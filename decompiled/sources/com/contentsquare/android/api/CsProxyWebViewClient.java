package com.contentsquare.android.api;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.google.firebase.messaging.Constants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J$\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u0016\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0017\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0018\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0019\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001c\u0010\u001c\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u001d\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J.\u0010\u001f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u000f2\b\u0010&\u001a\u0004\u0018\u00010\u000fH\u0017J0\u0010'\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010\u000f2\b\u0010+\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010,\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u001d\u001a\u0004\u0018\u00010 2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J0\u0010/\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010+\u001a\u0004\u0018\u00010\u000f2\b\u00100\u001a\u0004\u0018\u00010\u000f2\b\u00101\u001a\u0004\u0018\u00010\u000fH\u0016J&\u00102\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010(\u001a\u0004\u0018\u0001032\b\u0010!\u001a\u0004\u0018\u000104H\u0016J\u001c\u00105\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u00106\u001a\u0004\u0018\u000107H\u0017J.\u00108\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u001d\u001a\u0004\u0018\u00010 2\u0006\u00109\u001a\u00020$2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\"\u0010<\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>H\u0016J&\u0010@\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010A\u001a\u0004\u0018\u00010\u00142\b\u0010B\u001a\u0004\u0018\u00010\u0014H\u0017J\u001c\u0010C\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u001e\u0010F\u001a\u0004\u0018\u00010.2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u001d\u001a\u0004\u0018\u00010 H\u0016J\u001e\u0010F\u001a\u0004\u0018\u00010.2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0017J\u001c\u0010G\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u001c\u0010H\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u001d\u001a\u0004\u0018\u00010 H\u0017J\u001c\u0010H\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0017R\u001a\u0010\u0002\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/contentsquare/android/api/CsProxyWebViewClient;", "Landroid/webkit/WebViewClient;", "proxy", "tagInjector", "Lcom/contentsquare/android/api/CsWebViewTagInjector;", "(Landroid/webkit/WebViewClient;Lcom/contentsquare/android/api/CsWebViewTagInjector;)V", "getProxy", "()Landroid/webkit/WebViewClient;", "setProxy", "(Landroid/webkit/WebViewClient;)V", "doUpdateVisitedHistory", "", "view", "Landroid/webkit/WebView;", "url", "", "isReload", "", "onFormResubmission", "dontResend", "Landroid/os/Message;", "resend", "onLoadResource", "onPageCommitVisible", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedClientCertRequest", "request", "Landroid/webkit/ClientCertRequest;", "onReceivedError", "Landroid/webkit/WebResourceRequest;", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Landroid/webkit/WebResourceError;", "errorCode", "", "description", "failingUrl", "onReceivedHttpAuthRequest", "handler", "Landroid/webkit/HttpAuthHandler;", "host", "realm", "onReceivedHttpError", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onReceivedLoginRequest", "account", "args", "onReceivedSslError", "Landroid/webkit/SslErrorHandler;", "Landroid/net/http/SslError;", "onRenderProcessGone", "detail", "Landroid/webkit/RenderProcessGoneDetail;", "onSafeBrowsingHit", "threatType", "callback", "Landroid/webkit/SafeBrowsingResponse;", "onScaleChanged", "oldScale", "", "newScale", "onTooManyRedirects", "cancelMsg", "continueMsg", "onUnhandledKeyEvent", "event", "Landroid/view/KeyEvent;", "shouldInterceptRequest", "shouldOverrideKeyEvent", "shouldOverrideUrlLoading", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CsProxyWebViewClient extends WebViewClient {

    @NotNull
    private WebViewClient proxy;

    @NotNull
    private final CsWebViewTagInjector tagInjector;

    public CsProxyWebViewClient(@NotNull WebViewClient proxy, @NotNull CsWebViewTagInjector tagInjector) {
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(tagInjector, "tagInjector");
        this.proxy = proxy;
        this.tagInjector = tagInjector;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(@Nullable WebView view, @Nullable String url, boolean isReload) {
        this.proxy.doUpdateVisitedHistory(view, url, isReload);
    }

    @NotNull
    public final WebViewClient getProxy() {
        return this.proxy;
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(@Nullable WebView view, @Nullable Message dontResend, @Nullable Message resend) {
        this.proxy.onFormResubmission(view, dontResend, resend);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(@Nullable WebView view, @Nullable String url) {
        this.proxy.onLoadResource(view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(@Nullable WebView view, @Nullable String url) {
        this.proxy.onPageCommitVisible(view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(@Nullable WebView view, @Nullable String url) {
        InstrumentationCallbacks.onPageFinishedCalled(this, view, url);
        this.proxy.onPageFinished(view, url);
        this.tagInjector.injectTag(view);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(@Nullable WebView view, @Nullable String url, @Nullable Bitmap favicon) {
        this.proxy.onPageStarted(view, url, favicon);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedClientCertRequest(@Nullable WebView view, @Nullable ClientCertRequest request) {
        this.proxy.onReceivedClientCertRequest(view, request);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated.", replaceWith = @ReplaceWith(expression = "Refers to android.webkit.WebViewClient.onReceivedError", imports = {}))
    public void onReceivedError(@Nullable WebView view, int errorCode, @Nullable String description, @Nullable String failingUrl) {
        this.proxy.onReceivedError(view, errorCode, description, failingUrl);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(@Nullable WebView view, @Nullable HttpAuthHandler handler, @Nullable String host, @Nullable String realm) {
        this.proxy.onReceivedHttpAuthRequest(view, handler, host, realm);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(@Nullable WebView view, @Nullable WebResourceRequest request, @Nullable WebResourceResponse errorResponse) {
        this.proxy.onReceivedHttpError(view, request, errorResponse);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(@Nullable WebView view, @Nullable String realm, @Nullable String account, @Nullable String args) {
        this.proxy.onReceivedLoginRequest(view, realm, account, args);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(@Nullable WebView view, @Nullable SslErrorHandler handler, @Nullable SslError error) {
        this.proxy.onReceivedSslError(view, handler, error);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(26)
    public boolean onRenderProcessGone(@Nullable WebView view, @Nullable RenderProcessGoneDetail detail) {
        return this.proxy.onRenderProcessGone(view, detail);
    }

    @Override // android.webkit.WebViewClient
    public void onSafeBrowsingHit(@Nullable WebView view, @Nullable WebResourceRequest request, int threatType, @Nullable SafeBrowsingResponse callback) {
        this.proxy.onSafeBrowsingHit(view, request, threatType, callback);
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(@Nullable WebView view, float oldScale, float newScale) {
        this.proxy.onScaleChanged(view, oldScale, newScale);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated.", replaceWith = @ReplaceWith(expression = "Refers to android.webkit.WebViewClient.onTooManyRedirects", imports = {}))
    public void onTooManyRedirects(@Nullable WebView view, @Nullable Message cancelMsg, @Nullable Message continueMsg) {
        this.proxy.onTooManyRedirects(view, cancelMsg, continueMsg);
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(@Nullable WebView view, @Nullable KeyEvent event) {
        this.proxy.onUnhandledKeyEvent(view, event);
    }

    public final void setProxy(@NotNull WebViewClient webViewClient) {
        Intrinsics.checkNotNullParameter(webViewClient, "<set-?>");
        this.proxy = webViewClient;
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public WebResourceResponse shouldInterceptRequest(@Nullable WebView view, @Nullable WebResourceRequest request) {
        return this.proxy.shouldInterceptRequest(view, request);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(@Nullable WebView view, @Nullable KeyEvent event) {
        return this.proxy.shouldOverrideKeyEvent(view, event);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(24)
    public boolean shouldOverrideUrlLoading(@Nullable WebView view, @Nullable WebResourceRequest request) {
        return this.proxy.shouldOverrideUrlLoading(view, request);
    }

    public /* synthetic */ CsProxyWebViewClient(WebViewClient webViewClient, CsWebViewTagInjector csWebViewTagInjector, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(webViewClient, (i & 2) != 0 ? new CsWebViewTagInjector(null, null, null, null, null, 31, null) : csWebViewTagInjector);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(@Nullable WebView view, @Nullable WebResourceRequest request, @Nullable WebResourceError error) {
        this.proxy.onReceivedError(view, request, error);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated.", replaceWith = @ReplaceWith(expression = "Refers to android.webkit.WebViewClient.shouldInterceptRequest", imports = {}))
    @Nullable
    public WebResourceResponse shouldInterceptRequest(@Nullable WebView view, @Nullable String url) {
        return this.proxy.shouldInterceptRequest(view, url);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated.", replaceWith = @ReplaceWith(expression = "Refers to android.webkit.WebViewClient.shouldOverrideUrlLoading", imports = {}))
    public boolean shouldOverrideUrlLoading(@Nullable WebView view, @Nullable String url) {
        return this.proxy.shouldOverrideUrlLoading(view, url);
    }
}
