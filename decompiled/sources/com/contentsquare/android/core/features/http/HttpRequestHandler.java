package com.contentsquare.android.core.features.http;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/contentsquare/android/core/features/http/HttpRequestHandler;", "", "handleGet", "Lcom/contentsquare/android/core/features/http/HttpResponse;", "options", "Lcom/contentsquare/android/core/features/http/RequestOptions;", "handlePost", "data", "", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface HttpRequestHandler {
    @NotNull
    HttpResponse handleGet(RequestOptions options);

    @NotNull
    HttpResponse handlePost(RequestOptions options, byte[] data);
}
