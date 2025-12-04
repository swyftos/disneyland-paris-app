package com.contentsquare.android.sdk;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.agent.TimeAgent", f = "TimeAgent.kt", i = {0}, l = {80}, m = "storeOnDisk", n = {"this"}, s = {"L$0"})
/* renamed from: com.contentsquare.android.sdk.z7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0873z7 extends ContinuationImpl {
    public C0864y7 a;
    public /* synthetic */ Object b;
    public final /* synthetic */ C0864y7 c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0873z7(C0864y7 c0864y7, Continuation<? super C0873z7> continuation) {
        super(continuation);
        this.c = c0864y7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.c(this);
    }
}
