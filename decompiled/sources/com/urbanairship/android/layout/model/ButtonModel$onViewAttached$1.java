package com.urbanairship.android.layout.model;

import android.view.View;
import com.urbanairship.android.layout.widget.TappableView;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes5.dex */
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

    /* renamed from: com.urbanairship.android.layout.model.ButtonModel$onViewAttached$1$1, reason: invalid class name */
    static final class AnonymousClass1 implements FlowCollector {
        final /* synthetic */ View $view;
        final /* synthetic */ ButtonModel this$0;

        AnonymousClass1(ButtonModel buttonModel, View view) {
            this.this$0 = buttonModel;
            this.$view = view;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(kotlin.Unit r10, kotlin.coroutines.Continuation r11) {
            /*
                r9 = this;
                boolean r10 = r11 instanceof com.urbanairship.android.layout.model.ButtonModel$onViewAttached$1$1$emit$1
                if (r10 == 0) goto L13
                r10 = r11
                com.urbanairship.android.layout.model.ButtonModel$onViewAttached$1$1$emit$1 r10 = (com.urbanairship.android.layout.model.ButtonModel$onViewAttached$1$1$emit$1) r10
                int r0 = r10.label
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r0 & r1
                if (r2 == 0) goto L13
                int r0 = r0 - r1
                r10.label = r0
                goto L18
            L13:
                com.urbanairship.android.layout.model.ButtonModel$onViewAttached$1$1$emit$1 r10 = new com.urbanairship.android.layout.model.ButtonModel$onViewAttached$1$1$emit$1
                r10.<init>(r9, r11)
            L18:
                java.lang.Object r11 = r10.result
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r10.label
                r2 = 1
                if (r1 == 0) goto L36
                if (r1 != r2) goto L2e
                java.lang.Object r9 = r10.L$0
                com.urbanairship.android.layout.model.ButtonModel$onViewAttached$1$1 r9 = (com.urbanairship.android.layout.model.ButtonModel$onViewAttached$1.AnonymousClass1) r9
                kotlin.ResultKt.throwOnFailure(r11)
                goto Le0
            L2e:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L36:
                kotlin.ResultKt.throwOnFailure(r11)
                com.urbanairship.android.layout.model.ButtonModel r11 = r9.this$0
                com.urbanairship.android.layout.model.ButtonModel$Listener r11 = r11.getListener()
                if (r11 == 0) goto L45
                r1 = 0
                r11.setEnabled(r1)
            L45:
                com.urbanairship.android.layout.model.ButtonModel r11 = r9.this$0
                com.urbanairship.android.layout.environment.LayoutState r3 = r11.getLayoutState()
                com.urbanairship.android.layout.model.ButtonModel r11 = r9.this$0
                com.urbanairship.android.layout.info.View r11 = r11.getViewInfo()
                com.urbanairship.android.layout.info.Button r11 = (com.urbanairship.android.layout.info.Button) r11
                java.lang.String r6 = r11.getIdentifier()
                r7 = 3
                r8 = 0
                r4 = 0
                r5 = 0
                com.urbanairship.android.layout.reporting.LayoutData r11 = com.urbanairship.android.layout.environment.LayoutState.reportingContext$default(r3, r4, r5, r6, r7, r8)
                com.urbanairship.android.layout.model.ButtonModel r1 = r9.this$0
                com.urbanairship.android.layout.event.ReportingEvent$ButtonTap r3 = new com.urbanairship.android.layout.event.ReportingEvent$ButtonTap
                com.urbanairship.android.layout.event.ReportingEvent$ButtonTapData r4 = new com.urbanairship.android.layout.event.ReportingEvent$ButtonTapData
                com.urbanairship.android.layout.model.ButtonModel r5 = r9.this$0
                com.urbanairship.android.layout.info.View r5 = r5.getViewInfo()
                com.urbanairship.android.layout.info.Button r5 = (com.urbanairship.android.layout.info.Button) r5
                java.lang.String r5 = r5.getIdentifier()
                com.urbanairship.android.layout.model.ButtonModel r6 = r9.this$0
                com.urbanairship.android.layout.info.View r6 = r6.getViewInfo()
                com.urbanairship.android.layout.info.Button r6 = (com.urbanairship.android.layout.info.Button) r6
                com.urbanairship.json.JsonValue r6 = r6.getReportingMetadata()
                r4.<init>(r5, r6)
                r3.<init>(r4, r11)
                r1.report(r3)
                com.urbanairship.android.layout.model.ButtonModel r1 = r9.this$0
                com.urbanairship.android.layout.info.View r3 = r1.getViewInfo()
                com.urbanairship.android.layout.info.Button r3 = (com.urbanairship.android.layout.info.Button) r3
                java.util.Map r3 = r3.getActions()
                r1.runActions(r3, r11)
                com.urbanairship.android.layout.model.ButtonModel r11 = r9.this$0
                com.urbanairship.android.layout.info.View r11 = r11.getViewInfo()
                com.urbanairship.android.layout.info.Button r11 = (com.urbanairship.android.layout.info.Button) r11
                java.util.List r11 = r11.getEventHandlers()
                boolean r11 = com.urbanairship.android.layout.property.EventHandlerKt.hasTapHandler(r11)
                if (r11 == 0) goto Lc2
                com.urbanairship.android.layout.model.ButtonModel r11 = r9.this$0
                com.urbanairship.android.layout.info.View r11 = r11.getViewInfo()
                com.urbanairship.android.layout.info.Button r11 = (com.urbanairship.android.layout.info.Button) r11
                java.util.List r11 = r11.getClickBehaviors()
                boolean r11 = com.urbanairship.android.layout.property.ButtonClickBehaviorTypeKt.getHasFormSubmit(r11)
                if (r11 != 0) goto Lc2
                com.urbanairship.android.layout.model.ButtonModel r11 = r9.this$0
                com.urbanairship.android.layout.property.EventHandler$Type r1 = com.urbanairship.android.layout.property.EventHandler.Type.TAP
                r3 = 2
                r4 = 0
                com.urbanairship.android.layout.model.BaseModel.handleViewEvent$default(r11, r1, r4, r3, r4)
            Lc2:
                com.urbanairship.android.layout.model.ButtonModel r11 = r9.this$0
                android.view.View r1 = r9.$view
                android.content.Context r1 = r1.getContext()
                if (r1 != 0) goto Ld5
                android.content.Context r1 = com.urbanairship.UAirship.getApplicationContext()
                java.lang.String r3 = "getApplicationContext(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            Ld5:
                r10.L$0 = r9
                r10.label = r2
                java.lang.Object r10 = com.urbanairship.android.layout.model.ButtonModel.access$evaluateClickBehaviors(r11, r1, r10)
                if (r10 != r0) goto Le0
                return r0
            Le0:
                com.urbanairship.android.layout.model.ButtonModel r9 = r9.this$0
                com.urbanairship.android.layout.model.ButtonModel$Listener r9 = r9.getListener()
                if (r9 == 0) goto Leb
                r9.setEnabled(r2)
            Leb:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.ButtonModel$onViewAttached$1.AnonymousClass1.emit(kotlin.Unit, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Unit> flowTaps = ((TappableView) this.$view).taps();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$view);
            this.label = 1;
            if (flowTaps.collect(anonymousClass1, this) == coroutine_suspended) {
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
