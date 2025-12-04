package com.urbanairship.automation.engine;

import com.urbanairship.UALog;
import com.urbanairship.automation.AutomationDelay;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
final class AutomationEngine$preprocessDelay$2$job$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ AutomationDelay $delay;
    final /* synthetic */ String $scheduleId;
    final /* synthetic */ long $triggerDate;
    int label;
    final /* synthetic */ AutomationEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutomationEngine$preprocessDelay$2$job$1(AutomationEngine automationEngine, AutomationDelay automationDelay, long j, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = automationEngine;
        this.$delay = automationDelay;
        this.$triggerDate = j;
        this.$scheduleId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AutomationEngine$preprocessDelay$2$job$1(this.this$0, this.$delay, this.$triggerDate, this.$scheduleId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AutomationEngine$preprocessDelay$2$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final String str = this.$scheduleId;
            UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationEngine$preprocessDelay$2$job$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Preprocessing delay " + str;
                }
            }, 1, null);
            AutomationDelayProcessorInterface automationDelayProcessorInterface = this.this$0.delayProcessor;
            AutomationDelay automationDelay = this.$delay;
            long j = this.$triggerDate;
            this.label = 1;
            if (automationDelayProcessorInterface.preprocess(automationDelay, j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        final String str2 = this.$scheduleId;
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationEngine$preprocessDelay$2$job$1.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Finished preprocessing delay " + str2;
            }
        }, 1, null);
        return Unit.INSTANCE;
    }
}
