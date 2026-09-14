package com.urbanairship.experiment;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
final class ExperimentManager$evaluateExperiments$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExperimentManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExperimentManager$evaluateExperiments$1(ExperimentManager experimentManager, Continuation continuation) {
        super(continuation);
        this.this$0 = experimentManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM5085evaluateExperiments0E7RQCE$suspendImpl = ExperimentManager.m5085evaluateExperiments0E7RQCE$suspendImpl(this.this$0, null, null, this);
        return objM5085evaluateExperiments0E7RQCE$suspendImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM5085evaluateExperiments0E7RQCE$suspendImpl : Result.m5276boximpl(objM5085evaluateExperiments0E7RQCE$suspendImpl);
    }
}
