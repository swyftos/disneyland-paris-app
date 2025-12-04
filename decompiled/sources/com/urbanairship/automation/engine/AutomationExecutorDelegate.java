package com.urbanairship.automation.engine;

import androidx.annotation.MainThread;
import com.urbanairship.automation.AutomationSchedule;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0007H'¢\u0006\u0002\u0010\u0010¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/urbanairship/automation/engine/AutomationExecutorDelegate;", "ExecutionData", "", "execute", "Lcom/urbanairship/automation/engine/ScheduleExecuteResult;", "data", "preparedScheduleInfo", "Lcom/urbanairship/automation/engine/PreparedScheduleInfo;", "(Ljava/lang/Object;Lcom/urbanairship/automation/engine/PreparedScheduleInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "interrupted", "Lcom/urbanairship/automation/engine/InterruptedBehavior;", "schedule", "Lcom/urbanairship/automation/AutomationSchedule;", "(Lcom/urbanairship/automation/AutomationSchedule;Lcom/urbanairship/automation/engine/PreparedScheduleInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isReady", "Lcom/urbanairship/automation/engine/ScheduleReadyResult;", "(Ljava/lang/Object;Lcom/urbanairship/automation/engine/PreparedScheduleInfo;)Lcom/urbanairship/automation/engine/ScheduleReadyResult;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AutomationExecutorDelegate<ExecutionData> {
    @MainThread
    @Nullable
    Object execute(ExecutionData executiondata, @NotNull PreparedScheduleInfo preparedScheduleInfo, @NotNull Continuation<? super ScheduleExecuteResult> continuation);

    @Nullable
    Object interrupted(@NotNull AutomationSchedule automationSchedule, @NotNull PreparedScheduleInfo preparedScheduleInfo, @NotNull Continuation<? super InterruptedBehavior> continuation);

    @MainThread
    @NotNull
    ScheduleReadyResult isReady(ExecutionData data, @NotNull PreparedScheduleInfo preparedScheduleInfo);
}
