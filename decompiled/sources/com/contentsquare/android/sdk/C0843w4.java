package com.contentsquare.android.sdk;

import android.graphics.Rect;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.bouncycastle.asn1.eac.EACTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.RecyclerViewCaptureUseCase$capture$2", f = "RecyclerViewCaptureUseCase.kt", i = {0, 0, 0, 0, 0, 2}, l = {64, EACTags.ELEMENT_LIST, EACTags.ANSWER_TO_RESET}, m = "invokeSuspend", n = {"recyclerView", "snapshotId", "scrollRect", "delayAfterScrollMilliseconds", "numberOfItems", "throwable"}, s = {"L$2", "L$3", "L$4", "I$0", "I$1", "L$2"})
/* renamed from: com.contentsquare.android.sdk.w4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0843w4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    public Object a;
    public Object b;
    public String c;
    public Rect d;
    public int e;
    public int f;
    public int g;
    public /* synthetic */ Object h;
    public final /* synthetic */ C0834v4 i;
    public final /* synthetic */ AbstractC0844w5 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0843w4(C0834v4 c0834v4, AbstractC0844w5 abstractC0844w5, Continuation<? super C0843w4> continuation) {
        super(2, continuation);
        this.i = c0834v4;
        this.j = abstractC0844w5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        C0843w4 c0843w4 = new C0843w4(this.i, this.j, continuation);
        c0843w4.h = obj;
        return c0843w4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return ((C0843w4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x018d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0843w4.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
