package cucumber.runner;

import cucumber.runtime.StepDefinition;
import gherkin.pickles.PickleStep;
import java.util.List;

/* loaded from: classes5.dex */
final class NoStepDefinition implements StepDefinition {
    @Override // cucumber.runtime.StepDefinition
    public void execute(Object[] objArr) {
    }

    @Override // cucumber.runtime.StepDefinition
    public String getLocation(boolean z) {
        return null;
    }

    @Override // cucumber.runtime.StepDefinition
    public String getPattern() {
        return null;
    }

    @Override // cucumber.runtime.StepDefinition
    public boolean isDefinedAt(StackTraceElement stackTraceElement) {
        return false;
    }

    @Override // cucumber.runtime.StepDefinition
    public boolean isScenarioScoped() {
        return false;
    }

    @Override // cucumber.runtime.StepDefinition
    public List matchedArguments(PickleStep pickleStep) {
        return null;
    }

    NoStepDefinition() {
    }

    @Override // cucumber.runtime.StepDefinition
    public Integer getParameterCount() {
        return 0;
    }
}
