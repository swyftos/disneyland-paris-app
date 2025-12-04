package com.urbanairship.automation;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\u0019\u0010\b\u001a\u00020\t*\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u000b\u001a/\u0010\f\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0011"}, d2 = {"addingSeconds", "Ljava/util/Calendar;", "seconds", "", "copyForDate", "date", "Ljava/util/Date;", "distantFuture", "durationSince", "Lkotlin/time/Duration;", ETCPaymentMethod.OTHER, "(Ljava/util/Date;Ljava/util/Date;)J", "nextMatching", "month", "day", "(Ljava/util/Calendar;Ljava/util/Date;Ljava/lang/Integer;I)Ljava/util/Calendar;", "startOfDay", "urbanairship-automation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExecutionWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/ExecutionWindowKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,891:1\n1#2:892\n*E\n"})
/* loaded from: classes5.dex */
public final class ExecutionWindowKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Calendar startOfDay(Calendar calendar, Date date) {
        Object objClone = calendar.clone();
        Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar2 = (Calendar) objClone;
        calendar2.setTimeInMillis(date.getTime());
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        return calendar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Calendar copyForDate(Calendar calendar, Date date) {
        Object objClone = calendar.clone();
        Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar2 = (Calendar) objClone;
        calendar2.setTimeInMillis(date.getTime());
        return calendar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Calendar addingSeconds(Calendar calendar, int i) {
        calendar.add(13, i);
        return calendar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Calendar distantFuture(Calendar calendar) {
        calendar.add(1, 1);
        return calendar;
    }

    static /* synthetic */ Calendar nextMatching$default(Calendar calendar, Date date, Integer num, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        return nextMatching(calendar, date, num, i);
    }

    private static final boolean nextMatching$canAccept(Date date, Integer num, int i, Calendar calendar) {
        if (calendar.getTime().compareTo(date) < 0) {
            return false;
        }
        return (num == null || calendar.get(2) == num.intValue()) && calendar.get(5) == i;
    }

    private static final void nextMatching$setDesiredComponents(Integer num, int i, Calendar calendar) {
        if (num != null) {
            calendar.set(2, num.intValue());
        }
        calendar.set(5, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Calendar nextMatching(Calendar calendar, Date date, Integer num, int i) {
        Calendar calendarStartOfDay = startOfDay(calendar, date);
        nextMatching$setDesiredComponents(num, i, calendarStartOfDay);
        if (nextMatching$canAccept(date, num, i, calendarStartOfDay)) {
            return calendarStartOfDay;
        }
        if (num == null) {
            for (int i2 = 1; i2 < 12; i2++) {
                calendarStartOfDay = copyForDate(calendar, date);
                calendarStartOfDay.add(2, i2);
                nextMatching$setDesiredComponents(num, i, calendarStartOfDay);
                if (nextMatching$canAccept(date, num, i, calendarStartOfDay)) {
                    return calendarStartOfDay;
                }
            }
        }
        calendarStartOfDay.add(1, 1);
        nextMatching$setDesiredComponents(num, i, calendarStartOfDay);
        if (nextMatching$canAccept(date, num, i, calendarStartOfDay)) {
            return calendarStartOfDay;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long durationSince(Date date, Date date2) {
        Duration.Companion companion = Duration.INSTANCE;
        return DurationKt.toDuration(date.getTime() - date2.getTime(), DurationUnit.MILLISECONDS);
    }
}
