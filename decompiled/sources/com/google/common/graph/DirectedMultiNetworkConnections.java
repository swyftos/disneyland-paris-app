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
final class DirectedMultiNetworkConnections extends AbstractDirectedNetworkConnections {
    private transient Reference predecessorsReference;
    private transient Reference successorsReference;

    private DirectedMultiNetworkConnections(Map map, Map map2, int i) {
        super(map, map2, i);
    }

    static DirectedMultiNetworkConnections of() {
        return new DirectedMultiNetworkConnections(new HashMap(2, 1.0f), new HashMap(2, 1.0f), 0);
    }

    static DirectedMultiNetworkConnections ofImmutable(Map map, Map map2, int i) {
        return new DirectedMultiNetworkConnections(ImmutableMap.copyOf(map), ImmutableMap.copyOf(map2), i);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set predecessors() {
        return Collections.unmodifiableSet(predecessorsMultiset().elementSet());
    }

    private Multiset predecessorsMultiset() {
        Multiset multiset = (Multiset) getReference(this.predecessorsReference);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset hashMultisetCreate = HashMultiset.create(this.inEdgeMap.values());
        this.predecessorsReference = new SoftReference(hashMultisetCreate);
        return hashMultisetCreate;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set successors() {
        return Collections.unmodifiableSet(successorsMultiset().elementSet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Multiset successorsMultiset() {
        Multiset multiset = (Multiset) getReference(this.successorsReference);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset hashMultisetCreate = HashMultiset.create(this.outEdgeMap.values());
        this.successorsReference = new SoftReference(hashMultisetCreate);
        return hashMultisetCreate;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set edgesConnecting(final Object obj) {
        return new MultiEdgesConnecting(this.outEdgeMap, obj) { // from class: com.google.common.graph.DirectedMultiNetworkConnections.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return DirectedMultiNetworkConnections.this.successorsMultiset().count(obj);
            }
        };
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public Object removeInEdge(Object obj, boolean z) {
        Object objRemoveInEdge = super.removeInEdge(obj, z);
        Multiset multiset = (Multiset) getReference(this.predecessorsReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(objRemoveInEdge));
        }
        return objRemoveInEdge;
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public Object removeOutEdge(Object obj) {
        Object objRemoveOutEdge = super.removeOutEdge(obj);
        Multiset multiset = (Multiset) getReference(this.successorsReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(objRemoveOutEdge));
        }
        return objRemoveOutEdge;
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void addInEdge(Object obj, Object obj2, boolean z) {
        super.addInEdge(obj, obj2, z);
        Multiset multiset = (Multiset) getReference(this.predecessorsReference);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(obj2));
        }
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void addOutEdge(Object obj, Object obj2) {
        super.addOutEdge(obj, obj2);
        Multiset multiset = (Multiset) getReference(this.successorsReference);
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
