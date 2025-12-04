package androidx.test.espresso.matcher;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import androidx.test.espresso.Root;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.remote.annotation.RemoteMsgConstructor;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.Stage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;

/* loaded from: classes2.dex */
public final class RootMatchers {
    public static final Matcher<Root> DEFAULT = Matchers.allOf(hasWindowLayoutParams(), Matchers.allOf(Matchers.anyOf(Matchers.allOf(isDialog(), withDecorView(hasWindowFocus())), isSubwindowOfCurrentActivity()), isFocusable()));

    static final class HasWindowFocus extends TypeSafeMatcher<View> {
        @RemoteMsgConstructor
        public HasWindowFocus() {
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("has window focus");
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(View view) {
            return view.hasWindowFocus();
        }
    }

    static final class HasWindowLayoutParams extends TypeSafeMatcher<Root> {
        @RemoteMsgConstructor
        public HasWindowLayoutParams() {
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("has window layout params");
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(Root root) {
            return root.getWindowLayoutParams().isPresent();
        }
    }

    static final class IsDialog extends TypeSafeMatcher<Root> {
        @RemoteMsgConstructor
        public IsDialog() {
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("is dialog");
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(Root root) {
            int i = root.getWindowLayoutParams().get().type;
            return i != 1 && i < 99 && root.getDecorView().getWindowToken() == root.getDecorView().getApplicationWindowToken();
        }
    }

    static final class IsFocusable extends TypeSafeMatcher<Root> {
        @RemoteMsgConstructor
        public IsFocusable() {
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("is focusable");
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(Root root) {
            return (root.getWindowLayoutParams().get().flags & 8) != 8;
        }
    }

    static final class IsSubwindowOfCurrentActivity extends TypeSafeMatcher<Root> {
        @RemoteMsgConstructor
        public IsSubwindowOfCurrentActivity() {
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("is subwindow of current activity");
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(Root root) {
            return RootMatchers.getResumedActivityTokens().contains(root.getDecorView().getApplicationWindowToken());
        }
    }

    static final class IsSystemAlertWindow extends TypeSafeMatcher<Root> {
        @RemoteMsgConstructor
        public IsSystemAlertWindow() {
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("is system alert window");
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(Root root) {
            int i = root.getWindowLayoutParams().get().type;
            return i > 2000 && i < 2999 && root.getDecorView().getWindowToken() == root.getDecorView().getApplicationWindowToken();
        }
    }

    static final class IsTouchable extends TypeSafeMatcher<Root> {
        @RemoteMsgConstructor
        public IsTouchable() {
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("is touchable");
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(Root root) {
            return (root.getWindowLayoutParams().get().flags & 16) != 16;
        }
    }

    static final class WithDecorView extends TypeSafeMatcher<Root> {
        private final Matcher decorViewMatcher;

        public WithDecorView(Matcher matcher) {
            this.decorViewMatcher = matcher;
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with decor view ");
            this.decorViewMatcher.describeTo(description);
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(Root root) {
            return this.decorViewMatcher.matches(root.getDecorView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List getResumedActivityTokens() {
        Collection<Activity> activitiesInStage = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED);
        if (activitiesInStage.isEmpty()) {
            Log.w("RootMatchers", "suppressed: NoActivityResumedException(\"At least one activity should be in RESUMED stage.\"");
        }
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        Iterator<Activity> it = activitiesInStage.iterator();
        while (it.hasNext()) {
            arrayListNewArrayList.add(it.next().getWindow().getDecorView().getApplicationWindowToken());
        }
        return arrayListNewArrayList;
    }

    private static Matcher hasWindowFocus() {
        return new HasWindowFocus();
    }

    public static Matcher<Root> hasWindowLayoutParams() {
        return new HasWindowLayoutParams();
    }

    public static Matcher<Root> isDialog() {
        return new IsDialog();
    }

    public static Matcher<Root> isFocusable() {
        return new IsFocusable();
    }

    public static Matcher<Root> isPlatformPopup() {
        return new IsPlatformPopup();
    }

    private static Matcher isSubwindowOfCurrentActivity() {
        return new IsSubwindowOfCurrentActivity();
    }

    public static Matcher<Root> isSystemAlertWindow() {
        return new IsSystemAlertWindow();
    }

    public static Matcher<Root> isTouchable() {
        return new IsTouchable();
    }

    public static Matcher<Root> withDecorView(Matcher<View> matcher) {
        Preconditions.checkNotNull(matcher);
        return new WithDecorView(matcher);
    }

    static final class IsPlatformPopup extends TypeSafeMatcher<Root> {
        @RemoteMsgConstructor
        public IsPlatformPopup() {
        }

        @Override // org.hamcrest.SelfDescribing
        public void describeTo(Description description) {
            description.appendText("with decor view of type PopupWindow$PopupViewContainer");
        }

        @Override // org.hamcrest.TypeSafeMatcher
        public boolean matchesSafely(Root root) {
            return RootMatchers.withDecorView(ViewMatchers.withClassName(Matchers.is("android.widget.PopupWindow$PopupDecorView"))).matches(root);
        }
    }
}
