package org.picocontainer.lifecycle;

import com.facebook.react.uimanager.ViewProps;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.Disposable;
import org.picocontainer.PicoLifecycleException;
import org.picocontainer.Startable;

/* loaded from: classes6.dex */
public class StartableLifecycleStrategy extends AbstractMonitoringLifecycleStrategy {
    private transient Method dispose;
    private transient Method start;
    private transient Method stop;

    public StartableLifecycleStrategy(ComponentMonitor componentMonitor) {
        super(componentMonitor);
    }

    private void doMethodsIfNotDone() {
        try {
            if (this.start == null) {
                this.start = getStartableInterface().getMethod(getStartMethodName(), new Class[0]);
            }
            if (this.stop == null) {
                this.stop = getStartableInterface().getMethod(getStopMethodName(), new Class[0]);
            }
            if (this.dispose == null) {
                this.dispose = getDisposableInterface().getMethod(getDisposeMethodName(), new Class[0]);
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    protected String getDisposeMethodName() {
        return "dispose";
    }

    protected String getStopMethodName() {
        return "stop";
    }

    protected String getStartMethodName() {
        return ViewProps.START;
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void start(Object obj) throws IllegalAccessException, InvocationTargetException {
        doMethodsIfNotDone();
        if (obj == null || !getStartableInterface().isAssignableFrom(obj.getClass())) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        currentMonitor().invoking(null, null, this.start, obj, new Object[0]);
        try {
            startComponent(obj);
            currentMonitor().invoked(null, null, this.start, obj, System.currentTimeMillis() - jCurrentTimeMillis, new Object[0], null);
        } catch (RuntimeException e) {
            currentMonitor().lifecycleInvocationFailed(null, null, this.start, obj, e);
        }
    }

    protected void startComponent(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        doLifecycleMethod(obj, this.start);
    }

    private void doLifecycleMethod(Object obj, Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            method.invoke(obj, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new PicoLifecycleException(method, obj, e);
        } catch (InvocationTargetException e2) {
            if (e2.getTargetException() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getTargetException());
            }
            throw new PicoLifecycleException(method, obj, e2.getTargetException());
        }
    }

    protected void stopComponent(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        doLifecycleMethod(obj, this.stop);
    }

    protected void disposeComponent(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        doLifecycleMethod(obj, this.dispose);
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void stop(Object obj) throws IllegalAccessException, InvocationTargetException {
        doMethodsIfNotDone();
        if (obj == null || !getStartableInterface().isAssignableFrom(obj.getClass())) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        currentMonitor().invoking(null, null, this.stop, obj, new Object[0]);
        try {
            stopComponent(obj);
            currentMonitor().invoked(null, null, this.stop, obj, System.currentTimeMillis() - jCurrentTimeMillis, new Object[0], null);
        } catch (RuntimeException e) {
            currentMonitor().lifecycleInvocationFailed(null, null, this.stop, obj, e);
        }
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void dispose(Object obj) throws IllegalAccessException, InvocationTargetException {
        doMethodsIfNotDone();
        if (obj == null || !getDisposableInterface().isAssignableFrom(obj.getClass())) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        currentMonitor().invoking(null, null, this.dispose, obj, new Object[0]);
        try {
            disposeComponent(obj);
            currentMonitor().invoked(null, null, this.dispose, obj, System.currentTimeMillis() - jCurrentTimeMillis, new Object[0], null);
        } catch (RuntimeException e) {
            currentMonitor().lifecycleInvocationFailed(null, null, this.dispose, obj, e);
        }
    }

    @Override // org.picocontainer.LifecycleStrategy
    public boolean hasLifecycle(Class<?> cls) {
        return getStartableInterface().isAssignableFrom(cls) || getDisposableInterface().isAssignableFrom(cls);
    }

    protected Class getDisposableInterface() {
        return Disposable.class;
    }

    protected Class getStartableInterface() {
        return Startable.class;
    }
}
