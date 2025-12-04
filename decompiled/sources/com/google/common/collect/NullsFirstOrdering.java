package com.google.common.collect;

import java.io.Serializable;

/* loaded from: classes4.dex */
final class NullsFirstOrdering extends Ordering implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering ordering;

    @Override // com.google.common.collect.Ordering
    public Ordering nullsFirst() {
        return this;
    }

    NullsFirstOrdering(Ordering ordering) {
        this.ordering = ordering;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        return this.ordering.compare(obj, obj2);
    }

    @Override // com.google.common.collect.Ordering
    public Ordering reverse() {
        return this.ordering.reverse().nullsLast();
    }

    @Override // com.google.common.collect.Ordering
    public Ordering nullsLast() {
        return this.ordering.nullsLast();
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NullsFirstOrdering) {
            return this.ordering.equals(((NullsFirstOrdering) obj).ordering);
        }
        return false;
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ 957692532;
    }

    public String toString() {
        return this.ordering + ".nullsFirst()";
    }
}
