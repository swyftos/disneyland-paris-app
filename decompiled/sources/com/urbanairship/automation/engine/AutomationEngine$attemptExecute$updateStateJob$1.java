package com.urbanairship.automation.engine;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
final class AutomationEngine$attemptExecute$updateStateJob$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ PreparedSchedule $preparedSchedule;
    int label;
    final /* synthetic */ AutomationEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutomationEngine$attemptExecute$updateStateJob$1(AutomationEngine automationEngine, PreparedSchedule preparedSchedule, Continuation continuation) {
        super(2, continuation);
        this.this$0 = automationEngine;
        this.$preparedSchedule = preparedSchedule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AutomationEngine$attemptExecute$updateStateJob$1(this.this$0, this.$preparedSchedule, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AutomationEngine$attemptExecute$updateStateJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AutomationEngine automationEngine = this.this$0;
            String scheduleId$urbanairship_automation_release = this.$preparedSchedule.getInfo$urbanairship_automation_release().getScheduleId$urbanairship_automation_release();
            final AutomationEngine automationEngine2 = this.this$0;
            Function1 function1 = new Function1() { // from class: com.urbanairship.automation.engine.AutomationEngine$attemptExecute$updateStateJob$1.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final AutomationScheduleData invoke(AutomationScheduleData it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.executing$urbanairship_automation_release(automationEngine2.clock.currentTimeMillis());
                }
            };
            this.label = 1;
            if (automationEngine.updateState(scheduleId$urbanairship_automation_release, function1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
