package androidx.test.internal.runner.listener;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.test.internal.runner.TestSize;
import com.amazonaws.services.p017s3.model.InstructionFileId;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;

/* JADX INFO: loaded from: classes2.dex */
public class SuiteAssignmentPrinter extends InstrumentationRunListener {
    long endTime;
    long startTime;
    boolean timingValid;

    @Override // org.junit.runner.notification.RunListener
    public void testStarted(Description description) throws Exception {
        this.timingValid = true;
        this.startTime = getCurrentTimeMillis();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0066  */
    @Override // org.junit.runner.notification.RunListener
    public void testFinished(Description description) throws Exception {
        long currentTimeMillis = getCurrentTimeMillis();
        this.endTime = currentTimeMillis;
        if (this.timingValid) {
            long j = this.startTime;
            if (j < 0) {
                sendString("F");
                Log.d("SuiteAssignmentPrinter", String.format("%s#%s: skipping suite assignment due to test failure\n", description.getClassName(), description.getMethodName()));
            } else {
                long j2 = currentTimeMillis - j;
                TestSize testSizeForRunTime = TestSize.getTestSizeForRunTime(j2);
                TestSize testSizeFromDescription = TestSize.fromDescription(description);
                if (!testSizeForRunTime.equals(testSizeFromDescription)) {
                    sendString(String.format("\n%s#%s: current size: %s. suggested: %s runTime: %d ms\n", description.getClassName(), description.getMethodName(), testSizeFromDescription, testSizeForRunTime.getSizeQualifierName(), Long.valueOf(j2)));
                } else {
                    sendString(InstructionFileId.DOT);
                    Log.d("SuiteAssignmentPrinter", String.format("%s#%s assigned correctly as %s. runTime: %d ms\n", description.getClassName(), description.getMethodName(), testSizeForRunTime.getSizeQualifierName(), Long.valueOf(j2)));
                }
            }
        } else {
            sendString("F");
            Log.d("SuiteAssignmentPrinter", String.format("%s#%s: skipping suite assignment due to test failure\n", description.getClassName(), description.getMethodName()));
        }
        this.startTime = -1L;
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
