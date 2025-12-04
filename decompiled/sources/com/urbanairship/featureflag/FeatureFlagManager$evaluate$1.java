package com.urbanairship.featureflag;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class FeatureFlagManager$evaluate$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeatureFlagManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeatureFlagManager$evaluate$1(FeatureFlagManager featureFlagManager, Continuation continuation) {
        super(continuation);
        this.this$0 = featureFlagManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM2855evaluate0E7RQCE = this.this$0.m2855evaluate0E7RQCE(null, null, this);
        return objM2855evaluate0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2855evaluate0E7RQCE : Result.m2967boximpl(objM2855evaluate0E7RQCE);
    }
}
