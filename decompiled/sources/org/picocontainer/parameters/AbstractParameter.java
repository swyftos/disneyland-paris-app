package org.picocontainer.parameters;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.NameBinding;
import org.picocontainer.Parameter;
import org.picocontainer.PicoContainer;

/* loaded from: classes6.dex */
public abstract class AbstractParameter implements Parameter {
    @Override // org.picocontainer.Parameter
    @Deprecated
    public final Object resolveInstance(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, Type type, NameBinding nameBinding, boolean z, Annotation annotation) {
        return resolve(picoContainer, componentAdapter, null, type, nameBinding, z, annotation).resolveInstance();
    }

    @Override // org.picocontainer.Parameter
    @Deprecated
    public final boolean isResolvable(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, Type type, NameBinding nameBinding, boolean z, Annotation annotation) {
        return resolve(picoContainer, componentAdapter, null, type, nameBinding, z, annotation).isResolved();
    }
}
