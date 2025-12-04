package com.google.android.material.shape;

import androidx.annotation.NonNull;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes4.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float f, boolean z) {
        this.size = f;
        this.inside = z;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f2, float f3, @NonNull ShapePath shapePath) {
        if (this.inside) {
            shapePath.lineTo(f2 - (this.size * f3), BitmapDescriptorFactory.HUE_RED);
            float f4 = this.size;
            shapePath.lineTo(f2, f4 * f3, (f4 * f3) + f2, BitmapDescriptorFactory.HUE_RED);
            shapePath.lineTo(f, BitmapDescriptorFactory.HUE_RED);
            return;
        }
        float f5 = this.size;
        shapePath.lineTo(f2 - (f5 * f3), BitmapDescriptorFactory.HUE_RED, f2, (-f5) * f3);
        shapePath.lineTo(f2 + (this.size * f3), BitmapDescriptorFactory.HUE_RED, f, BitmapDescriptorFactory.HUE_RED);
    }
}
