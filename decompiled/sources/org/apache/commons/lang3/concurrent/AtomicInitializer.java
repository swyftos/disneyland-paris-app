package org.apache.commons.lang3.concurrent;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public abstract class AtomicInitializer<T> implements ConcurrentInitializer<T> {
    private final AtomicReference reference = new AtomicReference();

    protected abstract T initialize() throws ConcurrentException;

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public T get() throws ConcurrentException {
        T t = (T) this.reference.get();
        if (t != null) {
            return t;
        }
        T tInitialize = initialize();
        return !PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.reference, null, tInitialize) ? (T) this.reference.get() : tInitialize;
    }
}
