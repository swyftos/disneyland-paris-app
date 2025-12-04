package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes4.dex */
abstract class AbstractUndirectedNetworkConnections implements NetworkConnections {
    final Map incidentEdgeMap;

    AbstractUndirectedNetworkConnections(Map map) {
        this.incidentEdgeMap = (Map) Preconditions.checkNotNull(map);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set predecessors() {
        return adjacentNodes();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set successors() {
        return adjacentNodes();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set incidentEdges() {
        return Collections.unmodifiableSet(this.incidentEdgeMap.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set inEdges() {
        return incidentEdges();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set outEdges() {
        return incidentEdges();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Object adjacentNode(Object obj) {
        Object obj2 = this.incidentEdgeMap.get(obj);
        Objects.requireNonNull(obj2);
        return obj2;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Object removeInEdge(Object obj, boolean z) {
        if (z) {
            return null;
        }
        return removeOutEdge(obj);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Object removeOutEdge(Object obj) {
        Object objRemove = this.incidentEdgeMap.remove(obj);
        Objects.requireNonNull(objRemove);
        return objRemove;
    }

    @Override // com.google.common.graph.NetworkConnections
    public void addInEdge(Object obj, Object obj2, boolean z) {
        if (z) {
            return;
        }
        addOutEdge(obj, obj2);
    }

    @Override // com.google.common.graph.NetworkConnections
    public void addOutEdge(Object obj, Object obj2) {
        Preconditions.checkState(this.incidentEdgeMap.put(obj, obj2) == null);
    }
}
