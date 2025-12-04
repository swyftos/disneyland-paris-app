package org.hamcrest.collection;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/* loaded from: classes6.dex */
public class IsEmptyIterable<E> extends TypeSafeMatcher<Iterable<? extends E>> {
    @Override // org.hamcrest.TypeSafeMatcher
    public boolean matchesSafely(Iterable<? extends E> iterable) {
        return !iterable.iterator().hasNext();
    }

    @Override // org.hamcrest.TypeSafeMatcher
    public void describeMismatchSafely(Iterable<? extends E> iterable, Description description) {
        description.appendValueList("[", ",", "]", iterable);
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("an empty iterable");
    }

    @Factory
    public static <E> Matcher<Iterable<? extends E>> emptyIterable() {
        return new IsEmptyIterable();
    }

    @Factory
    public static <E> Matcher<Iterable<E>> emptyIterableOf(Class<E> cls) {
        return emptyIterable();
    }
}
