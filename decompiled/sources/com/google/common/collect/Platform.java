package com.google.common.collect;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
abstract class Platform {
    static Map newHashMapWithExpectedSize(int i) {
        return CompactHashMap.createWithExpectedSize(i);
    }

    static Map newLinkedHashMapWithExpectedSize(int i) {
        return CompactLinkedHashMap.createWithExpectedSize(i);
    }

    static Set newHashSetWithExpectedSize(int i) {
        return CompactHashSet.createWithExpectedSize(i);
    }

    static Set newLinkedHashSetWithExpectedSize(int i) {
        return CompactLinkedHashSet.createWithExpectedSize(i);
    }

    static Map preservesInsertionOrderOnPutsMap() {
        return CompactHashMap.create();
    }

    static Set preservesInsertionOrderOnAddsSet() {
        return CompactHashSet.create();
    }

    static Object[] newArray(Object[] objArr, int i) {
        if (objArr.length != 0) {
            objArr = Arrays.copyOf(objArr, 0);
        }
        return Arrays.copyOf(objArr, i);
    }

    static Object[] copy(Object[] objArr, int i, int i2, Object[] objArr2) {
        return Arrays.copyOfRange(objArr, i, i2, objArr2.getClass());
    }

    static MapMaker tryWeakKeys(MapMaker mapMaker) {
        return mapMaker.weakKeys();
    }

    static Class getDeclaringClassOrObjectForJ2cl(Enum r0) {
        return r0.getDeclaringClass();
    }
}
