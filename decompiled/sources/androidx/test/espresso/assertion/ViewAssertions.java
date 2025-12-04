package androidx.test.espresso.assertion;

import android.util.Log;
import android.view.View;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Predicate;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.remote.annotation.RemoteMsgConstructor;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;
import java.util.ArrayList;
import java.util.Locale;
import junit.framework.AssertionFailedError;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.StringDescription;

/* loaded from: classes2.dex */
public final class ViewAssertions {
    private static final String TAG = "ViewAssertions";

    static class DoesNotExistViewAssertion implements ViewAssertion {
        @RemoteMsgConstructor
        private DoesNotExistViewAssertion() {
        }

        @Override // androidx.test.espresso.ViewAssertion
        public void check(View view, NoMatchingViewException noMatchingViewException) {
            if (view != null) {
                String strValueOf = String.valueOf(HumanReadables.describe(view));
                ViewMatchers.assertThat(strValueOf.length() != 0 ? "View is present in the hierarchy: ".concat(strValueOf) : new String("View is present in the hierarchy: "), Boolean.TRUE, Matchers.is(Boolean.FALSE));
            }
        }
    }

    static class MatchesViewAssertion implements ViewAssertion {
        final Matcher viewMatcher;

        private MatchesViewAssertion(Matcher matcher) {
            this.viewMatcher = matcher;
        }

        @Override // androidx.test.espresso.ViewAssertion
        public void check(View view, NoMatchingViewException noMatchingViewException) {
            StringDescription stringDescription = new StringDescription();
            stringDescription.appendText("'");
            this.viewMatcher.describeTo(stringDescription);
            if (noMatchingViewException == null) {
                stringDescription.appendText("' doesn't match the selected view.");
                ViewMatchers.assertThat(stringDescription.toString(), view, this.viewMatcher);
            } else {
                stringDescription.appendText(String.format(Locale.ROOT, "' check could not be performed because view '%s' was not found.\n", noMatchingViewException.getViewMatcherDescription()));
                Log.e(ViewAssertions.TAG, stringDescription.toString());
                throw noMatchingViewException;
            }
        }

        public String toString() {
            return String.format(Locale.ROOT, "MatchesViewAssertion{viewMatcher=%s}", this.viewMatcher);
        }
    }

    static class SelectedDescendantsMatchViewAssertion implements ViewAssertion {
        private final Matcher matcher;
        private final Matcher selector;

        private SelectedDescendantsMatchViewAssertion(Matcher matcher, Matcher matcher2) {
            this.selector = matcher;
            this.matcher = matcher2;
        }

        @Override // androidx.test.espresso.ViewAssertion
        public void check(View view, NoMatchingViewException noMatchingViewException) {
            Preconditions.checkNotNull(view);
            ArrayList arrayList = new ArrayList();
            for (View view2 : Iterables.filter(TreeIterables.breadthFirstViewTraversal(view), new Predicate<View>() { // from class: androidx.test.espresso.assertion.ViewAssertions.SelectedDescendantsMatchViewAssertion.1
                @Override // androidx.test.espresso.core.internal.deps.guava.base.Predicate
                public boolean apply(View view3) {
                    return SelectedDescendantsMatchViewAssertion.this.selector.matches(view3);
                }
            })) {
                if (!this.matcher.matches(view2)) {
                    arrayList.add(view2);
                }
            }
            if (arrayList.size() > 0) {
                throw new AssertionFailedError(HumanReadables.getViewHierarchyErrorMessage(view, arrayList, String.format(Locale.ROOT, "At least one view did not match the required matcher: %s", this.matcher), "****DOES NOT MATCH****"));
            }
        }

        public String toString() {
            return String.format(Locale.ROOT, "SelectedDescendantsMatchViewAssertion{selector=%s, matcher=%s}", this.selector, this.matcher);
        }
    }

    public static ViewAssertion doesNotExist() {
        return new DoesNotExistViewAssertion();
    }

    public static ViewAssertion matches(Matcher<? super View> matcher) {
        return new MatchesViewAssertion((Matcher) Preconditions.checkNotNull(matcher));
    }

    public static ViewAssertion selectedDescendantsMatch(Matcher<View> matcher, Matcher<View> matcher2) {
        return new SelectedDescendantsMatchViewAssertion(matcher, matcher2);
    }
}
