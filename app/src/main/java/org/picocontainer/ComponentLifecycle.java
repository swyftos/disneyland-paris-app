package org.picocontainer;

/* JADX INFO: loaded from: classes5.dex */
public interface ComponentLifecycle<T> {
    boolean componentHasLifecycle();

    void dispose(PicoContainer picoContainer);

    boolean isStarted();

    void start(PicoContainer picoContainer);

    void stop(PicoContainer picoContainer);
}
