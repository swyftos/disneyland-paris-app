package com.google.common.cache;

import com.amazonaws.services.p017s3.model.InstructionFileId;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
class LocalCache extends AbstractMap implements ConcurrentMap {
    final int concurrencyLevel;
    final CacheLoader defaultLoader;
    final EntryFactory entryFactory;
    Set entrySet;
    final long expireAfterAccessNanos;
    final long expireAfterWriteNanos;
    final AbstractCache.StatsCounter globalStatsCounter;
    final Equivalence keyEquivalence;
    Set keySet;
    final Strength keyStrength;
    final long maxWeight;
    final long refreshNanos;
    final RemovalListener removalListener;
    final Queue removalNotificationQueue;
    final int segmentMask;
    final int segmentShift;
    final Segment[] segments;
    final Ticker ticker;
    final Equivalence valueEquivalence;
    final Strength valueStrength;
    Collection values;
    final Weigher weigher;
    static final Logger logger = Logger.getLogger(LocalCache.class.getName());
    static final ValueReference UNSET = new ValueReference() { // from class: com.google.common.cache.LocalCache.1
        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference copyFor(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object get() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 0;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(Object obj) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object waitForValue() {
            return null;
        }
    };
    static final Queue DISCARDING_QUEUE = new AbstractQueue() { // from class: com.google.common.cache.LocalCache.2
        @Override // java.util.Queue
        public boolean offer(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return ImmutableSet.m1563of().iterator();
        }
    };

    private enum NullEntry implements ReferenceEntry {
        INSTANCE;

        @Override // com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return 0L;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            return 0;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry getNext() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry getNextInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry getNextInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry getPreviousInAccessQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry getPreviousInWriteQueue() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference getValueReference() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return 0L;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference valueReference) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
        }
    }

    enum Strength {
        STRONG { // from class: com.google.common.cache.LocalCache.Strength.1
            @Override // com.google.common.cache.LocalCache.Strength
            ValueReference referenceValue(Segment segment, ReferenceEntry referenceEntry, Object obj, int i) {
                if (i == 1) {
                    return new StrongValueReference(obj);
                }
                return new WeightedStrongValueReference(obj, i);
            }

            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence defaultEquivalence() {
                return Equivalence.equals();
            }
        },
        SOFT { // from class: com.google.common.cache.LocalCache.Strength.2
            @Override // com.google.common.cache.LocalCache.Strength
            ValueReference referenceValue(Segment segment, ReferenceEntry referenceEntry, Object obj, int i) {
                if (i == 1) {
                    return new SoftValueReference(segment.valueReferenceQueue, obj, referenceEntry);
                }
                return new WeightedSoftValueReference(segment.valueReferenceQueue, obj, referenceEntry, i);
            }

            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence defaultEquivalence() {
                return Equivalence.identity();
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.Strength.3
            @Override // com.google.common.cache.LocalCache.Strength
            ValueReference referenceValue(Segment segment, ReferenceEntry referenceEntry, Object obj, int i) {
                if (i == 1) {
                    return new WeakValueReference(segment.valueReferenceQueue, obj, referenceEntry);
                }
                return new WeightedWeakValueReference(segment.valueReferenceQueue, obj, referenceEntry, i);
            }

            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence defaultEquivalence() {
                return Equivalence.identity();
            }
        };

        abstract Equivalence defaultEquivalence();

        abstract ValueReference referenceValue(Segment segment, ReferenceEntry referenceEntry, Object obj, int i);
    }

    interface ValueReference {
        ValueReference copyFor(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry);

        Object get();

        ReferenceEntry getEntry();

        int getWeight();

        boolean isActive();

        boolean isLoading();

        void notifyNewValue(Object obj);

        Object waitForValue();
    }

    static int rehash(int i) {
        int i2 = i + ((i << 15) ^ (-12931));
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = i5 + (i5 << 2) + (i5 << 14);
        return i6 ^ (i6 >>> 16);
    }

    LocalCache(CacheBuilder cacheBuilder, CacheLoader cacheLoader) {
        Queue concurrentLinkedQueue;
        this.concurrencyLevel = Math.min(cacheBuilder.getConcurrencyLevel(), 65536);
        Strength keyStrength = cacheBuilder.getKeyStrength();
        this.keyStrength = keyStrength;
        this.valueStrength = cacheBuilder.getValueStrength();
        this.keyEquivalence = cacheBuilder.getKeyEquivalence();
        this.valueEquivalence = cacheBuilder.getValueEquivalence();
        long maximumWeight = cacheBuilder.getMaximumWeight();
        this.maxWeight = maximumWeight;
        this.weigher = cacheBuilder.getWeigher();
        this.expireAfterAccessNanos = cacheBuilder.getExpireAfterAccessNanos();
        this.expireAfterWriteNanos = cacheBuilder.getExpireAfterWriteNanos();
        this.refreshNanos = cacheBuilder.getRefreshNanos();
        RemovalListener removalListener = cacheBuilder.getRemovalListener();
        this.removalListener = removalListener;
        if (removalListener == CacheBuilder.NullListener.INSTANCE) {
            concurrentLinkedQueue = discardingQueue();
        } else {
            concurrentLinkedQueue = new ConcurrentLinkedQueue();
        }
        this.removalNotificationQueue = concurrentLinkedQueue;
        this.ticker = cacheBuilder.getTicker(recordsTime());
        this.entryFactory = EntryFactory.getFactory(keyStrength, usesAccessEntries(), usesWriteEntries());
        this.globalStatsCounter = (AbstractCache.StatsCounter) cacheBuilder.getStatsCounterSupplier().get();
        this.defaultLoader = cacheLoader;
        int iMin = Math.min(cacheBuilder.getInitialCapacity(), 1073741824);
        if (evictsBySize() && !customWeigher()) {
            iMin = (int) Math.min(iMin, maximumWeight);
        }
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        int i4 = 1;
        while (i4 < this.concurrencyLevel && (!evictsBySize() || ((long) i4) * 20 <= this.maxWeight)) {
            i3++;
            i4 <<= 1;
        }
        this.segmentShift = 32 - i3;
        this.segmentMask = i4 - 1;
        this.segments = newSegmentArray(i4);
        int i5 = iMin / i4;
        while (i2 < (i5 * i4 < iMin ? i5 + 1 : i5)) {
            i2 <<= 1;
        }
        if (evictsBySize()) {
            long j = this.maxWeight;
            long j2 = i4;
            long j3 = (j / j2) + 1;
            long j4 = j % j2;
            while (true) {
                Segment[] segmentArr = this.segments;
                if (i >= segmentArr.length) {
                    return;
                }
                if (i == j4) {
                    j3--;
                }
                segmentArr[i] = createSegment(i2, j3, (AbstractCache.StatsCounter) cacheBuilder.getStatsCounterSupplier().get());
                i++;
            }
        } else {
            while (true) {
                Segment[] segmentArr2 = this.segments;
                if (i >= segmentArr2.length) {
                    return;
                }
                segmentArr2[i] = createSegment(i2, -1L, (AbstractCache.StatsCounter) cacheBuilder.getStatsCounterSupplier().get());
                i++;
            }
        }
    }

    boolean evictsBySize() {
        return this.maxWeight >= 0;
    }

    boolean customWeigher() {
        return this.weigher != CacheBuilder.OneWeigher.INSTANCE;
    }

    boolean expiresAfterWrite() {
        return this.expireAfterWriteNanos > 0;
    }

    boolean expiresAfterAccess() {
        return this.expireAfterAccessNanos > 0;
    }

    boolean refreshes() {
        return this.refreshNanos > 0;
    }

    boolean usesAccessQueue() {
        return expiresAfterAccess() || evictsBySize();
    }

    boolean usesWriteQueue() {
        return expiresAfterWrite();
    }

    boolean recordsWrite() {
        return expiresAfterWrite() || refreshes();
    }

    boolean recordsAccess() {
        return expiresAfterAccess();
    }

    boolean recordsTime() {
        return recordsWrite() || recordsAccess();
    }

    boolean usesWriteEntries() {
        return usesWriteQueue() || recordsWrite();
    }

    boolean usesAccessEntries() {
        return usesAccessQueue() || recordsAccess();
    }

    boolean usesKeyReferences() {
        return this.keyStrength != Strength.STRONG;
    }

    boolean usesValueReferences() {
        return this.valueStrength != Strength.STRONG;
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 com.google.common.cache.LocalCache$EntryFactory, still in use, count: 1, list:
  (r0v0 com.google.common.cache.LocalCache$EntryFactory) from 0x0058: FILLED_NEW_ARRAY 
  (r0v0 com.google.common.cache.LocalCache$EntryFactory)
  (r1v1 com.google.common.cache.LocalCache$EntryFactory)
  (r3v1 com.google.common.cache.LocalCache$EntryFactory)
  (r5v1 com.google.common.cache.LocalCache$EntryFactory)
  (r7v1 com.google.common.cache.LocalCache$EntryFactory)
  (r9v1 com.google.common.cache.LocalCache$EntryFactory)
  (r11v1 com.google.common.cache.LocalCache$EntryFactory)
  (r13v1 com.google.common.cache.LocalCache$EntryFactory)
 A[WRAPPED] (LINE:576) elemType: com.google.common.cache.LocalCache$EntryFactory
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    static abstract class EntryFactory {
        STRONG { // from class: com.google.common.cache.LocalCache.EntryFactory.1
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new StrongEntry(obj, i, referenceEntry);
            }
        },
        STRONG_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.2
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new StrongAccessEntry(obj, i, referenceEntry);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2, obj);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }
        },
        STRONG_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.3
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new StrongWriteEntry(obj, i, referenceEntry);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2, obj);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }
        },
        STRONG_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.4
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new StrongAccessWriteEntry(obj, i, referenceEntry);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2, obj);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.EntryFactory.5
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new WeakEntry(segment.keyReferenceQueue, obj, i, referenceEntry);
            }
        },
        WEAK_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.6
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new WeakAccessEntry(segment.keyReferenceQueue, obj, i, referenceEntry);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2, obj);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }
        },
        WEAK_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.7
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new WeakWriteEntry(segment.keyReferenceQueue, obj, i, referenceEntry);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2, obj);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }
        },
        WEAK_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.8
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new WeakAccessWriteEntry(segment.keyReferenceQueue, obj, i, referenceEntry);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2, obj);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }
        };

        static final EntryFactory[] factories = {new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.1
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new StrongEntry(obj, i, referenceEntry);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.2
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new StrongAccessEntry(obj, i, referenceEntry);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2, obj);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.3
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new StrongWriteEntry(obj, i, referenceEntry);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2, obj);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.4
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new StrongAccessWriteEntry(obj, i, referenceEntry);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2, obj);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.5
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new WeakEntry(segment.keyReferenceQueue, obj, i, referenceEntry);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.6
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new WeakAccessEntry(segment.keyReferenceQueue, obj, i, referenceEntry);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2, obj);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.7
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new WeakWriteEntry(segment.keyReferenceQueue, obj, i, referenceEntry);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2, obj);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.8
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new WeakAccessWriteEntry(segment.keyReferenceQueue, obj, i, referenceEntry);
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2, obj);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }
        }};

        abstract ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry);

        private EntryFactory(String str, int i) {
            super(str, i);
        }

        public static EntryFactory valueOf(String str) {
            return (EntryFactory) Enum.valueOf(EntryFactory.class, str);
        }

        public static EntryFactory[] values() {
            return (EntryFactory[]) $VALUES.clone();
        }

        static {
        }

        static EntryFactory getFactory(Strength strength, boolean z, boolean z2) {
            return factories[(((strength == Strength.WEAK ? 4 : 0) | (z ? 1 : 0)) == true ? 1 : 0) | (z2 ? 2 : 0)];
        }

        ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
            return newEntry(segment, obj, referenceEntry.getHash(), referenceEntry2);
        }

        void copyAccessEntry(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
            referenceEntry2.setAccessTime(referenceEntry.getAccessTime());
            LocalCache.connectAccessOrder(referenceEntry.getPreviousInAccessQueue(), referenceEntry2);
            LocalCache.connectAccessOrder(referenceEntry2, referenceEntry.getNextInAccessQueue());
            LocalCache.nullifyAccessOrder(referenceEntry);
        }

        void copyWriteEntry(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
            referenceEntry2.setWriteTime(referenceEntry.getWriteTime());
            LocalCache.connectWriteOrder(referenceEntry.getPreviousInWriteQueue(), referenceEntry2);
            LocalCache.connectWriteOrder(referenceEntry2, referenceEntry.getNextInWriteQueue());
            LocalCache.nullifyWriteOrder(referenceEntry);
        }
    }

    static ValueReference unset() {
        return UNSET;
    }

    static abstract class AbstractReferenceEntry implements ReferenceEntry {
        AbstractReferenceEntry() {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference valueReference) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public Object getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }
    }

    static ReferenceEntry nullEntry() {
        return NullEntry.INSTANCE;
    }

    static Queue discardingQueue() {
        return DISCARDING_QUEUE;
    }

    static class StrongEntry extends AbstractReferenceEntry {
        final int hash;
        final Object key;
        final ReferenceEntry next;
        volatile ValueReference valueReference = LocalCache.unset();

        StrongEntry(Object obj, int i, ReferenceEntry referenceEntry) {
            this.key = obj;
            this.hash = i;
            this.next = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public Object getKey() {
            return this.key;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ValueReference getValueReference() {
            return this.valueReference;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference valueReference) {
            this.valueReference = valueReference;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public int getHash() {
            return this.hash;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry getNext() {
            return this.next;
        }
    }

    static final class StrongAccessEntry extends StrongEntry {
        volatile long accessTime;
        ReferenceEntry nextAccess;
        ReferenceEntry previousAccess;

        StrongAccessEntry(Object obj, int i, ReferenceEntry referenceEntry) {
            super(obj, i, referenceEntry);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.accessTime = j;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry referenceEntry) {
            this.nextAccess = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry referenceEntry) {
            this.previousAccess = referenceEntry;
        }
    }

    static final class StrongWriteEntry extends StrongEntry {
        ReferenceEntry nextWrite;
        ReferenceEntry previousWrite;
        volatile long writeTime;

        StrongWriteEntry(Object obj, int i, ReferenceEntry referenceEntry) {
            super(obj, i, referenceEntry);
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.writeTime = j;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry referenceEntry) {
            this.nextWrite = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry referenceEntry) {
            this.previousWrite = referenceEntry;
        }
    }

    static final class StrongAccessWriteEntry extends StrongEntry {
        volatile long accessTime;
        ReferenceEntry nextAccess;
        ReferenceEntry nextWrite;
        ReferenceEntry previousAccess;
        ReferenceEntry previousWrite;
        volatile long writeTime;

        StrongAccessWriteEntry(Object obj, int i, ReferenceEntry referenceEntry) {
            super(obj, i, referenceEntry);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.accessTime = j;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry referenceEntry) {
            this.nextAccess = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry referenceEntry) {
            this.previousAccess = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.writeTime = j;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry referenceEntry) {
            this.nextWrite = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry referenceEntry) {
            this.previousWrite = referenceEntry;
        }
    }

    static class WeakEntry extends WeakReference implements ReferenceEntry {
        final int hash;
        final ReferenceEntry next;
        volatile ValueReference valueReference;

        WeakEntry(ReferenceQueue referenceQueue, Object obj, int i, ReferenceEntry referenceEntry) {
            super(obj, referenceQueue);
            this.valueReference = LocalCache.unset();
            this.hash = i;
            this.next = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public Object getKey() {
            return get();
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference getValueReference() {
            return this.valueReference;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void setValueReference(ValueReference valueReference) {
            this.valueReference = valueReference;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int getHash() {
            return this.hash;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry getNext() {
            return this.next;
        }
    }

    static final class WeakAccessEntry extends WeakEntry {
        volatile long accessTime;
        ReferenceEntry nextAccess;
        ReferenceEntry previousAccess;

        WeakAccessEntry(ReferenceQueue referenceQueue, Object obj, int i, ReferenceEntry referenceEntry) {
            super(referenceQueue, obj, i, referenceEntry);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.accessTime = j;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry referenceEntry) {
            this.nextAccess = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry referenceEntry) {
            this.previousAccess = referenceEntry;
        }
    }

    static final class WeakWriteEntry extends WeakEntry {
        ReferenceEntry nextWrite;
        ReferenceEntry previousWrite;
        volatile long writeTime;

        WeakWriteEntry(ReferenceQueue referenceQueue, Object obj, int i, ReferenceEntry referenceEntry) {
            super(referenceQueue, obj, i, referenceEntry);
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.writeTime = j;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry referenceEntry) {
            this.nextWrite = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry referenceEntry) {
            this.previousWrite = referenceEntry;
        }
    }

    static final class WeakAccessWriteEntry extends WeakEntry {
        volatile long accessTime;
        ReferenceEntry nextAccess;
        ReferenceEntry nextWrite;
        ReferenceEntry previousAccess;
        ReferenceEntry previousWrite;
        volatile long writeTime;

        WeakAccessWriteEntry(ReferenceQueue referenceQueue, Object obj, int i, ReferenceEntry referenceEntry) {
            super(referenceQueue, obj, i, referenceEntry);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.accessTime = j;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry referenceEntry) {
            this.nextAccess = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry referenceEntry) {
            this.previousAccess = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.writeTime = j;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry referenceEntry) {
            this.nextWrite = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry referenceEntry) {
            this.previousWrite = referenceEntry;
        }
    }

    static class WeakValueReference extends WeakReference implements ValueReference {
        final ReferenceEntry entry;

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(Object obj) {
        }

        WeakValueReference(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            super(obj, referenceQueue);
            this.entry = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry getEntry() {
            return this.entry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference copyFor(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return new WeakValueReference(referenceQueue, obj, referenceEntry);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object waitForValue() {
            return get();
        }
    }

    static class SoftValueReference extends SoftReference implements ValueReference {
        final ReferenceEntry entry;

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(Object obj) {
        }

        SoftValueReference(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            super(obj, referenceQueue);
            this.entry = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry getEntry() {
            return this.entry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference copyFor(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return new SoftValueReference(referenceQueue, obj, referenceEntry);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object waitForValue() {
            return get();
        }
    }

    static class StrongValueReference implements ValueReference {
        final Object referent;

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference copyFor(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(Object obj) {
        }

        StrongValueReference(Object obj) {
            this.referent = obj;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object get() {
            return this.referent;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object waitForValue() {
            return get();
        }
    }

    static final class WeightedWeakValueReference extends WeakValueReference {
        final int weight;

        WeightedWeakValueReference(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry, int i) {
            super(referenceQueue, obj, referenceEntry);
            this.weight = i;
        }

        @Override // com.google.common.cache.LocalCache.WeakValueReference, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.weight;
        }

        @Override // com.google.common.cache.LocalCache.WeakValueReference, com.google.common.cache.LocalCache.ValueReference
        public ValueReference copyFor(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return new WeightedWeakValueReference(referenceQueue, obj, referenceEntry, this.weight);
        }
    }

    static final class WeightedSoftValueReference extends SoftValueReference {
        final int weight;

        WeightedSoftValueReference(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry, int i) {
            super(referenceQueue, obj, referenceEntry);
            this.weight = i;
        }

        @Override // com.google.common.cache.LocalCache.SoftValueReference, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.weight;
        }

        @Override // com.google.common.cache.LocalCache.SoftValueReference, com.google.common.cache.LocalCache.ValueReference
        public ValueReference copyFor(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return new WeightedSoftValueReference(referenceQueue, obj, referenceEntry, this.weight);
        }
    }

    static final class WeightedStrongValueReference extends StrongValueReference {
        final int weight;

        WeightedStrongValueReference(Object obj, int i) {
            super(obj);
            this.weight = i;
        }

        @Override // com.google.common.cache.LocalCache.StrongValueReference, com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.weight;
        }
    }

    int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    void reclaimValue(ValueReference valueReference) {
        ReferenceEntry entry = valueReference.getEntry();
        int hash = entry.getHash();
        segmentFor(hash).reclaimValue(entry.getKey(), hash, valueReference);
    }

    void reclaimKey(ReferenceEntry referenceEntry) {
        int hash = referenceEntry.getHash();
        segmentFor(hash).reclaimKey(referenceEntry, hash);
    }

    Segment segmentFor(int i) {
        return this.segments[this.segmentMask & (i >>> this.segmentShift)];
    }

    Segment createSegment(int i, long j, AbstractCache.StatsCounter statsCounter) {
        return new Segment(this, i, j, statsCounter);
    }

    Object getLiveValue(ReferenceEntry referenceEntry, long j) {
        Object obj;
        if (referenceEntry.getKey() == null || (obj = referenceEntry.getValueReference().get()) == null || isExpired(referenceEntry, j)) {
            return null;
        }
        return obj;
    }

    boolean isExpired(ReferenceEntry referenceEntry, long j) {
        Preconditions.checkNotNull(referenceEntry);
        if (!expiresAfterAccess() || j - referenceEntry.getAccessTime() < this.expireAfterAccessNanos) {
            return expiresAfterWrite() && j - referenceEntry.getWriteTime() >= this.expireAfterWriteNanos;
        }
        return true;
    }

    static void connectAccessOrder(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
        referenceEntry.setNextInAccessQueue(referenceEntry2);
        referenceEntry2.setPreviousInAccessQueue(referenceEntry);
    }

    static void nullifyAccessOrder(ReferenceEntry referenceEntry) {
        ReferenceEntry referenceEntryNullEntry = nullEntry();
        referenceEntry.setNextInAccessQueue(referenceEntryNullEntry);
        referenceEntry.setPreviousInAccessQueue(referenceEntryNullEntry);
    }

    static void connectWriteOrder(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
        referenceEntry.setNextInWriteQueue(referenceEntry2);
        referenceEntry2.setPreviousInWriteQueue(referenceEntry);
    }

    static void nullifyWriteOrder(ReferenceEntry referenceEntry) {
        ReferenceEntry referenceEntryNullEntry = nullEntry();
        referenceEntry.setNextInWriteQueue(referenceEntryNullEntry);
        referenceEntry.setPreviousInWriteQueue(referenceEntryNullEntry);
    }

    void processPendingNotifications() {
        while (true) {
            RemovalNotification removalNotification = (RemovalNotification) this.removalNotificationQueue.poll();
            if (removalNotification == null) {
                return;
            }
            try {
                this.removalListener.onRemoval(removalNotification);
            } catch (Throwable th) {
                logger.log(Level.WARNING, "Exception thrown by removal listener", th);
            }
        }
    }

    final Segment[] newSegmentArray(int i) {
        return new Segment[i];
    }

    static class Segment extends ReentrantLock {
        final Queue accessQueue;
        volatile int count;
        final ReferenceQueue keyReferenceQueue;
        final LocalCache map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue recencyQueue;
        final AbstractCache.StatsCounter statsCounter;
        volatile AtomicReferenceArray table;
        int threshold;
        long totalWeight;
        final ReferenceQueue valueReferenceQueue;
        final Queue writeQueue;

        Segment(LocalCache localCache, int i, long j, AbstractCache.StatsCounter statsCounter) {
            this.map = localCache;
            this.maxSegmentWeight = j;
            this.statsCounter = (AbstractCache.StatsCounter) Preconditions.checkNotNull(statsCounter);
            initTable(newEntryArray(i));
            this.keyReferenceQueue = localCache.usesKeyReferences() ? new ReferenceQueue() : null;
            this.valueReferenceQueue = localCache.usesValueReferences() ? new ReferenceQueue() : null;
            this.recencyQueue = localCache.usesAccessQueue() ? new ConcurrentLinkedQueue() : LocalCache.discardingQueue();
            this.writeQueue = localCache.usesWriteQueue() ? new WriteQueue() : LocalCache.discardingQueue();
            this.accessQueue = localCache.usesAccessQueue() ? new AccessQueue() : LocalCache.discardingQueue();
        }

        AtomicReferenceArray newEntryArray(int i) {
            return new AtomicReferenceArray(i);
        }

        void initTable(AtomicReferenceArray atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (!this.map.customWeigher()) {
                int i = this.threshold;
                if (i == this.maxSegmentWeight) {
                    this.threshold = i + 1;
                }
            }
            this.table = atomicReferenceArray;
        }

        ReferenceEntry newEntry(Object obj, int i, ReferenceEntry referenceEntry) {
            return this.map.entryFactory.newEntry(this, Preconditions.checkNotNull(obj), i, referenceEntry);
        }

        ReferenceEntry copyEntry(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
            Object key = referenceEntry.getKey();
            if (key == null) {
                return null;
            }
            ValueReference valueReference = referenceEntry.getValueReference();
            Object obj = valueReference.get();
            if (obj == null && valueReference.isActive()) {
                return null;
            }
            ReferenceEntry referenceEntryCopyEntry = this.map.entryFactory.copyEntry(this, referenceEntry, referenceEntry2, key);
            referenceEntryCopyEntry.setValueReference(valueReference.copyFor(this.valueReferenceQueue, obj, referenceEntryCopyEntry));
            return referenceEntryCopyEntry;
        }

        void setValue(ReferenceEntry referenceEntry, Object obj, Object obj2, long j) {
            ValueReference valueReference = referenceEntry.getValueReference();
            int iWeigh = this.map.weigher.weigh(obj, obj2);
            Preconditions.checkState(iWeigh >= 0, "Weights must be non-negative");
            referenceEntry.setValueReference(this.map.valueStrength.referenceValue(this, referenceEntry, obj2, iWeigh));
            recordWrite(referenceEntry, iWeigh, j);
            valueReference.notifyNewValue(obj2);
        }

        Object get(Object obj, int i, CacheLoader cacheLoader) {
            ReferenceEntry entry;
            Preconditions.checkNotNull(obj);
            Preconditions.checkNotNull(cacheLoader);
            try {
                try {
                    if (this.count != 0 && (entry = getEntry(obj, i)) != null) {
                        long j = this.map.ticker.read();
                        Object liveValue = getLiveValue(entry, j);
                        if (liveValue != null) {
                            recordRead(entry, j);
                            this.statsCounter.recordHits(1);
                            Object objScheduleRefresh = scheduleRefresh(entry, obj, i, liveValue, j, cacheLoader);
                            postReadCleanup();
                            return objScheduleRefresh;
                        }
                        ValueReference valueReference = entry.getValueReference();
                        if (valueReference.isLoading()) {
                            Object objWaitForLoadingValue = waitForLoadingValue(entry, obj, valueReference);
                            postReadCleanup();
                            return objWaitForLoadingValue;
                        }
                    }
                    Object objLockedGetOrLoad = lockedGetOrLoad(obj, i, cacheLoader);
                    postReadCleanup();
                    return objLockedGetOrLoad;
                } catch (ExecutionException e) {
                    Throwable cause = e.getCause();
                    if (cause instanceof Error) {
                        throw new ExecutionError((Error) cause);
                    }
                    if (cause instanceof RuntimeException) {
                        throw new UncheckedExecutionException(cause);
                    }
                    throw e;
                }
            } catch (Throwable th) {
                postReadCleanup();
                throw th;
            }
        }

        Object get(Object obj, int i) {
            try {
                if (this.count != 0) {
                    long j = this.map.ticker.read();
                    ReferenceEntry liveEntry = getLiveEntry(obj, i, j);
                    if (liveEntry == null) {
                        return null;
                    }
                    Object obj2 = liveEntry.getValueReference().get();
                    if (obj2 != null) {
                        recordRead(liveEntry, j);
                        return scheduleRefresh(liveEntry, liveEntry.getKey(), i, obj2, j, this.map.defaultLoader);
                    }
                    tryDrainReferenceQueues();
                }
                return null;
            } finally {
                postReadCleanup();
            }
        }

        Object lockedGetOrLoad(Object obj, int i, CacheLoader cacheLoader) {
            LoadingValueReference loadingValueReference;
            boolean z;
            ValueReference valueReference;
            Object objLoadSync;
            lock();
            try {
                long j = this.map.ticker.read();
                preWriteCleanup(j);
                int i2 = this.count - 1;
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                ReferenceEntry referenceEntryNewEntry = referenceEntry;
                while (true) {
                    loadingValueReference = null;
                    if (referenceEntryNewEntry == null) {
                        z = true;
                        valueReference = null;
                        break;
                    }
                    Object key = referenceEntryNewEntry.getKey();
                    if (referenceEntryNewEntry.getHash() != i || key == null || !this.map.keyEquivalence.equivalent(obj, key)) {
                        referenceEntryNewEntry = referenceEntryNewEntry.getNext();
                    } else {
                        ValueReference valueReference2 = referenceEntryNewEntry.getValueReference();
                        if (valueReference2.isLoading()) {
                            z = false;
                        } else {
                            Object obj2 = valueReference2.get();
                            if (obj2 == null) {
                                enqueueNotification(key, i, obj2, valueReference2.getWeight(), RemovalCause.COLLECTED);
                            } else if (this.map.isExpired(referenceEntryNewEntry, j)) {
                                enqueueNotification(key, i, obj2, valueReference2.getWeight(), RemovalCause.EXPIRED);
                            } else {
                                recordLockedRead(referenceEntryNewEntry, j);
                                this.statsCounter.recordHits(1);
                                unlock();
                                postWriteCleanup();
                                return obj2;
                            }
                            this.writeQueue.remove(referenceEntryNewEntry);
                            this.accessQueue.remove(referenceEntryNewEntry);
                            this.count = i2;
                            z = true;
                        }
                        valueReference = valueReference2;
                        break;
                    }
                }
                if (z) {
                    loadingValueReference = new LoadingValueReference();
                    if (referenceEntryNewEntry == null) {
                        referenceEntryNewEntry = newEntry(obj, i, referenceEntry);
                        referenceEntryNewEntry.setValueReference(loadingValueReference);
                        atomicReferenceArray.set(length, referenceEntryNewEntry);
                    } else {
                        referenceEntryNewEntry.setValueReference(loadingValueReference);
                    }
                }
                unlock();
                postWriteCleanup();
                if (z) {
                    try {
                        synchronized (referenceEntryNewEntry) {
                            objLoadSync = loadSync(obj, i, loadingValueReference, cacheLoader);
                        }
                        this.statsCounter.recordMisses(1);
                        return objLoadSync;
                    } catch (Throwable th) {
                        this.statsCounter.recordMisses(1);
                        throw th;
                    }
                }
                return waitForLoadingValue(referenceEntryNewEntry, obj, valueReference);
            } catch (Throwable th2) {
                unlock();
                postWriteCleanup();
                throw th2;
            }
        }

        Object waitForLoadingValue(ReferenceEntry referenceEntry, Object obj, ValueReference valueReference) {
            if (!valueReference.isLoading()) {
                throw new AssertionError();
            }
            Preconditions.checkState(!Thread.holdsLock(referenceEntry), "Recursive load of: %s", obj);
            try {
                Object objWaitForValue = valueReference.waitForValue();
                if (objWaitForValue == null) {
                    throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + obj + InstructionFileId.DOT);
                }
                recordRead(referenceEntry, this.map.ticker.read());
                this.statsCounter.recordMisses(1);
                return objWaitForValue;
            } catch (Throwable th) {
                this.statsCounter.recordMisses(1);
                throw th;
            }
        }

        Object loadSync(Object obj, int i, LoadingValueReference loadingValueReference, CacheLoader cacheLoader) {
            return getAndRecordStats(obj, i, loadingValueReference, loadingValueReference.loadFuture(obj, cacheLoader));
        }

        ListenableFuture loadAsync(final Object obj, final int i, final LoadingValueReference loadingValueReference, CacheLoader cacheLoader) {
            final ListenableFuture listenableFutureLoadFuture = loadingValueReference.loadFuture(obj, cacheLoader);
            listenableFutureLoadFuture.addListener(new Runnable() { // from class: com.google.common.cache.LocalCache$Segment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadAsync$0(obj, i, loadingValueReference, listenableFutureLoadFuture);
                }
            }, MoreExecutors.directExecutor());
            return listenableFutureLoadFuture;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$loadAsync$0(Object obj, int i, LoadingValueReference loadingValueReference, ListenableFuture listenableFuture) {
            try {
                getAndRecordStats(obj, i, loadingValueReference, listenableFuture);
            } catch (Throwable th) {
                LocalCache.logger.log(Level.WARNING, "Exception thrown during refresh", th);
                loadingValueReference.setException(th);
            }
        }

        Object getAndRecordStats(Object obj, int i, LoadingValueReference loadingValueReference, ListenableFuture listenableFuture) throws Throwable {
            Object uninterruptibly;
            try {
                uninterruptibly = Uninterruptibles.getUninterruptibly(listenableFuture);
                try {
                    if (uninterruptibly == null) {
                        throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + obj + InstructionFileId.DOT);
                    }
                    this.statsCounter.recordLoadSuccess(loadingValueReference.elapsedNanos());
                    storeLoadedValue(obj, i, loadingValueReference, uninterruptibly);
                    return uninterruptibly;
                } catch (Throwable th) {
                    th = th;
                    if (uninterruptibly == null) {
                        this.statsCounter.recordLoadException(loadingValueReference.elapsedNanos());
                        removeLoadingValue(obj, i, loadingValueReference);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                uninterruptibly = null;
            }
        }

        Object scheduleRefresh(ReferenceEntry referenceEntry, Object obj, int i, Object obj2, long j, CacheLoader cacheLoader) {
            Object objRefresh;
            return (!this.map.refreshes() || j - referenceEntry.getWriteTime() <= this.map.refreshNanos || referenceEntry.getValueReference().isLoading() || (objRefresh = refresh(obj, i, cacheLoader, true)) == null) ? obj2 : objRefresh;
        }

        Object refresh(Object obj, int i, CacheLoader cacheLoader, boolean z) {
            LoadingValueReference loadingValueReferenceInsertLoadingValueReference = insertLoadingValueReference(obj, i, z);
            if (loadingValueReferenceInsertLoadingValueReference == null) {
                return null;
            }
            ListenableFuture listenableFutureLoadAsync = loadAsync(obj, i, loadingValueReferenceInsertLoadingValueReference, cacheLoader);
            if (listenableFutureLoadAsync.isDone()) {
                try {
                    return Uninterruptibles.getUninterruptibly(listenableFutureLoadAsync);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        LoadingValueReference insertLoadingValueReference(Object obj, int i, boolean z) {
            lock();
            try {
                long j = this.map.ticker.read();
                preWriteCleanup(j);
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry next = referenceEntry; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        ValueReference valueReference = next.getValueReference();
                        if (!valueReference.isLoading() && (!z || j - next.getWriteTime() >= this.map.refreshNanos)) {
                            this.modCount++;
                            LoadingValueReference loadingValueReference = new LoadingValueReference(valueReference);
                            next.setValueReference(loadingValueReference);
                            return loadingValueReference;
                        }
                        return null;
                    }
                }
                this.modCount++;
                LoadingValueReference loadingValueReference2 = new LoadingValueReference();
                ReferenceEntry referenceEntryNewEntry = newEntry(obj, i, referenceEntry);
                referenceEntryNewEntry.setValueReference(loadingValueReference2);
                atomicReferenceArray.set(length, referenceEntryNewEntry);
                return loadingValueReference2;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        void drainReferenceQueues() {
            if (this.map.usesKeyReferences()) {
                drainKeyReferenceQueue();
            }
            if (this.map.usesValueReferences()) {
                drainValueReferenceQueue();
            }
        }

        void drainKeyReferenceQueue() {
            int i = 0;
            do {
                Object objPoll = this.keyReferenceQueue.poll();
                if (objPoll == null) {
                    return;
                }
                this.map.reclaimKey((ReferenceEntry) objPoll);
                i++;
            } while (i != 16);
        }

        void drainValueReferenceQueue() {
            int i = 0;
            do {
                Object objPoll = this.valueReferenceQueue.poll();
                if (objPoll == null) {
                    return;
                }
                this.map.reclaimValue((ValueReference) objPoll);
                i++;
            } while (i != 16);
        }

        void clearReferenceQueues() {
            if (this.map.usesKeyReferences()) {
                clearKeyReferenceQueue();
            }
            if (this.map.usesValueReferences()) {
                clearValueReferenceQueue();
            }
        }

        void clearKeyReferenceQueue() {
            while (this.keyReferenceQueue.poll() != null) {
            }
        }

        void clearValueReferenceQueue() {
            while (this.valueReferenceQueue.poll() != null) {
            }
        }

        void recordRead(ReferenceEntry referenceEntry, long j) {
            if (this.map.recordsAccess()) {
                referenceEntry.setAccessTime(j);
            }
            this.recencyQueue.add(referenceEntry);
        }

        void recordLockedRead(ReferenceEntry referenceEntry, long j) {
            if (this.map.recordsAccess()) {
                referenceEntry.setAccessTime(j);
            }
            this.accessQueue.add(referenceEntry);
        }

        void recordWrite(ReferenceEntry referenceEntry, int i, long j) {
            drainRecencyQueue();
            this.totalWeight += (long) i;
            if (this.map.recordsAccess()) {
                referenceEntry.setAccessTime(j);
            }
            if (this.map.recordsWrite()) {
                referenceEntry.setWriteTime(j);
            }
            this.accessQueue.add(referenceEntry);
            this.writeQueue.add(referenceEntry);
        }

        void drainRecencyQueue() {
            while (true) {
                ReferenceEntry referenceEntry = (ReferenceEntry) this.recencyQueue.poll();
                if (referenceEntry == null) {
                    return;
                }
                if (this.accessQueue.contains(referenceEntry)) {
                    this.accessQueue.add(referenceEntry);
                }
            }
        }

        void tryExpireEntries(long j) {
            if (tryLock()) {
                try {
                    expireEntries(j);
                } finally {
                    unlock();
                }
            }
        }

        void expireEntries(long j) {
            ReferenceEntry referenceEntry;
            ReferenceEntry referenceEntry2;
            drainRecencyQueue();
            do {
                referenceEntry = (ReferenceEntry) this.writeQueue.peek();
                if (referenceEntry == null || !this.map.isExpired(referenceEntry, j)) {
                    do {
                        referenceEntry2 = (ReferenceEntry) this.accessQueue.peek();
                        if (referenceEntry2 == null || !this.map.isExpired(referenceEntry2, j)) {
                            return;
                        }
                    } while (removeEntry(referenceEntry2, referenceEntry2.getHash(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (removeEntry(referenceEntry, referenceEntry.getHash(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        void enqueueNotification(Object obj, int i, Object obj2, int i2, RemovalCause removalCause) {
            this.totalWeight -= (long) i2;
            if (removalCause.wasEvicted()) {
                this.statsCounter.recordEviction();
            }
            if (this.map.removalNotificationQueue != LocalCache.DISCARDING_QUEUE) {
                this.map.removalNotificationQueue.offer(RemovalNotification.create(obj, obj2, removalCause));
            }
        }

        void evictEntries(ReferenceEntry referenceEntry) {
            if (this.map.evictsBySize()) {
                drainRecencyQueue();
                if (referenceEntry.getValueReference().getWeight() > this.maxSegmentWeight && !removeEntry(referenceEntry, referenceEntry.getHash(), RemovalCause.SIZE)) {
                    throw new AssertionError();
                }
                while (this.totalWeight > this.maxSegmentWeight) {
                    ReferenceEntry nextEvictable = getNextEvictable();
                    if (!removeEntry(nextEvictable, nextEvictable.getHash(), RemovalCause.SIZE)) {
                        throw new AssertionError();
                    }
                }
            }
        }

        ReferenceEntry getNextEvictable() {
            for (ReferenceEntry referenceEntry : this.accessQueue) {
                if (referenceEntry.getValueReference().getWeight() > 0) {
                    return referenceEntry;
                }
            }
            throw new AssertionError();
        }

        ReferenceEntry getFirst(int i) {
            AtomicReferenceArray atomicReferenceArray = this.table;
            return (ReferenceEntry) atomicReferenceArray.get(i & (atomicReferenceArray.length() - 1));
        }

        ReferenceEntry getEntry(Object obj, int i) {
            for (ReferenceEntry first = getFirst(i); first != null; first = first.getNext()) {
                if (first.getHash() == i) {
                    Object key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.keyEquivalence.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        ReferenceEntry getLiveEntry(Object obj, int i, long j) {
            ReferenceEntry entry = getEntry(obj, i);
            if (entry == null) {
                return null;
            }
            if (!this.map.isExpired(entry, j)) {
                return entry;
            }
            tryExpireEntries(j);
            return null;
        }

        Object getLiveValue(ReferenceEntry referenceEntry, long j) {
            if (referenceEntry.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            Object obj = referenceEntry.getValueReference().get();
            if (obj == null) {
                tryDrainReferenceQueues();
                return null;
            }
            if (!this.map.isExpired(referenceEntry, j)) {
                return obj;
            }
            tryExpireEntries(j);
            return null;
        }

        boolean containsKey(Object obj, int i) {
            try {
                if (this.count == 0) {
                    return false;
                }
                ReferenceEntry liveEntry = getLiveEntry(obj, i, this.map.ticker.read());
                if (liveEntry == null) {
                    return false;
                }
                return liveEntry.getValueReference().get() != null;
            } finally {
                postReadCleanup();
            }
        }

        Object put(Object obj, int i, Object obj2, boolean z) {
            int i2;
            lock();
            try {
                long j = this.map.ticker.read();
                preWriteCleanup(j);
                if (this.count + 1 > this.threshold) {
                    expand();
                }
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry next = referenceEntry; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        ValueReference valueReference = next.getValueReference();
                        Object obj3 = valueReference.get();
                        if (obj3 != null) {
                            if (z) {
                                recordLockedRead(next, j);
                            } else {
                                this.modCount++;
                                enqueueNotification(obj, i, obj3, valueReference.getWeight(), RemovalCause.REPLACED);
                                setValue(next, obj, obj2, j);
                                evictEntries(next);
                            }
                            return obj3;
                        }
                        this.modCount++;
                        if (valueReference.isActive()) {
                            enqueueNotification(obj, i, obj3, valueReference.getWeight(), RemovalCause.COLLECTED);
                            setValue(next, obj, obj2, j);
                            i2 = this.count;
                        } else {
                            setValue(next, obj, obj2, j);
                            i2 = this.count + 1;
                        }
                        this.count = i2;
                        evictEntries(next);
                        return null;
                    }
                }
                this.modCount++;
                ReferenceEntry referenceEntryNewEntry = newEntry(obj, i, referenceEntry);
                setValue(referenceEntryNewEntry, obj, obj2, j);
                atomicReferenceArray.set(length, referenceEntryNewEntry);
                this.count++;
                evictEntries(referenceEntryNewEntry);
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        void expand() {
            AtomicReferenceArray atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i = this.count;
            AtomicReferenceArray atomicReferenceArrayNewEntryArray = newEntryArray(length << 1);
            this.threshold = (atomicReferenceArrayNewEntryArray.length() * 3) / 4;
            int length2 = atomicReferenceArrayNewEntryArray.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                ReferenceEntry next = (ReferenceEntry) atomicReferenceArray.get(i2);
                if (next != null) {
                    ReferenceEntry next2 = next.getNext();
                    int hash = next.getHash() & length2;
                    if (next2 == null) {
                        atomicReferenceArrayNewEntryArray.set(hash, next);
                    } else {
                        ReferenceEntry referenceEntry = next;
                        while (next2 != null) {
                            int hash2 = next2.getHash() & length2;
                            if (hash2 != hash) {
                                referenceEntry = next2;
                                hash = hash2;
                            }
                            next2 = next2.getNext();
                        }
                        atomicReferenceArrayNewEntryArray.set(hash, referenceEntry);
                        while (next != referenceEntry) {
                            int hash3 = next.getHash() & length2;
                            ReferenceEntry referenceEntryCopyEntry = copyEntry(next, (ReferenceEntry) atomicReferenceArrayNewEntryArray.get(hash3));
                            if (referenceEntryCopyEntry != null) {
                                atomicReferenceArrayNewEntryArray.set(hash3, referenceEntryCopyEntry);
                            } else {
                                removeCollectedEntry(next);
                                i--;
                            }
                            next = next.getNext();
                        }
                    }
                }
            }
            this.table = atomicReferenceArrayNewEntryArray;
            this.count = i;
        }

        boolean replace(Object obj, int i, Object obj2, Object obj3) {
            lock();
            try {
                long j = this.map.ticker.read();
                preWriteCleanup(j);
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry next = referenceEntry; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i && key != null) {
                        if (this.map.keyEquivalence.equivalent(obj, key)) {
                            ValueReference valueReference = next.getValueReference();
                            Object obj4 = valueReference.get();
                            if (obj4 == null) {
                                if (!valueReference.isActive()) {
                                    break;
                                }
                                this.modCount++;
                                ReferenceEntry referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry, next, key, i, obj4, valueReference, RemovalCause.COLLECTED);
                                int i2 = this.count - 1;
                                atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                                this.count = i2;
                                break;
                            }
                            if (this.map.valueEquivalence.equivalent(obj2, obj4)) {
                                this.modCount++;
                                enqueueNotification(obj, i, obj4, valueReference.getWeight(), RemovalCause.REPLACED);
                                setValue(next, obj, obj3, j);
                                evictEntries(next);
                                return true;
                            }
                            recordLockedRead(next, j);
                            break;
                        }
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        Object replace(Object obj, int i, Object obj2) {
            lock();
            try {
                long j = this.map.ticker.read();
                preWriteCleanup(j);
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry next = referenceEntry; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i && key != null) {
                        if (this.map.keyEquivalence.equivalent(obj, key)) {
                            ValueReference valueReference = next.getValueReference();
                            Object obj3 = valueReference.get();
                            if (obj3 == null) {
                                if (!valueReference.isActive()) {
                                    break;
                                }
                                this.modCount++;
                                ReferenceEntry referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry, next, key, i, obj3, valueReference, RemovalCause.COLLECTED);
                                int i2 = this.count - 1;
                                atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                                this.count = i2;
                                break;
                            }
                            this.modCount++;
                            enqueueNotification(obj, i, obj3, valueReference.getWeight(), RemovalCause.REPLACED);
                            setValue(next, obj, obj2, j);
                            evictEntries(next);
                            return obj3;
                        }
                    }
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        Object remove(Object obj, int i) {
            RemovalCause removalCause;
            lock();
            try {
                preWriteCleanup(this.map.ticker.read());
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry next = referenceEntry; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        ValueReference valueReference = next.getValueReference();
                        Object obj2 = valueReference.get();
                        if (obj2 != null) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else {
                            if (!valueReference.isActive()) {
                                break;
                            }
                            removalCause = RemovalCause.COLLECTED;
                        }
                        RemovalCause removalCause2 = removalCause;
                        this.modCount++;
                        ReferenceEntry referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry, next, key, i, obj2, valueReference, removalCause2);
                        int i2 = this.count - 1;
                        atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                        this.count = i2;
                        return obj2;
                    }
                }
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        boolean remove(Object obj, int i, Object obj2) {
            RemovalCause removalCause;
            lock();
            try {
                preWriteCleanup(this.map.ticker.read());
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry next = referenceEntry; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        ValueReference valueReference = next.getValueReference();
                        Object obj3 = valueReference.get();
                        if (this.map.valueEquivalence.equivalent(obj2, obj3)) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else {
                            if (obj3 != null || !valueReference.isActive()) {
                                break;
                                break;
                            }
                            removalCause = RemovalCause.COLLECTED;
                        }
                        this.modCount++;
                        ReferenceEntry referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry, next, key, i, obj3, valueReference, removalCause);
                        int i2 = this.count - 1;
                        atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                        this.count = i2;
                        return removalCause == RemovalCause.EXPLICIT;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        boolean storeLoadedValue(Object obj, int i, LoadingValueReference loadingValueReference, Object obj2) {
            lock();
            try {
                long j = this.map.ticker.read();
                preWriteCleanup(j);
                int i2 = this.count + 1;
                if (i2 > this.threshold) {
                    expand();
                    i2 = this.count + 1;
                }
                int i3 = i2;
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = i & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry next = referenceEntry; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        ValueReference valueReference = next.getValueReference();
                        Object obj3 = valueReference.get();
                        if (loadingValueReference != valueReference && (obj3 != null || valueReference == LocalCache.UNSET)) {
                            enqueueNotification(obj, i, obj2, 0, RemovalCause.REPLACED);
                            return false;
                        }
                        this.modCount++;
                        if (loadingValueReference.isActive()) {
                            enqueueNotification(obj, i, obj3, loadingValueReference.getWeight(), obj3 == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                            i3--;
                        }
                        setValue(next, obj, obj2, j);
                        this.count = i3;
                        evictEntries(next);
                        return true;
                    }
                }
                this.modCount++;
                ReferenceEntry referenceEntryNewEntry = newEntry(obj, i, referenceEntry);
                setValue(referenceEntryNewEntry, obj, obj2, j);
                atomicReferenceArray.set(length, referenceEntryNewEntry);
                this.count = i3;
                evictEntries(referenceEntryNewEntry);
                return true;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        void clear() {
            if (this.count != 0) {
                lock();
                try {
                    preWriteCleanup(this.map.ticker.read());
                    AtomicReferenceArray atomicReferenceArray = this.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (ReferenceEntry next = (ReferenceEntry) atomicReferenceArray.get(i); next != null; next = next.getNext()) {
                            if (next.getValueReference().isActive()) {
                                Object key = next.getKey();
                                Object obj = next.getValueReference().get();
                                enqueueNotification(key, next.getHash(), obj, next.getValueReference().getWeight(), (key == null || obj == null) ? RemovalCause.COLLECTED : RemovalCause.EXPLICIT);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    clearReferenceQueues();
                    this.writeQueue.clear();
                    this.accessQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
        }

        ReferenceEntry removeValueFromChain(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj, int i, Object obj2, ValueReference valueReference, RemovalCause removalCause) {
            enqueueNotification(obj, i, obj2, valueReference.getWeight(), removalCause);
            this.writeQueue.remove(referenceEntry2);
            this.accessQueue.remove(referenceEntry2);
            if (valueReference.isLoading()) {
                valueReference.notifyNewValue(null);
                return referenceEntry;
            }
            return removeEntryFromChain(referenceEntry, referenceEntry2);
        }

        ReferenceEntry removeEntryFromChain(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
            int i = this.count;
            ReferenceEntry next = referenceEntry2.getNext();
            while (referenceEntry != referenceEntry2) {
                ReferenceEntry referenceEntryCopyEntry = copyEntry(referenceEntry, next);
                if (referenceEntryCopyEntry != null) {
                    next = referenceEntryCopyEntry;
                } else {
                    removeCollectedEntry(referenceEntry);
                    i--;
                }
                referenceEntry = referenceEntry.getNext();
            }
            this.count = i;
            return next;
        }

        void removeCollectedEntry(ReferenceEntry referenceEntry) {
            enqueueNotification(referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry.getValueReference().get(), referenceEntry.getValueReference().getWeight(), RemovalCause.COLLECTED);
            this.writeQueue.remove(referenceEntry);
            this.accessQueue.remove(referenceEntry);
        }

        boolean reclaimKey(ReferenceEntry referenceEntry, int i) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry next = referenceEntry2; next != null; next = next.getNext()) {
                    if (next == referenceEntry) {
                        this.modCount++;
                        ReferenceEntry referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry2, next, next.getKey(), i, next.getValueReference().get(), next.getValueReference(), RemovalCause.COLLECTED);
                        int i2 = this.count - 1;
                        atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                        this.count = i2;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        boolean reclaimValue(Object obj, int i, ValueReference valueReference) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry next = referenceEntry; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        if (next.getValueReference() != valueReference) {
                            return false;
                        }
                        this.modCount++;
                        ReferenceEntry referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry, next, key, i, valueReference.get(), valueReference, RemovalCause.COLLECTED);
                        int i2 = this.count - 1;
                        atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                        this.count = i2;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
            }
        }

        boolean removeLoadingValue(Object obj, int i, LoadingValueReference loadingValueReference) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry next = referenceEntry; next != null; next = next.getNext()) {
                    Object key = next.getKey();
                    if (next.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        if (next.getValueReference() != loadingValueReference) {
                            break;
                        }
                        if (loadingValueReference.isActive()) {
                            next.setValueReference(loadingValueReference.getOldValue());
                        } else {
                            atomicReferenceArray.set(length, removeEntryFromChain(referenceEntry, next));
                        }
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        boolean removeEntry(ReferenceEntry referenceEntry, int i, RemovalCause removalCause) {
            AtomicReferenceArray atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i;
            ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry next = referenceEntry2; next != null; next = next.getNext()) {
                if (next == referenceEntry) {
                    this.modCount++;
                    ReferenceEntry referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry2, next, next.getKey(), i, next.getValueReference().get(), next.getValueReference(), removalCause);
                    int i2 = this.count - 1;
                    atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                    this.count = i2;
                    return true;
                }
            }
            return false;
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        void preWriteCleanup(long j) {
            runLockedCleanup(j);
        }

        void postWriteCleanup() {
            runUnlockedCleanup();
        }

        void cleanUp() {
            runLockedCleanup(this.map.ticker.read());
            runUnlockedCleanup();
        }

        void runLockedCleanup(long j) {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries(j);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        void runUnlockedCleanup() {
            if (isHeldByCurrentThread()) {
                return;
            }
            this.map.processPendingNotifications();
        }
    }

    static class LoadingValueReference implements ValueReference {
        final SettableFuture futureValue;
        volatile ValueReference oldValue;
        final Stopwatch stopwatch;

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference copyFor(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return this;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry getEntry() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return true;
        }

        public LoadingValueReference() {
            this(LocalCache.unset());
        }

        public LoadingValueReference(ValueReference valueReference) {
            this.futureValue = SettableFuture.create();
            this.stopwatch = Stopwatch.createUnstarted();
            this.oldValue = valueReference;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return this.oldValue.isActive();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.oldValue.getWeight();
        }

        public boolean set(Object obj) {
            return this.futureValue.set(obj);
        }

        public boolean setException(Throwable th) {
            return this.futureValue.setException(th);
        }

        private ListenableFuture fullyFailedFuture(Throwable th) {
            return Futures.immediateFailedFuture(th);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void notifyNewValue(Object obj) {
            if (obj != null) {
                set(obj);
            } else {
                this.oldValue = LocalCache.unset();
            }
        }

        public ListenableFuture loadFuture(Object obj, CacheLoader cacheLoader) {
            try {
                this.stopwatch.start();
                Object obj2 = this.oldValue.get();
                if (obj2 == null) {
                    Object objLoad = cacheLoader.load(obj);
                    return set(objLoad) ? this.futureValue : Futures.immediateFuture(objLoad);
                }
                ListenableFuture listenableFutureReload = cacheLoader.reload(obj, obj2);
                if (listenableFutureReload == null) {
                    return Futures.immediateFuture(null);
                }
                return Futures.transform(listenableFutureReload, new Function() { // from class: com.google.common.cache.LocalCache$LoadingValueReference$$ExternalSyntheticLambda0
                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj3) {
                        return this.f$0.lambda$loadFuture$0(obj3);
                    }
                }, MoreExecutors.directExecutor());
            } catch (Throwable th) {
                ListenableFuture listenableFutureFullyFailedFuture = setException(th) ? this.futureValue : fullyFailedFuture(th);
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return listenableFutureFullyFailedFuture;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$loadFuture$0(Object obj) {
            set(obj);
            return obj;
        }

        public long elapsedNanos() {
            return this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object waitForValue() {
            return Uninterruptibles.getUninterruptibly(this.futureValue);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object get() {
            return this.oldValue.get();
        }

        public ValueReference getOldValue() {
            return this.oldValue;
        }
    }

    static final class WriteQueue extends AbstractQueue {
        final ReferenceEntry head = new AbstractReferenceEntry(this) { // from class: com.google.common.cache.LocalCache.WriteQueue.1
            ReferenceEntry nextWrite = this;
            ReferenceEntry previousWrite = this;

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public long getWriteTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setWriteTime(long j) {
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry getNextInWriteQueue() {
                return this.nextWrite;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setNextInWriteQueue(ReferenceEntry referenceEntry) {
                this.nextWrite = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry getPreviousInWriteQueue() {
                return this.previousWrite;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setPreviousInWriteQueue(ReferenceEntry referenceEntry) {
                this.previousWrite = referenceEntry;
            }
        };

        WriteQueue() {
        }

        @Override // java.util.Queue
        public boolean offer(ReferenceEntry referenceEntry) {
            LocalCache.connectWriteOrder(referenceEntry.getPreviousInWriteQueue(), referenceEntry.getNextInWriteQueue());
            LocalCache.connectWriteOrder(this.head.getPreviousInWriteQueue(), referenceEntry);
            LocalCache.connectWriteOrder(referenceEntry, this.head);
            return true;
        }

        @Override // java.util.Queue
        public ReferenceEntry peek() {
            ReferenceEntry nextInWriteQueue = this.head.getNextInWriteQueue();
            if (nextInWriteQueue == this.head) {
                return null;
            }
            return nextInWriteQueue;
        }

        @Override // java.util.Queue
        public ReferenceEntry poll() {
            ReferenceEntry nextInWriteQueue = this.head.getNextInWriteQueue();
            if (nextInWriteQueue == this.head) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry previousInWriteQueue = referenceEntry.getPreviousInWriteQueue();
            ReferenceEntry nextInWriteQueue = referenceEntry.getNextInWriteQueue();
            LocalCache.connectWriteOrder(previousInWriteQueue, nextInWriteQueue);
            LocalCache.nullifyWriteOrder(referenceEntry);
            return nextInWriteQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInWriteQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.head.getNextInWriteQueue() == this.head;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (ReferenceEntry nextInWriteQueue = this.head.getNextInWriteQueue(); nextInWriteQueue != this.head; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i++;
            }
            return i;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry nextInWriteQueue = this.head.getNextInWriteQueue();
            while (true) {
                ReferenceEntry referenceEntry = this.head;
                if (nextInWriteQueue != referenceEntry) {
                    ReferenceEntry nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    LocalCache.nullifyWriteOrder(nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                } else {
                    referenceEntry.setNextInWriteQueue(referenceEntry);
                    ReferenceEntry referenceEntry2 = this.head;
                    referenceEntry2.setPreviousInWriteQueue(referenceEntry2);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new AbstractSequentialIterator(peek()) { // from class: com.google.common.cache.LocalCache.WriteQueue.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractSequentialIterator
                public ReferenceEntry computeNext(ReferenceEntry referenceEntry) {
                    ReferenceEntry nextInWriteQueue = referenceEntry.getNextInWriteQueue();
                    if (nextInWriteQueue == WriteQueue.this.head) {
                        return null;
                    }
                    return nextInWriteQueue;
                }
            };
        }
    }

    static final class AccessQueue extends AbstractQueue {
        final ReferenceEntry head = new AbstractReferenceEntry(this) { // from class: com.google.common.cache.LocalCache.AccessQueue.1
            ReferenceEntry nextAccess = this;
            ReferenceEntry previousAccess = this;

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public long getAccessTime() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setAccessTime(long j) {
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry getNextInAccessQueue() {
                return this.nextAccess;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setNextInAccessQueue(ReferenceEntry referenceEntry) {
                this.nextAccess = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry getPreviousInAccessQueue() {
                return this.previousAccess;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void setPreviousInAccessQueue(ReferenceEntry referenceEntry) {
                this.previousAccess = referenceEntry;
            }
        };

        AccessQueue() {
        }

        @Override // java.util.Queue
        public boolean offer(ReferenceEntry referenceEntry) {
            LocalCache.connectAccessOrder(referenceEntry.getPreviousInAccessQueue(), referenceEntry.getNextInAccessQueue());
            LocalCache.connectAccessOrder(this.head.getPreviousInAccessQueue(), referenceEntry);
            LocalCache.connectAccessOrder(referenceEntry, this.head);
            return true;
        }

        @Override // java.util.Queue
        public ReferenceEntry peek() {
            ReferenceEntry nextInAccessQueue = this.head.getNextInAccessQueue();
            if (nextInAccessQueue == this.head) {
                return null;
            }
            return nextInAccessQueue;
        }

        @Override // java.util.Queue
        public ReferenceEntry poll() {
            ReferenceEntry nextInAccessQueue = this.head.getNextInAccessQueue();
            if (nextInAccessQueue == this.head) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry previousInAccessQueue = referenceEntry.getPreviousInAccessQueue();
            ReferenceEntry nextInAccessQueue = referenceEntry.getNextInAccessQueue();
            LocalCache.connectAccessOrder(previousInAccessQueue, nextInAccessQueue);
            LocalCache.nullifyAccessOrder(referenceEntry);
            return nextInAccessQueue != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInAccessQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.head.getNextInAccessQueue() == this.head;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i = 0;
            for (ReferenceEntry nextInAccessQueue = this.head.getNextInAccessQueue(); nextInAccessQueue != this.head; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i++;
            }
            return i;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry nextInAccessQueue = this.head.getNextInAccessQueue();
            while (true) {
                ReferenceEntry referenceEntry = this.head;
                if (nextInAccessQueue != referenceEntry) {
                    ReferenceEntry nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    LocalCache.nullifyAccessOrder(nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                } else {
                    referenceEntry.setNextInAccessQueue(referenceEntry);
                    ReferenceEntry referenceEntry2 = this.head;
                    referenceEntry2.setPreviousInAccessQueue(referenceEntry2);
                    return;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new AbstractSequentialIterator(peek()) { // from class: com.google.common.cache.LocalCache.AccessQueue.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractSequentialIterator
                public ReferenceEntry computeNext(ReferenceEntry referenceEntry) {
                    ReferenceEntry nextInAccessQueue = referenceEntry.getNextInAccessQueue();
                    if (nextInAccessQueue == AccessQueue.this.head) {
                        return null;
                    }
                    return nextInAccessQueue;
                }
            };
        }
    }

    public void cleanUp() {
        for (Segment segment : this.segments) {
            segment.cleanUp();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment[] segmentArr = this.segments;
        long j = 0;
        for (Segment segment : segmentArr) {
            if (segment.count != 0) {
                return false;
            }
            j += (long) segment.modCount;
        }
        if (j == 0) {
            return true;
        }
        for (Segment segment2 : segmentArr) {
            if (segment2.count != 0) {
                return false;
            }
            j -= (long) segment2.modCount;
        }
        return j == 0;
    }

    long longSize() {
        long jMax = 0;
        for (Segment segment : this.segments) {
            jMax += (long) Math.max(0, segment.count);
        }
        return jMax;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return Ints.saturatedCast(longSize());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).get(obj, iHash);
    }

    Object get(Object obj, CacheLoader cacheLoader) {
        int iHash = hash(Preconditions.checkNotNull(obj));
        return segmentFor(iHash).get(obj, iHash, cacheLoader);
    }

    public Object getIfPresent(Object obj) {
        int iHash = hash(Preconditions.checkNotNull(obj));
        Object obj2 = segmentFor(iHash).get(obj, iHash);
        if (obj2 == null) {
            this.globalStatsCounter.recordMisses(1);
        } else {
            this.globalStatsCounter.recordHits(1);
        }
        return obj2;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    Object getOrLoad(Object obj) {
        return get(obj, this.defaultLoader);
    }

    ImmutableMap getAllPresent(Iterable iterable) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int i = 0;
        int i2 = 0;
        for (Object obj : iterable) {
            Object obj2 = get(obj);
            if (obj2 == null) {
                i2++;
            } else {
                builder.put(obj, obj2);
                i++;
            }
        }
        this.globalStatsCounter.recordHits(i);
        this.globalStatsCounter.recordMisses(i2);
        return builder.buildKeepingLast();
    }

    ImmutableMap getAll(Iterable iterable) {
        LinkedHashMap linkedHashMapNewLinkedHashMap = Maps.newLinkedHashMap();
        LinkedHashSet linkedHashSetNewLinkedHashSet = Sets.newLinkedHashSet();
        int i = 0;
        int i2 = 0;
        for (Object obj : iterable) {
            Object obj2 = get(obj);
            if (!linkedHashMapNewLinkedHashMap.containsKey(obj)) {
                linkedHashMapNewLinkedHashMap.put(obj, obj2);
                if (obj2 == null) {
                    i2++;
                    linkedHashSetNewLinkedHashSet.add(obj);
                } else {
                    i++;
                }
            }
        }
        try {
            if (!linkedHashSetNewLinkedHashSet.isEmpty()) {
                try {
                    Map mapLoadAll = loadAll(Collections.unmodifiableSet(linkedHashSetNewLinkedHashSet), this.defaultLoader);
                    for (Object obj3 : linkedHashSetNewLinkedHashSet) {
                        Object obj4 = mapLoadAll.get(obj3);
                        if (obj4 == null) {
                            throw new CacheLoader.InvalidCacheLoadException("loadAll failed to return a value for " + obj3);
                        }
                        linkedHashMapNewLinkedHashMap.put(obj3, obj4);
                    }
                } catch (CacheLoader.UnsupportedLoadingOperationException unused) {
                    for (Object obj5 : linkedHashSetNewLinkedHashSet) {
                        i2--;
                        linkedHashMapNewLinkedHashMap.put(obj5, get(obj5, this.defaultLoader));
                    }
                }
            }
            ImmutableMap immutableMapCopyOf = ImmutableMap.copyOf((Map) linkedHashMapNewLinkedHashMap);
            this.globalStatsCounter.recordHits(i);
            this.globalStatsCounter.recordMisses(i2);
            return immutableMapCopyOf;
        } catch (Throwable th) {
            this.globalStatsCounter.recordHits(i);
            this.globalStatsCounter.recordMisses(i2);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00b9  */
    Map loadAll(Set set, CacheLoader cacheLoader) throws Throwable {
        Preconditions.checkNotNull(cacheLoader);
        Preconditions.checkNotNull(set);
        Stopwatch stopwatchCreateStarted = Stopwatch.createStarted();
        boolean z = true;
        boolean z2 = false;
        try {
            try {
                try {
                    Map mapLoadAll = cacheLoader.loadAll(set);
                    if (mapLoadAll == null) {
                        this.globalStatsCounter.recordLoadException(stopwatchCreateStarted.elapsed(TimeUnit.NANOSECONDS));
                        throw new CacheLoader.InvalidCacheLoadException(cacheLoader + " returned null map from loadAll");
                    }
                    stopwatchCreateStarted.stop();
                    for (Map.Entry entry : mapLoadAll.entrySet()) {
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        if (key == null || value == null) {
                            z2 = true;
                        } else {
                            put(key, value);
                        }
                    }
                    if (z2) {
                        this.globalStatsCounter.recordLoadException(stopwatchCreateStarted.elapsed(TimeUnit.NANOSECONDS));
                        throw new CacheLoader.InvalidCacheLoadException(cacheLoader + " returned null keys or values from loadAll");
                    }
                    this.globalStatsCounter.recordLoadSuccess(stopwatchCreateStarted.elapsed(TimeUnit.NANOSECONDS));
                    return mapLoadAll;
                } catch (Error e) {
                    throw new ExecutionError(e);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    throw new ExecutionException(e2);
                } catch (RuntimeException e3) {
                    throw new UncheckedExecutionException(e3);
                }
            } catch (CacheLoader.UnsupportedLoadingOperationException e4) {
                try {
                    throw e4;
                } catch (Throwable th) {
                    th = th;
                    if (!z) {
                        this.globalStatsCounter.recordLoadException(stopwatchCreateStarted.elapsed(TimeUnit.NANOSECONDS));
                    }
                    throw th;
                }
            } catch (Exception e5) {
                throw new ExecutionException(e5);
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
            if (!z) {
                this.globalStatsCounter.recordLoadException(stopwatchCreateStarted.elapsed(TimeUnit.NANOSECONDS));
            }
            throw th;
        }
    }

    void refresh(Object obj) {
        int iHash = hash(Preconditions.checkNotNull(obj));
        segmentFor(iHash).refresh(obj, iHash, this.defaultLoader, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).containsKey(obj, iHash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.util.concurrent.atomic.AtomicReferenceArray] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        long j = this.ticker.read();
        Segment[] segmentArr = this.segments;
        long j2 = -1;
        int i = 0;
        while (i < 3) {
            int length = segmentArr.length;
            long j3 = 0;
            for (?? r12 = z; r12 < length; r12++) {
                Segment segment = segmentArr[r12];
                int i2 = segment.count;
                ?? r14 = segment.table;
                for (?? r15 = z; r15 < r14.length(); r15++) {
                    ReferenceEntry next = (ReferenceEntry) r14.get(r15);
                    while (next != null) {
                        Segment[] segmentArr2 = segmentArr;
                        Object liveValue = segment.getLiveValue(next, j);
                        long j4 = j;
                        if (liveValue != null && this.valueEquivalence.equivalent(obj, liveValue)) {
                            return true;
                        }
                        next = next.getNext();
                        segmentArr = segmentArr2;
                        j = j4;
                    }
                }
                j3 += (long) segment.modCount;
                j = j;
                z = false;
            }
            long j5 = j;
            Segment[] segmentArr3 = segmentArr;
            if (j3 == j2) {
                return false;
            }
            i++;
            j2 = j3;
            segmentArr = segmentArr3;
            j = j5;
            z = false;
        }
        return z;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        int iHash = hash(obj);
        return segmentFor(iHash).put(obj, iHash, obj2, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object putIfAbsent(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        int iHash = hash(obj);
        return segmentFor(iHash).put(obj, iHash, obj2, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).remove(obj, iHash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).remove(obj, iHash, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(Object obj, Object obj2, Object obj3) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj3);
        if (obj2 == null) {
            return false;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).replace(obj, iHash, obj2, obj3);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object replace(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        int iHash = hash(obj);
        return segmentFor(iHash).replace(obj, iHash, obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment segment : this.segments) {
            segment.clear();
        }
    }

    void invalidateAll(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.keySet = keySet;
        return keySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.values = values;
        return values;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    abstract class HashIterator implements Iterator {
        Segment currentSegment;
        AtomicReferenceArray currentTable;
        WriteThroughEntry lastReturned;
        ReferenceEntry nextEntry;
        WriteThroughEntry nextExternal;
        int nextSegmentIndex;
        int nextTableIndex = -1;

        HashIterator() {
            this.nextSegmentIndex = LocalCache.this.segments.length - 1;
            advance();
        }

        final void advance() {
            this.nextExternal = null;
            if (nextInChain() || nextInTable()) {
                return;
            }
            while (true) {
                int i = this.nextSegmentIndex;
                if (i < 0) {
                    return;
                }
                Segment[] segmentArr = LocalCache.this.segments;
                this.nextSegmentIndex = i - 1;
                Segment segment = segmentArr[i];
                this.currentSegment = segment;
                if (segment.count != 0) {
                    AtomicReferenceArray atomicReferenceArray = this.currentSegment.table;
                    this.currentTable = atomicReferenceArray;
                    this.nextTableIndex = atomicReferenceArray.length() - 1;
                    if (nextInTable()) {
                        return;
                    }
                }
            }
        }

        boolean nextInChain() {
            ReferenceEntry referenceEntry = this.nextEntry;
            if (referenceEntry == null) {
                return false;
            }
            while (true) {
                this.nextEntry = referenceEntry.getNext();
                ReferenceEntry referenceEntry2 = this.nextEntry;
                if (referenceEntry2 == null) {
                    return false;
                }
                if (advanceTo(referenceEntry2)) {
                    return true;
                }
                referenceEntry = this.nextEntry;
            }
        }

        boolean nextInTable() {
            while (true) {
                int i = this.nextTableIndex;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray atomicReferenceArray = this.currentTable;
                this.nextTableIndex = i - 1;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i);
                this.nextEntry = referenceEntry;
                if (referenceEntry != null && (advanceTo(referenceEntry) || nextInChain())) {
                    return true;
                }
            }
        }

        boolean advanceTo(ReferenceEntry referenceEntry) {
            Segment segment;
            try {
                long j = LocalCache.this.ticker.read();
                Object key = referenceEntry.getKey();
                Object liveValue = LocalCache.this.getLiveValue(referenceEntry, j);
                if (liveValue == null) {
                    return false;
                }
                this.nextExternal = LocalCache.this.new WriteThroughEntry(key, liveValue);
                return true;
            } finally {
                this.currentSegment.postReadCleanup();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextExternal != null;
        }

        WriteThroughEntry nextEntry() {
            WriteThroughEntry writeThroughEntry = this.nextExternal;
            if (writeThroughEntry == null) {
                throw new NoSuchElementException();
            }
            this.lastReturned = writeThroughEntry;
            advance();
            return this.lastReturned;
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.checkState(this.lastReturned != null);
            LocalCache.this.remove(this.lastReturned.getKey());
            this.lastReturned = null;
        }
    }

    final class KeyIterator extends HashIterator {
        KeyIterator(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return nextEntry().getKey();
        }
    }

    final class ValueIterator extends HashIterator {
        ValueIterator(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return nextEntry().getValue();
        }
    }

    final class WriteThroughEntry implements Map.Entry {
        final Object key;
        Object value;

        WriteThroughEntry(Object obj, Object obj2) {
            this.key = obj;
            this.value = obj2;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.key.equals(entry.getKey()) && this.value.equals(entry.getValue());
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.value.hashCode() ^ this.key.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object objPut = LocalCache.this.put(this.key, obj);
            this.value = obj;
            return objPut;
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class EntryIterator extends HashIterator {
        EntryIterator(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry next() {
            return nextEntry();
        }
    }

    abstract class AbstractCacheSet extends AbstractSet {
        AbstractCacheSet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LocalCache.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LocalCache.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return LocalCache.toArrayList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray(Object[] objArr) {
            return LocalCache.toArrayList(this).toArray(objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList toArrayList(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterators.addAll(arrayList, collection.iterator());
        return arrayList;
    }

    final class KeySet extends AbstractCacheSet {
        KeySet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new KeyIterator(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LocalCache.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LocalCache.this.remove(obj) != null;
        }
    }

    final class Values extends AbstractCollection {
        Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return LocalCache.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            LocalCache.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new ValueIterator(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return LocalCache.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return LocalCache.toArrayList(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return LocalCache.toArrayList(this).toArray(objArr);
        }
    }

    final class EntrySet extends AbstractCacheSet {
        EntrySet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new EntryIterator(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = LocalCache.this.get(key)) != null && LocalCache.this.valueEquivalence.equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && LocalCache.this.remove(key, entry.getValue());
        }
    }

    static class ManualSerializationProxy extends ForwardingCache implements Serializable {
        private static final long serialVersionUID = 1;
        final int concurrencyLevel;
        transient Cache delegate;
        final long expireAfterAccessNanos;
        final long expireAfterWriteNanos;
        final Equivalence keyEquivalence;
        final Strength keyStrength;
        final CacheLoader loader;
        final long maxWeight;
        final RemovalListener removalListener;
        final Ticker ticker;
        final Equivalence valueEquivalence;
        final Strength valueStrength;
        final Weigher weigher;

        ManualSerializationProxy(LocalCache localCache) {
            this(localCache.keyStrength, localCache.valueStrength, localCache.keyEquivalence, localCache.valueEquivalence, localCache.expireAfterWriteNanos, localCache.expireAfterAccessNanos, localCache.maxWeight, localCache.weigher, localCache.concurrencyLevel, localCache.removalListener, localCache.ticker, localCache.defaultLoader);
        }

        private ManualSerializationProxy(Strength strength, Strength strength2, Equivalence equivalence, Equivalence equivalence2, long j, long j2, long j3, Weigher weigher, int i, RemovalListener removalListener, Ticker ticker, CacheLoader cacheLoader) {
            Ticker ticker2 = ticker;
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = j;
            this.expireAfterAccessNanos = j2;
            this.maxWeight = j3;
            this.weigher = weigher;
            this.concurrencyLevel = i;
            this.removalListener = removalListener;
            this.ticker = (ticker2 == Ticker.systemTicker() || ticker2 == CacheBuilder.NULL_TICKER) ? null : ticker2;
            this.loader = cacheLoader;
        }

        CacheBuilder recreateCacheBuilder() {
            CacheBuilder cacheBuilderRemovalListener = CacheBuilder.newBuilder().setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence(this.keyEquivalence).valueEquivalence(this.valueEquivalence).concurrencyLevel(this.concurrencyLevel).removalListener(this.removalListener);
            cacheBuilderRemovalListener.strictParsing = false;
            long j = this.expireAfterWriteNanos;
            if (j > 0) {
                cacheBuilderRemovalListener.expireAfterWrite(j, TimeUnit.NANOSECONDS);
            }
            long j2 = this.expireAfterAccessNanos;
            if (j2 > 0) {
                cacheBuilderRemovalListener.expireAfterAccess(j2, TimeUnit.NANOSECONDS);
            }
            Weigher weigher = this.weigher;
            if (weigher != CacheBuilder.OneWeigher.INSTANCE) {
                cacheBuilderRemovalListener.weigher(weigher);
                long j3 = this.maxWeight;
                if (j3 != -1) {
                    cacheBuilderRemovalListener.maximumWeight(j3);
                }
            } else {
                long j4 = this.maxWeight;
                if (j4 != -1) {
                    cacheBuilderRemovalListener.maximumSize(j4);
                }
            }
            Ticker ticker = this.ticker;
            if (ticker != null) {
                cacheBuilderRemovalListener.ticker(ticker);
            }
            return cacheBuilderRemovalListener;
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.delegate = recreateCacheBuilder().build();
        }

        private Object readResolve() {
            return this.delegate;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        public Cache delegate() {
            return this.delegate;
        }
    }

    static final class LoadingSerializationProxy extends ManualSerializationProxy implements LoadingCache, Serializable {
        private static final long serialVersionUID = 1;
        transient LoadingCache autoDelegate;

        LoadingSerializationProxy(LocalCache localCache) {
            super(localCache);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.autoDelegate = recreateCacheBuilder().build(this.loader);
        }

        @Override // com.google.common.cache.LoadingCache
        public Object get(Object obj) {
            return this.autoDelegate.get(obj);
        }

        @Override // com.google.common.cache.LoadingCache
        public Object getUnchecked(Object obj) {
            return this.autoDelegate.getUnchecked(obj);
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap getAll(Iterable iterable) {
            return this.autoDelegate.getAll(iterable);
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public Object apply(Object obj) {
            return this.autoDelegate.apply(obj);
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(Object obj) {
            this.autoDelegate.refresh(obj);
        }

        private Object readResolve() {
            return this.autoDelegate;
        }
    }

    static class LocalManualCache implements Cache, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache localCache;

        LocalManualCache(CacheBuilder cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
        }

        private LocalManualCache(LocalCache localCache) {
            this.localCache = localCache;
        }

        @Override // com.google.common.cache.Cache
        public Object getIfPresent(Object obj) {
            return this.localCache.getIfPresent(obj);
        }

        @Override // com.google.common.cache.Cache
        public Object get(Object obj, final Callable callable) {
            Preconditions.checkNotNull(callable);
            return this.localCache.get(obj, new CacheLoader(this) { // from class: com.google.common.cache.LocalCache.LocalManualCache.1
                @Override // com.google.common.cache.CacheLoader
                public Object load(Object obj2) {
                    return callable.call();
                }
            });
        }

        @Override // com.google.common.cache.Cache
        public ImmutableMap getAllPresent(Iterable iterable) {
            return this.localCache.getAllPresent(iterable);
        }

        @Override // com.google.common.cache.Cache
        public void put(Object obj, Object obj2) {
            this.localCache.put(obj, obj2);
        }

        @Override // com.google.common.cache.Cache
        public void putAll(Map map) {
            this.localCache.putAll(map);
        }

        @Override // com.google.common.cache.Cache
        public void invalidate(Object obj) {
            Preconditions.checkNotNull(obj);
            this.localCache.remove(obj);
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll(Iterable iterable) {
            this.localCache.invalidateAll(iterable);
        }

        @Override // com.google.common.cache.Cache
        public void invalidateAll() {
            this.localCache.clear();
        }

        @Override // com.google.common.cache.Cache
        public long size() {
            return this.localCache.longSize();
        }

        @Override // com.google.common.cache.Cache
        public ConcurrentMap asMap() {
            return this.localCache;
        }

        @Override // com.google.common.cache.Cache
        public CacheStats stats() {
            AbstractCache.SimpleStatsCounter simpleStatsCounter = new AbstractCache.SimpleStatsCounter();
            simpleStatsCounter.incrementBy(this.localCache.globalStatsCounter);
            for (Segment segment : this.localCache.segments) {
                simpleStatsCounter.incrementBy(segment.statsCounter);
            }
            return simpleStatsCounter.snapshot();
        }

        @Override // com.google.common.cache.Cache
        public void cleanUp() {
            this.localCache.cleanUp();
        }

        Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use ManualSerializationProxy");
        }
    }

    static class LocalLoadingCache extends LocalManualCache implements LoadingCache {
        private static final long serialVersionUID = 1;

        LocalLoadingCache(CacheBuilder cacheBuilder, CacheLoader cacheLoader) {
            super();
        }

        @Override // com.google.common.cache.LoadingCache
        public Object get(Object obj) {
            return this.localCache.getOrLoad(obj);
        }

        @Override // com.google.common.cache.LoadingCache
        public Object getUnchecked(Object obj) {
            try {
                return get(obj);
            } catch (ExecutionException e) {
                throw new UncheckedExecutionException(e.getCause());
            }
        }

        @Override // com.google.common.cache.LoadingCache
        public ImmutableMap getAll(Iterable iterable) {
            return this.localCache.getAll(iterable);
        }

        @Override // com.google.common.cache.LoadingCache
        public void refresh(Object obj) {
            this.localCache.refresh(obj);
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final Object apply(Object obj) {
            return getUnchecked(obj);
        }

        @Override // com.google.common.cache.LocalCache.LocalManualCache
        Object writeReplace() {
            return new LoadingSerializationProxy(this.localCache);
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use LoadingSerializationProxy");
        }
    }
}
