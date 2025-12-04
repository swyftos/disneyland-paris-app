package cucumber.runtime.formatter;

import cucumber.api.Result;
import cucumber.api.SummaryPrinter;
import cucumber.api.event.EventHandler;
import cucumber.api.event.EventListener;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.StepDefinedEvent;
import cucumber.api.event.TestRunFinished;
import cucumber.api.event.TestStepFinished;
import cucumber.api.formatter.ColorAware;
import cucumber.api.formatter.NiceAppendable;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes5.dex */
public class UnusedStepsSummaryPrinter implements ColorAware, EventListener, SummaryPrinter {
    private final NiceAppendable out;
    private EventHandler stepDefinedHandler = new EventHandler() { // from class: cucumber.runtime.formatter.UnusedStepsSummaryPrinter.1
        @Override // cucumber.api.event.EventHandler
        public void receive(StepDefinedEvent stepDefinedEvent) {
            UnusedStepsSummaryPrinter.this.unusedSteps.put(stepDefinedEvent.stepDefinition.getLocation(false), stepDefinedEvent.stepDefinition.getPattern());
        }
    };
    private EventHandler testStepFinishedHandler = new EventHandler() { // from class: cucumber.runtime.formatter.UnusedStepsSummaryPrinter.2
        @Override // cucumber.api.event.EventHandler
        public void receive(TestStepFinished testStepFinished) {
            String codeLocation = testStepFinished.testStep.getCodeLocation();
            if (codeLocation != null) {
                UnusedStepsSummaryPrinter.this.unusedSteps.remove(codeLocation);
            }
        }
    };
    private EventHandler testRunFinishedhandler = new EventHandler() { // from class: cucumber.runtime.formatter.UnusedStepsSummaryPrinter.3
        @Override // cucumber.api.event.EventHandler
        public void receive(TestRunFinished testRunFinished) throws IOException {
            if (UnusedStepsSummaryPrinter.this.unusedSteps.isEmpty()) {
                return;
            }
            Format format = UnusedStepsSummaryPrinter.this.formats.get(Result.Type.UNUSED.lowerCaseName());
            UnusedStepsSummaryPrinter.this.out.println(format.text(UnusedStepsSummaryPrinter.this.unusedSteps.size() + " Unused steps:"));
            for (Map.Entry entry : UnusedStepsSummaryPrinter.this.unusedSteps.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                UnusedStepsSummaryPrinter.this.out.println(format.text(str) + " # " + str2);
            }
        }
    };
    private final Map unusedSteps = new TreeMap();
    private Formats formats = new MonochromeFormats();

    public UnusedStepsSummaryPrinter(Appendable appendable) {
        this.out = new NiceAppendable(appendable);
    }

    @Override // cucumber.api.event.EventListener
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(StepDefinedEvent.class, this.stepDefinedHandler);
        eventPublisher.registerHandlerFor(TestStepFinished.class, this.testStepFinishedHandler);
        eventPublisher.registerHandlerFor(TestRunFinished.class, this.testRunFinishedhandler);
    }

    @Override // cucumber.api.formatter.ColorAware
    public void setMonochrome(boolean z) {
        if (z) {
            this.formats = new MonochromeFormats();
        } else {
            this.formats = new AnsiFormats();
        }
    }
}
