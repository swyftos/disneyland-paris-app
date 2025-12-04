package com.contentsquare.android.error.analysis.util;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/contentsquare/android/error/analysis/util/URLWrapper;", "", "url", "Ljava/net/URL;", "(Ljava/net/URL;)V", "openConnection", "Ljava/net/URLConnection;", "toString", "", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class URLWrapper {

    @NotNull
    private final URL url;

    public URLWrapper(URL url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
    }

    @NotNull
    public final URLConnection openConnection() throws IOException {
        URLConnection uRLConnectionOpenConnection = this.url.openConnection();
        Intrinsics.checkNotNullExpressionValue(uRLConnectionOpenConnection, "url.openConnection()");
        return uRLConnectionOpenConnection;
    }

    @NotNull
    public String toString() {
        String string = this.url.toString();
        Intrinsics.checkNotNullExpressionValue(string, "url.toString()");
        return string;
    }
}
