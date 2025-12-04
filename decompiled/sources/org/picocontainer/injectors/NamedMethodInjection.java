package org.picocontainer.injectors;

import com.urbanairship.channel.AttributeMutation;
import java.util.Properties;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;

/* loaded from: classes6.dex */
public class NamedMethodInjection extends AbstractInjectionFactory {
    private final boolean optional;
    private final String prefix;

    public NamedMethodInjection(String str) {
        this(str, true);
    }

    public NamedMethodInjection() {
        this(AttributeMutation.ATTRIBUTE_ACTION_SET);
    }

    public NamedMethodInjection(boolean z) {
        this(AttributeMutation.ATTRIBUTE_ACTION_SET, z);
    }

    public NamedMethodInjection(String str, boolean z) {
        this.prefix = str;
        this.optional = z;
    }

    @Override // org.picocontainer.ComponentFactory
    public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) throws PicoCompositionException {
        return wrapLifeCycle(componentMonitor.newInjector(new NamedMethodInjector(obj, cls, parameterArr, componentMonitor, this.prefix, this.optional)), lifecycleStrategy);
    }
}
