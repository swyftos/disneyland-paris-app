package com.contentsquare.android.sdk;

/* loaded from: classes2.dex */
public final /* synthetic */ class y8 {
    public static /* synthetic */ int a(String str) {
        if (str == null) {
            throw new NullPointerException("Name is null");
        }
        if (str.equals("DEBUG")) {
            return 1;
        }
        if (str.equals("WARN")) {
            return 2;
        }
        if (str.equals("ERROR")) {
            return 3;
        }
        if (str.equals("CRITICAL")) {
            return 4;
        }
        throw new IllegalArgumentException("No enum constant com.contentsquare.android.analytics.internal.uigestureinterceptor.webview.WebViewAnalyticsEventProcessor.LogLevel.".concat(str));
    }
}
