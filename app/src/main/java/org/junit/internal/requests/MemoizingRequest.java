package org.junit.internal.requests;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.runner.Request;
import org.junit.runner.Runner;

/* JADX INFO: loaded from: classes2.dex */
abstract class MemoizingRequest extends Request {
    private volatile Runner runner;
    private final Lock runnerLock = new ReentrantLock();

    protected abstract Runner createRunner();

    MemoizingRequest() {
    }

    @Override // org.junit.runner.Request
    public final Runner getRunner() {
        if (this.runner == null) {
            this.runnerLock.lock();
            try {
                if (this.runner == null) {
                    this.runner = createRunner();
                }
            } finally {
                this.runnerLock.unlock();
            }
        }
        return this.runner;
    }
}
