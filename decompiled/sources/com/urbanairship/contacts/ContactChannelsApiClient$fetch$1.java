package com.urbanairship.contacts;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class ContactChannelsApiClient$fetch$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ContactChannelsApiClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContactChannelsApiClient$fetch$1(ContactChannelsApiClient contactChannelsApiClient, Continuation continuation) {
        super(continuation);
        this.this$0 = contactChannelsApiClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetch$urbanairship_core_release(null, this);
    }
}
