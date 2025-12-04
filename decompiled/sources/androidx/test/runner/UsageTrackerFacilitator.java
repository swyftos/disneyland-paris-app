package androidx.test.runner;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.internal.runner.RunnerArgs;
import androidx.test.internal.runner.tracker.UsageTracker;
import androidx.test.internal.runner.tracker.UsageTrackerRegistry;
import androidx.test.internal.util.Checks;

/* loaded from: classes2.dex */
public class UsageTrackerFacilitator implements UsageTracker {
    private final boolean shouldTrackUsage;

    public UsageTrackerFacilitator(@NonNull RunnerArgs runnerArgs) {
        Checks.checkNotNull(runnerArgs, "runnerArgs cannot be null!");
        if (runnerArgs.orchestratorService != null) {
            this.shouldTrackUsage = !runnerArgs.disableAnalytics && runnerArgs.listTestsForOrchestrator;
        } else {
            this.shouldTrackUsage = !runnerArgs.disableAnalytics;
        }
    }

    public UsageTrackerFacilitator(boolean z) {
        this.shouldTrackUsage = z;
    }

    public boolean shouldTrackUsage() {
        return this.shouldTrackUsage;
    }

    public void registerUsageTracker(@Nullable UsageTracker usageTracker) {
        if (usageTracker == null || !shouldTrackUsage()) {
            Log.i("UsageTrackerFacilitator", "Usage tracking disabled");
            UsageTrackerRegistry.registerInstance(new UsageTracker.NoOpUsageTracker());
        } else {
            Log.i("UsageTrackerFacilitator", "Usage tracking enabled");
            UsageTrackerRegistry.registerInstance(usageTracker);
        }
    }

    @Override // androidx.test.internal.runner.tracker.UsageTracker
    public void trackUsage(String str, String str2) {
        if (shouldTrackUsage()) {
            UsageTrackerRegistry.getInstance().trackUsage(str, str2);
        }
    }

    @Override // androidx.test.internal.runner.tracker.UsageTracker
    public void sendUsages() {
        if (shouldTrackUsage()) {
            UsageTrackerRegistry.getInstance().sendUsages();
        }
    }
}
