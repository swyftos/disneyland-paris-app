package com.contentsquare.android.sdk;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.agent.PublicUsageAgent", f = "PublicUsageAgent.kt", i = {0}, l = {109}, m = "storeOnDisk", n = {"this"}, s = {"L$0"})
/* renamed from: com.contentsquare.android.sdk.g4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0685g4 extends ContinuationImpl {
    public C0675f4 a;
    public /* synthetic */ Object b;
    public final /* synthetic */ C0675f4 c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0685g4(C0675f4 c0675f4, Continuation<? super C0685g4> continuation) {
        super(continuation);
        this.c = c0675f4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.c(this);
    }
}
