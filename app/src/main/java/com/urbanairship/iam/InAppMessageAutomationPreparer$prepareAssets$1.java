package com.urbanairship.iam;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
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
        Object objM5116prepareAssetsBWLJW6A = this.this$0.m5116prepareAssetsBWLJW6A(null, null, false, this);
        return objM5116prepareAssetsBWLJW6A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM5116prepareAssetsBWLJW6A : Result.m5276boximpl(objM5116prepareAssetsBWLJW6A);
    }
}
