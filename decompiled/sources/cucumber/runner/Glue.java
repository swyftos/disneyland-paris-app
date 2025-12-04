package cucumber.runner;

import cucumber.api.StepDefinitionReporter;
import cucumber.api.event.StepDefinedEvent;
import cucumber.runtime.DuplicateStepDefinitionException;
import cucumber.runtime.HookDefinition;
import cucumber.runtime.ScenarioScoped;
import cucumber.runtime.StepDefinition;
import gherkin.pickles.PickleStep;
import io.cucumber.stepexpression.Argument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes5.dex */
final class Glue implements cucumber.runtime.Glue {
    private final EventBus bus;
    final Map stepDefinitionsByPattern = new TreeMap();
    final Map stepDefinitionsByStepText = new HashMap();
    final List beforeHooks = new ArrayList();
    final List beforeStepHooks = new ArrayList();
    final List afterHooks = new ArrayList();
    final List afterStepHooks = new ArrayList();

    public Glue(EventBus eventBus) {
        this.bus = eventBus;
    }

    @Override // cucumber.runtime.Glue
    public void addStepDefinition(StepDefinition stepDefinition) {
        StepDefinition stepDefinition2 = (StepDefinition) this.stepDefinitionsByPattern.get(stepDefinition.getPattern());
        if (stepDefinition2 != null) {
            throw new DuplicateStepDefinitionException(stepDefinition2, stepDefinition);
        }
        this.stepDefinitionsByPattern.put(stepDefinition.getPattern(), stepDefinition);
        EventBus eventBus = this.bus;
        eventBus.send(new StepDefinedEvent(eventBus.getTime(), this.bus.getTimeMillis(), stepDefinition));
    }

    @Override // cucumber.runtime.Glue
    public void addBeforeHook(HookDefinition hookDefinition) {
        this.beforeHooks.add(hookDefinition);
        Collections.sort(this.beforeHooks, new HookComparator(true));
    }

    @Override // cucumber.runtime.Glue
    public void addBeforeStepHook(HookDefinition hookDefinition) {
        this.beforeStepHooks.add(hookDefinition);
        Collections.sort(this.beforeStepHooks, new HookComparator(true));
    }

    @Override // cucumber.runtime.Glue
    public void addAfterHook(HookDefinition hookDefinition) {
        this.afterHooks.add(hookDefinition);
        Collections.sort(this.afterHooks, new HookComparator(false));
    }

    @Override // cucumber.runtime.Glue
    public void addAfterStepHook(HookDefinition hookDefinition) {
        this.afterStepHooks.add(hookDefinition);
        Collections.sort(this.afterStepHooks, new HookComparator(false));
    }

    List getBeforeHooks() {
        return this.beforeHooks;
    }

    List getBeforeStepHooks() {
        return this.beforeStepHooks;
    }

    List getAfterHooks() {
        return this.afterHooks;
    }

    List getAfterStepHooks() {
        return this.afterStepHooks;
    }

    PickleStepDefinitionMatch stepDefinitionMatch(String str, PickleStep pickleStep) {
        String text = pickleStep.getText();
        StepDefinition stepDefinition = (StepDefinition) this.stepDefinitionsByStepText.get(text);
        if (stepDefinition != null) {
            return new PickleStepDefinitionMatch(stepDefinition.matchedArguments(pickleStep), stepDefinition, str, pickleStep);
        }
        List listStepDefinitionMatches = stepDefinitionMatches(str, pickleStep);
        if (listStepDefinitionMatches.isEmpty()) {
            return null;
        }
        if (listStepDefinitionMatches.size() > 1) {
            throw new AmbiguousStepDefinitionsException(pickleStep, listStepDefinitionMatches);
        }
        PickleStepDefinitionMatch pickleStepDefinitionMatch = (PickleStepDefinitionMatch) listStepDefinitionMatches.get(0);
        this.stepDefinitionsByStepText.put(text, pickleStepDefinitionMatch.getStepDefinition());
        return pickleStepDefinitionMatch;
    }

    private List stepDefinitionMatches(String str, PickleStep pickleStep) {
        ArrayList arrayList = new ArrayList();
        for (StepDefinition stepDefinition : this.stepDefinitionsByPattern.values()) {
            List<Argument> listMatchedArguments = stepDefinition.matchedArguments(pickleStep);
            if (listMatchedArguments != null) {
                arrayList.add(new PickleStepDefinitionMatch(listMatchedArguments, stepDefinition, str, pickleStep));
            }
        }
        return arrayList;
    }

    void reportStepDefinitions(StepDefinitionReporter stepDefinitionReporter) {
        Iterator it = this.stepDefinitionsByPattern.values().iterator();
        while (it.hasNext()) {
            stepDefinitionReporter.stepDefinition((StepDefinition) it.next());
        }
    }

    @Override // cucumber.runtime.Glue
    public void removeScenarioScopedGlue() {
        removeScenarioScopedHooks(this.beforeHooks);
        removeScenarioScopedHooks(this.beforeStepHooks);
        removeScenarioScopedHooks(this.afterHooks);
        removeScenarioScopedHooks(this.afterStepHooks);
        removeScenariosScopedStepDefinitions(this.stepDefinitionsByPattern);
        removeScenariosScopedStepDefinitions(this.stepDefinitionsByStepText);
    }

    private void removeScenarioScopedHooks(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            HookDefinition hookDefinition = (HookDefinition) it.next();
            if (hookDefinition instanceof ScenarioScoped) {
                ((ScenarioScoped) hookDefinition).disposeScenarioScope();
            }
            if (hookDefinition.isScenarioScoped()) {
                it.remove();
            }
        }
    }

    private void removeScenariosScopedStepDefinitions(Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            StepDefinition stepDefinition = (StepDefinition) ((Map.Entry) it.next()).getValue();
            if (stepDefinition instanceof ScenarioScoped) {
                ((ScenarioScoped) stepDefinition).disposeScenarioScope();
            }
            if (stepDefinition.isScenarioScoped()) {
                it.remove();
            }
        }
    }
}
