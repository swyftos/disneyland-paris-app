package org.picocontainer;

import gherkin.GherkinLanguageConstants;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.adapters.AbstractAdapter;
import org.picocontainer.adapters.InstanceAdapter;
import org.picocontainer.behaviors.AbstractBehaviorFactory;
import org.picocontainer.behaviors.AdaptingBehavior;
import org.picocontainer.containers.AbstractDelegatingMutablePicoContainer;
import org.picocontainer.containers.AbstractDelegatingPicoContainer;
import org.picocontainer.containers.EmptyPicoContainer;
import org.picocontainer.containers.ImmutablePicoContainer;
import org.picocontainer.converters.BuiltInConverters;
import org.picocontainer.converters.ConvertsNothing;
import org.picocontainer.injectors.AbstractInjector;
import org.picocontainer.injectors.FactoryInjector;
import org.picocontainer.lifecycle.DefaultLifecycleState;
import org.picocontainer.lifecycle.LifecycleState;
import org.picocontainer.lifecycle.StartableLifecycleStrategy;
import org.picocontainer.monitors.NullComponentMonitor;
import org.picocontainer.parameters.BasicComponentParameter;
import org.picocontainer.parameters.DefaultConstructorParameter;

/* loaded from: classes6.dex */
public class DefaultPicoContainer implements MutablePicoContainer, Converting, ComponentMonitorStrategy, Serializable {
    private final Set children;
    private final Set childrenStarted;
    private final Set componentAdapters;
    protected final ComponentFactory componentFactory;
    private final Map componentKeyToAdapterCache;
    protected ComponentMonitor componentMonitor;
    private final Properties containerProperties;
    private Converters converters;
    private transient IntoThreadLocal intoThreadLocal;
    private LifecycleState lifecycleState;
    protected final LifecycleStrategy lifecycleStrategy;
    private String name;
    protected final List<ComponentAdapter<?>> orderedComponentAdapters;
    private PicoContainer parent;

    private static ComponentAdapter typeComponentAdapter(ComponentAdapter componentAdapter) {
        return componentAdapter;
    }

    public DefaultPicoContainer(ComponentFactory componentFactory, PicoContainer picoContainer) {
        this(componentFactory, new StartableLifecycleStrategy(new NullComponentMonitor()), picoContainer, new NullComponentMonitor());
    }

    public DefaultPicoContainer(ComponentFactory componentFactory, LifecycleStrategy lifecycleStrategy, PicoContainer picoContainer) {
        this(componentFactory, lifecycleStrategy, picoContainer, new NullComponentMonitor());
    }

    public DefaultPicoContainer(ComponentFactory componentFactory, LifecycleStrategy lifecycleStrategy, PicoContainer picoContainer, ComponentMonitor componentMonitor) {
        this.children = new HashSet();
        this.lifecycleState = new DefaultLifecycleState();
        this.childrenStarted = new HashSet();
        this.containerProperties = new Properties();
        this.componentKeyToAdapterCache = new HashMap();
        this.componentAdapters = new LinkedHashSet();
        this.orderedComponentAdapters = new ArrayList();
        if (componentFactory == null) {
            throw new NullPointerException("componentFactory");
        }
        if (lifecycleStrategy == null) {
            throw new NullPointerException("lifecycleStrategy");
        }
        this.componentFactory = componentFactory;
        this.lifecycleStrategy = lifecycleStrategy;
        this.parent = picoContainer;
        if (picoContainer != null && !(picoContainer instanceof EmptyPicoContainer)) {
            this.parent = new ImmutablePicoContainer(picoContainer);
        }
        this.componentMonitor = componentMonitor;
    }

    public DefaultPicoContainer(ComponentMonitor componentMonitor, PicoContainer picoContainer) {
        this(new AdaptingBehavior(), new StartableLifecycleStrategy(componentMonitor), picoContainer, componentMonitor);
    }

    public DefaultPicoContainer(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, PicoContainer picoContainer) {
        this(new AdaptingBehavior(), lifecycleStrategy, picoContainer, componentMonitor);
    }

    public DefaultPicoContainer(LifecycleStrategy lifecycleStrategy, PicoContainer picoContainer) {
        this(new NullComponentMonitor(), lifecycleStrategy, picoContainer);
    }

    public DefaultPicoContainer(ComponentFactory componentFactory) {
        this(componentFactory, (PicoContainer) null);
    }

    public DefaultPicoContainer(ComponentMonitor componentMonitor) {
        this(componentMonitor, new StartableLifecycleStrategy(componentMonitor), (PicoContainer) null);
    }

    public DefaultPicoContainer(PicoContainer picoContainer) {
        this(new AdaptingBehavior(), picoContainer);
    }

    public DefaultPicoContainer() {
        this(new AdaptingBehavior(), (PicoContainer) null);
    }

    @Override // org.picocontainer.PicoContainer
    public Collection<ComponentAdapter<?>> getComponentAdapters() {
        return Collections.unmodifiableSet(getModifiableComponentAdapterList());
    }

    @Override // org.picocontainer.PicoContainer
    public final ComponentAdapter<?> getComponentAdapter(Object obj) {
        Object objNoComponentFound;
        ComponentAdapter<?> componentAdapter = getComponentKeyToAdapterCache().get(obj);
        if (componentAdapter == null && this.parent != null && (componentAdapter = getParent().getComponentAdapter(obj)) != null) {
            componentAdapter = new KnowsContainerAdapter(componentAdapter, getParent());
        }
        return (componentAdapter != null || (objNoComponentFound = this.componentMonitor.noComponentFound(this, obj)) == null) ? componentAdapter : new LateInstance(obj, objNoComponentFound);
    }

    public static class LateInstance extends AbstractAdapter {
        private final Object instance;

        @Override // org.picocontainer.ComponentAdapter
        public void verify(PicoContainer picoContainer) throws PicoCompositionException {
        }

        private LateInstance(Object obj, Object obj2) {
            super(obj, obj2.getClass());
            this.instance = obj2;
        }

        public Object getComponentInstance() {
            return this.instance;
        }

        @Override // org.picocontainer.ComponentAdapter
        public Object getComponentInstance(PicoContainer picoContainer, Type type) throws PicoCompositionException {
            return this.instance;
        }

        @Override // org.picocontainer.ComponentAdapter
        public String getDescriptor() {
            return "LateInstance";
        }
    }

    public static class KnowsContainerAdapter<T> implements ComponentAdapter<T> {
        private final ComponentAdapter ca;
        private final PicoContainer ctr;

        @Override // org.picocontainer.ComponentAdapter
        public String getDescriptor() {
            return null;
        }

        public KnowsContainerAdapter(ComponentAdapter<T> componentAdapter, PicoContainer picoContainer) {
            this.ca = componentAdapter;
            this.ctr = picoContainer;
        }

        public T getComponentInstance(Type type) throws PicoCompositionException {
            return getComponentInstance(this.ctr, type);
        }

        @Override // org.picocontainer.ComponentAdapter
        public Object getComponentKey() {
            return this.ca.getComponentKey();
        }

        @Override // org.picocontainer.ComponentAdapter
        public Class<? extends T> getComponentImplementation() {
            return this.ca.getComponentImplementation();
        }

        @Override // org.picocontainer.ComponentAdapter
        public T getComponentInstance(PicoContainer picoContainer) throws PicoCompositionException {
            return (T) this.ca.getComponentInstance(picoContainer);
        }

        @Override // org.picocontainer.ComponentAdapter
        public T getComponentInstance(PicoContainer picoContainer, Type type) throws PicoCompositionException {
            return (T) this.ca.getComponentInstance(picoContainer, type);
        }

        @Override // org.picocontainer.ComponentAdapter
        public void verify(PicoContainer picoContainer) throws PicoCompositionException {
            this.ca.verify(picoContainer);
        }

        @Override // org.picocontainer.ComponentAdapter
        public void accept(PicoVisitor picoVisitor) {
            this.ca.accept(picoVisitor);
        }

        @Override // org.picocontainer.ComponentAdapter
        public ComponentAdapter getDelegate() {
            return this.ca.getDelegate();
        }

        @Override // org.picocontainer.ComponentAdapter
        public <U extends ComponentAdapter> U findAdapterOfType(Class<U> cls) {
            return (U) this.ca.findAdapterOfType(cls);
        }
    }

    @Override // org.picocontainer.PicoContainer
    public <T> ComponentAdapter<T> getComponentAdapter(Class<T> cls, NameBinding nameBinding) {
        return getComponentAdapter(cls, nameBinding, null);
    }

    private ComponentAdapter getComponentAdapter(Class cls, NameBinding nameBinding, Class cls2) {
        String name;
        ComponentAdapter<?> componentAdapter;
        ComponentAdapter<?> componentAdapter2 = getComponentAdapter(cls);
        if (componentAdapter2 != null) {
            return typeComponentAdapter(componentAdapter2);
        }
        List componentAdapters = cls2 == null ? getComponentAdapters(cls) : getComponentAdapters(cls, cls2);
        if (componentAdapters.size() == 1) {
            return (ComponentAdapter) componentAdapters.get(0);
        }
        if (componentAdapters.isEmpty()) {
            if (this.parent != null) {
                return getParent().getComponentAdapter(cls, nameBinding);
            }
            return null;
        }
        if (nameBinding != null && (name = nameBinding.getName()) != null && (componentAdapter = getComponentAdapter(name)) != null && cls.isAssignableFrom(componentAdapter.getComponentImplementation())) {
            return typeComponentAdapter(componentAdapter);
        }
        throw new AbstractInjector.AmbiguousComponentResolutionException(cls, BasicComponentParameter.makeFoundAmbiguousStrings(componentAdapters));
    }

    @Override // org.picocontainer.PicoContainer
    public <T> ComponentAdapter<T> getComponentAdapter(Class<T> cls, Class<? extends Annotation> cls2) {
        return getComponentAdapter(cls, null, cls2);
    }

    @Override // org.picocontainer.PicoContainer
    public <T> List<ComponentAdapter<T>> getComponentAdapters(Class<T> cls) {
        return getComponentAdapters(cls, null);
    }

    @Override // org.picocontainer.PicoContainer
    public <T> List<ComponentAdapter<T>> getComponentAdapters(Class<T> cls, Class<? extends Annotation> cls2) {
        if (cls == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (ComponentAdapter<?> componentAdapter : getComponentAdapters()) {
            Object componentKey = componentAdapter.getComponentKey();
            if (cls.isAssignableFrom(componentAdapter.getComponentImplementation())) {
                if (componentKey instanceof BindKey) {
                    if (componentKey instanceof BindKey) {
                        BindKey bindKey = (BindKey) componentKey;
                        if (bindKey.getAnnotation() == null || cls2 == null || bindKey.getAnnotation() == cls2) {
                        }
                    }
                }
                arrayList.add(typeComponentAdapter(componentAdapter));
            }
        }
        return arrayList;
    }

    protected MutablePicoContainer addAdapterInternal(ComponentAdapter<?> componentAdapter) {
        Object componentKey = componentAdapter.getComponentKey();
        if (getComponentKeyToAdapterCache().containsKey(componentKey)) {
            throw new PicoCompositionException("Duplicate Keys not allowed. Duplicate for '" + componentKey + "'");
        }
        getModifiableComponentAdapterList().add(componentAdapter);
        getComponentKeyToAdapterCache().put(componentKey, componentAdapter);
        return this;
    }

    @Override // org.picocontainer.MutablePicoContainer
    public MutablePicoContainer addAdapter(ComponentAdapter<?> componentAdapter) {
        return addAdapter(componentAdapter, this.containerProperties);
    }

    public MutablePicoContainer addAdapter(ComponentAdapter<?> componentAdapter, Properties properties) {
        Properties properties2 = (Properties) properties.clone();
        AbstractBehaviorFactory.removePropertiesIfPresent(properties2, Characteristics.USE_NAMES);
        if (!AbstractBehaviorFactory.removePropertiesIfPresent(properties2, Characteristics.NONE)) {
            ComponentFactory componentFactory = this.componentFactory;
            if (componentFactory instanceof BehaviorFactory) {
                MutablePicoContainer mutablePicoContainerAddAdapterInternal = addAdapterInternal(((BehaviorFactory) componentFactory).addComponentAdapter(this.componentMonitor, this.lifecycleStrategy, properties2, componentAdapter));
                throwIfPropertiesLeft(properties2);
                return mutablePicoContainerAddAdapterInternal;
            }
        }
        return addAdapterInternal(componentAdapter);
    }

    @Override // org.picocontainer.MutablePicoContainer
    public <T> ComponentAdapter<T> removeComponent(Object obj) {
        this.lifecycleState.removingComponent();
        ComponentAdapter<T> componentAdapter = (ComponentAdapter) getComponentKeyToAdapterCache().remove(obj);
        getModifiableComponentAdapterList().remove(componentAdapter);
        getOrderedComponentAdapters().remove(componentAdapter);
        return componentAdapter;
    }

    @Override // org.picocontainer.MutablePicoContainer
    public MutablePicoContainer addComponent(Object obj) {
        return addComponent(obj, this.containerProperties);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MutablePicoContainer addComponent(Object obj, Properties properties) {
        Class<?> cls;
        if (obj instanceof String) {
            return addComponent(obj, obj, new Parameter[0]);
        }
        if (obj instanceof Class) {
            cls = (Class) obj;
        } else {
            cls = obj.getClass();
        }
        return addComponent(cls, obj, properties, new Parameter[0]);
    }

    @Override // org.picocontainer.MutablePicoContainer
    public MutablePicoContainer addConfig(String str, Object obj) {
        return addAdapterInternal(new InstanceAdapter(str, obj, this.lifecycleStrategy, this.componentMonitor));
    }

    @Override // org.picocontainer.MutablePicoContainer
    public MutablePicoContainer addComponent(Object obj, Object obj2, Parameter... parameterArr) {
        return addComponent(obj, obj2, this.containerProperties, parameterArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MutablePicoContainer addComponent(Object obj, Object obj2, Properties properties, Parameter... parameterArr) throws PicoCompositionException {
        if (parameterArr != null && parameterArr.length == 0) {
            parameterArr = null;
        }
        if (parameterArr != null && parameterArr.length == 1 && DefaultConstructorParameter.INSTANCE.equals(parameterArr[0])) {
            parameterArr = new Parameter[0];
        }
        Parameter[] parameterArr2 = parameterArr;
        if (obj2 instanceof Class) {
            Properties properties2 = (Properties) properties.clone();
            ComponentAdapter<?> componentAdapterCreateComponentAdapter = this.componentFactory.createComponentAdapter(this.componentMonitor, this.lifecycleStrategy, properties2, obj, (Class) obj2, parameterArr2);
            AbstractBehaviorFactory.removePropertiesIfPresent(properties2, Characteristics.USE_NAMES);
            throwIfPropertiesLeft(properties2);
            if (this.lifecycleState.isStarted()) {
                addAdapterIfStartable(componentAdapterCreateComponentAdapter);
                potentiallyStartAdapter(componentAdapterCreateComponentAdapter);
            }
            return addAdapterInternal(componentAdapterCreateComponentAdapter);
        }
        InstanceAdapter instanceAdapter = new InstanceAdapter(obj, obj2, this.lifecycleStrategy, this.componentMonitor);
        if (this.lifecycleState.isStarted()) {
            addAdapterIfStartable(instanceAdapter);
            potentiallyStartAdapter(instanceAdapter);
        }
        return addAdapter(instanceAdapter, properties);
    }

    private void throwIfPropertiesLeft(Properties properties) {
        if (properties.size() <= 0) {
            return;
        }
        throw new PicoCompositionException("Unprocessed Characteristics:" + properties + ", please refer to http://picocontainer.org/unprocessed-properties-help.html");
    }

    private synchronized void addOrderedComponentAdapter(ComponentAdapter componentAdapter) {
        if (!getOrderedComponentAdapters().contains(componentAdapter)) {
            getOrderedComponentAdapters().add(componentAdapter);
        }
    }

    @Override // org.picocontainer.PicoContainer
    public List<Object> getComponents() throws PicoException {
        return getComponents(Object.class);
    }

    @Override // org.picocontainer.PicoContainer
    public <T> List<T> getComponents(Class<T> cls) {
        if (cls == null) {
            return Collections.emptyList();
        }
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                for (ComponentAdapter<?> componentAdapter : getModifiableComponentAdapterList()) {
                    if (cls.isAssignableFrom(componentAdapter.getComponentImplementation())) {
                        ComponentAdapter componentAdapterTypeComponentAdapter = typeComponentAdapter(componentAdapter);
                        map.put(componentAdapterTypeComponentAdapter, getLocalInstance(componentAdapterTypeComponentAdapter));
                    }
                }
                Iterator<ComponentAdapter<?>> it = getOrderedComponentAdapters().iterator();
                while (it.hasNext()) {
                    Object obj = map.get(it.next());
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    private Object getLocalInstance(ComponentAdapter componentAdapter) throws PicoCompositionException {
        Object componentInstance = componentAdapter.getComponentInstance(this, ComponentAdapter.NOTHING.class);
        addOrderedComponentAdapter(componentAdapter);
        return componentInstance;
    }

    @Override // org.picocontainer.PicoContainer
    public Object getComponent(Object obj) {
        return getComponent(obj, (Class<? extends Annotation>) null);
    }

    @Override // org.picocontainer.PicoContainer
    public Object getComponent(Object obj, Type type) {
        synchronized (this) {
            try {
                AnonymousClass1 anonymousClass1 = null;
                if (this.intoThreadLocal == null) {
                    this.intoThreadLocal = new IntoThreadLocal();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.intoThreadLocal.set(type);
        try {
            return getComponent(obj, (Class<? extends Annotation>) null);
        } finally {
            this.intoThreadLocal.set(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v0, types: [org.picocontainer.DefaultPicoContainer] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [org.picocontainer.ComponentAdapter] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4, types: [org.picocontainer.ComponentAdapter] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [org.picocontainer.ComponentAdapter] */
    /* JADX WARN: Type inference failed for: r2v8 */
    public Object getComponent(Object obj, Class<? extends Annotation> cls) throws PicoCompositionException {
        ComponentAdapter defaultPicoContainer = null;
        defaultPicoContainer = null;
        defaultPicoContainer = null;
        defaultPicoContainer = null;
        try {
            try {
                if (cls != null) {
                    obj = getComponentAdapter((Class) obj, cls);
                    if (obj != 0) {
                        defaultPicoContainer = getInstance(obj, null);
                        obj = obj;
                    }
                } else if (obj instanceof Class) {
                    ComponentAdapter componentAdapter = getComponentAdapter((Class) obj, null);
                    if (componentAdapter != null) {
                        try {
                            defaultPicoContainer = getInstance(componentAdapter, (Class) obj);
                        } catch (AbstractInjector.AmbiguousComponentResolutionException e) {
                            e = e;
                            defaultPicoContainer = componentAdapter;
                            if (defaultPicoContainer != null) {
                                e.setComponent(BasicComponentParameter.findInjectorOrInstanceAdapter(defaultPicoContainer).toString());
                            }
                            throw e;
                        }
                    }
                    obj = componentAdapter;
                } else {
                    obj = getComponentAdapter(obj);
                    if (obj != 0) {
                        defaultPicoContainer = getInstance(obj, null);
                        obj = obj;
                    }
                }
                return decorateComponent(defaultPicoContainer, obj);
            } catch (AbstractInjector.AmbiguousComponentResolutionException e2) {
                e = e2;
                defaultPicoContainer = obj;
            }
        } catch (AbstractInjector.AmbiguousComponentResolutionException e3) {
            e = e3;
        }
    }

    protected Object decorateComponent(Object obj, ComponentAdapter<?> componentAdapter) {
        if ((componentAdapter instanceof ComponentLifecycle) && this.lifecycleStrategy.isLazy(componentAdapter)) {
            ComponentLifecycle componentLifecycle = (ComponentLifecycle) componentAdapter;
            if (!componentLifecycle.isStarted()) {
                componentLifecycle.start(this);
            }
        }
        return obj;
    }

    @Override // org.picocontainer.PicoContainer
    public <T> T getComponent(Class<T> cls) {
        return cls.cast(getComponent((Object) cls, (Class<? extends Annotation>) null));
    }

    @Override // org.picocontainer.PicoContainer
    public <T> T getComponent(Class<T> cls, Class<? extends Annotation> cls2) {
        return cls.cast(getComponent((Object) cls, cls2));
    }

    private Object getInstance(ComponentAdapter componentAdapter, Class cls) throws PicoCompositionException {
        Object component;
        Object componentInstance;
        if (getModifiableComponentAdapterList().contains(componentAdapter) || (componentAdapter instanceof LateInstance)) {
            try {
                if (componentAdapter instanceof FactoryInjector) {
                    componentInstance = ((FactoryInjector) componentAdapter).getComponentInstance(this, getInto());
                } else {
                    componentInstance = componentAdapter.getComponentInstance(this, getInto());
                }
                addOrderedComponentAdapter(componentAdapter);
                return componentInstance;
            } catch (AbstractInjector.CyclicDependencyException e) {
                if (this.parent == null || (component = getParent().getComponent(componentAdapter.getComponentKey())) == null) {
                    throw e;
                }
                return component;
            }
        }
        Object componentKey = cls;
        if (this.parent == null) {
            return null;
        }
        if (cls == null) {
            componentKey = componentAdapter.getComponentKey();
        }
        return getParent().getComponent(componentKey);
    }

    private Type getInto() {
        IntoThreadLocal intoThreadLocal = this.intoThreadLocal;
        if (intoThreadLocal == null) {
            return null;
        }
        return (Type) intoThreadLocal.get();
    }

    @Override // org.picocontainer.PicoContainer
    public PicoContainer getParent() {
        return this.parent;
    }

    @Override // org.picocontainer.MutablePicoContainer
    public <T> ComponentAdapter<T> removeComponentByInstance(T t) {
        for (ComponentAdapter<?> componentAdapter : getModifiableComponentAdapterList()) {
            if (getLocalInstance(componentAdapter).equals(t)) {
                return removeComponent(componentAdapter.getComponentKey());
            }
        }
        return null;
    }

    @Override // org.picocontainer.Startable
    public synchronized void start() {
        this.lifecycleState.starting();
        startAdapters();
        this.childrenStarted.clear();
        for (PicoContainer picoContainer : this.children) {
            this.childrenStarted.add(new WeakReference(picoContainer));
            if (picoContainer instanceof Startable) {
                ((Startable) picoContainer).start();
            }
        }
    }

    @Override // org.picocontainer.Startable
    public synchronized void stop() {
        try {
            this.lifecycleState.stopping();
            for (PicoContainer picoContainer : this.children) {
                if (childStarted(picoContainer) && (picoContainer instanceof Startable)) {
                    ((Startable) picoContainer).stop();
                }
            }
            stopAdapters();
            this.lifecycleState.stopped();
        } catch (Throwable th) {
            throw th;
        }
    }

    private boolean childStarted(PicoContainer picoContainer) {
        Iterator it = this.childrenStarted.iterator();
        while (it.hasNext()) {
            PicoContainer picoContainer2 = (PicoContainer) ((WeakReference) it.next()).get();
            if (picoContainer2 != null && picoContainer.equals(picoContainer2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.picocontainer.Disposable
    public synchronized void dispose() {
        try {
            if (this.lifecycleState.isStarted()) {
                stop();
            }
            this.lifecycleState.disposing();
            for (PicoContainer picoContainer : this.children) {
                if (picoContainer instanceof MutablePicoContainer) {
                    ((Disposable) picoContainer).dispose();
                }
            }
            disposeAdapters();
            this.lifecycleState.disposed();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.picocontainer.MutablePicoContainer
    public synchronized void setLifecycleState(LifecycleState lifecycleState) {
        this.lifecycleState = lifecycleState;
    }

    @Override // org.picocontainer.MutablePicoContainer
    public MutablePicoContainer makeChildContainer() {
        DefaultPicoContainer defaultPicoContainer = new DefaultPicoContainer(this.componentFactory, this.lifecycleStrategy, this, this.componentMonitor);
        addChildContainer(defaultPicoContainer);
        return defaultPicoContainer;
    }

    private void checkCircularChildDependencies(PicoContainer picoContainer) {
        if (picoContainer == this) {
            throw new IllegalArgumentException(String.format("Cannot have circular dependency between parent %s and child: %s", this, picoContainer));
        }
        if (picoContainer instanceof AbstractDelegatingPicoContainer) {
            AbstractDelegatingPicoContainer abstractDelegatingPicoContainer = (AbstractDelegatingPicoContainer) picoContainer;
            while (abstractDelegatingPicoContainer != null) {
                PicoContainer delegate = abstractDelegatingPicoContainer.getDelegate();
                if (this == delegate) {
                    throw new IllegalArgumentException(String.format("Cannot have circular dependency between parent %s and child: %s", this, picoContainer));
                }
                abstractDelegatingPicoContainer = delegate instanceof AbstractDelegatingPicoContainer ? (AbstractDelegatingPicoContainer) delegate : null;
            }
        }
    }

    @Override // org.picocontainer.MutablePicoContainer
    public MutablePicoContainer addChildContainer(PicoContainer picoContainer) {
        checkCircularChildDependencies(picoContainer);
        if (this.children.add(picoContainer) && this.lifecycleState.isStarted()) {
            this.childrenStarted.add(new WeakReference(picoContainer));
        }
        return this;
    }

    @Override // org.picocontainer.MutablePicoContainer
    public boolean removeChildContainer(PicoContainer picoContainer) {
        WeakReference weakReference;
        boolean zRemove = this.children.remove(picoContainer);
        Iterator it = this.childrenStarted.iterator();
        while (true) {
            if (!it.hasNext()) {
                weakReference = null;
                break;
            }
            weakReference = (WeakReference) it.next();
            if (((PicoContainer) weakReference.get()).equals(picoContainer)) {
                break;
            }
        }
        if (weakReference != null) {
            this.childrenStarted.remove(weakReference);
        }
        return zRemove;
    }

    @Override // org.picocontainer.MutablePicoContainer
    public MutablePicoContainer change(Properties... propertiesArr) {
        for (Properties properties : propertiesArr) {
            Enumeration<?> enumerationPropertyNames = properties.propertyNames();
            while (enumerationPropertyNames.hasMoreElements()) {
                String str = (String) enumerationPropertyNames.nextElement();
                this.containerProperties.setProperty(str, properties.getProperty(str));
            }
        }
        return this;
    }

    @Override // org.picocontainer.MutablePicoContainer
    public MutablePicoContainer as(Properties... propertiesArr) {
        return new AsPropertiesPicoContainer(propertiesArr);
    }

    @Override // org.picocontainer.PicoContainer
    public void accept(PicoVisitor picoVisitor) {
        if (picoVisitor.visitContainer(this)) {
            this.componentFactory.accept(picoVisitor);
            Iterator it = new ArrayList(getComponentAdapters()).iterator();
            while (it.hasNext()) {
                ((ComponentAdapter) it.next()).accept(picoVisitor);
            }
            Iterator it2 = new ArrayList(this.children).iterator();
            while (it2.hasNext()) {
                ((PicoContainer) it2.next()).accept(picoVisitor);
            }
        }
    }

    @Override // org.picocontainer.ComponentMonitorStrategy
    public void changeMonitor(ComponentMonitor componentMonitor) {
        this.componentMonitor = componentMonitor;
        LifecycleStrategy lifecycleStrategy = this.lifecycleStrategy;
        if (lifecycleStrategy instanceof ComponentMonitorStrategy) {
            ((ComponentMonitorStrategy) lifecycleStrategy).changeMonitor(componentMonitor);
        }
        for (ComponentAdapter<?> componentAdapter : getModifiableComponentAdapterList()) {
            if (componentAdapter instanceof ComponentMonitorStrategy) {
                ((ComponentMonitorStrategy) componentAdapter).changeMonitor(componentMonitor);
            }
        }
        for (PicoContainer picoContainer : this.children) {
            if (picoContainer instanceof ComponentMonitorStrategy) {
                ((ComponentMonitorStrategy) picoContainer).changeMonitor(componentMonitor);
            }
        }
    }

    @Override // org.picocontainer.ComponentMonitorStrategy
    public ComponentMonitor currentMonitor() {
        return this.componentMonitor;
    }

    private void startAdapters() throws PicoCompositionException {
        Iterator<ComponentAdapter<?>> it = getComponentAdapters().iterator();
        while (it.hasNext()) {
            addAdapterIfStartable(it.next());
        }
        Iterator it2 = new ArrayList(getOrderedComponentAdapters()).iterator();
        while (it2.hasNext()) {
            potentiallyStartAdapter((ComponentAdapter) it2.next());
        }
    }

    protected void potentiallyStartAdapter(ComponentAdapter<?> componentAdapter) {
        if (!(componentAdapter instanceof ComponentLifecycle) || this.lifecycleStrategy.isLazy(componentAdapter)) {
            return;
        }
        ((ComponentLifecycle) componentAdapter).start(this);
    }

    private void addAdapterIfStartable(ComponentAdapter componentAdapter) throws PicoCompositionException {
        if ((componentAdapter instanceof ComponentLifecycle) && ((ComponentLifecycle) componentAdapter).componentHasLifecycle()) {
            instantiateComponentAsIsStartable(componentAdapter);
            addOrderedComponentAdapter(componentAdapter);
        }
    }

    protected void instantiateComponentAsIsStartable(ComponentAdapter<?> componentAdapter) throws PicoCompositionException {
        if (this.lifecycleStrategy.isLazy(componentAdapter)) {
            return;
        }
        componentAdapter.getComponentInstance(this, ComponentAdapter.NOTHING.class);
    }

    private void stopAdapters() {
        for (int size = getOrderedComponentAdapters().size() - 1; size >= 0; size--) {
            ComponentAdapter<?> componentAdapter = getOrderedComponentAdapters().get(size);
            if (componentAdapter instanceof ComponentLifecycle) {
                ComponentLifecycle componentLifecycle = (ComponentLifecycle) componentAdapter;
                if (componentLifecycle.componentHasLifecycle() && componentLifecycle.isStarted()) {
                    componentLifecycle.stop(this);
                }
            }
        }
    }

    private void disposeAdapters() {
        for (int size = getOrderedComponentAdapters().size() - 1; size >= 0; size--) {
            ComponentAdapter<?> componentAdapter = getOrderedComponentAdapters().get(size);
            if (componentAdapter instanceof ComponentLifecycle) {
                ((ComponentLifecycle) componentAdapter).dispose(this);
            }
        }
    }

    protected List<ComponentAdapter<?>> getOrderedComponentAdapters() {
        return this.orderedComponentAdapters;
    }

    protected Map<Object, ComponentAdapter<?>> getComponentKeyToAdapterCache() {
        return this.componentKeyToAdapterCache;
    }

    protected Set<ComponentAdapter<?>> getModifiableComponentAdapterList() {
        return this.componentAdapters;
    }

    @Override // org.picocontainer.MutablePicoContainer
    public synchronized void setName(String str) {
        this.name = str;
    }

    public String toString() {
        String string = this.name;
        if (string == null) {
            string = super.toString();
        }
        Integer numValueOf = Integer.valueOf(this.componentAdapters.size());
        PicoContainer picoContainer = this.parent;
        return String.format("%s:%d<%s", string, numValueOf, (picoContainer == null || (picoContainer instanceof EmptyPicoContainer)) ? GherkinLanguageConstants.TABLE_CELL_SEPARATOR : picoContainer.toString());
    }

    @Override // org.picocontainer.Converting
    public synchronized Converters getConverters() {
        try {
            if (this.converters == null) {
                PicoContainer picoContainer = this.parent;
                if (picoContainer != null && (!(picoContainer instanceof Converting) || !(((Converting) picoContainer).getConverters() instanceof ConvertsNothing))) {
                    return ((Converting) this.parent).getConverters();
                }
                this.converters = new BuiltInConverters();
            }
            return this.converters;
        } catch (Throwable th) {
            throw th;
        }
    }

    private class AsPropertiesPicoContainer extends AbstractDelegatingMutablePicoContainer {
        private final Properties properties;

        public AsPropertiesPicoContainer(Properties... propertiesArr) {
            super(DefaultPicoContainer.this);
            this.properties = (Properties) DefaultPicoContainer.this.containerProperties.clone();
            for (Properties properties : propertiesArr) {
                Enumeration<?> enumerationPropertyNames = properties.propertyNames();
                while (enumerationPropertyNames.hasMoreElements()) {
                    String str = (String) enumerationPropertyNames.nextElement();
                    this.properties.setProperty(str, properties.getProperty(str));
                }
            }
        }

        @Override // org.picocontainer.containers.AbstractDelegatingMutablePicoContainer, org.picocontainer.MutablePicoContainer
        public MutablePicoContainer as(Properties... propertiesArr) {
            throw new PicoCompositionException("Syntax 'as(FOO).as(BAR)' not allowed, do 'as(FOO, BAR)' instead");
        }

        @Override // org.picocontainer.containers.AbstractDelegatingMutablePicoContainer, org.picocontainer.MutablePicoContainer
        public MutablePicoContainer makeChildContainer() {
            return getDelegate().makeChildContainer();
        }

        @Override // org.picocontainer.containers.AbstractDelegatingMutablePicoContainer, org.picocontainer.MutablePicoContainer
        public MutablePicoContainer addComponent(Object obj, Object obj2, Parameter... parameterArr) {
            return DefaultPicoContainer.this.addComponent(obj, obj2, this.properties, parameterArr);
        }

        @Override // org.picocontainer.containers.AbstractDelegatingMutablePicoContainer, org.picocontainer.MutablePicoContainer
        public MutablePicoContainer addComponent(Object obj) {
            return DefaultPicoContainer.this.addComponent(obj, this.properties);
        }

        @Override // org.picocontainer.containers.AbstractDelegatingMutablePicoContainer, org.picocontainer.MutablePicoContainer
        public MutablePicoContainer addAdapter(ComponentAdapter componentAdapter) {
            return DefaultPicoContainer.this.addAdapter(componentAdapter, this.properties);
        }

        @Override // org.picocontainer.containers.AbstractDelegatingMutablePicoContainer, org.picocontainer.MutablePicoContainer
        public LifecycleState getLifecycleState() {
            return DefaultPicoContainer.this.getLifecycleState();
        }

        @Override // org.picocontainer.containers.AbstractDelegatingMutablePicoContainer, org.picocontainer.MutablePicoContainer
        public String getName() {
            return DefaultPicoContainer.this.getName();
        }
    }

    private static class IntoThreadLocal extends ThreadLocal implements Serializable {
        private IntoThreadLocal() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Type initialValue() {
            return ComponentAdapter.NOTHING.class;
        }
    }

    @Override // org.picocontainer.MutablePicoContainer
    public synchronized LifecycleState getLifecycleState() {
        return this.lifecycleState;
    }

    @Override // org.picocontainer.MutablePicoContainer
    public synchronized String getName() {
        return this.name;
    }
}
