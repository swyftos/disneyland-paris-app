package com.urbanairship.inputvalidation;

import android.net.Uri;
import ch.qos.logback.core.CoreConstants;
import com.allegion.accesssdk.BuildConfig;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.UAirship;
import com.urbanairship.actions.RateAppAction;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.Request;
import com.urbanairship.http.RequestAuth;
import com.urbanairship.http.RequestBody;
import com.urbanairship.http.RequestResult;
import com.urbanairship.http.ResponseParser;
import com.urbanairship.http.SuspendingRequestSession;
import com.urbanairship.http.SuspendingRequestSessionKt;
import com.urbanairship.json.JsonException;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0002J$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0013J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/inputvalidation/SmsValidatorApiClient;", "Lcom/urbanairship/inputvalidation/SmsValidatorApiInterface;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", BuildConfig.SESSION_KEY_REFERENCE, "Lcom/urbanairship/http/SuspendingRequestSession;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/http/SuspendingRequestSession;)V", "performRequest", "Lcom/urbanairship/http/RequestResult;", "Lcom/urbanairship/inputvalidation/SmsValidatorApiClient$Result;", RateAppAction.BODY_KEY, "Lcom/urbanairship/json/JsonSerializable;", "(Lcom/urbanairship/json/JsonSerializable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestUri", "Landroid/net/Uri;", "validateSmsWithPrefix", "msisdn", "", "prefix", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateSmsWithSender", "sender", "Body", "Result", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSmsValidatorApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmsValidatorApiClient.kt\ncom/urbanairship/inputvalidation/SmsValidatorApiClient\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,128:1\n1#2:129\n*E\n"})
/* loaded from: classes5.dex */
public final class SmsValidatorApiClient implements SmsValidatorApiInterface {
    private final AirshipRuntimeConfig config;
    private SuspendingRequestSession session;

    public SmsValidatorApiClient(@NotNull AirshipRuntimeConfig config, @NotNull SuspendingRequestSession session) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(session, "session");
        this.config = config;
        this.session = session;
    }

    public /* synthetic */ SmsValidatorApiClient(AirshipRuntimeConfig airshipRuntimeConfig, SuspendingRequestSession suspendingRequestSession, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(airshipRuntimeConfig, (i & 2) != 0 ? SuspendingRequestSessionKt.toSuspendingRequestSession(airshipRuntimeConfig.getRequestSession()) : suspendingRequestSession);
    }

    @Override // com.urbanairship.inputvalidation.SmsValidatorApiInterface
    @Nullable
    public Object validateSmsWithSender(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super RequestResult<Result>> continuation) throws InvalidParameterException {
        return performRequest(new Body(str, str2, null, 4, null), continuation);
    }

    @Override // com.urbanairship.inputvalidation.SmsValidatorApiInterface
    @Nullable
    public Object validateSmsWithPrefix(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super RequestResult<Result>> continuation) throws InvalidParameterException {
        return performRequest(new Body(str, null, str2, 2, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performRequest(JsonSerializable jsonSerializable, Continuation continuation) {
        String str;
        int platform = this.config.getPlatform();
        if (platform != 1) {
            str = platform != 2 ? null : "android";
        } else {
            str = "amazon";
        }
        if (str == null) {
            throw new InvalidParameterException("Invalid platform");
        }
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("X-UA-Lib-Version", UAirship.getVersion()), TuplesKt.to("X-UA-Device-Family", str), TuplesKt.to("Content-Type", "application/json"), TuplesKt.to("Accept", "application/vnd.urbanairship+json; version=3;"));
        return this.session.execute(new Request(requestUri(), "POST", RequestAuth.GeneratedAppToken.INSTANCE, new RequestBody.Json(jsonSerializable), MapsKt.toMap(mapMutableMapOf), false, 32, null), new ResponseParser() { // from class: com.urbanairship.inputvalidation.SmsValidatorApiClient$$ExternalSyntheticLambda0
            @Override // com.urbanairship.http.ResponseParser
            public final Object parseResponse(int i, Map map, String str2) {
                return SmsValidatorApiClient.performRequest$lambda$0(i, map, str2);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Result performRequest$lambda$0(int i, Map map, String str) throws JsonException {
        Intrinsics.checkNotNullParameter(map, "<anonymous parameter 1>");
        if (!UAHttpStatusUtil.inSuccessRange(i)) {
            return null;
        }
        JsonValue string = JsonValue.parseString(str);
        Intrinsics.checkNotNullExpressionValue(string, "parseString(...)");
        return Result.INSTANCE.fromJson(string);
    }

    private final Uri requestUri() {
        Uri uriBuild = this.config.getDeviceUrl().appendEncodedPath("api/channels/sms/format").build();
        if (uriBuild != null) {
            return uriBuild;
        }
        throw new InvalidParameterException("Initial config not resolved.");
    }

    private static final class Body implements JsonSerializable {
        public static final Companion Companion = new Companion(null);
        private final String msisdn;
        private final String prefix;
        private final String sender;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Body)) {
                return false;
            }
            Body body = (Body) obj;
            return Intrinsics.areEqual(this.msisdn, body.msisdn) && Intrinsics.areEqual(this.sender, body.sender) && Intrinsics.areEqual(this.prefix, body.prefix);
        }

        public int hashCode() {
            int iHashCode = this.msisdn.hashCode() * 31;
            String str = this.sender;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.prefix;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Body(msisdn=" + this.msisdn + ", sender=" + this.sender + ", prefix=" + this.prefix + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Body(String msisdn, String str, String str2) {
            Intrinsics.checkNotNullParameter(msisdn, "msisdn");
            this.msisdn = msisdn;
            this.sender = str;
            this.prefix = str2;
        }

        public /* synthetic */ Body(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/inputvalidation/SmsValidatorApiClient$Body$Companion;", "", "()V", "MSISDN", "", "PREFIX", "SENDER", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("msisdn", this.msisdn), TuplesKt.to("sender", this.sender), TuplesKt.to("prefix", this.prefix)).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/urbanairship/inputvalidation/SmsValidatorApiClient$Result;", "", "()V", "Companion", "Invalid", "Valid", "Lcom/urbanairship/inputvalidation/SmsValidatorApiClient$Result$Invalid;", "Lcom/urbanairship/inputvalidation/SmsValidatorApiClient$Result$Valid;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Result {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/inputvalidation/SmsValidatorApiClient$Result$Valid;", "Lcom/urbanairship/inputvalidation/SmsValidatorApiClient$Result;", "address", "", "(Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Valid extends Result {
            private final String address;

            public static /* synthetic */ Valid copy$default(Valid valid, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = valid.address;
                }
                return valid.copy(str);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getAddress() {
                return this.address;
            }

            @NotNull
            public final Valid copy(@NotNull String address) {
                Intrinsics.checkNotNullParameter(address, "address");
                return new Valid(address);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Valid) && Intrinsics.areEqual(this.address, ((Valid) other).address);
            }

            public int hashCode() {
                return this.address.hashCode();
            }

            @NotNull
            public String toString() {
                return "Valid(address=" + this.address + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(@NotNull String address) {
                super(null);
                Intrinsics.checkNotNullParameter(address, "address");
                this.address = address;
            }

            @NotNull
            public final String getAddress() {
                return this.address;
            }
        }

        private Result() {
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/inputvalidation/SmsValidatorApiClient$Result$Invalid;", "Lcom/urbanairship/inputvalidation/SmsValidatorApiClient$Result;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Invalid extends Result {

            @NotNull
            public static final Invalid INSTANCE = new Invalid();

            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof Invalid);
            }

            public int hashCode() {
                return -846268224;
            }

            @NotNull
            public String toString() {
                return "Invalid";
            }

            private Invalid() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/inputvalidation/SmsValidatorApiClient$Result$Companion;", "", "()V", "MSISDN", "", "VALID", "fromJson", "Lcom/urbanairship/inputvalidation/SmsValidatorApiClient$Result;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nSmsValidatorApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmsValidatorApiClient.kt\ncom/urbanairship/inputvalidation/SmsValidatorApiClient$Result$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,128:1\n44#2,15:129\n44#2,15:144\n*S KotlinDebug\n*F\n+ 1 SmsValidatorApiClient.kt\ncom/urbanairship/inputvalidation/SmsValidatorApiClient$Result$Companion\n*L\n119#1:129,15\n120#1:144,15\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Removed duplicated region for block: B:124:0x02f0  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x016f  */
            @org.jetbrains.annotations.NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.urbanairship.inputvalidation.SmsValidatorApiClient.Result fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r20) throws com.urbanairship.json.JsonException {
                /*
                    Method dump skipped, instructions count: 823
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.inputvalidation.SmsValidatorApiClient.Result.Companion.fromJson(com.urbanairship.json.JsonValue):com.urbanairship.inputvalidation.SmsValidatorApiClient$Result");
            }
        }
    }
}
