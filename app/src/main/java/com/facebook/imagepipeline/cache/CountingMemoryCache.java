package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
public interface CountingMemoryCache<K, V> extends MemoryCache<K, V>, MemoryTrimmable {

    public interface EntryStateObserver<K> {
        void onExclusivityChanged(K k, boolean z);
    }

    @Nullable
    CloseableReference<V> cache(K k, CloseableReference<V> closeableReference, EntryStateObserver<K> entryStateObserver);

    void clear();

    @Nullable
    CountingLruMap<K, Entry<K, V>> getCachedEntries();

    int getEvictionQueueCount();

    int getEvictionQueueSizeInBytes();

    int getInUseSizeInBytes();

    MemoryCacheParams getMemoryCacheParams();

    @Nullable
    Map<Bitmap, Object> getOtherEntries();

    void maybeEvictEntries();

    @Nullable
    CloseableReference<V> reuse(K k);

    @VisibleForTesting
    public static class Entry<K, V> {
        public final K key;

        @Nullable
        public final EntryStateObserver<K> observer;
        public int size;
        public final CloseableReference<V> valueRef;
        public int clientCount = 0;
        public boolean isOrphan = false;
        public int accessCount = 0;

        private Entry(Object obj, CloseableReference closeableReference, EntryStateObserver entryStateObserver, int i) {
            this.key = (K) Preconditions.checkNotNull(obj);
            this.valueRef = (CloseableReference) Preconditions.checkNotNull(CloseableReference.cloneOrNull(closeableReference));
            this.observer = entryStateObserver;
            this.size = i;
        }

        @VisibleForTesting
        /* JADX INFO: renamed from: of */
        public static <K, V> Entry<K, V> m1357of(K k, CloseableReference<V> closeableReference, @Nullable EntryStateObserver<K> entryStateObserver) {
            return m1356of(k, closeableReference, -1, entryStateObserver);
        }

        @VisibleForTesting
        /* JADX INFO: renamed from: of */
        public static <K, V> Entry<K, V> m1356of(K k, CloseableReference<V> closeableReference, int i, @Nullable EntryStateObserver<K> entryStateObserver) {
            return new Entry<>(k, closeableReference, entryStateObserver, i);
        }
    }
}
