package com.urbanairship.android.layout.environment;

import com.urbanairship.android.layout.environment.LayoutState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* loaded from: classes5.dex */
final class LayoutState$setState$job$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ LayoutState.StateMutation $mutation;
    final /* synthetic */ Duration $ttl;
    int label;
    final /* synthetic */ LayoutState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutState$setState$job$1(Duration duration, LayoutState layoutState, LayoutState.StateMutation stateMutation, Continuation continuation) {
        super(2, continuation);
        this.$ttl = duration;
        this.this$0 = layoutState;
        this.$mutation = stateMutation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LayoutState$setState$job$1(this.$ttl, this.this$0, this.$mutation, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LayoutState$setState$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long rawValue = this.$ttl.getRawValue();
            this.label = 1;
            if (DelayKt.m3608delayVtjQ1oo(rawValue, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.removeTempMutation(this.$mutation);
        return Unit.INSTANCE;
    }
}
