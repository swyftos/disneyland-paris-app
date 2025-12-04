package androidx.test.internal.runner.listener;

import androidx.annotation.VisibleForTesting;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;

/* loaded from: classes2.dex */
public class SuiteAssignmentPrinter extends InstrumentationRunListener {
    long endTime;
    long startTime;
    boolean timingValid;

    @Override // org.junit.runner.notification.RunListener
    public void testStarted(Description description) throws Exception {
        this.timingValid = true;
        this.startTime = getCurrentTimeMillis();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0066  */
    @Override // org.junit.runner.notification.RunListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void testFinished(org.junit.runner.Description r9) throws java.lang.Exception {
        /*
            r8 = this;
            long r0 = r8.getCurrentTimeMillis()
            r8.endTime = r0
            boolean r2 = r8.timingValid
            java.lang.String r3 = "SuiteAssignmentPrinter"
            if (r2 == 0) goto L66
            long r4 = r8.startTime
            r6 = 0
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 >= 0) goto L15
            goto L66
        L15:
            long r0 = r0 - r4
            float r2 = (float) r0
            androidx.test.internal.runner.TestSize r2 = androidx.test.internal.runner.TestSize.getTestSizeForRunTime(r2)
            androidx.test.internal.runner.TestSize r4 = androidx.test.internal.runner.TestSize.fromDescription(r9)
            boolean r5 = r2.equals(r4)
            if (r5 != 0) goto L43
            java.lang.String r3 = r9.getClassName()
            java.lang.String r9 = r9.getMethodName()
            java.lang.String r2 = r2.getSizeQualifierName()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.Object[] r9 = new java.lang.Object[]{r3, r9, r4, r2, r0}
            java.lang.String r0 = "\n%s#%s: current size: %s. suggested: %s runTime: %d ms\n"
            java.lang.String r9 = java.lang.String.format(r0, r9)
            r8.sendString(r9)
            goto L80
        L43:
            java.lang.String r4 = "."
            r8.sendString(r4)
            java.lang.String r4 = r9.getClassName()
            java.lang.String r9 = r9.getMethodName()
            java.lang.String r2 = r2.getSizeQualifierName()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.Object[] r9 = new java.lang.Object[]{r4, r9, r2, r0}
            java.lang.String r0 = "%s#%s assigned correctly as %s. runTime: %d ms\n"
            java.lang.String r9 = java.lang.String.format(r0, r9)
            android.util.Log.d(r3, r9)
            goto L80
        L66:
            java.lang.String r0 = "F"
            r8.sendString(r0)
            java.lang.String r0 = r9.getClassName()
            java.lang.String r9 = r9.getMethodName()
            java.lang.Object[] r9 = new java.lang.Object[]{r0, r9}
            java.lang.String r0 = "%s#%s: skipping suite assignment due to test failure\n"
            java.lang.String r9 = java.lang.String.format(r0, r9)
            android.util.Log.d(r3, r9)
        L80:
            r0 = -1
            r8.startTime = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.test.internal.runner.listener.SuiteAssignmentPrinter.testFinished(org.junit.runner.Description):void");
    }

    @Override // org.junit.runner.notification.RunListener
    public void testFailure(Failure failure) throws Exception {
        this.timingValid = false;
    }

    @Override // org.junit.runner.notification.RunListener
    public void testAssumptionFailure(Failure failure) {
        this.timingValid = false;
    }

    @Override // org.junit.runner.notification.RunListener
    public void testIgnored(Description description) throws Exception {
        this.timingValid = false;
    }

    @VisibleForTesting
    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
