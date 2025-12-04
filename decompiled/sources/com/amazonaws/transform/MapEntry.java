package com.amazonaws.transform;

import java.util.Map;

/* loaded from: classes2.dex */
public class MapEntry<K, V> implements Map.Entry<K, V> {
    private Object key;
    private Object value;

    @Override // java.util.Map.Entry
    public K getKey() {
        return (K) this.key;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return (V) this.value;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        this.value = v;
        return v;
    }

    public K setKey(K k) {
        this.key = k;
        return k;
    }
}
