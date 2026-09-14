package com.contentsquare.android.sdk;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.i8 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2779i8 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Continuation<InterfaceC2749f8> f2751a;

    public C2779i8(SafeContinuation safeContinuation) {
        this.f2751a = safeContinuation;
    }

    /* JADX INFO: renamed from: a */
    public final void m1158a(@NotNull String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Continuation<InterfaceC2749f8> continuation = this.f2751a;
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m5277constructorimpl(ResultKt.createFailure(new IllegalStateException(error))));
    }

    /* JADX INFO: renamed from: a */
    public final void m1157a(@NotNull C2769h8.a result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.f2751a.resumeWith(Result.m5277constructorimpl(result));
    }
}
