package com.contentsquare.android.error.analysis.apierror.v1.processors;

import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.GzipUtil;
import com.contentsquare.android.error.analysis.apierror.ApiErrorConstants;
import com.contentsquare.android.error.analysis.util.ExtensionsKt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J$\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0017\u0010\u0010\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0002\b\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventCompressor;", "", "()V", "os", "Ljava/io/ByteArrayOutputStream;", "compress", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "event", "gzip", "", "value", "resize", "maxSize", "", "defaultValue", "", "unzip", "unzip$error_analysis_release", "Companion", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNetworkEventCompressor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkEventCompressor.kt\ncom/contentsquare/android/error/analysis/apierror/v1/processors/NetworkEventCompressor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,106:1\n1#2:107\n*E\n"})
/* loaded from: classes2.dex */
public final class NetworkEventCompressor {

    @NotNull
    public static final String SUPPRESSED_MESSAGE_EMPTY = "";

    @NotNull
    public static final String SUPPRESSED_MESSAGE_MARKER = "…";

    @NotNull
    private final ByteArrayOutputStream os = new ByteArrayOutputStream();

    private final byte[] gzip(byte[] value) {
        Charset charset = Charsets.UTF_8;
        byte[] bytes = "…".getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        if (!Arrays.equals(value, bytes)) {
            byte[] bytes2 = "".getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            if (!Arrays.equals(value, bytes2)) {
                byte[] bArrCompress = null;
                try {
                    if (value != null) {
                        try {
                            bArrCompress = GzipUtil.INSTANCE.compress(value, this.os);
                        } catch (IOException e) {
                            new Logger("NetworkEventCompressor").e("Error while gzipping api error details : " + e);
                        }
                    }
                    return bArrCompress;
                } finally {
                    this.os.reset();
                }
            }
        }
        return value;
    }

    private final byte[] resize(byte[] value, long maxSize, String defaultValue) {
        if (value == null) {
            return null;
        }
        if (value.length <= maxSize) {
            return value;
        }
        byte[] bytes = defaultValue.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @NotNull
    public final NetworkEvent compress(NetworkEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        byte[] bArrGzip = gzip(resize(event.getRequestBody(), 64000L, "…"));
        byte[] responseBody = event.getResponseBody();
        return NetworkEvent.copy$default(event, 0L, null, null, 0, 0L, 0L, bArrGzip, null, gzip(resize(responseBody != null ? ExtensionsKt.truncateBody(responseBody) : null, 5000L, "…")), null, null, null, resize(event.getCustomRequestHeaders(), ApiErrorConstants.HEADERS_MAX_SIZE, ""), resize(event.getCustomResponseHeaders(), ApiErrorConstants.HEADERS_MAX_SIZE, ""), gzip(resize(event.getQueryParameters(), 2000L, "…")), null, null, null, null, null, null, null, null, null, null, null, null, null, 268406463, null);
    }

    @VisibleForTesting
    @NotNull
    public final byte[] unzip$error_analysis_release(byte[] value) {
        byte[] bArrDecompress;
        return (value == null || (bArrDecompress = GzipUtil.INSTANCE.decompress(value)) == null) ? new byte[0] : bArrDecompress;
    }
}
