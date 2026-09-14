package org.picocontainer.lifecycle;

/* JADX INFO: loaded from: classes5.dex */
public interface LifecycleState {
    void disposed();

    void disposing();

    boolean isDisposed();

    boolean isStarted();

    boolean isStopped();

    void removingComponent();

    void starting();

    void stopped();

    void stopping();
}
