package androidx.media3.common.util;

import androidx.annotation.Nullable;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes.dex */
public final class TimedValueQueue<V> {
    private int first;
    private int size;
    private long[] timestamps;
    private Object[] values;

    public TimedValueQueue() {
        this(10);
    }

    public TimedValueQueue(int i) {
        this.timestamps = new long[i];
        this.values = newArray(i);
    }

    public synchronized void add(long j, V v) {
        clearBufferOnTimeDiscontinuity(j);
        doubleCapacityIfFull();
        addUnchecked(j, v);
    }

    public synchronized void clear() {
        this.first = 0;
        this.size = 0;
        Arrays.fill(this.values, (Object) null);
    }

    public synchronized int size() {
        return this.size;
    }

    @Nullable
    public synchronized V pollFirst() {
        return this.size == 0 ? null : (V) popFirst();
    }

    @Nullable
    public synchronized V pollFloor(long j) {
        return (V) poll(j, true);
    }

    @Nullable
    public synchronized V poll(long j) {
        return (V) poll(j, false);
    }

    private Object poll(long j, boolean z) {
        Object objPopFirst = null;
        long j2 = Long.MAX_VALUE;
        while (this.size > 0) {
            long j3 = j - this.timestamps[this.first];
            if (j3 < 0 && (z || (-j3) >= j2)) {
                break;
            }
            objPopFirst = popFirst();
            j2 = j3;
        }
        return objPopFirst;
    }

    private Object popFirst() {
        Assertions.checkState(this.size > 0);
        Object[] objArr = this.values;
        int i = this.first;
        Object obj = objArr[i];
        objArr[i] = null;
        this.first = (i + 1) % objArr.length;
        this.size--;
        return obj;
    }

    private void clearBufferOnTimeDiscontinuity(long j) {
        if (this.size > 0) {
            if (j <= this.timestamps[((this.first + r0) - 1) % this.values.length]) {
                clear();
            }
        }
    }

    private void doubleCapacityIfFull() {
        int length = this.values.length;
        if (this.size < length) {
            return;
        }
        int i = length * 2;
        long[] jArr = new long[i];
        Object[] objArrNewArray = newArray(i);
        int i2 = this.first;
        int i3 = length - i2;
        System.arraycopy(this.timestamps, i2, jArr, 0, i3);
        System.arraycopy(this.values, this.first, objArrNewArray, 0, i3);
        int i4 = this.first;
        if (i4 > 0) {
            System.arraycopy(this.timestamps, 0, jArr, i3, i4);
            System.arraycopy(this.values, 0, objArrNewArray, i3, this.first);
        }
        this.timestamps = jArr;
        this.values = objArrNewArray;
        this.first = 0;
    }

    private void addUnchecked(long j, Object obj) {
        int i = this.first;
        int i2 = this.size;
        Object[] objArr = this.values;
        int length = (i + i2) % objArr.length;
        this.timestamps[length] = j;
        objArr[length] = obj;
        this.size = i2 + 1;
    }

    private static Object[] newArray(int i) {
        return new Object[i];
    }
}
