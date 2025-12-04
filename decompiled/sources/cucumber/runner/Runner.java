package cucumber.runner;

import cucumber.api.HookType;
import cucumber.api.StepDefinitionReporter;
import cucumber.api.event.SnippetsSuggestedEvent;
import cucumber.runtime.Backend;
import cucumber.runtime.HookDefinition;
import cucumber.util.FixJava;
import gherkin.events.PickleEvent;
import gherkin.pickles.PickleStep;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.core.options.RunnerOptions;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class Runner {
    private static final Logger log = LoggerFactory.getLogger(Runner.class);
    private final Collection backends;
    private final EventBus bus;
    private final Glue glue;
    private final RunnerOptions runnerOptions;

    public Runner(EventBus eventBus, Collection<? extends Backend> collection, RunnerOptions runnerOptions) {
        this.bus = eventBus;
        this.glue = new Glue(eventBus);
        this.runnerOptions = runnerOptions;
        this.backends = collection;
        List<URI> glue = runnerOptions.getGlue();
        log.debug("Loading glue from " + FixJava.join(glue, ", "));
        for (Backend backend : collection) {
            log.debug("Loading glue for backend " + backend.getClass().getName());
            backend.loadGlue(this.glue, glue);
        }
    }

    public EventBus getBus() {
        return this.bus;
    }

    public void runPickle(PickleEvent pickleEvent) {
        buildBackendWorlds();
        createTestCaseForPickle(pickleEvent).run(this.bus);
        disposeBackendWorlds();
    }

    public void reportStepDefinitions(StepDefinitionReporter stepDefinitionReporter) {
        this.glue.reportStepDefinitions(stepDefinitionReporter);
    }

    private TestCase createTestCaseForPickle(PickleEvent pickleEvent) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (!pickleEvent.pickle.getSteps().isEmpty()) {
            addTestStepsForBeforeHooks(arrayList2, pickleEvent.pickle.getTags());
            addTestStepsForPickleSteps(arrayList, pickleEvent);
            addTestStepsForAfterHooks(arrayList3, pickleEvent.pickle.getTags());
        }
        return new TestCase(arrayList, arrayList2, arrayList3, pickleEvent, this.runnerOptions.isDryRun());
    }

    private void addTestStepsForPickleSteps(List list, PickleEvent pickleEvent) {
        PickleStepDefinitionMatch failedPickleStepInstantiationMatch;
        PickleStepDefinitionMatch pickleStepDefinitionMatch;
        for (PickleStep pickleStep : pickleEvent.pickle.getSteps()) {
            try {
                PickleStepDefinitionMatch pickleStepDefinitionMatchStepDefinitionMatch = this.glue.stepDefinitionMatch(pickleEvent.uri, pickleStep);
                if (pickleStepDefinitionMatchStepDefinitionMatch == null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = this.backends.iterator();
                    while (it.hasNext()) {
                        arrayList.addAll(((Backend) it.next()).getSnippet(pickleStep, "**KEYWORD**", this.runnerOptions.getSnippetType().getFunctionNameGenerator()));
                    }
                    if (!arrayList.isEmpty()) {
                        EventBus eventBus = this.bus;
                        eventBus.send(new SnippetsSuggestedEvent(eventBus.getTime(), this.bus.getTimeMillis().longValue(), pickleEvent.uri, pickleStep.getLocations(), arrayList));
                    }
                    pickleStepDefinitionMatchStepDefinitionMatch = new UndefinedPickleStepDefinitionMatch(pickleStep);
                }
                pickleStepDefinitionMatch = pickleStepDefinitionMatchStepDefinitionMatch;
            } catch (AmbiguousStepDefinitionsException e) {
                failedPickleStepInstantiationMatch = new AmbiguousPickleStepDefinitionsMatch(pickleEvent.uri, pickleStep, e);
                pickleStepDefinitionMatch = failedPickleStepInstantiationMatch;
                List afterStepHooks = getAfterStepHooks(pickleEvent.pickle.getTags());
                list.add(new PickleStepTestStep(pickleEvent.uri, pickleStep, getBeforeStepHooks(pickleEvent.pickle.getTags()), afterStepHooks, pickleStepDefinitionMatch));
            } catch (Throwable th) {
                failedPickleStepInstantiationMatch = new FailedPickleStepInstantiationMatch(pickleEvent.uri, pickleStep, th);
                pickleStepDefinitionMatch = failedPickleStepInstantiationMatch;
                List afterStepHooks2 = getAfterStepHooks(pickleEvent.pickle.getTags());
                list.add(new PickleStepTestStep(pickleEvent.uri, pickleStep, getBeforeStepHooks(pickleEvent.pickle.getTags()), afterStepHooks2, pickleStepDefinitionMatch));
            }
            List afterStepHooks22 = getAfterStepHooks(pickleEvent.pickle.getTags());
            list.add(new PickleStepTestStep(pickleEvent.uri, pickleStep, getBeforeStepHooks(pickleEvent.pickle.getTags()), afterStepHooks22, pickleStepDefinitionMatch));
        }
    }

    private void addTestStepsForBeforeHooks(List list, List list2) {
        addTestStepsForHooks(list, list2, this.glue.getBeforeHooks(), HookType.Before);
    }

    private void addTestStepsForAfterHooks(List list, List list2) {
        addTestStepsForHooks(list, list2, this.glue.getAfterHooks(), HookType.After);
    }

    private void addTestStepsForHooks(List list, List list2, List list3, HookType hookType) {
        Iterator it = list3.iterator();
        while (it.hasNext()) {
            HookDefinition hookDefinition = (HookDefinition) it.next();
            if (hookDefinition.matches(list2)) {
                list.add(new HookTestStep(hookType, new HookDefinitionMatch(hookDefinition)));
            }
        }
    }

    private List getAfterStepHooks(List list) {
        ArrayList arrayList = new ArrayList();
        addTestStepsForHooks(arrayList, list, this.glue.getAfterStepHooks(), HookType.AfterStep);
        return arrayList;
    }

    private List getBeforeStepHooks(List list) {
        ArrayList arrayList = new ArrayList();
        addTestStepsForHooks(arrayList, list, this.glue.getBeforeStepHooks(), HookType.BeforeStep);
        return arrayList;
    }

    private void buildBackendWorlds() {
        Iterator it = this.backends.iterator();
        while (it.hasNext()) {
            ((Backend) it.next()).buildWorld();
        }
    }

    private void disposeBackendWorlds() {
        Iterator it = this.backends.iterator();
        while (it.hasNext()) {
            ((Backend) it.next()).disposeWorld();
        }
        this.glue.removeScenarioScopedGlue();
    }
}
