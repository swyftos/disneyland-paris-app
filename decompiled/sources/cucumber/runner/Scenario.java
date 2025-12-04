package cucumber.runner;

import cucumber.api.Result;
import cucumber.api.event.EmbedEvent;
import cucumber.api.event.WriteEvent;
import gherkin.pickles.PickleTag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
class Scenario implements cucumber.api.Scenario {
    private final EventBus bus;
    private final List stepResults = new ArrayList();
    private final TestCase testCase;

    Scenario(EventBus eventBus, TestCase testCase) {
        this.bus = eventBus;
        this.testCase = testCase;
    }

    public void add(Result result) {
        this.stepResults.add(result);
    }

    @Override // cucumber.api.Scenario
    public Collection getSourceTagNames() {
        HashSet hashSet = new HashSet();
        Iterator it = this.testCase.getTags().iterator();
        while (it.hasNext()) {
            hashSet.add(((PickleTag) it.next()).getName());
        }
        return new ArrayList(hashSet);
    }

    @Override // cucumber.api.Scenario
    public Result.Type getStatus() {
        if (this.stepResults.isEmpty()) {
            return Result.Type.UNDEFINED;
        }
        return ((Result) Collections.max(this.stepResults, Result.SEVERITY)).getStatus();
    }

    @Override // cucumber.api.Scenario
    public boolean isFailed() {
        return getStatus() == Result.Type.FAILED;
    }

    @Override // cucumber.api.Scenario
    public void embed(byte[] bArr, String str) {
        EventBus eventBus = this.bus;
        eventBus.send(new EmbedEvent(eventBus.getTime(), this.bus.getTimeMillis().longValue(), this.testCase, bArr, str));
    }

    @Override // cucumber.api.Scenario
    public void embed(byte[] bArr, String str, String str2) {
        EventBus eventBus = this.bus;
        eventBus.send(new EmbedEvent(eventBus.getTime(), this.bus.getTimeMillis().longValue(), this.testCase, bArr, str, str2));
    }

    @Override // cucumber.api.Scenario
    public void write(String str) {
        EventBus eventBus = this.bus;
        eventBus.send(new WriteEvent(eventBus.getTime(), this.bus.getTimeMillis().longValue(), this.testCase, str));
    }

    @Override // cucumber.api.Scenario
    public String getName() {
        return this.testCase.getName();
    }

    @Override // cucumber.api.Scenario
    public String getId() {
        return this.testCase.getUri() + ":" + this.testCase.getLine();
    }

    @Override // cucumber.api.Scenario
    public String getUri() {
        return this.testCase.getUri();
    }

    @Override // cucumber.api.Scenario
    public List getLines() {
        return this.testCase.getLines();
    }

    public Throwable getError() {
        if (this.stepResults.isEmpty()) {
            return null;
        }
        return ((Result) Collections.max(this.stepResults, Result.SEVERITY)).getError();
    }
}
