package org.picocontainer.behaviors;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Properties;
import org.picocontainer.BehaviorFactory;
import org.picocontainer.Characteristics;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentFactory;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.InjectionFactory;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVisitor;
import org.picocontainer.injectors.AdaptingInjection;

/* loaded from: classes6.dex */
public class AbstractBehaviorFactory implements ComponentFactory, Serializable, BehaviorFactory {
    private ComponentFactory delegate;

    @Override // org.picocontainer.BehaviorFactory
    public ComponentFactory wrap(ComponentFactory componentFactory) {
        this.delegate = componentFactory;
        return this;
    }

    @Override // org.picocontainer.ComponentFactory
    public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) throws PicoCompositionException {
        if (this.delegate == null) {
            this.delegate = new AdaptingInjection();
        }
        ComponentAdapter<T> componentAdapterCreateComponentAdapter = this.delegate.createComponentAdapter(componentMonitor, lifecycleStrategy, properties, obj, cls, parameterArr);
        return (removePropertiesIfPresent(properties, Characteristics.ENABLE_CIRCULAR) && (this.delegate instanceof InjectionFactory)) ? componentMonitor.newBehavior(new HiddenImplementation(componentAdapterCreateComponentAdapter)) : componentAdapterCreateComponentAdapter;
    }

    @Override // org.picocontainer.ComponentFactory
    public void verify(PicoContainer picoContainer) {
        this.delegate.verify(picoContainer);
    }

    @Override // org.picocontainer.ComponentFactory
    public void accept(PicoVisitor picoVisitor) {
        picoVisitor.visitComponentFactory(this);
        ComponentFactory componentFactory = this.delegate;
        if (componentFactory != null) {
            componentFactory.accept(picoVisitor);
        }
    }

    @Override // org.picocontainer.BehaviorFactory
    public <T> ComponentAdapter<T> addComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, ComponentAdapter<T> componentAdapter) {
        ComponentFactory componentFactory = this.delegate;
        return (componentFactory == null || !(componentFactory instanceof BehaviorFactory)) ? componentAdapter : ((BehaviorFactory) componentFactory).addComponentAdapter(componentMonitor, lifecycleStrategy, properties, componentAdapter);
    }

    public static boolean arePropertiesPresent(Properties properties, Properties properties2, boolean z) {
        Enumeration enumerationKeys = properties2.keys();
        while (enumerationKeys.hasMoreElements()) {
            String str = (String) enumerationKeys.nextElement();
            String property = properties2.getProperty(str);
            String property2 = properties.getProperty(str);
            if (property2 == null) {
                return false;
            }
            if (!property.equals(property2) && z) {
                return false;
            }
        }
        return true;
    }

    public static boolean removePropertiesIfPresent(Properties properties, Properties properties2) {
        if (!arePropertiesPresent(properties, properties2, true)) {
            return false;
        }
        Enumeration enumerationKeys = properties2.keys();
        while (enumerationKeys.hasMoreElements()) {
            properties.remove(enumerationKeys.nextElement());
        }
        return true;
    }

    public static String getAndRemovePropertiesIfPresentByKey(Properties properties, Properties properties2) {
        String str = null;
        if (!arePropertiesPresent(properties, properties2, false)) {
            return null;
        }
        Enumeration enumerationKeys = properties2.keys();
        while (enumerationKeys.hasMoreElements()) {
            str = (String) properties.remove(enumerationKeys.nextElement());
        }
        return str;
    }

    protected void mergeProperties(Properties properties, Properties properties2) {
        Enumeration<?> enumerationPropertyNames = properties2.propertyNames();
        while (enumerationPropertyNames.hasMoreElements()) {
            String str = (String) enumerationPropertyNames.nextElement();
            properties.setProperty(str, properties2.getProperty(str));
        }
    }
}
