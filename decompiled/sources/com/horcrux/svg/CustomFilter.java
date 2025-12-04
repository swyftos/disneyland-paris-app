package com.horcrux.svg;

import android.graphics.Bitmap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes4.dex */
public class CustomFilter {
    public static Bitmap apply(Bitmap bitmap, Bitmap bitmap2, CustomFilterFunction customFilterFunction) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        int[] iArr3 = new int[i];
        float[] fArr = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};
        float[] fArr2 = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};
        try {
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            bitmap2.getPixels(iArr2, 0, width, 0, 0, width, height);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused) {
        }
        for (int i2 = 0; i2 < height; i2++) {
            for (int i3 = 0; i3 < width; i3++) {
                int i4 = (i2 * width) + i3;
                int i5 = iArr[i4];
                fArr[0] = ((i5 >> 24) & 255) / 255.0f;
                fArr[1] = ((i5 >> 16) & 255) / 255.0f;
                fArr[2] = ((i5 >> 8) & 255) / 255.0f;
                fArr[3] = (i5 & 255) / 255.0f;
                int i6 = iArr2[i4];
                fArr2[0] = ((i6 >> 24) & 255) / 255.0f;
                fArr2[1] = ((i6 >> 16) & 255) / 255.0f;
                fArr2[2] = ((i6 >> 8) & 255) / 255.0f;
                fArr2[3] = (i6 & 255) / 255.0f;
                iArr3[i4] = normalizeFromFloats(customFilterFunction.execute(fArr, fArr2));
            }
        }
        return Bitmap.createBitmap(iArr3, width, height, Bitmap.Config.ARGB_8888);
    }

    public static int normalizeFromFloat(float f) {
        return Math.min(255, Math.max(0, Math.round(f * 255.0f)));
    }

    public static int normalizeFromFloats(float[] fArr) {
        if (fArr.length < 4 || normalizeFromFloat(fArr[0]) <= 0) {
            return 0;
        }
        return normalizeFromFloat(fArr[3] / fArr[0]) | (normalizeFromFloat(fArr[0]) << 24) | (normalizeFromFloat(fArr[1] / fArr[0]) << 16) | (normalizeFromFloat(fArr[2] / fArr[0]) << 8);
    }
}
