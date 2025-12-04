package com.google.common.graph;

import java.util.Iterator;
import java.util.Set;

/* loaded from: classes4.dex */
interface GraphConnections {
    void addPredecessor(Object obj, Object obj2);

    Object addSuccessor(Object obj, Object obj2);

    Set adjacentNodes();

    Iterator incidentEdgeIterator(Object obj);

    Set predecessors();

    void removePredecessor(Object obj);

    Object removeSuccessor(Object obj);

    Set successors();

    Object value(Object obj);
}
