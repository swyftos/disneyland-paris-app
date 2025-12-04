package com.urbanairship.automation;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/ExecutionWindowResult;", "", "()V", "Now", "Retry", "Lcom/urbanairship/automation/ExecutionWindowResult$Now;", "Lcom/urbanairship/automation/ExecutionWindowResult$Retry;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public abstract class ExecutionWindowResult {
    public /* synthetic */ ExecutionWindowResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ExecutionWindowResult() {
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/automation/ExecutionWindowResult$Now;", "Lcom/urbanairship/automation/ExecutionWindowResult;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Now extends ExecutionWindowResult {

        @NotNull
        public static final Now INSTANCE = new Now();

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof Now);
        }

        public int hashCode() {
            return -1450283261;
        }

        @NotNull
        public String toString() {
            return "Now";
        }

        private Now() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/automation/ExecutionWindowResult$Retry;", "Lcom/urbanairship/automation/ExecutionWindowResult;", "delay", "Lkotlin/time/Duration;", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDelay-UwyO8pc", "()J", "J", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Retry extends ExecutionWindowResult {
        private final long delay;

        public /* synthetic */ Retry(long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(j);
        }

        private Retry(long j) {
            super(null);
            this.delay = j;
        }

        /* renamed from: getDelay-UwyO8pc, reason: not valid java name and from getter */
        public final long getDelay() {
            return this.delay;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(Retry.class, other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.automation.ExecutionWindowResult.Retry");
            return Duration.m3472equalsimpl0(this.delay, ((Retry) other).delay);
        }

        public int hashCode() {
            return Duration.m3494hashCodeimpl(this.delay);
        }

        @NotNull
        public String toString() {
            return "Retry(delay=" + ((Object) Duration.m3515toStringimpl(this.delay)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }
}
