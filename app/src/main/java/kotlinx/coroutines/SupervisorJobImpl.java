package kotlinx.coroutines;

/* JADX INFO: loaded from: classes6.dex */
final class SupervisorJobImpl extends JobImpl {
    @Override // kotlinx.coroutines.JobSupport
    public boolean childCancelled(Throwable th) {
        return false;
    }

    public SupervisorJobImpl(Job job) {
        super(job);
    }
}
