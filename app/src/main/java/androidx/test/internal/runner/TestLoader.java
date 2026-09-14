package androidx.test.internal.runner;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.test.internal.runner.junit3.AndroidJUnit3Builder;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.RunnerBuilder;

/* JADX INFO: loaded from: classes2.dex */
class TestLoader {
    private final ClassLoader classLoader;
    private final RunnerBuilder runnerBuilder;
    private final Map runnersMap = new LinkedHashMap();

    static TestLoader testLoader(ClassLoader classLoader, RunnerBuilder runnerBuilder, boolean z) {
        if (z) {
            runnerBuilder = new ScanningRunnerBuilder(runnerBuilder);
        }
        if (classLoader == null) {
            classLoader = TestLoader.class.getClassLoader();
        }
        return new TestLoader(classLoader, runnerBuilder);
    }

    private TestLoader(ClassLoader classLoader, RunnerBuilder runnerBuilder) {
        this.classLoader = classLoader;
        this.runnerBuilder = runnerBuilder;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0068  */
    /* JADX WARN: Code duplicated, block: B:23:? A[RETURN, SYNTHETIC] */
    private void doCreateRunner(String str, boolean z) {
        if (this.runnersMap.containsKey(str)) {
            return;
        }
        Runner unloadableClassRunner = null;
        try {
            Class<?> cls = Class.forName(str, false, this.classLoader);
            Runner runnerSafeRunnerForClass = this.runnerBuilder.safeRunnerForClass(cls);
            if (runnerSafeRunnerForClass == null) {
                logDebug(String.format("Skipping class %s: not a test", cls.getName()));
            } else {
                if (runnerSafeRunnerForClass == AndroidJUnit3Builder.NOT_A_VALID_TEST) {
                    logDebug(String.format("Skipping class %s: not a valid test", cls.getName()));
                }
                if (unloadableClassRunner != null) {
                    this.runnersMap.put(str, unloadableClassRunner);
                }
            }
            unloadableClassRunner = runnerSafeRunnerForClass;
        } catch (ClassNotFoundException | LinkageError e) {
            Log.e("TestLoader", String.format("Could not find class: %s", str));
            Description descriptionCreateSuiteDescription = Description.createSuiteDescription(str, new Annotation[0]);
            Failure failure = new Failure(descriptionCreateSuiteDescription, e);
            if (!z) {
                unloadableClassRunner = new UnloadableClassRunner(descriptionCreateSuiteDescription, failure);
            }
        }
        if (unloadableClassRunner != null) {
            this.runnersMap.put(str, unloadableClassRunner);
        }
    }

    List getRunnersFor(Collection collection, boolean z) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            doCreateRunner((String) it.next(), z);
        }
        return new ArrayList(this.runnersMap.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logDebug(String str) {
        if (Log.isLoggable("TestLoader", 3)) {
            Log.d("TestLoader", str);
        }
    }

    private static class ScanningRunnerBuilder extends RunnerBuilder {
        private final RunnerBuilder runnerBuilder;

        ScanningRunnerBuilder(RunnerBuilder runnerBuilder) {
            this.runnerBuilder = runnerBuilder;
        }

        @Override // org.junit.runners.model.RunnerBuilder
        public Runner runnerForClass(Class cls) {
            if (Modifier.isAbstract(cls.getModifiers())) {
                TestLoader.logDebug(String.format("Skipping abstract class %s: not a test", cls.getName()));
                return null;
            }
            return this.runnerBuilder.runnerForClass(cls);
        }
    }

    @VisibleForTesting
    static class UnloadableClassRunner extends Runner {
        private final Description description;
        private final Failure failure;

        UnloadableClassRunner(Description description, Failure failure) {
            this.description = description;
            this.failure = failure;
        }

        @Override // org.junit.runner.Runner, org.junit.runner.Describable
        public Description getDescription() {
            return this.description;
        }

        @Override // org.junit.runner.Runner
        public void run(RunNotifier runNotifier) {
            runNotifier.fireTestStarted(this.description);
            runNotifier.fireTestFailure(this.failure);
            runNotifier.fireTestFinished(this.description);
        }
    }
}
