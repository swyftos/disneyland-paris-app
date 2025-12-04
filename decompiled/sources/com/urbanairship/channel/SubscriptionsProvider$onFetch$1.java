package com.urbanairship.channel;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class SubscriptionsProvider$onFetch$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SubscriptionsProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubscriptionsProvider$onFetch$1(SubscriptionsProvider subscriptionsProvider, Continuation continuation) {
        super(continuation);
        this.this$0 = subscriptionsProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo2837onFetchgIAlus = this.this$0.mo2837onFetchgIAlus(null, this);
        return objMo2837onFetchgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo2837onFetchgIAlus : Result.m2967boximpl(objMo2837onFetchgIAlus);
    }
}
