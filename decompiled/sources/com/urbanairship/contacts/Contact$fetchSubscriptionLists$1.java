package com.urbanairship.contacts;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
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
        Object objM2839fetchSubscriptionListsIoAF18A$suspendImpl = Contact.m2839fetchSubscriptionListsIoAF18A$suspendImpl(this.this$0, this);
        return objM2839fetchSubscriptionListsIoAF18A$suspendImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2839fetchSubscriptionListsIoAF18A$suspendImpl : Result.m2967boximpl(objM2839fetchSubscriptionListsIoAF18A$suspendImpl);
    }
}
