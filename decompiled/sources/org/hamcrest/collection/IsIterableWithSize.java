package org.hamcrest.collection;

import java.util.Iterator;
import org.hamcrest.Factory;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.core.IsEqual;

/* loaded from: classes6.dex */
public class IsIterableWithSize<E> extends FeatureMatcher<Iterable<E>, Integer> {
    public IsIterableWithSize(Matcher<? super Integer> matcher) {
        super(matcher, "an iterable with size", "iterable size");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.hamcrest.FeatureMatcher
    public Integer featureValueOf(Iterable<E> iterable) {
        Iterator<E> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            it.next();
        }
        return Integer.valueOf(i);
    }

    @Factory
    public static <E> Matcher<Iterable<E>> iterableWithSize(Matcher<? super Integer> matcher) {
        return new IsIterableWithSize(matcher);
    }

    @Factory
    public static <E> Matcher<Iterable<E>> iterableWithSize(int i) {
        return iterableWithSize((Matcher<? super Integer>) IsEqual.equalTo(Integer.valueOf(i)));
    }
}
