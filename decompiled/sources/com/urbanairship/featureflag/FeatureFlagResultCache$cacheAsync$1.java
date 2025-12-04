package com.urbanairship.featureflag;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
final class FeatureFlagResultCache$cacheAsync$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ FeatureFlag $flag;
    final /* synthetic */ long $ttlMilliseconds;
    int label;
    final /* synthetic */ FeatureFlagResultCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeatureFlagResultCache$cacheAsync$1(FeatureFlagResultCache featureFlagResultCache, FeatureFlag featureFlag, long j, Continuation continuation) {
        super(2, continuation);
        this.this$0 = featureFlagResultCache;
        this.$flag = featureFlag;
        this.$ttlMilliseconds = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FeatureFlagResultCache$cacheAsync$1(this.this$0, this.$flag, this.$ttlMilliseconds, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((FeatureFlagResultCache$cacheAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FeatureFlagResultCache featureFlagResultCache = this.this$0;
            FeatureFlag featureFlag = this.$flag;
            Duration.Companion companion = Duration.INSTANCE;
            long duration = DurationKt.toDuration(this.$ttlMilliseconds, DurationUnit.MILLISECONDS);
            this.label = 1;
            if (featureFlagResultCache.m2863cache8Mi8wO0(featureFlag, duration, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
