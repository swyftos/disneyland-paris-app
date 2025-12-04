package com.urbanairship.android.layout.reporting;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.urbanairship.Predicate;
import com.urbanairship.UALog;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.FilteredActivityListener;
import com.urbanairship.app.SimpleActivityListener;
import java.lang.ref.WeakReference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class DisplayTimer {
    private long displayTime;
    private long resumeTime;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(Activity activity) {
        return true;
    }

    public DisplayTimer(@NonNull LifecycleOwner lifecycleOwner) {
        this(lifecycleOwner, 0L);
    }

    public DisplayTimer(@NonNull LifecycleOwner lifecycleOwner, long j) {
        this.resumeTime = 0L;
        this.displayTime = 0L;
        if (j > 0) {
            this.displayTime = j;
        }
        lifecycleOwner.getLifecycle().addObserver(new LifecycleListener(this));
    }

    public DisplayTimer(@NonNull ActivityMonitor activityMonitor) {
        this(activityMonitor, null, 0L);
    }

    public DisplayTimer(@NonNull ActivityMonitor activityMonitor, @Nullable Predicate<Activity> predicate, long j) {
        this.resumeTime = 0L;
        this.displayTime = 0L;
        if (j > 0) {
            this.displayTime = j;
        }
        activityMonitor.addActivityListener(new FilteredActivityListener(new DisplayActivityListener(this), predicate == null ? new Predicate() { // from class: com.urbanairship.android.layout.reporting.DisplayTimer$$ExternalSyntheticLambda0
            @Override // com.urbanairship.Predicate
            public final boolean apply(Object obj) {
                return DisplayTimer.lambda$new$0((Activity) obj);
            }
        } : predicate));
    }

    public long getTime() {
        long j = this.displayTime;
        return this.resumeTime > 0 ? j + (System.currentTimeMillis() - this.resumeTime) : j;
    }

    public void onResume() {
        this.resumeTime = System.currentTimeMillis();
    }

    public void onPause() {
        this.displayTime += System.currentTimeMillis() - this.resumeTime;
        this.resumeTime = 0L;
    }

    private static final class DisplayActivityListener extends SimpleActivityListener {
        private final WeakReference weakTimer;

        public DisplayActivityListener(DisplayTimer displayTimer) {
            this.weakTimer = new WeakReference(displayTimer);
        }

        @Override // com.urbanairship.app.SimpleActivityListener, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            DisplayTimer displayTimer = (DisplayTimer) this.weakTimer.get();
            if (displayTimer != null) {
                displayTimer.onPause();
            } else {
                UALog.w("DisplayTimer ref was null!", new Object[0]);
            }
        }

        @Override // com.urbanairship.app.SimpleActivityListener, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            DisplayTimer displayTimer = (DisplayTimer) this.weakTimer.get();
            if (displayTimer != null) {
                displayTimer.onResume();
            } else {
                UALog.w("DisplayTimer ref was null!", new Object[0]);
            }
        }
    }

    private static final class LifecycleListener implements DefaultLifecycleObserver {
        private final WeakReference weakTimer;

        public LifecycleListener(DisplayTimer displayTimer) {
            this.weakTimer = new WeakReference(displayTimer);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onResume(LifecycleOwner lifecycleOwner) {
            DisplayTimer displayTimer = (DisplayTimer) this.weakTimer.get();
            if (displayTimer != null) {
                displayTimer.onResume();
            } else {
                UALog.w("DisplayTimer ref was null!", new Object[0]);
            }
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onPause(LifecycleOwner lifecycleOwner) {
            DisplayTimer displayTimer = (DisplayTimer) this.weakTimer.get();
            if (displayTimer != null) {
                displayTimer.onPause();
            } else {
                UALog.w("DisplayTimer ref was null!", new Object[0]);
            }
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onDestroy(LifecycleOwner lifecycleOwner) {
            lifecycleOwner.getLifecycle().removeObserver(this);
        }
    }
}
