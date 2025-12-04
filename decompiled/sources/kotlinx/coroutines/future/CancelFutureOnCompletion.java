package kotlinx.coroutines.future;

import java.util.concurrent.Future;
import kotlinx.coroutines.JobNode;

/* loaded from: classes6.dex */
final class CancelFutureOnCompletion extends JobNode {
    private final Future future;

    @Override // kotlinx.coroutines.JobNode
    public boolean getOnCancelling() {
        return false;
    }

    public CancelFutureOnCompletion(Future future) {
        this.future = future;
    }

    @Override // kotlinx.coroutines.JobNode
    public void invoke(Throwable th) {
        if (th == null || this.future.isDone()) {
            return;
        }
        this.future.cancel(false);
    }
}
