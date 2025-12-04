package cucumber.runtime.java;

import cucumber.api.java.ObjectFactory;
import cucumber.runtime.CucumberException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
class DefaultJavaObjectFactory implements ObjectFactory {
    private final Map instances = new HashMap();

    @Override // cucumber.api.java.ObjectFactory
    public boolean addClass(Class cls) {
        return true;
    }

    @Override // cucumber.api.java.ObjectFactory
    public void start() {
    }

    DefaultJavaObjectFactory() {
    }

    @Override // cucumber.api.java.ObjectFactory
    public void stop() {
        this.instances.clear();
    }

    @Override // cucumber.api.java.ObjectFactory
    public Object getInstance(Class cls) {
        Object objCast = cls.cast(this.instances.get(cls));
        return objCast == null ? cacheNewInstance(cls) : objCast;
    }

    private Object cacheNewInstance(Class cls) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objNewInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            this.instances.put(cls, objNewInstance);
            return objNewInstance;
        } catch (NoSuchMethodException e) {
            throw new CucumberException(String.format("%s doesn't have an empty constructor. If you need DI, put cucumber-picocontainer on the classpath", cls), e);
        } catch (Exception e2) {
            throw new CucumberException(String.format("Failed to instantiate %s", cls), e2);
        }
    }
}
