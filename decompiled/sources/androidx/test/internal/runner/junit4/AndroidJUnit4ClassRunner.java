package androidx.test.internal.runner.junit4;

import androidx.test.internal.runner.RunnerArgs;
import androidx.test.internal.runner.junit4.statement.RunAfters;
import androidx.test.internal.runner.junit4.statement.RunBefores;
import androidx.test.internal.runner.junit4.statement.UiThreadStatement;
import androidx.test.internal.util.AndroidRunnerParams;
import androidx.test.platform.app.InstrumentationRegistry;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

/* loaded from: classes2.dex */
public class AndroidJUnit4ClassRunner extends BlockJUnit4ClassRunner {
    private final AndroidRunnerParams androidRunnerParams;

    public AndroidJUnit4ClassRunner(Class<?> cls, AndroidRunnerParams androidRunnerParams) throws InitializationError {
        super(cls);
        this.androidRunnerParams = androidRunnerParams;
    }

    public AndroidJUnit4ClassRunner(Class<?> cls) throws InitializationError {
        this(cls, createRunnerParams());
    }

    private static AndroidRunnerParams createRunnerParams() {
        return new AndroidRunnerParams(InstrumentationRegistry.getInstrumentation(), InstrumentationRegistry.getArguments(), new RunnerArgs.Builder().fromBundle(InstrumentationRegistry.getInstrumentation(), InstrumentationRegistry.getArguments()).build().testTimeout, false);
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    protected Statement methodInvoker(FrameworkMethod frameworkMethod, Object obj) {
        if (UiThreadStatement.shouldRunOnUiThread(frameworkMethod)) {
            return new UiThreadStatement(super.methodInvoker(frameworkMethod, obj), true);
        }
        return super.methodInvoker(frameworkMethod, obj);
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    protected Statement withBefores(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        List<FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(Before.class);
        return annotatedMethods.isEmpty() ? statement : new RunBefores(frameworkMethod, statement, annotatedMethods, obj);
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    protected Statement withAfters(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        List<FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(After.class);
        return annotatedMethods.isEmpty() ? statement : new RunAfters(frameworkMethod, statement, annotatedMethods, obj);
    }

    @Override // org.junit.runners.BlockJUnit4ClassRunner
    protected Statement withPotentialTimeout(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        long timeout = getTimeout((Test) frameworkMethod.getAnnotation(Test.class));
        if (timeout <= 0 && this.androidRunnerParams.getPerTestTimeout() > 0) {
            timeout = this.androidRunnerParams.getPerTestTimeout();
        }
        return timeout <= 0 ? statement : new FailOnTimeout(statement, timeout);
    }

    private long getTimeout(Test test) {
        if (test == null) {
            return 0L;
        }
        return test.timeout();
    }
}
