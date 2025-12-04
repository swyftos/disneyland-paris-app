package androidx.test.runner.lifecycle;

import android.app.Activity;
import java.util.Collection;

/* loaded from: classes2.dex */
public interface ActivityLifecycleMonitor {
    void addLifecycleCallback(ActivityLifecycleCallback activityLifecycleCallback);

    Collection<Activity> getActivitiesInStage(Stage stage);

    Stage getLifecycleStageOf(Activity activity);

    void removeLifecycleCallback(ActivityLifecycleCallback activityLifecycleCallback);
}
