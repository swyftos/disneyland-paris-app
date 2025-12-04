package kotlin.ranges;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.OpenEndRange;

/* loaded from: classes5.dex */
class ComparableOpenEndRange implements OpenEndRange {
    private final Comparable endExclusive;
    private final Comparable start;

    public ComparableOpenEndRange(Comparable start, Comparable endExclusive) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(endExclusive, "endExclusive");
        this.start = start;
        this.endExclusive = endExclusive;
    }

    @Override // kotlin.ranges.OpenEndRange
    public boolean contains(Comparable comparable) {
        return OpenEndRange.DefaultImpls.contains(this, comparable);
    }

    @Override // kotlin.ranges.OpenEndRange
    public boolean isEmpty() {
        return OpenEndRange.DefaultImpls.isEmpty(this);
    }

    @Override // kotlin.ranges.OpenEndRange
    public Comparable getStart() {
        return this.start;
    }

    @Override // kotlin.ranges.OpenEndRange
    public Comparable getEndExclusive() {
        return this.endExclusive;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ComparableOpenEndRange) {
            if (!isEmpty() || !((ComparableOpenEndRange) obj).isEmpty()) {
                ComparableOpenEndRange comparableOpenEndRange = (ComparableOpenEndRange) obj;
                if (!Intrinsics.areEqual(getStart(), comparableOpenEndRange.getStart()) || !Intrinsics.areEqual(getEndExclusive(), comparableOpenEndRange.getEndExclusive())) {
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
        return getEndExclusive().hashCode() + (getStart().hashCode() * 31);
    }

    public String toString() {
        return getStart() + "..<" + getEndExclusive();
    }
}
