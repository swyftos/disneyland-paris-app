package cucumber.runtime.io;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes5.dex */
class FlatteningIterator implements Iterator {
    private Object next;
    private final Deque iterators = new ArrayDeque();
    private boolean nextBlank = true;

    FlatteningIterator() {
    }

    void push(Iterator it) {
        this.iterators.addFirst(it);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    private void moveToNext() {
        if (!this.nextBlank || this.iterators.isEmpty()) {
            return;
        }
        if (!((Iterator) this.iterators.peek()).hasNext()) {
            this.iterators.removeFirst();
            moveToNext();
            return;
        }
        Object next = ((Iterator) this.iterators.peekFirst()).next();
        if (next instanceof Iterator) {
            push((Iterator) next);
            moveToNext();
        } else {
            this.next = next;
            this.nextBlank = false;
        }
    }

    @Override // java.util.Iterator
    public Object next() {
        moveToNext();
        if (this.nextBlank) {
            throw new NoSuchElementException();
        }
        Object obj = this.next;
        this.next = null;
        this.nextBlank = true;
        return obj;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        moveToNext();
        return !this.nextBlank;
    }
}
