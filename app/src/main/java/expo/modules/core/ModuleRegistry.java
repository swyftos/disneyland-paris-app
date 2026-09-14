package expo.modules.core;

import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.RegistryLifecycleListener;
import expo.modules.core.interfaces.SingletonModule;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class ModuleRegistry {
    private final Map mInternalModulesMap = new HashMap();
    private final Map mSingletonModulesMap = new HashMap();
    private final List mExtraRegistryLifecycleListeners = new ArrayList();
    private volatile boolean mIsInitialized = false;

    public ModuleRegistry(Collection<InternalModule> collection, Collection<SingletonModule> collection2) {
        Iterator<InternalModule> it = collection.iterator();
        while (it.hasNext()) {
            registerInternalModule(it.next());
        }
        Iterator<SingletonModule> it2 = collection2.iterator();
        while (it2.hasNext()) {
            registerSingletonModule(it2.next());
        }
    }

    public <T> T getModule(Class<T> cls) {
        return (T) this.mInternalModulesMap.get(cls);
    }

    public <T> T getSingletonModule(String str, Class<T> cls) {
        return (T) this.mSingletonModulesMap.get(str);
    }

    public void registerInternalModule(InternalModule internalModule) {
        Iterator<? extends Class> it = internalModule.getExportedInterfaces().iterator();
        while (it.hasNext()) {
            this.mInternalModulesMap.put(it.next(), internalModule);
        }
    }

    public InternalModule unregisterInternalModule(Class cls) {
        return (InternalModule) this.mInternalModulesMap.remove(cls);
    }

    public void registerSingletonModule(SingletonModule singletonModule) {
        this.mSingletonModulesMap.put(singletonModule.getName(), singletonModule);
    }

    public void registerExtraListener(RegistryLifecycleListener registryLifecycleListener) {
        this.mExtraRegistryLifecycleListeners.add(new WeakReference(registryLifecycleListener));
    }

    public synchronized void ensureIsInitialized() {
        if (!this.mIsInitialized) {
            initialize();
            this.mIsInitialized = true;
        }
    }

    public void initialize() {
        ArrayList arrayList = new ArrayList(this.mInternalModulesMap.values());
        Iterator it = this.mExtraRegistryLifecycleListeners.iterator();
        while (it.hasNext()) {
            RegistryLifecycleListener registryLifecycleListener = (RegistryLifecycleListener) ((WeakReference) it.next()).get();
            if (registryLifecycleListener != null) {
                arrayList.add(registryLifecycleListener);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((RegistryLifecycleListener) it2.next()).onCreate(this);
        }
    }

    public void onDestroy() {
        ArrayList arrayList = new ArrayList(this.mInternalModulesMap.values());
        Iterator it = this.mExtraRegistryLifecycleListeners.iterator();
        while (it.hasNext()) {
            RegistryLifecycleListener registryLifecycleListener = (RegistryLifecycleListener) ((WeakReference) it.next()).get();
            if (registryLifecycleListener != null) {
                arrayList.add(registryLifecycleListener);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((RegistryLifecycleListener) it2.next()).onDestroy();
        }
    }
}
