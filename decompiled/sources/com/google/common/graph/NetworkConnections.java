package com.google.common.graph;

import java.util.Set;

/* loaded from: classes4.dex */
interface NetworkConnections {
    void addInEdge(Object obj, Object obj2, boolean z);

    void addOutEdge(Object obj, Object obj2);

    Object adjacentNode(Object obj);

    Set adjacentNodes();

    Set edgesConnecting(Object obj);

    Set inEdges();

    Set incidentEdges();

    Set outEdges();

    Set predecessors();

    Object removeInEdge(Object obj, boolean z);

    Object removeOutEdge(Object obj);

    Set successors();
}
