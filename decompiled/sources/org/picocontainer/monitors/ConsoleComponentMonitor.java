package org.picocontainer.monitors;

import java.io.OutputStream;
import java.io.PrintStream;
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

/* loaded from: classes6.dex */
public class ConsoleComponentMonitor implements ComponentMonitor, Serializable {
    private final ComponentMonitor delegate;
    private final transient PrintStream out;

    public ConsoleComponentMonitor() {
        this(System.out);
    }

    public ConsoleComponentMonitor(OutputStream outputStream) {
        this(outputStream, new NullComponentMonitor());
    }

    public ConsoleComponentMonitor(OutputStream outputStream, ComponentMonitor componentMonitor) {
        this.out = new PrintStream(outputStream);
        this.delegate = componentMonitor;
    }

    @Override // org.picocontainer.ComponentMonitor
    public <T> Constructor<T> instantiating(PicoContainer picoContainer, ComponentAdapter<T> componentAdapter, Constructor<T> constructor) {
        this.out.println(ComponentMonitorHelper.format(ComponentMonitorHelper.INSTANTIATING, ComponentMonitorHelper.ctorToString(constructor)));
        return this.delegate.instantiating(picoContainer, componentAdapter, constructor);
    }

    @Override // org.picocontainer.ComponentMonitor
    public <T> void instantiated(PicoContainer picoContainer, ComponentAdapter<T> componentAdapter, Constructor<T> constructor, Object obj, Object[] objArr, long j) {
        this.out.println(ComponentMonitorHelper.format(ComponentMonitorHelper.INSTANTIATED, ComponentMonitorHelper.ctorToString(constructor), Long.valueOf(j), obj.getClass().getName(), ComponentMonitorHelper.parmsToString(objArr)));
        this.delegate.instantiated(picoContainer, componentAdapter, constructor, obj, objArr, j);
    }

    @Override // org.picocontainer.ComponentMonitor
    public <T> void instantiationFailed(PicoContainer picoContainer, ComponentAdapter<T> componentAdapter, Constructor<T> constructor, Exception exc) {
        this.out.println(ComponentMonitorHelper.format(ComponentMonitorHelper.INSTANTIATION_FAILED, ComponentMonitorHelper.ctorToString(constructor), exc.getMessage()));
        this.delegate.instantiationFailed(picoContainer, componentAdapter, constructor, exc);
    }

    @Override // org.picocontainer.ComponentMonitor
    public Object invoking(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, Member member, Object obj, Object[] objArr) {
        this.out.println(ComponentMonitorHelper.format(ComponentMonitorHelper.INVOKING, ComponentMonitorHelper.memberToString(member), obj));
        return this.delegate.invoking(picoContainer, componentAdapter, member, obj, objArr);
    }

    @Override // org.picocontainer.ComponentMonitor
    public void invoked(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, Member member, Object obj, long j, Object[] objArr, Object obj2) {
        this.out.println(ComponentMonitorHelper.format(ComponentMonitorHelper.INVOKED, ComponentMonitorHelper.methodToString(member), obj, Long.valueOf(j)));
        this.delegate.invoked(picoContainer, componentAdapter, member, obj, j, objArr, obj2);
    }

    @Override // org.picocontainer.ComponentMonitor
    public void invocationFailed(Member member, Object obj, Exception exc) {
        this.out.println(ComponentMonitorHelper.format(ComponentMonitorHelper.INVOCATION_FAILED, ComponentMonitorHelper.memberToString(member), obj, exc.getMessage()));
        this.delegate.invocationFailed(member, obj, exc);
    }

    @Override // org.picocontainer.ComponentMonitor
    public void lifecycleInvocationFailed(MutablePicoContainer mutablePicoContainer, ComponentAdapter<?> componentAdapter, Method method, Object obj, RuntimeException runtimeException) {
        this.out.println(ComponentMonitorHelper.format(ComponentMonitorHelper.LIFECYCLE_INVOCATION_FAILED, ComponentMonitorHelper.methodToString(method), obj, runtimeException.getMessage()));
        this.delegate.lifecycleInvocationFailed(mutablePicoContainer, componentAdapter, method, obj, runtimeException);
    }

    @Override // org.picocontainer.ComponentMonitor
    public Object noComponentFound(MutablePicoContainer mutablePicoContainer, Object obj) {
        this.out.println(ComponentMonitorHelper.format(ComponentMonitorHelper.NO_COMPONENT, obj));
        return this.delegate.noComponentFound(mutablePicoContainer, obj);
    }

    @Override // org.picocontainer.ComponentMonitor
    public Injector newInjector(Injector injector) {
        return this.delegate.newInjector(injector);
    }

    @Override // org.picocontainer.ComponentMonitor
    public Behavior newBehavior(Behavior behavior) {
        return this.delegate.newBehavior(behavior);
    }
}
