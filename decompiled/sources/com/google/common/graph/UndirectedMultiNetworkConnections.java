package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
final class UndirectedMultiNetworkConnections extends AbstractUndirectedNetworkConnections {
    private transient Reference adjacentNodesReference;

    private UndirectedMultiNetworkConnections(Map map) {
        super(map);
    }

    static UndirectedMultiNetworkConnections of() {
        return new UndirectedMultiNetworkConnections(new HashMap(2, 1.0f));
    }

    static UndirectedMultiNetworkConnections ofImmutable(Map map) {
        return new UndirectedMultiNetworkConnections(ImmutableMap.copyOf(map));
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set adjacentNodes() {
        return Collections.unmodifiableSet(adjacentNodesMultiset().elementSet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Multiset adjacentNodesMultiset() {
        Multiset multiset = (Multiset) getReference(this.adjacentNodesReference);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset hashMultisetCreate = HashMultiset.create(this.incidentEdgeMap.values());
        this.adjacentNodesReference = new SoftReference(hashMultisetCreate);
        return hashMultisetCreate;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set edgesConnecting(final Object obj) {
        return new MultiEdgesConnecting(this.incidentEdgeMap, obj) { // from class: com.google.common.graph.UndirectedMultiNetworkConnections.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return UndirectedMultiNetworkConnections.this.adjacentNodesMultiset().count(obj);
            }
        };
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public Object removeInEdge(Object obj, boolean z) {
        if (z) {
            return null;
        }
        return removeOutEdge(obj);
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public Object removeOutEdge(Object obj) {
        Object objRemoveOutEdge = super.removeOutEdge(obj);
        Multiset multiset = (Multiset) getReference(this.adjacentNodesReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(objRemoveOutEdge));
        }
        return objRemoveOutEdge;
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void addInEdge(Object obj, Object obj2, boolean z) {
        if (z) {
            return;
        }
        addOutEdge(obj, obj2);
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void addOutEdge(Object obj, Object obj2) {
        super.addOutEdge(obj, obj2);
        Multiset multiset = (Multiset) getReference(this.adjacentNodesReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(obj2));
        }
    }

    private static Object getReference(Reference reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }
}
