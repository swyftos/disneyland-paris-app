package com.urbanairship.featureflag;

import com.urbanairship.deferred.DeferredRequest;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
final class FlagDeferredResolver$resolve$2$execution$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ FeatureFlagInfo $flagInfo;
    final /* synthetic */ DeferredRequest $request;
    final /* synthetic */ String $requestId;
    int label;
    final /* synthetic */ FlagDeferredResolver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlagDeferredResolver$resolve$2$execution$1(FlagDeferredResolver flagDeferredResolver, DeferredRequest deferredRequest, FeatureFlagInfo featureFlagInfo, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = flagDeferredResolver;
        this.$request = deferredRequest;
        this.$flagInfo = featureFlagInfo;
        this.$requestId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FlagDeferredResolver$resolve$2$execution$1(this.this$0, this.$request, this.$flagInfo, this.$requestId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((FlagDeferredResolver$resolve$2$execution$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM2868resolveBWLJW6A;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlagDeferredResolver flagDeferredResolver = this.this$0;
            DeferredRequest deferredRequest = this.$request;
            FeatureFlagInfo featureFlagInfo = this.$flagInfo;
            String str = this.$requestId;
            this.label = 1;
            objM2868resolveBWLJW6A = flagDeferredResolver.m2868resolveBWLJW6A(deferredRequest, featureFlagInfo, str, this);
            if (objM2868resolveBWLJW6A == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objM2868resolveBWLJW6A = ((Result) obj).getValue();
        }
        return Result.m2967boximpl(objM2868resolveBWLJW6A);
    }
}
