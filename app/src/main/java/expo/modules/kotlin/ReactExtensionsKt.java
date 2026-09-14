package expo.modules.kotlin;

import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ThemedReactContext;
import expo.modules.adapters.react.NativeModulesProxy;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, m1836d2 = {"getUnimoduleProxy", "Lexpo/modules/adapters/react/NativeModulesProxy;", "Lcom/facebook/react/bridge/ReactContext;", "expo-modules-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nReactExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReactExtensions.kt\nexpo/modules/kotlin/ReactExtensionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,15:1\n1#2:16\n*E\n"})
public final class ReactExtensionsKt {
    @Nullable
    public static final NativeModulesProxy getUnimoduleProxy(@NotNull ReactContext reactContext) {
        NativeModule nativeModule;
        Object next;
        Intrinsics.checkNotNullParameter(reactContext, "<this>");
        if (!reactContext.isBridgeless()) {
            CatalystInstance catalystInstance = reactContext.getCatalystInstance();
            NativeModule nativeModule2 = catalystInstance != null ? catalystInstance.getNativeModule("NativeUnimoduleProxy") : null;
            if (nativeModule2 instanceof NativeModulesProxy) {
                return (NativeModulesProxy) nativeModule2;
            }
            return null;
        }
        Collection<NativeModule> nativeModules = ((ThemedReactContext) reactContext).getReactApplicationContext().getNativeModules();
        if (nativeModules != null) {
            Iterator<T> it = nativeModules.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((NativeModule) next) instanceof NativeModulesProxy));
            nativeModule = (NativeModule) next;
        } else {
            nativeModule = null;
        }
        if (nativeModule instanceof NativeModulesProxy) {
            return (NativeModulesProxy) nativeModule;
        }
        return null;
    }
}
