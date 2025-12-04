package com.google.common.collect;

import java.util.ListIterator;

/* loaded from: classes4.dex */
abstract class TransformedListIterator extends TransformedIterator implements ListIterator {
    TransformedListIterator(ListIterator listIterator) {
        super(listIterator);
    }

    private ListIterator backingIterator() {
        return (ListIterator) this.backingIterator;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return backingIterator().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return transform(backingIterator().previous());
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return backingIterator().nextIndex();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return backingIterator().previousIndex();
    }

    public void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        throw new UnsupportedOperationException();
    }
}
