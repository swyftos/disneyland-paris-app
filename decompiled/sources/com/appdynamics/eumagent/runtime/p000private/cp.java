package com.appdynamics.eumagent.runtime.p000private;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public final class cp<K, V> {
    private final HashMap<K, LinkedList<V>> a = new HashMap<>();
    private final HashMap<K, Collection<V>> b = new HashMap<>();

    public final synchronized void a() {
        this.a.clear();
    }

    public final synchronized void a(K k, V v) {
        try {
            LinkedList<V> linkedList = this.a.get(k);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.a.put(k, linkedList);
            }
            linkedList.add(v);
            this.b.remove(k);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized Collection<V> a(K k) {
        Collection<V> collectionUnmodifiableCollection;
        LinkedList<V> linkedList;
        collectionUnmodifiableCollection = this.b.get(k);
        if (collectionUnmodifiableCollection == null && (linkedList = this.a.get(k)) != null) {
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(new ArrayList(linkedList));
            this.b.put(k, collectionUnmodifiableCollection);
        }
        return collectionUnmodifiableCollection;
    }
}
