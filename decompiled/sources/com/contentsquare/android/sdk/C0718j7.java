package com.contentsquare.android.sdk;

import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "com.contentsquare.android.internal.core.telemetry.processing.TelemetryManager", f = "TelemetryManager.kt", i = {0, 0, 1, 1}, l = {263, 264}, m = "processReport", n = {"this", "reportType", "this", "reportType"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* renamed from: com.contentsquare.android.sdk.j7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0718j7 extends ContinuationImpl {
    public C0698h7 a;
    public String b;
    public Iterator c;
    public /* synthetic */ Object d;
    public final /* synthetic */ C0698h7 e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0718j7(C0698h7 c0698h7, Continuation<? super C0718j7> continuation) {
        super(continuation);
        this.e = c0698h7;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return C0698h7.a(this.e, null, this);
    }
}
