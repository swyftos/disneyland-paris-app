package org.picocontainer.injectors;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Properties;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.ComponentMonitorStrategy;
import org.picocontainer.InjectionFactory;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.lifecycle.NullLifecycleStrategy;
import org.picocontainer.monitors.NullComponentMonitor;

/* loaded from: classes6.dex */
public class Reinjector {
    private static NullLifecycleStrategy NO_LIFECYCLE = new NullLifecycleStrategy();
    private static Properties NO_PROPERTIES = new Properties();
    private final ComponentMonitor monitor;
    private final PicoContainer parent;

    public Reinjector(PicoContainer picoContainer) {
        this(picoContainer, picoContainer instanceof ComponentMonitorStrategy ? ((ComponentMonitorStrategy) picoContainer).currentMonitor() : new NullComponentMonitor());
    }

    public Reinjector(PicoContainer picoContainer, ComponentMonitor componentMonitor) {
        this.parent = picoContainer;
        this.monitor = componentMonitor;
    }

    public Object reinject(Class<?> cls, Method method) {
        return reinject(cls, cls, this.parent.getComponent((Class) cls), NO_PROPERTIES, new MethodInjection(method));
    }

    public Object reinject(Class<?> cls, Enum r9) {
        return reinject(cls, cls, this.parent.getComponent((Class) cls), NO_PROPERTIES, new MethodInjection(toMethod(r9)));
    }

    private Method toMethod(final Enum r2) {
        Object objDoPrivileged = AccessController.doPrivileged((PrivilegedAction<Object>) new PrivilegedAction() { // from class: org.picocontainer.injectors.Reinjector.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    return r2.getClass().getMethod("toMethod", new Class[0]).invoke(r2, new Object[0]);
                } catch (IllegalAccessException unused) {
                    return new PicoCompositionException("Illegal access to " + r2.name());
                } catch (NoSuchMethodException unused2) {
                    return new PicoCompositionException("Expected generated method toMethod() on enum");
                } catch (InvocationTargetException e) {
                    return new PicoCompositionException("Invocation Target Exception " + r2.name(), e.getCause());
                }
            }
        });
        if (objDoPrivileged instanceof Method) {
            return (Method) objDoPrivileged;
        }
        throw ((PicoCompositionException) objDoPrivileged);
    }

    public Object reinject(Class<?> cls, InjectionFactory injectionFactory) {
        return reinject(cls, cls, this.parent.getComponent((Class) cls), NO_PROPERTIES, injectionFactory);
    }

    public Object reinject(Class<?> cls, Class<?> cls2, InjectionFactory injectionFactory) {
        return reinject(cls, cls2, this.parent.getComponent((Class) cls), NO_PROPERTIES, injectionFactory);
    }

    public Object reinject(Class<?> cls, Class cls2, Object obj, InjectionFactory injectionFactory) {
        return reinject(cls, cls2, obj, NO_PROPERTIES, injectionFactory);
    }

    public Object reinject(Class<?> cls, Class cls2, Object obj, Properties properties, InjectionFactory injectionFactory) {
        return ((org.picocontainer.Injector) new Reinjection(injectionFactory, this.parent).createComponentAdapter(this.monitor, NO_LIFECYCLE, properties, cls, cls2, null)).decorateComponentInstance(this.parent, null, obj);
    }
}
