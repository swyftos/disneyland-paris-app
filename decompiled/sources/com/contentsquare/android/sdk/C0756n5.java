package com.contentsquare.android.sdk;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.ScrollViewCaptureUseCase$capture$2", f = "ScrollViewCaptureUseCase.kt", i = {2}, l = {37, 42, 49}, m = "invokeSuspend", n = {"throwable"}, s = {"L$2"})
/* renamed from: com.contentsquare.android.sdk.n5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0756n5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    public Object a;
    public Object b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ C0766o5 e;
    public final /* synthetic */ AbstractC0844w5 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0756n5(C0766o5 c0766o5, AbstractC0844w5 abstractC0844w5, Continuation<? super C0756n5> continuation) {
        super(2, continuation);
        this.e = c0766o5;
        this.f = abstractC0844w5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        C0756n5 c0756n5 = new C0756n5(this.e, this.f, continuation);
        c0756n5.d = obj;
        return c0756n5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return ((C0756n5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00fe  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0756n5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
