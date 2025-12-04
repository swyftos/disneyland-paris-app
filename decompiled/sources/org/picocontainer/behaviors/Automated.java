package org.picocontainer.behaviors;

import java.io.Serializable;
import org.picocontainer.ComponentAdapter;

/* loaded from: classes6.dex */
public class Automated<T> extends AbstractBehavior<T> implements org.picocontainer.Behavior<T>, Serializable {
    @Override // org.picocontainer.behaviors.AbstractBehavior, org.picocontainer.LifecycleStrategy
    public boolean hasLifecycle(Class<?> cls) {
        return true;
    }

    public Automated(ComponentAdapter<T> componentAdapter) {
        super(componentAdapter);
    }

    @Override // org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "Automated";
    }
}
