package io.cucumber.junit;

import cucumber.runner.ThreadLocalRunnerSupplier;
import cucumber.runtime.CucumberException;
import cucumber.runtime.filter.Filters;
import cucumber.runtime.model.CucumberFeature;
import gherkin.ast.Feature;
import gherkin.events.PickleEvent;
import io.cucumber.junit.PickleRunners;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;

/* loaded from: classes5.dex */
final class FeatureRunner extends ParentRunner {
    private final List children;
    private final CucumberFeature cucumberFeature;
    private Description description;

    FeatureRunner(CucumberFeature cucumberFeature, Filters filters, ThreadLocalRunnerSupplier threadLocalRunnerSupplier, JUnitOptions jUnitOptions) {
        super((Class<?>) null);
        this.children = new ArrayList();
        this.cucumberFeature = cucumberFeature;
        buildFeatureElementRunners(filters, threadLocalRunnerSupplier, jUnitOptions);
    }

    @Override // org.junit.runners.ParentRunner
    protected String getName() {
        Feature feature = this.cucumberFeature.getGherkinFeature().getFeature();
        return feature.getKeyword() + ": " + feature.getName();
    }

    @Override // org.junit.runners.ParentRunner, org.junit.runner.Runner, org.junit.runner.Describable
    public Description getDescription() {
        if (this.description == null) {
            this.description = Description.createSuiteDescription(getName(), new FeatureId(this.cucumberFeature), new Annotation[0]);
            Iterator it = getChildren().iterator();
            while (it.hasNext()) {
                this.description.addChild(describeChild((PickleRunners.PickleRunner) it.next()));
            }
        }
        return this.description;
    }

    public boolean isEmpty() {
        return this.children.isEmpty();
    }

    @Override // org.junit.runners.ParentRunner
    protected List getChildren() {
        return this.children;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.ParentRunner
    public Description describeChild(PickleRunners.PickleRunner pickleRunner) {
        return pickleRunner.getDescription();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.ParentRunner
    public void runChild(PickleRunners.PickleRunner pickleRunner, RunNotifier runNotifier) {
        pickleRunner.run(runNotifier);
    }

    private void buildFeatureElementRunners(Filters filters, ThreadLocalRunnerSupplier threadLocalRunnerSupplier, JUnitOptions jUnitOptions) {
        for (PickleEvent pickleEvent : this.cucumberFeature.getPickles()) {
            if (filters.matchesFilters(pickleEvent)) {
                try {
                    if (jUnitOptions.stepNotifications()) {
                        this.children.add(PickleRunners.withStepDescriptions(threadLocalRunnerSupplier, pickleEvent, jUnitOptions));
                    } else {
                        this.children.add(PickleRunners.withNoStepDescriptions(this.cucumberFeature.getName(), threadLocalRunnerSupplier, pickleEvent, jUnitOptions));
                    }
                } catch (InitializationError e) {
                    throw new CucumberException("Failed to create scenario runner", e);
                }
            }
        }
    }

    private static final class FeatureId implements Serializable {
        private static final long serialVersionUID = 1;
        private final URI uri;

        FeatureId(CucumberFeature cucumberFeature) {
            this.uri = cucumberFeature.getUri();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || FeatureId.class != obj.getClass()) {
                return false;
            }
            return this.uri.equals(((FeatureId) obj).uri);
        }

        public int hashCode() {
            return this.uri.hashCode();
        }

        public String toString() {
            return this.uri.toString();
        }
    }
}
