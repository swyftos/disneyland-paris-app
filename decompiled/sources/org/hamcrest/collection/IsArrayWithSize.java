package org.hamcrest.collection;

import org.hamcrest.Factory;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.core.DescribedAs;
import org.hamcrest.core.IsEqual;

/* loaded from: classes6.dex */
public class IsArrayWithSize<E> extends FeatureMatcher<E[], Integer> {
    public IsArrayWithSize(Matcher<? super Integer> matcher) {
        super(matcher, "an array with size", "array size");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.hamcrest.FeatureMatcher
    public Integer featureValueOf(E[] eArr) {
        return Integer.valueOf(eArr.length);
    }

    @Factory
    public static <E> Matcher<E[]> arrayWithSize(Matcher<? super Integer> matcher) {
        return new IsArrayWithSize(matcher);
    }

    @Factory
    public static <E> Matcher<E[]> arrayWithSize(int i) {
        return arrayWithSize((Matcher<? super Integer>) IsEqual.equalTo(Integer.valueOf(i)));
    }

    @Factory
    public static <E> Matcher<E[]> emptyArray() {
        return DescribedAs.describedAs("an empty array", arrayWithSize(0), new Object[0]);
    }
}
