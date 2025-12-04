package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.infer.annotation.ThreadSafe;
import java.util.LinkedList;
import javax.annotation.Nullable;

@Nullsafe(Nullsafe.Mode.LOCAL)
@ThreadSafe
/* loaded from: classes3.dex */
public class BucketMap<T> {
    LinkedEntry mHead;
    protected final SparseArray<LinkedEntry> mMap = new SparseArray<>();
    LinkedEntry mTail;

    static class LinkedEntry {
        int key;
        LinkedEntry next;
        LinkedEntry prev;
        LinkedList value;

        private LinkedEntry(LinkedEntry linkedEntry, int i, LinkedList linkedList, LinkedEntry linkedEntry2) {
            this.prev = linkedEntry;
            this.key = i;
            this.value = linkedList;
            this.next = linkedEntry2;
        }

        public String toString() {
            return "LinkedEntry(key: " + this.key + ")";
        }
    }

    @Nullable
    public synchronized T acquire(int i) {
        LinkedEntry linkedEntry = this.mMap.get(i);
        if (linkedEntry == null) {
            return null;
        }
        T t = (T) linkedEntry.value.pollFirst();
        moveToFront(linkedEntry);
        return t;
    }

    public synchronized void release(int i, T t) {
        try {
            LinkedEntry linkedEntry = this.mMap.get(i);
            if (linkedEntry == null) {
                linkedEntry = new LinkedEntry(null, i, new LinkedList(), null);
                this.mMap.put(i, linkedEntry);
            }
            linkedEntry.value.addLast(t);
            moveToFront(linkedEntry);
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized void prune(LinkedEntry linkedEntry) {
        try {
            LinkedEntry linkedEntry2 = linkedEntry.prev;
            LinkedEntry linkedEntry3 = linkedEntry.next;
            if (linkedEntry2 != null) {
                linkedEntry2.next = linkedEntry3;
            }
            if (linkedEntry3 != null) {
                linkedEntry3.prev = linkedEntry2;
            }
            linkedEntry.prev = null;
            linkedEntry.next = null;
            if (linkedEntry == this.mHead) {
                this.mHead = linkedEntry3;
            }
            if (linkedEntry == this.mTail) {
                this.mTail = linkedEntry2;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void moveToFront(LinkedEntry linkedEntry) {
        if (this.mHead == linkedEntry) {
            return;
        }
        prune(linkedEntry);
        LinkedEntry linkedEntry2 = this.mHead;
        if (linkedEntry2 == null) {
            this.mHead = linkedEntry;
            this.mTail = linkedEntry;
        } else {
            linkedEntry.next = linkedEntry2;
            linkedEntry2.prev = linkedEntry;
            this.mHead = linkedEntry;
        }
    }

    @Nullable
    public synchronized T removeFromEnd() {
        LinkedEntry linkedEntry = this.mTail;
        if (linkedEntry == null) {
            return null;
        }
        T t = (T) linkedEntry.value.pollLast();
        maybePrune(linkedEntry);
        return t;
    }

    private void maybePrune(LinkedEntry linkedEntry) {
        if (linkedEntry == null || !linkedEntry.value.isEmpty()) {
            return;
        }
        prune(linkedEntry);
        this.mMap.remove(linkedEntry.key);
    }
}
