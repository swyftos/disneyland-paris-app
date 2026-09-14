package com.airbnb.lottie.utils;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes2.dex */
public class MeanCalculator {

    /* JADX INFO: renamed from: n */
    private int f211n;
    private float sum;

    public void add(float f) {
        float f2 = this.sum + f;
        this.sum = f2;
        int i = this.f211n + 1;
        this.f211n = i;
        if (i == Integer.MAX_VALUE) {
            this.sum = f2 / 2.0f;
            this.f211n = i / 2;
        }
    }

    public float getMean() {
        int i = this.f211n;
        return i == 0 ? BitmapDescriptorFactory.HUE_RED : this.sum / i;
    }
}
