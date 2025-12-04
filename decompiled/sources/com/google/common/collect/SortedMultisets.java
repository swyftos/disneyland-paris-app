package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* loaded from: classes4.dex */
abstract class SortedMultisets {

    static class ElementSet extends Multisets.ElementSet implements SortedSet {
        private final SortedMultiset multiset;

        ElementSet(SortedMultiset sortedMultiset) {
            this.multiset = sortedMultiset;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Multisets.ElementSet
        public final SortedMultiset multiset() {
            return this.multiset;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Object> iterator() {
            return Multisets.elementIterator(multiset().entrySet().iterator());
        }

        @Override // java.util.SortedSet
        public Comparator<Object> comparator() {
            return multiset().comparator();
        }

        @Override // java.util.SortedSet
        public SortedSet<Object> subSet(Object obj, Object obj2) {
            return multiset().subMultiset(obj, BoundType.CLOSED, obj2, BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public SortedSet<Object> headSet(Object obj) {
            return multiset().headMultiset(obj, BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public SortedSet<Object> tailSet(Object obj) {
            return multiset().tailMultiset(obj, BoundType.CLOSED).elementSet();
        }

        @Override // java.util.SortedSet
        public Object first() {
            return SortedMultisets.getElementOrThrow(multiset().firstEntry());
        }

        @Override // java.util.SortedSet
        public Object last() {
            return SortedMultisets.getElementOrThrow(multiset().lastEntry());
        }
    }

    static class NavigableElementSet extends ElementSet implements NavigableSet {
        NavigableElementSet(SortedMultiset sortedMultiset) {
            super(sortedMultiset);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public Object lower(Object obj) {
            return SortedMultisets.getElementOrNull(multiset().headMultiset(obj, BoundType.OPEN).lastEntry());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public Object floor(Object obj) {
            return SortedMultisets.getElementOrNull(multiset().headMultiset(obj, BoundType.CLOSED).lastEntry());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public Object ceiling(Object obj) {
            return SortedMultisets.getElementOrNull(multiset().tailMultiset(obj, BoundType.CLOSED).firstEntry());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public Object higher(Object obj) {
            return SortedMultisets.getElementOrNull(multiset().tailMultiset(obj, BoundType.OPEN).firstEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<Object> descendingSet() {
            return new NavigableElementSet(multiset().descendingMultiset());
        }

        @Override // java.util.NavigableSet
        public Iterator<Object> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public Object pollFirst() {
            return SortedMultisets.getElementOrNull(multiset().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public Object pollLast() {
            return SortedMultisets.getElementOrNull(multiset().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<Object> subSet(Object obj, boolean z, Object obj2, boolean z2) {
            return new NavigableElementSet(multiset().subMultiset(obj, BoundType.forBoolean(z), obj2, BoundType.forBoolean(z2)));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<Object> headSet(Object obj, boolean z) {
            return new NavigableElementSet(multiset().headMultiset(obj, BoundType.forBoolean(z)));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<Object> tailSet(Object obj, boolean z) {
            return new NavigableElementSet(multiset().tailMultiset(obj, BoundType.forBoolean(z)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getElementOrThrow(Multiset.Entry entry) {
        if (entry == null) {
            throw new NoSuchElementException();
        }
        return entry.getElement();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getElementOrNull(Multiset.Entry entry) {
        if (entry == null) {
            return null;
        }
        return entry.getElement();
    }
}
