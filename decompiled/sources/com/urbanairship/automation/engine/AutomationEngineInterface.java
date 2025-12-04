package com.urbanairship.automation.engine;

import com.facebook.react.uimanager.ViewProps;
import com.urbanairship.automation.AutomationSchedule;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH¦@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH¦@¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0017\u001a\u00020\u0003H&J\u001c\u0010\u0018\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH¦@¢\u0006\u0002\u0010\tJ\u001c\u0010\u0019\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH¦@¢\u0006\u0002\u0010\t¨\u0006\u001bÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/automation/engine/AutomationEngineInterface;", "", "cancelSchedules", "", "group", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "identifiers", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelSchedulesWith", "type", "Lcom/urbanairship/automation/AutomationSchedule$ScheduleType;", "(Lcom/urbanairship/automation/AutomationSchedule$ScheduleType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSchedule", "Lcom/urbanairship/automation/AutomationSchedule;", "identifier", "getSchedules", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEnginePaused", "paused", "", "setExecutionPaused", ViewProps.START, "stopSchedules", "upsertSchedules", "schedules", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AutomationEngineInterface {
    @Nullable
    Object cancelSchedules(@NotNull String str, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object cancelSchedules(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object cancelSchedulesWith(@NotNull AutomationSchedule.ScheduleType scheduleType, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object getSchedule(@NotNull String str, @NotNull Continuation<? super AutomationSchedule> continuation);

    @Nullable
    Object getSchedules(@NotNull String str, @NotNull Continuation<? super List<AutomationSchedule>> continuation);

    @Nullable
    Object getSchedules(@NotNull Continuation<? super List<AutomationSchedule>> continuation);

    void setEnginePaused(boolean paused);

    void setExecutionPaused(boolean paused);

    void start();

    @Nullable
    Object stopSchedules(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object upsertSchedules(@NotNull List<AutomationSchedule> list, @NotNull Continuation<? super Unit> continuation);
}
