package com.contentsquare.rn.utils;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.UIManagerModule;

/* loaded from: classes3.dex */
public class ReactNativeViewFinder {

    @NonNull
    private final ReactNativeUiThreadUtil mReactNativeUiThreadUtil;

    public interface OnViewFoundListener {
        void onViewFound(@NonNull View view);
    }

    public interface OnWebViewFoundListener {
        void onWebViewFound(@NonNull WebView webView);
    }

    public ReactNativeViewFinder(@NonNull ReactNativeUiThreadUtil reactNativeUiThreadUtil) {
        this.mReactNativeUiThreadUtil = reactNativeUiThreadUtil;
    }

    public void findView(@NonNull ReactApplicationContext reactApplicationContext, int i, @NonNull OnViewFoundListener onViewFoundListener) {
        if (this.mReactNativeUiThreadUtil.isOnUiThread()) {
            UIManagerModule uIManagerModule = (UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class);
            if (uIManagerModule == null) {
                return;
            }
            try {
                onViewFoundListener.onViewFound(uIManagerModule.resolveView(i));
                return;
            } catch (IllegalViewOperationException | NullPointerException unused) {
                Log.w("CSLIB", "could not resolve view with tag @" + i);
                return;
            }
        }
        Log.w("CSLIB", "findView should be run from the UI Thread.");
    }

    public void findWebView(@NonNull ReactApplicationContext reactApplicationContext, int i, @NonNull OnWebViewFoundListener onWebViewFoundListener) {
        View viewResolveView;
        if (this.mReactNativeUiThreadUtil.isOnUiThread()) {
            try {
                viewResolveView = ((UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class)).resolveView(i);
            } catch (IllegalViewOperationException unused) {
                Log.w("CSLIB", "could not resolve web view");
                viewResolveView = null;
            }
            if (viewResolveView instanceof WebView) {
                onWebViewFoundListener.onWebViewFound((WebView) viewResolveView);
                return;
            }
            if (viewResolveView instanceof ViewGroup) {
                WebView webViewFindWebViewInChildren = findWebViewInChildren((ViewGroup) viewResolveView);
                if (webViewFindWebViewInChildren != null) {
                    onWebViewFoundListener.onWebViewFound(webViewFindWebViewInChildren);
                    return;
                } else {
                    Log.w("CSLIB", "could not resolve web view");
                    return;
                }
            }
            Log.w("CSLIB", "could not resolve web view");
            return;
        }
        Log.w("CSLIB", "findWebView should be run from the UI Thread.");
    }

    @Nullable
    @VisibleForTesting
    protected WebView findWebViewInChildren(@NonNull ViewGroup viewGroup) {
        WebView webViewFindWebViewInChildren;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof WebView) {
                return (WebView) childAt;
            }
            if (childAt instanceof ViewGroup) {
                ViewGroup viewGroup2 = (ViewGroup) childAt;
                if (viewGroup2.getChildCount() > 0 && (webViewFindWebViewInChildren = findWebViewInChildren(viewGroup2)) != null) {
                    return webViewFindWebViewInChildren;
                }
            }
        }
        return null;
    }
}
