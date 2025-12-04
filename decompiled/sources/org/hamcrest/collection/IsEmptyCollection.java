package org.hamcrest.collection;

import java.util.Collection;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/* loaded from: classes6.dex */
public class IsEmptyCollection<E> extends TypeSafeMatcher<Collection<? extends E>> {
    @Override // org.hamcrest.TypeSafeMatcher
    public boolean matchesSafely(Collection<? extends E> collection) {
        return collection.isEmpty();
    }

    @Override // org.hamcrest.TypeSafeMatcher
    public void describeMismatchSafely(Collection<? extends E> collection, Description description) {
        description.appendValue(collection);
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("an empty collection");
    }

    @Factory
    public static <E> Matcher<Collection<? extends E>> empty() {
        return new IsEmptyCollection();
    }

    @Factory
    public static <E> Matcher<Collection<E>> emptyCollectionOf(Class<E> cls) {
        return empty();
    }
}
