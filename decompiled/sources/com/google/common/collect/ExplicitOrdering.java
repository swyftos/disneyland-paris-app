package com.google.common.collect;

import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes4.dex */
final class ExplicitOrdering extends Ordering implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap rankMap;

    ExplicitOrdering(List list) {
        this(Maps.indexMap(list));
    }

    ExplicitOrdering(ImmutableMap immutableMap) {
        this.rankMap = immutableMap;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return rank(obj) - rank(obj2);
    }

    private int rank(Object obj) {
        Integer num = (Integer) this.rankMap.get(obj);
        if (num == null) {
            throw new Ordering.IncomparableValueException(obj);
        }
        return num.intValue();
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj instanceof ExplicitOrdering) {
            return this.rankMap.equals(((ExplicitOrdering) obj).rankMap);
        }
        return false;
    }

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public String toString() {
        return "Ordering.explicit(" + this.rankMap.keySet() + ")";
    }
}
