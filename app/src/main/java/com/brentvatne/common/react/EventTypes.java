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

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\b\u0086\u0081\u0002\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001#B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006$"}, m1836d2 = {"Lcom/brentvatne/common/react/EventTypes;", "", "eventName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "EVENT_LOAD_START", "EVENT_LOAD", "EVENT_ERROR", "EVENT_PROGRESS", "EVENT_BANDWIDTH", "EVENT_CONTROLS_VISIBILITY_CHANGE", "EVENT_SEEK", "EVENT_END", "EVENT_FULLSCREEN_WILL_PRESENT", "EVENT_FULLSCREEN_DID_PRESENT", "EVENT_FULLSCREEN_WILL_DISMISS", "EVENT_FULLSCREEN_DID_DISMISS", "EVENT_READY", "EVENT_BUFFER", "EVENT_PLAYBACK_STATE_CHANGED", "EVENT_IDLE", "EVENT_TIMED_METADATA", "EVENT_AUDIO_BECOMING_NOISY", "EVENT_AUDIO_FOCUS_CHANGE", "EVENT_PLAYBACK_RATE_CHANGE", "EVENT_VOLUME_CHANGE", "EVENT_AUDIO_TRACKS", "EVENT_TEXT_TRACKS", "EVENT_TEXT_TRACK_DATA_CHANGED", "EVENT_VIDEO_TRACKS", "EVENT_ON_RECEIVE_AD_EVENT", "EVENT_PICTURE_IN_PICTURE_STATUS_CHANGED", "Companion", "react-native-video_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public enum EventTypes {
    EVENT_LOAD_START("onVideoLoadStart"),
    EVENT_LOAD("onVideoLoad"),
    EVENT_ERROR("onVideoError"),
    EVENT_PROGRESS("onVideoProgress"),
    EVENT_BANDWIDTH("onVideoBandwidthUpdate"),
    EVENT_CONTROLS_VISIBILITY_CHANGE("onControlsVisibilityChange"),
    EVENT_SEEK("onVideoSeek"),
    EVENT_END("onVideoEnd"),
    EVENT_FULLSCREEN_WILL_PRESENT("onVideoFullscreenPlayerWillPresent"),
    EVENT_FULLSCREEN_DID_PRESENT("onVideoFullscreenPlayerDidPresent"),
    EVENT_FULLSCREEN_WILL_DISMISS("onVideoFullscreenPlayerWillDismiss"),
    EVENT_FULLSCREEN_DID_DISMISS("onVideoFullscreenPlayerDidDismiss"),
    EVENT_READY("onReadyForDisplay"),
    EVENT_BUFFER("onVideoBuffer"),
    EVENT_PLAYBACK_STATE_CHANGED("onVideoPlaybackStateChanged"),
    EVENT_IDLE("onVideoIdle"),
    EVENT_TIMED_METADATA("onTimedMetadata"),
    EVENT_AUDIO_BECOMING_NOISY("onVideoAudioBecomingNoisy"),
    EVENT_AUDIO_FOCUS_CHANGE("onAudioFocusChanged"),
    EVENT_PLAYBACK_RATE_CHANGE("onPlaybackRateChange"),
    EVENT_VOLUME_CHANGE("onVolumeChange"),
    EVENT_AUDIO_TRACKS("onAudioTracks"),
    EVENT_TEXT_TRACKS("onTextTracks"),
    EVENT_TEXT_TRACK_DATA_CHANGED("onTextTrackDataChanged"),
    EVENT_VIDEO_TRACKS("onVideoTracks"),
    EVENT_ON_RECEIVE_AD_EVENT("onReceiveAdEvent"),
    EVENT_PICTURE_IN_PICTURE_STATUS_CHANGED("onPictureInPictureStatusChanged");

    private final String eventName;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static EnumEntries<EventTypes> getEntries() {
        return $ENTRIES;
    }

    EventTypes(String str) {
        this.eventName = str;
    }

    @NotNull
    public final String getEventName() {
        return this.eventName;
    }

    @Metadata(m1835d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¨\u0006\u0007"}, m1836d2 = {"Lcom/brentvatne/common/react/EventTypes$Companion;", "", "<init>", "()V", "toMap", "", "", "react-native-video_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
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
                linkedHashMap.put(ViewProps.TOP + StringsKt.removePrefix(eventTypes.getEventName(), (CharSequence) "on"), MapsKt.hashMapOf(TuplesKt.m1842to("registrationName", eventTypes.getEventName())));
            }
            return linkedHashMap;
        }
    }
}
