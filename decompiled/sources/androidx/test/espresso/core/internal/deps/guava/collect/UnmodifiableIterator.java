package androidx.test.espresso.core.internal.deps.guava.collect;

import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class UnmodifiableIterator<E> implements Iterator<E> {
    protected UnmodifiableIterator() {
    }

    @Override // java.util.Iterator
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
