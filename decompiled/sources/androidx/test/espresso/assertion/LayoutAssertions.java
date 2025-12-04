package androidx.test.espresso.assertion;

import android.graphics.Rect;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Predicate;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.matcher.LayoutMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import junit.framework.AssertionFailedError;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

/* loaded from: classes2.dex */
public final class LayoutAssertions {

    static class NoOverlapsViewAssertion implements ViewAssertion {
        private final Matcher selector;

        private NoOverlapsViewAssertion(Matcher matcher) {
            this.selector = matcher;
        }

        @Override // androidx.test.espresso.ViewAssertion
        public void check(View view, NoMatchingViewException noMatchingViewException) {
            Predicate<View> predicate = new Predicate<View>() { // from class: androidx.test.espresso.assertion.LayoutAssertions.NoOverlapsViewAssertion.1
                @Override // androidx.test.espresso.core.internal.deps.guava.base.Predicate
                public boolean apply(View view2) {
                    return NoOverlapsViewAssertion.this.selector.matches(view2);
                }
            };
            if (noMatchingViewException != null) {
                throw noMatchingViewException;
            }
            LinkedList linkedList = new LinkedList();
            StringBuilder sb = new StringBuilder();
            for (View view2 : Iterables.filter(TreeIterables.breadthFirstViewTraversal(view), predicate)) {
                Rect rect = LayoutAssertions.getRect(view2);
                if (!rect.isEmpty() && (!(view2 instanceof TextView) || ((TextView) view2).getText().length() != 0)) {
                    Iterator it = linkedList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        View view3 = (View) it.next();
                        if (!(view2 instanceof ImageView) || !(view3 instanceof ImageView)) {
                            if (Rect.intersects(rect, LayoutAssertions.getRect(view3))) {
                                if (sb.length() > 0) {
                                    sb.append(",\n\n");
                                }
                                sb.append(String.format(Locale.ROOT, "%s overlaps\n%s", HumanReadables.describe(view2), HumanReadables.describe(view3)));
                            }
                        }
                    }
                    linkedList.add(view2);
                }
            }
            if (sb.length() > 0) {
                throw new AssertionFailedError(sb.toString());
            }
        }

        public String toString() {
            return String.format(Locale.ROOT, "NoOverlapsViewAssertion{selector=%s}", this.selector);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Rect getRect(View view) {
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        return new Rect(iArr[0], iArr[1], (view.getWidth() + r0) - 1, (iArr[1] + view.getHeight()) - 1);
    }

    public static ViewAssertion noEllipsizedText() {
        return ViewAssertions.selectedDescendantsMatch(ViewMatchers.isAssignableFrom(TextView.class), Matchers.not((Matcher) LayoutMatchers.hasEllipsizedText()));
    }

    public static ViewAssertion noMultilineButtons() {
        return ViewAssertions.selectedDescendantsMatch(ViewMatchers.isAssignableFrom(Button.class), Matchers.not((Matcher) LayoutMatchers.hasMultilineText()));
    }

    public static ViewAssertion noOverlaps() {
        return noOverlaps(Matchers.allOf(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE), Matchers.anyOf(ViewMatchers.isAssignableFrom(TextView.class), ViewMatchers.isAssignableFrom(ImageView.class))));
    }

    public static ViewAssertion noOverlaps(Matcher<View> matcher) {
        return new NoOverlapsViewAssertion((Matcher) Preconditions.checkNotNull(matcher));
    }
}
