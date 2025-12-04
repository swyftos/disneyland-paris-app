package org.picocontainer.containers;

import java.util.Properties;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.Parameter;
import org.picocontainer.PicoContainer;

/* loaded from: classes6.dex */
public class PropertiesPicoContainer extends AbstractDelegatingPicoContainer {
    public PropertiesPicoContainer(Properties properties, PicoContainer picoContainer) {
        super(new DefaultPicoContainer(picoContainer));
        for (Object obj : properties.keySet()) {
            ((MutablePicoContainer) getDelegate()).addComponent(obj, properties.get(obj), new Parameter[0]);
        }
    }

    public PropertiesPicoContainer(Properties properties) {
        this(properties, null);
    }

    public void setName(String str) {
        ((DefaultPicoContainer) getDelegate()).setName(str);
    }

    @Override // org.picocontainer.containers.AbstractDelegatingPicoContainer
    public String toString() {
        return "[Properties]:" + super.getDelegate().toString();
    }
}
