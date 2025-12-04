package org.hamcrest.collection;

import java.util.Collection;
import org.hamcrest.Factory;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.core.IsEqual;

/* loaded from: classes6.dex */
public class IsCollectionWithSize<E> extends FeatureMatcher<Collection<? extends E>, Integer> {
    public IsCollectionWithSize(Matcher<? super Integer> matcher) {
        super(matcher, "a collection with size", "collection size");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.hamcrest.FeatureMatcher
    public Integer featureValueOf(Collection<? extends E> collection) {
        return Integer.valueOf(collection.size());
    }

    @Factory
    public static <E> Matcher<Collection<? extends E>> hasSize(Matcher<? super Integer> matcher) {
        return new IsCollectionWithSize(matcher);
    }

    @Factory
    public static <E> Matcher<Collection<? extends E>> hasSize(int i) {
        return hasSize((Matcher<? super Integer>) IsEqual.equalTo(Integer.valueOf(i)));
    }
}
