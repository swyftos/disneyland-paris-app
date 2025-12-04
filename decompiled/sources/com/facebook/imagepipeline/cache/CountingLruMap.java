package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Nullsafe(Nullsafe.Mode.LOCAL)
/* loaded from: classes3.dex */
public class CountingLruMap<K, V> {
    private final LinkedHashMap mMap = new LinkedHashMap();
    private int mSizeInBytes = 0;
    private final ValueDescriptor mValueDescriptor;

    public CountingLruMap(ValueDescriptor<V> valueDescriptor) {
        this.mValueDescriptor = valueDescriptor;
    }

    public synchronized int getCount() {
        return this.mMap.size();
    }

    public synchronized int getSizeInBytes() {
        return this.mSizeInBytes;
    }

    @Nullable
    public synchronized K getFirstKey() {
        return this.mMap.isEmpty() ? null : this.mMap.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> getMatchingEntries(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        try {
            arrayList = new ArrayList<>(this.mMap.entrySet().size());
            for (Map.Entry<K, V> entry : this.mMap.entrySet()) {
                if (predicate == null || predicate.apply(entry.getKey())) {
                    arrayList.add(entry);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.mMap.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return (V) this.mMap.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V v2;
        v2 = (V) this.mMap.remove(k);
        this.mSizeInBytes -= getValueSizeInBytes(v2);
        this.mMap.put(k, v);
        this.mSizeInBytes += getValueSizeInBytes(v);
        return v2;
    }

    @Nullable
    public synchronized V remove(K k) {
        V v;
        v = (V) this.mMap.remove(k);
        this.mSizeInBytes -= getValueSizeInBytes(v);
        return v;
    }

    public synchronized ArrayList<V> removeAll(@Nullable Predicate<K> predicate) {
        ArrayList<V> arrayList;
        try {
            arrayList = new ArrayList<>();
            Iterator<Map.Entry<K, V>> it = this.mMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (predicate == null || predicate.apply(next.getKey())) {
                    arrayList.add(next.getValue());
                    this.mSizeInBytes -= getValueSizeInBytes(next.getValue());
                    it.remove();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public synchronized ArrayList<V> clear() {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>((Collection<? extends V>) this.mMap.values());
        this.mMap.clear();
        this.mSizeInBytes = 0;
        return arrayList;
    }

    public synchronized void resetSize() {
        if (this.mMap.isEmpty()) {
            this.mSizeInBytes = 0;
        }
    }

    private int getValueSizeInBytes(Object obj) {
        if (obj == null) {
            return 0;
        }
        return this.mValueDescriptor.getSizeInBytes(obj);
    }
}
