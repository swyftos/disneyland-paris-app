package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Map;

/* loaded from: classes4.dex */
final class MapRetrievalCache extends MapIteratorCache {
    private volatile transient CacheEntry cacheEntry1;
    private volatile transient CacheEntry cacheEntry2;

    MapRetrievalCache(Map map) {
        super(map);
    }

    @Override // com.google.common.graph.MapIteratorCache
    Object get(Object obj) {
        Preconditions.checkNotNull(obj);
        Object ifCached = getIfCached(obj);
        if (ifCached != null) {
            return ifCached;
        }
        Object withoutCaching = getWithoutCaching(obj);
        if (withoutCaching != null) {
            addToCache(obj, withoutCaching);
        }
        return withoutCaching;
    }

    @Override // com.google.common.graph.MapIteratorCache
    Object getIfCached(Object obj) {
        Object ifCached = super.getIfCached(obj);
        if (ifCached != null) {
            return ifCached;
        }
        CacheEntry cacheEntry = this.cacheEntry1;
        if (cacheEntry != null && cacheEntry.key == obj) {
            return cacheEntry.value;
        }
        CacheEntry cacheEntry2 = this.cacheEntry2;
        if (cacheEntry2 == null || cacheEntry2.key != obj) {
            return null;
        }
        addToCache(cacheEntry2);
        return cacheEntry2.value;
    }

    @Override // com.google.common.graph.MapIteratorCache
    void clearCache() {
        super.clearCache();
        this.cacheEntry1 = null;
        this.cacheEntry2 = null;
    }

    private void addToCache(Object obj, Object obj2) {
        addToCache(new CacheEntry(obj, obj2));
    }

    private void addToCache(CacheEntry cacheEntry) {
        this.cacheEntry2 = this.cacheEntry1;
        this.cacheEntry1 = cacheEntry;
    }

    private static final class CacheEntry {
        final Object key;
        final Object value;

        CacheEntry(Object obj, Object obj2) {
            this.key = obj;
            this.value = obj2;
        }
    }
}
