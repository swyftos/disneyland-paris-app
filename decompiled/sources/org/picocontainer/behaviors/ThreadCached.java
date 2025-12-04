package org.picocontainer.behaviors;

import org.picocontainer.ComponentAdapter;
import org.picocontainer.references.ThreadLocalReference;

/* loaded from: classes6.dex */
public final class ThreadCached<T> extends Stored<T> {
    public ThreadCached(ComponentAdapter<T> componentAdapter) {
        super(componentAdapter, new ThreadLocalReference());
    }

    @Override // org.picocontainer.behaviors.Stored, org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "ThreadCached" + getLifecycleDescriptor();
    }
}
