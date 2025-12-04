package org.bouncycastle.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class CollectionStore<T> implements Store<T>, Iterable<T> {
    private Collection _local;

    public CollectionStore(Collection<T> collection) {
        this._local = new ArrayList(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.bouncycastle.util.Store
    public Collection<T> getMatches(Selector<T> selector) {
        if (selector == 0) {
            return new ArrayList(this._local);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this._local) {
            if (selector.match(obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // org.bouncycastle.util.Iterable, java.lang.Iterable
    public Iterator<T> iterator() {
        return getMatches(null).iterator();
    }
}
