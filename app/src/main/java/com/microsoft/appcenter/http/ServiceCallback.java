package com.microsoft.appcenter.http;

/* JADX INFO: loaded from: classes4.dex */
public interface ServiceCallback {
    void onCallFailed(Exception exc);

    void onCallSucceeded(HttpResponse httpResponse);
}
