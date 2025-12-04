package com.mrousavy.camera.core.types;

import android.util.Size;
import androidx.camera.video.FallbackStrategy;
import androidx.camera.video.Quality;
import androidx.camera.video.QualitySelector;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import com.mrousavy.camera.core.types.VideoStabilizationMode;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 N2\u00020\u0001:\u0001NB}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u00020,H\u0002J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\bHÆ\u0003J\t\u0010?\u001a\u00020\bHÆ\u0003J\t\u0010@\u001a\u00020\bHÆ\u0003J\t\u0010A\u001a\u00020\bHÆ\u0003J\t\u0010B\u001a\u00020\bHÆ\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\t\u0010D\u001a\u00020\u0011HÆ\u0003J\t\u0010E\u001a\u00020\u0013HÆ\u0003J\t\u0010F\u001a\u00020\u0013HÆ\u0003J\t\u0010G\u001a\u00020\u0013HÆ\u0003J\u009b\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013HÆ\u0001J\u0013\u0010I\u001a\u00020\u00132\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020\u0003HÖ\u0001J\t\u0010L\u001a\u00020MHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0011\u0010\u0015\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u0011\u0010+\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\b0\u0010.R\u001a\u00101\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u000302X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00107\u001a\u0002058F¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006O"}, d2 = {"Lcom/mrousavy/camera/core/types/CameraDeviceFormat;", "", "videoWidth", "", "videoHeight", "photoWidth", "photoHeight", "minFps", "", "maxFps", "minISO", "maxISO", "fieldOfView", "videoStabilizationModes", "", "Lcom/mrousavy/camera/core/types/VideoStabilizationMode;", "autoFocusSystem", "Lcom/mrousavy/camera/core/types/AutoFocusSystem;", "supportsVideoHdr", "", "supportsPhotoHdr", "supportsDepthCapture", "<init>", "(IIIIDDDDDLjava/util/List;Lcom/mrousavy/camera/core/types/AutoFocusSystem;ZZZ)V", "getVideoWidth", "()I", "getVideoHeight", "getPhotoWidth", "getPhotoHeight", "getMinFps", "()D", "getMaxFps", "getMinISO", "getMaxISO", "getFieldOfView", "getVideoStabilizationModes", "()Ljava/util/List;", "getAutoFocusSystem", "()Lcom/mrousavy/camera/core/types/AutoFocusSystem;", "getSupportsVideoHdr", "()Z", "getSupportsPhotoHdr", "getSupportsDepthCapture", "photoSize", "Landroid/util/Size;", "getPhotoSize", "()Landroid/util/Size;", "videoSize", "getVideoSize", "qualitySizes", "", "Landroidx/camera/video/Quality;", "getQualitySelector", "Landroidx/camera/video/QualitySelector;", TCEventPropertiesNames.TCP_SIZE, "videoQualitySelector", "getVideoQualitySelector", "()Landroidx/camera/video/QualitySelector;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "toString", "", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCameraDeviceFormat.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CameraDeviceFormat.kt\ncom/mrousavy/camera/core/types/CameraDeviceFormat\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,75:1\n1#2:76\n*E\n"})
/* loaded from: classes4.dex */
public final /* data */ class CameraDeviceFormat {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final AutoFocusSystem autoFocusSystem;
    private final double fieldOfView;
    private final double maxFps;
    private final double maxISO;
    private final double minFps;
    private final double minISO;
    private final int photoHeight;
    private final int photoWidth;
    private final Map qualitySizes;
    private final boolean supportsDepthCapture;
    private final boolean supportsPhotoHdr;
    private final boolean supportsVideoHdr;
    private final int videoHeight;
    private final List videoStabilizationModes;
    private final int videoWidth;

    /* renamed from: component1, reason: from getter */
    public final int getVideoWidth() {
        return this.videoWidth;
    }

    @NotNull
    public final List<VideoStabilizationMode> component10() {
        return this.videoStabilizationModes;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final AutoFocusSystem getAutoFocusSystem() {
        return this.autoFocusSystem;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getSupportsVideoHdr() {
        return this.supportsVideoHdr;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getSupportsPhotoHdr() {
        return this.supportsPhotoHdr;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getSupportsDepthCapture() {
        return this.supportsDepthCapture;
    }

    /* renamed from: component2, reason: from getter */
    public final int getVideoHeight() {
        return this.videoHeight;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPhotoWidth() {
        return this.photoWidth;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPhotoHeight() {
        return this.photoHeight;
    }

    /* renamed from: component5, reason: from getter */
    public final double getMinFps() {
        return this.minFps;
    }

    /* renamed from: component6, reason: from getter */
    public final double getMaxFps() {
        return this.maxFps;
    }

    /* renamed from: component7, reason: from getter */
    public final double getMinISO() {
        return this.minISO;
    }

    /* renamed from: component8, reason: from getter */
    public final double getMaxISO() {
        return this.maxISO;
    }

    /* renamed from: component9, reason: from getter */
    public final double getFieldOfView() {
        return this.fieldOfView;
    }

    @NotNull
    public final CameraDeviceFormat copy(int videoWidth, int videoHeight, int photoWidth, int photoHeight, double minFps, double maxFps, double minISO, double maxISO, double fieldOfView, @NotNull List<? extends VideoStabilizationMode> videoStabilizationModes, @NotNull AutoFocusSystem autoFocusSystem, boolean supportsVideoHdr, boolean supportsPhotoHdr, boolean supportsDepthCapture) {
        Intrinsics.checkNotNullParameter(videoStabilizationModes, "videoStabilizationModes");
        Intrinsics.checkNotNullParameter(autoFocusSystem, "autoFocusSystem");
        return new CameraDeviceFormat(videoWidth, videoHeight, photoWidth, photoHeight, minFps, maxFps, minISO, maxISO, fieldOfView, videoStabilizationModes, autoFocusSystem, supportsVideoHdr, supportsPhotoHdr, supportsDepthCapture);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CameraDeviceFormat)) {
            return false;
        }
        CameraDeviceFormat cameraDeviceFormat = (CameraDeviceFormat) other;
        return this.videoWidth == cameraDeviceFormat.videoWidth && this.videoHeight == cameraDeviceFormat.videoHeight && this.photoWidth == cameraDeviceFormat.photoWidth && this.photoHeight == cameraDeviceFormat.photoHeight && Double.compare(this.minFps, cameraDeviceFormat.minFps) == 0 && Double.compare(this.maxFps, cameraDeviceFormat.maxFps) == 0 && Double.compare(this.minISO, cameraDeviceFormat.minISO) == 0 && Double.compare(this.maxISO, cameraDeviceFormat.maxISO) == 0 && Double.compare(this.fieldOfView, cameraDeviceFormat.fieldOfView) == 0 && Intrinsics.areEqual(this.videoStabilizationModes, cameraDeviceFormat.videoStabilizationModes) && this.autoFocusSystem == cameraDeviceFormat.autoFocusSystem && this.supportsVideoHdr == cameraDeviceFormat.supportsVideoHdr && this.supportsPhotoHdr == cameraDeviceFormat.supportsPhotoHdr && this.supportsDepthCapture == cameraDeviceFormat.supportsDepthCapture;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((Integer.hashCode(this.videoWidth) * 31) + Integer.hashCode(this.videoHeight)) * 31) + Integer.hashCode(this.photoWidth)) * 31) + Integer.hashCode(this.photoHeight)) * 31) + Double.hashCode(this.minFps)) * 31) + Double.hashCode(this.maxFps)) * 31) + Double.hashCode(this.minISO)) * 31) + Double.hashCode(this.maxISO)) * 31) + Double.hashCode(this.fieldOfView)) * 31) + this.videoStabilizationModes.hashCode()) * 31) + this.autoFocusSystem.hashCode()) * 31) + Boolean.hashCode(this.supportsVideoHdr)) * 31) + Boolean.hashCode(this.supportsPhotoHdr)) * 31) + Boolean.hashCode(this.supportsDepthCapture);
    }

    @NotNull
    public String toString() {
        return "CameraDeviceFormat(videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", photoWidth=" + this.photoWidth + ", photoHeight=" + this.photoHeight + ", minFps=" + this.minFps + ", maxFps=" + this.maxFps + ", minISO=" + this.minISO + ", maxISO=" + this.maxISO + ", fieldOfView=" + this.fieldOfView + ", videoStabilizationModes=" + this.videoStabilizationModes + ", autoFocusSystem=" + this.autoFocusSystem + ", supportsVideoHdr=" + this.supportsVideoHdr + ", supportsPhotoHdr=" + this.supportsPhotoHdr + ", supportsDepthCapture=" + this.supportsDepthCapture + ")";
    }

    public CameraDeviceFormat(int i, int i2, int i3, int i4, double d, double d2, double d3, double d4, double d5, @NotNull List<? extends VideoStabilizationMode> videoStabilizationModes, @NotNull AutoFocusSystem autoFocusSystem, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(videoStabilizationModes, "videoStabilizationModes");
        Intrinsics.checkNotNullParameter(autoFocusSystem, "autoFocusSystem");
        this.videoWidth = i;
        this.videoHeight = i2;
        this.photoWidth = i3;
        this.photoHeight = i4;
        this.minFps = d;
        this.maxFps = d2;
        this.minISO = d3;
        this.maxISO = d4;
        this.fieldOfView = d5;
        this.videoStabilizationModes = videoStabilizationModes;
        this.autoFocusSystem = autoFocusSystem;
        this.supportsVideoHdr = z;
        this.supportsPhotoHdr = z2;
        this.supportsDepthCapture = z3;
        this.qualitySizes = MapsKt.mapOf(TuplesKt.to(Quality.SD, 345600), TuplesKt.to(Quality.HD, 921600), TuplesKt.to(Quality.FHD, 2073600), TuplesKt.to(Quality.UHD, 8294400));
    }

    public final int getVideoWidth() {
        return this.videoWidth;
    }

    public final int getVideoHeight() {
        return this.videoHeight;
    }

    public final int getPhotoWidth() {
        return this.photoWidth;
    }

    public final int getPhotoHeight() {
        return this.photoHeight;
    }

    public final double getMinFps() {
        return this.minFps;
    }

    public final double getMaxFps() {
        return this.maxFps;
    }

    public final double getMinISO() {
        return this.minISO;
    }

    public final double getMaxISO() {
        return this.maxISO;
    }

    public final double getFieldOfView() {
        return this.fieldOfView;
    }

    @NotNull
    public final List<VideoStabilizationMode> getVideoStabilizationModes() {
        return this.videoStabilizationModes;
    }

    @NotNull
    public final AutoFocusSystem getAutoFocusSystem() {
        return this.autoFocusSystem;
    }

    public final boolean getSupportsVideoHdr() {
        return this.supportsVideoHdr;
    }

    public final boolean getSupportsPhotoHdr() {
        return this.supportsPhotoHdr;
    }

    public final boolean getSupportsDepthCapture() {
        return this.supportsDepthCapture;
    }

    @NotNull
    public final Size getPhotoSize() {
        return new Size(this.photoWidth, this.photoHeight);
    }

    @NotNull
    public final Size getVideoSize() {
        return new Size(this.videoWidth, this.videoHeight);
    }

    private final QualitySelector getQualitySelector(Size size) {
        int width = size.getWidth() * size.getHeight();
        Iterator it = this.qualitySizes.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            int iAbs = Math.abs(width - ((Number) ((Map.Entry) next).getValue()).intValue());
            do {
                Object next2 = it.next();
                int iAbs2 = Math.abs(width - ((Number) ((Map.Entry) next2).getValue()).intValue());
                if (iAbs > iAbs2) {
                    next = next2;
                    iAbs = iAbs2;
                }
            } while (it.hasNext());
        }
        Quality quality = (Quality) ((Map.Entry) next).getKey();
        QualitySelector qualitySelectorFrom = QualitySelector.from(quality, FallbackStrategy.higherQualityOrLowerThan(quality));
        Intrinsics.checkNotNullExpressionValue(qualitySelectorFrom, "from(...)");
        return qualitySelectorFrom;
    }

    @NotNull
    public final QualitySelector getVideoQualitySelector() {
        return getQualitySelector(getVideoSize());
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/mrousavy/camera/core/types/CameraDeviceFormat$Companion;", "", "<init>", "()V", "fromJSValue", "Lcom/mrousavy/camera/core/types/CameraDeviceFormat;", "value", "Lcom/facebook/react/bridge/ReadableMap;", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nCameraDeviceFormat.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CameraDeviceFormat.kt\ncom/mrousavy/camera/core/types/CameraDeviceFormat$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,75:1\n1557#2:76\n1628#2,3:77\n*S KotlinDebug\n*F\n+ 1 CameraDeviceFormat.kt\ncom/mrousavy/camera/core/types/CameraDeviceFormat$Companion\n*L\n52#1:76\n52#1:77,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CameraDeviceFormat fromJSValue(@NotNull ReadableMap value) throws InvalidTypeScriptUnionError {
            Intrinsics.checkNotNullParameter(value, "value");
            ReadableArray array = value.getArray("videoStabilizationModes");
            if (array == null) {
                throw new InvalidTypeScriptUnionError("format", value.toString());
            }
            ArrayList<Object> arrayList = array.toArrayList();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            for (Object obj : arrayList) {
                VideoStabilizationMode.Companion companion = VideoStabilizationMode.INSTANCE;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                arrayList2.add(companion.fromUnionValue((String) obj));
            }
            return new CameraDeviceFormat(value.getInt("videoWidth"), value.getInt("videoHeight"), value.getInt("photoWidth"), value.getInt("photoHeight"), value.getDouble("minFps"), value.getDouble("maxFps"), value.getDouble("minISO"), value.getDouble("maxISO"), value.getDouble("fieldOfView"), arrayList2, AutoFocusSystem.INSTANCE.fromUnionValue(value.getString("autoFocusSystem")), value.getBoolean("supportsVideoHdr"), value.getBoolean("supportsPhotoHdr"), value.getBoolean("supportsDepthCapture"));
        }
    }
}
