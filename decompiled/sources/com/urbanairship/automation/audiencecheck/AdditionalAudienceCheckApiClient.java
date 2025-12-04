package com.urbanairship.automation.audiencecheck;

import android.net.Uri;
import ch.qos.logback.core.CoreConstants;
import com.allegion.accesssdk.BuildConfig;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.http.Request;
import com.urbanairship.http.RequestAuth;
import com.urbanairship.http.RequestBody;
import com.urbanairship.http.RequestResult;
import com.urbanairship.http.ResponseParser;
import com.urbanairship.http.SuspendingRequestSession;
import com.urbanairship.http.SuspendingRequestSessionKt;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.util.UAHttpStatusUtil;
import java.security.InvalidParameterException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0002\r\u000eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient;", "", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", BuildConfig.SESSION_KEY_REFERENCE, "Lcom/urbanairship/http/SuspendingRequestSession;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/http/SuspendingRequestSession;)V", "resolve", "Lcom/urbanairship/http/RequestResult;", "Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Result;", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Info;", "(Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Info;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Info", "Result", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAdditionalAudienceCheckApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdditionalAudienceCheckApiClient.kt\ncom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,109:1\n1#2:110\n*E\n"})
/* loaded from: classes5.dex */
public final class AdditionalAudienceCheckApiClient {
    private final AirshipRuntimeConfig config;
    private SuspendingRequestSession session;

    public AdditionalAudienceCheckApiClient(@NotNull AirshipRuntimeConfig config, @NotNull SuspendingRequestSession session) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(session, "session");
        this.config = config;
        this.session = session;
    }

    public /* synthetic */ AdditionalAudienceCheckApiClient(AirshipRuntimeConfig airshipRuntimeConfig, SuspendingRequestSession suspendingRequestSession, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(airshipRuntimeConfig, (i & 2) != 0 ? SuspendingRequestSessionKt.toSuspendingRequestSession(airshipRuntimeConfig.getRequestSession()) : suspendingRequestSession);
    }

    @Nullable
    public final Object resolve(@NotNull Info info, @NotNull Continuation<? super RequestResult<Result>> continuation) throws InvalidParameterException {
        String str;
        int platform = this.config.getPlatform();
        if (platform != 1) {
            str = platform != 2 ? null : "android";
        } else {
            str = "amazon";
        }
        if (str == null) {
            return new RequestResult(new InvalidParameterException("Invalid platform"));
        }
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("X-UA-Contact-ID", info.getContactId()), TuplesKt.to("X-UA-Device-Family", str), TuplesKt.to("Content-Type", "application/json"), TuplesKt.to("Accept", "application/vnd.urbanairship+json; version=3;"));
        return this.session.execute(new Request(Uri.parse(info.getUrl()), "POST", new RequestAuth.ContactTokenAuth(info.getContactId()), new RequestBody.Json(info), MapsKt.toMap(mapMutableMapOf), false, 32, null), new ResponseParser() { // from class: com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckApiClient$$ExternalSyntheticLambda0
            @Override // com.urbanairship.http.ResponseParser
            public final Object parseResponse(int i, Map map, String str2) {
                return AdditionalAudienceCheckApiClient.resolve$lambda$1(i, map, str2);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Result resolve$lambda$1(int i, Map map, String str) {
        JsonValue string;
        Intrinsics.checkNotNullParameter(map, "<anonymous parameter 1>");
        if (!UAHttpStatusUtil.inSuccessRange(i) || str == null || (string = JsonValue.parseString(str)) == null) {
            return null;
        }
        return Result.INSTANCE.fromJson(string);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\f\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\bJ'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Result;", "Lcom/urbanairship/json/JsonSerializable;", "isMatched", "", "cacheTtl", "Lkotlin/time/Duration;", "(ZJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCacheTtl-UwyO8pc", "()J", "J", "()Z", "component1", "component2", "component2-UwyO8pc", "copy", "copy-HG0u8IE", "(ZJ)Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Result;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Result implements JsonSerializable {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final long cacheTtl;
        private final boolean isMatched;

        public /* synthetic */ Result(boolean z, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, j);
        }

        /* renamed from: copy-HG0u8IE$default, reason: not valid java name */
        public static /* synthetic */ Result m2792copyHG0u8IE$default(Result result, boolean z, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                z = result.isMatched;
            }
            if ((i & 2) != 0) {
                j = result.cacheTtl;
            }
            return result.m2794copyHG0u8IE(z, j);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsMatched() {
            return this.isMatched;
        }

        /* renamed from: component2-UwyO8pc, reason: not valid java name and from getter */
        public final long getCacheTtl() {
            return this.cacheTtl;
        }

        @NotNull
        /* renamed from: copy-HG0u8IE, reason: not valid java name */
        public final Result m2794copyHG0u8IE(boolean isMatched, long cacheTtl) {
            return new Result(isMatched, cacheTtl, null);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return this.isMatched == result.isMatched && Duration.m3472equalsimpl0(this.cacheTtl, result.cacheTtl);
        }

        public int hashCode() {
            return (Boolean.hashCode(this.isMatched) * 31) + Duration.m3494hashCodeimpl(this.cacheTtl);
        }

        @NotNull
        public String toString() {
            return "Result(isMatched=" + this.isMatched + ", cacheTtl=" + ((Object) Duration.m3515toStringimpl(this.cacheTtl)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        private Result(boolean z, long j) {
            this.isMatched = z;
            this.cacheTtl = j;
        }

        public final boolean isMatched() {
            return this.isMatched;
        }

        /* renamed from: getCacheTtl-UwyO8pc, reason: not valid java name */
        public final long m2795getCacheTtlUwyO8pc() {
            return this.cacheTtl;
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Result$Companion;", "", "()V", "CACHE_TTL", "", "IS_MATCHED", "fromJson", "Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Result;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nAdditionalAudienceCheckApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdditionalAudienceCheckApiClient.kt\ncom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Result$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,109:1\n44#2,15:110\n44#2,15:125\n*S KotlinDebug\n*F\n+ 1 AdditionalAudienceCheckApiClient.kt\ncom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Result$Companion\n*L\n74#1:110,15\n75#1:125,15\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Removed duplicated region for block: B:121:0x02df  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x0176  */
            @org.jetbrains.annotations.NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckApiClient.Result fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r21) throws com.urbanairship.json.JsonException {
                /*
                    Method dump skipped, instructions count: 829
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckApiClient.Result.Companion.fromJson(com.urbanairship.json.JsonValue):com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckApiClient$Result");
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("allowed", Boolean.valueOf(this.isMatched)), TuplesKt.to("cache_seconds", Long.valueOf(Duration.m3488getInWholeSecondsimpl(this.cacheTtl)))).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\b\u0010\u001d\u001a\u00020\bH\u0016J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006 "}, d2 = {"Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Info;", "Lcom/urbanairship/json/JsonSerializable;", "url", "", "channelId", "contactId", "namedUserId", "context", "Lcom/urbanairship/json/JsonValue;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonValue;)V", "getChannelId", "()Ljava/lang/String;", "getContactId", "getContext", "()Lcom/urbanairship/json/JsonValue;", "getNamedUserId", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "toString", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Info implements JsonSerializable {
        private final String channelId;
        private final String contactId;
        private final JsonValue context;
        private final String namedUserId;
        private final String url;

        public static /* synthetic */ Info copy$default(Info info, String str, String str2, String str3, String str4, JsonValue jsonValue, int i, Object obj) {
            if ((i & 1) != 0) {
                str = info.url;
            }
            if ((i & 2) != 0) {
                str2 = info.channelId;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                str3 = info.contactId;
            }
            String str6 = str3;
            if ((i & 8) != 0) {
                str4 = info.namedUserId;
            }
            String str7 = str4;
            if ((i & 16) != 0) {
                jsonValue = info.context;
            }
            return info.copy(str, str5, str6, str7, jsonValue);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getContactId() {
            return this.contactId;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final String getNamedUserId() {
            return this.namedUserId;
        }

        @Nullable
        /* renamed from: component5, reason: from getter */
        public final JsonValue getContext() {
            return this.context;
        }

        @NotNull
        public final Info copy(@NotNull String url, @NotNull String channelId, @NotNull String contactId, @Nullable String namedUserId, @Nullable JsonValue context) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(contactId, "contactId");
            return new Info(url, channelId, contactId, namedUserId, context);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Info)) {
                return false;
            }
            Info info = (Info) other;
            return Intrinsics.areEqual(this.url, info.url) && Intrinsics.areEqual(this.channelId, info.channelId) && Intrinsics.areEqual(this.contactId, info.contactId) && Intrinsics.areEqual(this.namedUserId, info.namedUserId) && Intrinsics.areEqual(this.context, info.context);
        }

        public int hashCode() {
            int iHashCode = ((((this.url.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.contactId.hashCode()) * 31;
            String str = this.namedUserId;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            JsonValue jsonValue = this.context;
            return iHashCode2 + (jsonValue != null ? jsonValue.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Info(url=" + this.url + ", channelId=" + this.channelId + ", contactId=" + this.contactId + ", namedUserId=" + this.namedUserId + ", context=" + this.context + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Info(@NotNull String url, @NotNull String channelId, @NotNull String contactId, @Nullable String str, @Nullable JsonValue jsonValue) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(contactId, "contactId");
            this.url = url;
            this.channelId = channelId;
            this.contactId = contactId;
            this.namedUserId = str;
            this.context = jsonValue;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final String getContactId() {
            return this.contactId;
        }

        @Nullable
        public final String getNamedUserId() {
            return this.namedUserId;
        }

        @Nullable
        public final JsonValue getContext() {
            return this.context;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("channel_id", this.channelId), TuplesKt.to(DeferredApiClient.KEY_CONTACT_ID, this.contactId), TuplesKt.to("named_user_id", this.namedUserId), TuplesKt.to("context", this.context)).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }
}
