package com.urbanairship.app;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.Predicate;

/* loaded from: classes5.dex */
public class FilteredActivityListener implements ActivityListener {
    private final Predicate filter;
    private final ActivityListener listener;

    public FilteredActivityListener(@NonNull ActivityListener activityListener, @NonNull Predicate<Activity> predicate) {
        this.listener = activityListener;
        this.filter = predicate;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        if (this.filter.apply(activity)) {
            this.listener.onActivityCreated(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        if (this.filter.apply(activity)) {
            this.listener.onActivityStarted(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        if (this.filter.apply(activity)) {
            this.listener.onActivityResumed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
        if (this.filter.apply(activity)) {
            this.listener.onActivityPaused(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
        if (this.filter.apply(activity)) {
            this.listener.onActivityStopped(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        if (this.filter.apply(activity)) {
            this.listener.onActivitySaveInstanceState(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        if (this.filter.apply(activity)) {
            this.listener.onActivityDestroyed(activity);
        }
    }
}
