package org.picocontainer.classname;

import java.net.URL;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.PicoContainer;

/* loaded from: classes6.dex */
public interface ClassLoadingPicoContainer extends MutablePicoContainer {
    ClassLoadingPicoContainer addChildContainer(String str, PicoContainer picoContainer);

    ClassPathElement addClassLoaderURL(URL url);

    ClassLoader getComponentClassLoader();

    ClassLoadingPicoContainer makeChildContainer(String str);
}
