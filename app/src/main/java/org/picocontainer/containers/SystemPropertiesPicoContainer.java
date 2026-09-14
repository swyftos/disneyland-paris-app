package org.picocontainer.containers;

import org.picocontainer.PicoContainer;

/* JADX INFO: loaded from: classes5.dex */
public class SystemPropertiesPicoContainer extends PropertiesPicoContainer {
    public SystemPropertiesPicoContainer() {
        this(null);
    }

    public SystemPropertiesPicoContainer(PicoContainer picoContainer) {
        super(System.getProperties(), picoContainer);
    }

    @Override // org.picocontainer.containers.PropertiesPicoContainer, org.picocontainer.containers.AbstractDelegatingPicoContainer
    public String toString() {
        return "[SysProps]:" + super.getDelegate().toString();
    }
}
