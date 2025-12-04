package com.urbanairship.experiment;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class ExperimentManager$getExperimentWithId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExperimentManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExperimentManager$getExperimentWithId$1(ExperimentManager experimentManager, Continuation continuation) {
        super(continuation);
        this.this$0 = experimentManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ExperimentManager.getExperimentWithId$suspendImpl(this.this$0, null, null, this);
    }
}
