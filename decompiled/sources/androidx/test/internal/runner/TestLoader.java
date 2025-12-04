package androidx.test.internal.runner;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
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
import org.junit.runner.notification.StoppedByUserException;
import org.junit.runners.model.RunnerBuilder;

/* loaded from: classes2.dex */
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v4, types: [org.junit.runner.Runner] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void doCreateRunner(java.lang.String r6, boolean r7) throws java.lang.ClassNotFoundException {
        /*
            r5 = this;
            java.util.Map r0 = r5.runnersMap
            boolean r0 = r0.containsKey(r6)
            if (r0 == 0) goto L9
            return
        L9:
            r0 = 0
            r1 = 0
            java.lang.ClassLoader r2 = r5.classLoader     // Catch: java.lang.Throwable -> L2b
            java.lang.Class r2 = java.lang.Class.forName(r6, r1, r2)     // Catch: java.lang.Throwable -> L2b
            org.junit.runners.model.RunnerBuilder r3 = r5.runnerBuilder     // Catch: java.lang.Throwable -> L2b
            org.junit.runner.Runner r3 = r3.safeRunnerForClass(r2)     // Catch: java.lang.Throwable -> L2b
            if (r3 != 0) goto L2d
            java.lang.String r4 = "Skipping class %s: not a test"
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Throwable -> L2b
            java.lang.Object[] r2 = new java.lang.Object[]{r2}     // Catch: java.lang.Throwable -> L2b
            java.lang.String r2 = java.lang.String.format(r4, r2)     // Catch: java.lang.Throwable -> L2b
            logDebug(r2)     // Catch: java.lang.Throwable -> L2b
            goto L43
        L2b:
            r2 = move-exception
            goto L45
        L2d:
            org.junit.runner.Runner r4 = androidx.test.internal.runner.junit3.AndroidJUnit3Builder.NOT_A_VALID_TEST     // Catch: java.lang.Throwable -> L2b
            if (r3 != r4) goto L43
            java.lang.String r3 = "Skipping class %s: not a valid test"
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Throwable -> L2b
            java.lang.Object[] r2 = new java.lang.Object[]{r2}     // Catch: java.lang.Throwable -> L2b
            java.lang.String r2 = java.lang.String.format(r3, r2)     // Catch: java.lang.Throwable -> L2b
            logDebug(r2)     // Catch: java.lang.Throwable -> L2b
            goto L66
        L43:
            r0 = r3
            goto L66
        L45:
            java.lang.String r3 = "Could not find class: %s"
            java.lang.Object[] r4 = new java.lang.Object[]{r6}
            java.lang.String r3 = java.lang.String.format(r3, r4)
            java.lang.String r4 = "TestLoader"
            android.util.Log.e(r4, r3)
            java.lang.annotation.Annotation[] r1 = new java.lang.annotation.Annotation[r1]
            org.junit.runner.Description r1 = org.junit.runner.Description.createSuiteDescription(r6, r1)
            org.junit.runner.notification.Failure r3 = new org.junit.runner.notification.Failure
            r3.<init>(r1, r2)
            if (r7 != 0) goto L66
            androidx.test.internal.runner.TestLoader$UnloadableClassRunner r0 = new androidx.test.internal.runner.TestLoader$UnloadableClassRunner
            r0.<init>(r1, r3)
        L66:
            if (r0 == 0) goto L6d
            java.util.Map r5 = r5.runnersMap
            r5.put(r6, r0)
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.test.internal.runner.TestLoader.doCreateRunner(java.lang.String, boolean):void");
    }

    List getRunnersFor(Collection collection, boolean z) throws ClassNotFoundException {
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
        public void run(RunNotifier runNotifier) throws StoppedByUserException {
            runNotifier.fireTestStarted(this.description);
            runNotifier.fireTestFailure(this.failure);
            runNotifier.fireTestFinished(this.description);
        }
    }
}
