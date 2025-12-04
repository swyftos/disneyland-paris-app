package com.urbanairship.channel;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class ChannelApiClient$updateChannel$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChannelApiClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelApiClient$updateChannel$1(ChannelApiClient channelApiClient, Continuation continuation) {
        super(continuation);
        this.this$0 = channelApiClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateChannel$urbanairship_core_release(null, null, this);
    }
}
