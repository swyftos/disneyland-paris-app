package com.urbanairship.webkit;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.urbanairship.javascript.JavaScriptExecutor;
import java.lang.ref.WeakReference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class WebViewJavaScriptExecutor implements JavaScriptExecutor {
    private final WeakReference weakReference;

    public WebViewJavaScriptExecutor(@NonNull WebView webView) {
        this.weakReference = new WeakReference(webView);
    }

    @Override // com.urbanairship.javascript.JavaScriptExecutor
    public void executeJavaScript(@NonNull String str) {
        WebView webView = (WebView) this.weakReference.get();
        if (webView != null) {
            webView.evaluateJavascript(str, null);
        }
    }
}
