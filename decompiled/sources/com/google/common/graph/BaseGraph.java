package com.google.common.graph;

import java.util.Set;

/* loaded from: classes4.dex */
interface BaseGraph extends SuccessorsFunction, PredecessorsFunction {
    Set adjacentNodes(Object obj);

    boolean allowsSelfLoops();

    int degree(Object obj);

    Set edges();

    boolean hasEdgeConnecting(EndpointPair endpointPair);

    boolean hasEdgeConnecting(Object obj, Object obj2);

    int inDegree(Object obj);

    ElementOrder incidentEdgeOrder();

    Set incidentEdges(Object obj);

    boolean isDirected();

    ElementOrder nodeOrder();

    Set nodes();

    int outDegree(Object obj);

    Set predecessors(Object obj);

    @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    Set successors(Object obj);
}
