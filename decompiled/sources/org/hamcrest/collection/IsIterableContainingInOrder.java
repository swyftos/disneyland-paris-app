package org.hamcrest.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.SelfDescribing;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.hamcrest.core.IsEqual;

/* loaded from: classes6.dex */
public class IsIterableContainingInOrder<E> extends TypeSafeDiagnosingMatcher<Iterable<? extends E>> {
    private final List matchers;

    public IsIterableContainingInOrder(List<Matcher<? super E>> list) {
        this.matchers = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.hamcrest.TypeSafeDiagnosingMatcher
    public boolean matchesSafely(Iterable<? extends E> iterable, Description description) {
        MatchSeries matchSeries = new MatchSeries(this.matchers, description);
        Iterator<? extends E> it = iterable.iterator();
        while (it.hasNext()) {
            if (!matchSeries.matches(it.next())) {
                return false;
            }
        }
        return matchSeries.isFinished();
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("iterable containing ").appendList("[", ", ", "]", this.matchers);
    }

    private static class MatchSeries {
        public final List matchers;
        private final Description mismatchDescription;
        public int nextMatchIx = 0;

        public MatchSeries(List list, Description description) {
            this.mismatchDescription = description;
            if (list.isEmpty()) {
                throw new IllegalArgumentException("Should specify at least one expected element");
            }
            this.matchers = list;
        }

        public boolean matches(Object obj) {
            return isNotSurplus(obj) && isMatched(obj);
        }

        public boolean isFinished() {
            if (this.nextMatchIx >= this.matchers.size()) {
                return true;
            }
            this.mismatchDescription.appendText("No item matched: ").appendDescriptionOf((SelfDescribing) this.matchers.get(this.nextMatchIx));
            return false;
        }

        private boolean isMatched(Object obj) {
            Matcher matcher = (Matcher) this.matchers.get(this.nextMatchIx);
            if (!matcher.matches(obj)) {
                describeMismatch(matcher, obj);
                return false;
            }
            this.nextMatchIx++;
            return true;
        }

        private boolean isNotSurplus(Object obj) {
            if (this.matchers.size() > this.nextMatchIx) {
                return true;
            }
            this.mismatchDescription.appendText("Not matched: ").appendValue(obj);
            return false;
        }

        private void describeMismatch(Matcher matcher, Object obj) {
            this.mismatchDescription.appendText("item " + this.nextMatchIx + ": ");
            matcher.describeMismatch(obj, this.mismatchDescription);
        }
    }

    @Factory
    public static <E> Matcher<Iterable<? extends E>> contains(E... eArr) {
        ArrayList arrayList = new ArrayList();
        for (E e : eArr) {
            arrayList.add(IsEqual.equalTo(e));
        }
        return contains(arrayList);
    }

    @Factory
    public static <E> Matcher<Iterable<? extends E>> contains(Matcher<? super E> matcher) {
        return contains(new ArrayList(Arrays.asList(matcher)));
    }

    @Factory
    public static <E> Matcher<Iterable<? extends E>> contains(Matcher<? super E>... matcherArr) {
        return contains(Arrays.asList(matcherArr));
    }

    @Factory
    public static <E> Matcher<Iterable<? extends E>> contains(List<Matcher<? super E>> list) {
        return new IsIterableContainingInOrder(list);
    }
}
