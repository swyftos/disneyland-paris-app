package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Optional;

/* loaded from: classes2.dex */
public abstract class FluentIterable<E> implements Iterable<E> {
    private final Optional iterableDelegate = Optional.absent();

    protected FluentIterable() {
    }

    private Iterable getDelegate() {
        return (Iterable) this.iterableDelegate.or((Optional) this);
    }

    public String toString() {
        return Iterables.toString(getDelegate());
    }
}
