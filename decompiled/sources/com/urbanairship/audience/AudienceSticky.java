package com.urbanairship.audience;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
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

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0016\u0010\u0012\u001a\u00020\u0007HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\fJ3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Lcom/urbanairship/audience/AudienceSticky;", "Lcom/urbanairship/json/JsonSerializable;", "id", "", "reportingMetadata", "Lcom/urbanairship/json/JsonValue;", "lastAccessTtl", "Lkotlin/time/Duration;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonValue;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getLastAccessTtl-UwyO8pc", "()J", "J", "getReportingMetadata", "()Lcom/urbanairship/json/JsonValue;", "component1", "component2", "component3", "component3-UwyO8pc", "copy", "copy-SxA4cEA", "(Ljava/lang/String;Lcom/urbanairship/json/JsonValue;J)Lcom/urbanairship/audience/AudienceSticky;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "toString", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AudienceSticky implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final String id;
    private final long lastAccessTtl;
    private final JsonValue reportingMetadata;

    public /* synthetic */ AudienceSticky(String str, JsonValue jsonValue, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, jsonValue, j);
    }

    /* renamed from: copy-SxA4cEA$default, reason: not valid java name */
    public static /* synthetic */ AudienceSticky m2763copySxA4cEA$default(AudienceSticky audienceSticky, String str, JsonValue jsonValue, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = audienceSticky.id;
        }
        if ((i & 2) != 0) {
            jsonValue = audienceSticky.reportingMetadata;
        }
        if ((i & 4) != 0) {
            j = audienceSticky.lastAccessTtl;
        }
        return audienceSticky.m2765copySxA4cEA(str, jsonValue, j);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final JsonValue getReportingMetadata() {
        return this.reportingMetadata;
    }

    /* renamed from: component3-UwyO8pc, reason: not valid java name and from getter */
    public final long getLastAccessTtl() {
        return this.lastAccessTtl;
    }

    @NotNull
    /* renamed from: copy-SxA4cEA, reason: not valid java name */
    public final AudienceSticky m2765copySxA4cEA(@NotNull String id, @Nullable JsonValue reportingMetadata, long lastAccessTtl) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new AudienceSticky(id, reportingMetadata, lastAccessTtl, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AudienceSticky)) {
            return false;
        }
        AudienceSticky audienceSticky = (AudienceSticky) other;
        return Intrinsics.areEqual(this.id, audienceSticky.id) && Intrinsics.areEqual(this.reportingMetadata, audienceSticky.reportingMetadata) && Duration.m3472equalsimpl0(this.lastAccessTtl, audienceSticky.lastAccessTtl);
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        JsonValue jsonValue = this.reportingMetadata;
        return ((iHashCode + (jsonValue == null ? 0 : jsonValue.hashCode())) * 31) + Duration.m3494hashCodeimpl(this.lastAccessTtl);
    }

    @NotNull
    public String toString() {
        return "AudienceSticky(id=" + this.id + ", reportingMetadata=" + this.reportingMetadata + ", lastAccessTtl=" + ((Object) Duration.m3515toStringimpl(this.lastAccessTtl)) + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    private AudienceSticky(String id, JsonValue jsonValue, long j) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.reportingMetadata = jsonValue;
        this.lastAccessTtl = j;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final JsonValue getReportingMetadata() {
        return this.reportingMetadata;
    }

    /* renamed from: getLastAccessTtl-UwyO8pc, reason: not valid java name */
    public final long m2766getLastAccessTtlUwyO8pc() {
        return this.lastAccessTtl;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/audience/AudienceSticky$Companion;", "", "()V", "ID", "", "LAST_ACCESS_TTL", "REPORTING_METADATA", "fromJson", "Lcom/urbanairship/audience/AudienceSticky;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAudienceSticky.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudienceSticky.kt\ncom/urbanairship/audience/AudienceSticky$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,53:1\n44#2,15:54\n44#2,15:69\n*S KotlinDebug\n*F\n+ 1 AudienceSticky.kt\ncom/urbanairship/audience/AudienceSticky$Companion\n*L\n40#1:54,15\n42#1:69,15\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final AudienceSticky fromJson(@NotNull JsonValue value) throws JsonException {
            String strOptString;
            Long lValueOf;
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonValue jsonValue = jsonMapRequireMap.get("id");
            if (jsonValue == null) {
                throw new JsonException("Missing required field: 'id" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString = jsonValue.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList = jsonValue.optList();
                if (objOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap = jsonValue.optMap();
                if (objOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'id" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue2 = jsonValue.getJsonValue();
                if (jsonValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue2;
            }
            String str = strOptString;
            JsonValue jsonValue3 = jsonMapRequireMap.get("reporting_metadata");
            Duration.Companion companion = Duration.INSTANCE;
            JsonValue jsonValue4 = jsonMapRequireMap.get("last_access_ttl");
            if (jsonValue4 == null) {
                throw new JsonException("Missing required field: 'last_access_ttl" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue4);
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Long.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString = jsonValue4.optString();
                if (objOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf = (Long) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString2 = jsonValue4.optString();
                if (objOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf = (Long) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                lValueOf = (Long) Boolean.valueOf(jsonValue4.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                lValueOf = Long.valueOf(jsonValue4.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                lValueOf = (Long) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                lValueOf = (Long) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                lValueOf = (Long) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                lValueOf = (Long) Integer.valueOf(jsonValue4.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                lValueOf = (Long) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList2 = jsonValue4.optList();
                if (objOptList2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf = (Long) objOptList2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap2 = jsonValue4.optMap();
                if (objOptMap2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf = (Long) objOptMap2;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + Long.class.getSimpleName() + "' for field 'last_access_ttl" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue5 = jsonValue4.getJsonValue();
                if (jsonValue5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf = (Long) jsonValue5;
            }
            return new AudienceSticky(str, jsonValue3, DurationKt.toDuration(lValueOf.longValue(), DurationUnit.MILLISECONDS), null);
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("id", this.id), TuplesKt.to("reporting_metadata", this.reportingMetadata), TuplesKt.to("last_access_ttl", Long.valueOf(Duration.m3485getInWholeMillisecondsimpl(this.lastAccessTtl)))).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
