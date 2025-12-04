package com.google.common.graph;

import com.google.common.base.Optional;

/* loaded from: classes4.dex */
abstract class AbstractGraphBuilder {
    final boolean directed;
    boolean allowsSelfLoops = false;
    ElementOrder nodeOrder = ElementOrder.insertion();
    ElementOrder incidentEdgeOrder = ElementOrder.unordered();
    Optional expectedNodeCount = Optional.absent();

    AbstractGraphBuilder(boolean z) {
        this.directed = z;
    }
}
