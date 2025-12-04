package cucumber.runner;

import gherkin.pickles.PickleStep;
import java.util.Collections;

/* loaded from: classes5.dex */
final class FailedPickleStepInstantiationMatch extends PickleStepDefinitionMatch {
    private final Throwable throwable;

    FailedPickleStepInstantiationMatch(String str, PickleStep pickleStep, Throwable th) {
        super(Collections.emptyList(), new NoStepDefinition(), str, pickleStep);
        this.throwable = removeFrameworkFramesAndAppendStepLocation(th, getStepLocation());
    }

    @Override // cucumber.runner.PickleStepDefinitionMatch, cucumber.runtime.StepDefinitionMatch
    public void runStep(cucumber.api.Scenario scenario) throws Throwable {
        throw this.throwable;
    }

    @Override // cucumber.runner.PickleStepDefinitionMatch, cucumber.runtime.StepDefinitionMatch
    public void dryRunStep(cucumber.api.Scenario scenario) throws Throwable {
        runStep(scenario);
    }
}
