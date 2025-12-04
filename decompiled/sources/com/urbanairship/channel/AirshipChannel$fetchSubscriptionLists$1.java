package com.urbanairship.channel;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class AirshipChannel$fetchSubscriptionLists$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AirshipChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AirshipChannel$fetchSubscriptionLists$1(AirshipChannel airshipChannel, Continuation continuation) {
        super(continuation);
        this.this$0 = airshipChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM2828fetchSubscriptionListsIoAF18A$suspendImpl = AirshipChannel.m2828fetchSubscriptionListsIoAF18A$suspendImpl(this.this$0, this);
        return objM2828fetchSubscriptionListsIoAF18A$suspendImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2828fetchSubscriptionListsIoAF18A$suspendImpl : Result.m2967boximpl(objM2828fetchSubscriptionListsIoAF18A$suspendImpl);
    }
}
