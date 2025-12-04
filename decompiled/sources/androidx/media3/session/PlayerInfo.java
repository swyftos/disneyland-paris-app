package androidx.media3.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* loaded from: classes.dex */
class PlayerInfo {
    public static final PlayerInfo DEFAULT;
    private static final String FIELD_AUDIO_ATTRIBUTES;
    private static final String FIELD_CUE_GROUP;
    private static final String FIELD_CURRENT_TRACKS;
    private static final String FIELD_DEVICE_INFO;
    private static final String FIELD_DEVICE_MUTED;
    private static final String FIELD_DEVICE_VOLUME;
    private static final String FIELD_DISCONTINUITY_REASON;
    private static final String FIELD_IN_PROCESS_BINDER;
    private static final String FIELD_IS_LOADING;
    private static final String FIELD_IS_PLAYING;
    static final String FIELD_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    private static final String FIELD_MEDIA_ITEM_TRANSITION_REASON;
    private static final String FIELD_MEDIA_METADATA;
    static final String FIELD_NEW_POSITION_INFO;
    static final String FIELD_OLD_POSITION_INFO;
    private static final String FIELD_PLAYBACK_ERROR;
    private static final String FIELD_PLAYBACK_PARAMETERS;
    private static final String FIELD_PLAYBACK_STATE;
    private static final String FIELD_PLAYBACK_SUPPRESSION_REASON;
    private static final String FIELD_PLAYLIST_METADATA;
    private static final String FIELD_PLAY_WHEN_READY;
    private static final String FIELD_PLAY_WHEN_READY_CHANGE_REASON;
    private static final String FIELD_REPEAT_MODE;
    static final String FIELD_SEEK_BACK_INCREMENT_MS;
    static final String FIELD_SEEK_FORWARD_INCREMENT_MS;
    static final String FIELD_SESSION_POSITION_INFO;
    private static final String FIELD_SHUFFLE_MODE_ENABLED;
    private static final String FIELD_TIMELINE;
    private static final String FIELD_TIMELINE_CHANGE_REASON;
    private static final String FIELD_TRACK_SELECTION_PARAMETERS;
    private static final String FIELD_VIDEO_SIZE;
    private static final String FIELD_VOLUME;
    public final AudioAttributes audioAttributes;
    public final CueGroup cueGroup;
    public final Tracks currentTracks;
    public final DeviceInfo deviceInfo;
    public final boolean deviceMuted;
    public final int deviceVolume;
    public final int discontinuityReason;
    public final boolean isLoading;
    public final boolean isPlaying;
    public final long maxSeekToPreviousPositionMs;
    public final int mediaItemTransitionReason;
    public final MediaMetadata mediaMetadata;
    public final Player.PositionInfo newPositionInfo;
    public final Player.PositionInfo oldPositionInfo;
    public final boolean playWhenReady;
    public final int playWhenReadyChangeReason;
    public final PlaybackParameters playbackParameters;
    public final int playbackState;
    public final int playbackSuppressionReason;
    public final PlaybackException playerError;
    public final MediaMetadata playlistMetadata;
    public final int repeatMode;
    public final long seekBackIncrementMs;
    public final long seekForwardIncrementMs;
    public final SessionPositionInfo sessionPositionInfo;
    public final boolean shuffleModeEnabled;
    public final Timeline timeline;
    public final int timelineChangeReason;
    public final TrackSelectionParameters trackSelectionParameters;
    public final VideoSize videoSize;
    public final float volume;

    private boolean isPlaying(int i, boolean z, int i2) {
        return i == 3 && z && i2 == 0;
    }

    public static class BundlingExclusions {
        public final boolean areCurrentTracksExcluded;
        public final boolean isTimelineExcluded;
        public static final BundlingExclusions NONE = new BundlingExclusions(false, false);
        private static final String FIELD_IS_TIMELINE_EXCLUDED = Util.intToStringMaxRadix(0);
        private static final String FIELD_ARE_CURRENT_TRACKS_EXCLUDED = Util.intToStringMaxRadix(1);

        public BundlingExclusions(boolean z, boolean z2) {
            this.isTimelineExcluded = z;
            this.areCurrentTracksExcluded = z2;
        }

        @UnstableApi
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBoolean(FIELD_IS_TIMELINE_EXCLUDED, this.isTimelineExcluded);
            bundle.putBoolean(FIELD_ARE_CURRENT_TRACKS_EXCLUDED, this.areCurrentTracksExcluded);
            return bundle;
        }

        public static BundlingExclusions fromBundle(Bundle bundle) {
            return new BundlingExclusions(bundle.getBoolean(FIELD_IS_TIMELINE_EXCLUDED, false), bundle.getBoolean(FIELD_ARE_CURRENT_TRACKS_EXCLUDED, false));
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BundlingExclusions)) {
                return false;
            }
            BundlingExclusions bundlingExclusions = (BundlingExclusions) obj;
            return this.isTimelineExcluded == bundlingExclusions.isTimelineExcluded && this.areCurrentTracksExcluded == bundlingExclusions.areCurrentTracksExcluded;
        }

        public int hashCode() {
            return Objects.hashCode(Boolean.valueOf(this.isTimelineExcluded), Boolean.valueOf(this.areCurrentTracksExcluded));
        }
    }

    public static class Builder {
        private AudioAttributes audioAttributes;
        private CueGroup cueGroup;
        private Tracks currentTracks;
        private DeviceInfo deviceInfo;
        private boolean deviceMuted;
        private int deviceVolume;
        private int discontinuityReason;
        private boolean isLoading;
        private boolean isPlaying;
        private long maxSeekToPreviousPositionMs;
        private int mediaItemTransitionReason;
        private MediaMetadata mediaMetadata;
        private Player.PositionInfo newPositionInfo;
        private Player.PositionInfo oldPositionInfo;
        private boolean playWhenReady;
        private int playWhenReadyChangeReason;
        private PlaybackParameters playbackParameters;
        private int playbackState;
        private int playbackSuppressionReason;
        private PlaybackException playerError;
        private MediaMetadata playlistMetadata;
        private int repeatMode;
        private long seekBackIncrementMs;
        private long seekForwardIncrementMs;
        private SessionPositionInfo sessionPositionInfo;
        private boolean shuffleModeEnabled;
        private Timeline timeline;
        private int timelineChangeReason;
        private TrackSelectionParameters trackSelectionParameters;
        private VideoSize videoSize;
        private float volume;

        public Builder(PlayerInfo playerInfo) {
            this.playerError = playerInfo.playerError;
            this.mediaItemTransitionReason = playerInfo.mediaItemTransitionReason;
            this.sessionPositionInfo = playerInfo.sessionPositionInfo;
            this.oldPositionInfo = playerInfo.oldPositionInfo;
            this.newPositionInfo = playerInfo.newPositionInfo;
            this.discontinuityReason = playerInfo.discontinuityReason;
            this.playbackParameters = playerInfo.playbackParameters;
            this.repeatMode = playerInfo.repeatMode;
            this.shuffleModeEnabled = playerInfo.shuffleModeEnabled;
            this.timeline = playerInfo.timeline;
            this.timelineChangeReason = playerInfo.timelineChangeReason;
            this.videoSize = playerInfo.videoSize;
            this.playlistMetadata = playerInfo.playlistMetadata;
            this.volume = playerInfo.volume;
            this.audioAttributes = playerInfo.audioAttributes;
            this.cueGroup = playerInfo.cueGroup;
            this.deviceInfo = playerInfo.deviceInfo;
            this.deviceVolume = playerInfo.deviceVolume;
            this.deviceMuted = playerInfo.deviceMuted;
            this.playWhenReady = playerInfo.playWhenReady;
            this.playWhenReadyChangeReason = playerInfo.playWhenReadyChangeReason;
            this.isPlaying = playerInfo.isPlaying;
            this.isLoading = playerInfo.isLoading;
            this.playbackSuppressionReason = playerInfo.playbackSuppressionReason;
            this.playbackState = playerInfo.playbackState;
            this.mediaMetadata = playerInfo.mediaMetadata;
            this.seekBackIncrementMs = playerInfo.seekBackIncrementMs;
            this.seekForwardIncrementMs = playerInfo.seekForwardIncrementMs;
            this.maxSeekToPreviousPositionMs = playerInfo.maxSeekToPreviousPositionMs;
            this.currentTracks = playerInfo.currentTracks;
            this.trackSelectionParameters = playerInfo.trackSelectionParameters;
        }

        @CanIgnoreReturnValue
        public Builder setPlayerError(@Nullable PlaybackException playbackException) {
            this.playerError = playbackException;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMediaItemTransitionReason(int i) {
            this.mediaItemTransitionReason = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSessionPositionInfo(SessionPositionInfo sessionPositionInfo) {
            this.sessionPositionInfo = sessionPositionInfo;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setOldPositionInfo(Player.PositionInfo positionInfo) {
            this.oldPositionInfo = positionInfo;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setNewPositionInfo(Player.PositionInfo positionInfo) {
            this.newPositionInfo = positionInfo;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setDiscontinuityReason(int i) {
            this.discontinuityReason = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPlaybackParameters(PlaybackParameters playbackParameters) {
            this.playbackParameters = playbackParameters;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setRepeatMode(int i) {
            this.repeatMode = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setShuffleModeEnabled(boolean z) {
            this.shuffleModeEnabled = z;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setTimeline(Timeline timeline) {
            this.timeline = timeline;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setTimelineChangeReason(int i) {
            this.timelineChangeReason = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setVideoSize(VideoSize videoSize) {
            this.videoSize = videoSize;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPlaylistMetadata(MediaMetadata mediaMetadata) {
            this.playlistMetadata = mediaMetadata;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setVolume(@FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
            this.volume = f;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setAudioAttributes(AudioAttributes audioAttributes) {
            this.audioAttributes = audioAttributes;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setCues(CueGroup cueGroup) {
            this.cueGroup = cueGroup;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setDeviceInfo(DeviceInfo deviceInfo) {
            this.deviceInfo = deviceInfo;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setDeviceVolume(int i) {
            this.deviceVolume = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setDeviceMuted(boolean z) {
            this.deviceMuted = z;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPlayWhenReady(boolean z) {
            this.playWhenReady = z;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPlayWhenReadyChangeReason(int i) {
            this.playWhenReadyChangeReason = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setIsPlaying(boolean z) {
            this.isPlaying = z;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setIsLoading(boolean z) {
            this.isLoading = z;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPlaybackSuppressionReason(int i) {
            this.playbackSuppressionReason = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPlaybackState(int i) {
            this.playbackState = i;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMediaMetadata(MediaMetadata mediaMetadata) {
            this.mediaMetadata = mediaMetadata;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSeekBackIncrement(long j) {
            this.seekBackIncrementMs = j;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSeekForwardIncrement(long j) {
            this.seekForwardIncrementMs = j;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMaxSeekToPreviousPositionMs(long j) {
            this.maxSeekToPreviousPositionMs = j;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setCurrentTracks(Tracks tracks) {
            this.currentTracks = tracks;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
            this.trackSelectionParameters = trackSelectionParameters;
            return this;
        }

        public PlayerInfo build() {
            Assertions.checkState(this.timeline.isEmpty() || this.sessionPositionInfo.positionInfo.mediaItemIndex < this.timeline.getWindowCount());
            return new PlayerInfo(this.playerError, this.mediaItemTransitionReason, this.sessionPositionInfo, this.oldPositionInfo, this.newPositionInfo, this.discontinuityReason, this.playbackParameters, this.repeatMode, this.shuffleModeEnabled, this.videoSize, this.timeline, this.timelineChangeReason, this.playlistMetadata, this.volume, this.audioAttributes, this.cueGroup, this.deviceInfo, this.deviceVolume, this.deviceMuted, this.playWhenReady, this.playWhenReadyChangeReason, this.playbackSuppressionReason, this.playbackState, this.isPlaying, this.isLoading, this.mediaMetadata, this.seekBackIncrementMs, this.seekForwardIncrementMs, this.maxSeekToPreviousPositionMs, this.currentTracks, this.trackSelectionParameters);
        }
    }

    static {
        SessionPositionInfo sessionPositionInfo = SessionPositionInfo.DEFAULT;
        Player.PositionInfo positionInfo = SessionPositionInfo.DEFAULT_POSITION_INFO;
        PlaybackParameters playbackParameters = PlaybackParameters.DEFAULT;
        VideoSize videoSize = VideoSize.UNKNOWN;
        Timeline timeline = Timeline.EMPTY;
        MediaMetadata mediaMetadata = MediaMetadata.EMPTY;
        DEFAULT = new PlayerInfo(null, 0, sessionPositionInfo, positionInfo, positionInfo, 0, playbackParameters, 0, false, videoSize, timeline, 0, mediaMetadata, 1.0f, AudioAttributes.DEFAULT, CueGroup.EMPTY_TIME_ZERO, DeviceInfo.UNKNOWN, 0, false, false, 1, 0, 1, false, false, mediaMetadata, 5000L, 15000L, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, Tracks.EMPTY, TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT);
        FIELD_PLAYBACK_PARAMETERS = Util.intToStringMaxRadix(1);
        FIELD_REPEAT_MODE = Util.intToStringMaxRadix(2);
        FIELD_SHUFFLE_MODE_ENABLED = Util.intToStringMaxRadix(3);
        FIELD_TIMELINE = Util.intToStringMaxRadix(4);
        FIELD_VIDEO_SIZE = Util.intToStringMaxRadix(5);
        FIELD_PLAYLIST_METADATA = Util.intToStringMaxRadix(6);
        FIELD_VOLUME = Util.intToStringMaxRadix(7);
        FIELD_AUDIO_ATTRIBUTES = Util.intToStringMaxRadix(8);
        FIELD_DEVICE_INFO = Util.intToStringMaxRadix(9);
        FIELD_DEVICE_VOLUME = Util.intToStringMaxRadix(10);
        FIELD_DEVICE_MUTED = Util.intToStringMaxRadix(11);
        FIELD_PLAY_WHEN_READY = Util.intToStringMaxRadix(12);
        FIELD_PLAY_WHEN_READY_CHANGE_REASON = Util.intToStringMaxRadix(13);
        FIELD_PLAYBACK_SUPPRESSION_REASON = Util.intToStringMaxRadix(14);
        FIELD_PLAYBACK_STATE = Util.intToStringMaxRadix(15);
        FIELD_IS_PLAYING = Util.intToStringMaxRadix(16);
        FIELD_IS_LOADING = Util.intToStringMaxRadix(17);
        FIELD_PLAYBACK_ERROR = Util.intToStringMaxRadix(18);
        FIELD_SESSION_POSITION_INFO = Util.intToStringMaxRadix(19);
        FIELD_MEDIA_ITEM_TRANSITION_REASON = Util.intToStringMaxRadix(20);
        FIELD_OLD_POSITION_INFO = Util.intToStringMaxRadix(21);
        FIELD_NEW_POSITION_INFO = Util.intToStringMaxRadix(22);
        FIELD_DISCONTINUITY_REASON = Util.intToStringMaxRadix(23);
        FIELD_CUE_GROUP = Util.intToStringMaxRadix(24);
        FIELD_MEDIA_METADATA = Util.intToStringMaxRadix(25);
        FIELD_SEEK_BACK_INCREMENT_MS = Util.intToStringMaxRadix(26);
        FIELD_SEEK_FORWARD_INCREMENT_MS = Util.intToStringMaxRadix(27);
        FIELD_MAX_SEEK_TO_PREVIOUS_POSITION_MS = Util.intToStringMaxRadix(28);
        FIELD_TRACK_SELECTION_PARAMETERS = Util.intToStringMaxRadix(29);
        FIELD_CURRENT_TRACKS = Util.intToStringMaxRadix(30);
        FIELD_TIMELINE_CHANGE_REASON = Util.intToStringMaxRadix(31);
        FIELD_IN_PROCESS_BINDER = Util.intToStringMaxRadix(32);
    }

    public PlayerInfo copyWithPlayWhenReady(boolean z, int i, int i2) {
        return new Builder(this).setPlayWhenReady(z).setPlayWhenReadyChangeReason(i).setPlaybackSuppressionReason(i2).setIsPlaying(isPlaying(this.playbackState, z, i2)).build();
    }

    public PlayerInfo copyWithMediaItemTransitionReason(int i) {
        return new Builder(this).setMediaItemTransitionReason(i).build();
    }

    public PlayerInfo copyWithPlayerError(PlaybackException playbackException) {
        return new Builder(this).setPlayerError(playbackException).build();
    }

    public PlayerInfo copyWithPlaybackState(int i, PlaybackException playbackException) {
        return new Builder(this).setPlayerError(playbackException).setPlaybackState(i).setIsPlaying(isPlaying(i, this.playWhenReady, this.playbackSuppressionReason)).build();
    }

    public PlayerInfo copyWithIsPlaying(boolean z) {
        return new Builder(this).setIsPlaying(z).build();
    }

    public PlayerInfo copyWithIsLoading(boolean z) {
        return new Builder(this).setIsLoading(z).build();
    }

    public PlayerInfo copyWithPlaybackParameters(PlaybackParameters playbackParameters) {
        return new Builder(this).setPlaybackParameters(playbackParameters).build();
    }

    public PlayerInfo copyWithPositionInfos(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        return new Builder(this).setOldPositionInfo(positionInfo).setNewPositionInfo(positionInfo2).setDiscontinuityReason(i).build();
    }

    public PlayerInfo copyWithSessionPositionInfo(SessionPositionInfo sessionPositionInfo) {
        return new Builder(this).setSessionPositionInfo(sessionPositionInfo).build();
    }

    public PlayerInfo copyWithTimeline(Timeline timeline) {
        return new Builder(this).setTimeline(timeline).build();
    }

    public PlayerInfo copyWithTimelineAndSessionPositionInfo(Timeline timeline, SessionPositionInfo sessionPositionInfo, int i) {
        return new Builder(this).setTimeline(timeline).setSessionPositionInfo(sessionPositionInfo).setTimelineChangeReason(i).build();
    }

    public PlayerInfo copyWithTimelineAndMediaItemIndex(Timeline timeline, int i, int i2) {
        Builder timelineChangeReason = new Builder(this).setTimeline(timeline).setTimelineChangeReason(i2);
        Player.PositionInfo positionInfo = this.sessionPositionInfo.positionInfo;
        Player.PositionInfo positionInfo2 = new Player.PositionInfo(positionInfo.windowUid, i, positionInfo.mediaItem, positionInfo.periodUid, positionInfo.periodIndex, positionInfo.positionMs, positionInfo.contentPositionMs, positionInfo.adGroupIndex, positionInfo.adIndexInAdGroup);
        SessionPositionInfo sessionPositionInfo = this.sessionPositionInfo;
        return timelineChangeReason.setSessionPositionInfo(new SessionPositionInfo(positionInfo2, sessionPositionInfo.isPlayingAd, sessionPositionInfo.eventTimeMs, sessionPositionInfo.durationMs, sessionPositionInfo.bufferedPositionMs, sessionPositionInfo.bufferedPercentage, sessionPositionInfo.totalBufferedDurationMs, sessionPositionInfo.currentLiveOffsetMs, sessionPositionInfo.contentDurationMs, sessionPositionInfo.contentBufferedPositionMs)).build();
    }

    public PlayerInfo copyWithPlaylistMetadata(MediaMetadata mediaMetadata) {
        return new Builder(this).setPlaylistMetadata(mediaMetadata).build();
    }

    public PlayerInfo copyWithRepeatMode(int i) {
        return new Builder(this).setRepeatMode(i).build();
    }

    public PlayerInfo copyWithShuffleModeEnabled(boolean z) {
        return new Builder(this).setShuffleModeEnabled(z).build();
    }

    public PlayerInfo copyWithAudioAttributes(AudioAttributes audioAttributes) {
        return new Builder(this).setAudioAttributes(audioAttributes).build();
    }

    public PlayerInfo copyWithVideoSize(VideoSize videoSize) {
        return new Builder(this).setVideoSize(videoSize).build();
    }

    public PlayerInfo copyWithVolume(float f) {
        return new Builder(this).setVolume(f).build();
    }

    public PlayerInfo copyWithDeviceInfo(DeviceInfo deviceInfo) {
        return new Builder(this).setDeviceInfo(deviceInfo).build();
    }

    public PlayerInfo copyWithDeviceVolume(int i, boolean z) {
        return new Builder(this).setDeviceVolume(i).setDeviceMuted(z).build();
    }

    public PlayerInfo copyWithMediaMetadata(MediaMetadata mediaMetadata) {
        return new Builder(this).setMediaMetadata(mediaMetadata).build();
    }

    public PlayerInfo copyWithSeekBackIncrement(long j) {
        return new Builder(this).setSeekBackIncrement(j).build();
    }

    public PlayerInfo copyWithSeekForwardIncrement(long j) {
        return new Builder(this).setSeekForwardIncrement(j).build();
    }

    public PlayerInfo copyWithMaxSeekToPreviousPositionMs(long j) {
        return new Builder(this).setMaxSeekToPreviousPositionMs(j).build();
    }

    public PlayerInfo copyWithCurrentTracks(Tracks tracks) {
        return new Builder(this).setCurrentTracks(tracks).build();
    }

    public PlayerInfo copyWithTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        return new Builder(this).setTrackSelectionParameters(trackSelectionParameters).build();
    }

    public PlayerInfo(PlaybackException playbackException, int i, SessionPositionInfo sessionPositionInfo, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2, PlaybackParameters playbackParameters, int i3, boolean z, VideoSize videoSize, Timeline timeline, int i4, MediaMetadata mediaMetadata, float f, AudioAttributes audioAttributes, CueGroup cueGroup, DeviceInfo deviceInfo, int i5, boolean z2, boolean z3, int i6, int i7, int i8, boolean z4, boolean z5, MediaMetadata mediaMetadata2, long j, long j2, long j3, Tracks tracks, TrackSelectionParameters trackSelectionParameters) {
        this.playerError = playbackException;
        this.mediaItemTransitionReason = i;
        this.sessionPositionInfo = sessionPositionInfo;
        this.oldPositionInfo = positionInfo;
        this.newPositionInfo = positionInfo2;
        this.discontinuityReason = i2;
        this.playbackParameters = playbackParameters;
        this.repeatMode = i3;
        this.shuffleModeEnabled = z;
        this.videoSize = videoSize;
        this.timeline = timeline;
        this.timelineChangeReason = i4;
        this.playlistMetadata = mediaMetadata;
        this.volume = f;
        this.audioAttributes = audioAttributes;
        this.cueGroup = cueGroup;
        this.deviceInfo = deviceInfo;
        this.deviceVolume = i5;
        this.deviceMuted = z2;
        this.playWhenReady = z3;
        this.playWhenReadyChangeReason = i6;
        this.playbackSuppressionReason = i7;
        this.playbackState = i8;
        this.isPlaying = z4;
        this.isLoading = z5;
        this.mediaMetadata = mediaMetadata2;
        this.seekBackIncrementMs = j;
        this.seekForwardIncrementMs = j2;
        this.maxSeekToPreviousPositionMs = j3;
        this.currentTracks = tracks;
        this.trackSelectionParameters = trackSelectionParameters;
    }

    public MediaItem getCurrentMediaItem() {
        if (this.timeline.isEmpty()) {
            return null;
        }
        return this.timeline.getWindow(this.sessionPositionInfo.positionInfo.mediaItemIndex, new Timeline.Window()).mediaItem;
    }

    public PlayerInfo filterByAvailableCommands(Player.Commands commands, boolean z, boolean z2) {
        Builder builder = new Builder(this);
        boolean zContains = commands.contains(16);
        boolean zContains2 = commands.contains(17);
        builder.setSessionPositionInfo(this.sessionPositionInfo.filterByAvailableCommands(zContains, zContains2));
        builder.setOldPositionInfo(this.oldPositionInfo.filterByAvailableCommands(zContains, zContains2));
        builder.setNewPositionInfo(this.newPositionInfo.filterByAvailableCommands(zContains, zContains2));
        if (!zContains2 && zContains && !this.timeline.isEmpty()) {
            builder.setTimeline(this.timeline.copyWithSingleWindow(this.sessionPositionInfo.positionInfo.mediaItemIndex));
        } else if (z || !zContains2) {
            builder.setTimeline(Timeline.EMPTY);
        }
        if (!commands.contains(18)) {
            builder.setPlaylistMetadata(MediaMetadata.EMPTY);
        }
        if (!commands.contains(22)) {
            builder.setVolume(1.0f);
        }
        if (!commands.contains(21)) {
            builder.setAudioAttributes(AudioAttributes.DEFAULT);
        }
        if (!commands.contains(28)) {
            builder.setCues(CueGroup.EMPTY_TIME_ZERO);
        }
        if (!commands.contains(23)) {
            builder.setDeviceVolume(0).setDeviceMuted(false);
        }
        if (!commands.contains(18)) {
            builder.setMediaMetadata(MediaMetadata.EMPTY);
        }
        if (z2 || !commands.contains(30)) {
            builder.setCurrentTracks(Tracks.EMPTY);
        }
        return builder.build();
    }

    public Bundle toBundleInProcess() {
        Bundle bundle = new Bundle();
        bundle.putBinder(FIELD_IN_PROCESS_BINDER, new InProcessBinder());
        return bundle;
    }

    public Bundle toBundleForRemoteProcess(int i) {
        Bundle bundle = new Bundle();
        PlaybackException playbackException = this.playerError;
        if (playbackException != null) {
            bundle.putBundle(FIELD_PLAYBACK_ERROR, playbackException.toBundle());
        }
        int i2 = this.mediaItemTransitionReason;
        if (i2 != 0) {
            bundle.putInt(FIELD_MEDIA_ITEM_TRANSITION_REASON, i2);
        }
        if (i < 3 || !this.sessionPositionInfo.equals(SessionPositionInfo.DEFAULT)) {
            bundle.putBundle(FIELD_SESSION_POSITION_INFO, this.sessionPositionInfo.toBundle(i));
        }
        if (i < 3 || !SessionPositionInfo.DEFAULT_POSITION_INFO.equalsForBundling(this.oldPositionInfo)) {
            bundle.putBundle(FIELD_OLD_POSITION_INFO, this.oldPositionInfo.toBundle(i));
        }
        if (i < 3 || !SessionPositionInfo.DEFAULT_POSITION_INFO.equalsForBundling(this.newPositionInfo)) {
            bundle.putBundle(FIELD_NEW_POSITION_INFO, this.newPositionInfo.toBundle(i));
        }
        int i3 = this.discontinuityReason;
        if (i3 != 0) {
            bundle.putInt(FIELD_DISCONTINUITY_REASON, i3);
        }
        if (!this.playbackParameters.equals(PlaybackParameters.DEFAULT)) {
            bundle.putBundle(FIELD_PLAYBACK_PARAMETERS, this.playbackParameters.toBundle());
        }
        int i4 = this.repeatMode;
        if (i4 != 0) {
            bundle.putInt(FIELD_REPEAT_MODE, i4);
        }
        boolean z = this.shuffleModeEnabled;
        if (z) {
            bundle.putBoolean(FIELD_SHUFFLE_MODE_ENABLED, z);
        }
        if (!this.timeline.equals(Timeline.EMPTY)) {
            bundle.putBundle(FIELD_TIMELINE, this.timeline.toBundle());
        }
        int i5 = this.timelineChangeReason;
        if (i5 != 0) {
            bundle.putInt(FIELD_TIMELINE_CHANGE_REASON, i5);
        }
        if (!this.videoSize.equals(VideoSize.UNKNOWN)) {
            bundle.putBundle(FIELD_VIDEO_SIZE, this.videoSize.toBundle());
        }
        MediaMetadata mediaMetadata = this.playlistMetadata;
        MediaMetadata mediaMetadata2 = MediaMetadata.EMPTY;
        if (!mediaMetadata.equals(mediaMetadata2)) {
            bundle.putBundle(FIELD_PLAYLIST_METADATA, this.playlistMetadata.toBundle());
        }
        float f = this.volume;
        if (f != 1.0f) {
            bundle.putFloat(FIELD_VOLUME, f);
        }
        if (!this.audioAttributes.equals(AudioAttributes.DEFAULT)) {
            bundle.putBundle(FIELD_AUDIO_ATTRIBUTES, this.audioAttributes.toBundle());
        }
        if (!this.cueGroup.equals(CueGroup.EMPTY_TIME_ZERO)) {
            bundle.putBundle(FIELD_CUE_GROUP, this.cueGroup.toBundle());
        }
        if (!this.deviceInfo.equals(DeviceInfo.UNKNOWN)) {
            bundle.putBundle(FIELD_DEVICE_INFO, this.deviceInfo.toBundle());
        }
        int i6 = this.deviceVolume;
        if (i6 != 0) {
            bundle.putInt(FIELD_DEVICE_VOLUME, i6);
        }
        boolean z2 = this.deviceMuted;
        if (z2) {
            bundle.putBoolean(FIELD_DEVICE_MUTED, z2);
        }
        boolean z3 = this.playWhenReady;
        if (z3) {
            bundle.putBoolean(FIELD_PLAY_WHEN_READY, z3);
        }
        int i7 = this.playWhenReadyChangeReason;
        if (i7 != 1) {
            bundle.putInt(FIELD_PLAY_WHEN_READY_CHANGE_REASON, i7);
        }
        int i8 = this.playbackSuppressionReason;
        if (i8 != 0) {
            bundle.putInt(FIELD_PLAYBACK_SUPPRESSION_REASON, i8);
        }
        int i9 = this.playbackState;
        if (i9 != 1) {
            bundle.putInt(FIELD_PLAYBACK_STATE, i9);
        }
        boolean z4 = this.isPlaying;
        if (z4) {
            bundle.putBoolean(FIELD_IS_PLAYING, z4);
        }
        boolean z5 = this.isLoading;
        if (z5) {
            bundle.putBoolean(FIELD_IS_LOADING, z5);
        }
        if (!this.mediaMetadata.equals(mediaMetadata2)) {
            bundle.putBundle(FIELD_MEDIA_METADATA, this.mediaMetadata.toBundle());
        }
        long j = i < 6 ? 0L : 5000L;
        long j2 = this.seekBackIncrementMs;
        if (j2 != j) {
            bundle.putLong(FIELD_SEEK_BACK_INCREMENT_MS, j2);
        }
        long j3 = i < 6 ? 0L : 15000L;
        long j4 = this.seekForwardIncrementMs;
        if (j4 != j3) {
            bundle.putLong(FIELD_SEEK_FORWARD_INCREMENT_MS, j4);
        }
        long j5 = i >= 6 ? C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS : 0L;
        long j6 = this.maxSeekToPreviousPositionMs;
        if (j6 != j5) {
            bundle.putLong(FIELD_MAX_SEEK_TO_PREVIOUS_POSITION_MS, j6);
        }
        if (!this.currentTracks.equals(Tracks.EMPTY)) {
            bundle.putBundle(FIELD_CURRENT_TRACKS, this.currentTracks.toBundle());
        }
        if (!this.trackSelectionParameters.equals(TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT)) {
            bundle.putBundle(FIELD_TRACK_SELECTION_PARAMETERS, this.trackSelectionParameters.toBundle());
        }
        return bundle;
    }

    public static PlayerInfo fromBundle(Bundle bundle, int i) {
        SessionPositionInfo sessionPositionInfoFromBundle;
        Player.PositionInfo positionInfoFromBundle;
        Player.PositionInfo positionInfoFromBundle2;
        PlaybackParameters playbackParametersFromBundle;
        MediaMetadata mediaMetadataFromBundle;
        AudioAttributes audioAttributesFromBundle;
        MediaMetadata mediaMetadataFromBundle2;
        Timeline timeline;
        int i2;
        long j;
        TrackSelectionParameters trackSelectionParametersFromBundle;
        IBinder binder = bundle.getBinder(FIELD_IN_PROCESS_BINDER);
        if (binder instanceof InProcessBinder) {
            return ((InProcessBinder) binder).getPlayerInfo();
        }
        Bundle bundle2 = bundle.getBundle(FIELD_PLAYBACK_ERROR);
        PlaybackException playbackExceptionFromBundle = bundle2 == null ? null : PlaybackException.fromBundle(bundle2);
        int i3 = bundle.getInt(FIELD_MEDIA_ITEM_TRANSITION_REASON, 0);
        Bundle bundle3 = bundle.getBundle(FIELD_SESSION_POSITION_INFO);
        if (bundle3 == null) {
            sessionPositionInfoFromBundle = SessionPositionInfo.DEFAULT;
        } else {
            sessionPositionInfoFromBundle = SessionPositionInfo.fromBundle(bundle3);
        }
        SessionPositionInfo sessionPositionInfo = sessionPositionInfoFromBundle;
        Bundle bundle4 = bundle.getBundle(FIELD_OLD_POSITION_INFO);
        if (bundle4 == null) {
            positionInfoFromBundle = SessionPositionInfo.DEFAULT_POSITION_INFO;
        } else {
            positionInfoFromBundle = Player.PositionInfo.fromBundle(bundle4);
        }
        Player.PositionInfo positionInfo = positionInfoFromBundle;
        Bundle bundle5 = bundle.getBundle(FIELD_NEW_POSITION_INFO);
        if (bundle5 == null) {
            positionInfoFromBundle2 = SessionPositionInfo.DEFAULT_POSITION_INFO;
        } else {
            positionInfoFromBundle2 = Player.PositionInfo.fromBundle(bundle5);
        }
        Player.PositionInfo positionInfo2 = positionInfoFromBundle2;
        int i4 = bundle.getInt(FIELD_DISCONTINUITY_REASON, 0);
        Bundle bundle6 = bundle.getBundle(FIELD_PLAYBACK_PARAMETERS);
        if (bundle6 == null) {
            playbackParametersFromBundle = PlaybackParameters.DEFAULT;
        } else {
            playbackParametersFromBundle = PlaybackParameters.fromBundle(bundle6);
        }
        PlaybackParameters playbackParameters = playbackParametersFromBundle;
        int i5 = bundle.getInt(FIELD_REPEAT_MODE, 0);
        boolean z = bundle.getBoolean(FIELD_SHUFFLE_MODE_ENABLED, false);
        Bundle bundle7 = bundle.getBundle(FIELD_TIMELINE);
        Timeline timelineFromBundle = bundle7 == null ? Timeline.EMPTY : Timeline.fromBundle(bundle7);
        int i6 = bundle.getInt(FIELD_TIMELINE_CHANGE_REASON, 0);
        Bundle bundle8 = bundle.getBundle(FIELD_VIDEO_SIZE);
        VideoSize videoSizeFromBundle = bundle8 == null ? VideoSize.UNKNOWN : VideoSize.fromBundle(bundle8);
        Bundle bundle9 = bundle.getBundle(FIELD_PLAYLIST_METADATA);
        if (bundle9 == null) {
            mediaMetadataFromBundle = MediaMetadata.EMPTY;
        } else {
            mediaMetadataFromBundle = MediaMetadata.fromBundle(bundle9);
        }
        MediaMetadata mediaMetadata = mediaMetadataFromBundle;
        float f = bundle.getFloat(FIELD_VOLUME, 1.0f);
        Bundle bundle10 = bundle.getBundle(FIELD_AUDIO_ATTRIBUTES);
        if (bundle10 == null) {
            audioAttributesFromBundle = AudioAttributes.DEFAULT;
        } else {
            audioAttributesFromBundle = AudioAttributes.fromBundle(bundle10);
        }
        AudioAttributes audioAttributes = audioAttributesFromBundle;
        Bundle bundle11 = bundle.getBundle(FIELD_CUE_GROUP);
        CueGroup cueGroupFromBundle = bundle11 == null ? CueGroup.EMPTY_TIME_ZERO : CueGroup.fromBundle(bundle11);
        Bundle bundle12 = bundle.getBundle(FIELD_DEVICE_INFO);
        DeviceInfo deviceInfoFromBundle = bundle12 == null ? DeviceInfo.UNKNOWN : DeviceInfo.fromBundle(bundle12);
        int i7 = bundle.getInt(FIELD_DEVICE_VOLUME, 0);
        boolean z2 = bundle.getBoolean(FIELD_DEVICE_MUTED, false);
        boolean z3 = bundle.getBoolean(FIELD_PLAY_WHEN_READY, false);
        int i8 = bundle.getInt(FIELD_PLAY_WHEN_READY_CHANGE_REASON, 1);
        int i9 = bundle.getInt(FIELD_PLAYBACK_SUPPRESSION_REASON, 0);
        int i10 = bundle.getInt(FIELD_PLAYBACK_STATE, 1);
        boolean z4 = bundle.getBoolean(FIELD_IS_PLAYING, false);
        boolean z5 = bundle.getBoolean(FIELD_IS_LOADING, false);
        Bundle bundle13 = bundle.getBundle(FIELD_MEDIA_METADATA);
        if (bundle13 == null) {
            mediaMetadataFromBundle2 = MediaMetadata.EMPTY;
        } else {
            mediaMetadataFromBundle2 = MediaMetadata.fromBundle(bundle13);
        }
        MediaMetadata mediaMetadata2 = mediaMetadataFromBundle2;
        String str = FIELD_SEEK_BACK_INCREMENT_MS;
        if (i < 4) {
            timeline = timelineFromBundle;
            i2 = i6;
            j = 0;
        } else {
            timeline = timelineFromBundle;
            i2 = i6;
            j = 5000;
        }
        long j2 = bundle.getLong(str, j);
        long j3 = bundle.getLong(FIELD_SEEK_FORWARD_INCREMENT_MS, i < 4 ? 0L : 15000L);
        long j4 = bundle.getLong(FIELD_MAX_SEEK_TO_PREVIOUS_POSITION_MS, i >= 4 ? C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS : 0L);
        Bundle bundle14 = bundle.getBundle(FIELD_CURRENT_TRACKS);
        Tracks tracksFromBundle = bundle14 == null ? Tracks.EMPTY : Tracks.fromBundle(bundle14);
        Bundle bundle15 = bundle.getBundle(FIELD_TRACK_SELECTION_PARAMETERS);
        if (bundle15 == null) {
            trackSelectionParametersFromBundle = TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT;
        } else {
            trackSelectionParametersFromBundle = TrackSelectionParameters.fromBundle(bundle15);
        }
        return new PlayerInfo(playbackExceptionFromBundle, i3, sessionPositionInfo, positionInfo, positionInfo2, i4, playbackParameters, i5, z, videoSizeFromBundle, timeline, i2, mediaMetadata, f, audioAttributes, cueGroupFromBundle, deviceInfoFromBundle, i7, z2, z3, i8, i9, i10, z4, z5, mediaMetadata2, j2, j3, j4, tracksFromBundle, trackSelectionParametersFromBundle);
    }

    private final class InProcessBinder extends Binder {
        private InProcessBinder() {
        }

        public PlayerInfo getPlayerInfo() {
            return PlayerInfo.this;
        }
    }
}
