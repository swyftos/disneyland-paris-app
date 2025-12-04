package com.urbanairship.automation.engine;

import androidx.annotation.MainThread;
import com.urbanairship.automation.AutomationSchedule;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/urbanairship/automation/engine/AutomationExecutorInterface;", "", "execute", "Lcom/urbanairship/automation/engine/ScheduleExecuteResult;", "preparedSchedule", "Lcom/urbanairship/automation/engine/PreparedSchedule;", "(Lcom/urbanairship/automation/engine/PreparedSchedule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "interrupted", "Lcom/urbanairship/automation/engine/InterruptedBehavior;", "schedule", "Lcom/urbanairship/automation/AutomationSchedule;", "preparedScheduleInfo", "Lcom/urbanairship/automation/engine/PreparedScheduleInfo;", "(Lcom/urbanairship/automation/AutomationSchedule;Lcom/urbanairship/automation/engine/PreparedScheduleInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isReady", "Lcom/urbanairship/automation/engine/ScheduleReadyResult;", "isValid", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AutomationExecutorInterface {
    @Nullable
    Object execute(@NotNull PreparedSchedule preparedSchedule, @NotNull Continuation<? super ScheduleExecuteResult> continuation);

    @Nullable
    Object interrupted(@NotNull AutomationSchedule automationSchedule, @NotNull PreparedScheduleInfo preparedScheduleInfo, @NotNull Continuation<? super InterruptedBehavior> continuation);

    @MainThread
    @NotNull
    ScheduleReadyResult isReady(@NotNull PreparedSchedule preparedSchedule);

    boolean isValid(@NotNull AutomationSchedule schedule);
}
