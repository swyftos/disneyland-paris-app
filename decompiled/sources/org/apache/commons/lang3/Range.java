package org.apache.commons.lang3;

import ch.qos.logback.classic.pattern.CallerDataConverter;
import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes6.dex */
public final class Range<T> implements Serializable {
    private static final long serialVersionUID = 1;
    private final Comparator comparator;
    private transient int hashCode;
    private final Object maximum;
    private final Object minimum;
    private transient String toString;

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/lang/Comparable<TT;>;>(TT;)Lorg/apache/commons/lang3/Range<TT;>; */
    public static Range is(Comparable comparable) {
        return between(comparable, comparable, null);
    }

    public static <T> Range<T> is(T t, Comparator<T> comparator) {
        return between(t, t, comparator);
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/lang/Comparable<TT;>;>(TT;TT;)Lorg/apache/commons/lang3/Range<TT;>; */
    public static Range between(Comparable comparable, Comparable comparable2) {
        return between(comparable, comparable2, null);
    }

    public static <T> Range<T> between(T t, T t2, Comparator<T> comparator) {
        return new Range<>(t, t2, comparator);
    }

    private Range(Object obj, Object obj2, Comparator comparator) {
        if (obj == null || obj2 == null) {
            throw new IllegalArgumentException("Elements in a range must not be null: element1=" + obj + ", element2=" + obj2);
        }
        if (comparator == null) {
            this.comparator = ComparableComparator.INSTANCE;
        } else {
            this.comparator = comparator;
        }
        if (this.comparator.compare(obj, obj2) < 1) {
            this.minimum = obj;
            this.maximum = obj2;
        } else {
            this.minimum = obj2;
            this.maximum = obj;
        }
    }

    public T getMinimum() {
        return (T) this.minimum;
    }

    public T getMaximum() {
        return (T) this.maximum;
    }

    public Comparator<T> getComparator() {
        return this.comparator;
    }

    public boolean isNaturalOrdering() {
        return this.comparator == ComparableComparator.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean contains(T t) {
        return t != null && this.comparator.compare(t, this.minimum) > -1 && this.comparator.compare(t, this.maximum) < 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isAfter(T t) {
        return t != null && this.comparator.compare(t, this.minimum) < 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isStartedBy(T t) {
        return t != null && this.comparator.compare(t, this.minimum) == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isEndedBy(T t) {
        return t != null && this.comparator.compare(t, this.maximum) == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isBefore(T t) {
        return t != null && this.comparator.compare(t, this.maximum) > 0;
    }

    public int elementCompareTo(T t) {
        Validate.notNull(t, "Element is null", new Object[0]);
        if (isAfter(t)) {
            return -1;
        }
        return isBefore(t) ? 1 : 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsRange(Range<T> range) {
        return range != null && contains(range.minimum) && contains(range.maximum);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isAfterRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return isAfter(range.maximum);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isOverlappedBy(Range<T> range) {
        if (range == 0) {
            return false;
        }
        return range.contains(this.minimum) || range.contains(this.maximum) || contains(range.minimum);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isBeforeRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return isBefore(range.minimum);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Range<T> intersectionWith(Range<T> range) {
        if (!isOverlappedBy(range)) {
            throw new IllegalArgumentException(String.format("Cannot calculate intersection with non-overlapping range %s", range));
        }
        if (equals(range)) {
            return this;
        }
        return between(getComparator().compare(this.minimum, range.minimum) < 0 ? range.minimum : this.minimum, getComparator().compare(this.maximum, range.maximum) < 0 ? this.maximum : range.maximum, getComparator());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != Range.class) {
            return false;
        }
        Range range = (Range) obj;
        return this.minimum.equals(range.minimum) && this.maximum.equals(range.maximum);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.maximum.hashCode() + ((((629 + Range.class.hashCode()) * 37) + this.minimum.hashCode()) * 37);
        this.hashCode = iHashCode;
        return iHashCode;
    }

    public String toString() {
        if (this.toString == null) {
            this.toString = "[" + this.minimum + CallerDataConverter.DEFAULT_RANGE_DELIMITER + this.maximum + "]";
        }
        return this.toString;
    }

    public String toString(String str) {
        return String.format(str, this.minimum, this.maximum, this.comparator);
    }

    private enum ComparableComparator implements Comparator {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }
}
