package com.urbanairship.automation;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.urbanairship.automation.Rule;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0012\u001a\u00020\u0000R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/automation/DateRange;", "", "calendar", "Ljava/util/Calendar;", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "(Ljava/util/Calendar;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "startDate", "Ljava/util/Date;", "endDate", "(Ljava/util/Date;Ljava/util/Date;)V", "getEndDate", "()Ljava/util/Date;", "getStartDate", "contains", "", "date", "intersection", "range", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DateRange {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final Date endDate;
    private final Date startDate;

    public /* synthetic */ DateRange(Calendar calendar, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(calendar, j);
    }

    public DateRange(@NotNull Date startDate, @NotNull Date endDate) {
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @NotNull
    public final Date getStartDate() {
        return this.startDate;
    }

    @NotNull
    public final Date getEndDate() {
        return this.endDate;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private DateRange(Calendar calendar, long j) {
        Intrinsics.checkNotNullParameter(calendar, "calendar");
        Date time = calendar.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
        Date time2 = ExecutionWindowKt.addingSeconds(calendar, (int) Duration.m3488getInWholeSecondsimpl(j)).getTime();
        Intrinsics.checkNotNullExpressionValue(time2, "getTime(...)");
        this(time, time2);
    }

    public final boolean contains(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return RangesKt.rangeUntil(this.startDate, this.endDate).contains(date);
    }

    @Nullable
    public final DateRange intersection(@NotNull DateRange range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (this.startDate.compareTo(range.endDate) > 0 || this.endDate.compareTo(range.startDate) < 0) {
            return null;
        }
        return new DateRange((Date) ComparisonsKt.maxOf(this.startDate, range.startDate), (Date) ComparisonsKt.minOf(this.endDate, range.endDate));
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0002J\u001e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/automation/DateRange$Companion;", "", "()V", "intervalWithOffset", "Lcom/urbanairship/automation/DateRange;", "calendar", "Lcom/urbanairship/automation/AirshipCalendar;", "date", "Ljava/util/Date;", "timeRange", "Lcom/urbanairship/automation/Rule$TimeRange;", "addingDays", "", "today", "tomorrow", "yesterday", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final DateRange today(@NotNull AirshipCalendar calendar, @NotNull Date date, @NotNull Rule.TimeRange timeRange) {
            Intrinsics.checkNotNullParameter(calendar, "calendar");
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(timeRange, "timeRange");
            return intervalWithOffset(calendar, date, timeRange, 0);
        }

        @NotNull
        public final DateRange yesterday(@NotNull AirshipCalendar calendar, @NotNull Date date, @NotNull Rule.TimeRange timeRange) {
            Intrinsics.checkNotNullParameter(calendar, "calendar");
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(timeRange, "timeRange");
            return intervalWithOffset(calendar, date, timeRange, -1);
        }

        @NotNull
        public final DateRange tomorrow(@NotNull AirshipCalendar calendar, @NotNull Date date, @NotNull Rule.TimeRange timeRange) {
            Intrinsics.checkNotNullParameter(calendar, "calendar");
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(timeRange, "timeRange");
            return intervalWithOffset(calendar, date, timeRange, 1);
        }

        private final DateRange intervalWithOffset(AirshipCalendar calendar, Date date, Rule.TimeRange timeRange, int addingDays) {
            int i = timeRange.getStart() > timeRange.getEnd() ? addingDays + 1 : addingDays;
            Date time = calendar.startOfDay(date, addingDays).getTime();
            Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
            Date time2 = calendar.dateCalendar$urbanairship_automation_release(time, timeRange.getStartHour$urbanairship_automation_release(), timeRange.getStartMinute$urbanairship_automation_release()).getTime();
            Intrinsics.checkNotNullExpressionValue(time2, "getTime(...)");
            Date time3 = calendar.startOfDay(date, i).getTime();
            Intrinsics.checkNotNullExpressionValue(time3, "getTime(...)");
            Date time4 = calendar.dateCalendar$urbanairship_automation_release(time3, timeRange.getEndHour$urbanairship_automation_release(), timeRange.getEndMinute$urbanairship_automation_release()).getTime();
            Intrinsics.checkNotNullExpressionValue(time4, "getTime(...)");
            return new DateRange(time2, time4);
        }
    }
}
