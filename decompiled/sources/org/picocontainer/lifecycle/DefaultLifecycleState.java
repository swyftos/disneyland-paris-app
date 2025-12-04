package org.picocontainer.lifecycle;

import java.io.Serializable;
import org.picocontainer.PicoCompositionException;

/* loaded from: classes6.dex */
public class DefaultLifecycleState implements LifecycleState, Serializable {
    private String state = "CONSTRUCTED";

    @Override // org.picocontainer.lifecycle.LifecycleState
    public void removingComponent() {
        if (isStarted()) {
            throw new PicoCompositionException("Cannot remove components after the container has started");
        }
        if (isDisposed()) {
            throw new PicoCompositionException("Cannot remove components after the container has been disposed");
        }
    }

    @Override // org.picocontainer.lifecycle.LifecycleState
    public void starting() {
        if (isConstructed() || isStopped()) {
            this.state = "STARTED";
            return;
        }
        throw new IllegalStateException("Cannot start.  Current container state was: " + this.state);
    }

    @Override // org.picocontainer.lifecycle.LifecycleState
    public void stopping() {
        if (isStarted()) {
            return;
        }
        throw new IllegalStateException("Cannot stop.  Current container state was: " + this.state);
    }

    @Override // org.picocontainer.lifecycle.LifecycleState
    public void stopped() {
        this.state = "STOPPED";
    }

    @Override // org.picocontainer.lifecycle.LifecycleState
    public boolean isStarted() {
        return this.state == "STARTED";
    }

    @Override // org.picocontainer.lifecycle.LifecycleState
    public void disposing() {
        if (isStopped() || isConstructed()) {
            return;
        }
        throw new IllegalStateException("Cannot dispose.  Current lifecycle state is: " + this.state);
    }

    @Override // org.picocontainer.lifecycle.LifecycleState
    public void disposed() {
        this.state = "DISPOSED";
    }

    @Override // org.picocontainer.lifecycle.LifecycleState
    public boolean isDisposed() {
        return this.state == "DISPOSED";
    }

    @Override // org.picocontainer.lifecycle.LifecycleState
    public boolean isStopped() {
        return this.state == "STOPPED";
    }

    public boolean isConstructed() {
        return this.state == "CONSTRUCTED";
    }
}
