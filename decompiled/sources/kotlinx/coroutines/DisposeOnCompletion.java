package kotlinx.coroutines;

/* loaded from: classes6.dex */
final class DisposeOnCompletion extends JobNode {
    private final DisposableHandle handle;

    @Override // kotlinx.coroutines.JobNode
    public boolean getOnCancelling() {
        return false;
    }

    public DisposeOnCompletion(DisposableHandle disposableHandle) {
        this.handle = disposableHandle;
    }

    @Override // kotlinx.coroutines.JobNode
    public void invoke(Throwable th) {
        this.handle.dispose();
    }
}
