package com.microsoft.appcenter.utils.async;

/* loaded from: classes4.dex */
public interface AppCenterFuture<T> {
    T get();

    boolean isDone();

    void thenAccept(AppCenterConsumer<T> appCenterConsumer);
}
