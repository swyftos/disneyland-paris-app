package org.picocontainer.monitors;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.picocontainer.Behavior;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.Injector;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoException;
import org.picocontainer.PicoLifecycleException;

/* loaded from: classes6.dex */
public final class LifecycleComponentMonitor implements ComponentMonitor {
    private final ComponentMonitor delegate;
    private final List lifecycleFailures;

    public LifecycleComponentMonitor(ComponentMonitor componentMonitor) {
        this.lifecycleFailures = new ArrayList();
        this.delegate = componentMonitor;
    }

    public LifecycleComponentMonitor() {
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
        this.lifecycleFailures.add(runtimeException);
        try {
            this.delegate.lifecycleInvocationFailed(mutablePicoContainer, componentAdapter, method, obj, runtimeException);
        } catch (PicoLifecycleException unused) {
        }
    }

    @Override // org.picocontainer.ComponentMonitor
    public Object noComponentFound(MutablePicoContainer mutablePicoContainer, Object obj) {
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

    public void rethrowLifecycleFailuresException() {
        throw new LifecycleFailuresException(this.lifecycleFailures);
    }

    public final class LifecycleFailuresException extends PicoException {
        private final List lifecycleFailures;

        public LifecycleFailuresException(List<RuntimeException> list) {
            this.lifecycleFailures = list;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            StringBuffer stringBuffer = new StringBuffer();
            Iterator it = this.lifecycleFailures.iterator();
            while (it.hasNext()) {
                stringBuffer.append(((Exception) it.next()).getMessage());
                stringBuffer.append(";  ");
            }
            return stringBuffer.toString();
        }

        public Collection<RuntimeException> getFailures() {
            return this.lifecycleFailures;
        }
    }
}
