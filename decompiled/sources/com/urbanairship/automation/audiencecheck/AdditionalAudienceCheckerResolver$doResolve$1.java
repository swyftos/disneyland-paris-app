package com.urbanairship.automation.audiencecheck;

import java.security.InvalidParameterException;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class AdditionalAudienceCheckerResolver$doResolve$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdditionalAudienceCheckerResolver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdditionalAudienceCheckerResolver$doResolve$1(AdditionalAudienceCheckerResolver additionalAudienceCheckerResolver, Continuation continuation) {
        super(continuation);
        this.this$0 = additionalAudienceCheckerResolver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws InvalidParameterException {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM2797doResolveBWLJW6A = this.this$0.m2797doResolveBWLJW6A(null, null, null, this);
        return objM2797doResolveBWLJW6A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2797doResolveBWLJW6A : Result.m2967boximpl(objM2797doResolveBWLJW6A);
    }
}
