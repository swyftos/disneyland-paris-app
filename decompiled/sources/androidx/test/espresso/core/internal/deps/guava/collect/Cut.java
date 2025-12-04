package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.primitives.Booleans;
import ch.qos.logback.core.CoreConstants;
import java.io.Serializable;
import java.lang.Comparable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes2.dex */
abstract class Cut<C extends Comparable> implements Comparable<Cut<C>>, Serializable {
    private static final long serialVersionUID = 0;
    final Comparable endpoint;

    private static final class AboveAll extends Cut<Comparable<?>> {
        private static final AboveAll INSTANCE = new AboveAll();
        private static final long serialVersionUID = 0;

        private AboveAll() {
            super(null);
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut, java.lang.Comparable
        public int compareTo(Cut cut) {
            return cut == this ? 0 : 1;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        void describeAsLowerBound(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        void describeAsUpperBound(StringBuilder sb) {
            sb.append("+∞)");
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        boolean isLessThan(Comparable comparable) {
            return false;
        }

        public String toString() {
            return "+∞";
        }
    }

    private static final class AboveValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        AboveValue(Comparable comparable) {
            super((Comparable) Preconditions.checkNotNull(comparable));
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        void describeAsLowerBound(StringBuilder sb) {
            sb.append(CoreConstants.LEFT_PARENTHESIS_CHAR);
            sb.append(this.endpoint);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        void describeAsUpperBound(StringBuilder sb) {
            sb.append(this.endpoint);
            sb.append(AbstractJsonLexerKt.END_LIST);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        public int hashCode() {
            return ~this.endpoint.hashCode();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        boolean isLessThan(Comparable comparable) {
            return Range.compareOrThrow(this.endpoint, comparable) < 0;
        }

        public String toString() {
            String strValueOf = String.valueOf(this.endpoint);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 2);
            sb.append("/");
            sb.append(strValueOf);
            sb.append("\\");
            return sb.toString();
        }
    }

    private static final class BelowAll extends Cut<Comparable<?>> {
        private static final BelowAll INSTANCE = new BelowAll();
        private static final long serialVersionUID = 0;

        private BelowAll() {
            super(null);
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut, java.lang.Comparable
        public int compareTo(Cut cut) {
            return cut == this ? 0 : -1;
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        void describeAsLowerBound(StringBuilder sb) {
            sb.append("(-∞");
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        void describeAsUpperBound(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        boolean isLessThan(Comparable comparable) {
            return true;
        }

        public String toString() {
            return "-∞";
        }
    }

    private static final class BelowValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        BelowValue(Comparable comparable) {
            super((Comparable) Preconditions.checkNotNull(comparable));
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        void describeAsLowerBound(StringBuilder sb) {
            sb.append(AbstractJsonLexerKt.BEGIN_LIST);
            sb.append(this.endpoint);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        void describeAsUpperBound(StringBuilder sb) {
            sb.append(this.endpoint);
            sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        public int hashCode() {
            return this.endpoint.hashCode();
        }

        @Override // androidx.test.espresso.core.internal.deps.guava.collect.Cut
        boolean isLessThan(Comparable comparable) {
            return Range.compareOrThrow(this.endpoint, comparable) <= 0;
        }

        public String toString() {
            String strValueOf = String.valueOf(this.endpoint);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 2);
            sb.append("\\");
            sb.append(strValueOf);
            sb.append("/");
            return sb.toString();
        }
    }

    Cut(Comparable comparable) {
        this.endpoint = comparable;
    }

    static Cut aboveAll() {
        return AboveAll.INSTANCE;
    }

    static Cut aboveValue(Comparable comparable) {
        return new AboveValue(comparable);
    }

    static Cut belowAll() {
        return BelowAll.INSTANCE;
    }

    static Cut belowValue(Comparable comparable) {
        return new BelowValue(comparable);
    }

    @Override // java.lang.Comparable
    public int compareTo(Cut cut) {
        if (cut == belowAll()) {
            return 1;
        }
        if (cut == aboveAll()) {
            return -1;
        }
        int iCompareOrThrow = Range.compareOrThrow(this.endpoint, cut.endpoint);
        return iCompareOrThrow != 0 ? iCompareOrThrow : Booleans.compare(this instanceof AboveValue, cut instanceof AboveValue);
    }

    abstract void describeAsLowerBound(StringBuilder sb);

    abstract void describeAsUpperBound(StringBuilder sb);

    public boolean equals(Object obj) {
        if (!(obj instanceof Cut)) {
            return false;
        }
        try {
            return compareTo((Cut) obj) == 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public abstract int hashCode();

    abstract boolean isLessThan(Comparable comparable);
}
