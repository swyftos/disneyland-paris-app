package com.urbanairship.featureflag;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class FeatureFlagManager$flag$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeatureFlagManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeatureFlagManager$flag$1(FeatureFlagManager featureFlagManager, Continuation continuation) {
        super(continuation);
        this.this$0 = featureFlagManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM2862flag0E7RQCE = this.this$0.m2862flag0E7RQCE(null, false, this);
        return objM2862flag0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2862flag0E7RQCE : Result.m2967boximpl(objM2862flag0E7RQCE);
    }
}
