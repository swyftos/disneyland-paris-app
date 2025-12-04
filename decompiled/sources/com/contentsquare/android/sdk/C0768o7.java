package com.contentsquare.android.sdk;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.processing.TelemetryReportProcessor", f = "TelemetryReportProcessor.kt", i = {0, 1, 2, 3, 4, 5}, l = {27, 28, 29, 30, 31, 32}, m = "collectEventsFromAgents", n = {"this", "this", "this", "this", "this", "this"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0", "L$0"})
/* renamed from: com.contentsquare.android.sdk.o7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0768o7 extends ContinuationImpl {
    public C0778p7 a;
    public Iterator b;
    public Object c;
    public /* synthetic */ Object d;
    public final /* synthetic */ C0778p7 e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0768o7(C0778p7 c0778p7, Continuation<? super C0768o7> continuation) {
        super(continuation);
        this.e = c0778p7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.a(null, this);
    }
}
