package com.urbanairship.automation.engine;

import com.urbanairship.util.TaskSleeper;
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
final class AutomationEngine$handleInterval$2 extends SuspendLambda implements Function2 {
    final /* synthetic */ long $interval;
    final /* synthetic */ String $scheduleID;
    int label;
    final /* synthetic */ AutomationEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutomationEngine$handleInterval$2(AutomationEngine automationEngine, long j, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = automationEngine;
        this.$interval = j;
        this.$scheduleID = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AutomationEngine$handleInterval$2(this.this$0, this.$interval, this.$scheduleID, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AutomationEngine$handleInterval$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TaskSleeper taskSleeper = this.this$0.sleeper;
            long j = this.$interval;
            this.label = 1;
            if (taskSleeper.m2958sleepVtjQ1oo(j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        final AutomationEngine automationEngine = this.this$0;
        String str = this.$scheduleID;
        Function1 function1 = new Function1() { // from class: com.urbanairship.automation.engine.AutomationEngine$handleInterval$2.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AutomationScheduleData invoke(AutomationScheduleData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.idle$urbanairship_automation_release(automationEngine.clock.currentTimeMillis());
            }
        };
        this.label = 2;
        if (automationEngine.updateState(str, function1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
