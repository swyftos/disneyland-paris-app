package com.urbanairship.featureflag;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
final class FeatureFlagManager$resolveStatic$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeatureFlagManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeatureFlagManager$resolveStatic$1(FeatureFlagManager featureFlagManager, Continuation continuation) {
        super(continuation);
        this.this$0 = featureFlagManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM5103resolveStaticyxL6bBk = this.this$0.m5103resolveStaticyxL6bBk(null, false, null, null, this);
        return objM5103resolveStaticyxL6bBk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM5103resolveStaticyxL6bBk : Result.m5276boximpl(objM5103resolveStaticyxL6bBk);
    }
}
