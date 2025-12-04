package com.contentsquare.android.sdk;

import android.view.View;
import android.view.ViewGroup;
import com.contentsquare.android.api.model.CustomVar;
import com.contentsquare.android.sdk.Q7;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.screencapture.screenrecorder.VerticalComposeLazyScreenRecorder$generateScreenGraph$2", f = "VerticalComposeLazyScreenRecorder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class R7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super U4>, Object> {
    public final /* synthetic */ Q7 a;
    public final /* synthetic */ InterfaceC0679f8 b;
    public final /* synthetic */ Function2<View, G2, Unit> c;
    public final /* synthetic */ String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public R7(Q7 q7, InterfaceC0679f8 interfaceC0679f8, Q7.d dVar, String str, Continuation continuation) {
        super(2, continuation);
        this.a = q7;
        this.b = interfaceC0679f8;
        this.c = dVar;
        this.d = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new R7(this.a, this.b, (Q7.d) this.c, this.d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super U4> continuation) {
        return ((R7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        Q7 q7 = this.a;
        H7 h7 = q7.f;
        ViewGroup viewGroupB = q7.b();
        if (viewGroupB == null) {
            return null;
        }
        Q7 q72 = this.a;
        CustomVar[] customVarArr = ((C0723k2) q72.b).f;
        K1 k1 = q72.e;
        InterfaceC0679f8 interfaceC0679f8 = this.b;
        W4 w4 = new W4(q72.b(), false);
        Q7 q73 = this.a;
        U4 u4A = h7.a(viewGroupB, customVarArr, k1, interfaceC0679f8, w4, new Q7.a(q73.k, q73.m), this.c);
        String str = this.d;
        Q7 q74 = this.a;
        u4A.a = str;
        String strC = q74.c();
        Intrinsics.checkNotNullParameter(strC, "<set-?>");
        u4A.b = strC;
        return u4A;
    }
}
