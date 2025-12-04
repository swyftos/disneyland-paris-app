package com.facebook.common.time;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Nullsafe(Nullsafe.Mode.LOCAL)
/* loaded from: classes3.dex */
public interface MonotonicClock {
    @DoNotStrip
    long nowNanos();

    @DoNotStrip
    default long now() {
        return TimeUnit.NANOSECONDS.toMillis(nowNanos());
    }

    static MonotonicClock of(Clock clock) {
        return new MonotonicClockWrapper(clock);
    }

    public static final class MonotonicClockWrapper implements MonotonicClock {
        private long mLast;
        private final Clock provider;

        private MonotonicClockWrapper(Clock clock) {
            this.provider = clock;
            this.mLast = clock.now();
        }

        @Override // com.facebook.common.time.MonotonicClock
        public long nowNanos() {
            return TimeUnit.MILLISECONDS.toNanos(now());
        }

        @Override // com.facebook.common.time.MonotonicClock
        public long now() {
            long jMax = Math.max(this.mLast, this.provider.now());
            this.mLast = jMax;
            return jMax;
        }
    }
}
