package expo.modules.kotlin;

import androidx.tracing.Trace;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import expo.modules.core.logging.Logger;
import expo.modules.kotlin.defaultmodules.CoreModule;
import expo.modules.kotlin.jni.JNIDeallocator;
import expo.modules.kotlin.jni.JSIContext;
import expo.modules.kotlin.jni.JavaScriptValue;
import expo.modules.kotlin.sharedobjects.ClassRegistry;
import expo.modules.kotlin.sharedobjects.SharedObjectRegistry;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u000203R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00068Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020/X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u00065"}, m1836d2 = {"Lexpo/modules/kotlin/RuntimeContext;", "", "appContext", "Lexpo/modules/kotlin/AppContext;", "reactContextHolder", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lexpo/modules/kotlin/AppContext;Ljava/lang/ref/WeakReference;)V", "getReactContextHolder", "()Ljava/lang/ref/WeakReference;", "appContextHolder", "getAppContext", "()Lexpo/modules/kotlin/AppContext;", "reactContext", "getReactContext", "()Lcom/facebook/react/bridge/ReactApplicationContext;", "registry", "Lexpo/modules/kotlin/ModuleRegistry;", "getRegistry", "()Lexpo/modules/kotlin/ModuleRegistry;", "jsiContext", "Lexpo/modules/kotlin/jni/JSIContext;", "getJsiContext$expo_modules_core_release", "()Lexpo/modules/kotlin/jni/JSIContext;", "setJsiContext$expo_modules_core_release", "(Lexpo/modules/kotlin/jni/JSIContext;)V", "isJSIContextInitialized", "", "eval", "Lexpo/modules/kotlin/jni/JavaScriptValue;", "source", "", "coreModule", "Lexpo/modules/kotlin/ModuleHolder;", "Lexpo/modules/kotlin/defaultmodules/CoreModule;", "getCoreModule$expo_modules_core_release", "()Lexpo/modules/kotlin/ModuleHolder;", "jniDeallocator", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "getJniDeallocator", "()Lexpo/modules/kotlin/jni/JNIDeallocator;", "sharedObjectRegistry", "Lexpo/modules/kotlin/sharedobjects/SharedObjectRegistry;", "getSharedObjectRegistry$expo_modules_core_release", "()Lexpo/modules/kotlin/sharedobjects/SharedObjectRegistry;", "classRegistry", "Lexpo/modules/kotlin/sharedobjects/ClassRegistry;", "getClassRegistry$expo_modules_core_release", "()Lexpo/modules/kotlin/sharedobjects/ClassRegistry;", "installJSIContext", "", "deallocate", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nRuntimeContext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RuntimeContext.kt\nexpo/modules/kotlin/RuntimeContext\n+ 2 ExpoTrace.kt\nexpo/modules/kotlin/tracing/ExpoTraceKt\n+ 3 Trace.kt\nandroidx/tracing/TraceKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 KotlinUtilities.kt\nexpo/modules/core/utilities/KotlinUtilitiesKt\n*L\n1#1,112:1\n14#2:113\n25#2:114\n27#3,3:115\n31#3:120\n1#4:118\n12#5:119\n*S KotlinDebug\n*F\n+ 1 RuntimeContext.kt\nexpo/modules/kotlin/RuntimeContext\n*L\n74#1:113\n74#1:114\n74#1:115,3\n74#1:120\n80#1:119\n*E\n"})
public final class RuntimeContext {
    private final WeakReference appContextHolder;
    private final ClassRegistry classRegistry;
    private final ModuleHolder coreModule;
    private final JNIDeallocator jniDeallocator;
    public JSIContext jsiContext;
    private final WeakReference reactContextHolder;
    private final ModuleRegistry registry;
    private final SharedObjectRegistry sharedObjectRegistry;

    public RuntimeContext(@NotNull AppContext appContext, @NotNull WeakReference<ReactApplicationContext> reactContextHolder) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(reactContextHolder, "reactContextHolder");
        this.reactContextHolder = reactContextHolder;
        this.appContextHolder = UtilsKt.weak(appContext);
        this.registry = new ModuleRegistry(UtilsKt.weak(this));
        CoreModule coreModule = new CoreModule();
        coreModule.set_runtimeContext$expo_modules_core_release(this);
        this.coreModule = new ModuleHolder(coreModule);
        this.jniDeallocator = new JNIDeallocator(false, 1, null);
        this.sharedObjectRegistry = new SharedObjectRegistry(this);
        this.classRegistry = new ClassRegistry();
    }

    @NotNull
    public final WeakReference<ReactApplicationContext> getReactContextHolder() {
        return this.reactContextHolder;
    }

    @Nullable
    public final AppContext getAppContext() {
        return (AppContext) this.appContextHolder.get();
    }

    @Nullable
    public final ReactApplicationContext getReactContext() {
        return getReactContextHolder().get();
    }

    @NotNull
    public final ModuleRegistry getRegistry() {
        return this.registry;
    }

    @NotNull
    public final JSIContext getJsiContext$expo_modules_core_release() {
        JSIContext jSIContext = this.jsiContext;
        if (jSIContext != null) {
            return jSIContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("jsiContext");
        return null;
    }

    public final void setJsiContext$expo_modules_core_release(@NotNull JSIContext jSIContext) {
        Intrinsics.checkNotNullParameter(jSIContext, "<set-?>");
        this.jsiContext = jSIContext;
    }

    private final boolean isJSIContextInitialized() {
        return this.jsiContext != null;
    }

    @NotNull
    public final JavaScriptValue eval(@NotNull String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return getJsiContext$expo_modules_core_release().evaluateScript(source);
    }

    @NotNull
    public final ModuleHolder<CoreModule> getCoreModule$expo_modules_core_release() {
        return this.coreModule;
    }

    @NotNull
    public final JNIDeallocator getJniDeallocator() {
        return this.jniDeallocator;
    }

    @NotNull
    /* JADX INFO: renamed from: getSharedObjectRegistry$expo_modules_core_release, reason: from getter */
    public final SharedObjectRegistry getSharedObjectRegistry() {
        return this.sharedObjectRegistry;
    }

    @NotNull
    /* JADX INFO: renamed from: getClassRegistry$expo_modules_core_release, reason: from getter */
    public final ClassRegistry getClassRegistry() {
        return this.classRegistry;
    }

    public final void installJSIContext() {
        JavaScriptContextHolder javaScriptContextHolder;
        synchronized (this) {
            if (isJSIContextInitialized()) {
                Logger.warn$default(CoreLoggerKt.getLogger(), "⚠️ JSI interop was already installed", null, 2, null);
                return;
            }
            Trace.beginSection("[ExpoModulesCore] " + (this + ".installJSIContext"));
            try {
                try {
                    setJsiContext$expo_modules_core_release(new JSIContext());
                    ReactApplicationContext reactApplicationContext = getReactContextHolder().get();
                    if (reactApplicationContext != null && (javaScriptContextHolder = reactApplicationContext.getJavaScriptContextHolder()) != null) {
                        Long lValueOf = Long.valueOf(javaScriptContextHolder.get());
                        if (lValueOf.longValue() == 0) {
                            lValueOf = null;
                        }
                        if (lValueOf != null) {
                            long jLongValue = lValueOf.longValue();
                            if (reactApplicationContext.isBridgeless()) {
                                JSIContext jsiContext$expo_modules_core_release = getJsiContext$expo_modules_core_release();
                                RuntimeExecutor runtimeExecutor = reactApplicationContext.getCatalystInstance().getRuntimeExecutor();
                                Intrinsics.checkNotNull(runtimeExecutor);
                                jsiContext$expo_modules_core_release.installJSIForBridgeless(this, jLongValue, runtimeExecutor);
                            } else {
                                JSIContext jsiContext$expo_modules_core_release2 = getJsiContext$expo_modules_core_release();
                                CallInvokerHolder jSCallInvokerHolder = reactApplicationContext.getCatalystInstance().getJSCallInvokerHolder();
                                Intrinsics.checkNotNull(jSCallInvokerHolder, "null cannot be cast to non-null type com.facebook.react.turbomodule.core.CallInvokerHolderImpl");
                                jsiContext$expo_modules_core_release2.installJSI(this, jLongValue, (CallInvokerHolderImpl) jSCallInvokerHolder);
                            }
                            CoreLoggerKt.getLogger().info("✅ JSI interop was installed");
                        } else {
                            Logger.error$default(CoreLoggerKt.getLogger(), "❌ Cannot install JSI interop - JS runtime pointer is null", null, 2, null);
                        }
                    }
                } catch (Throwable th) {
                    CoreLoggerKt.getLogger().error("❌ Cannot install JSI interop: " + th, th);
                }
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
            } catch (Throwable th2) {
                Trace.endSection();
                throw th2;
            }
        }
    }

    public final void deallocate() {
        ((CoreModule) this.coreModule.getModule()).set_runtimeContext$expo_modules_core_release(null);
        this.jniDeallocator.deallocate$expo_modules_core_release();
    }
}
