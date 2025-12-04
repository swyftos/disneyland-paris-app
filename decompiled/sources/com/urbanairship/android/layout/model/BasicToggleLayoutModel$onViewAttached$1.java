package com.urbanairship.android.layout.model;

import com.urbanairship.android.layout.environment.ThomasForm;
import com.urbanairship.android.layout.info.BasicToggleLayoutInfo;
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
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes5.dex */
final class BasicToggleLayoutModel$onViewAttached$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ BasicToggleLayoutModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BasicToggleLayoutModel$onViewAttached$1(BasicToggleLayoutModel basicToggleLayoutModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = basicToggleLayoutModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BasicToggleLayoutModel$onViewAttached$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BasicToggleLayoutModel$onViewAttached$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow<Boolean> stateFlowIsOn = this.this$0.isOn();
            final BasicToggleLayoutModel basicToggleLayoutModel = this.this$0;
            FlowCollector<? super Boolean> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.BasicToggleLayoutModel$onViewAttached$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Boolean) obj2).booleanValue(), continuation);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public final Object emit(boolean z, Continuation continuation) {
                    ThomasForm thomasForm = basicToggleLayoutModel.formState;
                    String identifier = ((BasicToggleLayoutInfo) basicToggleLayoutModel.getViewInfo()).getIdentifier();
                    Boolean boolBoxBoolean = Boxing.boxBoolean(z);
                    ThomasFormField.FieldType.Companion companion = ThomasFormField.FieldType.INSTANCE;
                    Boolean boolBoxBoolean2 = Boxing.boxBoolean(z);
                    final BasicToggleLayoutModel basicToggleLayoutModel2 = basicToggleLayoutModel;
                    thomasForm.updateFormInput(new ThomasFormField.Toggle(identifier, boolBoxBoolean, ThomasFormField.FieldType.Companion.just$default(companion, boolBoxBoolean2, new Function1() { // from class: com.urbanairship.android.layout.model.BasicToggleLayoutModel.onViewAttached.1.1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            return invoke(((Boolean) obj2).booleanValue());
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public final Boolean invoke(boolean z2) {
                            return Boolean.valueOf(z2 || !((BasicToggleLayoutInfo) basicToggleLayoutModel2.getViewInfo()).isRequired());
                        }
                    }, null, ThomasFormField.INSTANCE.makeAttributes(((BasicToggleLayoutInfo) basicToggleLayoutModel.getViewInfo()).getAttributeName(), ((BasicToggleLayoutInfo) basicToggleLayoutModel.getViewInfo()).getAttributeValue()), 4, null)), basicToggleLayoutModel.getProperties().getPagerPageId());
                    if (EventHandlerKt.hasFormInputHandler(((BasicToggleLayoutInfo) basicToggleLayoutModel.getViewInfo()).getEventHandlers())) {
                        basicToggleLayoutModel.handleViewEvent(EventHandler.Type.FORM_INPUT, Boxing.boxBoolean(z));
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
