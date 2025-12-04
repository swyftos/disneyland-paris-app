package io.cucumber.junit;

import cucumber.api.PickleStepTestStep;
import cucumber.api.Result;
import cucumber.api.TestStep;
import cucumber.api.event.EventHandler;
import cucumber.api.event.TestCaseFinished;
import cucumber.api.event.TestCaseStarted;
import cucumber.api.event.TestStepFinished;
import cucumber.api.event.TestStepStarted;
import cucumber.runner.EventBus;
import gherkin.pickles.PickleStep;
import io.cucumber.junit.PickleRunners;
import io.cucumber.junit.SkippedThrowable;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;
import org.junit.runners.model.MultipleFailureException;

/* loaded from: classes5.dex */
final class JUnitReporter {
    private final EventBus bus;
    private final JUnitOptions junitOptions;
    private PickleRunners.PickleRunner pickleRunner;
    TestNotifier pickleRunnerNotifier;
    private RunNotifier runNotifier;
    ArrayList stepErrors;
    TestNotifier stepNotifier;
    private final EventHandler testCaseFinishedHandler;
    private final EventHandler testCaseStartedHandler;
    private final EventHandler testStepFinishedHandler;
    private final EventHandler testStepStartedHandler;

    private interface TestNotifier {
        void addFailedAssumption(Throwable th);

        void addFailure(Throwable th);

        void fireTestFinished();

        void fireTestStarted();
    }

    JUnitReporter(EventBus eventBus, JUnitOptions jUnitOptions) {
        EventHandler eventHandler = new EventHandler() { // from class: io.cucumber.junit.JUnitReporter.1
            @Override // cucumber.api.event.EventHandler
            public void receive(TestCaseStarted testCaseStarted) {
                JUnitReporter.this.handleTestCaseStarted();
            }
        };
        this.testCaseStartedHandler = eventHandler;
        EventHandler eventHandler2 = new EventHandler() { // from class: io.cucumber.junit.JUnitReporter.2
            @Override // cucumber.api.event.EventHandler
            public void receive(TestStepStarted testStepStarted) {
                TestStep testStep = testStepStarted.testStep;
                if (testStep instanceof PickleStepTestStep) {
                    JUnitReporter.this.handleStepStarted(((PickleStepTestStep) testStep).getPickleStep());
                }
            }
        };
        this.testStepStartedHandler = eventHandler2;
        EventHandler eventHandler3 = new EventHandler() { // from class: io.cucumber.junit.JUnitReporter.3
            @Override // cucumber.api.event.EventHandler
            public void receive(TestStepFinished testStepFinished) {
                TestStep testStep = testStepFinished.testStep;
                if (testStep instanceof PickleStepTestStep) {
                    JUnitReporter.this.handleStepResult((PickleStepTestStep) testStep, testStepFinished.result);
                } else {
                    JUnitReporter.this.handleHookResult(testStepFinished.result);
                }
            }
        };
        this.testStepFinishedHandler = eventHandler3;
        EventHandler eventHandler4 = new EventHandler() { // from class: io.cucumber.junit.JUnitReporter.4
            @Override // cucumber.api.event.EventHandler
            public void receive(TestCaseFinished testCaseFinished) {
                JUnitReporter.this.handleTestCaseResult(testCaseFinished.result);
            }
        };
        this.testCaseFinishedHandler = eventHandler4;
        this.junitOptions = jUnitOptions;
        this.bus = eventBus;
        eventBus.registerHandlerFor(TestCaseStarted.class, eventHandler);
        eventBus.registerHandlerFor(TestStepStarted.class, eventHandler2);
        eventBus.registerHandlerFor(TestStepFinished.class, eventHandler3);
        eventBus.registerHandlerFor(TestCaseFinished.class, eventHandler4);
    }

    void finishExecutionUnit() {
        this.bus.removeHandlerFor(TestCaseStarted.class, this.testCaseStartedHandler);
        this.bus.removeHandlerFor(TestStepStarted.class, this.testStepStartedHandler);
        this.bus.removeHandlerFor(TestStepFinished.class, this.testStepFinishedHandler);
        this.bus.removeHandlerFor(TestCaseFinished.class, this.testCaseFinishedHandler);
    }

    void startExecutionUnit(PickleRunners.PickleRunner pickleRunner, RunNotifier runNotifier) {
        this.pickleRunner = pickleRunner;
        this.runNotifier = runNotifier;
        this.stepNotifier = null;
        this.pickleRunnerNotifier = new EachTestNotifier(runNotifier, pickleRunner.getDescription());
    }

    void handleTestCaseStarted() {
        this.pickleRunnerNotifier.fireTestStarted();
        this.stepErrors = new ArrayList();
    }

    void handleStepStarted(PickleStep pickleStep) {
        if (this.junitOptions.stepNotifications()) {
            this.stepNotifier = new EachTestNotifier(this.runNotifier, this.pickleRunner.describeChild(pickleStep));
        } else {
            this.stepNotifier = new NoTestNotifier();
        }
        this.stepNotifier.fireTestStarted();
    }

    /* renamed from: io.cucumber.junit.JUnitReporter$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$cucumber$api$Result$Type;

        static {
            int[] iArr = new int[Result.Type.values().length];
            $SwitchMap$cucumber$api$Result$Type = iArr;
            try {
                iArr[Result.Type.PASSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cucumber$api$Result$Type[Result.Type.SKIPPED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cucumber$api$Result$Type[Result.Type.PENDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cucumber$api$Result$Type[Result.Type.UNDEFINED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cucumber$api$Result$Type[Result.Type.AMBIGUOUS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$cucumber$api$Result$Type[Result.Type.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    void handleStepResult(PickleStepTestStep pickleStepTestStep, Result result) {
        Throwable error = result.getError();
        switch (AnonymousClass5.$SwitchMap$cucumber$api$Result$Type[result.getStatus().ordinal()]) {
            case 1:
                break;
            case 2:
                if (error == null) {
                    error = new SkippedThrowable(SkippedThrowable.NotificationLevel.STEP);
                } else {
                    this.stepErrors.add(error);
                }
                this.stepNotifier.addFailedAssumption(error);
                break;
            case 3:
                this.stepErrors.add(error);
                addFailureOrFailedAssumptionDependingOnStrictMode(this.stepNotifier, error);
                break;
            case 4:
                if (error == null) {
                    error = new UndefinedThrowable();
                }
                this.stepErrors.add(new UndefinedThrowable(pickleStepTestStep.getStepText()));
                addFailureOrFailedAssumptionDependingOnStrictMode(this.stepNotifier, error);
                break;
            case 5:
            case 6:
                this.stepErrors.add(error);
                this.stepNotifier.addFailure(error);
                break;
            default:
                throw new IllegalStateException("Unexpected result status: " + result.getStatus());
        }
        this.stepNotifier.fireTestFinished();
    }

    void handleHookResult(Result result) {
        if (result.getError() != null) {
            this.stepErrors.add(result.getError());
        }
    }

    void handleTestCaseResult(Result result) {
        int i = AnonymousClass5.$SwitchMap$cucumber$api$Result$Type[result.getStatus().ordinal()];
        if (i == 2) {
            if (this.stepErrors.isEmpty()) {
                this.stepErrors.add(new SkippedThrowable(SkippedThrowable.NotificationLevel.SCENARIO));
            }
            Iterator it = this.stepErrors.iterator();
            while (it.hasNext()) {
                this.pickleRunnerNotifier.addFailedAssumption((Throwable) it.next());
            }
        } else if (i == 3 || i == 4) {
            Iterator it2 = this.stepErrors.iterator();
            while (it2.hasNext()) {
                addFailureOrFailedAssumptionDependingOnStrictMode(this.pickleRunnerNotifier, (Throwable) it2.next());
            }
        } else if (i == 5 || i == 6) {
            Iterator it3 = this.stepErrors.iterator();
            while (it3.hasNext()) {
                this.pickleRunnerNotifier.addFailure((Throwable) it3.next());
            }
        }
        this.pickleRunnerNotifier.fireTestFinished();
    }

    private void addFailureOrFailedAssumptionDependingOnStrictMode(TestNotifier testNotifier, Throwable th) {
        if (this.junitOptions.isStrict()) {
            testNotifier.addFailure(th);
        } else {
            testNotifier.addFailedAssumption(th);
        }
    }

    static final class NoTestNotifier implements TestNotifier {
        @Override // io.cucumber.junit.JUnitReporter.TestNotifier
        public void addFailedAssumption(Throwable th) {
        }

        @Override // io.cucumber.junit.JUnitReporter.TestNotifier
        public void addFailure(Throwable th) {
        }

        @Override // io.cucumber.junit.JUnitReporter.TestNotifier
        public void fireTestFinished() {
        }

        @Override // io.cucumber.junit.JUnitReporter.TestNotifier
        public void fireTestStarted() {
        }

        NoTestNotifier() {
        }
    }

    static class EachTestNotifier implements TestNotifier {
        private final Description description;
        private final RunNotifier notifier;

        EachTestNotifier(RunNotifier runNotifier, Description description) {
            this.notifier = runNotifier;
            this.description = description;
        }

        @Override // io.cucumber.junit.JUnitReporter.TestNotifier
        public void addFailure(Throwable th) {
            if (th instanceof MultipleFailureException) {
                addMultipleFailureException((MultipleFailureException) th);
            } else {
                this.notifier.fireTestFailure(new Failure(this.description, th));
            }
        }

        private void addMultipleFailureException(MultipleFailureException multipleFailureException) {
            Iterator<Throwable> it = multipleFailureException.getFailures().iterator();
            while (it.hasNext()) {
                addFailure(it.next());
            }
        }

        @Override // io.cucumber.junit.JUnitReporter.TestNotifier
        public void addFailedAssumption(Throwable th) {
            this.notifier.fireTestAssumptionFailed(new Failure(this.description, th));
        }

        @Override // io.cucumber.junit.JUnitReporter.TestNotifier
        public void fireTestFinished() {
            this.notifier.fireTestFinished(this.description);
        }

        @Override // io.cucumber.junit.JUnitReporter.TestNotifier
        public void fireTestStarted() throws StoppedByUserException {
            this.notifier.fireTestStarted(this.description);
        }
    }
}
