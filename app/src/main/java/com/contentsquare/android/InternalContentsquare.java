package com.contentsquare.android;

import com.contentsquare.android.core.features.http.HttpConnection;
import com.contentsquare.android.core.features.http.HttpRequestHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/contentsquare/android/InternalContentsquare;", "", "()V", "setHttpRequestHandler", "", "httpRequestHandler", "Lcom/contentsquare/android/core/features/http/HttpRequestHandler;", "core_release"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
public final class InternalContentsquare {

    @NotNull
    public static final InternalContentsquare INSTANCE = new InternalContentsquare();

    private InternalContentsquare() {
    }

    public final void setHttpRequestHandler(HttpRequestHandler httpRequestHandler) {
        Intrinsics.checkNotNullParameter(httpRequestHandler, "httpRequestHandler");
        HttpConnection.INSTANCE.setRequestHandler$core_release(httpRequestHandler);
    }
}
