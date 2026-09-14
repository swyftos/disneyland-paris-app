package expo.modules.core.interfaces;

import android.content.Context;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface Package {
    default List<? extends InternalModule> createInternalModules(Context context) {
        return Collections.emptyList();
    }

    default List<? extends SingletonModule> createSingletonModules(Context context) {
        return Collections.emptyList();
    }

    default List<? extends ApplicationLifecycleListener> createApplicationLifecycleListeners(Context context) {
        return Collections.emptyList();
    }

    default List<? extends ReactNativeHostHandler> createReactNativeHostHandlers(Context context) {
        return Collections.emptyList();
    }

    default List<? extends ReactActivityLifecycleListener> createReactActivityLifecycleListeners(Context context) {
        return Collections.emptyList();
    }

    default List<? extends ReactActivityHandler> createReactActivityHandlers(Context context) {
        return Collections.emptyList();
    }
}
