package com.brentvatne.common.api;

import com.brentvatne.common.toolbox.ReactBridgeUtils;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/brentvatne/common/api/SubtitleStyle;", "", "<init>", "()V", "value", "", ViewProps.FONT_SIZE, "getFontSize", "()I", ViewProps.PADDING_LEFT, "getPaddingLeft", ViewProps.PADDING_RIGHT, "getPaddingRight", ViewProps.PADDING_TOP, "getPaddingTop", ViewProps.PADDING_BOTTOM, "getPaddingBottom", "", ViewProps.OPACITY, "getOpacity", "()F", "", "subtitlesFollowVideo", "getSubtitlesFollowVideo", "()Z", "Companion", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SubtitleStyle {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int paddingBottom;
    private int paddingLeft;
    private int paddingRight;
    private int paddingTop;
    private int fontSize = -1;
    private float opacity = 1.0f;
    private boolean subtitlesFollowVideo = true;

    @JvmStatic
    @NotNull
    public static final SubtitleStyle parse(@Nullable ReadableMap readableMap) {
        return INSTANCE.parse(readableMap);
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    public final int getPaddingLeft() {
        return this.paddingLeft;
    }

    public final int getPaddingRight() {
        return this.paddingRight;
    }

    public final int getPaddingTop() {
        return this.paddingTop;
    }

    public final int getPaddingBottom() {
        return this.paddingBottom;
    }

    public final float getOpacity() {
        return this.opacity;
    }

    public final boolean getSubtitlesFollowVideo() {
        return this.subtitlesFollowVideo;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/brentvatne/common/api/SubtitleStyle$Companion;", "", "<init>", "()V", "PROP_FONT_SIZE_TRACK", "", "PROP_PADDING_BOTTOM", "PROP_PADDING_TOP", "PROP_PADDING_LEFT", "PROP_PADDING_RIGHT", "PROP_OPACITY", "PROP_SUBTITLES_FOLLOW_VIDEO", "parse", "Lcom/brentvatne/common/api/SubtitleStyle;", "src", "Lcom/facebook/react/bridge/ReadableMap;", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final SubtitleStyle parse(@Nullable ReadableMap src) {
            SubtitleStyle subtitleStyle = new SubtitleStyle();
            subtitleStyle.fontSize = ReactBridgeUtils.safeGetInt(src, ViewProps.FONT_SIZE, -1);
            subtitleStyle.paddingBottom = ReactBridgeUtils.safeGetInt(src, ViewProps.PADDING_BOTTOM, 0);
            subtitleStyle.paddingTop = ReactBridgeUtils.safeGetInt(src, ViewProps.PADDING_TOP, 0);
            subtitleStyle.paddingLeft = ReactBridgeUtils.safeGetInt(src, ViewProps.PADDING_LEFT, 0);
            subtitleStyle.paddingRight = ReactBridgeUtils.safeGetInt(src, ViewProps.PADDING_RIGHT, 0);
            subtitleStyle.opacity = ReactBridgeUtils.safeGetFloat(src, ViewProps.OPACITY, 1.0f);
            subtitleStyle.subtitlesFollowVideo = ReactBridgeUtils.safeGetBool(src, "subtitlesFollowVideo", true);
            return subtitleStyle;
        }
    }
}
