package androidx.test.internal.runner.junit3;

import java.util.Enumeration;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;
import junit.framework.TestResult;

/* loaded from: classes2.dex */
abstract class DelegatingTestResult extends TestResult {
    private TestResult wrappedResult;

    DelegatingTestResult(TestResult testResult) {
        this.wrappedResult = testResult;
    }

    @Override // junit.framework.TestResult
    public void addError(Test test, Throwable th) {
        this.wrappedResult.addError(test, th);
    }

    @Override // junit.framework.TestResult
    public void addFailure(Test test, AssertionFailedError assertionFailedError) {
        this.wrappedResult.addFailure(test, assertionFailedError);
    }

    @Override // junit.framework.TestResult
    public void addListener(TestListener testListener) {
        this.wrappedResult.addListener(testListener);
    }

    @Override // junit.framework.TestResult
    public void removeListener(TestListener testListener) {
        this.wrappedResult.removeListener(testListener);
    }

    @Override // junit.framework.TestResult
    public void endTest(Test test) {
        this.wrappedResult.endTest(test);
    }

    @Override // junit.framework.TestResult
    public int errorCount() {
        return this.wrappedResult.errorCount();
    }

    @Override // junit.framework.TestResult
    public Enumeration errors() {
        return this.wrappedResult.errors();
    }

    @Override // junit.framework.TestResult
    public int failureCount() {
        return this.wrappedResult.failureCount();
    }

    @Override // junit.framework.TestResult
    public Enumeration failures() {
        return this.wrappedResult.failures();
    }

    @Override // junit.framework.TestResult
    public int runCount() {
        return this.wrappedResult.runCount();
    }

    @Override // junit.framework.TestResult
    public boolean shouldStop() {
        return this.wrappedResult.shouldStop();
    }

    @Override // junit.framework.TestResult
    public void startTest(Test test) {
        this.wrappedResult.startTest(test);
    }

    @Override // junit.framework.TestResult
    public void stop() {
        this.wrappedResult.stop();
    }

    @Override // junit.framework.TestResult
    public boolean wasSuccessful() {
        return this.wrappedResult.wasSuccessful();
    }
}
