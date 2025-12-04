package com.urbanairship.embedded;

import com.urbanairship.embedded.AirshipEmbeddedObserver;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes5.dex */
final class AirshipEmbeddedObserver$listener$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ AirshipEmbeddedObserver.Listener $value;
    int label;
    final /* synthetic */ AirshipEmbeddedObserver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AirshipEmbeddedObserver$listener$1(AirshipEmbeddedObserver airshipEmbeddedObserver, AirshipEmbeddedObserver.Listener listener, Continuation continuation) {
        super(2, continuation);
        this.this$0 = airshipEmbeddedObserver;
        this.$value = listener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AirshipEmbeddedObserver$listener$1(this.this$0, this.$value, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AirshipEmbeddedObserver$listener$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<List<AirshipEmbeddedInfo>> embeddedViewInfoFlow = this.this$0.getEmbeddedViewInfoFlow();
            final AirshipEmbeddedObserver.Listener listener = this.$value;
            FlowCollector<? super List<AirshipEmbeddedInfo>> flowCollector = new FlowCollector() { // from class: com.urbanairship.embedded.AirshipEmbeddedObserver$listener$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(List list, Continuation continuation) {
                    listener.onEmbeddedViewInfoUpdate(list);
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (embeddedViewInfoFlow.collect(flowCollector, this) == coroutine_suspended) {
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
