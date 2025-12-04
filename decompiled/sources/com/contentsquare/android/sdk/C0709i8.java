package com.contentsquare.android.sdk;

import com.contentsquare.android.sdk.C0699h8;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.i8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0709i8 {
    public final /* synthetic */ Continuation<InterfaceC0679f8> a;

    public C0709i8(SafeContinuation safeContinuation) {
        this.a = safeContinuation;
    }

    public final void a(@NotNull String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Continuation<InterfaceC0679f8> continuation = this.a;
        Result.Companion companion = Result.INSTANCE;
        continuation.resumeWith(Result.m2968constructorimpl(ResultKt.createFailure(new IllegalStateException(error))));
    }

    public final void a(@NotNull C0699h8.a result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.a.resumeWith(Result.m2968constructorimpl(result));
    }
}
