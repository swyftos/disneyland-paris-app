package com.amazonaws.http;

import com.amazonaws.util.StringUtils;
import java.io.InputStream;
import java.net.URI;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public class HttpRequest {
    private final InputStream content;
    private final Map headers;
    private boolean isStreaming;
    private final String method;
    private URI uri;

    public HttpRequest(String str, URI uri) {
        this(str, uri, null, null);
    }

    public HttpRequest(String str, URI uri, Map<String, String> map, InputStream inputStream) {
        Map mapUnmodifiableMap;
        this.method = StringUtils.upperCase(str);
        this.uri = uri;
        if (map == null) {
            mapUnmodifiableMap = Collections.EMPTY_MAP;
        } else {
            mapUnmodifiableMap = Collections.unmodifiableMap(map);
        }
        this.headers = mapUnmodifiableMap;
        this.content = inputStream;
    }

    public String getMethod() {
        return this.method;
    }

    public URI getUri() {
        return this.uri;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public InputStream getContent() {
        return this.content;
    }

    public long getContentLength() {
        String str;
        Map map = this.headers;
        if (map == null || (str = (String) map.get("Content-Length")) == null || str.isEmpty()) {
            return 0L;
        }
        return Long.valueOf(str).longValue();
    }

    public boolean isStreaming() {
        return this.isStreaming;
    }

    public void setStreaming(boolean z) {
        this.isStreaming = z;
    }
}
