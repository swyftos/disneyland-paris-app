package com.urbanairship.experiment;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.audience.CompoundAudienceSelector;
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

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/experiment/ExperimentCompoundAudience;", "Lcom/urbanairship/json/JsonSerializable;", "selector", "Lcom/urbanairship/audience/CompoundAudienceSelector;", "(Lcom/urbanairship/audience/CompoundAudienceSelector;)V", "getSelector", "()Lcom/urbanairship/audience/CompoundAudienceSelector;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ExperimentCompoundAudience implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final CompoundAudienceSelector selector;

    public static /* synthetic */ ExperimentCompoundAudience copy$default(ExperimentCompoundAudience experimentCompoundAudience, CompoundAudienceSelector compoundAudienceSelector, int i, Object obj) {
        if ((i & 1) != 0) {
            compoundAudienceSelector = experimentCompoundAudience.selector;
        }
        return experimentCompoundAudience.copy(compoundAudienceSelector);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final CompoundAudienceSelector getSelector() {
        return this.selector;
    }

    @NotNull
    public final ExperimentCompoundAudience copy(@NotNull CompoundAudienceSelector selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new ExperimentCompoundAudience(selector);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ExperimentCompoundAudience) && Intrinsics.areEqual(this.selector, ((ExperimentCompoundAudience) other).selector);
    }

    public int hashCode() {
        return this.selector.hashCode();
    }

    @NotNull
    public String toString() {
        return "ExperimentCompoundAudience(selector=" + this.selector + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ExperimentCompoundAudience(@NotNull CompoundAudienceSelector selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        this.selector = selector;
    }

    @NotNull
    public final CompoundAudienceSelector getSelector() {
        return this.selector;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/urbanairship/experiment/ExperimentCompoundAudience$Companion;", "", "()V", "SELECTOR", "", "fromJson", "Lcom/urbanairship/experiment/ExperimentCompoundAudience;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nExperiment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Experiment.kt\ncom/urbanairship/experiment/ExperimentCompoundAudience$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,254:1\n44#2,15:255\n*S KotlinDebug\n*F\n+ 1 Experiment.kt\ncom/urbanairship/experiment/ExperimentCompoundAudience$Companion\n*L\n165#1:255,15\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final ExperimentCompoundAudience fromJson(@NotNull JsonValue value) throws JsonException {
            JsonValue jsonValue;
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            CompoundAudienceSelector.Companion companion = CompoundAudienceSelector.INSTANCE;
            JsonValue jsonValue2 = jsonMapRequireMap.get("selector");
            if (jsonValue2 == null) {
                throw new JsonException("Missing required field: 'selector" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue2);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonValue.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString = jsonValue2.optString();
                if (objOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
                jsonValue = (JsonValue) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString2 = jsonValue2.optString();
                if (objOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
                jsonValue = (JsonValue) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jsonValue = (JsonValue) Boolean.valueOf(jsonValue2.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jsonValue = (JsonValue) Long.valueOf(jsonValue2.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                jsonValue = (JsonValue) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue2.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jsonValue = (JsonValue) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                jsonValue = (JsonValue) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                jsonValue = (JsonValue) Integer.valueOf(jsonValue2.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                jsonValue = (JsonValue) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                JsonSerializable jsonSerializableOptList = jsonValue2.optList();
                if (jsonSerializableOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
                jsonValue = (JsonValue) jsonSerializableOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                JsonSerializable jsonSerializableOptMap = jsonValue2.optMap();
                if (jsonSerializableOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
                jsonValue = (JsonValue) jsonSerializableOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + "' for field 'selector" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                jsonValue = jsonValue2.getJsonValue();
                if (jsonValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
            }
            return new ExperimentCompoundAudience(companion.fromJson(jsonValue));
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("selector", this.selector)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
