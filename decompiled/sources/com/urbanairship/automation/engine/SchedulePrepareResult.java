package com.urbanairship.automation.engine;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/urbanairship/automation/engine/SchedulePrepareResult;", "", "()V", "Cancel", "Invalidate", "Penalize", "Prepared", "Skip", "Lcom/urbanairship/automation/engine/SchedulePrepareResult$Cancel;", "Lcom/urbanairship/automation/engine/SchedulePrepareResult$Invalidate;", "Lcom/urbanairship/automation/engine/SchedulePrepareResult$Penalize;", "Lcom/urbanairship/automation/engine/SchedulePrepareResult$Prepared;", "Lcom/urbanairship/automation/engine/SchedulePrepareResult$Skip;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class SchedulePrepareResult {
    public /* synthetic */ SchedulePrepareResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/automation/engine/SchedulePrepareResult$Prepared;", "Lcom/urbanairship/automation/engine/SchedulePrepareResult;", "schedule", "Lcom/urbanairship/automation/engine/PreparedSchedule;", "(Lcom/urbanairship/automation/engine/PreparedSchedule;)V", "getSchedule", "()Lcom/urbanairship/automation/engine/PreparedSchedule;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Prepared extends SchedulePrepareResult {
        private final PreparedSchedule schedule;

        public static /* synthetic */ Prepared copy$default(Prepared prepared, PreparedSchedule preparedSchedule, int i, Object obj) {
            if ((i & 1) != 0) {
                preparedSchedule = prepared.schedule;
            }
            return prepared.copy(preparedSchedule);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final PreparedSchedule getSchedule() {
            return this.schedule;
        }

        @NotNull
        public final Prepared copy(@NotNull PreparedSchedule schedule) {
            Intrinsics.checkNotNullParameter(schedule, "schedule");
            return new Prepared(schedule);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Prepared) && Intrinsics.areEqual(this.schedule, ((Prepared) other).schedule);
        }

        public int hashCode() {
            return this.schedule.hashCode();
        }

        @NotNull
        public String toString() {
            return "Prepared(schedule=" + this.schedule + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Prepared(@NotNull PreparedSchedule schedule) {
            super(null);
            Intrinsics.checkNotNullParameter(schedule, "schedule");
            this.schedule = schedule;
        }

        @NotNull
        public final PreparedSchedule getSchedule() {
            return this.schedule;
        }
    }

    private SchedulePrepareResult() {
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/automation/engine/SchedulePrepareResult$Cancel;", "Lcom/urbanairship/automation/engine/SchedulePrepareResult;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Cancel extends SchedulePrepareResult {

        @NotNull
        public static final Cancel INSTANCE = new Cancel();

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof Cancel);
        }

        public int hashCode() {
            return -1555903427;
        }

        @NotNull
        public String toString() {
            return "Cancel";
        }

        private Cancel() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/automation/engine/SchedulePrepareResult$Invalidate;", "Lcom/urbanairship/automation/engine/SchedulePrepareResult;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Invalidate extends SchedulePrepareResult {

        @NotNull
        public static final Invalidate INSTANCE = new Invalidate();

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof Invalidate);
        }

        public int hashCode() {
            return -1833028226;
        }

        @NotNull
        public String toString() {
            return "Invalidate";
        }

        private Invalidate() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/automation/engine/SchedulePrepareResult$Skip;", "Lcom/urbanairship/automation/engine/SchedulePrepareResult;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Skip extends SchedulePrepareResult {

        @NotNull
        public static final Skip INSTANCE = new Skip();

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof Skip);
        }

        public int hashCode() {
            return 2063669250;
        }

        @NotNull
        public String toString() {
            return "Skip";
        }

        private Skip() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/automation/engine/SchedulePrepareResult$Penalize;", "Lcom/urbanairship/automation/engine/SchedulePrepareResult;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Penalize extends SchedulePrepareResult {

        @NotNull
        public static final Penalize INSTANCE = new Penalize();

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof Penalize);
        }

        public int hashCode() {
            return -139466541;
        }

        @NotNull
        public String toString() {
            return "Penalize";
        }

        private Penalize() {
            super(null);
        }
    }
}
