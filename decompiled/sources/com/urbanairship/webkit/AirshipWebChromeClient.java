package com.urbanairship.webkit;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.UALog;
import com.urbanairship.util.UriUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes5.dex */
public class AirshipWebChromeClient extends WebChromeClient {
    private static final List SPECIAL_SCHEMES = Arrays.asList("tel", "sms", "mailto");
    private View customView;
    private final WeakReference weakActivity;

    public AirshipWebChromeClient(@Nullable Activity activity) {
        this.weakActivity = new WeakReference(activity);
    }

    @Override // android.webkit.WebChromeClient
    @Nullable
    public Bitmap getDefaultVideoPoster() {
        return Bitmap.createBitmap(new int[]{0}, 1, 1, Bitmap.Config.ARGB_8888);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(@NonNull View view, @NonNull WebChromeClient.CustomViewCallback customViewCallback) {
        Activity activity = (Activity) this.weakActivity.get();
        if (activity == null) {
            return;
        }
        View view2 = this.customView;
        if (view2 != null) {
            ((ViewGroup) view2.getParent()).removeView(this.customView);
        }
        this.customView = view;
        view.setBackgroundColor(-16777216);
        activity.getWindow().setFlags(1024, 1024);
        activity.getWindow().addContentView(this.customView, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        Activity activity = (Activity) this.weakActivity.get();
        if (activity == null || this.customView == null) {
            return;
        }
        activity.getWindow().clearFlags(1024);
        ((ViewGroup) this.customView.getParent()).removeView(this.customView);
        this.customView = null;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        if (!z2 || message == null || !(message.obj instanceof WebView.WebViewTransport)) {
            return false;
        }
        WebView webView2 = new WebView(webView.getContext());
        webView2.setWebViewClient(new WebViewClient() { // from class: com.urbanairship.webkit.AirshipWebChromeClient.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView3, String str) {
                if (str == null) {
                    return true;
                }
                Uri uri = Uri.parse(str);
                boolean zEquals = "uairship".equals(uri.getScheme());
                if ((!AirshipWebChromeClient.SPECIAL_SCHEMES.contains(uri.getScheme()) && uri.getHost() == null) || zEquals) {
                    return false;
                }
                Intent intent = new Intent("android.intent.action.VIEW", UriUtils.parse(str));
                intent.addFlags(268435456);
                try {
                    webView3.getContext().startActivity(intent);
                    return true;
                } catch (ActivityNotFoundException e) {
                    UALog.e(e);
                    return true;
                }
            }
        });
        ((WebView.WebViewTransport) message.obj).setWebView(webView2);
        message.sendToTarget();
        return true;
    }
}
