package com.google.maps.android.geometry;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public class Point {

    /* JADX INFO: renamed from: x */
    public final double f3580x;

    /* JADX INFO: renamed from: y */
    public final double f3581y;

    public Point(double d, double d2) {
        this.f3580x = d;
        this.f3581y = d2;
    }

    @NonNull
    public String toString() {
        return "Point{x=" + this.f3580x + ", y=" + this.f3581y + '}';
    }
}
