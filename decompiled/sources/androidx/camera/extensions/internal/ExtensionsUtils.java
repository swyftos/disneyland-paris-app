package androidx.camera.extensions.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraInfoInternal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public class ExtensionsUtils {
    @NonNull
    public static Map<String, CameraCharacteristics> getCameraCharacteristicsMap(@NonNull CameraInfoInternal cameraInfoInternal) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String cameraId = cameraInfoInternal.getCameraId();
        CameraCharacteristics cameraCharacteristics = (CameraCharacteristics) cameraInfoInternal.getCameraCharacteristics();
        linkedHashMap.put(cameraId, cameraCharacteristics);
        Set<String> physicalCameraIds = Api28Impl.getPhysicalCameraIds(cameraCharacteristics);
        if (physicalCameraIds == null) {
            return linkedHashMap;
        }
        for (String str : physicalCameraIds) {
            if (!Objects.equals(str, cameraId)) {
                linkedHashMap.put(str, (CameraCharacteristics) cameraInfoInternal.getPhysicalCameraCharacteristics(str));
            }
        }
        return linkedHashMap;
    }

    private static class Api28Impl {
        static Set getPhysicalCameraIds(CameraCharacteristics cameraCharacteristics) {
            try {
                return cameraCharacteristics.getPhysicalCameraIds();
            } catch (Exception unused) {
                return Collections.emptySet();
            }
        }
    }
}
