package com.urbanairship.contacts;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
final class Contact$fetchSubscriptionLists$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Contact this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Contact$fetchSubscriptionLists$1(Contact contact, Continuation continuation) {
        super(continuation);
        this.this$0 = contact;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM5081fetchSubscriptionListsIoAF18A$suspendImpl = Contact.m5081fetchSubscriptionListsIoAF18A$suspendImpl(this.this$0, this);
        return objM5081fetchSubscriptionListsIoAF18A$suspendImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM5081fetchSubscriptionListsIoAF18A$suspendImpl : Result.m5276boximpl(objM5081fetchSubscriptionListsIoAF18A$suspendImpl);
    }
}
