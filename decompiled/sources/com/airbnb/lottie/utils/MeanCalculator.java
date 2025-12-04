package com.airbnb.lottie.utils;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes2.dex */
public class MeanCalculator {
    private int n;
    private float sum;

    public void add(float f) {
        float f2 = this.sum + f;
        this.sum = f2;
        int i = this.n + 1;
        this.n = i;
        if (i == Integer.MAX_VALUE) {
            this.sum = f2 / 2.0f;
            this.n = i / 2;
        }
    }

    public float getMean() {
        int i = this.n;
        return i == 0 ? BitmapDescriptorFactory.HUE_RED : this.sum / i;
    }
}
