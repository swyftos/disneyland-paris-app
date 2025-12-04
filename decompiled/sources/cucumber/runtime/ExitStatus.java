package cucumber.runtime;

import cucumber.api.Result;
import cucumber.api.event.EventHandler;
import cucumber.api.event.EventListener;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestCaseFinished;
import io.cucumber.core.options.RuntimeOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class ExitStatus implements EventListener {
    private final RuntimeOptions runtimeOptions;
    private final List results = new ArrayList();
    private final EventHandler testCaseFinishedHandler = new EventHandler() { // from class: cucumber.runtime.ExitStatus.1
        @Override // cucumber.api.event.EventHandler
        public void receive(TestCaseFinished testCaseFinished) {
            ExitStatus.this.results.add(testCaseFinished.result);
        }
    };

    public ExitStatus(RuntimeOptions runtimeOptions) {
        this.runtimeOptions = runtimeOptions;
    }

    @Override // cucumber.api.event.EventListener
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestCaseFinished.class, this.testCaseFinishedHandler);
    }

    public byte exitStatus() {
        if (this.results.isEmpty()) {
            return (byte) 0;
        }
        return this.runtimeOptions.isWip() ? ((Result) Collections.min(this.results, Result.SEVERITY)).is(Result.Type.PASSED) ? (byte) 1 : (byte) 0 : !((Result) Collections.max(this.results, Result.SEVERITY)).isOk(this.runtimeOptions.isStrict()) ? (byte) 1 : (byte) 0;
    }
}
