package com.contentsquare.android.sdk;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.g4 */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.agent.PublicUsageAgent", m1845f = "PublicUsageAgent.kt", m1846i = {0}, m1847l = {109}, m1848m = "storeOnDisk", m1849n = {"this"}, m1850s = {"L$0"})
public final class C2755g4 extends ContinuationImpl {

    /* JADX INFO: renamed from: a */
    public C2745f4 f2665a;

    /* JADX INFO: renamed from: b */
    public /* synthetic */ Object f2666b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C2745f4 f2667c;

    /* JADX INFO: renamed from: d */
    public int f2668d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2755g4(C2745f4 c2745f4, Continuation<? super C2755g4> continuation) {
        super(continuation);
        this.f2667c = c2745f4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2666b = obj;
        this.f2668d |= Integer.MIN_VALUE;
        return this.f2667c.m1127c(this);
    }
}
