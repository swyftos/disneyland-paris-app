package com.urbanairship.iam;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.Predicate;
import com.urbanairship.UALog;
import com.urbanairship.app.ActivityListener;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.ApplicationListener;
import com.urbanairship.app.FilteredActivityListener;
import com.urbanairship.app.ForwardingActivityListener;
import com.urbanairship.app.GlobalActivityMonitor;
import com.urbanairship.util.ManifestUtils;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0005\u0018\u0000 )2\u00020\u0001:\u0001)B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020 H\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\"H\u0017J\r\u0010#\u001a\u00020\u001cH\u0001¢\u0006\u0002\b$J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020 H\u0016J\u0010\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006*"}, d2 = {"Lcom/urbanairship/iam/InAppActivityMonitor;", "Lcom/urbanairship/app/ActivityMonitor;", "activityMonitor", "(Lcom/urbanairship/app/ActivityMonitor;)V", "activityPredicate", "com/urbanairship/iam/InAppActivityMonitor$activityPredicate$1", "Lcom/urbanairship/iam/InAppActivityMonitor$activityPredicate$1;", "allowedActivities", "", "Ljava/lang/Class;", "filteredActivityListener", "Lcom/urbanairship/app/FilteredActivityListener;", "foregroundState", "Lkotlinx/coroutines/flow/StateFlow;", "", "getForegroundState", "()Lkotlinx/coroutines/flow/StateFlow;", "forwardingActivityListener", "Lcom/urbanairship/app/ForwardingActivityListener;", "ignoredActivities", "isAppForegrounded", "()Z", "resumedActivities", "", "Landroid/app/Activity;", "getResumedActivities", "()Ljava/util/List;", "addActivityListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/app/ActivityListener;", "addApplicationListener", "Lcom/urbanairship/app/ApplicationListener;", ViewProps.FILTER, "Lcom/urbanairship/Predicate;", "init", "init$urbanairship_automation_release", "removeActivityListener", "removeApplicationListener", "shouldIgnoreActivity", "activity", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppActivityMonitor implements ActivityMonitor {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String EXCLUDE_FROM_AUTO_SHOW = "com.urbanairship.push.iam.EXCLUDE_FROM_AUTO_SHOW";
    private static InAppActivityMonitor shared;
    private final ActivityMonitor activityMonitor;
    private final InAppActivityMonitor$activityPredicate$1 activityPredicate;
    private final Set allowedActivities;
    private final FilteredActivityListener filteredActivityListener;
    private final ForwardingActivityListener forwardingActivityListener;
    private final Set ignoredActivities;

    @JvmStatic
    @NotNull
    public static final InAppActivityMonitor shared(@NotNull Context context) {
        return INSTANCE.shared(context);
    }

    public InAppActivityMonitor(@NotNull ActivityMonitor activityMonitor) {
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        this.activityMonitor = activityMonitor;
        this.allowedActivities = new LinkedHashSet();
        this.ignoredActivities = new LinkedHashSet();
        InAppActivityMonitor$activityPredicate$1 inAppActivityMonitor$activityPredicate$1 = new InAppActivityMonitor$activityPredicate$1(this);
        this.activityPredicate = inAppActivityMonitor$activityPredicate$1;
        ForwardingActivityListener forwardingActivityListener = new ForwardingActivityListener();
        this.forwardingActivityListener = forwardingActivityListener;
        this.filteredActivityListener = new FilteredActivityListener(forwardingActivityListener, inAppActivityMonitor$activityPredicate$1);
    }

    @Override // com.urbanairship.app.ActivityMonitor
    @NotNull
    public StateFlow<Boolean> getForegroundState() {
        return this.activityMonitor.getForegroundState();
    }

    @VisibleForTesting
    public final void init$urbanairship_automation_release() {
        this.activityMonitor.addActivityListener(this.filteredActivityListener);
    }

    @Override // com.urbanairship.app.ActivityMonitor
    public void addActivityListener(@NotNull ActivityListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.forwardingActivityListener.addListener(listener);
    }

    @Override // com.urbanairship.app.ActivityMonitor
    public void removeActivityListener(@NotNull ActivityListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.forwardingActivityListener.removeListener(listener);
    }

    @Override // com.urbanairship.app.ActivityMonitor
    public void addApplicationListener(@NotNull ApplicationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.activityMonitor.addApplicationListener(listener);
    }

    @Override // com.urbanairship.app.ActivityMonitor
    public void removeApplicationListener(@NotNull ApplicationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.activityMonitor.removeApplicationListener(listener);
    }

    @Override // com.urbanairship.app.ActivityMonitor
    /* renamed from: isAppForegrounded */
    public boolean getIsAppForegrounded() {
        return this.activityMonitor.getIsAppForegrounded();
    }

    @Override // com.urbanairship.app.ActivityMonitor
    @NotNull
    public List<Activity> getResumedActivities() {
        return this.activityMonitor.getResumedActivities(this.activityPredicate);
    }

    @Override // com.urbanairship.app.ActivityMonitor
    @MainThread
    @NotNull
    public List<Activity> getResumedActivities(@Nullable final Predicate<Activity> filter) {
        return this.activityMonitor.getResumedActivities(new Predicate() { // from class: com.urbanairship.iam.InAppActivityMonitor$$ExternalSyntheticLambda0
            @Override // com.urbanairship.Predicate
            public final boolean apply(Object obj) {
                return InAppActivityMonitor.getResumedActivities$lambda$0(this.f$0, filter, (Activity) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getResumedActivities$lambda$0(InAppActivityMonitor this$0, Predicate predicate, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this$0.activityPredicate.apply2(activity)) {
            if (predicate != null ? predicate.apply(activity) : true) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldIgnoreActivity(Activity activity) {
        ActivityInfo activityInfo = ManifestUtils.getActivityInfo(activity.getClass());
        Bundle bundle = activityInfo != null ? activityInfo.metaData : null;
        if (bundle == null || !bundle.getBoolean(EXCLUDE_FROM_AUTO_SHOW, false)) {
            return false;
        }
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.iam.InAppActivityMonitor.shouldIgnoreActivity.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Activity contains metadata to exclude it from auto showing an in-app message";
            }
        }, 1, null);
        return true;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/urbanairship/iam/InAppActivityMonitor$Companion;", "", "()V", "EXCLUDE_FROM_AUTO_SHOW", "", "shared", "Lcom/urbanairship/iam/InAppActivityMonitor;", "context", "Landroid/content/Context;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final InAppActivityMonitor shared(@NotNull Context context) {
            InAppActivityMonitor inAppActivityMonitor;
            Intrinsics.checkNotNullParameter(context, "context");
            InAppActivityMonitor inAppActivityMonitor2 = InAppActivityMonitor.shared;
            if (inAppActivityMonitor2 != null) {
                return inAppActivityMonitor2;
            }
            synchronized (InAppActivityMonitor.class) {
                inAppActivityMonitor = InAppActivityMonitor.shared;
                if (inAppActivityMonitor == null) {
                    inAppActivityMonitor = new InAppActivityMonitor(GlobalActivityMonitor.INSTANCE.shared(context));
                    InAppActivityMonitor.shared = inAppActivityMonitor;
                    inAppActivityMonitor.init$urbanairship_automation_release();
                }
            }
            return inAppActivityMonitor;
        }
    }
}
