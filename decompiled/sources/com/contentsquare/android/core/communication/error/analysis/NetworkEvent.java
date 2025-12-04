package com.contentsquare.android.core.communication.error.analysis;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.media3.common.C;
import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.error.analysis.apierror.v2.EventProcessorPerformanceManager;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.util.PendingIntentCompat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\bM\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001d\u0012\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\f\u0012\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\f\u0012\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011\u0012\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\u0002\u0010$J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010:J\u0017\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003J\u0017\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010*J\u0017\u0010U\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\u0017\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\u0011\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001dHÆ\u0003J\u0017\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0017\u0010\\\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0017\u0010^\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003J\u0017\u0010_\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0003J\t\u0010`\u001a\u00020\u0005HÆ\u0003J\t\u0010a\u001a\u00020\bHÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010:J\u000b\u0010f\u001a\u0004\u0018\u00010\fHÆ\u0003J¶\u0003\u0010g\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00052\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001d2\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010hJ\u0006\u0010i\u001a\u00020\u0000J\u0013\u0010j\u001a\u00020k2\b\u0010l\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010m\u001a\u00020\bH\u0016J\t\u0010n\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010&R\u0019\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001f\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001f\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b3\u00102R\u001f\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b4\u00102R\u001f\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b5\u00102R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b6\u0010&R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b7\u0010&R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b8\u0010&R\u0015\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u001f\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b<\u00102R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b?\u0010&R\u0013\u0010!\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b@\u0010&R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010;\u001a\u0004\bA\u0010:R\u001f\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\bB\u00102R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010>R\u0011\u0010\u001b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bD\u0010-R\u001f\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\bE\u00102R\u001f\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\bF\u00102R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010>R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010-¨\u0006o"}, d2 = {"Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "", "timestampMs", "", "httpMethod", "", "url", "statusCode", "", "requestTime", "responseTime", "requestBody", "", EventProcessorPerformanceManager.LOG_EVENT_REQUEST_BODY_SIZE, "responseBody", EventProcessorPerformanceManager.LOG_EVENT_RESPONSE_BODY_SIZE, "standardRequestHeaders", "", "standardResponseHeaders", "customRequestHeaders", "customResponseHeaders", "queryParameters", "initializationVector", "encryptedSymmetricKey", "encryptionPublicKeyId", "requestHeaders", "responseHeaders", "source", "matchingBodyContents", "", "plainRequestBodyAttributes", "requestBodyAttributes", "plainResponseBodyAttributes", "responseBodyAttributes", "plainCustomRequestHeaders", "plainCustomResponseHeaders", "(JLjava/lang/String;Ljava/lang/String;IJJ[BLjava/lang/Integer;[BLjava/lang/Integer;Ljava/util/Map;Ljava/util/Map;[B[B[B[B[BLjava/lang/Long;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;[BLjava/util/Map;[BLjava/util/Map;Ljava/util/Map;)V", "getCustomRequestHeaders", "()[B", "getCustomResponseHeaders", "getEncryptedSymmetricKey", "getEncryptionPublicKeyId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getHttpMethod", "()Ljava/lang/String;", "getInitializationVector", "getMatchingBodyContents", "()Ljava/util/List;", "getPlainCustomRequestHeaders", "()Ljava/util/Map;", "getPlainCustomResponseHeaders", "getPlainRequestBodyAttributes", "getPlainResponseBodyAttributes", "getQueryParameters", "getRequestBody", "getRequestBodyAttributes", "getRequestBodySize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRequestHeaders", "getRequestTime", "()J", "getResponseBody", "getResponseBodyAttributes", "getResponseBodySize", "getResponseHeaders", "getResponseTime", "getSource", "getStandardRequestHeaders", "getStandardResponseHeaders", "getStatusCode", "()I", "getTimestampMs", "getUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;IJJ[BLjava/lang/Integer;[BLjava/lang/Integer;Ljava/util/Map;Ljava/util/Map;[B[B[B[B[BLjava/lang/Long;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;[BLjava/util/Map;[BLjava/util/Map;Ljava/util/Map;)Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "copyWithoutDetails", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class NetworkEvent {

    @Nullable
    private final byte[] customRequestHeaders;

    @Nullable
    private final byte[] customResponseHeaders;

    @Nullable
    private final byte[] encryptedSymmetricKey;

    @Nullable
    private final Long encryptionPublicKeyId;

    @NotNull
    private final String httpMethod;

    @Nullable
    private final byte[] initializationVector;

    @Nullable
    private final List<String> matchingBodyContents;

    @Nullable
    private final Map<String, String> plainCustomRequestHeaders;

    @Nullable
    private final Map<String, String> plainCustomResponseHeaders;

    @Nullable
    private final Map<String, String> plainRequestBodyAttributes;

    @Nullable
    private final Map<String, String> plainResponseBodyAttributes;

    @Nullable
    private final byte[] queryParameters;

    @Nullable
    private final byte[] requestBody;

    @Nullable
    private final byte[] requestBodyAttributes;

    @Nullable
    private final Integer requestBodySize;

    @Nullable
    private final Map<String, String> requestHeaders;
    private final long requestTime;

    @Nullable
    private final byte[] responseBody;

    @Nullable
    private final byte[] responseBodyAttributes;

    @Nullable
    private final Integer responseBodySize;

    @Nullable
    private final Map<String, String> responseHeaders;
    private final long responseTime;

    @NotNull
    private final String source;

    @Nullable
    private final Map<String, String> standardRequestHeaders;

    @Nullable
    private final Map<String, String> standardResponseHeaders;
    private final int statusCode;
    private final long timestampMs;

    @NotNull
    private final String url;

    public NetworkEvent(long j, String httpMethod, String url, int i, long j2, long j3, byte[] bArr, Integer num, byte[] bArr2, Integer num2, Map<String, String> map, Map<String, String> map2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, Long l, Map<String, String> map3, Map<String, String> map4, String source, List<String> list, Map<String, String> map5, byte[] bArr8, Map<String, String> map6, byte[] bArr9, Map<String, String> map7, Map<String, String> map8) {
        Intrinsics.checkNotNullParameter(httpMethod, "httpMethod");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(source, "source");
        this.timestampMs = j;
        this.httpMethod = httpMethod;
        this.url = url;
        this.statusCode = i;
        this.requestTime = j2;
        this.responseTime = j3;
        this.requestBody = bArr;
        this.requestBodySize = num;
        this.responseBody = bArr2;
        this.responseBodySize = num2;
        this.standardRequestHeaders = map;
        this.standardResponseHeaders = map2;
        this.customRequestHeaders = bArr3;
        this.customResponseHeaders = bArr4;
        this.queryParameters = bArr5;
        this.initializationVector = bArr6;
        this.encryptedSymmetricKey = bArr7;
        this.encryptionPublicKeyId = l;
        this.requestHeaders = map3;
        this.responseHeaders = map4;
        this.source = source;
        this.matchingBodyContents = list;
        this.plainRequestBodyAttributes = map5;
        this.requestBodyAttributes = bArr8;
        this.plainResponseBodyAttributes = map6;
        this.responseBodyAttributes = bArr9;
        this.plainCustomRequestHeaders = map7;
        this.plainCustomResponseHeaders = map8;
    }

    public static /* synthetic */ NetworkEvent copy$default(NetworkEvent networkEvent, long j, String str, String str2, int i, long j2, long j3, byte[] bArr, Integer num, byte[] bArr2, Integer num2, Map map, Map map2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, Long l, Map map3, Map map4, String str3, List list, Map map5, byte[] bArr8, Map map6, byte[] bArr9, Map map7, Map map8, int i2, Object obj) {
        return networkEvent.copy((i2 & 1) != 0 ? networkEvent.timestampMs : j, (i2 & 2) != 0 ? networkEvent.httpMethod : str, (i2 & 4) != 0 ? networkEvent.url : str2, (i2 & 8) != 0 ? networkEvent.statusCode : i, (i2 & 16) != 0 ? networkEvent.requestTime : j2, (i2 & 32) != 0 ? networkEvent.responseTime : j3, (i2 & 64) != 0 ? networkEvent.requestBody : bArr, (i2 & 128) != 0 ? networkEvent.requestBodySize : num, (i2 & 256) != 0 ? networkEvent.responseBody : bArr2, (i2 & 512) != 0 ? networkEvent.responseBodySize : num2, (i2 & 1024) != 0 ? networkEvent.standardRequestHeaders : map, (i2 & 2048) != 0 ? networkEvent.standardResponseHeaders : map2, (i2 & 4096) != 0 ? networkEvent.customRequestHeaders : bArr3, (i2 & 8192) != 0 ? networkEvent.customResponseHeaders : bArr4, (i2 & 16384) != 0 ? networkEvent.queryParameters : bArr5, (i2 & 32768) != 0 ? networkEvent.initializationVector : bArr6, (i2 & 65536) != 0 ? networkEvent.encryptedSymmetricKey : bArr7, (i2 & 131072) != 0 ? networkEvent.encryptionPublicKeyId : l, (i2 & 262144) != 0 ? networkEvent.requestHeaders : map3, (i2 & 524288) != 0 ? networkEvent.responseHeaders : map4, (i2 & 1048576) != 0 ? networkEvent.source : str3, (i2 & 2097152) != 0 ? networkEvent.matchingBodyContents : list, (i2 & 4194304) != 0 ? networkEvent.plainRequestBodyAttributes : map5, (i2 & 8388608) != 0 ? networkEvent.requestBodyAttributes : bArr8, (i2 & 16777216) != 0 ? networkEvent.plainResponseBodyAttributes : map6, (i2 & PendingIntentCompat.FLAG_MUTABLE) != 0 ? networkEvent.responseBodyAttributes : bArr9, (i2 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? networkEvent.plainCustomRequestHeaders : map7, (i2 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? networkEvent.plainCustomResponseHeaders : map8);
    }

    /* renamed from: component1, reason: from getter */
    public final long getTimestampMs() {
        return this.timestampMs;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Integer getResponseBodySize() {
        return this.responseBodySize;
    }

    @Nullable
    public final Map<String, String> component11() {
        return this.standardRequestHeaders;
    }

    @Nullable
    public final Map<String, String> component12() {
        return this.standardResponseHeaders;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final byte[] getCustomRequestHeaders() {
        return this.customRequestHeaders;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final byte[] getCustomResponseHeaders() {
        return this.customResponseHeaders;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final byte[] getQueryParameters() {
        return this.queryParameters;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final byte[] getInitializationVector() {
        return this.initializationVector;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final byte[] getEncryptedSymmetricKey() {
        return this.encryptedSymmetricKey;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final Long getEncryptionPublicKeyId() {
        return this.encryptionPublicKeyId;
    }

    @Nullable
    public final Map<String, String> component19() {
        return this.requestHeaders;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getHttpMethod() {
        return this.httpMethod;
    }

    @Nullable
    public final Map<String, String> component20() {
        return this.responseHeaders;
    }

    @NotNull
    /* renamed from: component21, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    @Nullable
    public final List<String> component22() {
        return this.matchingBodyContents;
    }

    @Nullable
    public final Map<String, String> component23() {
        return this.plainRequestBodyAttributes;
    }

    @Nullable
    /* renamed from: component24, reason: from getter */
    public final byte[] getRequestBodyAttributes() {
        return this.requestBodyAttributes;
    }

    @Nullable
    public final Map<String, String> component25() {
        return this.plainResponseBodyAttributes;
    }

    @Nullable
    /* renamed from: component26, reason: from getter */
    public final byte[] getResponseBodyAttributes() {
        return this.responseBodyAttributes;
    }

    @Nullable
    public final Map<String, String> component27() {
        return this.plainCustomRequestHeaders;
    }

    @Nullable
    public final Map<String, String> component28() {
        return this.plainCustomResponseHeaders;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component4, reason: from getter */
    public final int getStatusCode() {
        return this.statusCode;
    }

    /* renamed from: component5, reason: from getter */
    public final long getRequestTime() {
        return this.requestTime;
    }

    /* renamed from: component6, reason: from getter */
    public final long getResponseTime() {
        return this.responseTime;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final byte[] getRequestBody() {
        return this.requestBody;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Integer getRequestBodySize() {
        return this.requestBodySize;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final byte[] getResponseBody() {
        return this.responseBody;
    }

    @NotNull
    public final NetworkEvent copy(long timestampMs, String httpMethod, String url, int statusCode, long requestTime, long responseTime, byte[] requestBody, Integer requestBodySize, byte[] responseBody, Integer responseBodySize, Map<String, String> standardRequestHeaders, Map<String, String> standardResponseHeaders, byte[] customRequestHeaders, byte[] customResponseHeaders, byte[] queryParameters, byte[] initializationVector, byte[] encryptedSymmetricKey, Long encryptionPublicKeyId, Map<String, String> requestHeaders, Map<String, String> responseHeaders, String source, List<String> matchingBodyContents, Map<String, String> plainRequestBodyAttributes, byte[] requestBodyAttributes, Map<String, String> plainResponseBodyAttributes, byte[] responseBodyAttributes, Map<String, String> plainCustomRequestHeaders, Map<String, String> plainCustomResponseHeaders) {
        Intrinsics.checkNotNullParameter(httpMethod, "httpMethod");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(source, "source");
        return new NetworkEvent(timestampMs, httpMethod, url, statusCode, requestTime, responseTime, requestBody, requestBodySize, responseBody, responseBodySize, standardRequestHeaders, standardResponseHeaders, customRequestHeaders, customResponseHeaders, queryParameters, initializationVector, encryptedSymmetricKey, encryptionPublicKeyId, requestHeaders, responseHeaders, source, matchingBodyContents, plainRequestBodyAttributes, requestBodyAttributes, plainResponseBodyAttributes, responseBodyAttributes, plainCustomRequestHeaders, plainCustomResponseHeaders);
    }

    @NotNull
    public final NetworkEvent copyWithoutDetails() {
        return copy$default(this, 0L, null, null, 0, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 267386943, null);
    }

    public boolean equals(Object other) {
        byte[] bArr;
        byte[] bArr2;
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(NetworkEvent.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.contentsquare.android.core.communication.error.analysis.NetworkEvent");
        NetworkEvent networkEvent = (NetworkEvent) other;
        if (this.timestampMs != networkEvent.timestampMs || !Intrinsics.areEqual(this.httpMethod, networkEvent.httpMethod) || !Intrinsics.areEqual(this.url, networkEvent.url) || this.statusCode != networkEvent.statusCode || this.requestTime != networkEvent.requestTime || this.responseTime != networkEvent.responseTime || !Intrinsics.areEqual(this.responseBodySize, networkEvent.responseBodySize) || !Intrinsics.areEqual(this.requestBodySize, networkEvent.requestBodySize)) {
            return false;
        }
        byte[] bArr3 = this.requestBody;
        if (bArr3 != null) {
            byte[] bArr4 = networkEvent.requestBody;
            if (bArr4 == null || !Arrays.equals(bArr3, bArr4)) {
                return false;
            }
        } else if (networkEvent.requestBody != null) {
            return false;
        }
        byte[] bArr5 = this.responseBody;
        if (bArr5 != null) {
            byte[] bArr6 = networkEvent.responseBody;
            if (bArr6 == null || !Arrays.equals(bArr5, bArr6)) {
                return false;
            }
        } else if (networkEvent.responseBody != null) {
            return false;
        }
        if (!Intrinsics.areEqual(this.standardRequestHeaders, networkEvent.standardRequestHeaders) || !Intrinsics.areEqual(this.standardResponseHeaders, networkEvent.standardResponseHeaders)) {
            return false;
        }
        byte[] bArr7 = this.customRequestHeaders;
        if (bArr7 != null) {
            byte[] bArr8 = networkEvent.customRequestHeaders;
            if (bArr8 == null || !Arrays.equals(bArr7, bArr8)) {
                return false;
            }
        } else if (networkEvent.customRequestHeaders != null) {
            return false;
        }
        byte[] bArr9 = this.customResponseHeaders;
        if (bArr9 != null) {
            byte[] bArr10 = networkEvent.customResponseHeaders;
            if (bArr10 == null || !Arrays.equals(bArr9, bArr10)) {
                return false;
            }
        } else if (networkEvent.customResponseHeaders != null) {
            return false;
        }
        byte[] bArr11 = this.queryParameters;
        if (bArr11 != null) {
            byte[] bArr12 = networkEvent.queryParameters;
            if (bArr12 == null || !Arrays.equals(bArr11, bArr12)) {
                return false;
            }
        } else if (networkEvent.queryParameters != null) {
            return false;
        }
        byte[] bArr13 = this.initializationVector;
        if (bArr13 != null) {
            byte[] bArr14 = networkEvent.initializationVector;
            if (bArr14 == null || !Arrays.equals(bArr13, bArr14)) {
                return false;
            }
        } else if (networkEvent.initializationVector != null) {
            return false;
        }
        byte[] bArr15 = this.encryptedSymmetricKey;
        if (bArr15 != null) {
            byte[] bArr16 = networkEvent.encryptedSymmetricKey;
            if (bArr16 == null || !Arrays.equals(bArr15, bArr16)) {
                return false;
            }
        } else if (networkEvent.encryptedSymmetricKey != null) {
            return false;
        }
        if (!Intrinsics.areEqual(this.encryptionPublicKeyId, networkEvent.encryptionPublicKeyId) || !Intrinsics.areEqual(this.requestHeaders, networkEvent.requestHeaders) || !Intrinsics.areEqual(this.responseHeaders, networkEvent.responseHeaders) || !Intrinsics.areEqual(this.source, networkEvent.source) || !Intrinsics.areEqual(this.matchingBodyContents, networkEvent.matchingBodyContents) || !Intrinsics.areEqual(this.plainRequestBodyAttributes, networkEvent.plainRequestBodyAttributes)) {
            return false;
        }
        byte[] bArr17 = this.requestBodyAttributes;
        if ((bArr17 != null && ((bArr2 = networkEvent.requestBodyAttributes) == null || !Arrays.equals(bArr17, bArr2))) || !Intrinsics.areEqual(this.plainResponseBodyAttributes, networkEvent.plainResponseBodyAttributes)) {
            return false;
        }
        byte[] bArr18 = this.responseBodyAttributes;
        return (bArr18 == null || ((bArr = networkEvent.responseBodyAttributes) != null && Arrays.equals(bArr18, bArr))) && Intrinsics.areEqual(this.plainCustomRequestHeaders, networkEvent.plainCustomRequestHeaders) && Intrinsics.areEqual(this.plainCustomResponseHeaders, networkEvent.plainCustomResponseHeaders);
    }

    @Nullable
    public final byte[] getCustomRequestHeaders() {
        return this.customRequestHeaders;
    }

    @Nullable
    public final byte[] getCustomResponseHeaders() {
        return this.customResponseHeaders;
    }

    @Nullable
    public final byte[] getEncryptedSymmetricKey() {
        return this.encryptedSymmetricKey;
    }

    @Nullable
    public final Long getEncryptionPublicKeyId() {
        return this.encryptionPublicKeyId;
    }

    @NotNull
    public final String getHttpMethod() {
        return this.httpMethod;
    }

    @Nullable
    public final byte[] getInitializationVector() {
        return this.initializationVector;
    }

    @Nullable
    public final List<String> getMatchingBodyContents() {
        return this.matchingBodyContents;
    }

    @Nullable
    public final Map<String, String> getPlainCustomRequestHeaders() {
        return this.plainCustomRequestHeaders;
    }

    @Nullable
    public final Map<String, String> getPlainCustomResponseHeaders() {
        return this.plainCustomResponseHeaders;
    }

    @Nullable
    public final Map<String, String> getPlainRequestBodyAttributes() {
        return this.plainRequestBodyAttributes;
    }

    @Nullable
    public final Map<String, String> getPlainResponseBodyAttributes() {
        return this.plainResponseBodyAttributes;
    }

    @Nullable
    public final byte[] getQueryParameters() {
        return this.queryParameters;
    }

    @Nullable
    public final byte[] getRequestBody() {
        return this.requestBody;
    }

    @Nullable
    public final byte[] getRequestBodyAttributes() {
        return this.requestBodyAttributes;
    }

    @Nullable
    public final Integer getRequestBodySize() {
        return this.requestBodySize;
    }

    @Nullable
    public final Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    public final long getRequestTime() {
        return this.requestTime;
    }

    @Nullable
    public final byte[] getResponseBody() {
        return this.responseBody;
    }

    @Nullable
    public final byte[] getResponseBodyAttributes() {
        return this.responseBodyAttributes;
    }

    @Nullable
    public final Integer getResponseBodySize() {
        return this.responseBodySize;
    }

    @Nullable
    public final Map<String, String> getResponseHeaders() {
        return this.responseHeaders;
    }

    public final long getResponseTime() {
        return this.responseTime;
    }

    @NotNull
    public final String getSource() {
        return this.source;
    }

    @Nullable
    public final Map<String, String> getStandardRequestHeaders() {
        return this.standardRequestHeaders;
    }

    @Nullable
    public final Map<String, String> getStandardResponseHeaders() {
        return this.standardResponseHeaders;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final long getTimestampMs() {
        return this.timestampMs;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int iHashCode = (Long.hashCode(this.responseTime) + ((Long.hashCode(this.requestTime) + ((((this.url.hashCode() + ((this.httpMethod.hashCode() + (Long.hashCode(this.timestampMs) * 31)) * 31)) * 31) + this.statusCode) * 31)) * 31)) * 31;
        byte[] bArr = this.requestBody;
        int iHashCode2 = (iHashCode + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        Integer num = this.requestBodySize;
        int iIntValue = (iHashCode2 + (num != null ? num.intValue() : 0)) * 31;
        byte[] bArr2 = this.responseBody;
        int iHashCode3 = (iIntValue + (bArr2 != null ? Arrays.hashCode(bArr2) : 0)) * 31;
        Integer num2 = this.responseBodySize;
        int iIntValue2 = (iHashCode3 + (num2 != null ? num2.intValue() : 0)) * 31;
        Map<String, String> map = this.standardRequestHeaders;
        int iHashCode4 = (iIntValue2 + (map != null ? map.hashCode() : 0)) * 31;
        Map<String, String> map2 = this.standardResponseHeaders;
        int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
        byte[] bArr3 = this.customRequestHeaders;
        int iHashCode6 = (iHashCode5 + (bArr3 != null ? Arrays.hashCode(bArr3) : 0)) * 31;
        byte[] bArr4 = this.customResponseHeaders;
        int iHashCode7 = (iHashCode6 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0)) * 31;
        byte[] bArr5 = this.queryParameters;
        int iHashCode8 = (iHashCode7 + (bArr5 != null ? Arrays.hashCode(bArr5) : 0)) * 31;
        byte[] bArr6 = this.initializationVector;
        int iHashCode9 = (iHashCode8 + (bArr6 != null ? Arrays.hashCode(bArr6) : 0)) * 31;
        byte[] bArr7 = this.encryptedSymmetricKey;
        int iHashCode10 = (iHashCode9 + (bArr7 != null ? Arrays.hashCode(bArr7) : 0)) * 31;
        Long l = this.encryptionPublicKeyId;
        int iHashCode11 = (iHashCode10 + (l != null ? l.hashCode() : 0)) * 31;
        Map<String, String> map3 = this.requestHeaders;
        int iHashCode12 = (iHashCode11 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<String, String> map4 = this.responseHeaders;
        int iHashCode13 = (this.source.hashCode() + ((iHashCode12 + (map4 != null ? map4.hashCode() : 0)) * 31)) * 31;
        List<String> list = this.matchingBodyContents;
        int iHashCode14 = (iHashCode13 + (list != null ? list.hashCode() : 0)) * 31;
        Map<String, String> map5 = this.plainRequestBodyAttributes;
        int iHashCode15 = (iHashCode14 + (map5 != null ? map5.hashCode() : 0)) * 31;
        byte[] bArr8 = this.requestBodyAttributes;
        int iHashCode16 = (iHashCode15 + (bArr8 != null ? Arrays.hashCode(bArr8) : 0)) * 31;
        Map<String, String> map6 = this.plainResponseBodyAttributes;
        int iHashCode17 = (iHashCode16 + (map6 != null ? map6.hashCode() : 0)) * 31;
        byte[] bArr9 = this.responseBodyAttributes;
        int iHashCode18 = (iHashCode17 + (bArr9 != null ? Arrays.hashCode(bArr9) : 0)) * 31;
        Map<String, String> map7 = this.plainCustomRequestHeaders;
        int iHashCode19 = (iHashCode18 + (map7 != null ? map7.hashCode() : 0)) * 31;
        Map<String, String> map8 = this.plainCustomResponseHeaders;
        return iHashCode19 + (map8 != null ? map8.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "NetworkEvent(timestampMs=" + this.timestampMs + ", httpMethod=" + this.httpMethod + ", url=" + this.url + ", statusCode=" + this.statusCode + ", requestTime=" + this.requestTime + ", responseTime=" + this.responseTime + ", requestBody=" + Arrays.toString(this.requestBody) + ", requestBodySize=" + this.requestBodySize + ", responseBody=" + Arrays.toString(this.responseBody) + ", responseBodySize=" + this.responseBodySize + ", standardRequestHeaders=" + this.standardRequestHeaders + ", standardResponseHeaders=" + this.standardResponseHeaders + ", customRequestHeaders=" + Arrays.toString(this.customRequestHeaders) + ", customResponseHeaders=" + Arrays.toString(this.customResponseHeaders) + ", queryParameters=" + Arrays.toString(this.queryParameters) + ", initializationVector=" + Arrays.toString(this.initializationVector) + ", encryptedSymmetricKey=" + Arrays.toString(this.encryptedSymmetricKey) + ", encryptionPublicKeyId=" + this.encryptionPublicKeyId + ", requestHeaders=" + this.requestHeaders + ", responseHeaders=" + this.responseHeaders + ", source=" + this.source + ", matchingBodyContents=" + this.matchingBodyContents + ", plainRequestBodyAttributes=" + this.plainRequestBodyAttributes + ", requestBodyAttributes=" + Arrays.toString(this.requestBodyAttributes) + ", plainResponseBodyAttributes=" + this.plainResponseBodyAttributes + ", responseBodyAttributes=" + Arrays.toString(this.responseBodyAttributes) + ", plainCustomRequestHeaders=" + this.plainCustomRequestHeaders + ", plainCustomResponseHeaders=" + this.plainCustomResponseHeaders + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public /* synthetic */ NetworkEvent(long j, String str, String str2, int i, long j2, long j3, byte[] bArr, Integer num, byte[] bArr2, Integer num2, Map map, Map map2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, Long l, Map map3, Map map4, String str3, List list, Map map5, byte[] bArr8, Map map6, byte[] bArr9, Map map7, Map map8, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2, i, j2, j3, (i2 & 64) != 0 ? null : bArr, (i2 & 128) != 0 ? null : num, (i2 & 256) != 0 ? null : bArr2, (i2 & 512) != 0 ? null : num2, (i2 & 1024) != 0 ? null : map, (i2 & 2048) != 0 ? null : map2, (i2 & 4096) != 0 ? null : bArr3, (i2 & 8192) != 0 ? null : bArr4, (i2 & 16384) != 0 ? null : bArr5, (32768 & i2) != 0 ? null : bArr6, (65536 & i2) != 0 ? null : bArr7, (131072 & i2) != 0 ? null : l, (262144 & i2) != 0 ? null : map3, (524288 & i2) != 0 ? null : map4, str3, (2097152 & i2) != 0 ? null : list, (4194304 & i2) != 0 ? null : map5, (8388608 & i2) != 0 ? null : bArr8, (16777216 & i2) != 0 ? null : map6, (33554432 & i2) != 0 ? null : bArr9, (67108864 & i2) != 0 ? null : map7, (i2 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? null : map8);
    }
}
