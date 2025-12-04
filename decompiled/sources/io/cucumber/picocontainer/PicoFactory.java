package io.cucumber.picocontainer;

import cucumber.runtime.Utils;
import io.cucumber.core.backend.ObjectFactory;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apiguardian.api.API;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.PicoBuilder;

@API(status = API.Status.STABLE)
/* loaded from: classes5.dex */
public final class PicoFactory implements ObjectFactory {
    private final Set classes = new HashSet();
    private MutablePicoContainer pico;

    @Override // io.cucumber.core.backend.ObjectFactory
    public void start() {
        this.pico = new PicoBuilder().withCaching().withLifecycle().build();
        Iterator it = this.classes.iterator();
        while (it.hasNext()) {
            this.pico.addComponent((Class) it.next());
        }
        this.pico.start();
    }

    @Override // io.cucumber.core.backend.ObjectFactory
    public void stop() {
        this.pico.stop();
        this.pico.dispose();
    }

    @Override // io.cucumber.core.backend.ObjectFactory
    public boolean addClass(Class<?> cls) throws SecurityException {
        if (!Utils.isInstantiable(cls) || !this.classes.add(cls)) {
            return true;
        }
        addConstructorDependencies(cls);
        return true;
    }

    @Override // io.cucumber.core.backend.ObjectFactory
    public <T> T getInstance(Class<T> cls) {
        return (T) this.pico.getComponent((Class) cls);
    }

    private void addConstructorDependencies(Class cls) throws SecurityException {
        for (Constructor<?> constructor : cls.getConstructors()) {
            for (Class<?> cls2 : constructor.getParameterTypes()) {
                addClass(cls2);
            }
        }
    }
}
