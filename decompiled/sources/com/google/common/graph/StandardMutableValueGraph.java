package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes4.dex */
final class StandardMutableValueGraph extends StandardValueGraph implements MutableValueGraph {
    private final ElementOrder incidentEdgeOrder;

    StandardMutableValueGraph(AbstractGraphBuilder abstractGraphBuilder) {
        super(abstractGraphBuilder);
        this.incidentEdgeOrder = abstractGraphBuilder.incidentEdgeOrder.cast();
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public ElementOrder incidentEdgeOrder() {
        return this.incidentEdgeOrder;
    }

    @Override // com.google.common.graph.MutableValueGraph
    public boolean addNode(Object obj) {
        Preconditions.checkNotNull(obj, "node");
        if (containsNode(obj)) {
            return false;
        }
        addNodeInternal(obj);
        return true;
    }

    private GraphConnections addNodeInternal(Object obj) {
        GraphConnections graphConnectionsNewConnections = newConnections();
        Preconditions.checkState(this.nodeConnections.put(obj, graphConnectionsNewConnections) == null);
        return graphConnectionsNewConnections;
    }

    @Override // com.google.common.graph.MutableValueGraph
    public Object putEdgeValue(Object obj, Object obj2, Object obj3) {
        Preconditions.checkNotNull(obj, "nodeU");
        Preconditions.checkNotNull(obj2, "nodeV");
        Preconditions.checkNotNull(obj3, "value");
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!obj.equals(obj2), "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", obj);
        }
        GraphConnections graphConnectionsAddNodeInternal = (GraphConnections) this.nodeConnections.get(obj);
        if (graphConnectionsAddNodeInternal == null) {
            graphConnectionsAddNodeInternal = addNodeInternal(obj);
        }
        Object objAddSuccessor = graphConnectionsAddNodeInternal.addSuccessor(obj2, obj3);
        GraphConnections graphConnectionsAddNodeInternal2 = (GraphConnections) this.nodeConnections.get(obj2);
        if (graphConnectionsAddNodeInternal2 == null) {
            graphConnectionsAddNodeInternal2 = addNodeInternal(obj2);
        }
        graphConnectionsAddNodeInternal2.addPredecessor(obj, obj3);
        if (objAddSuccessor == null) {
            long j = this.edgeCount + 1;
            this.edgeCount = j;
            Graphs.checkPositive(j);
        }
        return objAddSuccessor;
    }

    @Override // com.google.common.graph.MutableValueGraph
    public Object putEdgeValue(EndpointPair endpointPair, Object obj) {
        validateEndpoints(endpointPair);
        return putEdgeValue(endpointPair.nodeU(), endpointPair.nodeV(), obj);
    }

    @Override // com.google.common.graph.MutableValueGraph
    public boolean removeNode(Object obj) {
        Preconditions.checkNotNull(obj, "node");
        GraphConnections graphConnections = (GraphConnections) this.nodeConnections.get(obj);
        if (graphConnections == null) {
            return false;
        }
        if (allowsSelfLoops() && graphConnections.removeSuccessor(obj) != null) {
            graphConnections.removePredecessor(obj);
            this.edgeCount--;
        }
        UnmodifiableIterator it = ImmutableList.copyOf((Collection) graphConnections.successors()).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            GraphConnections graphConnections2 = (GraphConnections) this.nodeConnections.getWithoutCaching(next);
            Objects.requireNonNull(graphConnections2);
            graphConnections2.removePredecessor(obj);
            Objects.requireNonNull(graphConnections.removeSuccessor(next));
            this.edgeCount--;
        }
        if (isDirected()) {
            UnmodifiableIterator it2 = ImmutableList.copyOf((Collection) graphConnections.predecessors()).iterator();
            while (it2.hasNext()) {
                Object next2 = it2.next();
                GraphConnections graphConnections3 = (GraphConnections) this.nodeConnections.getWithoutCaching(next2);
                Objects.requireNonNull(graphConnections3);
                Preconditions.checkState(graphConnections3.removeSuccessor(obj) != null);
                graphConnections.removePredecessor(next2);
                this.edgeCount--;
            }
        }
        this.nodeConnections.remove(obj);
        Graphs.checkNonNegative(this.edgeCount);
        return true;
    }

    @Override // com.google.common.graph.MutableValueGraph
    public Object removeEdge(Object obj, Object obj2) {
        Preconditions.checkNotNull(obj, "nodeU");
        Preconditions.checkNotNull(obj2, "nodeV");
        GraphConnections graphConnections = (GraphConnections) this.nodeConnections.get(obj);
        GraphConnections graphConnections2 = (GraphConnections) this.nodeConnections.get(obj2);
        if (graphConnections == null || graphConnections2 == null) {
            return null;
        }
        Object objRemoveSuccessor = graphConnections.removeSuccessor(obj2);
        if (objRemoveSuccessor != null) {
            graphConnections2.removePredecessor(obj);
            long j = this.edgeCount - 1;
            this.edgeCount = j;
            Graphs.checkNonNegative(j);
        }
        return objRemoveSuccessor;
    }

    @Override // com.google.common.graph.MutableValueGraph
    public Object removeEdge(EndpointPair endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    private GraphConnections newConnections() {
        if (isDirected()) {
            return DirectedGraphConnections.of(this.incidentEdgeOrder);
        }
        return UndirectedGraphConnections.of(this.incidentEdgeOrder);
    }
}
