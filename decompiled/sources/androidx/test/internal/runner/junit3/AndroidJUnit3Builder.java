package androidx.test.internal.runner.junit3;

import android.util.Log;
import androidx.test.internal.util.AndroidRunnerBuilderUtil;
import androidx.test.internal.util.AndroidRunnerParams;
import org.junit.internal.builders.JUnit3Builder;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

/* loaded from: classes2.dex */
public class AndroidJUnit3Builder extends JUnit3Builder {
    public static final Runner NOT_A_VALID_TEST = new Runner() { // from class: androidx.test.internal.runner.junit3.AndroidJUnit3Builder.1
        @Override // org.junit.runner.Runner
        public void run(RunNotifier runNotifier) {
        }

        @Override // org.junit.runner.Runner, org.junit.runner.Describable
        public Description getDescription() {
            return Description.EMPTY;
        }
    };
    private final AndroidRunnerParams androidRunnerParams;
    private final boolean scanningPath;

    public AndroidJUnit3Builder(AndroidRunnerParams androidRunnerParams, boolean z) {
        this.androidRunnerParams = androidRunnerParams;
        this.scanningPath = z;
    }

    @Deprecated
    public AndroidJUnit3Builder(AndroidRunnerParams androidRunnerParams) {
        this(androidRunnerParams, false);
    }

    @Override // org.junit.internal.builders.JUnit3Builder, org.junit.runners.model.RunnerBuilder
    public Runner runnerForClass(Class<?> cls) throws Throwable {
        try {
            if (!AndroidRunnerBuilderUtil.isJUnit3Test(cls)) {
                return null;
            }
            if (this.scanningPath && !AndroidRunnerBuilderUtil.hasJUnit3TestMethod(cls)) {
                return NOT_A_VALID_TEST;
            }
            return new JUnit38ClassRunner(new AndroidTestSuite(cls, this.androidRunnerParams));
        } catch (Throwable th) {
            Log.e("AndroidJUnit3Builder", "Error constructing runner", th);
            throw th;
        }
    }
}
