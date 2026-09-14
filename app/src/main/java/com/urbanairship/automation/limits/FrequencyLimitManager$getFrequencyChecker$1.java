package com.urbanairship.automation.limits;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
final class FrequencyLimitManager$getFrequencyChecker$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FrequencyLimitManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FrequencyLimitManager$getFrequencyChecker$1(FrequencyLimitManager frequencyLimitManager, Continuation continuation) {
        super(continuation);
        this.this$0 = frequencyLimitManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM5057getFrequencyCheckergIAlus = this.this$0.m5057getFrequencyCheckergIAlus(null, this);
        return objM5057getFrequencyCheckergIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM5057getFrequencyCheckergIAlus : Result.m5276boximpl(objM5057getFrequencyCheckergIAlus);
    }
}
