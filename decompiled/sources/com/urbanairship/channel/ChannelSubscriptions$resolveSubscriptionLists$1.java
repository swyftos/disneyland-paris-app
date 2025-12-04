package com.urbanairship.channel;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class ChannelSubscriptions$resolveSubscriptionLists$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChannelSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelSubscriptions$resolveSubscriptionLists$1(ChannelSubscriptions channelSubscriptions, Continuation continuation) {
        super(continuation);
        this.this$0 = channelSubscriptions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM2835resolveSubscriptionListsgIAlus = this.this$0.m2835resolveSubscriptionListsgIAlus(null, this);
        return objM2835resolveSubscriptionListsgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2835resolveSubscriptionListsgIAlus : Result.m2967boximpl(objM2835resolveSubscriptionListsgIAlus);
    }
}
