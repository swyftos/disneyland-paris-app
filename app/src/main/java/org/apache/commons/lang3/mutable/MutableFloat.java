package org.apache.commons.lang3.mutable;

/* JADX INFO: loaded from: classes6.dex */
public class MutableFloat extends Number implements Comparable<MutableFloat>, Mutable<Number> {
    private static final long serialVersionUID = 5787169186L;
    private float value;

    public MutableFloat() {
    }

    public MutableFloat(float f) {
        this.value = f;
    }

    public MutableFloat(Number number) {
        this.value = number.floatValue();
    }

    public MutableFloat(String str) {
        this.value = Float.parseFloat(str);
    }

    public void add(float f) {
        this.value += f;
    }

    public void add(Number number) {
        this.value += number.floatValue();
    }

    public float addAndGet(float f) {
        float f2 = this.value + f;
        this.value = f2;
        return f2;
    }

    public float addAndGet(Number number) {
        float fFloatValue = this.value + number.floatValue();
        this.value = fFloatValue;
        return fFloatValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(MutableFloat mutableFloat) {
        return Float.compare(this.value, mutableFloat.value);
    }

    public void decrement() {
        this.value -= 1.0f;
    }

    public float decrementAndGet() {
        float f = this.value - 1.0f;
        this.value = f;
        return f;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableFloat) && Float.floatToIntBits(((MutableFloat) obj).value) == Float.floatToIntBits(this.value);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    public float getAndAdd(float f) {
        float f2 = this.value;
        this.value = f + f2;
        return f2;
    }

    public float getAndAdd(Number number) {
        float f = this.value;
        this.value = number.floatValue() + f;
        return f;
    }

    public float getAndDecrement() {
        float f = this.value;
        this.value = f - 1.0f;
        return f;
    }

    public float getAndIncrement() {
        float f = this.value;
        this.value = 1.0f + f;
        return f;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    @Deprecated
    /* JADX INFO: renamed from: getValue */
    public Number getValue2() {
        return Float.valueOf(this.value);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value);
    }

    public void increment() {
        this.value += 1.0f;
    }

    public float incrementAndGet() {
        float f = this.value + 1.0f;
        this.value = f;
        return f;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    public boolean isInfinite() {
        return Float.isInfinite(this.value);
    }

    public boolean isNaN() {
        return Float.isNaN(this.value);
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) this.value;
    }

    public void setValue(float f) {
        this.value = f;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        this.value = number.floatValue();
    }

    public void subtract(float f) {
        this.value -= f;
    }

    public void subtract(Number number) {
        this.value -= number.floatValue();
    }

    public Float toFloat() {
        return Float.valueOf(floatValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }
}
