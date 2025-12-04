package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes4.dex */
class StandardValueGraph extends AbstractValueGraph {
    private final boolean allowsSelfLoops;
    long edgeCount;
    private final boolean isDirected;
    final MapIteratorCache nodeConnections;
    private final ElementOrder nodeOrder;

    StandardValueGraph(AbstractGraphBuilder abstractGraphBuilder) {
        this(abstractGraphBuilder, abstractGraphBuilder.nodeOrder.createMap(((Integer) abstractGraphBuilder.expectedNodeCount.or((Optional) 10)).intValue()), 0L);
    }

    StandardValueGraph(AbstractGraphBuilder abstractGraphBuilder, Map map, long j) {
        MapIteratorCache mapIteratorCache;
        this.isDirected = abstractGraphBuilder.directed;
        this.allowsSelfLoops = abstractGraphBuilder.allowsSelfLoops;
        this.nodeOrder = abstractGraphBuilder.nodeOrder.cast();
        if (map instanceof TreeMap) {
            mapIteratorCache = new MapRetrievalCache(map);
        } else {
            mapIteratorCache = new MapIteratorCache(map);
        }
        this.nodeConnections = mapIteratorCache;
        this.edgeCount = Graphs.checkNonNegative(j);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean isDirected() {
        return this.isDirected;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public ElementOrder nodeOrder() {
        return this.nodeOrder;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set adjacentNodes(Object obj) {
        return nodeInvalidatableSet(checkedConnections(obj).adjacentNodes(), obj);
    }

    @Override // com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public Set predecessors(Object obj) {
        return nodeInvalidatableSet(checkedConnections(obj).predecessors(), obj);
    }

    @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public Set successors(Object obj) {
        return nodeInvalidatableSet(checkedConnections(obj).successors(), obj);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public Set incidentEdges(Object obj) {
        final GraphConnections graphConnectionsCheckedConnections = checkedConnections(obj);
        return nodeInvalidatableSet(new IncidentEdgeSet(this, this, obj) { // from class: com.google.common.graph.StandardValueGraph.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return graphConnectionsCheckedConnections.incidentEdgeIterator(this.node);
            }
        }, obj);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(Object obj, Object obj2) {
        return hasEdgeConnectingInternal(Preconditions.checkNotNull(obj), Preconditions.checkNotNull(obj2));
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(EndpointPair endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        return isOrderingCompatible(endpointPair) && hasEdgeConnectingInternal(endpointPair.nodeU(), endpointPair.nodeV());
    }

    public Object edgeValueOrDefault(Object obj, Object obj2, Object obj3) {
        return edgeValueOrDefaultInternal(Preconditions.checkNotNull(obj), Preconditions.checkNotNull(obj2), obj3);
    }

    public Object edgeValueOrDefault(EndpointPair endpointPair, Object obj) {
        validateEndpoints(endpointPair);
        return edgeValueOrDefaultInternal(endpointPair.nodeU(), endpointPair.nodeV(), obj);
    }

    @Override // com.google.common.graph.AbstractBaseGraph
    protected long edgeCount() {
        return this.edgeCount;
    }

    private final GraphConnections checkedConnections(Object obj) {
        GraphConnections graphConnections = (GraphConnections) this.nodeConnections.get(obj);
        if (graphConnections != null) {
            return graphConnections;
        }
        Preconditions.checkNotNull(obj);
        throw new IllegalArgumentException("Node " + obj + " is not an element of this graph.");
    }

    final boolean containsNode(Object obj) {
        return this.nodeConnections.containsKey(obj);
    }

    private final boolean hasEdgeConnectingInternal(Object obj, Object obj2) {
        GraphConnections graphConnections = (GraphConnections) this.nodeConnections.get(obj);
        return graphConnections != null && graphConnections.successors().contains(obj2);
    }

    private final Object edgeValueOrDefaultInternal(Object obj, Object obj2, Object obj3) {
        GraphConnections graphConnections = (GraphConnections) this.nodeConnections.get(obj);
        Object objValue = graphConnections == null ? null : graphConnections.value(obj2);
        return objValue == null ? obj3 : objValue;
    }
}
