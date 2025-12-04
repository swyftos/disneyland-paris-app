package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

@Beta
@GwtCompatible
@Deprecated
/* loaded from: classes4.dex */
public abstract class TreeTraverser<T> {
    public abstract Iterable<T> children(T t);

    @Deprecated
    public static <T> TreeTraverser<T> using(final Function<T, ? extends Iterable<T>> function) {
        Preconditions.checkNotNull(function);
        return new TreeTraverser() { // from class: com.google.common.collect.TreeTraverser.1
            @Override // com.google.common.collect.TreeTraverser
            public Iterable children(Object obj) {
                return (Iterable) function.apply(obj);
            }
        };
    }

    @Deprecated
    public final FluentIterable<T> preOrderTraversal(final T t) {
        Preconditions.checkNotNull(t);
        return new FluentIterable() { // from class: com.google.common.collect.TreeTraverser.2
            @Override // java.lang.Iterable
            public UnmodifiableIterator iterator() {
                return TreeTraverser.this.preOrderIterator(t);
            }
        };
    }

    UnmodifiableIterator preOrderIterator(Object obj) {
        return new PreOrderIterator(obj);
    }

    private final class PreOrderIterator extends UnmodifiableIterator {
        private final Deque stack;

        PreOrderIterator(Object obj) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.stack = arrayDeque;
            arrayDeque.addLast(Iterators.singletonIterator(Preconditions.checkNotNull(obj)));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.stack.isEmpty();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Iterator
        public Object next() {
            Iterator it = (Iterator) this.stack.getLast();
            Object objCheckNotNull = Preconditions.checkNotNull(it.next());
            if (!it.hasNext()) {
                this.stack.removeLast();
            }
            Iterator<T> it2 = TreeTraverser.this.children(objCheckNotNull).iterator();
            if (it2.hasNext()) {
                this.stack.addLast(it2);
            }
            return objCheckNotNull;
        }
    }

    @Deprecated
    public final FluentIterable<T> postOrderTraversal(final T t) {
        Preconditions.checkNotNull(t);
        return new FluentIterable() { // from class: com.google.common.collect.TreeTraverser.3
            @Override // java.lang.Iterable
            public UnmodifiableIterator iterator() {
                return TreeTraverser.this.postOrderIterator(t);
            }
        };
    }

    UnmodifiableIterator postOrderIterator(Object obj) {
        return new PostOrderIterator(obj);
    }

    private static final class PostOrderNode {
        final Iterator childIterator;
        final Object root;

        PostOrderNode(Object obj, Iterator it) {
            this.root = Preconditions.checkNotNull(obj);
            this.childIterator = (Iterator) Preconditions.checkNotNull(it);
        }
    }

    private final class PostOrderIterator extends AbstractIterator {
        private final ArrayDeque stack;

        PostOrderIterator(Object obj) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.stack = arrayDeque;
            arrayDeque.addLast(expand(obj));
        }

        @Override // com.google.common.collect.AbstractIterator
        protected Object computeNext() {
            while (!this.stack.isEmpty()) {
                PostOrderNode postOrderNode = (PostOrderNode) this.stack.getLast();
                if (postOrderNode.childIterator.hasNext()) {
                    this.stack.addLast(expand(postOrderNode.childIterator.next()));
                } else {
                    this.stack.removeLast();
                    return postOrderNode.root;
                }
            }
            return endOfData();
        }

        private PostOrderNode expand(Object obj) {
            return new PostOrderNode(obj, TreeTraverser.this.children(obj).iterator());
        }
    }

    @Deprecated
    public final FluentIterable<T> breadthFirstTraversal(final T t) {
        Preconditions.checkNotNull(t);
        return new FluentIterable() { // from class: com.google.common.collect.TreeTraverser.4
            @Override // java.lang.Iterable
            public UnmodifiableIterator iterator() {
                return new BreadthFirstIterator(t);
            }
        };
    }

    private final class BreadthFirstIterator extends UnmodifiableIterator implements PeekingIterator {
        private final Queue queue;

        BreadthFirstIterator(Object obj) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.queue = arrayDeque;
            arrayDeque.add(obj);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.queue.isEmpty();
        }

        @Override // com.google.common.collect.PeekingIterator
        public Object peek() {
            return this.queue.element();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Iterator, com.google.common.collect.PeekingIterator
        public Object next() {
            Object objRemove = this.queue.remove();
            Iterables.addAll(this.queue, TreeTraverser.this.children(objRemove));
            return objRemove;
        }
    }
}
