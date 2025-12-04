package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Function;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Maps {

    /* renamed from: androidx.test.espresso.core.internal.deps.guava.collect.Maps$1, reason: invalid class name */
    abstract class AnonymousClass1 extends TransformedIterator {
    }

    private enum EntryFunction implements Function<Map.Entry<?, ?>, Object> {
        KEY { // from class: androidx.test.espresso.core.internal.deps.guava.collect.Maps.EntryFunction.1
            @Override // androidx.test.espresso.core.internal.deps.guava.base.Function
            public /* bridge */ /* synthetic */ Object apply(Map.Entry<?, ?> entry) {
                return apply2((Map.Entry) entry);
            }

            /* renamed from: apply, reason: avoid collision after fix types in other method */
            public Object apply2(Map.Entry entry) {
                return entry.getKey();
            }
        },
        VALUE { // from class: androidx.test.espresso.core.internal.deps.guava.collect.Maps.EntryFunction.2
            @Override // androidx.test.espresso.core.internal.deps.guava.base.Function
            public /* bridge */ /* synthetic */ Object apply(Map.Entry<?, ?> entry) {
                return apply2((Map.Entry) entry);
            }

            /* renamed from: apply, reason: avoid collision after fix types in other method */
            public Object apply2(Map.Entry entry) {
                return entry.getValue();
            }
        };

        /* synthetic */ EntryFunction(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>();
    }

    static String toStringImpl(Map map) {
        StringBuilder sbNewStringBuilderForCollection = Collections2.newStringBuilderForCollection(map.size());
        sbNewStringBuilderForCollection.append('{');
        boolean z = true;
        for (Map.Entry entry : map.entrySet()) {
            if (!z) {
                sbNewStringBuilderForCollection.append(", ");
            }
            sbNewStringBuilderForCollection.append(entry.getKey());
            sbNewStringBuilderForCollection.append('=');
            sbNewStringBuilderForCollection.append(entry.getValue());
            z = false;
        }
        sbNewStringBuilderForCollection.append('}');
        return sbNewStringBuilderForCollection.toString();
    }

    static Function valueFunction() {
        return EntryFunction.VALUE;
    }

    static boolean equalsImpl(Map map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }
}
