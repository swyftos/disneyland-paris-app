package com.contentsquare.android.sdk;

import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* renamed from: com.contentsquare.android.sdk.m8, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC0749m8 implements Runnable {
    public final /* synthetic */ CancellableContinuation<Unit> a;

    public RunnableC0749m8(CancellableContinuationImpl cancellableContinuationImpl) {
        this.a = cancellableContinuationImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CancellableContinuation<Unit> cancellableContinuation = this.a;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m2968constructorimpl(Unit.INSTANCE));
    }
}
