package androidx.test.internal.runner.junit4;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.test.internal.util.AndroidRunnerParams;
import androidx.test.runner.AndroidJUnit4;
import org.junit.internal.builders.AnnotatedBuilder;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

/* loaded from: classes2.dex */
public class AndroidAnnotatedBuilder extends AnnotatedBuilder {
    private final AndroidRunnerParams androidRunnerParams;

    public AndroidAnnotatedBuilder(RunnerBuilder runnerBuilder, AndroidRunnerParams androidRunnerParams) {
        super(runnerBuilder);
        this.androidRunnerParams = androidRunnerParams;
    }

    @Override // org.junit.internal.builders.AnnotatedBuilder, org.junit.runners.model.RunnerBuilder
    public Runner runnerForClass(Class<?> cls) throws Exception {
        try {
            RunWith runWith = (RunWith) cls.getAnnotation(RunWith.class);
            if (runWith != null && AndroidJUnit4.class.equals(runWith.value())) {
                Class<? extends Runner> clsValue = runWith.value();
                try {
                    Runner runnerBuildAndroidRunner = buildAndroidRunner(clsValue, cls);
                    if (runnerBuildAndroidRunner != null) {
                        return runnerBuildAndroidRunner;
                    }
                } catch (NoSuchMethodException unused) {
                    return super.buildRunner(clsValue, cls);
                }
            }
            return super.runnerForClass(cls);
        } catch (Throwable th) {
            Log.e("AndroidAnnotatedBuilder", "Error constructing runner", th);
            throw th;
        }
    }

    @VisibleForTesting
    public Runner buildAndroidRunner(Class<? extends Runner> cls, Class<?> cls2) throws Exception {
        return cls.getConstructor(Class.class, AndroidRunnerParams.class).newInstance(cls2, this.androidRunnerParams);
    }
}
