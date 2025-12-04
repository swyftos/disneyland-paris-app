package com.urbanairship.channel;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class ChannelBatchUpdateManager$uploadPending$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChannelBatchUpdateManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelBatchUpdateManager$uploadPending$1(ChannelBatchUpdateManager channelBatchUpdateManager, Continuation continuation) {
        super(continuation);
        this.this$0 = channelBatchUpdateManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.uploadPending$urbanairship_core_release(null, this);
    }
}
