package com.urbanairship.featureflag;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
final class FlagDeferredResolver$resolve$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlagDeferredResolver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlagDeferredResolver$resolve$1(FlagDeferredResolver flagDeferredResolver, Continuation continuation) {
        super(continuation);
        this.this$0 = flagDeferredResolver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM5111resolve0E7RQCE = this.this$0.m5111resolve0E7RQCE(null, null, this);
        return objM5111resolve0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM5111resolve0E7RQCE : Result.m5276boximpl(objM5111resolve0E7RQCE);
    }
}
