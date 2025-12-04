package org.junit.runners.model;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.TestCouldNotBeSkippedException;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.Throwables;

/* loaded from: classes6.dex */
public class MultipleFailureException extends Exception {
    private static final long serialVersionUID = 1;
    private final List fErrors;

    public MultipleFailureException(List<Throwable> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List of Throwables must not be empty");
        }
        this.fErrors = new ArrayList(list.size());
        for (Throwable testCouldNotBeSkippedException : list) {
            if (testCouldNotBeSkippedException instanceof AssumptionViolatedException) {
                testCouldNotBeSkippedException = new TestCouldNotBeSkippedException((AssumptionViolatedException) testCouldNotBeSkippedException);
            }
            this.fErrors.add(testCouldNotBeSkippedException);
        }
    }

    public List<Throwable> getFailures() {
        return Collections.unmodifiableList(this.fErrors);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(String.format("There were %d errors:", Integer.valueOf(this.fErrors.size())));
        for (Throwable th : this.fErrors) {
            sb.append(String.format("%n  %s(%s)", th.getClass().getName(), th.getMessage()));
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        Iterator it = this.fErrors.iterator();
        while (it.hasNext()) {
            ((Throwable) it.next()).printStackTrace();
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        Iterator it = this.fErrors.iterator();
        while (it.hasNext()) {
            ((Throwable) it.next()).printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        Iterator it = this.fErrors.iterator();
        while (it.hasNext()) {
            ((Throwable) it.next()).printStackTrace(printWriter);
        }
    }

    public static void assertEmpty(List<Throwable> list) throws Exception {
        if (list.isEmpty()) {
            return;
        }
        if (list.size() == 1) {
            throw Throwables.rethrowAsException(list.get(0));
        }
        throw new org.junit.internal.runners.model.MultipleFailureException(list);
    }
}
