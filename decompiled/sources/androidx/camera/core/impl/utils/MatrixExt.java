package androidx.camera.core.impl.utils;

import android.opengl.Matrix;
import androidx.annotation.NonNull;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Locale;

/* loaded from: classes.dex */
public final class MatrixExt {
    private static final float[] sTemp = new float[16];

    public static void setRotate(@NonNull float[] fArr, float f, float f2, float f3) {
        Matrix.setIdentityM(fArr, 0);
        preRotate(fArr, f, f2, f3);
    }

    public static void preRotate(@NonNull float[] fArr, float f, float f2, float f3) {
        normalize(fArr, f2, f3);
        Matrix.rotateM(fArr, 0, f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f);
        denormalize(fArr, f2, f3);
    }

    public static void postRotate(@NonNull float[] fArr, float f, float f2, float f3) {
        float[] fArr2 = sTemp;
        synchronized (fArr2) {
            Matrix.setIdentityM(fArr2, 0);
            normalize(fArr2, f2, f3);
            Matrix.rotateM(fArr2, 0, f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f);
            denormalize(fArr2, f2, f3);
            Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr, 0);
        }
    }

    public static void preVerticalFlip(@NonNull float[] fArr, float f) {
        normalize(fArr, BitmapDescriptorFactory.HUE_RED, f);
        Matrix.scaleM(fArr, 0, 1.0f, -1.0f, 1.0f);
        denormalize(fArr, BitmapDescriptorFactory.HUE_RED, f);
    }

    @NonNull
    public static String toString(@NonNull float[] fArr, int i) {
        return String.format(Locale.US, "Matrix:\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f", Float.valueOf(fArr[i]), Float.valueOf(fArr[i + 4]), Float.valueOf(fArr[i + 8]), Float.valueOf(fArr[i + 12]), Float.valueOf(fArr[i + 1]), Float.valueOf(fArr[i + 5]), Float.valueOf(fArr[i + 9]), Float.valueOf(fArr[i + 13]), Float.valueOf(fArr[i + 2]), Float.valueOf(fArr[i + 6]), Float.valueOf(fArr[i + 10]), Float.valueOf(fArr[i + 14]), Float.valueOf(fArr[i + 3]), Float.valueOf(fArr[i + 7]), Float.valueOf(fArr[i + 11]), Float.valueOf(fArr[i + 15]));
    }

    private static void normalize(float[] fArr, float f, float f2) {
        Matrix.translateM(fArr, 0, f, f2, BitmapDescriptorFactory.HUE_RED);
    }

    private static void denormalize(float[] fArr, float f, float f2) {
        Matrix.translateM(fArr, 0, -f, -f2, BitmapDescriptorFactory.HUE_RED);
    }
}
