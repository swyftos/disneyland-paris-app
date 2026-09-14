package com.contentsquare.android.sdk;

import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.m8 */
/* JADX INFO: loaded from: classes2.dex */
public final class RunnableC2819m8 implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ CancellableContinuation<Unit> f2889a;

    public RunnableC2819m8(CancellableContinuationImpl cancellableContinuationImpl) {
        this.f2889a = cancellableContinuationImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CancellableContinuation<Unit> cancellableContinuation = this.f2889a;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m5277constructorimpl(Unit.INSTANCE));
    }
}
