package com.brentvatne.exoplayer;

import android.content.Context;
import com.brentvatne.common.api.BufferingStrategy;
import com.brentvatne.common.api.ControlsConfig;
import com.brentvatne.common.api.Source;
import com.brentvatne.common.api.SubtitleStyle;
import com.brentvatne.common.react.EventTypes;
import com.brentvatne.common.toolbox.DebugLog;
import com.brentvatne.common.toolbox.ReactBridgeUtils;
import com.brentvatne.react.ReactNativeVideoManager;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;
import java.util.MissingResourceException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u0000 T2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001TB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0014J\u001a\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\bH\u0007J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001cH\u0007J\u001a\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u0017H\u0007J\u001a\u0010!\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u0017H\u0007J\u001a\u0010#\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u0017H\u0007J\u0018\u0010%\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u001cH\u0007J\u0018\u0010'\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u001cH\u0007J\u0018\u0010)\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u001cH\u0007J\u0018\u0010+\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\bH\u0007J\u0018\u0010-\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010.\u001a\u00020/H\u0007J\u0018\u00100\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u00101\u001a\u00020/H\u0007J\u0018\u00102\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u001cH\u0007J\u0018\u00104\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u00105\u001a\u00020/H\u0007J\u0018\u00106\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u00107\u001a\u00020/H\u0007J\u0018\u00108\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u001cH\u0007J\u0018\u0010:\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u001cH\u0007J\u0018\u0010<\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u001cH\u0007J\u0018\u0010>\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\bH\u0007J\u0018\u0010@\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u001cH\u0007J\u0018\u0010B\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u001cH\u0007J\u0018\u0010D\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010E\u001a\u00020FH\u0007J\u0018\u0010G\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010H\u001a\u00020\u001cH\u0007J\u0018\u0010I\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010J\u001a\u00020\u001cH\u0007J\u001a\u0010K\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0018\u0010L\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010M\u001a\u00020FH\u0007J\u0018\u0010N\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010O\u001a\u00020\u001cH\u0007J\u001a\u0010P\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010Q\u001a\u0004\u0018\u00010\u0017H\u0007J\u001a\u0010R\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010S\u001a\u0004\u0018\u00010\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/brentvatne/exoplayer/ReactExoplayerViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/brentvatne/exoplayer/ReactExoplayerView;", "config", "Lcom/brentvatne/exoplayer/ReactExoplayerConfig;", "<init>", "(Lcom/brentvatne/exoplayer/ReactExoplayerConfig;)V", "getName", "", "createViewInstance", "themedReactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "onDropViewInstance", "", "view", "getExportedCustomDirectEventTypeConstants", "", "", "addEventEmitters", "reactContext", "setSrc", "videoView", ReactExoplayerViewManager.PROP_SRC, "Lcom/facebook/react/bridge/ReadableMap;", "setResizeMode", "resizeMode", "setRepeat", ReactExoplayerViewManager.PROP_REPEAT, "", "setPreventsDisplaySleepDuringVideoPlayback", "preventsSleep", "setSelectedVideoTrack", ReactExoplayerViewManager.PROP_SELECTED_VIDEO_TRACK, "setSelectedAudioTrack", ReactExoplayerViewManager.PROP_SELECTED_AUDIO_TRACK, "setSelectedTextTrack", ReactExoplayerViewManager.PROP_SELECTED_TEXT_TRACK, "setPaused", ReactExoplayerViewManager.PROP_PAUSED, "setMuted", ReactExoplayerViewManager.PROP_MUTED, "setEnterPictureInPictureOnLeave", ReactExoplayerViewManager.PROP_ENTER_PICTURE_IN_PICTURE_ON_LEAVE, "setAudioOutput", ReactExoplayerViewManager.PROP_AUDIO_OUTPUT, "setVolume", ReactExoplayerViewManager.PROP_VOLUME, "", "setProgressUpdateInterval", ReactExoplayerViewManager.PROP_PROGRESS_UPDATE_INTERVAL, "setReportBandwidth", ReactExoplayerViewManager.PROP_REPORT_BANDWIDTH, "setRate", ReactExoplayerViewManager.PROP_RATE, "setMaxBitRate", ReactExoplayerViewManager.PROP_MAXIMUM_BIT_RATE, "setPlayInBackground", ReactExoplayerViewManager.PROP_PLAY_IN_BACKGROUND, "setDisableFocus", ReactExoplayerViewManager.PROP_DISABLE_FOCUS, "setFocusable", ReactExoplayerViewManager.PROP_FOCUSABLE, "setBufferingStrategy", ReactExoplayerViewManager.PROP_BUFFERING_STRATEGY, "setDisableDisconnectError", ReactExoplayerViewManager.PROP_DISABLE_DISCONNECT_ERROR, "setFullscreen", "fullscreen", "setViewType", ReactExoplayerViewManager.PROP_VIEW_TYPE, "", "setHideShutterView", ReactExoplayerViewManager.PROP_HIDE_SHUTTER_VIEW, "setControls", ReactExoplayerViewManager.PROP_CONTROLS, "setSubtitleStyle", "setShutterColor", "color", "setShowNotificationControls", ReactExoplayerViewManager.PROP_SHOW_NOTIFICATION_CONTROLS, "setDebug", "debugConfig", "setControlsStyles", ReactExoplayerViewManager.PROP_CONTROLS_STYLES, "Companion", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ReactExoplayerViewManager extends ViewGroupManager<ReactExoplayerView> {

    @NotNull
    private static final String PROP_AUDIO_OUTPUT = "audioOutput";

    @NotNull
    private static final String PROP_BUFFERING_STRATEGY = "bufferingStrategy";

    @NotNull
    private static final String PROP_CONTROLS = "controls";

    @NotNull
    private static final String PROP_CONTROLS_STYLES = "controlsStyles";

    @NotNull
    private static final String PROP_DEBUG = "debug";

    @NotNull
    private static final String PROP_DISABLE_DISCONNECT_ERROR = "disableDisconnectError";

    @NotNull
    private static final String PROP_DISABLE_FOCUS = "disableFocus";

    @NotNull
    private static final String PROP_ENTER_PICTURE_IN_PICTURE_ON_LEAVE = "enterPictureInPictureOnLeave";

    @NotNull
    private static final String PROP_FOCUSABLE = "focusable";

    @NotNull
    private static final String PROP_FULLSCREEN = "fullscreen";

    @NotNull
    private static final String PROP_HIDE_SHUTTER_VIEW = "hideShutterView";

    @NotNull
    private static final String PROP_MAXIMUM_BIT_RATE = "maxBitRate";

    @NotNull
    private static final String PROP_MUTED = "muted";

    @NotNull
    private static final String PROP_PAUSED = "paused";

    @NotNull
    private static final String PROP_PLAY_IN_BACKGROUND = "playInBackground";

    @NotNull
    private static final String PROP_PREVENTS_DISPLAY_SLEEP_DURING_VIDEO_PLAYBACK = "preventsDisplaySleepDuringVideoPlayback";

    @NotNull
    private static final String PROP_PROGRESS_UPDATE_INTERVAL = "progressUpdateInterval";

    @NotNull
    private static final String PROP_RATE = "rate";

    @NotNull
    private static final String PROP_REPEAT = "repeat";

    @NotNull
    private static final String PROP_REPORT_BANDWIDTH = "reportBandwidth";

    @NotNull
    private static final String PROP_RESIZE_MODE = "resizeMode";

    @NotNull
    private static final String PROP_SELECTED_AUDIO_TRACK = "selectedAudioTrack";

    @NotNull
    private static final String PROP_SELECTED_AUDIO_TRACK_TYPE = "type";

    @NotNull
    private static final String PROP_SELECTED_AUDIO_TRACK_VALUE = "value";

    @NotNull
    private static final String PROP_SELECTED_TEXT_TRACK = "selectedTextTrack";

    @NotNull
    private static final String PROP_SELECTED_TEXT_TRACK_TYPE = "type";

    @NotNull
    private static final String PROP_SELECTED_TEXT_TRACK_VALUE = "value";

    @NotNull
    private static final String PROP_SELECTED_VIDEO_TRACK = "selectedVideoTrack";

    @NotNull
    private static final String PROP_SELECTED_VIDEO_TRACK_TYPE = "type";

    @NotNull
    private static final String PROP_SELECTED_VIDEO_TRACK_VALUE = "value";

    @NotNull
    private static final String PROP_SHOW_NOTIFICATION_CONTROLS = "showNotificationControls";

    @NotNull
    private static final String PROP_SHUTTER_COLOR = "shutterColor";

    @NotNull
    private static final String PROP_SRC = "src";

    @NotNull
    private static final String PROP_SUBTITLE_STYLE = "subtitleStyle";

    @NotNull
    private static final String PROP_VIEW_TYPE = "viewType";

    @NotNull
    private static final String PROP_VOLUME = "volume";

    @NotNull
    private static final String REACT_CLASS = "RCTVideo";

    @NotNull
    private static final String TAG = "ExoViewManager";

    @NotNull
    private final ReactExoplayerConfig config;

    public ReactExoplayerViewManager(@NotNull ReactExoplayerConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ReactExoplayerView createViewInstance(@NotNull ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "themedReactContext");
        ReactNativeVideoManager.INSTANCE.getInstance().registerView(this);
        return new ReactExoplayerView(themedReactContext, this.config);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(@NotNull ReactExoplayerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.cleanUpResources();
        view.exitPictureInPictureMode();
        ReactNativeVideoManager.INSTANCE.getInstance().unregisterView(this);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @NotNull
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return EventTypes.INSTANCE.toMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(@NotNull ThemedReactContext reactContext, @NotNull ReactExoplayerView view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        super.addEventEmitters(reactContext, (ThemedReactContext) view);
        view.eventEmitter.addEventEmitters(reactContext, view);
    }

    @ReactProp(name = PROP_SRC)
    public final void setSrc(@NotNull ReactExoplayerView videoView, @Nullable ReadableMap src) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        Context applicationContext = videoView.getContext().getApplicationContext();
        Source.Companion companion = Source.INSTANCE;
        Intrinsics.checkNotNull(applicationContext);
        videoView.setSrc(companion.parse(src, applicationContext));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        if (r4.equals("none") != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
    
        r3.setResizeModeModifier(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
    
        if (r4.equals("contain") == false) goto L17;
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "resizeMode")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setResizeMode(@org.jetbrains.annotations.NotNull com.brentvatne.exoplayer.ReactExoplayerView r3, @org.jetbrains.annotations.NotNull java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r2 = "videoView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            java.lang.String r2 = "resizeMode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            int r2 = r4.hashCode()
            r0 = 0
            switch(r2) {
                case -1881872635: goto L37;
                case 3387192: goto L2b;
                case 94852023: goto L1d;
                case 951526612: goto L14;
                default: goto L13;
            }
        L13:
            goto L3f
        L14:
            java.lang.String r2 = "contain"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L33
            goto L3f
        L1d:
            java.lang.String r2 = "cover"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L26
            goto L3f
        L26:
            r2 = 4
            r3.setResizeModeModifier(r2)
            goto L62
        L2b:
            java.lang.String r2 = "none"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L3f
        L33:
            r3.setResizeModeModifier(r0)
            goto L62
        L37:
            java.lang.String r2 = "stretch"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L5e
        L3f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r1 = "Unsupported resize mode: "
            r2.append(r1)
            r2.append(r4)
            java.lang.String r4 = " - falling back to fit"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "ExoViewManager"
            com.brentvatne.common.toolbox.DebugLog.w(r4, r2)
            r3.setResizeModeModifier(r0)
            goto L62
        L5e:
            r2 = 3
            r3.setResizeModeModifier(r2)
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.brentvatne.exoplayer.ReactExoplayerViewManager.setResizeMode(com.brentvatne.exoplayer.ReactExoplayerView, java.lang.String):void");
    }

    @ReactProp(defaultBoolean = false, name = PROP_REPEAT)
    public final void setRepeat(@NotNull ReactExoplayerView videoView, boolean repeat) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setRepeatModifier(repeat);
    }

    @ReactProp(defaultBoolean = false, name = PROP_PREVENTS_DISPLAY_SLEEP_DURING_VIDEO_PLAYBACK)
    public final void setPreventsDisplaySleepDuringVideoPlayback(@NotNull ReactExoplayerView videoView, boolean preventsSleep) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setPreventsDisplaySleepDuringVideoPlayback(preventsSleep);
    }

    @ReactProp(name = PROP_SELECTED_VIDEO_TRACK)
    public final void setSelectedVideoTrack(@NotNull ReactExoplayerView videoView, @Nullable ReadableMap selectedVideoTrack) throws MissingResourceException {
        String strSafeGetString;
        String strSafeGetString2;
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        if (selectedVideoTrack != null) {
            strSafeGetString = ReactBridgeUtils.safeGetString(selectedVideoTrack, "type");
            strSafeGetString2 = ReactBridgeUtils.safeGetString(selectedVideoTrack, "value");
        } else {
            strSafeGetString = null;
            strSafeGetString2 = null;
        }
        videoView.setSelectedVideoTrack(strSafeGetString, strSafeGetString2);
    }

    @ReactProp(name = PROP_SELECTED_AUDIO_TRACK)
    public final void setSelectedAudioTrack(@NotNull ReactExoplayerView videoView, @Nullable ReadableMap selectedAudioTrack) throws MissingResourceException {
        String strSafeGetString;
        String strSafeGetString2;
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        if (selectedAudioTrack != null) {
            strSafeGetString = ReactBridgeUtils.safeGetString(selectedAudioTrack, "type");
            strSafeGetString2 = ReactBridgeUtils.safeGetString(selectedAudioTrack, "value");
        } else {
            strSafeGetString = null;
            strSafeGetString2 = null;
        }
        videoView.setSelectedAudioTrack(strSafeGetString, strSafeGetString2);
    }

    @ReactProp(name = PROP_SELECTED_TEXT_TRACK)
    public final void setSelectedTextTrack(@NotNull ReactExoplayerView videoView, @Nullable ReadableMap selectedTextTrack) throws MissingResourceException {
        String strSafeGetString;
        String strSafeGetString2;
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        if (selectedTextTrack != null) {
            strSafeGetString = ReactBridgeUtils.safeGetString(selectedTextTrack, "type");
            strSafeGetString2 = ReactBridgeUtils.safeGetString(selectedTextTrack, "value");
        } else {
            strSafeGetString = null;
            strSafeGetString2 = null;
        }
        videoView.setSelectedTextTrack(strSafeGetString, strSafeGetString2);
    }

    @ReactProp(defaultBoolean = false, name = PROP_PAUSED)
    public final void setPaused(@NotNull ReactExoplayerView videoView, boolean paused) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setPausedModifier(paused);
    }

    @ReactProp(defaultBoolean = false, name = PROP_MUTED)
    public final void setMuted(@NotNull ReactExoplayerView videoView, boolean muted) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setMutedModifier(muted);
    }

    @ReactProp(defaultBoolean = false, name = PROP_ENTER_PICTURE_IN_PICTURE_ON_LEAVE)
    public final void setEnterPictureInPictureOnLeave(@NotNull ReactExoplayerView videoView, boolean enterPictureInPictureOnLeave) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setEnterPictureInPictureOnLeave(enterPictureInPictureOnLeave);
    }

    @ReactProp(name = PROP_AUDIO_OUTPUT)
    public final void setAudioOutput(@NotNull ReactExoplayerView videoView, @NotNull String audioOutput) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        Intrinsics.checkNotNullParameter(audioOutput, "audioOutput");
        videoView.setAudioOutput(AudioOutput.INSTANCE.get(audioOutput));
    }

    @ReactProp(defaultFloat = 1.0f, name = PROP_VOLUME)
    public final void setVolume(@NotNull ReactExoplayerView videoView, float volume) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setVolumeModifier(volume);
    }

    @ReactProp(defaultFloat = 250.0f, name = PROP_PROGRESS_UPDATE_INTERVAL)
    public final void setProgressUpdateInterval(@NotNull ReactExoplayerView videoView, float progressUpdateInterval) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setProgressUpdateInterval(progressUpdateInterval);
    }

    @ReactProp(defaultBoolean = false, name = PROP_REPORT_BANDWIDTH)
    public final void setReportBandwidth(@NotNull ReactExoplayerView videoView, boolean reportBandwidth) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setReportBandwidth(reportBandwidth);
    }

    @ReactProp(name = PROP_RATE)
    public final void setRate(@NotNull ReactExoplayerView videoView, float rate) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setRateModifier(rate);
    }

    @ReactProp(name = PROP_MAXIMUM_BIT_RATE)
    public final void setMaxBitRate(@NotNull ReactExoplayerView videoView, float maxBitRate) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setMaxBitRateModifier((int) maxBitRate);
    }

    @ReactProp(defaultBoolean = false, name = PROP_PLAY_IN_BACKGROUND)
    public final void setPlayInBackground(@NotNull ReactExoplayerView videoView, boolean playInBackground) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setPlayInBackground(playInBackground);
    }

    @ReactProp(defaultBoolean = false, name = PROP_DISABLE_FOCUS)
    public final void setDisableFocus(@NotNull ReactExoplayerView videoView, boolean disableFocus) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setDisableFocus(disableFocus);
    }

    @ReactProp(defaultBoolean = true, name = PROP_FOCUSABLE)
    public final void setFocusable(@NotNull ReactExoplayerView videoView, boolean focusable) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setFocusable(focusable);
    }

    @ReactProp(name = PROP_BUFFERING_STRATEGY)
    public final void setBufferingStrategy(@NotNull ReactExoplayerView videoView, @NotNull String bufferingStrategy) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        Intrinsics.checkNotNullParameter(bufferingStrategy, "bufferingStrategy");
        videoView.setBufferingStrategy(BufferingStrategy.INSTANCE.parse(bufferingStrategy));
    }

    @ReactProp(defaultBoolean = false, name = PROP_DISABLE_DISCONNECT_ERROR)
    public final void setDisableDisconnectError(@NotNull ReactExoplayerView videoView, boolean disableDisconnectError) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setDisableDisconnectError(disableDisconnectError);
    }

    @ReactProp(defaultBoolean = false, name = "fullscreen")
    public final void setFullscreen(@NotNull ReactExoplayerView videoView, boolean fullscreen) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setFullscreen(fullscreen);
    }

    @ReactProp(defaultInt = 1, name = PROP_VIEW_TYPE)
    public final void setViewType(@NotNull ReactExoplayerView videoView, int viewType) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setViewType(viewType);
    }

    @ReactProp(defaultBoolean = false, name = PROP_HIDE_SHUTTER_VIEW)
    public final void setHideShutterView(@NotNull ReactExoplayerView videoView, boolean hideShutterView) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setHideShutterView(hideShutterView);
    }

    @ReactProp(defaultBoolean = false, name = PROP_CONTROLS)
    public final void setControls(@NotNull ReactExoplayerView videoView, boolean controls) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setControls(controls);
    }

    @ReactProp(name = PROP_SUBTITLE_STYLE)
    public final void setSubtitleStyle(@NotNull ReactExoplayerView videoView, @Nullable ReadableMap src) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setSubtitleStyle(SubtitleStyle.INSTANCE.parse(src));
    }

    @ReactProp(defaultInt = -16777216, name = PROP_SHUTTER_COLOR)
    public final void setShutterColor(@NotNull ReactExoplayerView videoView, int color) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setShutterColor(Integer.valueOf(color));
    }

    @ReactProp(name = PROP_SHOW_NOTIFICATION_CONTROLS)
    public final void setShowNotificationControls(@NotNull ReactExoplayerView videoView, boolean showNotificationControls) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setShowNotificationControls(showNotificationControls);
    }

    @ReactProp(defaultBoolean = false, name = PROP_DEBUG)
    public final void setDebug(@NotNull ReactExoplayerView videoView, @Nullable ReadableMap debugConfig) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        boolean zSafeGetBool = ReactBridgeUtils.safeGetBool(debugConfig, "enable", false);
        boolean zSafeGetBool2 = ReactBridgeUtils.safeGetBool(debugConfig, "thread", false);
        if (zSafeGetBool) {
            DebugLog.setConfig(2, zSafeGetBool2);
        } else {
            DebugLog.setConfig(5, zSafeGetBool2);
        }
        videoView.setDebug(zSafeGetBool);
    }

    @ReactProp(name = PROP_CONTROLS_STYLES)
    public final void setControlsStyles(@NotNull ReactExoplayerView videoView, @Nullable ReadableMap controlsStyles) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setControlsStyles(ControlsConfig.INSTANCE.parse(controlsStyles));
    }
}
