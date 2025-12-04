package com.google.android.libraries.barhopper;

import androidx.annotation.NonNull;
import com.google.android.apps.common.proguard.UsedByNative;

@UsedByNative("jni_common.cc")
/* loaded from: classes4.dex */
public final class MultiScaleDetectionOptions {

    @UsedByNative("jni_common.cc")
    private float[] extraScales = new float[0];

    @NonNull
    public float[] getExtraScales() {
        return this.extraScales;
    }

    public void setExtraScales(@NonNull float[] fArr) {
        this.extraScales = fArr;
    }
}
