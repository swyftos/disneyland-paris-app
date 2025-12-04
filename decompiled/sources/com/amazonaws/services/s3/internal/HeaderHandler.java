package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;

/* loaded from: classes2.dex */
public interface HeaderHandler<T> {
    void handle(T t, HttpResponse httpResponse);
}
