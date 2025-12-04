package com.urbanairship.channel;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class ChannelAuthTokenProvider$fetchToken$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChannelAuthTokenProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelAuthTokenProvider$fetchToken$1(ChannelAuthTokenProvider channelAuthTokenProvider, Continuation continuation) {
        super(continuation);
        this.this$0 = channelAuthTokenProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo2833fetchTokengIAlus = this.this$0.mo2833fetchTokengIAlus(null, this);
        return objMo2833fetchTokengIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo2833fetchTokengIAlus : Result.m2967boximpl(objMo2833fetchTokengIAlus);
    }
}
