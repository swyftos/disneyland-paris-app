package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class LruCache<T, Y> {
    private final Map cache = new LinkedHashMap(100, 0.75f, true);
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    protected int getSize(@Nullable Y y) {
        return 1;
    }

    protected void onItemEvicted(@NonNull T t, @Nullable Y y) {
    }

    public LruCache(long j) {
        this.initialMaxSize = j;
        this.maxSize = j;
    }

    public synchronized void setSizeMultiplier(float f) {
        if (f < BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
        this.maxSize = Math.round(this.initialMaxSize * f);
        evict();
    }

    protected synchronized int getCount() {
        return this.cache.size();
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized long getCurrentSize() {
        return this.currentSize;
    }

    public synchronized boolean contains(@NonNull T t) {
        return this.cache.containsKey(t);
    }

    @Nullable
    public synchronized Y get(@NonNull T t) {
        Entry entry;
        entry = (Entry) this.cache.get(t);
        return entry != null ? (Y) entry.value : null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public synchronized Y put(@NonNull T t, @Nullable Y y) {
        int size = getSize(y);
        long j = size;
        Y y2 = null;
        if (j >= this.maxSize) {
            onItemEvicted(t, y);
            return null;
        }
        if (y != null) {
            this.currentSize += j;
        }
        Entry entry = (Entry) this.cache.put(t, y == null ? null : new Entry(y, size));
        if (entry != null) {
            this.currentSize -= entry.size;
            if (!entry.value.equals(y)) {
                onItemEvicted(t, entry.value);
            }
        }
        evict();
        if (entry != null) {
            y2 = (Y) entry.value;
        }
        return y2;
    }

    @Nullable
    public synchronized Y remove(@NonNull T t) {
        Entry entry = (Entry) this.cache.remove(t);
        if (entry == null) {
            return null;
        }
        this.currentSize -= entry.size;
        return (Y) entry.value;
    }

    public void clearMemory() {
        trimToSize(0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected synchronized void trimToSize(long j) {
        while (this.currentSize > j) {
            Iterator it = this.cache.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            Entry entry2 = (Entry) entry.getValue();
            this.currentSize -= entry2.size;
            Object key = entry.getKey();
            it.remove();
            onItemEvicted(key, entry2.value);
        }
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    static final class Entry {
        final int size;
        final Object value;

        Entry(Object obj, int i) {
            this.value = obj;
            this.size = i;
        }
    }
}
