package com.contentsquare.android.error.analysis.apierror.v2.collectors;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B;\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/v2/collectors/ProcessedHeaders;", "", "plainHeaders", "", "", "encryptedHeaders", "", "standardHeaders", "(Ljava/util/Map;[BLjava/util/Map;)V", "getEncryptedHeaders", "()[B", "getPlainHeaders", "()Ljava/util/Map;", "getStandardHeaders", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
final class ProcessedHeaders {

    @Nullable
    private final byte[] encryptedHeaders;

    @Nullable
    private final Map<String, String> plainHeaders;

    @Nullable
    private final Map<String, String> standardHeaders;

    public ProcessedHeaders(Map<String, String> map, byte[] bArr, Map<String, String> map2) {
        this.plainHeaders = map;
        this.encryptedHeaders = bArr;
        this.standardHeaders = map2;
    }

    @Nullable
    public final byte[] getEncryptedHeaders() {
        return this.encryptedHeaders;
    }

    @Nullable
    public final Map<String, String> getPlainHeaders() {
        return this.plainHeaders;
    }

    @Nullable
    public final Map<String, String> getStandardHeaders() {
        return this.standardHeaders;
    }
}
