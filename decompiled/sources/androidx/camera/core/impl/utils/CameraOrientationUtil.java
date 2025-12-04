package androidx.camera.core.impl.utils;

import androidx.camera.core.Logger;
import com.contentsquare.android.api.Currencies;
import com.facebook.imagepipeline.common.RotationOptions;

/* loaded from: classes.dex */
public final class CameraOrientationUtil {
    public static int getRelativeImageRotation(int i, int i2, boolean z) {
        int i3;
        if (z) {
            i3 = ((i2 - i) + Currencies.IDR) % Currencies.IDR;
        } else {
            i3 = (i2 + i) % Currencies.IDR;
        }
        if (Logger.isVerboseEnabled("CameraOrientationUtil")) {
            Logger.d("CameraOrientationUtil", String.format("getRelativeImageRotation: destRotationDegrees=%s, sourceRotationDegrees=%s, isOppositeFacing=%s, result=%s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)));
        }
        return i3;
    }

    public static int surfaceRotationToDegrees(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 90;
        }
        if (i == 2) {
            return RotationOptions.ROTATE_180;
        }
        if (i == 3) {
            return 270;
        }
        throw new IllegalArgumentException("Unsupported surface rotation: " + i);
    }

    public static int degreesToSurfaceRotation(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 90) {
            return 1;
        }
        if (i == 180) {
            return 2;
        }
        if (i == 270) {
            return 3;
        }
        throw new IllegalStateException("Invalid sensor rotation: " + i);
    }
}
