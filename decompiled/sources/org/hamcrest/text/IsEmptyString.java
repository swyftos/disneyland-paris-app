package org.hamcrest.text;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.core.AnyOf;
import org.hamcrest.core.IsNull;

/* loaded from: classes6.dex */
public final class IsEmptyString extends BaseMatcher<String> {
    private static final IsEmptyString INSTANCE;
    private static final Matcher NULL_OR_EMPTY_INSTANCE;

    static {
        IsEmptyString isEmptyString = new IsEmptyString();
        INSTANCE = isEmptyString;
        NULL_OR_EMPTY_INSTANCE = AnyOf.anyOf(IsNull.nullValue(), isEmptyString);
    }

    @Override // org.hamcrest.Matcher
    public boolean matches(Object obj) {
        return obj != null && (obj instanceof String) && ((String) obj).equals("");
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("an empty string");
    }

    @Factory
    public static Matcher<String> isEmptyString() {
        return INSTANCE;
    }

    @Factory
    public static Matcher<String> isEmptyOrNullString() {
        return NULL_OR_EMPTY_INSTANCE;
    }
}
