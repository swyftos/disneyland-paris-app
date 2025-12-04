package org.picocontainer;

import java.util.Properties;
import org.picocontainer.lifecycle.LifecycleState;

/* loaded from: classes6.dex */
public interface MutablePicoContainer extends PicoContainer, Startable, Disposable {
    MutablePicoContainer addAdapter(ComponentAdapter<?> componentAdapter);

    MutablePicoContainer addChildContainer(PicoContainer picoContainer);

    MutablePicoContainer addComponent(Object obj);

    MutablePicoContainer addComponent(Object obj, Object obj2, Parameter... parameterArr);

    MutablePicoContainer addConfig(String str, Object obj);

    MutablePicoContainer as(Properties... propertiesArr);

    MutablePicoContainer change(Properties... propertiesArr);

    LifecycleState getLifecycleState();

    String getName();

    MutablePicoContainer makeChildContainer();

    boolean removeChildContainer(PicoContainer picoContainer);

    <T> ComponentAdapter<T> removeComponent(Object obj);

    <T> ComponentAdapter<T> removeComponentByInstance(T t);

    void setLifecycleState(LifecycleState lifecycleState);

    void setName(String str);
}
