package com.reactnativecommunity.webview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNCWebViewManagerDelegate;
import com.facebook.react.viewmanagers.RNCWebViewManagerInterface;
import com.facebook.react.views.scroll.ScrollEventType;
import com.reactnativecommunity.webview.events.TopCustomMenuSelectionEvent;
import com.reactnativecommunity.webview.events.TopHttpErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingFinishEvent;
import com.reactnativecommunity.webview.events.TopLoadingProgressEvent;
import com.reactnativecommunity.webview.events.TopLoadingStartEvent;
import com.reactnativecommunity.webview.events.TopMessageEvent;
import com.reactnativecommunity.webview.events.TopOpenWindowEvent;
import com.reactnativecommunity.webview.events.TopRenderProcessGoneEvent;
import com.reactnativecommunity.webview.events.TopShouldStartLoadWithRequestEvent;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = RNCWebViewManagerImpl.NAME)
/* loaded from: classes4.dex */
public class RNCWebViewManager extends ViewGroupManager<RNCWebViewWrapper> implements RNCWebViewManagerInterface<RNCWebViewWrapper> {
    private final ViewManagerDelegate<RNCWebViewWrapper> mDelegate = new RNCWebViewManagerDelegate(this);
    private final RNCWebViewManagerImpl mRNCWebViewManagerImpl = new RNCWebViewManagerImpl(true);

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setAllowingReadAccessToURL(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setAllowsAirPlayForMediaPlayback(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setAllowsBackForwardNavigationGestures(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setAllowsInlineMediaPlayback(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setAllowsLinkPreview(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setAllowsPictureInPictureMediaPlayback(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setAutoManageStatusBarEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setAutomaticallyAdjustContentInsets(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setBounces(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setContentInset(RNCWebViewWrapper rNCWebViewWrapper, @Nullable ReadableMap readableMap) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setContentInsetAdjustmentBehavior(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setContentMode(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setDataDetectorTypes(RNCWebViewWrapper rNCWebViewWrapper, @Nullable ReadableArray readableArray) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setDecelerationRate(RNCWebViewWrapper rNCWebViewWrapper, double d) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setDirectionalLockEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setEnableApplePay(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setFraudulentWebsiteWarningEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setHasOnFileDownload(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setHideKeyboardAccessoryView(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setKeyboardDisplayRequiresUserAction(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setLimitsNavigationsToAppBoundDomains(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setMediaCapturePermissionGrantType(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setPagingEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setPullToRefreshEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setRefreshControlLightMode(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setScrollEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setSharedCookiesEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "suppressMenuItems ")
    public void setSuppressMenuItems(RNCWebViewWrapper rNCWebViewWrapper, @Nullable ReadableArray readableArray) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setTextInteractionEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void setUseSharedProcessPool(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    protected ViewManagerDelegate<RNCWebViewWrapper> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return RNCWebViewManagerImpl.NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    @NonNull
    public RNCWebViewWrapper createViewInstance(@NonNull ThemedReactContext themedReactContext) {
        return this.mRNCWebViewManagerImpl.createViewInstance(themedReactContext);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "allowFileAccess")
    public void setAllowFileAccess(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setAllowFileAccess(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "allowFileAccessFromFileURLs")
    public void setAllowFileAccessFromFileURLs(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setAllowFileAccessFromFileURLs(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "allowUniversalAccessFromFileURLs")
    public void setAllowUniversalAccessFromFileURLs(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setAllowUniversalAccessFromFileURLs(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "allowsFullscreenVideo")
    public void setAllowsFullscreenVideo(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setAllowsFullscreenVideo(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "allowsProtectedMedia")
    public void setAllowsProtectedMedia(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setAllowsProtectedMedia(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "androidLayerType")
    public void setAndroidLayerType(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.setAndroidLayerType(rNCWebViewWrapper, str);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "applicationNameForUserAgent")
    public void setApplicationNameForUserAgent(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.setApplicationNameForUserAgent(rNCWebViewWrapper, str);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "basicAuthCredential")
    public void setBasicAuthCredential(RNCWebViewWrapper rNCWebViewWrapper, @Nullable ReadableMap readableMap) {
        this.mRNCWebViewManagerImpl.setBasicAuthCredential(rNCWebViewWrapper, readableMap);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "cacheEnabled")
    public void setCacheEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setCacheEnabled(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "cacheMode")
    public void setCacheMode(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.setCacheMode(rNCWebViewWrapper, str);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "domStorageEnabled")
    public void setDomStorageEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setDomStorageEnabled(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "downloadingMessage")
    public void setDownloadingMessage(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.setDownloadingMessage(str);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "forceDarkOn")
    public void setForceDarkOn(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setForceDarkOn(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "geolocationEnabled")
    public void setGeolocationEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setGeolocationEnabled(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "hasOnScroll")
    public void setHasOnScroll(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setHasOnScroll(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "incognito")
    public void setIncognito(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setIncognito(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "injectedJavaScript")
    public void setInjectedJavaScript(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.setInjectedJavaScript(rNCWebViewWrapper, str);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "injectedJavaScriptBeforeContentLoaded")
    public void setInjectedJavaScriptBeforeContentLoaded(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.setInjectedJavaScriptBeforeContentLoaded(rNCWebViewWrapper, str);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "injectedJavaScriptForMainFrameOnly")
    public void setInjectedJavaScriptForMainFrameOnly(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setInjectedJavaScriptForMainFrameOnly(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "injectedJavaScriptBeforeContentLoadedForMainFrameOnly")
    public void setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "injectedJavaScriptObject")
    public void setInjectedJavaScriptObject(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.setInjectedJavaScriptObject(rNCWebViewWrapper, str);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "javaScriptCanOpenWindowsAutomatically")
    public void setJavaScriptCanOpenWindowsAutomatically(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setJavaScriptCanOpenWindowsAutomatically(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "javaScriptEnabled")
    public void setJavaScriptEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setJavaScriptEnabled(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "lackPermissionToDownloadMessage")
    public void setLackPermissionToDownloadMessage(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.setLackPermissionToDownloadMessage(str);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "hasOnOpenWindowEvent")
    public void setHasOnOpenWindowEvent(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setHasOnOpenWindowEvent(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "mediaPlaybackRequiresUserAction")
    public void setMediaPlaybackRequiresUserAction(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setMediaPlaybackRequiresUserAction(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "menuItems")
    public void setMenuItems(RNCWebViewWrapper rNCWebViewWrapper, @Nullable ReadableArray readableArray) {
        this.mRNCWebViewManagerImpl.setMenuCustomItems(rNCWebViewWrapper, readableArray);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "messagingEnabled")
    public void setMessagingEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setMessagingEnabled(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "messagingModuleName")
    public void setMessagingModuleName(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.setMessagingModuleName(rNCWebViewWrapper, str);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "minimumFontSize")
    public void setMinimumFontSize(RNCWebViewWrapper rNCWebViewWrapper, int i) {
        this.mRNCWebViewManagerImpl.setMinimumFontSize(rNCWebViewWrapper, i);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "mixedContentMode")
    public void setMixedContentMode(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.setMixedContentMode(rNCWebViewWrapper, str);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "nestedScrollEnabled")
    public void setNestedScrollEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setNestedScrollEnabled(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "overScrollMode")
    public void setOverScrollMode(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.setOverScrollMode(rNCWebViewWrapper, str);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "saveFormDataDisabled")
    public void setSaveFormDataDisabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setSaveFormDataDisabled(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "scalesPageToFit")
    public void setScalesPageToFit(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setScalesPageToFit(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "setBuiltInZoomControls")
    public void setSetBuiltInZoomControls(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setSetBuiltInZoomControls(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "setDisplayZoomControls")
    public void setSetDisplayZoomControls(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setSetDisplayZoomControls(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "setSupportMultipleWindows")
    public void setSetSupportMultipleWindows(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setSetSupportMultipleWindows(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "showsHorizontalScrollIndicator")
    public void setShowsHorizontalScrollIndicator(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setShowsHorizontalScrollIndicator(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "showsVerticalScrollIndicator")
    public void setShowsVerticalScrollIndicator(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setShowsVerticalScrollIndicator(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "newSource")
    public void setNewSource(RNCWebViewWrapper rNCWebViewWrapper, @Nullable ReadableMap readableMap) {
        this.mRNCWebViewManagerImpl.setSource(rNCWebViewWrapper, readableMap);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "textZoom")
    public void setTextZoom(RNCWebViewWrapper rNCWebViewWrapper, int i) {
        this.mRNCWebViewManagerImpl.setTextZoom(rNCWebViewWrapper, i);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "thirdPartyCookiesEnabled")
    public void setThirdPartyCookiesEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setThirdPartyCookiesEnabled(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "webviewDebuggingEnabled")
    public void setWebviewDebuggingEnabled(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        this.mRNCWebViewManagerImpl.setWebviewDebuggingEnabled(rNCWebViewWrapper, z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    @ReactProp(name = "userAgent")
    public void setUserAgent(RNCWebViewWrapper rNCWebViewWrapper, @Nullable String str) {
        this.mRNCWebViewManagerImpl.setUserAgent(rNCWebViewWrapper, str);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void goBack(RNCWebViewWrapper rNCWebViewWrapper) {
        rNCWebViewWrapper.getWebView().goBack();
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void goForward(RNCWebViewWrapper rNCWebViewWrapper) {
        rNCWebViewWrapper.getWebView().goForward();
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void reload(RNCWebViewWrapper rNCWebViewWrapper) {
        rNCWebViewWrapper.getWebView().reload();
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void stopLoading(RNCWebViewWrapper rNCWebViewWrapper) {
        rNCWebViewWrapper.getWebView().stopLoading();
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void injectJavaScript(RNCWebViewWrapper rNCWebViewWrapper, String str) {
        rNCWebViewWrapper.getWebView().evaluateJavascriptWithFallback(str);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void requestFocus(RNCWebViewWrapper rNCWebViewWrapper) {
        rNCWebViewWrapper.requestFocus();
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void postMessage(RNCWebViewWrapper rNCWebViewWrapper, String str) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", str);
            rNCWebViewWrapper.getWebView().evaluateJavascriptWithFallback("(function () {var event;var data = " + jSONObject.toString() + ";try {event = new MessageEvent('message', data);} catch (e) {event = document.createEvent('MessageEvent');event.initMessageEvent('message', true, true, data.data, data.origin, data.lastEventId, data.source);}document.dispatchEvent(event);})();");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void loadUrl(RNCWebViewWrapper rNCWebViewWrapper, String str) {
        RNCWebView webView = rNCWebViewWrapper.getWebView();
        InstrumentationCallbacks.loadUrlCalled(webView);
        webView.loadUrl(str);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void clearFormData(RNCWebViewWrapper rNCWebViewWrapper) {
        rNCWebViewWrapper.getWebView().clearFormData();
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void clearCache(RNCWebViewWrapper rNCWebViewWrapper, boolean z) {
        rNCWebViewWrapper.getWebView().clearCache(z);
    }

    @Override // com.facebook.react.viewmanagers.RNCWebViewManagerInterface
    public void clearHistory(RNCWebViewWrapper rNCWebViewWrapper) {
        rNCWebViewWrapper.getWebView().clearHistory();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(@NonNull ThemedReactContext themedReactContext, RNCWebViewWrapper rNCWebViewWrapper) {
        rNCWebViewWrapper.getWebView().setWebViewClient(new RNCWebViewClient());
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = MapBuilder.newHashMap();
        }
        exportedCustomDirectEventTypeConstants.put(TopLoadingStartEvent.EVENT_NAME, MapBuilder.of("registrationName", "onLoadingStart"));
        exportedCustomDirectEventTypeConstants.put(TopLoadingFinishEvent.EVENT_NAME, MapBuilder.of("registrationName", "onLoadingFinish"));
        exportedCustomDirectEventTypeConstants.put(TopLoadingErrorEvent.EVENT_NAME, MapBuilder.of("registrationName", "onLoadingError"));
        exportedCustomDirectEventTypeConstants.put(TopMessageEvent.EVENT_NAME, MapBuilder.of("registrationName", "onMessage"));
        exportedCustomDirectEventTypeConstants.put(TopLoadingProgressEvent.EVENT_NAME, MapBuilder.of("registrationName", "onLoadingProgress"));
        exportedCustomDirectEventTypeConstants.put(TopShouldStartLoadWithRequestEvent.EVENT_NAME, MapBuilder.of("registrationName", "onShouldStartLoadWithRequest"));
        exportedCustomDirectEventTypeConstants.put(ScrollEventType.getJSEventName(ScrollEventType.SCROLL), MapBuilder.of("registrationName", "onScroll"));
        exportedCustomDirectEventTypeConstants.put(TopHttpErrorEvent.EVENT_NAME, MapBuilder.of("registrationName", "onHttpError"));
        exportedCustomDirectEventTypeConstants.put(TopRenderProcessGoneEvent.EVENT_NAME, MapBuilder.of("registrationName", "onRenderProcessGone"));
        exportedCustomDirectEventTypeConstants.put(TopCustomMenuSelectionEvent.EVENT_NAME, MapBuilder.of("registrationName", "onCustomMenuSelection"));
        exportedCustomDirectEventTypeConstants.put(TopOpenWindowEvent.EVENT_NAME, MapBuilder.of("registrationName", "onOpenWindow"));
        return exportedCustomDirectEventTypeConstants;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Integer> getCommandsMap() {
        return this.mRNCWebViewManagerImpl.getCommandsMap();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(@NonNull RNCWebViewWrapper rNCWebViewWrapper, String str, @Nullable ReadableArray readableArray) {
        super.receiveCommand((RNCWebViewManager) rNCWebViewWrapper, str, readableArray);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(@NonNull RNCWebViewWrapper rNCWebViewWrapper) {
        super.onAfterUpdateTransaction((RNCWebViewManager) rNCWebViewWrapper);
        this.mRNCWebViewManagerImpl.onAfterUpdateTransaction(rNCWebViewWrapper);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(@NonNull RNCWebViewWrapper rNCWebViewWrapper) {
        this.mRNCWebViewManagerImpl.onDropViewInstance(rNCWebViewWrapper);
        super.onDropViewInstance((RNCWebViewManager) rNCWebViewWrapper);
    }
}
