package androidx.test.internal.runner.junit3;

import android.util.Log;
import androidx.test.internal.util.AndroidRunnerParams;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.internal.builders.SuiteMethodBuilder;
import org.junit.internal.runners.SuiteMethod;
import org.junit.runner.Runner;

/* loaded from: classes2.dex */
public class AndroidSuiteBuilder extends SuiteMethodBuilder {
    private final AndroidRunnerParams androidRunnerParams;

    public AndroidSuiteBuilder(AndroidRunnerParams androidRunnerParams) {
        this.androidRunnerParams = androidRunnerParams;
    }

    @Override // org.junit.internal.builders.SuiteMethodBuilder, org.junit.runners.model.RunnerBuilder
    public Runner runnerForClass(Class<?> cls) throws Throwable {
        if (this.androidRunnerParams.isIgnoreSuiteMethods()) {
            return null;
        }
        try {
            if (!hasSuiteMethod(cls)) {
                return null;
            }
            Test testTestFromSuiteMethod = SuiteMethod.testFromSuiteMethod(cls);
            if (!(testTestFromSuiteMethod instanceof TestSuite)) {
                throw new IllegalArgumentException(cls.getName().concat("#suite() did not return a TestSuite"));
            }
            return new JUnit38ClassRunner(new AndroidTestSuite((TestSuite) testTestFromSuiteMethod, this.androidRunnerParams));
        } catch (Throwable th) {
            Log.e("AndroidSuiteBuilder", "Error constructing runner", th);
            throw th;
        }
    }
}
