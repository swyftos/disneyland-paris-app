package org.picocontainer.lifecycle;

import java.io.Serializable;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.ComponentMonitorStrategy;
import org.picocontainer.LifecycleStrategy;

/* loaded from: classes6.dex */
public abstract class AbstractMonitoringLifecycleStrategy implements LifecycleStrategy, ComponentMonitorStrategy, Serializable {
    private ComponentMonitor componentMonitor;

    @Override // org.picocontainer.LifecycleStrategy
    public boolean isLazy(ComponentAdapter<?> componentAdapter) {
        return false;
    }

    public AbstractMonitoringLifecycleStrategy(ComponentMonitor componentMonitor) {
        changeMonitor(componentMonitor);
    }

    @Override // org.picocontainer.ComponentMonitorStrategy
    public void changeMonitor(ComponentMonitor componentMonitor) {
        if (componentMonitor == null) {
            throw new NullPointerException("Monitor is null");
        }
        this.componentMonitor = componentMonitor;
    }

    @Override // org.picocontainer.ComponentMonitorStrategy
    public ComponentMonitor currentMonitor() {
        return this.componentMonitor;
    }
}
