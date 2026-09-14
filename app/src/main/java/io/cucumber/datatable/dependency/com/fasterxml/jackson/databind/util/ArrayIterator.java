package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public class ArrayIterator<T> implements Iterator<T>, Iterable<T> {

    /* JADX INFO: renamed from: _a */
    private final Object[] f3824_a;
    private int _index = 0;

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this;
    }

    public ArrayIterator(T[] tArr) {
        this.f3824_a = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this._index < this.f3824_a.length;
    }

    @Override // java.util.Iterator
    public T next() {
        int i = this._index;
        Object[] objArr = this.f3824_a;
        if (i >= objArr.length) {
            throw new NoSuchElementException();
        }
        this._index = i + 1;
        return (T) objArr[i];
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
