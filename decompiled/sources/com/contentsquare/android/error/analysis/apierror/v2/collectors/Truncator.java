package com.contentsquare.android.error.analysis.apierror.v2.collectors;

import com.contentsquare.android.error.analysis.apierror.ApiErrorConstants;
import com.contentsquare.android.error.analysis.apierror.encryption.SymmetricCryptor;
import com.contentsquare.android.error.analysis.apierror.v2.ApiErrorTelemetrySender;
import com.contentsquare.android.error.analysis.apierror.v2.ApiErrorsType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020!R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u000e\u0010\u0017\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/v2/collectors/Truncator;", "", "symmetricCryptor", "Lcom/contentsquare/android/error/analysis/apierror/encryption/SymmetricCryptor;", "plainHeaders", "", "", "headersToEncrypt", "standardHeaders", "type", "Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorsType;", "(Lcom/contentsquare/android/error/analysis/apierror/encryption/SymmetricCryptor;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorsType;)V", "encryptedSize", "", "getHeadersToEncrypt", "()Ljava/util/Map;", "getPlainHeaders", "plainSize", "shouldCollectEncryptedHeaders", "", "shouldCollectPlainHeaders", "shouldCollectStandardHeaders", "getStandardHeaders", "standardSize", "getSymmetricCryptor", "()Lcom/contentsquare/android/error/analysis/apierror/encryption/SymmetricCryptor;", "getType", "()Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorsType;", "reportTelemetry", "", "telemetrySender", "Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorTelemetrySender;", "truncateHeaders", "Lcom/contentsquare/android/error/analysis/apierror/v2/collectors/ProcessedHeaders;", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHeaderCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HeaderCollector.kt\ncom/contentsquare/android/error/analysis/apierror/v2/collectors/Truncator\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,201:1\n1#2:202\n483#3,7:203\n*S KotlinDebug\n*F\n+ 1 HeaderCollector.kt\ncom/contentsquare/android/error/analysis/apierror/v2/collectors/Truncator\n*L\n99#1:203,7\n*E\n"})
/* loaded from: classes2.dex */
final class Truncator {
    private final long encryptedSize;

    @NotNull
    private final Map<String, String> headersToEncrypt;

    @NotNull
    private final Map<String, String> plainHeaders;
    private final long plainSize;
    private final boolean shouldCollectEncryptedHeaders;
    private final boolean shouldCollectPlainHeaders;
    private final boolean shouldCollectStandardHeaders;

    @NotNull
    private final Map<String, String> standardHeaders;
    private final long standardSize;

    @NotNull
    private final SymmetricCryptor symmetricCryptor;

    @NotNull
    private final ApiErrorsType type;

    public Truncator(SymmetricCryptor symmetricCryptor, Map<String, String> plainHeaders, Map<String, String> headersToEncrypt, Map<String, String> standardHeaders, ApiErrorsType type) {
        Intrinsics.checkNotNullParameter(symmetricCryptor, "symmetricCryptor");
        Intrinsics.checkNotNullParameter(plainHeaders, "plainHeaders");
        Intrinsics.checkNotNullParameter(headersToEncrypt, "headersToEncrypt");
        Intrinsics.checkNotNullParameter(standardHeaders, "standardHeaders");
        Intrinsics.checkNotNullParameter(type, "type");
        this.symmetricCryptor = symmetricCryptor;
        this.plainHeaders = plainHeaders;
        this.headersToEncrypt = headersToEncrypt;
        this.standardHeaders = standardHeaders;
        this.type = type;
        long jSizeInBytes = HeaderCollectorKt.sizeInBytes(standardHeaders);
        this.standardSize = jSizeInBytes;
        long jSizeInBytes2 = HeaderCollectorKt.sizeInBytes(headersToEncrypt);
        this.encryptedSize = jSizeInBytes2;
        long jSizeInBytes3 = HeaderCollectorKt.sizeInBytes(plainHeaders);
        this.plainSize = jSizeInBytes3;
        this.shouldCollectPlainHeaders = jSizeInBytes3 < ApiErrorConstants.HEADERS_MAX_SIZE;
        long j = jSizeInBytes3 + jSizeInBytes2;
        this.shouldCollectEncryptedHeaders = j < ApiErrorConstants.HEADERS_MAX_SIZE;
        this.shouldCollectStandardHeaders = j + jSizeInBytes < ApiErrorConstants.HEADERS_MAX_SIZE;
    }

    @NotNull
    public final Map<String, String> getHeadersToEncrypt() {
        return this.headersToEncrypt;
    }

    @NotNull
    public final Map<String, String> getPlainHeaders() {
        return this.plainHeaders;
    }

    @NotNull
    public final Map<String, String> getStandardHeaders() {
        return this.standardHeaders;
    }

    @NotNull
    public final SymmetricCryptor getSymmetricCryptor() {
        return this.symmetricCryptor;
    }

    @NotNull
    public final ApiErrorsType getType() {
        return this.type;
    }

    public final void reportTelemetry(ApiErrorTelemetrySender telemetrySender) {
        Intrinsics.checkNotNullParameter(telemetrySender, "telemetrySender");
        if (!this.shouldCollectPlainHeaders) {
            telemetrySender.sendTelemetry(this.type == ApiErrorsType.REQUEST ? ApiErrorTelemetrySender.PLAIN_REQUEST_HEADERS_TOO_LARGE : ApiErrorTelemetrySender.PLAIN_RESPONSE_HEADERS_TOO_LARGE, this.plainSize, ApiErrorConstants.HEADERS_MAX_SIZE);
        }
        if (this.shouldCollectEncryptedHeaders) {
            return;
        }
        telemetrySender.sendTelemetry(this.type == ApiErrorsType.REQUEST ? ApiErrorTelemetrySender.ENCRYPTED_REQUEST_HEADERS_TOO_LARGE : ApiErrorTelemetrySender.ENCRYPTED_RESPONSE_HEADERS_TOO_LARGE, this.encryptedSize, ApiErrorConstants.HEADERS_MAX_SIZE - this.plainSize);
    }

    @NotNull
    public final ProcessedHeaders truncateHeaders() {
        Map<String, String> truncated_map;
        Map<String, String> truncated_map2 = null;
        if (this.shouldCollectPlainHeaders) {
            truncated_map = this.plainHeaders;
            if (truncated_map.isEmpty()) {
                truncated_map = null;
            }
        } else {
            truncated_map = ApiErrorConstants.INSTANCE.getTRUNCATED_MAP();
        }
        Map<String, String> map = this.headersToEncrypt;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!StringsKt.isBlank(entry.getValue())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        byte[] bArrEncryptAsJson = this.shouldCollectEncryptedHeaders ? linkedHashMap.isEmpty() ? null : HeaderCollectorKt.encryptAsJson(this.symmetricCryptor, linkedHashMap) : ApiErrorConstants.INSTANCE.getSUPPRESSED_MESSAGE_MARKER();
        if (this.shouldCollectStandardHeaders) {
            Map<String, String> map2 = this.standardHeaders;
            if (!map2.isEmpty()) {
                truncated_map2 = map2;
            }
        } else {
            truncated_map2 = ApiErrorConstants.INSTANCE.getTRUNCATED_MAP();
        }
        return new ProcessedHeaders(truncated_map, bArrEncryptAsJson, truncated_map2);
    }
}
