package org.hamcrest.collection;

import java.util.Arrays;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/* loaded from: classes6.dex */
public class IsArray<T> extends TypeSafeMatcher<T[]> {
    private final Matcher[] elementMatchers;

    public IsArray(Matcher<? super T>[] matcherArr) {
        this.elementMatchers = (Matcher[]) matcherArr.clone();
    }

    @Override // org.hamcrest.TypeSafeMatcher
    public boolean matchesSafely(T[] tArr) {
        if (tArr.length != this.elementMatchers.length) {
            return false;
        }
        for (int i = 0; i < tArr.length; i++) {
            if (!this.elementMatchers[i].matches(tArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // org.hamcrest.TypeSafeMatcher
    public void describeMismatchSafely(T[] tArr, Description description) {
        if (tArr.length != this.elementMatchers.length) {
            description.appendText("array length was " + tArr.length);
            return;
        }
        for (int i = 0; i < tArr.length; i++) {
            if (!this.elementMatchers[i].matches(tArr[i])) {
                description.appendText("element " + i + " was ").appendValue(tArr[i]);
                return;
            }
        }
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendList(descriptionStart(), descriptionSeparator(), descriptionEnd(), Arrays.asList(this.elementMatchers));
    }

    protected String descriptionStart() {
        return "[";
    }

    protected String descriptionSeparator() {
        return ", ";
    }

    protected String descriptionEnd() {
        return "]";
    }

    @Factory
    public static <T> IsArray<T> array(Matcher<? super T>... matcherArr) {
        return new IsArray<>(matcherArr);
    }
}
