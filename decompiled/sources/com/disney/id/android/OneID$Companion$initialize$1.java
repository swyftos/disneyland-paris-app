package com.disney.id.android;

import android.content.Context;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes3.dex */
final class OneID$Companion$initialize$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Config $config;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $country;
    final /* synthetic */ OneIDListener $delegate;
    final /* synthetic */ String $externalRefreshToken;
    final /* synthetic */ OneIDStateCallback $stateCallback;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OneID$Companion$initialize$1(Config config, String str, OneIDListener oneIDListener, Context context, String str2, OneIDStateCallback oneIDStateCallback, Continuation continuation) {
        super(2, continuation);
        this.$config = config;
        this.$country = str;
        this.$delegate = oneIDListener;
        this.$context = context;
        this.$externalRefreshToken = str2;
        this.$stateCallback = oneIDStateCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OneID$Companion$initialize$1(this.$config, this.$country, this.$delegate, this.$context, this.$externalRefreshToken, this.$stateCallback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OneID$Companion$initialize$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            OneID.INSTANCE.initialize(this.$config, this.$country, this.$delegate, this.$context, this.$externalRefreshToken, this.$stateCallback);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
