package org.hamcrest.text;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/* loaded from: classes6.dex */
public class IsEqualIgnoringWhiteSpace extends TypeSafeMatcher<String> {
    private final String string;

    public IsEqualIgnoringWhiteSpace(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Non-null value required by IsEqualIgnoringCase()");
        }
        this.string = str;
    }

    @Override // org.hamcrest.TypeSafeMatcher
    public boolean matchesSafely(String str) {
        return stripSpace(this.string).equalsIgnoreCase(stripSpace(str));
    }

    @Override // org.hamcrest.TypeSafeMatcher
    public void describeMismatchSafely(String str, Description description) {
        description.appendText("was  ").appendText(stripSpace(str));
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("equalToIgnoringWhiteSpace(").appendValue(this.string).appendText(")");
    }

    public String stripSpace(String str) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Character.isWhitespace(cCharAt)) {
                if (!z) {
                    sb.append(' ');
                }
                z = true;
            } else {
                sb.append(cCharAt);
                z = false;
            }
        }
        return sb.toString().trim();
    }

    @Factory
    public static Matcher<String> equalToIgnoringWhiteSpace(String str) {
        return new IsEqualIgnoringWhiteSpace(str);
    }
}
