package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class ReverseOrdering extends Ordering implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering forwardOrder;

    ReverseOrdering(Ordering ordering) {
        this.forwardOrder = (Ordering) Preconditions.checkNotNull(ordering);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.forwardOrder.compare(obj2, obj);
    }

    @Override // com.google.common.collect.Ordering
    public Ordering reverse() {
        return this.forwardOrder;
    }

    @Override // com.google.common.collect.Ordering
    public Object min(Object obj, Object obj2) {
        return this.forwardOrder.max(obj, obj2);
    }

    @Override // com.google.common.collect.Ordering
    public Object min(Object obj, Object obj2, Object obj3, Object... objArr) {
        return this.forwardOrder.max(obj, obj2, obj3, objArr);
    }

    @Override // com.google.common.collect.Ordering
    public Object min(Iterator it) {
        return this.forwardOrder.max(it);
    }

    @Override // com.google.common.collect.Ordering
    public Object min(Iterable iterable) {
        return this.forwardOrder.max(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public Object max(Object obj, Object obj2) {
        return this.forwardOrder.min(obj, obj2);
    }

    @Override // com.google.common.collect.Ordering
    public Object max(Object obj, Object obj2, Object obj3, Object... objArr) {
        return this.forwardOrder.min(obj, obj2, obj3, objArr);
    }

    @Override // com.google.common.collect.Ordering
    public Object max(Iterator it) {
        return this.forwardOrder.min(it);
    }

    @Override // com.google.common.collect.Ordering
    public Object max(Iterable iterable) {
        return this.forwardOrder.min(iterable);
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReverseOrdering) {
            return this.forwardOrder.equals(((ReverseOrdering) obj).forwardOrder);
        }
        return false;
    }

    public String toString() {
        return this.forwardOrder + ".reverse()";
    }
}
