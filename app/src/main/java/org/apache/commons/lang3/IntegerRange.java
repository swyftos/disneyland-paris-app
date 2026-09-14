package org.apache.commons.lang3;

import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes6.dex */
public final class IntegerRange extends NumberRange<Integer> {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: of */
    public static IntegerRange m1944of(int i, int i2) {
        return m1945of(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: renamed from: of */
    public static IntegerRange m1945of(Integer num, Integer num2) {
        return new IntegerRange(num, num2);
    }

    private IntegerRange(Integer num, Integer num2) {
        super(num, num2, null);
    }

    public int fit(int i) {
        return ((Integer) super.fit(Integer.valueOf(i))).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IntStream toIntStream() {
        return IntStream.rangeClosed(((Integer) getMinimum()).intValue(), ((Integer) getMaximum()).intValue());
    }
}
