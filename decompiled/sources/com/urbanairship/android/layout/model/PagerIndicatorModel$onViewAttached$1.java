package com.urbanairship.android.layout.model;

import com.urbanairship.android.layout.environment.SharedState;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.model.PagerIndicatorModel;
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
final class PagerIndicatorModel$onViewAttached$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ PagerIndicatorModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagerIndicatorModel$onViewAttached$1(PagerIndicatorModel pagerIndicatorModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = pagerIndicatorModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PagerIndicatorModel$onViewAttached$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PagerIndicatorModel$onViewAttached$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        StateFlow<State.Pager> changes;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedState<State.Pager> pager = this.this$0.getLayoutState().getPager();
            if (pager == null || (changes = pager.getChanges()) == null) {
                return Unit.INSTANCE;
            }
            final PagerIndicatorModel pagerIndicatorModel = this.this$0;
            FlowCollector<? super State.Pager> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.PagerIndicatorModel$onViewAttached$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(State.Pager pager2, Continuation continuation) {
                    PagerIndicatorModel.Listener listener = pagerIndicatorModel.getListener();
                    if (listener != null) {
                        listener.onUpdate(pager2.getPageIds().size(), pager2.getPageIndex());
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
