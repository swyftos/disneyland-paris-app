package org.picocontainer.injectors;

import com.urbanairship.channel.AttributeMutation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.NameBinding;
import org.picocontainer.Parameter;

/* loaded from: classes6.dex */
public class NamedMethodInjector<T> extends SetterInjector<T> {
    public NamedMethodInjector(Object obj, Class<?> cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, boolean z) {
        this(obj, cls, parameterArr, componentMonitor, AttributeMutation.ATTRIBUTE_ACTION_SET, z);
    }

    public NamedMethodInjector(Object obj, Class<?> cls, Parameter[] parameterArr, ComponentMonitor componentMonitor) {
        this(obj, cls, parameterArr, componentMonitor, AttributeMutation.ATTRIBUTE_ACTION_SET, true);
    }

    public NamedMethodInjector(Object obj, Class<?> cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, String str) {
        this(obj, cls, parameterArr, componentMonitor, str, true);
    }

    public NamedMethodInjector(Object obj, Class<?> cls, Parameter[] parameterArr, ComponentMonitor componentMonitor, String str, boolean z) {
        super(obj, cls, parameterArr, componentMonitor, str, "", z, true);
    }

    @Override // org.picocontainer.injectors.IterativeInjector
    protected NameBinding makeParameterNameImpl(final AccessibleObject accessibleObject) {
        return new NameBinding() { // from class: org.picocontainer.injectors.NamedMethodInjector.1
            @Override // org.picocontainer.NameBinding
            public String getName() {
                String strSubstring = ((Method) accessibleObject).getName().substring(NamedMethodInjector.this.prefix.length());
                return strSubstring.substring(0, 1).toLowerCase() + strSubstring.substring(1);
            }
        };
    }

    @Override // org.picocontainer.injectors.SetterInjector, org.picocontainer.injectors.AbstractInjector, org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "NamedMethodInjection:";
    }
}
