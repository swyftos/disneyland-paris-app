package com.urbanairship.preferencecenter.widget;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.urbanairship.preferencecenter.widget.ContactChannelManagementDialogsKt$showContactManagementAddDialog$2$1 */
/* JADX INFO: loaded from: classes5.dex */
final class C5720xf7b0bd54 extends SuspendLambda implements Function2 {
    final /* synthetic */ ContactChannelDialogInputView $inputView;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C5720xf7b0bd54(ContactChannelDialogInputView contactChannelDialogInputView, Continuation continuation) {
        super(2, continuation);
        this.$inputView = contactChannelDialogInputView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        C5720xf7b0bd54 c5720xf7b0bd54 = new C5720xf7b0bd54(this.$inputView, continuation);
        c5720xf7b0bd54.L$0 = obj;
        return c5720xf7b0bd54;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation continuation) {
        return ((C5720xf7b0bd54) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$inputView.setError((String) this.L$0);
        return Unit.INSTANCE;
    }
}
