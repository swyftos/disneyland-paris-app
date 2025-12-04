package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Objects;

/* loaded from: classes4.dex */
final class StandardMutableNetwork extends StandardNetwork implements MutableNetwork {
    StandardMutableNetwork(NetworkBuilder networkBuilder) {
        super(networkBuilder);
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean addNode(Object obj) {
        Preconditions.checkNotNull(obj, "node");
        if (containsNode(obj)) {
            return false;
        }
        addNodeInternal(obj);
        return true;
    }

    private NetworkConnections addNodeInternal(Object obj) {
        NetworkConnections networkConnectionsNewConnections = newConnections();
        Preconditions.checkState(this.nodeConnections.put(obj, networkConnectionsNewConnections) == null);
        return networkConnectionsNewConnections;
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean addEdge(Object obj, Object obj2, Object obj3) {
        Preconditions.checkNotNull(obj, "nodeU");
        Preconditions.checkNotNull(obj2, "nodeV");
        Preconditions.checkNotNull(obj3, "edge");
        if (containsEdge(obj3)) {
            EndpointPair endpointPairIncidentNodes = incidentNodes(obj3);
            EndpointPair endpointPairOf = EndpointPair.of(this, obj, obj2);
            Preconditions.checkArgument(endpointPairIncidentNodes.equals(endpointPairOf), "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.", obj3, endpointPairIncidentNodes, endpointPairOf);
            return false;
        }
        NetworkConnections networkConnectionsAddNodeInternal = (NetworkConnections) this.nodeConnections.get(obj);
        if (!allowsParallelEdges()) {
            Preconditions.checkArgument(networkConnectionsAddNodeInternal == null || !networkConnectionsAddNodeInternal.successors().contains(obj2), "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.", obj, obj2);
        }
        boolean zEquals = obj.equals(obj2);
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!zEquals, "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", obj);
        }
        if (networkConnectionsAddNodeInternal == null) {
            networkConnectionsAddNodeInternal = addNodeInternal(obj);
        }
        networkConnectionsAddNodeInternal.addOutEdge(obj3, obj2);
        NetworkConnections networkConnectionsAddNodeInternal2 = (NetworkConnections) this.nodeConnections.get(obj2);
        if (networkConnectionsAddNodeInternal2 == null) {
            networkConnectionsAddNodeInternal2 = addNodeInternal(obj2);
        }
        networkConnectionsAddNodeInternal2.addInEdge(obj3, obj, zEquals);
        this.edgeToReferenceNode.put(obj3, obj);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean addEdge(EndpointPair endpointPair, Object obj) {
        validateEndpoints(endpointPair);
        return addEdge(endpointPair.nodeU(), endpointPair.nodeV(), obj);
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean removeNode(Object obj) {
        Preconditions.checkNotNull(obj, "node");
        NetworkConnections networkConnections = (NetworkConnections) this.nodeConnections.get(obj);
        if (networkConnections == null) {
            return false;
        }
        UnmodifiableIterator it = ImmutableList.copyOf((Collection) networkConnections.incidentEdges()).iterator();
        while (it.hasNext()) {
            removeEdge(it.next());
        }
        this.nodeConnections.remove(obj);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    public boolean removeEdge(Object obj) {
        Preconditions.checkNotNull(obj, "edge");
        Object obj2 = this.edgeToReferenceNode.get(obj);
        boolean z = false;
        if (obj2 == null) {
            return false;
        }
        NetworkConnections networkConnections = (NetworkConnections) this.nodeConnections.get(obj2);
        Objects.requireNonNull(networkConnections);
        NetworkConnections networkConnections2 = networkConnections;
        Object objAdjacentNode = networkConnections2.adjacentNode(obj);
        NetworkConnections networkConnections3 = (NetworkConnections) this.nodeConnections.get(objAdjacentNode);
        Objects.requireNonNull(networkConnections3);
        NetworkConnections networkConnections4 = networkConnections3;
        networkConnections2.removeOutEdge(obj);
        if (allowsSelfLoops() && obj2.equals(objAdjacentNode)) {
            z = true;
        }
        networkConnections4.removeInEdge(obj, z);
        this.edgeToReferenceNode.remove(obj);
        return true;
    }

    private NetworkConnections newConnections() {
        if (isDirected()) {
            if (allowsParallelEdges()) {
                return DirectedMultiNetworkConnections.of();
            }
            return DirectedNetworkConnections.of();
        }
        if (allowsParallelEdges()) {
            return UndirectedMultiNetworkConnections.of();
        }
        return UndirectedNetworkConnections.of();
    }
}
