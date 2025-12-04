package com.google.common.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
final class UndirectedNetworkConnections extends AbstractUndirectedNetworkConnections {
    UndirectedNetworkConnections(Map map) {
        super(map);
    }

    static UndirectedNetworkConnections of() {
        return new UndirectedNetworkConnections(HashBiMap.create(2));
    }

    static UndirectedNetworkConnections ofImmutable(Map map) {
        return new UndirectedNetworkConnections(ImmutableBiMap.copyOf(map));
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set adjacentNodes() {
        return Collections.unmodifiableSet(((BiMap) this.incidentEdgeMap).values());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set edgesConnecting(Object obj) {
        return new EdgesConnecting(((BiMap) this.incidentEdgeMap).inverse(), obj);
    }
}
