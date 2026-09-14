package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    static final ImmutableMap EMPTY = new RegularImmutableMap(null, new Object[0], 0);
    private static final long serialVersionUID = 0;
    final transient Object[] alternatingKeysAndValues;
    private final transient Object hashTable;
    private final transient int size;

    static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int keyOffset;
        private final transient ImmutableMap map;
        private final transient int size;

        EntrySet(ImmutableMap immutableMap, Object[] objArr, int i, int i2) {
            this.map = immutableMap;
            this.alternatingKeysAndValues = objArr;
            this.keyOffset = i;
            this.size = i2;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.map.get(key));
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection
        int copyIntoArray(Object[] objArr, int i) {
            return asList().copyIntoArray(objArr, i);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet
        ImmutableList createAsList() {
            return new ImmutableList<Map.Entry<K, V>>() { // from class: androidx.test.espresso.core.internal.deps.guava.collect.RegularImmutableMap.EntrySet.1
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return EntrySet.this.size;
                }

                @Override // java.util.List
                public Map.Entry get(int i) {
                    Preconditions.checkElementIndex(i, EntrySet.this.size);
                    int i2 = i + i;
                    return new AbstractMap.SimpleImmutableEntry(EntrySet.this.alternatingKeysAndValues[EntrySet.this.keyOffset + i2], EntrySet.this.alternatingKeysAndValues[i2 + (EntrySet.this.keyOffset ^ 1)]);
                }
            };
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet, androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public UnmodifiableIterator iterator() {
            return asList().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.size;
        }
    }

    static final class KeySet<K> extends ImmutableSet<K> {
        private final transient ImmutableList list;
        private final transient ImmutableMap map;

        KeySet(ImmutableMap immutableMap, ImmutableList immutableList) {
            this.map = immutableMap;
            this.list = immutableList;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet
        public ImmutableList asList() {
            return this.list;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.map.get(obj) != null;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection
        int copyIntoArray(Object[] objArr, int i) {
            return asList().copyIntoArray(objArr, i);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet, androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public UnmodifiableIterator iterator() {
            return asList().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }
    }

    static final class KeysOrValuesAsList extends ImmutableList<Object> {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int offset;
        private final transient int size;

        KeysOrValuesAsList(Object[] objArr, int i, int i2) {
            this.alternatingKeysAndValues = objArr;
            this.offset = i;
            this.size = i2;
        }

        @Override // java.util.List
        public Object get(int i) {
            Preconditions.checkElementIndex(i, this.size);
            return this.alternatingKeysAndValues[i + i + this.offset];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }
    }

    private RegularImmutableMap(Object obj, Object[] objArr, int i) {
        this.hashTable = obj;
        this.alternatingKeysAndValues = objArr;
        this.size = i;
    }

    private static IllegalArgumentException duplicateKeyException(Object obj, Object obj2, Object[] objArr, int i) {
        String strValueOf = String.valueOf(obj);
        String strValueOf2 = String.valueOf(obj2);
        String strValueOf3 = String.valueOf(objArr[i]);
        String strValueOf4 = String.valueOf(objArr[i ^ 1]);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        StringBuilder sb = new StringBuilder(length + 39 + length2 + strValueOf3.length() + strValueOf4.length());
        sb.append("Multiple entries with same key: ");
        sb.append(strValueOf);
        sb.append("=");
        sb.append(strValueOf2);
        sb.append(" and ");
        sb.append(strValueOf3);
        sb.append("=");
        sb.append(strValueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableMap
    ImmutableSet createEntrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.size);
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableMap
    ImmutableSet createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.size));
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableMap
    ImmutableCollection createValues() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.size);
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableMap, java.util.Map
    public Object get(Object obj) {
        return get(this.hashTable, this.alternatingKeysAndValues, this.size, 0, obj);
    }

    @Override // androidx.test.espresso.core.internal.deps.guava.collect.ImmutableMap
    boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.size;
    }

    static RegularImmutableMap create(int i, Object[] objArr) {
        if (i == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (i == 1) {
            CollectPreconditions.checkEntryNotNull(objArr[0], objArr[1]);
            return new RegularImmutableMap(null, objArr, 1);
        }
        Preconditions.checkPositionIndex(i, objArr.length >> 1);
        return new RegularImmutableMap(createHashTable(objArr, i, ImmutableSet.chooseTableSize(i), 0), objArr, i);
    }

    static Object createHashTable(Object[] objArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        if (i == 1) {
            CollectPreconditions.checkEntryNotNull(objArr[i3], objArr[i3 ^ 1]);
            return null;
        }
        int i7 = i2 - 1;
        int i8 = 0;
        if (i2 <= 128) {
            byte[] bArr = new byte[i2];
            Arrays.fill(bArr, (byte) -1);
            while (i8 < i) {
                int i9 = i8 + i8 + i3;
                Object obj = objArr[i9];
                Object obj2 = objArr[i9 ^ 1];
                CollectPreconditions.checkEntryNotNull(obj, obj2);
                int iSmear = Hashing.smear(obj.hashCode());
                while (true) {
                    i6 = iSmear & i7;
                    int i10 = bArr[i6] & 255;
                    if (i10 == 255) {
                        break;
                    }
                    if (objArr[i10].equals(obj)) {
                        throw duplicateKeyException(obj, obj2, objArr, i10);
                    }
                    iSmear = i6 + 1;
                }
                bArr[i6] = (byte) i9;
                i8++;
            }
            return bArr;
        }
        if (i2 <= 32768) {
            short[] sArr = new short[i2];
            Arrays.fill(sArr, (short) -1);
            while (i8 < i) {
                int i11 = i8 + i8 + i3;
                Object obj3 = objArr[i11];
                Object obj4 = objArr[i11 ^ 1];
                CollectPreconditions.checkEntryNotNull(obj3, obj4);
                int iSmear2 = Hashing.smear(obj3.hashCode());
                while (true) {
                    i5 = iSmear2 & i7;
                    char c = (char) sArr[i5];
                    if (c == 65535) {
                        break;
                    }
                    if (objArr[c].equals(obj3)) {
                        throw duplicateKeyException(obj3, obj4, objArr, c);
                    }
                    iSmear2 = i5 + 1;
                }
                sArr[i5] = (short) i11;
                i8++;
            }
            return sArr;
        }
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        while (i8 < i) {
            int i12 = i8 + i8 + i3;
            Object obj5 = objArr[i12];
            Object obj6 = objArr[i12 ^ 1];
            CollectPreconditions.checkEntryNotNull(obj5, obj6);
            int iSmear3 = Hashing.smear(obj5.hashCode());
            while (true) {
                i4 = iSmear3 & i7;
                int i13 = iArr[i4];
                if (i13 == -1) {
                    break;
                }
                if (objArr[i13].equals(obj5)) {
                    throw duplicateKeyException(obj5, obj6, objArr, i13);
                }
                iSmear3 = i4 + 1;
            }
            iArr[i4] = i12;
            i8++;
        }
        return iArr;
    }

    static Object get(Object obj, Object[] objArr, int i, int i2, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[i2].equals(obj2)) {
                return objArr[i2 ^ 1];
            }
            return null;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int iSmear = Hashing.smear(obj2.hashCode());
            while (true) {
                int i3 = iSmear & length;
                int i4 = bArr[i3] & 255;
                if (i4 == 255) {
                    return null;
                }
                if (objArr[i4].equals(obj2)) {
                    return objArr[i4 ^ 1];
                }
                iSmear = i3 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int iSmear2 = Hashing.smear(obj2.hashCode());
            while (true) {
                int i5 = iSmear2 & length2;
                char c = (char) sArr[i5];
                if (c == 65535) {
                    return null;
                }
                if (objArr[c].equals(obj2)) {
                    return objArr[c ^ 1];
                }
                iSmear2 = i5 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int iSmear3 = Hashing.smear(obj2.hashCode());
            while (true) {
                int i6 = iSmear3 & length3;
                int i7 = iArr[i6];
                if (i7 == -1) {
                    return null;
                }
                if (objArr[i7].equals(obj2)) {
                    return objArr[i7 ^ 1];
                }
                iSmear3 = i6 + 1;
            }
        }
    }
}
