package expo.modules.core.interfaces;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.devsupport.interfaces.DevSupportManager;

/* JADX INFO: loaded from: classes5.dex */
public interface ReactNativeHostHandler {
    @Nullable
    default String getBundleAssetName(boolean z) {
        return null;
    }

    @Nullable
    default Object getDevSupportManagerFactory() {
        return null;
    }

    @Nullable
    default String getJSBundleFile(boolean z) {
        return null;
    }

    @Nullable
    default JavaScriptExecutorFactory getJavaScriptExecutorFactory() {
        return null;
    }

    @Nullable
    default Boolean getUseDeveloperSupport() {
        return null;
    }

    default void onDidCreateDevSupportManager(@NonNull DevSupportManager devSupportManager) {
    }

    default void onDidCreateReactInstance(boolean z, ReactContext reactContext) {
    }

    default void onReactInstanceException(boolean z, @NonNull Exception exc) {
    }

    default void onWillCreateReactInstance(boolean z) {
    }
}
