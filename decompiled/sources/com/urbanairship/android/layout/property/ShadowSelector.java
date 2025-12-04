package com.urbanairship.android.layout.property;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.android.layout.property.Shadow;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/android/layout/property/ShadowSelector;", "", DeferredApiClient.KEY_PLATFORM, "Lcom/urbanairship/android/layout/property/Platform;", "shadow", "Lcom/urbanairship/android/layout/property/Shadow;", "(Lcom/urbanairship/android/layout/property/Platform;Lcom/urbanairship/android/layout/property/Shadow;)V", "getPlatform", "()Lcom/urbanairship/android/layout/property/Platform;", "getShadow", "()Lcom/urbanairship/android/layout/property/Shadow;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ShadowSelector {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final Platform platform;
    private final Shadow shadow;

    public static /* synthetic */ ShadowSelector copy$default(ShadowSelector shadowSelector, Platform platform, Shadow shadow, int i, Object obj) {
        if ((i & 1) != 0) {
            platform = shadowSelector.platform;
        }
        if ((i & 2) != 0) {
            shadow = shadowSelector.shadow;
        }
        return shadowSelector.copy(platform, shadow);
    }

    @JvmStatic
    @NotNull
    public static final ShadowSelector fromJson(@NotNull JsonValue jsonValue) throws JsonException {
        return INSTANCE.fromJson(jsonValue);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Platform getPlatform() {
        return this.platform;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final Shadow getShadow() {
        return this.shadow;
    }

    @NotNull
    public final ShadowSelector copy(@Nullable Platform platform, @NotNull Shadow shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        return new ShadowSelector(platform, shadow);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShadowSelector)) {
            return false;
        }
        ShadowSelector shadowSelector = (ShadowSelector) other;
        return this.platform == shadowSelector.platform && Intrinsics.areEqual(this.shadow, shadowSelector.shadow);
    }

    public int hashCode() {
        Platform platform = this.platform;
        return ((platform == null ? 0 : platform.hashCode()) * 31) + this.shadow.hashCode();
    }

    @NotNull
    public String toString() {
        return "ShadowSelector(platform=" + this.platform + ", shadow=" + this.shadow + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ShadowSelector(@Nullable Platform platform, @NotNull Shadow shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        this.platform = platform;
        this.shadow = shadow;
    }

    @Nullable
    public final Platform getPlatform() {
        return this.platform;
    }

    @NotNull
    public final Shadow getShadow() {
        return this.shadow;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/ShadowSelector$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/property/ShadowSelector;", "json", "Lcom/urbanairship/json/JsonValue;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nShadowSelector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShadowSelector.kt\ncom/urbanairship/android/layout/property/ShadowSelector$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,23:1\n79#2,16:24\n44#2,15:41\n1#3:40\n*S KotlinDebug\n*F\n+ 1 ShadowSelector.kt\ncom/urbanairship/android/layout/property/ShadowSelector$Companion\n*L\n17#1:24,16\n18#1:41,15\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final ShadowSelector fromJson(@NotNull JsonValue json) throws JsonException {
            String str;
            String strOptString;
            JsonValue jsonValue;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonMap jsonMapRequireMap = json.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonValue jsonValue2 = jsonMapRequireMap.get(DeferredApiClient.KEY_PLATFORM);
            if (jsonValue2 == null) {
                str = "' for field '";
                strOptString = null;
            } else {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString = jsonValue2.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString = jsonValue2.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString = (String) Boolean.valueOf(jsonValue2.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    str = "' for field '";
                    strOptString = (String) Long.valueOf(jsonValue2.getLong(0L));
                } else {
                    str = "' for field '";
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue2.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString = (String) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString = (String) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        strOptString = (String) Integer.valueOf(jsonValue2.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList = jsonValue2.optList();
                        if (objOptList == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap = jsonValue2.optMap();
                        if (objOptMap == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptMap;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + DeferredApiClient.KEY_PLATFORM + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue3 = jsonValue2.getJsonValue();
                        if (jsonValue3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) jsonValue3;
                    }
                }
                str = "' for field '";
            }
            Platform platformFrom = strOptString != null ? Platform.from(strOptString) : null;
            Shadow.Companion companion = Shadow.INSTANCE;
            JsonMap jsonMapRequireMap2 = json.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap2, "requireMap(...)");
            JsonValue jsonValue4 = jsonMapRequireMap2.get("shadow");
            if (jsonValue4 == null) {
                throw new JsonException("Missing required field: 'shadow" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonValue.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString = jsonValue4.optString();
                if (objOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
                jsonValue = (JsonValue) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString2 = jsonValue4.optString();
                if (objOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
                jsonValue = (JsonValue) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jsonValue = (JsonValue) Boolean.valueOf(jsonValue4.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jsonValue = (JsonValue) Long.valueOf(jsonValue4.getLong(0L));
            } else {
                String str2 = str;
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    jsonValue = (JsonValue) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jsonValue = (JsonValue) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    jsonValue = (JsonValue) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    jsonValue = (JsonValue) Integer.valueOf(jsonValue4.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    jsonValue = (JsonValue) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    JsonSerializable jsonSerializableOptList = jsonValue4.optList();
                    if (jsonSerializableOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                    }
                    jsonValue = (JsonValue) jsonSerializableOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    JsonSerializable jsonSerializableOptMap = jsonValue4.optMap();
                    if (jsonSerializableOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                    }
                    jsonValue = (JsonValue) jsonSerializableOptMap;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + str2 + "shadow" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue = jsonValue4.getJsonValue();
                    if (jsonValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                    }
                }
            }
            return new ShadowSelector(platformFrom, companion.fromJson(jsonValue));
        }
    }
}
