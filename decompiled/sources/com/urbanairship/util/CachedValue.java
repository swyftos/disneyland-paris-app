package com.urbanairship.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Predicate;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class CachedValue<T> {
    private final Clock clock;
    private long expiration;
    private final Object lock;
    private Object value;

    public CachedValue() {
        this(Clock.DEFAULT_CLOCK);
    }

    public CachedValue(@NonNull Clock clock) {
        this.lock = new Object();
        this.clock = clock;
    }

    public void set(@Nullable T t, long j) {
        synchronized (this.lock) {
            this.value = t;
            this.expiration = j;
        }
    }

    public void expire() {
        synchronized (this.lock) {
            this.value = null;
            this.expiration = 0L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void expireIf(Predicate<T> predicate) {
        synchronized (this.lock) {
            try {
                Object obj = this.value;
                if (obj != null && predicate.test(obj)) {
                    this.value = null;
                    this.expiration = 0L;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long remainingCacheTimeMillis() {
        long jCurrentTimeMillis = this.expiration - this.clock.currentTimeMillis();
        if (jCurrentTimeMillis >= 0) {
            return jCurrentTimeMillis;
        }
        return 0L;
    }

    @Nullable
    public T get() {
        synchronized (this.lock) {
            try {
                if (this.clock.currentTimeMillis() >= this.expiration) {
                    return null;
                }
                return (T) this.value;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
