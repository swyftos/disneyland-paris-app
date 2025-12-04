package com.urbanairship.android.framework.proxy.events;

import com.urbanairship.android.framework.proxy.Event;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* loaded from: classes2.dex */
final class EventEmitter$addEvent$1$2 extends SuspendLambda implements Function2 {
    final /* synthetic */ Event $event;
    int label;
    final /* synthetic */ EventEmitter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EventEmitter$addEvent$1$2(EventEmitter eventEmitter, Event event, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eventEmitter;
        this.$event = event;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new EventEmitter$addEvent$1$2(this.this$0, this.$event, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((EventEmitter$addEvent$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableSharedFlow mutableSharedFlow = this.this$0._pendingEventsUpdates;
            Event event = this.$event;
            this.label = 1;
            if (mutableSharedFlow.emit(event, this) == coroutine_suspended) {
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
