package com.urbanairship.channel;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class ChannelRegistrar$updateRegistration$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChannelRegistrar this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelRegistrar$updateRegistration$1(ChannelRegistrar channelRegistrar, Continuation continuation) {
        super(continuation);
        this.this$0 = channelRegistrar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateRegistration$urbanairship_core_release(this);
    }
}
