package io.cucumber.junit;

import cucumber.runtime.model.CucumberFeature;
import gherkin.ast.Feature;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;

/* loaded from: classes5.dex */
public class AndroidFeatureRunner extends ParentRunner<AndroidPickleRunner> {
    private final List children;
    private final CucumberFeature cucumberFeature;

    public AndroidFeatureRunner(Class<?> cls, CucumberFeature cucumberFeature, List<AndroidPickleRunner> list) throws InitializationError {
        super(cls);
        this.cucumberFeature = cucumberFeature;
        this.children = list;
    }

    @Override // org.junit.runners.ParentRunner
    public String getName() {
        Feature feature = this.cucumberFeature.getGherkinFeature().getFeature();
        return feature.getKeyword() + ": " + feature.getName();
    }

    @Override // org.junit.runners.ParentRunner
    protected List<AndroidPickleRunner> getChildren() {
        return this.children;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.ParentRunner
    public Description describeChild(AndroidPickleRunner androidPickleRunner) {
        return androidPickleRunner.getDescription();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.ParentRunner
    public void runChild(AndroidPickleRunner androidPickleRunner, RunNotifier runNotifier) {
        androidPickleRunner.run(runNotifier);
    }
}
