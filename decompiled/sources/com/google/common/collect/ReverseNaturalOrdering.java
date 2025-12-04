package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class ReverseNaturalOrdering extends Ordering implements Serializable {
    static final ReverseNaturalOrdering INSTANCE = new ReverseNaturalOrdering();
    private static final long serialVersionUID = 0;

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Comparable comparable, Comparable comparable2) {
        Preconditions.checkNotNull(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    @Override // com.google.common.collect.Ordering
    public Ordering reverse() {
        return Ordering.natural();
    }

    @Override // com.google.common.collect.Ordering
    public Comparable min(Comparable comparable, Comparable comparable2) {
        return (Comparable) NaturalOrdering.INSTANCE.max(comparable, comparable2);
    }

    @Override // com.google.common.collect.Ordering
    public Comparable min(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable... comparableArr) {
        return (Comparable) NaturalOrdering.INSTANCE.max(comparable, comparable2, comparable3, comparableArr);
    }

    @Override // com.google.common.collect.Ordering
    public Comparable min(Iterator it) {
        return (Comparable) NaturalOrdering.INSTANCE.max(it);
    }

    @Override // com.google.common.collect.Ordering
    public Comparable min(Iterable iterable) {
        return (Comparable) NaturalOrdering.INSTANCE.max(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public Comparable max(Comparable comparable, Comparable comparable2) {
        return (Comparable) NaturalOrdering.INSTANCE.min(comparable, comparable2);
    }

    @Override // com.google.common.collect.Ordering
    public Comparable max(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable... comparableArr) {
        return (Comparable) NaturalOrdering.INSTANCE.min(comparable, comparable2, comparable3, comparableArr);
    }

    @Override // com.google.common.collect.Ordering
    public Comparable max(Iterator it) {
        return (Comparable) NaturalOrdering.INSTANCE.min(it);
    }

    @Override // com.google.common.collect.Ordering
    public Comparable max(Iterable iterable) {
        return (Comparable) NaturalOrdering.INSTANCE.min(iterable);
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    private ReverseNaturalOrdering() {
    }
}
