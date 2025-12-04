package org.picocontainer.behaviors;

import org.picocontainer.ComponentAdapter;
import org.picocontainer.ObjectReference;
import org.picocontainer.behaviors.Decorated;

/* loaded from: classes6.dex */
public class Behavior {
    public static final org.picocontainer.Behavior cached(ComponentAdapter componentAdapter) {
        return new Cached(componentAdapter);
    }

    public static final org.picocontainer.Behavior cached(ComponentAdapter componentAdapter, ObjectReference objectReference) {
        return new Cached(componentAdapter, objectReference);
    }

    public static final org.picocontainer.Behavior decorated(ComponentAdapter componentAdapter, Decorated.Decorator decorator) {
        return new Decorated(componentAdapter, decorator);
    }
}
