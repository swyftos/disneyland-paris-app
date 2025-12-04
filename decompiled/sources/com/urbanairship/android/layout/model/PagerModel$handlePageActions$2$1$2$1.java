package com.urbanairship.android.layout.model;

import com.urbanairship.android.layout.environment.SharedState;
import com.urbanairship.android.layout.environment.State;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* loaded from: classes5.dex */
final class PagerModel$handlePageActions$2$1$2$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ PagerModel$handlePageActions$2$1$1 $this_apply;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PagerModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagerModel$handlePageActions$2$1$2$1(PagerModel pagerModel, PagerModel$handlePageActions$2$1$1 pagerModel$handlePageActions$2$1$1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = pagerModel;
        this.$this_apply = pagerModel$handlePageActions$2$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PagerModel$handlePageActions$2$1$2$1 pagerModel$handlePageActions$2$1$2$1 = new PagerModel$handlePageActions$2$1$2$1(this.this$0, this.$this_apply, continuation);
        pagerModel$handlePageActions$2$1$2$1.L$0 = obj;
        return pagerModel$handlePageActions$2$1$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PagerModel$handlePageActions$2$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        while (CoroutineScopeKt.isActive(coroutineScope)) {
            SharedState sharedState = this.this$0.pagerState;
            final PagerModel$handlePageActions$2$1$1 pagerModel$handlePageActions$2$1$1 = this.$this_apply;
            sharedState.update(new Function1() { // from class: com.urbanairship.android.layout.model.PagerModel$handlePageActions$2$1$2$1.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final State.Pager invoke(State.Pager state) {
                    Intrinsics.checkNotNullParameter(state, "state");
                    return State.Pager.copy$default(state, null, 0, 0, false, null, null, getProgress(), false, false, false, false, null, false, 8127, null);
                }
            });
            this.L$0 = coroutineScope;
            this.label = 1;
            if (DelayKt.delay(100L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
