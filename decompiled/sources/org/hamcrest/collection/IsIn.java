package org.hamcrest.collection;

import java.util.Arrays;
import java.util.Collection;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/* loaded from: classes6.dex */
public class IsIn<T> extends BaseMatcher<T> {
    private final Collection collection;

    public IsIn(Collection<T> collection) {
        this.collection = collection;
    }

    public IsIn(T[] tArr) {
        this.collection = Arrays.asList(tArr);
    }

    @Override // org.hamcrest.Matcher
    public boolean matches(Object obj) {
        return this.collection.contains(obj);
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("one of ");
        description.appendValueList("{", ", ", "}", this.collection);
    }

    @Factory
    public static <T> Matcher<T> isIn(Collection<T> collection) {
        return new IsIn(collection);
    }

    @Factory
    public static <T> Matcher<T> isIn(T[] tArr) {
        return new IsIn(tArr);
    }

    @Factory
    public static <T> Matcher<T> isOneOf(T... tArr) {
        return isIn(tArr);
    }
}
