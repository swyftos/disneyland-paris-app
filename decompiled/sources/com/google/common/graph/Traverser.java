package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.DoNotMock;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

@DoNotMock("Call forGraph or forTree, passing a lambda or a Graph with the desired edges (built with GraphBuilder)")
@Beta
/* loaded from: classes4.dex */
public abstract class Traverser<N> {
    private final SuccessorsFunction successorFunction;

    private enum InsertionOrder {
        FRONT { // from class: com.google.common.graph.Traverser.InsertionOrder.1
            @Override // com.google.common.graph.Traverser.InsertionOrder
            void insertInto(Deque deque, Object obj) {
                deque.addFirst(obj);
            }
        },
        BACK { // from class: com.google.common.graph.Traverser.InsertionOrder.2
            @Override // com.google.common.graph.Traverser.InsertionOrder
            void insertInto(Deque deque, Object obj) {
                deque.addLast(obj);
            }
        };

        abstract void insertInto(Deque deque, Object obj);
    }

    abstract Traversal newTraversal();

    private Traverser(SuccessorsFunction successorsFunction) {
        this.successorFunction = (SuccessorsFunction) Preconditions.checkNotNull(successorsFunction);
    }

    public static <N> Traverser<N> forGraph(final SuccessorsFunction<N> successorsFunction) {
        return new Traverser(successorsFunction) { // from class: com.google.common.graph.Traverser.1
            @Override // com.google.common.graph.Traverser
            Traversal newTraversal() {
                return Traversal.inGraph(successorsFunction);
            }
        };
    }

    public static <N> Traverser<N> forTree(final SuccessorsFunction<N> successorsFunction) {
        if (successorsFunction instanceof BaseGraph) {
            Preconditions.checkArgument(((BaseGraph) successorsFunction).isDirected(), "Undirected graphs can never be trees.");
        }
        if (successorsFunction instanceof Network) {
            Preconditions.checkArgument(((Network) successorsFunction).isDirected(), "Undirected networks can never be trees.");
        }
        return new Traverser(successorsFunction) { // from class: com.google.common.graph.Traverser.2
            @Override // com.google.common.graph.Traverser
            Traversal newTraversal() {
                return Traversal.inTree(successorsFunction);
            }
        };
    }

    public final Iterable<N> breadthFirst(N n) {
        return breadthFirst((Iterable) ImmutableSet.of(n));
    }

    public final Iterable<N> breadthFirst(Iterable<? extends N> iterable) {
        final ImmutableSet immutableSetValidate = validate(iterable);
        return new Iterable() { // from class: com.google.common.graph.Traverser.3
            @Override // java.lang.Iterable
            public Iterator iterator() {
                return Traverser.this.newTraversal().breadthFirst(immutableSetValidate.iterator());
            }
        };
    }

    public final Iterable<N> depthFirstPreOrder(N n) {
        return depthFirstPreOrder((Iterable) ImmutableSet.of(n));
    }

    public final Iterable<N> depthFirstPreOrder(Iterable<? extends N> iterable) {
        final ImmutableSet immutableSetValidate = validate(iterable);
        return new Iterable() { // from class: com.google.common.graph.Traverser.4
            @Override // java.lang.Iterable
            public Iterator iterator() {
                return Traverser.this.newTraversal().preOrder(immutableSetValidate.iterator());
            }
        };
    }

    public final Iterable<N> depthFirstPostOrder(N n) {
        return depthFirstPostOrder((Iterable) ImmutableSet.of(n));
    }

    public final Iterable<N> depthFirstPostOrder(Iterable<? extends N> iterable) {
        final ImmutableSet immutableSetValidate = validate(iterable);
        return new Iterable() { // from class: com.google.common.graph.Traverser.5
            @Override // java.lang.Iterable
            public Iterator iterator() {
                return Traverser.this.newTraversal().postOrder(immutableSetValidate.iterator());
            }
        };
    }

    private ImmutableSet validate(Iterable iterable) {
        ImmutableSet immutableSetCopyOf = ImmutableSet.copyOf(iterable);
        UnmodifiableIterator it = immutableSetCopyOf.iterator();
        while (it.hasNext()) {
            this.successorFunction.successors(it.next());
        }
        return immutableSetCopyOf;
    }

    private static abstract class Traversal {
        final SuccessorsFunction successorFunction;

        abstract Object visitNext(Deque deque);

        Traversal(SuccessorsFunction successorsFunction) {
            this.successorFunction = successorsFunction;
        }

        static Traversal inGraph(SuccessorsFunction successorsFunction) {
            final HashSet hashSet = new HashSet();
            return new Traversal(successorsFunction) { // from class: com.google.common.graph.Traverser.Traversal.1
                @Override // com.google.common.graph.Traverser.Traversal
                Object visitNext(Deque deque) {
                    Iterator it = (Iterator) deque.getFirst();
                    while (it.hasNext()) {
                        Object next = it.next();
                        Objects.requireNonNull(next);
                        if (hashSet.add(next)) {
                            return next;
                        }
                    }
                    deque.removeFirst();
                    return null;
                }
            };
        }

        static Traversal inTree(SuccessorsFunction successorsFunction) {
            return new Traversal(successorsFunction) { // from class: com.google.common.graph.Traverser.Traversal.2
                @Override // com.google.common.graph.Traverser.Traversal
                Object visitNext(Deque deque) {
                    Iterator it = (Iterator) deque.getFirst();
                    if (it.hasNext()) {
                        return Preconditions.checkNotNull(it.next());
                    }
                    deque.removeFirst();
                    return null;
                }
            };
        }

        final Iterator breadthFirst(Iterator it) {
            return topDown(it, InsertionOrder.BACK);
        }

        final Iterator preOrder(Iterator it) {
            return topDown(it, InsertionOrder.FRONT);
        }

        private Iterator topDown(Iterator it, final InsertionOrder insertionOrder) {
            final ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(it);
            return new AbstractIterator() { // from class: com.google.common.graph.Traverser.Traversal.3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.AbstractIterator
                protected Object computeNext() {
                    do {
                        Object objVisitNext = Traversal.this.visitNext(arrayDeque);
                        if (objVisitNext != null) {
                            Iterator it2 = Traversal.this.successorFunction.successors(objVisitNext).iterator();
                            if (it2.hasNext()) {
                                insertionOrder.insertInto(arrayDeque, it2);
                            }
                            return objVisitNext;
                        }
                    } while (!arrayDeque.isEmpty());
                    return endOfData();
                }
            };
        }

        final Iterator postOrder(Iterator it) {
            final ArrayDeque arrayDeque = new ArrayDeque();
            final ArrayDeque arrayDeque2 = new ArrayDeque();
            arrayDeque2.add(it);
            return new AbstractIterator() { // from class: com.google.common.graph.Traverser.Traversal.4
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.AbstractIterator
                protected Object computeNext() {
                    while (true) {
                        Object objVisitNext = Traversal.this.visitNext(arrayDeque2);
                        if (objVisitNext != null) {
                            Iterator it2 = Traversal.this.successorFunction.successors(objVisitNext).iterator();
                            if (!it2.hasNext()) {
                                return objVisitNext;
                            }
                            arrayDeque2.addFirst(it2);
                            arrayDeque.push(objVisitNext);
                        } else {
                            if (!arrayDeque.isEmpty()) {
                                return arrayDeque.pop();
                            }
                            return endOfData();
                        }
                    }
                }
            };
        }
    }
}
