package com.urbanairship.audience;

import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.disney.id.android.Guest;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\r\u0010\u0013\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0014J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/audience/AirshipDeviceAudienceResult;", "Lcom/urbanairship/json/JsonSerializable;", "isMatch", "", "reportingMetadata", "", "Lcom/urbanairship/json/JsonValue;", "(ZLjava/util/List;)V", "()Z", "getReportingMetadata", "()Ljava/util/List;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "negate", "negate$urbanairship_core_release", "toJsonValue", "toString", "", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class AirshipDeviceAudienceResult implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final AirshipDeviceAudienceResult match;
    private static final AirshipDeviceAudienceResult miss;
    private final boolean isMatch;
    private final List reportingMetadata;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AirshipDeviceAudienceResult copy$default(AirshipDeviceAudienceResult airshipDeviceAudienceResult, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = airshipDeviceAudienceResult.isMatch;
        }
        if ((i & 2) != 0) {
            list = airshipDeviceAudienceResult.reportingMetadata;
        }
        return airshipDeviceAudienceResult.copy(z, list);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsMatch() {
        return this.isMatch;
    }

    @Nullable
    public final List<JsonValue> component2() {
        return this.reportingMetadata;
    }

    @NotNull
    public final AirshipDeviceAudienceResult copy(boolean isMatch, @Nullable List<? extends JsonValue> reportingMetadata) {
        return new AirshipDeviceAudienceResult(isMatch, reportingMetadata);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AirshipDeviceAudienceResult)) {
            return false;
        }
        AirshipDeviceAudienceResult airshipDeviceAudienceResult = (AirshipDeviceAudienceResult) other;
        return this.isMatch == airshipDeviceAudienceResult.isMatch && Intrinsics.areEqual(this.reportingMetadata, airshipDeviceAudienceResult.reportingMetadata);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.isMatch) * 31;
        List list = this.reportingMetadata;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    @NotNull
    public String toString() {
        return "AirshipDeviceAudienceResult(isMatch=" + this.isMatch + ", reportingMetadata=" + this.reportingMetadata + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public AirshipDeviceAudienceResult(boolean z, @Nullable List<? extends JsonValue> list) {
        this.isMatch = z;
        this.reportingMetadata = list;
    }

    public /* synthetic */ AirshipDeviceAudienceResult(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : list);
    }

    public final boolean isMatch() {
        return this.isMatch;
    }

    @Nullable
    public final List<JsonValue> getReportingMetadata() {
        return this.reportingMetadata;
    }

    @NotNull
    public final AirshipDeviceAudienceResult negate$urbanairship_core_release() {
        return new AirshipDeviceAudienceResult(!this.isMatch, this.reportingMetadata);
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eJ5\u0010\u000f\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u0013H\u0000¢\u0006\u0002\b\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/audience/AirshipDeviceAudienceResult$Companion;", "", "()V", "IS_MATCH", "", "REPORTING_METADATA", "match", "Lcom/urbanairship/audience/AirshipDeviceAudienceResult;", "getMatch", "()Lcom/urbanairship/audience/AirshipDeviceAudienceResult;", "miss", "getMiss", "fromJson", "value", "Lcom/urbanairship/json/JsonValue;", Guest.PAYLOAD_REDUCED, "results", "", "reducer", "Lkotlin/Function2;", "", "reduced$urbanairship_core_release", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAirshipDeviceAudienceResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirshipDeviceAudienceResult.kt\ncom/urbanairship/audience/AirshipDeviceAudienceResult$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,64:1\n44#2,15:65\n1855#3:80\n1856#3:82\n1#4:81\n*S KotlinDebug\n*F\n+ 1 AirshipDeviceAudienceResult.kt\ncom/urbanairship/audience/AirshipDeviceAudienceResult$Companion\n*L\n33#1:65,15\n45#1:80\n45#1:82\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final AirshipDeviceAudienceResult getMatch() {
            return AirshipDeviceAudienceResult.match;
        }

        @NotNull
        public final AirshipDeviceAudienceResult getMiss() {
            return AirshipDeviceAudienceResult.miss;
        }

        @NotNull
        public final AirshipDeviceAudienceResult fromJson(@NotNull JsonValue value) throws JsonException {
            Boolean boolValueOf;
            JsonList jsonListRequireList;
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonValue jsonValue = jsonMapRequireMap.get("is_match");
            if (jsonValue == null) {
                throw new JsonException("Missing required field: 'is_match" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString = jsonValue.optString();
                if (objOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString2 = jsonValue.optString();
                if (objOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                boolValueOf = Boolean.valueOf(jsonValue.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                boolValueOf = (Boolean) Long.valueOf(jsonValue.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                boolValueOf = (Boolean) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                boolValueOf = (Boolean) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                boolValueOf = (Boolean) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                boolValueOf = (Boolean) Integer.valueOf(jsonValue.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                boolValueOf = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList = jsonValue.optList();
                if (objOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap = jsonValue.optMap();
                if (objOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'is_match" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue2 = jsonValue.getJsonValue();
                if (jsonValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) jsonValue2;
            }
            boolean zBooleanValue = boolValueOf.booleanValue();
            JsonValue jsonValue3 = jsonMapRequireMap.get("reporting_metadata");
            return new AirshipDeviceAudienceResult(zBooleanValue, (jsonValue3 == null || (jsonListRequireList = jsonValue3.requireList()) == null) ? null : jsonListRequireList.getList());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final AirshipDeviceAudienceResult reduced$urbanairship_core_release(@NotNull List<AirshipDeviceAudienceResult> results, @NotNull Function2<? super Boolean, ? super Boolean, Boolean> reducer) {
            T tValueOf;
            Intrinsics.checkNotNullParameter(results, "results");
            Intrinsics.checkNotNullParameter(reducer, "reducer");
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ArrayList arrayList = null;
            for (AirshipDeviceAudienceResult airshipDeviceAudienceResult : results) {
                Boolean bool = (Boolean) objectRef.element;
                if (bool != null) {
                    Boolean boolInvoke = reducer.invoke(bool, Boolean.valueOf(airshipDeviceAudienceResult.isMatch()));
                    boolInvoke.booleanValue();
                    tValueOf = boolInvoke;
                } else {
                    tValueOf = Boolean.valueOf(airshipDeviceAudienceResult.isMatch());
                }
                objectRef.element = tValueOf;
                List<JsonValue> reportingMetadata = airshipDeviceAudienceResult.getReportingMetadata();
                if (reportingMetadata != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(reportingMetadata);
                }
            }
            Boolean bool2 = (Boolean) objectRef.element;
            return new AirshipDeviceAudienceResult(bool2 != null ? bool2.booleanValue() : true, arrayList);
        }
    }

    static {
        int i = 2;
        match = new AirshipDeviceAudienceResult(true, 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        miss = new AirshipDeviceAudienceResult(false, 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("is_match", Boolean.valueOf(this.isMatch)), TuplesKt.to("reporting_metadata", this.reportingMetadata)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
