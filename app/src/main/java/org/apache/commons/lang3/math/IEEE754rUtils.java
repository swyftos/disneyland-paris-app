package org.apache.commons.lang3.math;

import java.util.Objects;
import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes6.dex */
public class IEEE754rUtils {
    public static double max(double... dArr) {
        Objects.requireNonNull(dArr, "array");
        Validate.isTrue(dArr.length != 0, "Array cannot be empty.", new Object[0]);
        double dMax = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            dMax = max(dArr[i], dMax);
        }
        return dMax;
    }

    public static double max(double d, double d2) {
        if (Double.isNaN(d)) {
            return d2;
        }
        return Double.isNaN(d2) ? d : Math.max(d, d2);
    }

    public static double max(double d, double d2, double d3) {
        return max(max(d, d2), d3);
    }

    public static float max(float... fArr) {
        Objects.requireNonNull(fArr, "array");
        Validate.isTrue(fArr.length != 0, "Array cannot be empty.", new Object[0]);
        float fMax = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            fMax = max(fArr[i], fMax);
        }
        return fMax;
    }

    public static float max(float f, float f2) {
        if (Float.isNaN(f)) {
            return f2;
        }
        return Float.isNaN(f2) ? f : Math.max(f, f2);
    }

    public static float max(float f, float f2, float f3) {
        return max(max(f, f2), f3);
    }

    public static double min(double... dArr) {
        Objects.requireNonNull(dArr, "array");
        Validate.isTrue(dArr.length != 0, "Array cannot be empty.", new Object[0]);
        double dMin = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            dMin = min(dArr[i], dMin);
        }
        return dMin;
    }

    public static double min(double d, double d2) {
        if (Double.isNaN(d)) {
            return d2;
        }
        return Double.isNaN(d2) ? d : Math.min(d, d2);
    }

    public static double min(double d, double d2, double d3) {
        return min(min(d, d2), d3);
    }

    public static float min(float... fArr) {
        Objects.requireNonNull(fArr, "array");
        Validate.isTrue(fArr.length != 0, "Array cannot be empty.", new Object[0]);
        float fMin = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            fMin = min(fArr[i], fMin);
        }
        return fMin;
    }

    public static float min(float f, float f2) {
        if (Float.isNaN(f)) {
            return f2;
        }
        return Float.isNaN(f2) ? f : Math.min(f, f2);
    }

    public static float min(float f, float f2, float f3) {
        return min(min(f, f2), f3);
    }

    @Deprecated
    public IEEE754rUtils() {
    }
}
