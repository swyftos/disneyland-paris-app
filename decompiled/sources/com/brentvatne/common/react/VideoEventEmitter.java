package com.brentvatne.common.react;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.brentvatne.common.api.TimedMetadata;
import com.brentvatne.common.api.Track;
import com.brentvatne.common.api.VideoTrack;
import com.brentvatne.exoplayer.ReactExoplayerView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0002¡\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0096\u0001\u001a\u00020\u00062\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001J\u001a\u0010\u009b\u0001\u001a\u00030\u009c\u00012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0002J\u001a\u0010\u009d\u0001\u001a\u00030\u009c\u00012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0015H\u0002J&\u0010\u009e\u0001\u001a\u00030\u009c\u00012\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0018H\u0002J\u001a\u0010\u009f\u0001\u001a\u00030 \u00012\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nRû\u0001\u0010\u000b\u001aâ\u0001\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0014\u0012#\u0012!\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0018¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0017\u0012#\u0012!\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0018¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0019\u0012#\u0012!\u0012\u0004\u0012\u00020\u001a0\u0015j\b\u0012\u0004\u0012\u00020\u001a`\u0018¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00060\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!Rc\u0010\"\u001aK\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b($\u0012\u0017\u0012\u00150%j\u0002`'¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00060#X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,Rt\u0010-\u001a\\\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(0\u0012\u0013\u0012\u001101¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u00060.X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106Rv\u00107\u001a^\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(8\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(9\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(:\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00060.X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00104\"\u0004\b<\u00106RJ\u0010=\u001a2\u0012\u0013\u0012\u00110?¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110?¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\u00060>X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ERJ\u0010F\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020\u00060>X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010C\"\u0004\bI\u0010ER \u0010J\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\b\"\u0004\bL\u0010\nR \u0010M\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\b\"\u0004\bO\u0010\nR \u0010P\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\b\"\u0004\bR\u0010\nR \u0010S\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\b\"\u0004\bU\u0010\nR \u0010V\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\b\"\u0004\bX\u0010\nR \u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\b\"\u0004\b[\u0010\nR5\u0010\\\u001a\u001d\u0012\u0013\u0012\u00110?¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(^\u0012\u0004\u0012\u00020\u00060]X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR5\u0010c\u001a\u001d\u0012\u0013\u0012\u00110?¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(d\u0012\u0004\u0012\u00020\u00060]X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010`\"\u0004\bf\u0010bR \u0010g\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\b\"\u0004\bi\u0010\nRE\u0010j\u001a-\u0012#\u0012!\u0012\u0004\u0012\u00020k0\u0015j\b\u0012\u0004\u0012\u00020k`\u0018¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(l\u0012\u0004\u0012\u00020\u00060]X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010`\"\u0004\bn\u0010bR \u0010o\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\b\"\u0004\bq\u0010\nR5\u0010r\u001a\u001d\u0012\u0013\u0012\u00110?¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(s\u0012\u0004\u0012\u00020\u00060]X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010`\"\u0004\bu\u0010bR5\u0010v\u001a\u001d\u0012\u0013\u0012\u00110w¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(x\u0012\u0004\u0012\u00020\u00060]X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010`\"\u0004\bz\u0010bR5\u0010{\u001a\u001d\u0012\u0013\u0012\u00110w¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(|\u0012\u0004\u0012\u00020\u00060]X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010`\"\u0004\b~\u0010bRK\u0010\u007f\u001a1\u0012'\u0012%\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0018¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00060]X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010`\"\u0005\b\u0081\u0001\u0010bRL\u0010\u0082\u0001\u001a1\u0012'\u0012%\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0018¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00060]X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010`\"\u0005\b\u0084\u0001\u0010bRL\u0010\u0085\u0001\u001a1\u0012'\u0012%\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u0018¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00060]X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010`\"\u0005\b\u0087\u0001\u0010bR9\u0010\u0088\u0001\u001a\u001e\u0012\u0014\u0012\u00120\u001c¢\u0006\r\b\u000e\u0012\t\b\u000f\u0012\u0005\b\b(\u0089\u0001\u0012\u0004\u0012\u00020\u00060]X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010`\"\u0005\b\u008b\u0001\u0010bRb\u0010\u008c\u0001\u001aG\u0012\u0014\u0012\u00120\u001c¢\u0006\r\b\u000e\u0012\t\b\u000f\u0012\u0005\b\b(\u008d\u0001\u0012'\u0012%\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u008e\u0001¢\u0006\r\b\u000e\u0012\t\b\u000f\u0012\u0005\b\b(\u008f\u0001\u0012\u0004\u0012\u00020\u00060>X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010C\"\u0005\b\u0091\u0001\u0010ER9\u0010\u0092\u0001\u001a\u001e\u0012\u0014\u0012\u00120?¢\u0006\r\b\u000e\u0012\t\b\u000f\u0012\u0005\b\b(\u0093\u0001\u0012\u0004\u0012\u00020\u00060]X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010`\"\u0005\b\u0095\u0001\u0010b¨\u0006¢\u0001"}, d2 = {"Lcom/brentvatne/common/react/VideoEventEmitter;", "", "<init>", "()V", "onVideoLoadStart", "Lkotlin/Function0;", "", "getOnVideoLoadStart", "()Lkotlin/jvm/functions/Function0;", "setOnVideoLoadStart", "(Lkotlin/jvm/functions/Function0;)V", "onVideoLoad", "Lkotlin/Function8;", "", "Lkotlin/ParameterName;", "name", TypedValues.TransitionType.S_DURATION, "currentPosition", "", "videoWidth", "videoHeight", "Ljava/util/ArrayList;", "Lcom/brentvatne/common/api/Track;", "audioTracks", "Lkotlin/collections/ArrayList;", "textTracks", "Lcom/brentvatne/common/api/VideoTrack;", "videoTracks", "", "trackId", "getOnVideoLoad", "()Lkotlin/jvm/functions/Function8;", "setOnVideoLoad", "(Lkotlin/jvm/functions/Function8;)V", "onVideoError", "Lkotlin/Function3;", "errorString", "Ljava/lang/Exception;", "exception", "Lkotlin/Exception;", "errorCode", "getOnVideoError", "()Lkotlin/jvm/functions/Function3;", "setOnVideoError", "(Lkotlin/jvm/functions/Function3;)V", "onVideoProgress", "Lkotlin/Function4;", "bufferedDuration", "seekableDuration", "", "currentPlaybackTime", "getOnVideoProgress", "()Lkotlin/jvm/functions/Function4;", "setOnVideoProgress", "(Lkotlin/jvm/functions/Function4;)V", "onVideoBandwidthUpdate", "bitRateEstimate", "height", "width", "getOnVideoBandwidthUpdate", "setOnVideoBandwidthUpdate", "onVideoPlaybackStateChanged", "Lkotlin/Function2;", "", "isPlaying", "isSeeking", "getOnVideoPlaybackStateChanged", "()Lkotlin/jvm/functions/Function2;", "setOnVideoPlaybackStateChanged", "(Lkotlin/jvm/functions/Function2;)V", "onVideoSeek", "seekTime", "getOnVideoSeek", "setOnVideoSeek", "onVideoEnd", "getOnVideoEnd", "setOnVideoEnd", "onVideoFullscreenPlayerWillPresent", "getOnVideoFullscreenPlayerWillPresent", "setOnVideoFullscreenPlayerWillPresent", "onVideoFullscreenPlayerDidPresent", "getOnVideoFullscreenPlayerDidPresent", "setOnVideoFullscreenPlayerDidPresent", "onVideoFullscreenPlayerWillDismiss", "getOnVideoFullscreenPlayerWillDismiss", "setOnVideoFullscreenPlayerWillDismiss", "onVideoFullscreenPlayerDidDismiss", "getOnVideoFullscreenPlayerDidDismiss", "setOnVideoFullscreenPlayerDidDismiss", "onReadyForDisplay", "getOnReadyForDisplay", "setOnReadyForDisplay", "onVideoBuffer", "Lkotlin/Function1;", "isBuffering", "getOnVideoBuffer", "()Lkotlin/jvm/functions/Function1;", "setOnVideoBuffer", "(Lkotlin/jvm/functions/Function1;)V", "onControlsVisibilityChange", "isVisible", "getOnControlsVisibilityChange", "setOnControlsVisibilityChange", "onVideoIdle", "getOnVideoIdle", "setOnVideoIdle", "onTimedMetadata", "Lcom/brentvatne/common/api/TimedMetadata;", "metadataArrayList", "getOnTimedMetadata", "setOnTimedMetadata", "onVideoAudioBecomingNoisy", "getOnVideoAudioBecomingNoisy", "setOnVideoAudioBecomingNoisy", "onAudioFocusChanged", "hasFocus", "getOnAudioFocusChanged", "setOnAudioFocusChanged", "onPlaybackRateChange", "", "rate", "getOnPlaybackRateChange", "setOnPlaybackRateChange", "onVolumeChange", "volume", "getOnVolumeChange", "setOnVolumeChange", "onAudioTracks", "getOnAudioTracks", "setOnAudioTracks", "onTextTracks", "getOnTextTracks", "setOnTextTracks", "onVideoTracks", "getOnVideoTracks", "setOnVideoTracks", "onTextTrackDataChanged", "textTrackData", "getOnTextTrackDataChanged", "setOnTextTrackDataChanged", "onReceiveAdEvent", "adEvent", "", "adData", "getOnReceiveAdEvent", "setOnReceiveAdEvent", "onPictureInPictureStatusChanged", "isActive", "getOnPictureInPictureStatusChanged", "setOnPictureInPictureStatusChanged", "addEventEmitters", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "view", "Lcom/brentvatne/exoplayer/ReactExoplayerView;", "audioTracksToArray", "Lcom/facebook/react/bridge/WritableArray;", "videoTracksToArray", "textTracksToArray", "aspectRatioToNaturalSize", "Lcom/facebook/react/bridge/WritableMap;", "EventBuilder", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVideoEventEmitter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VideoEventEmitter.kt\ncom/brentvatne/common/react/VideoEventEmitter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,366:1\n1872#2,2:367\n1874#2:370\n1872#2,3:371\n1872#2,3:374\n1872#2,3:377\n1#3:369\n*S KotlinDebug\n*F\n+ 1 VideoEventEmitter.kt\ncom/brentvatne/common/react/VideoEventEmitter\n*L\n301#1:367,2\n301#1:370\n317#1:371,3\n335#1:374,3\n218#1:377,3\n*E\n"})
/* loaded from: classes2.dex */
public final class VideoEventEmitter {
    public Function1<? super Boolean, Unit> onAudioFocusChanged;
    public Function1<? super ArrayList<Track>, Unit> onAudioTracks;
    public Function1<? super Boolean, Unit> onControlsVisibilityChange;
    public Function1<? super Boolean, Unit> onPictureInPictureStatusChanged;
    public Function1<? super Float, Unit> onPlaybackRateChange;
    public Function0<Unit> onReadyForDisplay;
    public Function2<? super String, ? super Map<String, String>, Unit> onReceiveAdEvent;
    public Function1<? super String, Unit> onTextTrackDataChanged;
    public Function1<? super ArrayList<Track>, Unit> onTextTracks;
    public Function1<? super ArrayList<TimedMetadata>, Unit> onTimedMetadata;
    public Function0<Unit> onVideoAudioBecomingNoisy;
    public Function4<? super Long, ? super Integer, ? super Integer, ? super String, Unit> onVideoBandwidthUpdate;
    public Function1<? super Boolean, Unit> onVideoBuffer;
    public Function0<Unit> onVideoEnd;
    public Function3<? super String, ? super Exception, ? super String, Unit> onVideoError;
    public Function0<Unit> onVideoFullscreenPlayerDidDismiss;
    public Function0<Unit> onVideoFullscreenPlayerDidPresent;
    public Function0<Unit> onVideoFullscreenPlayerWillDismiss;
    public Function0<Unit> onVideoFullscreenPlayerWillPresent;
    public Function0<Unit> onVideoIdle;
    public Function8<? super Long, ? super Long, ? super Integer, ? super Integer, ? super ArrayList<Track>, ? super ArrayList<Track>, ? super ArrayList<VideoTrack>, ? super String, Unit> onVideoLoad;
    public Function0<Unit> onVideoLoadStart;
    public Function2<? super Boolean, ? super Boolean, Unit> onVideoPlaybackStateChanged;
    public Function4<? super Long, ? super Long, ? super Long, ? super Double, Unit> onVideoProgress;
    public Function2<? super Long, ? super Long, Unit> onVideoSeek;
    public Function1<? super ArrayList<VideoTrack>, Unit> onVideoTracks;
    public Function1<? super Float, Unit> onVolumeChange;

    @NotNull
    public final Function0<Unit> getOnVideoLoadStart() {
        Function0<Unit> function0 = this.onVideoLoadStart;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onVideoLoadStart");
        return null;
    }

    public final void setOnVideoLoadStart(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onVideoLoadStart = function0;
    }

    @NotNull
    public final Function8<Long, Long, Integer, Integer, ArrayList<Track>, ArrayList<Track>, ArrayList<VideoTrack>, String, Unit> getOnVideoLoad() {
        Function8 function8 = this.onVideoLoad;
        if (function8 != null) {
            return function8;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onVideoLoad");
        return null;
    }

    public final void setOnVideoLoad(@NotNull Function8<? super Long, ? super Long, ? super Integer, ? super Integer, ? super ArrayList<Track>, ? super ArrayList<Track>, ? super ArrayList<VideoTrack>, ? super String, Unit> function8) {
        Intrinsics.checkNotNullParameter(function8, "<set-?>");
        this.onVideoLoad = function8;
    }

    @NotNull
    public final Function3<String, Exception, String, Unit> getOnVideoError() {
        Function3 function3 = this.onVideoError;
        if (function3 != null) {
            return function3;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onVideoError");
        return null;
    }

    public final void setOnVideoError(@NotNull Function3<? super String, ? super Exception, ? super String, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.onVideoError = function3;
    }

    @NotNull
    public final Function4<Long, Long, Long, Double, Unit> getOnVideoProgress() {
        Function4 function4 = this.onVideoProgress;
        if (function4 != null) {
            return function4;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onVideoProgress");
        return null;
    }

    public final void setOnVideoProgress(@NotNull Function4<? super Long, ? super Long, ? super Long, ? super Double, Unit> function4) {
        Intrinsics.checkNotNullParameter(function4, "<set-?>");
        this.onVideoProgress = function4;
    }

    @NotNull
    public final Function4<Long, Integer, Integer, String, Unit> getOnVideoBandwidthUpdate() {
        Function4 function4 = this.onVideoBandwidthUpdate;
        if (function4 != null) {
            return function4;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onVideoBandwidthUpdate");
        return null;
    }

    public final void setOnVideoBandwidthUpdate(@NotNull Function4<? super Long, ? super Integer, ? super Integer, ? super String, Unit> function4) {
        Intrinsics.checkNotNullParameter(function4, "<set-?>");
        this.onVideoBandwidthUpdate = function4;
    }

    @NotNull
    public final Function2<Boolean, Boolean, Unit> getOnVideoPlaybackStateChanged() {
        Function2 function2 = this.onVideoPlaybackStateChanged;
        if (function2 != null) {
            return function2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onVideoPlaybackStateChanged");
        return null;
    }

    public final void setOnVideoPlaybackStateChanged(@NotNull Function2<? super Boolean, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.onVideoPlaybackStateChanged = function2;
    }

    @NotNull
    public final Function2<Long, Long, Unit> getOnVideoSeek() {
        Function2 function2 = this.onVideoSeek;
        if (function2 != null) {
            return function2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onVideoSeek");
        return null;
    }

    public final void setOnVideoSeek(@NotNull Function2<? super Long, ? super Long, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.onVideoSeek = function2;
    }

    @NotNull
    public final Function0<Unit> getOnVideoEnd() {
        Function0<Unit> function0 = this.onVideoEnd;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onVideoEnd");
        return null;
    }

    public final void setOnVideoEnd(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onVideoEnd = function0;
    }

    @NotNull
    public final Function0<Unit> getOnVideoFullscreenPlayerWillPresent() {
        Function0<Unit> function0 = this.onVideoFullscreenPlayerWillPresent;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onVideoFullscreenPlayerWillPresent");
        return null;
    }

    public final void setOnVideoFullscreenPlayerWillPresent(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onVideoFullscreenPlayerWillPresent = function0;
    }

    @NotNull
    public final Function0<Unit> getOnVideoFullscreenPlayerDidPresent() {
        Function0<Unit> function0 = this.onVideoFullscreenPlayerDidPresent;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onVideoFullscreenPlayerDidPresent");
        return null;
    }

    public final void setOnVideoFullscreenPlayerDidPresent(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onVideoFullscreenPlayerDidPresent = function0;
    }

    @NotNull
    public final Function0<Unit> getOnVideoFullscreenPlayerWillDismiss() {
        Function0<Unit> function0 = this.onVideoFullscreenPlayerWillDismiss;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onVideoFullscreenPlayerWillDismiss");
        return null;
    }

    public final void setOnVideoFullscreenPlayerWillDismiss(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onVideoFullscreenPlayerWillDismiss = function0;
    }

    @NotNull
    public final Function0<Unit> getOnVideoFullscreenPlayerDidDismiss() {
        Function0<Unit> function0 = this.onVideoFullscreenPlayerDidDismiss;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onVideoFullscreenPlayerDidDismiss");
        return null;
    }

    public final void setOnVideoFullscreenPlayerDidDismiss(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onVideoFullscreenPlayerDidDismiss = function0;
    }

    @NotNull
    public final Function0<Unit> getOnReadyForDisplay() {
        Function0<Unit> function0 = this.onReadyForDisplay;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onReadyForDisplay");
        return null;
    }

    public final void setOnReadyForDisplay(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onReadyForDisplay = function0;
    }

    @NotNull
    public final Function1<Boolean, Unit> getOnVideoBuffer() {
        Function1 function1 = this.onVideoBuffer;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onVideoBuffer");
        return null;
    }

    public final void setOnVideoBuffer(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onVideoBuffer = function1;
    }

    @NotNull
    public final Function1<Boolean, Unit> getOnControlsVisibilityChange() {
        Function1 function1 = this.onControlsVisibilityChange;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onControlsVisibilityChange");
        return null;
    }

    public final void setOnControlsVisibilityChange(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onControlsVisibilityChange = function1;
    }

    @NotNull
    public final Function0<Unit> getOnVideoIdle() {
        Function0<Unit> function0 = this.onVideoIdle;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onVideoIdle");
        return null;
    }

    public final void setOnVideoIdle(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onVideoIdle = function0;
    }

    @NotNull
    public final Function1<ArrayList<TimedMetadata>, Unit> getOnTimedMetadata() {
        Function1 function1 = this.onTimedMetadata;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onTimedMetadata");
        return null;
    }

    public final void setOnTimedMetadata(@NotNull Function1<? super ArrayList<TimedMetadata>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onTimedMetadata = function1;
    }

    @NotNull
    public final Function0<Unit> getOnVideoAudioBecomingNoisy() {
        Function0<Unit> function0 = this.onVideoAudioBecomingNoisy;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onVideoAudioBecomingNoisy");
        return null;
    }

    public final void setOnVideoAudioBecomingNoisy(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onVideoAudioBecomingNoisy = function0;
    }

    @NotNull
    public final Function1<Boolean, Unit> getOnAudioFocusChanged() {
        Function1 function1 = this.onAudioFocusChanged;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onAudioFocusChanged");
        return null;
    }

    public final void setOnAudioFocusChanged(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onAudioFocusChanged = function1;
    }

    @NotNull
    public final Function1<Float, Unit> getOnPlaybackRateChange() {
        Function1 function1 = this.onPlaybackRateChange;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onPlaybackRateChange");
        return null;
    }

    public final void setOnPlaybackRateChange(@NotNull Function1<? super Float, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onPlaybackRateChange = function1;
    }

    @NotNull
    public final Function1<Float, Unit> getOnVolumeChange() {
        Function1 function1 = this.onVolumeChange;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onVolumeChange");
        return null;
    }

    public final void setOnVolumeChange(@NotNull Function1<? super Float, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onVolumeChange = function1;
    }

    @NotNull
    public final Function1<ArrayList<Track>, Unit> getOnAudioTracks() {
        Function1 function1 = this.onAudioTracks;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onAudioTracks");
        return null;
    }

    public final void setOnAudioTracks(@NotNull Function1<? super ArrayList<Track>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onAudioTracks = function1;
    }

    @NotNull
    public final Function1<ArrayList<Track>, Unit> getOnTextTracks() {
        Function1 function1 = this.onTextTracks;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onTextTracks");
        return null;
    }

    public final void setOnTextTracks(@NotNull Function1<? super ArrayList<Track>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onTextTracks = function1;
    }

    @NotNull
    public final Function1<ArrayList<VideoTrack>, Unit> getOnVideoTracks() {
        Function1 function1 = this.onVideoTracks;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onVideoTracks");
        return null;
    }

    public final void setOnVideoTracks(@NotNull Function1<? super ArrayList<VideoTrack>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onVideoTracks = function1;
    }

    @NotNull
    public final Function1<String, Unit> getOnTextTrackDataChanged() {
        Function1 function1 = this.onTextTrackDataChanged;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onTextTrackDataChanged");
        return null;
    }

    public final void setOnTextTrackDataChanged(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onTextTrackDataChanged = function1;
    }

    @NotNull
    public final Function2<String, Map<String, String>, Unit> getOnReceiveAdEvent() {
        Function2 function2 = this.onReceiveAdEvent;
        if (function2 != null) {
            return function2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onReceiveAdEvent");
        return null;
    }

    public final void setOnReceiveAdEvent(@NotNull Function2<? super String, ? super Map<String, String>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.onReceiveAdEvent = function2;
    }

    @NotNull
    public final Function1<Boolean, Unit> getOnPictureInPictureStatusChanged() {
        Function1 function1 = this.onPictureInPictureStatusChanged;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onPictureInPictureStatusChanged");
        return null;
    }

    public final void setOnPictureInPictureStatusChanged(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onPictureInPictureStatusChanged = function1;
    }

    public final void addEventEmitters(@NotNull ThemedReactContext reactContext, @NotNull ReactExoplayerView view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, view.getId());
        int surfaceId = UIManagerHelper.getSurfaceId(reactContext);
        if (eventDispatcherForReactTag != null) {
            final EventBuilder eventBuilder = new EventBuilder(surfaceId, view.getId(), eventDispatcherForReactTag);
            setOnVideoLoadStart(new Function0() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return VideoEventEmitter.addEventEmitters$lambda$0(eventBuilder);
                }
            });
            setOnVideoLoad(new Function8() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function8
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
                    return VideoEventEmitter.addEventEmitters$lambda$3(eventBuilder, this, ((Long) obj).longValue(), ((Long) obj2).longValue(), ((Integer) obj3).intValue(), ((Integer) obj4).intValue(), (ArrayList) obj5, (ArrayList) obj6, (ArrayList) obj7, (String) obj8);
                }
            });
            setOnVideoError(new Function3() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return VideoEventEmitter.addEventEmitters$lambda$6(eventBuilder, (String) obj, (Exception) obj2, (String) obj3);
                }
            });
            setOnVideoProgress(new Function4() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return VideoEventEmitter.addEventEmitters$lambda$8(eventBuilder, ((Long) obj).longValue(), ((Long) obj2).longValue(), ((Long) obj3).longValue(), ((Double) obj4).doubleValue());
                }
            });
            setOnVideoBandwidthUpdate(new Function4() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return VideoEventEmitter.addEventEmitters$lambda$11(eventBuilder, ((Long) obj).longValue(), ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (String) obj4);
                }
            });
            setOnVideoPlaybackStateChanged(new Function2() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VideoEventEmitter.addEventEmitters$lambda$13(eventBuilder, ((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue());
                }
            });
            setOnVideoSeek(new Function2() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VideoEventEmitter.addEventEmitters$lambda$15(eventBuilder, ((Long) obj).longValue(), ((Long) obj2).longValue());
                }
            });
            setOnVideoEnd(new Function0() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return VideoEventEmitter.addEventEmitters$lambda$16(eventBuilder);
                }
            });
            setOnVideoFullscreenPlayerWillPresent(new Function0() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return VideoEventEmitter.addEventEmitters$lambda$17(eventBuilder);
                }
            });
            setOnVideoFullscreenPlayerDidPresent(new Function0() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return VideoEventEmitter.addEventEmitters$lambda$18(eventBuilder);
                }
            });
            setOnVideoFullscreenPlayerWillDismiss(new Function0() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return VideoEventEmitter.addEventEmitters$lambda$19(eventBuilder);
                }
            });
            setOnVideoFullscreenPlayerDidDismiss(new Function0() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return VideoEventEmitter.addEventEmitters$lambda$20(eventBuilder);
                }
            });
            setOnReadyForDisplay(new Function0() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return VideoEventEmitter.addEventEmitters$lambda$21(eventBuilder);
                }
            });
            setOnVideoBuffer(new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return VideoEventEmitter.addEventEmitters$lambda$23(eventBuilder, ((Boolean) obj).booleanValue());
                }
            });
            setOnControlsVisibilityChange(new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return VideoEventEmitter.addEventEmitters$lambda$25(eventBuilder, ((Boolean) obj).booleanValue());
                }
            });
            setOnVideoIdle(new Function0() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return VideoEventEmitter.addEventEmitters$lambda$26(eventBuilder);
                }
            });
            setOnTimedMetadata(new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return VideoEventEmitter.addEventEmitters$lambda$31(eventBuilder, (ArrayList) obj);
                }
            });
            setOnVideoAudioBecomingNoisy(new Function0() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return VideoEventEmitter.addEventEmitters$lambda$32(eventBuilder);
                }
            });
            setOnAudioFocusChanged(new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return VideoEventEmitter.addEventEmitters$lambda$34(eventBuilder, ((Boolean) obj).booleanValue());
                }
            });
            setOnPlaybackRateChange(new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return VideoEventEmitter.addEventEmitters$lambda$36(eventBuilder, ((Float) obj).floatValue());
                }
            });
            setOnVolumeChange(new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return VideoEventEmitter.addEventEmitters$lambda$38(eventBuilder, ((Float) obj).floatValue());
                }
            });
            setOnAudioTracks(new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return VideoEventEmitter.addEventEmitters$lambda$40(eventBuilder, this, (ArrayList) obj);
                }
            });
            setOnTextTracks(new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return VideoEventEmitter.addEventEmitters$lambda$42(eventBuilder, this, (ArrayList) obj);
                }
            });
            setOnVideoTracks(new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return VideoEventEmitter.addEventEmitters$lambda$44(eventBuilder, this, (ArrayList) obj);
                }
            });
            setOnTextTrackDataChanged(new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return VideoEventEmitter.addEventEmitters$lambda$46(eventBuilder, (String) obj);
                }
            });
            setOnReceiveAdEvent(new Function2() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VideoEventEmitter.addEventEmitters$lambda$50(eventBuilder, (String) obj, (Map) obj2);
                }
            });
            setOnPictureInPictureStatusChanged(new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return VideoEventEmitter.addEventEmitters$lambda$52(eventBuilder, ((Boolean) obj).booleanValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$0(EventBuilder eventBuilder) {
        EventBuilder.dispatch$default(eventBuilder, EventTypes.EVENT_LOAD_START, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$3(EventBuilder eventBuilder, final VideoEventEmitter videoEventEmitter, final long j, final long j2, final int i, final int i2, final ArrayList audioTracks, final ArrayList textTracks, final ArrayList videoTracks, final String str) {
        Intrinsics.checkNotNullParameter(audioTracks, "audioTracks");
        Intrinsics.checkNotNullParameter(textTracks, "textTracks");
        Intrinsics.checkNotNullParameter(videoTracks, "videoTracks");
        eventBuilder.dispatch(EventTypes.EVENT_LOAD, new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoEventEmitter.addEventEmitters$lambda$3$lambda$2(j, j2, videoEventEmitter, i, i2, str, videoTracks, audioTracks, textTracks, (WritableMap) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$3$lambda$2(long j, long j2, VideoEventEmitter videoEventEmitter, int i, int i2, String str, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, WritableMap dispatch) {
        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
        dispatch.putDouble(TypedValues.TransitionType.S_DURATION, j / 1000.0d);
        dispatch.putDouble("currentTime", j2 / 1000.0d);
        dispatch.putMap("naturalSize", videoEventEmitter.aspectRatioToNaturalSize(i, i2));
        if (str != null) {
            dispatch.putString("trackId", str);
        }
        dispatch.putArray("videoTracks", videoEventEmitter.videoTracksToArray(arrayList));
        dispatch.putArray("audioTracks", videoEventEmitter.audioTracksToArray(arrayList2));
        dispatch.putArray("textTracks", videoEventEmitter.textTracksToArray(arrayList3));
        dispatch.putBoolean("canPlayFastForward", true);
        dispatch.putBoolean("canPlaySlowForward", true);
        dispatch.putBoolean("canPlaySlowReverse", true);
        dispatch.putBoolean("canPlayReverse", true);
        dispatch.putBoolean("canPlayFastForward", true);
        dispatch.putBoolean("canStepBackward", true);
        dispatch.putBoolean("canStepForward", true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$6(EventBuilder eventBuilder, final String errorString, final Exception exception, final String errorCode) {
        Intrinsics.checkNotNullParameter(errorString, "errorString");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        eventBuilder.dispatch(EventTypes.EVENT_ERROR, new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoEventEmitter.addEventEmitters$lambda$6$lambda$5(exception, errorString, errorCode, (WritableMap) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$6$lambda$5(Exception exc, String str, String str2, WritableMap dispatch) {
        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
        WritableMap writableMapCreateMap = Arguments.createMap();
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        String string = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        writableMapCreateMap.putString("errorString", str);
        writableMapCreateMap.putString("errorException", exc.toString());
        writableMapCreateMap.putString("errorCode", str2);
        writableMapCreateMap.putString("errorStackTrace", string);
        Unit unit = Unit.INSTANCE;
        dispatch.putMap(Constants.IPC_BUNDLE_KEY_SEND_ERROR, writableMapCreateMap);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$8(EventBuilder eventBuilder, final long j, final long j2, final long j3, final double d) {
        eventBuilder.dispatch(EventTypes.EVENT_PROGRESS, new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoEventEmitter.addEventEmitters$lambda$8$lambda$7(j, j2, j3, d, (WritableMap) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$8$lambda$7(long j, long j2, long j3, double d, WritableMap dispatch) {
        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
        dispatch.putDouble("currentTime", j / 1000.0d);
        dispatch.putDouble("playableDuration", j2 / 1000.0d);
        dispatch.putDouble("seekableDuration", j3 / 1000.0d);
        dispatch.putDouble("currentPlaybackTime", d);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$11(EventBuilder eventBuilder, final long j, final int i, final int i2, final String str) {
        eventBuilder.dispatch(EventTypes.EVENT_BANDWIDTH, new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoEventEmitter.addEventEmitters$lambda$11$lambda$10(j, i2, i, str, (WritableMap) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$11$lambda$10(long j, int i, int i2, String str, WritableMap dispatch) {
        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
        dispatch.putDouble(TCVideoEventPropertiesNames.TCV_BITRATE, j);
        if (i > 0) {
            dispatch.putInt("width", i);
        }
        if (i2 > 0) {
            dispatch.putInt("height", i2);
        }
        if (str != null) {
            dispatch.putString("trackId", str);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$13(EventBuilder eventBuilder, final boolean z, final boolean z2) {
        eventBuilder.dispatch(EventTypes.EVENT_PLAYBACK_STATE_CHANGED, new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoEventEmitter.addEventEmitters$lambda$13$lambda$12(z, z2, (WritableMap) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$13$lambda$12(boolean z, boolean z2, WritableMap dispatch) {
        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
        dispatch.putBoolean("isPlaying", z);
        dispatch.putBoolean("isSeeking", z2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$15(EventBuilder eventBuilder, final long j, final long j2) {
        eventBuilder.dispatch(EventTypes.EVENT_SEEK, new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda39
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoEventEmitter.addEventEmitters$lambda$15$lambda$14(j, j2, (WritableMap) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$15$lambda$14(long j, long j2, WritableMap dispatch) {
        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
        dispatch.putDouble("currentTime", j / 1000.0d);
        dispatch.putDouble("seekTime", j2 / 1000.0d);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$16(EventBuilder eventBuilder) {
        EventBuilder.dispatch$default(eventBuilder, EventTypes.EVENT_END, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$17(EventBuilder eventBuilder) {
        EventBuilder.dispatch$default(eventBuilder, EventTypes.EVENT_FULLSCREEN_WILL_PRESENT, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$18(EventBuilder eventBuilder) {
        EventBuilder.dispatch$default(eventBuilder, EventTypes.EVENT_FULLSCREEN_DID_PRESENT, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$19(EventBuilder eventBuilder) {
        EventBuilder.dispatch$default(eventBuilder, EventTypes.EVENT_FULLSCREEN_WILL_DISMISS, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$20(EventBuilder eventBuilder) {
        EventBuilder.dispatch$default(eventBuilder, EventTypes.EVENT_FULLSCREEN_DID_DISMISS, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$21(EventBuilder eventBuilder) {
        EventBuilder.dispatch$default(eventBuilder, EventTypes.EVENT_READY, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$23(EventBuilder eventBuilder, final boolean z) {
        eventBuilder.dispatch(EventTypes.EVENT_BUFFER, new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda42
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoEventEmitter.addEventEmitters$lambda$23$lambda$22(z, (WritableMap) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$23$lambda$22(boolean z, WritableMap dispatch) {
        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
        dispatch.putBoolean("isBuffering", z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$25(EventBuilder eventBuilder, final boolean z) {
        eventBuilder.dispatch(EventTypes.EVENT_CONTROLS_VISIBILITY_CHANGE, new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda40
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoEventEmitter.addEventEmitters$lambda$25$lambda$24(z, (WritableMap) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$25$lambda$24(boolean z, WritableMap dispatch) {
        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
        dispatch.putBoolean("isVisible", z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$26(EventBuilder eventBuilder) {
        EventBuilder.dispatch$default(eventBuilder, EventTypes.EVENT_IDLE, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$31(EventBuilder eventBuilder, final ArrayList metadataArrayList) {
        Intrinsics.checkNotNullParameter(metadataArrayList, "metadataArrayList");
        if (metadataArrayList.size() == 0) {
            return Unit.INSTANCE;
        }
        eventBuilder.dispatch(EventTypes.EVENT_TIMED_METADATA, new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoEventEmitter.addEventEmitters$lambda$31$lambda$30(metadataArrayList, (WritableMap) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$31$lambda$30(ArrayList arrayList, WritableMap dispatch) {
        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
        WritableArray writableArrayCreateArray = Arguments.createArray();
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TimedMetadata timedMetadata = (TimedMetadata) obj;
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("identifier", timedMetadata.getIdentifier());
            writableMapCreateMap.putString("value", timedMetadata.getValue());
            writableArrayCreateArray.pushMap(writableMapCreateMap);
            i = i2;
        }
        Unit unit = Unit.INSTANCE;
        dispatch.putArray("metadata", writableArrayCreateArray);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$32(EventBuilder eventBuilder) {
        EventBuilder.dispatch$default(eventBuilder, EventTypes.EVENT_AUDIO_BECOMING_NOISY, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$34(EventBuilder eventBuilder, final boolean z) {
        eventBuilder.dispatch(EventTypes.EVENT_AUDIO_FOCUS_CHANGE, new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoEventEmitter.addEventEmitters$lambda$34$lambda$33(z, (WritableMap) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$34$lambda$33(boolean z, WritableMap dispatch) {
        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
        dispatch.putBoolean("hasAudioFocus", z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$36(EventBuilder eventBuilder, final float f) {
        eventBuilder.dispatch(EventTypes.EVENT_PLAYBACK_RATE_CHANGE, new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoEventEmitter.addEventEmitters$lambda$36$lambda$35(f, (WritableMap) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$36$lambda$35(float f, WritableMap dispatch) {
        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
        dispatch.putDouble("playbackRate", f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$38(EventBuilder eventBuilder, final float f) {
        eventBuilder.dispatch(EventTypes.EVENT_VOLUME_CHANGE, new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda44
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoEventEmitter.addEventEmitters$lambda$38$lambda$37(f, (WritableMap) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$38$lambda$37(float f, WritableMap dispatch) {
        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
        dispatch.putDouble("volume", f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$40(EventBuilder eventBuilder, final VideoEventEmitter videoEventEmitter, final ArrayList arrayList) {
        eventBuilder.dispatch(EventTypes.EVENT_AUDIO_TRACKS, new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoEventEmitter.addEventEmitters$lambda$40$lambda$39(this.f$0, arrayList, (WritableMap) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$40$lambda$39(VideoEventEmitter videoEventEmitter, ArrayList arrayList, WritableMap dispatch) {
        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
        dispatch.putArray("audioTracks", videoEventEmitter.audioTracksToArray(arrayList));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$42(EventBuilder eventBuilder, final VideoEventEmitter videoEventEmitter, final ArrayList arrayList) {
        eventBuilder.dispatch(EventTypes.EVENT_TEXT_TRACKS, new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoEventEmitter.addEventEmitters$lambda$42$lambda$41(this.f$0, arrayList, (WritableMap) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$42$lambda$41(VideoEventEmitter videoEventEmitter, ArrayList arrayList, WritableMap dispatch) {
        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
        dispatch.putArray("textTracks", videoEventEmitter.textTracksToArray(arrayList));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$44(EventBuilder eventBuilder, final VideoEventEmitter videoEventEmitter, final ArrayList arrayList) {
        eventBuilder.dispatch(EventTypes.EVENT_VIDEO_TRACKS, new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda43
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoEventEmitter.addEventEmitters$lambda$44$lambda$43(this.f$0, arrayList, (WritableMap) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$44$lambda$43(VideoEventEmitter videoEventEmitter, ArrayList arrayList, WritableMap dispatch) {
        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
        dispatch.putArray("videoTracks", videoEventEmitter.videoTracksToArray(arrayList));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$46(EventBuilder eventBuilder, final String textTrackData) {
        Intrinsics.checkNotNullParameter(textTrackData, "textTrackData");
        eventBuilder.dispatch(EventTypes.EVENT_TEXT_TRACK_DATA_CHANGED, new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoEventEmitter.addEventEmitters$lambda$46$lambda$45(textTrackData, (WritableMap) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$46$lambda$45(String str, WritableMap dispatch) {
        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
        dispatch.putString("subtitleTracks", str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$50(EventBuilder eventBuilder, final String adEvent, final Map map) {
        Intrinsics.checkNotNullParameter(adEvent, "adEvent");
        eventBuilder.dispatch(EventTypes.EVENT_ON_RECEIVE_AD_EVENT, new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoEventEmitter.addEventEmitters$lambda$50$lambda$49(adEvent, map, (WritableMap) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$50$lambda$49(String str, Map map, WritableMap dispatch) {
        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
        dispatch.putString("event", str);
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                Intrinsics.checkNotNull(str2);
                writableMapCreateMap.putString(str2, str3);
            }
        }
        Unit unit = Unit.INSTANCE;
        dispatch.putMap("data", writableMapCreateMap);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$52(EventBuilder eventBuilder, final boolean z) {
        eventBuilder.dispatch(EventTypes.EVENT_PICTURE_IN_PICTURE_STATUS_CHANGED, new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VideoEventEmitter.addEventEmitters$lambda$52$lambda$51(z, (WritableMap) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addEventEmitters$lambda$52$lambda$51(boolean z, WritableMap dispatch) {
        Intrinsics.checkNotNullParameter(dispatch, "$this$dispatch");
        dispatch.putBoolean("isActive", z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class EventBuilder {
        private final EventDispatcher dispatcher;
        private final int surfaceId;
        private final int viewId;

        public EventBuilder(int i, int i2, EventDispatcher dispatcher) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            this.surfaceId = i;
            this.viewId = i2;
            this.dispatcher = dispatcher;
        }

        public static /* synthetic */ void dispatch$default(EventBuilder eventBuilder, EventTypes eventTypes, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                function1 = null;
            }
            eventBuilder.dispatch(eventTypes, function1);
        }

        public final void dispatch(EventTypes event, Function1 function1) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.dispatcher.dispatchEvent(new VideoEventEmitter$EventBuilder$dispatch$1(event, function1, this.surfaceId, this.viewId));
        }
    }

    private final WritableArray audioTracksToArray(ArrayList audioTracks) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        if (audioTracks != null) {
            int i = 0;
            for (Object obj : audioTracks) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Track track = (Track) obj;
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putInt("index", i);
                writableMapCreateMap.putString("title", track.getTitle());
                String mimeType = track.getMimeType();
                if (mimeType != null) {
                    writableMapCreateMap.putString("type", mimeType);
                }
                String language = track.getLanguage();
                if (language != null) {
                    writableMapCreateMap.putString(TCEventPropertiesNames.TCD_LANGUAGE, language);
                }
                if (track.getBitrate() > 0) {
                    writableMapCreateMap.putInt(TCVideoEventPropertiesNames.TCV_BITRATE, track.getBitrate());
                }
                writableMapCreateMap.putBoolean("selected", track.getIsSelected());
                writableArrayCreateArray.pushMap(writableMapCreateMap);
                i = i2;
            }
        }
        Intrinsics.checkNotNullExpressionValue(writableArrayCreateArray, "apply(...)");
        return writableArrayCreateArray;
    }

    private final WritableArray videoTracksToArray(ArrayList videoTracks) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        if (videoTracks != null) {
            int i = 0;
            for (Object obj : videoTracks) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                VideoTrack videoTrack = (VideoTrack) obj;
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putInt("width", videoTrack.getWidth());
                writableMapCreateMap.putInt("height", videoTrack.getHeight());
                writableMapCreateMap.putInt(TCVideoEventPropertiesNames.TCV_BITRATE, videoTrack.getBitrate());
                writableMapCreateMap.putString("codecs", videoTrack.getCodecs());
                writableMapCreateMap.putString("trackId", videoTrack.getTrackId());
                writableMapCreateMap.putInt("index", videoTrack.getIndex());
                writableMapCreateMap.putBoolean("selected", videoTrack.getIsSelected());
                writableMapCreateMap.putInt("rotation", videoTrack.getRotation());
                writableArrayCreateArray.pushMap(writableMapCreateMap);
                i = i2;
            }
        }
        Intrinsics.checkNotNullExpressionValue(writableArrayCreateArray, "apply(...)");
        return writableArrayCreateArray;
    }

    private final WritableArray textTracksToArray(ArrayList textTracks) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        if (textTracks != null) {
            int i = 0;
            for (Object obj : textTracks) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Track track = (Track) obj;
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putInt("index", i);
                writableMapCreateMap.putString("title", track.getTitle());
                writableMapCreateMap.putString("type", track.getMimeType());
                writableMapCreateMap.putString(TCEventPropertiesNames.TCD_LANGUAGE, track.getLanguage());
                writableMapCreateMap.putBoolean("selected", track.getIsSelected());
                writableArrayCreateArray.pushMap(writableMapCreateMap);
                i = i2;
            }
        }
        Intrinsics.checkNotNullExpressionValue(writableArrayCreateArray, "apply(...)");
        return writableArrayCreateArray;
    }

    private final WritableMap aspectRatioToNaturalSize(int videoWidth, int videoHeight) {
        String str;
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (videoWidth > 0) {
            writableMapCreateMap.putInt("width", videoWidth);
        }
        if (videoHeight > 0) {
            writableMapCreateMap.putInt("height", videoHeight);
        }
        if (videoWidth > videoHeight) {
            str = "landscape";
        } else if (videoWidth < videoHeight) {
            str = "portrait";
        } else {
            str = "square";
        }
        writableMapCreateMap.putString("orientation", str);
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "apply(...)");
        return writableMapCreateMap;
    }
}
