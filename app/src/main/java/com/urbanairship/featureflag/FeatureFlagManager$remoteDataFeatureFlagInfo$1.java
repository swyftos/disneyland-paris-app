package com.urbanairship.featureflag;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
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
        Object objM5100remoteDataFeatureFlagInfogIAlus = this.this$0.m5100remoteDataFeatureFlagInfogIAlus(null, this);
        return objM5100remoteDataFeatureFlagInfogIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM5100remoteDataFeatureFlagInfogIAlus : Result.m5276boximpl(objM5100remoteDataFeatureFlagInfogIAlus);
    }
}
