package com.google.common.collect;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes4.dex */
final class AllEqualOrdering extends Ordering implements Serializable {
    static final AllEqualOrdering INSTANCE = new AllEqualOrdering();
    private static final long serialVersionUID = 0;

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return 0;
    }

    @Override // com.google.common.collect.Ordering
    public Ordering reverse() {
        return this;
    }

    AllEqualOrdering() {
    }

    @Override // com.google.common.collect.Ordering
    public List sortedCopy(Iterable iterable) {
        return Lists.newArrayList(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public ImmutableList immutableSortedCopy(Iterable iterable) {
        return ImmutableList.copyOf(iterable);
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public String toString() {
        return "Ordering.allEqual()";
    }
}
