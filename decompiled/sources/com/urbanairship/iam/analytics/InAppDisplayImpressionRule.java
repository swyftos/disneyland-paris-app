package com.urbanairship.iam.analytics;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.time.Duration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppDisplayImpressionRule;", "", "()V", "Interval", "Once", "Lcom/urbanairship/iam/analytics/InAppDisplayImpressionRule$Interval;", "Lcom/urbanairship/iam/analytics/InAppDisplayImpressionRule$Once;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class InAppDisplayImpressionRule {
    public /* synthetic */ InAppDisplayImpressionRule(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppDisplayImpressionRule$Once;", "Lcom/urbanairship/iam/analytics/InAppDisplayImpressionRule;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Once extends InAppDisplayImpressionRule {

        @NotNull
        public static final Once INSTANCE = new Once();

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof Once);
        }

        public int hashCode() {
            return -1246574282;
        }

        @NotNull
        public String toString() {
            return "Once";
        }

        private Once() {
            super(null);
        }
    }

    private InAppDisplayImpressionRule() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\b\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppDisplayImpressionRule$Interval;", "Lcom/urbanairship/iam/analytics/InAppDisplayImpressionRule;", "value", "Lkotlin/time/Duration;", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-UwyO8pc", "()J", "J", "component1", "component1-UwyO8pc", "copy", "copy-LRDsOJo", "(J)Lcom/urbanairship/iam/analytics/InAppDisplayImpressionRule$Interval;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Interval extends InAppDisplayImpressionRule {
        private final long value;

        public /* synthetic */ Interval(long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(j);
        }

        /* renamed from: copy-LRDsOJo$default, reason: not valid java name */
        public static /* synthetic */ Interval m2883copyLRDsOJo$default(Interval interval, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = interval.value;
            }
            return interval.m2885copyLRDsOJo(j);
        }

        /* renamed from: component1-UwyO8pc, reason: not valid java name and from getter */
        public final long getValue() {
            return this.value;
        }

        @NotNull
        /* renamed from: copy-LRDsOJo, reason: not valid java name */
        public final Interval m2885copyLRDsOJo(long value) {
            return new Interval(value, null);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Interval) && Duration.m3472equalsimpl0(this.value, ((Interval) other).value);
        }

        public int hashCode() {
            return Duration.m3494hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return "Interval(value=" + ((Object) Duration.m3515toStringimpl(this.value)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        private Interval(long j) {
            super(null);
            this.value = j;
        }

        /* renamed from: getValue-UwyO8pc, reason: not valid java name */
        public final long m2886getValueUwyO8pc() {
            return this.value;
        }
    }
}
