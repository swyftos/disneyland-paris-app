package cucumber.runner;

import cucumber.api.Result;
import cucumber.api.event.TestCaseFinished;
import cucumber.api.event.TestCaseStarted;
import gherkin.events.PickleEvent;
import gherkin.pickles.PickleLocation;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
final class TestCase implements cucumber.api.TestCase {
    private final List afterHooks;
    private final List beforeHooks;
    private final boolean dryRun;
    private final PickleEvent pickleEvent;
    private final List testSteps;

    public TestCase(List list, List list2, List list3, PickleEvent pickleEvent, boolean z) {
        this.testSteps = list;
        this.beforeHooks = list2;
        this.afterHooks = list3;
        this.pickleEvent = pickleEvent;
        this.dryRun = z;
    }

    void run(EventBus eventBus) {
        boolean zRun = this.dryRun;
        Long timeMillis = eventBus.getTimeMillis();
        Long time = eventBus.getTime();
        eventBus.send(new TestCaseStarted(time, timeMillis.longValue(), this));
        Scenario scenario = new Scenario(eventBus, this);
        Iterator it = this.beforeHooks.iterator();
        while (it.hasNext()) {
            zRun |= ((HookTestStep) it.next()).run(this, eventBus, scenario, this.dryRun);
        }
        Iterator it2 = this.testSteps.iterator();
        while (it2.hasNext()) {
            zRun |= ((PickleStepTestStep) it2.next()).run(this, eventBus, scenario, zRun);
        }
        Iterator it3 = this.afterHooks.iterator();
        while (it3.hasNext()) {
            ((HookTestStep) it3.next()).run(this, eventBus, scenario, this.dryRun);
        }
        Long time2 = eventBus.getTime();
        eventBus.send(new TestCaseFinished(time2, eventBus.getTimeMillis().longValue(), this, new Result(scenario.getStatus(), Long.valueOf(time2.longValue() - time.longValue()), scenario.getError())));
    }

    @Override // cucumber.api.TestCase
    public List getTestSteps() {
        ArrayList arrayList = new ArrayList(this.beforeHooks);
        for (PickleStepTestStep pickleStepTestStep : this.testSteps) {
            arrayList.addAll(pickleStepTestStep.getBeforeStepHookSteps());
            arrayList.add(pickleStepTestStep);
            arrayList.addAll(pickleStepTestStep.getAfterStepHookSteps());
        }
        arrayList.addAll(this.afterHooks);
        return arrayList;
    }

    @Override // cucumber.api.TestCase
    public String getName() {
        return this.pickleEvent.pickle.getName();
    }

    @Override // cucumber.api.TestCase
    public String getScenarioDesignation() {
        return fileColonLine(this.pickleEvent.pickle.getLocations().get(0)) + " # " + getName();
    }

    @Override // cucumber.api.TestCase
    public String getUri() {
        return this.pickleEvent.uri;
    }

    @Override // cucumber.api.TestCase
    public int getLine() {
        return this.pickleEvent.pickle.getLocations().get(0).getLine();
    }

    public List getLines() {
        ArrayList arrayList = new ArrayList();
        Iterator<PickleLocation> it = this.pickleEvent.pickle.getLocations().iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().getLine()));
        }
        return arrayList;
    }

    private String fileColonLine(PickleLocation pickleLocation) {
        return URI.create(this.pickleEvent.uri).getSchemeSpecificPart() + ":" + pickleLocation.getLine();
    }

    @Override // cucumber.api.TestCase
    public List getTags() {
        return this.pickleEvent.pickle.getTags();
    }
}
