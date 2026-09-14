package com.contentsquare.android.sdk;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.y8 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C2939y8 {
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ int m1238a(String str) {
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
