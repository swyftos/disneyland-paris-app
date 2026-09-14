package com.urbanairship.automation.audiencecheck;

import android.net.Uri;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.allegion.accesssdk.BuildConfig;
import com.disney.p026id.android.tracker.OneIDTrackerEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.http.Request;
import com.urbanairship.http.RequestAuth;
import com.urbanairship.http.RequestBody;
import com.urbanairship.http.RequestResult;
import com.urbanairship.http.ResponseParser;
import com.urbanairship.http.SuspendingRequestSession;
import com.urbanairship.http.SuspendingRequestSessionKt;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.util.UAHttpStatusUtil;
import java.security.InvalidParameterException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0002\r\u000eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1836d2 = {"Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient;", "", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", BuildConfig.SESSION_KEY_REFERENCE, "Lcom/urbanairship/http/SuspendingRequestSession;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/http/SuspendingRequestSession;)V", "resolve", "Lcom/urbanairship/http/RequestResult;", "Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Result;", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Info;", "(Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Info;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Info", "Result", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nAdditionalAudienceCheckApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdditionalAudienceCheckApiClient.kt\ncom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,109:1\n1#2:110\n*E\n"})
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
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.m1842to("X-UA-Contact-ID", info.getContactId()), TuplesKt.m1842to("X-UA-Device-Family", str), TuplesKt.m1842to("Content-Type", "application/json"), TuplesKt.m1842to("Accept", "application/vnd.urbanairship+json; version=3;"));
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

    @Metadata(m1835d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\f\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\bJ'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, m1836d2 = {"Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Result;", "Lcom/urbanairship/json/JsonSerializable;", "isMatched", "", "cacheTtl", "Lkotlin/time/Duration;", "(ZJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCacheTtl-UwyO8pc", "()J", "J", "()Z", "component1", "component2", "component2-UwyO8pc", "copy", "copy-HG0u8IE", "(ZJ)Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Result;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final /* data */ class Result implements JsonSerializable {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final long cacheTtl;
        private final boolean isMatched;

        public /* synthetic */ Result(boolean z, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, j);
        }

        /* JADX INFO: renamed from: copy-HG0u8IE$default, reason: not valid java name */
        public static /* synthetic */ Result m5034copyHG0u8IE$default(Result result, boolean z, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                z = result.isMatched;
            }
            if ((i & 2) != 0) {
                j = result.cacheTtl;
            }
            return result.m5036copyHG0u8IE(z, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsMatched() {
            return this.isMatched;
        }

        /* JADX INFO: renamed from: component2-UwyO8pc, reason: not valid java name and from getter */
        public final long getCacheTtl() {
            return this.cacheTtl;
        }

        @NotNull
        /* JADX INFO: renamed from: copy-HG0u8IE, reason: not valid java name */
        public final Result m5036copyHG0u8IE(boolean isMatched, long cacheTtl) {
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
            return this.isMatched == result.isMatched && Duration.m5777equalsimpl0(this.cacheTtl, result.cacheTtl);
        }

        public int hashCode() {
            return (Boolean.hashCode(this.isMatched) * 31) + Duration.m5799hashCodeimpl(this.cacheTtl);
        }

        @NotNull
        public String toString() {
            return "Result(isMatched=" + this.isMatched + ", cacheTtl=" + ((Object) Duration.m5820toStringimpl(this.cacheTtl)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        private Result(boolean z, long j) {
            this.isMatched = z;
            this.cacheTtl = j;
        }

        public final boolean isMatched() {
            return this.isMatched;
        }

        /* JADX INFO: renamed from: getCacheTtl-UwyO8pc, reason: not valid java name */
        public final long m5037getCacheTtlUwyO8pc() {
            return this.cacheTtl;
        }

        @Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m1836d2 = {"Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Result$Companion;", "", "()V", "CACHE_TTL", "", "IS_MATCHED", "fromJson", "Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Result;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
        @SourceDebugExtension({"SMAP\nAdditionalAudienceCheckApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdditionalAudienceCheckApiClient.kt\ncom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Result$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,109:1\n44#2,15:110\n44#2,15:125\n*S KotlinDebug\n*F\n+ 1 AdditionalAudienceCheckApiClient.kt\ncom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Result$Companion\n*L\n74#1:110,15\n75#1:125,15\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Code duplicated, block: B:100:0x0272  */
            /* JADX WARN: Code duplicated, block: B:101:0x0275  */
            /* JADX WARN: Code duplicated, block: B:103:0x027b  */
            /* JADX WARN: Code duplicated, block: B:105:0x0285  */
            /* JADX WARN: Code duplicated, block: B:107:0x028b  */
            /* JADX WARN: Code duplicated, block: B:108:0x028e  */
            /* JADX WARN: Code duplicated, block: B:110:0x0294  */
            /* JADX WARN: Code duplicated, block: B:112:0x029e  */
            /* JADX WARN: Code duplicated, block: B:114:0x02a4  */
            /* JADX WARN: Code duplicated, block: B:117:0x02b5  */
            /* JADX WARN: Code duplicated, block: B:119:0x02bb  */
            /* JADX WARN: Code duplicated, block: B:121:0x02df  */
            /* JADX WARN: Code duplicated, block: B:61:0x0176  */
            /* JADX WARN: Code duplicated, block: B:63:0x0188  */
            /* JADX WARN: Code duplicated, block: B:65:0x018e  */
            /* JADX WARN: Code duplicated, block: B:66:0x0192  */
            /* JADX WARN: Code duplicated, block: B:68:0x0198  */
            /* JADX WARN: Code duplicated, block: B:70:0x01a2  */
            /* JADX WARN: Code duplicated, block: B:72:0x01a8  */
            /* JADX WARN: Code duplicated, block: B:73:0x01ac  */
            /* JADX WARN: Code duplicated, block: B:75:0x01b2  */
            /* JADX WARN: Code duplicated, block: B:77:0x01be  */
            /* JADX WARN: Code duplicated, block: B:78:0x01cb  */
            /* JADX WARN: Code duplicated, block: B:80:0x01d7  */
            /* JADX WARN: Code duplicated, block: B:81:0x01e3  */
            /* JADX WARN: Code duplicated, block: B:83:0x01ef  */
            /* JADX WARN: Code duplicated, block: B:84:0x01ff  */
            /* JADX WARN: Code duplicated, block: B:86:0x020b  */
            /* JADX WARN: Code duplicated, block: B:87:0x0219  */
            /* JADX WARN: Code duplicated, block: B:89:0x0225  */
            /* JADX WARN: Code duplicated, block: B:90:0x0232  */
            /* JADX WARN: Code duplicated, block: B:92:0x023c  */
            /* JADX WARN: Code duplicated, block: B:93:0x0248  */
            /* JADX WARN: Code duplicated, block: B:95:0x0253  */
            /* JADX WARN: Code duplicated, block: B:96:0x0262  */
            /* JADX WARN: Code duplicated, block: B:98:0x026c  */
            /* JADX WARN: Instruction removed from duplicated block: B:119:0x02bb, please report this as an issue */
            /* JADX WARN: Instruction removed from duplicated block: B:121:0x02df, please report this as an issue */
            @NotNull
            public final Result fromJson(@NotNull JsonValue value) throws JsonException {
                String str;
                Boolean boolValueOf;
                boolean zBooleanValue;
                JsonValue jsonValue;
                KClass orCreateKotlinClass;
                Object jsonValue2;
                Long lValueOf;
                Object objOptMap;
                Object objOptList;
                Object objOptString;
                Object objOptString2;
                Intrinsics.checkNotNullParameter(value, "value");
                JsonMap jsonMapRequireMap = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                JsonValue jsonValue3 = jsonMapRequireMap.get("allowed");
                if (jsonValue3 == null) {
                    throw new JsonException("Missing required field: 'allowed" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Boolean.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString3 = jsonValue3.optString();
                    if (objOptString3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolValueOf = (Boolean) objOptString3;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString4 = jsonValue3.optString();
                    if (objOptString4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolValueOf = (Boolean) objOptString4;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            boolValueOf = (Boolean) Long.valueOf(jsonValue3.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            str = "' for field '";
                            boolValueOf = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                        } else {
                            str = "' for field '";
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                boolValueOf = (Boolean) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                boolValueOf = (Boolean) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                boolValueOf = (Boolean) Integer.valueOf(jsonValue3.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                boolValueOf = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                Object objOptList2 = jsonValue3.optList();
                                if (objOptList2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                }
                                boolValueOf = (Boolean) objOptList2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                Object objOptMap2 = jsonValue3.optMap();
                                if (objOptMap2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                }
                                boolValueOf = (Boolean) objOptMap2;
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + str + "allowed" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                Object jsonValue4 = jsonValue3.getJsonValue();
                                if (jsonValue4 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                }
                                boolValueOf = (Boolean) jsonValue4;
                            }
                        }
                        zBooleanValue = boolValueOf.booleanValue();
                        Duration.Companion companion = Duration.INSTANCE;
                        jsonValue = jsonMapRequireMap.get("cache_seconds");
                        if (jsonValue != null) {
                            throw new JsonException("Missing required field: 'cache_seconds" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                            objOptString2 = jsonValue.optString();
                            if (objOptString2 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                            }
                            lValueOf = (Long) objOptString2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            objOptString = jsonValue.optString();
                            if (objOptString != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                            }
                            lValueOf = (Long) objOptString;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            lValueOf = (Long) Boolean.valueOf(jsonValue.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            lValueOf = Long.valueOf(jsonValue.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            lValueOf = (Long) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            lValueOf = (Long) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            lValueOf = (Long) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            lValueOf = (Long) Integer.valueOf(jsonValue.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            lValueOf = (Long) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            objOptList = jsonValue.optList();
                            if (objOptList != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                            }
                            lValueOf = (Long) objOptList;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            objOptMap = jsonValue.optMap();
                            if (objOptMap != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                            }
                            lValueOf = (Long) objOptMap;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + Long.class.getSimpleName() + str + "cache_seconds" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonValue2 = jsonValue.getJsonValue();
                            if (jsonValue2 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                            }
                            lValueOf = (Long) jsonValue2;
                        }
                        return new Result(zBooleanValue, DurationKt.toDuration(lValueOf.longValue(), DurationUnit.SECONDS), null);
                    }
                    boolValueOf = Boolean.valueOf(jsonValue3.getBoolean(false));
                }
                str = "' for field '";
                zBooleanValue = boolValueOf.booleanValue();
                Duration.Companion companion2 = Duration.INSTANCE;
                jsonValue = jsonMapRequireMap.get("cache_seconds");
                if (jsonValue != null) {
                    throw new JsonException("Missing required field: 'cache_seconds" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    objOptString2 = jsonValue.optString();
                    if (objOptString2 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) objOptString2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    objOptString = jsonValue.optString();
                    if (objOptString != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) objOptString;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    lValueOf = (Long) Boolean.valueOf(jsonValue.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    lValueOf = Long.valueOf(jsonValue.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    lValueOf = (Long) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    lValueOf = (Long) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    lValueOf = (Long) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    lValueOf = (Long) Integer.valueOf(jsonValue.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    lValueOf = (Long) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    objOptList = jsonValue.optList();
                    if (objOptList != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) objOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    objOptMap = jsonValue.optMap();
                    if (objOptMap != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) objOptMap;
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Long.class.getSimpleName() + str + "cache_seconds" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue2 = jsonValue.getJsonValue();
                    if (jsonValue2 != null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) jsonValue2;
                }
                return new Result(zBooleanValue, DurationKt.toDuration(lValueOf.longValue(), DurationUnit.SECONDS), null);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* JADX INFO: renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("allowed", Boolean.valueOf(this.isMatched)), TuplesKt.m1842to("cache_seconds", Long.valueOf(Duration.m5793getInWholeSecondsimpl(this.cacheTtl)))).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(m1835d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\b\u0010\u001d\u001a\u00020\bH\u0016J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006 "}, m1836d2 = {"Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Info;", "Lcom/urbanairship/json/JsonSerializable;", "url", "", "channelId", "contactId", "namedUserId", "context", "Lcom/urbanairship/json/JsonValue;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonValue;)V", "getChannelId", "()Ljava/lang/String;", "getContactId", "getContext", "()Lcom/urbanairship/json/JsonValue;", "getNamedUserId", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "toString", "Companion", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getContactId() {
            return this.contactId;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getNamedUserId() {
            return this.namedUserId;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
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
        /* JADX INFO: renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("channel_id", this.channelId), TuplesKt.m1842to(DeferredApiClient.KEY_CONTACT_ID, this.contactId), TuplesKt.m1842to("named_user_id", this.namedUserId), TuplesKt.m1842to("context", this.context)).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }
}
