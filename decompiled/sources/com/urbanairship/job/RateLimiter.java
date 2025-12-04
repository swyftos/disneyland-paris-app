package com.urbanairship.job;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.urbanairship.util.Clock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class RateLimiter {
    private final Clock clock;
    private final Map hits;
    private final Object lock;
    private final Map rules;

    public enum LimitStatus {
        OVER,
        UNDER
    }

    public RateLimiter() {
        this(Clock.DEFAULT_CLOCK);
    }

    @VisibleForTesting
    public RateLimiter(Clock clock) {
        this.hits = new HashMap();
        this.rules = new HashMap();
        this.lock = new Object();
        this.clock = clock;
    }

    public void track(@NonNull String str) {
        synchronized (this.lock) {
            try {
                List list = (List) this.hits.get(str);
                Rule rule = (Rule) this.rules.get(str);
                long jCurrentTimeMillis = this.clock.currentTimeMillis();
                if (list != null && rule != null) {
                    list.add(Long.valueOf(jCurrentTimeMillis));
                    filter(list, rule, jCurrentTimeMillis);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public Status status(@NonNull String str) {
        synchronized (this.lock) {
            try {
                List list = (List) this.hits.get(str);
                Rule rule = (Rule) this.rules.get(str);
                long jCurrentTimeMillis = this.clock.currentTimeMillis();
                if (list != null && rule != null) {
                    filter(list, rule, jCurrentTimeMillis);
                    if (list.size() >= rule.rate) {
                        return new Status(LimitStatus.OVER, rule.durationMs - (jCurrentTimeMillis - ((Long) list.get(list.size() - rule.rate)).longValue()));
                    }
                    return new Status(LimitStatus.UNDER, 0L);
                }
                return null;
            } finally {
            }
        }
    }

    public void setLimit(@NonNull String str, @IntRange(from = 1) int i, long j, @NonNull TimeUnit timeUnit) {
        synchronized (this.lock) {
            this.rules.put(str, new Rule(i, timeUnit.toMillis(j)));
            this.hits.put(str, new ArrayList());
        }
    }

    private void filter(List list, Rule rule, long j) {
        Iterator it = new ArrayList(list).iterator();
        while (it.hasNext()) {
            Long l = (Long) it.next();
            if (j >= l.longValue() + rule.durationMs) {
                list.remove(l);
            }
        }
    }

    public static final class Status {
        private final LimitStatus limitStatus;
        private final long nextAvailableMs;

        @VisibleForTesting
        public Status(@NonNull LimitStatus limitStatus, long j) {
            this.limitStatus = limitStatus;
            this.nextAvailableMs = j;
        }

        public LimitStatus getLimitStatus() {
            return this.limitStatus;
        }

        public long getNextAvailable(@NonNull TimeUnit timeUnit) {
            return timeUnit.convert(this.nextAvailableMs, TimeUnit.MILLISECONDS);
        }
    }

    private static final class Rule {
        final long durationMs;
        final int rate;

        Rule(int i, long j) {
            this.rate = i;
            this.durationMs = j;
        }
    }
}
