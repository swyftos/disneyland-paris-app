package org.picocontainer.containers;

import org.picocontainer.ComponentFactory;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.PicoContainer;
import org.picocontainer.behaviors.Caching;
import org.picocontainer.injectors.ConstructorInjection;
import org.picocontainer.lifecycle.NullLifecycleStrategy;
import org.picocontainer.monitors.NullComponentMonitor;

/* loaded from: classes6.dex */
public class TransientPicoContainer extends DefaultPicoContainer {
    public TransientPicoContainer() {
        super(new Caching().wrap(new ConstructorInjection()), new NullLifecycleStrategy(), null, new NullComponentMonitor());
    }

    public TransientPicoContainer(PicoContainer picoContainer) {
        super(new Caching().wrap(new ConstructorInjection()), new NullLifecycleStrategy(), picoContainer, new NullComponentMonitor());
    }

    public TransientPicoContainer(ComponentFactory componentFactory, PicoContainer picoContainer) {
        super(componentFactory, new NullLifecycleStrategy(), picoContainer, new NullComponentMonitor());
    }
}
