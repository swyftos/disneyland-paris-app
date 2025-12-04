package com.mrousavy.camera.core;

import android.annotation.SuppressLint;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Log;
import android.util.Range;
import android.util.Size;
import android.util.SizeF;
import androidx.camera.camera2.internal.Camera2CameraInfoImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.PreviewCapabilities;
import androidx.camera.core.SurfaceOrientedMeteringPointFactory;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.capability.PreviewCapabilitiesImpl;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.video.AudioStats;
import androidx.camera.video.Quality;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoCapabilities;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.mrousavy.camera.core.extensions.CameraInfo_idKt;
import com.mrousavy.camera.core.types.AutoFocusSystem;
import com.mrousavy.camera.core.types.DeviceType;
import com.mrousavy.camera.core.types.HardwareLevel;
import com.mrousavy.camera.core.types.Orientation;
import com.mrousavy.camera.core.types.Position;
import com.mrousavy.camera.core.types.VideoStabilizationMode;
import com.mrousavy.camera.core.utils.CamcorderProfileUtils;
import com.mrousavy.camera.react.extensions.List_toJSValueKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\b\u0007\u0018\u0000 M2\u00020\u0001:\u0001MB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u00105\u001a\u000206J\b\u00107\u001a\u000208H\u0002J&\u00109\u001a\u0002062\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001301H\u0002J\b\u0010>\u001a\u00020\u000eH\u0002J\b\u0010?\u001a\u00020\u000eH\u0002J\b\u0010@\u001a\u00020/H\u0002J\u000e\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001301H\u0002J\b\u0010B\u001a\u000208H\u0002J\u000e\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DH\u0002J\u0018\u0010F\u001a\u00020/2\u0006\u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u00020IH\u0002J\u0018\u0010J\u001a\u00020/2\u0006\u0010K\u001a\u00020L2\u0006\u0010H\u001a\u00020IH\u0002J\b\u0010J\u001a\u00020/H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0018\u0010\u0016\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\t0\t0)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\u001301X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/mrousavy/camera/core/CameraDeviceDetails;", "", "cameraInfo", "Landroidx/camera/core/CameraInfo;", "extensionsManager", "Landroidx/camera/extensions/ExtensionsManager;", "<init>", "(Landroidx/camera/core/CameraInfo;Landroidx/camera/extensions/ExtensionsManager;)V", "cameraId", "", ViewProps.POSITION, "Lcom/mrousavy/camera/core/types/Position;", "name", "hasFlash", "", "minZoom", "", "maxZoom", "minExposure", "", "kotlin.jvm.PlatformType", "Ljava/lang/Integer;", "maxExposure", "supportsFocus", "supportsRawCapture", "supportsDepthCapture", "autoFocusSystem", "Lcom/mrousavy/camera/core/types/AutoFocusSystem;", "previewCapabilities", "Landroidx/camera/core/PreviewCapabilities;", "videoCapabilities", "Landroidx/camera/video/VideoCapabilities;", "supports10BitHdr", "sensorRotationDegrees", "sensorOrientation", "Lcom/mrousavy/camera/core/types/Orientation;", "cameraInfoInternal", "Landroidx/camera/core/impl/CameraInfoInternal;", "camera2Details", "Landroidx/camera/camera2/internal/Camera2CameraInfoImpl;", "physicalDeviceIds", "", "isMultiCam", "cameraHardwareLevel", "hardwareLevel", "Lcom/mrousavy/camera/core/types/HardwareLevel;", "minFocusDistance", "", "isoRange", "Landroid/util/Range;", "maxFieldOfView", "supportsHdrExtension", "supportsLowLightBoostExtension", "toMap", "Lcom/facebook/react/bridge/ReadableMap;", "getFormats", "Lcom/facebook/react/bridge/ReadableArray;", "buildFormatMap", "photoSize", "Landroid/util/Size;", "videoSize", "fpsRange", "getSupports10BitHDR", "getSupportsFocus", "getMinFocusDistanceCm", "getIsoRange", "createStabilizationModes", "getDeviceTypes", "", "Lcom/mrousavy/camera/core/types/DeviceType;", "getFieldOfView", "focalLength", "sensorSize", "Landroid/util/SizeF;", "getMaxFieldOfView", "focalLengths", "", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SuppressLint({"RestrictedApi"})
@SourceDebugExtension({"SMAP\nCameraDeviceDetails.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CameraDeviceDetails.kt\ncom/mrousavy/camera/core/CameraDeviceDetails\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,272:1\n1863#2:273\n1557#2:274\n1628#2,3:275\n1368#2:278\n1454#2,5:279\n1863#2:285\n1863#2,2:286\n1864#2:288\n1864#2:289\n1755#2,3:290\n1863#2,2:293\n1#3:284\n126#4:295\n153#4,3:296\n*S KotlinDebug\n*F\n+ 1 CameraDeviceDetails.kt\ncom/mrousavy/camera/core/CameraDeviceDetails\n*L\n120#1:273\n123#1:274\n123#1:275,3\n123#1:278\n123#1:279,5\n132#1:285\n140#1:286,2\n132#1:288\n120#1:289\n180#1:290,3\n225#1:293,2\n235#1:295\n235#1:296,3\n*E\n"})
/* loaded from: classes4.dex */
public final class CameraDeviceDetails {
    private final AutoFocusSystem autoFocusSystem;
    private final Camera2CameraInfoImpl camera2Details;
    private final Integer cameraHardwareLevel;
    private final String cameraId;
    private final CameraInfo cameraInfo;
    private final CameraInfoInternal cameraInfoInternal;
    private final HardwareLevel hardwareLevel;
    private final boolean hasFlash;
    private final boolean isMultiCam;
    private final Range isoRange;
    private final Integer maxExposure;
    private final double maxFieldOfView;
    private final float maxZoom;
    private final Integer minExposure;
    private final double minFocusDistance;
    private final float minZoom;
    private final String name;
    private final Set physicalDeviceIds;
    private final Position position;
    private final PreviewCapabilities previewCapabilities;
    private final Orientation sensorOrientation;
    private final int sensorRotationDegrees;
    private final boolean supports10BitHdr;
    private final boolean supportsDepthCapture;
    private final boolean supportsFocus;
    private final boolean supportsHdrExtension;
    private final boolean supportsLowLightBoostExtension;
    private final boolean supportsRawCapture;
    private final VideoCapabilities videoCapabilities;

    public CameraDeviceDetails(@NotNull CameraInfo cameraInfo, @NotNull ExtensionsManager extensionsManager) throws NoCameraDeviceError {
        CameraCharacteristicsCompat cameraCharacteristicsCompat;
        Map<String, CameraCharacteristics> cameraCharacteristicsMap;
        Intrinsics.checkNotNullParameter(cameraInfo, "cameraInfo");
        Intrinsics.checkNotNullParameter(extensionsManager, "extensionsManager");
        this.cameraInfo = cameraInfo;
        String id = CameraInfo_idKt.getId(cameraInfo);
        if (id == null) {
            throw new NoCameraDeviceError();
        }
        this.cameraId = id;
        Position positionFromLensFacing = Position.INSTANCE.fromLensFacing(cameraInfo.getLensFacing());
        this.position = positionFromLensFacing;
        this.name = id + " (" + positionFromLensFacing + ") " + cameraInfo.getImplementationType();
        this.hasFlash = cameraInfo.hasFlashUnit();
        ZoomState value = cameraInfo.getZoomState().getValue();
        this.minZoom = value != null ? value.getMinZoomRatio() : BitmapDescriptorFactory.HUE_RED;
        ZoomState value2 = cameraInfo.getZoomState().getValue();
        this.maxZoom = value2 != null ? value2.getMaxZoomRatio() : 1.0f;
        this.minExposure = (Integer) cameraInfo.getExposureState().getExposureCompensationRange().getLower();
        this.maxExposure = (Integer) cameraInfo.getExposureState().getExposureCompensationRange().getUpper();
        boolean supportsFocus = getSupportsFocus();
        this.supportsFocus = supportsFocus;
        this.autoFocusSystem = supportsFocus ? AutoFocusSystem.CONTRAST_DETECTION : AutoFocusSystem.NONE;
        PreviewCapabilities previewCapabilitiesFrom = PreviewCapabilitiesImpl.from(cameraInfo);
        Intrinsics.checkNotNullExpressionValue(previewCapabilitiesFrom, "from(...)");
        this.previewCapabilities = previewCapabilitiesFrom;
        VideoCapabilities videoCapabilities = Recorder.getVideoCapabilities(cameraInfo, 0);
        Intrinsics.checkNotNullExpressionValue(videoCapabilities, "getVideoCapabilities(...)");
        this.videoCapabilities = videoCapabilities;
        this.supports10BitHdr = getSupports10BitHDR();
        int sensorRotationDegrees = cameraInfo.getSensorRotationDegrees();
        this.sensorRotationDegrees = sensorRotationDegrees;
        this.sensorOrientation = Orientation.INSTANCE.fromRotationDegrees(sensorRotationDegrees);
        Intrinsics.checkNotNull(cameraInfo, "null cannot be cast to non-null type androidx.camera.core.impl.CameraInfoInternal");
        this.cameraInfoInternal = (CameraInfoInternal) cameraInfo;
        Integer num = null;
        Camera2CameraInfoImpl camera2CameraInfoImpl = cameraInfo instanceof Camera2CameraInfoImpl ? (Camera2CameraInfoImpl) cameraInfo : null;
        this.camera2Details = camera2CameraInfoImpl;
        Set<String> setEmptySet = (camera2CameraInfoImpl == null || (cameraCharacteristicsMap = camera2CameraInfoImpl.getCameraCharacteristicsMap()) == null || (setEmptySet = cameraCharacteristicsMap.keySet()) == null) ? SetsKt.emptySet() : setEmptySet;
        this.physicalDeviceIds = setEmptySet;
        this.isMultiCam = setEmptySet.size() > 1;
        if (camera2CameraInfoImpl != null && (cameraCharacteristicsCompat = camera2CameraInfoImpl.getCameraCharacteristicsCompat()) != null) {
            num = (Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        }
        this.cameraHardwareLevel = num;
        this.hardwareLevel = HardwareLevel.INSTANCE.fromCameraHardwareLevel(num != null ? num.intValue() : 2);
        this.minFocusDistance = getMinFocusDistanceCm();
        this.isoRange = getIsoRange();
        this.maxFieldOfView = getMaxFieldOfView();
        this.supportsHdrExtension = extensionsManager.isExtensionAvailable(cameraInfo.getCameraSelector(), 2);
        this.supportsLowLightBoostExtension = extensionsManager.isExtensionAvailable(cameraInfo.getCameraSelector(), 3);
    }

    @NotNull
    public final ReadableMap toMap() {
        List deviceTypes = getDeviceTypes();
        ReadableArray formats = getFormats();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("id", this.cameraId);
        writableMapCreateMap.putArray("physicalDevices", List_toJSValueKt.toJSValue(deviceTypes));
        writableMapCreateMap.putString(ViewProps.POSITION, this.position.getUnionValue());
        writableMapCreateMap.putString("name", this.name);
        writableMapCreateMap.putBoolean("hasFlash", this.hasFlash);
        writableMapCreateMap.putBoolean("hasTorch", this.hasFlash);
        writableMapCreateMap.putDouble("minFocusDistance", this.minFocusDistance);
        writableMapCreateMap.putBoolean("isMultiCam", this.isMultiCam);
        writableMapCreateMap.putBoolean("supportsRawCapture", this.supportsRawCapture);
        writableMapCreateMap.putBoolean("supportsLowLightBoost", this.supportsLowLightBoostExtension);
        writableMapCreateMap.putBoolean("supportsFocus", this.supportsFocus);
        writableMapCreateMap.putDouble("minZoom", this.minZoom);
        writableMapCreateMap.putDouble("maxZoom", this.maxZoom);
        writableMapCreateMap.putDouble("neutralZoom", 1.0d);
        Integer minExposure = this.minExposure;
        Intrinsics.checkNotNullExpressionValue(minExposure, "minExposure");
        writableMapCreateMap.putInt("minExposure", minExposure.intValue());
        Integer maxExposure = this.maxExposure;
        Intrinsics.checkNotNullExpressionValue(maxExposure, "maxExposure");
        writableMapCreateMap.putInt("maxExposure", maxExposure.intValue());
        writableMapCreateMap.putString("hardwareLevel", this.hardwareLevel.getUnionValue());
        writableMapCreateMap.putString("sensorOrientation", this.sensorOrientation.getUnionValue());
        writableMapCreateMap.putArray("formats", formats);
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }

    private final ReadableArray getFormats() {
        Iterator it;
        ArrayList<Size> arrayList;
        List<Size> list;
        Set<Range<Integer>> supportedFrameRateRanges;
        Iterator<T> it2;
        List list2;
        StringBuilder sb;
        CameraDeviceDetails cameraDeviceDetails = this;
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Set<DynamicRange> supportedDynamicRanges = cameraDeviceDetails.videoCapabilities.getSupportedDynamicRanges();
        Intrinsics.checkNotNullExpressionValue(supportedDynamicRanges, "getSupportedDynamicRanges(...)");
        Iterator it3 = supportedDynamicRanges.iterator();
        while (it3.hasNext()) {
            DynamicRange dynamicRange = (DynamicRange) it3.next();
            try {
                List<Quality> supportedQualities = cameraDeviceDetails.videoCapabilities.getSupportedQualities(dynamicRange);
                Intrinsics.checkNotNullExpressionValue(supportedQualities, "getSupportedQualities(...)");
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(supportedQualities, 10));
                for (Quality quality : supportedQualities) {
                    Intrinsics.checkNotNull(quality, "null cannot be cast to non-null type androidx.camera.video.Quality.ConstantQuality");
                    arrayList2.add((Quality.ConstantQuality) quality);
                }
                arrayList = new ArrayList();
                Iterator it4 = arrayList2.iterator();
                while (it4.hasNext()) {
                    List<Size> typicalSizes = ((Quality.ConstantQuality) it4.next()).getTypicalSizes();
                    Intrinsics.checkNotNullExpressionValue(typicalSizes, "getTypicalSizes(...)");
                    CollectionsKt.addAll(arrayList, typicalSizes);
                }
                List<Size> supportedHighResolutions = cameraDeviceDetails.cameraInfoInternal.getSupportedHighResolutions(256);
                Intrinsics.checkNotNullExpressionValue(supportedHighResolutions, "getSupportedHighResolutions(...)");
                List<Size> supportedResolutions = cameraDeviceDetails.cameraInfoInternal.getSupportedResolutions(256);
                Intrinsics.checkNotNullExpressionValue(supportedResolutions, "getSupportedResolutions(...)");
                list = CollectionsKt.toList(CollectionsKt.union(supportedHighResolutions, supportedResolutions));
                supportedFrameRateRanges = cameraDeviceDetails.cameraInfo.getSupportedFrameRateRanges();
                Intrinsics.checkNotNullExpressionValue(supportedFrameRateRanges, "getSupportedFrameRateRanges(...)");
                it2 = supportedFrameRateRanges.iterator();
            } catch (Throwable th) {
                th = th;
                it = it3;
            }
            if (!it2.hasNext()) {
                throw new NoSuchElementException();
            }
            Integer num = (Integer) ((Range) it2.next()).getLower();
            while (it2.hasNext()) {
                Integer num2 = (Integer) ((Range) it2.next()).getLower();
                if (num.compareTo(num2) > 0) {
                    num = num2;
                }
            }
            Iterator<T> it5 = supportedFrameRateRanges.iterator();
            if (!it5.hasNext()) {
                throw new NoSuchElementException();
            }
            Integer num3 = (Integer) ((Range) it5.next()).getUpper();
            while (it5.hasNext()) {
                Integer num4 = (Integer) ((Range) it5.next()).getUpper();
                if (num3.compareTo(num4) < 0) {
                    num3 = num4;
                }
            }
            for (Size size : arrayList) {
                try {
                    CamcorderProfileUtils.Companion companion = CamcorderProfileUtils.INSTANCE;
                    String str = cameraDeviceDetails.cameraId;
                    Intrinsics.checkNotNull(size);
                    Integer maximumFps = companion.getMaximumFps(str, size);
                    if (maximumFps == null) {
                        maximumFps = num3;
                    }
                    Intrinsics.checkNotNull(num);
                    int iIntValue = num.intValue();
                    Intrinsics.checkNotNull(maximumFps);
                    Range range = new Range(Integer.valueOf(Math.min(iIntValue, maximumFps.intValue())), maximumFps);
                    for (Size size2 : list) {
                        try {
                            Intrinsics.checkNotNull(size2);
                            writableArrayCreateArray.pushMap(cameraDeviceDetails.buildFormatMap(size2, size, range));
                            it = it3;
                            list2 = list;
                        } catch (Throwable th2) {
                            int width = size2.getWidth();
                            int height = size2.getHeight();
                            it = it3;
                            try {
                                sb = new StringBuilder();
                                list2 = list;
                            } catch (Throwable th3) {
                                th = th3;
                                list2 = list;
                                try {
                                    Log.w("CameraDeviceDetails", "Video size " + size.getWidth() + "x" + size.getHeight() + " cannot be used as a format!", th);
                                    cameraDeviceDetails = this;
                                    it3 = it;
                                    list = list2;
                                } catch (Throwable th4) {
                                    th = th4;
                                    Log.w("CameraDeviceDetails", "Dynamic Range Profile " + dynamicRange + " cannot be used as a format!", th);
                                    cameraDeviceDetails = this;
                                    it3 = it;
                                }
                            }
                            try {
                                sb.append("Photo size ");
                                sb.append(width);
                                sb.append("x");
                                sb.append(height);
                                sb.append(" cannot be used as a format!");
                                Log.w("CameraDeviceDetails", sb.toString(), th2);
                            } catch (Throwable th5) {
                                th = th5;
                                Log.w("CameraDeviceDetails", "Video size " + size.getWidth() + "x" + size.getHeight() + " cannot be used as a format!", th);
                                cameraDeviceDetails = this;
                                it3 = it;
                                list = list2;
                            }
                        }
                        cameraDeviceDetails = this;
                        it3 = it;
                        list = list2;
                    }
                    it = it3;
                    list2 = list;
                } catch (Throwable th6) {
                    th = th6;
                    it = it3;
                    list2 = list;
                    Log.w("CameraDeviceDetails", "Video size " + size.getWidth() + "x" + size.getHeight() + " cannot be used as a format!", th);
                    cameraDeviceDetails = this;
                    it3 = it;
                    list = list2;
                }
                cameraDeviceDetails = this;
                it3 = it;
                list = list2;
            }
            it = it3;
            cameraDeviceDetails = this;
            it3 = it;
        }
        Intrinsics.checkNotNull(writableArrayCreateArray);
        return writableArrayCreateArray;
    }

    private final ReadableMap buildFormatMap(Size photoSize, Size videoSize, Range fpsRange) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("photoHeight", photoSize.getHeight());
        writableMapCreateMap.putInt("photoWidth", photoSize.getWidth());
        writableMapCreateMap.putInt("videoHeight", videoSize.getHeight());
        writableMapCreateMap.putInt("videoWidth", videoSize.getWidth());
        Object lower = fpsRange.getLower();
        Intrinsics.checkNotNullExpressionValue(lower, "getLower(...)");
        writableMapCreateMap.putInt("minFps", ((Number) lower).intValue());
        Object upper = fpsRange.getUpper();
        Intrinsics.checkNotNullExpressionValue(upper, "getUpper(...)");
        writableMapCreateMap.putInt("maxFps", ((Number) upper).intValue());
        Object lower2 = this.isoRange.getLower();
        Intrinsics.checkNotNullExpressionValue(lower2, "getLower(...)");
        writableMapCreateMap.putInt("minISO", ((Number) lower2).intValue());
        Object upper2 = this.isoRange.getUpper();
        Intrinsics.checkNotNullExpressionValue(upper2, "getUpper(...)");
        writableMapCreateMap.putInt("maxISO", ((Number) upper2).intValue());
        writableMapCreateMap.putDouble("fieldOfView", this.maxFieldOfView);
        writableMapCreateMap.putBoolean("supportsVideoHdr", this.supports10BitHdr);
        writableMapCreateMap.putBoolean("supportsPhotoHdr", this.supportsHdrExtension);
        writableMapCreateMap.putBoolean("supportsDepthCapture", this.supportsDepthCapture);
        writableMapCreateMap.putString("autoFocusSystem", this.autoFocusSystem.getUnionValue());
        writableMapCreateMap.putArray("videoStabilizationModes", createStabilizationModes());
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }

    private final boolean getSupports10BitHDR() {
        Set<DynamicRange> supportedDynamicRanges = this.videoCapabilities.getSupportedDynamicRanges();
        Intrinsics.checkNotNullExpressionValue(supportedDynamicRanges, "getSupportedDynamicRanges(...)");
        if (supportedDynamicRanges != null && supportedDynamicRanges.isEmpty()) {
            return false;
        }
        for (DynamicRange dynamicRange : supportedDynamicRanges) {
            if (dynamicRange.is10BitHdr() || Intrinsics.areEqual(dynamicRange, DynamicRange.HDR_UNSPECIFIED_10_BIT)) {
                return true;
            }
        }
        return false;
    }

    private final boolean getSupportsFocus() {
        MeteringPoint meteringPointCreatePoint = new SurfaceOrientedMeteringPointFactory(1.0f, 1.0f).createPoint(0.5f, 0.5f);
        Intrinsics.checkNotNullExpressionValue(meteringPointCreatePoint, "createPoint(...)");
        return this.cameraInfo.isFocusMeteringSupported(new FocusMeteringAction.Builder(meteringPointCreatePoint).build());
    }

    private final double getMinFocusDistanceCm() {
        Float f;
        CameraInfo cameraInfo = this.cameraInfo;
        Camera2CameraInfoImpl camera2CameraInfoImpl = cameraInfo instanceof Camera2CameraInfoImpl ? (Camera2CameraInfoImpl) cameraInfo : null;
        return (camera2CameraInfoImpl == null || (f = (Float) camera2CameraInfoImpl.getCameraCharacteristicsCompat().get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE)) == null || Intrinsics.areEqual(f, BitmapDescriptorFactory.HUE_RED) || Float.isNaN(f.floatValue()) || Float.isInfinite(f.floatValue())) ? AudioStats.AUDIO_AMPLITUDE_NONE : (1.0d / f.floatValue()) * 100.0d;
    }

    private final Range getIsoRange() {
        CameraInfo cameraInfo = this.cameraInfo;
        Camera2CameraInfoImpl camera2CameraInfoImpl = cameraInfo instanceof Camera2CameraInfoImpl ? (Camera2CameraInfoImpl) cameraInfo : null;
        if (camera2CameraInfoImpl == null) {
            return new Range(0, 0);
        }
        Range range = (Range) camera2CameraInfoImpl.getCameraCharacteristicsCompat().get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE);
        return range == null ? new Range(0, 0) : range;
    }

    private final ReadableArray createStabilizationModes() {
        Set setMutableSetOf = SetsKt.mutableSetOf(VideoStabilizationMode.OFF);
        if (this.videoCapabilities.isStabilizationSupported()) {
            setMutableSetOf.add(VideoStabilizationMode.CINEMATIC);
        }
        if (this.previewCapabilities.isStabilizationSupported()) {
            setMutableSetOf.add(VideoStabilizationMode.CINEMATIC_EXTENDED);
        }
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator it = setMutableSetOf.iterator();
        while (it.hasNext()) {
            writableArrayCreateArray.pushString(((VideoStabilizationMode) it.next()).getUnionValue());
        }
        Intrinsics.checkNotNull(writableArrayCreateArray);
        return writableArrayCreateArray;
    }

    private final List getDeviceTypes() {
        DeviceType deviceType;
        List listListOf = CollectionsKt.listOf(DeviceType.WIDE_ANGLE);
        Camera2CameraInfoImpl camera2CameraInfoImpl = this.camera2Details;
        if (camera2CameraInfoImpl == null) {
            return listListOf;
        }
        Map<String, CameraCharacteristics> cameraCharacteristicsMap = camera2CameraInfoImpl.getCameraCharacteristicsMap();
        Intrinsics.checkNotNullExpressionValue(cameraCharacteristicsMap, "getCameraCharacteristicsMap(...)");
        ArrayList arrayList = new ArrayList(cameraCharacteristicsMap.size());
        Iterator<Map.Entry<String, CameraCharacteristics>> it = cameraCharacteristicsMap.entrySet().iterator();
        while (it.hasNext()) {
            CameraCharacteristics value = it.next().getValue();
            SizeF sizeF = (SizeF) value.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
            if (sizeF == null) {
                deviceType = DeviceType.WIDE_ANGLE;
            } else {
                float[] fArr = (float[]) value.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
                if (fArr == null) {
                    deviceType = DeviceType.WIDE_ANGLE;
                } else {
                    double maxFieldOfView = getMaxFieldOfView(fArr, sizeF);
                    if (maxFieldOfView > 94.0d) {
                        deviceType = DeviceType.ULTRA_WIDE_ANGLE;
                    } else if (60.0d <= maxFieldOfView && maxFieldOfView <= 94.0d) {
                        deviceType = DeviceType.WIDE_ANGLE;
                    } else if (maxFieldOfView < 60.0d) {
                        deviceType = DeviceType.TELEPHOTO;
                    } else {
                        throw new Error("Invalid Field Of View! (" + maxFieldOfView + ")");
                    }
                }
            }
            arrayList.add(deviceType);
        }
        return arrayList;
    }

    private final double getFieldOfView(float focalLength, SizeF sensorSize) {
        return (sensorSize.getWidth() == BitmapDescriptorFactory.HUE_RED || sensorSize.getHeight() == BitmapDescriptorFactory.HUE_RED) ? AudioStats.AUDIO_AMPLITUDE_NONE : Math.toDegrees(Math.atan2(Math.sqrt((sensorSize.getWidth() * sensorSize.getWidth()) + (sensorSize.getHeight() * sensorSize.getHeight())), focalLength * 2.0d) * 2.0d);
    }

    private final double getMaxFieldOfView(float[] focalLengths, SizeF sensorSize) {
        Float fMinOrNull = ArraysKt.minOrNull(focalLengths);
        return fMinOrNull != null ? getFieldOfView(fMinOrNull.floatValue(), sensorSize) : AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    private final double getMaxFieldOfView() {
        CameraCharacteristicsCompat cameraCharacteristicsCompat;
        SizeF sizeF;
        float[] fArr;
        Camera2CameraInfoImpl camera2CameraInfoImpl = this.camera2Details;
        return (camera2CameraInfoImpl == null || (cameraCharacteristicsCompat = camera2CameraInfoImpl.getCameraCharacteristicsCompat()) == null || (sizeF = (SizeF) cameraCharacteristicsCompat.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE)) == null || (fArr = (float[]) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS)) == null) ? AudioStats.AUDIO_AMPLITUDE_NONE : getMaxFieldOfView(fArr, sizeF);
    }
}
