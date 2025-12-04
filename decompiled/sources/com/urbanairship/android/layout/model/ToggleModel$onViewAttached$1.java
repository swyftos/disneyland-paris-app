package com.urbanairship.android.layout.model;

import com.urbanairship.android.layout.environment.ThomasForm;
import com.urbanairship.android.layout.info.ToggleInfo;
import com.urbanairship.android.layout.property.EventHandler;
import com.urbanairship.android.layout.property.EventHandlerKt;
import com.urbanairship.android.layout.reporting.ThomasFormField;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;

/* loaded from: classes5.dex */
final class ToggleModel$onViewAttached$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ SharedFlow $checkedChanges;
    int label;
    final /* synthetic */ ToggleModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ToggleModel$onViewAttached$1(SharedFlow sharedFlow, ToggleModel toggleModel, Continuation continuation) {
        super(2, continuation);
        this.$checkedChanges = sharedFlow;
        this.this$0 = toggleModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ToggleModel$onViewAttached$1(this.$checkedChanges, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ToggleModel$onViewAttached$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow sharedFlow = this.$checkedChanges;
            final ToggleModel toggleModel = this.this$0;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.ToggleModel$onViewAttached$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Boolean) obj2).booleanValue(), continuation);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public final Object emit(boolean z, Continuation continuation) {
                    Object value;
                    ThomasForm thomasForm = toggleModel.formState;
                    String identifier = ((ToggleInfo) toggleModel.getViewInfo()).getIdentifier();
                    Boolean boolBoxBoolean = Boxing.boxBoolean(z);
                    ThomasFormField.FieldType.Companion companion = ThomasFormField.FieldType.INSTANCE;
                    Boolean boolBoxBoolean2 = Boxing.boxBoolean(z);
                    final ToggleModel toggleModel2 = toggleModel;
                    thomasForm.updateFormInput(new ThomasFormField.Toggle(identifier, boolBoxBoolean, ThomasFormField.FieldType.Companion.just$default(companion, boolBoxBoolean2, new Function1() { // from class: com.urbanairship.android.layout.model.ToggleModel.onViewAttached.1.1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            return invoke(((Boolean) obj2).booleanValue());
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public final Boolean invoke(boolean z2) {
                            return Boolean.valueOf(z2 || !((ToggleInfo) toggleModel2.getViewInfo()).isRequired());
                        }
                    }, null, ThomasFormField.INSTANCE.makeAttributes(((ToggleInfo) toggleModel.getViewInfo()).getAttributeName(), ((ToggleInfo) toggleModel.getViewInfo()).getAttributeValue()), 4, null)), toggleModel.getProperties().getPagerPageId());
                    if (EventHandlerKt.hasFormInputHandler(((ToggleInfo) toggleModel.getViewInfo()).getEventHandlers())) {
                        toggleModel.handleViewEvent(EventHandler.Type.FORM_INPUT, Boxing.boxBoolean(z));
                    }
                    MutableStateFlow mutableStateFlow = toggleModel.valueChanged;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, (Boolean) value));
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
