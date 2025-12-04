package com.microsoft.appcenter;

import com.microsoft.appcenter.http.HttpClient;

/* loaded from: classes4.dex */
public final class DependencyConfiguration {
    private static HttpClient sHttpClient;

    public static HttpClient getHttpClient() {
        return sHttpClient;
    }

    public static void setHttpClient(HttpClient httpClient) {
        sHttpClient = httpClient;
    }
}
