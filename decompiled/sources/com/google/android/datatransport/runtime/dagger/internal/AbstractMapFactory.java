package com.google.android.datatransport.runtime.dagger.internal;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes3.dex */
abstract class AbstractMapFactory implements Factory {
    private final Map contributingMap;

    AbstractMapFactory(Map map) {
        this.contributingMap = Collections.unmodifiableMap(map);
    }

    final Map contributingMap() {
        return this.contributingMap;
    }

    public static abstract class Builder<K, V, V2> {
        final LinkedHashMap map;

        Builder(int i) {
            this.map = DaggerCollections.newLinkedHashMapWithExpectedSize(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        Builder put(Object obj, Provider provider) {
            this.map.put(Preconditions.checkNotNull(obj, "key"), Preconditions.checkNotNull(provider, "provider"));
            return this;
        }

        Builder putAll(Provider provider) {
            if (!(provider instanceof DelegateFactory)) {
                this.map.putAll(((AbstractMapFactory) provider).contributingMap);
                return this;
            }
            return putAll(((DelegateFactory) provider).getDelegate());
        }
    }
}
