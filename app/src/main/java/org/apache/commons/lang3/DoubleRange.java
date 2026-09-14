package org.apache.commons.lang3;

/* JADX INFO: loaded from: classes6.dex */
public final class DoubleRange extends NumberRange<Double> {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: of */
    public static DoubleRange m1942of(double d, double d2) {
        return m1943of(Double.valueOf(d), Double.valueOf(d2));
    }

    /* JADX INFO: renamed from: of */
    public static DoubleRange m1943of(Double d, Double d2) {
        return new DoubleRange(d, d2);
    }

    private DoubleRange(Double d, Double d2) {
        super(d, d2, null);
    }

    public double fit(double d) {
        return ((Double) super.fit(Double.valueOf(d))).doubleValue();
    }
}
