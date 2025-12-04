package com.urbanairship;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import com.urbanairship.job.JobInfo;
import com.urbanairship.job.JobResult;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public abstract class AirshipComponent {
    private final Context context;
    private final PreferenceDataStore dataStore;
    protected final Executor defaultExecutor = AirshipExecutors.newSerialExecutor();
    private final String enableKey = "airshipComponent.enable_" + getClass().getName();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getComponentGroup() {
        return -1;
    }

    @CallSuper
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void init() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean onAirshipDeepLink(@NonNull Uri uri) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @WorkerThread
    protected void onAirshipReady(@NonNull UAirship uAirship) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void tearDown() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public AirshipComponent(@NonNull Context context, @NonNull PreferenceDataStore preferenceDataStore) {
        this.context = context.getApplicationContext();
        this.dataStore = preferenceDataStore;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Executor getJobExecutor(@NonNull JobInfo jobInfo) {
        return this.defaultExecutor;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @WorkerThread
    public JobResult onPerformJob(@NonNull UAirship uAirship, @NonNull JobInfo jobInfo) {
        return JobResult.SUCCESS;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected PreferenceDataStore getDataStore() {
        return this.dataStore;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Context getContext() {
        return this.context;
    }
}
