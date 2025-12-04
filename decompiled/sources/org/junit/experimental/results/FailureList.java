package org.junit.experimental.results;

import java.util.Iterator;
import java.util.List;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/* loaded from: classes6.dex */
class FailureList {
    private final List failures;

    public FailureList(List list) {
        this.failures = list;
    }

    public Result result() {
        Result result = new Result();
        RunListener runListenerCreateListener = result.createListener();
        Iterator it = this.failures.iterator();
        while (it.hasNext()) {
            try {
                runListenerCreateListener.testFailure((Failure) it.next());
            } catch (Exception unused) {
                throw new RuntimeException("I can't believe this happened");
            }
        }
        return result;
    }
}
