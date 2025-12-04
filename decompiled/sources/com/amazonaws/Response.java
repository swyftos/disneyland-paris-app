package com.amazonaws;

import com.amazonaws.http.HttpResponse;

/* loaded from: classes2.dex */
public final class Response<T> {
    private final HttpResponse httpResponse;
    private final Object response;

    public Response(T t, HttpResponse httpResponse) {
        this.response = t;
        this.httpResponse = httpResponse;
    }

    public T getAwsResponse() {
        return (T) this.response;
    }

    public HttpResponse getHttpResponse() {
        return this.httpResponse;
    }
}
