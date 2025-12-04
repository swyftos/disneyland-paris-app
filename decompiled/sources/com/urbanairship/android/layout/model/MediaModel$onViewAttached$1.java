package com.urbanairship.android.layout.model;

import com.urbanairship.android.layout.property.EventHandler;
import com.urbanairship.android.layout.view.MediaView;
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
final class MediaModel$onViewAttached$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ MediaView $view;
    int label;
    final /* synthetic */ MediaModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaModel$onViewAttached$1(MediaView mediaView, MediaModel mediaModel, Continuation continuation) {
        super(2, continuation);
        this.$view = mediaView;
        this.this$0 = mediaModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MediaModel$onViewAttached$1(this.$view, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((MediaModel$onViewAttached$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Unit> flowTaps = this.$view.taps();
            final MediaModel mediaModel = this.this$0;
            FlowCollector<? super Unit> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.MediaModel$onViewAttached$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Unit unit, Continuation continuation) {
                    BaseModel.handleViewEvent$default(mediaModel, EventHandler.Type.TAP, null, 2, null);
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (flowTaps.collect(flowCollector, this) == coroutine_suspended) {
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
