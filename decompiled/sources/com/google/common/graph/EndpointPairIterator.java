package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes4.dex */
abstract class EndpointPairIterator extends AbstractIterator {
    private final BaseGraph graph;
    Object node;
    private final Iterator nodeIterator;
    Iterator successorIterator;

    static EndpointPairIterator of(BaseGraph baseGraph) {
        return baseGraph.isDirected() ? new Directed(baseGraph) : new Undirected(baseGraph);
    }

    private EndpointPairIterator(BaseGraph baseGraph) {
        this.node = null;
        this.successorIterator = ImmutableSet.of().iterator();
        this.graph = baseGraph;
        this.nodeIterator = baseGraph.nodes().iterator();
    }

    final boolean advance() {
        Preconditions.checkState(!this.successorIterator.hasNext());
        if (!this.nodeIterator.hasNext()) {
            return false;
        }
        Object next = this.nodeIterator.next();
        this.node = next;
        this.successorIterator = this.graph.successors(next).iterator();
        return true;
    }

    private static final class Directed extends EndpointPairIterator {
        private Directed(BaseGraph baseGraph) {
            super(baseGraph);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        public EndpointPair computeNext() {
            while (!this.successorIterator.hasNext()) {
                if (!advance()) {
                    return (EndpointPair) endOfData();
                }
            }
            Object obj = this.node;
            Objects.requireNonNull(obj);
            return EndpointPair.ordered(obj, this.successorIterator.next());
        }
    }

    private static final class Undirected extends EndpointPairIterator {
        private Set visitedNodes;

        private Undirected(BaseGraph baseGraph) {
            super(baseGraph);
            this.visitedNodes = Sets.newHashSetWithExpectedSize(baseGraph.nodes().size() + 1);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        public EndpointPair computeNext() {
            do {
                Objects.requireNonNull(this.visitedNodes);
                while (this.successorIterator.hasNext()) {
                    Object next = this.successorIterator.next();
                    if (!this.visitedNodes.contains(next)) {
                        Object obj = this.node;
                        Objects.requireNonNull(obj);
                        return EndpointPair.unordered(obj, next);
                    }
                }
                this.visitedNodes.add(this.node);
            } while (advance());
            this.visitedNodes = null;
            return (EndpointPair) endOfData();
        }
    }
}
