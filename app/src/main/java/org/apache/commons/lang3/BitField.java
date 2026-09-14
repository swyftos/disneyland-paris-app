package org.apache.commons.lang3;

/* JADX INFO: loaded from: classes6.dex */
public class BitField {
    private final int mask;
    private final int shiftCount;

    public BitField(int i) {
        this.mask = i;
        this.shiftCount = i == 0 ? 0 : Integer.numberOfTrailingZeros(i);
    }

    public int clear(int i) {
        return (~this.mask) & i;
    }

    public byte clearByte(byte b) {
        return (byte) clear(b);
    }

    public short clearShort(short s) {
        return (short) clear(s);
    }

    public int getRawValue(int i) {
        return this.mask & i;
    }

    public short getShortRawValue(short s) {
        return (short) getRawValue(s);
    }

    public short getShortValue(short s) {
        return (short) getValue(s);
    }

    public int getValue(int i) {
        return getRawValue(i) >> this.shiftCount;
    }

    public boolean isAllSet(int i) {
        int i2 = this.mask;
        return (i & i2) == i2;
    }

    public boolean isSet(int i) {
        return (this.mask & i) != 0;
    }

    public int set(int i) {
        return this.mask | i;
    }

    public int setBoolean(int i, boolean z) {
        return z ? set(i) : clear(i);
    }

    public byte setByte(byte b) {
        return (byte) set(b);
    }

    public byte setByteBoolean(byte b, boolean z) {
        return z ? setByte(b) : clearByte(b);
    }

    public short setShort(short s) {
        return (short) set(s);
    }

    public short setShortBoolean(short s, boolean z) {
        return z ? setShort(s) : clearShort(s);
    }

    public short setShortValue(short s, short s2) {
        return (short) setValue(s, s2);
    }

    public int setValue(int i, int i2) {
        int i3 = this.mask;
        return ((i2 << this.shiftCount) & i3) | (i & (~i3));
    }
}
