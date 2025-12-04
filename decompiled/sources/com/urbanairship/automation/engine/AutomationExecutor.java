package com.urbanairship.automation.engine;

import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.automation.AutomationScheduleKt;
import com.urbanairship.automation.engine.PreparedScheduleData;
import com.urbanairship.automation.limits.FrequencyChecker;
import com.urbanairship.automation.remotedata.AutomationRemoteDataAccess;
import com.urbanairship.iam.PreparedInAppMessageData;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0097@¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/automation/engine/AutomationExecutor;", "Lcom/urbanairship/automation/engine/AutomationExecutorInterface;", "actionExecutor", "Lcom/urbanairship/automation/engine/AutomationExecutorDelegate;", "Lcom/urbanairship/json/JsonValue;", "messageExecutor", "Lcom/urbanairship/iam/PreparedInAppMessageData;", "remoteDataAccess", "Lcom/urbanairship/automation/remotedata/AutomationRemoteDataAccess;", "(Lcom/urbanairship/automation/engine/AutomationExecutorDelegate;Lcom/urbanairship/automation/engine/AutomationExecutorDelegate;Lcom/urbanairship/automation/remotedata/AutomationRemoteDataAccess;)V", "execute", "Lcom/urbanairship/automation/engine/ScheduleExecuteResult;", "preparedSchedule", "Lcom/urbanairship/automation/engine/PreparedSchedule;", "(Lcom/urbanairship/automation/engine/PreparedSchedule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "interrupted", "Lcom/urbanairship/automation/engine/InterruptedBehavior;", "schedule", "Lcom/urbanairship/automation/AutomationSchedule;", "preparedScheduleInfo", "Lcom/urbanairship/automation/engine/PreparedScheduleInfo;", "(Lcom/urbanairship/automation/AutomationSchedule;Lcom/urbanairship/automation/engine/PreparedScheduleInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isReady", "Lcom/urbanairship/automation/engine/ScheduleReadyResult;", "isValid", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AutomationExecutor implements AutomationExecutorInterface {
    private final AutomationExecutorDelegate actionExecutor;
    private final AutomationExecutorDelegate messageExecutor;
    private final AutomationRemoteDataAccess remoteDataAccess;

    /* renamed from: com.urbanairship.automation.engine.AutomationExecutor$execute$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationExecutor.this.execute(null, this);
        }
    }

    public AutomationExecutor(@NotNull AutomationExecutorDelegate<JsonValue> actionExecutor, @NotNull AutomationExecutorDelegate<PreparedInAppMessageData> messageExecutor, @NotNull AutomationRemoteDataAccess remoteDataAccess) {
        Intrinsics.checkNotNullParameter(actionExecutor, "actionExecutor");
        Intrinsics.checkNotNullParameter(messageExecutor, "messageExecutor");
        Intrinsics.checkNotNullParameter(remoteDataAccess, "remoteDataAccess");
        this.actionExecutor = actionExecutor;
        this.messageExecutor = messageExecutor;
        this.remoteDataAccess = remoteDataAccess;
    }

    @Override // com.urbanairship.automation.engine.AutomationExecutorInterface
    public boolean isValid(@NotNull AutomationSchedule schedule) {
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        return this.remoteDataAccess.isCurrent(schedule);
    }

    @Override // com.urbanairship.automation.engine.AutomationExecutorInterface
    @NotNull
    public ScheduleReadyResult isReady(@NotNull PreparedSchedule preparedSchedule) {
        Intrinsics.checkNotNullParameter(preparedSchedule, "preparedSchedule");
        FrequencyChecker frequencyChecker$urbanairship_automation_release = preparedSchedule.getFrequencyChecker$urbanairship_automation_release();
        if (frequencyChecker$urbanairship_automation_release != null && !frequencyChecker$urbanairship_automation_release.checkAndIncrement()) {
            return ScheduleReadyResult.SKIP;
        }
        PreparedScheduleData data$urbanairship_automation_release = preparedSchedule.getData$urbanairship_automation_release();
        if (data$urbanairship_automation_release instanceof PreparedScheduleData.Action) {
            return this.actionExecutor.isReady(((PreparedScheduleData.Action) preparedSchedule.getData$urbanairship_automation_release()).getJson(), preparedSchedule.getInfo$urbanairship_automation_release());
        }
        if (data$urbanairship_automation_release instanceof PreparedScheduleData.InAppMessage) {
            return this.messageExecutor.isReady(((PreparedScheduleData.InAppMessage) preparedSchedule.getData$urbanairship_automation_release()).getMessage(), preparedSchedule.getInfo$urbanairship_automation_release());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.urbanairship.automation.engine.AutomationExecutorInterface
    @androidx.annotation.MainThread
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(@org.jetbrains.annotations.NotNull final com.urbanairship.automation.engine.PreparedSchedule r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.automation.engine.ScheduleExecuteResult> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.urbanairship.automation.engine.AutomationExecutor.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.automation.engine.AutomationExecutor$execute$1 r0 = (com.urbanairship.automation.engine.AutomationExecutor.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.engine.AutomationExecutor$execute$1 r0 = new com.urbanairship.automation.engine.AutomationExecutor$execute$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r5 = r0.L$0
            r6 = r5
            com.urbanairship.automation.engine.PreparedSchedule r6 = (com.urbanairship.automation.engine.PreparedSchedule) r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L31
            goto L8c
        L31:
            r5 = move-exception
            goto L95
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            java.lang.Object r5 = r0.L$0
            r6 = r5
            com.urbanairship.automation.engine.PreparedSchedule r6 = (com.urbanairship.automation.engine.PreparedSchedule) r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L31
            goto L6a
        L44:
            kotlin.ResultKt.throwOnFailure(r7)
            com.urbanairship.automation.engine.PreparedScheduleData r7 = r6.getData$urbanairship_automation_release()     // Catch: java.lang.Exception -> L31
            boolean r2 = r7 instanceof com.urbanairship.automation.engine.PreparedScheduleData.Action     // Catch: java.lang.Exception -> L31
            if (r2 == 0) goto L6d
            com.urbanairship.automation.engine.AutomationExecutorDelegate r5 = r5.actionExecutor     // Catch: java.lang.Exception -> L31
            com.urbanairship.automation.engine.PreparedScheduleData r7 = r6.getData$urbanairship_automation_release()     // Catch: java.lang.Exception -> L31
            com.urbanairship.automation.engine.PreparedScheduleData$Action r7 = (com.urbanairship.automation.engine.PreparedScheduleData.Action) r7     // Catch: java.lang.Exception -> L31
            com.urbanairship.json.JsonValue r7 = r7.getJson()     // Catch: java.lang.Exception -> L31
            com.urbanairship.automation.engine.PreparedScheduleInfo r2 = r6.getInfo$urbanairship_automation_release()     // Catch: java.lang.Exception -> L31
            r0.L$0 = r6     // Catch: java.lang.Exception -> L31
            r0.label = r4     // Catch: java.lang.Exception -> L31
            java.lang.Object r7 = r5.execute(r7, r2, r0)     // Catch: java.lang.Exception -> L31
            if (r7 != r1) goto L6a
            return r1
        L6a:
            com.urbanairship.automation.engine.ScheduleExecuteResult r7 = (com.urbanairship.automation.engine.ScheduleExecuteResult) r7     // Catch: java.lang.Exception -> L31
            goto L9f
        L6d:
            boolean r7 = r7 instanceof com.urbanairship.automation.engine.PreparedScheduleData.InAppMessage     // Catch: java.lang.Exception -> L31
            if (r7 == 0) goto L8f
            com.urbanairship.automation.engine.AutomationExecutorDelegate r5 = r5.messageExecutor     // Catch: java.lang.Exception -> L31
            com.urbanairship.automation.engine.PreparedScheduleData r7 = r6.getData$urbanairship_automation_release()     // Catch: java.lang.Exception -> L31
            com.urbanairship.automation.engine.PreparedScheduleData$InAppMessage r7 = (com.urbanairship.automation.engine.PreparedScheduleData.InAppMessage) r7     // Catch: java.lang.Exception -> L31
            com.urbanairship.iam.PreparedInAppMessageData r7 = r7.getMessage()     // Catch: java.lang.Exception -> L31
            com.urbanairship.automation.engine.PreparedScheduleInfo r2 = r6.getInfo$urbanairship_automation_release()     // Catch: java.lang.Exception -> L31
            r0.L$0 = r6     // Catch: java.lang.Exception -> L31
            r0.label = r3     // Catch: java.lang.Exception -> L31
            java.lang.Object r7 = r5.execute(r7, r2, r0)     // Catch: java.lang.Exception -> L31
            if (r7 != r1) goto L8c
            return r1
        L8c:
            com.urbanairship.automation.engine.ScheduleExecuteResult r7 = (com.urbanairship.automation.engine.ScheduleExecuteResult) r7     // Catch: java.lang.Exception -> L31
            goto L9f
        L8f:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException     // Catch: java.lang.Exception -> L31
            r5.<init>()     // Catch: java.lang.Exception -> L31
            throw r5     // Catch: java.lang.Exception -> L31
        L95:
            com.urbanairship.automation.engine.AutomationExecutor$execute$2 r7 = new com.urbanairship.automation.engine.AutomationExecutor$execute$2
            r7.<init>()
            com.urbanairship.UALog.e(r5, r7)
            com.urbanairship.automation.engine.ScheduleExecuteResult r7 = com.urbanairship.automation.engine.ScheduleExecuteResult.RETRY
        L9f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationExecutor.execute(com.urbanairship.automation.engine.PreparedSchedule, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.urbanairship.automation.engine.AutomationExecutorInterface
    @Nullable
    public Object interrupted(@NotNull AutomationSchedule automationSchedule, @NotNull PreparedScheduleInfo preparedScheduleInfo, @NotNull Continuation<? super InterruptedBehavior> continuation) {
        if (AutomationScheduleKt.isInAppMessageType(automationSchedule)) {
            return this.messageExecutor.interrupted(automationSchedule, preparedScheduleInfo, continuation);
        }
        return this.actionExecutor.interrupted(automationSchedule, preparedScheduleInfo, continuation);
    }
}
