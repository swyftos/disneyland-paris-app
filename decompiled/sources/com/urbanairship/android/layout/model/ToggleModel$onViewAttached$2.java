package com.urbanairship.android.layout.model;

import com.urbanairship.android.layout.property.EventHandler;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;

/* loaded from: classes5.dex */
final class ToggleModel$onViewAttached$2 extends SuspendLambda implements Function2 {
    final /* synthetic */ SharedFlow $checkedChanges;
    int label;
    final /* synthetic */ ToggleModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ToggleModel$onViewAttached$2(SharedFlow sharedFlow, ToggleModel toggleModel, Continuation continuation) {
        super(2, continuation);
        this.$checkedChanges = sharedFlow;
        this.this$0 = toggleModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ToggleModel$onViewAttached$2(this.$checkedChanges, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ToggleModel$onViewAttached$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow flowDrop = FlowKt.drop(this.$checkedChanges, 1);
            final ToggleModel toggleModel = this.this$0;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.ToggleModel$onViewAttached$2.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Boolean) obj2).booleanValue(), continuation);
                }

                public final Object emit(boolean z, Continuation continuation) {
                    BaseModel.handleViewEvent$default(toggleModel, EventHandler.Type.TAP, null, 2, null);
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (flowDrop.collect(flowCollector, this) == coroutine_suspended) {
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
