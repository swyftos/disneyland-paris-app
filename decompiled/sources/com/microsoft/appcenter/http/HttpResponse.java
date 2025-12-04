package com.microsoft.appcenter.http;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class HttpResponse {
    private final Map headers;
    private final String payload;
    private final int statusCode;

    public HttpResponse(int i) {
        this(i, "");
    }

    public HttpResponse(int i, @NonNull String str) {
        this(i, str, new HashMap());
    }

    public HttpResponse(int i, @NonNull String str, @NonNull Map<String, String> map) {
        this.payload = str;
        this.statusCode = i;
        this.headers = map;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    @NonNull
    public String getPayload() {
        return this.payload;
    }

    @NonNull
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HttpResponse httpResponse = (HttpResponse) obj;
        return this.statusCode == httpResponse.statusCode && this.payload.equals(httpResponse.payload) && this.headers.equals(httpResponse.headers);
    }

    public int hashCode() {
        return (((this.statusCode * 31) + this.payload.hashCode()) * 31) + this.headers.hashCode();
    }
}
