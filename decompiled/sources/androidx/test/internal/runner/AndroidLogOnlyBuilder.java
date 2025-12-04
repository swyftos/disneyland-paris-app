package androidx.test.internal.runner;

import androidx.test.internal.runner.junit3.JUnit38ClassRunner;
import androidx.test.internal.runner.junit3.NonExecutingTestSuite;
import androidx.test.internal.util.AndroidRunnerBuilderUtil;
import androidx.test.internal.util.AndroidRunnerParams;
import androidx.test.internal.util.Checks;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.internal.runners.SuiteMethod;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

/* loaded from: classes2.dex */
class AndroidLogOnlyBuilder extends RunnerBuilder {
    private final AndroidRunnerBuilder builder;
    private int runnerCount = 0;
    private final AndroidRunnerParams runnerParams;
    private final boolean scanningPath;

    AndroidLogOnlyBuilder(AndroidRunnerParams androidRunnerParams, boolean z, List list) {
        this.runnerParams = (AndroidRunnerParams) Checks.checkNotNull(androidRunnerParams, "runnerParams cannot be null!");
        this.scanningPath = z;
        this.builder = new AndroidRunnerBuilder(this, androidRunnerParams, z, list);
    }

    @Override // org.junit.runners.model.RunnerBuilder
    public Runner runnerForClass(Class cls) throws Exception {
        this.runnerCount++;
        if (AndroidRunnerBuilderUtil.isJUnit3Test(cls)) {
            if (!this.scanningPath || AndroidRunnerBuilderUtil.hasJUnit3TestMethod(cls)) {
                return new JUnit38ClassRunner(new NonExecutingTestSuite((Class<?>) cls));
            }
            return null;
        }
        if (AndroidRunnerBuilderUtil.hasSuiteMethod(cls)) {
            if (this.runnerParams.isIgnoreSuiteMethods()) {
                return null;
            }
            Test testTestFromSuiteMethod = SuiteMethod.testFromSuiteMethod(cls);
            if (!(testTestFromSuiteMethod instanceof TestSuite)) {
                throw new IllegalArgumentException(cls.getName().concat("#suite() did not return a TestSuite"));
            }
            return new JUnit38ClassRunner(new NonExecutingTestSuite((TestSuite) testTestFromSuiteMethod));
        }
        int i = this.runnerCount;
        Runner runnerRunnerForClass = this.builder.runnerForClass(cls);
        if (runnerRunnerForClass == null) {
            return null;
        }
        return (!(runnerRunnerForClass instanceof ErrorReportingRunner) && this.runnerCount <= i) ? new NonExecutingRunner(runnerRunnerForClass) : runnerRunnerForClass;
    }
}
