package ch.qos.logback.core.util;

import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes2.dex */
public class DefaultInvocationGate implements InvocationGate {
    private long invocationCounter;
    long lowerLimitForMaskMatch;
    private volatile long mask;
    private long maxDelayThreshold;
    private long minDelayThreshold;
    long upperLimitForNoMaskMatch;

    public DefaultInvocationGate() {
        this(100L, 800L, System.currentTimeMillis());
    }

    public DefaultInvocationGate(long j, long j2, long j3) {
        this.mask = 15L;
        this.invocationCounter = 0L;
        this.minDelayThreshold = j;
        this.maxDelayThreshold = j2;
        this.lowerLimitForMaskMatch = j + j3;
        this.upperLimitForNoMaskMatch = j3 + j2;
    }

    private void decreaseMask() {
        this.mask >>>= 2;
    }

    private void increaseMask() {
        if (this.mask >= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            return;
        }
        this.mask = (this.mask << 1) | 1;
    }

    private void updateLimits(long j) {
        this.lowerLimitForMaskMatch = this.minDelayThreshold + j;
        this.upperLimitForNoMaskMatch = j + this.maxDelayThreshold;
    }

    public long getInvocationCounter() {
        return this.invocationCounter;
    }

    @Override // ch.qos.logback.core.util.InvocationGate
    public final boolean isTooSoon(long j) {
        long j2 = this.invocationCounter;
        this.invocationCounter = 1 + j2;
        boolean z = (j2 & this.mask) == this.mask;
        if (z) {
            if (j < this.lowerLimitForMaskMatch) {
                increaseMask();
            }
            updateLimits(j);
        } else if (j > this.upperLimitForNoMaskMatch) {
            decreaseMask();
            updateLimits(j);
            return false;
        }
        return !z;
    }
}
