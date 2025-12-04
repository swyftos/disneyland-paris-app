package org.hamcrest.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.hamcrest.core.IsEqual;

/* loaded from: classes6.dex */
public class IsIterableContainingInAnyOrder<T> extends TypeSafeDiagnosingMatcher<Iterable<? extends T>> {
    private final Collection matchers;

    public IsIterableContainingInAnyOrder(Collection<Matcher<? super T>> collection) {
        this.matchers = collection;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.hamcrest.TypeSafeDiagnosingMatcher
    public boolean matchesSafely(Iterable<? extends T> iterable, Description description) {
        Matching matching = new Matching(this.matchers, description);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!matching.matches(it.next())) {
                return false;
            }
        }
        return matching.isFinished(iterable);
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("iterable over ").appendList("[", ", ", "]", this.matchers).appendText(" in any order");
    }

    private static class Matching {
        private final Collection matchers;
        private final Description mismatchDescription;

        public Matching(Collection collection, Description description) {
            this.matchers = new ArrayList(collection);
            this.mismatchDescription = description;
        }

        public boolean matches(Object obj) {
            return isNotSurplus(obj) && isMatched(obj);
        }

        public boolean isFinished(Iterable iterable) {
            if (this.matchers.isEmpty()) {
                return true;
            }
            this.mismatchDescription.appendText("No item matches: ").appendList("", ", ", "", this.matchers).appendText(" in ").appendValueList("[", ", ", "]", iterable);
            return false;
        }

        private boolean isNotSurplus(Object obj) {
            if (!this.matchers.isEmpty()) {
                return true;
            }
            this.mismatchDescription.appendText("Not matched: ").appendValue(obj);
            return false;
        }

        private boolean isMatched(Object obj) {
            for (Matcher matcher : this.matchers) {
                if (matcher.matches(obj)) {
                    this.matchers.remove(matcher);
                    return true;
                }
            }
            this.mismatchDescription.appendText("Not matched: ").appendValue(obj);
            return false;
        }
    }

    @Factory
    @Deprecated
    public static <E> Matcher<Iterable<? extends E>> containsInAnyOrder(Matcher<? super E> matcher) {
        return containsInAnyOrder(new ArrayList(Arrays.asList(matcher)));
    }

    @Factory
    public static <T> Matcher<Iterable<? extends T>> containsInAnyOrder(Matcher<? super T>... matcherArr) {
        return containsInAnyOrder(Arrays.asList(matcherArr));
    }

    @Factory
    public static <T> Matcher<Iterable<? extends T>> containsInAnyOrder(T... tArr) {
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            arrayList.add(IsEqual.equalTo(t));
        }
        return new IsIterableContainingInAnyOrder(arrayList);
    }

    @Factory
    public static <T> Matcher<Iterable<? extends T>> containsInAnyOrder(Collection<Matcher<? super T>> collection) {
        return new IsIterableContainingInAnyOrder(collection);
    }
}
