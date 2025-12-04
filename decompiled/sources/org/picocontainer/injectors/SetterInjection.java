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
public class SetterInjection extends AbstractInjectionFactory {
    private String notThisOneThough;
    private boolean optional;
    private final String prefix;

    public SetterInjection(String str) {
        this.prefix = str;
    }

    public SetterInjection() {
        this(AttributeMutation.ATTRIBUTE_ACTION_SET);
    }

    public SetterInjection(String str, String str2) {
        this(str);
        this.notThisOneThough = str2;
    }

    @Override // org.picocontainer.ComponentFactory
    public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) throws PicoCompositionException {
        boolean zArePropertiesPresent = AbstractBehaviorFactory.arePropertiesPresent(properties, Characteristics.USE_NAMES, true);
        String str = this.prefix;
        String str2 = this.notThisOneThough;
        if (str2 == null) {
            str2 = "";
        }
        return wrapLifeCycle(componentMonitor.newInjector(new SetterInjector(obj, cls, parameterArr, componentMonitor, str, str2, this.optional, zArePropertiesPresent)), lifecycleStrategy);
    }

    public SetterInjection withInjectionOptional() {
        this.optional = true;
        return this;
    }
}
