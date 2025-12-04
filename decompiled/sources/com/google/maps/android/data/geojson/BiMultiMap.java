package com.google.maps.android.data.geojson;

import androidx.annotation.NonNull;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class BiMultiMap<K> extends HashMap<K, Object> {
    private final Map mValuesToKeys = new HashMap();

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ?> map) {
        for (Map.Entry<? extends K, ?> entry : map.entrySet()) {
            put((BiMultiMap<K>) entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object put(K k, Object obj) {
        if (obj instanceof Collection) {
            return put((BiMultiMap<K>) k, (Collection) obj);
        }
        this.mValuesToKeys.put(obj, k);
        return super.put((BiMultiMap<K>) k, (K) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object put(K k, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            this.mValuesToKeys.put(it.next(), k);
        }
        return super.put((BiMultiMap<K>) k, (K) collection);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Object objRemove = super.remove(obj);
        if (objRemove instanceof Collection) {
            Iterator it = ((Collection) objRemove).iterator();
            while (it.hasNext()) {
                this.mValuesToKeys.remove(it.next());
            }
        } else {
            this.mValuesToKeys.remove(objRemove);
        }
        return objRemove;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
        this.mValuesToKeys.clear();
    }

    @Override // java.util.HashMap, java.util.AbstractMap
    @NonNull
    public BiMultiMap<K> clone() {
        BiMultiMap<K> biMultiMap = new BiMultiMap<>();
        biMultiMap.putAll((Map) super.clone());
        return biMultiMap;
    }

    public K getKey(Object obj) {
        return (K) this.mValuesToKeys.get(obj);
    }
}
