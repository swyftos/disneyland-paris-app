package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.soloader.SoLoader;
import com.urbanairship.reactnative.ReactMessageView;
import expo.modules.core.interfaces.DoNotStrip;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.ModuleRegistry;
import expo.modules.kotlin.RuntimeContext;
import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.defaultmodules.CoreModule;
import expo.modules.kotlin.exception.JavaScriptEvaluateException;
import expo.modules.kotlin.sharedobjects.ClassRegistry;
import expo.modules.kotlin.sharedobjects.SharedObject;
import expo.modules.kotlin.sharedobjects.SharedObjectId;
import expo.modules.kotlin.sharedobjects.SharedObjectRegistry;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 <2\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001<B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u000f\u001a\u00020\u000eH\u0082 J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u001e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019J!\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0082 J!\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0082 J\u0011\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0086 J\t\u0010 \u001a\u00020!H\u0086 J\t\u0010\"\u001a\u00020!H\u0086 J\t\u0010#\u001a\u00020\u0011H\u0086 J\u0019\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020!H\u0086 J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u001fH\u0007J\u0010\u0010+\u001a\u00020,2\u0006\u0010*\u001a\u00020\u001fH\u0007J\u0013\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001f0.H\u0007¢\u0006\u0002\u0010/J\u0018\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u0002022\u0006\u0010'\u001a\u00020!H\u0007J\u0012\u00103\u001a\u0004\u0018\u00010!2\u0006\u0010%\u001a\u00020&H\u0007J\u0010\u00104\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&H\u0007J\u001c\u00105\u001a\u00020\u00112\n\u00101\u001a\u0006\u0012\u0002\b\u0003062\u0006\u0010'\u001a\u00020!H\u0007J\u0016\u00107\u001a\u0004\u0018\u00010!2\n\u00101\u001a\u0006\u0012\u0002\b\u000306H\u0007J\n\u00108\u001a\u0004\u0018\u00010)H\u0007J\b\u00109\u001a\u00020\u0011H\u0004J\b\u0010:\u001a\u00020\u0011H\u0016J\b\u0010;\u001a\u00020\u0011H\u0016R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006="}, m1836d2 = {"Lexpo/modules/kotlin/jni/JSIContext;", "Lexpo/modules/kotlin/jni/Destructible;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "<init>", "()V", "runtimeContextHolder", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/kotlin/RuntimeContext;", "getRuntimeContextHolder", "()Ljava/lang/ref/WeakReference;", "setRuntimeContextHolder", "(Ljava/lang/ref/WeakReference;)V", "mHybridData", "Lcom/facebook/jni/HybridData;", "initHybrid", "installJSI", "", "runtimeContext", "jsRuntimePointer", "", "jsInvokerHolder", "Lcom/facebook/react/turbomodule/core/CallInvokerHolderImpl;", "installJSIForBridgeless", "runtimeExecutor", "Lcom/facebook/react/bridge/RuntimeExecutor;", "jniDeallocator", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "evaluateScript", "Lexpo/modules/kotlin/jni/JavaScriptValue;", "script", "", "global", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "createObject", "drainJSEventLoop", "setNativeStateForSharedObject", "id", "", "js", "getJavaScriptModuleObject", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "name", "hasModule", "", "getJavaScriptModulesName", "", "()[Ljava/lang/String;", "registerSharedObject", "native", "", "getSharedObject", "deleteSharedObject", "registerClass", "Ljava/lang/Class;", "getJavascriptClass", "getCoreModuleObject", "finalize", "deallocate", ReactMessageView.EVENT_CLOSE, "Companion", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@DoNotStrip
@SourceDebugExtension({"SMAP\nJSIContext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JSIContext.kt\nexpo/modules/kotlin/jni/JSIContext\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,195:1\n37#2,2:196\n*S KotlinDebug\n*F\n+ 1 JSIContext.kt\nexpo/modules/kotlin/jni/JSIContext\n*L\n124#1:196,2\n*E\n"})
public final class JSIContext implements Destructible, AutoCloseable {

    @DoNotStrip
    @NotNull
    private final HybridData mHybridData = initHybrid();
    public WeakReference<RuntimeContext> runtimeContextHolder;

    private final native HybridData initHybrid();

    private final native void installJSI(long jsRuntimePointer, JNIDeallocator jniDeallocator, CallInvokerHolderImpl jsInvokerHolder);

    private final native void installJSIForBridgeless(long jsRuntimePointer, JNIDeallocator jniDeallocator, RuntimeExecutor runtimeExecutor);

    @NotNull
    public final native JavaScriptObject createObject();

    public final native void drainJSEventLoop();

    @NotNull
    public final native JavaScriptValue evaluateScript(@NotNull String script) throws JavaScriptEvaluateException;

    @NotNull
    public final native JavaScriptObject global();

    public final native void setNativeStateForSharedObject(int id, @NotNull JavaScriptObject js);

    @NotNull
    public final WeakReference<RuntimeContext> getRuntimeContextHolder() {
        WeakReference<RuntimeContext> weakReference = this.runtimeContextHolder;
        if (weakReference != null) {
            return weakReference;
        }
        Intrinsics.throwUninitializedPropertyAccessException("runtimeContextHolder");
        return null;
    }

    public final void setRuntimeContextHolder(@NotNull WeakReference<RuntimeContext> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.runtimeContextHolder = weakReference;
    }

    public final void installJSI(@NotNull RuntimeContext runtimeContext, long jsRuntimePointer, @NotNull CallInvokerHolderImpl jsInvokerHolder) {
        Intrinsics.checkNotNullParameter(runtimeContext, "runtimeContext");
        Intrinsics.checkNotNullParameter(jsInvokerHolder, "jsInvokerHolder");
        setRuntimeContextHolder(UtilsKt.weak(runtimeContext));
        installJSI(jsRuntimePointer, runtimeContext.getJniDeallocator(), jsInvokerHolder);
    }

    public final void installJSIForBridgeless(@NotNull RuntimeContext runtimeContext, long jsRuntimePointer, @NotNull RuntimeExecutor runtimeExecutor) {
        Intrinsics.checkNotNullParameter(runtimeContext, "runtimeContext");
        Intrinsics.checkNotNullParameter(runtimeExecutor, "runtimeExecutor");
        setRuntimeContextHolder(UtilsKt.weak(runtimeContext));
        installJSIForBridgeless(jsRuntimePointer, runtimeContext.getJniDeallocator(), runtimeExecutor);
    }

    @DoNotStrip
    @Nullable
    public final JavaScriptModuleObject_ getJavaScriptModuleObject(@NotNull String name) {
        ModuleRegistry registry;
        ModuleHolder<?> moduleHolder;
        Intrinsics.checkNotNullParameter(name, "name");
        RuntimeContext runtimeContext = getRuntimeContextHolder().get();
        if (runtimeContext == null || (registry = runtimeContext.getRegistry()) == null || (moduleHolder = registry.getModuleHolder(name)) == null) {
            return null;
        }
        return moduleHolder.getJsObject();
    }

    @DoNotStrip
    public final boolean hasModule(@NotNull String name) {
        ModuleRegistry registry;
        Intrinsics.checkNotNullParameter(name, "name");
        RuntimeContext runtimeContext = getRuntimeContextHolder().get();
        if (runtimeContext == null || (registry = runtimeContext.getRegistry()) == null) {
            return false;
        }
        return registry.hasModule(name);
    }

    @DoNotStrip
    @NotNull
    public final String[] getJavaScriptModulesName() {
        ModuleRegistry registry;
        Map<String, ModuleHolder<?>> registry2;
        Set<String> setKeySet;
        String[] strArr;
        RuntimeContext runtimeContext = getRuntimeContextHolder().get();
        return (runtimeContext == null || (registry = runtimeContext.getRegistry()) == null || (registry2 = registry.getRegistry()) == null || (setKeySet = registry2.keySet()) == null || (strArr = (String[]) setKeySet.toArray(new String[0])) == null) ? new String[0] : strArr;
    }

    @DoNotStrip
    public final void registerSharedObject(@NotNull Object obj, @NotNull JavaScriptObject js) {
        SharedObjectRegistry sharedObjectRegistry;
        Intrinsics.checkNotNullParameter(obj, "native");
        Intrinsics.checkNotNullParameter(js, "js");
        RuntimeContext runtimeContext = getRuntimeContextHolder().get();
        if (runtimeContext == null || (sharedObjectRegistry = runtimeContext.getSharedObjectRegistry()) == null) {
            return;
        }
        SharedObjectId.m5243boximpl(sharedObjectRegistry.m5256add5WKnsLU$expo_modules_core_release((SharedObject) obj, js));
    }

    @DoNotStrip
    @Nullable
    public final JavaScriptObject getSharedObject(int id) {
        RuntimeContext runtimeContext = getRuntimeContextHolder().get();
        if (runtimeContext == null) {
            return null;
        }
        return SharedObjectId.m5248toJavaScriptObjectNullimpl(SharedObjectId.m5244constructorimpl(id), runtimeContext);
    }

    @DoNotStrip
    public final void deleteSharedObject(int id) {
        SharedObjectRegistry sharedObjectRegistry;
        RuntimeContext runtimeContext = getRuntimeContextHolder().get();
        if (runtimeContext == null || (sharedObjectRegistry = runtimeContext.getSharedObjectRegistry()) == null) {
            return;
        }
        sharedObjectRegistry.m5257deletekyJHjyY$expo_modules_core_release(SharedObjectId.m5244constructorimpl(id));
    }

    @DoNotStrip
    public final void registerClass(@NotNull Class<?> cls, @NotNull JavaScriptObject js) {
        ClassRegistry classRegistry;
        Intrinsics.checkNotNullParameter(cls, "native");
        Intrinsics.checkNotNullParameter(js, "js");
        RuntimeContext runtimeContext = getRuntimeContextHolder().get();
        if (runtimeContext == null || (classRegistry = runtimeContext.getClassRegistry()) == null) {
            return;
        }
        classRegistry.add$expo_modules_core_release(cls, js);
    }

    @DoNotStrip
    @Nullable
    public final JavaScriptObject getJavascriptClass(@NotNull Class<?> cls) {
        ClassRegistry classRegistry;
        Intrinsics.checkNotNullParameter(cls, "native");
        RuntimeContext runtimeContext = getRuntimeContextHolder().get();
        if (runtimeContext == null || (classRegistry = runtimeContext.getClassRegistry()) == null) {
            return null;
        }
        return classRegistry.toJavaScriptObject$expo_modules_core_release(cls);
    }

    @DoNotStrip
    @Nullable
    public final JavaScriptModuleObject_ getCoreModuleObject() {
        ModuleHolder<CoreModule> coreModule$expo_modules_core_release;
        RuntimeContext runtimeContext = getRuntimeContextHolder().get();
        if (runtimeContext == null || (coreModule$expo_modules_core_release = runtimeContext.getCoreModule$expo_modules_core_release()) == null) {
            return null;
        }
        return coreModule$expo_modules_core_release.getJsObject();
    }

    protected final void finalize() throws Throwable {
        deallocate();
    }

    @Override // expo.modules.kotlin.jni.Destructible
    public void deallocate() {
        this.mHybridData.resetNative();
    }

    static {
        SoLoader.loadLibrary("expo-modules-core");
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        deallocate();
    }
}
