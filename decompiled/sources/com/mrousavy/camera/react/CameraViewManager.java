package com.mrousavy.camera.react;

import androidx.media3.common.MimeTypes;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.mrousavy.camera.core.types.CameraDeviceFormat;
import com.mrousavy.camera.core.types.CodeScannerOptions;
import com.mrousavy.camera.core.types.OutputOrientation;
import com.mrousavy.camera.core.types.PixelFormat;
import com.mrousavy.camera.core.types.PreviewViewType;
import com.mrousavy.camera.core.types.QualityBalance;
import com.mrousavy.camera.core.types.ResizeMode;
import com.mrousavy.camera.core.types.Torch;
import com.mrousavy.camera.core.types.VideoStabilizationMode;
import com.rumax.reactnative.pdfviewer.PDFView;
import com.swmansion.rnscreens.Screen;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0012\u0018\u0000 Q2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001QB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0016\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\rH\u0007J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0015H\u0007J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0015H\u0007J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0015H\u0007J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0015H\u0007J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0015H\u0007J\u0018\u0010 \u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0015H\u0007J\u001a\u0010\"\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\rH\u0007J\u0018\u0010$\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0015H\u0007J\u0018\u0010&\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0015H\u0007J\u001a\u0010(\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010\rH\u0007J\u0018\u0010*\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0015H\u0007J\u001a\u0010,\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010.H\u0007J\u001a\u0010/\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\b\u00100\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u00101\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u00010\rH\u0007J\u0018\u00103\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u00104\u001a\u000205H\u0007J\u0018\u00106\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u00107\u001a\u000205H\u0007J\u0018\u00108\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u0015H\u0007J\u001a\u0010:\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\b\u0010;\u001a\u0004\u0018\u00010\rH\u0007J\u0018\u0010<\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0015H\u0007J\u0018\u0010>\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010?\u001a\u00020@H\u0007J\u0018\u0010A\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010B\u001a\u00020@H\u0007J\u0018\u0010C\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u0015H\u0007J\u0018\u0010E\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u0015H\u0007J\u001a\u0010G\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\b\u0010H\u001a\u0004\u0018\u00010\rH\u0007J\u0018\u0010I\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010J\u001a\u00020@H\u0007J\u0018\u0010K\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010L\u001a\u00020@H\u0007J\u001a\u0010M\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\b\u0010N\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u0010O\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\b\u0010P\u001a\u0004\u0018\u00010.H\u0007¨\u0006R"}, d2 = {"Lcom/mrousavy/camera/react/CameraViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/mrousavy/camera/react/CameraView;", "<init>", "()V", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "onAfterUpdateTransaction", "", "view", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "onDropViewInstance", "setCameraId", "cameraId", "setIsMirrored", "isMirrored", "", "setPreview", "preview", "setPhoto", "photo", "setVideo", MimeTypes.BASE_TYPE_VIDEO, "setAudio", MimeTypes.BASE_TYPE_AUDIO, "setEnableLocation", "enableLocation", "setEnableFrameProcessor", "enableFrameProcessor", "setPixelFormat", "pixelFormat", "setEnableDepthData", "enableDepthData", "setEnableZoomGesture", "enableZoomGesture", "setVideoStabilizationMode", "videoStabilizationMode", "setEnablePortraitEffectsMatteDelivery", "enablePortraitEffectsMatteDelivery", "setFormat", "format", "Lcom/facebook/react/bridge/ReadableMap;", "setResizeMode", ViewProps.RESIZE_MODE, "setAndroidPreviewViewType", "androidPreviewViewType", "setMinFps", "minFps", "", "setMaxFps", "maxFps", "setPhotoHdr", "photoHdr", "setPhotoQualityBalance", "photoQualityBalance", "setVideoHdr", "videoHdr", "setVideoBitRateOverride", "videoBitRateOverride", "", "setVideoBitRateMultiplier", "videoBitRateMultiplier", "setLowLightBoost", "lowLightBoost", "setIsActive", "isActive", "setTorch", "torch", "setZoom", "zoom", "setExposure", "exposure", "setOrientation", "outputOrientation", "setCodeScanner", "codeScannerOptions", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CameraViewManager extends ViewGroupManager<CameraView> {

    @NotNull
    public static final String TAG = "CameraView";

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public CameraView createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new CameraView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(@NotNull CameraView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onAfterUpdateTransaction((CameraViewManager) view);
        view.update();
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put(CameraViewReadyEvent.EVENT_NAME, MapBuilder.of("registrationName", "onViewReady")).put(CameraInitializedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onInitialized")).put(CameraStartedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onStarted")).put(CameraStoppedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onStopped")).put(CameraShutterEvent.EVENT_NAME, MapBuilder.of("registrationName", "onShutter")).put(CameraErrorEvent.EVENT_NAME, MapBuilder.of("registrationName", PDFView.EVENT_ON_ERROR)).put(CameraCodeScannedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onCodeScanned")).put(CameraPreviewStartedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPreviewStarted")).put(CameraPreviewStoppedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPreviewStopped")).put(CameraOutputOrientationChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onOutputOrientationChanged")).put(CameraPreviewOrientationChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPreviewOrientationChanged")).put(AverageFpsChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onAverageFpsChanged")).build();
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "CameraView";
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(@NotNull CameraView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.destroy();
        super.onDropViewInstance((CameraViewManager) view);
    }

    @ReactProp(name = "cameraId")
    public final void setCameraId(@NotNull CameraView view, @NotNull String cameraId) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        view.setCameraId(cameraId);
    }

    @ReactProp(name = "isMirrored")
    public final void setIsMirrored(@NotNull CameraView view, boolean isMirrored) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setMirrored(isMirrored);
    }

    @ReactProp(defaultBoolean = true, name = "preview")
    public final void setPreview(@NotNull CameraView view, boolean preview) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPreview(preview);
    }

    @ReactProp(name = "photo")
    public final void setPhoto(@NotNull CameraView view, boolean photo) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPhoto(photo);
    }

    @ReactProp(name = MimeTypes.BASE_TYPE_VIDEO)
    public final void setVideo(@NotNull CameraView view, boolean video) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setVideo(video);
    }

    @ReactProp(name = MimeTypes.BASE_TYPE_AUDIO)
    public final void setAudio(@NotNull CameraView view, boolean audio) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setAudio(audio);
    }

    @ReactProp(name = "enableLocation")
    public final void setEnableLocation(@NotNull CameraView view, boolean enableLocation) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnableLocation(enableLocation);
    }

    @ReactProp(name = "enableFrameProcessor")
    public final void setEnableFrameProcessor(@NotNull CameraView view, boolean enableFrameProcessor) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnableFrameProcessor(enableFrameProcessor);
    }

    @ReactProp(name = "pixelFormat")
    public final void setPixelFormat(@NotNull CameraView view, @Nullable String pixelFormat) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (pixelFormat != null) {
            view.setPixelFormat(PixelFormat.INSTANCE.fromUnionValue(pixelFormat));
        } else {
            view.setPixelFormat(PixelFormat.YUV);
        }
    }

    @ReactProp(name = "enableDepthData")
    public final void setEnableDepthData(@NotNull CameraView view, boolean enableDepthData) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnableDepthData(enableDepthData);
    }

    @ReactProp(name = "enableZoomGesture")
    public final void setEnableZoomGesture(@NotNull CameraView view, boolean enableZoomGesture) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnableZoomGesture(enableZoomGesture);
    }

    @ReactProp(name = "videoStabilizationMode")
    public final void setVideoStabilizationMode(@NotNull CameraView view, @Nullable String videoStabilizationMode) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (videoStabilizationMode != null) {
            view.setVideoStabilizationMode(VideoStabilizationMode.INSTANCE.fromUnionValue(videoStabilizationMode));
        } else {
            view.setVideoStabilizationMode(null);
        }
    }

    @ReactProp(name = "enablePortraitEffectsMatteDelivery")
    public final void setEnablePortraitEffectsMatteDelivery(@NotNull CameraView view, boolean enablePortraitEffectsMatteDelivery) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnablePortraitEffectsMatteDelivery(enablePortraitEffectsMatteDelivery);
    }

    @ReactProp(name = "format")
    public final void setFormat(@NotNull CameraView view, @Nullable ReadableMap format) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (format != null) {
            view.setFormat(CameraDeviceFormat.INSTANCE.fromJSValue(format));
        } else {
            view.setFormat(null);
        }
    }

    @ReactProp(name = ViewProps.RESIZE_MODE)
    public final void setResizeMode(@NotNull CameraView view, @Nullable String resizeMode) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (resizeMode != null) {
            view.setResizeMode(ResizeMode.INSTANCE.fromUnionValue(resizeMode));
        } else {
            view.setResizeMode(ResizeMode.COVER);
        }
    }

    @ReactProp(name = "androidPreviewViewType")
    public final void setAndroidPreviewViewType(@NotNull CameraView view, @Nullable String androidPreviewViewType) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (androidPreviewViewType != null) {
            view.setAndroidPreviewViewType(PreviewViewType.INSTANCE.fromUnionValue(androidPreviewViewType));
        } else {
            view.setAndroidPreviewViewType(PreviewViewType.SURFACE_VIEW);
        }
    }

    @ReactProp(defaultInt = -1, name = "minFps")
    public final void setMinFps(@NotNull CameraView view, int minFps) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setMinFps(minFps > 0 ? Integer.valueOf(minFps) : null);
    }

    @ReactProp(defaultInt = -1, name = "maxFps")
    public final void setMaxFps(@NotNull CameraView view, int maxFps) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setMaxFps(maxFps > 0 ? Integer.valueOf(maxFps) : null);
    }

    @ReactProp(name = "photoHdr")
    public final void setPhotoHdr(@NotNull CameraView view, boolean photoHdr) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPhotoHdr(photoHdr);
    }

    @ReactProp(name = "photoQualityBalance")
    public final void setPhotoQualityBalance(@NotNull CameraView view, @Nullable String photoQualityBalance) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (photoQualityBalance != null) {
            view.setPhotoQualityBalance(QualityBalance.INSTANCE.fromUnionValue(photoQualityBalance));
        } else {
            view.setPhotoQualityBalance(QualityBalance.BALANCED);
        }
    }

    @ReactProp(name = "videoHdr")
    public final void setVideoHdr(@NotNull CameraView view, boolean videoHdr) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setVideoHdr(videoHdr);
    }

    @ReactProp(defaultDouble = Screen.SHEET_FIT_TO_CONTENTS, name = "videoBitRateOverride")
    public final void setVideoBitRateOverride(@NotNull CameraView view, double videoBitRateOverride) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (videoBitRateOverride != -1.0d) {
            view.setVideoBitRateOverride(Double.valueOf(videoBitRateOverride));
        } else {
            view.setVideoBitRateOverride(null);
        }
    }

    @ReactProp(defaultDouble = Screen.SHEET_FIT_TO_CONTENTS, name = "videoBitRateMultiplier")
    public final void setVideoBitRateMultiplier(@NotNull CameraView view, double videoBitRateMultiplier) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (videoBitRateMultiplier != -1.0d) {
            view.setVideoBitRateMultiplier(Double.valueOf(videoBitRateMultiplier));
        } else {
            view.setVideoBitRateMultiplier(null);
        }
    }

    @ReactProp(name = "lowLightBoost")
    public final void setLowLightBoost(@NotNull CameraView view, boolean lowLightBoost) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setLowLightBoost(lowLightBoost);
    }

    @ReactProp(name = "isActive")
    public final void setIsActive(@NotNull CameraView view, boolean isActive) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setActive(isActive);
    }

    @ReactProp(name = "torch")
    public final void setTorch(@NotNull CameraView view, @Nullable String torch) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (torch != null) {
            view.setTorch(Torch.INSTANCE.fromUnionValue(torch));
        } else {
            view.setTorch(Torch.OFF);
        }
    }

    @ReactProp(name = "zoom")
    public final void setZoom(@NotNull CameraView view, double zoom) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setZoom((float) zoom);
    }

    @ReactProp(name = "exposure")
    public final void setExposure(@NotNull CameraView view, double exposure) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setExposure(exposure);
    }

    @ReactProp(name = "outputOrientation")
    public final void setOrientation(@NotNull CameraView view, @Nullable String outputOrientation) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (outputOrientation != null) {
            view.setOutputOrientation(OutputOrientation.INSTANCE.fromUnionValue(outputOrientation));
        } else {
            view.setOutputOrientation(OutputOrientation.DEVICE);
        }
    }

    @ReactProp(name = "codeScannerOptions")
    public final void setCodeScanner(@NotNull CameraView view, @Nullable ReadableMap codeScannerOptions) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (codeScannerOptions != null) {
            view.setCodeScannerOptions(CodeScannerOptions.INSTANCE.fromJSValue(codeScannerOptions));
        } else {
            view.setCodeScannerOptions(null);
        }
    }
}
