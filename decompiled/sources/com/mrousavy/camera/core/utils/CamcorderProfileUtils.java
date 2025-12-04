package com.mrousavy.camera.core.utils;

import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/mrousavy/camera/core/utils/CamcorderProfileUtils;", "", "<init>", "()V", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CamcorderProfileUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0002\u0010\u0012J\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\f¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/mrousavy/camera/core/utils/CamcorderProfileUtils$Companion;", "", "<init>", "()V", "TAG", "", "getResolutionForCamcorderProfileQuality", "", "camcorderProfile", "findClosestCamcorderProfileQuality", "cameraId", "resolution", "Landroid/util/Size;", "allowLargerSize", "", "getMaximumVideoSize", "getMaximumFps", TCEventPropertiesNames.TCP_SIZE, "(Ljava/lang/String;Landroid/util/Size;)Ljava/lang/Integer;", "getRecommendedBitRate", "videoSize", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nCamcorderProfileUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CamcorderProfileUtils.kt\ncom/mrousavy/camera/core/utils/CamcorderProfileUtils$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n774#2:135\n865#2,2:136\n774#2:138\n865#2,2:139\n2318#2,14:141\n1971#2,14:155\n1#3:169\n*S KotlinDebug\n*F\n+ 1 CamcorderProfileUtils.kt\ncom/mrousavy/camera/core/utils/CamcorderProfileUtils$Companion\n*L\n37#1:135\n37#1:136,2\n45#1:138\n45#1:139,2\n50#1:141,14\n62#1:155,14\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final int getResolutionForCamcorderProfileQuality(int camcorderProfile) {
            switch (camcorderProfile) {
                case 2:
                    return 25344;
                case 3:
                    return 101376;
                case 4:
                    return 345600;
                case 5:
                    return 921600;
                case 6:
                    return 2073600;
                case 7:
                    return 76800;
                case 8:
                    return 8294400;
                case 9:
                    return 307200;
                case 10:
                    return 8847360;
                case 11:
                    return 3686400;
                case 12:
                    return 2211840;
                case 13:
                    return 33177600;
                default:
                    throw new Error("Invalid CamcorderProfile \"" + camcorderProfile + "\"!");
            }
        }

        private final int findClosestCamcorderProfileQuality(String cameraId, Size resolution, boolean allowLargerSize) {
            int width = resolution.getWidth() * resolution.getHeight();
            Integer intOrNull = StringsKt.toIntOrNull(cameraId);
            IntRange intRange = new IntRange(2, 13);
            ArrayList arrayList = new ArrayList();
            for (Integer num : intRange) {
                int iIntValue = num.intValue();
                if (intOrNull != null ? CamcorderProfile.hasProfile(intOrNull.intValue(), iIntValue) : CamcorderProfile.hasProfile(iIntValue)) {
                    arrayList.add(num);
                }
            }
            if (!allowLargerSize) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    if (CamcorderProfileUtils.INSTANCE.getResolutionForCamcorderProfileQuality(((Number) obj).intValue()) <= width) {
                        arrayList2.add(obj);
                    }
                }
                arrayList = arrayList2;
            }
            Iterator it = arrayList.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Object next = it.next();
            if (it.hasNext()) {
                int iAbs = Math.abs(CamcorderProfileUtils.INSTANCE.getResolutionForCamcorderProfileQuality(((Number) next).intValue()) - width);
                do {
                    Object next2 = it.next();
                    int iAbs2 = Math.abs(CamcorderProfileUtils.INSTANCE.getResolutionForCamcorderProfileQuality(((Number) next2).intValue()) - width);
                    if (iAbs > iAbs2) {
                        next = next2;
                        iAbs = iAbs2;
                    }
                } while (it.hasNext());
            }
            return ((Number) next).intValue();
        }

        @Nullable
        public final Size getMaximumVideoSize(@NotNull String cameraId) {
            EncoderProfiles all;
            Object next;
            Intrinsics.checkNotNullParameter(cameraId, "cameraId");
            try {
                if (Build.VERSION.SDK_INT >= 31 && (all = CamcorderProfile.getAll(cameraId, 1)) != null) {
                    List videoProfiles = all.getVideoProfiles();
                    Intrinsics.checkNotNullExpressionValue(videoProfiles, "getVideoProfiles(...)");
                    Iterator it = CollectionsKt.filterNotNull(videoProfiles).iterator();
                    if (it.hasNext()) {
                        next = it.next();
                        if (it.hasNext()) {
                            EncoderProfiles.VideoProfile videoProfileM = CamcorderProfileUtils$Companion$$ExternalSyntheticApiModelOutline2.m(next);
                            int width = videoProfileM.getWidth() * videoProfileM.getHeight();
                            do {
                                Object next2 = it.next();
                                EncoderProfiles.VideoProfile videoProfileM2 = CamcorderProfileUtils$Companion$$ExternalSyntheticApiModelOutline2.m(next2);
                                int width2 = videoProfileM2.getWidth() * videoProfileM2.getHeight();
                                if (width < width2) {
                                    next = next2;
                                    width = width2;
                                }
                            } while (it.hasNext());
                        }
                    } else {
                        next = null;
                    }
                    EncoderProfiles.VideoProfile videoProfileM3 = CamcorderProfileUtils$Companion$$ExternalSyntheticApiModelOutline2.m(next);
                    if (videoProfileM3 != null) {
                        return new Size(videoProfileM3.getWidth(), videoProfileM3.getHeight());
                    }
                }
                Integer intOrNull = StringsKt.toIntOrNull(cameraId);
                if (intOrNull == null) {
                    return null;
                }
                CamcorderProfile camcorderProfile = CamcorderProfile.get(intOrNull.intValue(), 1);
                return new Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
            } catch (Throwable th) {
                Log.e("CamcorderProfileUtils", "Failed to get maximum video size for Camera ID " + cameraId + "! " + th.getMessage(), th);
                return null;
            }
        }

        @Nullable
        public final Integer getMaximumFps(@NotNull String cameraId, @NotNull Size size) {
            EncoderProfiles all;
            Intrinsics.checkNotNullParameter(cameraId, "cameraId");
            Intrinsics.checkNotNullParameter(size, "size");
            try {
                int iFindClosestCamcorderProfileQuality = findClosestCamcorderProfileQuality(cameraId, size, false);
                if (Build.VERSION.SDK_INT >= 31 && (all = CamcorderProfile.getAll(cameraId, iFindClosestCamcorderProfileQuality)) != null) {
                    List videoProfiles = all.getVideoProfiles();
                    Intrinsics.checkNotNullExpressionValue(videoProfiles, "getVideoProfiles(...)");
                    Iterator it = videoProfiles.iterator();
                    if (!it.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Integer numValueOf = Integer.valueOf(CamcorderProfileUtils$Companion$$ExternalSyntheticApiModelOutline2.m(it.next()).getFrameRate());
                    while (it.hasNext()) {
                        Integer numValueOf2 = Integer.valueOf(CamcorderProfileUtils$Companion$$ExternalSyntheticApiModelOutline2.m(it.next()).getFrameRate());
                        if (numValueOf.compareTo(numValueOf2) < 0) {
                            numValueOf = numValueOf2;
                        }
                    }
                    return numValueOf;
                }
                Integer intOrNull = StringsKt.toIntOrNull(cameraId);
                if (intOrNull != null) {
                    return Integer.valueOf(CamcorderProfile.get(intOrNull.intValue(), iFindClosestCamcorderProfileQuality).videoFrameRate);
                }
                return null;
            } catch (Throwable th) {
                Log.e("CamcorderProfileUtils", "Failed to get maximum FPS for Camera ID " + cameraId + "! " + th.getMessage(), th);
                return null;
            }
        }

        @Nullable
        public final Integer getRecommendedBitRate(@NotNull String cameraId, @NotNull Size videoSize) {
            EncoderProfiles all;
            Intrinsics.checkNotNullParameter(cameraId, "cameraId");
            Intrinsics.checkNotNullParameter(videoSize, "videoSize");
            try {
                int iFindClosestCamcorderProfileQuality = findClosestCamcorderProfileQuality(cameraId, videoSize, true);
                if (Build.VERSION.SDK_INT >= 31 && (all = CamcorderProfile.getAll(cameraId, iFindClosestCamcorderProfileQuality)) != null) {
                    List videoProfiles = all.getVideoProfiles();
                    Intrinsics.checkNotNullExpressionValue(videoProfiles, "getVideoProfiles(...)");
                    Iterator it = videoProfiles.iterator();
                    if (!it.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Integer numValueOf = Integer.valueOf(CamcorderProfileUtils$Companion$$ExternalSyntheticApiModelOutline2.m(it.next()).getBitrate());
                    while (it.hasNext()) {
                        Integer numValueOf2 = Integer.valueOf(CamcorderProfileUtils$Companion$$ExternalSyntheticApiModelOutline2.m(it.next()).getBitrate());
                        if (numValueOf.compareTo(numValueOf2) < 0) {
                            numValueOf = numValueOf2;
                        }
                    }
                    return numValueOf;
                }
                Integer intOrNull = StringsKt.toIntOrNull(cameraId);
                if (intOrNull != null) {
                    return Integer.valueOf(CamcorderProfile.get(intOrNull.intValue(), iFindClosestCamcorderProfileQuality).videoBitRate);
                }
                return null;
            } catch (Throwable th) {
                Log.e("CamcorderProfileUtils", "Failed to get recommended video bit-rate for Camera ID " + cameraId + "! " + th.getMessage(), th);
                return null;
            }
        }
    }
}
