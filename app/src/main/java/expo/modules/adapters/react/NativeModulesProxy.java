package expo.modules.adapters.react;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import expo.modules.core.ModuleRegistry;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.ExpoModulesHelper;
import expo.modules.kotlin.KPromiseWrapper;
import expo.modules.kotlin.KotlinInteropModuleRegistry;
import expo.modules.kotlin.ModulesProvider;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class NativeModulesProxy extends ReactContextBaseJavaModule {
    private static final String EXPORTED_METHODS_KEY = "exportedMethods";
    private static final String MODULES_CONSTANTS_KEY = "modulesConstants";
    private static final String NAME = "NativeUnimoduleProxy";
    private static final String UNDEFINED_METHOD_ERROR = "E_UNDEFINED_METHOD";
    private static final String VIEW_MANAGERS_METADATA_KEY = "viewManagersMetadata";
    private Map<String, Object> cachedConstants;
    private KotlinInteropModuleRegistry mKotlinInteropModuleRegistry;
    private ModuleRegistry mModuleRegistry;

    public NativeModulesProxy(ReactApplicationContext reactApplicationContext, ModuleRegistry moduleRegistry) {
        super(reactApplicationContext);
        this.mModuleRegistry = moduleRegistry;
        ModulesProvider modulesProvider = ExpoModulesHelper.INSTANCE.getModulesProvider();
        Objects.requireNonNull(modulesProvider);
        this.mKotlinInteropModuleRegistry = new KotlinInteropModuleRegistry(modulesProvider, moduleRegistry, new WeakReference(reactApplicationContext));
    }

    public NativeModulesProxy(ReactApplicationContext reactApplicationContext, ModuleRegistry moduleRegistry, ModulesProvider modulesProvider) {
        super(reactApplicationContext);
        this.mModuleRegistry = moduleRegistry;
        Objects.requireNonNull(modulesProvider);
        this.mKotlinInteropModuleRegistry = new KotlinInteropModuleRegistry(modulesProvider, moduleRegistry, new WeakReference(reactApplicationContext));
    }

    public KotlinInteropModuleRegistry getKotlinInteropModuleRegistry() {
        return this.mKotlinInteropModuleRegistry;
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @Nullable
    public Map<String, Object> getConstants() {
        Map<String, Object> map = this.cachedConstants;
        if (map != null) {
            return map;
        }
        this.mModuleRegistry.ensureIsInitialized();
        KotlinInteropModuleRegistry kotlinInteropModuleRegistry = getKotlinInteropModuleRegistry();
        kotlinInteropModuleRegistry.installJSIInterop();
        kotlinInteropModuleRegistry.emitOnCreate();
        HashMap map2 = new HashMap(3);
        map2.put(MODULES_CONSTANTS_KEY, new HashMap());
        map2.put(EXPORTED_METHODS_KEY, new HashMap());
        map2.put(VIEW_MANAGERS_METADATA_KEY, this.mKotlinInteropModuleRegistry.viewManagersMetadata());
        CoreLoggerKt.getLogger().info("✅ Constants were exported");
        this.cachedConstants = map2;
        return map2;
    }

    @ReactMethod
    public void callMethod(String str, String str2, ReadableArray readableArray, Promise promise) {
        if (this.mKotlinInteropModuleRegistry.hasModule(str)) {
            this.mKotlinInteropModuleRegistry.callMethod(str, str2, readableArray, new KPromiseWrapper(promise));
            return;
        }
        promise.reject(UNDEFINED_METHOD_ERROR, "Method " + str2 + " of Java module " + str + " is undefined.");
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        this.mModuleRegistry.onDestroy();
        this.mKotlinInteropModuleRegistry.onDestroy();
    }

    ModuleRegistry getModuleRegistry() {
        return this.mModuleRegistry;
    }

    ReactApplicationContext getReactContext() {
        return getReactApplicationContext();
    }
}
