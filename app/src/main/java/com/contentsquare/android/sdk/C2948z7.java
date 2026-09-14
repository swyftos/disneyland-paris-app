package com.contentsquare.android.sdk;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.z7 */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m1844c = "com.contentsquare.android.internal.core.telemetry.agent.TimeAgent", m1845f = "TimeAgent.kt", m1846i = {0}, m1847l = {80}, m1848m = "storeOnDisk", m1849n = {"this"}, m1850s = {"L$0"})
public final class C2948z7 extends ContinuationImpl {

    /* JADX INFO: renamed from: a */
    public C2938y7 f3317a;

    /* JADX INFO: renamed from: b */
    public /* synthetic */ Object f3318b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C2938y7 f3319c;

    /* JADX INFO: renamed from: d */
    public int f3320d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2948z7(C2938y7 c2938y7, Continuation<? super C2948z7> continuation) {
        super(continuation);
        this.f3319c = c2938y7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f3318b = obj;
        this.f3320d |= Integer.MIN_VALUE;
        return this.f3319c.m1237c(this);
    }
}
