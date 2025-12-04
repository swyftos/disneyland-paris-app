package com.contentsquare.android.core.features.http;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/android/core/features/http/HttpStatusCode;", "", "()V", "checkStatus", "Lcom/contentsquare/android/core/features/http/HttpStatusCodeCategory;", "statusCode", "", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HttpStatusCode {

    @NotNull
    public static final HttpStatusCode INSTANCE = new HttpStatusCode();

    private HttpStatusCode() {
    }

    @NotNull
    public final HttpStatusCodeCategory checkStatus(int statusCode) {
        return (100 > statusCode || statusCode >= 200) ? (200 > statusCode || statusCode >= 300) ? (300 > statusCode || statusCode >= 400) ? (400 > statusCode || statusCode >= 500) ? (500 > statusCode || statusCode >= 600) ? HttpStatusCodeCategory.UNDEFINED : HttpStatusCodeCategory.SERVER_ERROR : HttpStatusCodeCategory.CLIENT_ERROR : HttpStatusCodeCategory.REDIRECTION : HttpStatusCodeCategory.SUCCESS : HttpStatusCodeCategory.INFORMATIONAL;
    }
}
