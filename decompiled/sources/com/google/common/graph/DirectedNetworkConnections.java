package com.google.common.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
final class DirectedNetworkConnections extends AbstractDirectedNetworkConnections {
    DirectedNetworkConnections(Map map, Map map2, int i) {
        super(map, map2, i);
    }

    static DirectedNetworkConnections of() {
        return new DirectedNetworkConnections(HashBiMap.create(2), HashBiMap.create(2), 0);
    }

    static DirectedNetworkConnections ofImmutable(Map map, Map map2, int i) {
        return new DirectedNetworkConnections(ImmutableBiMap.copyOf(map), ImmutableBiMap.copyOf(map2), i);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set predecessors() {
        return Collections.unmodifiableSet(((BiMap) this.inEdgeMap).values());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set successors() {
        return Collections.unmodifiableSet(((BiMap) this.outEdgeMap).values());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set edgesConnecting(Object obj) {
        return new EdgesConnecting(((BiMap) this.outEdgeMap).inverse(), obj);
    }
}
