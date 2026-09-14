package org.apache.commons.lang3.util;

import com.urbanairship.channel.AttributeMutation;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Objects;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes6.dex */
public final class FluentBitSet implements Cloneable, Serializable {
    private static final long serialVersionUID = 1;
    private final BitSet bitSet;

    public FluentBitSet() {
        this(new BitSet());
    }

    public FluentBitSet(BitSet bitSet) {
        Objects.requireNonNull(bitSet, AttributeMutation.ATTRIBUTE_ACTION_SET);
        this.bitSet = bitSet;
    }

    public FluentBitSet(int i) {
        this(new BitSet(i));
    }

    public FluentBitSet and(BitSet bitSet) {
        this.bitSet.and(bitSet);
        return this;
    }

    public FluentBitSet and(FluentBitSet fluentBitSet) {
        this.bitSet.and(fluentBitSet.bitSet);
        return this;
    }

    public FluentBitSet andNot(BitSet bitSet) {
        this.bitSet.andNot(bitSet);
        return this;
    }

    public FluentBitSet andNot(FluentBitSet fluentBitSet) {
        this.bitSet.andNot(fluentBitSet.bitSet);
        return this;
    }

    public BitSet bitSet() {
        return this.bitSet;
    }

    public int cardinality() {
        return this.bitSet.cardinality();
    }

    public FluentBitSet clear() {
        this.bitSet.clear();
        return this;
    }

    public FluentBitSet clear(int... iArr) {
        for (int i : iArr) {
            this.bitSet.clear(i);
        }
        return this;
    }

    public FluentBitSet clear(int i) {
        this.bitSet.clear(i);
        return this;
    }

    public FluentBitSet clear(int i, int i2) {
        this.bitSet.clear(i, i2);
        return this;
    }

    public Object clone() {
        return new FluentBitSet((BitSet) this.bitSet.clone());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FluentBitSet) {
            return Objects.equals(this.bitSet, ((FluentBitSet) obj).bitSet);
        }
        return false;
    }

    public FluentBitSet flip(int i) {
        this.bitSet.flip(i);
        return this;
    }

    public FluentBitSet flip(int i, int i2) {
        this.bitSet.flip(i, i2);
        return this;
    }

    public boolean get(int i) {
        return this.bitSet.get(i);
    }

    public FluentBitSet get(int i, int i2) {
        return new FluentBitSet(this.bitSet.get(i, i2));
    }

    public int hashCode() {
        return this.bitSet.hashCode();
    }

    public boolean intersects(BitSet bitSet) {
        return this.bitSet.intersects(bitSet);
    }

    public boolean intersects(FluentBitSet fluentBitSet) {
        return this.bitSet.intersects(fluentBitSet.bitSet);
    }

    public boolean isEmpty() {
        return this.bitSet.isEmpty();
    }

    public int length() {
        return this.bitSet.length();
    }

    public int nextClearBit(int i) {
        return this.bitSet.nextClearBit(i);
    }

    public int nextSetBit(int i) {
        return this.bitSet.nextSetBit(i);
    }

    /* JADX INFO: renamed from: or */
    public FluentBitSet m1985or(BitSet bitSet) {
        this.bitSet.or(bitSet);
        return this;
    }

    /* JADX INFO: renamed from: or */
    public FluentBitSet m1987or(FluentBitSet... fluentBitSetArr) {
        for (FluentBitSet fluentBitSet : fluentBitSetArr) {
            this.bitSet.or(fluentBitSet.bitSet);
        }
        return this;
    }

    /* JADX INFO: renamed from: or */
    public FluentBitSet m1986or(FluentBitSet fluentBitSet) {
        this.bitSet.or(fluentBitSet.bitSet);
        return this;
    }

    public int previousClearBit(int i) {
        return this.bitSet.previousClearBit(i);
    }

    public int previousSetBit(int i) {
        return this.bitSet.previousSetBit(i);
    }

    public FluentBitSet set(int... iArr) {
        for (int i : iArr) {
            this.bitSet.set(i);
        }
        return this;
    }

    public FluentBitSet set(int i) {
        this.bitSet.set(i);
        return this;
    }

    public FluentBitSet set(int i, boolean z) {
        this.bitSet.set(i, z);
        return this;
    }

    public FluentBitSet set(int i, int i2) {
        this.bitSet.set(i, i2);
        return this;
    }

    public FluentBitSet set(int i, int i2, boolean z) {
        this.bitSet.set(i, i2, z);
        return this;
    }

    public FluentBitSet setInclusive(int i, int i2) {
        this.bitSet.set(i, i2 + 1);
        return this;
    }

    public int size() {
        return this.bitSet.size();
    }

    public IntStream stream() {
        return this.bitSet.stream();
    }

    public byte[] toByteArray() {
        return this.bitSet.toByteArray();
    }

    public long[] toLongArray() {
        return this.bitSet.toLongArray();
    }

    public String toString() {
        return this.bitSet.toString();
    }

    public FluentBitSet xor(BitSet bitSet) {
        this.bitSet.xor(bitSet);
        return this;
    }

    public FluentBitSet xor(FluentBitSet fluentBitSet) {
        this.bitSet.xor(fluentBitSet.bitSet);
        return this;
    }
}
