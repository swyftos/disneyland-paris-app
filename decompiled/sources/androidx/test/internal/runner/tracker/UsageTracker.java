package androidx.test.internal.runner.tracker;

/* loaded from: classes2.dex */
public interface UsageTracker {

    public static class NoOpUsageTracker implements UsageTracker {
        @Override // androidx.test.internal.runner.tracker.UsageTracker
        public void sendUsages() {
        }

        @Override // androidx.test.internal.runner.tracker.UsageTracker
        public void trackUsage(String str, String str2) {
        }
    }

    void sendUsages();

    void trackUsage(String str, String str2);
}
