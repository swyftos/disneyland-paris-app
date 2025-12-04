package kotlin.ranges;

/* loaded from: classes5.dex */
final class OpenEndFloatRange implements OpenEndRange {
    private final float _endExclusive;
    private final float _start;

    public OpenEndFloatRange(float f, float f2) {
        this._start = f;
        this._endExclusive = f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).floatValue());
    }

    @Override // kotlin.ranges.OpenEndRange
    public Float getStart() {
        return Float.valueOf(this._start);
    }

    @Override // kotlin.ranges.OpenEndRange
    public Float getEndExclusive() {
        return Float.valueOf(this._endExclusive);
    }

    public boolean contains(float f) {
        return f >= this._start && f < this._endExclusive;
    }

    @Override // kotlin.ranges.OpenEndRange
    public boolean isEmpty() {
        return this._start >= this._endExclusive;
    }

    public boolean equals(Object obj) {
        if (obj instanceof OpenEndFloatRange) {
            if (!isEmpty() || !((OpenEndFloatRange) obj).isEmpty()) {
                OpenEndFloatRange openEndFloatRange = (OpenEndFloatRange) obj;
                if (this._start != openEndFloatRange._start || this._endExclusive != openEndFloatRange._endExclusive) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return Float.hashCode(this._endExclusive) + (Float.hashCode(this._start) * 31);
    }

    public String toString() {
        return this._start + "..<" + this._endExclusive;
    }
}
