package com.urbanairship.automation.remotedata;

import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.automation.InAppAutomationRemoteDataStatus;
import com.urbanairship.remotedata.RemoteDataSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H¦@¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H¦@¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0016\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H¦@¢\u0006\u0002\u0010\u0011R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\t¨\u0006\u001bÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/automation/remotedata/AutomationRemoteDataAccessInterface;", "", "status", "Lcom/urbanairship/automation/InAppAutomationRemoteDataStatus;", "getStatus", "()Lcom/urbanairship/automation/InAppAutomationRemoteDataStatus;", "statusUpdates", "Lkotlinx/coroutines/flow/Flow;", "getStatusUpdates", "()Lkotlinx/coroutines/flow/Flow;", "updatesFlow", "Lcom/urbanairship/automation/remotedata/InAppRemoteData;", "getUpdatesFlow", "bestEffortRefresh", "", "schedule", "Lcom/urbanairship/automation/AutomationSchedule;", "(Lcom/urbanairship/automation/AutomationSchedule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "contactIdFor", "", "isCurrent", "notifyOutdated", "", "requiredUpdate", "sourceFor", "Lcom/urbanairship/remotedata/RemoteDataSource;", "waitForFullRefresh", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AutomationRemoteDataAccessInterface {
    @Nullable
    Object bestEffortRefresh(@NotNull AutomationSchedule automationSchedule, @NotNull Continuation<? super Boolean> continuation);

    @Nullable
    String contactIdFor(@NotNull AutomationSchedule schedule);

    @NotNull
    InAppAutomationRemoteDataStatus getStatus();

    @NotNull
    Flow<InAppAutomationRemoteDataStatus> getStatusUpdates();

    @NotNull
    Flow<InAppRemoteData> getUpdatesFlow();

    boolean isCurrent(@NotNull AutomationSchedule schedule);

    @Nullable
    Object notifyOutdated(@NotNull AutomationSchedule automationSchedule, @NotNull Continuation<? super Unit> continuation);

    boolean requiredUpdate(@NotNull AutomationSchedule schedule);

    @Nullable
    RemoteDataSource sourceFor(@NotNull AutomationSchedule schedule);

    @Nullable
    Object waitForFullRefresh(@NotNull AutomationSchedule automationSchedule, @NotNull Continuation<? super Unit> continuation);
}
