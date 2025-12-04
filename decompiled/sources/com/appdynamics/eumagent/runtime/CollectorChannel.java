package com.appdynamics.eumagent.runtime;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DontObfuscate
/* loaded from: classes2.dex */
public abstract class CollectorChannel {
    private int connectTimeout;
    private int readTimeout;
    private String requestMethod;
    private Map<String, List<String>> requestProperties = new HashMap();
    private URL url;

    public abstract Map<String, List<String>> getHeaderFields();

    public abstract InputStream getInputStream();

    public abstract OutputStream getOutputStream();

    public abstract int getResponseCode();

    public void setURL(URL url) {
        this.url = url;
    }

    public URL getURL() {
        return this.url;
    }

    public void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public void addRequestProperty(String str, String str2) {
        if (!this.requestProperties.containsKey(str)) {
            this.requestProperties.put(str, new ArrayList());
        }
        this.requestProperties.get(str).add(str2);
    }

    public Map<String, List<String>> getRequestProperties() {
        return Collections.unmodifiableMap(this.requestProperties);
    }

    public void setRequestMethod(String str) {
        this.requestMethod = str;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }
}
