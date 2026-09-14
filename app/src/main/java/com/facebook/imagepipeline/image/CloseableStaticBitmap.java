package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.infer.annotation.Nullsafe;

/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
public interface CloseableStaticBitmap extends CloseableBitmap {
    CloseableReference<Bitmap> cloneUnderlyingBitmapReference();

    CloseableReference<Bitmap> convertToBitmapReference();

    int getExifOrientation();

    int getRotationAngle();

    /* JADX INFO: renamed from: of */
    static CloseableStaticBitmap m1361of(Bitmap bitmap, ResourceReleaser<Bitmap> resourceReleaser, QualityInfo qualityInfo, int i) {
        return m1362of(bitmap, resourceReleaser, qualityInfo, i, 0);
    }

    /* JADX INFO: renamed from: of */
    static CloseableStaticBitmap m1363of(CloseableReference<Bitmap> closeableReference, QualityInfo qualityInfo, int i) {
        return m1364of(closeableReference, qualityInfo, i, 0);
    }

    /* JADX INFO: renamed from: of */
    static CloseableStaticBitmap m1362of(Bitmap bitmap, ResourceReleaser<Bitmap> resourceReleaser, QualityInfo qualityInfo, int i, int i2) {
        if (BaseCloseableStaticBitmap.shouldUseSimpleCloseableStaticBitmap()) {
            return new BaseCloseableStaticBitmap(bitmap, resourceReleaser, qualityInfo, i, i2);
        }
        return new DefaultCloseableStaticBitmap(bitmap, resourceReleaser, qualityInfo, i, i2);
    }

    /* JADX INFO: renamed from: of */
    static CloseableStaticBitmap m1364of(CloseableReference<Bitmap> closeableReference, QualityInfo qualityInfo, int i, int i2) {
        if (BaseCloseableStaticBitmap.shouldUseSimpleCloseableStaticBitmap()) {
            return new BaseCloseableStaticBitmap(closeableReference, qualityInfo, i, i2);
        }
        return new DefaultCloseableStaticBitmap(closeableReference, qualityInfo, i, i2);
    }
}
