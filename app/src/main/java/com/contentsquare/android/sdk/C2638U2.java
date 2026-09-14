package com.contentsquare.android.sdk;

import android.app.Activity;
import com.contentsquare.android.C2362R;
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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.U2 */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.explanation.LongSnapshotExplanationLayoutManager$displayExplanation$1", m1845f = "LongSnapshotExplanationLayoutManager.kt", m1846i = {}, m1847l = {41}, m1848m = "invokeSuspend", m1849n = {}, m1850s = {})
public final class C2638U2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a */
    public DialogFragmentC2712c1 f2172a;

    /* JADX INFO: renamed from: b */
    public C2657W2 f2173b;

    /* JADX INFO: renamed from: c */
    public int f2174c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ C2657W2 f2175d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2638U2(C2657W2 c2657w2, Continuation<? super C2638U2> continuation) {
        super(2, continuation);
        this.f2175d = c2657w2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new C2638U2(this.f2175d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new C2638U2(this.f2175d, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        DialogFragmentC2712c1 dialogFragmentC2712c1;
        C2657W2 c2657w2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f2174c;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            C2657W2 c2657w3 = this.f2175d;
            dialogFragmentC2712c1 = new DialogFragmentC2712c1();
            C2657W2 c2657w4 = this.f2175d;
            Activity activity = c2657w4.f2205a.f1856a.get();
            if (activity != null) {
                this.f2172a = dialogFragmentC2712c1;
                this.f2173b = c2657w3;
                this.f2174c = 1;
                if (dialogFragmentC2712c1.m1105a(activity, c2657w4, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            c2657w2 = c2657w3;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c2657w2 = this.f2173b;
            dialogFragmentC2712c1 = this.f2172a;
            ResultKt.throwOnFailure(obj);
        }
        c2657w2.f2208d = dialogFragmentC2712c1;
        C2657W2 c2657w5 = this.f2175d;
        Function1<? super C2722d1, Unit> function1 = c2657w5.f2209e;
        if (function1 != null) {
            function1.invoke(new C2722d1(new AbstractC2898u7.a(C2362R.string.contentsquare_snapshot_explanation_title), new AbstractC2898u7.a(C2362R.string.contentsquare_snapshot_explanation_message), new AbstractC2725d4.b(C2362R.drawable.contentsquare_swipe_up), new C2801l0(C2362R.string.contentsquare_snapshot_explanation_button, new C2648V2(c2657w5)), null, 16));
        }
        return Unit.INSTANCE;
    }
}
