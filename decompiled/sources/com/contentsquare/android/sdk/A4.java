package com.contentsquare.android.sdk;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.RecyclerViewCaptureUseCase", f = "RecyclerViewCaptureUseCase.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {141, 150}, m = "scrollViewUntilTargetPosition", n = {"this", "config", "snapshotId", "scrollContainer", "scrollRect", "numberOfItems", "delayAfterScrollMilliseconds", "this", "config", "snapshotId", "scrollContainer", "scrollRect", "numberOfItems", "delayAfterScrollMilliseconds"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"})
/* loaded from: classes2.dex */
public final class A4 extends ContinuationImpl {
    public C0834v4 a;
    public AbstractC0844w5 b;
    public String c;
    public RecyclerView d;
    public Rect e;
    public int f;
    public int g;
    public /* synthetic */ Object h;
    public final /* synthetic */ C0834v4 i;
    public int j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A4(C0834v4 c0834v4, Continuation<? super A4> continuation) {
        super(continuation);
        this.i = c0834v4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.h = obj;
        this.j |= Integer.MIN_VALUE;
        return C0834v4.a(this.i, null, null, null, null, 0, 0, this);
    }
}
