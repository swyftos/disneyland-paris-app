package com.urbanairship.automation.limits;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class FrequencyLimitManager$setConstraints$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FrequencyLimitManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FrequencyLimitManager$setConstraints$1(FrequencyLimitManager frequencyLimitManager, Continuation continuation) {
        super(continuation);
        this.this$0 = frequencyLimitManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM2816setConstraintsgIAlus = this.this$0.m2816setConstraintsgIAlus(null, this);
        return objM2816setConstraintsgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2816setConstraintsgIAlus : Result.m2967boximpl(objM2816setConstraintsgIAlus);
    }
}
