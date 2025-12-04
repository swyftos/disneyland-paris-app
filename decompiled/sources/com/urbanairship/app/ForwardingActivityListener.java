package com.urbanairship.app;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class ForwardingActivityListener implements ActivityListener {
    private final List listeners = new ArrayList();

    public void addListener(@NonNull ActivityListener activityListener) {
        synchronized (this.listeners) {
            this.listeners.add(activityListener);
        }
    }

    public void removeListener(@NonNull ActivityListener activityListener) {
        synchronized (this.listeners) {
            this.listeners.remove(activityListener);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        Iterator it = new ArrayList(this.listeners).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onActivityCreated(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        Iterator it = new ArrayList(this.listeners).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onActivityStarted(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        Iterator it = new ArrayList(this.listeners).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onActivityResumed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
        Iterator it = new ArrayList(this.listeners).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onActivityPaused(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
        Iterator it = new ArrayList(this.listeners).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onActivityStopped(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @Nullable Bundle bundle) {
        Iterator it = new ArrayList(this.listeners).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onActivitySaveInstanceState(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        Iterator it = new ArrayList(this.listeners).iterator();
        while (it.hasNext()) {
            ((ActivityListener) it.next()).onActivityDestroyed(activity);
        }
    }
}
