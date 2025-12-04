package ch.qos.logback.core.util;

/* loaded from: classes2.dex */
public class FixedDelay implements DelayStrategy {
    private long nextDelay;
    private final long subsequentDelay;

    /* JADX WARN: Illegal instructions before constructor call */
    public FixedDelay(int i) {
        long j = i;
        this(j, j);
    }

    public FixedDelay(long j, long j2) {
        this.nextDelay = j;
        this.subsequentDelay = j2;
    }

    @Override // ch.qos.logback.core.util.DelayStrategy
    public long nextDelay() {
        long j = this.nextDelay;
        this.nextDelay = this.subsequentDelay;
        return j;
    }
}
