package com.urbanairship.android.layout.model;

import com.urbanairship.android.layout.environment.ThomasForm;
import com.urbanairship.android.layout.property.EventHandler;
import com.urbanairship.android.layout.property.EventHandlerKt;
import com.urbanairship.android.layout.reporting.ThomasFormField;
import com.urbanairship.android.layout.util.ViewExtensionsKt;
import com.urbanairship.android.layout.view.ScoreView;
import com.urbanairship.json.JsonValue;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;

/* loaded from: classes5.dex */
final class ScoreModel$onViewAttached$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ ScoreView $view;
    int label;
    final /* synthetic */ ScoreModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScoreModel$onViewAttached$1(ScoreView scoreView, ScoreModel scoreModel, Continuation continuation) {
        super(2, continuation);
        this.$view = scoreView;
        this.this$0 = scoreModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScoreModel$onViewAttached$1(this.$view, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScoreModel$onViewAttached$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Integer> flowScoreChanges = ViewExtensionsKt.scoreChanges(this.$view);
            final ScoreModel scoreModel = this.this$0;
            FlowCollector<? super Integer> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.ScoreModel$onViewAttached$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Number) obj2).intValue(), continuation);
                }

                public final Object emit(int i2, Continuation continuation) {
                    Object value;
                    ThomasForm thomasForm = scoreModel.formState;
                    String identifier = scoreModel.getViewInfo().getIdentifier();
                    Integer numBoxInt = Boxing.boxInt(i2);
                    ThomasFormField.FieldType.Companion companion = ThomasFormField.FieldType.INSTANCE;
                    Integer numBoxInt2 = Boxing.boxInt(i2);
                    final ScoreModel scoreModel2 = scoreModel;
                    thomasForm.updateFormInput(new ThomasFormField.Score(identifier, numBoxInt, ThomasFormField.FieldType.Companion.just$default(companion, numBoxInt2, new Function1() { // from class: com.urbanairship.android.layout.model.ScoreModel.onViewAttached.1.1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            return invoke(((Number) obj2).intValue());
                        }

                        public final Boolean invoke(int i3) {
                            return Boolean.valueOf(i3 > -1 || !scoreModel2.getViewInfo().isRequired());
                        }
                    }, null, ThomasFormField.INSTANCE.makeAttributes(scoreModel.getViewInfo().getAttributeName(), JsonValue.wrap(i2)), 4, null)), scoreModel.getProperties().getPagerPageId());
                    if (EventHandlerKt.hasFormInputHandler(scoreModel.getViewInfo().getEventHandlers())) {
                        scoreModel.handleViewEvent(EventHandler.Type.FORM_INPUT, Boxing.boxInt(i2));
                    }
                    MutableStateFlow mutableStateFlow = scoreModel.valuesUpdate;
                    do {
                        value = mutableStateFlow.getValue();
                        ((Number) value).intValue();
                    } while (!mutableStateFlow.compareAndSet(value, Boxing.boxInt(i2)));
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (flowScoreChanges.collect(flowCollector, this) == coroutine_suspended) {
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
