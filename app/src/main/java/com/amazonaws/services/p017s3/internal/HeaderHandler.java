package com.amazonaws.services.p017s3.internal;

import com.amazonaws.http.HttpResponse;

/* JADX INFO: loaded from: classes2.dex */
public interface HeaderHandler<T> {
    void handle(T t, HttpResponse httpResponse);
}
