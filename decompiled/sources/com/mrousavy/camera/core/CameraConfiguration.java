package com.mrousavy.camera.core;

import android.util.Range;
import androidx.camera.core.Preview;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.MimeTypes;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.mrousavy.camera.core.types.CameraDeviceFormat;
import com.mrousavy.camera.core.types.CodeType;
import com.mrousavy.camera.core.types.OutputOrientation;
import com.mrousavy.camera.core.types.PixelFormat;
import com.mrousavy.camera.core.types.QualityBalance;
import com.mrousavy.camera.core.types.Torch;
import com.mrousavy.camera.core.types.VideoStabilizationMode;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0018\u0002\n\u0002\b(\b\u0086\b\u0018\u0000 \u0087\u00012\u00020\u0001:\u0012~\u007f\u0080\u0001\u0081\u0001\u0082\u0001\u0083\u0001\u0084\u0001\u0085\u0001\u0086\u0001\u0087\u0001Bé\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020 \u0012\b\b\u0002\u0010!\u001a\u00020\u0013\u0012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0005¢\u0006\u0004\b$\u0010%J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010h\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\u000f\u0010i\u001a\b\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003J\u000f\u0010j\u001a\b\u0012\u0004\u0012\u00020\f0\u0005HÆ\u0003J\u000f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005HÆ\u0003J\u0010\u0010l\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010m\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00107J\t\u0010n\u001a\u00020\u0013HÆ\u0003J\t\u0010o\u001a\u00020\u0015HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\t\u0010q\u001a\u00020\u0013HÆ\u0003J\t\u0010r\u001a\u00020\u001aHÆ\u0003J\t\u0010s\u001a\u00020\u001cHÆ\u0003J\u0010\u0010t\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0002\u0010TJ\t\u0010u\u001a\u00020 HÆ\u0003J\t\u0010v\u001a\u00020\u0013HÆ\u0003J\u000f\u0010w\u001a\b\u0012\u0004\u0012\u00020#0\u0005HÆ\u0003Jð\u0001\u0010x\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00132\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00132\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0005HÆ\u0001¢\u0006\u0002\u0010yJ\u0013\u0010z\u001a\u00020\u00132\b\u0010{\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010|\u001a\u00020\u0010HÖ\u0001J\t\u0010}\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010+\"\u0004\b/\u0010-R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010+\"\u0004\b1\u0010-R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010+\"\u0004\b5\u0010-R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b;\u00107\"\u0004\b<\u00109R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010>\"\u0004\bJ\u0010@R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010W\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001a\u0010!\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010>\"\u0004\b\\\u0010@R \u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010+\"\u0004\b^\u0010-R\u0019\u0010_\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010`8F¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0013\u0010c\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\bd\u0010e¨\u0006\u0088\u0001"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration;", "", "cameraId", "", "preview", "Lcom/mrousavy/camera/core/CameraConfiguration$Output;", "Lcom/mrousavy/camera/core/CameraConfiguration$Preview;", "photo", "Lcom/mrousavy/camera/core/CameraConfiguration$Photo;", MimeTypes.BASE_TYPE_VIDEO, "Lcom/mrousavy/camera/core/CameraConfiguration$Video;", "frameProcessor", "Lcom/mrousavy/camera/core/CameraConfiguration$FrameProcessor;", "codeScanner", "Lcom/mrousavy/camera/core/CameraConfiguration$CodeScanner;", "minFps", "", "maxFps", "enableLocation", "", "outputOrientation", "Lcom/mrousavy/camera/core/types/OutputOrientation;", "format", "Lcom/mrousavy/camera/core/types/CameraDeviceFormat;", "enableLowLightBoost", "torch", "Lcom/mrousavy/camera/core/types/Torch;", "videoStabilizationMode", "Lcom/mrousavy/camera/core/types/VideoStabilizationMode;", "exposure", "", "zoom", "", "isActive", MimeTypes.BASE_TYPE_AUDIO, "Lcom/mrousavy/camera/core/CameraConfiguration$Audio;", "<init>", "(Ljava/lang/String;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Ljava/lang/Integer;Ljava/lang/Integer;ZLcom/mrousavy/camera/core/types/OutputOrientation;Lcom/mrousavy/camera/core/types/CameraDeviceFormat;ZLcom/mrousavy/camera/core/types/Torch;Lcom/mrousavy/camera/core/types/VideoStabilizationMode;Ljava/lang/Double;FZLcom/mrousavy/camera/core/CameraConfiguration$Output;)V", "getCameraId", "()Ljava/lang/String;", "setCameraId", "(Ljava/lang/String;)V", "getPreview", "()Lcom/mrousavy/camera/core/CameraConfiguration$Output;", "setPreview", "(Lcom/mrousavy/camera/core/CameraConfiguration$Output;)V", "getPhoto", "setPhoto", "getVideo", "setVideo", "getFrameProcessor", "setFrameProcessor", "getCodeScanner", "setCodeScanner", "getMinFps", "()Ljava/lang/Integer;", "setMinFps", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMaxFps", "setMaxFps", "getEnableLocation", "()Z", "setEnableLocation", "(Z)V", "getOutputOrientation", "()Lcom/mrousavy/camera/core/types/OutputOrientation;", "setOutputOrientation", "(Lcom/mrousavy/camera/core/types/OutputOrientation;)V", "getFormat", "()Lcom/mrousavy/camera/core/types/CameraDeviceFormat;", "setFormat", "(Lcom/mrousavy/camera/core/types/CameraDeviceFormat;)V", "getEnableLowLightBoost", "setEnableLowLightBoost", "getTorch", "()Lcom/mrousavy/camera/core/types/Torch;", "setTorch", "(Lcom/mrousavy/camera/core/types/Torch;)V", "getVideoStabilizationMode", "()Lcom/mrousavy/camera/core/types/VideoStabilizationMode;", "setVideoStabilizationMode", "(Lcom/mrousavy/camera/core/types/VideoStabilizationMode;)V", "getExposure", "()Ljava/lang/Double;", "setExposure", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getZoom", "()F", "setZoom", "(F)V", "setActive", "getAudio", "setAudio", "targetFpsRange", "Landroid/util/Range;", "getTargetFpsRange", "()Landroid/util/Range;", "targetPreviewAspectRatio", "getTargetPreviewAspectRatio", "()Ljava/lang/Float;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "(Ljava/lang/String;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Lcom/mrousavy/camera/core/CameraConfiguration$Output;Ljava/lang/Integer;Ljava/lang/Integer;ZLcom/mrousavy/camera/core/types/OutputOrientation;Lcom/mrousavy/camera/core/types/CameraDeviceFormat;ZLcom/mrousavy/camera/core/types/Torch;Lcom/mrousavy/camera/core/types/VideoStabilizationMode;Ljava/lang/Double;FZLcom/mrousavy/camera/core/CameraConfiguration$Output;)Lcom/mrousavy/camera/core/CameraConfiguration;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "toString", "CodeScanner", "Photo", "Video", "FrameProcessor", "Audio", "Preview", "Output", "Difference", "AbortThrow", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CameraConfiguration {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private Output audio;
    private String cameraId;
    private Output codeScanner;
    private boolean enableLocation;
    private boolean enableLowLightBoost;
    private Double exposure;
    private CameraDeviceFormat format;
    private Output frameProcessor;
    private boolean isActive;
    private Integer maxFps;
    private Integer minFps;
    private OutputOrientation outputOrientation;
    private Output photo;
    private Output preview;
    private Torch torch;
    private Output video;
    private VideoStabilizationMode videoStabilizationMode;
    private float zoom;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$AbortThrow;", "", "<init>", "()V", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AbortThrow extends Throwable {
    }

    public CameraConfiguration() {
        this(null, null, null, null, null, null, null, null, false, null, null, false, null, null, null, BitmapDescriptorFactory.HUE_RED, false, null, 262143, null);
    }

    public static /* synthetic */ CameraConfiguration copy$default(CameraConfiguration cameraConfiguration, String str, Output output, Output output2, Output output3, Output output4, Output output5, Integer num, Integer num2, boolean z, OutputOrientation outputOrientation, CameraDeviceFormat cameraDeviceFormat, boolean z2, Torch torch, VideoStabilizationMode videoStabilizationMode, Double d, float f, boolean z3, Output output6, int i, Object obj) {
        return cameraConfiguration.copy((i & 1) != 0 ? cameraConfiguration.cameraId : str, (i & 2) != 0 ? cameraConfiguration.preview : output, (i & 4) != 0 ? cameraConfiguration.photo : output2, (i & 8) != 0 ? cameraConfiguration.video : output3, (i & 16) != 0 ? cameraConfiguration.frameProcessor : output4, (i & 32) != 0 ? cameraConfiguration.codeScanner : output5, (i & 64) != 0 ? cameraConfiguration.minFps : num, (i & 128) != 0 ? cameraConfiguration.maxFps : num2, (i & 256) != 0 ? cameraConfiguration.enableLocation : z, (i & 512) != 0 ? cameraConfiguration.outputOrientation : outputOrientation, (i & 1024) != 0 ? cameraConfiguration.format : cameraDeviceFormat, (i & 2048) != 0 ? cameraConfiguration.enableLowLightBoost : z2, (i & 4096) != 0 ? cameraConfiguration.torch : torch, (i & 8192) != 0 ? cameraConfiguration.videoStabilizationMode : videoStabilizationMode, (i & 16384) != 0 ? cameraConfiguration.exposure : d, (i & 32768) != 0 ? cameraConfiguration.zoom : f, (i & 65536) != 0 ? cameraConfiguration.isActive : z3, (i & 131072) != 0 ? cameraConfiguration.audio : output6);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCameraId() {
        return this.cameraId;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final OutputOrientation getOutputOrientation() {
        return this.outputOrientation;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final CameraDeviceFormat getFormat() {
        return this.format;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getEnableLowLightBoost() {
        return this.enableLowLightBoost;
    }

    @NotNull
    /* renamed from: component13, reason: from getter */
    public final Torch getTorch() {
        return this.torch;
    }

    @NotNull
    /* renamed from: component14, reason: from getter */
    public final VideoStabilizationMode getVideoStabilizationMode() {
        return this.videoStabilizationMode;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final Double getExposure() {
        return this.exposure;
    }

    /* renamed from: component16, reason: from getter */
    public final float getZoom() {
        return this.zoom;
    }

    /* renamed from: component17, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    @NotNull
    public final Output<Audio> component18() {
        return this.audio;
    }

    @NotNull
    public final Output<Preview> component2() {
        return this.preview;
    }

    @NotNull
    public final Output<Photo> component3() {
        return this.photo;
    }

    @NotNull
    public final Output<Video> component4() {
        return this.video;
    }

    @NotNull
    public final Output<FrameProcessor> component5() {
        return this.frameProcessor;
    }

    @NotNull
    public final Output<CodeScanner> component6() {
        return this.codeScanner;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Integer getMinFps() {
        return this.minFps;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getMaxFps() {
        return this.maxFps;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getEnableLocation() {
        return this.enableLocation;
    }

    @NotNull
    public final CameraConfiguration copy(@Nullable String cameraId, @NotNull Output<Preview> preview, @NotNull Output<Photo> photo, @NotNull Output<Video> video, @NotNull Output<FrameProcessor> frameProcessor, @NotNull Output<CodeScanner> codeScanner, @Nullable Integer minFps, @Nullable Integer maxFps, boolean enableLocation, @NotNull OutputOrientation outputOrientation, @Nullable CameraDeviceFormat format, boolean enableLowLightBoost, @NotNull Torch torch, @NotNull VideoStabilizationMode videoStabilizationMode, @Nullable Double exposure, float zoom, boolean isActive, @NotNull Output<Audio> audio) {
        Intrinsics.checkNotNullParameter(preview, "preview");
        Intrinsics.checkNotNullParameter(photo, "photo");
        Intrinsics.checkNotNullParameter(video, "video");
        Intrinsics.checkNotNullParameter(frameProcessor, "frameProcessor");
        Intrinsics.checkNotNullParameter(codeScanner, "codeScanner");
        Intrinsics.checkNotNullParameter(outputOrientation, "outputOrientation");
        Intrinsics.checkNotNullParameter(torch, "torch");
        Intrinsics.checkNotNullParameter(videoStabilizationMode, "videoStabilizationMode");
        Intrinsics.checkNotNullParameter(audio, "audio");
        return new CameraConfiguration(cameraId, preview, photo, video, frameProcessor, codeScanner, minFps, maxFps, enableLocation, outputOrientation, format, enableLowLightBoost, torch, videoStabilizationMode, exposure, zoom, isActive, audio);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CameraConfiguration)) {
            return false;
        }
        CameraConfiguration cameraConfiguration = (CameraConfiguration) other;
        return Intrinsics.areEqual(this.cameraId, cameraConfiguration.cameraId) && Intrinsics.areEqual(this.preview, cameraConfiguration.preview) && Intrinsics.areEqual(this.photo, cameraConfiguration.photo) && Intrinsics.areEqual(this.video, cameraConfiguration.video) && Intrinsics.areEqual(this.frameProcessor, cameraConfiguration.frameProcessor) && Intrinsics.areEqual(this.codeScanner, cameraConfiguration.codeScanner) && Intrinsics.areEqual(this.minFps, cameraConfiguration.minFps) && Intrinsics.areEqual(this.maxFps, cameraConfiguration.maxFps) && this.enableLocation == cameraConfiguration.enableLocation && this.outputOrientation == cameraConfiguration.outputOrientation && Intrinsics.areEqual(this.format, cameraConfiguration.format) && this.enableLowLightBoost == cameraConfiguration.enableLowLightBoost && this.torch == cameraConfiguration.torch && this.videoStabilizationMode == cameraConfiguration.videoStabilizationMode && Intrinsics.areEqual((Object) this.exposure, (Object) cameraConfiguration.exposure) && Float.compare(this.zoom, cameraConfiguration.zoom) == 0 && this.isActive == cameraConfiguration.isActive && Intrinsics.areEqual(this.audio, cameraConfiguration.audio);
    }

    public int hashCode() {
        String str = this.cameraId;
        int iHashCode = (((((((((((str == null ? 0 : str.hashCode()) * 31) + this.preview.hashCode()) * 31) + this.photo.hashCode()) * 31) + this.video.hashCode()) * 31) + this.frameProcessor.hashCode()) * 31) + this.codeScanner.hashCode()) * 31;
        Integer num = this.minFps;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.maxFps;
        int iHashCode3 = (((((iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31) + Boolean.hashCode(this.enableLocation)) * 31) + this.outputOrientation.hashCode()) * 31;
        CameraDeviceFormat cameraDeviceFormat = this.format;
        int iHashCode4 = (((((((iHashCode3 + (cameraDeviceFormat == null ? 0 : cameraDeviceFormat.hashCode())) * 31) + Boolean.hashCode(this.enableLowLightBoost)) * 31) + this.torch.hashCode()) * 31) + this.videoStabilizationMode.hashCode()) * 31;
        Double d = this.exposure;
        return ((((((iHashCode4 + (d != null ? d.hashCode() : 0)) * 31) + Float.hashCode(this.zoom)) * 31) + Boolean.hashCode(this.isActive)) * 31) + this.audio.hashCode();
    }

    @NotNull
    public String toString() {
        return "CameraConfiguration(cameraId=" + this.cameraId + ", preview=" + this.preview + ", photo=" + this.photo + ", video=" + this.video + ", frameProcessor=" + this.frameProcessor + ", codeScanner=" + this.codeScanner + ", minFps=" + this.minFps + ", maxFps=" + this.maxFps + ", enableLocation=" + this.enableLocation + ", outputOrientation=" + this.outputOrientation + ", format=" + this.format + ", enableLowLightBoost=" + this.enableLowLightBoost + ", torch=" + this.torch + ", videoStabilizationMode=" + this.videoStabilizationMode + ", exposure=" + this.exposure + ", zoom=" + this.zoom + ", isActive=" + this.isActive + ", audio=" + this.audio + ")";
    }

    public CameraConfiguration(@Nullable String str, @NotNull Output<Preview> preview, @NotNull Output<Photo> photo, @NotNull Output<Video> video, @NotNull Output<FrameProcessor> frameProcessor, @NotNull Output<CodeScanner> codeScanner, @Nullable Integer num, @Nullable Integer num2, boolean z, @NotNull OutputOrientation outputOrientation, @Nullable CameraDeviceFormat cameraDeviceFormat, boolean z2, @NotNull Torch torch, @NotNull VideoStabilizationMode videoStabilizationMode, @Nullable Double d, float f, boolean z3, @NotNull Output<Audio> audio) {
        Intrinsics.checkNotNullParameter(preview, "preview");
        Intrinsics.checkNotNullParameter(photo, "photo");
        Intrinsics.checkNotNullParameter(video, "video");
        Intrinsics.checkNotNullParameter(frameProcessor, "frameProcessor");
        Intrinsics.checkNotNullParameter(codeScanner, "codeScanner");
        Intrinsics.checkNotNullParameter(outputOrientation, "outputOrientation");
        Intrinsics.checkNotNullParameter(torch, "torch");
        Intrinsics.checkNotNullParameter(videoStabilizationMode, "videoStabilizationMode");
        Intrinsics.checkNotNullParameter(audio, "audio");
        this.cameraId = str;
        this.preview = preview;
        this.photo = photo;
        this.video = video;
        this.frameProcessor = frameProcessor;
        this.codeScanner = codeScanner;
        this.minFps = num;
        this.maxFps = num2;
        this.enableLocation = z;
        this.outputOrientation = outputOrientation;
        this.format = cameraDeviceFormat;
        this.enableLowLightBoost = z2;
        this.torch = torch;
        this.videoStabilizationMode = videoStabilizationMode;
        this.exposure = d;
        this.zoom = f;
        this.isActive = z3;
        this.audio = audio;
    }

    @Nullable
    public final String getCameraId() {
        return this.cameraId;
    }

    public final void setCameraId(@Nullable String str) {
        this.cameraId = str;
    }

    public /* synthetic */ CameraConfiguration(String str, Output output, Output output2, Output output3, Output output4, Output output5, Integer num, Integer num2, boolean z, OutputOrientation outputOrientation, CameraDeviceFormat cameraDeviceFormat, boolean z2, Torch torch, VideoStabilizationMode videoStabilizationMode, Double d, float f, boolean z3, Output output6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? Output.Disabled.INSTANCE.create() : output, (i & 4) != 0 ? Output.Disabled.INSTANCE.create() : output2, (i & 8) != 0 ? Output.Disabled.INSTANCE.create() : output3, (i & 16) != 0 ? Output.Disabled.INSTANCE.create() : output4, (i & 32) != 0 ? Output.Disabled.INSTANCE.create() : output5, (i & 64) != 0 ? null : num, (i & 128) != 0 ? null : num2, (i & 256) != 0 ? false : z, (i & 512) != 0 ? OutputOrientation.DEVICE : outputOrientation, (i & 1024) != 0 ? null : cameraDeviceFormat, (i & 2048) != 0 ? false : z2, (i & 4096) != 0 ? Torch.OFF : torch, (i & 8192) != 0 ? VideoStabilizationMode.OFF : videoStabilizationMode, (i & 16384) != 0 ? null : d, (i & 32768) != 0 ? 1.0f : f, (i & 65536) != 0 ? false : z3, (i & 131072) != 0 ? Output.Disabled.INSTANCE.create() : output6);
    }

    @NotNull
    public final Output<Preview> getPreview() {
        return this.preview;
    }

    public final void setPreview(@NotNull Output<Preview> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.preview = output;
    }

    @NotNull
    public final Output<Photo> getPhoto() {
        return this.photo;
    }

    public final void setPhoto(@NotNull Output<Photo> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.photo = output;
    }

    @NotNull
    public final Output<Video> getVideo() {
        return this.video;
    }

    public final void setVideo(@NotNull Output<Video> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.video = output;
    }

    @NotNull
    public final Output<FrameProcessor> getFrameProcessor() {
        return this.frameProcessor;
    }

    public final void setFrameProcessor(@NotNull Output<FrameProcessor> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.frameProcessor = output;
    }

    @NotNull
    public final Output<CodeScanner> getCodeScanner() {
        return this.codeScanner;
    }

    public final void setCodeScanner(@NotNull Output<CodeScanner> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.codeScanner = output;
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

    public final boolean getEnableLocation() {
        return this.enableLocation;
    }

    public final void setEnableLocation(boolean z) {
        this.enableLocation = z;
    }

    @NotNull
    public final OutputOrientation getOutputOrientation() {
        return this.outputOrientation;
    }

    public final void setOutputOrientation(@NotNull OutputOrientation outputOrientation) {
        Intrinsics.checkNotNullParameter(outputOrientation, "<set-?>");
        this.outputOrientation = outputOrientation;
    }

    @Nullable
    public final CameraDeviceFormat getFormat() {
        return this.format;
    }

    public final void setFormat(@Nullable CameraDeviceFormat cameraDeviceFormat) {
        this.format = cameraDeviceFormat;
    }

    public final boolean getEnableLowLightBoost() {
        return this.enableLowLightBoost;
    }

    public final void setEnableLowLightBoost(boolean z) {
        this.enableLowLightBoost = z;
    }

    @NotNull
    public final Torch getTorch() {
        return this.torch;
    }

    public final void setTorch(@NotNull Torch torch) {
        Intrinsics.checkNotNullParameter(torch, "<set-?>");
        this.torch = torch;
    }

    @NotNull
    public final VideoStabilizationMode getVideoStabilizationMode() {
        return this.videoStabilizationMode;
    }

    public final void setVideoStabilizationMode(@NotNull VideoStabilizationMode videoStabilizationMode) {
        Intrinsics.checkNotNullParameter(videoStabilizationMode, "<set-?>");
        this.videoStabilizationMode = videoStabilizationMode;
    }

    @Nullable
    public final Double getExposure() {
        return this.exposure;
    }

    public final void setExposure(@Nullable Double d) {
        this.exposure = d;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final void setZoom(float f) {
        this.zoom = f;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }

    @NotNull
    public final Output<Audio> getAudio() {
        return this.audio;
    }

    public final void setAudio(@NotNull Output<Audio> output) {
        Intrinsics.checkNotNullParameter(output, "<set-?>");
        this.audio = output;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$CodeScanner;", "", "codeTypes", "", "Lcom/mrousavy/camera/core/types/CodeType;", "<init>", "(Ljava/util/List;)V", "getCodeTypes", "()Ljava/util/List;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class CodeScanner {
        private final List codeTypes;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CodeScanner copy$default(CodeScanner codeScanner, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = codeScanner.codeTypes;
            }
            return codeScanner.copy(list);
        }

        @NotNull
        public final List<CodeType> component1() {
            return this.codeTypes;
        }

        @NotNull
        public final CodeScanner copy(@NotNull List<? extends CodeType> codeTypes) {
            Intrinsics.checkNotNullParameter(codeTypes, "codeTypes");
            return new CodeScanner(codeTypes);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CodeScanner) && Intrinsics.areEqual(this.codeTypes, ((CodeScanner) other).codeTypes);
        }

        public int hashCode() {
            return this.codeTypes.hashCode();
        }

        @NotNull
        public String toString() {
            return "CodeScanner(codeTypes=" + this.codeTypes + ")";
        }

        public CodeScanner(@NotNull List<? extends CodeType> codeTypes) {
            Intrinsics.checkNotNullParameter(codeTypes, "codeTypes");
            this.codeTypes = codeTypes;
        }

        @NotNull
        public final List<CodeType> getCodeTypes() {
            return this.codeTypes;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Photo;", "", "isMirrored", "", "enableHdr", "photoQualityBalance", "Lcom/mrousavy/camera/core/types/QualityBalance;", "<init>", "(ZZLcom/mrousavy/camera/core/types/QualityBalance;)V", "()Z", "getEnableHdr", "getPhotoQualityBalance", "()Lcom/mrousavy/camera/core/types/QualityBalance;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Photo {
        private final boolean enableHdr;
        private final boolean isMirrored;
        private final QualityBalance photoQualityBalance;

        public static /* synthetic */ Photo copy$default(Photo photo, boolean z, boolean z2, QualityBalance qualityBalance, int i, Object obj) {
            if ((i & 1) != 0) {
                z = photo.isMirrored;
            }
            if ((i & 2) != 0) {
                z2 = photo.enableHdr;
            }
            if ((i & 4) != 0) {
                qualityBalance = photo.photoQualityBalance;
            }
            return photo.copy(z, z2, qualityBalance);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsMirrored() {
            return this.isMirrored;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getEnableHdr() {
            return this.enableHdr;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final QualityBalance getPhotoQualityBalance() {
            return this.photoQualityBalance;
        }

        @NotNull
        public final Photo copy(boolean isMirrored, boolean enableHdr, @NotNull QualityBalance photoQualityBalance) {
            Intrinsics.checkNotNullParameter(photoQualityBalance, "photoQualityBalance");
            return new Photo(isMirrored, enableHdr, photoQualityBalance);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Photo)) {
                return false;
            }
            Photo photo = (Photo) other;
            return this.isMirrored == photo.isMirrored && this.enableHdr == photo.enableHdr && this.photoQualityBalance == photo.photoQualityBalance;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.isMirrored) * 31) + Boolean.hashCode(this.enableHdr)) * 31) + this.photoQualityBalance.hashCode();
        }

        @NotNull
        public String toString() {
            return "Photo(isMirrored=" + this.isMirrored + ", enableHdr=" + this.enableHdr + ", photoQualityBalance=" + this.photoQualityBalance + ")";
        }

        public Photo(boolean z, boolean z2, @NotNull QualityBalance photoQualityBalance) {
            Intrinsics.checkNotNullParameter(photoQualityBalance, "photoQualityBalance");
            this.isMirrored = z;
            this.enableHdr = z2;
            this.photoQualityBalance = photoQualityBalance;
        }

        public final boolean getEnableHdr() {
            return this.enableHdr;
        }

        @NotNull
        public final QualityBalance getPhotoQualityBalance() {
            return this.photoQualityBalance;
        }

        public final boolean isMirrored() {
            return this.isMirrored;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ:\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Video;", "", "isMirrored", "", "enableHdr", "bitRateOverride", "", "bitRateMultiplier", "<init>", "(ZZLjava/lang/Double;Ljava/lang/Double;)V", "()Z", "getEnableHdr", "getBitRateOverride", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getBitRateMultiplier", "component1", "component2", "component3", "component4", "copy", "(ZZLjava/lang/Double;Ljava/lang/Double;)Lcom/mrousavy/camera/core/CameraConfiguration$Video;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Video {
        private final Double bitRateMultiplier;
        private final Double bitRateOverride;
        private final boolean enableHdr;
        private final boolean isMirrored;

        public static /* synthetic */ Video copy$default(Video video, boolean z, boolean z2, Double d, Double d2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = video.isMirrored;
            }
            if ((i & 2) != 0) {
                z2 = video.enableHdr;
            }
            if ((i & 4) != 0) {
                d = video.bitRateOverride;
            }
            if ((i & 8) != 0) {
                d2 = video.bitRateMultiplier;
            }
            return video.copy(z, z2, d, d2);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsMirrored() {
            return this.isMirrored;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getEnableHdr() {
            return this.enableHdr;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final Double getBitRateOverride() {
            return this.bitRateOverride;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final Double getBitRateMultiplier() {
            return this.bitRateMultiplier;
        }

        @NotNull
        public final Video copy(boolean isMirrored, boolean enableHdr, @Nullable Double bitRateOverride, @Nullable Double bitRateMultiplier) {
            return new Video(isMirrored, enableHdr, bitRateOverride, bitRateMultiplier);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Video)) {
                return false;
            }
            Video video = (Video) other;
            return this.isMirrored == video.isMirrored && this.enableHdr == video.enableHdr && Intrinsics.areEqual((Object) this.bitRateOverride, (Object) video.bitRateOverride) && Intrinsics.areEqual((Object) this.bitRateMultiplier, (Object) video.bitRateMultiplier);
        }

        public int hashCode() {
            int iHashCode = ((Boolean.hashCode(this.isMirrored) * 31) + Boolean.hashCode(this.enableHdr)) * 31;
            Double d = this.bitRateOverride;
            int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
            Double d2 = this.bitRateMultiplier;
            return iHashCode2 + (d2 != null ? d2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Video(isMirrored=" + this.isMirrored + ", enableHdr=" + this.enableHdr + ", bitRateOverride=" + this.bitRateOverride + ", bitRateMultiplier=" + this.bitRateMultiplier + ")";
        }

        public Video(boolean z, boolean z2, @Nullable Double d, @Nullable Double d2) {
            this.isMirrored = z;
            this.enableHdr = z2;
            this.bitRateOverride = d;
            this.bitRateMultiplier = d2;
        }

        @Nullable
        public final Double getBitRateMultiplier() {
            return this.bitRateMultiplier;
        }

        @Nullable
        public final Double getBitRateOverride() {
            return this.bitRateOverride;
        }

        public final boolean getEnableHdr() {
            return this.enableHdr;
        }

        public final boolean isMirrored() {
            return this.isMirrored;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$FrameProcessor;", "", "isMirrored", "", "pixelFormat", "Lcom/mrousavy/camera/core/types/PixelFormat;", "<init>", "(ZLcom/mrousavy/camera/core/types/PixelFormat;)V", "()Z", "getPixelFormat", "()Lcom/mrousavy/camera/core/types/PixelFormat;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class FrameProcessor {
        private final boolean isMirrored;
        private final PixelFormat pixelFormat;

        public static /* synthetic */ FrameProcessor copy$default(FrameProcessor frameProcessor, boolean z, PixelFormat pixelFormat, int i, Object obj) {
            if ((i & 1) != 0) {
                z = frameProcessor.isMirrored;
            }
            if ((i & 2) != 0) {
                pixelFormat = frameProcessor.pixelFormat;
            }
            return frameProcessor.copy(z, pixelFormat);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsMirrored() {
            return this.isMirrored;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final PixelFormat getPixelFormat() {
            return this.pixelFormat;
        }

        @NotNull
        public final FrameProcessor copy(boolean isMirrored, @NotNull PixelFormat pixelFormat) {
            Intrinsics.checkNotNullParameter(pixelFormat, "pixelFormat");
            return new FrameProcessor(isMirrored, pixelFormat);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FrameProcessor)) {
                return false;
            }
            FrameProcessor frameProcessor = (FrameProcessor) other;
            return this.isMirrored == frameProcessor.isMirrored && this.pixelFormat == frameProcessor.pixelFormat;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.isMirrored) * 31) + this.pixelFormat.hashCode();
        }

        @NotNull
        public String toString() {
            return "FrameProcessor(isMirrored=" + this.isMirrored + ", pixelFormat=" + this.pixelFormat + ")";
        }

        public FrameProcessor(boolean z, @NotNull PixelFormat pixelFormat) {
            Intrinsics.checkNotNullParameter(pixelFormat, "pixelFormat");
            this.isMirrored = z;
            this.pixelFormat = pixelFormat;
        }

        @NotNull
        public final PixelFormat getPixelFormat() {
            return this.pixelFormat;
        }

        public final boolean isMirrored() {
            return this.isMirrored;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0018\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Audio;", "", "nothing", "", "<init>", "(Lkotlin/Unit;)V", "getNothing", "()Lkotlin/Unit;", "Lkotlin/Unit;", "component1", "copy", "(Lkotlin/Unit;)Lcom/mrousavy/camera/core/CameraConfiguration$Audio;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Audio {
        private final Unit nothing;

        public static /* synthetic */ Audio copy$default(Audio audio, Unit unit, int i, Object obj) {
            if ((i & 1) != 0) {
                unit = audio.nothing;
            }
            return audio.copy(unit);
        }

        public final void component1() {
        }

        @NotNull
        public final Audio copy(@NotNull Unit nothing) {
            Intrinsics.checkNotNullParameter(nothing, "nothing");
            return new Audio(nothing);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Audio) && Intrinsics.areEqual(this.nothing, ((Audio) other).nothing);
        }

        public int hashCode() {
            return this.nothing.hashCode();
        }

        @NotNull
        public String toString() {
            return "Audio(nothing=" + this.nothing + ")";
        }

        public Audio(@NotNull Unit nothing) {
            Intrinsics.checkNotNullParameter(nothing, "nothing");
            this.nothing = nothing;
        }

        @NotNull
        public final Unit getNothing() {
            return this.nothing;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Preview;", "", "surfaceProvider", "Landroidx/camera/core/Preview$SurfaceProvider;", "<init>", "(Landroidx/camera/core/Preview$SurfaceProvider;)V", "getSurfaceProvider", "()Landroidx/camera/core/Preview$SurfaceProvider;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Preview {
        private final Preview.SurfaceProvider surfaceProvider;

        public static /* synthetic */ Preview copy$default(Preview preview, Preview.SurfaceProvider surfaceProvider, int i, Object obj) {
            if ((i & 1) != 0) {
                surfaceProvider = preview.surfaceProvider;
            }
            return preview.copy(surfaceProvider);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final Preview.SurfaceProvider getSurfaceProvider() {
            return this.surfaceProvider;
        }

        @NotNull
        public final Preview copy(@NotNull Preview.SurfaceProvider surfaceProvider) {
            Intrinsics.checkNotNullParameter(surfaceProvider, "surfaceProvider");
            return new Preview(surfaceProvider);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Preview) && Intrinsics.areEqual(this.surfaceProvider, ((Preview) other).surfaceProvider);
        }

        public int hashCode() {
            return this.surfaceProvider.hashCode();
        }

        @NotNull
        public String toString() {
            return "Preview(surfaceProvider=" + this.surfaceProvider + ")";
        }

        public Preview(@NotNull Preview.SurfaceProvider surfaceProvider) {
            Intrinsics.checkNotNullParameter(surfaceProvider, "surfaceProvider");
            this.surfaceProvider = surfaceProvider;
        }

        @NotNull
        public final Preview.SurfaceProvider getSurfaceProvider() {
            return this.surfaceProvider;
        }
    }

    @Nullable
    public final Range<Integer> getTargetFpsRange() {
        Integer num;
        Integer num2 = this.minFps;
        if (num2 == null || (num = this.maxFps) == null) {
            return null;
        }
        return new Range<>(num2, num);
    }

    @Nullable
    public final Float getTargetPreviewAspectRatio() {
        if (this.format == null) {
            return null;
        }
        Output output = this.video;
        Output.Enabled enabled = output instanceof Output.Enabled ? (Output.Enabled) output : null;
        Output output2 = this.photo;
        Output.Enabled enabled2 = output2 instanceof Output.Enabled ? (Output.Enabled) output2 : null;
        if (enabled != null) {
            return Float.valueOf(r0.getVideoWidth() / r0.getVideoHeight());
        }
        if (enabled2 != null) {
            return Float.valueOf(r0.getPhotoWidth() / r0.getPhotoHeight());
        }
        return null;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\b\tB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Output;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "isEnabled", "", "()Z", BucketLifecycleConfiguration.DISABLED, "Enabled", "Lcom/mrousavy/camera/core/CameraConfiguration$Output$Disabled;", "Lcom/mrousavy/camera/core/CameraConfiguration$Output$Enabled;", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class Output<T> {
        public /* synthetic */ Output(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Output() {
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \t*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002¨\u0006\n"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Output$Disabled;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/mrousavy/camera/core/CameraConfiguration$Output;", "<init>", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Disabled<T> extends Output<T> {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            public /* synthetic */ Disabled(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Disabled() {
                super(null);
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Output$Disabled$Companion;", "", "<init>", "()V", "create", "Lcom/mrousavy/camera/core/CameraConfiguration$Output$Disabled;", ExifInterface.GPS_DIRECTION_TRUE, "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @NotNull
                public final <T> Disabled<T> create() {
                    return new Disabled<>(null);
                }
            }

            public boolean equals(@Nullable Object other) {
                return other instanceof Disabled;
            }
        }

        public final boolean isEnabled() {
            return this instanceof Enabled;
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \r*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Output$Enabled;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/mrousavy/camera/core/CameraConfiguration$Output;", "config", "<init>", "(Ljava/lang/Object;)V", "getConfig", "()Ljava/lang/Object;", "Ljava/lang/Object;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Enabled<T> extends Output<T> {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);
            private final Object config;

            public /* synthetic */ Enabled(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
                this(obj);
            }

            private Enabled(Object obj) {
                super(null);
                this.config = obj;
            }

            public final T getConfig() {
                return (T) this.config;
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0002\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u0006¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Output$Enabled$Companion;", "", "<init>", "()V", "create", "Lcom/mrousavy/camera/core/CameraConfiguration$Output$Enabled;", ExifInterface.GPS_DIRECTION_TRUE, "config", "(Ljava/lang/Object;)Lcom/mrousavy/camera/core/CameraConfiguration$Output$Enabled;", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @NotNull
                public final <T> Enabled<T> create(T config) {
                    return new Enabled<>(config, null);
                }
            }

            public boolean equals(@Nullable Object other) {
                return (other instanceof Enabled) && Intrinsics.areEqual(this.config, ((Enabled) other).config);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Difference;", "", "deviceChanged", "", "outputsChanged", "sidePropsChanged", "isActiveChanged", "orientationChanged", "locationChanged", "<init>", "(ZZZZZZ)V", "getDeviceChanged", "()Z", "getOutputsChanged", "getSidePropsChanged", "getOrientationChanged", "getLocationChanged", "hasChanges", "getHasChanges", "component1", "component2", "component3", "component4", "component5", "component6", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Difference {
        private final boolean deviceChanged;
        private final boolean isActiveChanged;
        private final boolean locationChanged;
        private final boolean orientationChanged;
        private final boolean outputsChanged;
        private final boolean sidePropsChanged;

        public static /* synthetic */ Difference copy$default(Difference difference, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, Object obj) {
            if ((i & 1) != 0) {
                z = difference.deviceChanged;
            }
            if ((i & 2) != 0) {
                z2 = difference.outputsChanged;
            }
            boolean z7 = z2;
            if ((i & 4) != 0) {
                z3 = difference.sidePropsChanged;
            }
            boolean z8 = z3;
            if ((i & 8) != 0) {
                z4 = difference.isActiveChanged;
            }
            boolean z9 = z4;
            if ((i & 16) != 0) {
                z5 = difference.orientationChanged;
            }
            boolean z10 = z5;
            if ((i & 32) != 0) {
                z6 = difference.locationChanged;
            }
            return difference.copy(z, z7, z8, z9, z10, z6);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getDeviceChanged() {
            return this.deviceChanged;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getOutputsChanged() {
            return this.outputsChanged;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getSidePropsChanged() {
            return this.sidePropsChanged;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsActiveChanged() {
            return this.isActiveChanged;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getOrientationChanged() {
            return this.orientationChanged;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getLocationChanged() {
            return this.locationChanged;
        }

        @NotNull
        public final Difference copy(boolean deviceChanged, boolean outputsChanged, boolean sidePropsChanged, boolean isActiveChanged, boolean orientationChanged, boolean locationChanged) {
            return new Difference(deviceChanged, outputsChanged, sidePropsChanged, isActiveChanged, orientationChanged, locationChanged);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Difference)) {
                return false;
            }
            Difference difference = (Difference) other;
            return this.deviceChanged == difference.deviceChanged && this.outputsChanged == difference.outputsChanged && this.sidePropsChanged == difference.sidePropsChanged && this.isActiveChanged == difference.isActiveChanged && this.orientationChanged == difference.orientationChanged && this.locationChanged == difference.locationChanged;
        }

        public int hashCode() {
            return (((((((((Boolean.hashCode(this.deviceChanged) * 31) + Boolean.hashCode(this.outputsChanged)) * 31) + Boolean.hashCode(this.sidePropsChanged)) * 31) + Boolean.hashCode(this.isActiveChanged)) * 31) + Boolean.hashCode(this.orientationChanged)) * 31) + Boolean.hashCode(this.locationChanged);
        }

        @NotNull
        public String toString() {
            return "Difference(deviceChanged=" + this.deviceChanged + ", outputsChanged=" + this.outputsChanged + ", sidePropsChanged=" + this.sidePropsChanged + ", isActiveChanged=" + this.isActiveChanged + ", orientationChanged=" + this.orientationChanged + ", locationChanged=" + this.locationChanged + ")";
        }

        public Difference(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            this.deviceChanged = z;
            this.outputsChanged = z2;
            this.sidePropsChanged = z3;
            this.isActiveChanged = z4;
            this.orientationChanged = z5;
            this.locationChanged = z6;
        }

        public final boolean getDeviceChanged() {
            return this.deviceChanged;
        }

        public final boolean getOutputsChanged() {
            return this.outputsChanged;
        }

        public final boolean getSidePropsChanged() {
            return this.sidePropsChanged;
        }

        public final boolean isActiveChanged() {
            return this.isActiveChanged;
        }

        public final boolean getOrientationChanged() {
            return this.orientationChanged;
        }

        public final boolean getLocationChanged() {
            return this.locationChanged;
        }

        public final boolean getHasChanges() {
            return this.deviceChanged || this.outputsChanged || this.sidePropsChanged || this.isActiveChanged || this.orientationChanged || this.locationChanged;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/mrousavy/camera/core/CameraConfiguration$Companion;", "", "<init>", "()V", "copyOf", "Lcom/mrousavy/camera/core/CameraConfiguration;", ETCPaymentMethod.OTHER, "difference", "Lcom/mrousavy/camera/core/CameraConfiguration$Difference;", ViewProps.LEFT, ViewProps.RIGHT, "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CameraConfiguration copyOf(@Nullable CameraConfiguration other) {
            CameraConfiguration cameraConfigurationCopy$default;
            return (other == null || (cameraConfigurationCopy$default = CameraConfiguration.copy$default(other, null, null, null, null, null, null, null, null, false, null, null, false, null, null, null, BitmapDescriptorFactory.HUE_RED, false, null, 262143, null)) == null) ? new CameraConfiguration(null, null, null, null, null, null, null, null, false, null, null, false, null, null, null, BitmapDescriptorFactory.HUE_RED, false, null, 262143, null) : cameraConfigurationCopy$default;
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00d9  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.mrousavy.camera.core.CameraConfiguration.Difference difference(@org.jetbrains.annotations.Nullable com.mrousavy.camera.core.CameraConfiguration r11, @org.jetbrains.annotations.NotNull com.mrousavy.camera.core.CameraConfiguration r12) {
            /*
                Method dump skipped, instructions count: 272
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.CameraConfiguration.Companion.difference(com.mrousavy.camera.core.CameraConfiguration, com.mrousavy.camera.core.CameraConfiguration):com.mrousavy.camera.core.CameraConfiguration$Difference");
        }
    }
}
