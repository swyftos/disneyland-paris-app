package androidx.test.internal.runner.junit3;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.Ignore;
import org.junit.runner.Describable;
import org.junit.runner.Description;

@Ignore
/* loaded from: classes2.dex */
public class NonLeakyTestSuite extends TestSuite {
    public NonLeakyTestSuite(Class<?> cls) {
        super(cls);
    }

    @Override // junit.framework.TestSuite
    public void addTest(Test test) {
        super.addTest(new NonLeakyTest(test));
    }

    private static class NonLeakyTest implements Test, Describable {
        private Test delegate;
        private final Description desc;

        NonLeakyTest(Test test) {
            this.delegate = test;
            this.desc = JUnit38ClassRunner.makeDescription(test);
        }

        @Override // junit.framework.Test
        public int countTestCases() {
            Test test = this.delegate;
            if (test != null) {
                return test.countTestCases();
            }
            return 0;
        }

        @Override // junit.framework.Test
        public void run(TestResult testResult) {
            this.delegate.run(testResult);
            this.delegate = null;
        }

        @Override // org.junit.runner.Describable
        public Description getDescription() {
            return this.desc;
        }

        public String toString() {
            Test test = this.delegate;
            if (test != null) {
                return test.toString();
            }
            return this.desc.toString();
        }
    }
}
