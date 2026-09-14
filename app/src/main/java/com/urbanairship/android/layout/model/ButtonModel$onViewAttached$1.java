package com.urbanairship.android.layout.model;

import android.content.Context;
import android.view.View;
import com.urbanairship.UAirship;
import com.urbanairship.android.layout.environment.LayoutState;
import com.urbanairship.android.layout.event.ReportingEvent;
import com.urbanairship.android.layout.info.Button;
import com.urbanairship.android.layout.property.ButtonClickBehaviorTypeKt;
import com.urbanairship.android.layout.property.EventHandler;
import com.urbanairship.android.layout.property.EventHandlerKt;
import com.urbanairship.android.layout.reporting.LayoutData;
import com.urbanairship.android.layout.widget.TappableView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes5.dex */
final class ButtonModel$onViewAttached$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ View $view;
    int label;
    final /* synthetic */ ButtonModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ButtonModel$onViewAttached$1(View view, ButtonModel buttonModel, Continuation continuation) {
        super(2, continuation);
        this.$view = view;
        this.this$0 = buttonModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ButtonModel$onViewAttached$1(this.$view, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ButtonModel$onViewAttached$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.urbanairship.android.layout.model.ButtonModel$onViewAttached$1$1 */
    static final class C47581 implements FlowCollector {
        final /* synthetic */ View $view;
        final /* synthetic */ ButtonModel this$0;

        C47581(ButtonModel buttonModel, View view) {
            this.this$0 = buttonModel;
            this.$view = view;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Unit unit, Continuation continuation) {
            ButtonModel$onViewAttached$1$1$emit$1 buttonModel$onViewAttached$1$1$emit$1;
            if (continuation instanceof ButtonModel$onViewAttached$1$1$emit$1) {
                buttonModel$onViewAttached$1$1$emit$1 = (ButtonModel$onViewAttached$1$1$emit$1) continuation;
                int i = buttonModel$onViewAttached$1$1$emit$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    buttonModel$onViewAttached$1$1$emit$1.label = i - Integer.MIN_VALUE;
                } else {
                    buttonModel$onViewAttached$1$1$emit$1 = new ButtonModel$onViewAttached$1$1$emit$1(this, continuation);
                }
            } else {
                buttonModel$onViewAttached$1$1$emit$1 = new ButtonModel$onViewAttached$1$1$emit$1(this, continuation);
            }
            Object obj = buttonModel$onViewAttached$1$1$emit$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = buttonModel$onViewAttached$1$1$emit$1.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                ButtonModel.Listener listener = this.this$0.getListener();
                if (listener != null) {
                    listener.setEnabled(false);
                }
                LayoutData layoutDataReportingContext$default = LayoutState.reportingContext$default(this.this$0.getLayoutState(), null, null, ((Button) this.this$0.getViewInfo()).getIdentifier(), 3, null);
                this.this$0.report(new ReportingEvent.ButtonTap(new ReportingEvent.ButtonTapData(((Button) this.this$0.getViewInfo()).getIdentifier(), ((Button) this.this$0.getViewInfo()).getReportingMetadata()), layoutDataReportingContext$default));
                ButtonModel buttonModel = this.this$0;
                buttonModel.runActions(((Button) buttonModel.getViewInfo()).getActions(), layoutDataReportingContext$default);
                if (EventHandlerKt.hasTapHandler(((Button) this.this$0.getViewInfo()).getEventHandlers()) && !ButtonClickBehaviorTypeKt.getHasFormSubmit(((Button) this.this$0.getViewInfo()).getClickBehaviors())) {
                    BaseModel.handleViewEvent$default(this.this$0, EventHandler.Type.TAP, null, 2, null);
                }
                ButtonModel buttonModel2 = this.this$0;
                Context context = this.$view.getContext();
                if (context == null) {
                    context = UAirship.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getApplicationContext(...)");
                }
                buttonModel$onViewAttached$1$1$emit$1.L$0 = this;
                buttonModel$onViewAttached$1$1$emit$1.label = 1;
                if (buttonModel2.evaluateClickBehaviors(context, buttonModel$onViewAttached$1$1$emit$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this = (C47581) buttonModel$onViewAttached$1$1$emit$1.L$0;
                ResultKt.throwOnFailure(obj);
            }
            ButtonModel.Listener listener2 = this.this$0.getListener();
            if (listener2 != null) {
                listener2.setEnabled(true);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Unit> flowTaps = ((TappableView) this.$view).taps();
            C47581 c47581 = new C47581(this.this$0, this.$view);
            this.label = 1;
            if (flowTaps.collect(c47581, this) == coroutine_suspended) {
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
