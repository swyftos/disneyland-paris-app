package org.hamcrest.object;

import org.hamcrest.Factory;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.core.IsEqual;

/* JADX INFO: loaded from: classes.dex */
public class HasToString<T> extends FeatureMatcher<T, String> {
    public HasToString(Matcher<? super String> matcher) {
        super(matcher, "with toString()", "toString()");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.hamcrest.FeatureMatcher
    public String featureValueOf(T t) {
        return String.valueOf(t);
    }

    @Factory
    public static <T> Matcher<T> hasToString(Matcher<? super String> matcher) {
        return new HasToString(matcher);
    }

    @Factory
    public static <T> Matcher<T> hasToString(String str) {
        return new HasToString(IsEqual.equalTo(str));
    }
}
