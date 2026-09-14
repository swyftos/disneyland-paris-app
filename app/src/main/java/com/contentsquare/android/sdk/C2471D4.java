package com.contentsquare.android.sdk;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.D4 */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.RecyclerViewScroller", m1845f = "RecyclerViewScroller.kt", m1846i = {0}, m1847l = {17, 20}, m1848m = "scrollToPositionAndWait", m1849n = {"delayAfterScrollMilliseconds"}, m1850s = {"I$0"})
public final class C2471D4 extends ContinuationImpl {

    /* JADX INFO: renamed from: a */
    public int f1515a;

    /* JADX INFO: renamed from: b */
    public /* synthetic */ Object f1516b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C2461C4 f1517c;

    /* JADX INFO: renamed from: d */
    public int f1518d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2471D4(C2461C4 c2461c4, Continuation<? super C2471D4> continuation) {
        super(continuation);
        this.f1517c = c2461c4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f1516b = obj;
        this.f1518d |= Integer.MIN_VALUE;
        return this.f1517c.m884a(null, 0, this);
    }
}
