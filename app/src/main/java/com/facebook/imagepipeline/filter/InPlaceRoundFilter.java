package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, m1836d2 = {"Lcom/facebook/imagepipeline/filter/InPlaceRoundFilter;", "", "<init>", "()V", "roundBitmapInPlace", "", "bitmap", "Landroid/graphics/Bitmap;", "imagepipeline_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class InPlaceRoundFilter {

    @NotNull
    public static final InPlaceRoundFilter INSTANCE = new InPlaceRoundFilter();

    private InPlaceRoundFilter() {
    }

    @JvmStatic
    public static final void roundBitmapInPlace(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int iMin = Math.min(width, height) / 2;
        int i = width / 2;
        int i2 = height / 2;
        if (iMin == 0) {
            return;
        }
        Preconditions.checkArgument(Boolean.valueOf(iMin >= 1));
        Preconditions.checkArgument(Boolean.valueOf(width > 0 && ((float) width) <= 2048.0f));
        Preconditions.checkArgument(Boolean.valueOf(height > 0 && ((float) height) <= 2048.0f));
        Preconditions.checkArgument(Boolean.valueOf(i > 0 && i < width));
        Preconditions.checkArgument(Boolean.valueOf(i2 > 0 && i2 < height));
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i3 = iMin - 1;
        Preconditions.checkArgument(Boolean.valueOf(i - i3 >= 0 && i2 - i3 >= 0 && i + i3 < width && i2 + i3 < height));
        int i4 = (-iMin) * 2;
        int[] iArr2 = new int[width];
        int i5 = i4 + 1;
        int i6 = 0;
        int i7 = 1;
        int i8 = 1;
        while (i3 >= i6) {
            int i9 = i + i3;
            int i10 = i - i3;
            int i11 = i + i6;
            iMin = iMin;
            int i12 = i - i6;
            int i13 = i2 + i3;
            int i14 = i2 - i3;
            int i15 = i;
            int i16 = i2 + i6;
            int i17 = i2 - i6;
            Preconditions.checkArgument(Boolean.valueOf(i3 >= 0 && i11 < width && i12 >= 0 && i16 < height && i17 >= 0));
            int i18 = i16 * width;
            int i19 = height;
            int i20 = width * i17;
            int i21 = i2;
            int i22 = width * i13;
            i4 = i4;
            int i23 = width * i14;
            int i24 = i7;
            System.arraycopy(iArr2, 0, iArr, i18, i10);
            System.arraycopy(iArr2, 0, iArr, i20, i10);
            System.arraycopy(iArr2, 0, iArr, i22, i12);
            System.arraycopy(iArr2, 0, iArr, i23, i12);
            int i25 = width - i9;
            System.arraycopy(iArr2, 0, iArr, i18 + i9, i25);
            System.arraycopy(iArr2, 0, iArr, i20 + i9, i25);
            int i26 = width - i11;
            System.arraycopy(iArr2, 0, iArr, i22 + i11, i26);
            System.arraycopy(iArr2, 0, iArr, i23 + i11, i26);
            if (i5 <= 0) {
                i6++;
                i8 += 2;
                i5 += i8;
            }
            if (i5 > 0) {
                i3--;
                i7 = i24 + 2;
                i5 += i7 + i4;
            } else {
                i7 = i24;
            }
            i = i15;
            i2 = i21;
            height = i19;
        }
        int i27 = height;
        int i28 = iMin;
        int i29 = i2;
        for (int i30 = i29 - i28; -1 < i30; i30--) {
            System.arraycopy(iArr2, 0, iArr, i30 * width, width);
        }
        for (int i31 = i29 + i28; i31 < i27; i31++) {
            System.arraycopy(iArr2, 0, iArr, i31 * width, width);
        }
        bitmap.setPixels(iArr, 0, width, 0, 0, width, i27);
    }
}
