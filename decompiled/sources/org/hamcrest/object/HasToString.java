package org.hamcrest.object;

import org.hamcrest.Factory;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.core.IsEqual;

/* loaded from: classes6.dex */
public class HasToString<T> extends FeatureMatcher<T, String> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.hamcrest.FeatureMatcher
    protected /* bridge */ /* synthetic */ String featureValueOf(Object obj) {
        return featureValueOf2((HasToString<T>) obj);
    }

    public HasToString(Matcher<? super String> matcher) {
        super(matcher, "with toString()", "toString()");
    }

    @Override // org.hamcrest.FeatureMatcher
    /* renamed from: featureValueOf, reason: avoid collision after fix types in other method */
    protected String featureValueOf2(T t) {
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
