package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AggregateFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
abstract class CollectionFuture extends AggregateFuture {
    private List values;

    abstract Object combine(List list);

    CollectionFuture(ImmutableCollection immutableCollection, boolean z) {
        List listNewArrayListWithCapacity;
        super(immutableCollection, z, true);
        if (immutableCollection.isEmpty()) {
            listNewArrayListWithCapacity = Collections.emptyList();
        } else {
            listNewArrayListWithCapacity = Lists.newArrayListWithCapacity(immutableCollection.size());
        }
        for (int i = 0; i < immutableCollection.size(); i++) {
            listNewArrayListWithCapacity.add(null);
        }
        this.values = listNewArrayListWithCapacity;
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    final void collectOneValue(int i, Object obj) {
        List list = this.values;
        if (list != null) {
            list.set(i, new Present(obj));
        }
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    final void handleAllCompleted() {
        List list = this.values;
        if (list != null) {
            set(combine(list));
        }
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    void releaseResources(AggregateFuture.ReleaseResourcesReason releaseResourcesReason) {
        super.releaseResources(releaseResourcesReason);
        this.values = null;
    }

    static final class ListFuture extends CollectionFuture {
        ListFuture(ImmutableCollection immutableCollection, boolean z) {
            super(immutableCollection, z);
            init();
        }

        @Override // com.google.common.util.concurrent.CollectionFuture
        public List combine(List list) {
            ArrayList arrayListNewArrayListWithCapacity = Lists.newArrayListWithCapacity(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Present present = (Present) it.next();
                arrayListNewArrayListWithCapacity.add(present != null ? present.value : null);
            }
            return Collections.unmodifiableList(arrayListNewArrayListWithCapacity);
        }
    }

    private static final class Present {
        final Object value;

        Present(Object obj) {
            this.value = obj;
        }
    }
}
