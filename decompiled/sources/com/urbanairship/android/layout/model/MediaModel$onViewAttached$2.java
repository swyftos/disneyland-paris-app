package com.urbanairship.android.layout.model;

import com.urbanairship.android.layout.environment.SharedState;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.model.MediaModel;
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
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes5.dex */
final class MediaModel$onViewAttached$2 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ MediaModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaModel$onViewAttached$2(MediaModel mediaModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = mediaModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MediaModel$onViewAttached$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((MediaModel$onViewAttached$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SharedState<State.Pager> pagerState;
        StateFlow<State.Pager> changes;
        Flow flowDistinctUntilChanged;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.isPlayableMedia && (pagerState = this.this$0.getPagerState()) != null && (changes = pagerState.getChanges()) != null && (flowDistinctUntilChanged = FlowKt.distinctUntilChanged(changes, new Function2() { // from class: com.urbanairship.android.layout.model.MediaModel$onViewAttached$2.1
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(State.Pager old, State.Pager pager) {
                    Intrinsics.checkNotNullParameter(old, "old");
                    Intrinsics.checkNotNullParameter(pager, "new");
                    return Boolean.valueOf(old.isStoryPaused() == pager.isStoryPaused());
                }
            })) != null) {
                final MediaModel mediaModel = this.this$0;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.MediaModel$onViewAttached$2.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(State.Pager pager, Continuation continuation) {
                        if (pager.isStoryPaused()) {
                            MediaModel.Listener listener = mediaModel.getListener();
                            if (listener != null) {
                                listener.onPause();
                            }
                        } else {
                            MediaModel.Listener listener2 = mediaModel.getListener();
                            if (listener2 != null) {
                                listener2.onResume();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flowDistinctUntilChanged.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
