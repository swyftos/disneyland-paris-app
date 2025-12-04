package org.picocontainer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public interface ComponentMonitor {
    public static final Object KEEP = new Object();

    <T> void instantiated(PicoContainer picoContainer, ComponentAdapter<T> componentAdapter, Constructor<T> constructor, Object obj, Object[] objArr, long j);

    <T> Constructor<T> instantiating(PicoContainer picoContainer, ComponentAdapter<T> componentAdapter, Constructor<T> constructor);

    <T> void instantiationFailed(PicoContainer picoContainer, ComponentAdapter<T> componentAdapter, Constructor<T> constructor, Exception exc);

    void invocationFailed(Member member, Object obj, Exception exc);

    void invoked(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, Member member, Object obj, long j, Object[] objArr, Object obj2);

    Object invoking(PicoContainer picoContainer, ComponentAdapter<?> componentAdapter, Member member, Object obj, Object[] objArr);

    void lifecycleInvocationFailed(MutablePicoContainer mutablePicoContainer, ComponentAdapter<?> componentAdapter, Method method, Object obj, RuntimeException runtimeException);

    Behavior newBehavior(Behavior behavior);

    Injector newInjector(Injector injector);

    Object noComponentFound(MutablePicoContainer mutablePicoContainer, Object obj);
}
