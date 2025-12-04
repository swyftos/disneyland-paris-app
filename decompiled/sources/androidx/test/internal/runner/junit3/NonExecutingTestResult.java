package androidx.test.internal.runner.junit3;

import junit.framework.Protectable;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;

/* loaded from: classes2.dex */
class NonExecutingTestResult extends DelegatingTestResult {
    @Override // junit.framework.TestResult
    public void runProtected(Test test, Protectable protectable) {
    }

    NonExecutingTestResult(TestResult testResult) {
        super(testResult);
    }

    @Override // junit.framework.TestResult
    protected void run(TestCase testCase) {
        startTest(testCase);
        endTest(testCase);
    }
}
