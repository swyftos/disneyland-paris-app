package org.picocontainer.injectors;

import com.urbanairship.channel.AttributeMutation;
import java.util.Properties;
import org.picocontainer.Characteristics;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.behaviors.AbstractBehaviorFactory;

/* loaded from: classes6.dex */
public class MultiInjection extends AbstractInjectionFactory {
    private final String setterPrefix;

    public MultiInjection(String str) {
        this.setterPrefix = str;
    }

    public MultiInjection() {
        this(AttributeMutation.ATTRIBUTE_ACTION_SET);
    }

    @Override // org.picocontainer.ComponentFactory
    public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) throws PicoCompositionException {
        return wrapLifeCycle(new MultiInjector(obj, cls, parameterArr, componentMonitor, this.setterPrefix, AbstractBehaviorFactory.arePropertiesPresent(properties, Characteristics.USE_NAMES, true)), lifecycleStrategy);
    }
}
