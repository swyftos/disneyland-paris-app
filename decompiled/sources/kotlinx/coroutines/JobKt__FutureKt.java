package kotlinx.coroutines;

import java.util.concurrent.Future;

/* loaded from: classes6.dex */
abstract /* synthetic */ class JobKt__FutureKt {
    public static final void cancelFutureOnCancellation(CancellableContinuation cancellableContinuation, Future future) {
        CancellableContinuationKt.invokeOnCancellation(cancellableContinuation, new PublicCancelFutureOnCancel(future));
    }
}
