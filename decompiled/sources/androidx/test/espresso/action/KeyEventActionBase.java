package androidx.test.espresso.action;

import android.app.Activity;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import androidx.test.espresso.InjectEventSecurityException;
import androidx.test.espresso.NoActivityResumedException;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.ActivityLifecycles;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitor;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.Stage;
import java.util.Locale;
import org.hamcrest.Matcher;

/* loaded from: classes2.dex */
abstract class KeyEventActionBase implements ViewAction {
    public static final int BACK_ACTIVITY_TRANSITION_MILLIS_DELAY = 150;
    public static final int CLEAR_TRANSITIONING_ACTIVITIES_ATTEMPTS = 4;
    public static final int CLEAR_TRANSITIONING_ACTIVITIES_MILLIS_DELAY = 150;
    final EspressoKey espressoKey;

    KeyEventActionBase(EspressoKey espressoKey) {
        this.espressoKey = (EspressoKey) Preconditions.checkNotNull(espressoKey);
    }

    static Activity getCurrentActivity() {
        return (Activity) Iterables.getOnlyElement(ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED));
    }

    private static boolean isActivityResumed(Activity activity) {
        return ActivityLifecycleMonitorRegistry.getInstance().getLifecycleStageOf(activity) == Stage.RESUMED;
    }

    static void waitForPendingForegroundActivities(UiController uiController, boolean z) {
        ActivityLifecycleMonitor activityLifecycleMonitorRegistry = ActivityLifecycleMonitorRegistry.getInstance();
        boolean zHasTransitioningActivities = false;
        for (int i = 0; i < 4; i++) {
            uiController.loopMainThreadUntilIdle();
            zHasTransitioningActivities = ActivityLifecycles.hasTransitioningActivities(activityLifecycleMonitorRegistry);
            if (!zHasTransitioningActivities) {
                break;
            }
            uiController.loopMainThreadForAtLeast(150L);
        }
        if (!ActivityLifecycles.hasForegroundActivities(activityLifecycleMonitorRegistry)) {
            if (z) {
                throw new NoActivityResumedException("Pressed back and killed the app");
            }
            Log.w("KeyEventActionBase", "Pressed back and hopped to a different process or potentially killed the app");
        }
        if (zHasTransitioningActivities) {
            Log.w("KeyEventActionBase", "Back was pressed and left the application in an inconsistent state even after 600ms.");
        }
    }

    static void waitForStageChangeInitialActivity(UiController uiController, Activity activity) {
        if (isActivityResumed(activity)) {
            uiController.loopMainThreadForAtLeast(150L);
            if (isActivityResumed(activity)) {
                Log.i("KeyEventActionBase", "Back was pressed but there was no Activity stage transition in 150ms. Pressing back may trigger an activity stage transition if the activity is finished as a result. However, the activity may handle the back behavior in any number of other ways internally as well, such as popping the fragment back stack, dismissing a dialog, otherwise manually transacting fragments, etc.");
            }
        }
    }

    @Override // androidx.test.espresso.ViewAction
    public Matcher getConstraints() {
        return ViewMatchers.isDisplayed();
    }

    @Override // androidx.test.espresso.ViewAction
    public String getDescription() {
        return String.format(Locale.ROOT, "send %s key event", this.espressoKey);
    }

    @Override // androidx.test.espresso.ViewAction
    public void perform(UiController uiController, View view) {
        try {
            if (sendKeyEvent(uiController)) {
                return;
            }
            String strValueOf = String.valueOf(this.espressoKey);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 36);
            sb.append("Failed to inject espressoKey event: ");
            sb.append(strValueOf);
            Log.e("KeyEventActionBase", sb.toString());
            PerformException.Builder builderWithViewDescription = new PerformException.Builder().withActionDescription(getDescription()).withViewDescription(HumanReadables.describe(view));
            String strValueOf2 = String.valueOf(this.espressoKey);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 35);
            sb2.append("Failed to inject espressoKey event ");
            sb2.append(strValueOf2);
            throw builderWithViewDescription.withCause(new RuntimeException(sb2.toString())).build();
        } catch (InjectEventSecurityException e) {
            String strValueOf3 = String.valueOf(this.espressoKey);
            StringBuilder sb3 = new StringBuilder(strValueOf3.length() + 36);
            sb3.append("Failed to inject espressoKey event: ");
            sb3.append(strValueOf3);
            Log.e("KeyEventActionBase", sb3.toString());
            throw new PerformException.Builder().withActionDescription(getDescription()).withViewDescription(HumanReadables.describe(view)).withCause(e).build();
        }
    }

    private boolean sendKeyEvent(UiController uiController) throws InjectEventSecurityException {
        long jUptimeMillis = SystemClock.uptimeMillis();
        boolean zInjectKeyEvent = false;
        boolean zInjectKeyEvent2 = false;
        for (int i = 0; !zInjectKeyEvent2 && i < 4; i++) {
            zInjectKeyEvent2 = uiController.injectKeyEvent(new KeyEvent(jUptimeMillis, jUptimeMillis, 0, this.espressoKey.getKeyCode(), 0, this.espressoKey.getMetaState()));
        }
        if (!zInjectKeyEvent2) {
            return false;
        }
        long jUptimeMillis2 = SystemClock.uptimeMillis();
        for (int i2 = 0; !zInjectKeyEvent && i2 < 4; i2++) {
            zInjectKeyEvent = uiController.injectKeyEvent(new KeyEvent(jUptimeMillis2, jUptimeMillis2, 1, this.espressoKey.getKeyCode(), 0, this.espressoKey.getMetaState()));
        }
        return zInjectKeyEvent;
    }
}
