package org.picocontainer.behaviors;

import org.picocontainer.ComponentAdapter;
import org.picocontainer.ObjectReference;
import org.picocontainer.behaviors.Stored;
import org.picocontainer.references.SimpleReference;

/* loaded from: classes6.dex */
public class Cached<T> extends Stored<T> {
    public Cached(ComponentAdapter componentAdapter) {
        this(componentAdapter, new SimpleReference());
    }

    public Cached(ComponentAdapter componentAdapter, ObjectReference<Stored.Instance<T>> objectReference) {
        super(componentAdapter, objectReference);
    }

    @Override // org.picocontainer.behaviors.Stored, org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "Cached" + getLifecycleDescriptor();
    }
}
