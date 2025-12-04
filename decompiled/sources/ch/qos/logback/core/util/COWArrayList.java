package ch.qos.logback.core.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class COWArrayList<E> implements List<E> {
    final Object[] modelArray;
    Object[] ourCopy;
    AtomicBoolean fresh = new AtomicBoolean(false);
    CopyOnWriteArrayList underlyingList = new CopyOnWriteArrayList();

    public COWArrayList(E[] eArr) {
        this.modelArray = eArr;
    }

    private boolean isFresh() {
        return this.fresh.get();
    }

    private void markAsStale() {
        this.fresh.set(false);
    }

    private void refreshCopy() {
        this.ourCopy = this.underlyingList.toArray(this.modelArray);
        this.fresh.set(true);
    }

    private void refreshCopyIfNecessary() {
        if (isFresh()) {
            return;
        }
        refreshCopy();
    }

    @Override // java.util.List
    public void add(int i, E e) {
        this.underlyingList.add(i, e);
        markAsStale();
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(E e) {
        boolean zAdd = this.underlyingList.add(e);
        markAsStale();
        return zAdd;
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        boolean zAddAll = this.underlyingList.addAll(i, collection);
        markAsStale();
        return zAddAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        boolean zAddAll = this.underlyingList.addAll(collection);
        markAsStale();
        return zAddAll;
    }

    public void addIfAbsent(E e) {
        this.underlyingList.addIfAbsent(e);
        markAsStale();
    }

    public E[] asTypedArray() {
        refreshCopyIfNecessary();
        return (E[]) this.ourCopy;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.underlyingList.clear();
        markAsStale();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.underlyingList.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.underlyingList.containsAll(collection);
    }

    @Override // java.util.List
    public E get(int i) {
        refreshCopyIfNecessary();
        return (E) this.ourCopy[i];
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.underlyingList.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.underlyingList.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return this.underlyingList.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.underlyingList.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return this.underlyingList.listIterator();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return this.underlyingList.listIterator(i);
    }

    @Override // java.util.List
    public E remove(int i) {
        E e = (E) this.underlyingList.remove(i);
        markAsStale();
        return e;
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        boolean zRemove = this.underlyingList.remove(obj);
        markAsStale();
        return zRemove;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean zRemoveAll = this.underlyingList.removeAll(collection);
        markAsStale();
        return zRemoveAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        boolean zRetainAll = this.underlyingList.retainAll(collection);
        markAsStale();
        return zRetainAll;
    }

    @Override // java.util.List
    public E set(int i, E e) {
        E e2 = (E) this.underlyingList.set(i, e);
        markAsStale();
        return e2;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.underlyingList.size();
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        return this.underlyingList.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        refreshCopyIfNecessary();
        return this.ourCopy;
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        refreshCopyIfNecessary();
        return (T[]) this.ourCopy;
    }
}
