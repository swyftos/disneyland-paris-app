package com.urbanairship.automation.engine;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH¦@¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH¦@¢\u0006\u0002\u0010\u000eJ\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH¦@¢\u0006\u0002\u0010\tJ,\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0011H¦@¢\u0006\u0002\u0010\u0012J>\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u000b0\u0014H¦@¢\u0006\u0002\u0010\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/urbanairship/automation/engine/ScheduleStoreInterface;", "", "deleteSchedules", "", "group", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ids", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSchedule", "Lcom/urbanairship/automation/engine/AutomationScheduleData;", "id", "getSchedules", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSchedule", "closure", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertSchedules", "Lkotlin/Function2;", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ScheduleStoreInterface {
    @Nullable
    Object deleteSchedules(@NotNull String str, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object deleteSchedules(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object getSchedule(@NotNull String str, @NotNull Continuation<? super AutomationScheduleData> continuation);

    @Nullable
    Object getSchedules(@NotNull String str, @NotNull Continuation<? super List<AutomationScheduleData>> continuation);

    @Nullable
    Object getSchedules(@NotNull List<String> list, @NotNull Continuation<? super List<AutomationScheduleData>> continuation);

    @Nullable
    Object getSchedules(@NotNull Continuation<? super List<AutomationScheduleData>> continuation);

    @Nullable
    Object updateSchedule(@NotNull String str, @NotNull Function1<? super AutomationScheduleData, AutomationScheduleData> function1, @NotNull Continuation<? super AutomationScheduleData> continuation);

    @Nullable
    Object upsertSchedules(@NotNull List<String> list, @NotNull Function2<? super String, ? super AutomationScheduleData, AutomationScheduleData> function2, @NotNull Continuation<? super List<AutomationScheduleData>> continuation);
}
