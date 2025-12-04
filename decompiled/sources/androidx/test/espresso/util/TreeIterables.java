package androidx.test.espresso.util;

import android.view.View;
import android.view.ViewGroup;
import androidx.test.espresso.core.internal.deps.guava.base.Function;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.AbstractIterator;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.core.internal.deps.guava.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: classes2.dex */
public final class TreeIterables {
    private static final TreeViewer VIEW_TREE_VIEWER = new ViewTreeViewer();

    static class DistanceRecordingTreeViewer<T> implements TreeViewer<T> {
        private final TreeViewer delegateViewer;
        private final Map nodeToDistance = Maps.newHashMap();
        private final Object root;

        DistanceRecordingTreeViewer(Object obj, TreeViewer treeViewer) {
            this.root = Preconditions.checkNotNull(obj);
            this.delegateViewer = (TreeViewer) Preconditions.checkNotNull(treeViewer);
        }

        @Override // androidx.test.espresso.util.TreeIterables.TreeViewer
        public Collection children(Object obj) {
            if (obj == this.root) {
                this.nodeToDistance.put(obj, 0);
            }
            int distance = getDistance(obj) + 1;
            Collection collectionChildren = this.delegateViewer.children(obj);
            Iterator it = collectionChildren.iterator();
            while (it.hasNext()) {
                this.nodeToDistance.put(it.next(), Integer.valueOf(distance));
            }
            return collectionChildren;
        }

        int getDistance(Object obj) {
            return ((Integer) Preconditions.checkNotNull((Integer) this.nodeToDistance.get(obj), "Never seen %s before", obj)).intValue();
        }
    }

    private enum TraversalStrategy {
        BREADTH_FIRST { // from class: androidx.test.espresso.util.TreeIterables.TraversalStrategy.1
            @Override // androidx.test.espresso.util.TreeIterables.TraversalStrategy
            void combineNewChildren(LinkedList linkedList, Collection collection) {
                linkedList.addAll(collection);
            }
        },
        DEPTH_FIRST { // from class: androidx.test.espresso.util.TreeIterables.TraversalStrategy.2
            @Override // androidx.test.espresso.util.TreeIterables.TraversalStrategy
            void combineNewChildren(LinkedList linkedList, Collection collection) {
                linkedList.addAll(0, collection);
            }
        };

        abstract void combineNewChildren(LinkedList linkedList, Collection collection);

        Object next(LinkedList linkedList) {
            return linkedList.removeFirst();
        }
    }

    private static class TreeTraversalIterable<T> implements Iterable<T> {
        private final Object root;
        private final TraversalStrategy traversalStrategy;
        private final TreeViewer treeViewer;

        private TreeTraversalIterable(Object obj, TraversalStrategy traversalStrategy, TreeViewer treeViewer) {
            this.root = Preconditions.checkNotNull(obj);
            this.traversalStrategy = (TraversalStrategy) Preconditions.checkNotNull(traversalStrategy);
            this.treeViewer = (TreeViewer) Preconditions.checkNotNull(treeViewer);
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            final LinkedList linkedListNewLinkedList = Lists.newLinkedList();
            linkedListNewLinkedList.add(this.root);
            return new AbstractIterator<T>() { // from class: androidx.test.espresso.util.TreeIterables.TreeTraversalIterable.1
                @Override // androidx.test.espresso.core.internal.deps.guava.collect.AbstractIterator
                public Object computeNext() {
                    if (linkedListNewLinkedList.isEmpty()) {
                        return endOfData();
                    }
                    Object objCheckNotNull = Preconditions.checkNotNull(TreeTraversalIterable.this.traversalStrategy.next(linkedListNewLinkedList), "Null items not allowed!");
                    TreeTraversalIterable.this.traversalStrategy.combineNewChildren(linkedListNewLinkedList, TreeTraversalIterable.this.treeViewer.children(objCheckNotNull));
                    return objCheckNotNull;
                }
            };
        }
    }

    interface TreeViewer<T> {
        Collection children(Object obj);
    }

    public static class ViewAndDistance {
        private final int distanceFromRoot;
        private final View view;

        private ViewAndDistance(View view, int i) {
            this.view = view;
            this.distanceFromRoot = i;
        }

        public int getDistanceFromRoot() {
            return this.distanceFromRoot;
        }

        public View getView() {
            return this.view;
        }
    }

    static class ViewTreeViewer implements TreeViewer<View> {
        ViewTreeViewer() {
        }

        @Override // androidx.test.espresso.util.TreeIterables.TreeViewer
        public Collection children(View view) {
            Preconditions.checkNotNull(view);
            if (!(view instanceof ViewGroup)) {
                return Collections.emptyList();
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            ArrayList arrayListNewArrayList = Lists.newArrayList();
            for (int i = 0; i < childCount; i++) {
                arrayListNewArrayList.add(viewGroup.getChildAt(i));
            }
            return arrayListNewArrayList;
        }
    }

    static Iterable breadthFirstTraversal(Object obj, TreeViewer treeViewer) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(treeViewer);
        return new TreeTraversalIterable(obj, TraversalStrategy.BREADTH_FIRST, treeViewer);
    }

    public static Iterable<View> breadthFirstViewTraversal(View view) {
        return breadthFirstTraversal(view, VIEW_TREE_VIEWER);
    }

    static Iterable depthFirstTraversal(Object obj, TreeViewer treeViewer) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(treeViewer);
        return new TreeTraversalIterable(obj, TraversalStrategy.DEPTH_FIRST, treeViewer);
    }

    public static Iterable<View> depthFirstViewTraversal(View view) {
        return depthFirstTraversal(view, VIEW_TREE_VIEWER);
    }

    public static Iterable<ViewAndDistance> depthFirstViewTraversalWithDistance(View view) {
        final DistanceRecordingTreeViewer distanceRecordingTreeViewer = new DistanceRecordingTreeViewer(view, VIEW_TREE_VIEWER);
        return Iterables.transform(depthFirstTraversal(view, distanceRecordingTreeViewer), new Function<View, ViewAndDistance>() { // from class: androidx.test.espresso.util.TreeIterables.1
            @Override // androidx.test.espresso.core.internal.deps.guava.base.Function
            public ViewAndDistance apply(View view2) {
                return new ViewAndDistance(view2, distanceRecordingTreeViewer.getDistance(view2));
            }
        });
    }
}
