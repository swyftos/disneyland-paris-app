package org.picocontainer;

import java.util.Properties;

/* JADX INFO: loaded from: classes5.dex */
public interface ComponentFactory {
    void accept(PicoVisitor picoVisitor);

    <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) throws PicoCompositionException;

    void verify(PicoContainer picoContainer);
}
