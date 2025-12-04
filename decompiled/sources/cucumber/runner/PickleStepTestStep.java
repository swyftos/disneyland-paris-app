package cucumber.runner;

import cucumber.runtime.DefinitionArgument;
import gherkin.pickles.PickleStep;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
class PickleStepTestStep extends TestStep implements cucumber.api.PickleStepTestStep {
    private final List afterStepHookSteps;
    private final List beforeStepHookSteps;
    private final PickleStepDefinitionMatch definitionMatch;
    private final PickleStep step;
    private final String uri;

    PickleStepTestStep(String str, PickleStep pickleStep, List list, List list2, PickleStepDefinitionMatch pickleStepDefinitionMatch) {
        super(pickleStepDefinitionMatch);
        this.uri = str;
        this.step = pickleStep;
        this.afterStepHookSteps = list2;
        this.beforeStepHookSteps = list;
        this.definitionMatch = pickleStepDefinitionMatch;
    }

    @Override // cucumber.runner.TestStep
    boolean run(cucumber.api.TestCase testCase, EventBus eventBus, Scenario scenario, boolean z) {
        Iterator it = this.beforeStepHookSteps.iterator();
        boolean zRun = z;
        while (it.hasNext()) {
            zRun |= ((HookTestStep) it.next()).run(testCase, eventBus, scenario, z);
        }
        boolean zRun2 = super.run(testCase, eventBus, scenario, zRun) | zRun;
        Iterator it2 = this.afterStepHookSteps.iterator();
        while (it2.hasNext()) {
            zRun2 |= ((HookTestStep) it2.next()).run(testCase, eventBus, scenario, z);
        }
        return zRun2;
    }

    List getBeforeStepHookSteps() {
        return this.beforeStepHookSteps;
    }

    List getAfterStepHookSteps() {
        return this.afterStepHookSteps;
    }

    @Override // cucumber.api.PickleStepTestStep
    public PickleStep getPickleStep() {
        return this.step;
    }

    @Override // cucumber.api.PickleStepTestStep
    public String getStepLocation() {
        return this.uri + ":" + Integer.toString(getStepLine());
    }

    @Override // cucumber.api.PickleStepTestStep
    public int getStepLine() {
        return this.step.getLocations().get(this.step.getLocations().size() - 1).getLine();
    }

    @Override // cucumber.api.PickleStepTestStep
    public String getStepText() {
        return this.step.getText();
    }

    @Override // cucumber.api.PickleStepTestStep
    public List getDefinitionArgument() {
        return DefinitionArgument.createArguments(this.definitionMatch.getArguments());
    }

    @Override // cucumber.api.PickleStepTestStep
    public List getStepArgument() {
        return this.step.getArgument();
    }

    @Override // cucumber.api.PickleStepTestStep
    public String getPattern() {
        return this.definitionMatch.getPattern();
    }
}
