package org.picocontainer.lifecycle;

import org.picocontainer.ComponentAdapter;
import org.picocontainer.LifecycleStrategy;

/* loaded from: classes6.dex */
public class CompositeLifecycleStrategy implements LifecycleStrategy {
    private final LifecycleStrategy[] alternateStrategies;

    public CompositeLifecycleStrategy(LifecycleStrategy... lifecycleStrategyArr) {
        this.alternateStrategies = lifecycleStrategyArr;
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void start(Object obj) {
        for (LifecycleStrategy lifecycleStrategy : this.alternateStrategies) {
            lifecycleStrategy.start(obj);
        }
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void stop(Object obj) {
        for (LifecycleStrategy lifecycleStrategy : this.alternateStrategies) {
            lifecycleStrategy.stop(obj);
        }
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void dispose(Object obj) {
        for (LifecycleStrategy lifecycleStrategy : this.alternateStrategies) {
            lifecycleStrategy.dispose(obj);
        }
    }

    @Override // org.picocontainer.LifecycleStrategy
    public boolean hasLifecycle(Class<?> cls) {
        for (LifecycleStrategy lifecycleStrategy : this.alternateStrategies) {
            if (lifecycleStrategy.hasLifecycle(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.picocontainer.LifecycleStrategy
    public boolean isLazy(ComponentAdapter<?> componentAdapter) {
        for (LifecycleStrategy lifecycleStrategy : this.alternateStrategies) {
            if (lifecycleStrategy.isLazy(componentAdapter)) {
                return true;
            }
        }
        return false;
    }
}
