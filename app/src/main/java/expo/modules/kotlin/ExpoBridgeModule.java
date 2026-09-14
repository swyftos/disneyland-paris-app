package expo.modules.kotlin;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import expo.modules.adapters.react.NativeModulesProxy;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0007J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0014H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m1836d2 = {"Lexpo/modules/kotlin/ExpoBridgeModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "nativeModulesProxy", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/adapters/react/NativeModulesProxy;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/lang/ref/WeakReference;)V", "getName", "", "installModules", "", "tryWaitSync", "", "waitMs", "", "retries", "", "predicate", "Lkotlin/Function0;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ExpoBridgeModule extends ReactContextBaseJavaModule {

    @NotNull
    private final WeakReference<NativeModulesProxy> nativeModulesProxy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoBridgeModule(@NotNull ReactApplicationContext reactContext, @NotNull WeakReference<NativeModulesProxy> nativeModulesProxy) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(nativeModulesProxy, "nativeModulesProxy");
        this.nativeModulesProxy = nativeModulesProxy;
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "ExpoModulesCore";
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final boolean installModules() throws InterruptedException {
        KotlinInteropModuleRegistry kotlinInteropModuleRegistry;
        tryWaitSync(100L, 10, new Function0() { // from class: expo.modules.kotlin.ExpoBridgeModule$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ExpoBridgeModule.installModules$lambda$0(this.f$0));
            }
        });
        NativeModulesProxy nativeModulesProxy = this.nativeModulesProxy.get();
        if (nativeModulesProxy == null || (kotlinInteropModuleRegistry = nativeModulesProxy.getKotlinInteropModuleRegistry()) == null) {
            throw new IllegalStateException("Couldn't find KotlinInteropModuleRegistry");
        }
        kotlinInteropModuleRegistry.installJSIInterop();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean installModules$lambda$0(ExpoBridgeModule expoBridgeModule) {
        return expoBridgeModule.getReactApplicationContext().hasActiveReactInstance();
    }

    private final void tryWaitSync(long waitMs, int retries, Function0<Boolean> predicate) throws InterruptedException {
        for (int i = 0; i < retries && !predicate.invoke().booleanValue(); i++) {
            Thread.sleep(waitMs);
        }
    }
}
