package androidx.test.internal.runner.junit3;

import java.util.Enumeration;
import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.Ignore;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;

@Ignore
/* loaded from: classes2.dex */
public class NonExecutingTestSuite extends DelegatingFilterableTestSuite {
    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.TestSuite
    public /* bridge */ /* synthetic */ void addTest(Test test) {
        super.addTest(test);
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.TestSuite, junit.framework.Test
    public /* bridge */ /* synthetic */ int countTestCases() {
        return super.countTestCases();
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingFilterableTestSuite, org.junit.runner.manipulation.Filterable
    public /* bridge */ /* synthetic */ void filter(Filter filter) throws NoTestsRemainException {
        super.filter(filter);
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite
    public /* bridge */ /* synthetic */ TestSuite getDelegateSuite() {
        return super.getDelegateSuite();
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.TestSuite
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.TestSuite
    public /* bridge */ /* synthetic */ void runTest(Test test, TestResult testResult) {
        super.runTest(test, testResult);
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite
    public /* bridge */ /* synthetic */ void setDelegateSuite(TestSuite testSuite) {
        super.setDelegateSuite(testSuite);
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.TestSuite
    public /* bridge */ /* synthetic */ void setName(String str) {
        super.setName(str);
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.TestSuite
    public /* bridge */ /* synthetic */ Test testAt(int i) {
        return super.testAt(i);
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.TestSuite
    public /* bridge */ /* synthetic */ int testCount() {
        return super.testCount();
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.TestSuite
    public /* bridge */ /* synthetic */ Enumeration tests() {
        return super.tests();
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.TestSuite
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public NonExecutingTestSuite(Class<?> cls) {
        this(new TestSuite(cls));
    }

    public NonExecutingTestSuite(TestSuite testSuite) {
        super(testSuite);
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.TestSuite, junit.framework.Test
    public void run(TestResult testResult) {
        super.run(new NonExecutingTestResult(testResult));
    }
}
