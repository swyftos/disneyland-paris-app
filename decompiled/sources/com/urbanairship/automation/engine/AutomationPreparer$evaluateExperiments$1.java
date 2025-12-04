package com.urbanairship.automation.engine;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class AutomationPreparer$evaluateExperiments$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AutomationPreparer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutomationPreparer$evaluateExperiments$1(AutomationPreparer automationPreparer, Continuation continuation) {
        super(continuation);
        this.this$0 = automationPreparer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM2805evaluateExperiments0E7RQCE = this.this$0.m2805evaluateExperiments0E7RQCE(null, null, this);
        return objM2805evaluateExperiments0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2805evaluateExperiments0E7RQCE : Result.m2967boximpl(objM2805evaluateExperiments0E7RQCE);
    }
}
