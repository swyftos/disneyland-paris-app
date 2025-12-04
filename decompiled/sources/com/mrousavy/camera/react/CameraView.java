package com.mrousavy.camera.react;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.Preview;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.MimeTypes;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.messaging.Constants;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.mrousavy.camera.core.CameraConfiguration;
import com.mrousavy.camera.core.CameraSession;
import com.mrousavy.camera.core.CodeScannerFrame;
import com.mrousavy.camera.core.types.CameraDeviceFormat;
import com.mrousavy.camera.core.types.CodeScannerOptions;
import com.mrousavy.camera.core.types.Orientation;
import com.mrousavy.camera.core.types.OutputOrientation;
import com.mrousavy.camera.core.types.PixelFormat;
import com.mrousavy.camera.core.types.PreviewViewType;
import com.mrousavy.camera.core.types.QualityBalance;
import com.mrousavy.camera.core.types.ResizeMode;
import com.mrousavy.camera.core.types.ShutterType;
import com.mrousavy.camera.core.types.Torch;
import com.mrousavy.camera.core.types.VideoStabilizationMode;
import com.mrousavy.camera.frameprocessors.Frame;
import com.mrousavy.camera.frameprocessors.FrameProcessor;
import com.mrousavy.camera.react.CameraView;
import com.mrousavy.camera.react.FpsSampleCollector;
import com.mrousavy.camera.react.extensions.ViewGroup_installHierarchyFitterKt;
import com.rumax.reactnative.pdfviewer.PDFView;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 Æ\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002Æ\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010¦\u0001\u001a\u00030§\u0001H\u0014J\n\u0010¨\u0001\u001a\u00030§\u0001H\u0014J\b\u0010©\u0001\u001a\u00030§\u0001J\b\u0010ª\u0001\u001a\u00030§\u0001J\n\u0010«\u0001\u001a\u00030§\u0001H\u0003J\n\u0010¬\u0001\u001a\u00030§\u0001H\u0002J\n\u0010\u00ad\u0001\u001a\u00030\u009d\u0001H\u0002J\u0014\u0010®\u0001\u001a\u00030§\u00012\b\u0010¯\u0001\u001a\u00030°\u0001H\u0016J\u0014\u0010±\u0001\u001a\u00030§\u00012\b\u0010²\u0001\u001a\u00030³\u0001H\u0016J\n\u0010´\u0001\u001a\u00030§\u0001H\u0016J\n\u0010µ\u0001\u001a\u00030§\u0001H\u0016J\n\u0010¶\u0001\u001a\u00030§\u0001H\u0016J\u0014\u0010·\u0001\u001a\u00030§\u00012\b\u0010¸\u0001\u001a\u00030¹\u0001H\u0016J\u0013\u0010º\u0001\u001a\u00030§\u00012\u0007\u0010t\u001a\u00030»\u0001H\u0016J\u0014\u0010¼\u0001\u001a\u00030§\u00012\b\u0010½\u0001\u001a\u00030»\u0001H\u0016J%\u0010¾\u0001\u001a\u00030§\u00012\u000f\u0010¿\u0001\u001a\n\u0012\u0005\u0012\u00030Á\u00010À\u00012\b\u0010Â\u0001\u001a\u00030Ã\u0001H\u0016J\u0013\u0010Ä\u0001\u001a\u00030§\u00012\u0007\u0010Å\u0001\u001a\u00020OH\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001a\u0010\u001c\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R\u001a\u0010\u001f\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001a\u0010\"\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0011\"\u0004\b-\u0010\u0013R$\u0010/\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0011\"\u0004\b1\u0010\u0013R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u00108\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001e\u0010?\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b@\u0010;\"\u0004\bA\u0010=R\u001c\u0010B\u001a\u0004\u0018\u00010CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0011\"\u0004\bJ\u0010\u0013R\u001a\u0010K\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0011\"\u0004\bM\u0010\u0013R\u001e\u0010N\u001a\u0004\u0018\u00010OX\u0086\u000e¢\u0006\u0010\n\u0002\u0010T\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001e\u0010U\u001a\u0004\u0018\u00010OX\u0086\u000e¢\u0006\u0010\n\u0002\u0010T\u001a\u0004\bV\u0010Q\"\u0004\bW\u0010SR\u001a\u0010X\u001a\u00020YX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010^\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0011\"\u0004\b`\u0010\u0013R\u001a\u0010a\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u0011\"\u0004\bb\u0010\u0013R\u001a\u0010c\u001a\u00020dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001a\u0010i\u001a\u00020jX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010o\u001a\u00020OX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001a\u0010t\u001a\u00020uX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR$\u0010{\u001a\u00020z2\u0006\u0010.\u001a\u00020z@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR'\u0010\u0080\u0001\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0011\"\u0005\b\u0082\u0001\u0010\u0013R+\u0010\u0084\u0001\u001a\u00030\u0083\u00012\u0007\u0010.\u001a\u00030\u0083\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\"\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R\u000f\u0010\u008f\u0001\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0090\u0001\u001a\u00030\u0091\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0092\u0001\u001a\u00030\u0093\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\"\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R\"\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0006\b \u0001\u0010¡\u0001R\u0010\u0010¢\u0001\u001a\u00030£\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¤\u0001\u001a\u00030¥\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Ç\u0001"}, d2 = {"Lcom/mrousavy/camera/react/CameraView;", "Landroid/widget/FrameLayout;", "Lcom/mrousavy/camera/core/CameraSession$Callback;", "Lcom/mrousavy/camera/react/FpsSampleCollector$Callback;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "cameraId", "", "getCameraId", "()Ljava/lang/String;", "setCameraId", "(Ljava/lang/String;)V", "enableDepthData", "", "getEnableDepthData", "()Z", "setEnableDepthData", "(Z)V", "enablePortraitEffectsMatteDelivery", "getEnablePortraitEffectsMatteDelivery", "setEnablePortraitEffectsMatteDelivery", "isMirrored", "setMirrored", "photo", "getPhoto", "setPhoto", MimeTypes.BASE_TYPE_VIDEO, "getVideo", "setVideo", MimeTypes.BASE_TYPE_AUDIO, "getAudio", "setAudio", "enableFrameProcessor", "getEnableFrameProcessor", "setEnableFrameProcessor", "pixelFormat", "Lcom/mrousavy/camera/core/types/PixelFormat;", "getPixelFormat", "()Lcom/mrousavy/camera/core/types/PixelFormat;", "setPixelFormat", "(Lcom/mrousavy/camera/core/types/PixelFormat;)V", "enableLocation", "getEnableLocation", "setEnableLocation", "value", "preview", "getPreview", "setPreview", "format", "Lcom/mrousavy/camera/core/types/CameraDeviceFormat;", "getFormat", "()Lcom/mrousavy/camera/core/types/CameraDeviceFormat;", "setFormat", "(Lcom/mrousavy/camera/core/types/CameraDeviceFormat;)V", "minFps", "", "getMinFps", "()Ljava/lang/Integer;", "setMinFps", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "maxFps", "getMaxFps", "setMaxFps", "videoStabilizationMode", "Lcom/mrousavy/camera/core/types/VideoStabilizationMode;", "getVideoStabilizationMode", "()Lcom/mrousavy/camera/core/types/VideoStabilizationMode;", "setVideoStabilizationMode", "(Lcom/mrousavy/camera/core/types/VideoStabilizationMode;)V", "videoHdr", "getVideoHdr", "setVideoHdr", "photoHdr", "getPhotoHdr", "setPhotoHdr", "videoBitRateOverride", "", "getVideoBitRateOverride", "()Ljava/lang/Double;", "setVideoBitRateOverride", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "videoBitRateMultiplier", "getVideoBitRateMultiplier", "setVideoBitRateMultiplier", "photoQualityBalance", "Lcom/mrousavy/camera/core/types/QualityBalance;", "getPhotoQualityBalance", "()Lcom/mrousavy/camera/core/types/QualityBalance;", "setPhotoQualityBalance", "(Lcom/mrousavy/camera/core/types/QualityBalance;)V", "lowLightBoost", "getLowLightBoost", "setLowLightBoost", "isActive", "setActive", "torch", "Lcom/mrousavy/camera/core/types/Torch;", "getTorch", "()Lcom/mrousavy/camera/core/types/Torch;", "setTorch", "(Lcom/mrousavy/camera/core/types/Torch;)V", "zoom", "", "getZoom", "()F", "setZoom", "(F)V", "exposure", "getExposure", "()D", "setExposure", "(D)V", "outputOrientation", "Lcom/mrousavy/camera/core/types/OutputOrientation;", "getOutputOrientation", "()Lcom/mrousavy/camera/core/types/OutputOrientation;", "setOutputOrientation", "(Lcom/mrousavy/camera/core/types/OutputOrientation;)V", "Lcom/mrousavy/camera/core/types/PreviewViewType;", "androidPreviewViewType", "getAndroidPreviewViewType", "()Lcom/mrousavy/camera/core/types/PreviewViewType;", "setAndroidPreviewViewType", "(Lcom/mrousavy/camera/core/types/PreviewViewType;)V", "enableZoomGesture", "getEnableZoomGesture", "setEnableZoomGesture", "Lcom/mrousavy/camera/core/types/ResizeMode;", ViewProps.RESIZE_MODE, "getResizeMode", "()Lcom/mrousavy/camera/core/types/ResizeMode;", "setResizeMode", "(Lcom/mrousavy/camera/core/types/ResizeMode;)V", "codeScannerOptions", "Lcom/mrousavy/camera/core/types/CodeScannerOptions;", "getCodeScannerOptions", "()Lcom/mrousavy/camera/core/types/CodeScannerOptions;", "setCodeScannerOptions", "(Lcom/mrousavy/camera/core/types/CodeScannerOptions;)V", "isMounted", "mainCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "cameraSession", "Lcom/mrousavy/camera/core/CameraSession;", "getCameraSession$react_native_vision_camera_release", "()Lcom/mrousavy/camera/core/CameraSession;", "frameProcessor", "Lcom/mrousavy/camera/frameprocessors/FrameProcessor;", "getFrameProcessor$react_native_vision_camera_release", "()Lcom/mrousavy/camera/frameprocessors/FrameProcessor;", "setFrameProcessor$react_native_vision_camera_release", "(Lcom/mrousavy/camera/frameprocessors/FrameProcessor;)V", "previewView", "Landroidx/camera/view/PreviewView;", "getPreviewView$react_native_vision_camera_release", "()Landroidx/camera/view/PreviewView;", "setPreviewView$react_native_vision_camera_release", "(Landroidx/camera/view/PreviewView;)V", "currentConfigureCall", "", "fpsSampleCollector", "Lcom/mrousavy/camera/react/FpsSampleCollector;", "onAttachedToWindow", "", "onDetachedFromWindow", "destroy", "update", "updateZoomGesture", "updatePreview", "createPreviewView", "onFrame", TypedValues.AttributesType.S_FRAME, "Lcom/mrousavy/camera/frameprocessors/Frame;", PDFView.EVENT_ON_ERROR, Constants.IPC_BUNDLE_KEY_SEND_ERROR, "", "onInitialized", "onStarted", "onStopped", "onShutter", "type", "Lcom/mrousavy/camera/core/types/ShutterType;", "onOutputOrientationChanged", "Lcom/mrousavy/camera/core/types/Orientation;", "onPreviewOrientationChanged", "previewOrientation", "onCodeScanned", "codes", "", "Lcom/google/mlkit/vision/barcode/common/Barcode;", "scannerFrame", "Lcom/mrousavy/camera/core/CodeScannerFrame;", "onAverageFpsChanged", "averageFps", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SuppressLint({"ClickableViewAccessibility", "ViewConstructor", "MissingPermission"})
/* loaded from: classes4.dex */
public final class CameraView extends FrameLayout implements CameraSession.Callback, FpsSampleCollector.Callback {

    @NotNull
    public static final String TAG = "CameraView";
    private PreviewViewType androidPreviewViewType;
    private boolean audio;
    private String cameraId;
    private final CameraSession cameraSession;
    private CodeScannerOptions codeScannerOptions;
    private long currentConfigureCall;
    private boolean enableDepthData;
    private boolean enableFrameProcessor;
    private boolean enableLocation;
    private boolean enablePortraitEffectsMatteDelivery;
    private boolean enableZoomGesture;
    private double exposure;
    private CameraDeviceFormat format;
    private final FpsSampleCollector fpsSampleCollector;
    private FrameProcessor frameProcessor;
    private boolean isActive;
    private boolean isMirrored;
    private boolean isMounted;
    private boolean lowLightBoost;
    private final CoroutineScope mainCoroutineScope;
    private Integer maxFps;
    private Integer minFps;
    private OutputOrientation outputOrientation;
    private boolean photo;
    private boolean photoHdr;
    private QualityBalance photoQualityBalance;
    private PixelFormat pixelFormat;
    private boolean preview;
    private PreviewView previewView;
    private ResizeMode resizeMode;
    private Torch torch;
    private boolean video;
    private Double videoBitRateMultiplier;
    private Double videoBitRateOverride;
    private boolean videoHdr;
    private VideoStabilizationMode videoStabilizationMode;
    private float zoom;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.pixelFormat = PixelFormat.YUV;
        this.preview = true;
        this.photoQualityBalance = QualityBalance.SPEED;
        this.torch = Torch.OFF;
        this.zoom = 1.0f;
        this.outputOrientation = OutputOrientation.DEVICE;
        this.androidPreviewViewType = PreviewViewType.SURFACE_VIEW;
        this.resizeMode = ResizeMode.COVER;
        this.mainCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.currentConfigureCall = System.currentTimeMillis();
        this.fpsSampleCollector = new FpsSampleCollector(this);
        setClipToOutline(true);
        this.cameraSession = new CameraSession(context, this);
        ViewGroup_installHierarchyFitterKt.installHierarchyFitter(this);
        updatePreview();
    }

    @Nullable
    public final String getCameraId() {
        return this.cameraId;
    }

    public final void setCameraId(@Nullable String str) {
        this.cameraId = str;
    }

    public final boolean getEnableDepthData() {
        return this.enableDepthData;
    }

    public final void setEnableDepthData(boolean z) {
        this.enableDepthData = z;
    }

    public final boolean getEnablePortraitEffectsMatteDelivery() {
        return this.enablePortraitEffectsMatteDelivery;
    }

    public final void setEnablePortraitEffectsMatteDelivery(boolean z) {
        this.enablePortraitEffectsMatteDelivery = z;
    }

    /* renamed from: isMirrored, reason: from getter */
    public final boolean getIsMirrored() {
        return this.isMirrored;
    }

    public final void setMirrored(boolean z) {
        this.isMirrored = z;
    }

    public final boolean getPhoto() {
        return this.photo;
    }

    public final void setPhoto(boolean z) {
        this.photo = z;
    }

    public final boolean getVideo() {
        return this.video;
    }

    public final void setVideo(boolean z) {
        this.video = z;
    }

    public final boolean getAudio() {
        return this.audio;
    }

    public final void setAudio(boolean z) {
        this.audio = z;
    }

    public final boolean getEnableFrameProcessor() {
        return this.enableFrameProcessor;
    }

    public final void setEnableFrameProcessor(boolean z) {
        this.enableFrameProcessor = z;
    }

    @NotNull
    public final PixelFormat getPixelFormat() {
        return this.pixelFormat;
    }

    public final void setPixelFormat(@NotNull PixelFormat pixelFormat) {
        Intrinsics.checkNotNullParameter(pixelFormat, "<set-?>");
        this.pixelFormat = pixelFormat;
    }

    public final boolean getEnableLocation() {
        return this.enableLocation;
    }

    public final void setEnableLocation(boolean z) {
        this.enableLocation = z;
    }

    public final boolean getPreview() {
        return this.preview;
    }

    public final void setPreview(boolean z) {
        this.preview = z;
        updatePreview();
    }

    @Nullable
    public final CameraDeviceFormat getFormat() {
        return this.format;
    }

    public final void setFormat(@Nullable CameraDeviceFormat cameraDeviceFormat) {
        this.format = cameraDeviceFormat;
    }

    @Nullable
    public final Integer getMinFps() {
        return this.minFps;
    }

    public final void setMinFps(@Nullable Integer num) {
        this.minFps = num;
    }

    @Nullable
    public final Integer getMaxFps() {
        return this.maxFps;
    }

    public final void setMaxFps(@Nullable Integer num) {
        this.maxFps = num;
    }

    @Nullable
    public final VideoStabilizationMode getVideoStabilizationMode() {
        return this.videoStabilizationMode;
    }

    public final void setVideoStabilizationMode(@Nullable VideoStabilizationMode videoStabilizationMode) {
        this.videoStabilizationMode = videoStabilizationMode;
    }

    public final boolean getVideoHdr() {
        return this.videoHdr;
    }

    public final void setVideoHdr(boolean z) {
        this.videoHdr = z;
    }

    public final boolean getPhotoHdr() {
        return this.photoHdr;
    }

    public final void setPhotoHdr(boolean z) {
        this.photoHdr = z;
    }

    @Nullable
    public final Double getVideoBitRateOverride() {
        return this.videoBitRateOverride;
    }

    public final void setVideoBitRateOverride(@Nullable Double d) {
        this.videoBitRateOverride = d;
    }

    @Nullable
    public final Double getVideoBitRateMultiplier() {
        return this.videoBitRateMultiplier;
    }

    public final void setVideoBitRateMultiplier(@Nullable Double d) {
        this.videoBitRateMultiplier = d;
    }

    @NotNull
    public final QualityBalance getPhotoQualityBalance() {
        return this.photoQualityBalance;
    }

    public final void setPhotoQualityBalance(@NotNull QualityBalance qualityBalance) {
        Intrinsics.checkNotNullParameter(qualityBalance, "<set-?>");
        this.photoQualityBalance = qualityBalance;
    }

    public final boolean getLowLightBoost() {
        return this.lowLightBoost;
    }

    public final void setLowLightBoost(boolean z) {
        this.lowLightBoost = z;
    }

    /* renamed from: isActive, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }

    @NotNull
    public final Torch getTorch() {
        return this.torch;
    }

    public final void setTorch(@NotNull Torch torch) {
        Intrinsics.checkNotNullParameter(torch, "<set-?>");
        this.torch = torch;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final void setZoom(float f) {
        this.zoom = f;
    }

    public final double getExposure() {
        return this.exposure;
    }

    public final void setExposure(double d) {
        this.exposure = d;
    }

    @NotNull
    public final OutputOrientation getOutputOrientation() {
        return this.outputOrientation;
    }

    public final void setOutputOrientation(@NotNull OutputOrientation outputOrientation) {
        Intrinsics.checkNotNullParameter(outputOrientation, "<set-?>");
        this.outputOrientation = outputOrientation;
    }

    @NotNull
    public final PreviewViewType getAndroidPreviewViewType() {
        return this.androidPreviewViewType;
    }

    public final void setAndroidPreviewViewType(@NotNull PreviewViewType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.androidPreviewViewType = value;
        updatePreview();
    }

    public final boolean getEnableZoomGesture() {
        return this.enableZoomGesture;
    }

    public final void setEnableZoomGesture(boolean z) {
        this.enableZoomGesture = z;
        updateZoomGesture();
    }

    @NotNull
    public final ResizeMode getResizeMode() {
        return this.resizeMode;
    }

    public final void setResizeMode(@NotNull ResizeMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.resizeMode = value;
        updatePreview();
    }

    @Nullable
    public final CodeScannerOptions getCodeScannerOptions() {
        return this.codeScannerOptions;
    }

    public final void setCodeScannerOptions(@Nullable CodeScannerOptions codeScannerOptions) {
        this.codeScannerOptions = codeScannerOptions;
    }

    @NotNull
    /* renamed from: getCameraSession$react_native_vision_camera_release, reason: from getter */
    public final CameraSession getCameraSession() {
        return this.cameraSession;
    }

    @Nullable
    /* renamed from: getFrameProcessor$react_native_vision_camera_release, reason: from getter */
    public final FrameProcessor getFrameProcessor() {
        return this.frameProcessor;
    }

    public final void setFrameProcessor$react_native_vision_camera_release(@Nullable FrameProcessor frameProcessor) {
        this.frameProcessor = frameProcessor;
    }

    @Nullable
    /* renamed from: getPreviewView$react_native_vision_camera_release, reason: from getter */
    public final PreviewView getPreviewView() {
        return this.previewView;
    }

    public final void setPreviewView$react_native_vision_camera_release(@Nullable PreviewView previewView) {
        this.previewView = previewView;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Log.i("CameraView", "CameraView attached to window!");
        super.onAttachedToWindow();
        if (!this.isMounted) {
            this.isMounted = true;
            CameraView_EventsKt.invokeOnViewReady(this);
        }
        this.fpsSampleCollector.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        Log.i("CameraView", "CameraView detached from window!");
        super.onDetachedFromWindow();
        this.fpsSampleCollector.stop();
    }

    public final void destroy() {
        this.cameraSession.close();
    }

    public final void update() {
        Log.i("CameraView", "Updating CameraSession...");
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.currentConfigureCall = jCurrentTimeMillis;
        BuildersKt__Builders_commonKt.launch$default(this.mainCoroutineScope, null, null, new AnonymousClass1(jCurrentTimeMillis, null), 3, null);
    }

    /* renamed from: com.mrousavy.camera.react.CameraView$update$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ long $now;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j, Continuation continuation) {
            super(2, continuation);
            this.$now = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CameraView.this.new AnonymousClass1(this.$now, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CameraSession cameraSession = CameraView.this.getCameraSession();
                final CameraView cameraView = CameraView.this;
                final long j = this.$now;
                Function1<? super CameraConfiguration, Unit> function1 = new Function1() { // from class: com.mrousavy.camera.react.CameraView$update$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return CameraView.AnonymousClass1.invokeSuspend$lambda$0(cameraView, j, (CameraConfiguration) obj2);
                    }
                };
                this.label = 1;
                if (cameraSession.configure(function1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(CameraView cameraView, long j, CameraConfiguration cameraConfiguration) throws CameraConfiguration.AbortThrow {
            if (cameraView.currentConfigureCall != j) {
                Log.i("CameraView", "A new configure { ... } call arrived, aborting this one...");
                throw new CameraConfiguration.AbortThrow();
            }
            cameraConfiguration.setCameraId(cameraView.getCameraId());
            PreviewView previewView = cameraView.getPreviewView();
            if (previewView != null) {
                CameraConfiguration.Output.Enabled.Companion companion = CameraConfiguration.Output.Enabled.INSTANCE;
                Preview.SurfaceProvider surfaceProvider = previewView.getSurfaceProvider();
                Intrinsics.checkNotNullExpressionValue(surfaceProvider, "getSurfaceProvider(...)");
                cameraConfiguration.setPreview(companion.create(new CameraConfiguration.Preview(surfaceProvider)));
            } else {
                cameraConfiguration.setPreview(CameraConfiguration.Output.Disabled.INSTANCE.create());
            }
            if (cameraView.getPhoto()) {
                cameraConfiguration.setPhoto(CameraConfiguration.Output.Enabled.INSTANCE.create(new CameraConfiguration.Photo(cameraView.getIsMirrored(), cameraView.getPhotoHdr(), cameraView.getPhotoQualityBalance())));
            } else {
                cameraConfiguration.setPhoto(CameraConfiguration.Output.Disabled.INSTANCE.create());
            }
            if (cameraView.getVideo() || cameraView.getEnableFrameProcessor()) {
                cameraConfiguration.setVideo(CameraConfiguration.Output.Enabled.INSTANCE.create(new CameraConfiguration.Video(cameraView.getIsMirrored(), cameraView.getVideoHdr(), cameraView.getVideoBitRateOverride(), cameraView.getVideoBitRateMultiplier())));
            } else {
                cameraConfiguration.setVideo(CameraConfiguration.Output.Disabled.INSTANCE.create());
            }
            if (cameraView.getEnableFrameProcessor()) {
                cameraConfiguration.setFrameProcessor(CameraConfiguration.Output.Enabled.INSTANCE.create(new CameraConfiguration.FrameProcessor(cameraView.getIsMirrored(), cameraView.getPixelFormat())));
            } else {
                cameraConfiguration.setFrameProcessor(CameraConfiguration.Output.Disabled.INSTANCE.create());
            }
            if (cameraView.getAudio()) {
                cameraConfiguration.setAudio(CameraConfiguration.Output.Enabled.INSTANCE.create(new CameraConfiguration.Audio(Unit.INSTANCE)));
            } else {
                cameraConfiguration.setAudio(CameraConfiguration.Output.Disabled.INSTANCE.create());
            }
            cameraConfiguration.setEnableLocation(cameraView.getEnableLocation() && cameraView.getIsActive());
            CodeScannerOptions codeScannerOptions = cameraView.getCodeScannerOptions();
            if (codeScannerOptions != null) {
                cameraConfiguration.setCodeScanner(CameraConfiguration.Output.Enabled.INSTANCE.create(new CameraConfiguration.CodeScanner(codeScannerOptions.getCodeTypes())));
            } else {
                cameraConfiguration.setCodeScanner(CameraConfiguration.Output.Disabled.INSTANCE.create());
            }
            cameraConfiguration.setOutputOrientation(cameraView.getOutputOrientation());
            cameraConfiguration.setFormat(cameraView.getFormat());
            cameraConfiguration.setMinFps(cameraView.getMinFps());
            cameraConfiguration.setMaxFps(cameraView.getMaxFps());
            cameraConfiguration.setEnableLowLightBoost(cameraView.getLowLightBoost());
            cameraConfiguration.setTorch(cameraView.getTorch());
            cameraConfiguration.setExposure(Double.valueOf(cameraView.getExposure()));
            cameraConfiguration.setZoom(cameraView.getZoom());
            cameraConfiguration.setActive(cameraView.getIsActive());
            return Unit.INSTANCE;
        }
    }

    private final void updateZoomGesture() {
        if (this.enableZoomGesture) {
            final ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.mrousavy.camera.react.CameraView$updateZoomGesture$scaleGestureDetector$1
                @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
                public boolean onScale(ScaleGestureDetector detector) {
                    Intrinsics.checkNotNullParameter(detector, "detector");
                    CameraView cameraView = this.this$0;
                    cameraView.setZoom(cameraView.getZoom() * detector.getScaleFactor());
                    this.this$0.update();
                    return true;
                }
            });
            setOnTouchListener(new View.OnTouchListener() { // from class: com.mrousavy.camera.react.CameraView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return CameraView.updateZoomGesture$lambda$0(scaleGestureDetector, view, motionEvent);
                }
            });
        } else {
            setOnTouchListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateZoomGesture$lambda$0(ScaleGestureDetector scaleGestureDetector, View view, MotionEvent motionEvent) {
        return scaleGestureDetector.onTouchEvent(motionEvent);
    }

    /* renamed from: com.mrousavy.camera.react.CameraView$updatePreview$1, reason: invalid class name and case insensitive filesystem */
    static final class C09011 extends SuspendLambda implements Function2 {
        int label;

        C09011(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return CameraView.this.new C09011(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (CameraView.this.getPreview() && CameraView.this.getPreviewView() == null) {
                CameraView cameraView = CameraView.this;
                cameraView.setPreviewView$react_native_vision_camera_release(cameraView.createPreviewView());
                CameraView cameraView2 = CameraView.this;
                cameraView2.addView(cameraView2.getPreviewView());
            } else if (!CameraView.this.getPreview() && CameraView.this.getPreviewView() != null) {
                CameraView cameraView3 = CameraView.this;
                cameraView3.removeView(cameraView3.getPreviewView());
                CameraView.this.setPreviewView$react_native_vision_camera_release(null);
            }
            PreviewView previewView = CameraView.this.getPreviewView();
            if (previewView != null) {
                CameraView cameraView4 = CameraView.this;
                previewView.setImplementationMode(cameraView4.getAndroidPreviewViewType().toPreviewImplementationMode());
                previewView.setScaleType(cameraView4.getResizeMode().toScaleType());
            }
            CameraView.this.update();
            return Unit.INSTANCE;
        }
    }

    private final void updatePreview() {
        BuildersKt__Builders_commonKt.launch$default(this.mainCoroutineScope, null, null, new C09011(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PreviewView createPreviewView() {
        PreviewView previewView = new PreviewView(getContext());
        ViewGroup_installHierarchyFitterKt.installHierarchyFitter(previewView);
        previewView.setImplementationMode(this.androidPreviewViewType.toPreviewImplementationMode());
        previewView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        previewView.getPreviewStreamState().observe(this.cameraSession, new CameraView$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.mrousavy.camera.react.CameraView$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CameraView.createPreviewView$lambda$2$lambda$1(booleanRef, this, (PreviewView.StreamState) obj);
            }
        }));
        return previewView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createPreviewView$lambda$2$lambda$1(Ref.BooleanRef booleanRef, CameraView cameraView, PreviewView.StreamState streamState) {
        Log.i("CameraView", "PreviewView Stream State changed to " + streamState);
        boolean z = streamState == PreviewView.StreamState.STREAMING;
        if (z != booleanRef.element) {
            if (z) {
                CameraView_EventsKt.invokeOnPreviewStarted(cameraView);
            } else {
                CameraView_EventsKt.invokeOnPreviewStopped(cameraView);
            }
            booleanRef.element = z;
        }
        return Unit.INSTANCE;
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onFrame(@NotNull Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        this.fpsSampleCollector.onTick();
        FrameProcessor frameProcessor = this.frameProcessor;
        if (frameProcessor != null) {
            frameProcessor.call(frame);
        }
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onError(@NotNull Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        CameraView_EventsKt.invokeOnError(this, error);
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onInitialized() {
        CameraView_EventsKt.invokeOnInitialized(this);
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onStarted() {
        CameraView_EventsKt.invokeOnStarted(this);
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onStopped() {
        CameraView_EventsKt.invokeOnStopped(this);
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onShutter(@NotNull ShutterType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        CameraView_EventsKt.invokeOnShutter(this, type);
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onOutputOrientationChanged(@NotNull Orientation outputOrientation) {
        Intrinsics.checkNotNullParameter(outputOrientation, "outputOrientation");
        CameraView_EventsKt.invokeOnOutputOrientationChanged(this, outputOrientation);
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onPreviewOrientationChanged(@NotNull Orientation previewOrientation) {
        Intrinsics.checkNotNullParameter(previewOrientation, "previewOrientation");
        CameraView_EventsKt.invokeOnPreviewOrientationChanged(this, previewOrientation);
    }

    @Override // com.mrousavy.camera.core.CameraSession.Callback
    public void onCodeScanned(@NotNull List<? extends Barcode> codes, @NotNull CodeScannerFrame scannerFrame) {
        Intrinsics.checkNotNullParameter(codes, "codes");
        Intrinsics.checkNotNullParameter(scannerFrame, "scannerFrame");
        CameraView_EventsKt.invokeOnCodeScanned(this, codes, scannerFrame);
    }

    @Override // com.mrousavy.camera.react.FpsSampleCollector.Callback
    public void onAverageFpsChanged(double averageFps) {
        CameraView_EventsKt.invokeOnAverageFpsChanged(this, averageFps);
    }
}
