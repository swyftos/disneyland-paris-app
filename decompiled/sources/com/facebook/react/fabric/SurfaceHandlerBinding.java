package com.facebook.react.fabric;

import com.facebook.jni.HybridClassBase;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.fabric.mounting.LayoutMetricsConversions;
import com.facebook.react.interfaces.fabric.SurfaceHandler;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0082 J\t\u0010\u0012\u001a\u00020\nH\u0082 J\t\u0010\u0013\u001a\u00020\u0004H\u0082 J\t\u0010\u0014\u001a\u00020\u000eH\u0082 J@\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016JQ\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0082 J\u0011\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020%H\u0096 J\u0010\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u000eH\u0016J\u0011\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\nH\u0082 R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006+"}, d2 = {"Lcom/facebook/react/fabric/SurfaceHandlerBinding;", "Lcom/facebook/jni/HybridClassBase;", "Lcom/facebook/react/interfaces/fabric/SurfaceHandler;", "moduleName", "", "<init>", "(Ljava/lang/String;)V", "initHybrid", "", "surfaceId", "", "getSurfaceId", "()I", "isRunning", "", "()Z", "getModuleName", "()Ljava/lang/String;", "_getSurfaceId", "_getModuleName", "_isRunning", "setLayoutConstraints", "widthMeasureSpec", "heightMeasureSpec", "offsetX", "offsetY", "doLeftAndRightSwapInRTL", "isRTL", "pixelDensity", "", "setLayoutConstraintsNative", ViewProps.MIN_WIDTH, ViewProps.MAX_WIDTH, ViewProps.MIN_HEIGHT, ViewProps.MAX_HEIGHT, "setProps", "props", "Lcom/facebook/react/bridge/NativeMap;", "setMountable", "mountable", "setDisplayMode", "mode", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class SurfaceHandlerBinding extends HybridClassBase implements SurfaceHandler {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int DISPLAY_MODE_HIDDEN = 2;

    @Deprecated
    public static final int DISPLAY_MODE_SUSPENDED = 1;

    @Deprecated
    public static final int DISPLAY_MODE_VISIBLE = 0;
    private static final int NO_SURFACE_ID = 0;

    private final native String _getModuleName();

    private final native int _getSurfaceId();

    private final native boolean _isRunning();

    private final native void initHybrid(int surfaceId, String moduleName);

    private final native void setDisplayMode(int mode);

    private final native void setLayoutConstraintsNative(float minWidth, float maxWidth, float minHeight, float maxHeight, float offsetX, float offsetY, boolean doLeftAndRightSwapInRTL, boolean isRTL, float pixelDensity);

    @Override // com.facebook.react.interfaces.fabric.SurfaceHandler
    public native void setProps(@NotNull NativeMap props);

    public SurfaceHandlerBinding(@NotNull String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        initHybrid(0, moduleName);
    }

    @Override // com.facebook.react.interfaces.fabric.SurfaceHandler
    public int getSurfaceId() {
        return _getSurfaceId();
    }

    @Override // com.facebook.react.interfaces.fabric.SurfaceHandler
    public boolean isRunning() {
        return _isRunning();
    }

    @Override // com.facebook.react.interfaces.fabric.SurfaceHandler
    @NotNull
    public String getModuleName() {
        return _getModuleName();
    }

    @Override // com.facebook.react.interfaces.fabric.SurfaceHandler
    public void setLayoutConstraints(int widthMeasureSpec, int heightMeasureSpec, int offsetX, int offsetY, boolean doLeftAndRightSwapInRTL, boolean isRTL, float pixelDensity) {
        LayoutMetricsConversions.Companion companion = LayoutMetricsConversions.INSTANCE;
        setLayoutConstraintsNative(companion.getMinSize(widthMeasureSpec) / pixelDensity, companion.getMaxSize(widthMeasureSpec) / pixelDensity, companion.getMinSize(heightMeasureSpec) / pixelDensity, companion.getMaxSize(heightMeasureSpec) / pixelDensity, offsetX / pixelDensity, offsetY / pixelDensity, doLeftAndRightSwapInRTL, isRTL, pixelDensity);
    }

    @Override // com.facebook.react.interfaces.fabric.SurfaceHandler
    public void setMountable(boolean mountable) {
        setDisplayMode(!mountable ? 1 : 0);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/react/fabric/SurfaceHandlerBinding$Companion;", "", "<init>", "()V", "NO_SURFACE_ID", "", "DISPLAY_MODE_VISIBLE", "DISPLAY_MODE_SUSPENDED", "DISPLAY_MODE_HIDDEN", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        FabricSoLoader.staticInit();
    }
}
