package com.urbanairship.contacts;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class Contact$channelExtender$1$extend$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Contact$channelExtender$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Contact$channelExtender$1$extend$1(Contact$channelExtender$1 contact$channelExtender$1, Continuation continuation) {
        super(continuation);
        this.this$0 = contact$channelExtender$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.extend(null, this);
    }
}
