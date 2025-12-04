package com.contentsquare.rn.webview;

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
import com.contentsquare.android.api.CsWebViewClient;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0017J&\u0010\u000e\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u0013\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u0014\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0017J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0017J&\u0010\u0017\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J.\u0010\u001b\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\u001b\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010 \u001a\u0004\u0018\u00010!H\u0017J&\u0010\"\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010#\u001a\u0004\u0018\u00010\u0016H\u0017J&\u0010$\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010%\u001a\u0004\u0018\u00010\u00192\b\u0010&\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010'\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010(\u001a\u00020\u0007H\u0016J&\u0010)\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010 \u001a\u0004\u0018\u00010,H\u0016J\u001c\u0010-\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010.H\u0017J0\u0010/\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010*\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u00010\u000b2\b\u00102\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u00103\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u001c\u00106\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\"\u00107\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u000209H\u0016J0\u0010;\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u00102\u001a\u0004\u0018\u00010\u000b2\b\u0010<\u001a\u0004\u0018\u00010\u000b2\b\u0010=\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010>\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010?\u001a\u0004\u0018\u00010@H\u0017J.\u0010A\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010B\u001a\u00020\u001d2\b\u0010C\u001a\u0004\u0018\u00010DH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/contentsquare/rn/webview/BridgeWebViewClient;", "Lcom/contentsquare/android/api/CsWebViewClient;", "rnWebViewClient", "Landroid/webkit/WebViewClient;", "<init>", "(Landroid/webkit/WebViewClient;)V", "shouldOverrideUrlLoading", "", "view", "Landroid/webkit/WebView;", "url", "", "request", "Landroid/webkit/WebResourceRequest;", "onPageStarted", "", "favicon", "Landroid/graphics/Bitmap;", "onPageFinished", "onLoadResource", "onPageCommitVisible", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "onTooManyRedirects", "cancelMsg", "Landroid/os/Message;", "continueMsg", "onReceivedError", "errorCode", "", "description", "failingUrl", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Landroid/webkit/WebResourceError;", "onReceivedHttpError", "errorResponse", "onFormResubmission", "dontResend", "resend", "doUpdateVisitedHistory", "isReload", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "Landroid/net/http/SslError;", "onReceivedClientCertRequest", "Landroid/webkit/ClientCertRequest;", "onReceivedHttpAuthRequest", "Landroid/webkit/HttpAuthHandler;", "host", "realm", "shouldOverrideKeyEvent", "event", "Landroid/view/KeyEvent;", "onUnhandledKeyEvent", "onScaleChanged", "oldScale", "", "newScale", "onReceivedLoginRequest", "account", "args", "onRenderProcessGone", "detail", "Landroid/webkit/RenderProcessGoneDetail;", "onSafeBrowsingHit", "threatType", "callback", "Landroid/webkit/SafeBrowsingResponse;", "contentsquare_react-native-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class BridgeWebViewClient extends CsWebViewClient {

    @NotNull
    private WebViewClient rnWebViewClient;

    public BridgeWebViewClient(@NotNull WebViewClient rnWebViewClient) {
        Intrinsics.checkNotNullParameter(rnWebViewClient, "rnWebViewClient");
        this.rnWebViewClient = rnWebViewClient;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(@Nullable WebView view, @Nullable String url) {
        super.shouldOverrideUrlLoading(view, url);
        return this.rnWebViewClient.shouldOverrideUrlLoading(view, url);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(24)
    public boolean shouldOverrideUrlLoading(@Nullable WebView view, @Nullable WebResourceRequest request) {
        super.shouldOverrideUrlLoading(view, request);
        return this.rnWebViewClient.shouldOverrideUrlLoading(view, request);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(@Nullable WebView view, @Nullable String url, @Nullable Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        this.rnWebViewClient.onPageStarted(view, url, favicon);
    }

    @Override // com.contentsquare.android.api.CsWebViewClient, android.webkit.WebViewClient
    public void onPageFinished(@Nullable WebView view, @Nullable String url) {
        InstrumentationCallbacks.onPageFinishedCalled(this, view, url);
        super.onPageFinished(view, url);
        this.rnWebViewClient.onPageFinished(view, url);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(@Nullable WebView view, @Nullable String url) {
        super.onLoadResource(view, url);
        this.rnWebViewClient.onLoadResource(view, url);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(23)
    public void onPageCommitVisible(@Nullable WebView view, @Nullable String url) {
        super.onPageCommitVisible(view, url);
        this.rnWebViewClient.onPageCommitVisible(view, url);
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public WebResourceResponse shouldInterceptRequest(@Nullable WebView view, @Nullable String url) {
        super.shouldInterceptRequest(view, url);
        return this.rnWebViewClient.shouldInterceptRequest(view, url);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(21)
    @Nullable
    public WebResourceResponse shouldInterceptRequest(@Nullable WebView view, @Nullable WebResourceRequest request) {
        super.shouldInterceptRequest(view, request);
        return this.rnWebViewClient.shouldInterceptRequest(view, request);
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(@Nullable WebView view, @Nullable Message cancelMsg, @Nullable Message continueMsg) {
        super.onTooManyRedirects(view, cancelMsg, continueMsg);
        this.rnWebViewClient.onTooManyRedirects(view, cancelMsg, continueMsg);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(@Nullable WebView view, int errorCode, @Nullable String description, @Nullable String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        this.rnWebViewClient.onReceivedError(view, errorCode, description, failingUrl);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(23)
    public void onReceivedError(@Nullable WebView view, @Nullable WebResourceRequest request, @Nullable WebResourceError error) {
        super.onReceivedError(view, request, error);
        this.rnWebViewClient.onReceivedError(view, request, error);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(23)
    public void onReceivedHttpError(@Nullable WebView view, @Nullable WebResourceRequest request, @Nullable WebResourceResponse errorResponse) {
        super.onReceivedHttpError(view, request, errorResponse);
        this.rnWebViewClient.onReceivedHttpError(view, request, errorResponse);
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(@Nullable WebView view, @Nullable Message dontResend, @Nullable Message resend) {
        super.onFormResubmission(view, dontResend, resend);
        this.rnWebViewClient.onFormResubmission(view, dontResend, resend);
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(@Nullable WebView view, @Nullable String url, boolean isReload) {
        super.doUpdateVisitedHistory(view, url, isReload);
        this.rnWebViewClient.doUpdateVisitedHistory(view, url, isReload);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(@Nullable WebView view, @Nullable SslErrorHandler handler, @Nullable SslError error) {
        super.onReceivedSslError(view, handler, error);
        this.rnWebViewClient.onReceivedSslError(view, handler, error);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(21)
    public void onReceivedClientCertRequest(@Nullable WebView view, @Nullable ClientCertRequest request) {
        super.onReceivedClientCertRequest(view, request);
        this.rnWebViewClient.onReceivedClientCertRequest(view, request);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(@Nullable WebView view, @Nullable HttpAuthHandler handler, @Nullable String host, @Nullable String realm) {
        super.onReceivedHttpAuthRequest(view, handler, host, realm);
        this.rnWebViewClient.onReceivedHttpAuthRequest(view, handler, host, realm);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(@Nullable WebView view, @Nullable KeyEvent event) {
        super.shouldOverrideKeyEvent(view, event);
        return this.rnWebViewClient.shouldOverrideKeyEvent(view, event);
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(@Nullable WebView view, @Nullable KeyEvent event) {
        super.onUnhandledKeyEvent(view, event);
        this.rnWebViewClient.onUnhandledKeyEvent(view, event);
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(@Nullable WebView view, float oldScale, float newScale) {
        super.onScaleChanged(view, oldScale, newScale);
        this.rnWebViewClient.onScaleChanged(view, oldScale, newScale);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(@Nullable WebView view, @Nullable String realm, @Nullable String account, @Nullable String args) {
        super.onReceivedLoginRequest(view, realm, account, args);
        this.rnWebViewClient.onReceivedLoginRequest(view, realm, account, args);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(26)
    public boolean onRenderProcessGone(@Nullable WebView view, @Nullable RenderProcessGoneDetail detail) {
        super.onRenderProcessGone(view, detail);
        return this.rnWebViewClient.onRenderProcessGone(view, detail);
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(27)
    public void onSafeBrowsingHit(@Nullable WebView view, @Nullable WebResourceRequest request, int threatType, @Nullable SafeBrowsingResponse callback) {
        super.onSafeBrowsingHit(view, request, threatType, callback);
        this.rnWebViewClient.onSafeBrowsingHit(view, request, threatType, callback);
    }
}
