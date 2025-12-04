package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import com.google.common.graph.ElementOrder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
final class UndirectedGraphConnections implements GraphConnections {
    private final Map adjacentNodeValues;

    private UndirectedGraphConnections(Map map) {
        this.adjacentNodeValues = (Map) Preconditions.checkNotNull(map);
    }

    /* renamed from: com.google.common.graph.UndirectedGraphConnections$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$graph$ElementOrder$Type;

        static {
            int[] iArr = new int[ElementOrder.Type.values().length];
            $SwitchMap$com$google$common$graph$ElementOrder$Type = iArr;
            try {
                iArr[ElementOrder.Type.UNORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$common$graph$ElementOrder$Type[ElementOrder.Type.STABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static UndirectedGraphConnections of(ElementOrder elementOrder) {
        int i = AnonymousClass1.$SwitchMap$com$google$common$graph$ElementOrder$Type[elementOrder.type().ordinal()];
        if (i == 1) {
            return new UndirectedGraphConnections(new HashMap(2, 1.0f));
        }
        if (i == 2) {
            return new UndirectedGraphConnections(new LinkedHashMap(2, 1.0f));
        }
        throw new AssertionError(elementOrder.type());
    }

    static UndirectedGraphConnections ofImmutable(Map map) {
        return new UndirectedGraphConnections(ImmutableMap.copyOf(map));
    }

    @Override // com.google.common.graph.GraphConnections
    public Set adjacentNodes() {
        return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
    }

    @Override // com.google.common.graph.GraphConnections
    public Set predecessors() {
        return adjacentNodes();
    }

    @Override // com.google.common.graph.GraphConnections
    public Set successors() {
        return adjacentNodes();
    }

    @Override // com.google.common.graph.GraphConnections
    public Iterator incidentEdgeIterator(final Object obj) {
        return Iterators.transform(this.adjacentNodeValues.keySet().iterator(), new Function() { // from class: com.google.common.graph.UndirectedGraphConnections$$ExternalSyntheticLambda0
            @Override // com.google.common.base.Function
            public final Object apply(Object obj2) {
                return EndpointPair.unordered(obj, obj2);
            }
        });
    }

    @Override // com.google.common.graph.GraphConnections
    public Object value(Object obj) {
        return this.adjacentNodeValues.get(obj);
    }

    @Override // com.google.common.graph.GraphConnections
    public void removePredecessor(Object obj) {
        removeSuccessor(obj);
    }

    @Override // com.google.common.graph.GraphConnections
    public Object removeSuccessor(Object obj) {
        return this.adjacentNodeValues.remove(obj);
    }

    @Override // com.google.common.graph.GraphConnections
    public void addPredecessor(Object obj, Object obj2) {
        addSuccessor(obj, obj2);
    }

    @Override // com.google.common.graph.GraphConnections
    public Object addSuccessor(Object obj, Object obj2) {
        return this.adjacentNodeValues.put(obj, obj2);
    }
}
