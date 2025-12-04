package org.picocontainer.injectors;

import java.util.Properties;
import org.picocontainer.Characteristics;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;

/* loaded from: classes6.dex */
public class NamedFieldInjection extends AbstractInjectionFactory {
    @Override // org.picocontainer.ComponentFactory
    public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) throws PicoCompositionException {
        String str = (String) properties.remove("injectionFieldNames");
        if (str == null) {
            str = "";
        }
        return wrapLifeCycle(componentMonitor.newInjector(new NamedFieldInjector(obj, cls, parameterArr, componentMonitor, str)), lifecycleStrategy);
    }

    public static Properties injectionFieldNames(String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(" ");
            sb.append(str);
        }
        new Properties();
        return Characteristics.immutable("injectionFieldNames", sb.toString().trim());
    }
}
