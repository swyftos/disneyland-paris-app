package com.contentsquare.android.sdk;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.A4 */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.analytics.internal.features.clientmode.ui.overlay.captureusecase.RecyclerViewCaptureUseCase", m1845f = "RecyclerViewCaptureUseCase.kt", m1846i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, m1847l = {141, 150}, m1848m = "scrollViewUntilTargetPosition", m1849n = {"this", "config", "snapshotId", "scrollContainer", "scrollRect", "numberOfItems", "delayAfterScrollMilliseconds", "this", "config", "snapshotId", "scrollContainer", "scrollRect", "numberOfItems", "delayAfterScrollMilliseconds"}, m1850s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"})
public final class C2441A4 extends ContinuationImpl {

    /* JADX INFO: renamed from: a */
    public C2905v4 f1390a;

    /* JADX INFO: renamed from: b */
    public AbstractC2916w5 f1391b;

    /* JADX INFO: renamed from: c */
    public String f1392c;

    /* JADX INFO: renamed from: d */
    public RecyclerView f1393d;

    /* JADX INFO: renamed from: e */
    public Rect f1394e;

    /* JADX INFO: renamed from: f */
    public int f1395f;

    /* JADX INFO: renamed from: g */
    public int f1396g;

    /* JADX INFO: renamed from: h */
    public /* synthetic */ Object f1397h;

    /* JADX INFO: renamed from: i */
    public final /* synthetic */ C2905v4 f1398i;

    /* JADX INFO: renamed from: j */
    public int f1399j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2441A4(C2905v4 c2905v4, Continuation<? super C2441A4> continuation) {
        super(continuation);
        this.f1398i = c2905v4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f1397h = obj;
        this.f1399j |= Integer.MIN_VALUE;
        return C2905v4.m1217a(this.f1398i, null, null, null, null, 0, 0, this);
    }
}
