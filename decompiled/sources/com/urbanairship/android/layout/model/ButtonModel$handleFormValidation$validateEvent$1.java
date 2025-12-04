package com.urbanairship.android.layout.model;

import android.content.Context;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
final class ButtonModel$handleFormValidation$validateEvent$1 extends SuspendLambda implements Function1 {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ ButtonModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ButtonModel$handleFormValidation$validateEvent$1(ButtonModel buttonModel, Context context, Continuation continuation) {
        super(1, continuation);
        this.this$0 = buttonModel;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new ButtonModel$handleFormValidation$validateEvent$1(this.this$0, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((ButtonModel$handleFormValidation$validateEvent$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ac  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2e
            if (r1 == r5) goto L2a
            if (r1 == r4) goto L26
            if (r1 == r3) goto L21
            if (r1 != r2) goto L19
            kotlin.ResultKt.throwOnFailure(r7)
            goto Lb7
        L19:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L21:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L9a
        L26:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L7d
        L2a:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L50
        L2e:
            kotlin.ResultKt.throwOnFailure(r7)
            com.urbanairship.android.layout.model.ButtonModel r7 = r6.this$0
            com.urbanairship.android.layout.info.View r7 = r7.getViewInfo()
            com.urbanairship.android.layout.info.Button r7 = (com.urbanairship.android.layout.info.Button) r7
            java.util.List r7 = r7.getClickBehaviors()
            boolean r7 = com.urbanairship.android.layout.property.ButtonClickBehaviorTypeKt.getHasFormSubmit(r7)
            if (r7 == 0) goto L50
            com.urbanairship.android.layout.model.ButtonModel r7 = r6.this$0
            android.content.Context r1 = r6.$context
            r6.label = r5
            java.lang.Object r7 = com.urbanairship.android.layout.model.ButtonModel.access$handleSubmit(r7, r1, r6)
            if (r7 != r0) goto L50
            return r0
        L50:
            com.urbanairship.android.layout.model.ButtonModel r7 = r6.this$0
            com.urbanairship.android.layout.info.View r7 = r7.getViewInfo()
            com.urbanairship.android.layout.info.Button r7 = (com.urbanairship.android.layout.info.Button) r7
            java.util.List r7 = r7.getClickBehaviors()
            boolean r7 = com.urbanairship.android.layout.property.ButtonClickBehaviorTypeKt.getHasCancelOrDismiss(r7)
            if (r7 == 0) goto L7d
            com.urbanairship.android.layout.model.ButtonModel r7 = r6.this$0
            android.content.Context r1 = r6.$context
            com.urbanairship.android.layout.info.View r5 = r7.getViewInfo()
            com.urbanairship.android.layout.info.Button r5 = (com.urbanairship.android.layout.info.Button) r5
            java.util.List r5 = r5.getClickBehaviors()
            boolean r5 = com.urbanairship.android.layout.property.ButtonClickBehaviorTypeKt.getHasCancel(r5)
            r6.label = r4
            java.lang.Object r7 = com.urbanairship.android.layout.model.ButtonModel.access$handleDismiss(r7, r1, r5, r6)
            if (r7 != r0) goto L7d
            return r0
        L7d:
            com.urbanairship.android.layout.model.ButtonModel r7 = r6.this$0
            com.urbanairship.android.layout.info.View r7 = r7.getViewInfo()
            com.urbanairship.android.layout.info.Button r7 = (com.urbanairship.android.layout.info.Button) r7
            java.util.List r7 = r7.getClickBehaviors()
            boolean r7 = com.urbanairship.android.layout.property.ButtonClickBehaviorTypeKt.getHasPagerNext(r7)
            if (r7 == 0) goto L9a
            com.urbanairship.android.layout.model.ButtonModel r7 = r6.this$0
            r6.label = r3
            java.lang.Object r7 = com.urbanairship.android.layout.model.ButtonModel.access$handlePagerNext(r7, r6)
            if (r7 != r0) goto L9a
            return r0
        L9a:
            com.urbanairship.android.layout.model.ButtonModel r7 = r6.this$0
            com.urbanairship.android.layout.info.View r7 = r7.getViewInfo()
            com.urbanairship.android.layout.info.Button r7 = (com.urbanairship.android.layout.info.Button) r7
            java.util.List r7 = r7.getClickBehaviors()
            boolean r7 = com.urbanairship.android.layout.property.ButtonClickBehaviorTypeKt.getHasPagerPrevious(r7)
            if (r7 == 0) goto Lb7
            com.urbanairship.android.layout.model.ButtonModel r7 = r6.this$0
            r6.label = r2
            java.lang.Object r6 = com.urbanairship.android.layout.model.ButtonModel.access$handlePagerPrevious(r7, r6)
            if (r6 != r0) goto Lb7
            return r0
        Lb7:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.ButtonModel$handleFormValidation$validateEvent$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
