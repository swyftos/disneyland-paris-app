package com.google.maps.android;

/* loaded from: classes4.dex */
abstract class MathUtil {
    static double clamp(double d, double d2, double d3) {
        return d < d2 ? d2 : d > d3 ? d3 : d;
    }

    static double mod(double d, double d2) {
        return ((d % d2) + d2) % d2;
    }

    static double wrap(double d, double d2, double d3) {
        return (d < d2 || d >= d3) ? mod(d - d2, d3 - d2) + d2 : d;
    }

    static double mercator(double d) {
        return Math.log(Math.tan((d * 0.5d) + 0.7853981633974483d));
    }

    static double inverseMercator(double d) {
        return (Math.atan(Math.exp(d)) * 2.0d) - 1.5707963267948966d;
    }

    static double hav(double d) {
        double dSin = Math.sin(d * 0.5d);
        return dSin * dSin;
    }

    static double arcHav(double d) {
        return Math.asin(Math.sqrt(d)) * 2.0d;
    }

    static double sinFromHav(double d) {
        return Math.sqrt(d * (1.0d - d)) * 2.0d;
    }

    static double havFromSin(double d) {
        double d2 = d * d;
        return (d2 / (Math.sqrt(1.0d - d2) + 1.0d)) * 0.5d;
    }

    static double sinSumFromHav(double d, double d2) {
        double dSqrt = Math.sqrt((1.0d - d) * d);
        double dSqrt2 = Math.sqrt((1.0d - d2) * d2);
        return ((dSqrt + dSqrt2) - (((dSqrt * d2) + (dSqrt2 * d)) * 2.0d)) * 2.0d;
    }

    static double havDistance(double d, double d2, double d3) {
        return hav(d - d2) + (hav(d3) * Math.cos(d) * Math.cos(d2));
    }
}
