package androidx.test.internal.runner.lifecycle;

import android.app.Activity;
import android.os.Looper;
import android.util.Log;
import androidx.test.internal.util.Checks;
import androidx.test.runner.lifecycle.ActivityLifecycleCallback;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitor;
import androidx.test.runner.lifecycle.Stage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class ActivityLifecycleMonitorImpl implements ActivityLifecycleMonitor {
    private List activityStatuses;
    private final List callbacks;
    private final boolean declawThreadCheck;

    public ActivityLifecycleMonitorImpl() {
        this(false);
    }

    public ActivityLifecycleMonitorImpl(boolean z) {
        this.callbacks = new ArrayList();
        this.activityStatuses = new ArrayList();
        this.declawThreadCheck = z;
    }

    @Override // androidx.test.runner.lifecycle.ActivityLifecycleMonitor
    public void addLifecycleCallback(ActivityLifecycleCallback activityLifecycleCallback) {
        Checks.checkNotNull(activityLifecycleCallback);
        synchronized (this.callbacks) {
            try {
                Iterator it = this.callbacks.iterator();
                boolean z = true;
                while (it.hasNext()) {
                    ActivityLifecycleCallback activityLifecycleCallback2 = (ActivityLifecycleCallback) ((WeakReference) it.next()).get();
                    if (activityLifecycleCallback2 == null) {
                        it.remove();
                    } else if (activityLifecycleCallback2 == activityLifecycleCallback) {
                        z = false;
                    }
                }
                if (z) {
                    this.callbacks.add(new WeakReference(activityLifecycleCallback));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.test.runner.lifecycle.ActivityLifecycleMonitor
    public void removeLifecycleCallback(ActivityLifecycleCallback activityLifecycleCallback) {
        Checks.checkNotNull(activityLifecycleCallback);
        synchronized (this.callbacks) {
            try {
                Iterator it = this.callbacks.iterator();
                while (it.hasNext()) {
                    ActivityLifecycleCallback activityLifecycleCallback2 = (ActivityLifecycleCallback) ((WeakReference) it.next()).get();
                    if (activityLifecycleCallback2 == null) {
                        it.remove();
                    } else if (activityLifecycleCallback2 == activityLifecycleCallback) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.test.runner.lifecycle.ActivityLifecycleMonitor
    public Stage getLifecycleStageOf(Activity activity) {
        checkMainThread();
        Checks.checkNotNull(activity);
        Iterator it = this.activityStatuses.iterator();
        while (it.hasNext()) {
            ActivityStatus activityStatus = (ActivityStatus) it.next();
            Activity activity2 = (Activity) activityStatus.activityRef.get();
            if (activity2 == null) {
                it.remove();
            } else if (activity == activity2) {
                return activityStatus.lifecycleStage;
            }
        }
        String strValueOf = String.valueOf(activity);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 18);
        sb.append("Unknown activity: ");
        sb.append(strValueOf);
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // androidx.test.runner.lifecycle.ActivityLifecycleMonitor
    public Collection<Activity> getActivitiesInStage(Stage stage) {
        checkMainThread();
        Checks.checkNotNull(stage);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.activityStatuses.iterator();
        while (it.hasNext()) {
            ActivityStatus activityStatus = (ActivityStatus) it.next();
            Activity activity = (Activity) activityStatus.activityRef.get();
            if (activity == null) {
                it.remove();
            } else if (stage == activityStatus.lifecycleStage) {
                arrayList.add(activity);
            }
        }
        return arrayList;
    }

    public void signalLifecycleChange(Stage stage, Activity activity) {
        String strValueOf = String.valueOf(activity);
        String strValueOf2 = String.valueOf(stage);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 30 + strValueOf2.length());
        sb.append("Lifecycle status change: ");
        sb.append(strValueOf);
        sb.append(" in: ");
        sb.append(strValueOf2);
        Log.d("LifecycleMonitor", sb.toString());
        Iterator it = this.activityStatuses.iterator();
        boolean z = true;
        while (it.hasNext()) {
            ActivityStatus activityStatus = (ActivityStatus) it.next();
            Activity activity2 = (Activity) activityStatus.activityRef.get();
            if (activity2 == null) {
                it.remove();
            } else if (activity == activity2) {
                activityStatus.lifecycleStage = stage;
                z = false;
            }
        }
        if (z) {
            this.activityStatuses.add(new ActivityStatus(activity, stage));
        }
        synchronized (this.callbacks) {
            Iterator it2 = this.callbacks.iterator();
            while (it2.hasNext()) {
                ActivityLifecycleCallback activityLifecycleCallback = (ActivityLifecycleCallback) ((WeakReference) it2.next()).get();
                if (activityLifecycleCallback == null) {
                    it2.remove();
                } else {
                    try {
                        activityLifecycleCallback.onActivityLifecycleChanged(activity, stage);
                    } catch (RuntimeException e) {
                        Log.e("LifecycleMonitor", String.format("Callback threw exception! (callback: %s activity: %s stage: %s)", activityLifecycleCallback, activity, stage), e);
                    }
                }
            }
        }
    }

    private void checkMainThread() {
        if (!this.declawThreadCheck && !Thread.currentThread().equals(Looper.getMainLooper().getThread())) {
            throw new IllegalStateException("Querying activity state off main thread is not allowed.");
        }
    }

    private static class ActivityStatus {
        private final WeakReference activityRef;
        private Stage lifecycleStage;

        ActivityStatus(Activity activity, Stage stage) {
            this.activityRef = new WeakReference((Activity) Checks.checkNotNull(activity));
            this.lifecycleStage = (Stage) Checks.checkNotNull(stage);
        }
    }
}
