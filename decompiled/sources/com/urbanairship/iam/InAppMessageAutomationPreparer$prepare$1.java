package com.urbanairship.iam;

import com.urbanairship.automation.engine.PreparedScheduleInfo;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class InAppMessageAutomationPreparer$prepare$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppMessageAutomationPreparer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InAppMessageAutomationPreparer$prepare$1(InAppMessageAutomationPreparer inAppMessageAutomationPreparer, Continuation continuation) {
        super(continuation);
        this.this$0 = inAppMessageAutomationPreparer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM2875prepare0E7RQCE = this.this$0.m2875prepare0E7RQCE((InAppMessage) null, (PreparedScheduleInfo) null, (Continuation<? super Result<PreparedInAppMessageData>>) this);
        return objM2875prepare0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2875prepare0E7RQCE : Result.m2967boximpl(objM2875prepare0E7RQCE);
    }
}
