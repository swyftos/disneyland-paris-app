package androidx.media3.session;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.media.session.MediaButtonReceiver$Api31$$ExternalSyntheticApiModelOutline1;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.session.DefaultMediaNotificationProvider;
import androidx.media3.session.IMediaSessionService;
import androidx.media3.session.MediaNotification;
import androidx.media3.session.MediaSession;
import androidx.media3.session.legacy.MediaSessionManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class MediaSessionService extends Service {
    public static final String SERVICE_INTERFACE = "androidx.media3.session.MediaSessionService";
    private DefaultActionFactory actionFactory;
    private Listener listener;
    private MediaNotificationManager mediaNotificationManager;
    private MediaNotification.Provider mediaNotificationProvider;
    private MediaSessionServiceStub stub;
    private final Object lock = new Object();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Map sessions = new ArrayMap();
    private boolean defaultMethodCalled = false;

    @UnstableApi
    public interface Listener {
        @RequiresApi(31)
        default void onForegroundServiceStartNotAllowedException() {
        }
    }

    @Nullable
    public abstract MediaSession onGetSession(MediaSession.ControllerInfo controllerInfo);

    @Override // android.app.Service
    @CallSuper
    public void onCreate() {
        super.onCreate();
        synchronized (this.lock) {
            this.stub = new MediaSessionServiceStub(this);
        }
    }

    public final void addSession(final MediaSession mediaSession) {
        MediaSession mediaSession2;
        Assertions.checkNotNull(mediaSession, "session must not be null");
        boolean z = true;
        Assertions.checkArgument(!mediaSession.isReleased(), "session is already released");
        synchronized (this.lock) {
            mediaSession2 = (MediaSession) this.sessions.get(mediaSession.getId());
            if (mediaSession2 != null && mediaSession2 != mediaSession) {
                z = false;
            }
            Assertions.checkArgument(z, "Session ID should be unique");
            this.sessions.put(mediaSession.getId(), mediaSession);
        }
        if (mediaSession2 == null) {
            final MediaNotificationManager mediaNotificationManager = getMediaNotificationManager();
            Util.postOrRun(this.mainHandler, new Runnable() { // from class: androidx.media3.session.MediaSessionService$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$addSession$0(mediaNotificationManager, mediaSession);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addSession$0(MediaNotificationManager mediaNotificationManager, MediaSession mediaSession) {
        mediaNotificationManager.addSession(mediaSession);
        mediaSession.setListener(new MediaSessionListener());
    }

    public final void removeSession(final MediaSession mediaSession) {
        Assertions.checkNotNull(mediaSession, "session must not be null");
        synchronized (this.lock) {
            Assertions.checkArgument(this.sessions.containsKey(mediaSession.getId()), "session not found");
            this.sessions.remove(mediaSession.getId());
        }
        final MediaNotificationManager mediaNotificationManager = getMediaNotificationManager();
        Util.postOrRun(this.mainHandler, new Runnable() { // from class: androidx.media3.session.MediaSessionService$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionService.lambda$removeSession$1(mediaNotificationManager, mediaSession);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$removeSession$1(MediaNotificationManager mediaNotificationManager, MediaSession mediaSession) {
        mediaNotificationManager.removeSession(mediaSession);
        mediaSession.clearListener();
    }

    public final List<MediaSession> getSessions() {
        ArrayList arrayList;
        synchronized (this.lock) {
            arrayList = new ArrayList(this.sessions.values());
        }
        return arrayList;
    }

    public final boolean isSessionAdded(MediaSession mediaSession) {
        boolean zContainsKey;
        synchronized (this.lock) {
            zContainsKey = this.sessions.containsKey(mediaSession.getId());
        }
        return zContainsKey;
    }

    @UnstableApi
    public final void setListener(Listener listener) {
        synchronized (this.lock) {
            this.listener = listener;
        }
    }

    @UnstableApi
    public final void clearListener() {
        synchronized (this.lock) {
            this.listener = null;
        }
    }

    @Override // android.app.Service
    @Nullable
    @CallSuper
    public IBinder onBind(@Nullable Intent intent) {
        String action;
        MediaSession mediaSessionOnGetSession;
        if (intent == null || (action = intent.getAction()) == null) {
            return null;
        }
        if (action.equals(SERVICE_INTERFACE)) {
            return getServiceBinder();
        }
        if (!action.equals("android.media.browse.MediaBrowserService") || (mediaSessionOnGetSession = onGetSession(MediaSession.ControllerInfo.createLegacyControllerInfo())) == null) {
            return null;
        }
        addSession(mediaSessionOnGetSession);
        return mediaSessionOnGetSession.getLegacyBrowserServiceBinder();
    }

    @Override // android.app.Service
    @CallSuper
    public int onStartCommand(@Nullable final Intent intent, int i, int i2) {
        String customAction;
        if (intent == null) {
            return 1;
        }
        DefaultActionFactory actionFactory = getActionFactory();
        Uri data = intent.getData();
        MediaSession session = data != null ? MediaSession.getSession(data) : null;
        if (actionFactory.isMediaAction(intent)) {
            if (session == null) {
                session = onGetSession(MediaSession.ControllerInfo.createLegacyControllerInfo());
                if (session == null) {
                    return 1;
                }
                addSession(session);
            }
            final MediaSessionImpl impl = session.getImpl();
            impl.getApplicationHandler().post(new Runnable() { // from class: androidx.media3.session.MediaSessionService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MediaSessionService.lambda$onStartCommand$2(impl, intent);
                }
            });
        } else {
            if (session == null || !actionFactory.isCustomAction(intent) || (customAction = actionFactory.getCustomAction(intent)) == null) {
                return 1;
            }
            getMediaNotificationManager().onCustomAction(session, customAction, actionFactory.getCustomActionExtras(intent));
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onStartCommand$2(MediaSessionImpl mediaSessionImpl, Intent intent) {
        MediaSession.ControllerInfo mediaNotificationControllerInfo = mediaSessionImpl.getMediaNotificationControllerInfo();
        if (mediaNotificationControllerInfo == null) {
            mediaNotificationControllerInfo = createFallbackMediaButtonCaller(intent);
        }
        if (mediaSessionImpl.onMediaButtonEvent(mediaNotificationControllerInfo, intent)) {
            return;
        }
        Log.d("MSessionService", "Ignored unrecognized media button intent.");
    }

    private static MediaSession.ControllerInfo createFallbackMediaButtonCaller(Intent intent) {
        String packageName;
        ComponentName component = intent.getComponent();
        if (component != null) {
            packageName = component.getPackageName();
        } else {
            packageName = SERVICE_INTERFACE;
        }
        return new MediaSession.ControllerInfo(new MediaSessionManager.RemoteUserInfo(packageName, -1, -1), MediaLibraryInfo.VERSION_INT, 6, false, null, Bundle.EMPTY);
    }

    @UnstableApi
    public boolean isPlaybackOngoing() {
        return getMediaNotificationManager().isStartedInForeground();
    }

    @UnstableApi
    public void pauseAllPlayersAndStopSelf() {
        List<MediaSession> sessions = getSessions();
        for (int i = 0; i < sessions.size(); i++) {
            sessions.get(i).getPlayer().setPlayWhenReady(false);
        }
        stopSelf();
    }

    @Override // android.app.Service
    public void onTaskRemoved(@Nullable Intent intent) {
        if (isPlaybackOngoing()) {
            return;
        }
        stopSelf();
    }

    @Override // android.app.Service
    @CallSuper
    public void onDestroy() {
        super.onDestroy();
        synchronized (this.lock) {
            try {
                MediaSessionServiceStub mediaSessionServiceStub = this.stub;
                if (mediaSessionServiceStub != null) {
                    mediaSessionServiceStub.release();
                    this.stub = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public void onUpdateNotification(MediaSession mediaSession) {
        this.defaultMethodCalled = true;
    }

    public void onUpdateNotification(MediaSession mediaSession, boolean z) {
        onUpdateNotification(mediaSession);
        if (this.defaultMethodCalled) {
            getMediaNotificationManager().updateNotification(mediaSession, z);
        }
    }

    @UnstableApi
    protected final void setMediaNotificationProvider(MediaNotification.Provider provider) {
        Assertions.checkNotNull(provider);
        synchronized (this.lock) {
            this.mediaNotificationProvider = provider;
        }
    }

    IBinder getServiceBinder() {
        IBinder iBinderAsBinder;
        synchronized (this.lock) {
            iBinderAsBinder = ((MediaSessionServiceStub) Assertions.checkStateNotNull(this.stub)).asBinder();
        }
        return iBinderAsBinder;
    }

    boolean onUpdateNotificationInternal(MediaSession mediaSession, boolean z) {
        try {
            onUpdateNotification(mediaSession, getMediaNotificationManager().shouldRunInForeground(mediaSession, z));
            return true;
        } catch (IllegalStateException e) {
            if (Util.SDK_INT >= 31 && Api31.instanceOfForegroundServiceStartNotAllowedException(e)) {
                Log.e("MSessionService", "Failed to start foreground", e);
                onForegroundServiceStartNotAllowedException();
                return false;
            }
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaNotificationManager getMediaNotificationManager() {
        MediaNotificationManager mediaNotificationManager;
        synchronized (this.lock) {
            try {
                if (this.mediaNotificationManager == null) {
                    if (this.mediaNotificationProvider == null) {
                        this.mediaNotificationProvider = new DefaultMediaNotificationProvider.Builder(getApplicationContext()).build();
                    }
                    this.mediaNotificationManager = new MediaNotificationManager(this, this.mediaNotificationProvider, getActionFactory());
                }
                mediaNotificationManager = this.mediaNotificationManager;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaNotificationManager;
    }

    private DefaultActionFactory getActionFactory() {
        DefaultActionFactory defaultActionFactory;
        synchronized (this.lock) {
            try {
                if (this.actionFactory == null) {
                    this.actionFactory = new DefaultActionFactory(this);
                }
                defaultActionFactory = this.actionFactory;
            } catch (Throwable th) {
                throw th;
            }
        }
        return defaultActionFactory;
    }

    private Listener getListener() {
        Listener listener;
        synchronized (this.lock) {
            listener = this.listener;
        }
        return listener;
    }

    private void onForegroundServiceStartNotAllowedException() {
        this.mainHandler.post(new Runnable() { // from class: androidx.media3.session.MediaSessionService$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onForegroundServiceStartNotAllowedException$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onForegroundServiceStartNotAllowedException$3() {
        Listener listener = getListener();
        if (listener != null) {
            listener.onForegroundServiceStartNotAllowedException();
        }
    }

    private final class MediaSessionListener implements MediaSession.Listener {
        private MediaSessionListener() {
        }

        @Override // androidx.media3.session.MediaSession.Listener
        public void onNotificationRefreshRequired(MediaSession mediaSession) {
            MediaSessionService.this.onUpdateNotificationInternal(mediaSession, false);
        }

        @Override // androidx.media3.session.MediaSession.Listener
        public boolean onPlayRequested(MediaSession mediaSession) {
            int i = Util.SDK_INT;
            if (i < 31 || i >= 33 || MediaSessionService.this.getMediaNotificationManager().isStartedInForeground()) {
                return true;
            }
            return MediaSessionService.this.onUpdateNotificationInternal(mediaSession, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class MediaSessionServiceStub extends IMediaSessionService.Stub {
        private final Handler handler;
        private final MediaSessionManager mediaSessionManager;
        private final Set pendingControllers;
        private final WeakReference serviceReference;

        public MediaSessionServiceStub(MediaSessionService mediaSessionService) {
            this.serviceReference = new WeakReference(mediaSessionService);
            Context applicationContext = mediaSessionService.getApplicationContext();
            this.handler = new Handler(applicationContext.getMainLooper());
            this.mediaSessionManager = MediaSessionManager.getSessionManager(applicationContext);
            this.pendingControllers = Collections.synchronizedSet(new HashSet());
        }

        @Override // androidx.media3.session.IMediaSessionService
        public void connect(final IMediaController iMediaController, Bundle bundle) {
            if (iMediaController == null || bundle == null) {
                return;
            }
            try {
                final ConnectionRequest connectionRequestFromBundle = ConnectionRequest.fromBundle(bundle);
                if (this.serviceReference.get() == null) {
                    try {
                        iMediaController.onDisconnected(0);
                        return;
                    } catch (RemoteException unused) {
                        return;
                    }
                }
                int callingPid = Binder.getCallingPid();
                int callingUid = Binder.getCallingUid();
                long jClearCallingIdentity = Binder.clearCallingIdentity();
                if (callingPid == 0) {
                    callingPid = connectionRequestFromBundle.pid;
                }
                final MediaSessionManager.RemoteUserInfo remoteUserInfo = new MediaSessionManager.RemoteUserInfo(connectionRequestFromBundle.packageName, callingPid, callingUid);
                final boolean zIsTrustedForMediaControl = this.mediaSessionManager.isTrustedForMediaControl(remoteUserInfo);
                this.pendingControllers.add(iMediaController);
                try {
                    this.handler.post(new Runnable() { // from class: androidx.media3.session.MediaSessionService$MediaSessionServiceStub$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() throws Throwable {
                            this.f$0.lambda$connect$0(iMediaController, remoteUserInfo, connectionRequestFromBundle, zIsTrustedForMediaControl);
                        }
                    });
                } finally {
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                }
            } catch (RuntimeException e) {
                Log.w("MSessionService", "Ignoring malformed Bundle for ConnectionRequest", e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:36:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public /* synthetic */ void lambda$connect$0(androidx.media3.session.IMediaController r11, androidx.media3.session.legacy.MediaSessionManager.RemoteUserInfo r12, androidx.media3.session.ConnectionRequest r13, boolean r14) throws java.lang.Throwable {
            /*
                r10 = this;
                java.util.Set r0 = r10.pendingControllers
                r0.remove(r11)
                r0 = 0
                r1 = 1
                java.lang.ref.WeakReference r10 = r10.serviceReference     // Catch: java.lang.Throwable -> L40
                java.lang.Object r10 = r10.get()     // Catch: java.lang.Throwable -> L40
                androidx.media3.session.MediaSessionService r10 = (androidx.media3.session.MediaSessionService) r10     // Catch: java.lang.Throwable -> L40
                if (r10 != 0) goto L15
                r11.onDisconnected(r0)     // Catch: android.os.RemoteException -> L14
            L14:
                return
            L15:
                androidx.media3.session.MediaSession$ControllerInfo r9 = new androidx.media3.session.MediaSession$ControllerInfo     // Catch: java.lang.Throwable -> L40
                int r4 = r13.libraryVersion     // Catch: java.lang.Throwable -> L40
                int r5 = r13.controllerInterfaceVersion     // Catch: java.lang.Throwable -> L40
                androidx.media3.session.MediaSessionStub$Controller2Cb r7 = new androidx.media3.session.MediaSessionStub$Controller2Cb     // Catch: java.lang.Throwable -> L40
                r7.<init>(r11)     // Catch: java.lang.Throwable -> L40
                android.os.Bundle r8 = r13.connectionHints     // Catch: java.lang.Throwable -> L40
                r2 = r9
                r3 = r12
                r6 = r14
                r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L40
                androidx.media3.session.MediaSession r12 = r10.onGetSession(r9)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                if (r12 != 0) goto L32
                r11.onDisconnected(r0)     // Catch: android.os.RemoteException -> L31
            L31:
                return
            L32:
                r10.addSession(r12)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
                r12.handleControllerConnectionFromService(r11, r9)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
                r1 = r0
                goto L4a
            L3a:
                r10 = move-exception
                r1 = r0
                goto L50
            L3d:
                r10 = move-exception
                r1 = r0
                goto L43
            L40:
                r10 = move-exception
                goto L50
            L42:
                r10 = move-exception
            L43:
                java.lang.String r12 = "MSessionService"
                java.lang.String r13 = "Failed to add a session to session service"
                androidx.media3.common.util.Log.w(r12, r13, r10)     // Catch: java.lang.Throwable -> L40
            L4a:
                if (r1 == 0) goto L4f
                r11.onDisconnected(r0)     // Catch: android.os.RemoteException -> L4f
            L4f:
                return
            L50:
                if (r1 == 0) goto L55
                r11.onDisconnected(r0)     // Catch: android.os.RemoteException -> L55
            L55:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaSessionService.MediaSessionServiceStub.lambda$connect$0(androidx.media3.session.IMediaController, androidx.media3.session.legacy.MediaSessionManager$RemoteUserInfo, androidx.media3.session.ConnectionRequest, boolean):void");
        }

        public void release() {
            this.serviceReference.clear();
            this.handler.removeCallbacksAndMessages(null);
            Iterator it = this.pendingControllers.iterator();
            while (it.hasNext()) {
                try {
                    ((IMediaController) it.next()).onDisconnected(0);
                } catch (RemoteException unused) {
                }
            }
        }
    }

    private static final class Api31 {
        @DoNotInline
        public static boolean instanceOfForegroundServiceStartNotAllowedException(IllegalStateException illegalStateException) {
            return MediaButtonReceiver$Api31$$ExternalSyntheticApiModelOutline1.m(illegalStateException);
        }
    }
}
