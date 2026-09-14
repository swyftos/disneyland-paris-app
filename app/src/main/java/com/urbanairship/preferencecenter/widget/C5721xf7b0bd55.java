package com.urbanairship.preferencecenter.widget;

import androidx.appcompat.app.AlertDialog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.urbanairship.preferencecenter.widget.ContactChannelManagementDialogsKt$showContactManagementAddDialog$2$2 */
/* JADX INFO: loaded from: classes5.dex */
final class C5721xf7b0bd55 extends SuspendLambda implements Function2 {
    final /* synthetic */ AlertDialog $dialog;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C5721xf7b0bd55(AlertDialog alertDialog, Continuation continuation) {
        super(2, continuation);
        this.$dialog = alertDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C5721xf7b0bd55(this.$dialog, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Unit unit, Continuation continuation) {
        return ((C5721xf7b0bd55) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$dialog.dismiss();
        return Unit.INSTANCE;
    }
}
