package com.urbanairship.android.layout.model;

import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.environment.ThomasForm;
import com.urbanairship.android.layout.property.EventHandler;
import com.urbanairship.android.layout.property.EventHandlerKt;
import com.urbanairship.android.layout.reporting.AttributeName;
import com.urbanairship.android.layout.reporting.ThomasFormField;
import com.urbanairship.json.JsonValue;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes5.dex */
final class RadioInputController$onViewAttached$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ RadioInputController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RadioInputController$onViewAttached$1(RadioInputController radioInputController, Continuation continuation) {
        super(2, continuation);
        this.this$0 = radioInputController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RadioInputController$onViewAttached$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RadioInputController$onViewAttached$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow changes = this.this$0.radioState.getChanges();
            final RadioInputController radioInputController = this.this$0;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.RadioInputController$onViewAttached$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(State.Radio radio, Continuation continuation) {
                    JsonValue NULL;
                    ThomasForm thomasForm = radioInputController.formState;
                    String identifier = radio.getIdentifier();
                    State.Radio.Selected selectedItem = radio.getSelectedItem();
                    JsonValue reportingValue = selectedItem != null ? selectedItem.getReportingValue() : null;
                    ThomasFormField.FieldType.Companion companion = ThomasFormField.FieldType.INSTANCE;
                    State.Radio.Selected selectedItem2 = radio.getSelectedItem();
                    if (selectedItem2 == null || (NULL = selectedItem2.getReportingValue()) == null) {
                        NULL = JsonValue.NULL;
                        Intrinsics.checkNotNullExpressionValue(NULL, "NULL");
                    }
                    final RadioInputController radioInputController2 = radioInputController;
                    Function1 function1 = new Function1() { // from class: com.urbanairship.android.layout.model.RadioInputController.onViewAttached.1.1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(JsonValue it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return Boolean.valueOf(radioInputController2.isValid(it));
                        }
                    };
                    ThomasFormField.Companion companion2 = ThomasFormField.INSTANCE;
                    AttributeName attributeName = radioInputController.getViewInfo().getAttributeName();
                    State.Radio.Selected selectedItem3 = radio.getSelectedItem();
                    thomasForm.updateFormInput(new ThomasFormField.RadioInputController(identifier, reportingValue, ThomasFormField.FieldType.Companion.just$default(companion, NULL, function1, null, companion2.makeAttributes(attributeName, selectedItem3 != null ? selectedItem3.getAttributeValue() : null), 4, null)), radioInputController.getProperties().getPagerPageId());
                    if (EventHandlerKt.hasFormInputHandler(radioInputController.getViewInfo().getEventHandlers())) {
                        RadioInputController radioInputController3 = radioInputController;
                        EventHandler.Type type = EventHandler.Type.FORM_INPUT;
                        State.Radio.Selected selectedItem4 = radio.getSelectedItem();
                        radioInputController3.handleViewEvent(type, selectedItem4 != null ? selectedItem4.getReportingValue() : null);
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
