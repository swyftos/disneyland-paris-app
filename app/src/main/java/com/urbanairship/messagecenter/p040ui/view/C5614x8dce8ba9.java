package com.urbanairship.messagecenter.p040ui.view;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: renamed from: com.urbanairship.messagecenter.ui.view.MessageViewModel$subscribeForMessageUpdates$listener$1$onInboxUpdated$1 */
/* JADX INFO: loaded from: classes5.dex */
final class C5614x8dce8ba9 extends SuspendLambda implements Function2 {
    final /* synthetic */ String $messageId;
    Object L$0;
    int label;
    final /* synthetic */ MessageViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C5614x8dce8ba9(MessageViewModel messageViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = messageViewModel;
        this.$messageId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C5614x8dce8ba9(this.this$0, this.$messageId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((C5614x8dce8ba9) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableStateFlow mutableStateFlow2 = this.this$0._states;
            MessageViewModel messageViewModel = this.this$0;
            String str = this.$messageId;
            this.L$0 = mutableStateFlow2;
            this.label = 1;
            Object orFetchMessage = messageViewModel.getOrFetchMessage(str, this);
            if (orFetchMessage == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = orFetchMessage;
            mutableStateFlow = mutableStateFlow2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableStateFlow = (MutableStateFlow) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        mutableStateFlow.setValue(obj);
        return Unit.INSTANCE;
    }
}
