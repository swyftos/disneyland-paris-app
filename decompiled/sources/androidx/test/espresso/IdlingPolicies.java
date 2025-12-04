package androidx.test.espresso;

import androidx.test.espresso.IdlingPolicy;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class IdlingPolicies {
    private static volatile IdlingPolicy dynamicIdlingResourceErrorPolicy;
    private static volatile IdlingPolicy dynamicIdlingResourceWarningPolicy;
    private static volatile IdlingPolicy masterIdlingPolicy;

    static {
        IdlingPolicy.Builder builderWithIdlingTimeout = new IdlingPolicy.Builder().withIdlingTimeout(60L);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        masterIdlingPolicy = builderWithIdlingTimeout.withIdlingTimeoutUnit(timeUnit).throwAppNotIdleException().build();
        dynamicIdlingResourceErrorPolicy = new IdlingPolicy.Builder().withIdlingTimeout(26L).withIdlingTimeoutUnit(timeUnit).throwIdlingResourceTimeoutException().build();
        dynamicIdlingResourceWarningPolicy = new IdlingPolicy.Builder().withIdlingTimeout(5L).withIdlingTimeoutUnit(timeUnit).logWarning().build();
    }

    public static IdlingPolicy getDynamicIdlingResourceErrorPolicy() {
        return dynamicIdlingResourceErrorPolicy;
    }

    public static IdlingPolicy getDynamicIdlingResourceWarningPolicy() {
        return dynamicIdlingResourceWarningPolicy;
    }

    public static IdlingPolicy getMasterIdlingPolicy() {
        return masterIdlingPolicy;
    }

    public static void setIdlingResourceTimeout(long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j > 0);
        Preconditions.checkNotNull(timeUnit);
        dynamicIdlingResourceErrorPolicy = dynamicIdlingResourceErrorPolicy.toBuilder().withIdlingTimeout(j).withIdlingTimeoutUnit(timeUnit).build();
    }

    public static void setMasterPolicyTimeout(long j, TimeUnit timeUnit) {
        Preconditions.checkArgument(j > 0);
        Preconditions.checkNotNull(timeUnit);
        masterIdlingPolicy = masterIdlingPolicy.toBuilder().withIdlingTimeout(j).withIdlingTimeoutUnit(timeUnit).build();
    }

    public static void setMasterPolicyTimeoutWhenDebuggerAttached(boolean z) {
        masterIdlingPolicy = masterIdlingPolicy.toBuilder().withTimeoutIfDebuggerAttached(z).build();
    }
}
