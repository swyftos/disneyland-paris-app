package com.urbanairship.android.layout.util;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ProducerScope;

/* loaded from: classes5.dex */
final class ViewExtensionsKt$onEditing$1$textWatcher$1$beforeTextChanged$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ ProducerScope $$this$callbackFlow;
    final /* synthetic */ long $idleDelay;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ViewExtensionsKt$onEditing$1$textWatcher$1$beforeTextChanged$1(long j, ProducerScope producerScope, Continuation continuation) {
        super(2, continuation);
        this.$idleDelay = j;
        this.$$this$callbackFlow = producerScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ViewExtensionsKt$onEditing$1$textWatcher$1$beforeTextChanged$1 viewExtensionsKt$onEditing$1$textWatcher$1$beforeTextChanged$1 = new ViewExtensionsKt$onEditing$1$textWatcher$1$beforeTextChanged$1(this.$idleDelay, this.$$this$callbackFlow, continuation);
        viewExtensionsKt$onEditing$1$textWatcher$1$beforeTextChanged$1.L$0 = obj;
        return viewExtensionsKt$onEditing$1$textWatcher$1$beforeTextChanged$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ViewExtensionsKt$onEditing$1$textWatcher$1$beforeTextChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            long j = this.$idleDelay;
            this.L$0 = coroutineScope2;
            this.label = 1;
            if (DelayKt.m3608delayVtjQ1oo(j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope = coroutineScope2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            this.$$this$callbackFlow.mo3620trySendJP2dKIU(Boxing.boxBoolean(false));
        }
        return Unit.INSTANCE;
    }
}
