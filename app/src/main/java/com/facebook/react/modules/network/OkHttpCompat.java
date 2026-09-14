package com.facebook.react.modules.network;

import java.util.Collections;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes3.dex */
public class OkHttpCompat {
    public static CookieJarContainer getCookieJarContainer(OkHttpClient okHttpClient) {
        return (CookieJarContainer) okHttpClient.cookieJar();
    }

    public static Headers getHeadersFromMap(Map<String, String> map) {
        if (map == null) {
            return Headers.m1924of((Map<String, String>) Collections.emptyMap());
        }
        return Headers.m1924of(map);
    }
}
