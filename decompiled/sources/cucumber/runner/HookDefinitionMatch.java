package cucumber.runner;

import cucumber.runtime.HookDefinition;
import cucumber.runtime.StepDefinitionMatch;

/* loaded from: classes5.dex */
final class HookDefinitionMatch implements StepDefinitionMatch {
    private final HookDefinition hookDefinition;

    @Override // cucumber.runtime.StepDefinitionMatch
    public void dryRunStep(cucumber.api.Scenario scenario) {
    }

    HookDefinitionMatch(HookDefinition hookDefinition) {
        this.hookDefinition = hookDefinition;
    }

    @Override // cucumber.runtime.StepDefinitionMatch
    public void runStep(cucumber.api.Scenario scenario) throws Throwable {
        this.hookDefinition.execute(scenario);
    }

    @Override // cucumber.runtime.StepDefinitionMatch
    public String getCodeLocation() {
        return this.hookDefinition.getLocation(false);
    }
}
