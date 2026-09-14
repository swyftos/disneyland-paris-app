package com.urbanairship.contacts;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
final class ContactManager$fetchToken$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ContactManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContactManager$fetchToken$1(ContactManager contactManager, Continuation continuation) {
        super(continuation);
        this.this$0 = contactManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo5075fetchTokengIAlus = this.this$0.mo5075fetchTokengIAlus(null, this);
        return objMo5075fetchTokengIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo5075fetchTokengIAlus : Result.m5276boximpl(objMo5075fetchTokengIAlus);
    }
}
