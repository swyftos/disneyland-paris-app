package io.cucumber.junit;

import org.junit.runner.Runner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

/* loaded from: classes5.dex */
public class CucumberJUnitRunnerBuilder extends RunnerBuilder {
    @Override // org.junit.runners.model.RunnerBuilder
    public Runner runnerForClass(Class<?> cls) throws InitializationError {
        if (cls.equals(getClass())) {
            return new CucumberJUnitRunner(cls);
        }
        return null;
    }
}
