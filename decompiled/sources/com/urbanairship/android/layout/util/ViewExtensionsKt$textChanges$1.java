package com.urbanairship.android.layout.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes5.dex */
final class ViewExtensionsKt$textChanges$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ EditText $this_textChanges;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ViewExtensionsKt$textChanges$1(EditText editText, Continuation continuation) {
        super(2, continuation);
        this.$this_textChanges = editText;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ViewExtensionsKt$textChanges$1 viewExtensionsKt$textChanges$1 = new ViewExtensionsKt$textChanges$1(this.$this_textChanges, continuation);
        viewExtensionsKt$textChanges$1.L$0 = obj;
        return viewExtensionsKt$textChanges$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((ViewExtensionsKt$textChanges$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.text.TextWatcher, com.urbanairship.android.layout.util.ViewExtensionsKt$textChanges$1$listener$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            ViewExtensionsKt.checkMainThread();
            final ?? r1 = new TextWatcher() { // from class: com.urbanairship.android.layout.util.ViewExtensionsKt$textChanges$1$listener$1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(@NotNull CharSequence s, int start, int count, int after) {
                    Intrinsics.checkNotNullParameter(s, "s");
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(@NotNull CharSequence s, int start, int before, int count) {
                    Intrinsics.checkNotNullParameter(s, "s");
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(@NotNull Editable s) {
                    Intrinsics.checkNotNullParameter(s, "s");
                    producerScope.mo3620trySendJP2dKIU(s.toString());
                }
            };
            this.$this_textChanges.addTextChangedListener(r1);
            final EditText editText = this.$this_textChanges;
            Function0 function0 = new Function0() { // from class: com.urbanairship.android.layout.util.ViewExtensionsKt$textChanges$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2753invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2753invoke() {
                    editText.removeTextChangedListener(r1);
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
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
