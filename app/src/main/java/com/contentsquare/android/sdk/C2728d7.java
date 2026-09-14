package com.contentsquare.android.sdk;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.d7 */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.agent.TelemetryEventAgent", m1845f = "TelemetryEventAgent.kt", m1846i = {0}, m1847l = {97}, m1848m = "storeOnDisk", m1849n = {"this"}, m1850s = {"L$0"})
public final class C2728d7 extends ContinuationImpl {

    /* JADX INFO: renamed from: a */
    public C2718c7 f2526a;

    /* JADX INFO: renamed from: b */
    public /* synthetic */ Object f2527b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C2718c7 f2528c;

    /* JADX INFO: renamed from: d */
    public int f2529d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2728d7(C2718c7 c2718c7, Continuation<? super C2728d7> continuation) {
        super(continuation);
        this.f2528c = c2718c7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2527b = obj;
        this.f2529d |= Integer.MIN_VALUE;
        return this.f2528c.m1112c(this);
    }
}
