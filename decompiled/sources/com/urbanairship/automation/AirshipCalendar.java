package com.urbanairship.automation;

import com.urbanairship.automation.DateRange;
import com.urbanairship.automation.Rule;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u001c\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014J.\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00142\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0014J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/automation/AirshipCalendar;", "", "timeZone", "Ljava/util/TimeZone;", "(Ljava/util/TimeZone;)V", "calendar", "Ljava/util/Calendar;", "dateCalendar", "date", "Ljava/util/Date;", "hour", "", "minute", "dateCalendar$urbanairship_automation_release", "dateInterval", "Lcom/urbanairship/automation/DateRange;", "timeRange", "Lcom/urbanairship/automation/Rule$TimeRange;", "nextDate", "weekdays", "", "months", "days", "remainingDay", "startOfDay", "addingDays", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExecutionWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/AirshipCalendar\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,891:1\n1#2:892\n1#2:909\n288#3,2:893\n288#3,2:895\n288#3,2:897\n1603#3,9:899\n1855#3:908\n1856#3:910\n1612#3:911\n*S KotlinDebug\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/AirshipCalendar\n*L\n731#1:909\n672#1:893,2\n704#1:895,2\n708#1:897,2\n731#1:899,9\n731#1:908\n731#1:910\n731#1:911\n*E\n"})
/* loaded from: classes5.dex */
public final class AirshipCalendar {
    private final Calendar calendar;

    public AirshipCalendar(@NotNull TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Calendar calendar = Calendar.getInstance(timeZone);
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance(...)");
        this.calendar = calendar;
    }

    public static /* synthetic */ Calendar startOfDay$default(AirshipCalendar airshipCalendar, Date date, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return airshipCalendar.startOfDay(date, i);
    }

    @NotNull
    public final Calendar startOfDay(@NotNull Date date, int addingDays) {
        Intrinsics.checkNotNullParameter(date, "date");
        Calendar calendarStartOfDay = ExecutionWindowKt.startOfDay(this.calendar, date);
        calendarStartOfDay.add(6, addingDays);
        return calendarStartOfDay;
    }

    @NotNull
    public final DateRange remainingDay(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        Date time = ExecutionWindowKt.copyForDate(this.calendar, date).getTime();
        Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
        Date time2 = startOfDay(date, 1).getTime();
        Intrinsics.checkNotNullExpressionValue(time2, "getTime(...)");
        return new DateRange(time, time2);
    }

    @NotNull
    public final Calendar dateCalendar$urbanairship_automation_release(@NotNull Date date, int hour, int minute) {
        Intrinsics.checkNotNullParameter(date, "date");
        Calendar calendarStartOfDay$default = startOfDay$default(this, date, 0, 2, null);
        calendarStartOfDay$default.set(11, hour);
        calendarStartOfDay$default.set(12, minute);
        calendarStartOfDay$default.set(13, 0);
        calendarStartOfDay$default.set(14, 0);
        return calendarStartOfDay$default;
    }

    @NotNull
    public final DateRange dateInterval(@NotNull Date date, @NotNull Rule.TimeRange timeRange) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(timeRange, "timeRange");
        if (timeRange.getStart() == timeRange.getEnd()) {
            Calendar calendarDateCalendar$urbanairship_automation_release = dateCalendar$urbanairship_automation_release(date, timeRange.getStartHour$urbanairship_automation_release(), timeRange.getStartMinute$urbanairship_automation_release());
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (Intrinsics.areEqual(calendarDateCalendar$urbanairship_automation_release.getTime(), date)) {
                Duration.Companion companion = Duration.INSTANCE;
                return new DateRange(calendarDateCalendar$urbanairship_automation_release, DurationKt.toDuration(1, DurationUnit.SECONDS), defaultConstructorMarker);
            }
            Date time = startOfDay(date, 1).getTime();
            Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
            Calendar calendarDateCalendar$urbanairship_automation_release2 = dateCalendar$urbanairship_automation_release(time, timeRange.getStartHour$urbanairship_automation_release(), timeRange.getStartMinute$urbanairship_automation_release());
            Duration.Companion companion2 = Duration.INSTANCE;
            return new DateRange(calendarDateCalendar$urbanairship_automation_release2, DurationKt.toDuration(1, DurationUnit.SECONDS), defaultConstructorMarker);
        }
        DateRange.Companion companion3 = DateRange.INSTANCE;
        DateRange dateRangeYesterday = companion3.yesterday(this, date, timeRange);
        if (dateRangeYesterday.contains(date)) {
            return dateRangeYesterday;
        }
        DateRange dateRange = companion3.today(this, date, timeRange);
        return (dateRange.contains(date) || dateRange.getStartDate().compareTo(date) >= 0) ? dateRange : companion3.tomorrow(this, date, timeRange);
    }

    @NotNull
    public final Date nextDate(@NotNull Date date, @NotNull List<Integer> weekdays) {
        Object next;
        int iIntValue;
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(weekdays, "weekdays");
        int i = ExecutionWindowKt.copyForDate(this.calendar, date).get(7);
        List listSorted = CollectionsKt.sorted(weekdays);
        Iterator it = listSorted.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((Number) next).intValue() >= i) {
                break;
            }
        }
        Integer num = (Integer) next;
        if (num != null) {
            iIntValue = num.intValue();
        } else {
            Integer num2 = (Integer) CollectionsKt.firstOrNull(listSorted);
            iIntValue = num2 != null ? num2.intValue() : i;
        }
        int i2 = iIntValue >= i ? iIntValue - i : iIntValue + (7 - i);
        if (i2 <= 0) {
            return date;
        }
        Date time = startOfDay(date, i2).getTime();
        Intrinsics.checkNotNull(time);
        return time;
    }

    @NotNull
    public final Date nextDate(@NotNull Date date, @Nullable List<Integer> months, @Nullable List<Integer> days) {
        List listEmptyList;
        List listEmptyList2;
        Date date2;
        Object next;
        int iIntValue;
        Object next2;
        Intrinsics.checkNotNullParameter(date, "date");
        if ((months == null || !(!months.isEmpty())) && (days == null || !(!days.isEmpty()))) {
            return date;
        }
        Calendar calendarCopyForDate = ExecutionWindowKt.copyForDate(this.calendar, date);
        int i = calendarCopyForDate.get(5);
        int i2 = calendarCopyForDate.get(2);
        if (months == null || (listEmptyList = CollectionsKt.sorted(months)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        if (days == null || (listEmptyList2 = CollectionsKt.sorted(days)) == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        Iterator it = listEmptyList.iterator();
        while (true) {
            date2 = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((Number) next).intValue() >= i2) {
                break;
            }
        }
        Integer num = (Integer) next;
        if (num != null) {
            iIntValue = num.intValue();
        } else {
            Integer num2 = (Integer) CollectionsKt.firstOrNull(listEmptyList);
            iIntValue = num2 != null ? num2.intValue() : i2;
        }
        Iterator it2 = listEmptyList2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
            if (((Number) next2).intValue() >= i) {
                break;
            }
        }
        if (iIntValue == i2) {
            if (listEmptyList2.isEmpty() && next2 == null) {
                return date;
            }
            if (next2 != null) {
                if (((Integer) next2).intValue() == i) {
                    return date;
                }
                Date time = startOfDay(date, ((Number) next2).intValue() - i).getTime();
                Intrinsics.checkNotNull(time);
                return time;
            }
        }
        Integer num3 = (Integer) CollectionsKt.firstOrNull(listEmptyList2);
        if (num3 == null) {
            num3 = 1;
        }
        if (listEmptyList.isEmpty()) {
            Calendar calendarNextMatching$default = ExecutionWindowKt.nextMatching$default(calendarCopyForDate, date, null, num3.intValue(), 2, null);
            if (calendarNextMatching$default == null) {
                calendarNextMatching$default = ExecutionWindowKt.distantFuture(calendarCopyForDate);
            }
            Date time2 = calendarNextMatching$default.getTime();
            Intrinsics.checkNotNullExpressionValue(time2, "getTime(...)");
            return time2;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it3 = listEmptyList.iterator();
        while (it3.hasNext()) {
            Calendar calendarNextMatching = ExecutionWindowKt.nextMatching(calendarCopyForDate, date, Integer.valueOf(((Number) it3.next()).intValue()), num3.intValue());
            if (calendarNextMatching != null) {
                arrayList.add(calendarNextMatching);
            }
        }
        Iterator it4 = arrayList.iterator();
        if (it4.hasNext()) {
            Date time3 = ((Calendar) it4.next()).getTime();
            loop3: while (true) {
                date2 = time3;
                while (it4.hasNext()) {
                    time3 = ((Calendar) it4.next()).getTime();
                    if (date2.compareTo(time3) > 0) {
                        break;
                    }
                }
            }
        }
        if (date2 != null) {
            return date2;
        }
        Date time4 = ExecutionWindowKt.distantFuture(calendarCopyForDate).getTime();
        Intrinsics.checkNotNullExpressionValue(time4, "getTime(...)");
        return time4;
    }
}
