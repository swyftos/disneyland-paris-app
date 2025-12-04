package com.urbanairship.featureflag;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class FeatureFlagManager$remoteDataFeatureFlagInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeatureFlagManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeatureFlagManager$remoteDataFeatureFlagInfo$1(FeatureFlagManager featureFlagManager, Continuation continuation) {
        super(continuation);
        this.this$0 = featureFlagManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM2858remoteDataFeatureFlagInfogIAlus = this.this$0.m2858remoteDataFeatureFlagInfogIAlus(null, this);
        return objM2858remoteDataFeatureFlagInfogIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2858remoteDataFeatureFlagInfogIAlus : Result.m2967boximpl(objM2858remoteDataFeatureFlagInfogIAlus);
    }
}
