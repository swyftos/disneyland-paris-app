package com.urbanairship.android.layout.model;

import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.info.RadioInputToggleLayoutInfo;
import com.urbanairship.android.layout.model.BaseModel;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes5.dex */
final class RadioInputToggleLayoutModel$onViewAttached$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ RadioInputToggleLayoutModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RadioInputToggleLayoutModel$onViewAttached$1(RadioInputToggleLayoutModel radioInputToggleLayoutModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = radioInputToggleLayoutModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RadioInputToggleLayoutModel$onViewAttached$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RadioInputToggleLayoutModel$onViewAttached$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow changes = this.this$0.radioState.getChanges();
            final RadioInputToggleLayoutModel radioInputToggleLayoutModel = this.this$0;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.RadioInputToggleLayoutModel$onViewAttached$1.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(State.Radio radio, Continuation continuation) {
                    RadioInputToggleLayoutModel radioInputToggleLayoutModel2 = radioInputToggleLayoutModel;
                    radioInputToggleLayoutModel2.setChecked(State.Radio.isSelected$default(radio, ((RadioInputToggleLayoutInfo) radioInputToggleLayoutModel2.getViewInfo()).getIdentifier(), null, 2, null));
                    BaseModel.Listener listener = radioInputToggleLayoutModel.getListener();
                    if (listener != null) {
                        listener.setEnabled(radio.isEnabled());
                    }
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (changes.collect(flowCollector, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
