package com.urbanairship.iam;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class InAppMessageAutomationPreparer$prepareAssets$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppMessageAutomationPreparer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InAppMessageAutomationPreparer$prepareAssets$1(InAppMessageAutomationPreparer inAppMessageAutomationPreparer, Continuation continuation) {
        super(continuation);
        this.this$0 = inAppMessageAutomationPreparer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM2874prepareAssetsBWLJW6A = this.this$0.m2874prepareAssetsBWLJW6A(null, null, false, this);
        return objM2874prepareAssetsBWLJW6A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2874prepareAssetsBWLJW6A : Result.m2967boximpl(objM2874prepareAssetsBWLJW6A);
    }
}
