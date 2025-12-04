package androidx.test.espresso.action;

import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.action.EspressoKey;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

/* loaded from: classes2.dex */
public final class ViewActions {
    private static Set globalAssertions = new CopyOnWriteArraySet();

    public static ViewAction actionWithAssertions(final ViewAction viewAction) {
        return globalAssertions.isEmpty() ? viewAction : new ViewAction() { // from class: androidx.test.espresso.action.ViewActions.1
            @Override // androidx.test.espresso.ViewAction
            public Matcher getConstraints() {
                return viewAction.getConstraints();
            }

            @Override // androidx.test.espresso.ViewAction
            public String getDescription() {
                StringBuilder sb = new StringBuilder("Running view assertions[");
                Iterator it = ViewActions.globalAssertions.iterator();
                while (it.hasNext()) {
                    sb.append((String) ((Pair) it.next()).first);
                    sb.append(", ");
                }
                sb.append("] and then running: ");
                sb.append(viewAction.getDescription());
                return sb.toString();
            }

            @Override // androidx.test.espresso.ViewAction
            public void perform(UiController uiController, View view) {
                for (Pair pair : ViewActions.globalAssertions) {
                    String strValueOf = String.valueOf((String) pair.first);
                    Log.i("ViewAssertion", strValueOf.length() != 0 ? "Asserting ".concat(strValueOf) : new String("Asserting "));
                    ((ViewAssertion) pair.second).check(view, null);
                }
                viewAction.perform(uiController, view);
            }
        };
    }

    public static void addGlobalAssertion(String str, ViewAssertion viewAssertion) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(viewAssertion);
        Pair pair = new Pair(str, viewAssertion);
        Preconditions.checkArgument(!globalAssertions.contains(pair), "ViewAssertion with name %s is already in the global assertions!", str);
        globalAssertions.add(pair);
    }

    public static void clearGlobalAssertions() {
        globalAssertions.clear();
    }

    public static ViewAction clearText() {
        return actionWithAssertions(new ReplaceTextAction(""));
    }

    public static ViewAction click() {
        return actionWithAssertions(new GeneralClickAction(Tap.SINGLE, GeneralLocation.VISIBLE_CENTER, Press.FINGER, 0, 1));
    }

    public static ViewAction closeSoftKeyboard() {
        return actionWithAssertions(new CloseKeyboardAction());
    }

    public static ViewAction doubleClick() {
        return actionWithAssertions(new GeneralClickAction(Tap.DOUBLE, GeneralLocation.CENTER, Press.FINGER, 0, 1));
    }

    public static ViewAction longClick() {
        return actionWithAssertions(new GeneralClickAction(Tap.LONG, GeneralLocation.CENTER, Press.FINGER, 0, 1));
    }

    public static ViewAction openLink(Matcher<String> matcher, Matcher<Uri> matcher2) {
        Preconditions.checkNotNull(matcher);
        Preconditions.checkNotNull(matcher2);
        return actionWithAssertions(new OpenLinkAction(matcher, matcher2));
    }

    public static ViewAction openLinkWithText(String str) {
        return openLinkWithText((Matcher<String>) Matchers.is(str));
    }

    public static ViewAction openLinkWithUri(String str) {
        return openLinkWithUri((Matcher<Uri>) Matchers.is(Uri.parse(str)));
    }

    public static ViewAction pressBack() {
        return actionWithAssertions(new PressBackAction(true));
    }

    public static ViewAction pressBackUnconditionally() {
        return actionWithAssertions(new PressBackAction(false));
    }

    public static ViewAction pressImeActionButton() {
        return actionWithAssertions(new EditorAction());
    }

    public static ViewAction pressKey(int i) {
        return actionWithAssertions(new KeyEventAction(new EspressoKey.Builder().withKeyCode(i).build()));
    }

    public static ViewAction pressMenuKey() {
        return pressKey(82);
    }

    public static ViewAction repeatedlyUntil(ViewAction viewAction, Matcher<View> matcher, int i) {
        Preconditions.checkNotNull(viewAction);
        Preconditions.checkNotNull(matcher);
        return actionWithAssertions(new RepeatActionUntilViewState(viewAction, matcher, i));
    }

    public static ViewAction replaceText(String str) {
        return actionWithAssertions(new ReplaceTextAction(str));
    }

    public static ViewAction scrollTo() {
        return actionWithAssertions(new ScrollToAction());
    }

    public static ViewAction swipeDown() {
        return actionWithAssertions(new GeneralSwipeAction(Swipe.FAST, GeneralLocation.translate(GeneralLocation.TOP_CENTER, BitmapDescriptorFactory.HUE_RED, 0.083f), GeneralLocation.BOTTOM_CENTER, Press.FINGER));
    }

    public static ViewAction swipeLeft() {
        return actionWithAssertions(new GeneralSwipeAction(Swipe.FAST, GeneralLocation.translate(GeneralLocation.CENTER_RIGHT, -0.083f, BitmapDescriptorFactory.HUE_RED), GeneralLocation.CENTER_LEFT, Press.FINGER));
    }

    public static ViewAction swipeRight() {
        return actionWithAssertions(new GeneralSwipeAction(Swipe.FAST, GeneralLocation.translate(GeneralLocation.CENTER_LEFT, 0.083f, BitmapDescriptorFactory.HUE_RED), GeneralLocation.CENTER_RIGHT, Press.FINGER));
    }

    public static ViewAction swipeUp() {
        return actionWithAssertions(new GeneralSwipeAction(Swipe.FAST, GeneralLocation.translate(GeneralLocation.BOTTOM_CENTER, BitmapDescriptorFactory.HUE_RED, -0.083f), GeneralLocation.TOP_CENTER, Press.FINGER));
    }

    public static ViewAction typeText(String str) {
        return actionWithAssertions(new TypeTextAction(str));
    }

    public static ViewAction typeTextIntoFocusedView(String str) {
        return actionWithAssertions(new TypeTextAction(str, false));
    }

    public static ViewAction openLinkWithText(Matcher<String> matcher) {
        return openLink(matcher, Matchers.any(Uri.class));
    }

    public static ViewAction openLinkWithUri(Matcher<Uri> matcher) {
        return openLink(Matchers.any(String.class), matcher);
    }

    public static void removeGlobalAssertion(ViewAssertion viewAssertion) {
        while (true) {
            boolean z = false;
            for (Pair pair : globalAssertions) {
                if (viewAssertion != null && viewAssertion.equals(pair.second)) {
                    if (z || globalAssertions.remove(pair)) {
                        z = true;
                    }
                }
            }
            Preconditions.checkArgument(z, "ViewAssertion was not in global assertions!");
            return;
        }
    }

    public static ViewAction pressKey(EspressoKey espressoKey) {
        return actionWithAssertions(new KeyEventAction(espressoKey));
    }

    public static ViewAction click(int i, int i2) {
        return actionWithAssertions(new GeneralClickAction(Tap.SINGLE, GeneralLocation.VISIBLE_CENTER, Press.FINGER, i, i2));
    }

    public static ViewAction click(ViewAction viewAction) {
        Preconditions.checkNotNull(viewAction);
        return actionWithAssertions(new GeneralClickAction(Tap.SINGLE, GeneralLocation.CENTER, Press.FINGER, 0, 1, viewAction));
    }
}
