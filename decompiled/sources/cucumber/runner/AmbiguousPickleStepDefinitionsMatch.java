package cucumber.runner;

import gherkin.pickles.PickleStep;
import java.util.Collections;

/* loaded from: classes5.dex */
final class AmbiguousPickleStepDefinitionsMatch extends PickleStepDefinitionMatch {
    private AmbiguousStepDefinitionsException exception;

    AmbiguousPickleStepDefinitionsMatch(String str, PickleStep pickleStep, AmbiguousStepDefinitionsException ambiguousStepDefinitionsException) {
        super(Collections.emptyList(), new NoStepDefinition(), str, pickleStep);
        this.exception = ambiguousStepDefinitionsException;
    }

    @Override // cucumber.runner.PickleStepDefinitionMatch, cucumber.runtime.StepDefinitionMatch
    public void runStep(cucumber.api.Scenario scenario) {
        throw this.exception;
    }

    @Override // cucumber.runner.PickleStepDefinitionMatch, cucumber.runtime.StepDefinitionMatch
    public void dryRunStep(cucumber.api.Scenario scenario) {
        runStep(scenario);
    }
}
