package org.picocontainer.injectors;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.Parameter;
import org.picocontainer.PicoContainer;
import org.picocontainer.injectors.AbstractInjector;

/* loaded from: classes6.dex */
public abstract class AbstractFieldInjector<T> extends IterativeInjector<T> {
    public AbstractFieldInjector(Object obj, Class cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, boolean z) throws AbstractInjector.NotConcreteRegistrationException {
        super(obj, cls, parameterArr, componentMonitor, z);
    }

    @Override // org.picocontainer.injectors.IterativeInjector
    protected final void unsatisfiedDependencies(PicoContainer picoContainer, Set<Type> set, List<AccessibleObject> list) {
        StringBuilder sb = new StringBuilder(getComponentImplementation().getName());
        sb.append(" has unsatisfied dependency for fields [");
        for (int i = 0; i < list.size(); i++) {
            Field field = (Field) list.get(i);
            sb.append(field.getType().getName());
            sb.append(InstructionFileId.DOT);
            sb.append(field.getName());
        }
        throw new AbstractInjector.UnsatisfiableDependenciesException(sb.toString() + "] from " + picoContainer.toString());
    }
}
