package com.urbanairship.android.layout.model;

import com.urbanairship.android.layout.environment.LayoutEvent;
import com.urbanairship.android.layout.model.BaseFormController;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class BaseFormController$wireFormValidation$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseFormController.C09281.C00941 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseFormController$wireFormValidation$1$1$emit$1(BaseFormController.C09281.C00941 c00941, Continuation continuation) {
        super(continuation);
        this.this$0 = c00941;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((LayoutEvent.ValidateForm) null, (Continuation) this);
    }
}
