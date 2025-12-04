package com.amazonaws.internal.config;

/* loaded from: classes2.dex */
public class HttpClientConfig {
    private final String serviceName;

    HttpClientConfig(String str) {
        this.serviceName = str;
    }

    public String toString() {
        return "serviceName: " + this.serviceName;
    }

    public String getServiceName() {
        return this.serviceName;
    }
}
