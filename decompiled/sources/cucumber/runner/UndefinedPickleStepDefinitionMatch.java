package cucumber.runner;

import gherkin.pickles.PickleStep;
import java.util.Collections;

/* loaded from: classes5.dex */
class UndefinedPickleStepDefinitionMatch extends PickleStepDefinitionMatch {
    UndefinedPickleStepDefinitionMatch(PickleStep pickleStep) {
        super(Collections.emptyList(), new NoStepDefinition(), null, pickleStep);
    }

    @Override // cucumber.runner.PickleStepDefinitionMatch, cucumber.runtime.StepDefinitionMatch
    public void runStep(cucumber.api.Scenario scenario) {
        throw new UndefinedStepDefinitionException();
    }

    @Override // cucumber.runner.PickleStepDefinitionMatch, cucumber.runtime.StepDefinitionMatch
    public void dryRunStep(cucumber.api.Scenario scenario) {
        runStep(scenario);
    }
}
