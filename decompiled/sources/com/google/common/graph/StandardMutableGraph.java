package com.google.common.graph;

/* loaded from: classes4.dex */
final class StandardMutableGraph extends ForwardingGraph implements MutableGraph {
    private final MutableValueGraph backingValueGraph;

    StandardMutableGraph(AbstractGraphBuilder abstractGraphBuilder) {
        this.backingValueGraph = new StandardMutableValueGraph(abstractGraphBuilder);
    }

    @Override // com.google.common.graph.ForwardingGraph
    BaseGraph delegate() {
        return this.backingValueGraph;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean addNode(Object obj) {
        return this.backingValueGraph.addNode(obj);
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(Object obj, Object obj2) {
        return this.backingValueGraph.putEdgeValue(obj, obj2, GraphConstants$Presence.EDGE_EXISTS) == null;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(EndpointPair endpointPair) {
        validateEndpoints(endpointPair);
        return putEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeNode(Object obj) {
        return this.backingValueGraph.removeNode(obj);
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(Object obj, Object obj2) {
        return this.backingValueGraph.removeEdge(obj, obj2) != null;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(EndpointPair endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }
}
