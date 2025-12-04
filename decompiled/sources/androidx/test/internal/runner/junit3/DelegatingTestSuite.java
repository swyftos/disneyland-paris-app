package androidx.test.internal.runner.junit3;

import java.util.Enumeration;
import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.Ignore;

@Ignore
/* loaded from: classes2.dex */
abstract class DelegatingTestSuite extends TestSuite {
    private TestSuite wrappedSuite;

    public DelegatingTestSuite(TestSuite testSuite) {
        this.wrappedSuite = testSuite;
    }

    public TestSuite getDelegateSuite() {
        return this.wrappedSuite;
    }

    public void setDelegateSuite(TestSuite testSuite) {
        this.wrappedSuite = testSuite;
    }

    @Override // junit.framework.TestSuite
    public void addTest(Test test) {
        this.wrappedSuite.addTest(test);
    }

    @Override // junit.framework.TestSuite, junit.framework.Test
    public int countTestCases() {
        return this.wrappedSuite.countTestCases();
    }

    @Override // junit.framework.TestSuite
    public String getName() {
        return this.wrappedSuite.getName();
    }

    @Override // junit.framework.TestSuite
    public void runTest(Test test, TestResult testResult) {
        this.wrappedSuite.runTest(test, testResult);
    }

    @Override // junit.framework.TestSuite
    public void setName(String str) {
        this.wrappedSuite.setName(str);
    }

    @Override // junit.framework.TestSuite
    public Test testAt(int i) {
        return this.wrappedSuite.testAt(i);
    }

    @Override // junit.framework.TestSuite
    public int testCount() {
        return this.wrappedSuite.testCount();
    }

    @Override // junit.framework.TestSuite
    public Enumeration tests() {
        return this.wrappedSuite.tests();
    }

    @Override // junit.framework.TestSuite
    public String toString() {
        return this.wrappedSuite.toString();
    }

    @Override // junit.framework.TestSuite, junit.framework.Test
    public void run(TestResult testResult) {
        this.wrappedSuite.run(testResult);
    }
}
