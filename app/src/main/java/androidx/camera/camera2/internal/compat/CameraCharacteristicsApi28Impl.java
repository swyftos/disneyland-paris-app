package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.core.Logger;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class CameraCharacteristicsApi28Impl extends CameraCharacteristicsBaseImpl {
    CameraCharacteristicsApi28Impl(CameraCharacteristics cameraCharacteristics) {
        super(cameraCharacteristics);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat.CameraCharacteristicsCompatImpl
    public Set getPhysicalCameraIds() {
        try {
            return this.mCameraCharacteristics.getPhysicalCameraIds();
        } catch (Exception e) {
            Logger.m31e("CameraCharacteristicsImpl", "CameraCharacteristics.getPhysicalCameraIds throws an exception.", e);
            return Collections.emptySet();
        }
    }
}
