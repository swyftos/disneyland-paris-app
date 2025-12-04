package com.google.common.graph;

import java.util.AbstractSet;
import java.util.Set;

/* loaded from: classes4.dex */
abstract class IncidentEdgeSet extends AbstractSet {
    final BaseGraph graph;
    final Object node;

    IncidentEdgeSet(BaseGraph baseGraph, Object obj) {
        this.graph = baseGraph;
        this.node = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        if (this.graph.isDirected()) {
            return (this.graph.inDegree(this.node) + this.graph.outDegree(this.node)) - (this.graph.successors(this.node).contains(this.node) ? 1 : 0);
        }
        return this.graph.adjacentNodes(this.node).size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (!(obj instanceof EndpointPair)) {
            return false;
        }
        EndpointPair endpointPair = (EndpointPair) obj;
        if (this.graph.isDirected()) {
            if (!endpointPair.isOrdered()) {
                return false;
            }
            Object objSource = endpointPair.source();
            Object objTarget = endpointPair.target();
            return (this.node.equals(objSource) && this.graph.successors(this.node).contains(objTarget)) || (this.node.equals(objTarget) && this.graph.predecessors(this.node).contains(objSource));
        }
        if (endpointPair.isOrdered()) {
            return false;
        }
        Set setAdjacentNodes = this.graph.adjacentNodes(this.node);
        Object objNodeU = endpointPair.nodeU();
        Object objNodeV = endpointPair.nodeV();
        return (this.node.equals(objNodeV) && setAdjacentNodes.contains(objNodeU)) || (this.node.equals(objNodeU) && setAdjacentNodes.contains(objNodeV));
    }
}
