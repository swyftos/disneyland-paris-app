package com.urbanairship.channel;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
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
        Object objMo5079onFetchgIAlus = this.this$0.mo5079onFetchgIAlus(null, this);
        return objMo5079onFetchgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo5079onFetchgIAlus : Result.m5276boximpl(objMo5079onFetchgIAlus);
    }
}
