package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.media.MediaSessionManager;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSourceBitmapLoader;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import androidx.media3.session.SessionCommands;
import androidx.media3.session.legacy.LegacyParcelableUtil;
import androidx.media3.session.legacy.MediaSessionCompat;
import androidx.media3.session.legacy.MediaSessionManager;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Longs;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@DoNotMock
/* loaded from: classes.dex */
public class MediaSession {
    private final MediaSessionImpl impl;
    private static final Object STATIC_LOCK = new Object();
    private static final HashMap SESSION_ID_TO_SESSION_MAP = new HashMap();

    interface ControllerCb {
        default void onAudioAttributesChanged(int i, AudioAttributes audioAttributes) {
        }

        default void onAvailableCommandsChangedFromPlayer(int i, Player.Commands commands) {
        }

        default void onAvailableCommandsChangedFromSession(int i, SessionCommands sessionCommands, Player.Commands commands) {
        }

        default void onChildrenChanged(int i, String str, int i2, MediaLibraryService.LibraryParams libraryParams) {
        }

        default void onDeviceInfoChanged(int i, DeviceInfo deviceInfo) {
        }

        default void onDeviceVolumeChanged(int i, int i2, boolean z) {
        }

        default void onDisconnected(int i) {
        }

        default void onError(int i, SessionError sessionError) {
        }

        default void onIsLoadingChanged(int i, boolean z) {
        }

        default void onIsPlayingChanged(int i, boolean z) {
        }

        default void onLibraryResult(int i, LibraryResult libraryResult) {
        }

        default void onMediaItemTransition(int i, MediaItem mediaItem, int i2) {
        }

        default void onMediaMetadataChanged(int i, MediaMetadata mediaMetadata) {
        }

        default void onPeriodicSessionPositionInfoChanged(int i, SessionPositionInfo sessionPositionInfo, boolean z, boolean z2, int i2) {
        }

        default void onPlayWhenReadyChanged(int i, boolean z, int i2) {
        }

        default void onPlaybackParametersChanged(int i, PlaybackParameters playbackParameters) {
        }

        default void onPlaybackStateChanged(int i, int i2, PlaybackException playbackException) {
        }

        default void onPlaybackSuppressionReasonChanged(int i, int i2) {
        }

        default void onPlayerChanged(int i, PlayerWrapper playerWrapper, PlayerWrapper playerWrapper2) {
        }

        default void onPlayerError(int i, PlaybackException playbackException) {
        }

        default void onPlayerInfoChanged(int i, PlayerInfo playerInfo, Player.Commands commands, boolean z, boolean z2, int i2) {
        }

        default void onPlaylistMetadataChanged(int i, MediaMetadata mediaMetadata) {
        }

        default void onPositionDiscontinuity(int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
        }

        default void onRenderedFirstFrame(int i) {
        }

        default void onRepeatModeChanged(int i, int i2) {
        }

        default void onSearchResultChanged(int i, String str, int i2, MediaLibraryService.LibraryParams libraryParams) {
        }

        default void onSeekBackIncrementChanged(int i, long j) {
        }

        default void onSeekForwardIncrementChanged(int i, long j) {
        }

        default void onSessionActivityChanged(int i, PendingIntent pendingIntent) {
        }

        default void onSessionExtrasChanged(int i, Bundle bundle) {
        }

        default void onSessionResult(int i, SessionResult sessionResult) {
        }

        default void onShuffleModeEnabledChanged(int i, boolean z) {
        }

        default void onTimelineChanged(int i, Timeline timeline, int i2) {
        }

        default void onTrackSelectionParametersChanged(int i, TrackSelectionParameters trackSelectionParameters) {
        }

        default void onTracksChanged(int i, Tracks tracks) {
        }

        default void onVideoSizeChanged(int i, VideoSize videoSize) {
        }

        default void onVolumeChanged(int i, float f) {
        }

        default void sendCustomCommand(int i, SessionCommand sessionCommand, Bundle bundle) {
        }

        default void setCustomLayout(int i, List list) {
        }
    }

    interface Listener {
        void onNotificationRefreshRequired(MediaSession mediaSession);

        boolean onPlayRequested(MediaSession mediaSession);
    }

    public static final class Builder extends BuilderBase {
        @Override // androidx.media3.session.MediaSession.BuilderBase
        @UnstableApi
        public /* bridge */ /* synthetic */ BuilderBase setCustomLayout(List list) {
            return setCustomLayout((List<CommandButton>) list);
        }

        public Builder(Context context, Player player) {
            super(context, player, new Callback() { // from class: androidx.media3.session.MediaSession.Builder.1
            });
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        public Builder setSessionActivity(PendingIntent pendingIntent) {
            return (Builder) super.setSessionActivity(pendingIntent);
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        public Builder setId(String str) {
            return (Builder) super.setId(str);
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        public Builder setCallback(Callback callback) {
            return (Builder) super.setCallback(callback);
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        public Builder setExtras(Bundle bundle) {
            return (Builder) super.setExtras(bundle);
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        @UnstableApi
        public Builder setSessionExtras(Bundle bundle) {
            return (Builder) super.setSessionExtras(bundle);
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        @UnstableApi
        public Builder setBitmapLoader(androidx.media3.common.util.BitmapLoader bitmapLoader) {
            return (Builder) super.setBitmapLoader(bitmapLoader);
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        @UnstableApi
        public Builder setCustomLayout(List<CommandButton> list) {
            return (Builder) super.setCustomLayout((List) list);
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        @UnstableApi
        public Builder setPeriodicPositionUpdateEnabled(boolean z) {
            return (Builder) super.setPeriodicPositionUpdateEnabled(z);
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        @UnstableApi
        public Builder setShowPlayButtonIfPlaybackIsSuppressed(boolean z) {
            return (Builder) super.setShowPlayButtonIfPlaybackIsSuppressed(z);
        }

        public MediaSession build() {
            if (this.bitmapLoader == null) {
                this.bitmapLoader = new CacheBitmapLoader(new DataSourceBitmapLoader(this.context));
            }
            return new MediaSession(this.context, this.id, this.player, this.sessionActivity, this.customLayout, this.callback, this.tokenExtras, this.sessionExtras, (androidx.media3.common.util.BitmapLoader) Assertions.checkNotNull(this.bitmapLoader), this.playIfSuppressed, this.isPeriodicPositionUpdateEnabled, 0);
        }
    }

    public static final class ControllerInfo {

        @UnstableApi
        public static final int LEGACY_CONTROLLER_INTERFACE_VERSION = 0;
        public static final String LEGACY_CONTROLLER_PACKAGE_NAME = "android.media.session.MediaController";
        public static final int LEGACY_CONTROLLER_VERSION = 0;
        private final Bundle connectionHints;
        private final ControllerCb controllerCb;
        private final int interfaceVersion;
        private final boolean isTrusted;
        private final int libraryVersion;
        private final MediaSessionManager.RemoteUserInfo remoteUserInfo;

        ControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo, int i, int i2, boolean z, ControllerCb controllerCb, Bundle bundle) {
            this.remoteUserInfo = remoteUserInfo;
            this.libraryVersion = i;
            this.interfaceVersion = i2;
            this.isTrusted = z;
            this.controllerCb = controllerCb;
            this.connectionHints = bundle;
        }

        MediaSessionManager.RemoteUserInfo getRemoteUserInfo() {
            return this.remoteUserInfo;
        }

        public int getControllerVersion() {
            return this.libraryVersion;
        }

        @UnstableApi
        public int getInterfaceVersion() {
            return this.interfaceVersion;
        }

        public String getPackageName() {
            return this.remoteUserInfo.getPackageName();
        }

        public int getUid() {
            return this.remoteUserInfo.getUid();
        }

        public Bundle getConnectionHints() {
            return new Bundle(this.connectionHints);
        }

        @UnstableApi
        public boolean isTrusted() {
            return this.isTrusted;
        }

        public int hashCode() {
            return Objects.hashCode(this.controllerCb, this.remoteUserInfo);
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof ControllerInfo)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ControllerInfo controllerInfo = (ControllerInfo) obj;
            ControllerCb controllerCb = this.controllerCb;
            if (controllerCb != null || controllerInfo.controllerCb != null) {
                return Util.areEqual(controllerCb, controllerInfo.controllerCb);
            }
            return this.remoteUserInfo.equals(controllerInfo.remoteUserInfo);
        }

        public String toString() {
            return "ControllerInfo {pkg=" + this.remoteUserInfo.getPackageName() + ", uid=" + this.remoteUserInfo.getUid() + "}";
        }

        ControllerCb getControllerCb() {
            return this.controllerCb;
        }

        static ControllerInfo createLegacyControllerInfo() {
            return new ControllerInfo(new MediaSessionManager.RemoteUserInfo("android.media.session.MediaController", -1, -1), 0, 0, false, null, Bundle.EMPTY);
        }

        @VisibleForTesting(otherwise = 2)
        @Deprecated
        public static ControllerInfo createTestOnlyControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo, int i, int i2, boolean z, Bundle bundle) {
            return createTestOnlyControllerInfo(remoteUserInfo.getPackageName(), remoteUserInfo.getPid(), remoteUserInfo.getUid(), i, i2, z, bundle);
        }

        @VisibleForTesting(otherwise = 2)
        public static ControllerInfo createTestOnlyControllerInfo(String str, int i, int i2, int i3, int i4, boolean z, Bundle bundle) {
            return new ControllerInfo(new MediaSessionManager.RemoteUserInfo(str, i, i2), i3, i4, z, null, bundle);
        }
    }

    MediaSession(Context context, String str, Player player, PendingIntent pendingIntent, ImmutableList immutableList, Callback callback, Bundle bundle, Bundle bundle2, androidx.media3.common.util.BitmapLoader bitmapLoader, boolean z, boolean z2, int i) {
        synchronized (STATIC_LOCK) {
            HashMap map = SESSION_ID_TO_SESSION_MAP;
            if (map.containsKey(str)) {
                throw new IllegalStateException("Session ID must be unique. ID=" + str);
            }
            map.put(str, this);
        }
        this.impl = createImpl(context, str, player, pendingIntent, immutableList, callback, bundle, bundle2, bitmapLoader, z, z2, i);
    }

    MediaSessionImpl createImpl(Context context, String str, Player player, PendingIntent pendingIntent, ImmutableList immutableList, Callback callback, Bundle bundle, Bundle bundle2, androidx.media3.common.util.BitmapLoader bitmapLoader, boolean z, boolean z2, int i) {
        return new MediaSessionImpl(this, context, str, player, pendingIntent, immutableList, callback, bundle, bundle2, bitmapLoader, z, z2);
    }

    MediaSessionImpl getImpl() {
        return this.impl;
    }

    static MediaSession getSession(Uri uri) {
        synchronized (STATIC_LOCK) {
            try {
                for (MediaSession mediaSession : SESSION_ID_TO_SESSION_MAP.values()) {
                    if (Util.areEqual(mediaSession.getUri(), uri)) {
                        return mediaSession;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public final PendingIntent getSessionActivity() {
        return this.impl.getSessionActivity();
    }

    @UnstableApi
    public final void setSessionActivity(PendingIntent pendingIntent) {
        if (Util.SDK_INT >= 31) {
            Assertions.checkArgument(Api31.isActivity(pendingIntent));
        }
        this.impl.setSessionActivity(pendingIntent);
    }

    @UnstableApi
    public final void setSessionActivity(ControllerInfo controllerInfo, PendingIntent pendingIntent) {
        if (Util.SDK_INT >= 31) {
            Assertions.checkArgument(Api31.isActivity(pendingIntent));
        }
        this.impl.setSessionActivity(controllerInfo, pendingIntent);
    }

    public final void setPlayer(Player player) {
        Assertions.checkNotNull(player);
        Assertions.checkArgument(player.canAdvertiseSession());
        Assertions.checkArgument(player.getApplicationLooper() == getPlayer().getApplicationLooper());
        Assertions.checkState(player.getApplicationLooper() == Looper.myLooper());
        this.impl.setPlayer(player);
    }

    public final void release() {
        try {
            synchronized (STATIC_LOCK) {
                SESSION_ID_TO_SESSION_MAP.remove(this.impl.getId());
            }
            this.impl.release();
        } catch (Exception unused) {
        }
    }

    final boolean isReleased() {
        return this.impl.isReleased();
    }

    public final Player getPlayer() {
        return this.impl.getPlayerWrapper().getWrappedPlayer();
    }

    public final String getId() {
        return this.impl.getId();
    }

    public final SessionToken getToken() {
        return this.impl.getToken();
    }

    public final List<ControllerInfo> getConnectedControllers() {
        return this.impl.getConnectedControllers();
    }

    @Nullable
    public final ControllerInfo getControllerForCurrentRequest() {
        return this.impl.getControllerForCurrentRequest();
    }

    @UnstableApi
    public boolean isMediaNotificationController(ControllerInfo controllerInfo) {
        return this.impl.isMediaNotificationController(controllerInfo);
    }

    @Nullable
    @UnstableApi
    public ControllerInfo getMediaNotificationControllerInfo() {
        return this.impl.getMediaNotificationControllerInfo();
    }

    @UnstableApi
    public final boolean isAutomotiveController(ControllerInfo controllerInfo) {
        return this.impl.isAutomotiveController(controllerInfo);
    }

    @UnstableApi
    public final boolean isAutoCompanionController(ControllerInfo controllerInfo) {
        return this.impl.isAutoCompanionController(controllerInfo);
    }

    @CanIgnoreReturnValue
    public final ListenableFuture<SessionResult> setCustomLayout(ControllerInfo controllerInfo, List<CommandButton> list) {
        Assertions.checkNotNull(controllerInfo, "controller must not be null");
        Assertions.checkNotNull(list, "layout must not be null");
        return this.impl.setCustomLayout(controllerInfo, ImmutableList.copyOf((Collection) list));
    }

    public final void setCustomLayout(List<CommandButton> list) {
        Assertions.checkNotNull(list, "layout must not be null");
        this.impl.setCustomLayout(ImmutableList.copyOf((Collection) list));
    }

    public final void setAvailableCommands(ControllerInfo controllerInfo, SessionCommands sessionCommands, Player.Commands commands) {
        Assertions.checkNotNull(controllerInfo, "controller must not be null");
        Assertions.checkNotNull(sessionCommands, "sessionCommands must not be null");
        Assertions.checkNotNull(commands, "playerCommands must not be null");
        this.impl.setAvailableCommands(controllerInfo, sessionCommands, commands);
    }

    @UnstableApi
    public ImmutableList<CommandButton> getCustomLayout() {
        return this.impl.getCustomLayout();
    }

    public final void broadcastCustomCommand(SessionCommand sessionCommand, Bundle bundle) {
        Assertions.checkNotNull(sessionCommand);
        Assertions.checkNotNull(bundle);
        Assertions.checkArgument(sessionCommand.commandCode == 0, "command must be a custom command");
        this.impl.broadcastCustomCommand(sessionCommand, bundle);
    }

    @UnstableApi
    public Bundle getSessionExtras() {
        return this.impl.getSessionExtras();
    }

    public final void setSessionExtras(Bundle bundle) {
        Assertions.checkNotNull(bundle);
        this.impl.setSessionExtras(bundle);
    }

    public final void setSessionExtras(ControllerInfo controllerInfo, Bundle bundle) {
        Assertions.checkNotNull(controllerInfo, "controller must not be null");
        Assertions.checkNotNull(bundle);
        this.impl.setSessionExtras(controllerInfo, bundle);
    }

    @UnstableApi
    public final androidx.media3.common.util.BitmapLoader getBitmapLoader() {
        return this.impl.getBitmapLoader();
    }

    @UnstableApi
    public final boolean getShowPlayButtonIfPlaybackIsSuppressed() {
        return this.impl.shouldPlayIfSuppressed();
    }

    public final ListenableFuture<SessionResult> sendCustomCommand(ControllerInfo controllerInfo, SessionCommand sessionCommand, Bundle bundle) {
        Assertions.checkNotNull(controllerInfo);
        Assertions.checkNotNull(sessionCommand);
        Assertions.checkNotNull(bundle);
        Assertions.checkArgument(sessionCommand.commandCode == 0, "command must be a custom command");
        return this.impl.sendCustomCommand(controllerInfo, sessionCommand, bundle);
    }

    @UnstableApi
    public final void sendError(ControllerInfo controllerInfo, SessionError sessionError) {
        this.impl.sendError(controllerInfo, sessionError);
    }

    @UnstableApi
    public final void sendError(SessionError sessionError) {
        this.impl.sendError(sessionError);
    }

    final MediaSessionCompat getSessionCompat() {
        return this.impl.getSessionCompat();
    }

    @UnstableApi
    @Deprecated
    public final MediaSessionCompat.Token getSessionCompatToken() {
        return (MediaSessionCompat.Token) LegacyParcelableUtil.convert(this.impl.getSessionCompat().getSessionToken(), MediaSessionCompat.Token.CREATOR);
    }

    @RequiresApi(21)
    @UnstableApi
    public final MediaSession.Token getPlatformToken() {
        return (MediaSession.Token) this.impl.getSessionCompat().getSessionToken().getToken();
    }

    final void handleControllerConnectionFromService(IMediaController iMediaController, ControllerInfo controllerInfo) {
        this.impl.connectFromService(iMediaController, controllerInfo);
    }

    final IBinder getLegacyBrowserServiceBinder() {
        return this.impl.getLegacyBrowserServiceBinder();
    }

    final void setListener(Listener listener) {
        this.impl.setMediaSessionListener(listener);
    }

    final void clearListener() {
        this.impl.clearMediaSessionListener();
    }

    final Uri getUri() {
        return this.impl.getUri();
    }

    public interface Callback {
        default void onDisconnected(MediaSession mediaSession, ControllerInfo controllerInfo) {
        }

        @UnstableApi
        default boolean onMediaButtonEvent(MediaSession mediaSession, ControllerInfo controllerInfo, Intent intent) {
            return false;
        }

        @Deprecated
        default int onPlayerCommandRequest(MediaSession mediaSession, ControllerInfo controllerInfo, int i) {
            return 0;
        }

        @UnstableApi
        default void onPlayerInteractionFinished(MediaSession mediaSession, ControllerInfo controllerInfo, Player.Commands commands) {
        }

        default void onPostConnect(MediaSession mediaSession, ControllerInfo controllerInfo) {
        }

        default ConnectionResult onConnect(MediaSession mediaSession, ControllerInfo controllerInfo) {
            return new ConnectionResult.AcceptedResultBuilder(mediaSession).build();
        }

        default ListenableFuture<SessionResult> onSetRating(MediaSession mediaSession, ControllerInfo controllerInfo, String str, Rating rating) {
            return Futures.immediateFuture(new SessionResult(-6));
        }

        default ListenableFuture<SessionResult> onSetRating(MediaSession mediaSession, ControllerInfo controllerInfo, Rating rating) {
            return Futures.immediateFuture(new SessionResult(-6));
        }

        default ListenableFuture<SessionResult> onCustomCommand(MediaSession mediaSession, ControllerInfo controllerInfo, SessionCommand sessionCommand, Bundle bundle) {
            return Futures.immediateFuture(new SessionResult(-6));
        }

        default ListenableFuture<List<MediaItem>> onAddMediaItems(MediaSession mediaSession, ControllerInfo controllerInfo, List<MediaItem> list) {
            Iterator<MediaItem> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().localConfiguration == null) {
                    return Futures.immediateFailedFuture(new UnsupportedOperationException());
                }
            }
            return Futures.immediateFuture(list);
        }

        @UnstableApi
        default ListenableFuture<MediaItemsWithStartPosition> onSetMediaItems(MediaSession mediaSession, ControllerInfo controllerInfo, List<MediaItem> list, final int i, final long j) {
            return Util.transformFutureAsync(onAddMediaItems(mediaSession, controllerInfo, list), new AsyncFunction() { // from class: androidx.media3.session.MediaSession$Callback$$ExternalSyntheticLambda0
                @Override // com.google.common.util.concurrent.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    return MediaSession.Callback.lambda$onSetMediaItems$0(i, j, (List) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ ListenableFuture lambda$onSetMediaItems$0(int i, long j, List list) {
            return Futures.immediateFuture(new MediaItemsWithStartPosition(list, i, j));
        }

        @UnstableApi
        default ListenableFuture<MediaItemsWithStartPosition> onPlaybackResumption(MediaSession mediaSession, ControllerInfo controllerInfo) {
            return Futures.immediateFailedFuture(new UnsupportedOperationException());
        }
    }

    @UnstableApi
    public static final class MediaItemsWithStartPosition {
        public final ImmutableList<MediaItem> mediaItems;
        public final int startIndex;
        public final long startPositionMs;

        public MediaItemsWithStartPosition(List<MediaItem> list, int i, long j) {
            this.mediaItems = ImmutableList.copyOf((Collection) list);
            this.startIndex = i;
            this.startPositionMs = j;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MediaItemsWithStartPosition)) {
                return false;
            }
            MediaItemsWithStartPosition mediaItemsWithStartPosition = (MediaItemsWithStartPosition) obj;
            return this.mediaItems.equals(mediaItemsWithStartPosition.mediaItems) && Util.areEqual(Integer.valueOf(this.startIndex), Integer.valueOf(mediaItemsWithStartPosition.startIndex)) && Util.areEqual(Long.valueOf(this.startPositionMs), Long.valueOf(mediaItemsWithStartPosition.startPositionMs));
        }

        public int hashCode() {
            return (((this.mediaItems.hashCode() * 31) + this.startIndex) * 31) + Longs.hashCode(this.startPositionMs);
        }
    }

    public static final class ConnectionResult {
        public final Player.Commands availablePlayerCommands;
        public final SessionCommands availableSessionCommands;

        @Nullable
        @UnstableApi
        public final ImmutableList<CommandButton> customLayout;
        public final boolean isAccepted;

        @Nullable
        @UnstableApi
        public final PendingIntent sessionActivity;

        @Nullable
        @UnstableApi
        public final Bundle sessionExtras;

        @UnstableApi
        public static final SessionCommands DEFAULT_SESSION_COMMANDS = new SessionCommands.Builder().addAllSessionCommands().build();

        @UnstableApi
        public static final SessionCommands DEFAULT_SESSION_AND_LIBRARY_COMMANDS = new SessionCommands.Builder().addAllLibraryCommands().addAllSessionCommands().build();

        @UnstableApi
        public static final Player.Commands DEFAULT_PLAYER_COMMANDS = new Player.Commands.Builder().addAllCommands().build();

        @UnstableApi
        public static class AcceptedResultBuilder {
            private Player.Commands availablePlayerCommands = ConnectionResult.DEFAULT_PLAYER_COMMANDS;
            private SessionCommands availableSessionCommands;
            private ImmutableList customLayout;
            private PendingIntent sessionActivity;
            private Bundle sessionExtras;

            public AcceptedResultBuilder(MediaSession mediaSession) {
                SessionCommands sessionCommands;
                if (mediaSession instanceof MediaLibraryService.MediaLibrarySession) {
                    sessionCommands = ConnectionResult.DEFAULT_SESSION_AND_LIBRARY_COMMANDS;
                } else {
                    sessionCommands = ConnectionResult.DEFAULT_SESSION_COMMANDS;
                }
                this.availableSessionCommands = sessionCommands;
            }

            @CanIgnoreReturnValue
            public AcceptedResultBuilder setAvailableSessionCommands(SessionCommands sessionCommands) {
                this.availableSessionCommands = (SessionCommands) Assertions.checkNotNull(sessionCommands);
                return this;
            }

            @CanIgnoreReturnValue
            public AcceptedResultBuilder setAvailablePlayerCommands(Player.Commands commands) {
                this.availablePlayerCommands = (Player.Commands) Assertions.checkNotNull(commands);
                return this;
            }

            @CanIgnoreReturnValue
            public AcceptedResultBuilder setCustomLayout(@Nullable List<CommandButton> list) {
                this.customLayout = list == null ? null : ImmutableList.copyOf((Collection) list);
                return this;
            }

            @CanIgnoreReturnValue
            public AcceptedResultBuilder setSessionExtras(Bundle bundle) {
                this.sessionExtras = bundle;
                return this;
            }

            @CanIgnoreReturnValue
            public AcceptedResultBuilder setSessionActivity(@Nullable PendingIntent pendingIntent) {
                this.sessionActivity = pendingIntent;
                return this;
            }

            public ConnectionResult build() {
                return new ConnectionResult(true, this.availableSessionCommands, this.availablePlayerCommands, this.customLayout, this.sessionExtras, this.sessionActivity);
            }
        }

        private ConnectionResult(boolean z, SessionCommands sessionCommands, Player.Commands commands, ImmutableList immutableList, Bundle bundle, PendingIntent pendingIntent) {
            this.isAccepted = z;
            this.availableSessionCommands = sessionCommands;
            this.availablePlayerCommands = commands;
            this.customLayout = immutableList;
            this.sessionExtras = bundle;
            this.sessionActivity = pendingIntent;
        }

        public static ConnectionResult accept(SessionCommands sessionCommands, Player.Commands commands) {
            return new ConnectionResult(true, sessionCommands, commands, null, null, null);
        }

        public static ConnectionResult reject() {
            return new ConnectionResult(false, SessionCommands.EMPTY, Player.Commands.EMPTY, ImmutableList.of(), Bundle.EMPTY, null);
        }
    }

    static abstract class BuilderBase {
        androidx.media3.common.util.BitmapLoader bitmapLoader;
        Callback callback;
        final Context context;
        ImmutableList customLayout;
        String id;
        boolean isPeriodicPositionUpdateEnabled;
        boolean playIfSuppressed;
        final Player player;
        PendingIntent sessionActivity;
        Bundle sessionExtras;
        Bundle tokenExtras;

        public BuilderBase(Context context, Player player, Callback callback) {
            this.context = (Context) Assertions.checkNotNull(context);
            this.player = (Player) Assertions.checkNotNull(player);
            Assertions.checkArgument(player.canAdvertiseSession());
            this.id = "";
            this.callback = callback;
            Bundle bundle = Bundle.EMPTY;
            this.tokenExtras = bundle;
            this.sessionExtras = bundle;
            this.customLayout = ImmutableList.of();
            this.playIfSuppressed = true;
            this.isPeriodicPositionUpdateEnabled = true;
        }

        public BuilderBase setSessionActivity(PendingIntent pendingIntent) {
            if (Util.SDK_INT >= 31) {
                Assertions.checkArgument(Api31.isActivity(pendingIntent));
            }
            this.sessionActivity = (PendingIntent) Assertions.checkNotNull(pendingIntent);
            return this;
        }

        public BuilderBase setId(String str) {
            this.id = (String) Assertions.checkNotNull(str);
            return this;
        }

        BuilderBase setCallback(Callback callback) {
            this.callback = (Callback) Assertions.checkNotNull(callback);
            return this;
        }

        public BuilderBase setExtras(Bundle bundle) {
            this.tokenExtras = new Bundle((Bundle) Assertions.checkNotNull(bundle));
            return this;
        }

        public BuilderBase setSessionExtras(Bundle bundle) {
            this.sessionExtras = new Bundle((Bundle) Assertions.checkNotNull(bundle));
            return this;
        }

        public BuilderBase setBitmapLoader(androidx.media3.common.util.BitmapLoader bitmapLoader) {
            this.bitmapLoader = (androidx.media3.common.util.BitmapLoader) Assertions.checkNotNull(bitmapLoader);
            return this;
        }

        public BuilderBase setCustomLayout(List list) {
            this.customLayout = ImmutableList.copyOf((Collection) list);
            return this;
        }

        public BuilderBase setShowPlayButtonIfPlaybackIsSuppressed(boolean z) {
            this.playIfSuppressed = z;
            return this;
        }

        public BuilderBase setPeriodicPositionUpdateEnabled(boolean z) {
            this.isPeriodicPositionUpdateEnabled = z;
            return this;
        }
    }

    private static final class Api31 {
        @DoNotInline
        public static boolean isActivity(PendingIntent pendingIntent) {
            return pendingIntent.isActivity();
        }
    }
}
