package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@Immutable(containerOf = {"N"})
@Beta
/* loaded from: classes4.dex */
public abstract class EndpointPair<N> implements Iterable<N> {
    private final Object nodeU;
    private final Object nodeV;

    public abstract boolean equals(@CheckForNull Object obj);

    public abstract int hashCode();

    public abstract boolean isOrdered();

    public abstract N source();

    public abstract N target();

    private EndpointPair(Object obj, Object obj2) {
        this.nodeU = Preconditions.checkNotNull(obj);
        this.nodeV = Preconditions.checkNotNull(obj2);
    }

    public static <N> EndpointPair<N> ordered(N n, N n2) {
        return new Ordered(n, n2);
    }

    public static <N> EndpointPair<N> unordered(N n, N n2) {
        return new Unordered(n2, n);
    }

    static EndpointPair of(Graph graph, Object obj, Object obj2) {
        return graph.isDirected() ? ordered(obj, obj2) : unordered(obj, obj2);
    }

    static EndpointPair of(Network network, Object obj, Object obj2) {
        return network.isDirected() ? ordered(obj, obj2) : unordered(obj, obj2);
    }

    public final N nodeU() {
        return (N) this.nodeU;
    }

    public final N nodeV() {
        return (N) this.nodeV;
    }

    public final N adjacentNode(N n) {
        if (n.equals(this.nodeU)) {
            return (N) this.nodeV;
        }
        if (n.equals(this.nodeV)) {
            return (N) this.nodeU;
        }
        throw new IllegalArgumentException("EndpointPair " + this + " does not contain node " + n);
    }

    @Override // java.lang.Iterable
    public final UnmodifiableIterator<N> iterator() {
        return Iterators.forArray(this.nodeU, this.nodeV);
    }

    private static final class Ordered extends EndpointPair {
        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return true;
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        private Ordered(Object obj, Object obj2) {
            super(obj, obj2);
        }

        @Override // com.google.common.graph.EndpointPair
        public Object source() {
            return nodeU();
        }

        @Override // com.google.common.graph.EndpointPair
        public Object target() {
            return nodeV();
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (isOrdered() != endpointPair.isOrdered()) {
                return false;
            }
            return source().equals(endpointPair.source()) && target().equals(endpointPair.target());
        }

        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return Objects.hashCode(source(), target());
        }

        public String toString() {
            return "<" + source() + " -> " + target() + ">";
        }
    }

    private static final class Unordered extends EndpointPair {
        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return false;
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        private Unordered(Object obj, Object obj2) {
            super(obj, obj2);
        }

        @Override // com.google.common.graph.EndpointPair
        public Object source() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        @Override // com.google.common.graph.EndpointPair
        public Object target() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (isOrdered() != endpointPair.isOrdered()) {
                return false;
            }
            if (nodeU().equals(endpointPair.nodeU())) {
                return nodeV().equals(endpointPair.nodeV());
            }
            return nodeU().equals(endpointPair.nodeV()) && nodeV().equals(endpointPair.nodeU());
        }

        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return nodeU().hashCode() + nodeV().hashCode();
        }

        public String toString() {
            return "[" + nodeU() + ", " + nodeV() + "]";
        }
    }
}
