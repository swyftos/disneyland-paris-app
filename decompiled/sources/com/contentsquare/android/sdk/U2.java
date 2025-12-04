package com.contentsquare.android.sdk;

import android.app.Activity;
import com.contentsquare.android.R;
import com.contentsquare.android.sdk.AbstractC0655d4;
import com.contentsquare.android.sdk.AbstractC0827u7;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.explanation.LongSnapshotExplanationLayoutManager$displayExplanation$1", f = "LongSnapshotExplanationLayoutManager.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class U2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public DialogFragmentC0642c1 a;
    public W2 b;
    public int c;
    public final /* synthetic */ W2 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U2(W2 w2, Continuation<? super U2> continuation) {
        super(2, continuation);
        this.d = w2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new U2(this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new U2(this.d, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        DialogFragmentC0642c1 dialogFragmentC0642c1;
        W2 w2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.c;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            W2 w22 = this.d;
            dialogFragmentC0642c1 = new DialogFragmentC0642c1();
            W2 w23 = this.d;
            Activity activity = w23.a.a.get();
            if (activity != null) {
                this.a = dialogFragmentC0642c1;
                this.b = w22;
                this.c = 1;
                if (dialogFragmentC0642c1.a(activity, w23, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            w2 = w22;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            w2 = this.b;
            dialogFragmentC0642c1 = this.a;
            ResultKt.throwOnFailure(obj);
        }
        w2.d = dialogFragmentC0642c1;
        W2 w24 = this.d;
        Function1<? super C0652d1, Unit> function1 = w24.e;
        if (function1 != null) {
            function1.invoke(new C0652d1(new AbstractC0827u7.a(R.string.contentsquare_snapshot_explanation_title), new AbstractC0827u7.a(R.string.contentsquare_snapshot_explanation_message), new AbstractC0655d4.b(R.drawable.contentsquare_swipe_up), new C0731l0(R.string.contentsquare_snapshot_explanation_button, new V2(w24)), null, 16));
        }
        return Unit.INSTANCE;
    }
}
