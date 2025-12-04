package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: classes4.dex */
abstract class Synchronized {

    static class SynchronizedObject implements Serializable {

        @J2ktIncompatible
        @GwtIncompatible
        private static final long serialVersionUID = 0;
        final Object delegate;
        final Object mutex;

        SynchronizedObject(Object obj, Object obj2) {
            this.delegate = Preconditions.checkNotNull(obj);
            this.mutex = obj2 == null ? this : obj2;
        }

        Object delegate() {
            return this.delegate;
        }

        public String toString() {
            String string;
            synchronized (this.mutex) {
                string = this.delegate.toString();
            }
            return string;
        }

        @J2ktIncompatible
        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            synchronized (this.mutex) {
                objectOutputStream.defaultWriteObject();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection collection(Collection collection, Object obj) {
        return new SynchronizedCollection(collection, obj);
    }

    static class SynchronizedCollection extends SynchronizedObject implements Collection {
        private static final long serialVersionUID = 0;

        private SynchronizedCollection(Collection collection, Object obj) {
            super(collection, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        Collection delegate() {
            return (Collection) super.delegate();
        }

        @Override // java.util.Collection
        public boolean add(Object obj) {
            boolean zAdd;
            synchronized (this.mutex) {
                zAdd = delegate().add(obj);
            }
            return zAdd;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            boolean zAddAll;
            synchronized (this.mutex) {
                zAddAll = delegate().addAll(collection);
            }
            return zAddAll;
        }

        @Override // java.util.Collection
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        public boolean contains(Object obj) {
            boolean zContains;
            synchronized (this.mutex) {
                zContains = delegate().contains(obj);
            }
            return zContains;
        }

        public boolean containsAll(Collection collection) {
            boolean zContainsAll;
            synchronized (this.mutex) {
                zContainsAll = delegate().containsAll(collection);
            }
            return zContainsAll;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.mutex) {
                zIsEmpty = delegate().isEmpty();
            }
            return zIsEmpty;
        }

        public Iterator iterator() {
            return delegate().iterator();
        }

        public boolean remove(Object obj) {
            boolean zRemove;
            synchronized (this.mutex) {
                zRemove = delegate().remove(obj);
            }
            return zRemove;
        }

        public boolean removeAll(Collection collection) {
            boolean zRemoveAll;
            synchronized (this.mutex) {
                zRemoveAll = delegate().removeAll(collection);
            }
            return zRemoveAll;
        }

        public boolean retainAll(Collection collection) {
            boolean zRetainAll;
            synchronized (this.mutex) {
                zRetainAll = delegate().retainAll(collection);
            }
            return zRetainAll;
        }

        @Override // java.util.Collection
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        public Object[] toArray() {
            Object[] array;
            synchronized (this.mutex) {
                array = delegate().toArray();
            }
            return array;
        }

        public Object[] toArray(Object[] objArr) {
            Object[] array;
            synchronized (this.mutex) {
                array = delegate().toArray(objArr);
            }
            return array;
        }
    }

    static Set set(Set set, Object obj) {
        return new SynchronizedSet(set, obj);
    }

    static class SynchronizedSet extends SynchronizedCollection implements Set {
        private static final long serialVersionUID = 0;

        SynchronizedSet(Set set, Object obj) {
            super(set, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Set delegate() {
            return (Set) super.delegate();
        }

        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                zEquals = delegate().equals(obj);
            }
            return zEquals;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int iHashCode;
            synchronized (this.mutex) {
                iHashCode = delegate().hashCode();
            }
            return iHashCode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SortedSet sortedSet(SortedSet sortedSet, Object obj) {
        return new SynchronizedSortedSet(sortedSet, obj);
    }

    static class SynchronizedSortedSet extends SynchronizedSet implements SortedSet {
        private static final long serialVersionUID = 0;

        SynchronizedSortedSet(SortedSet sortedSet, Object obj) {
            super(sortedSet, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedSet delegate() {
            return (SortedSet) super.delegate();
        }

        @Override // java.util.SortedSet
        public Comparator comparator() {
            Comparator comparator;
            synchronized (this.mutex) {
                comparator = delegate().comparator();
            }
            return comparator;
        }

        public SortedSet subSet(Object obj, Object obj2) {
            SortedSet sortedSet;
            synchronized (this.mutex) {
                sortedSet = Synchronized.sortedSet(delegate().subSet(obj, obj2), this.mutex);
            }
            return sortedSet;
        }

        public SortedSet headSet(Object obj) {
            SortedSet sortedSet;
            synchronized (this.mutex) {
                sortedSet = Synchronized.sortedSet(delegate().headSet(obj), this.mutex);
            }
            return sortedSet;
        }

        public SortedSet tailSet(Object obj) {
            SortedSet sortedSet;
            synchronized (this.mutex) {
                sortedSet = Synchronized.sortedSet(delegate().tailSet(obj), this.mutex);
            }
            return sortedSet;
        }

        @Override // java.util.SortedSet
        public Object first() {
            Object objFirst;
            synchronized (this.mutex) {
                objFirst = delegate().first();
            }
            return objFirst;
        }

        @Override // java.util.SortedSet
        public Object last() {
            Object objLast;
            synchronized (this.mutex) {
                objLast = delegate().last();
            }
            return objLast;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List list(List list, Object obj) {
        if (list instanceof RandomAccess) {
            return new SynchronizedRandomAccessList(list, obj);
        }
        return new SynchronizedList(list, obj);
    }

    static class SynchronizedList extends SynchronizedCollection implements List {
        private static final long serialVersionUID = 0;

        SynchronizedList(List list, Object obj) {
            super(list, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public List delegate() {
            return (List) super.delegate();
        }

        @Override // java.util.List
        public void add(int i, Object obj) {
            synchronized (this.mutex) {
                delegate().add(i, obj);
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection collection) {
            boolean zAddAll;
            synchronized (this.mutex) {
                zAddAll = delegate().addAll(i, collection);
            }
            return zAddAll;
        }

        @Override // java.util.List
        public Object get(int i) {
            Object obj;
            synchronized (this.mutex) {
                obj = delegate().get(i);
            }
            return obj;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int iIndexOf;
            synchronized (this.mutex) {
                iIndexOf = delegate().indexOf(obj);
            }
            return iIndexOf;
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int iLastIndexOf;
            synchronized (this.mutex) {
                iLastIndexOf = delegate().lastIndexOf(obj);
            }
            return iLastIndexOf;
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            return delegate().listIterator();
        }

        @Override // java.util.List
        public ListIterator listIterator(int i) {
            return delegate().listIterator(i);
        }

        @Override // java.util.List
        public Object remove(int i) {
            Object objRemove;
            synchronized (this.mutex) {
                objRemove = delegate().remove(i);
            }
            return objRemove;
        }

        @Override // java.util.List
        public Object set(int i, Object obj) {
            Object obj2;
            synchronized (this.mutex) {
                obj2 = delegate().set(i, obj);
            }
            return obj2;
        }

        @Override // java.util.List
        public List subList(int i, int i2) {
            List list;
            synchronized (this.mutex) {
                list = Synchronized.list(delegate().subList(i, i2), this.mutex);
            }
            return list;
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                zEquals = delegate().equals(obj);
            }
            return zEquals;
        }

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            int iHashCode;
            synchronized (this.mutex) {
                iHashCode = delegate().hashCode();
            }
            return iHashCode;
        }
    }

    static final class SynchronizedRandomAccessList extends SynchronizedList implements RandomAccess {
        private static final long serialVersionUID = 0;

        SynchronizedRandomAccessList(List list, Object obj) {
            super(list, obj);
        }
    }

    static Multiset multiset(Multiset multiset, Object obj) {
        return ((multiset instanceof SynchronizedMultiset) || (multiset instanceof ImmutableMultiset)) ? multiset : new SynchronizedMultiset(multiset, obj);
    }

    static final class SynchronizedMultiset extends SynchronizedCollection implements Multiset {
        private static final long serialVersionUID = 0;
        transient Set elementSet;
        transient Set entrySet;

        SynchronizedMultiset(Multiset multiset, Object obj) {
            super(multiset, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Multiset delegate() {
            return (Multiset) super.delegate();
        }

        @Override // com.google.common.collect.Multiset
        public int count(Object obj) {
            int iCount;
            synchronized (this.mutex) {
                iCount = delegate().count(obj);
            }
            return iCount;
        }

        @Override // com.google.common.collect.Multiset
        public int add(Object obj, int i) {
            int iAdd;
            synchronized (this.mutex) {
                iAdd = delegate().add(obj, i);
            }
            return iAdd;
        }

        @Override // com.google.common.collect.Multiset
        public int remove(Object obj, int i) {
            int iRemove;
            synchronized (this.mutex) {
                iRemove = delegate().remove(obj, i);
            }
            return iRemove;
        }

        @Override // com.google.common.collect.Multiset
        public int setCount(Object obj, int i) {
            int count;
            synchronized (this.mutex) {
                count = delegate().setCount(obj, i);
            }
            return count;
        }

        @Override // com.google.common.collect.Multiset
        public boolean setCount(Object obj, int i, int i2) {
            boolean count;
            synchronized (this.mutex) {
                count = delegate().setCount(obj, i, i2);
            }
            return count;
        }

        @Override // com.google.common.collect.Multiset
        public Set elementSet() {
            Set set;
            synchronized (this.mutex) {
                try {
                    if (this.elementSet == null) {
                        this.elementSet = Synchronized.typePreservingSet(delegate().elementSet(), this.mutex);
                    }
                    set = this.elementSet;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.Multiset
        public Set entrySet() {
            Set set;
            synchronized (this.mutex) {
                try {
                    if (this.entrySet == null) {
                        this.entrySet = Synchronized.typePreservingSet(delegate().entrySet(), this.mutex);
                    }
                    set = this.entrySet;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // java.util.Collection, com.google.common.collect.Multiset
        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                zEquals = delegate().equals(obj);
            }
            return zEquals;
        }

        @Override // java.util.Collection, com.google.common.collect.Multiset
        public int hashCode() {
            int iHashCode;
            synchronized (this.mutex) {
                iHashCode = delegate().hashCode();
            }
            return iHashCode;
        }
    }

    static Multimap multimap(Multimap multimap, Object obj) {
        return ((multimap instanceof SynchronizedMultimap) || (multimap instanceof BaseImmutableMultimap)) ? multimap : new SynchronizedMultimap(multimap, obj);
    }

    static class SynchronizedMultimap extends SynchronizedObject implements Multimap {
        private static final long serialVersionUID = 0;
        transient Map asMap;
        transient Collection entries;
        transient Set keySet;
        transient Multiset keys;
        transient Collection valuesCollection;

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        Multimap delegate() {
            return (Multimap) super.delegate();
        }

        SynchronizedMultimap(Multimap multimap, Object obj) {
            super(multimap, obj);
        }

        @Override // com.google.common.collect.Multimap
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        @Override // com.google.common.collect.Multimap
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.mutex) {
                zIsEmpty = delegate().isEmpty();
            }
            return zIsEmpty;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsKey(Object obj) {
            boolean zContainsKey;
            synchronized (this.mutex) {
                zContainsKey = delegate().containsKey(obj);
            }
            return zContainsKey;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsValue(Object obj) {
            boolean zContainsValue;
            synchronized (this.mutex) {
                zContainsValue = delegate().containsValue(obj);
            }
            return zContainsValue;
        }

        @Override // com.google.common.collect.Multimap
        public boolean containsEntry(Object obj, Object obj2) {
            boolean zContainsEntry;
            synchronized (this.mutex) {
                zContainsEntry = delegate().containsEntry(obj, obj2);
            }
            return zContainsEntry;
        }

        public Collection get(Object obj) {
            Collection collectionTypePreservingCollection;
            synchronized (this.mutex) {
                collectionTypePreservingCollection = Synchronized.typePreservingCollection(delegate().get(obj), this.mutex);
            }
            return collectionTypePreservingCollection;
        }

        @Override // com.google.common.collect.Multimap
        public boolean put(Object obj, Object obj2) {
            boolean zPut;
            synchronized (this.mutex) {
                zPut = delegate().put(obj, obj2);
            }
            return zPut;
        }

        @Override // com.google.common.collect.Multimap
        public boolean putAll(Object obj, Iterable iterable) {
            boolean zPutAll;
            synchronized (this.mutex) {
                zPutAll = delegate().putAll(obj, iterable);
            }
            return zPutAll;
        }

        @Override // com.google.common.collect.Multimap
        public boolean putAll(Multimap multimap) {
            boolean zPutAll;
            synchronized (this.mutex) {
                zPutAll = delegate().putAll(multimap);
            }
            return zPutAll;
        }

        public Collection replaceValues(Object obj, Iterable iterable) {
            Collection collectionReplaceValues;
            synchronized (this.mutex) {
                collectionReplaceValues = delegate().replaceValues(obj, iterable);
            }
            return collectionReplaceValues;
        }

        @Override // com.google.common.collect.Multimap
        public boolean remove(Object obj, Object obj2) {
            boolean zRemove;
            synchronized (this.mutex) {
                zRemove = delegate().remove(obj, obj2);
            }
            return zRemove;
        }

        public Collection removeAll(Object obj) {
            Collection collectionRemoveAll;
            synchronized (this.mutex) {
                collectionRemoveAll = delegate().removeAll(obj);
            }
            return collectionRemoveAll;
        }

        @Override // com.google.common.collect.Multimap
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // com.google.common.collect.Multimap
        public Set keySet() {
            Set set;
            synchronized (this.mutex) {
                try {
                    if (this.keySet == null) {
                        this.keySet = Synchronized.typePreservingSet(delegate().keySet(), this.mutex);
                    }
                    set = this.keySet;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.Multimap
        public Collection values() {
            Collection collection;
            synchronized (this.mutex) {
                try {
                    if (this.valuesCollection == null) {
                        this.valuesCollection = Synchronized.collection(delegate().values(), this.mutex);
                    }
                    collection = this.valuesCollection;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }

        @Override // com.google.common.collect.Multimap
        public Collection entries() {
            Collection collection;
            synchronized (this.mutex) {
                try {
                    if (this.entries == null) {
                        this.entries = Synchronized.typePreservingCollection(delegate().entries(), this.mutex);
                    }
                    collection = this.entries;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Map asMap() {
            Map map;
            synchronized (this.mutex) {
                try {
                    if (this.asMap == null) {
                        this.asMap = new SynchronizedAsMap(delegate().asMap(), this.mutex);
                    }
                    map = this.asMap;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return map;
        }

        @Override // com.google.common.collect.Multimap
        public Multiset keys() {
            Multiset multiset;
            synchronized (this.mutex) {
                try {
                    if (this.keys == null) {
                        this.keys = Synchronized.multiset(delegate().keys(), this.mutex);
                    }
                    multiset = this.keys;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return multiset;
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                zEquals = delegate().equals(obj);
            }
            return zEquals;
        }

        @Override // com.google.common.collect.Multimap
        public int hashCode() {
            int iHashCode;
            synchronized (this.mutex) {
                iHashCode = delegate().hashCode();
            }
            return iHashCode;
        }
    }

    static ListMultimap listMultimap(ListMultimap listMultimap, Object obj) {
        return ((listMultimap instanceof SynchronizedListMultimap) || (listMultimap instanceof BaseImmutableMultimap)) ? listMultimap : new SynchronizedListMultimap(listMultimap, obj);
    }

    static final class SynchronizedListMultimap extends SynchronizedMultimap implements ListMultimap {
        private static final long serialVersionUID = 0;

        SynchronizedListMultimap(ListMultimap listMultimap, Object obj) {
            super(listMultimap, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public ListMultimap delegate() {
            return (ListMultimap) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List get(Object obj) {
            List list;
            synchronized (this.mutex) {
                list = Synchronized.list(delegate().get((ListMultimap) obj), this.mutex);
            }
            return list;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List removeAll(Object obj) {
            List listRemoveAll;
            synchronized (this.mutex) {
                listRemoveAll = delegate().removeAll(obj);
            }
            return listRemoveAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public List replaceValues(Object obj, Iterable iterable) {
            List listReplaceValues;
            synchronized (this.mutex) {
                listReplaceValues = delegate().replaceValues((ListMultimap) obj, iterable);
            }
            return listReplaceValues;
        }
    }

    static SetMultimap setMultimap(SetMultimap setMultimap, Object obj) {
        return ((setMultimap instanceof SynchronizedSetMultimap) || (setMultimap instanceof BaseImmutableMultimap)) ? setMultimap : new SynchronizedSetMultimap(setMultimap, obj);
    }

    static class SynchronizedSetMultimap extends SynchronizedMultimap implements SetMultimap {
        private static final long serialVersionUID = 0;
        transient Set entrySet;

        SynchronizedSetMultimap(SetMultimap setMultimap, Object obj) {
            super(setMultimap, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public SetMultimap delegate() {
            return (SetMultimap) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set get(Object obj) {
            Set set;
            synchronized (this.mutex) {
                set = Synchronized.set(delegate().get((SetMultimap) obj), this.mutex);
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set removeAll(Object obj) {
            Set setRemoveAll;
            synchronized (this.mutex) {
                setRemoveAll = delegate().removeAll(obj);
            }
            return setRemoveAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set replaceValues(Object obj, Iterable iterable) {
            Set setReplaceValues;
            synchronized (this.mutex) {
                setReplaceValues = delegate().replaceValues((SetMultimap) obj, iterable);
            }
            return setReplaceValues;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public Set entries() {
            Set set;
            synchronized (this.mutex) {
                try {
                    if (this.entrySet == null) {
                        this.entrySet = Synchronized.set(delegate().entries(), this.mutex);
                    }
                    set = this.entrySet;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }
    }

    static SortedSetMultimap sortedSetMultimap(SortedSetMultimap sortedSetMultimap, Object obj) {
        return sortedSetMultimap instanceof SynchronizedSortedSetMultimap ? sortedSetMultimap : new SynchronizedSortedSetMultimap(sortedSetMultimap, obj);
    }

    static final class SynchronizedSortedSetMultimap extends SynchronizedSetMultimap implements SortedSetMultimap {
        private static final long serialVersionUID = 0;

        SynchronizedSortedSetMultimap(SortedSetMultimap sortedSetMultimap, Object obj) {
            super(sortedSetMultimap, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        public SortedSetMultimap delegate() {
            return (SortedSetMultimap) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet get(Object obj) {
            SortedSet sortedSet;
            synchronized (this.mutex) {
                sortedSet = Synchronized.sortedSet(delegate().get((SortedSetMultimap) obj), this.mutex);
            }
            return sortedSet;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet removeAll(Object obj) {
            SortedSet sortedSetRemoveAll;
            synchronized (this.mutex) {
                sortedSetRemoveAll = delegate().removeAll(obj);
            }
            return sortedSetRemoveAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public SortedSet replaceValues(Object obj, Iterable iterable) {
            SortedSet sortedSetReplaceValues;
            synchronized (this.mutex) {
                sortedSetReplaceValues = delegate().replaceValues((SortedSetMultimap) obj, iterable);
            }
            return sortedSetReplaceValues;
        }

        @Override // com.google.common.collect.SortedSetMultimap
        public Comparator valueComparator() {
            Comparator comparatorValueComparator;
            synchronized (this.mutex) {
                comparatorValueComparator = delegate().valueComparator();
            }
            return comparatorValueComparator;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection typePreservingCollection(Collection collection, Object obj) {
        if (collection instanceof SortedSet) {
            return sortedSet((SortedSet) collection, obj);
        }
        if (collection instanceof Set) {
            return set((Set) collection, obj);
        }
        if (collection instanceof List) {
            return list((List) collection, obj);
        }
        return collection(collection, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Set typePreservingSet(Set set, Object obj) {
        if (set instanceof SortedSet) {
            return sortedSet((SortedSet) set, obj);
        }
        return set(set, obj);
    }

    static final class SynchronizedAsMapEntries extends SynchronizedSet {
        private static final long serialVersionUID = 0;

        SynchronizedAsMapEntries(Set set, Object obj) {
            super(set, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new TransformedIterator(super.iterator()) { // from class: com.google.common.collect.Synchronized.SynchronizedAsMapEntries.1
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.google.common.collect.TransformedIterator
                public Map.Entry transform(final Map.Entry entry) {
                    return new ForwardingMapEntry() { // from class: com.google.common.collect.Synchronized.SynchronizedAsMapEntries.1.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
                        public Map.Entry delegate() {
                            return entry;
                        }

                        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                        public Collection getValue() {
                            return Synchronized.typePreservingCollection((Collection) entry.getValue(), SynchronizedAsMapEntries.this.mutex);
                        }
                    };
                }
            };
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] arrayImpl;
            synchronized (this.mutex) {
                arrayImpl = ObjectArrays.toArrayImpl(delegate());
            }
            return arrayImpl;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public Object[] toArray(Object[] objArr) {
            Object[] arrayImpl;
            synchronized (this.mutex) {
                arrayImpl = ObjectArrays.toArrayImpl(delegate(), objArr);
            }
            return arrayImpl;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            boolean zContainsEntryImpl;
            synchronized (this.mutex) {
                zContainsEntryImpl = Maps.containsEntryImpl(delegate(), obj);
            }
            return zContainsEntryImpl;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            boolean zContainsAllImpl;
            synchronized (this.mutex) {
                zContainsAllImpl = Collections2.containsAllImpl(delegate(), collection);
            }
            return zContainsAllImpl;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            boolean zEqualsImpl;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                zEqualsImpl = Sets.equalsImpl(delegate(), obj);
            }
            return zEqualsImpl;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean zRemoveEntryImpl;
            synchronized (this.mutex) {
                zRemoveEntryImpl = Maps.removeEntryImpl(delegate(), obj);
            }
            return zRemoveEntryImpl;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            boolean zRemoveAll;
            synchronized (this.mutex) {
                zRemoveAll = Iterators.removeAll(delegate().iterator(), collection);
            }
            return zRemoveAll;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            boolean zRetainAll;
            synchronized (this.mutex) {
                zRetainAll = Iterators.retainAll(delegate().iterator(), collection);
            }
            return zRetainAll;
        }
    }

    static Map map(Map map, Object obj) {
        return new SynchronizedMap(map, obj);
    }

    static class SynchronizedMap extends SynchronizedObject implements Map {
        private static final long serialVersionUID = 0;
        transient Set entrySet;
        transient Set keySet;
        transient Collection values;

        SynchronizedMap(Map map, Object obj) {
            super(map, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        Map delegate() {
            return (Map) super.delegate();
        }

        @Override // java.util.Map
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            boolean zContainsKey;
            synchronized (this.mutex) {
                zContainsKey = delegate().containsKey(obj);
            }
            return zContainsKey;
        }

        public boolean containsValue(Object obj) {
            boolean zContainsValue;
            synchronized (this.mutex) {
                zContainsValue = delegate().containsValue(obj);
            }
            return zContainsValue;
        }

        public Set entrySet() {
            Set set;
            synchronized (this.mutex) {
                try {
                    if (this.entrySet == null) {
                        this.entrySet = Synchronized.set(delegate().entrySet(), this.mutex);
                    }
                    set = this.entrySet;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        public Object get(Object obj) {
            Object obj2;
            synchronized (this.mutex) {
                obj2 = delegate().get(obj);
            }
            return obj2;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.mutex) {
                zIsEmpty = delegate().isEmpty();
            }
            return zIsEmpty;
        }

        @Override // java.util.Map
        public Set keySet() {
            Set set;
            synchronized (this.mutex) {
                try {
                    if (this.keySet == null) {
                        this.keySet = Synchronized.set(delegate().keySet(), this.mutex);
                    }
                    set = this.keySet;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // java.util.Map
        public Object put(Object obj, Object obj2) {
            Object objPut;
            synchronized (this.mutex) {
                objPut = delegate().put(obj, obj2);
            }
            return objPut;
        }

        @Override // java.util.Map
        public void putAll(Map map) {
            synchronized (this.mutex) {
                delegate().putAll(map);
            }
        }

        @Override // java.util.Map
        public Object remove(Object obj) {
            Object objRemove;
            synchronized (this.mutex) {
                objRemove = delegate().remove(obj);
            }
            return objRemove;
        }

        @Override // java.util.Map
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        public Collection values() {
            Collection collection;
            synchronized (this.mutex) {
                try {
                    if (this.values == null) {
                        this.values = Synchronized.collection(delegate().values(), this.mutex);
                    }
                    collection = this.values;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                zEquals = delegate().equals(obj);
            }
            return zEquals;
        }

        @Override // java.util.Map
        public int hashCode() {
            int iHashCode;
            synchronized (this.mutex) {
                iHashCode = delegate().hashCode();
            }
            return iHashCode;
        }
    }

    static class SynchronizedSortedMap extends SynchronizedMap implements SortedMap {
        private static final long serialVersionUID = 0;

        SynchronizedSortedMap(SortedMap sortedMap, Object obj) {
            super(sortedMap, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        SortedMap delegate() {
            return (SortedMap) super.delegate();
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            Comparator comparator;
            synchronized (this.mutex) {
                comparator = delegate().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            Object objFirstKey;
            synchronized (this.mutex) {
                objFirstKey = delegate().firstKey();
            }
            return objFirstKey;
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            Object objLastKey;
            synchronized (this.mutex) {
                objLastKey = delegate().lastKey();
            }
            return objLastKey;
        }
    }

    static BiMap biMap(BiMap biMap, Object obj) {
        if ((biMap instanceof SynchronizedBiMap) || (biMap instanceof ImmutableBiMap)) {
            return biMap;
        }
        return new SynchronizedBiMap(biMap, obj, null);
    }

    static final class SynchronizedBiMap extends SynchronizedMap implements BiMap, Serializable {
        private static final long serialVersionUID = 0;
        private transient BiMap inverse;
        private transient Set valueSet;

        private SynchronizedBiMap(BiMap biMap, Object obj, BiMap biMap2) {
            super(biMap, obj);
            this.inverse = biMap2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public BiMap delegate() {
            return (BiMap) super.delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set values() {
            Set set;
            synchronized (this.mutex) {
                try {
                    if (this.valueSet == null) {
                        this.valueSet = Synchronized.set(delegate().values(), this.mutex);
                    }
                    set = this.valueSet;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.BiMap
        public Object forcePut(Object obj, Object obj2) {
            Object objForcePut;
            synchronized (this.mutex) {
                objForcePut = delegate().forcePut(obj, obj2);
            }
            return objForcePut;
        }

        @Override // com.google.common.collect.BiMap
        public BiMap inverse() {
            BiMap biMap;
            synchronized (this.mutex) {
                try {
                    if (this.inverse == null) {
                        this.inverse = new SynchronizedBiMap(delegate().inverse(), this.mutex, this);
                    }
                    biMap = this.inverse;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return biMap;
        }
    }

    static final class SynchronizedAsMap extends SynchronizedMap {
        private static final long serialVersionUID = 0;
        transient Set asMapEntrySet;
        transient Collection asMapValues;

        SynchronizedAsMap(Map map, Object obj) {
            super(map, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection get(Object obj) {
            Collection collectionTypePreservingCollection;
            synchronized (this.mutex) {
                Collection collection = (Collection) super.get(obj);
                collectionTypePreservingCollection = collection == null ? null : Synchronized.typePreservingCollection(collection, this.mutex);
            }
            return collectionTypePreservingCollection;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set entrySet() {
            Set set;
            synchronized (this.mutex) {
                try {
                    if (this.asMapEntrySet == null) {
                        this.asMapEntrySet = new SynchronizedAsMapEntries(delegate().entrySet(), this.mutex);
                    }
                    set = this.asMapEntrySet;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection values() {
            Collection collection;
            synchronized (this.mutex) {
                try {
                    if (this.asMapValues == null) {
                        this.asMapValues = new SynchronizedAsMapValues(delegate().values(), this.mutex);
                    }
                    collection = this.asMapValues;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public boolean containsValue(Object obj) {
            return values().contains(obj);
        }
    }

    static final class SynchronizedAsMapValues extends SynchronizedCollection {
        private static final long serialVersionUID = 0;

        SynchronizedAsMapValues(Collection collection, Object obj) {
            super(collection, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new TransformedIterator(super.iterator()) { // from class: com.google.common.collect.Synchronized.SynchronizedAsMapValues.1
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.google.common.collect.TransformedIterator
                public Collection transform(Collection collection) {
                    return Synchronized.typePreservingCollection(collection, SynchronizedAsMapValues.this.mutex);
                }
            };
        }
    }

    static final class SynchronizedNavigableSet extends SynchronizedSortedSet implements NavigableSet {
        private static final long serialVersionUID = 0;
        transient NavigableSet descendingSet;

        SynchronizedNavigableSet(NavigableSet navigableSet, Object obj) {
            super(navigableSet, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public NavigableSet delegate() {
            return (NavigableSet) super.delegate();
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            Object objCeiling;
            synchronized (this.mutex) {
                objCeiling = delegate().ceiling(obj);
            }
            return objCeiling;
        }

        @Override // java.util.NavigableSet
        public Iterator descendingIterator() {
            return delegate().descendingIterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet descendingSet() {
            synchronized (this.mutex) {
                try {
                    NavigableSet navigableSet = this.descendingSet;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    NavigableSet navigableSet2 = Synchronized.navigableSet(delegate().descendingSet(), this.mutex);
                    this.descendingSet = navigableSet2;
                    return navigableSet2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            Object objFloor;
            synchronized (this.mutex) {
                objFloor = delegate().floor(obj);
            }
            return objFloor;
        }

        @Override // java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z) {
            NavigableSet navigableSet;
            synchronized (this.mutex) {
                navigableSet = Synchronized.navigableSet(delegate().headSet(obj, z), this.mutex);
            }
            return navigableSet;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            Object objHigher;
            synchronized (this.mutex) {
                objHigher = delegate().higher(obj);
            }
            return objHigher;
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            Object objLower;
            synchronized (this.mutex) {
                objLower = delegate().lower(obj);
            }
            return objLower;
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            Object objPollFirst;
            synchronized (this.mutex) {
                objPollFirst = delegate().pollFirst();
            }
            return objPollFirst;
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            Object objPollLast;
            synchronized (this.mutex) {
                objPollLast = delegate().pollLast();
            }
            return objPollLast;
        }

        @Override // java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
            NavigableSet navigableSet;
            synchronized (this.mutex) {
                navigableSet = Synchronized.navigableSet(delegate().subSet(obj, z, obj2, z2), this.mutex);
            }
            return navigableSet;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z) {
            NavigableSet navigableSet;
            synchronized (this.mutex) {
                navigableSet = Synchronized.navigableSet(delegate().tailSet(obj, z), this.mutex);
            }
            return navigableSet;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet tailSet(Object obj) {
            return tailSet(obj, true);
        }
    }

    static NavigableSet navigableSet(NavigableSet navigableSet, Object obj) {
        return new SynchronizedNavigableSet(navigableSet, obj);
    }

    static NavigableSet navigableSet(NavigableSet navigableSet) {
        return navigableSet(navigableSet, null);
    }

    static NavigableMap navigableMap(NavigableMap navigableMap) {
        return navigableMap(navigableMap, null);
    }

    static NavigableMap navigableMap(NavigableMap navigableMap, Object obj) {
        return new SynchronizedNavigableMap(navigableMap, obj);
    }

    static final class SynchronizedNavigableMap extends SynchronizedSortedMap implements NavigableMap {
        private static final long serialVersionUID = 0;
        transient NavigableSet descendingKeySet;
        transient NavigableMap descendingMap;
        transient NavigableSet navigableKeySet;

        SynchronizedNavigableMap(NavigableMap navigableMap, Object obj) {
            super(navigableMap, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        public NavigableMap delegate() {
            return (NavigableMap) super.delegate();
        }

        @Override // java.util.NavigableMap
        public Map.Entry ceilingEntry(Object obj) {
            Map.Entry entryNullableSynchronizedEntry;
            synchronized (this.mutex) {
                entryNullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().ceilingEntry(obj), this.mutex);
            }
            return entryNullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public Object ceilingKey(Object obj) {
            Object objCeilingKey;
            synchronized (this.mutex) {
                objCeilingKey = delegate().ceilingKey(obj);
            }
            return objCeilingKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet descendingKeySet() {
            synchronized (this.mutex) {
                try {
                    NavigableSet navigableSet = this.descendingKeySet;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    NavigableSet navigableSet2 = Synchronized.navigableSet(delegate().descendingKeySet(), this.mutex);
                    this.descendingKeySet = navigableSet2;
                    return navigableSet2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableMap
        public NavigableMap descendingMap() {
            synchronized (this.mutex) {
                try {
                    NavigableMap navigableMap = this.descendingMap;
                    if (navigableMap != null) {
                        return navigableMap;
                    }
                    NavigableMap navigableMap2 = Synchronized.navigableMap(delegate().descendingMap(), this.mutex);
                    this.descendingMap = navigableMap2;
                    return navigableMap2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry firstEntry() {
            Map.Entry entryNullableSynchronizedEntry;
            synchronized (this.mutex) {
                entryNullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().firstEntry(), this.mutex);
            }
            return entryNullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public Map.Entry floorEntry(Object obj) {
            Map.Entry entryNullableSynchronizedEntry;
            synchronized (this.mutex) {
                entryNullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().floorEntry(obj), this.mutex);
            }
            return entryNullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public Object floorKey(Object obj) {
            Object objFloorKey;
            synchronized (this.mutex) {
                objFloorKey = delegate().floorKey(obj);
            }
            return objFloorKey;
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z) {
            NavigableMap navigableMap;
            synchronized (this.mutex) {
                navigableMap = Synchronized.navigableMap(delegate().headMap(obj, z), this.mutex);
            }
            return navigableMap;
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry higherEntry(Object obj) {
            Map.Entry entryNullableSynchronizedEntry;
            synchronized (this.mutex) {
                entryNullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().higherEntry(obj), this.mutex);
            }
            return entryNullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public Object higherKey(Object obj) {
            Object objHigherKey;
            synchronized (this.mutex) {
                objHigherKey = delegate().higherKey(obj);
            }
            return objHigherKey;
        }

        @Override // java.util.NavigableMap
        public Map.Entry lastEntry() {
            Map.Entry entryNullableSynchronizedEntry;
            synchronized (this.mutex) {
                entryNullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().lastEntry(), this.mutex);
            }
            return entryNullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public Map.Entry lowerEntry(Object obj) {
            Map.Entry entryNullableSynchronizedEntry;
            synchronized (this.mutex) {
                entryNullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().lowerEntry(obj), this.mutex);
            }
            return entryNullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public Object lowerKey(Object obj) {
            Object objLowerKey;
            synchronized (this.mutex) {
                objLowerKey = delegate().lowerKey(obj);
            }
            return objLowerKey;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            synchronized (this.mutex) {
                try {
                    NavigableSet navigableSet = this.navigableKeySet;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    NavigableSet navigableSet2 = Synchronized.navigableSet(delegate().navigableKeySet(), this.mutex);
                    this.navigableKeySet = navigableSet2;
                    return navigableSet2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollFirstEntry() {
            Map.Entry entryNullableSynchronizedEntry;
            synchronized (this.mutex) {
                entryNullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().pollFirstEntry(), this.mutex);
            }
            return entryNullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollLastEntry() {
            Map.Entry entryNullableSynchronizedEntry;
            synchronized (this.mutex) {
                entryNullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().pollLastEntry(), this.mutex);
            }
            return entryNullableSynchronizedEntry;
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            NavigableMap navigableMap;
            synchronized (this.mutex) {
                navigableMap = Synchronized.navigableMap(delegate().subMap(obj, z, obj2, z2), this.mutex);
            }
            return navigableMap;
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z) {
            NavigableMap navigableMap;
            synchronized (this.mutex) {
                navigableMap = Synchronized.navigableMap(delegate().tailMap(obj, z), this.mutex);
            }
            return navigableMap;
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map.Entry nullableSynchronizedEntry(Map.Entry entry, Object obj) {
        if (entry == null) {
            return null;
        }
        return new SynchronizedEntry(entry, obj);
    }

    static final class SynchronizedEntry extends SynchronizedObject implements Map.Entry {
        private static final long serialVersionUID = 0;

        SynchronizedEntry(Map.Entry entry, Object obj) {
            super(entry, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        Map.Entry delegate() {
            return (Map.Entry) super.delegate();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            boolean zEquals;
            synchronized (this.mutex) {
                zEquals = delegate().equals(obj);
            }
            return zEquals;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int iHashCode;
            synchronized (this.mutex) {
                iHashCode = delegate().hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            Object key;
            synchronized (this.mutex) {
                key = delegate().getKey();
            }
            return key;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            Object value;
            synchronized (this.mutex) {
                value = delegate().getValue();
            }
            return value;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object value;
            synchronized (this.mutex) {
                value = delegate().setValue(obj);
            }
            return value;
        }
    }

    static Queue queue(Queue queue, Object obj) {
        return queue instanceof SynchronizedQueue ? queue : new SynchronizedQueue(queue, obj);
    }

    static class SynchronizedQueue extends SynchronizedCollection implements Queue {
        private static final long serialVersionUID = 0;

        SynchronizedQueue(Queue queue, Object obj) {
            super(queue, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Queue delegate() {
            return (Queue) super.delegate();
        }

        @Override // java.util.Queue
        public Object element() {
            Object objElement;
            synchronized (this.mutex) {
                objElement = delegate().element();
            }
            return objElement;
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            boolean zOffer;
            synchronized (this.mutex) {
                zOffer = delegate().offer(obj);
            }
            return zOffer;
        }

        @Override // java.util.Queue
        public Object peek() {
            Object objPeek;
            synchronized (this.mutex) {
                objPeek = delegate().peek();
            }
            return objPeek;
        }

        @Override // java.util.Queue
        public Object poll() {
            Object objPoll;
            synchronized (this.mutex) {
                objPoll = delegate().poll();
            }
            return objPoll;
        }

        @Override // java.util.Queue
        public Object remove() {
            Object objRemove;
            synchronized (this.mutex) {
                objRemove = delegate().remove();
            }
            return objRemove;
        }
    }

    static Deque deque(Deque deque, Object obj) {
        return new SynchronizedDeque(deque, obj);
    }

    static final class SynchronizedDeque extends SynchronizedQueue implements Deque {
        private static final long serialVersionUID = 0;

        SynchronizedDeque(Deque deque, Object obj) {
            super(deque, obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        public Deque delegate() {
            return (Deque) super.delegate();
        }

        @Override // java.util.Deque
        public void addFirst(Object obj) {
            synchronized (this.mutex) {
                delegate().addFirst(obj);
            }
        }

        @Override // java.util.Deque
        public void addLast(Object obj) {
            synchronized (this.mutex) {
                delegate().addLast(obj);
            }
        }

        @Override // java.util.Deque
        public boolean offerFirst(Object obj) {
            boolean zOfferFirst;
            synchronized (this.mutex) {
                zOfferFirst = delegate().offerFirst(obj);
            }
            return zOfferFirst;
        }

        @Override // java.util.Deque
        public boolean offerLast(Object obj) {
            boolean zOfferLast;
            synchronized (this.mutex) {
                zOfferLast = delegate().offerLast(obj);
            }
            return zOfferLast;
        }

        @Override // java.util.Deque
        public Object removeFirst() {
            Object objRemoveFirst;
            synchronized (this.mutex) {
                objRemoveFirst = delegate().removeFirst();
            }
            return objRemoveFirst;
        }

        @Override // java.util.Deque
        public Object removeLast() {
            Object objRemoveLast;
            synchronized (this.mutex) {
                objRemoveLast = delegate().removeLast();
            }
            return objRemoveLast;
        }

        @Override // java.util.Deque
        public Object pollFirst() {
            Object objPollFirst;
            synchronized (this.mutex) {
                objPollFirst = delegate().pollFirst();
            }
            return objPollFirst;
        }

        @Override // java.util.Deque
        public Object pollLast() {
            Object objPollLast;
            synchronized (this.mutex) {
                objPollLast = delegate().pollLast();
            }
            return objPollLast;
        }

        @Override // java.util.Deque
        public Object getFirst() {
            Object first;
            synchronized (this.mutex) {
                first = delegate().getFirst();
            }
            return first;
        }

        @Override // java.util.Deque
        public Object getLast() {
            Object last;
            synchronized (this.mutex) {
                last = delegate().getLast();
            }
            return last;
        }

        @Override // java.util.Deque
        public Object peekFirst() {
            Object objPeekFirst;
            synchronized (this.mutex) {
                objPeekFirst = delegate().peekFirst();
            }
            return objPeekFirst;
        }

        @Override // java.util.Deque
        public Object peekLast() {
            Object objPeekLast;
            synchronized (this.mutex) {
                objPeekLast = delegate().peekLast();
            }
            return objPeekLast;
        }

        @Override // java.util.Deque
        public boolean removeFirstOccurrence(Object obj) {
            boolean zRemoveFirstOccurrence;
            synchronized (this.mutex) {
                zRemoveFirstOccurrence = delegate().removeFirstOccurrence(obj);
            }
            return zRemoveFirstOccurrence;
        }

        @Override // java.util.Deque
        public boolean removeLastOccurrence(Object obj) {
            boolean zRemoveLastOccurrence;
            synchronized (this.mutex) {
                zRemoveLastOccurrence = delegate().removeLastOccurrence(obj);
            }
            return zRemoveLastOccurrence;
        }

        @Override // java.util.Deque
        public void push(Object obj) {
            synchronized (this.mutex) {
                delegate().push(obj);
            }
        }

        @Override // java.util.Deque
        public Object pop() {
            Object objPop;
            synchronized (this.mutex) {
                objPop = delegate().pop();
            }
            return objPop;
        }

        @Override // java.util.Deque
        public Iterator descendingIterator() {
            Iterator itDescendingIterator;
            synchronized (this.mutex) {
                itDescendingIterator = delegate().descendingIterator();
            }
            return itDescendingIterator;
        }
    }

    static Table table(Table table, Object obj) {
        return new SynchronizedTable(table, obj);
    }

    static final class SynchronizedTable extends SynchronizedObject implements Table {
        SynchronizedTable(Table table, Object obj) {
            super(table, obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        Table delegate() {
            return (Table) super.delegate();
        }

        @Override // com.google.common.collect.Table
        public boolean contains(Object obj, Object obj2) {
            boolean zContains;
            synchronized (this.mutex) {
                zContains = delegate().contains(obj, obj2);
            }
            return zContains;
        }

        @Override // com.google.common.collect.Table
        public boolean containsRow(Object obj) {
            boolean zContainsRow;
            synchronized (this.mutex) {
                zContainsRow = delegate().containsRow(obj);
            }
            return zContainsRow;
        }

        @Override // com.google.common.collect.Table
        public boolean containsColumn(Object obj) {
            boolean zContainsColumn;
            synchronized (this.mutex) {
                zContainsColumn = delegate().containsColumn(obj);
            }
            return zContainsColumn;
        }

        @Override // com.google.common.collect.Table
        public boolean containsValue(Object obj) {
            boolean zContainsValue;
            synchronized (this.mutex) {
                zContainsValue = delegate().containsValue(obj);
            }
            return zContainsValue;
        }

        @Override // com.google.common.collect.Table
        public Object get(Object obj, Object obj2) {
            Object obj3;
            synchronized (this.mutex) {
                obj3 = delegate().get(obj, obj2);
            }
            return obj3;
        }

        @Override // com.google.common.collect.Table
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.mutex) {
                zIsEmpty = delegate().isEmpty();
            }
            return zIsEmpty;
        }

        @Override // com.google.common.collect.Table
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        @Override // com.google.common.collect.Table
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // com.google.common.collect.Table
        public Object put(Object obj, Object obj2, Object obj3) {
            Object objPut;
            synchronized (this.mutex) {
                objPut = delegate().put(obj, obj2, obj3);
            }
            return objPut;
        }

        @Override // com.google.common.collect.Table
        public void putAll(Table table) {
            synchronized (this.mutex) {
                delegate().putAll(table);
            }
        }

        @Override // com.google.common.collect.Table
        public Object remove(Object obj, Object obj2) {
            Object objRemove;
            synchronized (this.mutex) {
                objRemove = delegate().remove(obj, obj2);
            }
            return objRemove;
        }

        @Override // com.google.common.collect.Table
        public Map row(Object obj) {
            Map map;
            synchronized (this.mutex) {
                map = Synchronized.map(delegate().row(obj), this.mutex);
            }
            return map;
        }

        @Override // com.google.common.collect.Table
        public Map column(Object obj) {
            Map map;
            synchronized (this.mutex) {
                map = Synchronized.map(delegate().column(obj), this.mutex);
            }
            return map;
        }

        @Override // com.google.common.collect.Table
        public Set cellSet() {
            Set set;
            synchronized (this.mutex) {
                set = Synchronized.set(delegate().cellSet(), this.mutex);
            }
            return set;
        }

        @Override // com.google.common.collect.Table
        public Set rowKeySet() {
            Set set;
            synchronized (this.mutex) {
                set = Synchronized.set(delegate().rowKeySet(), this.mutex);
            }
            return set;
        }

        @Override // com.google.common.collect.Table
        public Set columnKeySet() {
            Set set;
            synchronized (this.mutex) {
                set = Synchronized.set(delegate().columnKeySet(), this.mutex);
            }
            return set;
        }

        @Override // com.google.common.collect.Table
        public Collection values() {
            Collection collection;
            synchronized (this.mutex) {
                collection = Synchronized.collection(delegate().values(), this.mutex);
            }
            return collection;
        }

        @Override // com.google.common.collect.Table
        public Map rowMap() {
            Map map;
            synchronized (this.mutex) {
                map = Synchronized.map(Maps.transformValues(delegate().rowMap(), new Function() { // from class: com.google.common.collect.Synchronized.SynchronizedTable.1
                    @Override // com.google.common.base.Function
                    public Map apply(Map map2) {
                        return Synchronized.map(map2, SynchronizedTable.this.mutex);
                    }
                }), this.mutex);
            }
            return map;
        }

        @Override // com.google.common.collect.Table
        public Map columnMap() {
            Map map;
            synchronized (this.mutex) {
                map = Synchronized.map(Maps.transformValues(delegate().columnMap(), new Function() { // from class: com.google.common.collect.Synchronized.SynchronizedTable.2
                    @Override // com.google.common.base.Function
                    public Map apply(Map map2) {
                        return Synchronized.map(map2, SynchronizedTable.this.mutex);
                    }
                }), this.mutex);
            }
            return map;
        }

        @Override // com.google.common.collect.Table
        public int hashCode() {
            int iHashCode;
            synchronized (this.mutex) {
                iHashCode = delegate().hashCode();
            }
            return iHashCode;
        }

        @Override // com.google.common.collect.Table
        public boolean equals(Object obj) {
            boolean zEquals;
            if (this == obj) {
                return true;
            }
            synchronized (this.mutex) {
                zEquals = delegate().equals(obj);
            }
            return zEquals;
        }
    }
}
