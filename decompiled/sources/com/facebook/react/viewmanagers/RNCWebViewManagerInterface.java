package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewManagerWithGeneratedInterface;

/* loaded from: classes3.dex */
public interface RNCWebViewManagerInterface<T extends View> extends ViewManagerWithGeneratedInterface {
    void clearCache(T t, boolean z);

    void clearFormData(T t);

    void clearHistory(T t);

    void goBack(T t);

    void goForward(T t);

    void injectJavaScript(T t, String str);

    void loadUrl(T t, String str);

    void postMessage(T t, String str);

    void reload(T t);

    void requestFocus(T t);

    void setAllowFileAccess(T t, boolean z);

    void setAllowFileAccessFromFileURLs(T t, boolean z);

    void setAllowUniversalAccessFromFileURLs(T t, boolean z);

    void setAllowingReadAccessToURL(T t, @Nullable String str);

    void setAllowsAirPlayForMediaPlayback(T t, boolean z);

    void setAllowsBackForwardNavigationGestures(T t, boolean z);

    void setAllowsFullscreenVideo(T t, boolean z);

    void setAllowsInlineMediaPlayback(T t, boolean z);

    void setAllowsLinkPreview(T t, boolean z);

    void setAllowsPictureInPictureMediaPlayback(T t, boolean z);

    void setAllowsProtectedMedia(T t, boolean z);

    void setAndroidLayerType(T t, @Nullable String str);

    void setApplicationNameForUserAgent(T t, @Nullable String str);

    void setAutoManageStatusBarEnabled(T t, boolean z);

    void setAutomaticallyAdjustContentInsets(T t, boolean z);

    void setBasicAuthCredential(T t, @Nullable ReadableMap readableMap);

    void setBounces(T t, boolean z);

    void setCacheEnabled(T t, boolean z);

    void setCacheMode(T t, @Nullable String str);

    void setContentInset(T t, @Nullable ReadableMap readableMap);

    void setContentInsetAdjustmentBehavior(T t, @Nullable String str);

    void setContentMode(T t, @Nullable String str);

    void setDataDetectorTypes(T t, @Nullable ReadableArray readableArray);

    void setDecelerationRate(T t, double d);

    void setDirectionalLockEnabled(T t, boolean z);

    void setDomStorageEnabled(T t, boolean z);

    void setDownloadingMessage(T t, @Nullable String str);

    void setEnableApplePay(T t, boolean z);

    void setForceDarkOn(T t, boolean z);

    void setFraudulentWebsiteWarningEnabled(T t, boolean z);

    void setGeolocationEnabled(T t, boolean z);

    void setHasOnFileDownload(T t, boolean z);

    void setHasOnOpenWindowEvent(T t, boolean z);

    void setHasOnScroll(T t, boolean z);

    void setHideKeyboardAccessoryView(T t, boolean z);

    void setIncognito(T t, boolean z);

    void setInjectedJavaScript(T t, @Nullable String str);

    void setInjectedJavaScriptBeforeContentLoaded(T t, @Nullable String str);

    void setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(T t, boolean z);

    void setInjectedJavaScriptForMainFrameOnly(T t, boolean z);

    void setInjectedJavaScriptObject(T t, @Nullable String str);

    void setJavaScriptCanOpenWindowsAutomatically(T t, boolean z);

    void setJavaScriptEnabled(T t, boolean z);

    void setKeyboardDisplayRequiresUserAction(T t, boolean z);

    void setLackPermissionToDownloadMessage(T t, @Nullable String str);

    void setLimitsNavigationsToAppBoundDomains(T t, boolean z);

    void setMediaCapturePermissionGrantType(T t, @Nullable String str);

    void setMediaPlaybackRequiresUserAction(T t, boolean z);

    void setMenuItems(T t, @Nullable ReadableArray readableArray);

    void setMessagingEnabled(T t, boolean z);

    void setMessagingModuleName(T t, @Nullable String str);

    void setMinimumFontSize(T t, int i);

    void setMixedContentMode(T t, @Nullable String str);

    void setNestedScrollEnabled(T t, boolean z);

    void setNewSource(T t, @Nullable ReadableMap readableMap);

    void setOverScrollMode(T t, @Nullable String str);

    void setPagingEnabled(T t, boolean z);

    void setPullToRefreshEnabled(T t, boolean z);

    void setRefreshControlLightMode(T t, boolean z);

    void setSaveFormDataDisabled(T t, boolean z);

    void setScalesPageToFit(T t, boolean z);

    void setScrollEnabled(T t, boolean z);

    void setSetBuiltInZoomControls(T t, boolean z);

    void setSetDisplayZoomControls(T t, boolean z);

    void setSetSupportMultipleWindows(T t, boolean z);

    void setSharedCookiesEnabled(T t, boolean z);

    void setShowsHorizontalScrollIndicator(T t, boolean z);

    void setShowsVerticalScrollIndicator(T t, boolean z);

    void setSuppressMenuItems(T t, @Nullable ReadableArray readableArray);

    void setTextInteractionEnabled(T t, boolean z);

    void setTextZoom(T t, int i);

    void setThirdPartyCookiesEnabled(T t, boolean z);

    void setUseSharedProcessPool(T t, boolean z);

    void setUserAgent(T t, @Nullable String str);

    void setWebviewDebuggingEnabled(T t, boolean z);

    void stopLoading(T t);
}
