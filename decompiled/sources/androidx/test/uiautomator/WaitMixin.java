package androidx.test.uiautomator;

import android.os.SystemClock;

/* loaded from: classes2.dex */
class WaitMixin<T> {
    private Object mObject;

    public WaitMixin(Object obj) {
        this.mObject = obj;
    }

    public Object wait(Condition condition, long j) {
        return wait(condition, j, 1000L);
    }

    public Object wait(Condition condition, long j, long j2) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        Object objApply = condition.apply(this.mObject);
        long jUptimeMillis2 = 0;
        while (true) {
            if ((objApply != null && !objApply.equals(Boolean.FALSE)) || jUptimeMillis2 >= j) {
                break;
            }
            SystemClock.sleep(j2);
            objApply = condition.apply(this.mObject);
            jUptimeMillis2 = SystemClock.uptimeMillis() - jUptimeMillis;
        }
        return objApply;
    }
}
