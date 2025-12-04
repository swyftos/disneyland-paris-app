package com.google.common.graph;

import java.util.Set;

/* loaded from: classes4.dex */
abstract class ForwardingNetwork extends AbstractNetwork {
    abstract Network delegate();

    ForwardingNetwork() {
    }

    @Override // com.google.common.graph.Network
    public Set nodes() {
        return delegate().nodes();
    }

    @Override // com.google.common.graph.Network
    public Set edges() {
        return delegate().edges();
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return delegate().isDirected();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return delegate().allowsParallelEdges();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    @Override // com.google.common.graph.Network
    public ElementOrder nodeOrder() {
        return delegate().nodeOrder();
    }

    @Override // com.google.common.graph.Network
    public ElementOrder edgeOrder() {
        return delegate().edgeOrder();
    }

    @Override // com.google.common.graph.Network
    public Set adjacentNodes(Object obj) {
        return delegate().adjacentNodes(obj);
    }

    @Override // com.google.common.graph.Network
    public Set incidentEdges(Object obj) {
        return delegate().incidentEdges(obj);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set adjacentEdges(Object obj) {
        return delegate().adjacentEdges(obj);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int degree(Object obj) {
        return delegate().degree(obj);
    }
}
