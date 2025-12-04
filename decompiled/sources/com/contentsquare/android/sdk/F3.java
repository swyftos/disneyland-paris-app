package com.contentsquare.android.sdk;

import com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.d;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.OverlayViewModel$captureSnapshot$1", f = "OverlayViewModel.kt", i = {0}, l = {93}, m = "invokeSuspend", n = {"config"}, s = {"L$0"})
/* loaded from: classes2.dex */
public final class F3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public AbstractC0637b6 a;
    public int b;
    public final /* synthetic */ H3 c;
    public final /* synthetic */ Function2<AbstractC0637b6, Continuation<? super Boolean>, Object> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F3(H3 h3, d.a aVar, Continuation continuation) {
        super(2, continuation);
        this.c = h3;
        this.d = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new F3(this.c, (d.a) this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new F3(this.c, (d.a) this.d, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00bc  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 520
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.F3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
