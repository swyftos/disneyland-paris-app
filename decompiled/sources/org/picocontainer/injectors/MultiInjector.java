package org.picocontainer.injectors;

import org.picocontainer.ComponentMonitor;
import org.picocontainer.Parameter;
import org.picocontainer.annotations.Inject;

/* loaded from: classes6.dex */
public class MultiInjector extends CompositeInjector {
    public MultiInjector(Object obj, Class cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, String str, boolean z) {
        super(obj, cls, parameterArr, componentMonitor, z, componentMonitor.newInjector(new ConstructorInjector(obj, cls, parameterArr, componentMonitor, z)), componentMonitor.newInjector(new SetterInjector(obj, cls, parameterArr, componentMonitor, str, "", false, z)), componentMonitor.newInjector(new AnnotatedMethodInjector(obj, cls, parameterArr, componentMonitor, Inject.class, z)), componentMonitor.newInjector(new AnnotatedFieldInjector(obj, cls, parameterArr, componentMonitor, Inject.class, z)));
    }

    @Override // org.picocontainer.injectors.CompositeInjector, org.picocontainer.injectors.AbstractInjector, org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "MultiInjector";
    }
}
