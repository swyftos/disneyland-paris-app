package org.picocontainer.injectors;

import java.util.Properties;
import org.picocontainer.Characteristics;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.Parameter;
import org.picocontainer.PicoCompositionException;

/* loaded from: classes6.dex */
public class TypedFieldInjection extends AbstractInjectionFactory {
    @Override // org.picocontainer.ComponentFactory
    public <T> ComponentAdapter<T> createComponentAdapter(ComponentMonitor componentMonitor, LifecycleStrategy lifecycleStrategy, Properties properties, Object obj, Class<T> cls, Parameter... parameterArr) throws PicoCompositionException {
        String str = (String) properties.remove("injectionFieldTypes");
        if (str == null) {
            str = "";
        }
        return wrapLifeCycle(componentMonitor.newInjector(new TypedFieldInjector(obj, cls, parameterArr, componentMonitor, str)), lifecycleStrategy);
    }

    public static Properties injectionFieldTypes(String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(" ");
            sb.append(str);
        }
        return Characteristics.immutable("injectionFieldTypes", sb.toString().trim());
    }
}
