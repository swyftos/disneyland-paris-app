package org.hamcrest.collection;

import java.util.Arrays;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsEqual;

/* loaded from: classes6.dex */
public class IsArrayContaining<T> extends TypeSafeMatcher<T[]> {
    private final Matcher elementMatcher;

    public IsArrayContaining(Matcher<? super T> matcher) {
        this.elementMatcher = matcher;
    }

    @Override // org.hamcrest.TypeSafeMatcher
    public boolean matchesSafely(T[] tArr) {
        for (T t : tArr) {
            if (this.elementMatcher.matches(t)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.hamcrest.TypeSafeMatcher
    public void describeMismatchSafely(T[] tArr, Description description) {
        super.describeMismatch(Arrays.asList(tArr), description);
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("an array containing ").appendDescriptionOf(this.elementMatcher);
    }

    @Factory
    public static <T> Matcher<T[]> hasItemInArray(Matcher<? super T> matcher) {
        return new IsArrayContaining(matcher);
    }

    @Factory
    public static <T> Matcher<T[]> hasItemInArray(T t) {
        return hasItemInArray(IsEqual.equalTo(t));
    }
}
