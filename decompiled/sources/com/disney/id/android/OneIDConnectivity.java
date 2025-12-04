package com.disney.id.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.disney.id.android.Connectivity;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.logging.Logger;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 /2\u00020\u0001:\u0003/01B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001cH\u0016J\b\u0010*\u001a\u00020(H\u0002J\b\u0010+\u001a\u00020\u0018H\u0016J\b\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001cH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0012\u0010%\u001a\u00060&R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/disney/id/android/OneIDConnectivity;", "Lcom/disney/id/android/Connectivity;", "()V", "appContext", "Landroid/content/Context;", "getAppContext$OneID_release", "()Landroid/content/Context;", "setAppContext$OneID_release", "(Landroid/content/Context;)V", "availableNetworks", "Ljava/util/HashSet;", "Landroid/net/Network;", "Lkotlin/collections/HashSet;", "connectivityHandler", "Landroid/os/Handler;", "connectivityManager", "Landroid/net/ConnectivityManager;", "connectivityRunner", "Ljava/lang/Runnable;", "connectivityThread", "Landroid/os/HandlerThread;", "countNetworks", "", "lastBroadcastWasConnected", "", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/disney/id/android/Connectivity$Listener;", "getListeners$OneID_release", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "networkCallback", "Lcom/disney/id/android/OneIDConnectivity$OneIDNetworkCallback;", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "communicateConnectionState", "isConnected", "networkType", "", "removeListener", "Companion", "ConnectivityHandler", "OneIDNetworkCallback", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OneIDConnectivity implements Connectivity {
    private static final String TAG = OneIDConnectivity.class.getSimpleName();
    private static ConnectivityManager.NetworkCallback networkCallbackHolder;

    @Inject
    public Context appContext;
    private final HashSet availableNetworks;
    private final Handler connectivityHandler;
    private final ConnectivityManager connectivityManager;
    private final Runnable connectivityRunner;
    private final HandlerThread connectivityThread;
    private int countNetworks;
    private boolean lastBroadcastWasConnected;
    private final CopyOnWriteArrayList listeners;

    @Inject
    public Logger logger;
    private final OneIDNetworkCallback networkCallback;

    public OneIDConnectivity() {
        NetworkCapabilities networkCapabilities;
        OneIDNetworkCallback oneIDNetworkCallback = new OneIDNetworkCallback();
        this.networkCallback = oneIDNetworkCallback;
        this.availableNetworks = new HashSet();
        this.listeners = new CopyOnWriteArrayList();
        OneIDDagger.getComponent().inject(this);
        HandlerThread handlerThread = new HandlerThread("OneID Connectivity Monitor");
        this.connectivityThread = handlerThread;
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "getLooper(...)");
        this.connectivityHandler = new ConnectivityHandler(this, looper);
        this.connectivityRunner = new Runnable() { // from class: com.disney.id.android.OneIDConnectivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                OneIDConnectivity._init_$lambda$0(this.f$0);
            }
        };
        Object systemService = getAppContext$OneID_release().getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        this.connectivityManager = connectivityManager;
        NetworkRequest.Builder builderAddCapability = new NetworkRequest.Builder().addCapability(12).addCapability(13);
        builderAddCapability.addCapability(16);
        builderAddCapability.addCapability(19).addCapability(21);
        ConnectivityManager.NetworkCallback networkCallback = networkCallbackHolder;
        if (networkCallback != null) {
            connectivityManager.unregisterNetworkCallback(networkCallback);
        }
        connectivityManager.registerNetworkCallback(builderAddCapability.build(), oneIDNetworkCallback);
        networkCallbackHolder = oneIDNetworkCallback;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.lastBroadcastWasConnected = activeNetworkInfo.isConnected();
        }
        if (this.lastBroadcastWasConnected) {
            try {
                networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            } catch (Exception e) {
                Logger logger$OneID_release = getLogger$OneID_release();
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                logger$OneID_release.e(TAG2, "Unexpected exception attempting to retrieve network capabilities", e);
                networkCapabilities = null;
            }
            if (networkCapabilities != null) {
                boolean z = false;
                boolean z2 = networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(13) && networkCapabilities.hasCapability(16) && networkCapabilities.hasCapability(17);
                this.lastBroadcastWasConnected = z2;
                if (z2) {
                    if (networkCapabilities.hasCapability(19) && networkCapabilities.hasCapability(21)) {
                        z = true;
                    }
                    this.lastBroadcastWasConnected = z;
                }
            }
        }
    }

    @NotNull
    public final Context getAppContext$OneID_release() {
        Context context = this.appContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appContext");
        return null;
    }

    public final void setAppContext$OneID_release(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.appContext = context;
    }

    @NotNull
    public final Logger getLogger$OneID_release() {
        Logger logger = this.logger;
        if (logger != null) {
            return logger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    public final void setLogger$OneID_release(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "<set-?>");
        this.logger = logger;
    }

    @NotNull
    public final CopyOnWriteArrayList<WeakReference<Connectivity.Listener>> getListeners$OneID_release() {
        return this.listeners;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(OneIDConnectivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.communicateConnectionState();
    }

    @Override // com.disney.id.android.Connectivity
    public void addListener(@NotNull Connectivity.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(new WeakReference(listener));
    }

    @Override // com.disney.id.android.Connectivity
    public void removeListener(@NotNull Connectivity.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Iterator it = this.listeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (Intrinsics.areEqual(listener, (Connectivity.Listener) weakReference.get())) {
                this.listeners.remove(weakReference);
                return;
            }
        }
    }

    @Override // com.disney.id.android.Connectivity
    public boolean isConnected() {
        try {
            Iterator it = this.availableNetworks.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                NetworkCapabilities networkCapabilities = this.connectivityManager.getNetworkCapabilities((Network) next);
                if (networkCapabilities != null && !networkCapabilities.hasCapability(17)) {
                    return true;
                }
            }
            return !this.availableNetworks.isEmpty();
        } catch (Exception e) {
            String message = e.getMessage();
            Logger logger$OneID_release = this.getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            logger$OneID_release.e(TAG2, "Unexpected exception attempting to iterate availableNetworks // " + message, e);
            return this.countNetworks > 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    @Override // com.disney.id.android.Connectivity
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String networkType() {
        /*
            r4 = this;
            android.net.ConnectivityManager r0 = r4.connectivityManager
            android.net.Network r0 = r0.getActiveNetwork()
            java.lang.String r1 = "none"
            if (r0 == 0) goto L72
            android.net.ConnectivityManager r2 = r4.connectivityManager
            android.net.NetworkCapabilities r2 = r2.getNetworkCapabilities(r0)
            if (r2 == 0) goto L30
            r3 = 1
            boolean r3 = r2.hasTransport(r3)
            if (r3 == 0) goto L1c
            java.lang.String r2 = "wifi"
            goto L31
        L1c:
            r3 = 0
            boolean r3 = r2.hasTransport(r3)
            if (r3 == 0) goto L26
            java.lang.String r2 = "cellular"
            goto L31
        L26:
            r3 = 3
            boolean r2 = r2.hasTransport(r3)
            if (r2 == 0) goto L30
            java.lang.String r2 = "ethernet"
            goto L31
        L30:
            r2 = r1
        L31:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r1)
            if (r1 == 0) goto L5a
            android.net.ConnectivityManager r1 = r4.connectivityManager
            android.net.LinkProperties r0 = r1.getLinkProperties(r0)
            if (r0 == 0) goto L57
            java.lang.String r0 = r0.getInterfaceName()
            if (r0 == 0) goto L57
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r2 = "ROOT"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r0 = r0.toLowerCase(r1)
            java.lang.String r1 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
        L55:
            r1 = r0
            goto L5b
        L57:
            java.lang.String r0 = "unknown"
            goto L55
        L5a:
            r1 = r2
        L5b:
            boolean r4 = r4.isConnected()
            if (r4 != 0) goto L72
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r0 = " (disconnected)"
            r4.append(r0)
            java.lang.String r1 = r4.toString()
        L72:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disney.id.android.OneIDConnectivity.networkType():java.lang.String");
    }

    private final void communicateConnectionState() {
        boolean zIsConnected = isConnected();
        boolean z = zIsConnected && !this.lastBroadcastWasConnected;
        boolean z2 = !zIsConnected && this.lastBroadcastWasConnected;
        if (!z && !z2) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.d$default(logger$OneID_release, TAG2, "Not sending any state, returning", null, 4, null);
            return;
        }
        Iterator it = this.listeners.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            Connectivity.Listener listener = (Connectivity.Listener) weakReference.get();
            if (listener == null) {
                listener = null;
            } else if (z2) {
                Logger logger$OneID_release2 = getLogger$OneID_release();
                String TAG3 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                Logger.DefaultImpls.d$default(logger$OneID_release2, TAG3, "Sending disconnected to " + listener, null, 4, null);
                listener.onDisconnected();
                this.lastBroadcastWasConnected = false;
            } else if (z) {
                Logger logger$OneID_release3 = getLogger$OneID_release();
                String TAG4 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                Logger.DefaultImpls.d$default(logger$OneID_release3, TAG4, "Sending connected to " + listener, null, 4, null);
                listener.onConnected();
                this.lastBroadcastWasConnected = true;
            }
            if (listener == null) {
                Logger logger$OneID_release4 = getLogger$OneID_release();
                String TAG5 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                Logger.DefaultImpls.d$default(logger$OneID_release4, TAG5, "Removing listener // " + weakReference, null, 4, null);
                Intrinsics.checkNotNull(weakReference);
                arrayList.add(weakReference);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.listeners.removeAll(arrayList);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/disney/id/android/OneIDConnectivity$ConnectivityHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "(Lcom/disney/id/android/OneIDConnectivity;Landroid/os/Looper;)V", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ConnectivityHandler extends Handler {
        final /* synthetic */ OneIDConnectivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConnectivityHandler(@NotNull OneIDConnectivity oneIDConnectivity, Looper looper) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.this$0 = oneIDConnectivity;
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            int i = msg.what;
            if (i == 1) {
                HashSet hashSet = this.this$0.availableNetworks;
                Object obj = msg.obj;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.net.Network");
                hashSet.add((Network) obj);
                this.this$0.countNetworks++;
                Logger logger$OneID_release = this.this$0.getLogger$OneID_release();
                String str = OneIDConnectivity.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                Logger.DefaultImpls.d$default(logger$OneID_release, str, "Network added // " + msg.obj, null, 4, null);
            } else if (i == 2) {
                HashSet hashSet2 = this.this$0.availableNetworks;
                Object obj2 = msg.obj;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.net.Network");
                hashSet2.remove((Network) obj2);
                this.this$0.countNetworks--;
                Logger logger$OneID_release2 = this.this$0.getLogger$OneID_release();
                String str2 = OneIDConnectivity.TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                Logger.DefaultImpls.d$default(logger$OneID_release2, str2, "Network removed // " + msg.obj, null, 4, null);
            } else {
                super.handleMessage(msg);
                return;
            }
            removeCallbacks(this.this$0.connectivityRunner);
            postDelayed(this.this$0.connectivityRunner, 150L);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/disney/id/android/OneIDConnectivity$OneIDNetworkCallback;", "Landroid/net/ConnectivityManager$NetworkCallback;", "(Lcom/disney/id/android/OneIDConnectivity;)V", "onAvailable", "", TCEventPropertiesNames.TCN_NETWORK, "Landroid/net/Network;", "onLost", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class OneIDNetworkCallback extends ConnectivityManager.NetworkCallback {
        public OneIDNetworkCallback() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NotNull Network network) {
            Intrinsics.checkNotNullParameter(network, "network");
            Message.obtain(OneIDConnectivity.this.connectivityHandler, 2, network).sendToTarget();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NotNull Network network) {
            Intrinsics.checkNotNullParameter(network, "network");
            Message.obtain(OneIDConnectivity.this.connectivityHandler, 1, network).sendToTarget();
        }
    }
}
