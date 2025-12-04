package io.reactivex.internal.util;

/* loaded from: classes5.dex */
public final class OpenHashSet<T> {
    Object[] keys;
    final float loadFactor;
    int mask;
    int maxSize;
    int size;

    static int mix(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    public OpenHashSet() {
        this(16, 0.75f);
    }

    public OpenHashSet(int i) {
        this(i, 0.75f);
    }

    public OpenHashSet(int i, float f) {
        this.loadFactor = f;
        int iRoundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
        this.mask = iRoundToPowerOfTwo - 1;
        this.maxSize = (int) (f * iRoundToPowerOfTwo);
        this.keys = new Object[iRoundToPowerOfTwo];
    }

    public boolean add(T t) {
        Object obj;
        Object[] objArr = this.keys;
        int i = this.mask;
        int iMix = mix(t.hashCode()) & i;
        Object obj2 = objArr[iMix];
        if (obj2 != null) {
            if (obj2.equals(t)) {
                return false;
            }
            do {
                iMix = (iMix + 1) & i;
                obj = objArr[iMix];
                if (obj == null) {
                }
            } while (!obj.equals(t));
            return false;
        }
        objArr[iMix] = t;
        int i2 = this.size + 1;
        this.size = i2;
        if (i2 >= this.maxSize) {
            rehash();
        }
        return true;
    }

    public boolean remove(T t) {
        Object obj;
        Object[] objArr = this.keys;
        int i = this.mask;
        int iMix = mix(t.hashCode()) & i;
        Object obj2 = objArr[iMix];
        if (obj2 == null) {
            return false;
        }
        if (obj2.equals(t)) {
            return removeEntry(iMix, objArr, i);
        }
        do {
            iMix = (iMix + 1) & i;
            obj = objArr[iMix];
            if (obj == null) {
                return false;
            }
        } while (!obj.equals(t));
        return removeEntry(iMix, objArr, i);
    }

    boolean removeEntry(int i, Object[] objArr, int i2) {
        int i3;
        Object obj;
        this.size--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                obj = objArr[i3];
                if (obj == null) {
                    objArr[i] = null;
                    return true;
                }
                int iMix = mix(obj.hashCode()) & i2;
                if (i <= i3) {
                    if (i >= iMix || iMix > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < iMix || iMix <= i3) {
                    i4 = i3 + 1;
                }
            }
            objArr[i] = obj;
            i = i3;
        }
    }

    void rehash() {
        Object obj;
        Object[] objArr = this.keys;
        int length = objArr.length;
        int i = length << 1;
        int i2 = i - 1;
        Object[] objArr2 = new Object[i];
        int i3 = this.size;
        while (true) {
            int i4 = i3 - 1;
            if (i3 != 0) {
                do {
                    length--;
                    obj = objArr[length];
                } while (obj == null);
                int iMix = mix(obj.hashCode()) & i2;
                if (objArr2[iMix] != null) {
                    do {
                        iMix = (iMix + 1) & i2;
                    } while (objArr2[iMix] != null);
                }
                objArr2[iMix] = objArr[length];
                i3 = i4;
            } else {
                this.mask = i2;
                this.maxSize = (int) (i * this.loadFactor);
                this.keys = objArr2;
                return;
            }
        }
    }

    public Object[] keys() {
        return this.keys;
    }

    public int size() {
        return this.size;
    }
}
