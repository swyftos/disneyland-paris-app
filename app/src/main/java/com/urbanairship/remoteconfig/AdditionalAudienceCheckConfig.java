package com.urbanairship.remoteconfig;

import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
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

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, m1836d2 = {"Lcom/urbanairship/remoteconfig/AdditionalAudienceCheckConfig;", "Lcom/urbanairship/json/JsonSerializable;", "isEnabled", "", "context", "Lcom/urbanairship/json/JsonValue;", "url", "", "(ZLcom/urbanairship/json/JsonValue;Ljava/lang/String;)V", "getContext", "()Lcom/urbanairship/json/JsonValue;", "()Z", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "toString", "Companion", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final /* data */ class AdditionalAudienceCheckConfig implements JsonSerializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final JsonValue context;
    private final boolean isEnabled;
    private final String url;

    public static /* synthetic */ AdditionalAudienceCheckConfig copy$default(AdditionalAudienceCheckConfig additionalAudienceCheckConfig, boolean z, JsonValue jsonValue, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = additionalAudienceCheckConfig.isEnabled;
        }
        if ((i & 2) != 0) {
            jsonValue = additionalAudienceCheckConfig.context;
        }
        if ((i & 4) != 0) {
            str = additionalAudienceCheckConfig.url;
        }
        return additionalAudienceCheckConfig.copy(z, jsonValue, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final JsonValue getContext() {
        return this.context;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final AdditionalAudienceCheckConfig copy(boolean isEnabled, @Nullable JsonValue context, @Nullable String url) {
        return new AdditionalAudienceCheckConfig(isEnabled, context, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdditionalAudienceCheckConfig)) {
            return false;
        }
        AdditionalAudienceCheckConfig additionalAudienceCheckConfig = (AdditionalAudienceCheckConfig) other;
        return this.isEnabled == additionalAudienceCheckConfig.isEnabled && Intrinsics.areEqual(this.context, additionalAudienceCheckConfig.context) && Intrinsics.areEqual(this.url, additionalAudienceCheckConfig.url);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.isEnabled) * 31;
        JsonValue jsonValue = this.context;
        int iHashCode2 = (iHashCode + (jsonValue == null ? 0 : jsonValue.hashCode())) * 31;
        String str = this.url;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AdditionalAudienceCheckConfig(isEnabled=" + this.isEnabled + ", context=" + this.context + ", url=" + this.url + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public AdditionalAudienceCheckConfig(boolean z, @Nullable JsonValue jsonValue, @Nullable String str) {
        this.isEnabled = z;
        this.context = jsonValue;
        this.url = str;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @Nullable
    public final JsonValue getContext() {
        return this.context;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1836d2 = {"Lcom/urbanairship/remoteconfig/AdditionalAudienceCheckConfig$Companion;", "", "()V", "CONTEXT", "", "IS_ENABLED", "URL", "fromJson", "Lcom/urbanairship/remoteconfig/AdditionalAudienceCheckConfig;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nRemoteConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteConfig.kt\ncom/urbanairship/remoteconfig/AdditionalAudienceCheckConfig$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,283:1\n44#2,15:284\n79#2,16:299\n*S KotlinDebug\n*F\n+ 1 RemoteConfig.kt\ncom/urbanairship/remoteconfig/AdditionalAudienceCheckConfig$Companion\n*L\n270#1:284,15\n272#1:299,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:100:0x029a  */
        /* JADX WARN: Code duplicated, block: B:103:0x02a4  */
        /* JADX WARN: Code duplicated, block: B:61:0x017b  */
        /* JADX WARN: Code duplicated, block: B:62:0x017e  */
        /* JADX WARN: Code duplicated, block: B:70:0x01b1  */
        /* JADX WARN: Code duplicated, block: B:71:0x01be  */
        /* JADX WARN: Code duplicated, block: B:73:0x01ca  */
        /* JADX WARN: Code duplicated, block: B:74:0x01d8  */
        /* JADX WARN: Code duplicated, block: B:76:0x01e2  */
        /* JADX WARN: Code duplicated, block: B:77:0x01f4  */
        /* JADX WARN: Code duplicated, block: B:79:0x0200  */
        /* JADX WARN: Code duplicated, block: B:80:0x020e  */
        /* JADX WARN: Code duplicated, block: B:82:0x021a  */
        /* JADX WARN: Code duplicated, block: B:83:0x0227  */
        /* JADX WARN: Code duplicated, block: B:91:0x025f  */
        /* JADX WARN: Code duplicated, block: B:92:0x026e  */
        /* JADX WARN: Code duplicated, block: B:94:0x0278  */
        /* JADX WARN: Code duplicated, block: B:95:0x027f  */
        /* JADX WARN: Code duplicated, block: B:97:0x0289  */
        /* JADX WARN: Code duplicated, block: B:98:0x0290  */
        /* JADX WARN: Instruction removed from duplicated block: B:103:0x02a4, please report this as an issue */
        @NotNull
        public final AdditionalAudienceCheckConfig fromJson(@NotNull JsonValue value) throws JsonException {
            String str;
            Boolean boolValueOf;
            JsonValue jsonValue;
            KClass orCreateKotlinClass;
            String strOptString;
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonValue jsonValue2 = jsonMapRequireMap.get("enabled");
            if (jsonValue2 == null) {
                throw new JsonException("Missing required field: 'enabled" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue2);
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Boolean.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString = jsonValue2.optString();
                if (objOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString2 = jsonValue2.optString();
                if (objOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptString2;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        boolValueOf = (Boolean) Long.valueOf(jsonValue2.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        str = "' for field '";
                        boolValueOf = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue2.getLong(0L)));
                    } else {
                        str = "' for field '";
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            boolValueOf = (Boolean) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            boolValueOf = (Boolean) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            boolValueOf = (Boolean) Integer.valueOf(jsonValue2.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            boolValueOf = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue2.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            Object objOptList = jsonValue2.optList();
                            if (objOptList == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                            boolValueOf = (Boolean) objOptList;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            Object objOptMap = jsonValue2.optMap();
                            if (objOptMap == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                            boolValueOf = (Boolean) objOptMap;
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + str + "enabled" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Object jsonValue3 = jsonValue2.getJsonValue();
                            if (jsonValue3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                            boolValueOf = (Boolean) jsonValue3;
                        }
                    }
                    boolean zBooleanValue = boolValueOf.booleanValue();
                    JsonValue jsonValue4 = jsonMapRequireMap.get("context");
                    jsonValue = jsonMapRequireMap.get("url");
                    if (jsonValue == null) {
                        strOptString = null;
                    } else {
                        Intrinsics.checkNotNull(jsonValue);
                        orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString = jsonValue.optString();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            strOptString = (String) jsonValue.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            strOptString = (String) jsonValue.optMap();
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "url" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            strOptString = (String) jsonValue.getJsonValue();
                        }
                    }
                    return new AdditionalAudienceCheckConfig(zBooleanValue, jsonValue4, strOptString);
                }
                boolValueOf = Boolean.valueOf(jsonValue2.getBoolean(false));
            }
            str = "' for field '";
            boolean zBooleanValue2 = boolValueOf.booleanValue();
            JsonValue jsonValue5 = jsonMapRequireMap.get("context");
            jsonValue = jsonMapRequireMap.get("url");
            if (jsonValue == null) {
                strOptString = null;
            } else {
                Intrinsics.checkNotNull(jsonValue);
                orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString = jsonValue.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    strOptString = (String) jsonValue.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    strOptString = (String) jsonValue.optMap();
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "url" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    strOptString = (String) jsonValue.getJsonValue();
                }
            }
            return new AdditionalAudienceCheckConfig(zBooleanValue2, jsonValue5, strOptString);
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* JADX INFO: renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("enabled", Boolean.valueOf(this.isEnabled)), TuplesKt.m1842to("context", this.context), TuplesKt.m1842to("url", this.url)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
