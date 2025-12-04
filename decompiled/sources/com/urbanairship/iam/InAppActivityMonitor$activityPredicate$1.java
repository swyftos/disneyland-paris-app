package com.urbanairship.iam;

import android.app.Activity;
import com.urbanairship.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/urbanairship/iam/InAppActivityMonitor$activityPredicate$1", "Lcom/urbanairship/Predicate;", "Landroid/app/Activity;", "apply", "", "activity", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppActivityMonitor$activityPredicate$1 implements Predicate<Activity> {
    final /* synthetic */ InAppActivityMonitor this$0;

    InAppActivityMonitor$activityPredicate$1(InAppActivityMonitor inAppActivityMonitor) {
        this.this$0 = inAppActivityMonitor;
    }

    @Override // com.urbanairship.Predicate
    public boolean apply(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.this$0.allowedActivities.contains(activity.getClass())) {
            return true;
        }
        if (this.this$0.ignoredActivities.contains(activity.getClass())) {
            return false;
        }
        if (this.this$0.shouldIgnoreActivity(activity)) {
            this.this$0.ignoredActivities.add(activity.getClass());
            return false;
        }
        this.this$0.allowedActivities.add(activity.getClass());
        return true;
    }
}
