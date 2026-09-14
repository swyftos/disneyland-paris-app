package com.appdynamics.eumagent.runtime.p192private;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.cp */
/* JADX INFO: loaded from: classes2.dex */
public final class C2120cp<K, V> {

    /* JADX INFO: renamed from: a */
    private final HashMap<K, LinkedList<V>> f813a = new HashMap<>();

    /* JADX INFO: renamed from: b */
    private final HashMap<K, Collection<V>> f814b = new HashMap<>();

    /* JADX INFO: renamed from: a */
    public final synchronized void m655a() {
        this.f813a.clear();
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m656a(K k, V v) {
        try {
            LinkedList<V> linkedList = this.f813a.get(k);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.f813a.put(k, linkedList);
            }
            linkedList.add(v);
            this.f814b.remove(k);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public final synchronized Collection<V> m654a(K k) {
        Collection<V> collectionUnmodifiableCollection;
        LinkedList<V> linkedList;
        collectionUnmodifiableCollection = this.f814b.get(k);
        if (collectionUnmodifiableCollection == null && (linkedList = this.f813a.get(k)) != null) {
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(new ArrayList(linkedList));
            this.f814b.put(k, collectionUnmodifiableCollection);
        }
        return collectionUnmodifiableCollection;
    }
}
