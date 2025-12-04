package com.facebook.react.devsupport;

import android.app.Activity;
import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.interfaces.TaskInterface;

/* loaded from: classes3.dex */
public interface ReactInstanceDevHelper {
    @Nullable
    View createRootView(String str);

    void destroyRootView(View view);

    @Nullable
    Activity getCurrentActivity();

    @Nullable
    ReactContext getCurrentReactContext();

    JavaScriptExecutorFactory getJavaScriptExecutorFactory();

    TaskInterface<Boolean> loadBundle(JSBundleLoader jSBundleLoader);

    void onJSBundleLoadedFromServer();

    void reload(String str);

    void toggleElementInspector();
}
