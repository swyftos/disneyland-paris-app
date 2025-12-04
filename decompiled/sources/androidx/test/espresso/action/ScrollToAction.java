package androidx.test.espresso.action;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.HumanReadables;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

/* loaded from: classes2.dex */
public final class ScrollToAction implements ViewAction {
    private static final String TAG = "ScrollToAction";

    @Override // androidx.test.espresso.ViewAction
    public Matcher<View> getConstraints() {
        return Matchers.allOf(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE), ViewMatchers.isDescendantOfA(Matchers.anyOf(ViewMatchers.isAssignableFrom(ScrollView.class), ViewMatchers.isAssignableFrom(HorizontalScrollView.class), ViewMatchers.isAssignableFrom(ListView.class))));
    }

    @Override // androidx.test.espresso.ViewAction
    public String getDescription() {
        return "scroll to";
    }

    @Override // androidx.test.espresso.ViewAction
    public void perform(UiController uiController, View view) {
        if (ViewMatchers.isDisplayingAtLeast(90).matches(view)) {
            Log.i(TAG, "View is already displayed. Returning.");
            return;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        if (!view.requestRectangleOnScreen(rect, true)) {
            Log.w(TAG, "Scrolling to view was requested, but none of the parents scrolled.");
        }
        uiController.loopMainThreadUntilIdle();
        if (!ViewMatchers.isDisplayingAtLeast(90).matches(view)) {
            throw new PerformException.Builder().withActionDescription(getDescription()).withViewDescription(HumanReadables.describe(view)).withCause(new RuntimeException("Scrolling to view was attempted, but the view is not displayed")).build();
        }
    }
}
