package com.urbanairship.featureflag;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
final class FlagDeferredResolver$fetchFlag$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlagDeferredResolver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlagDeferredResolver$fetchFlag$1(FlagDeferredResolver flagDeferredResolver, Continuation continuation) {
        super(continuation);
        this.this$0 = flagDeferredResolver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM5109fetchFlagyxL6bBk = this.this$0.m5109fetchFlagyxL6bBk(null, null, null, false, this);
        return objM5109fetchFlagyxL6bBk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM5109fetchFlagyxL6bBk : Result.m5276boximpl(objM5109fetchFlagyxL6bBk);
    }
}
