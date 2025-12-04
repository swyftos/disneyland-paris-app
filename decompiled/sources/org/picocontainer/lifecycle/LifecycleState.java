package org.picocontainer.lifecycle;

/* loaded from: classes6.dex */
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
