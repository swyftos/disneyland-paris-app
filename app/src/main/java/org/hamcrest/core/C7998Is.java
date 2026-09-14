package org.hamcrest.core;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/* JADX INFO: renamed from: org.hamcrest.core.Is */
/* JADX INFO: loaded from: classes6.dex */
public class C7998Is<T> extends BaseMatcher<T> {
    private final Matcher matcher;

    public C7998Is(Matcher<T> matcher) {
        this.matcher = matcher;
    }

    @Override // org.hamcrest.Matcher
    public boolean matches(Object obj) {
        return this.matcher.matches(obj);
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("is ").appendDescriptionOf(this.matcher);
    }

    @Override // org.hamcrest.BaseMatcher, org.hamcrest.Matcher
    public void describeMismatch(Object obj, Description description) {
        this.matcher.describeMismatch(obj, description);
    }

    @Factory
    /* JADX INFO: renamed from: is */
    public static <T> Matcher<T> m2127is(Matcher<T> matcher) {
        return new C7998Is(matcher);
    }

    @Factory
    /* JADX INFO: renamed from: is */
    public static <T> Matcher<T> m2126is(T t) {
        return m2127is(IsEqual.equalTo(t));
    }

    @Factory
    @Deprecated
    /* JADX INFO: renamed from: is */
    public static <T> Matcher<T> m2125is(Class<T> cls) {
        return m2127is(IsInstanceOf.instanceOf(cls));
    }

    @Factory
    public static <T> Matcher<T> isA(Class<T> cls) {
        return m2127is(IsInstanceOf.instanceOf(cls));
    }
}
