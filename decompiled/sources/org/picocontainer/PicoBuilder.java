package org.picocontainer;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import org.picocontainer.behaviors.Automating;
import org.picocontainer.behaviors.Behaviors;
import org.picocontainer.behaviors.Locking;
import org.picocontainer.behaviors.PropertyApplying;
import org.picocontainer.behaviors.Synchronizing;
import org.picocontainer.containers.EmptyPicoContainer;
import org.picocontainer.containers.TransientPicoContainer;
import org.picocontainer.injectors.CompositeInjection;
import org.picocontainer.injectors.Injectors;
import org.picocontainer.injectors.MethodInjection;
import org.picocontainer.lifecycle.JavaEE5LifecycleStrategy;
import org.picocontainer.lifecycle.NullLifecycleStrategy;
import org.picocontainer.lifecycle.ReflectionLifecycleStrategy;
import org.picocontainer.lifecycle.StartableLifecycleStrategy;
import org.picocontainer.monitors.ConsoleComponentMonitor;
import org.picocontainer.monitors.NullComponentMonitor;

/* loaded from: classes6.dex */
public class PicoBuilder {
    private boolean addChildToParent;
    private final Stack behaviors;
    private ComponentMonitor componentMonitor;
    private Class componentMonitorClass;
    private List containerComps;
    private final List injectors;
    private LifecycleStrategy lifecycleStrategy;
    private Class lifecycleStrategyClass;
    private Class mpcClass;
    private PicoContainer parentContainer;

    public PicoBuilder(PicoContainer picoContainer, InjectionFactory injectionFactory) {
        this(picoContainer);
        addInjector(injectionFactory);
    }

    public PicoBuilder(PicoContainer picoContainer) {
        this.mpcClass = DefaultPicoContainer.class;
        this.containerComps = new ArrayList();
        this.behaviors = new Stack();
        this.injectors = new ArrayList();
        this.componentMonitorClass = NullComponentMonitor.class;
        this.lifecycleStrategyClass = NullLifecycleStrategy.class;
        if (picoContainer != null) {
            this.parentContainer = picoContainer;
        } else {
            this.parentContainer = new EmptyPicoContainer();
        }
    }

    public PicoBuilder(InjectionFactory injectionFactory) {
        this(new EmptyPicoContainer(), injectionFactory);
    }

    public PicoBuilder() {
        this(new EmptyPicoContainer());
    }

    public PicoBuilder withLifecycle() {
        this.lifecycleStrategyClass = StartableLifecycleStrategy.class;
        this.lifecycleStrategy = null;
        return this;
    }

    public PicoBuilder withReflectionLifecycle() {
        this.lifecycleStrategyClass = ReflectionLifecycleStrategy.class;
        this.lifecycleStrategy = null;
        return this;
    }

    public PicoBuilder withLifecycle(Class<? extends LifecycleStrategy> cls) {
        this.lifecycleStrategyClass = cls;
        this.lifecycleStrategy = null;
        return this;
    }

    public PicoBuilder withJavaEE5Lifecycle() {
        this.lifecycleStrategyClass = JavaEE5LifecycleStrategy.class;
        this.lifecycleStrategy = null;
        return this;
    }

    public PicoBuilder withLifecycle(LifecycleStrategy lifecycleStrategy) {
        this.lifecycleStrategy = lifecycleStrategy;
        this.lifecycleStrategyClass = null;
        return this;
    }

    public PicoBuilder withConsoleMonitor() {
        this.componentMonitorClass = ConsoleComponentMonitor.class;
        return this;
    }

    public PicoBuilder withMonitor(Class<? extends ComponentMonitor> cls) {
        if (cls == null) {
            throw new NullPointerException("monitor class cannot be null");
        }
        if (!ComponentMonitor.class.isAssignableFrom(cls)) {
            throw new ClassCastException(cls.getName() + " is not a " + ComponentMonitor.class.getName());
        }
        this.componentMonitorClass = cls;
        this.componentMonitor = null;
        return this;
    }

    public MutablePicoContainer build() {
        ComponentFactory compositeInjection;
        DefaultPicoContainer transientPicoContainer = new TransientPicoContainer();
        transientPicoContainer.addComponent(PicoContainer.class, this.parentContainer, new Parameter[0]);
        addContainerComponents(transientPicoContainer);
        if (this.injectors.size() == 1) {
            compositeInjection = (ComponentFactory) this.injectors.get(0);
        } else if (this.injectors.size() == 0) {
            compositeInjection = Injectors.adaptiveDI();
        } else {
            List list = this.injectors;
            compositeInjection = new CompositeInjection((InjectionFactory[]) list.toArray(new InjectionFactory[list.size()]));
        }
        Stack stack = (Stack) this.behaviors.clone();
        while (!stack.empty()) {
            compositeInjection = buildComponentFactory(transientPicoContainer, compositeInjection, stack);
        }
        transientPicoContainer.addComponent(ComponentFactory.class, compositeInjection, new Parameter[0]);
        buildComponentMonitor(transientPicoContainer);
        Object obj = this.lifecycleStrategy;
        if (obj == null) {
            transientPicoContainer.addComponent(LifecycleStrategy.class, this.lifecycleStrategyClass, new Parameter[0]);
        } else {
            transientPicoContainer.addComponent(LifecycleStrategy.class, obj, new Parameter[0]);
        }
        transientPicoContainer.addComponent("mpc", this.mpcClass, new Parameter[0]);
        MutablePicoContainer mutablePicoContainer = (MutablePicoContainer) transientPicoContainer.getComponent("mpc");
        addChildToParent(mutablePicoContainer);
        return mutablePicoContainer;
    }

    private void buildComponentMonitor(DefaultPicoContainer defaultPicoContainer) {
        Class cls = this.componentMonitorClass;
        if (cls == null) {
            defaultPicoContainer.addComponent(ComponentMonitor.class, this.componentMonitor, new Parameter[0]);
        } else {
            defaultPicoContainer.addComponent(ComponentMonitor.class, cls, new Parameter[0]);
        }
    }

    private void addChildToParent(MutablePicoContainer mutablePicoContainer) {
        if (this.addChildToParent) {
            PicoContainer picoContainer = this.parentContainer;
            if (picoContainer instanceof MutablePicoContainer) {
                ((MutablePicoContainer) picoContainer).addChildContainer(mutablePicoContainer);
                return;
            }
            throw new PicoCompositionException("If using addChildContainer() the parent must be a MutablePicoContainer");
        }
    }

    private void addContainerComponents(DefaultPicoContainer defaultPicoContainer) {
        Iterator it = this.containerComps.iterator();
        while (it.hasNext()) {
            defaultPicoContainer.addComponent(it.next());
        }
    }

    private ComponentFactory buildComponentFactory(DefaultPicoContainer defaultPicoContainer, ComponentFactory componentFactory, Stack stack) {
        Object objPop = stack.pop();
        TransientPicoContainer transientPicoContainer = new TransientPicoContainer(defaultPicoContainer);
        transientPicoContainer.addComponent("componentFactory", objPop, new Parameter[0]);
        if (componentFactory != null) {
            transientPicoContainer.addComponent(ComponentFactory.class, componentFactory, new Parameter[0]);
        }
        ComponentFactory componentFactory2 = (ComponentFactory) transientPicoContainer.getComponent("componentFactory");
        if (componentFactory2 instanceof BehaviorFactory) {
            ((BehaviorFactory) componentFactory2).wrap(componentFactory);
        }
        return componentFactory2;
    }

    public PicoBuilder withHiddenImplementations() {
        this.behaviors.push(Behaviors.implementationHiding());
        return this;
    }

    public PicoBuilder withSetterInjection() {
        addInjector(Injectors.SDI());
        return this;
    }

    public PicoBuilder withAnnotatedMethodInjection(Class<? extends Annotation> cls) {
        addInjector(Injectors.annotatedMethodDI(cls));
        return this;
    }

    public PicoBuilder withAnnotatedMethodInjection() {
        addInjector(Injectors.annotatedMethodDI());
        return this;
    }

    public PicoBuilder withAnnotatedFieldInjection(Class<? extends Annotation> cls) {
        addInjector(Injectors.annotatedFieldDI(cls));
        return this;
    }

    public PicoBuilder withAnnotatedFieldInjection() {
        addInjector(Injectors.annotatedFieldDI());
        return this;
    }

    public PicoBuilder withTypedFieldInjection() {
        addInjector(Injectors.typedFieldDI());
        return this;
    }

    public PicoBuilder withConstructorInjection() {
        addInjector(Injectors.CDI());
        return this;
    }

    public PicoBuilder withNamedMethodInjection() {
        addInjector(Injectors.namedMethod());
        return this;
    }

    public PicoBuilder withNamedFieldInjection() {
        addInjector(Injectors.namedField());
        return this;
    }

    public PicoBuilder withCaching() {
        this.behaviors.push(Behaviors.caching());
        return this;
    }

    public PicoBuilder withComponentFactory(ComponentFactory componentFactory) {
        if (componentFactory == null) {
            throw new NullPointerException("CAF cannot be null");
        }
        this.behaviors.push(componentFactory);
        return this;
    }

    public PicoBuilder withSynchronizing() {
        this.behaviors.push(new Synchronizing());
        return this;
    }

    public PicoBuilder withLocking() {
        this.behaviors.push(new Locking());
        return this;
    }

    public PicoBuilder withBehaviors(BehaviorFactory... behaviorFactoryArr) {
        for (BehaviorFactory behaviorFactory : behaviorFactoryArr) {
            this.behaviors.push(behaviorFactory);
        }
        return this;
    }

    public PicoBuilder implementedBy(Class<? extends MutablePicoContainer> cls) {
        this.mpcClass = cls;
        return this;
    }

    public PicoBuilder withMonitor(ComponentMonitor componentMonitor) {
        this.componentMonitor = componentMonitor;
        this.componentMonitorClass = null;
        return this;
    }

    public PicoBuilder withComponentFactory(Class<? extends ComponentFactory> cls) {
        this.behaviors.push(cls);
        return this;
    }

    public PicoBuilder withCustomContainerComponent(Object obj) {
        this.containerComps.add(obj);
        return this;
    }

    public PicoBuilder withPropertyApplier() {
        this.behaviors.push(new PropertyApplying());
        return this;
    }

    public PicoBuilder withAutomatic() {
        this.behaviors.push(new Automating());
        return this;
    }

    public PicoBuilder withMethodInjection() {
        addInjector(new MethodInjection());
        return this;
    }

    public PicoBuilder addChildToParent() {
        this.addChildToParent = true;
        return this;
    }

    protected void addInjector(InjectionFactory injectionFactory) {
        this.injectors.add(injectionFactory);
    }
}
