package com.amazonaws.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class ImmutableMapParameter<K, V> implements Map<K, V> {
    private final Map map;

    private ImmutableMapParameter(Map map) {
        this.map = map;
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K, V> ImmutableMapParameter<K, V> of(K k, V v) {
        return new ImmutableMapParameter<>(Collections.singletonMap(k, v));
    }

    public static <K, V> ImmutableMapParameter<K, V> of(K k, V v, K k2, V v2) {
        HashMap map = new HashMap();
        putAndWarnDuplicateKeys(map, k, v);
        putAndWarnDuplicateKeys(map, k2, v2);
        return new ImmutableMapParameter<>(map);
    }

    public static <K, V> ImmutableMapParameter<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        HashMap map = new HashMap();
        putAndWarnDuplicateKeys(map, k, v);
        putAndWarnDuplicateKeys(map, k2, v2);
        putAndWarnDuplicateKeys(map, k3, v3);
        return new ImmutableMapParameter<>(map);
    }

    public static <K, V> ImmutableMapParameter<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        HashMap map = new HashMap();
        putAndWarnDuplicateKeys(map, k, v);
        putAndWarnDuplicateKeys(map, k2, v2);
        putAndWarnDuplicateKeys(map, k3, v3);
        putAndWarnDuplicateKeys(map, k4, v4);
        return new ImmutableMapParameter<>(map);
    }

    public static <K, V> ImmutableMapParameter<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        HashMap map = new HashMap();
        putAndWarnDuplicateKeys(map, k, v);
        putAndWarnDuplicateKeys(map, k2, v2);
        putAndWarnDuplicateKeys(map, k3, v3);
        putAndWarnDuplicateKeys(map, k4, v4);
        putAndWarnDuplicateKeys(map, k5, v5);
        return new ImmutableMapParameter<>(map);
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return this.map.entrySet();
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return (V) this.map.get(obj);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return this.map.keySet();
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return this.map.values();
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("This is an immutable map.");
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        throw new UnsupportedOperationException("This is an immutable map.");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("This is an immutable map.");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("This is an immutable map.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putAndWarnDuplicateKeys(Map map, Object obj, Object obj2) {
        if (map.containsKey(obj)) {
            throw new IllegalArgumentException("Duplicate keys are provided.");
        }
        map.put(obj, obj2);
    }

    public static class Builder<K, V> {
        private final Map entries = new HashMap();

        public Builder<K, V> put(K k, V v) {
            ImmutableMapParameter.putAndWarnDuplicateKeys(this.entries, k, v);
            return this;
        }

        public ImmutableMapParameter<K, V> build() {
            HashMap map = new HashMap();
            map.putAll(this.entries);
            return new ImmutableMapParameter<>(map);
        }
    }
}
