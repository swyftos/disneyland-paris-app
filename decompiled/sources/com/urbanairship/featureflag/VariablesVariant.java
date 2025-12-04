package com.urbanairship.featureflag;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.audience.AudienceSelector;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u0000 $2\u00020\u0001:\u0001$B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\b\u0010!\u001a\u00020\"H\u0016J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lcom/urbanairship/featureflag/VariablesVariant;", "Lcom/urbanairship/json/JsonSerializable;", "id", "", "selector", "Lcom/urbanairship/audience/AudienceSelector;", "compoundAudienceSelector", "Lcom/urbanairship/featureflag/FeatureFlagCompoundAudience;", "reportingMetadata", "Lcom/urbanairship/json/JsonMap;", "data", "(Ljava/lang/String;Lcom/urbanairship/audience/AudienceSelector;Lcom/urbanairship/featureflag/FeatureFlagCompoundAudience;Lcom/urbanairship/json/JsonMap;Lcom/urbanairship/json/JsonMap;)V", "getCompoundAudienceSelector", "()Lcom/urbanairship/featureflag/FeatureFlagCompoundAudience;", "getData", "()Lcom/urbanairship/json/JsonMap;", "getId", "()Ljava/lang/String;", "getReportingMetadata", "getSelector", "()Lcom/urbanairship/audience/AudienceSelector;", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class VariablesVariant implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final FeatureFlagCompoundAudience compoundAudienceSelector;
    private final JsonMap data;
    private final String id;
    private final JsonMap reportingMetadata;
    private final AudienceSelector selector;

    public static /* synthetic */ VariablesVariant copy$default(VariablesVariant variablesVariant, String str, AudienceSelector audienceSelector, FeatureFlagCompoundAudience featureFlagCompoundAudience, JsonMap jsonMap, JsonMap jsonMap2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = variablesVariant.id;
        }
        if ((i & 2) != 0) {
            audienceSelector = variablesVariant.selector;
        }
        AudienceSelector audienceSelector2 = audienceSelector;
        if ((i & 4) != 0) {
            featureFlagCompoundAudience = variablesVariant.compoundAudienceSelector;
        }
        FeatureFlagCompoundAudience featureFlagCompoundAudience2 = featureFlagCompoundAudience;
        if ((i & 8) != 0) {
            jsonMap = variablesVariant.reportingMetadata;
        }
        JsonMap jsonMap3 = jsonMap;
        if ((i & 16) != 0) {
            jsonMap2 = variablesVariant.data;
        }
        return variablesVariant.copy(str, audienceSelector2, featureFlagCompoundAudience2, jsonMap3, jsonMap2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final AudienceSelector getSelector() {
        return this.selector;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final FeatureFlagCompoundAudience getCompoundAudienceSelector() {
        return this.compoundAudienceSelector;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final JsonMap getReportingMetadata() {
        return this.reportingMetadata;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final JsonMap getData() {
        return this.data;
    }

    @NotNull
    public final VariablesVariant copy(@Nullable String id, @Nullable AudienceSelector selector, @Nullable FeatureFlagCompoundAudience compoundAudienceSelector, @Nullable JsonMap reportingMetadata, @Nullable JsonMap data) {
        return new VariablesVariant(id, selector, compoundAudienceSelector, reportingMetadata, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VariablesVariant)) {
            return false;
        }
        VariablesVariant variablesVariant = (VariablesVariant) other;
        return Intrinsics.areEqual(this.id, variablesVariant.id) && Intrinsics.areEqual(this.selector, variablesVariant.selector) && Intrinsics.areEqual(this.compoundAudienceSelector, variablesVariant.compoundAudienceSelector) && Intrinsics.areEqual(this.reportingMetadata, variablesVariant.reportingMetadata) && Intrinsics.areEqual(this.data, variablesVariant.data);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        AudienceSelector audienceSelector = this.selector;
        int iHashCode2 = (iHashCode + (audienceSelector == null ? 0 : audienceSelector.hashCode())) * 31;
        FeatureFlagCompoundAudience featureFlagCompoundAudience = this.compoundAudienceSelector;
        int iHashCode3 = (iHashCode2 + (featureFlagCompoundAudience == null ? 0 : featureFlagCompoundAudience.hashCode())) * 31;
        JsonMap jsonMap = this.reportingMetadata;
        int iHashCode4 = (iHashCode3 + (jsonMap == null ? 0 : jsonMap.hashCode())) * 31;
        JsonMap jsonMap2 = this.data;
        return iHashCode4 + (jsonMap2 != null ? jsonMap2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VariablesVariant(id=" + this.id + ", selector=" + this.selector + ", compoundAudienceSelector=" + this.compoundAudienceSelector + ", reportingMetadata=" + this.reportingMetadata + ", data=" + this.data + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/urbanairship/featureflag/VariablesVariant$Companion;", "", "()V", "KEY_COMPOUND_AUDIENCE", "", "KEY_DATA", "KEY_ID", "KEY_REPORTING_METADATA", "KEY_SELECTOR", "fromJson", "Lcom/urbanairship/featureflag/VariablesVariant;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nFeatureFlagInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeatureFlagInfo.kt\ncom/urbanairship/featureflag/VariablesVariant$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,401:1\n44#2,15:402\n44#2,15:418\n79#2,16:433\n1#3:417\n*S KotlinDebug\n*F\n+ 1 FeatureFlagInfo.kt\ncom/urbanairship/featureflag/VariablesVariant$Companion\n*L\n119#1:402,15\n124#1:418,15\n125#1:433,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VariablesVariant fromJson(@NotNull JsonMap json) throws JsonException {
            String strOptString;
            JsonMap jsonMapOptMap;
            JsonMap jsonMapOptMap2;
            JsonMap jsonMap;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue = json.get("id");
            if (jsonValue == null) {
                throw new JsonException("Missing required field: 'id" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString = jsonValue.optString();
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
                strOptString = (String) jsonValue.optList();
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                strOptString = (String) jsonValue.optMap();
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'id" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                strOptString = (String) jsonValue.getJsonValue();
            }
            String str = strOptString;
            AudienceSelector.Companion companion = AudienceSelector.INSTANCE;
            JsonValue jsonValueOpt = json.opt("audience_selector");
            Intrinsics.checkNotNullExpressionValue(jsonValueOpt, "opt(...)");
            AudienceSelector audienceSelectorFromJson = companion.fromJson(jsonValueOpt);
            JsonValue jsonValue2 = json.get("compound_audience");
            FeatureFlagCompoundAudience featureFlagCompoundAudienceFromJson = jsonValue2 != null ? FeatureFlagCompoundAudience.INSTANCE.fromJson(jsonValue2) : null;
            JsonValue jsonValue3 = json.get("reporting_metadata");
            if (jsonValue3 == null) {
                throw new JsonException("Missing required field: 'reporting_metadata" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonMap.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                jsonMapOptMap = (JsonMap) jsonValue3.optString();
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue3.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue3.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue3.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                jsonMapOptMap = (JsonMap) jsonValue3.optList();
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                jsonMapOptMap = jsonValue3.optMap();
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'reporting_metadata" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                jsonMapOptMap = (JsonMap) jsonValue3.getJsonValue();
            }
            JsonMap jsonMap2 = jsonMapOptMap;
            JsonValue jsonValue4 = json.get("data");
            if (jsonValue4 == null) {
                jsonMap = null;
            } else {
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    jsonMapOptMap2 = (JsonMap) jsonValue4.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonMapOptMap2 = (JsonMap) Boolean.valueOf(jsonValue4.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jsonMapOptMap2 = (JsonMap) Long.valueOf(jsonValue4.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    jsonMapOptMap2 = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jsonMapOptMap2 = (JsonMap) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    jsonMapOptMap2 = (JsonMap) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    jsonMapOptMap2 = (JsonMap) Integer.valueOf(jsonValue4.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    jsonMapOptMap2 = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    jsonMapOptMap2 = (JsonMap) jsonValue4.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    jsonMapOptMap2 = jsonValue4.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'data" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonMapOptMap2 = (JsonMap) jsonValue4.getJsonValue();
                }
                jsonMap = jsonMapOptMap2;
            }
            return new VariablesVariant(str, audienceSelectorFromJson, featureFlagCompoundAudienceFromJson, jsonMap2, jsonMap);
        }

        private Companion() {
        }
    }

    public VariablesVariant(@Nullable String str, @Nullable AudienceSelector audienceSelector, @Nullable FeatureFlagCompoundAudience featureFlagCompoundAudience, @Nullable JsonMap jsonMap, @Nullable JsonMap jsonMap2) {
        this.id = str;
        this.selector = audienceSelector;
        this.compoundAudienceSelector = featureFlagCompoundAudience;
        this.reportingMetadata = jsonMap;
        this.data = jsonMap2;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final AudienceSelector getSelector() {
        return this.selector;
    }

    @Nullable
    public final FeatureFlagCompoundAudience getCompoundAudienceSelector() {
        return this.compoundAudienceSelector;
    }

    @Nullable
    public final JsonMap getReportingMetadata() {
        return this.reportingMetadata;
    }

    @Nullable
    public final JsonMap getData() {
        return this.data;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() throws JsonException {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("id", this.id), TuplesKt.to("audience_selector", this.selector), TuplesKt.to("compound_audience", this.compoundAudienceSelector), TuplesKt.to("reporting_metadata", this.reportingMetadata), TuplesKt.to("data", this.data)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
