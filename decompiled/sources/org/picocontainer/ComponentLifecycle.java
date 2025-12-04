package org.picocontainer;

/* loaded from: classes6.dex */
public interface ComponentLifecycle<T> {
    boolean componentHasLifecycle();

    void dispose(PicoContainer picoContainer);

    boolean isStarted();

    void start(PicoContainer picoContainer);

    void stop(PicoContainer picoContainer);
}
