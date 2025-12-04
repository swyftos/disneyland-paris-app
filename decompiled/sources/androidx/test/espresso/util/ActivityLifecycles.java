package androidx.test.espresso.util;

import androidx.test.runner.lifecycle.ActivityLifecycleMonitor;
import androidx.test.runner.lifecycle.Stage;

/* loaded from: classes2.dex */
public final class ActivityLifecycles {
    public static boolean hasForegroundActivities(ActivityLifecycleMonitor activityLifecycleMonitor) {
        return !activityLifecycleMonitor.getActivitiesInStage(Stage.RESUMED).isEmpty();
    }

    public static boolean hasTransitioningActivities(ActivityLifecycleMonitor activityLifecycleMonitor) {
        return (activityLifecycleMonitor.getActivitiesInStage(Stage.RESTARTED).isEmpty() && activityLifecycleMonitor.getActivitiesInStage(Stage.STARTED).isEmpty() && activityLifecycleMonitor.getActivitiesInStage(Stage.PAUSED).isEmpty()) ? false : true;
    }

    public static boolean hasVisibleActivities(ActivityLifecycleMonitor activityLifecycleMonitor) {
        return hasForegroundActivities(activityLifecycleMonitor) || hasTransitioningActivities(activityLifecycleMonitor);
    }
}
