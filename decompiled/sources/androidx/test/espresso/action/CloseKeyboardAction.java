package androidx.test.espresso.action;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables;
import androidx.test.espresso.remote.annotation.RemoteMsgConstructor;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitor;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.Stage;
import java.util.Collection;
import java.util.concurrent.TimeoutException;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

/* loaded from: classes2.dex */
public final class CloseKeyboardAction implements ViewAction {
    private static final String TAG = "CloseKeyboardAction";

    private static class CloseKeyboardIdlingResult extends ResultReceiver implements IdlingResource {
        private final Handler handler;
        private boolean idle;
        private boolean receivedResult;
        private IdlingResource.ResourceCallback resourceCallback;
        private int result;
        private boolean timedOut;

        private CloseKeyboardIdlingResult(Handler handler) {
            super(handler);
            this.receivedResult = false;
            this.result = -1;
            this.timedOut = false;
            this.idle = false;
            this.handler = handler;
        }

        private void notifyEspresso(long j) {
            Preconditions.checkState(this.receivedResult);
            this.handler.postDelayed(new Runnable() { // from class: androidx.test.espresso.action.CloseKeyboardAction.CloseKeyboardIdlingResult.2
                @Override // java.lang.Runnable
                public void run() {
                    CloseKeyboardIdlingResult.this.idle = true;
                    if (CloseKeyboardIdlingResult.this.resourceCallback != null) {
                        CloseKeyboardIdlingResult.this.resourceCallback.onTransitionToIdle();
                    }
                }
            }, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void scheduleTimeout(long j) {
            this.handler.postDelayed(new Runnable() { // from class: androidx.test.espresso.action.CloseKeyboardAction.CloseKeyboardIdlingResult.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CloseKeyboardIdlingResult.this.receivedResult) {
                        return;
                    }
                    CloseKeyboardIdlingResult.this.timedOut = true;
                    if (CloseKeyboardIdlingResult.this.resourceCallback != null) {
                        CloseKeyboardIdlingResult.this.resourceCallback.onTransitionToIdle();
                    }
                }
            }, j);
        }

        @Override // androidx.test.espresso.IdlingResource
        public String getName() {
            return "CloseKeyboardIdlingResource";
        }

        @Override // androidx.test.espresso.IdlingResource
        public boolean isIdleNow() {
            return this.idle || this.timedOut;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i, Bundle bundle) {
            this.result = i;
            this.receivedResult = true;
            notifyEspresso(300L);
        }

        @Override // androidx.test.espresso.IdlingResource
        public void registerIdleTransitionCallback(IdlingResource.ResourceCallback resourceCallback) {
            this.resourceCallback = resourceCallback;
        }
    }

    @RemoteMsgConstructor
    public CloseKeyboardAction() {
    }

    private static Activity getRootActivity(UiController uiController) {
        ActivityLifecycleMonitor activityLifecycleMonitorRegistry = ActivityLifecycleMonitorRegistry.getInstance();
        Stage stage = Stage.RESUMED;
        Collection<Activity> activitiesInStage = activityLifecycleMonitorRegistry.getActivitiesInStage(stage);
        if (activitiesInStage.isEmpty()) {
            uiController.loopMainThreadUntilIdle();
            activitiesInStage = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(stage);
        }
        Preconditions.checkState(activitiesInStage.size() == 1, "More than one activity is in RESUMED stage. There may have been an error during the activity creation/startup process, please check your logs.");
        return (Activity) Iterables.getOnlyElement(activitiesInStage);
    }

    @Override // androidx.test.espresso.ViewAction
    public Matcher<View> getConstraints() {
        return Matchers.any(View.class);
    }

    @Override // androidx.test.espresso.ViewAction
    public String getDescription() {
        return "close keyboard";
    }

    private void tryToCloseKeyboard(View view, UiController uiController) {
        InputMethodManager inputMethodManager = (InputMethodManager) getRootActivity(uiController).getSystemService("input_method");
        CloseKeyboardIdlingResult closeKeyboardIdlingResult = new CloseKeyboardIdlingResult(new Handler(Looper.getMainLooper()));
        IdlingRegistry.getInstance().register(closeKeyboardIdlingResult);
        try {
            if (!inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0, closeKeyboardIdlingResult)) {
                Log.w(TAG, "Attempting to close soft keyboard, while it is not shown.");
                IdlingRegistry.getInstance().unregister(closeKeyboardIdlingResult);
                return;
            }
            closeKeyboardIdlingResult.scheduleTimeout(2000L);
            uiController.loopMainThreadUntilIdle();
            if (closeKeyboardIdlingResult.timedOut) {
                throw new TimeoutException("Wait on operation result timed out.");
            }
            IdlingRegistry.getInstance().unregister(closeKeyboardIdlingResult);
            if (closeKeyboardIdlingResult.result == 1 || closeKeyboardIdlingResult.result == 3) {
                return;
            }
            int i = closeKeyboardIdlingResult.result;
            StringBuilder sb = new StringBuilder(105);
            sb.append("Attempt to close the soft keyboard did not result in soft keyboard to be hidden. resultCode = ");
            sb.append(i);
            String string = sb.toString();
            Log.e(TAG, string);
            throw new PerformException.Builder().withActionDescription(getDescription()).withViewDescription(HumanReadables.describe(view)).withCause(new RuntimeException(string)).build();
        } catch (Throwable th) {
            IdlingRegistry.getInstance().unregister(closeKeyboardIdlingResult);
            throw th;
        }
    }

    @Override // androidx.test.espresso.ViewAction
    public void perform(UiController uiController, View view) {
        for (int i = 0; i < 3; i++) {
            try {
                tryToCloseKeyboard(view, uiController);
                return;
            } catch (TimeoutException e) {
                Log.w(TAG, "Caught timeout exception. Retrying.");
                if (i == 2) {
                    throw new PerformException.Builder().withActionDescription(getDescription()).withViewDescription(HumanReadables.describe(view)).withCause(e).build();
                }
            }
        }
    }
}
