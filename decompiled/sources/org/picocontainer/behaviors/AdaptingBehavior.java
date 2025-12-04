package org.picocontainer.behaviors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import org.picocontainer.BehaviorFactory;
import org.picocontainer.Characteristics;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentFactory;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVisitor;
import org.picocontainer.annotations.Cache;
import org.picocontainer.injectors.AdaptingInjection;

/* loaded from: classes6.dex */
public class AdaptingBehavior implements BehaviorFactory, Serializable {
    @Override // org.picocontainer.ComponentFactory
    public void verify(PicoContainer picoContainer) {
    }

    @Override // org.picocontainer.ComponentFactory
    public ComponentAdapter createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class cls, Parameter... parameterArr) throws PicoCompositionException {
        ArrayList arrayList = new ArrayList();
        BehaviorFactory behaviorFactoryMakeInjectionFactory = makeInjectionFactory();
        processSynchronizing(properties, arrayList);
        processLocking(properties, arrayList);
        processPropertyApplying(properties, arrayList);
        processAutomatic(properties, arrayList);
        processImplementationHiding(properties, arrayList);
        processCaching(properties, cls, arrayList);
        processGuarding(properties, cls, arrayList);
        Iterator<BehaviorFactory> it = arrayList.iterator();
        while (true) {
            ComponentFactory componentFactory = behaviorFactoryMakeInjectionFactory;
            if (it.hasNext()) {
                behaviorFactoryMakeInjectionFactory = it.next();
                if (componentFactory != null && (behaviorFactoryMakeInjectionFactory instanceof BehaviorFactory)) {
                    behaviorFactoryMakeInjectionFactory.wrap(componentFactory);
                }
            } else {
                return componentFactory.createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr);
            }
        }
    }

    @Override // org.picocontainer.BehaviorFactory
    public ComponentAdapter addComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, ComponentAdapter componentAdapter) {
        ArrayList arrayList = new ArrayList();
        processSynchronizing(properties, arrayList);
        processImplementationHiding(properties, arrayList);
        processCaching(properties, componentAdapter.getComponentImplementation(), arrayList);
        processGuarding(properties, componentAdapter.getComponentImplementation(), arrayList);
        BehaviorFactory behaviorFactory = null;
        for (BehaviorFactory behaviorFactory2 : arrayList) {
            if (behaviorFactory != null) {
                behaviorFactory2.wrap(behaviorFactory);
            }
            behaviorFactory = behaviorFactory2;
        }
        return behaviorFactory == null ? componentAdapter : behaviorFactory.addComponentAdapter(componentMonitor, lifecycleStrategy, properties, componentAdapter);
    }

    @Override // org.picocontainer.ComponentFactory
    public void accept(PicoVisitor picoVisitor) {
        picoVisitor.visitComponentFactory(this);
    }

    protected AdaptingInjection makeInjectionFactory() {
        return new AdaptingInjection();
    }

    protected void processSynchronizing(Properties properties, List<BehaviorFactory> list) {
        if (AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.SYNCHRONIZE)) {
            list.add(new Synchronizing());
        }
    }

    protected void processLocking(Properties properties, List<BehaviorFactory> list) {
        if (AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.LOCK)) {
            list.add(new Locking());
        }
    }

    protected void processCaching(Properties properties, Class cls, List<BehaviorFactory> list) {
        if (AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.CACHE) || cls.getAnnotation(Cache.class) != null) {
            list.add(new Caching());
        }
        AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.NO_CACHE);
    }

    protected void processGuarding(Properties properties, Class cls, List<BehaviorFactory> list) {
        if (AbstractBehaviorFactory.arePropertiesPresent(properties, Characteristics.GUARD, false)) {
            list.add(new Guarding());
        }
    }

    protected void processImplementationHiding(Properties properties, List<BehaviorFactory> list) {
        if (AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.HIDE_IMPL)) {
            list.add(new ImplementationHiding());
        }
        AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.NO_HIDE_IMPL);
    }

    protected void processPropertyApplying(Properties properties, List<BehaviorFactory> list) {
        if (AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.PROPERTY_APPLYING)) {
            list.add(new PropertyApplying());
        }
    }

    protected void processAutomatic(Properties properties, List<BehaviorFactory> list) {
        if (AbstractBehaviorFactory.removePropertiesIfPresent(properties, Characteristics.AUTOMATIC)) {
            list.add(new Automating());
        }
    }

    @Override // org.picocontainer.BehaviorFactory
    public ComponentFactory wrap(ComponentFactory componentFactory) {
        throw new UnsupportedOperationException();
    }
}
