package com.contentsquare.android.sdk;

import com.contentsquare.android.api.Currencies;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.OverlayViewModel$resumeSnapshot$1", f = "OverlayViewModel.kt", i = {}, l = {Currencies.CNY}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class G3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ H3 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G3(H3 h3, Continuation<? super G3> continuation) {
        super(2, continuation);
        this.b = h3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new G3(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new G3(this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.a
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.ResultKt.throwOnFailure(r5)
            goto L48
        Lf:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L17:
            kotlin.ResultKt.throwOnFailure(r5)
            com.contentsquare.android.sdk.H3 r5 = r4.b
            com.contentsquare.android.sdk.o5 r5 = r5.b
            r4.a = r2
            com.contentsquare.android.sdk.Y2 r1 = r5.c
            java.util.concurrent.atomic.AtomicBoolean r1 = r1.a
            r2 = 0
            r1.set(r2)
            com.contentsquare.android.sdk.o5$d r1 = r5.e
            if (r1 == 0) goto L43
            r2 = 0
            r5.e = r2
            kotlinx.coroutines.MainCoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getMain()
            com.contentsquare.android.sdk.p5 r3 = new com.contentsquare.android.sdk.p5
            r3.<init>(r1, r2)
            java.lang.Object r4 = kotlinx.coroutines.BuildersKt.withContext(r5, r3, r4)
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r5) goto L43
            goto L45
        L43:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L45:
            if (r4 != r0) goto L48
            return r0
        L48:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.G3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
