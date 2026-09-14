package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.proto.sessionreplay.p023v1.EventKt;
import com.contentsquare.proto.sessionreplay.p023v1.NetworkRequestMetricKt;
import com.contentsquare.proto.sessionreplay.p023v1.SessionRecordingV1;
import com.google.protobuf.ByteString;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.s3 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nNetworkSrEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkSrEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/NetworkSrEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NetworkRequestMetricKt.kt\ncom/contentsquare/proto/sessionreplay/v1/NetworkRequestMetricKtKt\n*L\n1#1,132:1\n11#2:133\n1#3:134\n1#3:136\n1#3:137\n11#4:135\n*S KotlinDebug\n*F\n+ 1 NetworkSrEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/NetworkSrEvent\n*L\n26#1:133\n26#1:134\n27#1:136\n27#1:135\n*E\n"})
public final class C2874s3 extends AbstractC2777i6 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final NetworkEvent f3095a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Logger f3096b;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.s3$a */
    public static final class a extends Lambda implements Function1<Map.Entry<? extends String, ? extends String>, CharSequence> {

        /* JADX INFO: renamed from: a */
        public static final a f3097a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(Map.Entry<? extends String, ? extends String> entry) {
            Map.Entry<? extends String, ? extends String> it = entry;
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getKey() + ": " + it.getValue();
        }
    }

    public C2874s3(@NotNull NetworkEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f3095a = event;
        this.f3096b = new Logger(null, 1, null);
        setTimestamp(event.getTimestampMs());
    }

    /* JADX INFO: renamed from: a */
    public static void m1199a(String str, StringBuilder sb, byte[] bArr, Map map) {
        Set setEntrySet;
        Set setEntrySet2;
        if (bArr == null && (map == null || map.isEmpty())) {
            return;
        }
        sb.append(str.concat(": ["));
        if (map != null && (setEntrySet2 = map.entrySet()) != null) {
        }
        if (bArr != null) {
            if (map != null && (setEntrySet = map.entrySet()) != null && (!setEntrySet.isEmpty())) {
                sb.append(", ");
            }
            sb.append("(encrypted)");
        }
        sb.append("]");
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2874s3) && Intrinsics.areEqual(this.f3095a, ((C2874s3) obj).f3095a);
    }

    public final int hashCode() {
        return this.f3095a.hashCode();
    }

    @Override // com.contentsquare.android.sdk.AbstractC2777i6
    @NotNull
    /* JADX INFO: renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        EventKt.Dsl dslM1141a = C2757g6.m1141a("newBuilder()", EventKt.Dsl.INSTANCE);
        NetworkRequestMetricKt.Dsl.Companion companion = NetworkRequestMetricKt.Dsl.INSTANCE;
        SessionRecordingV1.NetworkRequestMetric.Builder builderNewBuilder = SessionRecordingV1.NetworkRequestMetric.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        NetworkRequestMetricKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setUnixTimestampMs(this.f3095a.getTimestampMs());
        dsl_create.setHttpMethod(this.f3095a.getHttpMethod());
        dsl_create.setUrl(this.f3095a.getUrl());
        dsl_create.setStatusCode(this.f3095a.getStatusCode());
        dsl_create.setResponseTime(this.f3095a.getResponseTime());
        dsl_create.setRequestTime(this.f3095a.getRequestTime());
        dsl_create.setSource(this.f3095a.getSource());
        byte[] queryParameters = this.f3095a.getQueryParameters();
        if (queryParameters != null) {
            ByteString byteStringCopyFrom = ByteString.copyFrom(queryParameters);
            Intrinsics.checkNotNullExpressionValue(byteStringCopyFrom, "copyFrom(it)");
            dsl_create.setQueryParameters(byteStringCopyFrom);
        }
        byte[] initializationVector = this.f3095a.getInitializationVector();
        if (initializationVector != null) {
            ByteString byteStringCopyFrom2 = ByteString.copyFrom(initializationVector);
            Intrinsics.checkNotNullExpressionValue(byteStringCopyFrom2, "copyFrom(it)");
            dsl_create.setInitializationVector(byteStringCopyFrom2);
        }
        byte[] requestBody = this.f3095a.getRequestBody();
        if (requestBody != null) {
            ByteString byteStringCopyFrom3 = ByteString.copyFrom(requestBody);
            Intrinsics.checkNotNullExpressionValue(byteStringCopyFrom3, "copyFrom(it)");
            dsl_create.setRequestBody(byteStringCopyFrom3);
        }
        byte[] responseBody = this.f3095a.getResponseBody();
        if (responseBody != null) {
            ByteString byteStringCopyFrom4 = ByteString.copyFrom(responseBody);
            Intrinsics.checkNotNullExpressionValue(byteStringCopyFrom4, "copyFrom(it)");
            dsl_create.setResponseBody(byteStringCopyFrom4);
        }
        byte[] encryptedSymmetricKey = this.f3095a.getEncryptedSymmetricKey();
        if (encryptedSymmetricKey != null) {
            ByteString byteStringCopyFrom5 = ByteString.copyFrom(encryptedSymmetricKey);
            Intrinsics.checkNotNullExpressionValue(byteStringCopyFrom5, "copyFrom(it)");
            dsl_create.setEncryptedSymmetricKey(byteStringCopyFrom5);
        }
        Long encryptionPublicKeyId = this.f3095a.getEncryptionPublicKeyId();
        if (encryptionPublicKeyId != null) {
            dsl_create.setEncyptionPublicKeyId(encryptionPublicKeyId.longValue());
        }
        NetworkEvent networkEvent = this.f3095a;
        Map<String, String> plainRequestBodyAttributes = networkEvent.getPlainRequestBodyAttributes();
        if (plainRequestBodyAttributes != null) {
            dsl_create.putAllPlainRequestBodyAttributes(dsl_create.getPlainRequestBodyAttributesMap(), plainRequestBodyAttributes);
        }
        Map<String, String> plainResponseBodyAttributes = networkEvent.getPlainResponseBodyAttributes();
        if (plainResponseBodyAttributes != null) {
            dsl_create.putAllPlainResponseBodyAttributes(dsl_create.getPlainResponseBodyAttributesMap(), plainResponseBodyAttributes);
        }
        byte[] requestBodyAttributes = networkEvent.getRequestBodyAttributes();
        if (requestBodyAttributes != null) {
            ByteString byteStringCopyFrom6 = ByteString.copyFrom(requestBodyAttributes);
            Intrinsics.checkNotNullExpressionValue(byteStringCopyFrom6, "copyFrom(it)");
            dsl_create.setRequestBodyAttributes(byteStringCopyFrom6);
        }
        byte[] responseBodyAttributes = networkEvent.getResponseBodyAttributes();
        if (responseBodyAttributes != null) {
            ByteString byteStringCopyFrom7 = ByteString.copyFrom(responseBodyAttributes);
            Intrinsics.checkNotNullExpressionValue(byteStringCopyFrom7, "copyFrom(it)");
            dsl_create.setResponseBodyAttributes(byteStringCopyFrom7);
        }
        NetworkEvent networkEvent2 = this.f3095a;
        Map<String, String> standardRequestHeaders = networkEvent2.getStandardRequestHeaders();
        if (standardRequestHeaders != null) {
            dsl_create.putAllStandardRequestHeaders(dsl_create.getStandardRequestHeadersMap(), standardRequestHeaders);
        }
        Map<String, String> standardResponseHeaders = networkEvent2.getStandardResponseHeaders();
        if (standardResponseHeaders != null) {
            dsl_create.putAllStandardResponseHeaders(dsl_create.getStandardResponseHeadersMap(), standardResponseHeaders);
        }
        byte[] customRequestHeaders = networkEvent2.getCustomRequestHeaders();
        if (customRequestHeaders != null) {
            ByteString byteStringCopyFrom8 = ByteString.copyFrom(customRequestHeaders);
            Intrinsics.checkNotNullExpressionValue(byteStringCopyFrom8, "copyFrom(it)");
            dsl_create.setCustomRequestHeaders(byteStringCopyFrom8);
        }
        byte[] customResponseHeaders = networkEvent2.getCustomResponseHeaders();
        if (customResponseHeaders != null) {
            ByteString byteStringCopyFrom9 = ByteString.copyFrom(customResponseHeaders);
            Intrinsics.checkNotNullExpressionValue(byteStringCopyFrom9, "copyFrom(it)");
            dsl_create.setCustomResponseHeaders(byteStringCopyFrom9);
        }
        Map<String, String> plainCustomRequestHeaders = networkEvent2.getPlainCustomRequestHeaders();
        if (plainCustomRequestHeaders != null) {
            dsl_create.putAllPlainCustomRequestHeaders(dsl_create.getPlainCustomRequestHeadersMap(), plainCustomRequestHeaders);
        }
        Map<String, String> plainCustomResponseHeaders = networkEvent2.getPlainCustomResponseHeaders();
        if (plainCustomResponseHeaders != null) {
            dsl_create.putAllPlainCustomResponseHeaders(dsl_create.getPlainCustomResponseHeadersMap(), plainCustomResponseHeaders);
        }
        dslM1141a.setNetworkRequestMetric(dsl_create._build());
        return dslM1141a._build();
    }

    @NotNull
    public final String toString() {
        return "NetworkSrEvent(event=" + this.f3095a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
