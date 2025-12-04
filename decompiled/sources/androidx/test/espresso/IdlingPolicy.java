package androidx.test.espresso;

import android.util.Log;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class IdlingPolicy {
    private final boolean disableOnTimeout;
    private final ResponseAction errorHandler;
    private final long idleTimeout;
    private final boolean timeoutIfDebuggerAttached;
    private final TimeUnit unit;

    /* renamed from: androidx.test.espresso.IdlingPolicy$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$test$espresso$IdlingPolicy$ResponseAction;

        static {
            int[] iArr = new int[ResponseAction.values().length];
            $SwitchMap$androidx$test$espresso$IdlingPolicy$ResponseAction = iArr;
            try {
                iArr[ResponseAction.THROW_APP_NOT_IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$test$espresso$IdlingPolicy$ResponseAction[ResponseAction.THROW_IDLE_TIMEOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$test$espresso$IdlingPolicy$ResponseAction[ResponseAction.LOG_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private enum ResponseAction {
        THROW_APP_NOT_IDLE,
        THROW_IDLE_TIMEOUT,
        LOG_ERROR
    }

    private IdlingPolicy(Builder builder) {
        Preconditions.checkArgument(builder.idleTimeout > 0);
        this.idleTimeout = builder.idleTimeout;
        this.unit = (TimeUnit) Preconditions.checkNotNull(builder.unit);
        this.errorHandler = (ResponseAction) Preconditions.checkNotNull(builder.errorHandler);
        this.timeoutIfDebuggerAttached = builder.timeoutIfDebuggerAttached;
        this.disableOnTimeout = builder.disableOnTimeout;
    }

    public boolean getDisableOnTimeout() {
        return this.disableOnTimeout;
    }

    public long getIdleTimeout() {
        return this.idleTimeout;
    }

    public TimeUnit getIdleTimeoutUnit() {
        return this.unit;
    }

    public boolean getTimeoutIfDebuggerAttached() {
        return this.timeoutIfDebuggerAttached;
    }

    public void handleTimeout(List<String> list, String str) {
        int i = AnonymousClass1.$SwitchMap$androidx$test$espresso$IdlingPolicy$ResponseAction[this.errorHandler.ordinal()];
        if (i == 1) {
            throw AppNotIdleException.create(list, str);
        }
        if (i == 2) {
            throw new IdlingResourceTimeoutException(list);
        }
        if (i != 3) {
            String strValueOf = String.valueOf(list);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 24);
            sb.append("should never reach here.");
            sb.append(strValueOf);
            throw new IllegalStateException(sb.toString());
        }
        String strValueOf2 = String.valueOf(list);
        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 30);
        sb2.append("These resources are not idle: ");
        sb2.append(strValueOf2);
        Log.w("IdlingPolicy", sb2.toString());
    }

    Builder toBuilder() {
        return new Builder(this, null);
    }

    static class Builder {
        private boolean disableOnTimeout;
        private ResponseAction errorHandler;
        private long idleTimeout;
        private boolean timeoutIfDebuggerAttached;
        private TimeUnit unit;

        public Builder() {
            this.idleTimeout = -1L;
            this.unit = null;
            this.errorHandler = null;
            this.timeoutIfDebuggerAttached = false;
        }

        public IdlingPolicy build() {
            return new IdlingPolicy(this, null);
        }

        public Builder logWarning() {
            this.errorHandler = ResponseAction.LOG_ERROR;
            return this;
        }

        public Builder throwAppNotIdleException() {
            this.errorHandler = ResponseAction.THROW_APP_NOT_IDLE;
            return this;
        }

        public Builder throwIdlingResourceTimeoutException() {
            this.errorHandler = ResponseAction.THROW_IDLE_TIMEOUT;
            return this;
        }

        public Builder withIdlingTimeout(long j) {
            this.idleTimeout = j;
            return this;
        }

        public Builder withIdlingTimeoutUnit(TimeUnit timeUnit) {
            this.unit = timeUnit;
            return this;
        }

        public Builder withTimeoutIfDebuggerAttached(boolean z) {
            this.timeoutIfDebuggerAttached = z;
            return this;
        }

        private Builder(IdlingPolicy idlingPolicy) {
            this.idleTimeout = -1L;
            this.unit = null;
            this.errorHandler = null;
            this.timeoutIfDebuggerAttached = false;
            this.idleTimeout = idlingPolicy.idleTimeout;
            this.unit = idlingPolicy.unit;
            this.errorHandler = idlingPolicy.errorHandler;
        }

        /* synthetic */ Builder(IdlingPolicy idlingPolicy, AnonymousClass1 anonymousClass1) {
            this(idlingPolicy);
        }
    }

    /* synthetic */ IdlingPolicy(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }
}
