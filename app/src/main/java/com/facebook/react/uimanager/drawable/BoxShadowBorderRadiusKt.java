package com.facebook.react.uimanager.drawable;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0004"}, m1836d2 = {"adjustRadiusForSpread", "", "radius", "spread", "ReactAndroid_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class BoxShadowBorderRadiusKt {
    public static final float adjustRadiusForSpread(float f, float f2) {
        float fPow;
        if (f < Math.abs(f2)) {
            float f3 = 1;
            fPow = f3 + ((float) Math.pow((f / Math.abs(f2)) - f3, 3));
        } else {
            fPow = 1.0f;
        }
        return RangesKt.coerceAtLeast(f + (f2 * fPow), BitmapDescriptorFactory.HUE_RED);
    }
}
