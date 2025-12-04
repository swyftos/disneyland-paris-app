package com.urbanairship.app;

import android.app.Activity;
import androidx.annotation.MainThread;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.Predicate;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0013H&J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0015H'J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0013H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcom/urbanairship/app/ActivityMonitor;", "", "foregroundState", "Lkotlinx/coroutines/flow/StateFlow;", "", "getForegroundState", "()Lkotlinx/coroutines/flow/StateFlow;", "isAppForegrounded", "()Z", "resumedActivities", "", "Landroid/app/Activity;", "getResumedActivities", "()Ljava/util/List;", "addActivityListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/app/ActivityListener;", "addApplicationListener", "Lcom/urbanairship/app/ApplicationListener;", ViewProps.FILTER, "Lcom/urbanairship/Predicate;", "removeActivityListener", "removeApplicationListener", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ActivityMonitor {
    void addActivityListener(@NotNull ActivityListener listener);

    void addApplicationListener(@NotNull ApplicationListener listener);

    @NotNull
    StateFlow<Boolean> getForegroundState();

    @MainThread
    @NotNull
    List<Activity> getResumedActivities();

    @MainThread
    @NotNull
    List<Activity> getResumedActivities(@Nullable Predicate<Activity> filter);

    boolean isAppForegrounded();

    void removeActivityListener(@NotNull ActivityListener listener);

    void removeApplicationListener(@NotNull ApplicationListener listener);
}
