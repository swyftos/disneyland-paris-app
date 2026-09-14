package com.urbanairship.android.layout.property;

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
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0003\u0013\u0014\u0015B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/SmsLocale;", "Lcom/urbanairship/json/JsonSerializable;", "countryCode", "", "prefix", "registration", "Lcom/urbanairship/android/layout/property/SmsLocale$Registration;", "validationHints", "Lcom/urbanairship/android/layout/property/SmsLocale$ValidationHints;", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/android/layout/property/SmsLocale$Registration;Lcom/urbanairship/android/layout/property/SmsLocale$ValidationHints;)V", "getCountryCode", "()Ljava/lang/String;", "getPrefix", "getRegistration$urbanairship_layout_release", "()Lcom/urbanairship/android/layout/property/SmsLocale$Registration;", "getValidationHints$urbanairship_layout_release", "()Lcom/urbanairship/android/layout/property/SmsLocale$ValidationHints;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Companion", "Registration", "ValidationHints", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public final class SmsLocale implements JsonSerializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final String countryCode;
    private final String prefix;
    private final Registration registration;
    private final ValidationHints validationHints;

    public SmsLocale(@NotNull String countryCode, @NotNull String prefix, @Nullable Registration registration, @Nullable ValidationHints validationHints) {
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        this.countryCode = countryCode;
        this.prefix = prefix;
        this.registration = registration;
        this.validationHints = validationHints;
    }

    @NotNull
    public final String getCountryCode() {
        return this.countryCode;
    }

    @NotNull
    public final String getPrefix() {
        return this.prefix;
    }

    @Nullable
    /* JADX INFO: renamed from: getRegistration$urbanairship_layout_release, reason: from getter */
    public final Registration getRegistration() {
        return this.registration;
    }

    @Nullable
    /* JADX INFO: renamed from: getValidationHints$urbanairship_layout_release, reason: from getter */
    public final ValidationHints getValidationHints() {
        return this.validationHints;
    }

    @Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \t2\u00020\u0001:\u0004\t\n\u000b\fB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001\r¨\u0006\u000e"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/SmsLocale$Registration;", "Lcom/urbanairship/json/JsonSerializable;", "type", "Lcom/urbanairship/android/layout/property/SmsLocale$Registration$RegistrationType;", "(Lcom/urbanairship/android/layout/property/SmsLocale$Registration$RegistrationType;)V", "getType", "()Lcom/urbanairship/android/layout/property/SmsLocale$Registration$RegistrationType;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Companion", "OptIn", "OptInData", "RegistrationType", "Lcom/urbanairship/android/layout/property/SmsLocale$Registration$OptIn;", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static abstract class Registration implements JsonSerializable {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final RegistrationType type;

        public /* synthetic */ Registration(RegistrationType registrationType, DefaultConstructorMarker defaultConstructorMarker) {
            this(registrationType);
        }

        private Registration(RegistrationType registrationType) {
            this.type = registrationType;
        }

        @NotNull
        public final RegistrationType getType() {
            return this.type;
        }

        @Metadata(m1835d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/SmsLocale$Registration$OptIn;", "Lcom/urbanairship/android/layout/property/SmsLocale$Registration;", "data", "Lcom/urbanairship/android/layout/property/SmsLocale$Registration$OptInData;", "(Lcom/urbanairship/android/layout/property/SmsLocale$Registration$OptInData;)V", "getData", "()Lcom/urbanairship/android/layout/property/SmsLocale$Registration$OptInData;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
        public static final /* data */ class OptIn extends Registration {
            private final OptInData data;

            public static /* synthetic */ OptIn copy$default(OptIn optIn, OptInData optInData, int i, Object obj) {
                if ((i & 1) != 0) {
                    optInData = optIn.data;
                }
                return optIn.copy(optInData);
            }

            @NotNull
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final OptInData getData() {
                return this.data;
            }

            @NotNull
            public final OptIn copy(@NotNull OptInData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return new OptIn(data);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OptIn) && Intrinsics.areEqual(this.data, ((OptIn) other).data);
            }

            public int hashCode() {
                return this.data.hashCode();
            }

            @NotNull
            public String toString() {
                return "OptIn(data=" + this.data + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OptIn(@NotNull OptInData data) {
                super(RegistrationType.OPT_IN, null);
                Intrinsics.checkNotNullParameter(data, "data");
                this.data = data;
            }

            @NotNull
            public final OptInData getData() {
                return this.data;
            }
        }

        @Metadata(m1835d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/SmsLocale$Registration$OptInData;", "Lcom/urbanairship/json/JsonSerializable;", "senderId", "", "(Ljava/lang/String;)V", "getSenderId", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
        public static final /* data */ class OptInData implements JsonSerializable {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);
            private final String senderId;

            public static /* synthetic */ OptInData copy$default(OptInData optInData, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = optInData.senderId;
                }
                return optInData.copy(str);
            }

            @NotNull
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getSenderId() {
                return this.senderId;
            }

            @NotNull
            public final OptInData copy(@NotNull String senderId) {
                Intrinsics.checkNotNullParameter(senderId, "senderId");
                return new OptInData(senderId);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OptInData) && Intrinsics.areEqual(this.senderId, ((OptInData) other).senderId);
            }

            public int hashCode() {
                return this.senderId.hashCode();
            }

            @NotNull
            public String toString() {
                return "OptInData(senderId=" + this.senderId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public OptInData(@NotNull String senderId) {
                Intrinsics.checkNotNullParameter(senderId, "senderId");
                this.senderId = senderId;
            }

            @NotNull
            public final String getSenderId() {
                return this.senderId;
            }

            @Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/SmsLocale$Registration$OptInData$Companion;", "", "()V", "SENDER_ID_KEY", "", "fromJson", "Lcom/urbanairship/android/layout/property/SmsLocale$Registration$OptInData;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
            @SourceDebugExtension({"SMAP\nSmsLocale.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmsLocale.kt\ncom/urbanairship/android/layout/property/SmsLocale$Registration$OptInData$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,151:1\n44#2,15:152\n*S KotlinDebug\n*F\n+ 1 SmsLocale.kt\ncom/urbanairship/android/layout/property/SmsLocale$Registration$OptInData$Companion\n*L\n44#1:152,15\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @NotNull
                public final OptInData fromJson(@NotNull JsonValue value) throws JsonException {
                    String strOptString;
                    Intrinsics.checkNotNullParameter(value, "value");
                    JsonMap jsonMapRequireMap = value.requireMap();
                    Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                    JsonValue jsonValue = jsonMapRequireMap.get("sender_id");
                    if (jsonValue == null) {
                        throw new JsonException("Missing required field: 'sender_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
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
                        strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
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
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'sender_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue2 = jsonValue.toJsonValue();
                        if (jsonValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) jsonValue2;
                    }
                    return new OptInData(strOptString);
                }
            }

            @Override // com.urbanairship.json.JsonSerializable
            @NotNull
            public JsonValue toJsonValue() {
                JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("sender_id", this.senderId)).toJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                return jsonValue;
            }
        }

        @Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\b¨\u0006\n"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/SmsLocale$Registration$RegistrationType;", "", "Lcom/urbanairship/json/JsonSerializable;", "json", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "OPT_IN", "Companion", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
        public enum RegistrationType implements JsonSerializable {
            OPT_IN("opt_in");

            private final String json;
            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            public static EnumEntries<RegistrationType> getEntries() {
                return $ENTRIES;
            }

            RegistrationType(String str) {
                this.json = str;
            }

            @Override // com.urbanairship.json.JsonSerializable
            @NotNull
            public JsonValue toJsonValue() {
                JsonValue jsonValueWrap = JsonValue.wrap(this.json);
                Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
                return jsonValueWrap;
            }

            @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/SmsLocale$Registration$RegistrationType$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/property/SmsLocale$Registration$RegistrationType;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
            @SourceDebugExtension({"SMAP\nSmsLocale.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmsLocale.kt\ncom/urbanairship/android/layout/property/SmsLocale$Registration$RegistrationType$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,151:1\n223#2,2:152\n*S KotlinDebug\n*F\n+ 1 SmsLocale.kt\ncom/urbanairship/android/layout/property/SmsLocale$Registration$RegistrationType$Companion\n*L\n63#1:152,2\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @NotNull
                public final RegistrationType fromJson(@NotNull JsonValue value) throws NoSuchElementException, JsonException {
                    Intrinsics.checkNotNullParameter(value, "value");
                    String strRequireString = value.requireString();
                    Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                    for (RegistrationType registrationType : RegistrationType.getEntries()) {
                        if (Intrinsics.areEqual(registrationType.json, strRequireString)) {
                            return registrationType;
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() {
            JsonMap.Builder builderNewBuilder = JsonMap.newBuilder();
            Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder(...)");
            builderNewBuilder.put("type", this.type);
            if (this instanceof OptIn) {
                builderNewBuilder.putAll(((OptIn) this).getData().toJsonValue().optMap());
            }
            JsonValue jsonValue = builderNewBuilder.build().toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }

        @Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/SmsLocale$Registration$Companion;", "", "()V", "TYPE", "", "fromJson", "Lcom/urbanairship/android/layout/property/SmsLocale$Registration;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
        public static final class Companion {

            @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[RegistrationType.values().length];
                    try {
                        iArr[RegistrationType.OPT_IN.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Registration fromJson(@NotNull JsonValue value) throws JsonException {
                Intrinsics.checkNotNullParameter(value, "value");
                JsonMap jsonMapRequireMap = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                try {
                    RegistrationType.Companion companion = RegistrationType.INSTANCE;
                    JsonValue jsonValueRequire = jsonMapRequireMap.require("type");
                    Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
                    if (WhenMappings.$EnumSwitchMapping$0[companion.fromJson(jsonValueRequire).ordinal()] == 1) {
                        return new OptIn(OptInData.INSTANCE.fromJson(value));
                    }
                    throw new NoWhenBranchMatchedException();
                } catch (NoSuchElementException e) {
                    throw new JsonException("Invalid value of the registration type", e);
                }
            }
        }
    }

    @Metadata(m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\r"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/SmsLocale$ValidationHints;", "Lcom/urbanairship/json/JsonSerializable;", "minDigits", "", "maxDigits", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getMaxDigits", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMinDigits", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Companion", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final class ValidationHints implements JsonSerializable {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final Integer maxDigits;
        private final Integer minDigits;

        public ValidationHints(@Nullable Integer num, @Nullable Integer num2) {
            this.minDigits = num;
            this.maxDigits = num2;
        }

        @Nullable
        public final Integer getMinDigits() {
            return this.minDigits;
        }

        @Nullable
        public final Integer getMaxDigits() {
            return this.maxDigits;
        }

        @Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/SmsLocale$ValidationHints$Companion;", "", "()V", "MAX_DIGITS", "", "MIN_DIGITS", "fromJson", "Lcom/urbanairship/android/layout/property/SmsLocale$ValidationHints;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
        @SourceDebugExtension({"SMAP\nSmsLocale.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmsLocale.kt\ncom/urbanairship/android/layout/property/SmsLocale$ValidationHints$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,151:1\n79#2,16:152\n79#2,16:168\n*S KotlinDebug\n*F\n+ 1 SmsLocale.kt\ncom/urbanairship/android/layout/property/SmsLocale$ValidationHints$Companion\n*L\n113#1:152,16\n114#1:168,16\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final ValidationHints fromJson(@NotNull JsonValue value) throws JsonException {
                Integer numValueOf;
                Integer numValueOf2;
                Intrinsics.checkNotNullParameter(value, "value");
                JsonMap jsonMapRequireMap = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                JsonValue jsonValue = jsonMapRequireMap.get("min_digits");
                Integer num = null;
                if (jsonValue == null) {
                    numValueOf = null;
                } else {
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        numValueOf = (Integer) jsonValue.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        numValueOf = (Integer) Boolean.valueOf(jsonValue.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        numValueOf = (Integer) Long.valueOf(jsonValue.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        numValueOf = (Integer) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        numValueOf = (Integer) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        numValueOf = (Integer) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        numValueOf = Integer.valueOf(jsonValue.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        numValueOf = (Integer) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        numValueOf = (Integer) jsonValue.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        numValueOf = (Integer) jsonValue.optMap();
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + Integer.class.getSimpleName() + "' for field 'min_digits" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        numValueOf = (Integer) jsonValue.toJsonValue();
                    }
                }
                JsonValue jsonValue2 = jsonMapRequireMap.get("max_digits");
                if (jsonValue2 != null) {
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Integer.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        numValueOf2 = (Integer) jsonValue2.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        numValueOf2 = (Integer) Boolean.valueOf(jsonValue2.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        numValueOf2 = (Integer) Long.valueOf(jsonValue2.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        numValueOf2 = (Integer) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue2.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        numValueOf2 = (Integer) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        numValueOf2 = (Integer) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        numValueOf2 = Integer.valueOf(jsonValue2.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        numValueOf2 = (Integer) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue2.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        numValueOf2 = (Integer) jsonValue2.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        numValueOf2 = (Integer) jsonValue2.optMap();
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + Integer.class.getSimpleName() + "' for field 'max_digits" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        numValueOf2 = (Integer) jsonValue2.toJsonValue();
                    }
                    num = numValueOf2;
                }
                return new ValidationHints(numValueOf, num);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("min_digits", this.minDigits), TuplesKt.m1842to("max_digits", this.maxDigits)).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("country_code", this.countryCode), TuplesKt.m1842to("prefix", this.prefix), TuplesKt.m1842to("registration", this.registration), TuplesKt.m1842to("validation_hints", this.validationHints)).toJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/SmsLocale$Companion;", "", "()V", "COUNTRY_CODE", "", "PREFIX", "REGISTRATION", "VALIDATION_HINTS", "fromJson", "Lcom/urbanairship/android/layout/property/SmsLocale;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nSmsLocale.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmsLocale.kt\ncom/urbanairship/android/layout/property/SmsLocale$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,151:1\n44#2,15:152\n44#2,15:167\n1#3:182\n*S KotlinDebug\n*F\n+ 1 SmsLocale.kt\ncom/urbanairship/android/layout/property/SmsLocale$Companion\n*L\n143#1:152,15\n144#1:167,15\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:100:0x025e  */
        /* JADX WARN: Code duplicated, block: B:102:0x0264  */
        /* JADX WARN: Code duplicated, block: B:104:0x026e  */
        /* JADX WARN: Code duplicated, block: B:106:0x0274  */
        /* JADX WARN: Code duplicated, block: B:107:0x0277  */
        /* JADX WARN: Code duplicated, block: B:109:0x027d  */
        /* JADX WARN: Code duplicated, block: B:111:0x0287  */
        /* JADX WARN: Code duplicated, block: B:113:0x028d  */
        /* JADX WARN: Code duplicated, block: B:116:0x0298  */
        /* JADX WARN: Code duplicated, block: B:117:0x029f  */
        /* JADX WARN: Code duplicated, block: B:120:0x02a8  */
        /* JADX WARN: Code duplicated, block: B:123:0x02b4  */
        /* JADX WARN: Code duplicated, block: B:125:0x02ba  */
        /* JADX WARN: Code duplicated, block: B:127:0x02de  */
        /* JADX WARN: Code duplicated, block: B:60:0x0165  */
        /* JADX WARN: Code duplicated, block: B:62:0x0173  */
        /* JADX WARN: Code duplicated, block: B:65:0x017b  */
        /* JADX WARN: Code duplicated, block: B:67:0x0181  */
        /* JADX WARN: Code duplicated, block: B:69:0x018b  */
        /* JADX WARN: Code duplicated, block: B:72:0x0193  */
        /* JADX WARN: Code duplicated, block: B:74:0x0199  */
        /* JADX WARN: Code duplicated, block: B:76:0x01a5  */
        /* JADX WARN: Code duplicated, block: B:77:0x01b2  */
        /* JADX WARN: Code duplicated, block: B:79:0x01be  */
        /* JADX WARN: Code duplicated, block: B:80:0x01cc  */
        /* JADX WARN: Code duplicated, block: B:82:0x01d8  */
        /* JADX WARN: Code duplicated, block: B:83:0x01e8  */
        /* JADX WARN: Code duplicated, block: B:85:0x01f4  */
        /* JADX WARN: Code duplicated, block: B:86:0x0202  */
        /* JADX WARN: Code duplicated, block: B:88:0x020e  */
        /* JADX WARN: Code duplicated, block: B:89:0x021b  */
        /* JADX WARN: Code duplicated, block: B:91:0x0225  */
        /* JADX WARN: Code duplicated, block: B:92:0x0231  */
        /* JADX WARN: Code duplicated, block: B:94:0x023c  */
        /* JADX WARN: Code duplicated, block: B:95:0x024b  */
        /* JADX WARN: Code duplicated, block: B:97:0x0255  */
        /* JADX WARN: Code duplicated, block: B:99:0x025b  */
        /* JADX WARN: Instruction removed from duplicated block: B:125:0x02ba, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:127:0x02de, please report this as an issue */
        @NotNull
        public final SmsLocale fromJson(@NotNull JsonValue value) throws JsonException {
            String str;
            String strOptString;
            JsonValue jsonValue;
            KClass orCreateKotlinClass;
            Object jsonValue2;
            String strOptString2;
            Object objOptMap;
            Object objOptList;
            JsonValue jsonValue3;
            Registration registrationFromJson;
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonValue jsonValue4 = jsonMapRequireMap.get("country_code");
            if (jsonValue4 == null) {
                throw new JsonException("Missing required field: 'country_code" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue4.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString = (String) Boolean.valueOf(jsonValue4.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        str = "' for field '";
                        strOptString = (String) Long.valueOf(jsonValue4.getLong(0L));
                    } else {
                        str = "' for field '";
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue4.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString = (String) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString = (String) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            strOptString = (String) Integer.valueOf(jsonValue4.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue4.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            Object objOptList2 = jsonValue4.optList();
                            if (objOptList2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString = (String) objOptList2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            Object objOptMap2 = jsonValue4.optMap();
                            if (objOptMap2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString = (String) objOptMap2;
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "country_code" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Object jsonValue5 = jsonValue4.toJsonValue();
                            if (jsonValue5 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString = (String) jsonValue5;
                        }
                    }
                    jsonValue = jsonMapRequireMap.get("prefix");
                    if (jsonValue != null) {
                        throw new JsonException("Missing required field: 'prefix" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString2 = jsonValue.optString();
                        if (strOptString2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString2 = jsonValue.optString();
                        if (strOptString2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString2 = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString2 = (String) Long.valueOf(jsonValue.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString2 = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString2 = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString2 = (String) Integer.valueOf(jsonValue.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        objOptList = jsonValue.optList();
                        if (objOptList != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString2 = (String) objOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        objOptMap = jsonValue.optMap();
                        if (objOptMap != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString2 = (String) objOptMap;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "prefix" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue2 = jsonValue.toJsonValue();
                        if (jsonValue2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString2 = (String) jsonValue2;
                    }
                    jsonValue3 = jsonMapRequireMap.get("registration");
                    if (jsonValue3 != null) {
                        registrationFromJson = Registration.INSTANCE.fromJson(jsonValue3);
                    } else {
                        registrationFromJson = null;
                    }
                    JsonValue jsonValue6 = jsonMapRequireMap.get("validation_hints");
                    return new SmsLocale(strOptString, strOptString2, registrationFromJson, jsonValue6 != null ? ValidationHints.INSTANCE.fromJson(jsonValue6) : null);
                }
                strOptString = jsonValue4.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
            str = "' for field '";
            jsonValue = jsonMapRequireMap.get("prefix");
            if (jsonValue != null) {
                throw new JsonException("Missing required field: 'prefix" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString2 = jsonValue.optString();
                if (strOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString2 = jsonValue.optString();
                if (strOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString2 = (String) Boolean.valueOf(jsonValue.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString2 = (String) Long.valueOf(jsonValue.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString2 = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString2 = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString2 = (String) Integer.valueOf(jsonValue.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                objOptList = jsonValue.optList();
                if (objOptList != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString2 = (String) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                objOptMap = jsonValue.optMap();
                if (objOptMap != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString2 = (String) objOptMap;
            } else {
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "prefix" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                jsonValue2 = jsonValue.toJsonValue();
                if (jsonValue2 != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString2 = (String) jsonValue2;
            }
            jsonValue3 = jsonMapRequireMap.get("registration");
            if (jsonValue3 != null) {
                registrationFromJson = Registration.INSTANCE.fromJson(jsonValue3);
            } else {
                registrationFromJson = null;
            }
            JsonValue jsonValue7 = jsonMapRequireMap.get("validation_hints");
            return new SmsLocale(strOptString, strOptString2, registrationFromJson, jsonValue7 != null ? ValidationHints.INSTANCE.fromJson(jsonValue7) : null);
        }
    }
}
