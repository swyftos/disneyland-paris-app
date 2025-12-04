package androidx.test.espresso.matcher;

import android.text.Layout;
import android.view.View;
import android.widget.TextView;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/* loaded from: classes2.dex */
public final class LayoutMatchers {
    public static Matcher<View> hasEllipsizedText() {
        return new TypeSafeMatcher<View>(TextView.class) { // from class: androidx.test.espresso.matcher.LayoutMatchers.1
            @Override // org.hamcrest.SelfDescribing
            public void describeTo(Description description) {
                description.appendText("has ellipsized text");
            }

            @Override // org.hamcrest.TypeSafeMatcher
            public boolean matchesSafely(View view) {
                int lineCount;
                Layout layout = ((TextView) view).getLayout();
                return layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount + (-1)) > 0;
            }
        };
    }

    public static Matcher<View> hasMultilineText() {
        return new TypeSafeMatcher<View>(TextView.class) { // from class: androidx.test.espresso.matcher.LayoutMatchers.2
            @Override // org.hamcrest.SelfDescribing
            public void describeTo(Description description) {
                description.appendText("has more than one line of text");
            }

            @Override // org.hamcrest.TypeSafeMatcher
            public boolean matchesSafely(View view) {
                return ((TextView) view).getLineCount() > 1;
            }
        };
    }
}
