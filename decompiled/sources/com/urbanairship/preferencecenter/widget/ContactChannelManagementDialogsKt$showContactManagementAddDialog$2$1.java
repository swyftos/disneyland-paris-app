package com.urbanairship.preferencecenter.widget;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
final class ContactChannelManagementDialogsKt$showContactManagementAddDialog$2$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ ContactChannelDialogInputView $inputView;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContactChannelManagementDialogsKt$showContactManagementAddDialog$2$1(ContactChannelDialogInputView contactChannelDialogInputView, Continuation continuation) {
        super(2, continuation);
        this.$inputView = contactChannelDialogInputView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ContactChannelManagementDialogsKt$showContactManagementAddDialog$2$1 contactChannelManagementDialogsKt$showContactManagementAddDialog$2$1 = new ContactChannelManagementDialogsKt$showContactManagementAddDialog$2$1(this.$inputView, continuation);
        contactChannelManagementDialogsKt$showContactManagementAddDialog$2$1.L$0 = obj;
        return contactChannelManagementDialogsKt$showContactManagementAddDialog$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation continuation) {
        return ((ContactChannelManagementDialogsKt$showContactManagementAddDialog$2$1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
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
