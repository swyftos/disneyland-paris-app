package androidx.test.espresso.action;

import android.net.Uri;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.HumanReadables;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

/* loaded from: classes2.dex */
public final class OpenLinkAction implements ViewAction {
    private final Matcher linkTextMatcher;
    private final Matcher uriMatcher;

    public OpenLinkAction(Matcher<String> matcher, Matcher<Uri> matcher2) {
        this.linkTextMatcher = (Matcher) Preconditions.checkNotNull(matcher);
        this.uriMatcher = (Matcher) Preconditions.checkNotNull(matcher2);
    }

    @Override // androidx.test.espresso.ViewAction
    public Matcher<View> getConstraints() {
        return Matchers.allOf(ViewMatchers.isDisplayed(), ViewMatchers.isAssignableFrom(TextView.class), ViewMatchers.hasLinks());
    }

    @Override // androidx.test.espresso.ViewAction
    public String getDescription() {
        return String.format(Locale.ROOT, "open link with text %s and uri %s", this.linkTextMatcher, this.uriMatcher);
    }

    @Override // androidx.test.espresso.ViewAction
    public void perform(UiController uiController, View view) {
        TextView textView = (TextView) view;
        String string = textView.getText().toString();
        URLSpan[] urls = textView.getUrls();
        Spanned spanned = (Spanned) textView.getText();
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        for (URLSpan uRLSpan : urls) {
            int spanStart = spanned.getSpanStart(uRLSpan);
            boolean z = spanStart != -1;
            String strValueOf = String.valueOf(uRLSpan);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 49);
            sb.append("Unable to get start of text associated with url: ");
            sb.append(strValueOf);
            Preconditions.checkState(z, sb.toString());
            int spanEnd = spanned.getSpanEnd(uRLSpan);
            boolean z2 = spanEnd != -1;
            String strValueOf2 = String.valueOf(uRLSpan);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 47);
            sb2.append("Unable to get end of text associated with url: ");
            sb2.append(strValueOf2);
            Preconditions.checkState(z2, sb2.toString());
            String strSubstring = string.substring(spanStart, spanEnd);
            arrayListNewArrayList.add(strSubstring);
            if (this.linkTextMatcher.matches(strSubstring) && this.uriMatcher.matches(Uri.parse(uRLSpan.getURL()))) {
                uRLSpan.onClick(view);
                return;
            }
        }
        throw new PerformException.Builder().withActionDescription(getDescription()).withViewDescription(HumanReadables.describe(view)).withCause(new RuntimeException(String.format(Locale.ROOT, "Link with text '%s' and uri '%s' not found. List of links found in this view: %s\nList of uris: %s", this.linkTextMatcher, this.uriMatcher, arrayListNewArrayList, Arrays.asList(urls)))).build();
    }
}
