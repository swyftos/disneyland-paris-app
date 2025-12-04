package com.urbanairship.automation;

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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/automation/AdditionalAudienceCheckOverrides;", "Lcom/urbanairship/json/JsonSerializable;", "bypass", "", "context", "Lcom/urbanairship/json/JsonValue;", "url", "", "(Ljava/lang/Boolean;Lcom/urbanairship/json/JsonValue;Ljava/lang/String;)V", "getBypass", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getContext", "()Lcom/urbanairship/json/JsonValue;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Lcom/urbanairship/json/JsonValue;Ljava/lang/String;)Lcom/urbanairship/automation/AdditionalAudienceCheckOverrides;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "toString", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AdditionalAudienceCheckOverrides implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean bypass;
    private final JsonValue context;
    private final String url;

    public static /* synthetic */ AdditionalAudienceCheckOverrides copy$default(AdditionalAudienceCheckOverrides additionalAudienceCheckOverrides, Boolean bool, JsonValue jsonValue, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = additionalAudienceCheckOverrides.bypass;
        }
        if ((i & 2) != 0) {
            jsonValue = additionalAudienceCheckOverrides.context;
        }
        if ((i & 4) != 0) {
            str = additionalAudienceCheckOverrides.url;
        }
        return additionalAudienceCheckOverrides.copy(bool, jsonValue, str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Boolean getBypass() {
        return this.bypass;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final JsonValue getContext() {
        return this.context;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final AdditionalAudienceCheckOverrides copy(@Nullable Boolean bypass, @Nullable JsonValue context, @Nullable String url) {
        return new AdditionalAudienceCheckOverrides(bypass, context, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdditionalAudienceCheckOverrides)) {
            return false;
        }
        AdditionalAudienceCheckOverrides additionalAudienceCheckOverrides = (AdditionalAudienceCheckOverrides) other;
        return Intrinsics.areEqual(this.bypass, additionalAudienceCheckOverrides.bypass) && Intrinsics.areEqual(this.context, additionalAudienceCheckOverrides.context) && Intrinsics.areEqual(this.url, additionalAudienceCheckOverrides.url);
    }

    public int hashCode() {
        Boolean bool = this.bypass;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        JsonValue jsonValue = this.context;
        int iHashCode2 = (iHashCode + (jsonValue == null ? 0 : jsonValue.hashCode())) * 31;
        String str = this.url;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AdditionalAudienceCheckOverrides(bypass=" + this.bypass + ", context=" + this.context + ", url=" + this.url + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public AdditionalAudienceCheckOverrides(@Nullable Boolean bool, @Nullable JsonValue jsonValue, @Nullable String str) {
        this.bypass = bool;
        this.context = jsonValue;
        this.url = str;
    }

    @Nullable
    public final Boolean getBypass() {
        return this.bypass;
    }

    @Nullable
    public final JsonValue getContext() {
        return this.context;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/automation/AdditionalAudienceCheckOverrides$Companion;", "", "()V", "BYPASS", "", "CONTEXT", "URL", "fromJson", "Lcom/urbanairship/automation/AdditionalAudienceCheckOverrides;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAutomationAudience.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationAudience.kt\ncom/urbanairship/automation/AdditionalAudienceCheckOverrides$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,122:1\n79#2,16:123\n79#2,16:139\n*S KotlinDebug\n*F\n+ 1 AutomationAudience.kt\ncom/urbanairship/automation/AdditionalAudienceCheckOverrides$Companion\n*L\n109#1:123,16\n111#1:139,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final AdditionalAudienceCheckOverrides fromJson(@NotNull JsonValue value) throws JsonException {
            Boolean boolValueOf;
            String strOptString;
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonValue jsonValue = jsonMapRequireMap.get("bypass");
            String str = null;
            if (jsonValue == null) {
                boolValueOf = null;
            } else {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    boolValueOf = (Boolean) jsonValue.optString();
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
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    boolValueOf = (Boolean) Integer.valueOf(jsonValue.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    boolValueOf = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    boolValueOf = (Boolean) jsonValue.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    boolValueOf = (Boolean) jsonValue.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'bypass" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    boolValueOf = (Boolean) jsonValue.getJsonValue();
                }
            }
            JsonValue jsonValue2 = jsonMapRequireMap.get("context");
            JsonValue jsonValue3 = jsonMapRequireMap.get("url");
            if (jsonValue3 != null) {
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString = jsonValue3.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString = (String) Long.valueOf(jsonValue3.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    strOptString = (String) Integer.valueOf(jsonValue3.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    strOptString = (String) jsonValue3.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    strOptString = (String) jsonValue3.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'url" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    strOptString = (String) jsonValue3.getJsonValue();
                }
                str = strOptString;
            }
            return new AdditionalAudienceCheckOverrides(boolValueOf, jsonValue2, str);
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("bypass", this.bypass), TuplesKt.to("context", this.context), TuplesKt.to("url", this.url)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
