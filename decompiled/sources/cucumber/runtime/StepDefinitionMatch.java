package cucumber.runtime;

import cucumber.api.Scenario;

/* loaded from: classes5.dex */
public interface StepDefinitionMatch {
    void dryRunStep(Scenario scenario) throws Throwable;

    String getCodeLocation();

    void runStep(Scenario scenario) throws Throwable;
}
