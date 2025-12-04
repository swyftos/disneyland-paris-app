package org.picocontainer.containers;

import java.util.Properties;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.lifecycle.LifecycleState;

/* loaded from: classes6.dex */
public abstract class AbstractDelegatingMutablePicoContainer extends AbstractDelegatingPicoContainer implements MutablePicoContainer {
    public MutablePicoContainer makeChildContainer() {
        return null;
    }

    public AbstractDelegatingMutablePicoContainer(MutablePicoContainer mutablePicoContainer) {
        super(mutablePicoContainer);
    }

    public MutablePicoContainer addComponent(Object obj, Object obj2, Parameter... parameterArr) throws PicoCompositionException {
        return getDelegate().addComponent(obj, obj2, parameterArr);
    }

    public MutablePicoContainer addComponent(Object obj) throws PicoCompositionException {
        return getDelegate().addComponent(obj);
    }

    @Override // org.picocontainer.MutablePicoContainer
    public MutablePicoContainer addConfig(String str, Object obj) {
        return getDelegate().addConfig(str, obj);
    }

    public MutablePicoContainer addAdapter(ComponentAdapter<?> componentAdapter) throws PicoCompositionException {
        return getDelegate().addAdapter(componentAdapter);
    }

    @Override // org.picocontainer.MutablePicoContainer
    public <T> ComponentAdapter<T> removeComponent(Object obj) {
        return getDelegate().removeComponent(obj);
    }

    @Override // org.picocontainer.MutablePicoContainer
    public <T> ComponentAdapter<T> removeComponentByInstance(T t) {
        return getDelegate().removeComponentByInstance(t);
    }

    public MutablePicoContainer addChildContainer(PicoContainer picoContainer) {
        return getDelegate().addChildContainer(picoContainer);
    }

    public boolean removeChildContainer(PicoContainer picoContainer) {
        return getDelegate().removeChildContainer(picoContainer);
    }

    public MutablePicoContainer change(Properties... propertiesArr) {
        return getDelegate().change(propertiesArr);
    }

    public MutablePicoContainer as(Properties... propertiesArr) {
        return getDelegate().as(propertiesArr);
    }

    @Override // org.picocontainer.Disposable
    public void dispose() {
        getDelegate().dispose();
    }

    @Override // org.picocontainer.Startable
    public void start() {
        getDelegate().start();
    }

    @Override // org.picocontainer.Startable
    public void stop() {
        getDelegate().stop();
    }

    @Override // org.picocontainer.containers.AbstractDelegatingPicoContainer
    public MutablePicoContainer getDelegate() {
        return (MutablePicoContainer) super.getDelegate();
    }

    @Override // org.picocontainer.MutablePicoContainer
    public void setName(String str) {
        getDelegate().setName(str);
    }

    @Override // org.picocontainer.MutablePicoContainer
    public void setLifecycleState(LifecycleState lifecycleState) {
        getDelegate().setLifecycleState(lifecycleState);
    }

    public LifecycleState getLifecycleState() {
        return getDelegate().getLifecycleState();
    }

    public String getName() {
        return getDelegate().getName();
    }
}
