package com.urbanairship.webkit;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Base64;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.urbanairship.UALog;
import com.urbanairship.util.ManifestUtils;
import java.util.Map;

/* loaded from: classes5.dex */
public class AirshipWebView extends WebView {
    private String currentClientAuthRequestUrl;
    private boolean isStartSafeBrowsingAttempted;
    private WebViewClient webViewClient;

    protected void initializeView() {
    }

    protected void populateCustomJavascriptInterfaces() {
    }

    public AirshipWebView(@NonNull Context context) {
        this(context, null);
    }

    public AirshipWebView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.webViewStyle);
    }

    public AirshipWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isStartSafeBrowsingAttempted = false;
        if (isInEditMode()) {
            return;
        }
        init(context, attributeSet, i, 0);
    }

    @TargetApi(21)
    public AirshipWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.isStartSafeBrowsingAttempted = false;
        if (isInEditMode()) {
            return;
        }
        init(context, attributeSet, i, i2);
    }

    private void init(Context context, AttributeSet attributeSet, int i, int i2) {
        WebSettings settings = getSettings();
        settings.setDomStorageEnabled(true);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.urbanairship.R.styleable.AirshipWebView, i, i2);
            try {
                settings.setMixedContentMode(typedArrayObtainStyledAttributes.getInteger(com.urbanairship.R.styleable.AirshipWebView_mixed_content_mode, 2));
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowContentAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(-1);
        if (ManifestUtils.shouldEnableLocalStorage()) {
            UALog.v("Application contains metadata to enable local storage", new Object[0]);
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
        }
        initializeView();
        populateCustomJavascriptInterfaces();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadData$0(String str, String str2, String str3) {
        super.loadData(str, str2, str3);
    }

    @Override // android.webkit.WebView
    public void loadData(@NonNull final String str, @Nullable final String str2, @Nullable final String str3) {
        onPreLoad(new Runnable() { // from class: com.urbanairship.webkit.AirshipWebView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadData$0(str, str2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadDataWithBaseURL$1(String str, String str2, String str3, String str4, String str5) {
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(@Nullable final String str, @NonNull final String str2, @Nullable final String str3, @Nullable final String str4, @Nullable final String str5) {
        onPreLoad(new Runnable() { // from class: com.urbanairship.webkit.AirshipWebView$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadDataWithBaseURL$1(str, str2, str3, str4, str5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadUrl$2(String str) {
        super.loadUrl(str);
    }

    @Override // android.webkit.WebView
    public void loadUrl(@NonNull final String str) {
        onPreLoad(new Runnable() { // from class: com.urbanairship.webkit.AirshipWebView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadUrl$2(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadUrl$3(String str, Map map) {
        super.loadUrl(str, map);
    }

    @Override // android.webkit.WebView
    public void loadUrl(@NonNull final String str, @NonNull final Map<String, String> map) {
        onPreLoad(new Runnable() { // from class: com.urbanairship.webkit.AirshipWebView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadUrl$3(str, map);
            }
        });
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(@NonNull WebViewClient webViewClient) {
        if (!(webViewClient instanceof AirshipWebViewClient)) {
            UALog.w("The web view client should extend AirshipWebViewClient to support Airship url overrides and triggering actions from.", new Object[0]);
        }
        this.webViewClient = webViewClient;
        super.setWebViewClient(webViewClient);
    }

    protected void onPreLoad(@NonNull final Runnable runnable) {
        if (getWebViewClientCompat() == null) {
            UALog.d("No web view client set, setting a default AirshipWebViewClient for landing page view.", new Object[0]);
            setWebViewClient(new AirshipWebViewClient());
        }
        if (this.currentClientAuthRequestUrl != null && getWebViewClientCompat() != null && (getWebViewClientCompat() instanceof AirshipWebViewClient)) {
            ((AirshipWebViewClient) getWebViewClientCompat()).removeAuthRequestCredentials(this.currentClientAuthRequestUrl);
            this.currentClientAuthRequestUrl = null;
        }
        if (!this.isStartSafeBrowsingAttempted && shouldStartSafeBrowsing()) {
            WebViewCompat.startSafeBrowsing(getContext().getApplicationContext(), new ValueCallback() { // from class: com.urbanairship.webkit.AirshipWebView$$ExternalSyntheticLambda2
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    this.f$0.lambda$onPreLoad$4(runnable, (Boolean) obj);
                }
            });
            return;
        }
        UALog.d("Unable to start Safe Browsing. Feature is not supported or disabled in the manifest.", new Object[0]);
        this.isStartSafeBrowsingAttempted = true;
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPreLoad$4(Runnable runnable, Boolean bool) {
        if (!bool.booleanValue()) {
            UALog.d("Unable to start Safe Browsing. Feature is not supported or disabled in the manifest.", new Object[0]);
        }
        this.isStartSafeBrowsingAttempted = true;
        runnable.run();
    }

    @Nullable
    WebViewClient getWebViewClientCompat() {
        return this.webViewClient;
    }

    protected void setClientAuthRequest(@Nullable String str, @NonNull String str2, @NonNull String str3) {
        this.currentClientAuthRequestUrl = str;
        if (getWebViewClientCompat() == null || !(getWebViewClientCompat() instanceof AirshipWebViewClient)) {
            return;
        }
        AirshipWebViewClient airshipWebViewClient = (AirshipWebViewClient) getWebViewClientCompat();
        String host = Uri.parse(str).getHost();
        if (host != null) {
            airshipWebViewClient.addAuthRequestCredentials(host, str2, str3);
        }
    }

    @NonNull
    protected String createBasicAuth(@NonNull String str, @NonNull String str2) {
        return "Basic " + Base64.encodeToString((str + ":" + str2).getBytes(), 2);
    }

    private boolean shouldStartSafeBrowsing() {
        return WebViewFeature.isFeatureSupported("START_SAFE_BROWSING") && WebViewFeature.isFeatureSupported("SAFE_BROWSING_ENABLE") && WebSettingsCompat.getSafeBrowsingEnabled(getSettings()) && ManifestUtils.isWebViewSafeBrowsingEnabled();
    }
}
