package org.picocontainer;

import java.util.Properties;

/* loaded from: classes6.dex */
public interface BehaviorFactory extends ComponentFactory {
    <T> ComponentAdapter<T> addComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, ComponentAdapter<T> componentAdapter);

    ComponentFactory wrap(ComponentFactory componentFactory);
}
