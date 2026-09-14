package org.apache.commons.lang3.compare;

import java.util.function.Predicate;
import org.apache.commons.lang3.ObjectUtils;

/* JADX INFO: loaded from: classes6.dex */
public class ComparableUtils {

    public static class ComparableCheckBuilder<A extends Comparable<A>> {

        /* JADX INFO: renamed from: a */
        private final Comparable f3989a;

        private ComparableCheckBuilder(Comparable comparable) {
            this.f3989a = comparable;
        }

        public boolean between(A a2, A a3) {
            return betweenOrdered(a2, a3) || betweenOrdered(a3, a2);
        }

        public boolean betweenExclusive(A a2, A a3) {
            return betweenOrderedExclusive(a2, a3) || betweenOrderedExclusive(a3, a2);
        }

        private boolean betweenOrdered(Comparable comparable, Comparable comparable2) {
            return greaterThanOrEqualTo(comparable) && lessThanOrEqualTo(comparable2);
        }

        private boolean betweenOrderedExclusive(Comparable comparable, Comparable comparable2) {
            return greaterThan(comparable) && lessThan(comparable2);
        }

        public boolean equalTo(A a2) {
            Comparable comparable = this.f3989a;
            return comparable != null && comparable.compareTo(a2) == 0;
        }

        public boolean greaterThan(A a2) {
            Comparable comparable = this.f3989a;
            return comparable != null && comparable.compareTo(a2) > 0;
        }

        public boolean greaterThanOrEqualTo(A a2) {
            Comparable comparable = this.f3989a;
            return comparable != null && comparable.compareTo(a2) >= 0;
        }

        public boolean lessThan(A a2) {
            Comparable comparable = this.f3989a;
            return comparable != null && comparable.compareTo(a2) < 0;
        }

        public boolean lessThanOrEqualTo(A a2) {
            Comparable comparable = this.f3989a;
            return comparable != null && comparable.compareTo(a2) <= 0;
        }
    }

    public static <A extends Comparable<A>> Predicate<A> between(final A a2, final A a3) {
        return new Predicate() { // from class: org.apache.commons.lang3.compare.ComparableUtils$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ComparableUtils.lambda$between$0(a2, a3, (Comparable) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$between$0(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return m1955is(comparable3).between(comparable, comparable2);
    }

    public static <A extends Comparable<A>> Predicate<A> betweenExclusive(final A a2, final A a3) {
        return new Predicate() { // from class: org.apache.commons.lang3.compare.ComparableUtils$$ExternalSyntheticLambda3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ComparableUtils.lambda$betweenExclusive$0(a2, a3, (Comparable) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$betweenExclusive$0(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return m1955is(comparable3).betweenExclusive(comparable, comparable2);
    }

    /* JADX INFO: renamed from: ge */
    public static <A extends Comparable<A>> Predicate<A> m1953ge(final A a2) {
        return new Predicate() { // from class: org.apache.commons.lang3.compare.ComparableUtils$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ComparableUtils.lambda$ge$0(a2, (Comparable) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$ge$0(Comparable comparable, Comparable comparable2) {
        return m1955is(comparable2).greaterThanOrEqualTo(comparable);
    }

    /* JADX INFO: renamed from: gt */
    public static <A extends Comparable<A>> Predicate<A> m1954gt(final A a2) {
        return new Predicate() { // from class: org.apache.commons.lang3.compare.ComparableUtils$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ComparableUtils.lambda$gt$0(a2, (Comparable) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$gt$0(Comparable comparable, Comparable comparable2) {
        return m1955is(comparable2).greaterThan(comparable);
    }

    /* JADX INFO: renamed from: is */
    public static <A extends Comparable<A>> ComparableCheckBuilder<A> m1955is(A a2) {
        return new ComparableCheckBuilder<>(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$le$0(Comparable comparable, Comparable comparable2) {
        return m1955is(comparable2).lessThanOrEqualTo(comparable);
    }

    /* JADX INFO: renamed from: le */
    public static <A extends Comparable<A>> Predicate<A> m1956le(final A a2) {
        return new Predicate() { // from class: org.apache.commons.lang3.compare.ComparableUtils$$ExternalSyntheticLambda5
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ComparableUtils.lambda$le$0(a2, (Comparable) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$lt$0(Comparable comparable, Comparable comparable2) {
        return m1955is(comparable2).lessThan(comparable);
    }

    /* JADX INFO: renamed from: lt */
    public static <A extends Comparable<A>> Predicate<A> m1957lt(final A a2) {
        return new Predicate() { // from class: org.apache.commons.lang3.compare.ComparableUtils$$ExternalSyntheticLambda4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ComparableUtils.lambda$lt$0(a2, (Comparable) obj);
            }
        };
    }

    public static <A extends Comparable<A>> A max(A a2, A a3) {
        return ObjectUtils.compare(a2, a3, false) > 0 ? a2 : a3;
    }

    public static <A extends Comparable<A>> A min(A a2, A a3) {
        return ObjectUtils.compare(a2, a3, true) < 0 ? a2 : a3;
    }
}
