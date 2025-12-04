package com.urbanairship.util;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class AutoRefreshingDataProvider$fetch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AutoRefreshingDataProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutoRefreshingDataProvider$fetch$1(AutoRefreshingDataProvider autoRefreshingDataProvider, Continuation continuation) {
        super(continuation);
        this.this$0 = autoRefreshingDataProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM2947fetch0E7RQCE = this.this$0.m2947fetch0E7RQCE(null, null, this);
        return objM2947fetch0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2947fetch0E7RQCE : Result.m2967boximpl(objM2947fetch0E7RQCE);
    }
}
