package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.session.MediaController;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.emoji2.text.ConcurrencyHelpers$$ExternalSyntheticLambda0;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.FlagSet;
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
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import androidx.media3.session.LegacyConversions;
import androidx.media3.session.MediaController;
import androidx.media3.session.legacy.MediaBrowserCompat;
import androidx.media3.session.legacy.MediaControllerCompat;
import androidx.media3.session.legacy.MediaMetadataCompat;
import androidx.media3.session.legacy.MediaSessionCompat;
import androidx.media3.session.legacy.PlaybackStateCompat;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
class MediaControllerImplLegacy implements MediaController.MediaControllerImpl {
    private final androidx.media3.common.util.BitmapLoader bitmapLoader;
    private MediaBrowserCompat browserCompat;
    private boolean connected;
    final Context context;
    private MediaControllerCompat controllerCompat;
    private final ControllerCompatCallback controllerCompatCallback;
    private final MediaController instance;
    private final ListenerSet listeners;
    private boolean released;
    private final SessionToken token;
    private LegacyPlayerInfo legacyPlayerInfo = new LegacyPlayerInfo();
    private LegacyPlayerInfo pendingLegacyPlayerInfo = new LegacyPlayerInfo();
    private ControllerInfo controllerInfo = new ControllerInfo();
    private long currentPositionMs = C.TIME_UNSET;
    private long lastSetPlayWhenReadyCalledTimeMs = C.TIME_UNSET;

    private static int calculateCurrentItemIndexAfterAddItems(int i, int i2, int i3) {
        return i < i2 ? i : i + i3;
    }

    private static int calculateCurrentItemIndexAfterRemoveItems(int i, int i2, int i3) {
        int i4 = i3 - i2;
        if (i < i2) {
            return i;
        }
        if (i < i3) {
            return -1;
        }
        return i - i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ignoreFuture(Future future) {
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getCurrentAdGroupIndex() {
        return -1;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getCurrentAdIndexInAdGroup() {
        return -1;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getCurrentLiveOffset() {
        return C.TIME_UNSET;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getNextMediaItemIndex() {
        return -1;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getPlaybackSuppressionReason() {
        return 0;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getPreviousMediaItemIndex() {
        return -1;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public float getVolume() {
        return 1.0f;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean isLoading() {
        return false;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
    }

    public MediaControllerImplLegacy(Context context, MediaController mediaController, SessionToken sessionToken, Looper looper, androidx.media3.common.util.BitmapLoader bitmapLoader) {
        this.listeners = new ListenerSet(looper, Clock.DEFAULT, new ListenerSet.IterationFinishedEvent() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda3
            @Override // androidx.media3.common.util.ListenerSet.IterationFinishedEvent
            public final void invoke(Object obj, FlagSet flagSet) {
                this.f$0.lambda$new$0((Player.Listener) obj, flagSet);
            }
        });
        this.context = context;
        this.instance = mediaController;
        this.controllerCompatCallback = new ControllerCompatCallback(looper);
        this.token = sessionToken;
        this.bitmapLoader = bitmapLoader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Player.Listener listener, FlagSet flagSet) {
        listener.onEvents(getInstance(), new Player.Events(flagSet));
    }

    MediaController getInstance() {
        return this.instance;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void connect() {
        if (this.token.getType() == 0) {
            connectToSession((MediaSessionCompat.Token) Assertions.checkStateNotNull(this.token.getBinder()));
        } else {
            connectToService();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void addListener(Player.Listener listener) {
        this.listeners.add(listener);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void removeListener(Player.Listener listener) {
        this.listeners.remove(listener);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void stop() {
        PlayerInfo playerInfo = this.controllerInfo.playerInfo;
        if (playerInfo.playbackState == 1) {
            return;
        }
        SessionPositionInfo sessionPositionInfo = playerInfo.sessionPositionInfo;
        Player.PositionInfo positionInfo = sessionPositionInfo.positionInfo;
        long j = sessionPositionInfo.durationMs;
        long j2 = positionInfo.positionMs;
        PlayerInfo playerInfoCopyWithSessionPositionInfo = playerInfo.copyWithSessionPositionInfo(createSessionPositionInfo(positionInfo, false, j, j2, MediaUtils.calculateBufferedPercentage(j2, j), 0L));
        PlayerInfo playerInfo2 = this.controllerInfo.playerInfo;
        if (playerInfo2.playbackState != 1) {
            playerInfoCopyWithSessionPositionInfo = playerInfoCopyWithSessionPositionInfo.copyWithPlaybackState(1, playerInfo2.playerError);
        }
        ControllerInfo controllerInfo = this.controllerInfo;
        updateStateMaskedControllerInfo(new ControllerInfo(playerInfoCopyWithSessionPositionInfo, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout, controllerInfo.sessionExtras, null), null, null);
        this.controllerCompat.getTransportControls().stop();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void release() {
        if (this.released) {
            return;
        }
        this.released = true;
        MediaBrowserCompat mediaBrowserCompat = this.browserCompat;
        if (mediaBrowserCompat != null) {
            mediaBrowserCompat.disconnect();
            this.browserCompat = null;
        }
        MediaControllerCompat mediaControllerCompat = this.controllerCompat;
        if (mediaControllerCompat != null) {
            mediaControllerCompat.unregisterCallback(this.controllerCompatCallback);
            this.controllerCompatCallback.release();
            this.controllerCompat = null;
        }
        this.connected = false;
        this.listeners.release();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public SessionToken getConnectedToken() {
        if (this.connected) {
            return this.token;
        }
        return null;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean isConnected() {
        return this.connected;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void play() {
        setPlayWhenReady(true);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void pause() {
        setPlayWhenReady(false);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void prepare() {
        PlayerInfo playerInfo = this.controllerInfo.playerInfo;
        if (playerInfo.playbackState != 1) {
            return;
        }
        PlayerInfo playerInfoCopyWithPlaybackState = playerInfo.copyWithPlaybackState(playerInfo.timeline.isEmpty() ? 4 : 2, null);
        ControllerInfo controllerInfo = this.controllerInfo;
        updateStateMaskedControllerInfo(new ControllerInfo(playerInfoCopyWithPlaybackState, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout, controllerInfo.sessionExtras, null), null, null);
        if (hasMedia()) {
            initializeLegacyPlaylist();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekToDefaultPosition() {
        seekToInternal(getCurrentMediaItemIndex(), 0L);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekToDefaultPosition(int i) {
        seekToInternal(i, 0L);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekTo(long j) {
        seekToInternal(getCurrentMediaItemIndex(), j);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekTo(int i, long j) {
        seekToInternal(i, j);
    }

    private void seekToInternal(int i, long j) {
        Integer num;
        Integer num2;
        int i2;
        long j2;
        long j3;
        long j4;
        int i3 = i;
        long j5 = j;
        Assertions.checkArgument(i3 >= 0);
        int currentMediaItemIndex = getCurrentMediaItemIndex();
        Timeline timeline = this.controllerInfo.playerInfo.timeline;
        if ((timeline.isEmpty() || i3 < timeline.getWindowCount()) && !isPlayingAd()) {
            if (i3 != currentMediaItemIndex) {
                long queueId = ((QueueTimeline) this.controllerInfo.playerInfo.timeline).getQueueId(i3);
                if (queueId != -1) {
                    this.controllerCompat.getTransportControls().skipToQueueItem(queueId);
                    num = 2;
                } else {
                    Log.w("MCImplLegacy", "Cannot seek to new media item due to the missing queue Id at media item, mediaItemIndex=" + i3);
                    i3 = currentMediaItemIndex;
                    num = null;
                }
            } else {
                i3 = currentMediaItemIndex;
                num = null;
            }
            long currentPosition = getCurrentPosition();
            if (j5 == C.TIME_UNSET) {
                j5 = currentPosition;
                num2 = null;
            } else {
                this.controllerCompat.getTransportControls().seekTo(j5);
                num2 = 1;
            }
            if (num == null) {
                long bufferedPosition = getBufferedPosition();
                long duration = getDuration();
                long jMax = j5 < currentPosition ? j5 : Math.max(j5, bufferedPosition);
                j2 = jMax;
                i2 = duration == C.TIME_UNSET ? 0 : (int) ((100 * jMax) / duration);
                j3 = jMax - j5;
                j4 = duration;
            } else {
                i2 = 0;
                j2 = 0;
                j3 = 0;
                j4 = -9223372036854775807L;
            }
            PlayerInfo playerInfoCopyWithSessionPositionInfo = this.controllerInfo.playerInfo.copyWithSessionPositionInfo(createSessionPositionInfo(createPositionInfo(i3, !timeline.isEmpty() ? timeline.getWindow(i3, new Timeline.Window()).mediaItem : null, j5, false), false, j4, j2, i2, j3));
            if (playerInfoCopyWithSessionPositionInfo.playbackState != 1) {
                playerInfoCopyWithSessionPositionInfo = playerInfoCopyWithSessionPositionInfo.copyWithPlaybackState(2, null);
            }
            ControllerInfo controllerInfo = this.controllerInfo;
            updateStateMaskedControllerInfo(new ControllerInfo(playerInfoCopyWithSessionPositionInfo, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout, controllerInfo.sessionExtras, null), num2, num);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getSeekBackIncrement() {
        return this.controllerInfo.playerInfo.seekBackIncrementMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekBack() {
        this.controllerCompat.getTransportControls().rewind();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getSeekForwardIncrement() {
        return this.controllerInfo.playerInfo.seekForwardIncrementMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekForward() {
        this.controllerCompat.getTransportControls().fastForward();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public PendingIntent getSessionActivity() {
        return this.controllerCompat.getSessionActivity();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public ImmutableList getCustomLayout() {
        return this.controllerInfo.customLayout;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public Bundle getSessionExtras() {
        return this.controllerInfo.sessionExtras;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public PlaybackException getPlayerError() {
        return this.controllerInfo.playerInfo.playerError;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getDuration() {
        return this.controllerInfo.playerInfo.sessionPositionInfo.durationMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getCurrentPosition() {
        long updatedCurrentPositionMs = MediaUtils.getUpdatedCurrentPositionMs(this.controllerInfo.playerInfo, this.currentPositionMs, this.lastSetPlayWhenReadyCalledTimeMs, getInstance().getTimeDiffMs());
        this.currentPositionMs = updatedCurrentPositionMs;
        return updatedCurrentPositionMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getBufferedPosition() {
        return this.controllerInfo.playerInfo.sessionPositionInfo.bufferedPositionMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getBufferedPercentage() {
        return this.controllerInfo.playerInfo.sessionPositionInfo.bufferedPercentage;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getTotalBufferedDuration() {
        return this.controllerInfo.playerInfo.sessionPositionInfo.totalBufferedDurationMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getContentDuration() {
        return getDuration();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getContentPosition() {
        return getCurrentPosition();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getContentBufferedPosition() {
        return getBufferedPosition();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean isPlayingAd() {
        return this.controllerInfo.playerInfo.sessionPositionInfo.isPlayingAd;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public PlaybackParameters getPlaybackParameters() {
        return this.controllerInfo.playerInfo.playbackParameters;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public AudioAttributes getAudioAttributes() {
        return this.controllerInfo.playerInfo.audioAttributes;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public ListenableFuture setRating(String str, Rating rating) {
        if (str.equals(this.legacyPlayerInfo.mediaMetadataCompat.getString("android.media.metadata.MEDIA_ID"))) {
            this.controllerCompat.getTransportControls().setRating(LegacyConversions.convertToRatingCompat(rating));
        }
        return Futures.immediateFuture(new SessionResult(0));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public ListenableFuture setRating(Rating rating) {
        this.controllerCompat.getTransportControls().setRating(LegacyConversions.convertToRatingCompat(rating));
        return Futures.immediateFuture(new SessionResult(0));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        if (!playbackParameters.equals(getPlaybackParameters())) {
            PlayerInfo playerInfoCopyWithPlaybackParameters = this.controllerInfo.playerInfo.copyWithPlaybackParameters(playbackParameters);
            ControllerInfo controllerInfo = this.controllerInfo;
            updateStateMaskedControllerInfo(new ControllerInfo(playerInfoCopyWithPlaybackParameters, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout, controllerInfo.sessionExtras, null), null, null);
        }
        this.controllerCompat.getTransportControls().setPlaybackSpeed(playbackParameters.speed);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setPlaybackSpeed(float f) {
        if (f != getPlaybackParameters().speed) {
            PlayerInfo playerInfoCopyWithPlaybackParameters = this.controllerInfo.playerInfo.copyWithPlaybackParameters(new PlaybackParameters(f));
            ControllerInfo controllerInfo = this.controllerInfo;
            updateStateMaskedControllerInfo(new ControllerInfo(playerInfoCopyWithPlaybackParameters, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout, controllerInfo.sessionExtras, null), null, null);
        }
        this.controllerCompat.getTransportControls().setPlaybackSpeed(f);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public ListenableFuture sendCustomCommand(SessionCommand sessionCommand, Bundle bundle) {
        if (this.controllerInfo.availableSessionCommands.contains(sessionCommand)) {
            this.controllerCompat.getTransportControls().sendCustomAction(sessionCommand.customAction, bundle);
            return Futures.immediateFuture(new SessionResult(0));
        }
        final SettableFuture settableFutureCreate = SettableFuture.create();
        this.controllerCompat.sendCommand(sessionCommand.customAction, bundle, new ResultReceiver(getInstance().applicationHandler) { // from class: androidx.media3.session.MediaControllerImplLegacy.1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i, Bundle bundle2) {
                SettableFuture settableFuture = settableFutureCreate;
                if (bundle2 == null) {
                    bundle2 = Bundle.EMPTY;
                }
                settableFuture.set(new SessionResult(i, bundle2));
            }
        });
        return settableFutureCreate;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public Timeline getCurrentTimeline() {
        return this.controllerInfo.playerInfo.timeline;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setMediaItem(MediaItem mediaItem) {
        setMediaItem(mediaItem, C.TIME_UNSET);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setMediaItem(MediaItem mediaItem, long j) {
        setMediaItems(ImmutableList.of(mediaItem), 0, j);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setMediaItem(MediaItem mediaItem, boolean z) {
        setMediaItem(mediaItem);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setMediaItems(List list) {
        setMediaItems(list, 0, C.TIME_UNSET);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setMediaItems(List list, boolean z) {
        setMediaItems(list);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setMediaItems(List list, int i, long j) {
        if (list.isEmpty()) {
            clearMediaItems();
            return;
        }
        PlayerInfo playerInfoCopyWithTimelineAndSessionPositionInfo = this.controllerInfo.playerInfo.copyWithTimelineAndSessionPositionInfo(QueueTimeline.DEFAULT.copyWithNewMediaItems(0, list), createSessionPositionInfo(createPositionInfo(i, (MediaItem) list.get(i), j == C.TIME_UNSET ? 0L : j, false), false, C.TIME_UNSET, 0L, 0, 0L), 0);
        ControllerInfo controllerInfo = this.controllerInfo;
        updateStateMaskedControllerInfo(new ControllerInfo(playerInfoCopyWithTimelineAndSessionPositionInfo, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout, controllerInfo.sessionExtras, null), null, null);
        if (isPrepared()) {
            initializeLegacyPlaylist();
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        Log.w("MCImplLegacy", "Session doesn't support setting playlist metadata");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public MediaMetadata getPlaylistMetadata() {
        return this.controllerInfo.playerInfo.playlistMetadata;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void addMediaItem(MediaItem mediaItem) {
        addMediaItems(Integer.MAX_VALUE, Collections.singletonList(mediaItem));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void addMediaItem(int i, MediaItem mediaItem) {
        addMediaItems(i, Collections.singletonList(mediaItem));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void addMediaItems(List list) {
        addMediaItems(Integer.MAX_VALUE, list);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void addMediaItems(int i, List list) {
        Assertions.checkArgument(i >= 0);
        if (list.isEmpty()) {
            return;
        }
        QueueTimeline queueTimeline = (QueueTimeline) this.controllerInfo.playerInfo.timeline;
        if (queueTimeline.isEmpty()) {
            setMediaItems(list);
            return;
        }
        int iMin = Math.min(i, getCurrentTimeline().getWindowCount());
        PlayerInfo playerInfoCopyWithTimelineAndMediaItemIndex = this.controllerInfo.playerInfo.copyWithTimelineAndMediaItemIndex(queueTimeline.copyWithNewMediaItems(iMin, list), calculateCurrentItemIndexAfterAddItems(getCurrentMediaItemIndex(), iMin, list.size()), 0);
        ControllerInfo controllerInfo = this.controllerInfo;
        updateStateMaskedControllerInfo(new ControllerInfo(playerInfoCopyWithTimelineAndMediaItemIndex, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout, controllerInfo.sessionExtras, null), null, null);
        if (isPrepared()) {
            addQueueItems(list, iMin);
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void removeMediaItem(int i) {
        removeMediaItems(i, i + 1);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void removeMediaItems(int i, int i2) {
        Assertions.checkArgument(i >= 0 && i2 >= i);
        int windowCount = getCurrentTimeline().getWindowCount();
        int iMin = Math.min(i2, windowCount);
        if (i >= windowCount || i == iMin) {
            return;
        }
        QueueTimeline queueTimelineCopyWithRemovedMediaItems = ((QueueTimeline) this.controllerInfo.playerInfo.timeline).copyWithRemovedMediaItems(i, iMin);
        int iCalculateCurrentItemIndexAfterRemoveItems = calculateCurrentItemIndexAfterRemoveItems(getCurrentMediaItemIndex(), i, iMin);
        if (iCalculateCurrentItemIndexAfterRemoveItems == -1) {
            iCalculateCurrentItemIndexAfterRemoveItems = Util.constrainValue(i, 0, queueTimelineCopyWithRemovedMediaItems.getWindowCount() - 1);
            Log.w("MCImplLegacy", "Currently playing item is removed. Assumes item at " + iCalculateCurrentItemIndexAfterRemoveItems + " is the new current item");
        }
        PlayerInfo playerInfoCopyWithTimelineAndMediaItemIndex = this.controllerInfo.playerInfo.copyWithTimelineAndMediaItemIndex(queueTimelineCopyWithRemovedMediaItems, iCalculateCurrentItemIndexAfterRemoveItems, 0);
        ControllerInfo controllerInfo = this.controllerInfo;
        updateStateMaskedControllerInfo(new ControllerInfo(playerInfoCopyWithTimelineAndMediaItemIndex, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout, controllerInfo.sessionExtras, null), null, null);
        if (isPrepared()) {
            while (i < iMin && i < this.legacyPlayerInfo.queue.size()) {
                this.controllerCompat.removeQueueItem(((MediaSessionCompat.QueueItem) this.legacyPlayerInfo.queue.get(i)).getDescription());
                i++;
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void clearMediaItems() {
        removeMediaItems(0, Integer.MAX_VALUE);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void moveMediaItem(int i, int i2) {
        moveMediaItems(i, i + 1, i2);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void moveMediaItems(int i, int i2, int i3) {
        Assertions.checkArgument(i >= 0 && i <= i2 && i3 >= 0);
        QueueTimeline queueTimeline = (QueueTimeline) this.controllerInfo.playerInfo.timeline;
        int windowCount = queueTimeline.getWindowCount();
        int iMin = Math.min(i2, windowCount);
        int i4 = iMin - i;
        int i5 = windowCount - i4;
        int i6 = i5 - 1;
        int iMin2 = Math.min(i3, i5);
        if (i >= windowCount || i == iMin || i == iMin2) {
            return;
        }
        int iCalculateCurrentItemIndexAfterRemoveItems = calculateCurrentItemIndexAfterRemoveItems(getCurrentMediaItemIndex(), i, iMin);
        if (iCalculateCurrentItemIndexAfterRemoveItems == -1) {
            iCalculateCurrentItemIndexAfterRemoveItems = Util.constrainValue(i, 0, i6);
            Log.w("MCImplLegacy", "Currently playing item will be removed and added back to mimic move. Assumes item at " + iCalculateCurrentItemIndexAfterRemoveItems + " would be the new current item");
        }
        PlayerInfo playerInfoCopyWithTimelineAndMediaItemIndex = this.controllerInfo.playerInfo.copyWithTimelineAndMediaItemIndex(queueTimeline.copyWithMovedMediaItems(i, iMin, iMin2), calculateCurrentItemIndexAfterAddItems(iCalculateCurrentItemIndexAfterRemoveItems, iMin2, i4), 0);
        ControllerInfo controllerInfo = this.controllerInfo;
        updateStateMaskedControllerInfo(new ControllerInfo(playerInfoCopyWithTimelineAndMediaItemIndex, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout, controllerInfo.sessionExtras, null), null, null);
        if (isPrepared()) {
            ArrayList arrayList = new ArrayList();
            for (int i7 = 0; i7 < i4; i7++) {
                arrayList.add((MediaSessionCompat.QueueItem) this.legacyPlayerInfo.queue.get(i));
                this.controllerCompat.removeQueueItem(((MediaSessionCompat.QueueItem) this.legacyPlayerInfo.queue.get(i)).getDescription());
            }
            for (int i8 = 0; i8 < arrayList.size(); i8++) {
                this.controllerCompat.addQueueItem(((MediaSessionCompat.QueueItem) arrayList.get(i8)).getDescription(), i8 + iMin2);
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void replaceMediaItem(int i, MediaItem mediaItem) {
        replaceMediaItems(i, i + 1, ImmutableList.of(mediaItem));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void replaceMediaItems(int i, int i2, List list) {
        Assertions.checkArgument(i >= 0 && i <= i2);
        int windowCount = ((QueueTimeline) this.controllerInfo.playerInfo.timeline).getWindowCount();
        if (i > windowCount) {
            return;
        }
        int iMin = Math.min(i2, windowCount);
        addMediaItems(iMin, list);
        removeMediaItems(i, iMin);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getCurrentPeriodIndex() {
        return getCurrentMediaItemIndex();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getCurrentMediaItemIndex() {
        return this.controllerInfo.playerInfo.sessionPositionInfo.positionInfo.mediaItemIndex;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean hasPreviousMediaItem() {
        return this.connected;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean hasNextMediaItem() {
        return this.connected;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekToPreviousMediaItem() {
        this.controllerCompat.getTransportControls().skipToPrevious();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekToNextMediaItem() {
        this.controllerCompat.getTransportControls().skipToNext();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekToPrevious() {
        this.controllerCompat.getTransportControls().skipToPrevious();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void seekToNext() {
        this.controllerCompat.getTransportControls().skipToNext();
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public long getMaxSeekToPreviousPosition() {
        return this.controllerInfo.playerInfo.maxSeekToPreviousPositionMs;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getRepeatMode() {
        return this.controllerInfo.playerInfo.repeatMode;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setRepeatMode(int i) {
        if (i != getRepeatMode()) {
            PlayerInfo playerInfoCopyWithRepeatMode = this.controllerInfo.playerInfo.copyWithRepeatMode(i);
            ControllerInfo controllerInfo = this.controllerInfo;
            updateStateMaskedControllerInfo(new ControllerInfo(playerInfoCopyWithRepeatMode, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout, controllerInfo.sessionExtras, null), null, null);
        }
        this.controllerCompat.getTransportControls().setRepeatMode(LegacyConversions.convertToPlaybackStateCompatRepeatMode(i));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean getShuffleModeEnabled() {
        return this.controllerInfo.playerInfo.shuffleModeEnabled;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setShuffleModeEnabled(boolean z) {
        if (z != getShuffleModeEnabled()) {
            PlayerInfo playerInfoCopyWithShuffleModeEnabled = this.controllerInfo.playerInfo.copyWithShuffleModeEnabled(z);
            ControllerInfo controllerInfo = this.controllerInfo;
            updateStateMaskedControllerInfo(new ControllerInfo(playerInfoCopyWithShuffleModeEnabled, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout, controllerInfo.sessionExtras, null), null, null);
        }
        this.controllerCompat.getTransportControls().setShuffleMode(LegacyConversions.convertToPlaybackStateCompatShuffleMode(z));
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public VideoSize getVideoSize() {
        Log.w("MCImplLegacy", "Session doesn't support getting VideoSize");
        return VideoSize.UNKNOWN;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public Size getSurfaceSize() {
        Log.w("MCImplLegacy", "Session doesn't support getting VideoSurfaceSize");
        return Size.UNKNOWN;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void clearVideoSurface() {
        Log.w("MCImplLegacy", "Session doesn't support clearing Surface");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void clearVideoSurface(Surface surface) {
        Log.w("MCImplLegacy", "Session doesn't support clearing Surface");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setVideoSurface(Surface surface) {
        Log.w("MCImplLegacy", "Session doesn't support setting Surface");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        Log.w("MCImplLegacy", "Session doesn't support setting SurfaceHolder");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        Log.w("MCImplLegacy", "Session doesn't support clearing SurfaceHolder");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setVideoSurfaceView(SurfaceView surfaceView) {
        Log.w("MCImplLegacy", "Session doesn't support setting SurfaceView");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        Log.w("MCImplLegacy", "Session doesn't support clearing SurfaceView");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setVideoTextureView(TextureView textureView) {
        Log.w("MCImplLegacy", "Session doesn't support setting TextureView");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void clearVideoTextureView(TextureView textureView) {
        Log.w("MCImplLegacy", "Session doesn't support clearing TextureView");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public CueGroup getCurrentCues() {
        Log.w("MCImplLegacy", "Session doesn't support getting Cue");
        return CueGroup.EMPTY_TIME_ZERO;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setVolume(float f) {
        Log.w("MCImplLegacy", "Session doesn't support setting player volume");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public DeviceInfo getDeviceInfo() {
        return this.controllerInfo.playerInfo.deviceInfo;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getDeviceVolume() {
        PlayerInfo playerInfo = this.controllerInfo.playerInfo;
        if (playerInfo.deviceInfo.playbackType == 1) {
            return playerInfo.deviceVolume;
        }
        MediaControllerCompat mediaControllerCompat = this.controllerCompat;
        if (mediaControllerCompat != null) {
            return LegacyConversions.convertToDeviceVolume(mediaControllerCompat.getPlaybackInfo());
        }
        return 0;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean isDeviceMuted() {
        PlayerInfo playerInfo = this.controllerInfo.playerInfo;
        if (playerInfo.deviceInfo.playbackType == 1) {
            return playerInfo.deviceMuted;
        }
        MediaControllerCompat mediaControllerCompat = this.controllerCompat;
        return mediaControllerCompat != null && LegacyConversions.convertToIsDeviceMuted(mediaControllerCompat.getPlaybackInfo());
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setDeviceVolume(int i) {
        setDeviceVolume(i, 1);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setDeviceVolume(int i, int i2) {
        DeviceInfo deviceInfo = getDeviceInfo();
        int i3 = deviceInfo.minVolume;
        int i4 = deviceInfo.maxVolume;
        if (i3 <= i && (i4 == 0 || i <= i4)) {
            PlayerInfo playerInfoCopyWithDeviceVolume = this.controllerInfo.playerInfo.copyWithDeviceVolume(i, isDeviceMuted());
            ControllerInfo controllerInfo = this.controllerInfo;
            updateStateMaskedControllerInfo(new ControllerInfo(playerInfoCopyWithDeviceVolume, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout, controllerInfo.sessionExtras, null), null, null);
        }
        this.controllerCompat.setVolumeTo(i, i2);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void increaseDeviceVolume() {
        increaseDeviceVolume(1);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void increaseDeviceVolume(int i) {
        int deviceVolume = getDeviceVolume();
        int i2 = getDeviceInfo().maxVolume;
        if (i2 == 0 || deviceVolume + 1 <= i2) {
            PlayerInfo playerInfoCopyWithDeviceVolume = this.controllerInfo.playerInfo.copyWithDeviceVolume(deviceVolume + 1, isDeviceMuted());
            ControllerInfo controllerInfo = this.controllerInfo;
            updateStateMaskedControllerInfo(new ControllerInfo(playerInfoCopyWithDeviceVolume, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout, controllerInfo.sessionExtras, null), null, null);
        }
        this.controllerCompat.adjustVolume(1, i);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void decreaseDeviceVolume() {
        decreaseDeviceVolume(1);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void decreaseDeviceVolume(int i) {
        int deviceVolume = getDeviceVolume() - 1;
        if (deviceVolume >= getDeviceInfo().minVolume) {
            PlayerInfo playerInfoCopyWithDeviceVolume = this.controllerInfo.playerInfo.copyWithDeviceVolume(deviceVolume, isDeviceMuted());
            ControllerInfo controllerInfo = this.controllerInfo;
            updateStateMaskedControllerInfo(new ControllerInfo(playerInfoCopyWithDeviceVolume, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout, controllerInfo.sessionExtras, null), null, null);
        }
        this.controllerCompat.adjustVolume(-1, i);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setDeviceMuted(boolean z) {
        setDeviceMuted(z, 1);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setDeviceMuted(boolean z, int i) {
        if (Util.SDK_INT < 23) {
            Log.w("MCImplLegacy", "Session doesn't support setting mute state at API level less than 23");
            return;
        }
        if (z != isDeviceMuted()) {
            PlayerInfo playerInfoCopyWithDeviceVolume = this.controllerInfo.playerInfo.copyWithDeviceVolume(getDeviceVolume(), z);
            ControllerInfo controllerInfo = this.controllerInfo;
            updateStateMaskedControllerInfo(new ControllerInfo(playerInfoCopyWithDeviceVolume, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout, controllerInfo.sessionExtras, null), null, null);
        }
        this.controllerCompat.adjustVolume(z ? -100 : 100, i);
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
        Log.w("MCImplLegacy", "Legacy session doesn't support setting audio attributes remotely");
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public void setPlayWhenReady(boolean z) {
        PlayerInfo playerInfo = this.controllerInfo.playerInfo;
        if (playerInfo.playWhenReady == z) {
            return;
        }
        this.currentPositionMs = MediaUtils.getUpdatedCurrentPositionMs(playerInfo, this.currentPositionMs, this.lastSetPlayWhenReadyCalledTimeMs, getInstance().getTimeDiffMs());
        this.lastSetPlayWhenReadyCalledTimeMs = SystemClock.elapsedRealtime();
        PlayerInfo playerInfoCopyWithPlayWhenReady = this.controllerInfo.playerInfo.copyWithPlayWhenReady(z, 1, 0);
        ControllerInfo controllerInfo = this.controllerInfo;
        updateStateMaskedControllerInfo(new ControllerInfo(playerInfoCopyWithPlayWhenReady, controllerInfo.availableSessionCommands, controllerInfo.availablePlayerCommands, controllerInfo.customLayout, controllerInfo.sessionExtras, null), null, null);
        if (isPrepared() && hasMedia()) {
            if (z) {
                this.controllerCompat.getTransportControls().play();
            } else {
                this.controllerCompat.getTransportControls().pause();
            }
        }
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean getPlayWhenReady() {
        return this.controllerInfo.playerInfo.playWhenReady;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public int getPlaybackState() {
        return this.controllerInfo.playerInfo.playbackState;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public boolean isPlaying() {
        return this.controllerInfo.playerInfo.isPlaying;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public MediaMetadata getMediaMetadata() {
        MediaItem currentMediaItem = this.controllerInfo.playerInfo.getCurrentMediaItem();
        return currentMediaItem == null ? MediaMetadata.EMPTY : currentMediaItem.mediaMetadata;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public Player.Commands getAvailableCommands() {
        return this.controllerInfo.availablePlayerCommands;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public Tracks getCurrentTracks() {
        return Tracks.EMPTY;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public TrackSelectionParameters getTrackSelectionParameters() {
        return TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT;
    }

    @Override // androidx.media3.session.MediaController.MediaControllerImpl
    public SessionCommands getAvailableSessionCommands() {
        return this.controllerInfo.availableSessionCommands;
    }

    public Context getContext() {
        return this.context;
    }

    public MediaBrowserCompat getBrowserCompat() {
        return this.browserCompat;
    }

    void onConnected() {
        if (this.released || this.connected) {
            return;
        }
        this.connected = true;
        handleNewLegacyParameters(true, new LegacyPlayerInfo(this.controllerCompat.getPlaybackInfo(), convertToSafePlaybackStateCompat(this.controllerCompat.getPlaybackState()), this.controllerCompat.getMetadata(), convertToNonNullQueueItemList(this.controllerCompat.getQueue()), this.controllerCompat.getQueueTitle(), this.controllerCompat.getRepeatMode(), this.controllerCompat.getShuffleMode(), this.controllerCompat.getExtras()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectToSession(final MediaSessionCompat.Token token) {
        getInstance().runOnApplicationLooper(new Runnable() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$connectToSession$1(token);
            }
        });
        getInstance().applicationHandler.post(new Runnable() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$connectToSession$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$connectToSession$1(MediaSessionCompat.Token token) {
        MediaControllerCompat mediaControllerCompat = new MediaControllerCompat(this.context, token);
        this.controllerCompat = mediaControllerCompat;
        mediaControllerCompat.registerCallback(this.controllerCompatCallback, getInstance().applicationHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$connectToSession$2() {
        if (this.controllerCompat.isSessionReady()) {
            return;
        }
        onConnected();
    }

    private void connectToService() {
        getInstance().runOnApplicationLooper(new Runnable() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$connectToService$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$connectToService$3() {
        MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(this.context, this.token.getComponentName(), new ConnectionCallback(), null);
        this.browserCompat = mediaBrowserCompat;
        mediaBrowserCompat.connect();
    }

    private boolean isPrepared() {
        return this.controllerInfo.playerInfo.playbackState != 1;
    }

    private boolean hasMedia() {
        return !this.controllerInfo.playerInfo.timeline.isEmpty();
    }

    private void initializeLegacyPlaylist() {
        Timeline.Window window = new Timeline.Window();
        Assertions.checkState(isPrepared() && hasMedia());
        PlayerInfo playerInfo = this.controllerInfo.playerInfo;
        QueueTimeline queueTimeline = (QueueTimeline) playerInfo.timeline;
        int i = playerInfo.sessionPositionInfo.positionInfo.mediaItemIndex;
        MediaItem mediaItem = queueTimeline.getWindow(i, window).mediaItem;
        if (queueTimeline.getQueueId(i) != -1) {
            if (this.controllerInfo.playerInfo.playWhenReady) {
                this.controllerCompat.getTransportControls().play();
            } else {
                this.controllerCompat.getTransportControls().prepare();
            }
        } else {
            MediaItem.RequestMetadata requestMetadata = mediaItem.requestMetadata;
            if (requestMetadata.mediaUri != null) {
                if (this.controllerInfo.playerInfo.playWhenReady) {
                    MediaControllerCompat.TransportControls transportControls = this.controllerCompat.getTransportControls();
                    MediaItem.RequestMetadata requestMetadata2 = mediaItem.requestMetadata;
                    transportControls.playFromUri(requestMetadata2.mediaUri, getOrEmptyBundle(requestMetadata2.extras));
                } else {
                    MediaControllerCompat.TransportControls transportControls2 = this.controllerCompat.getTransportControls();
                    MediaItem.RequestMetadata requestMetadata3 = mediaItem.requestMetadata;
                    transportControls2.prepareFromUri(requestMetadata3.mediaUri, getOrEmptyBundle(requestMetadata3.extras));
                }
            } else if (requestMetadata.searchQuery != null) {
                if (this.controllerInfo.playerInfo.playWhenReady) {
                    MediaControllerCompat.TransportControls transportControls3 = this.controllerCompat.getTransportControls();
                    MediaItem.RequestMetadata requestMetadata4 = mediaItem.requestMetadata;
                    transportControls3.playFromSearch(requestMetadata4.searchQuery, getOrEmptyBundle(requestMetadata4.extras));
                } else {
                    MediaControllerCompat.TransportControls transportControls4 = this.controllerCompat.getTransportControls();
                    MediaItem.RequestMetadata requestMetadata5 = mediaItem.requestMetadata;
                    transportControls4.prepareFromSearch(requestMetadata5.searchQuery, getOrEmptyBundle(requestMetadata5.extras));
                }
            } else if (this.controllerInfo.playerInfo.playWhenReady) {
                this.controllerCompat.getTransportControls().playFromMediaId(mediaItem.mediaId, getOrEmptyBundle(mediaItem.requestMetadata.extras));
            } else {
                this.controllerCompat.getTransportControls().prepareFromMediaId(mediaItem.mediaId, getOrEmptyBundle(mediaItem.requestMetadata.extras));
            }
        }
        if (this.controllerInfo.playerInfo.sessionPositionInfo.positionInfo.positionMs != 0) {
            this.controllerCompat.getTransportControls().seekTo(this.controllerInfo.playerInfo.sessionPositionInfo.positionInfo.positionMs);
        }
        if (getAvailableCommands().contains(20)) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < queueTimeline.getWindowCount(); i2++) {
                if (i2 != i && queueTimeline.getQueueId(i2) == -1) {
                    arrayList.add(queueTimeline.getWindow(i2, window).mediaItem);
                }
            }
            addQueueItems(arrayList, 0);
        }
    }

    private void addQueueItems(final List list, final int i) {
        final ArrayList arrayList = new ArrayList();
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        Runnable runnable = new Runnable() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addQueueItems$4(atomicInteger, list, arrayList, i);
            }
        };
        for (int i2 = 0; i2 < list.size(); i2++) {
            byte[] bArr = ((MediaItem) list.get(i2)).mediaMetadata.artworkData;
            if (bArr == null) {
                arrayList.add(null);
                runnable.run();
            } else {
                ListenableFuture<Bitmap> listenableFutureDecodeBitmap = this.bitmapLoader.decodeBitmap(bArr);
                arrayList.add(listenableFutureDecodeBitmap);
                Handler handler = getInstance().applicationHandler;
                Objects.requireNonNull(handler);
                listenableFutureDecodeBitmap.addListener(runnable, new ConcurrencyHelpers$$ExternalSyntheticLambda0(handler));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addQueueItems$4(AtomicInteger atomicInteger, List list, List list2, int i) {
        if (atomicInteger.incrementAndGet() == list.size()) {
            handleBitmapFuturesAllCompletedAndAddQueueItems(list2, list, i);
        }
    }

    private void handleBitmapFuturesAllCompletedAndAddQueueItems(List list, List list2, int i) {
        Bitmap bitmap;
        for (int i2 = 0; i2 < list.size(); i2++) {
            ListenableFuture listenableFuture = (ListenableFuture) list.get(i2);
            if (listenableFuture != null) {
                try {
                    bitmap = (Bitmap) Futures.getDone(listenableFuture);
                } catch (CancellationException | ExecutionException e) {
                    Log.d("MCImplLegacy", "Failed to get bitmap", e);
                }
            } else {
                bitmap = null;
            }
            this.controllerCompat.addQueueItem(LegacyConversions.convertToMediaDescriptionCompat((MediaItem) list2.get(i2), bitmap), i + i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNewLegacyParameters(boolean z, LegacyPlayerInfo legacyPlayerInfo) {
        if (this.released || !this.connected) {
            return;
        }
        ControllerInfo controllerInfoBuildNewControllerInfo = buildNewControllerInfo(z, this.legacyPlayerInfo, this.controllerInfo, legacyPlayerInfo, this.controllerCompat.getPackageName(), this.controllerCompat.getFlags(), this.controllerCompat.isSessionReady(), this.controllerCompat.getRatingType(), getInstance().getTimeDiffMs(), getRoutingControllerId(this.controllerCompat), this.context);
        Pair pairCalculateDiscontinuityAndTransitionReason = calculateDiscontinuityAndTransitionReason(this.legacyPlayerInfo, this.controllerInfo, legacyPlayerInfo, controllerInfoBuildNewControllerInfo, getInstance().getTimeDiffMs());
        updateControllerInfo(z, legacyPlayerInfo, controllerInfoBuildNewControllerInfo, (Integer) pairCalculateDiscontinuityAndTransitionReason.first, (Integer) pairCalculateDiscontinuityAndTransitionReason.second);
    }

    private void updateStateMaskedControllerInfo(ControllerInfo controllerInfo, Integer num, Integer num2) {
        updateControllerInfo(false, this.legacyPlayerInfo, controllerInfo, num, num2);
    }

    private void updateControllerInfo(boolean z, LegacyPlayerInfo legacyPlayerInfo, final ControllerInfo controllerInfo, final Integer num, final Integer num2) {
        LegacyPlayerInfo legacyPlayerInfo2 = this.legacyPlayerInfo;
        final ControllerInfo controllerInfo2 = this.controllerInfo;
        if (legacyPlayerInfo2 != legacyPlayerInfo) {
            this.legacyPlayerInfo = new LegacyPlayerInfo(legacyPlayerInfo);
        }
        this.pendingLegacyPlayerInfo = this.legacyPlayerInfo;
        this.controllerInfo = controllerInfo;
        if (z) {
            getInstance().notifyAccepted();
            if (controllerInfo2.customLayout.equals(controllerInfo.customLayout)) {
                return;
            }
            getInstance().notifyControllerListener(new Consumer() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda6
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    this.f$0.lambda$updateControllerInfo$5(controllerInfo, (MediaController.Listener) obj);
                }
            });
            return;
        }
        if (!controllerInfo2.playerInfo.timeline.equals(controllerInfo.playerInfo.timeline)) {
            this.listeners.queueEvent(0, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda17
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$6(controllerInfo, (Player.Listener) obj);
                }
            });
        }
        if (!Util.areEqual(legacyPlayerInfo2.queueTitle, legacyPlayerInfo.queueTitle)) {
            this.listeners.queueEvent(15, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda19
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$7(controllerInfo, (Player.Listener) obj);
                }
            });
        }
        if (num != null) {
            this.listeners.queueEvent(11, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda20
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$8(controllerInfo2, controllerInfo, num, (Player.Listener) obj);
                }
            });
        }
        if (num2 != null) {
            this.listeners.queueEvent(1, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda21
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$9(controllerInfo, num2, (Player.Listener) obj);
                }
            });
        }
        if (!MediaUtils.areEqualError(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo.playbackStateCompat)) {
            final PlaybackException playbackExceptionConvertToPlaybackException = LegacyConversions.convertToPlaybackException(legacyPlayerInfo.playbackStateCompat);
            this.listeners.queueEvent(10, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda22
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    ((Player.Listener) obj).onPlayerErrorChanged(playbackExceptionConvertToPlaybackException);
                }
            });
            if (playbackExceptionConvertToPlaybackException != null) {
                this.listeners.queueEvent(10, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda23
                    @Override // androidx.media3.common.util.ListenerSet.Event
                    public final void invoke(Object obj) {
                        ((Player.Listener) obj).onPlayerError(playbackExceptionConvertToPlaybackException);
                    }
                });
            }
        }
        if (legacyPlayerInfo2.mediaMetadataCompat != legacyPlayerInfo.mediaMetadataCompat) {
            this.listeners.queueEvent(14, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda24
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    this.f$0.lambda$updateControllerInfo$12((Player.Listener) obj);
                }
            });
        }
        if (controllerInfo2.playerInfo.playbackState != controllerInfo.playerInfo.playbackState) {
            this.listeners.queueEvent(4, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda25
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$13(controllerInfo, (Player.Listener) obj);
                }
            });
        }
        if (controllerInfo2.playerInfo.playWhenReady != controllerInfo.playerInfo.playWhenReady) {
            this.listeners.queueEvent(5, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda26
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$14(controllerInfo, (Player.Listener) obj);
                }
            });
        }
        if (controllerInfo2.playerInfo.isPlaying != controllerInfo.playerInfo.isPlaying) {
            this.listeners.queueEvent(7, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda7
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$15(controllerInfo, (Player.Listener) obj);
                }
            });
        }
        if (!controllerInfo2.playerInfo.playbackParameters.equals(controllerInfo.playerInfo.playbackParameters)) {
            this.listeners.queueEvent(12, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda8
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$16(controllerInfo, (Player.Listener) obj);
                }
            });
        }
        if (controllerInfo2.playerInfo.repeatMode != controllerInfo.playerInfo.repeatMode) {
            this.listeners.queueEvent(8, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda9
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$17(controllerInfo, (Player.Listener) obj);
                }
            });
        }
        if (controllerInfo2.playerInfo.shuffleModeEnabled != controllerInfo.playerInfo.shuffleModeEnabled) {
            this.listeners.queueEvent(9, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda10
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$18(controllerInfo, (Player.Listener) obj);
                }
            });
        }
        if (!controllerInfo2.playerInfo.audioAttributes.equals(controllerInfo.playerInfo.audioAttributes)) {
            this.listeners.queueEvent(20, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda11
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$19(controllerInfo, (Player.Listener) obj);
                }
            });
        }
        if (!controllerInfo2.playerInfo.deviceInfo.equals(controllerInfo.playerInfo.deviceInfo)) {
            this.listeners.queueEvent(29, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda12
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$20(controllerInfo, (Player.Listener) obj);
                }
            });
        }
        PlayerInfo playerInfo = controllerInfo2.playerInfo;
        int i = playerInfo.deviceVolume;
        PlayerInfo playerInfo2 = controllerInfo.playerInfo;
        if (i != playerInfo2.deviceVolume || playerInfo.deviceMuted != playerInfo2.deviceMuted) {
            this.listeners.queueEvent(30, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda13
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$21(controllerInfo, (Player.Listener) obj);
                }
            });
        }
        if (!controllerInfo2.availablePlayerCommands.equals(controllerInfo.availablePlayerCommands)) {
            this.listeners.queueEvent(13, new ListenerSet.Event() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda14
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    MediaControllerImplLegacy.lambda$updateControllerInfo$22(controllerInfo, (Player.Listener) obj);
                }
            });
        }
        if (!controllerInfo2.availableSessionCommands.equals(controllerInfo.availableSessionCommands)) {
            getInstance().notifyControllerListener(new Consumer() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda15
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    this.f$0.lambda$updateControllerInfo$23(controllerInfo, (MediaController.Listener) obj);
                }
            });
        }
        if (!controllerInfo2.customLayout.equals(controllerInfo.customLayout)) {
            getInstance().notifyControllerListener(new Consumer() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda16
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    this.f$0.lambda$updateControllerInfo$24(controllerInfo, (MediaController.Listener) obj);
                }
            });
        }
        if (controllerInfo.sessionError != null) {
            getInstance().notifyControllerListener(new Consumer() { // from class: androidx.media3.session.MediaControllerImplLegacy$$ExternalSyntheticLambda18
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    this.f$0.lambda$updateControllerInfo$25(controllerInfo, (MediaController.Listener) obj);
                }
            });
        }
        this.listeners.flushEvents();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateControllerInfo$5(ControllerInfo controllerInfo, MediaController.Listener listener) {
        ignoreFuture(listener.onSetCustomLayout(getInstance(), controllerInfo.customLayout));
        listener.onCustomLayoutChanged(getInstance(), controllerInfo.customLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateControllerInfo$6(ControllerInfo controllerInfo, Player.Listener listener) {
        PlayerInfo playerInfo = controllerInfo.playerInfo;
        listener.onTimelineChanged(playerInfo.timeline, playerInfo.timelineChangeReason);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateControllerInfo$7(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onPlaylistMetadataChanged(controllerInfo.playerInfo.playlistMetadata);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateControllerInfo$8(ControllerInfo controllerInfo, ControllerInfo controllerInfo2, Integer num, Player.Listener listener) {
        listener.onPositionDiscontinuity(controllerInfo.playerInfo.sessionPositionInfo.positionInfo, controllerInfo2.playerInfo.sessionPositionInfo.positionInfo, num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateControllerInfo$9(ControllerInfo controllerInfo, Integer num, Player.Listener listener) {
        listener.onMediaItemTransition(controllerInfo.playerInfo.getCurrentMediaItem(), num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateControllerInfo$12(Player.Listener listener) {
        listener.onMediaMetadataChanged(this.controllerInfo.playerInfo.mediaMetadata);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateControllerInfo$13(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onPlaybackStateChanged(controllerInfo.playerInfo.playbackState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateControllerInfo$14(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onPlayWhenReadyChanged(controllerInfo.playerInfo.playWhenReady, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateControllerInfo$15(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onIsPlayingChanged(controllerInfo.playerInfo.isPlaying);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateControllerInfo$16(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onPlaybackParametersChanged(controllerInfo.playerInfo.playbackParameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateControllerInfo$17(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onRepeatModeChanged(controllerInfo.playerInfo.repeatMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateControllerInfo$18(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onShuffleModeEnabledChanged(controllerInfo.playerInfo.shuffleModeEnabled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateControllerInfo$19(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onAudioAttributesChanged(controllerInfo.playerInfo.audioAttributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateControllerInfo$20(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onDeviceInfoChanged(controllerInfo.playerInfo.deviceInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateControllerInfo$21(ControllerInfo controllerInfo, Player.Listener listener) {
        PlayerInfo playerInfo = controllerInfo.playerInfo;
        listener.onDeviceVolumeChanged(playerInfo.deviceVolume, playerInfo.deviceMuted);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateControllerInfo$22(ControllerInfo controllerInfo, Player.Listener listener) {
        listener.onAvailableCommandsChanged(controllerInfo.availablePlayerCommands);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateControllerInfo$23(ControllerInfo controllerInfo, MediaController.Listener listener) {
        listener.onAvailableSessionCommandsChanged(getInstance(), controllerInfo.availableSessionCommands);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateControllerInfo$24(ControllerInfo controllerInfo, MediaController.Listener listener) {
        ignoreFuture(listener.onSetCustomLayout(getInstance(), controllerInfo.customLayout));
        listener.onCustomLayoutChanged(getInstance(), controllerInfo.customLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateControllerInfo$25(ControllerInfo controllerInfo, MediaController.Listener listener) {
        listener.onError(getInstance(), controllerInfo.sessionError);
    }

    private static String getRoutingControllerId(MediaControllerCompat mediaControllerCompat) {
        MediaController.PlaybackInfo playbackInfo;
        if (Util.SDK_INT >= 30 && (playbackInfo = ((android.media.session.MediaController) mediaControllerCompat.getMediaController()).getPlaybackInfo()) != null) {
            return playbackInfo.getVolumeControlId();
        }
        return null;
    }

    private class ConnectionCallback extends MediaBrowserCompat.ConnectionCallback {
        private ConnectionCallback() {
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            MediaBrowserCompat browserCompat = MediaControllerImplLegacy.this.getBrowserCompat();
            if (browserCompat != null) {
                MediaControllerImplLegacy.this.connectToSession(browserCompat.getSessionToken());
            }
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
            MediaControllerImplLegacy.this.getInstance().release();
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            MediaControllerImplLegacy.this.getInstance().release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class ControllerCompatCallback extends MediaControllerCompat.Callback {
        private final Handler pendingChangesHandler;

        public ControllerCompatCallback(Looper looper) {
            this.pendingChangesHandler = new Handler(looper, new Handler.Callback() { // from class: androidx.media3.session.MediaControllerImplLegacy$ControllerCompatCallback$$ExternalSyntheticLambda1
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    return this.f$0.lambda$new$0(message);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$new$0(Message message) {
            if (message.what == 1) {
                MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                mediaControllerImplLegacy.handleNewLegacyParameters(false, mediaControllerImplLegacy.pendingLegacyPlayerInfo);
            }
            return true;
        }

        public void release() {
            this.pendingChangesHandler.removeCallbacksAndMessages(null);
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public void onSessionReady() {
            if (!MediaControllerImplLegacy.this.connected) {
                MediaControllerImplLegacy.this.onConnected();
                return;
            }
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            mediaControllerImplLegacy.pendingLegacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo.copyWithExtraBinderGetters(MediaControllerImplLegacy.convertToSafePlaybackStateCompat(MediaControllerImplLegacy.this.controllerCompat.getPlaybackState()), MediaControllerImplLegacy.this.controllerCompat.getRepeatMode(), MediaControllerImplLegacy.this.controllerCompat.getShuffleMode());
            onCaptioningEnabledChanged(MediaControllerImplLegacy.this.controllerCompat.isCaptioningEnabled());
            this.pendingChangesHandler.removeMessages(1);
            MediaControllerImplLegacy mediaControllerImplLegacy2 = MediaControllerImplLegacy.this;
            mediaControllerImplLegacy2.handleNewLegacyParameters(false, mediaControllerImplLegacy2.pendingLegacyPlayerInfo);
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public void onSessionDestroyed() {
            MediaControllerImplLegacy.this.getInstance().release();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public void onSessionEvent(final String str, final Bundle bundle) {
            if (str == null) {
                return;
            }
            MediaControllerImplLegacy.this.getInstance().notifyControllerListener(new Consumer() { // from class: androidx.media3.session.MediaControllerImplLegacy$ControllerCompatCallback$$ExternalSyntheticLambda3
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    this.f$0.lambda$onSessionEvent$1(str, bundle, (MediaController.Listener) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSessionEvent$1(String str, Bundle bundle, MediaController.Listener listener) {
            MediaController mediaControllerImplLegacy = MediaControllerImplLegacy.this.getInstance();
            Bundle bundle2 = Bundle.EMPTY;
            SessionCommand sessionCommand = new SessionCommand(str, bundle2);
            if (bundle == null) {
                bundle = bundle2;
            }
            MediaControllerImplLegacy.ignoreFuture(listener.onCustomCommand(mediaControllerImplLegacy, sessionCommand, bundle));
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            mediaControllerImplLegacy.pendingLegacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo.copyWithPlaybackStateCompat(MediaControllerImplLegacy.convertToSafePlaybackStateCompat(playbackStateCompat));
            startWaitingForPendingChanges();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            mediaControllerImplLegacy.pendingLegacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo.copyWithMediaMetadataCompat(mediaMetadataCompat);
            startWaitingForPendingChanges();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public void onQueueChanged(List list) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            mediaControllerImplLegacy.pendingLegacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo.copyWithQueue(MediaControllerImplLegacy.convertToNonNullQueueItemList(list));
            startWaitingForPendingChanges();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public void onQueueTitleChanged(CharSequence charSequence) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            mediaControllerImplLegacy.pendingLegacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo.copyWithQueueTitle(charSequence);
            startWaitingForPendingChanges();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public void onExtrasChanged(final Bundle bundle) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            mediaControllerImplLegacy.controllerInfo = new ControllerInfo(mediaControllerImplLegacy.controllerInfo.playerInfo, MediaControllerImplLegacy.this.controllerInfo.availableSessionCommands, MediaControllerImplLegacy.this.controllerInfo.availablePlayerCommands, MediaControllerImplLegacy.this.controllerInfo.customLayout, bundle, null);
            MediaControllerImplLegacy.this.getInstance().notifyControllerListener(new Consumer() { // from class: androidx.media3.session.MediaControllerImplLegacy$ControllerCompatCallback$$ExternalSyntheticLambda2
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    this.f$0.lambda$onExtrasChanged$2(bundle, (MediaController.Listener) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onExtrasChanged$2(Bundle bundle, MediaController.Listener listener) {
            listener.onExtrasChanged(MediaControllerImplLegacy.this.getInstance(), bundle);
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public void onAudioInfoChanged(MediaControllerCompat.PlaybackInfo playbackInfo) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            mediaControllerImplLegacy.pendingLegacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo.copyWithPlaybackInfoCompat(playbackInfo);
            startWaitingForPendingChanges();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public void onCaptioningEnabledChanged(final boolean z) {
            MediaControllerImplLegacy.this.getInstance().notifyControllerListener(new Consumer() { // from class: androidx.media3.session.MediaControllerImplLegacy$ControllerCompatCallback$$ExternalSyntheticLambda0
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    this.f$0.lambda$onCaptioningEnabledChanged$3(z, (MediaController.Listener) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCaptioningEnabledChanged$3(boolean z, MediaController.Listener listener) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("androidx.media3.session.ARGUMENT_CAPTIONING_ENABLED", z);
            MediaControllerImplLegacy.ignoreFuture(listener.onCustomCommand(MediaControllerImplLegacy.this.getInstance(), new SessionCommand("androidx.media3.session.SESSION_COMMAND_ON_CAPTIONING_ENABLED_CHANGED", Bundle.EMPTY), bundle));
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public void onRepeatModeChanged(int i) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            mediaControllerImplLegacy.pendingLegacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo.copyWithRepeatMode(i);
            startWaitingForPendingChanges();
        }

        @Override // androidx.media3.session.legacy.MediaControllerCompat.Callback
        public void onShuffleModeChanged(int i) {
            MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
            mediaControllerImplLegacy.pendingLegacyPlayerInfo = mediaControllerImplLegacy.pendingLegacyPlayerInfo.copyWithShuffleMode(i);
            startWaitingForPendingChanges();
        }

        private void startWaitingForPendingChanges() {
            if (this.pendingChangesHandler.hasMessages(1)) {
                return;
            }
            this.pendingChangesHandler.sendEmptyMessageDelayed(1, 500L);
        }
    }

    private static ControllerInfo buildNewControllerInfo(boolean z, LegacyPlayerInfo legacyPlayerInfo, ControllerInfo controllerInfo, LegacyPlayerInfo legacyPlayerInfo2, String str, long j, boolean z2, int i, long j2, String str2, Context context) {
        QueueTimeline queueTimelineCopy;
        int iFindQueueItemIndex;
        MediaMetadata mediaMetadataConvertToMediaMetadata;
        MediaMetadata mediaMetadata;
        MediaMetadata mediaMetadataConvertToMediaMetadata2;
        SessionCommands sessionCommandsConvertToSessionCommands;
        ImmutableList immutableListConvertToCustomLayout;
        int iConvertToPlaybackState;
        List list = legacyPlayerInfo.queue;
        List list2 = legacyPlayerInfo2.queue;
        boolean z3 = list != list2;
        if (z3) {
            queueTimelineCopy = QueueTimeline.create(list2);
        } else {
            queueTimelineCopy = ((QueueTimeline) controllerInfo.playerInfo.timeline).copy();
        }
        boolean z4 = legacyPlayerInfo.mediaMetadataCompat != legacyPlayerInfo2.mediaMetadataCompat || z;
        long activeQueueId = getActiveQueueId(legacyPlayerInfo.playbackStateCompat);
        long activeQueueId2 = getActiveQueueId(legacyPlayerInfo2.playbackStateCompat);
        boolean z5 = activeQueueId != activeQueueId2 || z;
        long jConvertToDurationMs = LegacyConversions.convertToDurationMs(legacyPlayerInfo2.mediaMetadataCompat);
        if (z4 || z5 || z3) {
            iFindQueueItemIndex = findQueueItemIndex(legacyPlayerInfo2.queue, activeQueueId2);
            MediaMetadataCompat mediaMetadataCompat = legacyPlayerInfo2.mediaMetadataCompat;
            boolean z6 = mediaMetadataCompat != null;
            if (z6 && z4) {
                mediaMetadataConvertToMediaMetadata = LegacyConversions.convertToMediaMetadata(mediaMetadataCompat, i);
            } else if (z6 || !z5) {
                mediaMetadataConvertToMediaMetadata = controllerInfo.playerInfo.mediaMetadata;
            } else if (iFindQueueItemIndex == -1) {
                mediaMetadataConvertToMediaMetadata = MediaMetadata.EMPTY;
            } else {
                mediaMetadataConvertToMediaMetadata = LegacyConversions.convertToMediaMetadata(((MediaSessionCompat.QueueItem) legacyPlayerInfo2.queue.get(iFindQueueItemIndex)).getDescription(), i);
            }
            if (iFindQueueItemIndex != -1 || !z4) {
                if (iFindQueueItemIndex != -1) {
                    queueTimelineCopy = queueTimelineCopy.copyWithClearedFakeMediaItem();
                    if (z6) {
                        queueTimelineCopy = queueTimelineCopy.copyWithNewMediaItem(iFindQueueItemIndex, LegacyConversions.convertToMediaItem(((MediaItem) Assertions.checkNotNull(queueTimelineCopy.getMediaItemAt(iFindQueueItemIndex))).mediaId, legacyPlayerInfo2.mediaMetadataCompat, i), jConvertToDurationMs);
                    }
                } else {
                    iFindQueueItemIndex = 0;
                }
                mediaMetadata = mediaMetadataConvertToMediaMetadata;
            } else if (z6) {
                Log.w("MCImplLegacy", "Adding a fake MediaItem at the end of the list because there's no QueueItem with the active queue id and current Timeline should have currently playing MediaItem.");
                queueTimelineCopy = queueTimelineCopy.copyWithFakeMediaItem(LegacyConversions.convertToMediaItem(legacyPlayerInfo2.mediaMetadataCompat, i), jConvertToDurationMs);
                iFindQueueItemIndex = queueTimelineCopy.getWindowCount() - 1;
                mediaMetadata = mediaMetadataConvertToMediaMetadata;
            } else {
                queueTimelineCopy = queueTimelineCopy.copyWithClearedFakeMediaItem();
                iFindQueueItemIndex = 0;
                mediaMetadata = mediaMetadataConvertToMediaMetadata;
            }
        } else {
            PlayerInfo playerInfo = controllerInfo.playerInfo;
            iFindQueueItemIndex = playerInfo.sessionPositionInfo.positionInfo.mediaItemIndex;
            mediaMetadata = playerInfo.mediaMetadata;
        }
        int i2 = iFindQueueItemIndex;
        QueueTimeline queueTimeline = queueTimelineCopy;
        CharSequence charSequence = legacyPlayerInfo.queueTitle;
        CharSequence charSequence2 = legacyPlayerInfo2.queueTitle;
        if (charSequence == charSequence2) {
            mediaMetadataConvertToMediaMetadata2 = controllerInfo.playerInfo.playlistMetadata;
        } else {
            mediaMetadataConvertToMediaMetadata2 = LegacyConversions.convertToMediaMetadata(charSequence2);
        }
        MediaMetadata mediaMetadata2 = mediaMetadataConvertToMediaMetadata2;
        int iConvertToRepeatMode = LegacyConversions.convertToRepeatMode(legacyPlayerInfo2.repeatMode);
        boolean zConvertToShuffleModeEnabled = LegacyConversions.convertToShuffleModeEnabled(legacyPlayerInfo2.shuffleMode);
        PlaybackStateCompat playbackStateCompat = legacyPlayerInfo.playbackStateCompat;
        PlaybackStateCompat playbackStateCompat2 = legacyPlayerInfo2.playbackStateCompat;
        if (playbackStateCompat != playbackStateCompat2) {
            sessionCommandsConvertToSessionCommands = LegacyConversions.convertToSessionCommands(playbackStateCompat2, z2);
            immutableListConvertToCustomLayout = LegacyConversions.convertToCustomLayout(legacyPlayerInfo2.playbackStateCompat);
        } else {
            sessionCommandsConvertToSessionCommands = controllerInfo.availableSessionCommands;
            immutableListConvertToCustomLayout = controllerInfo.customLayout;
        }
        SessionCommands sessionCommands = sessionCommandsConvertToSessionCommands;
        ImmutableList immutableList = immutableListConvertToCustomLayout;
        MediaControllerCompat.PlaybackInfo playbackInfo = legacyPlayerInfo2.playbackInfoCompat;
        Player.Commands commandsConvertToPlayerCommands = LegacyConversions.convertToPlayerCommands(legacyPlayerInfo2.playbackStateCompat, playbackInfo != null ? playbackInfo.getVolumeControl() : 0, j, z2);
        PlaybackException playbackExceptionConvertToPlaybackException = LegacyConversions.convertToPlaybackException(legacyPlayerInfo2.playbackStateCompat);
        SessionError sessionErrorConvertToSessionError = LegacyConversions.convertToSessionError(legacyPlayerInfo2.playbackStateCompat, context);
        long jConvertToCurrentPositionMs = LegacyConversions.convertToCurrentPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j2);
        long jConvertToBufferedPositionMs = LegacyConversions.convertToBufferedPositionMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j2);
        int iConvertToBufferedPercentage = LegacyConversions.convertToBufferedPercentage(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j2);
        long jConvertToTotalBufferedDurationMs = LegacyConversions.convertToTotalBufferedDurationMs(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j2);
        boolean zConvertToIsPlayingAd = LegacyConversions.convertToIsPlayingAd(legacyPlayerInfo2.mediaMetadataCompat);
        PlaybackParameters playbackParametersConvertToPlaybackParameters = LegacyConversions.convertToPlaybackParameters(legacyPlayerInfo2.playbackStateCompat);
        AudioAttributes audioAttributesConvertToAudioAttributes = LegacyConversions.convertToAudioAttributes(legacyPlayerInfo2.playbackInfoCompat);
        boolean zConvertToPlayWhenReady = LegacyConversions.convertToPlayWhenReady(legacyPlayerInfo2.playbackStateCompat);
        try {
            iConvertToPlaybackState = LegacyConversions.convertToPlaybackState(legacyPlayerInfo2.playbackStateCompat, legacyPlayerInfo2.mediaMetadataCompat, j2);
        } catch (LegacyConversions.ConversionException unused) {
            Log.e("MCImplLegacy", String.format("Received invalid playback state %s from package %s. Keeping the previous state.", Integer.valueOf(legacyPlayerInfo2.playbackStateCompat.getState()), str));
            iConvertToPlaybackState = controllerInfo.playerInfo.playbackState;
        }
        int i3 = iConvertToPlaybackState;
        boolean zConvertToIsPlaying = LegacyConversions.convertToIsPlaying(legacyPlayerInfo2.playbackStateCompat);
        DeviceInfo deviceInfoConvertToDeviceInfo = LegacyConversions.convertToDeviceInfo(legacyPlayerInfo2.playbackInfoCompat, str2);
        int iConvertToDeviceVolume = LegacyConversions.convertToDeviceVolume(legacyPlayerInfo2.playbackInfoCompat);
        boolean zConvertToIsDeviceMuted = LegacyConversions.convertToIsDeviceMuted(legacyPlayerInfo2.playbackInfoCompat);
        PlayerInfo playerInfo2 = controllerInfo.playerInfo;
        return createControllerInfo(queueTimeline, mediaMetadata, i2, mediaMetadata2, iConvertToRepeatMode, zConvertToShuffleModeEnabled, sessionCommands, commandsConvertToPlayerCommands, immutableList, legacyPlayerInfo2.sessionExtras, playbackExceptionConvertToPlaybackException, sessionErrorConvertToSessionError, jConvertToDurationMs, jConvertToCurrentPositionMs, jConvertToBufferedPositionMs, iConvertToBufferedPercentage, jConvertToTotalBufferedDurationMs, zConvertToIsPlayingAd, playbackParametersConvertToPlaybackParameters, audioAttributesConvertToAudioAttributes, zConvertToPlayWhenReady, i3, zConvertToIsPlaying, deviceInfoConvertToDeviceInfo, iConvertToDeviceVolume, zConvertToIsDeviceMuted, playerInfo2.seekBackIncrementMs, playerInfo2.seekForwardIncrementMs, playerInfo2.maxSeekToPreviousPositionMs);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.util.Pair calculateDiscontinuityAndTransitionReason(androidx.media3.session.MediaControllerImplLegacy.LegacyPlayerInfo r8, androidx.media3.session.MediaControllerImplLegacy.ControllerInfo r9, androidx.media3.session.MediaControllerImplLegacy.LegacyPlayerInfo r10, androidx.media3.session.MediaControllerImplLegacy.ControllerInfo r11, long r12) {
        /*
            androidx.media3.session.PlayerInfo r0 = r9.playerInfo
            androidx.media3.common.Timeline r0 = r0.timeline
            boolean r0 = r0.isEmpty()
            androidx.media3.session.PlayerInfo r1 = r11.playerInfo
            androidx.media3.common.Timeline r1 = r1.timeline
            boolean r1 = r1.isEmpty()
            r2 = 0
            if (r0 == 0) goto L18
            if (r1 == 0) goto L18
        L15:
            r8 = r2
            goto L98
        L18:
            r3 = 3
            r4 = 0
            if (r0 == 0) goto L28
            if (r1 != 0) goto L28
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            goto L98
        L28:
            androidx.media3.session.PlayerInfo r9 = r9.playerInfo
            androidx.media3.common.MediaItem r9 = r9.getCurrentMediaItem()
            java.lang.Object r9 = androidx.media3.common.util.Assertions.checkStateNotNull(r9)
            androidx.media3.common.MediaItem r9 = (androidx.media3.common.MediaItem) r9
            androidx.media3.session.PlayerInfo r0 = r11.playerInfo
            androidx.media3.common.Timeline r0 = r0.timeline
            androidx.media3.session.QueueTimeline r0 = (androidx.media3.session.QueueTimeline) r0
            boolean r0 = r0.contains(r9)
            if (r0 != 0) goto L4a
            r8 = 4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            goto L98
        L4a:
            androidx.media3.session.PlayerInfo r0 = r11.playerInfo
            androidx.media3.common.MediaItem r0 = r0.getCurrentMediaItem()
            boolean r9 = r9.equals(r0)
            r0 = 1
            if (r9 == 0) goto L90
            androidx.media3.session.legacy.PlaybackStateCompat r9 = r8.playbackStateCompat
            androidx.media3.session.legacy.MediaMetadataCompat r8 = r8.mediaMetadataCompat
            long r8 = androidx.media3.session.LegacyConversions.convertToCurrentPositionMs(r9, r8, r12)
            androidx.media3.session.legacy.PlaybackStateCompat r1 = r10.playbackStateCompat
            androidx.media3.session.legacy.MediaMetadataCompat r10 = r10.mediaMetadataCompat
            long r12 = androidx.media3.session.LegacyConversions.convertToCurrentPositionMs(r1, r10, r12)
            r5 = 0
            int r10 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r10 != 0) goto L7c
            androidx.media3.session.PlayerInfo r10 = r11.playerInfo
            int r10 = r10.repeatMode
            if (r10 != r0) goto L7c
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
            goto L98
        L7c:
            long r8 = r8 - r12
            long r8 = java.lang.Math.abs(r8)
            r10 = 100
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 <= 0) goto L15
            r8 = 5
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r7 = r2
            r2 = r8
            r8 = r7
            goto L98
        L90:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
        L98:
            android.util.Pair r8 = android.util.Pair.create(r2, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaControllerImplLegacy.calculateDiscontinuityAndTransitionReason(androidx.media3.session.MediaControllerImplLegacy$LegacyPlayerInfo, androidx.media3.session.MediaControllerImplLegacy$ControllerInfo, androidx.media3.session.MediaControllerImplLegacy$LegacyPlayerInfo, androidx.media3.session.MediaControllerImplLegacy$ControllerInfo, long):android.util.Pair");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List convertToNonNullQueueItemList(List list) {
        return list == null ? Collections.emptyList() : MediaUtils.removeNullElements(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PlaybackStateCompat convertToSafePlaybackStateCompat(PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat == null) {
            return null;
        }
        if (playbackStateCompat.getPlaybackSpeed() > BitmapDescriptorFactory.HUE_RED) {
            return playbackStateCompat;
        }
        Log.w("MCImplLegacy", "Adjusting playback speed to 1.0f because negative playback speed isn't supported.");
        return new PlaybackStateCompat.Builder(playbackStateCompat).setState(playbackStateCompat.getState(), playbackStateCompat.getPosition(), 1.0f, playbackStateCompat.getLastPositionUpdateTime()).build();
    }

    private static Bundle getOrEmptyBundle(Bundle bundle) {
        return bundle == null ? Bundle.EMPTY : bundle;
    }

    private static long getActiveQueueId(PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat == null) {
            return -1L;
        }
        return playbackStateCompat.getActiveQueueItemId();
    }

    private static int findQueueItemIndex(List list, long j) {
        if (list != null && j != -1) {
            for (int i = 0; i < list.size(); i++) {
                if (((MediaSessionCompat.QueueItem) list.get(i)).getQueueId() == j) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static ControllerInfo createControllerInfo(QueueTimeline queueTimeline, MediaMetadata mediaMetadata, int i, MediaMetadata mediaMetadata2, int i2, boolean z, SessionCommands sessionCommands, Player.Commands commands, ImmutableList immutableList, Bundle bundle, PlaybackException playbackException, SessionError sessionError, long j, long j2, long j3, int i3, long j4, boolean z2, PlaybackParameters playbackParameters, AudioAttributes audioAttributes, boolean z3, int i4, boolean z4, DeviceInfo deviceInfo, int i5, boolean z5, long j5, long j6, long j7) {
        SessionPositionInfo sessionPositionInfo = new SessionPositionInfo(createPositionInfo(i, queueTimeline.getMediaItemAt(i), j2, z2), z2, SystemClock.elapsedRealtime(), j, j3, i3, j4, C.TIME_UNSET, j, j3);
        Player.PositionInfo positionInfo = SessionPositionInfo.DEFAULT_POSITION_INFO;
        return new ControllerInfo(new PlayerInfo(playbackException, 0, sessionPositionInfo, positionInfo, positionInfo, 0, playbackParameters, i2, z, VideoSize.UNKNOWN, queueTimeline, 0, mediaMetadata2, 1.0f, audioAttributes, CueGroup.EMPTY_TIME_ZERO, deviceInfo, i5, z5, z3, 1, 0, i4, z4, false, mediaMetadata, j5, j6, j7, Tracks.EMPTY, TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT), sessionCommands, commands, immutableList, bundle, sessionError);
    }

    private static Player.PositionInfo createPositionInfo(int i, MediaItem mediaItem, long j, boolean z) {
        return new Player.PositionInfo(null, i, mediaItem, null, i, j, j, z ? 0 : -1, z ? 0 : -1);
    }

    private static SessionPositionInfo createSessionPositionInfo(Player.PositionInfo positionInfo, boolean z, long j, long j2, int i, long j3) {
        return new SessionPositionInfo(positionInfo, z, SystemClock.elapsedRealtime(), j, j2, i, j3, C.TIME_UNSET, j, j2);
    }

    private static final class LegacyPlayerInfo {
        public final MediaMetadataCompat mediaMetadataCompat;
        public final MediaControllerCompat.PlaybackInfo playbackInfoCompat;
        public final PlaybackStateCompat playbackStateCompat;
        public final List queue;
        public final CharSequence queueTitle;
        public final int repeatMode;
        public final Bundle sessionExtras;
        public final int shuffleMode;

        public LegacyPlayerInfo() {
            this.playbackInfoCompat = null;
            this.playbackStateCompat = null;
            this.mediaMetadataCompat = null;
            this.queue = Collections.emptyList();
            this.queueTitle = null;
            this.repeatMode = 0;
            this.shuffleMode = 0;
            this.sessionExtras = Bundle.EMPTY;
        }

        public LegacyPlayerInfo(MediaControllerCompat.PlaybackInfo playbackInfo, PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat, List list, CharSequence charSequence, int i, int i2, Bundle bundle) {
            this.playbackInfoCompat = playbackInfo;
            this.playbackStateCompat = playbackStateCompat;
            this.mediaMetadataCompat = mediaMetadataCompat;
            this.queue = (List) Assertions.checkNotNull(list);
            this.queueTitle = charSequence;
            this.repeatMode = i;
            this.shuffleMode = i2;
            this.sessionExtras = bundle == null ? Bundle.EMPTY : bundle;
        }

        public LegacyPlayerInfo(LegacyPlayerInfo legacyPlayerInfo) {
            this.playbackInfoCompat = legacyPlayerInfo.playbackInfoCompat;
            this.playbackStateCompat = legacyPlayerInfo.playbackStateCompat;
            this.mediaMetadataCompat = legacyPlayerInfo.mediaMetadataCompat;
            this.queue = legacyPlayerInfo.queue;
            this.queueTitle = legacyPlayerInfo.queueTitle;
            this.repeatMode = legacyPlayerInfo.repeatMode;
            this.shuffleMode = legacyPlayerInfo.shuffleMode;
            this.sessionExtras = legacyPlayerInfo.sessionExtras;
        }

        public LegacyPlayerInfo copyWithExtraBinderGetters(PlaybackStateCompat playbackStateCompat, int i, int i2) {
            return new LegacyPlayerInfo(this.playbackInfoCompat, playbackStateCompat, this.mediaMetadataCompat, this.queue, this.queueTitle, i, i2, this.sessionExtras);
        }

        public LegacyPlayerInfo copyWithPlaybackStateCompat(PlaybackStateCompat playbackStateCompat) {
            return new LegacyPlayerInfo(this.playbackInfoCompat, playbackStateCompat, this.mediaMetadataCompat, this.queue, this.queueTitle, this.repeatMode, this.shuffleMode, this.sessionExtras);
        }

        public LegacyPlayerInfo copyWithMediaMetadataCompat(MediaMetadataCompat mediaMetadataCompat) {
            return new LegacyPlayerInfo(this.playbackInfoCompat, this.playbackStateCompat, mediaMetadataCompat, this.queue, this.queueTitle, this.repeatMode, this.shuffleMode, this.sessionExtras);
        }

        public LegacyPlayerInfo copyWithQueue(List list) {
            return new LegacyPlayerInfo(this.playbackInfoCompat, this.playbackStateCompat, this.mediaMetadataCompat, list, this.queueTitle, this.repeatMode, this.shuffleMode, this.sessionExtras);
        }

        public LegacyPlayerInfo copyWithQueueTitle(CharSequence charSequence) {
            return new LegacyPlayerInfo(this.playbackInfoCompat, this.playbackStateCompat, this.mediaMetadataCompat, this.queue, charSequence, this.repeatMode, this.shuffleMode, this.sessionExtras);
        }

        public LegacyPlayerInfo copyWithPlaybackInfoCompat(MediaControllerCompat.PlaybackInfo playbackInfo) {
            return new LegacyPlayerInfo(playbackInfo, this.playbackStateCompat, this.mediaMetadataCompat, this.queue, this.queueTitle, this.repeatMode, this.shuffleMode, this.sessionExtras);
        }

        public LegacyPlayerInfo copyWithRepeatMode(int i) {
            return new LegacyPlayerInfo(this.playbackInfoCompat, this.playbackStateCompat, this.mediaMetadataCompat, this.queue, this.queueTitle, i, this.shuffleMode, this.sessionExtras);
        }

        public LegacyPlayerInfo copyWithShuffleMode(int i) {
            return new LegacyPlayerInfo(this.playbackInfoCompat, this.playbackStateCompat, this.mediaMetadataCompat, this.queue, this.queueTitle, this.repeatMode, i, this.sessionExtras);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class ControllerInfo {
        public final Player.Commands availablePlayerCommands;
        public final SessionCommands availableSessionCommands;
        public final ImmutableList customLayout;
        public final PlayerInfo playerInfo;
        public final SessionError sessionError;
        public final Bundle sessionExtras;

        public ControllerInfo() {
            this.playerInfo = PlayerInfo.DEFAULT.copyWithTimeline(QueueTimeline.DEFAULT);
            this.availableSessionCommands = SessionCommands.EMPTY;
            this.availablePlayerCommands = Player.Commands.EMPTY;
            this.customLayout = ImmutableList.of();
            this.sessionExtras = Bundle.EMPTY;
            this.sessionError = null;
        }

        public ControllerInfo(PlayerInfo playerInfo, SessionCommands sessionCommands, Player.Commands commands, ImmutableList immutableList, Bundle bundle, SessionError sessionError) {
            this.playerInfo = playerInfo;
            this.availableSessionCommands = sessionCommands;
            this.availablePlayerCommands = commands;
            this.customLayout = immutableList;
            this.sessionExtras = bundle == null ? Bundle.EMPTY : bundle;
            this.sessionError = sessionError;
        }
    }
}
