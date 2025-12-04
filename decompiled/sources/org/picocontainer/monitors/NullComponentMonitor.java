package org.picocontainer.monitors;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import org.picocontainer.Behavior;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.Injector;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoLifecycleException;

/* loaded from: classes6.dex */
public class NullComponentMonitor implements ComponentMonitor, Serializable {
    @Override // org.picocontainer.ComponentMonitor
    public <T> void instantiated(PicoContainer picoContainer, ComponentAdapter<T> componentAdapter, Constructor<T> constructor, Object obj, Object[] objArr, long j) {
    }

    @Override // org.picocontainer.ComponentMonitor
    public <T> Constructor<T> instantiating(PicoContainer picoContainer, ComponentAdapter<T> componentAdapter, Constructor<T> constructor) {
        return constructor;
    }

    @Override // org.picocontainer.ComponentMonitor
    public <T> void instantiationFailed(PicoContainer picoContainer, ComponentAdapter<T> componentAdapter, Constructor<T> constructor, Exception exc) {
    }

    @Override // org.picocontainer.ComponentMonitor
    public void invocationFailed(Member member, Object obj, Exception exc) {
    }

    @Override // org.picocontainer.ComponentMonitor
    public void invoked(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, Member member, Object obj, long j, Object[] objArr, Object obj2) {
    }

    @Override // org.picocontainer.ComponentMonitor
    public Behavior newBehavior(Behavior behavior) {
        return behavior;
    }

    @Override // org.picocontainer.ComponentMonitor
    public Injector newInjector(Injector injector) {
        return injector;
    }

    @Override // org.picocontainer.ComponentMonitor
    public Object noComponentFound(MutablePicoContainer mutablePicoContainer, Object obj) {
        return null;
    }

    @Override // org.picocontainer.ComponentMonitor
    public Object invoking(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, Member member, Object obj, Object[] objArr) {
        return ComponentMonitor.KEEP;
    }

    @Override // org.picocontainer.ComponentMonitor
    public void lifecycleInvocationFailed(MutablePicoContainer mutablePicoContainer, ComponentAdapter<?> componentAdapter, Method method, Object obj, RuntimeException runtimeException) {
        if (runtimeException instanceof PicoLifecycleException) {
            throw runtimeException;
        }
        throw new PicoLifecycleException(method, obj, runtimeException);
    }
}
