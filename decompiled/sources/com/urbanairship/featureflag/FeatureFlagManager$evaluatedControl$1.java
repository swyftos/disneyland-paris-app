package com.urbanairship.featureflag;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class FeatureFlagManager$evaluatedControl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeatureFlagManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeatureFlagManager$evaluatedControl$1(FeatureFlagManager featureFlagManager, Continuation continuation) {
        super(continuation);
        this.this$0 = featureFlagManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM2856evaluatedControl3t6e044 = this.this$0.m2856evaluatedControl3t6e044(null, null, null, this);
        return objM2856evaluatedControl3t6e044 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2856evaluatedControl3t6e044 : Result.m2967boximpl(objM2856evaluatedControl3t6e044);
    }
}
