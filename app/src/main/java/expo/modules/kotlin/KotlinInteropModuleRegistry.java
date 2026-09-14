package expo.modules.kotlin;

import androidx.tracing.Trace;
import com.amazonaws.services.p017s3.model.InstructionFileId;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ViewManager;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import expo.modules.adapters.react.NativeModulesProxy;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.modules.ModuleDefinitionBuilderKt;
import expo.modules.kotlin.views.GroupViewManagerWrapper;
import expo.modules.kotlin.views.SimpleViewManagerWrapper;
import expo.modules.kotlin.views.ViewManagerDefinition;
import expo.modules.kotlin.views.ViewManagerType;
import expo.modules.kotlin.views.ViewManagerWrapperDelegate;
import expo.modules.kotlin.views.ViewWrapperDelegateHolder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0014\u0010\u001f\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030!0 J\u001e\u0010\"\u001a\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010#0#J\"\u0010$\u001a\b\u0012\u0004\u0012\u00020%0 2\u0014\u0010&\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030!0 J\u0014\u0010'\u001a\u00020\u00182\f\u0010(\u001a\b\u0012\u0004\u0012\u00020%0 J\u0006\u0010)\u001a\u00020\u0018J\u0006\u0010*\u001a\u00020\u0018J\u0006\u0010+\u001a\u00020\u0018J\u000e\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020.R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006/"}, m1836d2 = {"Lexpo/modules/kotlin/KotlinInteropModuleRegistry;", "", "modulesProvider", "Lexpo/modules/kotlin/ModulesProvider;", "legacyModuleRegistry", "Lexpo/modules/core/ModuleRegistry;", "reactContext", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lexpo/modules/kotlin/ModulesProvider;Lexpo/modules/core/ModuleRegistry;Ljava/lang/ref/WeakReference;)V", "appContext", "Lexpo/modules/kotlin/AppContext;", "getAppContext", "()Lexpo/modules/kotlin/AppContext;", "registry", "Lexpo/modules/kotlin/ModuleRegistry;", "getRegistry", "()Lexpo/modules/kotlin/ModuleRegistry;", "hasModule", "", "name", "", "callMethod", "", "moduleName", TCEventPropertiesNames.TCE_METHOD, "arguments", "Lcom/facebook/react/bridge/ReadableArray;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "exportViewManagers", "", "Lcom/facebook/react/uimanager/ViewManager;", "viewManagersMetadata", "", "extractViewManagersDelegateHolders", "Lexpo/modules/kotlin/views/ViewWrapperDelegateHolder;", "viewManagers", "updateModuleHoldersInViewManagers", "viewWrapperHolders", "onDestroy", "installJSIInterop", "emitOnCreate", "setLegacyModulesProxy", "proxyModule", "Lexpo/modules/adapters/react/NativeModulesProxy;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nKotlinInteropModuleRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KotlinInteropModuleRegistry.kt\nexpo/modules/kotlin/KotlinInteropModuleRegistry\n+ 2 ExpoTrace.kt\nexpo/modules/kotlin/tracing/ExpoTraceKt\n+ 3 Trace.kt\nandroidx/tracing/TraceKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,114:1\n14#2:115\n25#2:116\n14#2:131\n25#2:132\n14#2:147\n25#2:148\n14#2:164\n25#2:165\n27#3,3:117\n31#3:130\n27#3,3:133\n31#3:146\n27#3,3:149\n31#3:163\n27#3,3:166\n31#3:175\n1368#4:120\n1454#4,2:121\n1456#4,3:127\n1368#4:136\n1454#4,2:137\n1456#4,3:143\n808#4,11:152\n1557#4:169\n1628#4,3:170\n1863#4,2:173\n126#5:123\n153#5,3:124\n126#5:139\n153#5,3:140\n*S KotlinDebug\n*F\n+ 1 KotlinInteropModuleRegistry.kt\nexpo/modules/kotlin/KotlinInteropModuleRegistry\n*L\n44#1:115\n44#1:116\n58#1:131\n58#1:132\n74#1:147\n74#1:148\n87#1:164\n87#1:165\n44#1:117,3\n44#1:130\n58#1:133,3\n58#1:146\n74#1:149,3\n74#1:163\n87#1:166,3\n87#1:175\n46#1:120\n46#1:121,2\n46#1:127,3\n59#1:136\n59#1:137,2\n59#1:143,3\n75#1:152,11\n89#1:169\n89#1:170,3\n90#1:173,2\n47#1:123\n47#1:124,3\n60#1:139\n60#1:140,3\n*E\n"})
public final class KotlinInteropModuleRegistry {
    private final AppContext appContext;

    @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ViewManagerType.values().length];
            try {
                iArr[ViewManagerType.SIMPLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ViewManagerType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public KotlinInteropModuleRegistry(@NotNull ModulesProvider modulesProvider, @NotNull expo.modules.core.ModuleRegistry legacyModuleRegistry, @NotNull WeakReference<ReactApplicationContext> reactContext) {
        Intrinsics.checkNotNullParameter(modulesProvider, "modulesProvider");
        Intrinsics.checkNotNullParameter(legacyModuleRegistry, "legacyModuleRegistry");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.appContext = new AppContext(modulesProvider, legacyModuleRegistry, reactContext);
    }

    @NotNull
    public final AppContext getAppContext() {
        return this.appContext;
    }

    @NotNull
    public final List<ViewManager<?, ?>> exportViewManagers() {
        BaseViewManager simpleViewManagerWrapper;
        Trace.beginSection("[ExpoModulesCore] KotlinInteropModuleRegistry.exportViewManagers");
        try {
            ModuleRegistry registry = getRegistry();
            ArrayList arrayList = new ArrayList();
            for (ModuleHolder<?> moduleHolder : registry) {
                Map<String, ViewManagerDefinition> viewManagerDefinitions = moduleHolder.getDefinition().getViewManagerDefinitions();
                ArrayList arrayList2 = new ArrayList(viewManagerDefinitions.size());
                for (Map.Entry<String, ViewManagerDefinition> entry : viewManagerDefinitions.entrySet()) {
                    String key = entry.getKey();
                    ViewManagerDefinition value = entry.getValue();
                    ViewManagerWrapperDelegate viewManagerWrapperDelegate = new ViewManagerWrapperDelegate(moduleHolder, value, Intrinsics.areEqual(key, ModuleDefinitionBuilderKt.DEFAULT_MODULE_VIEW) ? moduleHolder.getName() : null);
                    int i = WhenMappings.$EnumSwitchMapping$0[value.getViewManagerType().ordinal()];
                    if (i == 1) {
                        simpleViewManagerWrapper = new SimpleViewManagerWrapper(viewManagerWrapperDelegate);
                    } else {
                        if (i != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        simpleViewManagerWrapper = new GroupViewManagerWrapper(viewManagerWrapperDelegate);
                    }
                    arrayList2.add(simpleViewManagerWrapper);
                }
                CollectionsKt.addAll(arrayList, arrayList2);
            }
            Trace.endSection();
            return arrayList;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @NotNull
    public final List<ViewWrapperDelegateHolder> extractViewManagersDelegateHolders(@NotNull List<? extends ViewManager<?, ?>> viewManagers) {
        Intrinsics.checkNotNullParameter(viewManagers, "viewManagers");
        Trace.beginSection("[ExpoModulesCore] KotlinInteropModuleRegistry.extractViewManagersDelegateHolders");
        try {
            ArrayList arrayList = new ArrayList();
            for (Object obj : viewManagers) {
                if (obj instanceof ViewWrapperDelegateHolder) {
                    arrayList.add(obj);
                }
            }
            Trace.endSection();
            return arrayList;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final void updateModuleHoldersInViewManagers(@NotNull List<? extends ViewWrapperDelegateHolder> viewWrapperHolders) {
        Intrinsics.checkNotNullParameter(viewWrapperHolders, "viewWrapperHolders");
        Trace.beginSection("[ExpoModulesCore] KotlinInteropModuleRegistry.updateModuleHoldersInViewManagers");
        try {
            ArrayList<ViewManagerWrapperDelegate> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(viewWrapperHolders, 10));
            Iterator<T> it = viewWrapperHolders.iterator();
            while (it.hasNext()) {
                arrayList.add(((ViewWrapperDelegateHolder) it.next()).getViewWrapperDelegate());
            }
            for (ViewManagerWrapperDelegate viewManagerWrapperDelegate : arrayList) {
                ModuleHolder<?> moduleHolder = getRegistry().getModuleHolder(viewManagerWrapperDelegate.getModuleHolder$expo_modules_core_release().getName());
                if (moduleHolder == null) {
                    throw new IllegalArgumentException(("Cannot update the module holder for " + viewManagerWrapperDelegate.getModuleHolder$expo_modules_core_release().getName() + InstructionFileId.DOT).toString());
                }
                viewManagerWrapperDelegate.setModuleHolder$expo_modules_core_release(moduleHolder);
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @NotNull
    public final Map<String, Map<String, Object>> viewManagersMetadata() {
        String name;
        Trace.beginSection("[ExpoModulesCore] KotlinInteropModuleRegistry.viewManagersMetadata");
        try {
            ModuleRegistry registry = getRegistry();
            ArrayList arrayList = new ArrayList();
            for (ModuleHolder<?> moduleHolder : registry) {
                Map<String, ViewManagerDefinition> viewManagerDefinitions = moduleHolder.getDefinition().getViewManagerDefinitions();
                ArrayList arrayList2 = new ArrayList(viewManagerDefinitions.size());
                for (Map.Entry<String, ViewManagerDefinition> entry : viewManagerDefinitions.entrySet()) {
                    String key = entry.getKey();
                    ViewManagerDefinition value = entry.getValue();
                    if (Intrinsics.areEqual(key, ModuleDefinitionBuilderKt.DEFAULT_MODULE_VIEW)) {
                        name = moduleHolder.getName();
                    } else {
                        name = moduleHolder.getName() + "_" + key;
                    }
                    arrayList2.add(TuplesKt.m1842to(name, MapsKt.mapOf(TuplesKt.m1842to("propsNames", value.getPropsNames()))));
                }
                CollectionsKt.addAll(arrayList, arrayList2);
            }
            return MapsKt.toMap(arrayList);
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ModuleRegistry getRegistry() {
        return this.appContext.getHostingRuntimeContext().getRegistry();
    }

    public final boolean hasModule(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getRegistry().hasModule(name);
    }

    public final void callMethod(@NotNull String moduleName, @NotNull String method, @NotNull ReadableArray arguments, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            ModuleHolder<?> moduleHolder = getRegistry().getModuleHolder(moduleName);
            if (moduleHolder == null) {
                throw new IllegalArgumentException(("Trying to call '" + method + "' on the non-existing module '" + moduleName + "'").toString());
            }
            Object[] array = arguments.toArrayList().toArray();
            Intrinsics.checkNotNullExpressionValue(array, "toArray(...)");
            moduleHolder.call(method, array, promise);
        } catch (CodedException e) {
            promise.reject(e);
        } catch (Throwable th) {
            promise.reject(new UnexpectedException(th));
        }
    }

    public final void onDestroy() {
        this.appContext.onDestroy$expo_modules_core_release();
        CoreLoggerKt.getLogger().info("✅ KotlinInteropModuleRegistry was destroyed");
    }

    public final void installJSIInterop() {
        this.appContext.installJSIInterop();
    }

    public final void emitOnCreate() {
        this.appContext.onCreate();
    }

    public final void setLegacyModulesProxy(@NotNull NativeModulesProxy proxyModule) {
        Intrinsics.checkNotNullParameter(proxyModule, "proxyModule");
        this.appContext.setLegacyModulesProxyHolder$expo_modules_core_release(new WeakReference<>(proxyModule));
    }
}
