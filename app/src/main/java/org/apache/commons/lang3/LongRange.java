package org.apache.commons.lang3;

import java.util.stream.LongStream;

/* JADX INFO: loaded from: classes6.dex */
public final class LongRange extends NumberRange<Long> {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: of */
    public static LongRange m1946of(long j, long j2) {
        return m1947of(Long.valueOf(j), Long.valueOf(j2));
    }

    /* JADX INFO: renamed from: of */
    public static LongRange m1947of(Long l, Long l2) {
        return new LongRange(l, l2);
    }

    private LongRange(Long l, Long l2) {
        super(l, l2, null);
    }

    public long fit(long j) {
        return ((Long) super.fit(Long.valueOf(j))).longValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LongStream toLongStream() {
        return LongStream.rangeClosed(((Long) getMinimum()).longValue(), ((Long) getMaximum()).longValue());
    }
}
