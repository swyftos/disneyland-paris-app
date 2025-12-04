package io.cucumber.junit;

import cucumber.runner.Runner;
import cucumber.runtime.model.CucumberFeature;
import gherkin.events.PickleEvent;
import gherkin.pickles.PickleStep;
import io.cucumber.junit.PickleRunners;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;

/* loaded from: classes5.dex */
public class AndroidPickleRunner implements PickleRunners.PickleRunner {
    private Description description;
    private final CucumberFeature feature;
    private final JUnitOptions jUnitOptions;
    private final PickleEvent pickleEvent;
    private final Runner runner;
    private String scenarioName;

    public AndroidPickleRunner(Runner runner, PickleEvent pickleEvent, JUnitOptions jUnitOptions, CucumberFeature cucumberFeature, String str) {
        this.runner = runner;
        this.pickleEvent = pickleEvent;
        this.jUnitOptions = jUnitOptions;
        this.feature = cucumberFeature;
        this.scenarioName = str;
    }

    @Override // io.cucumber.junit.PickleRunners.PickleRunner
    public Description getDescription() {
        if (this.description == null) {
            this.description = makeDescriptionFromPickle();
        }
        return this.description;
    }

    @Override // io.cucumber.junit.PickleRunners.PickleRunner
    public Description describeChild(PickleStep pickleStep) {
        throw new UnsupportedOperationException("This pickle runner does not wish to describe its children");
    }

    @Override // io.cucumber.junit.PickleRunners.PickleRunner
    public void run(RunNotifier runNotifier) {
        JUnitReporter jUnitReporter = new JUnitReporter(this.runner.getBus(), this.jUnitOptions);
        jUnitReporter.startExecutionUnit(this, runNotifier);
        this.runner.runPickle(this.pickleEvent);
        jUnitReporter.finishExecutionUnit();
    }

    private Description makeDescriptionFromPickle() {
        return Description.createTestDescription(this.feature.getName(), this.scenarioName, new PickleRunners.PickleId(this.pickleEvent));
    }
}
