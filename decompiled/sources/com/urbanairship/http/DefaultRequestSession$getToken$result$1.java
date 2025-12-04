package com.urbanairship.http;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
final class DefaultRequestSession$getToken$result$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ String $identifier;
    final /* synthetic */ AuthTokenProvider $provider;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultRequestSession$getToken$result$1(AuthTokenProvider authTokenProvider, String str, Continuation continuation) {
        super(2, continuation);
        this.$provider = authTokenProvider;
        this.$identifier = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DefaultRequestSession$getToken$result$1(this.$provider, this.$identifier, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DefaultRequestSession$getToken$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objMo2833fetchTokengIAlus;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AuthTokenProvider authTokenProvider = this.$provider;
            String str = this.$identifier;
            this.label = 1;
            objMo2833fetchTokengIAlus = authTokenProvider.mo2833fetchTokengIAlus(str, this);
            if (objMo2833fetchTokengIAlus == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objMo2833fetchTokengIAlus = ((Result) obj).getValue();
        }
        return Result.m2967boximpl(objMo2833fetchTokengIAlus);
    }
}
