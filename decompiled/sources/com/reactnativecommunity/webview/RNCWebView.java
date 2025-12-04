package com.reactnativecommunity.webview;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.ContentSizeChangeEvent;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.views.scroll.OnScrollDispatchHelper;
import com.facebook.react.views.scroll.ScrollEvent;
import com.facebook.react.views.scroll.ScrollEventType;
import com.reactnativecommunity.webview.events.TopCustomMenuSelectionEvent;
import com.reactnativecommunity.webview.events.TopMessageEvent;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class RNCWebView extends WebView implements LifecycleEventListener {
    protected static final String JAVASCRIPT_INTERFACE = "ReactNativeWebView";

    @Nullable
    protected WebViewCompat.WebMessageListener bridgeListener;

    @Nullable
    protected RNCWebViewBridge fallbackBridge;
    protected boolean hasScrollEvent;

    @Nullable
    protected String injectedJS;

    @Nullable
    protected String injectedJSBeforeContentLoaded;
    protected boolean injectedJavaScriptBeforeContentLoadedForMainFrameOnly;
    protected boolean injectedJavaScriptForMainFrameOnly;
    protected String injectedJavaScriptObject;

    @Nullable
    protected RNCWebViewMessagingModule mMessagingJSModule;
    private OnScrollDispatchHelper mOnScrollDispatchHelper;

    @Nullable
    protected RNCWebViewClient mRNCWebViewClient;
    WebChromeClient mWebChromeClient;

    @Nullable
    protected List<Map<String, String>> menuCustomItems;
    protected boolean messagingEnabled;

    @Nullable
    protected String messagingModuleName;
    protected boolean nestedScrollEnabled;
    protected ProgressChangedFilter progressChangedFilter;
    protected boolean sendContentSizeChangeEvents;

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    public RNCWebView(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.bridgeListener = null;
        this.injectedJavaScriptForMainFrameOnly = true;
        this.injectedJavaScriptBeforeContentLoadedForMainFrameOnly = true;
        this.messagingEnabled = false;
        this.sendContentSizeChangeEvents = false;
        this.hasScrollEvent = false;
        this.nestedScrollEnabled = false;
        this.injectedJavaScriptObject = null;
        this.mMessagingJSModule = (RNCWebViewMessagingModule) ((ThemedReactContext) getContext()).getReactApplicationContext().getJSModule(RNCWebViewMessagingModule.class);
        this.progressChangedFilter = new ProgressChangedFilter();
    }

    public void setIgnoreErrFailedForThisURL(String str) {
        this.mRNCWebViewClient.setIgnoreErrFailedForThisURL(str);
    }

    public void setBasicAuthCredential(RNCBasicAuthCredential rNCBasicAuthCredential) {
        this.mRNCWebViewClient.setBasicAuthCredential(rNCBasicAuthCredential);
    }

    public void setSendContentSizeChangeEvents(boolean z) {
        this.sendContentSizeChangeEvents = z;
    }

    public void setHasScrollEvent(boolean z) {
        this.hasScrollEvent = z;
    }

    public void setNestedScrollEnabled(boolean z) {
        this.nestedScrollEnabled = z;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        cleanupCallbacksAndDestroy();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.nestedScrollEnabled) {
            requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.sendContentSizeChangeEvents) {
            dispatchEvent(this, new ContentSizeChangeEvent(RNCWebViewWrapper.getReactTagFromWebView(this), i, i2));
        }
    }

    public void setMenuCustomItems(List<Map<String, String>> list) {
        this.menuCustomItems = list;
    }

    @Override // android.view.View
    public ActionMode startActionMode(final ActionMode.Callback callback, int i) {
        if (this.menuCustomItems == null) {
            return super.startActionMode(callback, i);
        }
        return super.startActionMode(new ActionMode.Callback2() { // from class: com.reactnativecommunity.webview.RNCWebView.1
            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                for (int i2 = 0; i2 < RNCWebView.this.menuCustomItems.size(); i2++) {
                    menu.add(0, i2, i2, RNCWebView.this.menuCustomItems.get(i2).get("label"));
                }
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(final ActionMode actionMode, final MenuItem menuItem) {
                final WritableMap writableMapCreateMap = Arguments.createMap();
                RNCWebView.this.evaluateJavascript("(function(){return {selection: window.getSelection().toString()} })()", new ValueCallback<String>() { // from class: com.reactnativecommunity.webview.RNCWebView.1.1
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(String str) throws JSONException {
                        String string;
                        Map<String, String> map = RNCWebView.this.menuCustomItems.get(menuItem.getItemId());
                        writableMapCreateMap.putString("label", map.get("label"));
                        writableMapCreateMap.putString("key", map.get("key"));
                        try {
                            string = new JSONObject(str).getString("selection");
                        } catch (JSONException unused) {
                            string = "";
                        }
                        writableMapCreateMap.putString("selectedText", string);
                        RNCWebView rNCWebView = RNCWebView.this;
                        rNCWebView.dispatchEvent(rNCWebView, new TopCustomMenuSelectionEvent(RNCWebViewWrapper.getReactTagFromWebView(RNCWebView.this), writableMapCreateMap));
                        actionMode.finish();
                    }
                });
                return true;
            }

            @Override // android.view.ActionMode.Callback2
            public void onGetContentRect(ActionMode actionMode, View view, Rect rect) {
                ActionMode.Callback callback2 = callback;
                if (callback2 instanceof ActionMode.Callback2) {
                    ((ActionMode.Callback2) callback2).onGetContentRect(actionMode, view, rect);
                } else {
                    super.onGetContentRect(actionMode, view, rect);
                }
            }
        }, i);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof RNCWebViewClient) {
            RNCWebViewClient rNCWebViewClient = (RNCWebViewClient) webViewClient;
            this.mRNCWebViewClient = rNCWebViewClient;
            rNCWebViewClient.setProgressChangedFilter(this.progressChangedFilter);
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.mWebChromeClient = webChromeClient;
        super.setWebChromeClient(webChromeClient);
        if (webChromeClient instanceof RNCWebChromeClient) {
            ((RNCWebChromeClient) webChromeClient).setProgressChangedFilter(this.progressChangedFilter);
        }
    }

    @Override // android.webkit.WebView
    public WebChromeClient getWebChromeClient() {
        return this.mWebChromeClient;
    }

    @Nullable
    public RNCWebViewClient getRNCWebViewClient() {
        return this.mRNCWebViewClient;
    }

    public boolean getMessagingEnabled() {
        return this.messagingEnabled;
    }

    protected void createRNCWebViewBridge(RNCWebView rNCWebView) {
        if (WebViewFeature.isFeatureSupported("WEB_MESSAGE_LISTENER")) {
            if (this.bridgeListener == null) {
                this.bridgeListener = new WebViewCompat.WebMessageListener() { // from class: com.reactnativecommunity.webview.RNCWebView.2
                    @Override // androidx.webkit.WebViewCompat.WebMessageListener
                    public void onPostMessage(@NonNull WebView webView, @NonNull WebMessageCompat webMessageCompat, @NonNull Uri uri, boolean z, @NonNull JavaScriptReplyProxy javaScriptReplyProxy) {
                        RNCWebView.this.onMessage(webMessageCompat.getData(), uri.toString());
                    }
                };
                WebViewCompat.addWebMessageListener(rNCWebView, JAVASCRIPT_INTERFACE, RNCWebView$$ExternalSyntheticBackport1.m(new Object[]{"*"}), this.bridgeListener);
            }
        } else if (this.fallbackBridge == null) {
            RNCWebViewBridge rNCWebViewBridge = new RNCWebViewBridge(rNCWebView);
            this.fallbackBridge = rNCWebViewBridge;
            addJavascriptInterface(rNCWebViewBridge, JAVASCRIPT_INTERFACE);
        }
        injectJavascriptObject();
    }

    private void injectJavascriptObject() {
        String str;
        if (getSettings().getJavaScriptEnabled()) {
            StringBuilder sb = new StringBuilder();
            sb.append("(function(){\n    window.ReactNativeWebView = window.ReactNativeWebView || {};\n    window.ReactNativeWebView.injectedObjectJson = function () { return ");
            if (this.injectedJavaScriptObject == null) {
                str = null;
            } else {
                str = "`" + this.injectedJavaScriptObject + "`";
            }
            sb.append(str);
            sb.append("; };\n})();");
            evaluateJavascriptWithFallback(sb.toString());
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void setMessagingEnabled(boolean z) {
        if (this.messagingEnabled == z) {
            return;
        }
        this.messagingEnabled = z;
        if (z) {
            createRNCWebViewBridge(this);
        }
    }

    protected void evaluateJavascriptWithFallback(String str) {
        evaluateJavascript(str, null);
    }

    public void callInjectedJavaScript() {
        String str;
        if (!getSettings().getJavaScriptEnabled() || (str = this.injectedJS) == null || TextUtils.isEmpty(str)) {
            return;
        }
        evaluateJavascriptWithFallback("(function() {\n" + this.injectedJS + ";\n})();");
        injectJavascriptObject();
    }

    public void callInjectedJavaScriptBeforeContentLoaded() {
        String str;
        if (!getSettings().getJavaScriptEnabled() || (str = this.injectedJSBeforeContentLoaded) == null || TextUtils.isEmpty(str)) {
            return;
        }
        evaluateJavascriptWithFallback("(function() {\n" + this.injectedJSBeforeContentLoaded + ";\n})();");
        injectJavascriptObject();
    }

    public void setInjectedJavaScriptObject(String str) {
        this.injectedJavaScriptObject = str;
        injectJavascriptObject();
    }

    public void onMessage(final String str, final String str2) {
        getThemedReactContext();
        if (this.mRNCWebViewClient != null) {
            post(new Runnable() { // from class: com.reactnativecommunity.webview.RNCWebView.3
                @Override // java.lang.Runnable
                public void run() {
                    RNCWebViewClient rNCWebViewClient = RNCWebView.this.mRNCWebViewClient;
                    if (rNCWebViewClient == null) {
                        return;
                    }
                    WritableMap writableMapCreateWebViewEvent = rNCWebViewClient.createWebViewEvent(this, str2);
                    writableMapCreateWebViewEvent.putString("data", str);
                    RNCWebView rNCWebView = RNCWebView.this;
                    if (rNCWebView.mMessagingJSModule != null) {
                        rNCWebView.dispatchDirectMessage(writableMapCreateWebViewEvent);
                    } else {
                        rNCWebView.dispatchEvent(this, new TopMessageEvent(RNCWebViewWrapper.getReactTagFromWebView(this), writableMapCreateWebViewEvent));
                    }
                }
            });
            return;
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("data", str);
        if (this.mMessagingJSModule != null) {
            dispatchDirectMessage(writableMapCreateMap);
        } else {
            dispatchEvent(this, new TopMessageEvent(RNCWebViewWrapper.getReactTagFromWebView(this), writableMapCreateMap));
        }
    }

    protected void dispatchDirectMessage(WritableMap writableMap) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putMap("nativeEvent", writableMap);
        writableNativeMap.putString("messagingModuleName", this.messagingModuleName);
        this.mMessagingJSModule.onMessage(writableNativeMap);
    }

    protected boolean dispatchDirectShouldStartLoadWithRequest(WritableMap writableMap) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putMap("nativeEvent", writableMap);
        writableNativeMap.putString("messagingModuleName", this.messagingModuleName);
        this.mMessagingJSModule.onShouldStartLoadWithRequest(writableNativeMap);
        return true;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.hasScrollEvent) {
            if (this.mOnScrollDispatchHelper == null) {
                this.mOnScrollDispatchHelper = new OnScrollDispatchHelper();
            }
            if (this.mOnScrollDispatchHelper.onScrollChanged(i, i2)) {
                dispatchEvent(this, ScrollEvent.obtain(RNCWebViewWrapper.getReactTagFromWebView(this), ScrollEventType.SCROLL, i, i2, this.mOnScrollDispatchHelper.getXFlingVelocity(), this.mOnScrollDispatchHelper.getYFlingVelocity(), computeHorizontalScrollRange(), computeVerticalScrollRange(), getWidth(), getHeight()));
            }
        }
    }

    protected void dispatchEvent(WebView webView, Event event) {
        UIManagerHelper.getEventDispatcherForReactTag(getThemedReactContext(), RNCWebViewWrapper.getReactTagFromWebView(webView)).dispatchEvent(event);
    }

    protected void cleanupCallbacksAndDestroy() {
        setWebViewClient(null);
        destroy();
    }

    @Override // android.webkit.WebView
    public void destroy() {
        WebChromeClient webChromeClient = this.mWebChromeClient;
        if (webChromeClient != null) {
            webChromeClient.onHideCustomView();
        }
        super.destroy();
    }

    public ThemedReactContext getThemedReactContext() {
        return (ThemedReactContext) getContext();
    }

    public ReactApplicationContext getReactApplicationContext() {
        return getThemedReactContext().getReactApplicationContext();
    }

    protected class RNCWebViewBridge {
        private String TAG = "RNCWebViewBridge";
        RNCWebView mWebView;

        RNCWebViewBridge(RNCWebView rNCWebView) {
            this.mWebView = rNCWebView;
        }

        @JavascriptInterface
        public void postMessage(String str) {
            if (this.mWebView.getMessagingEnabled()) {
                RNCWebView rNCWebView = this.mWebView;
                rNCWebView.onMessage(str, rNCWebView.getUrl());
            } else {
                FLog.w(this.TAG, "ReactNativeWebView.postMessage method was called but messaging is disabled. Pass an onMessage handler to the WebView.");
            }
        }
    }

    protected static class ProgressChangedFilter {
        private boolean waitingForCommandLoadUrl = false;

        protected ProgressChangedFilter() {
        }

        public void setWaitingForCommandLoadUrl(boolean z) {
            this.waitingForCommandLoadUrl = z;
        }

        public boolean isWaitingForCommandLoadUrl() {
            return this.waitingForCommandLoadUrl;
        }
    }
}
