package com.brentvatne.exoplayer;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.session.CommandButton;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionService;
import androidx.media3.session.MediaStyleNotificationHelper;
import androidx.media3.session.SessionCommand;
import androidx.media3.ui.R;
import com.allegion.accesssdk.BuildConfig;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.brentvatne.common.toolbox.DebugLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010%\u001a\u00020\u0014H\u0016J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0007H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010 \u001a\u00020\u0007H\u0002J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010*\u001a\u00020\u0014H\u0002J\b\u0010+\u001a\u00020\u0014H\u0002J\b\u0010,\u001a\u00020(H\u0002J\"\u0010-\u001a\u00020.2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/brentvatne/exoplayer/VideoPlaybackService;", "Landroidx/media3/session/MediaSessionService;", "<init>", "()V", "mediaSessionsList", "", "Landroidx/media3/exoplayer/ExoPlayer;", "Landroidx/media3/session/MediaSession;", "binder", "Lcom/brentvatne/exoplayer/PlaybackServiceBinder;", "sourceActivity", "Ljava/lang/Class;", "Landroid/app/Activity;", "commandSeekForward", "Landroidx/media3/session/SessionCommand;", "commandSeekBackward", "seekForwardBtn", "Landroidx/media3/session/CommandButton;", "seekBackwardBtn", "registerPlayer", "", "player", "from", "unregisterPlayer", "onGetSession", "controllerInfo", "Landroidx/media3/session/MediaSession$ControllerInfo;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onUpdateNotification", BuildConfig.SESSION_KEY_REFERENCE, "startInForegroundRequired", "", "onTaskRemoved", "rootIntent", "onDestroy", "createSessionNotification", "buildNotification", "Landroid/app/Notification;", "hidePlayerNotification", "hideAllNotifications", "cleanup", "createPlaceholderNotification", "onStartCommand", "", "flags", "startId", "Companion", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVideoPlaybackService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VideoPlaybackService.kt\ncom/brentvatne/exoplayer/VideoPlaybackService\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,314:1\n1#2:315\n216#3,2:316\n*S KotlinDebug\n*F\n+ 1 VideoPlaybackService.kt\ncom/brentvatne/exoplayer/VideoPlaybackService\n*L\n224#1:316,2\n*E\n"})
/* loaded from: classes2.dex */
public final class VideoPlaybackService extends MediaSessionService {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String NOTIFICATION_CHANEL_ID = "RNVIDEO_SESSION_NOTIFICATION";
    private final SessionCommand commandSeekBackward;
    private final SessionCommand commandSeekForward;
    private final CommandButton seekBackwardBtn;
    private final CommandButton seekForwardBtn;
    private Class sourceActivity;
    private Map mediaSessionsList = new LinkedHashMap();
    private PlaybackServiceBinder binder = new PlaybackServiceBinder(this);

    @Override // androidx.media3.session.MediaSessionService
    @Nullable
    public MediaSession onGetSession(@NotNull MediaSession.ControllerInfo controllerInfo) {
        Intrinsics.checkNotNullParameter(controllerInfo, "controllerInfo");
        return null;
    }

    public VideoPlaybackService() {
        String stringValue = Companion.COMMAND.SEEK_FORWARD.getStringValue();
        Bundle bundle = Bundle.EMPTY;
        SessionCommand sessionCommand = new SessionCommand(stringValue, bundle);
        this.commandSeekForward = sessionCommand;
        SessionCommand sessionCommand2 = new SessionCommand(Companion.COMMAND.SEEK_BACKWARD.getStringValue(), bundle);
        this.commandSeekBackward = sessionCommand2;
        CommandButton commandButtonBuild = new CommandButton.Builder().setDisplayName("forward").setSessionCommand(sessionCommand).setIconResId(R.drawable.exo_notification_fastforward).build();
        Intrinsics.checkNotNullExpressionValue(commandButtonBuild, "build(...)");
        this.seekForwardBtn = commandButtonBuild;
        CommandButton commandButtonBuild2 = new CommandButton.Builder().setDisplayName("backward").setSessionCommand(sessionCommand2).setIconResId(R.drawable.exo_notification_rewind).build();
        Intrinsics.checkNotNullExpressionValue(commandButtonBuild2, "build(...)");
        this.seekBackwardBtn = commandButtonBuild2;
    }

    public final void registerPlayer(@NotNull ExoPlayer player, @NotNull Class<Activity> from) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(from, "from");
        if (this.mediaSessionsList.containsKey(player)) {
            return;
        }
        this.sourceActivity = from;
        MediaSession mediaSessionBuild = new MediaSession.Builder(this, player).setId("RNVideoPlaybackService_" + player.hashCode()).setCallback((MediaSession.Callback) new VideoPlaybackCallback()).setCustomLayout(Util.immutableListOf(this.seekForwardBtn, this.seekBackwardBtn)).build();
        Intrinsics.checkNotNullExpressionValue(mediaSessionBuild, "build(...)");
        this.mediaSessionsList.put(player, mediaSessionBuild);
        addSession(mediaSessionBuild);
        startForeground(player.hashCode(), buildNotification(mediaSessionBuild));
    }

    public final void unregisterPlayer(@NotNull ExoPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        hidePlayerNotification(player);
        MediaSession mediaSession = (MediaSession) this.mediaSessionsList.remove(player);
        if (mediaSession != null) {
            mediaSession.release();
        }
        if (this.mediaSessionsList.isEmpty()) {
            cleanup();
            stopSelf();
        }
    }

    @Override // androidx.media3.session.MediaSessionService, android.app.Service
    @NotNull
    public IBinder onBind(@Nullable Intent intent) {
        super.onBind(intent);
        return this.binder;
    }

    @Override // androidx.media3.session.MediaSessionService
    public void onUpdateNotification(@NotNull MediaSession session, boolean startInForegroundRequired) {
        Intrinsics.checkNotNullParameter(session, "session");
        createSessionNotification(session);
    }

    @Override // androidx.media3.session.MediaSessionService, android.app.Service
    public void onTaskRemoved(@Nullable Intent rootIntent) {
        cleanup();
        stopSelf();
    }

    @Override // androidx.media3.session.MediaSessionService, android.app.Service
    public void onDestroy() {
        cleanup();
        Object systemService = getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).deleteNotificationChannel(NOTIFICATION_CHANEL_ID);
        super.onDestroy();
    }

    private final void createSessionNotification(MediaSession session) {
        Object systemService = getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        notificationManager.createNotificationChannel(new NotificationChannel(NOTIFICATION_CHANEL_ID, NOTIFICATION_CHANEL_ID, 2));
        if (session.getPlayer().getCurrentMediaItem() == null) {
            notificationManager.cancel(session.getPlayer().hashCode());
        } else {
            notificationManager.notify(session.getPlayer().hashCode(), buildNotification(session));
        }
    }

    private final Notification buildNotification(MediaSession session) {
        int i;
        Class cls = this.sourceActivity;
        if (cls == null) {
            cls = VideoPlaybackService.class;
        }
        Intent intent = new Intent(this, (Class<?>) cls);
        intent.setFlags(603979776);
        if (Build.VERSION.SDK_INT >= 33) {
            Notification notificationBuild = new NotificationCompat.Builder(this, NOTIFICATION_CHANEL_ID).setSmallIcon(androidx.media3.session.R.drawable.media3_icon_circular_play).setStyle(new MediaStyleNotificationHelper.MediaStyle(session)).setContentIntent(PendingIntent.getActivity(this, 0, intent, 201326592)).build();
            Intrinsics.checkNotNull(notificationBuild);
            return notificationBuild;
        }
        int iHashCode = session.getPlayer().hashCode();
        Intent intent2 = new Intent(this, (Class<?>) VideoPlaybackService.class);
        intent2.putExtra("PLAYER_ID", iHashCode);
        intent2.putExtra("ACTION", Companion.COMMAND.SEEK_BACKWARD.getStringValue());
        int i2 = iHashCode * 10;
        PendingIntent service = PendingIntent.getService(this, i2, intent2, 167772160);
        Intent intent3 = new Intent(this, (Class<?>) VideoPlaybackService.class);
        intent3.putExtra("PLAYER_ID", iHashCode);
        intent3.putExtra("ACTION", Companion.COMMAND.TOGGLE_PLAY.getStringValue());
        PendingIntent service2 = PendingIntent.getService(this, i2 + 1, intent3, 167772160);
        Intent intent4 = new Intent(this, (Class<?>) VideoPlaybackService.class);
        intent4.putExtra("PLAYER_ID", iHashCode);
        intent4.putExtra("ACTION", Companion.COMMAND.SEEK_FORWARD.getStringValue());
        PendingIntent service3 = PendingIntent.getService(this, i2 + 2, intent4, 167772160);
        NotificationCompat.Builder builderAddAction = new NotificationCompat.Builder(this, NOTIFICATION_CHANEL_ID).setVisibility(1).setSmallIcon(androidx.media3.session.R.drawable.media3_icon_circular_play).addAction(androidx.media3.session.R.drawable.media3_icon_rewind, "Seek Backward", service);
        if (session.getPlayer().isPlaying()) {
            i = androidx.media3.session.R.drawable.media3_icon_pause;
        } else {
            i = androidx.media3.session.R.drawable.media3_icon_play;
        }
        NotificationCompat.Builder contentIntent = builderAddAction.addAction(i, "Toggle Play", service2).addAction(androidx.media3.session.R.drawable.media3_icon_fast_forward, "Seek Forward", service3).setStyle(new MediaStyleNotificationHelper.MediaStyle(session).setShowActionsInCompactView(0, 1, 2)).setContentTitle(session.getPlayer().getMediaMetadata().title).setContentText(session.getPlayer().getMediaMetadata().description).setContentIntent(PendingIntent.getActivity(this, 0, intent, 201326592));
        Uri uri = session.getPlayer().getMediaMetadata().artworkUri;
        Notification notificationBuild2 = contentIntent.setLargeIcon(uri != null ? session.getBitmapLoader().loadBitmap(uri).get() : null).setOngoing(true).build();
        Intrinsics.checkNotNull(notificationBuild2);
        return notificationBuild2;
    }

    private final void hidePlayerNotification(ExoPlayer player) {
        Object systemService = getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancel(player.hashCode());
    }

    private final void hideAllNotifications() {
        Object systemService = getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancelAll();
    }

    private final void cleanup() {
        hideAllNotifications();
        Iterator it = this.mediaSessionsList.entrySet().iterator();
        while (it.hasNext()) {
            ((MediaSession) ((Map.Entry) it.next()).getValue()).release();
        }
        this.mediaSessionsList.clear();
    }

    private final Notification createPlaceholderNotification() {
        Object systemService = getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).createNotificationChannel(new NotificationChannel(NOTIFICATION_CHANEL_ID, NOTIFICATION_CHANEL_ID, 2));
        Notification notificationBuild = new NotificationCompat.Builder(this, NOTIFICATION_CHANEL_ID).setSmallIcon(androidx.media3.session.R.drawable.media3_icon_circular_play).setContentTitle(getString(com.brentvatne.react.R.string.media_playback_notification_title)).setContentText(getString(com.brentvatne.react.R.string.media_playback_notification_text)).build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        return notificationBuild;
    }

    @Override // androidx.media3.session.MediaSessionService, android.app.Service
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Object next;
        startForeground(9999, createPlaceholderNotification());
        if (intent != null) {
            int intExtra = intent.getIntExtra("PLAYER_ID", -1);
            String stringExtra = intent.getStringExtra("ACTION");
            if (intExtra < 0) {
                DebugLog.w("VideoPlaybackService", "Received Command without playerId");
                return super.onStartCommand(intent, flags, startId);
            }
            if (stringExtra == null) {
                DebugLog.w("VideoPlaybackService", "Received Command without action command");
                return super.onStartCommand(intent, flags, startId);
            }
            Iterator it = this.mediaSessionsList.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((MediaSession) next).getPlayer().hashCode() == intExtra) {
                    break;
                }
            }
            MediaSession mediaSession = (MediaSession) next;
            if (mediaSession == null) {
                return super.onStartCommand(intent, flags, startId);
            }
            Companion companion = INSTANCE;
            companion.handleCommand(companion.commandFromString(stringExtra), mediaSession);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/brentvatne/exoplayer/VideoPlaybackService$Companion;", "", "<init>", "()V", "SEEK_INTERVAL_MS", "", "TAG", "", "PLACEHOLDER_NOTIFICATION_ID", "", "NOTIFICATION_CHANEL_ID", "commandFromString", "Lcom/brentvatne/exoplayer/VideoPlaybackService$Companion$COMMAND;", "value", "handleCommand", "", "command", BuildConfig.SESSION_KEY_REFERENCE, "Landroidx/media3/session/MediaSession;", "COMMAND", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[COMMAND.values().length];
                try {
                    iArr[COMMAND.SEEK_BACKWARD.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[COMMAND.SEEK_FORWARD.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[COMMAND.TOGGLE_PLAY.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[COMMAND.PLAY.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[COMMAND.PAUSE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/brentvatne/exoplayer/VideoPlaybackService$Companion$COMMAND;", "", "stringValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStringValue", "()Ljava/lang/String;", "NONE", "SEEK_FORWARD", "SEEK_BACKWARD", "TOGGLE_PLAY", "PLAY", "PAUSE", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class COMMAND {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ COMMAND[] $VALUES;
            private final String stringValue;
            public static final COMMAND NONE = new COMMAND("NONE", 0, "NONE");
            public static final COMMAND SEEK_FORWARD = new COMMAND("SEEK_FORWARD", 1, "COMMAND_SEEK_FORWARD");
            public static final COMMAND SEEK_BACKWARD = new COMMAND("SEEK_BACKWARD", 2, "COMMAND_SEEK_BACKWARD");
            public static final COMMAND TOGGLE_PLAY = new COMMAND("TOGGLE_PLAY", 3, "COMMAND_TOGGLE_PLAY");
            public static final COMMAND PLAY = new COMMAND("PLAY", 4, "COMMAND_PLAY");
            public static final COMMAND PAUSE = new COMMAND("PAUSE", 5, "COMMAND_PAUSE");

            private static final /* synthetic */ COMMAND[] $values() {
                return new COMMAND[]{NONE, SEEK_FORWARD, SEEK_BACKWARD, TOGGLE_PLAY, PLAY, PAUSE};
            }

            @NotNull
            public static EnumEntries<COMMAND> getEntries() {
                return $ENTRIES;
            }

            private COMMAND(String str, int i, String str2) {
                this.stringValue = str2;
            }

            @NotNull
            public final String getStringValue() {
                return this.stringValue;
            }

            static {
                COMMAND[] commandArr$values = $values();
                $VALUES = commandArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(commandArr$values);
            }

            public static COMMAND valueOf(String str) {
                return (COMMAND) Enum.valueOf(COMMAND.class, str);
            }

            public static COMMAND[] values() {
                return (COMMAND[]) $VALUES.clone();
            }
        }

        @NotNull
        public final COMMAND commandFromString(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            COMMAND command = COMMAND.SEEK_FORWARD;
            if (Intrinsics.areEqual(value, command.getStringValue())) {
                return command;
            }
            COMMAND command2 = COMMAND.SEEK_BACKWARD;
            if (Intrinsics.areEqual(value, command2.getStringValue())) {
                return command2;
            }
            COMMAND command3 = COMMAND.TOGGLE_PLAY;
            if (Intrinsics.areEqual(value, command3.getStringValue())) {
                return command3;
            }
            COMMAND command4 = COMMAND.PLAY;
            if (Intrinsics.areEqual(value, command4.getStringValue())) {
                return command4;
            }
            COMMAND command5 = COMMAND.PAUSE;
            return Intrinsics.areEqual(value, command5.getStringValue()) ? command5 : COMMAND.NONE;
        }

        public final void handleCommand(@NotNull COMMAND command, @NotNull MediaSession session) {
            Intrinsics.checkNotNullParameter(command, "command");
            Intrinsics.checkNotNullParameter(session, "session");
            int i = WhenMappings.$EnumSwitchMapping$0[command.ordinal()];
            if (i == 1) {
                session.getPlayer().seekTo(session.getPlayer().getContentPosition() - 10000);
                return;
            }
            if (i == 2) {
                session.getPlayer().seekTo(session.getPlayer().getContentPosition() + 10000);
                return;
            }
            if (i == 3) {
                handleCommand(session.getPlayer().isPlaying() ? COMMAND.PAUSE : COMMAND.PLAY, session);
                return;
            }
            if (i == 4) {
                session.getPlayer().play();
            } else if (i == 5) {
                session.getPlayer().pause();
            } else {
                DebugLog.w("VideoPlaybackService", "Received COMMAND.NONE - was there an error?");
            }
        }
    }
}
