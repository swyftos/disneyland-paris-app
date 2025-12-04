package org.picocontainer.injectors;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Properties;
import org.picocontainer.Characteristics;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;
import org.picocontainer.PicoVisitor;
import org.picocontainer.lifecycle.NullLifecycleStrategy;

/* loaded from: classes6.dex */
public class ProviderAdapter implements org.picocontainer.Injector, Provider, LifecycleStrategy {
    private final Class key;
    private LifecycleStrategy lifecycleStrategy;
    private Properties properties;
    private final Method provideMethod;
    private final Provider provider;

    @Override // org.picocontainer.ComponentAdapter
    public void accept(PicoVisitor picoVisitor) {
    }

    @Override // org.picocontainer.Injector
    public Object decorateComponentInstance(PicoContainer picoContainer, Type type, Object obj) {
        return null;
    }

    @Override // org.picocontainer.ComponentAdapter
    public ComponentAdapter findAdapterOfType(Class cls) {
        return null;
    }

    @Override // org.picocontainer.ComponentAdapter
    public ComponentAdapter getDelegate() {
        return null;
    }

    protected boolean useNames() {
        return false;
    }

    @Override // org.picocontainer.ComponentAdapter
    public void verify(PicoContainer picoContainer) throws PicoCompositionException {
    }

    protected ProviderAdapter() throws SecurityException {
        this.provider = this;
        Method provideMethod = getProvideMethod(getClass());
        this.provideMethod = provideMethod;
        this.key = provideMethod.getReturnType();
        setUseNames(useNames());
        this.lifecycleStrategy = new NullLifecycleStrategy();
    }

    public ProviderAdapter(LifecycleStrategy lifecycleStrategy, Provider provider) {
        this(lifecycleStrategy, provider, false);
    }

    public ProviderAdapter(Provider provider) {
        this(new NullLifecycleStrategy(), provider, false);
    }

    public ProviderAdapter(Provider provider, boolean z) {
        this(new NullLifecycleStrategy(), provider, z);
    }

    public ProviderAdapter(LifecycleStrategy lifecycleStrategy, Provider provider, boolean z) throws SecurityException {
        this.lifecycleStrategy = lifecycleStrategy;
        this.provider = provider;
        Method provideMethod = getProvideMethod(provider.getClass());
        this.provideMethod = provideMethod;
        this.key = provideMethod.getReturnType();
        setUseNames(z);
    }

    private void setUseNames(boolean z) {
        if (z) {
            this.properties = Characteristics.USE_NAMES;
        } else {
            this.properties = Characteristics.NONE;
        }
    }

    @Override // org.picocontainer.ComponentAdapter
    public Object getComponentKey() {
        return this.key;
    }

    @Override // org.picocontainer.ComponentAdapter
    public Class getComponentImplementation() {
        return this.key;
    }

    @Override // org.picocontainer.ComponentAdapter
    @Deprecated
    public Object getComponentInstance(PicoContainer picoContainer) throws PicoCompositionException {
        return getComponentInstance(picoContainer, ComponentAdapter.NOTHING.class);
    }

    @Override // org.picocontainer.ComponentAdapter
    public Object getComponentInstance(PicoContainer picoContainer, Type type) throws PicoCompositionException {
        return new Reinjector(picoContainer).reinject(this.key, this.provider.getClass(), this.provider, this.properties, new MethodInjection(this.provideMethod));
    }

    public static Method getProvideMethod(Class cls) throws SecurityException {
        Method method = null;
        for (Method method2 : cls.getDeclaredMethods()) {
            if (method2.getName().equals("provide")) {
                if (method != null) {
                    throw newProviderMethodException("only one");
                }
                method = method2;
            }
        }
        if (method == null) {
            throw newProviderMethodException(CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY);
        }
        if (method.getReturnType() != Void.TYPE) {
            return method;
        }
        throw newProviderMethodException("a non void returning");
    }

    private static PicoCompositionException newProviderMethodException(String str) {
        return new PicoCompositionException("There must be " + str + " method named 'provide' in the AbstractProvider implementation");
    }

    @Override // org.picocontainer.ComponentAdapter
    public String getDescriptor() {
        return "ProviderAdapter";
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void start(Object obj) {
        this.lifecycleStrategy.start(obj);
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void stop(Object obj) {
        this.lifecycleStrategy.stop(obj);
    }

    @Override // org.picocontainer.LifecycleStrategy
    public void dispose(Object obj) {
        this.lifecycleStrategy.dispose(obj);
    }

    @Override // org.picocontainer.LifecycleStrategy
    public boolean hasLifecycle(Class<?> cls) {
        return this.lifecycleStrategy.hasLifecycle(cls);
    }

    @Override // org.picocontainer.LifecycleStrategy
    public boolean isLazy(ComponentAdapter<?> componentAdapter) {
        return this.lifecycleStrategy.isLazy(componentAdapter);
    }
}
