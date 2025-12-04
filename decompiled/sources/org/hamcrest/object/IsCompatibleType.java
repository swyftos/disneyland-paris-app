package org.hamcrest.object;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/* loaded from: classes6.dex */
public class IsCompatibleType<T> extends TypeSafeMatcher<Class<?>> {
    private final Class type;

    public IsCompatibleType(Class<T> cls) {
        this.type = cls;
    }

    @Override // org.hamcrest.TypeSafeMatcher
    public boolean matchesSafely(Class<?> cls) {
        return this.type.isAssignableFrom(cls);
    }

    @Override // org.hamcrest.TypeSafeMatcher
    public void describeMismatchSafely(Class<?> cls, Description description) {
        description.appendValue(cls.getName());
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("type < ").appendText(this.type.getName());
    }

    @Factory
    public static <T> Matcher<Class<?>> typeCompatibleWith(Class<T> cls) {
        return new IsCompatibleType(cls);
    }
}
