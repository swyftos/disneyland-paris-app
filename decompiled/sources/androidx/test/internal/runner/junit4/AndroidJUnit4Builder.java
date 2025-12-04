package androidx.test.internal.runner.junit4;

import android.util.Log;
import androidx.test.internal.util.AndroidRunnerParams;
import java.lang.reflect.Method;
import org.junit.Test;
import org.junit.internal.builders.JUnit4Builder;
import org.junit.runner.Runner;

/* loaded from: classes2.dex */
public class AndroidJUnit4Builder extends JUnit4Builder {
    private final AndroidRunnerParams androidRunnerParams;
    private final boolean scanningPath;

    public AndroidJUnit4Builder(AndroidRunnerParams androidRunnerParams, boolean z) {
        this.androidRunnerParams = androidRunnerParams;
        this.scanningPath = z;
    }

    @Deprecated
    public AndroidJUnit4Builder(AndroidRunnerParams androidRunnerParams) {
        this(androidRunnerParams, false);
    }

    @Override // org.junit.internal.builders.JUnit4Builder, org.junit.runners.model.RunnerBuilder
    public Runner runnerForClass(Class<?> cls) throws Throwable {
        try {
            if (!this.scanningPath || hasTestMethods(cls)) {
                return new AndroidJUnit4ClassRunner(cls, this.androidRunnerParams);
            }
            return null;
        } catch (Throwable th) {
            Log.e("AndroidJUnit4Builder", "Error constructing runner", th);
            throw th;
        }
    }

    private static boolean hasTestMethods(Class cls) {
        try {
            for (Method method : cls.getMethods()) {
                if (method.isAnnotationPresent(Test.class)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            Log.w("AndroidJUnit4Builder", String.format("%s in hasTestMethods for %s", th.toString(), cls.getName()));
            return false;
        }
    }
}
