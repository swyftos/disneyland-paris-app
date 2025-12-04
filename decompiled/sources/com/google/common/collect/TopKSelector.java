package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
final class TopKSelector {
    private final Object[] buffer;
    private int bufferSize;
    private final Comparator comparator;
    private final int k;
    private Object threshold;

    public static TopKSelector least(int i, Comparator comparator) {
        return new TopKSelector(comparator, i);
    }

    private TopKSelector(Comparator comparator, int i) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator, "comparator");
        this.k = i;
        Preconditions.checkArgument(i >= 0, "k (%s) must be >= 0", i);
        Preconditions.checkArgument(i <= 1073741823, "k (%s) must be <= Integer.MAX_VALUE / 2", i);
        this.buffer = new Object[IntMath.checkedMultiply(i, 2)];
        this.bufferSize = 0;
        this.threshold = null;
    }

    public void offer(Object obj) {
        int i = this.k;
        if (i == 0) {
            return;
        }
        int i2 = this.bufferSize;
        if (i2 == 0) {
            this.buffer[0] = obj;
            this.threshold = obj;
            this.bufferSize = 1;
            return;
        }
        if (i2 < i) {
            Object[] objArr = this.buffer;
            this.bufferSize = i2 + 1;
            objArr[i2] = obj;
            if (this.comparator.compare(obj, NullnessCasts.uncheckedCastNullableTToT(this.threshold)) > 0) {
                this.threshold = obj;
                return;
            }
            return;
        }
        if (this.comparator.compare(obj, NullnessCasts.uncheckedCastNullableTToT(this.threshold)) < 0) {
            Object[] objArr2 = this.buffer;
            int i3 = this.bufferSize;
            int i4 = i3 + 1;
            this.bufferSize = i4;
            objArr2[i3] = obj;
            if (i4 == this.k * 2) {
                trim();
            }
        }
    }

    private void trim() {
        int i = (this.k * 2) - 1;
        int iLog2 = IntMath.log2(i, RoundingMode.CEILING) * 3;
        int iMax = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (iMax >= i) {
                break;
            }
            int iPartition = partition(iMax, i, ((iMax + i) + 1) >>> 1);
            int i4 = this.k;
            if (iPartition <= i4) {
                if (iPartition >= i4) {
                    break;
                }
                iMax = Math.max(iPartition, iMax + 1);
                i3 = iPartition;
            } else {
                i = iPartition - 1;
            }
            i2++;
            if (i2 >= iLog2) {
                Arrays.sort(this.buffer, iMax, i + 1, this.comparator);
                break;
            }
        }
        this.bufferSize = this.k;
        this.threshold = NullnessCasts.uncheckedCastNullableTToT(this.buffer[i3]);
        while (true) {
            i3++;
            if (i3 >= this.k) {
                return;
            }
            if (this.comparator.compare(NullnessCasts.uncheckedCastNullableTToT(this.buffer[i3]), NullnessCasts.uncheckedCastNullableTToT(this.threshold)) > 0) {
                this.threshold = this.buffer[i3];
            }
        }
    }

    private int partition(int i, int i2, int i3) {
        Object objUncheckedCastNullableTToT = NullnessCasts.uncheckedCastNullableTToT(this.buffer[i3]);
        Object[] objArr = this.buffer;
        objArr[i3] = objArr[i2];
        int i4 = i;
        while (i < i2) {
            if (this.comparator.compare(NullnessCasts.uncheckedCastNullableTToT(this.buffer[i]), objUncheckedCastNullableTToT) < 0) {
                swap(i4, i);
                i4++;
            }
            i++;
        }
        Object[] objArr2 = this.buffer;
        objArr2[i2] = objArr2[i4];
        objArr2[i4] = objUncheckedCastNullableTToT;
        return i4;
    }

    private void swap(int i, int i2) {
        Object[] objArr = this.buffer;
        Object obj = objArr[i];
        objArr[i] = objArr[i2];
        objArr[i2] = obj;
    }

    public void offerAll(Iterator it) {
        while (it.hasNext()) {
            offer(it.next());
        }
    }

    public List topK() {
        Object[] objArr = this.buffer;
        Arrays.sort(objArr, 0, this.bufferSize, this.comparator);
        int i = this.bufferSize;
        int i2 = this.k;
        if (i > i2) {
            Object[] objArr2 = this.buffer;
            Arrays.fill(objArr2, i2, objArr2.length, (Object) null);
            int i3 = this.k;
            this.bufferSize = i3;
            this.threshold = this.buffer[i3 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(objArr, this.bufferSize)));
    }
}
