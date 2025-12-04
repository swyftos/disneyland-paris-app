package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSourceBitmapLoader;
import androidx.media3.session.MediaController;
import com.disney.id.android.lightbox.WebToNativeBridgeBase;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@DoNotMock
/* loaded from: classes.dex */
public class MediaController implements Player {

    @UnstableApi
    public static final String KEY_MEDIA_NOTIFICATION_CONTROLLER_FLAG = "androidx.media3.session.MediaNotificationManager";

    @UnstableApi
    public static final long RELEASE_UNBIND_TIMEOUT_MS = 30000;
    final Handler applicationHandler;
    final ConnectionCallback connectionCallback;
    private boolean connectionNotified;
    private final MediaControllerImpl impl;
    final Listener listener;
    private boolean released;
    private long timeDiffMs;
    private final Timeline.Window window;

    interface ConnectionCallback {
        void onAccepted();

        void onRejected();
    }

    interface MediaControllerImpl {
        void addListener(Player.Listener listener);

        void addMediaItem(int i, MediaItem mediaItem);

        void addMediaItem(MediaItem mediaItem);

        void addMediaItems(int i, List list);

        void addMediaItems(List list);

        void clearMediaItems();

        void clearVideoSurface();

        void clearVideoSurface(Surface surface);

        void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder);

        void clearVideoSurfaceView(SurfaceView surfaceView);

        void clearVideoTextureView(TextureView textureView);

        void connect();

        void decreaseDeviceVolume();

        void decreaseDeviceVolume(int i);

        AudioAttributes getAudioAttributes();

        Player.Commands getAvailableCommands();

        SessionCommands getAvailableSessionCommands();

        int getBufferedPercentage();

        long getBufferedPosition();

        SessionToken getConnectedToken();

        long getContentBufferedPosition();

        long getContentDuration();

        long getContentPosition();

        int getCurrentAdGroupIndex();

        int getCurrentAdIndexInAdGroup();

        CueGroup getCurrentCues();

        long getCurrentLiveOffset();

        int getCurrentMediaItemIndex();

        int getCurrentPeriodIndex();

        long getCurrentPosition();

        Timeline getCurrentTimeline();

        Tracks getCurrentTracks();

        ImmutableList getCustomLayout();

        DeviceInfo getDeviceInfo();

        int getDeviceVolume();

        long getDuration();

        long getMaxSeekToPreviousPosition();

        MediaMetadata getMediaMetadata();

        int getNextMediaItemIndex();

        boolean getPlayWhenReady();

        PlaybackParameters getPlaybackParameters();

        int getPlaybackState();

        int getPlaybackSuppressionReason();

        PlaybackException getPlayerError();

        MediaMetadata getPlaylistMetadata();

        int getPreviousMediaItemIndex();

        int getRepeatMode();

        long getSeekBackIncrement();

        long getSeekForwardIncrement();

        PendingIntent getSessionActivity();

        Bundle getSessionExtras();

        boolean getShuffleModeEnabled();

        Size getSurfaceSize();

        long getTotalBufferedDuration();

        TrackSelectionParameters getTrackSelectionParameters();

        VideoSize getVideoSize();

        float getVolume();

        boolean hasNextMediaItem();

        boolean hasPreviousMediaItem();

        void increaseDeviceVolume();

        void increaseDeviceVolume(int i);

        boolean isConnected();

        boolean isDeviceMuted();

        boolean isLoading();

        boolean isPlaying();

        boolean isPlayingAd();

        void moveMediaItem(int i, int i2);

        void moveMediaItems(int i, int i2, int i3);

        void pause();

        void play();

        void prepare();

        void release();

        void removeListener(Player.Listener listener);

        void removeMediaItem(int i);

        void removeMediaItems(int i, int i2);

        void replaceMediaItem(int i, MediaItem mediaItem);

        void replaceMediaItems(int i, int i2, List list);

        void seekBack();

        void seekForward();

        void seekTo(int i, long j);

        void seekTo(long j);

        void seekToDefaultPosition();

        void seekToDefaultPosition(int i);

        void seekToNext();

        void seekToNextMediaItem();

        void seekToPrevious();

        void seekToPreviousMediaItem();

        ListenableFuture sendCustomCommand(SessionCommand sessionCommand, Bundle bundle);

        void setAudioAttributes(AudioAttributes audioAttributes, boolean z);

        void setDeviceMuted(boolean z);

        void setDeviceMuted(boolean z, int i);

        void setDeviceVolume(int i);

        void setDeviceVolume(int i, int i2);

        void setMediaItem(MediaItem mediaItem);

        void setMediaItem(MediaItem mediaItem, long j);

        void setMediaItem(MediaItem mediaItem, boolean z);

        void setMediaItems(List list);

        void setMediaItems(List list, int i, long j);

        void setMediaItems(List list, boolean z);

        void setPlayWhenReady(boolean z);

        void setPlaybackParameters(PlaybackParameters playbackParameters);

        void setPlaybackSpeed(float f);

        void setPlaylistMetadata(MediaMetadata mediaMetadata);

        ListenableFuture setRating(Rating rating);

        ListenableFuture setRating(String str, Rating rating);

        void setRepeatMode(int i);

        void setShuffleModeEnabled(boolean z);

        void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters);

        void setVideoSurface(Surface surface);

        void setVideoSurfaceHolder(SurfaceHolder surfaceHolder);

        void setVideoSurfaceView(SurfaceView surfaceView);

        void setVideoTextureView(TextureView textureView);

        void setVolume(float f);

        void stop();
    }

    @Override // androidx.media3.common.Player
    public final boolean canAdvertiseSession() {
        return false;
    }

    @Override // androidx.media3.common.Player
    @Nullable
    @UnstableApi
    public final Object getCurrentManifest() {
        return null;
    }

    public static final class Builder {
        private androidx.media3.common.util.BitmapLoader bitmapLoader;
        private final Context context;
        private final SessionToken token;
        private Bundle connectionHints = Bundle.EMPTY;
        private Listener listener = new Listener() { // from class: androidx.media3.session.MediaController.Builder.1
        };
        private Looper applicationLooper = Util.getCurrentOrMainLooper();

        public Builder(Context context, SessionToken sessionToken) {
            this.context = (Context) Assertions.checkNotNull(context);
            this.token = (SessionToken) Assertions.checkNotNull(sessionToken);
        }

        @CanIgnoreReturnValue
        public Builder setConnectionHints(Bundle bundle) {
            this.connectionHints = new Bundle((Bundle) Assertions.checkNotNull(bundle));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setListener(Listener listener) {
            this.listener = (Listener) Assertions.checkNotNull(listener);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setApplicationLooper(Looper looper) {
            this.applicationLooper = (Looper) Assertions.checkNotNull(looper);
            return this;
        }

        @CanIgnoreReturnValue
        @UnstableApi
        public Builder setBitmapLoader(androidx.media3.common.util.BitmapLoader bitmapLoader) {
            this.bitmapLoader = (androidx.media3.common.util.BitmapLoader) Assertions.checkNotNull(bitmapLoader);
            return this;
        }

        public ListenableFuture<MediaController> buildAsync() {
            final MediaControllerHolder mediaControllerHolder = new MediaControllerHolder(this.applicationLooper);
            if (this.token.isLegacySession() && this.bitmapLoader == null) {
                this.bitmapLoader = new CacheBitmapLoader(new DataSourceBitmapLoader(this.context));
            }
            final MediaController mediaController = new MediaController(this.context, this.token, this.connectionHints, this.listener, this.applicationLooper, mediaControllerHolder, this.bitmapLoader);
            Util.postOrRun(new Handler(this.applicationLooper), new Runnable() { // from class: androidx.media3.session.MediaController$Builder$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    mediaControllerHolder.setController(mediaController);
                }
            });
            return mediaControllerHolder;
        }
    }

    public interface Listener {
        default void onAvailableSessionCommandsChanged(MediaController mediaController, SessionCommands sessionCommands) {
        }

        @UnstableApi
        default void onCustomLayoutChanged(MediaController mediaController, List<CommandButton> list) {
        }

        default void onDisconnected(MediaController mediaController) {
        }

        @UnstableApi
        default void onError(MediaController mediaController, SessionError sessionError) {
        }

        default void onExtrasChanged(MediaController mediaController, Bundle bundle) {
        }

        @UnstableApi
        default void onSessionActivityChanged(MediaController mediaController, PendingIntent pendingIntent) {
        }

        default ListenableFuture<SessionResult> onSetCustomLayout(MediaController mediaController, List<CommandButton> list) {
            return Futures.immediateFuture(new SessionResult(-6));
        }

        default ListenableFuture<SessionResult> onCustomCommand(MediaController mediaController, SessionCommand sessionCommand, Bundle bundle) {
            return Futures.immediateFuture(new SessionResult(-6));
        }
    }

    MediaController(Context context, SessionToken sessionToken, Bundle bundle, Listener listener, Looper looper, ConnectionCallback connectionCallback, androidx.media3.common.util.BitmapLoader bitmapLoader) {
        Assertions.checkNotNull(context, "context must not be null");
        Assertions.checkNotNull(sessionToken, "token must not be null");
        Log.i("MediaController", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [" + MediaLibraryInfo.VERSION_SLASHY + "] [" + Util.DEVICE_DEBUG_INFO + "]");
        this.window = new Timeline.Window();
        this.timeDiffMs = C.TIME_UNSET;
        this.listener = listener;
        this.applicationHandler = new Handler(looper);
        this.connectionCallback = connectionCallback;
        MediaControllerImpl mediaControllerImplCreateImpl = createImpl(context, sessionToken, bundle, looper, bitmapLoader);
        this.impl = mediaControllerImplCreateImpl;
        mediaControllerImplCreateImpl.connect();
    }

    MediaControllerImpl createImpl(Context context, SessionToken sessionToken, Bundle bundle, Looper looper, androidx.media3.common.util.BitmapLoader bitmapLoader) {
        if (sessionToken.isLegacySession()) {
            return new MediaControllerImplLegacy(context, this, sessionToken, looper, (androidx.media3.common.util.BitmapLoader) Assertions.checkNotNull(bitmapLoader));
        }
        return new MediaControllerImplBase(context, this, sessionToken, bundle, looper);
    }

    @Override // androidx.media3.common.Player
    public final void stop() {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring stop().");
        } else {
            this.impl.stop();
        }
    }

    @Override // androidx.media3.common.Player
    public final void release() {
        verifyApplicationThread();
        if (this.released) {
            return;
        }
        Log.i("MediaController", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [" + MediaLibraryInfo.VERSION_SLASHY + "] [" + Util.DEVICE_DEBUG_INFO + "] [" + MediaLibraryInfo.registeredModules() + "]");
        this.released = true;
        this.applicationHandler.removeCallbacksAndMessages(null);
        try {
            this.impl.release();
        } catch (Exception e) {
            Log.d("MediaController", "Exception while releasing impl", e);
        }
        if (this.connectionNotified) {
            notifyControllerListener(new Consumer() { // from class: androidx.media3.session.MediaController$$ExternalSyntheticLambda0
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    this.f$0.lambda$release$0((MediaController.Listener) obj);
                }
            });
        } else {
            this.connectionNotified = true;
            this.connectionCallback.onRejected();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$0(Listener listener) {
        listener.onDisconnected(this);
    }

    public static void releaseFuture(Future<? extends MediaController> future) {
        if (future.cancel(false)) {
            return;
        }
        try {
            ((MediaController) Futures.getDone(future)).release();
        } catch (CancellationException | ExecutionException e) {
            Log.w("MediaController", "MediaController future failed (so we couldn't release it)", e);
        }
    }

    @Nullable
    public final SessionToken getConnectedToken() {
        if (isConnected()) {
            return this.impl.getConnectedToken();
        }
        return null;
    }

    public final boolean isConnected() {
        return this.impl.isConnected();
    }

    @Override // androidx.media3.common.Player
    public final void play() {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring play().");
        } else {
            this.impl.play();
        }
    }

    @Override // androidx.media3.common.Player
    public final void pause() {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring pause().");
        } else {
            this.impl.pause();
        }
    }

    @Override // androidx.media3.common.Player
    public final void prepare() {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring prepare().");
        } else {
            this.impl.prepare();
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekToDefaultPosition() {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring seekTo().");
        } else {
            this.impl.seekToDefaultPosition();
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekToDefaultPosition(int i) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring seekTo().");
        } else {
            this.impl.seekToDefaultPosition(i);
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekTo(long j) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring seekTo().");
        } else {
            this.impl.seekTo(j);
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekTo(int i, long j) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring seekTo().");
        } else {
            this.impl.seekTo(i, j);
        }
    }

    @Override // androidx.media3.common.Player
    public final long getSeekBackIncrement() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getSeekBackIncrement();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final void seekBack() {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring seekBack().");
        } else {
            this.impl.seekBack();
        }
    }

    @Override // androidx.media3.common.Player
    public final long getSeekForwardIncrement() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getSeekForwardIncrement();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final void seekForward() {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring seekForward().");
        } else {
            this.impl.seekForward();
        }
    }

    @Nullable
    public final PendingIntent getSessionActivity() {
        if (isConnected()) {
            return this.impl.getSessionActivity();
        }
        return null;
    }

    @Override // androidx.media3.common.Player
    @Nullable
    public final PlaybackException getPlayerError() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getPlayerError();
        }
        return null;
    }

    @Override // androidx.media3.common.Player
    public final void setPlayWhenReady(boolean z) {
        verifyApplicationThread();
        if (isConnected()) {
            this.impl.setPlayWhenReady(z);
        }
    }

    @Override // androidx.media3.common.Player
    public final boolean getPlayWhenReady() {
        verifyApplicationThread();
        return isConnected() && this.impl.getPlayWhenReady();
    }

    @Override // androidx.media3.common.Player
    public final int getPlaybackSuppressionReason() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getPlaybackSuppressionReason();
        }
        return 0;
    }

    @Override // androidx.media3.common.Player
    public final int getPlaybackState() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getPlaybackState();
        }
        return 1;
    }

    @Override // androidx.media3.common.Player
    public final boolean isPlaying() {
        verifyApplicationThread();
        return isConnected() && this.impl.isPlaying();
    }

    @Override // androidx.media3.common.Player
    public final boolean isLoading() {
        verifyApplicationThread();
        return isConnected() && this.impl.isLoading();
    }

    @Override // androidx.media3.common.Player
    public final long getDuration() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getDuration() : C.TIME_UNSET;
    }

    @Override // androidx.media3.common.Player
    public final long getCurrentPosition() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getCurrentPosition();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final long getBufferedPosition() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getBufferedPosition();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    @IntRange(from = 0, to = WebToNativeBridgeBase.CLOSE_WAIT_DURATION_MILLISECONDS)
    public final int getBufferedPercentage() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getBufferedPercentage();
        }
        return 0;
    }

    @Override // androidx.media3.common.Player
    public final long getTotalBufferedDuration() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getTotalBufferedDuration();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final long getCurrentLiveOffset() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getCurrentLiveOffset() : C.TIME_UNSET;
    }

    @Override // androidx.media3.common.Player
    public final long getContentDuration() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getContentDuration() : C.TIME_UNSET;
    }

    @Override // androidx.media3.common.Player
    public final long getContentPosition() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getContentPosition();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final long getContentBufferedPosition() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getContentBufferedPosition();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final boolean isPlayingAd() {
        verifyApplicationThread();
        return isConnected() && this.impl.isPlayingAd();
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentAdGroupIndex() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getCurrentAdGroupIndex();
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentAdIndexInAdGroup() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getCurrentAdIndexInAdGroup();
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    public final void setPlaybackParameters(PlaybackParameters playbackParameters) {
        verifyApplicationThread();
        Assertions.checkNotNull(playbackParameters, "playbackParameters must not be null");
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setPlaybackParameters().");
        } else {
            this.impl.setPlaybackParameters(playbackParameters);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setPlaybackSpeed(float f) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setPlaybackSpeed().");
        } else {
            this.impl.setPlaybackSpeed(f);
        }
    }

    @Override // androidx.media3.common.Player
    public final PlaybackParameters getPlaybackParameters() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getPlaybackParameters() : PlaybackParameters.DEFAULT;
    }

    @Override // androidx.media3.common.Player
    public final AudioAttributes getAudioAttributes() {
        verifyApplicationThread();
        if (!isConnected()) {
            return AudioAttributes.DEFAULT;
        }
        return this.impl.getAudioAttributes();
    }

    public final ListenableFuture<SessionResult> setRating(String str, Rating rating) {
        verifyApplicationThread();
        Assertions.checkNotNull(str, "mediaId must not be null");
        Assertions.checkNotEmpty(str, "mediaId must not be empty");
        Assertions.checkNotNull(rating, "rating must not be null");
        if (isConnected()) {
            return this.impl.setRating(str, rating);
        }
        return createDisconnectedFuture();
    }

    public final ListenableFuture<SessionResult> setRating(Rating rating) {
        verifyApplicationThread();
        Assertions.checkNotNull(rating, "rating must not be null");
        if (isConnected()) {
            return this.impl.setRating(rating);
        }
        return createDisconnectedFuture();
    }

    public final ListenableFuture<SessionResult> sendCustomCommand(SessionCommand sessionCommand, Bundle bundle) {
        verifyApplicationThread();
        Assertions.checkNotNull(sessionCommand, "command must not be null");
        Assertions.checkArgument(sessionCommand.commandCode == 0, "command must be a custom command");
        if (isConnected()) {
            return this.impl.sendCustomCommand(sessionCommand, bundle);
        }
        return createDisconnectedFuture();
    }

    @UnstableApi
    public final ImmutableList<CommandButton> getCustomLayout() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getCustomLayout() : ImmutableList.of();
    }

    @UnstableApi
    public final Bundle getSessionExtras() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getSessionExtras() : Bundle.EMPTY;
    }

    @Override // androidx.media3.common.Player
    public final Timeline getCurrentTimeline() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getCurrentTimeline() : Timeline.EMPTY;
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItem(MediaItem mediaItem) {
        verifyApplicationThread();
        Assertions.checkNotNull(mediaItem, "mediaItems must not be null");
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setMediaItem().");
        } else {
            this.impl.setMediaItem(mediaItem);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItem(MediaItem mediaItem, long j) {
        verifyApplicationThread();
        Assertions.checkNotNull(mediaItem, "mediaItems must not be null");
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setMediaItem().");
        } else {
            this.impl.setMediaItem(mediaItem, j);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItem(MediaItem mediaItem, boolean z) {
        verifyApplicationThread();
        Assertions.checkNotNull(mediaItem, "mediaItems must not be null");
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setMediaItems().");
        } else {
            this.impl.setMediaItem(mediaItem, z);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItems(List<MediaItem> list) {
        verifyApplicationThread();
        Assertions.checkNotNull(list, "mediaItems must not be null");
        for (int i = 0; i < list.size(); i++) {
            Assertions.checkArgument(list.get(i) != null, "items must not contain null, index=" + i);
        }
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setMediaItems().");
        } else {
            this.impl.setMediaItems(list);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItems(List<MediaItem> list, boolean z) {
        verifyApplicationThread();
        Assertions.checkNotNull(list, "mediaItems must not be null");
        for (int i = 0; i < list.size(); i++) {
            Assertions.checkArgument(list.get(i) != null, "items must not contain null, index=" + i);
        }
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setMediaItems().");
        } else {
            this.impl.setMediaItems(list, z);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setMediaItems(List<MediaItem> list, int i, long j) {
        verifyApplicationThread();
        Assertions.checkNotNull(list, "mediaItems must not be null");
        for (int i2 = 0; i2 < list.size(); i2++) {
            Assertions.checkArgument(list.get(i2) != null, "items must not contain null, index=" + i2);
        }
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setMediaItems().");
        } else {
            this.impl.setMediaItems(list, i, j);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        verifyApplicationThread();
        Assertions.checkNotNull(mediaMetadata, "playlistMetadata must not be null");
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setPlaylistMetadata().");
        } else {
            this.impl.setPlaylistMetadata(mediaMetadata);
        }
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata getPlaylistMetadata() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getPlaylistMetadata() : MediaMetadata.EMPTY;
    }

    @Override // androidx.media3.common.Player
    public final void addMediaItem(MediaItem mediaItem) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring addMediaItem().");
        } else {
            this.impl.addMediaItem(mediaItem);
        }
    }

    @Override // androidx.media3.common.Player
    public final void addMediaItem(int i, MediaItem mediaItem) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring addMediaItem().");
        } else {
            this.impl.addMediaItem(i, mediaItem);
        }
    }

    @Override // androidx.media3.common.Player
    public final void addMediaItems(List<MediaItem> list) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring addMediaItems().");
        } else {
            this.impl.addMediaItems(list);
        }
    }

    @Override // androidx.media3.common.Player
    public final void addMediaItems(int i, List<MediaItem> list) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring addMediaItems().");
        } else {
            this.impl.addMediaItems(i, list);
        }
    }

    @Override // androidx.media3.common.Player
    public final void removeMediaItem(int i) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring removeMediaItem().");
        } else {
            this.impl.removeMediaItem(i);
        }
    }

    @Override // androidx.media3.common.Player
    public final void removeMediaItems(int i, int i2) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring removeMediaItems().");
        } else {
            this.impl.removeMediaItems(i, i2);
        }
    }

    @Override // androidx.media3.common.Player
    public final void clearMediaItems() {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring clearMediaItems().");
        } else {
            this.impl.clearMediaItems();
        }
    }

    @Override // androidx.media3.common.Player
    public final void moveMediaItem(int i, int i2) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring moveMediaItem().");
        } else {
            this.impl.moveMediaItem(i, i2);
        }
    }

    @Override // androidx.media3.common.Player
    public final void moveMediaItems(int i, int i2, int i3) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring moveMediaItems().");
        } else {
            this.impl.moveMediaItems(i, i2, i3);
        }
    }

    @Override // androidx.media3.common.Player
    public final void replaceMediaItem(int i, MediaItem mediaItem) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring replaceMediaItem().");
        } else {
            this.impl.replaceMediaItem(i, mediaItem);
        }
    }

    @Override // androidx.media3.common.Player
    public final void replaceMediaItems(int i, int i2, List<MediaItem> list) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring replaceMediaItems().");
        } else {
            this.impl.replaceMediaItems(i, i2, list);
        }
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final boolean isCurrentWindowDynamic() {
        return isCurrentMediaItemDynamic();
    }

    @Override // androidx.media3.common.Player
    public final boolean isCurrentMediaItemDynamic() {
        verifyApplicationThread();
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).isDynamic;
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final boolean isCurrentWindowLive() {
        return isCurrentMediaItemLive();
    }

    @Override // androidx.media3.common.Player
    public final boolean isCurrentMediaItemLive() {
        verifyApplicationThread();
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).isLive();
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final boolean isCurrentWindowSeekable() {
        return isCurrentMediaItemSeekable();
    }

    @Override // androidx.media3.common.Player
    public final boolean isCurrentMediaItemSeekable() {
        verifyApplicationThread();
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).isSeekable;
    }

    @Override // androidx.media3.common.Player
    @Nullable
    public final MediaItem getCurrentMediaItem() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).mediaItem;
    }

    @Override // androidx.media3.common.Player
    public final int getMediaItemCount() {
        return getCurrentTimeline().getWindowCount();
    }

    @Override // androidx.media3.common.Player
    public final MediaItem getMediaItemAt(int i) {
        return getCurrentTimeline().getWindow(i, this.window).mediaItem;
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentPeriodIndex() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getCurrentPeriodIndex();
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final int getCurrentWindowIndex() {
        return getCurrentMediaItemIndex();
    }

    @Override // androidx.media3.common.Player
    public final int getCurrentMediaItemIndex() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getCurrentMediaItemIndex();
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final int getPreviousWindowIndex() {
        return getPreviousMediaItemIndex();
    }

    @Override // androidx.media3.common.Player
    public final int getPreviousMediaItemIndex() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getPreviousMediaItemIndex();
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final int getNextWindowIndex() {
        return getNextMediaItemIndex();
    }

    @Override // androidx.media3.common.Player
    public final int getNextMediaItemIndex() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getNextMediaItemIndex();
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final boolean hasPrevious() {
        return hasPreviousMediaItem();
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final boolean hasNext() {
        return hasNextMediaItem();
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final boolean hasPreviousWindow() {
        return hasPreviousMediaItem();
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final boolean hasNextWindow() {
        return hasNextMediaItem();
    }

    @Override // androidx.media3.common.Player
    public final boolean hasPreviousMediaItem() {
        verifyApplicationThread();
        return isConnected() && this.impl.hasPreviousMediaItem();
    }

    @Override // androidx.media3.common.Player
    public final boolean hasNextMediaItem() {
        verifyApplicationThread();
        return isConnected() && this.impl.hasNextMediaItem();
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final void previous() {
        seekToPreviousMediaItem();
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final void next() {
        seekToNextMediaItem();
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final void seekToPreviousWindow() {
        seekToPreviousMediaItem();
    }

    @Override // androidx.media3.common.Player
    public final void seekToPreviousMediaItem() {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring seekToPreviousMediaItem().");
        } else {
            this.impl.seekToPreviousMediaItem();
        }
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    @Deprecated
    public final void seekToNextWindow() {
        seekToNextMediaItem();
    }

    @Override // androidx.media3.common.Player
    public final void seekToNextMediaItem() {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring seekToNextMediaItem().");
        } else {
            this.impl.seekToNextMediaItem();
        }
    }

    @Override // androidx.media3.common.Player
    public final void seekToPrevious() {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring seekToPrevious().");
        } else {
            this.impl.seekToPrevious();
        }
    }

    @Override // androidx.media3.common.Player
    public final long getMaxSeekToPreviousPosition() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getMaxSeekToPreviousPosition();
        }
        return 0L;
    }

    @Override // androidx.media3.common.Player
    public final void seekToNext() {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring seekToNext().");
        } else {
            this.impl.seekToNext();
        }
    }

    @Override // androidx.media3.common.Player
    public final int getRepeatMode() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getRepeatMode();
        }
        return 0;
    }

    @Override // androidx.media3.common.Player
    public final void setRepeatMode(int i) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setRepeatMode().");
        } else {
            this.impl.setRepeatMode(i);
        }
    }

    @Override // androidx.media3.common.Player
    public final boolean getShuffleModeEnabled() {
        verifyApplicationThread();
        return isConnected() && this.impl.getShuffleModeEnabled();
    }

    @Override // androidx.media3.common.Player
    public final void setShuffleModeEnabled(boolean z) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setShuffleMode().");
        } else {
            this.impl.setShuffleModeEnabled(z);
        }
    }

    @Override // androidx.media3.common.Player
    public final VideoSize getVideoSize() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getVideoSize() : VideoSize.UNKNOWN;
    }

    @Override // androidx.media3.common.Player
    @UnstableApi
    public final Size getSurfaceSize() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getSurfaceSize() : Size.UNKNOWN;
    }

    @Override // androidx.media3.common.Player
    public final void clearVideoSurface() {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring clearVideoSurface().");
        } else {
            this.impl.clearVideoSurface();
        }
    }

    @Override // androidx.media3.common.Player
    public final void clearVideoSurface(@Nullable Surface surface) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring clearVideoSurface().");
        } else {
            this.impl.clearVideoSurface(surface);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setVideoSurface(@Nullable Surface surface) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setVideoSurface().");
        } else {
            this.impl.setVideoSurface(surface);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setVideoSurfaceHolder().");
        } else {
            this.impl.setVideoSurfaceHolder(surfaceHolder);
        }
    }

    @Override // androidx.media3.common.Player
    public final void clearVideoSurfaceHolder(@Nullable SurfaceHolder surfaceHolder) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring clearVideoSurfaceHolder().");
        } else {
            this.impl.clearVideoSurfaceHolder(surfaceHolder);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setVideoSurfaceView().");
        } else {
            this.impl.setVideoSurfaceView(surfaceView);
        }
    }

    @Override // androidx.media3.common.Player
    public final void clearVideoSurfaceView(@Nullable SurfaceView surfaceView) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring clearVideoSurfaceView().");
        } else {
            this.impl.clearVideoSurfaceView(surfaceView);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setVideoTextureView(@Nullable TextureView textureView) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setVideoTextureView().");
        } else {
            this.impl.setVideoTextureView(textureView);
        }
    }

    @Override // androidx.media3.common.Player
    public final void clearVideoTextureView(@Nullable TextureView textureView) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring clearVideoTextureView().");
        } else {
            this.impl.clearVideoTextureView(textureView);
        }
    }

    @Override // androidx.media3.common.Player
    public final CueGroup getCurrentCues() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getCurrentCues() : CueGroup.EMPTY_TIME_ZERO;
    }

    @Override // androidx.media3.common.Player
    @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d)
    public final float getVolume() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getVolume();
        }
        return 1.0f;
    }

    @Override // androidx.media3.common.Player
    public final void setVolume(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        verifyApplicationThread();
        Assertions.checkArgument(f >= BitmapDescriptorFactory.HUE_RED && f <= 1.0f, "volume must be between 0 and 1");
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setVolume().");
        } else {
            this.impl.setVolume(f);
        }
    }

    @Override // androidx.media3.common.Player
    public final DeviceInfo getDeviceInfo() {
        verifyApplicationThread();
        if (!isConnected()) {
            return DeviceInfo.UNKNOWN;
        }
        return this.impl.getDeviceInfo();
    }

    @Override // androidx.media3.common.Player
    @IntRange(from = 0)
    public final int getDeviceVolume() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.getDeviceVolume();
        }
        return 0;
    }

    @Override // androidx.media3.common.Player
    public final boolean isDeviceMuted() {
        verifyApplicationThread();
        if (isConnected()) {
            return this.impl.isDeviceMuted();
        }
        return false;
    }

    @Override // androidx.media3.common.Player
    @Deprecated
    public final void setDeviceVolume(@IntRange(from = 0) int i) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setDeviceVolume().");
        } else {
            this.impl.setDeviceVolume(i);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setDeviceVolume(@IntRange(from = 0) int i, int i2) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setDeviceVolume().");
        } else {
            this.impl.setDeviceVolume(i, i2);
        }
    }

    @Override // androidx.media3.common.Player
    @Deprecated
    public final void increaseDeviceVolume() {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring increaseDeviceVolume().");
        } else {
            this.impl.increaseDeviceVolume();
        }
    }

    @Override // androidx.media3.common.Player
    public final void increaseDeviceVolume(int i) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring increaseDeviceVolume().");
        } else {
            this.impl.increaseDeviceVolume(i);
        }
    }

    @Override // androidx.media3.common.Player
    @Deprecated
    public final void decreaseDeviceVolume() {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring decreaseDeviceVolume().");
        } else {
            this.impl.decreaseDeviceVolume();
        }
    }

    @Override // androidx.media3.common.Player
    public final void decreaseDeviceVolume(int i) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring decreaseDeviceVolume().");
        } else {
            this.impl.decreaseDeviceVolume(i);
        }
    }

    @Override // androidx.media3.common.Player
    @Deprecated
    public final void setDeviceMuted(boolean z) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setDeviceMuted().");
        } else {
            this.impl.setDeviceMuted(z);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setDeviceMuted(boolean z, int i) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setDeviceMuted().");
        } else {
            this.impl.setDeviceMuted(z, i);
        }
    }

    @Override // androidx.media3.common.Player
    public final void setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setAudioAttributes().");
        } else {
            this.impl.setAudioAttributes(audioAttributes, z);
        }
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata getMediaMetadata() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getMediaMetadata() : MediaMetadata.EMPTY;
    }

    @Override // androidx.media3.common.Player
    public final Tracks getCurrentTracks() {
        verifyApplicationThread();
        return isConnected() ? this.impl.getCurrentTracks() : Tracks.EMPTY;
    }

    @Override // androidx.media3.common.Player
    public final TrackSelectionParameters getTrackSelectionParameters() {
        verifyApplicationThread();
        if (!isConnected()) {
            return TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT;
        }
        return this.impl.getTrackSelectionParameters();
    }

    @Override // androidx.media3.common.Player
    public final void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        verifyApplicationThread();
        if (!isConnected()) {
            Log.w("MediaController", "The controller is not connected. Ignoring setTrackSelectionParameters().");
        }
        this.impl.setTrackSelectionParameters(trackSelectionParameters);
    }

    @Override // androidx.media3.common.Player
    public final Looper getApplicationLooper() {
        return this.applicationHandler.getLooper();
    }

    final long getTimeDiffMs() {
        return this.timeDiffMs;
    }

    @Override // androidx.media3.common.Player
    public final void addListener(Player.Listener listener) {
        Assertions.checkNotNull(listener, "listener must not be null");
        this.impl.addListener(listener);
    }

    @Override // androidx.media3.common.Player
    public final void removeListener(Player.Listener listener) {
        verifyApplicationThread();
        Assertions.checkNotNull(listener, "listener must not be null");
        this.impl.removeListener(listener);
    }

    @Override // androidx.media3.common.Player
    public final boolean isCommandAvailable(int i) {
        return getAvailableCommands().contains(i);
    }

    @Override // androidx.media3.common.Player
    public final Player.Commands getAvailableCommands() {
        verifyApplicationThread();
        if (!isConnected()) {
            return Player.Commands.EMPTY;
        }
        return this.impl.getAvailableCommands();
    }

    public final boolean isSessionCommandAvailable(int i) {
        return getAvailableSessionCommands().contains(i);
    }

    public final boolean isSessionCommandAvailable(SessionCommand sessionCommand) {
        return getAvailableSessionCommands().contains(sessionCommand);
    }

    public final SessionCommands getAvailableSessionCommands() {
        verifyApplicationThread();
        if (!isConnected()) {
            return SessionCommands.EMPTY;
        }
        return this.impl.getAvailableSessionCommands();
    }

    private static ListenableFuture createDisconnectedFuture() {
        return Futures.immediateFuture(new SessionResult(-100));
    }

    final void runOnApplicationLooper(Runnable runnable) {
        Util.postOrRun(this.applicationHandler, runnable);
    }

    final void notifyControllerListener(Consumer consumer) {
        Assertions.checkState(Looper.myLooper() == getApplicationLooper());
        consumer.accept(this.listener);
    }

    final void notifyAccepted() {
        Assertions.checkState(Looper.myLooper() == getApplicationLooper());
        Assertions.checkState(!this.connectionNotified);
        this.connectionNotified = true;
        this.connectionCallback.onAccepted();
    }

    private void verifyApplicationThread() {
        Assertions.checkState(Looper.myLooper() == getApplicationLooper(), "MediaController method is called from a wrong thread. See javadoc of MediaController for details.");
    }
}
