package com.urbanairship.featureflag;

import com.urbanairship.deferred.DeferredRequest;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
final class FlagDeferredResolver$resolve$2 extends SuspendLambda implements Function2 {
    final /* synthetic */ FeatureFlagInfo $flagInfo;
    final /* synthetic */ DeferredRequest $request;
    final /* synthetic */ String $requestId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FlagDeferredResolver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlagDeferredResolver$resolve$2(FlagDeferredResolver flagDeferredResolver, String str, DeferredRequest deferredRequest, FeatureFlagInfo featureFlagInfo, Continuation continuation) {
        super(2, continuation);
        this.this$0 = flagDeferredResolver;
        this.$requestId = str;
        this.$request = deferredRequest;
        this.$flagInfo = featureFlagInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FlagDeferredResolver$resolve$2 flagDeferredResolver$resolve$2 = new FlagDeferredResolver$resolve$2(this.this$0, this.$requestId, this.$request, this.$flagInfo, continuation);
        flagDeferredResolver$resolve$2.L$0 = obj;
        return flagDeferredResolver$resolve$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((FlagDeferredResolver$resolve$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007c A[PHI: r12
  0x007c: PHI (r12v13 java.lang.Object) = (r12v10 java.lang.Object), (r12v0 java.lang.Object) binds: [B:17:0x0079, B:6:0x000e] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r12)
            goto L7c
        L12:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L1a:
            java.lang.Object r1 = r11.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r12)
            goto L45
        L22:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            r1 = r12
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            com.urbanairship.featureflag.FlagDeferredResolver r12 = r11.this$0
            java.util.Map r12 = com.urbanairship.featureflag.FlagDeferredResolver.access$getPendingTasks$p(r12)
            java.lang.String r4 = r11.$requestId
            java.lang.Object r12 = r12.get(r4)
            kotlinx.coroutines.Deferred r12 = (kotlinx.coroutines.Deferred) r12
            if (r12 == 0) goto L47
            r11.L$0 = r1
            r11.label = r3
            java.lang.Object r12 = r12.await(r11)
            if (r12 != r0) goto L45
            return r0
        L45:
            kotlin.Result r12 = (kotlin.Result) r12
        L47:
            r3 = r1
            com.urbanairship.featureflag.FlagDeferredResolver r12 = r11.this$0
            kotlinx.coroutines.CoroutineDispatcher r4 = com.urbanairship.featureflag.FlagDeferredResolver.access$getDispatcher$p(r12)
            com.urbanairship.featureflag.FlagDeferredResolver$resolve$2$execution$1 r12 = new com.urbanairship.featureflag.FlagDeferredResolver$resolve$2$execution$1
            com.urbanairship.featureflag.FlagDeferredResolver r6 = r11.this$0
            com.urbanairship.deferred.DeferredRequest r7 = r11.$request
            com.urbanairship.featureflag.FeatureFlagInfo r8 = r11.$flagInfo
            java.lang.String r9 = r11.$requestId
            r10 = 0
            r5 = r12
            r5.<init>(r6, r7, r8, r9, r10)
            r7 = 2
            r8 = 0
            r5 = 0
            r6 = r12
            kotlinx.coroutines.Deferred r12 = kotlinx.coroutines.BuildersKt.async$default(r3, r4, r5, r6, r7, r8)
            com.urbanairship.featureflag.FlagDeferredResolver r1 = r11.this$0
            java.util.Map r1 = com.urbanairship.featureflag.FlagDeferredResolver.access$getPendingTasks$p(r1)
            java.lang.String r3 = r11.$requestId
            r1.put(r3, r12)
            r1 = 0
            r11.L$0 = r1
            r11.label = r2
            java.lang.Object r12 = r12.await(r11)
            if (r12 != r0) goto L7c
            return r0
        L7c:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FlagDeferredResolver$resolve$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
