package com.contentsquare.android.sdk;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.j7 */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.processing.TelemetryManager", m1845f = "TelemetryManager.kt", m1846i = {0, 0, 1, 1}, m1847l = {263, 264}, m1848m = "processReport", m1849n = {"this", "reportType", "this", "reportType"}, m1850s = {"L$0", "L$1", "L$0", "L$1"})
public final class C2788j7 extends ContinuationImpl {

    /* JADX INFO: renamed from: a */
    public C2768h7 f2784a;

    /* JADX INFO: renamed from: b */
    public String f2785b;

    /* JADX INFO: renamed from: c */
    public Iterator f2786c;

    /* JADX INFO: renamed from: d */
    public /* synthetic */ Object f2787d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C2768h7 f2788e;

    /* JADX INFO: renamed from: f */
    public int f2789f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2788j7(C2768h7 c2768h7, Continuation<? super C2788j7> continuation) {
        super(continuation);
        this.f2788e = c2768h7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2787d = obj;
        this.f2789f |= Integer.MIN_VALUE;
        return C2768h7.m1144a(this.f2788e, null, this);
    }
}
