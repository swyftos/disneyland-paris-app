package io.cucumber.junit;

import cucumber.runner.Runner;
import cucumber.runner.RunnerSupplier;
import gherkin.events.PickleEvent;
import gherkin.pickles.PickleStep;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;

/* loaded from: classes5.dex */
abstract class PickleRunners {

    interface PickleRunner {
        Description describeChild(PickleStep pickleStep);

        Description getDescription();

        void run(RunNotifier runNotifier);
    }

    static PickleRunner withStepDescriptions(RunnerSupplier runnerSupplier, PickleEvent pickleEvent, JUnitOptions jUnitOptions) {
        return new WithStepDescriptions(runnerSupplier, pickleEvent, jUnitOptions);
    }

    static PickleRunner withNoStepDescriptions(String str, RunnerSupplier runnerSupplier, PickleEvent pickleEvent, JUnitOptions jUnitOptions) {
        return new NoStepDescriptions(str, runnerSupplier, pickleEvent, jUnitOptions);
    }

    static class WithStepDescriptions extends ParentRunner implements PickleRunner {
        private Description description;
        private final JUnitOptions jUnitOptions;
        private final PickleEvent pickleEvent;
        private final RunnerSupplier runnerSupplier;
        private final Map stepDescriptions;

        WithStepDescriptions(RunnerSupplier runnerSupplier, PickleEvent pickleEvent, JUnitOptions jUnitOptions) {
            super((Class<?>) null);
            this.stepDescriptions = new HashMap();
            this.runnerSupplier = runnerSupplier;
            this.pickleEvent = pickleEvent;
            this.jUnitOptions = jUnitOptions;
        }

        @Override // org.junit.runners.ParentRunner
        protected List getChildren() {
            return this.pickleEvent.pickle.getSteps();
        }

        @Override // org.junit.runners.ParentRunner
        protected String getName() {
            return PickleRunners.getPickleName(this.pickleEvent, this.jUnitOptions.filenameCompatibleNames());
        }

        @Override // org.junit.runners.ParentRunner, org.junit.runner.Runner, org.junit.runner.Describable
        public Description getDescription() {
            if (this.description == null) {
                this.description = Description.createSuiteDescription(getName(), new PickleId(this.pickleEvent), new Annotation[0]);
                Iterator it = getChildren().iterator();
                while (it.hasNext()) {
                    this.description.addChild(describeChild((PickleStep) it.next()));
                }
            }
            return this.description;
        }

        @Override // org.junit.runners.ParentRunner
        public Description describeChild(PickleStep pickleStep) {
            String text;
            Description description = (Description) this.stepDescriptions.get(pickleStep);
            if (description != null) {
                return description;
            }
            if (this.jUnitOptions.filenameCompatibleNames()) {
                text = PickleRunners.makeNameFilenameCompatible(pickleStep.getText());
            } else {
                text = pickleStep.getText();
            }
            Description descriptionCreateTestDescription = Description.createTestDescription(getName(), text, new PickleStepId(this.pickleEvent, pickleStep));
            this.stepDescriptions.put(pickleStep, descriptionCreateTestDescription);
            return descriptionCreateTestDescription;
        }

        @Override // org.junit.runners.ParentRunner, org.junit.runner.Runner
        public void run(RunNotifier runNotifier) {
            Runner runner = this.runnerSupplier.get();
            JUnitReporter jUnitReporter = new JUnitReporter(runner.getBus(), this.jUnitOptions);
            jUnitReporter.startExecutionUnit(this, runNotifier);
            runner.runPickle(this.pickleEvent);
            jUnitReporter.finishExecutionUnit();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.junit.runners.ParentRunner
        public void runChild(PickleStep pickleStep, RunNotifier runNotifier) {
            throw new UnsupportedOperationException();
        }
    }

    static final class NoStepDescriptions implements PickleRunner {
        private Description description;
        private final String featureName;
        private final JUnitOptions jUnitOptions;
        private final PickleEvent pickleEvent;
        private final RunnerSupplier runnerSupplier;

        NoStepDescriptions(String str, RunnerSupplier runnerSupplier, PickleEvent pickleEvent, JUnitOptions jUnitOptions) {
            this.featureName = str;
            this.runnerSupplier = runnerSupplier;
            this.pickleEvent = pickleEvent;
            this.jUnitOptions = jUnitOptions;
        }

        @Override // io.cucumber.junit.PickleRunners.PickleRunner
        public Description getDescription() {
            if (this.description == null) {
                this.description = Description.createTestDescription(PickleRunners.createName(this.featureName, this.jUnitOptions.filenameCompatibleNames()), PickleRunners.getPickleName(this.pickleEvent, this.jUnitOptions.filenameCompatibleNames()), new PickleId(this.pickleEvent));
            }
            return this.description;
        }

        @Override // io.cucumber.junit.PickleRunners.PickleRunner
        public Description describeChild(PickleStep pickleStep) {
            throw new UnsupportedOperationException("This pickle runner does not wish to describe its children");
        }

        @Override // io.cucumber.junit.PickleRunners.PickleRunner
        public void run(RunNotifier runNotifier) {
            Runner runner = this.runnerSupplier.get();
            JUnitReporter jUnitReporter = new JUnitReporter(runner.getBus(), this.jUnitOptions);
            jUnitReporter.startExecutionUnit(this, runNotifier);
            runner.runPickle(this.pickleEvent);
            jUnitReporter.finishExecutionUnit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getPickleName(PickleEvent pickleEvent, boolean z) {
        return createName(pickleEvent.pickle.getName(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String createName(String str, boolean z) {
        if (str.isEmpty()) {
            return "EMPTY_NAME";
        }
        return z ? makeNameFilenameCompatible(str) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String makeNameFilenameCompatible(String str) {
        return str.replaceAll("[^A-Za-z0-9_]", "_");
    }

    static final class PickleId implements Serializable {
        private static final long serialVersionUID = 1;
        private int pickleLine;
        private final String uri;

        PickleId(String str, int i) {
            this.uri = str;
            this.pickleLine = i;
        }

        PickleId(PickleEvent pickleEvent) {
            this(pickleEvent.uri, pickleEvent.pickle.getLocations().get(0).getLine());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || PickleId.class != obj.getClass()) {
                return false;
            }
            PickleId pickleId = (PickleId) obj;
            return this.pickleLine == pickleId.pickleLine && this.uri.equals(pickleId.uri);
        }

        public int hashCode() {
            return (this.uri.hashCode() * 31) + this.pickleLine;
        }

        public String toString() {
            return this.uri + ":" + this.pickleLine;
        }
    }

    private static final class PickleStepId implements Serializable {
        private static final long serialVersionUID = 1;
        private final int pickleLine;
        private int pickleStepLine;
        private final String uri;

        PickleStepId(PickleEvent pickleEvent, PickleStep pickleStep) {
            this.uri = pickleEvent.uri;
            this.pickleLine = pickleEvent.pickle.getLocations().get(0).getLine();
            this.pickleStepLine = pickleStep.getLocations().get(r2.size() - 1).getLine();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || PickleStepId.class != obj.getClass()) {
                return false;
            }
            PickleStepId pickleStepId = (PickleStepId) obj;
            return this.pickleLine == pickleStepId.pickleLine && this.pickleStepLine == pickleStepId.pickleStepLine && this.uri.equals(pickleStepId.uri);
        }

        public int hashCode() {
            return (((this.pickleLine * 31) + this.uri.hashCode()) * 31) + this.pickleStepLine;
        }

        public String toString() {
            return this.uri + ":" + this.pickleLine + ":" + this.pickleStepLine;
        }
    }
}
