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

/* loaded from: classes5.dex */
final class BaseToggleLayoutModel$onViewAttached$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ BaseToggleLayoutModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseToggleLayoutModel$onViewAttached$1(BaseToggleLayoutModel baseToggleLayoutModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = baseToggleLayoutModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BaseToggleLayoutModel$onViewAttached$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BaseToggleLayoutModel$onViewAttached$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow flowDrop = FlowKt.drop(this.this$0.isOn(), 1);
            final BaseToggleLayoutModel baseToggleLayoutModel = this.this$0;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.BaseToggleLayoutModel$onViewAttached$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Boolean) obj2).booleanValue(), continuation);
                }

                public final Object emit(boolean z, Continuation continuation) {
                    BaseModel.handleViewEvent$default(baseToggleLayoutModel, EventHandler.Type.TAP, null, 2, null);
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
