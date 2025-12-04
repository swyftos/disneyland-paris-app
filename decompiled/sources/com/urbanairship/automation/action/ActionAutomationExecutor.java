package com.urbanairship.automation.action;

import com.urbanairship.actions.ActionRunner;
import com.urbanairship.actions.DefaultActionRunner;
import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.automation.engine.AutomationExecutorDelegate;
import com.urbanairship.automation.engine.InterruptedBehavior;
import com.urbanairship.automation.engine.PreparedScheduleInfo;
import com.urbanairship.automation.engine.ScheduleExecuteResult;
import com.urbanairship.automation.engine.ScheduleReadyResult;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/automation/action/ActionAutomationExecutor;", "Lcom/urbanairship/automation/engine/AutomationExecutorDelegate;", "Lcom/urbanairship/json/JsonValue;", "actionRunner", "Lcom/urbanairship/actions/ActionRunner;", "(Lcom/urbanairship/actions/ActionRunner;)V", "getActionRunner", "()Lcom/urbanairship/actions/ActionRunner;", "execute", "Lcom/urbanairship/automation/engine/ScheduleExecuteResult;", "data", "preparedScheduleInfo", "Lcom/urbanairship/automation/engine/PreparedScheduleInfo;", "(Lcom/urbanairship/json/JsonValue;Lcom/urbanairship/automation/engine/PreparedScheduleInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "interrupted", "Lcom/urbanairship/automation/engine/InterruptedBehavior;", "schedule", "Lcom/urbanairship/automation/AutomationSchedule;", "(Lcom/urbanairship/automation/AutomationSchedule;Lcom/urbanairship/automation/engine/PreparedScheduleInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isReady", "Lcom/urbanairship/automation/engine/ScheduleReadyResult;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActionAutomationExecutor implements AutomationExecutorDelegate<JsonValue> {
    private final ActionRunner actionRunner;

    /* renamed from: com.urbanairship.automation.action.ActionAutomationExecutor$execute$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ActionAutomationExecutor.this.execute2((JsonValue) null, (PreparedScheduleInfo) null, (Continuation<? super ScheduleExecuteResult>) this);
        }
    }

    public ActionAutomationExecutor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ActionAutomationExecutor(@NotNull ActionRunner actionRunner) {
        Intrinsics.checkNotNullParameter(actionRunner, "actionRunner");
        this.actionRunner = actionRunner;
    }

    public /* synthetic */ ActionAutomationExecutor(ActionRunner actionRunner, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DefaultActionRunner.INSTANCE : actionRunner);
    }

    @Override // com.urbanairship.automation.engine.AutomationExecutorDelegate
    public /* bridge */ /* synthetic */ Object execute(JsonValue jsonValue, PreparedScheduleInfo preparedScheduleInfo, Continuation continuation) {
        return execute2(jsonValue, preparedScheduleInfo, (Continuation<? super ScheduleExecuteResult>) continuation);
    }

    @NotNull
    public final ActionRunner getActionRunner() {
        return this.actionRunner;
    }

    @Override // com.urbanairship.automation.engine.AutomationExecutorDelegate
    @NotNull
    public ScheduleReadyResult isReady(@NotNull JsonValue data, @NotNull PreparedScheduleInfo preparedScheduleInfo) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(preparedScheduleInfo, "preparedScheduleInfo");
        return ScheduleReadyResult.READY;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: execute, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute2(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r9, @org.jetbrains.annotations.NotNull com.urbanairship.automation.engine.PreparedScheduleInfo r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.automation.engine.ScheduleExecuteResult> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.urbanairship.automation.action.ActionAutomationExecutor.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r11
            com.urbanairship.automation.action.ActionAutomationExecutor$execute$1 r0 = (com.urbanairship.automation.action.ActionAutomationExecutor.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            com.urbanairship.automation.action.ActionAutomationExecutor$execute$1 r0 = new com.urbanairship.automation.action.ActionAutomationExecutor$execute$1
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            kotlin.ResultKt.throwOnFailure(r11)
            goto L60
        L2b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L33:
            kotlin.ResultKt.throwOnFailure(r11)
            boolean r10 = r10.getAdditionalAudienceCheckResult$urbanairship_automation_release()
            if (r10 != 0) goto L3f
            com.urbanairship.automation.engine.ScheduleExecuteResult r8 = com.urbanairship.automation.engine.ScheduleExecuteResult.FINISHED
            return r8
        L3f:
            com.urbanairship.actions.ActionRunner r1 = r8.actionRunner
            com.urbanairship.json.JsonMap r8 = r9.optMap()
            java.util.Map r8 = r8.getMap()
            java.lang.String r9 = "getMap(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            r9 = 6
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            r5.label = r2
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r8
            java.lang.Object r8 = com.urbanairship.actions.ActionRunnerKt.runSuspending$default(r1, r2, r3, r4, r5, r6, r7)
            if (r8 != r0) goto L60
            return r0
        L60:
            com.urbanairship.automation.engine.ScheduleExecuteResult r8 = com.urbanairship.automation.engine.ScheduleExecuteResult.FINISHED
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.action.ActionAutomationExecutor.execute2(com.urbanairship.json.JsonValue, com.urbanairship.automation.engine.PreparedScheduleInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.urbanairship.automation.engine.AutomationExecutorDelegate
    @Nullable
    public Object interrupted(@NotNull AutomationSchedule automationSchedule, @NotNull PreparedScheduleInfo preparedScheduleInfo, @NotNull Continuation<? super InterruptedBehavior> continuation) {
        return InterruptedBehavior.RETRY;
    }
}
