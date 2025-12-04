package androidx.test.internal.runner.junit3;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.Ignore;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;

@Ignore
/* loaded from: classes2.dex */
abstract class DelegatingFilterableTestSuite extends DelegatingTestSuite implements Filterable {
    public DelegatingFilterableTestSuite(TestSuite testSuite) {
        super(testSuite);
    }

    @Override // org.junit.runner.manipulation.Filterable
    public void filter(Filter filter) throws NoTestsRemainException {
        TestSuite delegateSuite = getDelegateSuite();
        TestSuite testSuite = new TestSuite(delegateSuite.getName());
        int iTestCount = delegateSuite.testCount();
        for (int i = 0; i < iTestCount; i++) {
            Test testTestAt = delegateSuite.testAt(i);
            if (filter.shouldRun(makeDescription(testTestAt))) {
                testSuite.addTest(testTestAt);
            }
        }
        setDelegateSuite(testSuite);
        if (testSuite.testCount() == 0) {
            throw new NoTestsRemainException();
        }
    }

    private static Description makeDescription(Test test) {
        return JUnit38ClassRunner.makeDescription(test);
    }
}
