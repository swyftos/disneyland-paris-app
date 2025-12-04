package com.urbanairship.webkit;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.urbanairship.Cancelable;
import com.urbanairship.R;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.actions.ActionCompletionCallback;
import com.urbanairship.actions.ActionRunRequest;
import com.urbanairship.actions.ActionRunRequestExtender;
import com.urbanairship.javascript.JavaScriptEnvironment;
import com.urbanairship.javascript.NativeBridge;
import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class AirshipWebViewClient extends WebViewClient {
    private final Map authRequestCredentials;
    private boolean faviconEnabled;
    private final List listeners;
    private final NativeBridge nativeBridge;
    private final Map pendingNativeBridgeLoads;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface Listener {
        boolean onClose(@NonNull WebView webView);

        void onPageFinished(@NonNull WebView webView, @Nullable String str);

        void onReceivedError(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest, @NonNull WebResourceError webResourceError);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected ActionRunRequest extendActionRequest(@NonNull ActionRunRequest actionRunRequest, @NonNull WebView webView) {
        return actionRunRequest;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void onAirshipCommand(@NonNull WebView webView, @NonNull String str, @NonNull Uri uri) {
    }

    public AirshipWebViewClient() {
        this(new NativeBridge());
    }

    protected AirshipWebViewClient(@NonNull NativeBridge nativeBridge) {
        this.authRequestCredentials = new HashMap();
        this.pendingNativeBridgeLoads = new WeakHashMap();
        this.faviconEnabled = false;
        this.listeners = new CopyOnWriteArrayList();
        this.nativeBridge = nativeBridge;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (webView == null || webResourceRequest == null || webResourceError == null) {
            return;
        }
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    @NonNull
    @CallSuper
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected JavaScriptEnvironment.Builder extendJavascriptEnvironment(@NonNull JavaScriptEnvironment.Builder builder, @NonNull WebView webView) {
        return builder.addGetter("getDeviceModel", Build.MODEL).addGetter("getChannelId", UAirship.shared().getChannel().getId()).addGetter("getAppKey", UAirship.shared().getAirshipConfigOptions().appKey).addGetter("getNamedUser", UAirship.shared().getContact().getNamedUserId());
    }

    protected void onClose(@NonNull WebView webView) {
        boolean z;
        loop0: while (true) {
            for (Listener listener : this.listeners) {
                z = z || listener.onClose(webView);
            }
        }
        if (z) {
            return;
        }
        webView.getRootView().dispatchKeyEvent(new KeyEvent(0, 4));
        webView.getRootView().dispatchKeyEvent(new KeyEvent(1, 4));
    }

    public void setActionCompletionCallback(@Nullable ActionCompletionCallback actionCompletionCallback) {
        this.nativeBridge.setActionCompletionCallback(actionCompletionCallback);
    }

    @Override // android.webkit.WebViewClient
    @CallSuper
    public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @Nullable String str) {
        if (interceptUrl(webView, str)) {
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFaviconEnabled(boolean z) {
        this.faviconEnabled = z;
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    @CallSuper
    public WebResourceResponse shouldInterceptRequest(@NonNull WebView webView, @NonNull String str) {
        if (!this.faviconEnabled && str.toLowerCase().endsWith("/favicon.ico")) {
            return generateEmptyFaviconResponse(webView);
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    @SuppressLint({"NewApi"})
    @CallSuper
    public WebResourceResponse shouldInterceptRequest(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest) {
        String path;
        if (this.faviconEnabled) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        if (!webResourceRequest.isForMainFrame() && (path = webResourceRequest.getUrl().getPath()) != null && path.endsWith("/favicon.ico")) {
            return generateEmptyFaviconResponse(webView);
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    @CallSuper
    public void onLoadResource(@NonNull WebView webView, @Nullable String str) {
        interceptUrl(webView, str);
    }

    private boolean interceptUrl(final WebView webView, String str) {
        if (!isAllowed(webView.getUrl())) {
            return false;
        }
        return this.nativeBridge.onHandleCommand(str, new WebViewJavaScriptExecutor(webView), new ActionRunRequestExtender() { // from class: com.urbanairship.webkit.AirshipWebViewClient.1
            @Override // com.urbanairship.actions.ActionRunRequestExtender
            public ActionRunRequest extend(ActionRunRequest actionRunRequest) {
                return AirshipWebViewClient.this.extendActionRequest(actionRunRequest, webView);
            }
        }, new NativeBridge.CommandDelegate() { // from class: com.urbanairship.webkit.AirshipWebViewClient.2
            @Override // com.urbanairship.javascript.NativeBridge.CommandDelegate
            public void onClose() {
                AirshipWebViewClient.this.onClose(webView);
            }

            @Override // com.urbanairship.javascript.NativeBridge.CommandDelegate
            public void onAirshipCommand(String str2, Uri uri) {
                AirshipWebViewClient.this.onAirshipCommand(webView, str2, uri);
            }
        });
    }

    private WebResourceResponse generateEmptyFaviconResponse(WebView webView) {
        try {
            return new WebResourceResponse("image/png", null, new BufferedInputStream(webView.getContext().getResources().openRawResource(R.raw.ua_blank_favicon)));
        } catch (Exception e) {
            UALog.e(e, "Failed to read blank favicon with IOException.", new Object[0]);
            return null;
        }
    }

    @Override // android.webkit.WebViewClient
    @CallSuper
    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        InstrumentationCallbacks.onPageFinishedCalled(this, webView, str);
        if (webView == null) {
            return;
        }
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onPageFinished(webView, str);
        }
        if (!isAllowed(str)) {
            UALog.d("%s is not an allowed URL. Airship Javascript interface will not be accessible.", str);
            return;
        }
        this.pendingNativeBridgeLoads.put(webView, this.nativeBridge.loadJavaScriptEnvironment(webView.getContext(), extendJavascriptEnvironment(JavaScriptEnvironment.newBuilder(), webView).build(), new WebViewJavaScriptExecutor(webView)));
    }

    @Override // android.webkit.WebViewClient
    @CallSuper
    public void onPageStarted(@NonNull WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
        Cancelable cancelable = (Cancelable) this.pendingNativeBridgeLoads.get(webView);
        if (cancelable != null) {
            cancelable.cancel();
        }
    }

    protected boolean isAllowed(@Nullable String str) {
        return UAirship.shared().getUrlAllowList().isAllowed(str, 1);
    }

    @Override // android.webkit.WebViewClient
    @CallSuper
    public void onReceivedHttpAuthRequest(@NonNull WebView webView, @NonNull HttpAuthHandler httpAuthHandler, @Nullable String str, @Nullable String str2) {
        Credentials credentials = (Credentials) this.authRequestCredentials.get(str);
        if (credentials != null) {
            httpAuthHandler.proceed(credentials.username, credentials.password);
        }
    }

    public void addAuthRequestCredentials(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        this.authRequestCredentials.put(str, new Credentials(str2, str3));
    }

    public void removeAuthRequestCredentials(@NonNull String str) {
        this.authRequestCredentials.remove(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void addListener(@NonNull Listener listener) {
        this.listeners.add(listener);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void removeListener(@NonNull Listener listener) {
        this.listeners.remove(listener);
    }

    private static class Credentials {
        final String password;
        final String username;

        Credentials(String str, String str2) {
            this.username = str;
            this.password = str2;
        }
    }
}
