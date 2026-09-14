package com.urbanairship.messagecenter;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
final class Inbox$performUpdate$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Inbox this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Inbox$performUpdate$1(Inbox inbox, Continuation continuation) {
        super(continuation);
        this.this$0 = inbox;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM5148performUpdateIoAF18A$urbanairship_message_center_release = this.this$0.m5148performUpdateIoAF18A$urbanairship_message_center_release(this);
        return objM5148performUpdateIoAF18A$urbanairship_message_center_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM5148performUpdateIoAF18A$urbanairship_message_center_release : Result.m5276boximpl(objM5148performUpdateIoAF18A$urbanairship_message_center_release);
    }
}
