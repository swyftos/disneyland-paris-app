package com.contentsquare.android.sdk;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.o7 */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.processing.TelemetryReportProcessor", m1845f = "TelemetryReportProcessor.kt", m1846i = {0, 1, 2, 3, 4, 5}, m1847l = {27, 28, 29, 30, 31, 32}, m1848m = "collectEventsFromAgents", m1849n = {"this", "this", "this", "this", "this", "this"}, m1850s = {"L$0", "L$0", "L$0", "L$0", "L$0", "L$0"})
public final class C2838o7 extends ContinuationImpl {

    /* JADX INFO: renamed from: a */
    public C2848p7 f2980a;

    /* JADX INFO: renamed from: b */
    public Iterator f2981b;

    /* JADX INFO: renamed from: c */
    public Object f2982c;

    /* JADX INFO: renamed from: d */
    public /* synthetic */ Object f2983d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C2848p7 f2984e;

    /* JADX INFO: renamed from: f */
    public int f2985f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2838o7(C2848p7 c2848p7, Continuation<? super C2838o7> continuation) {
        super(continuation);
        this.f2984e = c2848p7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2983d = obj;
        this.f2985f |= Integer.MIN_VALUE;
        return this.f2984e.m1193a(null, this);
    }
}
