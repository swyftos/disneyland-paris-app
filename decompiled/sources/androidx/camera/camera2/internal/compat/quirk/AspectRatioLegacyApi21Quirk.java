package androidx.camera.camera2.internal.compat.quirk;

import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.impl.Quirk;

/* loaded from: classes.dex */
public class AspectRatioLegacyApi21Quirk implements Quirk {
    public int getCorrectedAspectRatio() {
        return 2;
    }

    static boolean load(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        return false;
    }
}
