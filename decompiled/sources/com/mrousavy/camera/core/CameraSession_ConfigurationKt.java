package com.mrousavy.camera.core;

import android.annotation.SuppressLint;
import android.util.Log;
import android.util.Range;
import androidx.annotation.OptIn;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraState;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ExperimentalGetImage;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.ZoomState;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoCapture;
import androidx.lifecycle.Lifecycle;
import com.mrousavy.camera.core.CameraConfiguration;
import com.mrousavy.camera.core.extensions.ImageAnalysis_Builder_setTargetFrameRateKt;
import com.mrousavy.camera.core.extensions.ResolutionSelector_forSizeKt;
import com.mrousavy.camera.core.extensions.StateError_toCameraErrorKt;
import com.mrousavy.camera.core.types.CameraDeviceFormat;
import com.mrousavy.camera.core.types.PixelFormat;
import com.mrousavy.camera.core.types.Torch;
import com.mrousavy.camera.core.types.VideoStabilizationMode;
import com.mrousavy.camera.core.utils.CamcorderProfileUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aE\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\f0\tH\u0002\u001a\u0014\u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0001\u001a\"\u0010\u0011\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0081@¢\u0006\u0002\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0010H\u0000\u001a\u0014\u0010\u0017\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0010H\u0000¨\u0006\u0018"}, d2 = {"assertFormatRequirement", "", "propName", "", "format", "Lcom/mrousavy/camera/core/types/CameraDeviceFormat;", "throwIfNotMet", "Lcom/mrousavy/camera/core/CameraError;", "requirement", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "configureOutputs", "Lcom/mrousavy/camera/core/CameraSession;", "configuration", "Lcom/mrousavy/camera/core/CameraConfiguration;", "configureCamera", "provider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "(Lcom/mrousavy/camera/core/CameraSession;Landroidx/camera/lifecycle/ProcessCameraProvider;Lcom/mrousavy/camera/core/CameraConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureSideProps", "config", "configureIsActive", "react-native-vision-camera_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCameraSession+Configuration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CameraSession+Configuration.kt\ncom/mrousavy/camera/core/CameraSession_ConfigurationKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,350:1\n1755#2,3:351\n37#3,2:354\n37#3,2:356\n*S KotlinDebug\n*F\n+ 1 CameraSession+Configuration.kt\ncom/mrousavy/camera/core/CameraSession_ConfigurationKt\n*L\n249#1:351,3\n277#1:354,2\n282#1:356,2\n*E\n"})
/* loaded from: classes4.dex */
public final class CameraSession_ConfigurationKt {

    /* renamed from: com.mrousavy.camera.core.CameraSession_ConfigurationKt$configureCamera$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CameraSession_ConfigurationKt.configureCamera(null, null, null, this);
        }
    }

    private static final void assertFormatRequirement(String str, CameraDeviceFormat cameraDeviceFormat, CameraError cameraError, Function1 function1) throws CameraError {
        if (cameraDeviceFormat == null) {
            throw new PropRequiresFormatToBeNonNullError(str);
        }
        if (!((Boolean) function1.invoke(cameraDeviceFormat)).booleanValue()) {
            throw cameraError;
        }
    }

    @OptIn(markerClass = {ExperimentalGetImage.class})
    @SuppressLint({"RestrictedApi"})
    public static final void configureOutputs(@NotNull CameraSession cameraSession, @NotNull final CameraConfiguration configuration) throws CameraError {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        String cameraId = configuration.getCameraId();
        Intrinsics.checkNotNull(cameraId);
        Log.i(CameraSession.TAG, "Creating new Outputs for Camera #" + cameraId + "...");
        final Range<Integer> targetFpsRange = configuration.getTargetFpsRange();
        CameraDeviceFormat format = configuration.getFormat();
        Log.i(CameraSession.TAG, "Using FPS Range: " + targetFpsRange);
        CameraConfiguration.Output<CameraConfiguration.Photo> photo = configuration.getPhoto();
        CameraConfiguration.Output.Enabled enabled = photo instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) photo : null;
        CameraConfiguration.Output<CameraConfiguration.Video> video = configuration.getVideo();
        CameraConfiguration.Output.Enabled enabled2 = video instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) video : null;
        CameraConfiguration.Output<CameraConfiguration.Preview> preview = configuration.getPreview();
        CameraConfiguration.Output.Enabled enabled3 = preview instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) preview : null;
        if (enabled3 != null) {
            Log.i(CameraSession.TAG, "Creating Preview output...");
            Preview.Builder builder = new Preview.Builder();
            if (configuration.getVideoStabilizationMode().isAtLeast(VideoStabilizationMode.CINEMATIC)) {
                assertFormatRequirement("videoStabilizationMode", format, new InvalidVideoStabilizationMode(configuration.getVideoStabilizationMode()), new Function1() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(CameraSession_ConfigurationKt.configureOutputs$lambda$2$lambda$0(configuration, (CameraDeviceFormat) obj));
                    }
                });
                builder.setPreviewStabilizationEnabled(true);
            }
            if (targetFpsRange != null) {
                Object upper = targetFpsRange.getUpper();
                Intrinsics.checkNotNullExpressionValue(upper, "getUpper(...)");
                assertFormatRequirement("fps", format, new InvalidFpsError(((Number) upper).intValue()), new Function1() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(CameraSession_ConfigurationKt.configureOutputs$lambda$2$lambda$1(targetFpsRange, (CameraDeviceFormat) obj));
                    }
                });
                builder.setTargetFrameRate(targetFpsRange);
            }
            if (format != null) {
                ResolutionSelector resolutionSelectorBuild = ResolutionSelector_forSizeKt.forSize(new ResolutionSelector.Builder(), enabled2 != null ? format.getVideoSize() : format.getPhotoSize()).setAllowedResolutionMode(0).build();
                Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild, "build(...)");
                builder.setResolutionSelector(resolutionSelectorBuild);
            }
            Preview previewBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(previewBuild, "build(...)");
            previewBuild.setSurfaceProvider(((CameraConfiguration.Preview) enabled3.getConfig()).getSurfaceProvider());
            cameraSession.setPreviewOutput$react_native_vision_camera_release(previewBuild);
        } else {
            cameraSession.setPreviewOutput$react_native_vision_camera_release(null);
        }
        if (enabled != null) {
            Log.i(CameraSession.TAG, "Creating Photo output...");
            ImageCapture.Builder builder2 = new ImageCapture.Builder();
            builder2.setCaptureMode(((CameraConfiguration.Photo) enabled.getConfig()).getPhotoQualityBalance().toCaptureMode());
            if (format != null) {
                Log.i(CameraSession.TAG, "Photo size: " + format.getPhotoSize());
                ResolutionSelector resolutionSelectorBuild2 = ResolutionSelector_forSizeKt.forSize(new ResolutionSelector.Builder(), format.getPhotoSize()).setAllowedResolutionMode(1).build();
                Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild2, "build(...)");
                builder2.setResolutionSelector(resolutionSelectorBuild2);
            }
            ImageCapture imageCaptureBuild = builder2.build();
            Intrinsics.checkNotNullExpressionValue(imageCaptureBuild, "build(...)");
            cameraSession.setPhotoOutput$react_native_vision_camera_release(imageCaptureBuild);
        } else {
            cameraSession.setPhotoOutput$react_native_vision_camera_release(null);
        }
        if (enabled2 != null) {
            Log.i(CameraSession.TAG, "Creating Video output...");
            Recorder recorderOutput$react_native_vision_camera_release = cameraSession.getRecorderOutput();
            if (cameraSession.getRecording() != null && recorderOutput$react_native_vision_camera_release != null) {
                Log.i(CameraSession.TAG, "Re-using active Recorder because we are currently recording...");
            } else {
                Log.i(CameraSession.TAG, "Creating new Recorder...");
                Recorder.Builder builder3 = new Recorder.Builder();
                if (format != null) {
                    builder3.setQualitySelector(format.getVideoQualitySelector());
                }
                Double bitRateOverride = ((CameraConfiguration.Video) enabled2.getConfig()).getBitRateOverride();
                if (bitRateOverride != null) {
                    builder3.setTargetVideoEncodingBitRate((int) (bitRateOverride.doubleValue() * 1000000));
                }
                Double bitRateMultiplier = ((CameraConfiguration.Video) enabled2.getConfig()).getBitRateMultiplier();
                if (bitRateMultiplier != null) {
                    double dDoubleValue = bitRateMultiplier.doubleValue();
                    if (format == null) {
                        throw new PropRequiresFormatToBeNonNullError("videoBitRate");
                    }
                    if (CamcorderProfileUtils.INSTANCE.getRecommendedBitRate(cameraId, format.getVideoSize()) != null) {
                        builder3.setTargetVideoEncodingBitRate((int) (r2.intValue() * dDoubleValue));
                    }
                }
                recorderOutput$react_native_vision_camera_release = builder3.build();
                Intrinsics.checkNotNull(recorderOutput$react_native_vision_camera_release);
            }
            VideoCapture.Builder builder4 = new VideoCapture.Builder(recorderOutput$react_native_vision_camera_release);
            if (((CameraConfiguration.Video) enabled2.getConfig()).isMirrored()) {
                builder4.setMirrorMode(1);
            } else {
                builder4.setMirrorMode(0);
            }
            if (configuration.getVideoStabilizationMode().isAtLeast(VideoStabilizationMode.STANDARD)) {
                assertFormatRequirement("videoStabilizationMode", format, new InvalidVideoStabilizationMode(configuration.getVideoStabilizationMode()), new Function1() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(CameraSession_ConfigurationKt.configureOutputs$lambda$11$lambda$8(configuration, (CameraDeviceFormat) obj));
                    }
                });
                builder4.setVideoStabilizationEnabled(true);
            }
            if (targetFpsRange != null) {
                Object upper2 = targetFpsRange.getUpper();
                Intrinsics.checkNotNullExpressionValue(upper2, "getUpper(...)");
                assertFormatRequirement("fps", format, new InvalidFpsError(((Number) upper2).intValue()), new Function1() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(CameraSession_ConfigurationKt.configureOutputs$lambda$11$lambda$9(targetFpsRange, (CameraDeviceFormat) obj));
                    }
                });
                builder4.setTargetFrameRate(targetFpsRange);
            }
            if (((CameraConfiguration.Video) enabled2.getConfig()).getEnableHdr()) {
                assertFormatRequirement("videoHdr", format, new InvalidVideoHdrError(), new Function1() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(CameraSession_ConfigurationKt.configureOutputs$lambda$11$lambda$10((CameraDeviceFormat) obj));
                    }
                });
                builder4.setDynamicRange(DynamicRange.HDR_UNSPECIFIED_10_BIT);
            }
            if (format != null) {
                Log.i(CameraSession.TAG, "Video size: " + format.getVideoSize());
                ResolutionSelector resolutionSelectorBuild3 = ResolutionSelector_forSizeKt.forSize(new ResolutionSelector.Builder(), format.getVideoSize()).setAllowedResolutionMode(0).build();
                Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild3, "build(...)");
                builder4.setResolutionSelector(resolutionSelectorBuild3);
            }
            VideoCapture<Recorder> videoCaptureBuild = builder4.build();
            Intrinsics.checkNotNullExpressionValue(videoCaptureBuild, "build(...)");
            cameraSession.setVideoOutput$react_native_vision_camera_release(videoCaptureBuild);
            cameraSession.setRecorderOutput$react_native_vision_camera_release(recorderOutput$react_native_vision_camera_release);
        } else {
            cameraSession.setVideoOutput$react_native_vision_camera_release(null);
            cameraSession.setRecorderOutput$react_native_vision_camera_release(null);
        }
        CameraConfiguration.Output<CameraConfiguration.FrameProcessor> frameProcessor = configuration.getFrameProcessor();
        CameraConfiguration.Output.Enabled enabled4 = frameProcessor instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) frameProcessor : null;
        if (enabled4 != null) {
            PixelFormat pixelFormat = ((CameraConfiguration.FrameProcessor) enabled4.getConfig()).getPixelFormat();
            Log.i(CameraSession.TAG, "Creating " + pixelFormat + " Frame Processor output...");
            ImageAnalysis.Builder builder5 = new ImageAnalysis.Builder();
            builder5.setBackpressureStrategy(1);
            builder5.setOutputImageFormat(pixelFormat.toImageAnalysisFormat());
            if (targetFpsRange != null) {
                Object upper3 = targetFpsRange.getUpper();
                Intrinsics.checkNotNullExpressionValue(upper3, "getUpper(...)");
                assertFormatRequirement("fps", format, new InvalidFpsError(((Number) upper3).intValue()), new Function1() { // from class: com.mrousavy.camera.core.CameraSession_ConfigurationKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(CameraSession_ConfigurationKt.configureOutputs$lambda$13$lambda$12(targetFpsRange, (CameraDeviceFormat) obj));
                    }
                });
                ImageAnalysis_Builder_setTargetFrameRateKt.setTargetFrameRate(builder5, targetFpsRange);
            }
            if (format != null) {
                Log.i(CameraSession.TAG, "Frame Processor size: " + format.getVideoSize());
                ResolutionSelector resolutionSelectorBuild4 = ResolutionSelector_forSizeKt.forSize(new ResolutionSelector.Builder(), format.getVideoSize()).setAllowedResolutionMode(0).build();
                Intrinsics.checkNotNullExpressionValue(resolutionSelectorBuild4, "build(...)");
                builder5.setResolutionSelector(resolutionSelectorBuild4);
            }
            ImageAnalysis imageAnalysisBuild = builder5.build();
            Intrinsics.checkNotNullExpressionValue(imageAnalysisBuild, "build(...)");
            imageAnalysisBuild.setAnalyzer(CameraQueues.INSTANCE.getVideoQueue().getExecutor(), new FrameProcessorPipeline(cameraSession.getCallback()));
            cameraSession.setFrameProcessorOutput$react_native_vision_camera_release(imageAnalysisBuild);
        } else {
            cameraSession.setFrameProcessorOutput$react_native_vision_camera_release(null);
        }
        CameraConfiguration.Output<CameraConfiguration.CodeScanner> codeScanner = configuration.getCodeScanner();
        CameraConfiguration.Output.Enabled enabled5 = codeScanner instanceof CameraConfiguration.Output.Enabled ? (CameraConfiguration.Output.Enabled) codeScanner : null;
        if (enabled5 != null) {
            Log.i(CameraSession.TAG, "Creating CodeScanner output...");
            ImageAnalysis imageAnalysisBuild2 = new ImageAnalysis.Builder().build();
            Intrinsics.checkNotNullExpressionValue(imageAnalysisBuild2, "build(...)");
            imageAnalysisBuild2.setAnalyzer(CameraQueues.INSTANCE.getAnalyzerExecutor(), new CodeScannerPipeline((CameraConfiguration.CodeScanner) enabled5.getConfig(), cameraSession.getCallback()));
            cameraSession.setCodeScannerOutput$react_native_vision_camera_release(imageAnalysisBuild2);
        } else {
            cameraSession.setCodeScannerOutput$react_native_vision_camera_release(null);
        }
        Log.i(CameraSession.TAG, "Successfully created new Outputs for Camera #" + configuration.getCameraId() + "!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean configureOutputs$lambda$2$lambda$0(CameraConfiguration cameraConfiguration, CameraDeviceFormat it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getVideoStabilizationModes().contains(cameraConfiguration.getVideoStabilizationMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean configureOutputs$lambda$2$lambda$1(Range range, CameraDeviceFormat it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ((double) ((Number) range.getLower()).intValue()) >= it.getMinFps() && ((double) ((Number) range.getUpper()).intValue()) <= it.getMaxFps();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean configureOutputs$lambda$11$lambda$8(CameraConfiguration cameraConfiguration, CameraDeviceFormat it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getVideoStabilizationModes().contains(cameraConfiguration.getVideoStabilizationMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean configureOutputs$lambda$11$lambda$9(Range range, CameraDeviceFormat it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ((double) ((Number) range.getLower()).intValue()) >= it.getMinFps() && ((double) ((Number) range.getUpper()).intValue()) <= it.getMaxFps();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean configureOutputs$lambda$11$lambda$10(CameraDeviceFormat it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getSupportsVideoHdr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean configureOutputs$lambda$13$lambda$12(Range range, CameraDeviceFormat it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ((double) ((Number) range.getLower()).intValue()) >= it.getMinFps() && ((double) ((Number) range.getUpper()).intValue()) <= it.getMaxFps();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @android.annotation.SuppressLint({"RestrictedApi"})
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object configureCamera(@org.jetbrains.annotations.NotNull com.mrousavy.camera.core.CameraSession r21, @org.jetbrains.annotations.NotNull androidx.camera.lifecycle.ProcessCameraProvider r22, @org.jetbrains.annotations.NotNull com.mrousavy.camera.core.CameraConfiguration r23, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r24) throws com.mrousavy.camera.core.NoCameraDeviceError, com.mrousavy.camera.core.PhotoHdrAndVideoHdrNotSupportedSimultaneously, com.mrousavy.camera.core.LowLightBoostNotSupportedWithHdr, com.mrousavy.camera.core.NoOutputsError {
        /*
            Method dump skipped, instructions count: 697
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraSession_ConfigurationKt.configureCamera(com.mrousavy.camera.core.CameraSession, androidx.camera.lifecycle.ProcessCameraProvider, com.mrousavy.camera.core.CameraConfiguration, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit configureCamera$lambda$15(Ref.BooleanRef booleanRef, CameraSession cameraSession, CameraState cameraState) {
        Log.i(CameraSession.TAG, "Camera State: " + cameraState.getType() + " (has error: " + (cameraState.getError() != null) + ")");
        boolean z = cameraState.getType() == CameraState.Type.OPEN;
        if (z != booleanRef.element) {
            if (z) {
                cameraSession.getCallback().onStarted();
            } else {
                cameraSession.getCallback().onStopped();
            }
            booleanRef.element = z;
        }
        CameraState.StateError error = cameraState.getError();
        if (error != null) {
            cameraSession.getCallback().onError(StateError_toCameraErrorKt.toCameraError(error));
        }
        return Unit.INSTANCE;
    }

    public static final void configureSideProps(@NotNull CameraSession cameraSession, @NotNull CameraConfiguration config) throws CameraNotReadyError, FlashUnavailableError {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        Camera camera$react_native_vision_camera_release = cameraSession.getCamera();
        if (camera$react_native_vision_camera_release == null) {
            throw new CameraNotReadyError();
        }
        ZoomState value = camera$react_native_vision_camera_release.getCameraInfo().getZoomState().getValue();
        if (!Intrinsics.areEqual(value != null ? Float.valueOf(value.getZoomRatio()) : null, config.getZoom())) {
            camera$react_native_vision_camera_release.getCameraControl().setZoomRatio(config.getZoom());
        }
        Integer value2 = camera$react_native_vision_camera_release.getCameraInfo().getTorchState().getValue();
        boolean z = value2 != null && value2.intValue() == 1;
        boolean z2 = config.getTorch() == Torch.ON;
        if (z != z2) {
            if (z2 && !camera$react_native_vision_camera_release.getCameraInfo().hasFlashUnit()) {
                throw new FlashUnavailableError();
            }
            camera$react_native_vision_camera_release.getCameraControl().enableTorch(z2);
        }
        int exposureCompensationIndex = camera$react_native_vision_camera_release.getCameraInfo().getExposureState().getExposureCompensationIndex();
        Double exposure = config.getExposure();
        int iRoundToInt = exposure != null ? MathKt.roundToInt(exposure.doubleValue()) : 0;
        if (exposureCompensationIndex != iRoundToInt) {
            camera$react_native_vision_camera_release.getCameraControl().setExposureCompensationIndex(iRoundToInt);
        }
    }

    public static final void configureIsActive(@NotNull CameraSession cameraSession, @NotNull CameraConfiguration config) {
        Intrinsics.checkNotNullParameter(cameraSession, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        if (config.isActive()) {
            cameraSession.getLifecycleRegistry().setCurrentState(Lifecycle.State.STARTED);
            cameraSession.getLifecycleRegistry().setCurrentState(Lifecycle.State.RESUMED);
        } else {
            cameraSession.getLifecycleRegistry().setCurrentState(Lifecycle.State.STARTED);
            cameraSession.getLifecycleRegistry().setCurrentState(Lifecycle.State.CREATED);
        }
    }
}
