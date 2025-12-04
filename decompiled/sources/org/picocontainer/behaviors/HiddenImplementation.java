package org.picocontainer.behaviors;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;

/* loaded from: classes6.dex */
public class HiddenImplementation<T> extends AbstractBehavior<T> {
    public HiddenImplementation(ComponentAdapter<T> componentAdapter) {
        super(componentAdapter);
    }

    @Override // org.picocontainer.behaviors.AbstractBehavior, org.picocontainer.ComponentAdapter
    public T getComponentInstance(PicoContainer picoContainer, Type type) throws PicoCompositionException {
        Class[] clsArr;
        ComponentAdapter<T> delegate = getDelegate();
        Object componentKey = delegate.getComponentKey();
        if ((componentKey instanceof Class) && ((Class) delegate.getComponentKey()).isInterface()) {
            clsArr = new Class[]{(Class) delegate.getComponentKey()};
        } else if (componentKey instanceof Class[]) {
            clsArr = (Class[]) componentKey;
        } else {
            return delegate.getComponentInstance(picoContainer, type);
        }
        verifyInterfacesOnly(clsArr);
        return createProxy(clsArr, picoContainer, delegate.getComponentImplementation().getClassLoader());
    }

    @Override // org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "Hidden";
    }

    protected T createProxy(Class[] clsArr, PicoContainer picoContainer, ClassLoader classLoader) {
        return (T) Proxy.newProxyInstance(classLoader, clsArr, new InvocationHandler(picoContainer) { // from class: org.picocontainer.behaviors.HiddenImplementation.1
            private final PicoContainer container;
            private volatile Object instance;
            final /* synthetic */ PicoContainer val$container1;

            {
                this.val$container1 = picoContainer;
                this.container = picoContainer;
            }

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) {
                if (this.instance == null) {
                    synchronized (HiddenImplementation.this) {
                        try {
                            if (this.instance == null) {
                                this.instance = HiddenImplementation.this.getDelegate().getComponentInstance(this.container, ComponentAdapter.NOTHING.class);
                            }
                        } finally {
                        }
                    }
                }
                return HiddenImplementation.this.invokeMethod(this.instance, method, objArr, this.container);
            }
        });
    }

    protected Object invokeMethod(Object obj, Method method, Object[] objArr, PicoContainer picoContainer) throws Throwable {
        ComponentMonitor componentMonitorCurrentMonitor = currentMonitor();
        try {
            componentMonitorCurrentMonitor.invoking(picoContainer, this, method, obj, objArr);
            long jCurrentTimeMillis = System.currentTimeMillis();
            Object objInvoke = method.invoke(obj, objArr);
            componentMonitorCurrentMonitor.invoked(picoContainer, this, method, obj, System.currentTimeMillis() - jCurrentTimeMillis, objArr, objInvoke);
            return objInvoke;
        } catch (InvocationTargetException e) {
            componentMonitorCurrentMonitor.invocationFailed(method, obj, e);
            throw e.getTargetException();
        }
    }

    private void verifyInterfacesOnly(Class[] clsArr) {
        for (Class cls : clsArr) {
            if (!cls.isInterface()) {
                throw new PicoCompositionException("Class keys must be interfaces. " + cls + " is not an interface.");
            }
        }
    }
}
