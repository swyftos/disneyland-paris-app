package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.proto.sessionreplay.v1.EventKt;
import com.contentsquare.proto.sessionreplay.v1.NetworkRequestMetricKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.google.protobuf.ByteString;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nNetworkSrEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkSrEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/NetworkSrEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NetworkRequestMetricKt.kt\ncom/contentsquare/proto/sessionreplay/v1/NetworkRequestMetricKtKt\n*L\n1#1,132:1\n11#2:133\n1#3:134\n1#3:136\n1#3:137\n11#4:135\n*S KotlinDebug\n*F\n+ 1 NetworkSrEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/NetworkSrEvent\n*L\n26#1:133\n26#1:134\n27#1:136\n27#1:135\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.s3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0803s3 extends AbstractC0707i6 {

    @NotNull
    public final NetworkEvent a;

    @NotNull
    public final Logger b;

    /* renamed from: com.contentsquare.android.sdk.s3$a */
    public static final class a extends Lambda implements Function1<Map.Entry<? extends String, ? extends String>, CharSequence> {
        public static final a a = new a();

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

    public C0803s3(@NotNull NetworkEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.a = event;
        this.b = new Logger(null, 1, null);
        setTimestamp(event.getTimestampMs());
    }

    public static void a(String str, StringBuilder sb, byte[] bArr, Map map) {
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
        return (obj instanceof C0803s3) && Intrinsics.areEqual(this.a, ((C0803s3) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.contentsquare.android.sdk.AbstractC0707i6
    @NotNull
    /* renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        EventKt.Dsl dslA = C0687g6.a("newBuilder()", EventKt.Dsl.INSTANCE);
        NetworkRequestMetricKt.Dsl.Companion companion = NetworkRequestMetricKt.Dsl.INSTANCE;
        SessionRecordingV1.NetworkRequestMetric.Builder builderNewBuilder = SessionRecordingV1.NetworkRequestMetric.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        NetworkRequestMetricKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setUnixTimestampMs(this.a.getTimestampMs());
        dsl_create.setHttpMethod(this.a.getHttpMethod());
        dsl_create.setUrl(this.a.getUrl());
        dsl_create.setStatusCode(this.a.getStatusCode());
        dsl_create.setResponseTime(this.a.getResponseTime());
        dsl_create.setRequestTime(this.a.getRequestTime());
        dsl_create.setSource(this.a.getSource());
        byte[] queryParameters = this.a.getQueryParameters();
        if (queryParameters != null) {
            ByteString byteStringCopyFrom = ByteString.copyFrom(queryParameters);
            Intrinsics.checkNotNullExpressionValue(byteStringCopyFrom, "copyFrom(it)");
            dsl_create.setQueryParameters(byteStringCopyFrom);
        }
        byte[] initializationVector = this.a.getInitializationVector();
        if (initializationVector != null) {
            ByteString byteStringCopyFrom2 = ByteString.copyFrom(initializationVector);
            Intrinsics.checkNotNullExpressionValue(byteStringCopyFrom2, "copyFrom(it)");
            dsl_create.setInitializationVector(byteStringCopyFrom2);
        }
        byte[] requestBody = this.a.getRequestBody();
        if (requestBody != null) {
            ByteString byteStringCopyFrom3 = ByteString.copyFrom(requestBody);
            Intrinsics.checkNotNullExpressionValue(byteStringCopyFrom3, "copyFrom(it)");
            dsl_create.setRequestBody(byteStringCopyFrom3);
        }
        byte[] responseBody = this.a.getResponseBody();
        if (responseBody != null) {
            ByteString byteStringCopyFrom4 = ByteString.copyFrom(responseBody);
            Intrinsics.checkNotNullExpressionValue(byteStringCopyFrom4, "copyFrom(it)");
            dsl_create.setResponseBody(byteStringCopyFrom4);
        }
        byte[] encryptedSymmetricKey = this.a.getEncryptedSymmetricKey();
        if (encryptedSymmetricKey != null) {
            ByteString byteStringCopyFrom5 = ByteString.copyFrom(encryptedSymmetricKey);
            Intrinsics.checkNotNullExpressionValue(byteStringCopyFrom5, "copyFrom(it)");
            dsl_create.setEncryptedSymmetricKey(byteStringCopyFrom5);
        }
        Long encryptionPublicKeyId = this.a.getEncryptionPublicKeyId();
        if (encryptionPublicKeyId != null) {
            dsl_create.setEncyptionPublicKeyId(encryptionPublicKeyId.longValue());
        }
        NetworkEvent networkEvent = this.a;
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
        NetworkEvent networkEvent2 = this.a;
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
        dslA.setNetworkRequestMetric(dsl_create._build());
        return dslA._build();
    }

    @NotNull
    public final String toString() {
        return "NetworkSrEvent(event=" + this.a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
