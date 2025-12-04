package org.picocontainer.monitors;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import org.picocontainer.Behavior;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.ComponentMonitorStrategy;
import org.picocontainer.Injector;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.PicoContainer;

/* loaded from: classes6.dex */
public class AbstractComponentMonitor implements ComponentMonitor, ComponentMonitorStrategy, Serializable {
    private ComponentMonitor delegate;

    @Override // org.picocontainer.ComponentMonitor
    public Behavior newBehavior(Behavior behavior) {
        return behavior;
    }

    @Override // org.picocontainer.ComponentMonitor
    public Injector newInjector(Injector injector) {
        return injector;
    }

    public AbstractComponentMonitor(ComponentMonitor componentMonitor) {
        checkMonitor(componentMonitor);
        this.delegate = componentMonitor;
    }

    public AbstractComponentMonitor() {
        this(new NullComponentMonitor());
    }

    @Override // org.picocontainer.ComponentMonitor
    public <T> Constructor<T> instantiating(PicoContainer picoContainer, ComponentAdapter<T> componentAdapter, Constructor<T> constructor) {
        return this.delegate.instantiating(picoContainer, componentAdapter, constructor);
    }

    @Override // org.picocontainer.ComponentMonitor
    public <T> void instantiated(PicoContainer picoContainer, ComponentAdapter<T> componentAdapter, Constructor<T> constructor, Object obj, Object[] objArr, long j) {
        this.delegate.instantiated(picoContainer, componentAdapter, constructor, obj, objArr, j);
    }

    @Override // org.picocontainer.ComponentMonitor
    public <T> void instantiationFailed(PicoContainer picoContainer, ComponentAdapter<T> componentAdapter, Constructor<T> constructor, Exception exc) {
        this.delegate.instantiationFailed(picoContainer, componentAdapter, constructor, exc);
    }

    @Override // org.picocontainer.ComponentMonitor
    public Object invoking(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, Member member, Object obj, Object[] objArr) {
        return this.delegate.invoking(picoContainer, componentAdapter, member, obj, objArr);
    }

    @Override // org.picocontainer.ComponentMonitor
    public void invoked(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, Member member, Object obj, long j, Object[] objArr, Object obj2) {
        this.delegate.invoked(picoContainer, componentAdapter, member, obj, j, objArr, obj2);
    }

    @Override // org.picocontainer.ComponentMonitor
    public void invocationFailed(Member member, Object obj, Exception exc) {
        this.delegate.invocationFailed(member, obj, exc);
    }

    @Override // org.picocontainer.ComponentMonitor
    public void lifecycleInvocationFailed(MutablePicoContainer mutablePicoContainer, ComponentAdapter<?> componentAdapter, Method method, Object obj, RuntimeException runtimeException) {
        this.delegate.lifecycleInvocationFailed(mutablePicoContainer, componentAdapter, method, obj, runtimeException);
    }

    @Override // org.picocontainer.ComponentMonitor
    public Object noComponentFound(MutablePicoContainer mutablePicoContainer, Object obj) {
        return this.delegate.noComponentFound(mutablePicoContainer, obj);
    }

    @Override // org.picocontainer.ComponentMonitorStrategy
    public void changeMonitor(ComponentMonitor componentMonitor) {
        checkMonitor(componentMonitor);
        ComponentMonitor componentMonitor2 = this.delegate;
        if (componentMonitor2 instanceof ComponentMonitorStrategy) {
            ((ComponentMonitorStrategy) componentMonitor2).changeMonitor(componentMonitor);
        } else {
            this.delegate = componentMonitor;
        }
    }

    @Override // org.picocontainer.ComponentMonitorStrategy
    public ComponentMonitor currentMonitor() {
        ComponentMonitor componentMonitor = this.delegate;
        return componentMonitor instanceof ComponentMonitorStrategy ? ((ComponentMonitorStrategy) componentMonitor).currentMonitor() : componentMonitor;
    }

    private void checkMonitor(ComponentMonitor componentMonitor) {
        if (componentMonitor == null) {
            throw new NullPointerException("monitor");
        }
    }
}
