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
final class OneID$Companion$initialize$4 extends SuspendLambda implements Function2 {
    final /* synthetic */ Config $config;
    final /* synthetic */ Context $context;
    final /* synthetic */ OneIDListener $delegate;
    final /* synthetic */ String $refreshToken;
    final /* synthetic */ OneIDStateCallback $stateCallback;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OneID$Companion$initialize$4(Config config, OneIDListener oneIDListener, Context context, String str, OneIDStateCallback oneIDStateCallback, Continuation continuation) {
        super(2, continuation);
        this.$config = config;
        this.$delegate = oneIDListener;
        this.$context = context;
        this.$refreshToken = str;
        this.$stateCallback = oneIDStateCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new OneID$Companion$initialize$4(this.$config, this.$delegate, this.$context, this.$refreshToken, this.$stateCallback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((OneID$Companion$initialize$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            OneID.INSTANCE.initialize(this.$config, (String) null, this.$delegate, this.$context, this.$refreshToken, this.$stateCallback);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
