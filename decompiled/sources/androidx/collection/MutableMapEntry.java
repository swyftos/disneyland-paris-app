package androidx.collection;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* loaded from: classes.dex */
final class MutableMapEntry implements Map.Entry, KMutableMap.Entry {
    private final int index;
    private final Object[] keys;
    private final Object[] values;

    public MutableMapEntry(Object[] keys, Object[] values, int i) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(values, "values");
        this.keys = keys;
        this.values = values;
        this.index = i;
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object obj) {
        Object[] objArr = this.values;
        int i = this.index;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    @Override // java.util.Map.Entry
    public Object getKey() {
        return this.keys[this.index];
    }

    @Override // java.util.Map.Entry
    public Object getValue() {
        return this.values[this.index];
    }
}
