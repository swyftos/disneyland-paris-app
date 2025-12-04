package com.urbanairship.automation.audiencecheck;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class AdditionalAudienceCheckerResolver$resolve$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdditionalAudienceCheckerResolver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdditionalAudienceCheckerResolver$resolve$1(AdditionalAudienceCheckerResolver additionalAudienceCheckerResolver, Continuation continuation) {
        super(continuation);
        this.this$0 = additionalAudienceCheckerResolver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM2798resolve0E7RQCE = this.this$0.m2798resolve0E7RQCE(null, null, this);
        return objM2798resolve0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2798resolve0E7RQCE : Result.m2967boximpl(objM2798resolve0E7RQCE);
    }
}
