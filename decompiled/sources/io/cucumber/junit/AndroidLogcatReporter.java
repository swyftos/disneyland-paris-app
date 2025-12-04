package io.cucumber.junit;

import android.util.Log;
import cucumber.api.PickleStepTestStep;
import cucumber.api.TestStep;
import cucumber.api.event.ConcurrentEventListener;
import cucumber.api.event.EventHandler;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestCaseStarted;
import cucumber.api.event.TestRunFinished;
import cucumber.api.event.TestStepStarted;
import cucumber.runtime.UndefinedStepsTracker;
import cucumber.runtime.formatter.Stats;
import java.util.Iterator;

/* loaded from: classes5.dex */
public final class AndroidLogcatReporter implements ConcurrentEventListener {
    private final String logTag;
    private final Stats stats;
    private final UndefinedStepsTracker undefinedStepsTracker;
    private final EventHandler testCaseStartedHandler = new EventHandler() { // from class: io.cucumber.junit.AndroidLogcatReporter.1
        @Override // cucumber.api.event.EventHandler
        public void receive(TestCaseStarted testCaseStarted) {
            Log.d(AndroidLogcatReporter.this.logTag, String.format("%s", testCaseStarted.testCase.getName()));
        }
    };
    private final EventHandler testStepStartedHandler = new EventHandler() { // from class: io.cucumber.junit.AndroidLogcatReporter.2
        @Override // cucumber.api.event.EventHandler
        public void receive(TestStepStarted testStepStarted) {
            TestStep testStep = testStepStarted.testStep;
            if (testStep instanceof PickleStepTestStep) {
                Log.d(AndroidLogcatReporter.this.logTag, String.format("%s", ((PickleStepTestStep) testStep).getStepText()));
            }
        }
    };
    private EventHandler runFinishHandler = new EventHandler() { // from class: io.cucumber.junit.AndroidLogcatReporter.3
        @Override // cucumber.api.event.EventHandler
        public void receive(TestRunFinished testRunFinished) {
            Iterator<Throwable> it = AndroidLogcatReporter.this.stats.getErrors().iterator();
            while (it.hasNext()) {
                Log.e(AndroidLogcatReporter.this.logTag, it.next().toString());
            }
            Iterator<String> it2 = AndroidLogcatReporter.this.undefinedStepsTracker.getSnippets().iterator();
            while (it2.hasNext()) {
                Log.w(AndroidLogcatReporter.this.logTag, it2.next());
            }
        }
    };

    public AndroidLogcatReporter(Stats stats, UndefinedStepsTracker undefinedStepsTracker, String str) {
        this.stats = stats;
        this.undefinedStepsTracker = undefinedStepsTracker;
        this.logTag = str;
    }

    @Override // cucumber.api.event.ConcurrentEventListener
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestCaseStarted.class, this.testCaseStartedHandler);
        eventPublisher.registerHandlerFor(TestStepStarted.class, this.testStepStartedHandler);
        eventPublisher.registerHandlerFor(TestRunFinished.class, this.runFinishHandler);
    }
}
