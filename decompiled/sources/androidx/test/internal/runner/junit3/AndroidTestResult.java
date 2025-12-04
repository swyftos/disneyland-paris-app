package androidx.test.internal.runner.junit3;

import android.app.Instrumentation;
import android.os.Bundle;
import android.test.AndroidTestCase;
import android.test.InstrumentationTestCase;
import java.util.concurrent.TimeoutException;
import junit.framework.AssertionFailedError;
import junit.framework.Protectable;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;

/* loaded from: classes2.dex */
class AndroidTestResult extends DelegatingTestResult {
    private final Bundle bundle;
    private final Instrumentation instr;
    private long timeout;

    AndroidTestResult(Bundle bundle, Instrumentation instrumentation, TestResult testResult) {
        super(testResult);
        this.bundle = bundle;
        this.instr = instrumentation;
    }

    @Override // junit.framework.TestResult
    protected void run(TestCase testCase) {
        if (testCase instanceof AndroidTestCase) {
            ((AndroidTestCase) testCase).setContext(this.instr.getTargetContext());
        }
        if (testCase instanceof InstrumentationTestCase) {
            ((InstrumentationTestCase) testCase).injectInstrumentation(this.instr);
        }
        super.run(testCase);
    }

    void setCurrentTimeout(long j) {
        this.timeout = j;
    }

    @Override // junit.framework.TestResult
    public void runProtected(Test test, Protectable protectable) {
        try {
            protectable.protect();
        } catch (InterruptedException unused) {
            super.addError(test, new TimeoutException(String.format("Test timed out after %d milliseconds", Long.valueOf(this.timeout))));
        } catch (ThreadDeath e) {
            throw e;
        } catch (AssertionFailedError e2) {
            super.addFailure(test, e2);
        } catch (Throwable th) {
            super.addError(test, th);
        }
    }
}
