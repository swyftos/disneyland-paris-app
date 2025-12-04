package com.urbanairship.android.layout.model;

import com.urbanairship.android.layout.environment.SharedState;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.info.CheckboxToggleLayoutInfo;
import com.urbanairship.android.layout.property.EventHandler;
import com.urbanairship.android.layout.property.EventHandlerKt;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes5.dex */
final class CheckboxToggleLayoutModel$onViewAttached$2 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ CheckboxToggleLayoutModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CheckboxToggleLayoutModel$onViewAttached$2(CheckboxToggleLayoutModel checkboxToggleLayoutModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = checkboxToggleLayoutModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CheckboxToggleLayoutModel$onViewAttached$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CheckboxToggleLayoutModel$onViewAttached$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow<Boolean> stateFlowIsOn = this.this$0.isOn();
            final CheckboxToggleLayoutModel checkboxToggleLayoutModel = this.this$0;
            FlowCollector<? super Boolean> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.CheckboxToggleLayoutModel$onViewAttached$2.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Boolean) obj2).booleanValue(), continuation);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public final Object emit(final boolean z, Continuation continuation) {
                    SharedState sharedState = checkboxToggleLayoutModel.checkboxState;
                    final CheckboxToggleLayoutModel checkboxToggleLayoutModel2 = checkboxToggleLayoutModel;
                    sharedState.update(new Function1() { // from class: com.urbanairship.android.layout.model.CheckboxToggleLayoutModel.onViewAttached.2.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // kotlin.jvm.functions.Function1
                        public final State.Checkbox invoke(State.Checkbox state) {
                            Intrinsics.checkNotNullParameter(state, "state");
                            return State.Checkbox.copy$default(state, null, 0, 0, z ? SetsKt.plus(state.getSelectedItems(), CheckboxToggleLayoutModelKt.asSelected((CheckboxToggleLayoutInfo) checkboxToggleLayoutModel2.getViewInfo())) : SetsKt.minus(state.getSelectedItems(), CheckboxToggleLayoutModelKt.asSelected((CheckboxToggleLayoutInfo) checkboxToggleLayoutModel2.getViewInfo())), false, 23, null);
                        }
                    });
                    if (EventHandlerKt.hasFormInputHandler(((CheckboxToggleLayoutInfo) checkboxToggleLayoutModel.getViewInfo()).getEventHandlers())) {
                        checkboxToggleLayoutModel.handleViewEvent(EventHandler.Type.FORM_INPUT, Boxing.boxBoolean(z));
                    }
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (stateFlowIsOn.collect(flowCollector, this) == coroutine_suspended) {
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
