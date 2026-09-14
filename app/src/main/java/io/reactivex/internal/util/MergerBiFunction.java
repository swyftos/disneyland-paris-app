package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class MergerBiFunction<T> implements BiFunction<List<T>, List<T>, List<T>> {
    final Comparator comparator;

    public MergerBiFunction(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0037, code lost:
    
        r3 = null;
     */
    @Override // io.reactivex.functions.BiFunction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<T> apply(List<T> list, List<T> list2) throws Exception {
        int size = list.size() + list2.size();
        if (size == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator<T> it = list.iterator();
        Iterator<T> it2 = list2.iterator();
        T next = it.hasNext() ? it.next() : null;
        if (it2.hasNext()) {
            T next2 = it2.next();
            while (next != null && next2 != null) {
                if (this.comparator.compare(next, next2) < 0) {
                    arrayList.add(next);
                    next = it.hasNext() ? it.next() : null;
                } else {
                    arrayList.add(next2);
                    next2 = it2.hasNext() ? it2.next() : null;
                }
            }
            if (next != null) {
                arrayList.add(next);
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            } else {
                arrayList.add(next2);
                while (it2.hasNext()) {
                    arrayList.add(it2.next());
                }
            }
            return arrayList;
        }
    }
}
