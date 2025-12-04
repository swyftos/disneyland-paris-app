package com.contentsquare.rn.webview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import com.contentsquare.android.R;
import com.contentsquare.android.api.CsWebViewManager;
import com.contentsquare.rn.utils.ReactNativeViewFinder;
import com.contentsquare.rn.utils.VersionUtils;
import com.contentsquare.rn.utils.WebViewUtils;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;

/* loaded from: classes3.dex */
public class WebViewInjector {

    @NonNull
    private final ReactNativeViewFinder mReactNativeViewFinder;

    @NonNull
    private final SDKWebViewManager mSDKWebViewManager;

    public static class SDKWebViewManager {
        public void injectWebView(@NonNull WebView webView) {
            CsWebViewManager.injectEventTrackingInterface(webView);
        }

        public void removeWebViewInjection(@NonNull WebView webView) {
            CsWebViewManager.INSTANCE.removeEventTrackingInterface(webView);
        }
    }

    public WebViewInjector(@NonNull ReactNativeViewFinder reactNativeViewFinder, @NonNull SDKWebViewManager sDKWebViewManager) {
        this.mReactNativeViewFinder = reactNativeViewFinder;
        this.mSDKWebViewManager = sDKWebViewManager;
    }

    public void injectWebView(@NonNull final ReactApplicationContext reactApplicationContext, int i) {
        final Activity currentActivity = reactApplicationContext.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        this.mReactNativeViewFinder.findWebView(reactApplicationContext, i, new ReactNativeViewFinder.OnWebViewFoundListener() { // from class: com.contentsquare.rn.webview.WebViewInjector$$ExternalSyntheticLambda1
            @Override // com.contentsquare.rn.utils.ReactNativeViewFinder.OnWebViewFoundListener
            public final void onWebViewFound(WebView webView) {
                this.f$0.lambda$injectWebView$0(currentActivity, reactApplicationContext, webView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$injectWebView$0(Activity activity, ReactApplicationContext reactApplicationContext, WebView webView) {
        Log.i("CSLIB", "WebView found in native bridge. Ready to be injected");
        WebViewClient webViewClient = WebViewUtils.INSTANCE.getWebViewClient(webView);
        this.mSDKWebViewManager.injectWebView(prepareWebView(activity, webView));
        handleBlankPageRemoval(webView, webViewClient);
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onCSWebViewInjected", null);
    }

    private void handleBlankPageRemoval(final WebView webView, WebViewClient webViewClient) {
        if (!VersionUtils.INSTANCE.isApiLevelAtLeast(26)) {
            Log.i("CSLIB", "Handling blank page removal not performed: API leve lower than 26");
        } else if (webViewClient != null) {
            webView.setWebViewClient(new BridgeWebViewClient(webViewClient) { // from class: com.contentsquare.rn.webview.WebViewInjector.1
                @Override // com.contentsquare.rn.webview.BridgeWebViewClient, android.webkit.WebViewClient
                public void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                    super.onPageStarted(webView2, str, bitmap);
                    WebBackForwardList webBackForwardListCopyBackForwardList = webView.copyBackForwardList();
                    if (webBackForwardListCopyBackForwardList.getSize() == 2 && "about:blank".equals(webBackForwardListCopyBackForwardList.getItemAtIndex(0).getOriginalUrl())) {
                        webView.clearHistory();
                    }
                }
            });
        } else {
            Log.i("CSLIB", "Handling blank page removal not performed: web client not found");
        }
    }

    public void removeWebViewInjection(@NonNull ReactApplicationContext reactApplicationContext, int i) {
        final Activity currentActivity = reactApplicationContext.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        this.mReactNativeViewFinder.findWebView(reactApplicationContext, i, new ReactNativeViewFinder.OnWebViewFoundListener() { // from class: com.contentsquare.rn.webview.WebViewInjector$$ExternalSyntheticLambda0
            @Override // com.contentsquare.rn.utils.ReactNativeViewFinder.OnWebViewFoundListener
            public final void onWebViewFound(WebView webView) {
                this.f$0.lambda$removeWebViewInjection$1(currentActivity, webView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeWebViewInjection$1(Activity activity, WebView webView) {
        Log.i("CSLIB", "WebView found in native bridge. Ready to remove injection");
        this.mSDKWebViewManager.removeWebViewInjection(prepareWebView(activity, webView));
    }

    @NonNull
    private WebView prepareWebView(@NonNull Activity activity, @NonNull WebView webView) {
        webView.setTag(R.string.contentsquare_react_native_web_view_activity_tag, activity);
        return webView;
    }
}
