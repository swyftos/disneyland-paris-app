package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes4.dex */
abstract class StandardNetwork extends AbstractNetwork {
    private final boolean allowsParallelEdges;
    private final boolean allowsSelfLoops;
    private final ElementOrder edgeOrder;
    final MapIteratorCache edgeToReferenceNode;
    private final boolean isDirected;
    final MapIteratorCache nodeConnections;
    private final ElementOrder nodeOrder;

    StandardNetwork(NetworkBuilder networkBuilder) {
        this(networkBuilder, networkBuilder.nodeOrder.createMap(((Integer) networkBuilder.expectedNodeCount.or((Optional) 10)).intValue()), networkBuilder.edgeOrder.createMap(((Integer) networkBuilder.expectedEdgeCount.or((Optional) 20)).intValue()));
    }

    StandardNetwork(NetworkBuilder networkBuilder, Map map, Map map2) {
        MapIteratorCache mapIteratorCache;
        this.isDirected = networkBuilder.directed;
        this.allowsParallelEdges = networkBuilder.allowsParallelEdges;
        this.allowsSelfLoops = networkBuilder.allowsSelfLoops;
        this.nodeOrder = networkBuilder.nodeOrder.cast();
        this.edgeOrder = networkBuilder.edgeOrder.cast();
        if (map instanceof TreeMap) {
            mapIteratorCache = new MapRetrievalCache(map);
        } else {
            mapIteratorCache = new MapIteratorCache(map);
        }
        this.nodeConnections = mapIteratorCache;
        this.edgeToReferenceNode = new MapIteratorCache(map2);
    }

    @Override // com.google.common.graph.Network
    public Set nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    @Override // com.google.common.graph.Network
    public Set edges() {
        return this.edgeToReferenceNode.unmodifiableKeySet();
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return this.isDirected;
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return this.allowsParallelEdges;
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    @Override // com.google.common.graph.Network
    public ElementOrder nodeOrder() {
        return this.nodeOrder;
    }

    @Override // com.google.common.graph.Network
    public ElementOrder edgeOrder() {
        return this.edgeOrder;
    }

    @Override // com.google.common.graph.Network
    public Set incidentEdges(Object obj) {
        return nodeInvalidatableSet(checkedConnections(obj).incidentEdges(), obj);
    }

    @Override // com.google.common.graph.Network
    public EndpointPair incidentNodes(Object obj) {
        Object objCheckedReferenceNode = checkedReferenceNode(obj);
        NetworkConnections networkConnections = (NetworkConnections) this.nodeConnections.get(objCheckedReferenceNode);
        Objects.requireNonNull(networkConnections);
        return EndpointPair.of(this, objCheckedReferenceNode, networkConnections.adjacentNode(obj));
    }

    @Override // com.google.common.graph.Network
    public Set adjacentNodes(Object obj) {
        return nodeInvalidatableSet(checkedConnections(obj).adjacentNodes(), obj);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set edgesConnecting(Object obj, Object obj2) {
        NetworkConnections networkConnectionsCheckedConnections = checkedConnections(obj);
        if (!this.allowsSelfLoops && obj == obj2) {
            return ImmutableSet.of();
        }
        Preconditions.checkArgument(containsNode(obj2), "Node %s is not an element of this graph.", obj2);
        return nodePairInvalidatableSet(networkConnectionsCheckedConnections.edgesConnecting(obj2), obj, obj2);
    }

    @Override // com.google.common.graph.Network
    public Set inEdges(Object obj) {
        return nodeInvalidatableSet(checkedConnections(obj).inEdges(), obj);
    }

    @Override // com.google.common.graph.Network
    public Set outEdges(Object obj) {
        return nodeInvalidatableSet(checkedConnections(obj).outEdges(), obj);
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public Set predecessors(Object obj) {
        return nodeInvalidatableSet(checkedConnections(obj).predecessors(), obj);
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public Set successors(Object obj) {
        return nodeInvalidatableSet(checkedConnections(obj).successors(), obj);
    }

    final NetworkConnections checkedConnections(Object obj) {
        NetworkConnections networkConnections = (NetworkConnections) this.nodeConnections.get(obj);
        if (networkConnections != null) {
            return networkConnections;
        }
        Preconditions.checkNotNull(obj);
        throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", obj));
    }

    final Object checkedReferenceNode(Object obj) {
        Object obj2 = this.edgeToReferenceNode.get(obj);
        if (obj2 != null) {
            return obj2;
        }
        Preconditions.checkNotNull(obj);
        throw new IllegalArgumentException(String.format("Edge %s is not an element of this graph.", obj));
    }

    final boolean containsNode(Object obj) {
        return this.nodeConnections.containsKey(obj);
    }

    final boolean containsEdge(Object obj) {
        return this.edgeToReferenceNode.containsKey(obj);
    }
}
