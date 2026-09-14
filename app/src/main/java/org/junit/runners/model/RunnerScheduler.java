package org.junit.runners.model;

/* JADX INFO: loaded from: classes5.dex */
public interface RunnerScheduler {
    void finished();

    void schedule(Runnable runnable);
}
