package org.hamcrest;

/* loaded from: classes6.dex */
public abstract class Condition<T> {
    public static final NotMatched NOT_MATCHED = new NotMatched();

    public interface Step<I, O> {
        Condition<O> apply(I i, Description description);
    }

    public abstract <U> Condition<U> and(Step<? super T, U> step);

    public abstract boolean matching(Matcher<T> matcher, String str);

    private Condition() {
    }

    public final boolean matching(Matcher<T> matcher) {
        return matching(matcher, "");
    }

    public final <U> Condition<U> then(Step<? super T, U> step) {
        return and(step);
    }

    public static <T> Condition<T> notMatched() {
        return NOT_MATCHED;
    }

    public static <T> Condition<T> matched(T t, Description description) {
        return new Matched(t, description);
    }

    private static final class Matched extends Condition {
        private final Description mismatch;
        private final Object theValue;

        private Matched(Object obj, Description description) {
            super();
            this.theValue = obj;
            this.mismatch = description;
        }

        @Override // org.hamcrest.Condition
        public boolean matching(Matcher matcher, String str) {
            if (matcher.matches(this.theValue)) {
                return true;
            }
            this.mismatch.appendText(str);
            matcher.describeMismatch(this.theValue, this.mismatch);
            return false;
        }

        @Override // org.hamcrest.Condition
        public Condition and(Step step) {
            return step.apply(this.theValue, this.mismatch);
        }
    }

    private static final class NotMatched extends Condition {
        @Override // org.hamcrest.Condition
        public boolean matching(Matcher matcher, String str) {
            return false;
        }

        private NotMatched() {
            super();
        }

        @Override // org.hamcrest.Condition
        public Condition and(Step step) {
            return Condition.notMatched();
        }
    }
}
