package com.urbanairship.android.layout.model;

import com.urbanairship.android.layout.environment.SharedState;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.info.CheckboxInfo;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* loaded from: classes5.dex */
final class CheckboxModel$onViewAttached$2 extends SuspendLambda implements Function2 {
    final /* synthetic */ SharedFlow $checkedChanges;
    int label;
    final /* synthetic */ CheckboxModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CheckboxModel$onViewAttached$2(SharedFlow sharedFlow, CheckboxModel checkboxModel, Continuation continuation) {
        super(2, continuation);
        this.$checkedChanges = sharedFlow;
        this.this$0 = checkboxModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CheckboxModel$onViewAttached$2(this.$checkedChanges, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CheckboxModel$onViewAttached$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow sharedFlow = this.$checkedChanges;
            final CheckboxModel checkboxModel = this.this$0;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.CheckboxModel$onViewAttached$2.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Boolean) obj2).booleanValue(), continuation);
                }

                public final Object emit(final boolean z, Continuation continuation) {
                    SharedState sharedState = checkboxModel.checkboxState;
                    final CheckboxModel checkboxModel2 = checkboxModel;
                    sharedState.update(new Function1() { // from class: com.urbanairship.android.layout.model.CheckboxModel.onViewAttached.2.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // kotlin.jvm.functions.Function1
                        public final State.Checkbox invoke(State.Checkbox state) {
                            Set setMinus;
                            Intrinsics.checkNotNullParameter(state, "state");
                            State.Checkbox.Selected selected = new State.Checkbox.Selected(null, ((CheckboxInfo) checkboxModel2.getViewInfo()).getReportingValue());
                            if (z) {
                                setMinus = SetsKt.plus(state.getSelectedItems(), selected);
                            } else {
                                setMinus = SetsKt.minus(state.getSelectedItems(), selected);
                            }
                            return State.Checkbox.copy$default(state, null, 0, 0, setMinus, false, 23, null);
                        }
                    });
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (sharedFlow.collect(flowCollector, this) == coroutine_suspended) {
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
