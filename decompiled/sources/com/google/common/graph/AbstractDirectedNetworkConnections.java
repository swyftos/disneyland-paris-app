package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes4.dex */
abstract class AbstractDirectedNetworkConnections implements NetworkConnections {
    final Map inEdgeMap;
    final Map outEdgeMap;
    private int selfLoopCount;

    AbstractDirectedNetworkConnections(Map map, Map map2, int i) {
        this.inEdgeMap = (Map) Preconditions.checkNotNull(map);
        this.outEdgeMap = (Map) Preconditions.checkNotNull(map2);
        this.selfLoopCount = Graphs.checkNonNegative(i);
        Preconditions.checkState(i <= map.size() && i <= map2.size());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set adjacentNodes() {
        return Sets.union(predecessors(), successors());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set incidentEdges() {
        return new AbstractSet() { // from class: com.google.common.graph.AbstractDirectedNetworkConnections.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator iterator() {
                Iterable iterableUnion;
                if (AbstractDirectedNetworkConnections.this.selfLoopCount == 0) {
                    iterableUnion = Iterables.concat(AbstractDirectedNetworkConnections.this.inEdgeMap.keySet(), AbstractDirectedNetworkConnections.this.outEdgeMap.keySet());
                } else {
                    iterableUnion = Sets.union(AbstractDirectedNetworkConnections.this.inEdgeMap.keySet(), AbstractDirectedNetworkConnections.this.outEdgeMap.keySet());
                }
                return Iterators.unmodifiableIterator(iterableUnion.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return IntMath.saturatedAdd(AbstractDirectedNetworkConnections.this.inEdgeMap.size(), AbstractDirectedNetworkConnections.this.outEdgeMap.size() - AbstractDirectedNetworkConnections.this.selfLoopCount);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return AbstractDirectedNetworkConnections.this.inEdgeMap.containsKey(obj) || AbstractDirectedNetworkConnections.this.outEdgeMap.containsKey(obj);
            }
        };
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set inEdges() {
        return Collections.unmodifiableSet(this.inEdgeMap.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set outEdges() {
        return Collections.unmodifiableSet(this.outEdgeMap.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Object adjacentNode(Object obj) {
        Object obj2 = this.outEdgeMap.get(obj);
        Objects.requireNonNull(obj2);
        return obj2;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Object removeInEdge(Object obj, boolean z) {
        if (z) {
            int i = this.selfLoopCount - 1;
            this.selfLoopCount = i;
            Graphs.checkNonNegative(i);
        }
        Object objRemove = this.inEdgeMap.remove(obj);
        Objects.requireNonNull(objRemove);
        return objRemove;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Object removeOutEdge(Object obj) {
        Object objRemove = this.outEdgeMap.remove(obj);
        Objects.requireNonNull(objRemove);
        return objRemove;
    }

    @Override // com.google.common.graph.NetworkConnections
    public void addInEdge(Object obj, Object obj2, boolean z) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        if (z) {
            int i = this.selfLoopCount + 1;
            this.selfLoopCount = i;
            Graphs.checkPositive(i);
        }
        Preconditions.checkState(this.inEdgeMap.put(obj, obj2) == null);
    }

    @Override // com.google.common.graph.NetworkConnections
    public void addOutEdge(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        Preconditions.checkState(this.outEdgeMap.put(obj, obj2) == null);
    }
}
