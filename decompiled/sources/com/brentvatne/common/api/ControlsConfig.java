package com.brentvatne.common.api;

import com.brentvatne.common.toolbox.ReactBridgeUtils;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001a\u0010%\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\u001a\u00101\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u00068"}, d2 = {"Lcom/brentvatne/common/api/ControlsConfig;", "", "<init>", "()V", "hideSeekBar", "", "getHideSeekBar", "()Z", "setHideSeekBar", "(Z)V", "hideDuration", "getHideDuration", "setHideDuration", "hidePosition", "getHidePosition", "setHidePosition", "hidePlayPause", "getHidePlayPause", "setHidePlayPause", "hideForward", "getHideForward", "setHideForward", "hideRewind", "getHideRewind", "setHideRewind", "hideNext", "getHideNext", "setHideNext", "hidePrevious", "getHidePrevious", "setHidePrevious", "hideFullscreen", "getHideFullscreen", "setHideFullscreen", "hideNavigationBarOnFullScreenMode", "getHideNavigationBarOnFullScreenMode", "setHideNavigationBarOnFullScreenMode", "hideNotificationBarOnFullScreenMode", "getHideNotificationBarOnFullScreenMode", "setHideNotificationBarOnFullScreenMode", "liveLabel", "", "getLiveLabel", "()Ljava/lang/String;", "setLiveLabel", "(Ljava/lang/String;)V", "hideSettingButton", "getHideSettingButton", "setHideSettingButton", "seekIncrementMS", "", "getSeekIncrementMS", "()I", "setSeekIncrementMS", "(I)V", "Companion", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ControlsConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private boolean hideDuration;
    private boolean hideForward;
    private boolean hideFullscreen;
    private boolean hideNext;
    private boolean hidePlayPause;
    private boolean hidePosition;
    private boolean hidePrevious;
    private boolean hideRewind;
    private boolean hideSeekBar;
    private String liveLabel;
    private boolean hideNavigationBarOnFullScreenMode = true;
    private boolean hideNotificationBarOnFullScreenMode = true;
    private boolean hideSettingButton = true;
    private int seekIncrementMS = 10000;

    @JvmStatic
    @NotNull
    public static final ControlsConfig parse(@Nullable ReadableMap readableMap) {
        return INSTANCE.parse(readableMap);
    }

    public final boolean getHideSeekBar() {
        return this.hideSeekBar;
    }

    public final void setHideSeekBar(boolean z) {
        this.hideSeekBar = z;
    }

    public final boolean getHideDuration() {
        return this.hideDuration;
    }

    public final void setHideDuration(boolean z) {
        this.hideDuration = z;
    }

    public final boolean getHidePosition() {
        return this.hidePosition;
    }

    public final void setHidePosition(boolean z) {
        this.hidePosition = z;
    }

    public final boolean getHidePlayPause() {
        return this.hidePlayPause;
    }

    public final void setHidePlayPause(boolean z) {
        this.hidePlayPause = z;
    }

    public final boolean getHideForward() {
        return this.hideForward;
    }

    public final void setHideForward(boolean z) {
        this.hideForward = z;
    }

    public final boolean getHideRewind() {
        return this.hideRewind;
    }

    public final void setHideRewind(boolean z) {
        this.hideRewind = z;
    }

    public final boolean getHideNext() {
        return this.hideNext;
    }

    public final void setHideNext(boolean z) {
        this.hideNext = z;
    }

    public final boolean getHidePrevious() {
        return this.hidePrevious;
    }

    public final void setHidePrevious(boolean z) {
        this.hidePrevious = z;
    }

    public final boolean getHideFullscreen() {
        return this.hideFullscreen;
    }

    public final void setHideFullscreen(boolean z) {
        this.hideFullscreen = z;
    }

    public final boolean getHideNavigationBarOnFullScreenMode() {
        return this.hideNavigationBarOnFullScreenMode;
    }

    public final void setHideNavigationBarOnFullScreenMode(boolean z) {
        this.hideNavigationBarOnFullScreenMode = z;
    }

    public final boolean getHideNotificationBarOnFullScreenMode() {
        return this.hideNotificationBarOnFullScreenMode;
    }

    public final void setHideNotificationBarOnFullScreenMode(boolean z) {
        this.hideNotificationBarOnFullScreenMode = z;
    }

    @Nullable
    public final String getLiveLabel() {
        return this.liveLabel;
    }

    public final void setLiveLabel(@Nullable String str) {
        this.liveLabel = str;
    }

    public final boolean getHideSettingButton() {
        return this.hideSettingButton;
    }

    public final void setHideSettingButton(boolean z) {
        this.hideSettingButton = z;
    }

    public final int getSeekIncrementMS() {
        return this.seekIncrementMS;
    }

    public final void setSeekIncrementMS(int i) {
        this.seekIncrementMS = i;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/brentvatne/common/api/ControlsConfig$Companion;", "", "<init>", "()V", "parse", "Lcom/brentvatne/common/api/ControlsConfig;", "controlsConfig", "Lcom/facebook/react/bridge/ReadableMap;", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final ControlsConfig parse(@Nullable ReadableMap controlsConfig) {
            ControlsConfig controlsConfig2 = new ControlsConfig();
            if (controlsConfig != null) {
                controlsConfig2.setHideSeekBar(ReactBridgeUtils.safeGetBool(controlsConfig, "hideSeekBar", false));
                controlsConfig2.setHideDuration(ReactBridgeUtils.safeGetBool(controlsConfig, "hideDuration", false));
                controlsConfig2.setHidePosition(ReactBridgeUtils.safeGetBool(controlsConfig, "hidePosition", false));
                controlsConfig2.setHidePlayPause(ReactBridgeUtils.safeGetBool(controlsConfig, "hidePlayPause", false));
                controlsConfig2.setHideForward(ReactBridgeUtils.safeGetBool(controlsConfig, "hideForward", false));
                controlsConfig2.setHideRewind(ReactBridgeUtils.safeGetBool(controlsConfig, "hideRewind", false));
                controlsConfig2.setHideNext(ReactBridgeUtils.safeGetBool(controlsConfig, "hideNext", false));
                controlsConfig2.setHidePrevious(ReactBridgeUtils.safeGetBool(controlsConfig, "hidePrevious", false));
                controlsConfig2.setHideFullscreen(ReactBridgeUtils.safeGetBool(controlsConfig, "hideFullscreen", false));
                controlsConfig2.setSeekIncrementMS(ReactBridgeUtils.safeGetInt(controlsConfig, "seekIncrementMS", 10000));
                controlsConfig2.setHideNavigationBarOnFullScreenMode(ReactBridgeUtils.safeGetBool(controlsConfig, "hideNavigationBarOnFullScreenMode", true));
                controlsConfig2.setHideNotificationBarOnFullScreenMode(ReactBridgeUtils.safeGetBool(controlsConfig, "hideNotificationBarOnFullScreenMode", true));
                controlsConfig2.setLiveLabel(ReactBridgeUtils.safeGetString(controlsConfig, "liveLabel", null));
                controlsConfig2.setHideSettingButton(ReactBridgeUtils.safeGetBool(controlsConfig, "hideSettingButton", true));
            }
            return controlsConfig2;
        }
    }
}
