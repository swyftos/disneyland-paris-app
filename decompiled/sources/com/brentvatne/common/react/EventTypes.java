package com.brentvatne.common.react;

import com.facebook.react.uimanager.ViewProps;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\b\u0086\u0081\u0002\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001#B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006$"}, d2 = {"Lcom/brentvatne/common/react/EventTypes;", "", "eventName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "EVENT_LOAD_START", "EVENT_LOAD", "EVENT_ERROR", "EVENT_PROGRESS", "EVENT_BANDWIDTH", "EVENT_CONTROLS_VISIBILITY_CHANGE", "EVENT_SEEK", "EVENT_END", "EVENT_FULLSCREEN_WILL_PRESENT", "EVENT_FULLSCREEN_DID_PRESENT", "EVENT_FULLSCREEN_WILL_DISMISS", "EVENT_FULLSCREEN_DID_DISMISS", "EVENT_READY", "EVENT_BUFFER", "EVENT_PLAYBACK_STATE_CHANGED", "EVENT_IDLE", "EVENT_TIMED_METADATA", "EVENT_AUDIO_BECOMING_NOISY", "EVENT_AUDIO_FOCUS_CHANGE", "EVENT_PLAYBACK_RATE_CHANGE", "EVENT_VOLUME_CHANGE", "EVENT_AUDIO_TRACKS", "EVENT_TEXT_TRACKS", "EVENT_TEXT_TRACK_DATA_CHANGED", "EVENT_VIDEO_TRACKS", "EVENT_ON_RECEIVE_AD_EVENT", "EVENT_PICTURE_IN_PICTURE_STATUS_CHANGED", "Companion", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EventTypes {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EventTypes[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final String eventName;
    public static final EventTypes EVENT_LOAD_START = new EventTypes("EVENT_LOAD_START", 0, "onVideoLoadStart");
    public static final EventTypes EVENT_LOAD = new EventTypes("EVENT_LOAD", 1, "onVideoLoad");
    public static final EventTypes EVENT_ERROR = new EventTypes("EVENT_ERROR", 2, "onVideoError");
    public static final EventTypes EVENT_PROGRESS = new EventTypes("EVENT_PROGRESS", 3, "onVideoProgress");
    public static final EventTypes EVENT_BANDWIDTH = new EventTypes("EVENT_BANDWIDTH", 4, "onVideoBandwidthUpdate");
    public static final EventTypes EVENT_CONTROLS_VISIBILITY_CHANGE = new EventTypes("EVENT_CONTROLS_VISIBILITY_CHANGE", 5, "onControlsVisibilityChange");
    public static final EventTypes EVENT_SEEK = new EventTypes("EVENT_SEEK", 6, "onVideoSeek");
    public static final EventTypes EVENT_END = new EventTypes("EVENT_END", 7, "onVideoEnd");
    public static final EventTypes EVENT_FULLSCREEN_WILL_PRESENT = new EventTypes("EVENT_FULLSCREEN_WILL_PRESENT", 8, "onVideoFullscreenPlayerWillPresent");
    public static final EventTypes EVENT_FULLSCREEN_DID_PRESENT = new EventTypes("EVENT_FULLSCREEN_DID_PRESENT", 9, "onVideoFullscreenPlayerDidPresent");
    public static final EventTypes EVENT_FULLSCREEN_WILL_DISMISS = new EventTypes("EVENT_FULLSCREEN_WILL_DISMISS", 10, "onVideoFullscreenPlayerWillDismiss");
    public static final EventTypes EVENT_FULLSCREEN_DID_DISMISS = new EventTypes("EVENT_FULLSCREEN_DID_DISMISS", 11, "onVideoFullscreenPlayerDidDismiss");
    public static final EventTypes EVENT_READY = new EventTypes("EVENT_READY", 12, "onReadyForDisplay");
    public static final EventTypes EVENT_BUFFER = new EventTypes("EVENT_BUFFER", 13, "onVideoBuffer");
    public static final EventTypes EVENT_PLAYBACK_STATE_CHANGED = new EventTypes("EVENT_PLAYBACK_STATE_CHANGED", 14, "onVideoPlaybackStateChanged");
    public static final EventTypes EVENT_IDLE = new EventTypes("EVENT_IDLE", 15, "onVideoIdle");
    public static final EventTypes EVENT_TIMED_METADATA = new EventTypes("EVENT_TIMED_METADATA", 16, "onTimedMetadata");
    public static final EventTypes EVENT_AUDIO_BECOMING_NOISY = new EventTypes("EVENT_AUDIO_BECOMING_NOISY", 17, "onVideoAudioBecomingNoisy");
    public static final EventTypes EVENT_AUDIO_FOCUS_CHANGE = new EventTypes("EVENT_AUDIO_FOCUS_CHANGE", 18, "onAudioFocusChanged");
    public static final EventTypes EVENT_PLAYBACK_RATE_CHANGE = new EventTypes("EVENT_PLAYBACK_RATE_CHANGE", 19, "onPlaybackRateChange");
    public static final EventTypes EVENT_VOLUME_CHANGE = new EventTypes("EVENT_VOLUME_CHANGE", 20, "onVolumeChange");
    public static final EventTypes EVENT_AUDIO_TRACKS = new EventTypes("EVENT_AUDIO_TRACKS", 21, "onAudioTracks");
    public static final EventTypes EVENT_TEXT_TRACKS = new EventTypes("EVENT_TEXT_TRACKS", 22, "onTextTracks");
    public static final EventTypes EVENT_TEXT_TRACK_DATA_CHANGED = new EventTypes("EVENT_TEXT_TRACK_DATA_CHANGED", 23, "onTextTrackDataChanged");
    public static final EventTypes EVENT_VIDEO_TRACKS = new EventTypes("EVENT_VIDEO_TRACKS", 24, "onVideoTracks");
    public static final EventTypes EVENT_ON_RECEIVE_AD_EVENT = new EventTypes("EVENT_ON_RECEIVE_AD_EVENT", 25, "onReceiveAdEvent");
    public static final EventTypes EVENT_PICTURE_IN_PICTURE_STATUS_CHANGED = new EventTypes("EVENT_PICTURE_IN_PICTURE_STATUS_CHANGED", 26, "onPictureInPictureStatusChanged");

    private static final /* synthetic */ EventTypes[] $values() {
        return new EventTypes[]{EVENT_LOAD_START, EVENT_LOAD, EVENT_ERROR, EVENT_PROGRESS, EVENT_BANDWIDTH, EVENT_CONTROLS_VISIBILITY_CHANGE, EVENT_SEEK, EVENT_END, EVENT_FULLSCREEN_WILL_PRESENT, EVENT_FULLSCREEN_DID_PRESENT, EVENT_FULLSCREEN_WILL_DISMISS, EVENT_FULLSCREEN_DID_DISMISS, EVENT_READY, EVENT_BUFFER, EVENT_PLAYBACK_STATE_CHANGED, EVENT_IDLE, EVENT_TIMED_METADATA, EVENT_AUDIO_BECOMING_NOISY, EVENT_AUDIO_FOCUS_CHANGE, EVENT_PLAYBACK_RATE_CHANGE, EVENT_VOLUME_CHANGE, EVENT_AUDIO_TRACKS, EVENT_TEXT_TRACKS, EVENT_TEXT_TRACK_DATA_CHANGED, EVENT_VIDEO_TRACKS, EVENT_ON_RECEIVE_AD_EVENT, EVENT_PICTURE_IN_PICTURE_STATUS_CHANGED};
    }

    @NotNull
    public static EnumEntries<EventTypes> getEntries() {
        return $ENTRIES;
    }

    private EventTypes(String str, int i, String str2) {
        this.eventName = str2;
    }

    @NotNull
    public final String getEventName() {
        return this.eventName;
    }

    static {
        EventTypes[] eventTypesArr$values = $values();
        $VALUES = eventTypesArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(eventTypesArr$values);
        INSTANCE = new Companion(null);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¨\u0006\u0007"}, d2 = {"Lcom/brentvatne/common/react/EventTypes$Companion;", "", "<init>", "()V", "toMap", "", "", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nVideoEventEmitter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VideoEventEmitter.kt\ncom/brentvatne/common/react/EventTypes$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,366:1\n1863#2,2:367\n*S KotlinDebug\n*F\n+ 1 VideoEventEmitter.kt\ncom/brentvatne/common/react/EventTypes$Companion\n*L\n51#1:367,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Map<String, Object> toMap() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (EventTypes eventTypes : ArraysKt.toList(EventTypes.values())) {
                linkedHashMap.put(ViewProps.TOP + StringsKt.removePrefix(eventTypes.getEventName(), (CharSequence) "on"), MapsKt.hashMapOf(TuplesKt.to("registrationName", eventTypes.getEventName())));
            }
            return linkedHashMap;
        }
    }

    public static EventTypes valueOf(String str) {
        return (EventTypes) Enum.valueOf(EventTypes.class, str);
    }

    public static EventTypes[] values() {
        return (EventTypes[]) $VALUES.clone();
    }
}
