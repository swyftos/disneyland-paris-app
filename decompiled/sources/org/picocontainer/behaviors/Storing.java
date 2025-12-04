package org.picocontainer.behaviors;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.picocontainer.Characteristics;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.references.ThreadLocalMapObjectReference;

/* loaded from: classes6.dex */
public class Storing extends AbstractBehaviorFactory {
    private final StoreThreadLocal mapThreadLocalObjectReference = new StoreThreadLocal();

    @Override // org.picocontainer.behaviors.AbstractBehaviorFactory, org.picocontainer.ComponentFactory
    public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) throws PicoCompositionException {
        if (AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.NO_CACHE)) {
            return super.createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr);
        }
        AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.CACHE);
        return componentMonitor.newBehavior(new Stored(super.createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr), new ThreadLocalMapObjectReference(this.mapThreadLocalObjectReference, obj)));
    }

    @Override // org.picocontainer.behaviors.AbstractBehaviorFactory, org.picocontainer.BehaviorFactory
    public <T> ComponentAdapter<T> addComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, ComponentAdapter<T> componentAdapter) {
        if (AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.NO_CACHE)) {
            return super.addComponentAdapter(componentMonitor, lifecycleStrategy, properties, componentAdapter);
        }
        AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.CACHE);
        return componentMonitor.newBehavior(new Stored(super.addComponentAdapter(componentMonitor, lifecycleStrategy, properties, componentAdapter), new ThreadLocalMapObjectReference(this.mapThreadLocalObjectReference, componentAdapter.getComponentKey())));
    }

    public StoreWrapper getCacheForThread() {
        StoreWrapper storeWrapper = new StoreWrapper();
        storeWrapper.wrapped = this.mapThreadLocalObjectReference.get();
        return storeWrapper;
    }

    public void putCacheForThread(StoreWrapper storeWrapper) {
        this.mapThreadLocalObjectReference.set(storeWrapper.wrapped);
    }

    public StoreWrapper resetCacheForThread() {
        HashMap map = new HashMap();
        this.mapThreadLocalObjectReference.set(map);
        StoreWrapper storeWrapper = new StoreWrapper();
        storeWrapper.wrapped = map;
        return storeWrapper;
    }

    public void invalidateCacheForThread() {
        this.mapThreadLocalObjectReference.set(Collections.unmodifiableMap(Collections.emptyMap()));
    }

    public int getCacheSize() {
        return this.mapThreadLocalObjectReference.get().size();
    }

    public static class StoreThreadLocal extends ThreadLocal<Map> implements Serializable {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Map initialValue() {
            return new HashMap();
        }
    }

    public static class StoreWrapper implements Serializable {
        private Map wrapped;
    }
}
