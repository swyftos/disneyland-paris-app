package androidx.test.internal.runner;

import java.util.ArrayList;
import java.util.Iterator;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;

/* loaded from: classes2.dex */
class NonExecutingRunner extends Runner implements Sortable, Filterable {
    private final Runner runner;

    NonExecutingRunner(Runner runner) {
        this.runner = runner;
    }

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public Description getDescription() {
        return this.runner.getDescription();
    }

    @Override // org.junit.runner.Runner
    public void run(RunNotifier runNotifier) throws StoppedByUserException {
        generateListOfTests(runNotifier, getDescription());
    }

    @Override // org.junit.runner.manipulation.Filterable
    public void filter(Filter filter) throws NoTestsRemainException {
        filter.apply(this.runner);
    }

    @Override // org.junit.runner.manipulation.Sortable
    public void sort(Sorter sorter) {
        sorter.apply(this.runner);
    }

    private void generateListOfTests(RunNotifier runNotifier, Description description) throws StoppedByUserException {
        ArrayList<Description> children = description.getChildren();
        if (children.isEmpty()) {
            runNotifier.fireTestStarted(description);
            runNotifier.fireTestFinished(description);
        } else {
            Iterator<Description> it = children.iterator();
            while (it.hasNext()) {
                generateListOfTests(runNotifier, it.next());
            }
        }
    }
}
