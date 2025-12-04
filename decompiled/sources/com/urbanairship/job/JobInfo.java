package com.urbanairship.job;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;
import ch.qos.logback.core.CoreConstants;
import com.urbanairship.AirshipComponent;
import com.urbanairship.json.JsonMap;
import com.urbanairship.util.Checks;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class JobInfo {
    public static final int APPEND = 1;
    public static final int KEEP = 2;
    public static final int REPLACE = 0;
    private final String action;
    private final String airshipComponentName;
    private final int conflictStrategy;
    private final JsonMap extras;
    private final long initialBackOffMs;
    private final boolean isNetworkAccessRequired;
    private final long minDelayMs;
    private final Set rateLimitIds;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConflictStrategy {
    }

    private JobInfo(Builder builder) {
        this.action = builder.action;
        this.airshipComponentName = builder.airshipComponentName == null ? "" : builder.airshipComponentName;
        this.extras = builder.extras != null ? builder.extras : JsonMap.EMPTY_MAP;
        this.isNetworkAccessRequired = builder.isNetworkAccessRequired;
        this.minDelayMs = builder.minDelayMs;
        this.conflictStrategy = builder.conflictStrategy;
        this.initialBackOffMs = builder.initialBackOffMs;
        this.rateLimitIds = new HashSet(builder.rateLimitIds);
    }

    @NonNull
    public String getAction() {
        return this.action;
    }

    public boolean isNetworkAccessRequired() {
        return this.isNetworkAccessRequired;
    }

    public long getMinDelayMs() {
        return this.minDelayMs;
    }

    @NonNull
    public JsonMap getExtras() {
        return this.extras;
    }

    @NonNull
    public String getAirshipComponentName() {
        return this.airshipComponentName;
    }

    @NonNull
    public Set<String> getRateLimitIds() {
        return this.rateLimitIds;
    }

    public int getConflictStrategy() {
        return this.conflictStrategy;
    }

    public long getInitialBackOffMs() {
        return this.initialBackOffMs;
    }

    public String toString() {
        return "JobInfo{action='" + this.action + CoreConstants.SINGLE_QUOTE_CHAR + ", airshipComponentName='" + this.airshipComponentName + CoreConstants.SINGLE_QUOTE_CHAR + ", isNetworkAccessRequired=" + this.isNetworkAccessRequired + ", minDelayMs=" + this.minDelayMs + ", conflictStrategy=" + this.conflictStrategy + ", initialBackOffMs=" + this.initialBackOffMs + ", extras=" + this.extras + ", rateLimitIds=" + this.rateLimitIds + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        JobInfo jobInfo = (JobInfo) obj;
        return this.isNetworkAccessRequired == jobInfo.isNetworkAccessRequired && this.minDelayMs == jobInfo.minDelayMs && this.conflictStrategy == jobInfo.conflictStrategy && this.initialBackOffMs == jobInfo.initialBackOffMs && ObjectsCompat.equals(this.extras, jobInfo.extras) && ObjectsCompat.equals(this.action, jobInfo.action) && ObjectsCompat.equals(this.airshipComponentName, jobInfo.airshipComponentName) && ObjectsCompat.equals(this.rateLimitIds, jobInfo.rateLimitIds);
    }

    public int hashCode() {
        return ObjectsCompat.hash(this.extras, this.action, this.airshipComponentName, Boolean.valueOf(this.isNetworkAccessRequired), Long.valueOf(this.minDelayMs), Integer.valueOf(this.conflictStrategy), Long.valueOf(this.initialBackOffMs), this.rateLimitIds);
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final long MIN_INITIAL_BACKOFF_MS;
        private String action;
        private String airshipComponentName;
        private int conflictStrategy;
        private JsonMap extras;
        private long initialBackOffMs;
        private boolean isNetworkAccessRequired;
        private long minDelayMs;
        private Set rateLimitIds;

        private Builder() {
            this.MIN_INITIAL_BACKOFF_MS = 30000L;
            this.conflictStrategy = 0;
            this.initialBackOffMs = 30000L;
            this.minDelayMs = 0L;
            this.rateLimitIds = new HashSet();
        }

        @NonNull
        public Builder setAction(@Nullable String str) {
            this.action = str;
            return this;
        }

        @NonNull
        public Builder setInitialBackOff(long j, @NonNull TimeUnit timeUnit) {
            this.initialBackOffMs = Math.max(30000L, timeUnit.toMillis(j));
            return this;
        }

        @NonNull
        public Builder setNetworkAccessRequired(boolean z) {
            this.isNetworkAccessRequired = z;
            return this;
        }

        @NonNull
        public Builder setAirshipComponent(@NonNull Class<? extends AirshipComponent> cls) {
            this.airshipComponentName = cls.getName();
            return this;
        }

        @NonNull
        public Builder setMinDelay(long j, @NonNull TimeUnit timeUnit) {
            this.minDelayMs = timeUnit.toMillis(j);
            return this;
        }

        Builder setAirshipComponent(String str) {
            this.airshipComponentName = str;
            return this;
        }

        @NonNull
        public Builder setExtras(@NonNull JsonMap jsonMap) {
            this.extras = jsonMap;
            return this;
        }

        @NonNull
        public Builder setConflictStrategy(int i) {
            this.conflictStrategy = i;
            return this;
        }

        @NonNull
        public Builder addRateLimit(@NonNull String str) {
            this.rateLimitIds.add(str);
            return this;
        }

        @NonNull
        public JobInfo build() {
            Checks.checkNotNull(this.action, "Missing action.");
            return new JobInfo(this);
        }
    }
}
