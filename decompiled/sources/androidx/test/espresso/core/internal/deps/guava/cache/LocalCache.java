package androidx.test.espresso.core.internal.deps.guava.cache;

import androidx.test.espresso.core.internal.deps.guava.base.Equivalence;
import androidx.test.espresso.core.internal.deps.guava.base.Function;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Stopwatch;
import androidx.test.espresso.core.internal.deps.guava.base.Ticker;
import androidx.test.espresso.core.internal.deps.guava.cache.CacheBuilder;
import androidx.test.espresso.core.internal.deps.guava.cache.CacheLoader;
import androidx.test.espresso.core.internal.deps.guava.collect.AbstractSequentialIterator;
import androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterators;
import androidx.test.espresso.core.internal.deps.guava.primitives.Ints;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.Futures;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListenableFuture;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.MoreExecutors;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.SettableFuture;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.Uninterruptibles;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.IOException;
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
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    final int concurrencyLevel;
    final CacheLoader defaultLoader;
    final EntryFactory entryFactory;
    Set entrySet;
    final long expireAfterAccessNanos;
    final long expireAfterWriteNanos;
    final AbstractCache$StatsCounter globalStatsCounter;
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
    static final ValueReference UNSET = new ValueReference<Object, Object>() { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.1
        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ValueReference copyFor(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return this;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public Object get() {
            return null;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ReferenceEntry getEntry() {
            return null;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public int getWeight() {
            return 0;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public boolean isActive() {
            return false;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public void notifyNewValue(Object obj) {
        }
    };
    static final Queue DISCARDING_QUEUE = new AbstractQueue<Object>() { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.2
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return ImmutableSet.of().iterator();
        }

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
    };

    abstract class AbstractCacheSet<T> extends AbstractSet<T> {
        AbstractCacheSet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LocalCache.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LocalCache.this.size();
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

    static abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
        AbstractReferenceEntry() {
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public int getHash() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public Object getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getNext() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ValueReference getValueReference() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setValueReference(ValueReference valueReference) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }
    }

    static final class AccessQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry head = new AbstractReferenceEntry<K, V>(this) { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AccessQueue.1
            ReferenceEntry nextAccess = this;
            ReferenceEntry previousAccess = this;

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public long getAccessTime() {
                return Long.MAX_VALUE;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public ReferenceEntry getNextInAccessQueue() {
                return this.nextAccess;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public ReferenceEntry getPreviousInAccessQueue() {
                return this.previousAccess;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public void setAccessTime(long j) {
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public void setNextInAccessQueue(ReferenceEntry referenceEntry) {
                this.nextAccess = referenceEntry;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public void setPreviousInAccessQueue(ReferenceEntry referenceEntry) {
                this.previousAccess = referenceEntry;
            }
        };

        AccessQueue() {
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry nextInAccessQueue = this.head.getNextInAccessQueue();
            while (true) {
                ReferenceEntry referenceEntry = this.head;
                if (nextInAccessQueue == referenceEntry) {
                    referenceEntry.setNextInAccessQueue(referenceEntry);
                    ReferenceEntry referenceEntry2 = this.head;
                    referenceEntry2.setPreviousInAccessQueue(referenceEntry2);
                    return;
                } else {
                    ReferenceEntry nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    LocalCache.nullifyAccessOrder(nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInAccessQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.head.getNextInAccessQueue() == this.head;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AccessQueue.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // androidx.test.espresso.core.internal.deps.guava.collect.AbstractSequentialIterator
                public ReferenceEntry computeNext(ReferenceEntry referenceEntry) {
                    ReferenceEntry nextInAccessQueue = referenceEntry.getNextInAccessQueue();
                    if (nextInAccessQueue == AccessQueue.this.head) {
                        return null;
                    }
                    return nextInAccessQueue;
                }
            };
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
        public int size() {
            int i = 0;
            for (ReferenceEntry nextInAccessQueue = this.head.getNextInAccessQueue(); nextInAccessQueue != this.head; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i++;
            }
            return i;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$EntryFactory, still in use, count: 1, list:
  (r0v0 androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$EntryFactory) from 0x0058: FILLED_NEW_ARRAY 
  (r0v0 androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$EntryFactory)
  (r1v1 androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$EntryFactory)
  (r3v1 androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$EntryFactory)
  (r5v1 androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$EntryFactory)
  (r7v1 androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$EntryFactory)
  (r9v1 androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$EntryFactory)
  (r11v1 androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$EntryFactory)
  (r13v1 androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$EntryFactory)
 A[WRAPPED] (LINE:10) elemType: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$EntryFactory
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    static abstract class EntryFactory {
        STRONG { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.1
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new StrongEntry(obj, i, referenceEntry);
            }
        },
        STRONG_ACCESS { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.2
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new StrongAccessEntry(obj, i, referenceEntry);
            }
        },
        STRONG_WRITE { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.3
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new StrongWriteEntry(obj, i, referenceEntry);
            }
        },
        STRONG_ACCESS_WRITE { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.4
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new StrongAccessWriteEntry(obj, i, referenceEntry);
            }
        },
        WEAK { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.5
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new WeakEntry(segment.keyReferenceQueue, obj, i, referenceEntry);
            }
        },
        WEAK_ACCESS { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.6
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new WeakAccessEntry(segment.keyReferenceQueue, obj, i, referenceEntry);
            }
        },
        WEAK_WRITE { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.7
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new WeakWriteEntry(segment.keyReferenceQueue, obj, i, referenceEntry);
            }
        },
        WEAK_ACCESS_WRITE { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.8
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new WeakAccessWriteEntry(segment.keyReferenceQueue, obj, i, referenceEntry);
            }
        };

        static final EntryFactory[] factories = {new EntryFactory() { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.1
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new StrongEntry(obj, i, referenceEntry);
            }
        }, new EntryFactory() { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.2
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new StrongAccessEntry(obj, i, referenceEntry);
            }
        }, new EntryFactory() { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.3
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new StrongWriteEntry(obj, i, referenceEntry);
            }
        }, new EntryFactory() { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.4
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new StrongAccessWriteEntry(obj, i, referenceEntry);
            }
        }, new EntryFactory() { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.5
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new WeakEntry(segment.keyReferenceQueue, obj, i, referenceEntry);
            }
        }, new EntryFactory() { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.6
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new WeakAccessEntry(segment.keyReferenceQueue, obj, i, referenceEntry);
            }
        }, new EntryFactory() { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.7
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new WeakWriteEntry(segment.keyReferenceQueue, obj, i, referenceEntry);
            }
        }, new EntryFactory() { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory.8
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
                ReferenceEntry referenceEntryCopyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, referenceEntryCopyEntry);
                copyWriteEntry(referenceEntry, referenceEntryCopyEntry);
                return referenceEntryCopyEntry;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntryFactory
            ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry) {
                return new WeakAccessWriteEntry(segment.keyReferenceQueue, obj, i, referenceEntry);
            }
        }};

        static {
        }

        private EntryFactory() {
        }

        static EntryFactory getFactory(Strength strength, boolean z, boolean z2) {
            return factories[(strength == Strength.WEAK ? 4 : 0) | (z ? 1 : 0) | (z2 ? 2 : 0)];
        }

        public static EntryFactory[] values() {
            return (EntryFactory[]) $VALUES.clone();
        }

        void copyAccessEntry(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
            referenceEntry2.setAccessTime(referenceEntry.getAccessTime());
            LocalCache.connectAccessOrder(referenceEntry.getPreviousInAccessQueue(), referenceEntry2);
            LocalCache.connectAccessOrder(referenceEntry2, referenceEntry.getNextInAccessQueue());
            LocalCache.nullifyAccessOrder(referenceEntry);
        }

        ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
            return newEntry(segment, referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry2);
        }

        void copyWriteEntry(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
            referenceEntry2.setWriteTime(referenceEntry.getWriteTime());
            LocalCache.connectWriteOrder(referenceEntry.getPreviousInWriteQueue(), referenceEntry2);
            LocalCache.connectWriteOrder(referenceEntry2, referenceEntry.getNextInWriteQueue());
            LocalCache.nullifyWriteOrder(referenceEntry);
        }

        abstract ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceEntry);
    }

    final class EntryIterator extends LocalCache<K, V>.HashIterator<Map.Entry<K, V>> {
        EntryIterator(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry next() {
            return nextEntry();
        }
    }

    final class EntrySet extends LocalCache<K, V>.AbstractCacheSet<Map.Entry<K, V>> {
        EntrySet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = LocalCache.this.get(key)) != null && LocalCache.this.valueEquivalence.equivalent(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new EntryIterator(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && LocalCache.this.remove(key, entry.getValue());
        }
    }

    abstract class HashIterator<T> implements Iterator<T> {
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
                    this.currentTable = this.currentSegment.table;
                    this.nextTableIndex = r0.length() - 1;
                    if (nextInTable()) {
                        return;
                    }
                }
            }
        }

        boolean advanceTo(ReferenceEntry referenceEntry) {
            try {
                long j = LocalCache.this.ticker.read();
                Object key = referenceEntry.getKey();
                Object liveValue = LocalCache.this.getLiveValue(referenceEntry, j);
                if (liveValue == null) {
                    this.currentSegment.postReadCleanup();
                    return false;
                }
                this.nextExternal = new WriteThroughEntry(key, liveValue);
                this.currentSegment.postReadCleanup();
                return true;
            } catch (Throwable th) {
                this.currentSegment.postReadCleanup();
                throw th;
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

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.checkState(this.lastReturned != null);
            LocalCache.this.remove(this.lastReturned.getKey());
            this.lastReturned = null;
        }
    }

    final class KeyIterator extends LocalCache<K, V>.HashIterator<K> {
        KeyIterator(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return nextEntry().getKey();
        }
    }

    final class KeySet extends LocalCache<K, V>.AbstractCacheSet<K> {
        KeySet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LocalCache.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new KeyIterator(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LocalCache.this.remove(obj) != null;
        }
    }

    static class LoadingValueReference<K, V> implements ValueReference<K, V> {
        final SettableFuture futureValue;
        volatile ValueReference oldValue;
        final Stopwatch stopwatch;

        public LoadingValueReference() {
            this(LocalCache.unset());
        }

        private ListenableFuture fullyFailedFuture(Throwable th) {
            return Futures.immediateFailedFuture(th);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ValueReference copyFor(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return this;
        }

        public long elapsedNanos() {
            return this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public Object get() {
            return this.oldValue.get();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ReferenceEntry getEntry() {
            return null;
        }

        public ValueReference getOldValue() {
            return this.oldValue;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.oldValue.getWeight();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public boolean isActive() {
            return this.oldValue.isActive();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ListenableFuture loadFuture(Object obj, CacheLoader cacheLoader) {
            try {
                this.stopwatch.start();
                Object obj2 = this.oldValue.get();
                if (obj2 == null) {
                    Object objLoad = cacheLoader.load(obj);
                    return set(objLoad) ? this.futureValue : Futures.immediateFuture(objLoad);
                }
                ListenableFuture listenableFutureReload = cacheLoader.reload(obj, obj2);
                return listenableFutureReload == null ? Futures.immediateFuture(null) : Futures.transform(listenableFutureReload, new Function<V, V>() { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.LoadingValueReference.1
                    @Override // androidx.test.espresso.core.internal.deps.guava.base.Function
                    public Object apply(Object obj3) {
                        LoadingValueReference.this.set(obj3);
                        return obj3;
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

        public boolean set(Object obj) {
            return this.futureValue.set(obj);
        }

        public boolean setException(Throwable th) {
            return this.futureValue.setException(th);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public void notifyNewValue(Object obj) {
            if (obj != null) {
                set(obj);
            } else {
                this.oldValue = LocalCache.unset();
            }
        }

        public LoadingValueReference(ValueReference valueReference) {
            this.futureValue = SettableFuture.create();
            this.stopwatch = Stopwatch.createUnstarted();
            this.oldValue = valueReference;
        }
    }

    private enum NullEntry implements ReferenceEntry<Object, Object> {
        INSTANCE;

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getAccessTime() {
            return 0L;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public int getHash() {
            return 0;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public Object getKey() {
            return null;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getNext() {
            return null;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getNextInAccessQueue() {
            return this;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getNextInWriteQueue() {
            return this;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getPreviousInAccessQueue() {
            return this;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getPreviousInWriteQueue() {
            return this;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ValueReference getValueReference() {
            return null;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getWriteTime() {
            return 0L;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setAccessTime(long j) {
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry referenceEntry) {
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry referenceEntry) {
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry referenceEntry) {
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry referenceEntry) {
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setValueReference(ValueReference valueReference) {
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setWriteTime(long j) {
        }
    }

    static class Segment<K, V> extends ReentrantLock {
        final Queue accessQueue;
        volatile int count;
        final ReferenceQueue keyReferenceQueue;
        final LocalCache map;
        final long maxSegmentWeight;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue recencyQueue;
        final AbstractCache$StatsCounter statsCounter;
        volatile AtomicReferenceArray table;
        int threshold;
        long totalWeight;
        final ReferenceQueue valueReferenceQueue;
        final Queue writeQueue;

        Segment(LocalCache localCache, int i, long j, AbstractCache$StatsCounter abstractCache$StatsCounter) {
            this.map = localCache;
            this.maxSegmentWeight = j;
            this.statsCounter = (AbstractCache$StatsCounter) Preconditions.checkNotNull(abstractCache$StatsCounter);
            initTable(newEntryArray(i));
            this.keyReferenceQueue = localCache.usesKeyReferences() ? new ReferenceQueue() : null;
            this.valueReferenceQueue = localCache.usesValueReferences() ? new ReferenceQueue() : null;
            this.recencyQueue = localCache.usesAccessQueue() ? new ConcurrentLinkedQueue() : LocalCache.discardingQueue();
            this.writeQueue = localCache.usesWriteQueue() ? new WriteQueue() : LocalCache.discardingQueue();
            this.accessQueue = localCache.usesAccessQueue() ? new AccessQueue() : LocalCache.discardingQueue();
        }

        void cleanUp() {
            runLockedCleanup(this.map.ticker.read());
            runUnlockedCleanup();
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
                    unlock();
                    postWriteCleanup();
                } catch (Throwable th) {
                    unlock();
                    postWriteCleanup();
                    throw th;
                }
            }
        }

        void clearKeyReferenceQueue() {
            while (this.keyReferenceQueue.poll() != null) {
            }
        }

        void clearReferenceQueues() {
            if (this.map.usesKeyReferences()) {
                clearKeyReferenceQueue();
            }
            if (this.map.usesValueReferences()) {
                clearValueReferenceQueue();
            }
        }

        void clearValueReferenceQueue() {
            while (this.valueReferenceQueue.poll() != null) {
            }
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

        ReferenceEntry copyEntry(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
            if (referenceEntry.getKey() == null) {
                return null;
            }
            ValueReference valueReference = referenceEntry.getValueReference();
            Object obj = valueReference.get();
            if (obj == null && valueReference.isActive()) {
                return null;
            }
            ReferenceEntry referenceEntryCopyEntry = this.map.entryFactory.copyEntry(this, referenceEntry, referenceEntry2);
            referenceEntryCopyEntry.setValueReference(valueReference.copyFor(this.valueReferenceQueue, obj, referenceEntryCopyEntry));
            return referenceEntryCopyEntry;
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

        void drainReferenceQueues() {
            if (this.map.usesKeyReferences()) {
                drainKeyReferenceQueue();
            }
            if (this.map.usesValueReferences()) {
                drainValueReferenceQueue();
            }
        }

        void enqueueNotification(Object obj, int i, Object obj2, int i2, RemovalCause removalCause) {
            this.totalWeight -= i2;
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

        void expand() {
            AtomicReferenceArray atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i = this.count;
            AtomicReferenceArray atomicReferenceArrayNewEntryArray = newEntryArray(length + length);
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

        ReferenceEntry getFirst(int i) {
            return (ReferenceEntry) this.table.get(i & (r1.length() - 1));
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

        ReferenceEntry getNextEvictable() {
            for (ReferenceEntry referenceEntry : this.accessQueue) {
                if (referenceEntry.getValueReference().getWeight() > 0) {
                    return referenceEntry;
                }
            }
            throw new AssertionError();
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

        ListenableFuture loadAsync(final Object obj, final int i, final LoadingValueReference loadingValueReference, CacheLoader cacheLoader) {
            final ListenableFuture listenableFutureLoadFuture = loadingValueReference.loadFuture(obj, cacheLoader);
            listenableFutureLoadFuture.addListener(new Runnable() { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Segment.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Segment.this.getAndRecordStats(obj, i, loadingValueReference, listenableFutureLoadFuture);
                    } catch (Throwable th) {
                        LocalCache.logger.logp(Level.WARNING, "androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$Segment$1", "run", "Exception thrown during refresh", th);
                        loadingValueReference.setException(th);
                    }
                }
            }, MoreExecutors.directExecutor());
            return listenableFutureLoadFuture;
        }

        ReferenceEntry newEntry(Object obj, int i, ReferenceEntry referenceEntry) {
            return this.map.entryFactory.newEntry(this, Preconditions.checkNotNull(obj), i, referenceEntry);
        }

        AtomicReferenceArray newEntryArray(int i) {
            return new AtomicReferenceArray(i);
        }

        void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        void postWriteCleanup() {
            runUnlockedCleanup();
        }

        void preWriteCleanup(long j) {
            runLockedCleanup(j);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x008d, code lost:
        
            unlock();
            postWriteCleanup();
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0093, code lost:
        
            return null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        java.lang.Object put(java.lang.Object r15, int r16, java.lang.Object r17, boolean r18) {
            /*
                Method dump skipped, instructions count: 238
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Segment.put(java.lang.Object, int, java.lang.Object, boolean):java.lang.Object");
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
                unlock();
                postWriteCleanup();
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
                            unlock();
                            if (!isHeldByCurrentThread()) {
                                postWriteCleanup();
                            }
                            return false;
                        }
                        this.modCount++;
                        ReferenceEntry referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry, next, key, i, valueReference.get(), valueReference, RemovalCause.COLLECTED);
                        int i2 = this.count - 1;
                        atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                        this.count = i2;
                        unlock();
                        if (!isHeldByCurrentThread()) {
                            postWriteCleanup();
                        }
                        return true;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
                return false;
            } catch (Throwable th) {
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
                throw th;
            }
        }

        void recordLockedRead(ReferenceEntry referenceEntry, long j) {
            if (this.map.recordsAccess()) {
                referenceEntry.setAccessTime(j);
            }
            this.accessQueue.add(referenceEntry);
        }

        void recordRead(ReferenceEntry referenceEntry, long j) {
            if (this.map.recordsAccess()) {
                referenceEntry.setAccessTime(j);
            }
            this.recencyQueue.add(referenceEntry);
        }

        void recordWrite(ReferenceEntry referenceEntry, int i, long j) {
            drainRecencyQueue();
            this.totalWeight += i;
            if (this.map.recordsAccess()) {
                referenceEntry.setAccessTime(j);
            }
            if (this.map.recordsWrite()) {
                referenceEntry.setWriteTime(j);
            }
            this.accessQueue.add(referenceEntry);
            this.writeQueue.add(referenceEntry);
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        
            r9 = r5.getValueReference();
            r12 = r9.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
        
            if (r12 == null) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
        
            r2 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
        
            r10 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
        
            if (r9.isActive() == false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:
        
            r2 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.COLLECTED;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        
            r11.modCount++;
            r13 = removeValueFromChain(r4, r5, r6, r13, r12, r9, r10);
            r2 = r11.count - 1;
            r0.set(r1, r13);
            r11.count = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0067, code lost:
        
            unlock();
            postWriteCleanup();
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
        
            return r12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        java.lang.Object remove(java.lang.Object r12, int r13) {
            /*
                r11 = this;
                r11.lock()
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache r0 = r11.map     // Catch: java.lang.Throwable -> L46
                androidx.test.espresso.core.internal.deps.guava.base.Ticker r0 = r0.ticker     // Catch: java.lang.Throwable -> L46
                long r0 = r0.read()     // Catch: java.lang.Throwable -> L46
                r11.preWriteCleanup(r0)     // Catch: java.lang.Throwable -> L46
                java.util.concurrent.atomic.AtomicReferenceArray r0 = r11.table     // Catch: java.lang.Throwable -> L46
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L46
                int r1 = r1 + (-1)
                r1 = r1 & r13
                java.lang.Object r2 = r0.get(r1)     // Catch: java.lang.Throwable -> L46
                r4 = r2
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r4 = (androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry) r4     // Catch: java.lang.Throwable -> L46
                r5 = r4
            L1f:
                r2 = 0
                if (r5 == 0) goto L6e
                java.lang.Object r6 = r5.getKey()     // Catch: java.lang.Throwable -> L46
                int r3 = r5.getHash()     // Catch: java.lang.Throwable -> L46
                if (r3 != r13) goto L75
                if (r6 == 0) goto L75
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache r3 = r11.map     // Catch: java.lang.Throwable -> L46
                androidx.test.espresso.core.internal.deps.guava.base.Equivalence r3 = r3.keyEquivalence     // Catch: java.lang.Throwable -> L46
                boolean r3 = r3.equivalent(r12, r6)     // Catch: java.lang.Throwable -> L46
                if (r3 == 0) goto L75
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$ValueReference r9 = r5.getValueReference()     // Catch: java.lang.Throwable -> L46
                java.lang.Object r12 = r9.get()     // Catch: java.lang.Throwable -> L46
                if (r12 == 0) goto L48
                androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause r2 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L46
            L44:
                r10 = r2
                goto L51
            L46:
                r12 = move-exception
                goto L7a
            L48:
                boolean r3 = r9.isActive()     // Catch: java.lang.Throwable -> L46
                if (r3 == 0) goto L6e
                androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause r2 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L46
                goto L44
            L51:
                int r2 = r11.modCount     // Catch: java.lang.Throwable -> L46
                int r2 = r2 + 1
                r11.modCount = r2     // Catch: java.lang.Throwable -> L46
                r3 = r11
                r7 = r13
                r8 = r12
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r13 = r3.removeValueFromChain(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L46
                int r2 = r11.count     // Catch: java.lang.Throwable -> L46
                int r2 = r2 + (-1)
                r0.set(r1, r13)     // Catch: java.lang.Throwable -> L46
                r11.count = r2     // Catch: java.lang.Throwable -> L46
                r11.unlock()
                r11.postWriteCleanup()
                return r12
            L6e:
                r11.unlock()
                r11.postWriteCleanup()
                return r2
            L75:
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r5 = r5.getNext()     // Catch: java.lang.Throwable -> L46
                goto L1f
            L7a:
                r11.unlock()
                r11.postWriteCleanup()
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Segment.remove(java.lang.Object, int):java.lang.Object");
        }

        ReferenceEntry removeEntryFromChain(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
            int i = this.count;
            ReferenceEntry next = referenceEntry2.getNext();
            while (referenceEntry != referenceEntry2) {
                ReferenceEntry referenceEntryCopyEntry = copyEntry(referenceEntry, next);
                if (referenceEntryCopyEntry == null) {
                    removeCollectedEntry(referenceEntry);
                    i--;
                } else {
                    next = referenceEntryCopyEntry;
                }
                referenceEntry = referenceEntry.getNext();
            }
            this.count = i;
            return next;
        }

        boolean removeLoadingValue(Object obj, int i, LoadingValueReference loadingValueReference) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                ReferenceEntry next = referenceEntry;
                while (true) {
                    if (next == null) {
                        break;
                    }
                    Object key = next.getKey();
                    if (next.getHash() != i || key == null || !this.map.keyEquivalence.equivalent(obj, key)) {
                        next = next.getNext();
                    } else if (next.getValueReference() == loadingValueReference) {
                        if (loadingValueReference.isActive()) {
                            next.setValueReference(loadingValueReference.getOldValue());
                        } else {
                            atomicReferenceArray.set(length, removeEntryFromChain(referenceEntry, next));
                        }
                        unlock();
                        postWriteCleanup();
                        return true;
                    }
                }
                unlock();
                postWriteCleanup();
                return false;
            } catch (Throwable th) {
                unlock();
                postWriteCleanup();
                throw th;
            }
        }

        ReferenceEntry removeValueFromChain(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj, int i, Object obj2, ValueReference valueReference, RemovalCause removalCause) {
            enqueueNotification(obj, i, obj2, valueReference.getWeight(), removalCause);
            this.writeQueue.remove(referenceEntry2);
            this.accessQueue.remove(referenceEntry2);
            if (!valueReference.isLoading()) {
                return removeEntryFromChain(referenceEntry, referenceEntry2);
            }
            valueReference.notifyNewValue(null);
            return referenceEntry;
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0075, code lost:
        
            return null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        java.lang.Object replace(java.lang.Object r18, int r19, java.lang.Object r20) {
            /*
                r17 = this;
                r9 = r17
                r0 = r19
                r17.lock()
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache r1 = r9.map     // Catch: java.lang.Throwable -> L6d
                androidx.test.espresso.core.internal.deps.guava.base.Ticker r1 = r1.ticker     // Catch: java.lang.Throwable -> L6d
                long r7 = r1.read()     // Catch: java.lang.Throwable -> L6d
                r9.preWriteCleanup(r7)     // Catch: java.lang.Throwable -> L6d
                java.util.concurrent.atomic.AtomicReferenceArray r10 = r9.table     // Catch: java.lang.Throwable -> L6d
                int r1 = r10.length()     // Catch: java.lang.Throwable -> L6d
                int r1 = r1 + (-1)
                r11 = r0 & r1
                java.lang.Object r1 = r10.get(r11)     // Catch: java.lang.Throwable -> L6d
                r2 = r1
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r2 = (androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry) r2     // Catch: java.lang.Throwable -> L6d
                r12 = r2
            L24:
                r13 = 0
                if (r12 == 0) goto L6f
                java.lang.Object r4 = r12.getKey()     // Catch: java.lang.Throwable -> L6d
                int r1 = r12.getHash()     // Catch: java.lang.Throwable -> L6d
                if (r1 != r0) goto La2
                if (r4 == 0) goto La2
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache r1 = r9.map     // Catch: java.lang.Throwable -> L6d
                androidx.test.espresso.core.internal.deps.guava.base.Equivalence r1 = r1.keyEquivalence     // Catch: java.lang.Throwable -> L6d
                r14 = r18
                boolean r1 = r1.equivalent(r14, r4)     // Catch: java.lang.Throwable -> L6d
                if (r1 == 0) goto La4
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$ValueReference r15 = r12.getValueReference()     // Catch: java.lang.Throwable -> L6d
                java.lang.Object r16 = r15.get()     // Catch: java.lang.Throwable -> L6d
                if (r16 != 0) goto L76
                boolean r1 = r15.isActive()     // Catch: java.lang.Throwable -> L6d
                if (r1 == 0) goto L6f
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> L6d
                int r1 = r1 + 1
                r9.modCount = r1     // Catch: java.lang.Throwable -> L6d
                androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause r8 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L6d
                r1 = r17
                r3 = r12
                r5 = r19
                r6 = r16
                r7 = r15
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r0 = r1.removeValueFromChain(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L6d
                int r1 = r9.count     // Catch: java.lang.Throwable -> L6d
                int r1 = r1 + (-1)
                r10.set(r11, r0)     // Catch: java.lang.Throwable -> L6d
                r9.count = r1     // Catch: java.lang.Throwable -> L6d
                goto L6f
            L6d:
                r0 = move-exception
                goto Laa
            L6f:
                r17.unlock()
                r17.postWriteCleanup()
                return r13
            L76:
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> L6d
                int r1 = r1 + 1
                r9.modCount = r1     // Catch: java.lang.Throwable -> L6d
                int r5 = r15.getWeight()     // Catch: java.lang.Throwable -> L6d
                androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause r6 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> L6d
                r1 = r17
                r2 = r18
                r3 = r19
                r4 = r16
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L6d
                r1 = r17
                r2 = r12
                r3 = r18
                r4 = r20
                r5 = r7
                r1.setValue(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L6d
                r9.evictEntries(r12)     // Catch: java.lang.Throwable -> L6d
                r17.unlock()
                r17.postWriteCleanup()
                return r16
            La2:
                r14 = r18
            La4:
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r12 = r12.getNext()     // Catch: java.lang.Throwable -> L6d
                goto L24
            Laa:
                r17.unlock()
                r17.postWriteCleanup()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Segment.replace(java.lang.Object, int, java.lang.Object):java.lang.Object");
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

        Object scheduleRefresh(ReferenceEntry referenceEntry, Object obj, int i, Object obj2, long j, CacheLoader cacheLoader) {
            Object objRefresh;
            return (!this.map.refreshes() || j - referenceEntry.getWriteTime() <= this.map.refreshNanos || referenceEntry.getValueReference().isLoading() || (objRefresh = refresh(obj, i, cacheLoader, true)) == null) ? obj2 : objRefresh;
        }

        void setValue(ReferenceEntry referenceEntry, Object obj, Object obj2, long j) {
            ValueReference valueReference = referenceEntry.getValueReference();
            int iWeigh = this.map.weigher.weigh(obj, obj2);
            Preconditions.checkState(iWeigh >= 0, "Weights must be non-negative");
            referenceEntry.setValueReference(this.map.valueStrength.referenceValue(this, referenceEntry, obj2, iWeigh));
            recordWrite(referenceEntry, iWeigh, j);
            valueReference.notifyNewValue(obj2);
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
                ReferenceEntry next = referenceEntry;
                while (true) {
                    if (next == null) {
                        this.modCount++;
                        ReferenceEntry referenceEntryNewEntry = newEntry(obj, i, referenceEntry);
                        setValue(referenceEntryNewEntry, obj, obj2, j);
                        atomicReferenceArray.set(length, referenceEntryNewEntry);
                        this.count = i3;
                        evictEntries(referenceEntryNewEntry);
                        break;
                    }
                    Object key = next.getKey();
                    if (next.getHash() == i && key != null && this.map.keyEquivalence.equivalent(obj, key)) {
                        ValueReference valueReference = next.getValueReference();
                        Object obj3 = valueReference.get();
                        if (loadingValueReference != valueReference && (obj3 != null || valueReference == LocalCache.UNSET)) {
                            enqueueNotification(obj, i, obj2, 0, RemovalCause.REPLACED);
                            unlock();
                            postWriteCleanup();
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
                    } else {
                        next = next.getNext();
                    }
                }
                unlock();
                postWriteCleanup();
                return true;
            } catch (Throwable th) {
                unlock();
                postWriteCleanup();
                throw th;
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

        void tryExpireEntries(long j) {
            if (tryLock()) {
                try {
                    expireEntries(j);
                } finally {
                    unlock();
                }
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

        Object getAndRecordStats(Object obj, int i, LoadingValueReference loadingValueReference, ListenableFuture listenableFuture) throws Throwable {
            Object uninterruptibly;
            try {
                uninterruptibly = Uninterruptibles.getUninterruptibly(listenableFuture);
            } catch (Throwable th) {
                th = th;
                uninterruptibly = null;
            }
            try {
                if (uninterruptibly != null) {
                    this.statsCounter.recordLoadSuccess(loadingValueReference.elapsedNanos());
                    storeLoadedValue(obj, i, loadingValueReference, uninterruptibly);
                    return uninterruptibly;
                }
                String strValueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 35);
                sb.append("CacheLoader returned null for key ");
                sb.append(strValueOf);
                sb.append(InstructionFileId.DOT);
                throw new CacheLoader.InvalidCacheLoadException(sb.toString());
            } catch (Throwable th2) {
                th = th2;
                if (uninterruptibly == null) {
                    this.statsCounter.recordLoadException(loadingValueReference.elapsedNanos());
                    removeLoadingValue(obj, i, loadingValueReference);
                }
                throw th;
            }
        }

        /* JADX WARN: Finally extract failed */
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
                            unlock();
                            postWriteCleanup();
                            return loadingValueReference;
                        }
                        unlock();
                        postWriteCleanup();
                        return null;
                    }
                }
                this.modCount++;
                LoadingValueReference loadingValueReference2 = new LoadingValueReference();
                ReferenceEntry referenceEntryNewEntry = newEntry(obj, i, referenceEntry);
                referenceEntryNewEntry.setValueReference(loadingValueReference2);
                atomicReferenceArray.set(length, referenceEntryNewEntry);
                unlock();
                postWriteCleanup();
                return loadingValueReference2;
            } catch (Throwable th) {
                unlock();
                postWriteCleanup();
                throw th;
            }
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

        void removeCollectedEntry(ReferenceEntry referenceEntry) {
            enqueueNotification(referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry.getValueReference().get(), referenceEntry.getValueReference().getWeight(), RemovalCause.COLLECTED);
            this.writeQueue.remove(referenceEntry);
            this.accessQueue.remove(referenceEntry);
        }

        boolean removeEntry(ReferenceEntry referenceEntry, int i, RemovalCause removalCause) {
            AtomicReferenceArray atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i;
            ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry next = referenceEntry2; next != null; next = next.getNext()) {
                if (next == referenceEntry) {
                    this.modCount++;
                    ReferenceEntry referenceEntryRemoveValueFromChain = removeValueFromChain(referenceEntry2, next, next.getKey(), i, next.getValueReference().get(), next.getValueReference(), removalCause);
                    int i2 = this.count;
                    atomicReferenceArray.set(length, referenceEntryRemoveValueFromChain);
                    this.count = i2 - 1;
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        
            r9 = r5.getValueReference();
            r8 = r9.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
        
            if (r12.map.valueEquivalence.equivalent(r15, r8) == false) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
        
            r13 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
        
            if (r8 != null) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
        
            if (r9.isActive() == false) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
        
            r13 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.COLLECTED;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
        
            r12.modCount++;
            r14 = removeValueFromChain(r4, r5, r6, r14, r8, r9, r13);
            r15 = r12.count - 1;
            r0.set(r1, r14);
            r12.count = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0071, code lost:
        
            if (r13 != androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.EXPLICIT) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0073, code lost:
        
            r2 = true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean remove(java.lang.Object r13, int r14, java.lang.Object r15) {
            /*
                r12 = this;
                r12.lock()
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache r0 = r12.map     // Catch: java.lang.Throwable -> L4d
                androidx.test.espresso.core.internal.deps.guava.base.Ticker r0 = r0.ticker     // Catch: java.lang.Throwable -> L4d
                long r0 = r0.read()     // Catch: java.lang.Throwable -> L4d
                r12.preWriteCleanup(r0)     // Catch: java.lang.Throwable -> L4d
                java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.table     // Catch: java.lang.Throwable -> L4d
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L4d
                int r1 = r1 + (-1)
                r1 = r1 & r14
                java.lang.Object r2 = r0.get(r1)     // Catch: java.lang.Throwable -> L4d
                r4 = r2
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r4 = (androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry) r4     // Catch: java.lang.Throwable -> L4d
                r5 = r4
            L1f:
                r2 = 0
                if (r5 == 0) goto L74
                java.lang.Object r6 = r5.getKey()     // Catch: java.lang.Throwable -> L4d
                int r3 = r5.getHash()     // Catch: java.lang.Throwable -> L4d
                if (r3 != r14) goto L7b
                if (r6 == 0) goto L7b
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache r3 = r12.map     // Catch: java.lang.Throwable -> L4d
                androidx.test.espresso.core.internal.deps.guava.base.Equivalence r3 = r3.keyEquivalence     // Catch: java.lang.Throwable -> L4d
                boolean r3 = r3.equivalent(r13, r6)     // Catch: java.lang.Throwable -> L4d
                if (r3 == 0) goto L7b
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$ValueReference r9 = r5.getValueReference()     // Catch: java.lang.Throwable -> L4d
                java.lang.Object r8 = r9.get()     // Catch: java.lang.Throwable -> L4d
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache r13 = r12.map     // Catch: java.lang.Throwable -> L4d
                androidx.test.espresso.core.internal.deps.guava.base.Equivalence r13 = r13.valueEquivalence     // Catch: java.lang.Throwable -> L4d
                boolean r13 = r13.equivalent(r15, r8)     // Catch: java.lang.Throwable -> L4d
                if (r13 == 0) goto L4f
                androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause r13 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L4d
                goto L59
            L4d:
                r13 = move-exception
                goto L80
            L4f:
                if (r8 != 0) goto L74
                boolean r13 = r9.isActive()     // Catch: java.lang.Throwable -> L4d
                if (r13 == 0) goto L74
                androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause r13 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L4d
            L59:
                int r15 = r12.modCount     // Catch: java.lang.Throwable -> L4d
                r11 = 1
                int r15 = r15 + r11
                r12.modCount = r15     // Catch: java.lang.Throwable -> L4d
                r3 = r12
                r7 = r14
                r10 = r13
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r14 = r3.removeValueFromChain(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L4d
                int r15 = r12.count     // Catch: java.lang.Throwable -> L4d
                int r15 = r15 + (-1)
                r0.set(r1, r14)     // Catch: java.lang.Throwable -> L4d
                r12.count = r15     // Catch: java.lang.Throwable -> L4d
                androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause r14 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L4d
                if (r13 != r14) goto L74
                r2 = r11
            L74:
                r12.unlock()
                r12.postWriteCleanup()
                return r2
            L7b:
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r5 = r5.getNext()     // Catch: java.lang.Throwable -> L4d
                goto L1f
            L80:
                r12.unlock()
                r12.postWriteCleanup()
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Segment.remove(java.lang.Object, int, java.lang.Object):boolean");
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0075, code lost:
        
            return false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean replace(java.lang.Object r18, int r19, java.lang.Object r20, java.lang.Object r21) {
            /*
                r17 = this;
                r9 = r17
                r0 = r19
                r17.lock()
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache r1 = r9.map     // Catch: java.lang.Throwable -> L6d
                androidx.test.espresso.core.internal.deps.guava.base.Ticker r1 = r1.ticker     // Catch: java.lang.Throwable -> L6d
                long r7 = r1.read()     // Catch: java.lang.Throwable -> L6d
                r9.preWriteCleanup(r7)     // Catch: java.lang.Throwable -> L6d
                java.util.concurrent.atomic.AtomicReferenceArray r10 = r9.table     // Catch: java.lang.Throwable -> L6d
                int r1 = r10.length()     // Catch: java.lang.Throwable -> L6d
                int r1 = r1 + (-1)
                r11 = r0 & r1
                java.lang.Object r1 = r10.get(r11)     // Catch: java.lang.Throwable -> L6d
                r2 = r1
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r2 = (androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry) r2     // Catch: java.lang.Throwable -> L6d
                r12 = r2
            L24:
                r13 = 0
                if (r12 == 0) goto L6f
                java.lang.Object r4 = r12.getKey()     // Catch: java.lang.Throwable -> L6d
                int r1 = r12.getHash()     // Catch: java.lang.Throwable -> L6d
                if (r1 != r0) goto Lb5
                if (r4 == 0) goto Lb5
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache r1 = r9.map     // Catch: java.lang.Throwable -> L6d
                androidx.test.espresso.core.internal.deps.guava.base.Equivalence r1 = r1.keyEquivalence     // Catch: java.lang.Throwable -> L6d
                r14 = r18
                boolean r1 = r1.equivalent(r14, r4)     // Catch: java.lang.Throwable -> L6d
                if (r1 == 0) goto Lb2
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$ValueReference r15 = r12.getValueReference()     // Catch: java.lang.Throwable -> L6d
                java.lang.Object r6 = r15.get()     // Catch: java.lang.Throwable -> L6d
                r16 = 1
                if (r6 != 0) goto L76
                boolean r1 = r15.isActive()     // Catch: java.lang.Throwable -> L6d
                if (r1 == 0) goto L6f
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> L6d
                int r1 = r1 + 1
                r9.modCount = r1     // Catch: java.lang.Throwable -> L6d
                androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause r8 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L6d
                r1 = r17
                r3 = r12
                r5 = r19
                r7 = r15
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r0 = r1.removeValueFromChain(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L6d
                int r1 = r9.count     // Catch: java.lang.Throwable -> L6d
                int r1 = r1 + (-1)
                r10.set(r11, r0)     // Catch: java.lang.Throwable -> L6d
                r9.count = r1     // Catch: java.lang.Throwable -> L6d
                goto L6f
            L6d:
                r0 = move-exception
                goto Lbe
            L6f:
                r17.unlock()
                r17.postWriteCleanup()
                return r13
            L76:
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache r1 = r9.map     // Catch: java.lang.Throwable -> L6d
                androidx.test.espresso.core.internal.deps.guava.base.Equivalence r1 = r1.valueEquivalence     // Catch: java.lang.Throwable -> L6d
                r3 = r20
                boolean r1 = r1.equivalent(r3, r6)     // Catch: java.lang.Throwable -> L6d
                if (r1 == 0) goto Lae
                int r1 = r9.modCount     // Catch: java.lang.Throwable -> L6d
                int r1 = r1 + 1
                r9.modCount = r1     // Catch: java.lang.Throwable -> L6d
                int r5 = r15.getWeight()     // Catch: java.lang.Throwable -> L6d
                androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause r10 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> L6d
                r1 = r17
                r2 = r18
                r3 = r19
                r4 = r6
                r6 = r10
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L6d
                r1 = r17
                r2 = r12
                r3 = r18
                r4 = r21
                r5 = r7
                r1.setValue(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L6d
                r9.evictEntries(r12)     // Catch: java.lang.Throwable -> L6d
                r17.unlock()
                r17.postWriteCleanup()
                return r16
            Lae:
                r9.recordLockedRead(r12, r7)     // Catch: java.lang.Throwable -> L6d
                goto L6f
            Lb2:
                r3 = r20
                goto Lb8
            Lb5:
                r14 = r18
                goto Lb2
            Lb8:
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r12 = r12.getNext()     // Catch: java.lang.Throwable -> L6d
                goto L24
            Lbe:
                r17.unlock()
                r17.postWriteCleanup()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Segment.replace(java.lang.Object, int, java.lang.Object, java.lang.Object):boolean");
        }
    }

    static class SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {
        final ReferenceEntry entry;

        SoftValueReference(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            super(obj, referenceQueue);
            this.entry = referenceEntry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ValueReference copyFor(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return new SoftValueReference(referenceQueue, obj, referenceEntry);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ReferenceEntry getEntry() {
            return this.entry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public void notifyNewValue(Object obj) {
        }
    }

    enum Strength {
        STRONG { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Strength.1
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Strength
            Equivalence defaultEquivalence() {
                return Equivalence.equals();
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Strength
            ValueReference referenceValue(Segment segment, ReferenceEntry referenceEntry, Object obj, int i) {
                return i == 1 ? new StrongValueReference(obj) : new WeightedStrongValueReference(obj, i);
            }
        },
        SOFT { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Strength.2
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Strength
            Equivalence defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Strength
            ValueReference referenceValue(Segment segment, ReferenceEntry referenceEntry, Object obj, int i) {
                return i == 1 ? new SoftValueReference(segment.valueReferenceQueue, obj, referenceEntry) : new WeightedSoftValueReference(segment.valueReferenceQueue, obj, referenceEntry, i);
            }
        },
        WEAK { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Strength.3
            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Strength
            Equivalence defaultEquivalence() {
                return Equivalence.identity();
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Strength
            ValueReference referenceValue(Segment segment, ReferenceEntry referenceEntry, Object obj, int i) {
                return i == 1 ? new WeakValueReference(segment.valueReferenceQueue, obj, referenceEntry) : new WeightedWeakValueReference(segment.valueReferenceQueue, obj, referenceEntry, i);
            }
        };

        abstract Equivalence defaultEquivalence();

        abstract ValueReference referenceValue(Segment segment, ReferenceEntry referenceEntry, Object obj, int i);
    }

    static final class StrongAccessEntry<K, V> extends StrongEntry<K, V> {
        volatile long accessTime;
        ReferenceEntry nextAccess;
        ReferenceEntry previousAccess;

        StrongAccessEntry(Object obj, int i, ReferenceEntry referenceEntry) {
            super(obj, i, referenceEntry);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.accessTime = j;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry referenceEntry) {
            this.nextAccess = referenceEntry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry referenceEntry) {
            this.previousAccess = referenceEntry;
        }
    }

    static final class StrongAccessWriteEntry<K, V> extends StrongEntry<K, V> {
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

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.accessTime = j;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry referenceEntry) {
            this.nextAccess = referenceEntry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry referenceEntry) {
            this.nextWrite = referenceEntry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry referenceEntry) {
            this.previousAccess = referenceEntry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry referenceEntry) {
            this.previousWrite = referenceEntry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.writeTime = j;
        }
    }

    static class StrongEntry<K, V> extends AbstractReferenceEntry<K, V> {
        final int hash;
        final Object key;
        final ReferenceEntry next;
        volatile ValueReference valueReference = LocalCache.unset();

        StrongEntry(Object obj, int i, ReferenceEntry referenceEntry) {
            this.key = obj;
            this.hash = i;
            this.next = referenceEntry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public int getHash() {
            return this.hash;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public Object getKey() {
            return this.key;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getNext() {
            return this.next;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ValueReference getValueReference() {
            return this.valueReference;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setValueReference(ValueReference valueReference) {
            this.valueReference = valueReference;
        }
    }

    static class StrongValueReference<K, V> implements ValueReference<K, V> {
        final Object referent;

        StrongValueReference(Object obj) {
            this.referent = obj;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ValueReference copyFor(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return this;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public Object get() {
            return this.referent;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ReferenceEntry getEntry() {
            return null;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public void notifyNewValue(Object obj) {
        }
    }

    static final class StrongWriteEntry<K, V> extends StrongEntry<K, V> {
        ReferenceEntry nextWrite;
        ReferenceEntry previousWrite;
        volatile long writeTime;

        StrongWriteEntry(Object obj, int i, ReferenceEntry referenceEntry) {
            super(obj, i, referenceEntry);
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry referenceEntry) {
            this.nextWrite = referenceEntry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry referenceEntry) {
            this.previousWrite = referenceEntry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.writeTime = j;
        }
    }

    final class ValueIterator extends LocalCache<K, V>.HashIterator<V> {
        ValueIterator(LocalCache localCache) {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return nextEntry().getValue();
        }
    }

    interface ValueReference<K, V> {
        ValueReference copyFor(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry);

        Object get();

        ReferenceEntry getEntry();

        int getWeight();

        boolean isActive();

        boolean isLoading();

        void notifyNewValue(Object obj);
    }

    final class Values extends AbstractCollection<V> {
        Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            LocalCache.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return LocalCache.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new ValueIterator(LocalCache.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return LocalCache.this.size();
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

    static final class WeakAccessEntry<K, V> extends WeakEntry<K, V> {
        volatile long accessTime;
        ReferenceEntry nextAccess;
        ReferenceEntry previousAccess;

        WeakAccessEntry(ReferenceQueue referenceQueue, Object obj, int i, ReferenceEntry referenceEntry) {
            super(referenceQueue, obj, i, referenceEntry);
            this.accessTime = Long.MAX_VALUE;
            this.nextAccess = LocalCache.nullEntry();
            this.previousAccess = LocalCache.nullEntry();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.accessTime = j;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry referenceEntry) {
            this.nextAccess = referenceEntry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry referenceEntry) {
            this.previousAccess = referenceEntry;
        }
    }

    static final class WeakAccessWriteEntry<K, V> extends WeakEntry<K, V> {
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

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getAccessTime() {
            return this.accessTime;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getNextInAccessQueue() {
            return this.nextAccess;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getPreviousInAccessQueue() {
            return this.previousAccess;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setAccessTime(long j) {
            this.accessTime = j;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInAccessQueue(ReferenceEntry referenceEntry) {
            this.nextAccess = referenceEntry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry referenceEntry) {
            this.nextWrite = referenceEntry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInAccessQueue(ReferenceEntry referenceEntry) {
            this.previousAccess = referenceEntry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry referenceEntry) {
            this.previousWrite = referenceEntry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.writeTime = j;
        }
    }

    static class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {
        final int hash;
        final ReferenceEntry next;
        volatile ValueReference valueReference;

        WeakEntry(ReferenceQueue referenceQueue, Object obj, int i, ReferenceEntry referenceEntry) {
            super(obj, referenceQueue);
            this.valueReference = LocalCache.unset();
            this.hash = i;
            this.next = referenceEntry;
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public int getHash() {
            return this.hash;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public Object getKey() {
            return get();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getNext() {
            return this.next;
        }

        public ReferenceEntry getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ValueReference getValueReference() {
            return this.valueReference;
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j) {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setValueReference(ValueReference valueReference) {
            this.valueReference = valueReference;
        }

        public void setWriteTime(long j) {
            throw new UnsupportedOperationException();
        }
    }

    static class WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {
        final ReferenceEntry entry;

        WeakValueReference(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            super(obj, referenceQueue);
            this.entry = referenceEntry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ValueReference copyFor(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return new WeakValueReference(referenceQueue, obj, referenceEntry);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ReferenceEntry getEntry() {
            return this.entry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public int getWeight() {
            return 1;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public boolean isLoading() {
            return false;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public void notifyNewValue(Object obj) {
        }
    }

    static final class WeakWriteEntry<K, V> extends WeakEntry<K, V> {
        ReferenceEntry nextWrite;
        ReferenceEntry previousWrite;
        volatile long writeTime;

        WeakWriteEntry(ReferenceQueue referenceQueue, Object obj, int i, ReferenceEntry referenceEntry) {
            super(referenceQueue, obj, i, referenceEntry);
            this.writeTime = Long.MAX_VALUE;
            this.nextWrite = LocalCache.nullEntry();
            this.previousWrite = LocalCache.nullEntry();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getNextInWriteQueue() {
            return this.nextWrite;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public ReferenceEntry getPreviousInWriteQueue() {
            return this.previousWrite;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public long getWriteTime() {
            return this.writeTime;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setNextInWriteQueue(ReferenceEntry referenceEntry) {
            this.nextWrite = referenceEntry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setPreviousInWriteQueue(ReferenceEntry referenceEntry) {
            this.previousWrite = referenceEntry;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
        public void setWriteTime(long j) {
            this.writeTime = j;
        }
    }

    static final class WeightedSoftValueReference<K, V> extends SoftValueReference<K, V> {
        final int weight;

        WeightedSoftValueReference(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry, int i) {
            super(referenceQueue, obj, referenceEntry);
            this.weight = i;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.SoftValueReference, androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ValueReference copyFor(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return new WeightedSoftValueReference(referenceQueue, obj, referenceEntry, this.weight);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.SoftValueReference, androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.weight;
        }
    }

    static final class WeightedStrongValueReference<K, V> extends StrongValueReference<K, V> {
        final int weight;

        WeightedStrongValueReference(Object obj, int i) {
            super(obj);
            this.weight = i;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.StrongValueReference, androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.weight;
        }
    }

    static final class WeightedWeakValueReference<K, V> extends WeakValueReference<K, V> {
        final int weight;

        WeightedWeakValueReference(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry, int i) {
            super(referenceQueue, obj, referenceEntry);
            this.weight = i;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakValueReference, androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public ValueReference copyFor(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return new WeightedWeakValueReference(referenceQueue, obj, referenceEntry, this.weight);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WeakValueReference, androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ValueReference
        public int getWeight() {
            return this.weight;
        }
    }

    static final class WriteQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {
        final ReferenceEntry head = new AbstractReferenceEntry<K, V>(this) { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WriteQueue.1
            ReferenceEntry nextWrite = this;
            ReferenceEntry previousWrite = this;

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public ReferenceEntry getNextInWriteQueue() {
                return this.nextWrite;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public ReferenceEntry getPreviousInWriteQueue() {
                return this.previousWrite;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public long getWriteTime() {
                return Long.MAX_VALUE;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public void setNextInWriteQueue(ReferenceEntry referenceEntry) {
                this.nextWrite = referenceEntry;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public void setPreviousInWriteQueue(ReferenceEntry referenceEntry) {
                this.previousWrite = referenceEntry;
            }

            @Override // androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.AbstractReferenceEntry, androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry
            public void setWriteTime(long j) {
            }
        };

        WriteQueue() {
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry nextInWriteQueue = this.head.getNextInWriteQueue();
            while (true) {
                ReferenceEntry referenceEntry = this.head;
                if (nextInWriteQueue == referenceEntry) {
                    referenceEntry.setNextInWriteQueue(referenceEntry);
                    ReferenceEntry referenceEntry2 = this.head;
                    referenceEntry2.setPreviousInWriteQueue(referenceEntry2);
                    return;
                } else {
                    ReferenceEntry nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    LocalCache.nullifyWriteOrder(nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInWriteQueue() != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.head.getNextInWriteQueue() == this.head;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) { // from class: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.WriteQueue.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // androidx.test.espresso.core.internal.deps.guava.collect.AbstractSequentialIterator
                public ReferenceEntry computeNext(ReferenceEntry referenceEntry) {
                    ReferenceEntry nextInWriteQueue = referenceEntry.getNextInWriteQueue();
                    if (nextInWriteQueue == WriteQueue.this.head) {
                        return null;
                    }
                    return nextInWriteQueue;
                }
            };
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
        public int size() {
            int i = 0;
            for (ReferenceEntry nextInWriteQueue = this.head.getNextInWriteQueue(); nextInWriteQueue != this.head; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i++;
            }
            return i;
        }
    }

    final class WriteThroughEntry implements Map.Entry<K, V> {
        final Object key;
        Object value;

        WriteThroughEntry(Object obj, Object obj2) {
            this.key = obj;
            this.value = obj2;
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
        public Object getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.value;
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
            String strValueOf = String.valueOf(getKey());
            String strValueOf2 = String.valueOf(getValue());
            StringBuilder sb = new StringBuilder(strValueOf.length() + 1 + strValueOf2.length());
            sb.append(strValueOf);
            sb.append("=");
            sb.append(strValueOf2);
            return sb.toString();
        }
    }

    LocalCache(CacheBuilder cacheBuilder, CacheLoader cacheLoader) {
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
        this.removalNotificationQueue = removalListener == CacheBuilder.NullListener.INSTANCE ? discardingQueue() : new ConcurrentLinkedQueue();
        this.ticker = cacheBuilder.getTicker(recordsTime());
        this.entryFactory = EntryFactory.getFactory(keyStrength, usesAccessEntries(), usesWriteEntries());
        this.globalStatsCounter = (AbstractCache$StatsCounter) cacheBuilder.getStatsCounterSupplier().get();
        this.defaultLoader = cacheLoader;
        int iMin = Math.min(cacheBuilder.getInitialCapacity(), 1073741824);
        if (evictsBySize() && !customWeigher()) {
            iMin = (int) Math.min(iMin, maximumWeight);
        }
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        int i4 = 1;
        while (i4 < this.concurrencyLevel && (!evictsBySize() || i4 * 20 <= this.maxWeight)) {
            i3++;
            i4 += i4;
        }
        this.segmentShift = 32 - i3;
        this.segmentMask = i4 - 1;
        this.segments = newSegmentArray(i4);
        int i5 = iMin / i4;
        while (i2 < (i5 * i4 < iMin ? i5 + 1 : i5)) {
            i2 += i2;
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
                segmentArr[i] = createSegment(i2, j3, (AbstractCache$StatsCounter) cacheBuilder.getStatsCounterSupplier().get());
                i++;
            }
        } else {
            while (true) {
                Segment[] segmentArr2 = this.segments;
                if (i >= segmentArr2.length) {
                    return;
                }
                segmentArr2[i] = createSegment(i2, -1L, (AbstractCache$StatsCounter) cacheBuilder.getStatsCounterSupplier().get());
                i++;
            }
        }
    }

    static void connectAccessOrder(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
        referenceEntry.setNextInAccessQueue(referenceEntry2);
        referenceEntry2.setPreviousInAccessQueue(referenceEntry);
    }

    static void connectWriteOrder(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
        referenceEntry.setNextInWriteQueue(referenceEntry2);
        referenceEntry2.setPreviousInWriteQueue(referenceEntry);
    }

    static Queue discardingQueue() {
        return DISCARDING_QUEUE;
    }

    static ReferenceEntry nullEntry() {
        return NullEntry.INSTANCE;
    }

    static void nullifyAccessOrder(ReferenceEntry referenceEntry) {
        ReferenceEntry referenceEntryNullEntry = nullEntry();
        referenceEntry.setNextInAccessQueue(referenceEntryNullEntry);
        referenceEntry.setPreviousInAccessQueue(referenceEntryNullEntry);
    }

    static void nullifyWriteOrder(ReferenceEntry referenceEntry) {
        ReferenceEntry referenceEntryNullEntry = nullEntry();
        referenceEntry.setNextInWriteQueue(referenceEntryNullEntry);
        referenceEntry.setPreviousInWriteQueue(referenceEntryNullEntry);
    }

    static int rehash(int i) {
        int i2 = i + ((i << 15) ^ (-12931));
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = i5 + (i5 << 2) + (i5 << 14);
        return i6 ^ (i6 >>> 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList toArrayList(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterators.addAll(arrayList, collection.iterator());
        return arrayList;
    }

    static ValueReference unset() {
        return UNSET;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment segment : this.segments) {
            segment.clear();
        }
    }

    Segment createSegment(int i, long j, AbstractCache$StatsCounter abstractCache$StatsCounter) {
        return new Segment(this, i, j, abstractCache$StatsCounter);
    }

    boolean customWeigher() {
        return this.weigher != CacheBuilder.OneWeigher.INSTANCE;
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

    boolean evictsBySize() {
        return this.maxWeight >= 0;
    }

    boolean expiresAfterAccess() {
        return this.expireAfterAccessNanos > 0;
    }

    boolean expiresAfterWrite() {
        return this.expireAfterWriteNanos > 0;
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

    Object getLiveValue(ReferenceEntry referenceEntry, long j) {
        Object obj;
        if (referenceEntry.getKey() == null || (obj = referenceEntry.getValueReference().get()) == null || isExpired(referenceEntry, j)) {
            return null;
        }
        return obj;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    boolean isExpired(ReferenceEntry referenceEntry, long j) {
        Preconditions.checkNotNull(referenceEntry);
        if (!expiresAfterAccess() || j - referenceEntry.getAccessTime() < this.expireAfterAccessNanos) {
            return expiresAfterWrite() && j - referenceEntry.getWriteTime() >= this.expireAfterWriteNanos;
        }
        return true;
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

    long longSize() {
        long jMax = 0;
        for (int i = 0; i < this.segments.length; i++) {
            jMax += Math.max(0, r6[i].count);
        }
        return jMax;
    }

    final Segment[] newSegmentArray(int i) {
        return new Segment[i];
    }

    void processPendingNotifications() {
        while (true) {
            RemovalNotification<K, V> removalNotification = (RemovalNotification) this.removalNotificationQueue.poll();
            if (removalNotification == null) {
                return;
            }
            try {
                this.removalListener.onRemoval(removalNotification);
            } catch (Throwable th) {
                logger.logp(Level.WARNING, "androidx.test.espresso.core.internal.deps.guava.cache.LocalCache", "processPendingNotifications", "Exception thrown by removal listener", th);
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        int iHash = hash(obj);
        return segmentFor(iHash).put(obj, iHash, obj2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object putIfAbsent(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        int iHash = hash(obj);
        return segmentFor(iHash).put(obj, iHash, obj2, true);
    }

    void reclaimKey(ReferenceEntry referenceEntry) {
        int hash = referenceEntry.getHash();
        segmentFor(hash).reclaimKey(referenceEntry, hash);
    }

    void reclaimValue(ValueReference valueReference) {
        ReferenceEntry entry = valueReference.getEntry();
        int hash = entry.getHash();
        segmentFor(hash).reclaimValue(entry.getKey(), hash, valueReference);
    }

    boolean recordsAccess() {
        return expiresAfterAccess();
    }

    boolean recordsTime() {
        return recordsWrite() || recordsAccess();
    }

    boolean recordsWrite() {
        return expiresAfterWrite() || refreshes();
    }

    boolean refreshes() {
        return this.refreshNanos > 0;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object replace(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        int iHash = hash(obj);
        return segmentFor(iHash).replace(obj, iHash, obj2);
    }

    Segment segmentFor(int i) {
        return this.segments[this.segmentMask & (i >>> this.segmentShift)];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return Ints.saturatedCast(longSize());
    }

    boolean usesAccessEntries() {
        return usesAccessQueue() || recordsAccess();
    }

    boolean usesAccessQueue() {
        return expiresAfterAccess() || evictsBySize();
    }

    boolean usesKeyReferences() {
        return this.keyStrength != Strength.STRONG;
    }

    boolean usesValueReferences() {
        return this.valueStrength != Strength.STRONG;
    }

    boolean usesWriteEntries() {
        return usesWriteQueue() || recordsWrite();
    }

    boolean usesWriteQueue() {
        return expiresAfterWrite();
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

    static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        final LocalCache localCache;

        LocalManualCache(CacheBuilder cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.Cache
        public Object getIfPresent(Object obj) {
            return this.localCache.getIfPresent(obj);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.Cache
        public void invalidateAll() {
            this.localCache.clear();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.cache.Cache
        public void put(Object obj, Object obj2) {
            this.localCache.put(obj, obj2);
        }

        Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }

        private LocalManualCache(LocalCache localCache) {
            this.localCache = localCache;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment[] segmentArr = this.segments;
        long j = 0;
        for (int i = 0; i < segmentArr.length; i++) {
            if (segmentArr[i].count != 0) {
                return false;
            }
            j += segmentArr[i].modCount;
        }
        if (j == 0) {
            return true;
        }
        for (int i2 = 0; i2 < segmentArr.length; i2++) {
            if (segmentArr[i2].count != 0) {
                return false;
            }
            j -= segmentArr[i2].modCount;
        }
        return j == 0;
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
                j3 += segment.modCount;
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
    public Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).get(obj, iHash);
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
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).remove(obj, iHash, obj2);
    }

    static class ManualSerializationProxy<K, V> extends ForwardingCache<K, V> implements Serializable {
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

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.delegate = recreateCacheBuilder().build();
        }

        private Object readResolve() {
            return this.delegate;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.test.espresso.core.internal.deps.guava.cache.ForwardingCache, androidx.test.espresso.core.internal.deps.guava.collect.ForwardingObject
        public Cache delegate() {
            return this.delegate;
        }

        CacheBuilder recreateCacheBuilder() {
            CacheBuilder<K1, V1> cacheBuilderRemovalListener = CacheBuilder.newBuilder().setKeyStrength(this.keyStrength).setValueStrength(this.valueStrength).keyEquivalence(this.keyEquivalence).valueEquivalence(this.valueEquivalence).concurrencyLevel(this.concurrencyLevel).removalListener(this.removalListener);
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

        ManualSerializationProxy(LocalCache localCache) {
            this(localCache.keyStrength, localCache.valueStrength, localCache.keyEquivalence, localCache.valueEquivalence, localCache.expireAfterWriteNanos, localCache.expireAfterAccessNanos, localCache.maxWeight, localCache.weigher, localCache.concurrencyLevel, localCache.removalListener, localCache.ticker, localCache.defaultLoader);
        }
    }
}
