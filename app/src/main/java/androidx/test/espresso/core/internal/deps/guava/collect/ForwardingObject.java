package androidx.test.espresso.core.internal.deps.guava.collect;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingObject {
    protected ForwardingObject() {
    }

    protected abstract Object delegate();

    public String toString() {
        return delegate().toString();
    }
}
