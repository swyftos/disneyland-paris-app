package com.urbanairship.android.layout.model;

import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.environment.ThomasForm;
import com.urbanairship.android.layout.property.EventHandler;
import com.urbanairship.android.layout.property.EventHandlerKt;
import com.urbanairship.android.layout.reporting.ThomasFormField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
final class CheckboxController$onViewAttached$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ CheckboxController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CheckboxController$onViewAttached$1(CheckboxController checkboxController, Continuation continuation) {
        super(2, continuation);
        this.this$0 = checkboxController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CheckboxController$onViewAttached$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CheckboxController$onViewAttached$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow changes = this.this$0.checkboxState.getChanges();
            final CheckboxController checkboxController = this.this$0;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.CheckboxController$onViewAttached$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(State.Checkbox checkbox, Continuation continuation) {
                    Set<State.Checkbox.Selected> selectedItems = checkbox.getSelectedItems();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(selectedItems, 10));
                    Iterator<T> it = selectedItems.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((State.Checkbox.Selected) it.next()).getReportingValue());
                    }
                    Set set = CollectionsKt.toSet(arrayList);
                    ThomasForm thomasForm = checkboxController.formState;
                    String identifier = checkbox.getIdentifier();
                    ThomasFormField.FieldType.Companion companion = ThomasFormField.FieldType.INSTANCE;
                    final CheckboxController checkboxController2 = checkboxController;
                    thomasForm.updateFormInput(new ThomasFormField.CheckboxController(identifier, set, ThomasFormField.FieldType.Companion.just$default(companion, set, new Function1() { // from class: com.urbanairship.android.layout.model.CheckboxController.onViewAttached.1.1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(Set it2) {
                            Intrinsics.checkNotNullParameter(it2, "it");
                            return Boolean.valueOf(checkboxController2.isValid(it2));
                        }
                    }, null, null, 12, null)), checkboxController.getProperties().getPagerPageId());
                    if (EventHandlerKt.hasFormInputHandler(checkboxController.getViewInfo().getEventHandlers())) {
                        checkboxController.handleViewEvent(EventHandler.Type.FORM_INPUT, CollectionsKt.toList(set));
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
