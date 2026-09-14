package org.picocontainer;

import java.util.Properties;

/* JADX INFO: loaded from: classes5.dex */
public interface BehaviorFactory extends ComponentFactory {
    <T> ComponentAdapter<T> addComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, ComponentAdapter<T> componentAdapter);

    ComponentFactory wrap(ComponentFactory componentFactory);
}
