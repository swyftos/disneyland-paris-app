package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Nullsafe(Nullsafe.Mode.LOCAL)
/* loaded from: classes3.dex */
public abstract class AbstractAdaptiveCountingMemoryCache<K, V> implements CountingMemoryCache<K, V> {
    final int mAdaptiveRatePromil;
    private final MemoryCache.CacheTrimStrategy mCacheTrimStrategy;
    final CountingLruMap mCachedEntries;
    private final int mFrequentlyUsedThreshold;
    final int mGhostListMaxSize;
    int mLFUFractionPromil;
    private long mLastCacheParamsCheck;
    final CountingLruMap mLeastFrequentlyUsedExclusiveEntries;
    final IntMapArrayList mLeastFrequentlyUsedKeysGhostList;

    @GuardedBy("this")
    protected MemoryCacheParams mMemoryCacheParams;
    private final Supplier mMemoryCacheParamsSupplier;
    final CountingLruMap mMostFrequentlyUsedExclusiveEntries;
    final ArrayList mMostFrequentlyUsedKeysGhostList;
    private final ValueDescriptor mValueDescriptor;

    enum ArrayListType {
        LFU,
        MFU
    }

    protected abstract void logIllegalAdaptiveRate();

    protected abstract void logIllegalLfuFraction();

    public AbstractAdaptiveCountingMemoryCache(Supplier<MemoryCacheParams> supplier, MemoryCache.CacheTrimStrategy cacheTrimStrategy, ValueDescriptor<V> valueDescriptor, int i, int i2, int i3, int i4) {
        FLog.d("AbstractArcCountingMemoryCache", "Create Adaptive Replacement Cache");
        this.mValueDescriptor = valueDescriptor;
        this.mLeastFrequentlyUsedExclusiveEntries = new CountingLruMap(wrapValueDescriptor(valueDescriptor));
        this.mMostFrequentlyUsedExclusiveEntries = new CountingLruMap(wrapValueDescriptor(valueDescriptor));
        this.mCachedEntries = new CountingLruMap(wrapValueDescriptor(valueDescriptor));
        this.mCacheTrimStrategy = cacheTrimStrategy;
        this.mMemoryCacheParamsSupplier = supplier;
        this.mMemoryCacheParams = (MemoryCacheParams) Preconditions.checkNotNull(supplier.get(), "mMemoryCacheParamsSupplier returned null");
        this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
        this.mFrequentlyUsedThreshold = i2;
        this.mGhostListMaxSize = i3;
        this.mLeastFrequentlyUsedKeysGhostList = new IntMapArrayList(i3);
        this.mMostFrequentlyUsedKeysGhostList = new ArrayList(i3);
        if (i4 < 100 || i4 > 900) {
            this.mLFUFractionPromil = 500;
            logIllegalLfuFraction();
        } else {
            this.mLFUFractionPromil = i4;
        }
        if (i <= 0 || i >= 1000) {
            this.mAdaptiveRatePromil = 10;
            logIllegalAdaptiveRate();
        } else {
            this.mAdaptiveRatePromil = i;
        }
    }

    private ValueDescriptor wrapValueDescriptor(final ValueDescriptor valueDescriptor) {
        return new ValueDescriptor() { // from class: com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache.1
            @Override // com.facebook.imagepipeline.cache.ValueDescriptor
            public int getSizeInBytes(CountingMemoryCache.Entry entry) {
                return valueDescriptor.getSizeInBytes(entry.valueRef.get());
            }
        };
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @Nullable
    public CloseableReference<V> cache(K k, CloseableReference<V> closeableReference) {
        return cache(k, closeableReference, null);
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    @Nullable
    public CloseableReference<V> cache(K k, CloseableReference<V> closeableReference, @Nullable CountingMemoryCache.EntryStateObserver<K> entryStateObserver) {
        CountingMemoryCache.Entry entry;
        CountingMemoryCache.Entry entry2;
        CloseableReference<V> closeableReferenceNewClientReference;
        CloseableReference closeableReferenceReferenceToClose;
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(closeableReference);
        maybeUpdateCacheParams();
        synchronized (this) {
            try {
                entry = (CountingMemoryCache.Entry) this.mLeastFrequentlyUsedExclusiveEntries.remove(k);
                entry2 = (CountingMemoryCache.Entry) this.mMostFrequentlyUsedExclusiveEntries.remove(k);
                Preconditions.checkState(entry == null || entry2 == null);
                CountingMemoryCache.Entry entry3 = (CountingMemoryCache.Entry) this.mCachedEntries.remove(k);
                closeableReferenceNewClientReference = null;
                if (entry3 != null) {
                    makeOrphan(entry3);
                    closeableReferenceReferenceToClose = referenceToClose(entry3);
                } else {
                    closeableReferenceReferenceToClose = null;
                }
                if (canCacheNewValue(closeableReference.get())) {
                    CountingMemoryCache.Entry entryOf = CountingMemoryCache.Entry.of(k, closeableReference, entryStateObserver);
                    Integer value = this.mLeastFrequentlyUsedKeysGhostList.getValue(k);
                    entryOf.accessCount = value != null ? value.intValue() : 0;
                    this.mCachedEntries.put(k, entryOf);
                    closeableReferenceNewClientReference = newClientReference(entryOf);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        CloseableReference.closeSafely((CloseableReference<?>) closeableReferenceReferenceToClose);
        maybeNotifyExclusiveEntryRemoval(entry, entry2);
        maybeEvictEntries();
        return closeableReferenceNewClientReference;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean canCacheNewValue(java.lang.Object r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.facebook.imagepipeline.cache.ValueDescriptor r0 = r3.mValueDescriptor     // Catch: java.lang.Throwable -> L25
            int r4 = r0.getSizeInBytes(r4)     // Catch: java.lang.Throwable -> L25
            com.facebook.imagepipeline.cache.MemoryCacheParams r0 = r3.mMemoryCacheParams     // Catch: java.lang.Throwable -> L25
            int r0 = r0.maxCacheEntrySize     // Catch: java.lang.Throwable -> L25
            if (r4 > r0) goto L27
            int r0 = r3.getInUseCount()     // Catch: java.lang.Throwable -> L25
            com.facebook.imagepipeline.cache.MemoryCacheParams r1 = r3.mMemoryCacheParams     // Catch: java.lang.Throwable -> L25
            int r1 = r1.maxCacheEntries     // Catch: java.lang.Throwable -> L25
            r2 = 1
            int r1 = r1 - r2
            if (r0 > r1) goto L27
            int r0 = r3.getInUseSizeInBytes()     // Catch: java.lang.Throwable -> L25
            com.facebook.imagepipeline.cache.MemoryCacheParams r1 = r3.mMemoryCacheParams     // Catch: java.lang.Throwable -> L25
            int r1 = r1.maxCacheSize     // Catch: java.lang.Throwable -> L25
            int r1 = r1 - r4
            if (r0 > r1) goto L27
            goto L28
        L25:
            r4 = move-exception
            goto L2a
        L27:
            r2 = 0
        L28:
            monitor-exit(r3)
            return r2
        L2a:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache.canCacheNewValue(java.lang.Object):boolean");
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @Nullable
    public CloseableReference<V> get(K k) {
        CountingMemoryCache.Entry entry;
        CountingMemoryCache.Entry entry2;
        CloseableReference<V> closeableReferenceNewClientReference;
        Preconditions.checkNotNull(k);
        synchronized (this) {
            try {
                entry = (CountingMemoryCache.Entry) this.mLeastFrequentlyUsedExclusiveEntries.remove(k);
                entry2 = (CountingMemoryCache.Entry) this.mMostFrequentlyUsedExclusiveEntries.remove(k);
                CountingMemoryCache.Entry entry3 = (CountingMemoryCache.Entry) this.mCachedEntries.get(k);
                if (entry3 != null) {
                    closeableReferenceNewClientReference = newClientReference(entry3);
                } else {
                    maybeUpdateCacheFraction(k);
                    closeableReferenceNewClientReference = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        maybeNotifyExclusiveEntryRemoval(entry, entry2);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return closeableReferenceNewClientReference;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @Nullable
    public V inspect(K k) {
        CountingMemoryCache.Entry entry = (CountingMemoryCache.Entry) this.mCachedEntries.get(k);
        if (entry == null) {
            return null;
        }
        return entry.valueRef.get();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public void probe(K k) {
        Preconditions.checkNotNull(k);
        synchronized (this) {
            try {
                CountingMemoryCache.Entry entry = (CountingMemoryCache.Entry) this.mLeastFrequentlyUsedExclusiveEntries.remove(k);
                if (entry == null) {
                    entry = (CountingMemoryCache.Entry) this.mMostFrequentlyUsedExclusiveEntries.remove(k);
                }
                if (entry != null) {
                    increaseAccessCount(entry);
                    maybeAddToExclusives(entry);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private synchronized void maybeUpdateCacheFraction(Object obj) {
        try {
            if (this.mLeastFrequentlyUsedKeysGhostList.contains(obj)) {
                int i = this.mLFUFractionPromil;
                int i2 = this.mAdaptiveRatePromil;
                if (i + i2 <= 900) {
                    this.mLFUFractionPromil = i + i2;
                }
                this.mLeastFrequentlyUsedKeysGhostList.increaseValueIfExists(obj);
            } else if (this.mLFUFractionPromil - this.mAdaptiveRatePromil >= 100 && this.mMostFrequentlyUsedKeysGhostList.contains(obj)) {
                this.mLFUFractionPromil -= this.mAdaptiveRatePromil;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized CloseableReference newClientReference(final CountingMemoryCache.Entry entry) {
        increaseCounters(entry);
        return CloseableReference.of(entry.valueRef.get(), (ResourceReleaser<V>) new ResourceReleaser() { // from class: com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache.2
            @Override // com.facebook.common.references.ResourceReleaser
            public void release(Object obj) {
                AbstractAdaptiveCountingMemoryCache.this.releaseClientReference(entry);
            }
        });
    }

    private synchronized void addElementToGhostList(Object obj, int i, ArrayListType arrayListType) {
        try {
            if (arrayListType == ArrayListType.LFU) {
                this.mLeastFrequentlyUsedKeysGhostList.addPair(obj, Integer.valueOf(i));
            } else {
                if (this.mMostFrequentlyUsedKeysGhostList.size() == this.mGhostListMaxSize) {
                    this.mMostFrequentlyUsedKeysGhostList.remove(0);
                }
                this.mMostFrequentlyUsedKeysGhostList.add(obj);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseClientReference(CountingMemoryCache.Entry entry) {
        boolean zMaybeAddToExclusives;
        CloseableReference closeableReferenceReferenceToClose;
        Preconditions.checkNotNull(entry);
        synchronized (this) {
            decreaseClientCount(entry);
            zMaybeAddToExclusives = maybeAddToExclusives(entry);
            closeableReferenceReferenceToClose = referenceToClose(entry);
        }
        CloseableReference.closeSafely((CloseableReference<?>) closeableReferenceReferenceToClose);
        if (!zMaybeAddToExclusives) {
            entry = null;
        }
        maybeNotifyExclusiveEntryInsertion(entry);
        maybeUpdateCacheParams();
        maybeEvictEntries();
    }

    private synchronized boolean maybeAddToExclusives(CountingMemoryCache.Entry entry) {
        try {
            if (entry.isOrphan || entry.clientCount != 0) {
                return false;
            }
            if (entry.accessCount > this.mFrequentlyUsedThreshold) {
                this.mMostFrequentlyUsedExclusiveEntries.put(entry.key, entry);
            } else {
                this.mLeastFrequentlyUsedExclusiveEntries.put(entry.key, entry);
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    @Nullable
    public CloseableReference<V> reuse(K k) {
        CountingMemoryCache.Entry entry;
        boolean z;
        CloseableReference<V> closeableReference;
        Preconditions.checkNotNull(k);
        synchronized (this) {
            try {
                entry = (CountingMemoryCache.Entry) this.mLeastFrequentlyUsedExclusiveEntries.remove(k);
                if (entry == null) {
                    entry = (CountingMemoryCache.Entry) this.mMostFrequentlyUsedExclusiveEntries.remove(k);
                }
                if (entry != null) {
                    CountingMemoryCache.Entry entry2 = (CountingMemoryCache.Entry) this.mCachedEntries.remove(k);
                    Preconditions.checkNotNull(entry2);
                    Preconditions.checkState(entry2.clientCount == 0);
                    closeableReference = entry2.valueRef;
                    z = true;
                } else {
                    closeableReference = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            maybeNotifyExclusiveEntryRemoval(entry);
        }
        return closeableReference;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int removeAll(Predicate<K> predicate) {
        ArrayList<V> arrayListRemoveAll;
        ArrayList<V> arrayListRemoveAll2;
        ArrayList<V> arrayListRemoveAll3;
        synchronized (this) {
            arrayListRemoveAll = this.mLeastFrequentlyUsedExclusiveEntries.removeAll(predicate);
            arrayListRemoveAll2 = this.mMostFrequentlyUsedExclusiveEntries.removeAll(predicate);
            arrayListRemoveAll3 = this.mCachedEntries.removeAll(predicate);
            makeOrphans(arrayListRemoveAll3);
        }
        maybeClose(arrayListRemoveAll3);
        maybeNotifyExclusiveEntriesRemoval(arrayListRemoveAll, arrayListRemoveAll2);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return arrayListRemoveAll3.size();
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public void clear() {
        ArrayList<V> arrayListClear;
        ArrayList<V> arrayListClear2;
        ArrayList<V> arrayListClear3;
        synchronized (this) {
            arrayListClear = this.mLeastFrequentlyUsedExclusiveEntries.clear();
            arrayListClear2 = this.mMostFrequentlyUsedExclusiveEntries.clear();
            arrayListClear3 = this.mCachedEntries.clear();
            makeOrphans(arrayListClear3);
        }
        maybeClose(arrayListClear3);
        maybeNotifyExclusiveEntriesRemoval(arrayListClear, arrayListClear2);
        maybeUpdateCacheParams();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized boolean contains(Predicate<K> predicate) {
        return !this.mCachedEntries.getMatchingEntries(predicate).isEmpty();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized boolean contains(K k) {
        return this.mCachedEntries.contains(k);
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType memoryTrimType) {
        ArrayList arrayListTrimExclusivelyOwnedEntries;
        ArrayList arrayListTrimExclusivelyOwnedEntries2;
        double trimRatio = this.mCacheTrimStrategy.getTrimRatio(memoryTrimType);
        synchronized (this) {
            int sizeInBytes = ((int) (this.mCachedEntries.getSizeInBytes() * (1.0d - trimRatio))) - getInUseSizeInBytes();
            int i = 0;
            int iMax = Math.max(0, sizeInBytes);
            int sizeInBytes2 = this.mMostFrequentlyUsedExclusiveEntries.getSizeInBytes();
            int iMax2 = Math.max(0, iMax - sizeInBytes2);
            if (iMax > sizeInBytes2) {
                iMax = sizeInBytes2;
                i = iMax2;
            }
            arrayListTrimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(Integer.MAX_VALUE, i, this.mLeastFrequentlyUsedExclusiveEntries, ArrayListType.LFU);
            arrayListTrimExclusivelyOwnedEntries2 = trimExclusivelyOwnedEntries(Integer.MAX_VALUE, iMax, this.mMostFrequentlyUsedExclusiveEntries, ArrayListType.MFU);
            makeOrphans(arrayListTrimExclusivelyOwnedEntries, arrayListTrimExclusivelyOwnedEntries2);
        }
        maybeClose(arrayListTrimExclusivelyOwnedEntries, arrayListTrimExclusivelyOwnedEntries2);
        maybeNotifyExclusiveEntriesRemoval(arrayListTrimExclusivelyOwnedEntries, arrayListTrimExclusivelyOwnedEntries2);
        maybeUpdateCacheParams();
        maybeEvictEntries();
    }

    private synchronized void maybeUpdateCacheParams() {
        if (this.mLastCacheParamsCheck + this.mMemoryCacheParams.paramsCheckIntervalMs > SystemClock.uptimeMillis()) {
            return;
        }
        this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
        this.mMemoryCacheParams = (MemoryCacheParams) Preconditions.checkNotNull((MemoryCacheParams) this.mMemoryCacheParamsSupplier.get(), "mMemoryCacheParamsSupplier returned null");
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public MemoryCacheParams getMemoryCacheParams() {
        return this.mMemoryCacheParams;
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public void maybeEvictEntries() {
        ArrayList arrayListTrimExclusivelyOwnedEntries;
        ArrayList arrayListTrimExclusivelyOwnedEntries2;
        synchronized (this) {
            MemoryCacheParams memoryCacheParams = this.mMemoryCacheParams;
            int iMin = Math.min(memoryCacheParams.maxEvictionQueueEntries, memoryCacheParams.maxCacheEntries - getInUseCount());
            MemoryCacheParams memoryCacheParams2 = this.mMemoryCacheParams;
            int iMin2 = Math.min(memoryCacheParams2.maxEvictionQueueSize, memoryCacheParams2.maxCacheSize - getInUseSizeInBytes());
            int i = this.mLFUFractionPromil;
            int i2 = (int) ((iMin * i) / 1000);
            int i3 = (int) ((iMin2 * i) / 1000);
            arrayListTrimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(i2, i3, this.mLeastFrequentlyUsedExclusiveEntries, ArrayListType.LFU);
            arrayListTrimExclusivelyOwnedEntries2 = trimExclusivelyOwnedEntries(iMin - i2, iMin2 - i3, this.mMostFrequentlyUsedExclusiveEntries, ArrayListType.MFU);
            makeOrphans(arrayListTrimExclusivelyOwnedEntries, arrayListTrimExclusivelyOwnedEntries2);
        }
        maybeClose(arrayListTrimExclusivelyOwnedEntries, arrayListTrimExclusivelyOwnedEntries2);
        maybeNotifyExclusiveEntriesRemoval(arrayListTrimExclusivelyOwnedEntries, arrayListTrimExclusivelyOwnedEntries2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private synchronized ArrayList trimExclusivelyOwnedEntries(int i, int i2, CountingLruMap countingLruMap, ArrayListType arrayListType) {
        int iMax = Math.max(i, 0);
        int iMax2 = Math.max(i2, 0);
        if (countingLruMap.getCount() <= iMax && countingLruMap.getSizeInBytes() <= iMax2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (countingLruMap.getCount() <= iMax && countingLruMap.getSizeInBytes() <= iMax2) {
                return arrayList;
            }
            Object objCheckNotNull = Preconditions.checkNotNull(countingLruMap.getFirstKey());
            addElementToGhostList(objCheckNotNull, ((CountingMemoryCache.Entry) Preconditions.checkNotNull((CountingMemoryCache.Entry) countingLruMap.get(objCheckNotNull))).accessCount, arrayListType);
            countingLruMap.remove(objCheckNotNull);
            arrayList.add((CountingMemoryCache.Entry) this.mCachedEntries.remove(objCheckNotNull));
        }
    }

    private void maybeClose(ArrayList arrayList, ArrayList arrayList2) {
        maybeClose(arrayList);
        maybeClose(arrayList2);
    }

    private void maybeClose(ArrayList arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                CloseableReference.closeSafely((CloseableReference<?>) referenceToClose((CountingMemoryCache.Entry) it.next()));
            }
        }
    }

    private void maybeNotifyExclusiveEntriesRemoval(ArrayList arrayList, ArrayList arrayList2) {
        maybeNotifyExclusiveEntryRemoval(arrayList);
        maybeNotifyExclusiveEntryRemoval(arrayList2);
    }

    private void maybeNotifyExclusiveEntryRemoval(CountingMemoryCache.Entry entry, CountingMemoryCache.Entry entry2) {
        maybeNotifyExclusiveEntryRemoval(entry);
        maybeNotifyExclusiveEntryRemoval(entry2);
    }

    private void maybeNotifyExclusiveEntryRemoval(ArrayList arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                maybeNotifyExclusiveEntryRemoval((CountingMemoryCache.Entry) it.next());
            }
        }
    }

    private static void maybeNotifyExclusiveEntryRemoval(CountingMemoryCache.Entry entry) {
        CountingMemoryCache.EntryStateObserver<K> entryStateObserver;
        if (entry == null || (entryStateObserver = entry.observer) == null) {
            return;
        }
        entryStateObserver.onExclusivityChanged(entry.key, false);
    }

    private static void maybeNotifyExclusiveEntryInsertion(CountingMemoryCache.Entry entry) {
        CountingMemoryCache.EntryStateObserver<K> entryStateObserver;
        if (entry == null || (entryStateObserver = entry.observer) == null) {
            return;
        }
        entryStateObserver.onExclusivityChanged(entry.key, true);
    }

    private synchronized void makeOrphans(ArrayList arrayList, ArrayList arrayList2) {
        makeOrphans(arrayList);
        makeOrphans(arrayList2);
    }

    private synchronized void makeOrphans(ArrayList arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                makeOrphan((CountingMemoryCache.Entry) it.next());
            }
        }
    }

    private synchronized void makeOrphan(CountingMemoryCache.Entry entry) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkState(!entry.isOrphan);
        entry.isOrphan = true;
    }

    private synchronized void increaseCounters(CountingMemoryCache.Entry entry) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkState(!entry.isOrphan);
        entry.clientCount++;
        increaseAccessCount(entry);
    }

    private synchronized void increaseAccessCount(CountingMemoryCache.Entry entry) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkState(!entry.isOrphan);
        entry.accessCount++;
    }

    private synchronized void decreaseClientCount(CountingMemoryCache.Entry entry) {
        Preconditions.checkNotNull(entry);
        Preconditions.checkState(entry.clientCount > 0);
        entry.clientCount--;
    }

    private synchronized CloseableReference referenceToClose(CountingMemoryCache.Entry entry) {
        Preconditions.checkNotNull(entry);
        return (entry.isOrphan && entry.clientCount == 0) ? entry.valueRef : null;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized int getCount() {
        return this.mCachedEntries.getCount();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized int getSizeInBytes() {
        return this.mCachedEntries.getSizeInBytes();
    }

    public synchronized int getInUseCount() {
        return (this.mCachedEntries.getCount() - this.mLeastFrequentlyUsedExclusiveEntries.getCount()) - this.mMostFrequentlyUsedExclusiveEntries.getCount();
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public synchronized int getInUseSizeInBytes() {
        return (this.mCachedEntries.getSizeInBytes() - this.mLeastFrequentlyUsedExclusiveEntries.getSizeInBytes()) - this.mMostFrequentlyUsedExclusiveEntries.getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public synchronized int getEvictionQueueCount() {
        return this.mLeastFrequentlyUsedExclusiveEntries.getCount() + this.mMostFrequentlyUsedExclusiveEntries.getCount();
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public synchronized int getEvictionQueueSizeInBytes() {
        return this.mLeastFrequentlyUsedExclusiveEntries.getSizeInBytes() + this.mMostFrequentlyUsedExclusiveEntries.getSizeInBytes();
    }

    public String reportData() {
        return Objects.toStringHelper("CountingMemoryCache").add("cached_entries_count:", this.mCachedEntries.getCount()).add("exclusive_entries_count", getEvictionQueueCount()).toString();
    }

    class IntMapArrayList {
        private final ArrayList mFirstList;
        private final int mMaxCapacity;
        private final ArrayList mSecondList;

        public IntMapArrayList(int i) {
            this.mFirstList = new ArrayList(i);
            this.mSecondList = new ArrayList(i);
            this.mMaxCapacity = i;
        }

        public void addPair(Object obj, Integer num) {
            if (this.mFirstList.size() == this.mMaxCapacity) {
                this.mFirstList.remove(0);
                this.mSecondList.remove(0);
            }
            this.mFirstList.add(obj);
            this.mSecondList.add(num);
        }

        public void increaseValueIfExists(Object obj) {
            int iIndexOf = this.mFirstList.indexOf(obj);
            if (iIndexOf < 0) {
                return;
            }
            Integer numValueOf = Integer.valueOf(((Integer) this.mSecondList.get(iIndexOf)).intValue() + 1);
            int i = this.mMaxCapacity;
            if (iIndexOf == i - 1) {
                this.mSecondList.set(i - 1, numValueOf);
                return;
            }
            this.mFirstList.remove(iIndexOf);
            this.mSecondList.remove(iIndexOf);
            this.mFirstList.add(obj);
            this.mSecondList.add(numValueOf);
        }

        public Integer getValue(Object obj) {
            int iIndexOf = this.mFirstList.indexOf(obj);
            if (iIndexOf < 0) {
                return null;
            }
            return (Integer) this.mSecondList.get(iIndexOf);
        }

        public boolean contains(Object obj) {
            return this.mFirstList.contains(obj);
        }
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public CountingLruMap getCachedEntries() {
        return this.mCachedEntries;
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public Map<Bitmap, Object> getOtherEntries() {
        return Collections.emptyMap();
    }
}
