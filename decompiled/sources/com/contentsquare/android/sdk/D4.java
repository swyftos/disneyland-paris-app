package com.contentsquare.android.sdk;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.RecyclerViewScroller", f = "RecyclerViewScroller.kt", i = {0}, l = {17, 20}, m = "scrollToPositionAndWait", n = {"delayAfterScrollMilliseconds"}, s = {"I$0"})
/* loaded from: classes2.dex */
public final class D4 extends ContinuationImpl {
    public int a;
    public /* synthetic */ Object b;
    public final /* synthetic */ C4 c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D4(C4 c4, Continuation<? super D4> continuation) {
        super(continuation);
        this.c = c4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.a(null, 0, this);
    }
}
