package org.hamcrest;

/* loaded from: classes6.dex */
public class JavaLangMatcherAssert {
    public static <T> boolean that(T t, Matcher<? super T> matcher) {
        return matcher.matches(t);
    }
}
