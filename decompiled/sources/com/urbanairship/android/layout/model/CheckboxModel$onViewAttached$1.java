package com.urbanairship.android.layout.model;

import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.info.CheckboxInfo;
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
final class CheckboxModel$onViewAttached$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ CheckboxModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CheckboxModel$onViewAttached$1(CheckboxModel checkboxModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = checkboxModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CheckboxModel$onViewAttached$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CheckboxModel$onViewAttached$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow changes = this.this$0.checkboxState.getChanges();
            final CheckboxModel checkboxModel = this.this$0;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.CheckboxModel$onViewAttached$1.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(State.Checkbox checkbox, Continuation continuation) {
                    boolean z = true;
                    boolean zIsSelected$default = State.Checkbox.isSelected$default(checkbox, null, ((CheckboxInfo) checkboxModel.getViewInfo()).getReportingValue(), 1, null);
                    checkboxModel.setChecked(zIsSelected$default);
                    CheckboxModel checkboxModel2 = checkboxModel;
                    if (!checkbox.isEnabled() || (checkbox.getSelectedItems().size() >= checkbox.getMaxSelection() && !zIsSelected$default)) {
                        z = false;
                    }
                    checkboxModel2.setEnabled(z);
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
