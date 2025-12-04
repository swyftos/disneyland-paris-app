package org.picocontainer.containers;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.Converters;
import org.picocontainer.Converting;
import org.picocontainer.NameBinding;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVisitor;

/* loaded from: classes6.dex */
public class CompositePicoContainer implements PicoContainer, Converting, Serializable {
    private Converters compositeConverter = new CompositeConverters();
    private final PicoContainer[] containers;

    @Override // org.picocontainer.PicoContainer
    public void accept(PicoVisitor picoVisitor) {
    }

    @Override // org.picocontainer.PicoContainer
    public <T> T getComponent(Class<T> cls, Class<? extends Annotation> cls2) {
        return null;
    }

    @Override // org.picocontainer.PicoContainer
    public PicoContainer getParent() {
        return null;
    }

    public class CompositeConverters implements Converters {
        public CompositeConverters() {
        }

        @Override // org.picocontainer.Converters
        public boolean canConvert(Type type) {
            for (PicoContainer picoContainer : CompositePicoContainer.this.containers) {
                if ((picoContainer instanceof Converting) && ((Converting) picoContainer).getConverters().canConvert(type)) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.picocontainer.Converters
        public Object convert(String str, Type type) {
            for (PicoContainer picoContainer : CompositePicoContainer.this.containers) {
                if (picoContainer instanceof Converting) {
                    Converters converters = ((Converting) picoContainer).getConverters();
                    if (converters.canConvert(type)) {
                        return converters.convert(str, type);
                    }
                }
            }
            return null;
        }
    }

    public CompositePicoContainer(PicoContainer... picoContainerArr) {
        this.containers = picoContainerArr;
    }

    @Override // org.picocontainer.PicoContainer
    public <T> T getComponent(Class<T> cls) {
        for (PicoContainer picoContainer : this.containers) {
            T t = (T) picoContainer.getComponent((Class) cls);
            if (t != null) {
                return t;
            }
        }
        return null;
    }

    @Override // org.picocontainer.PicoContainer
    public Object getComponent(Object obj, Type type) {
        for (PicoContainer picoContainer : this.containers) {
            Object component = picoContainer.getComponent(obj, type);
            if (component != null) {
                return component;
            }
        }
        return null;
    }

    @Override // org.picocontainer.PicoContainer
    public Object getComponent(Object obj) {
        for (PicoContainer picoContainer : this.containers) {
            Object component = picoContainer.getComponent(obj);
            if (component != null) {
                return component;
            }
        }
        return null;
    }

    @Override // org.picocontainer.PicoContainer
    public ComponentAdapter getComponentAdapter(Object obj) {
        for (PicoContainer picoContainer : this.containers) {
            ComponentAdapter<?> componentAdapter = picoContainer.getComponentAdapter(obj);
            if (componentAdapter != null) {
                return componentAdapter;
            }
        }
        return null;
    }

    @Override // org.picocontainer.PicoContainer
    public <T> ComponentAdapter<T> getComponentAdapter(Class<T> cls, NameBinding nameBinding) {
        for (PicoContainer picoContainer : this.containers) {
            ComponentAdapter<T> componentAdapter = picoContainer.getComponentAdapter(cls, nameBinding);
            if (componentAdapter != null) {
                return componentAdapter;
            }
        }
        return null;
    }

    @Override // org.picocontainer.PicoContainer
    public <T> ComponentAdapter<T> getComponentAdapter(Class<T> cls, Class<? extends Annotation> cls2) {
        for (PicoContainer picoContainer : this.containers) {
            ComponentAdapter<T> componentAdapter = picoContainer.getComponentAdapter(cls, cls2);
            if (componentAdapter != null) {
                return componentAdapter;
            }
        }
        return null;
    }

    @Override // org.picocontainer.PicoContainer
    public List<Object> getComponents() {
        return Collections.emptyList();
    }

    @Override // org.picocontainer.PicoContainer
    public Collection<ComponentAdapter<?>> getComponentAdapters() {
        return Collections.emptyList();
    }

    @Override // org.picocontainer.PicoContainer
    public <T> List<ComponentAdapter<T>> getComponentAdapters(Class<T> cls) {
        return Collections.emptyList();
    }

    @Override // org.picocontainer.PicoContainer
    public <T> List<ComponentAdapter<T>> getComponentAdapters(Class<T> cls, Class<? extends Annotation> cls2) {
        return Collections.emptyList();
    }

    @Override // org.picocontainer.PicoContainer
    public <T> List<T> getComponents(Class<T> cls) {
        return Collections.emptyList();
    }

    @Override // org.picocontainer.Converting
    public Converters getConverters() {
        return this.compositeConverter;
    }
}
