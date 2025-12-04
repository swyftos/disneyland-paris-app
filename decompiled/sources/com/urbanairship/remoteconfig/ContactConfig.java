package com.urbanairship.remoteconfig;

import androidx.annotation.RestrictTo;
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
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001f\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/remoteconfig/ContactConfig;", "Lcom/urbanairship/json/JsonSerializable;", "foregroundIntervalMs", "", "channelRegistrationMaxResolveAgeMs", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getChannelRegistrationMaxResolveAgeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getForegroundIntervalMs", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/urbanairship/remoteconfig/ContactConfig;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class ContactConfig implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final Long channelRegistrationMaxResolveAgeMs;
    private final Long foregroundIntervalMs;

    @JvmOverloads
    public ContactConfig() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public ContactConfig(@Nullable Long l) {
        this(l, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ContactConfig copy$default(ContactConfig contactConfig, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = contactConfig.foregroundIntervalMs;
        }
        if ((i & 2) != 0) {
            l2 = contactConfig.channelRegistrationMaxResolveAgeMs;
        }
        return contactConfig.copy(l, l2);
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final ContactConfig fromJson(@NotNull JsonValue jsonValue) {
        return INSTANCE.fromJson(jsonValue);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Long getForegroundIntervalMs() {
        return this.foregroundIntervalMs;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Long getChannelRegistrationMaxResolveAgeMs() {
        return this.channelRegistrationMaxResolveAgeMs;
    }

    @NotNull
    public final ContactConfig copy(@Nullable Long foregroundIntervalMs, @Nullable Long channelRegistrationMaxResolveAgeMs) {
        return new ContactConfig(foregroundIntervalMs, channelRegistrationMaxResolveAgeMs);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContactConfig)) {
            return false;
        }
        ContactConfig contactConfig = (ContactConfig) other;
        return Intrinsics.areEqual(this.foregroundIntervalMs, contactConfig.foregroundIntervalMs) && Intrinsics.areEqual(this.channelRegistrationMaxResolveAgeMs, contactConfig.channelRegistrationMaxResolveAgeMs);
    }

    public int hashCode() {
        Long l = this.foregroundIntervalMs;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.channelRegistrationMaxResolveAgeMs;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ContactConfig(foregroundIntervalMs=" + this.foregroundIntervalMs + ", channelRegistrationMaxResolveAgeMs=" + this.channelRegistrationMaxResolveAgeMs + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @JvmOverloads
    public ContactConfig(@Nullable Long l, @Nullable Long l2) {
        this.foregroundIntervalMs = l;
        this.channelRegistrationMaxResolveAgeMs = l2;
    }

    public /* synthetic */ ContactConfig(Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2);
    }

    @Nullable
    public final Long getForegroundIntervalMs() {
        return this.foregroundIntervalMs;
    }

    @Nullable
    public final Long getChannelRegistrationMaxResolveAgeMs() {
        return this.channelRegistrationMaxResolveAgeMs;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("foreground_resolve_interval_ms", this.foregroundIntervalMs), TuplesKt.to("max_cra_resolve_age_ms", this.channelRegistrationMaxResolveAgeMs)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/remoteconfig/ContactConfig$Companion;", "", "()V", "CHANNEL_REGISTRATION_MAX_RESOLVE_AGE_MS_KEY", "", "FOREGROUND_INTERVAL_MS_KEY", "fromJson", "Lcom/urbanairship/remoteconfig/ContactConfig;", "json", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @SourceDebugExtension({"SMAP\nRemoteConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteConfig.kt\ncom/urbanairship/remoteconfig/ContactConfig$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,283:1\n79#2,16:284\n79#2,16:300\n*S KotlinDebug\n*F\n+ 1 RemoteConfig.kt\ncom/urbanairship/remoteconfig/ContactConfig$Companion\n*L\n140#1:284,16\n141#1:300,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public final ContactConfig fromJson(@NotNull JsonValue json) throws JsonException {
            Long lValueOf;
            Long lValueOf2;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonMap jsonMapOptMap = json.optMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
            JsonValue jsonValue = jsonMapOptMap.get("foreground_resolve_interval_ms");
            Long l = null;
            if (jsonValue == null) {
                lValueOf = null;
            } else {
                Intrinsics.checkNotNull(jsonValue);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    lValueOf = (Long) jsonValue.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    lValueOf = (Long) Boolean.valueOf(jsonValue.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    lValueOf = Long.valueOf(jsonValue.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    lValueOf = (Long) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    lValueOf = (Long) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    lValueOf = (Long) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    lValueOf = (Long) Integer.valueOf(jsonValue.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    lValueOf = (Long) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    lValueOf = (Long) jsonValue.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    lValueOf = (Long) jsonValue.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Long.class.getSimpleName() + "' for field 'foreground_resolve_interval_ms" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    lValueOf = (Long) jsonValue.getJsonValue();
                }
            }
            JsonMap jsonMapOptMap2 = json.optMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapOptMap2, "optMap(...)");
            JsonValue jsonValue2 = jsonMapOptMap2.get("max_cra_resolve_age_ms");
            if (jsonValue2 != null) {
                Intrinsics.checkNotNull(jsonValue2);
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Long.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    lValueOf2 = (Long) jsonValue2.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    lValueOf2 = (Long) Boolean.valueOf(jsonValue2.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    lValueOf2 = Long.valueOf(jsonValue2.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    lValueOf2 = (Long) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue2.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    lValueOf2 = (Long) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    lValueOf2 = (Long) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    lValueOf2 = (Long) Integer.valueOf(jsonValue2.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    lValueOf2 = (Long) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    lValueOf2 = (Long) jsonValue2.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    lValueOf2 = (Long) jsonValue2.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Long.class.getSimpleName() + "' for field 'max_cra_resolve_age_ms" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    lValueOf2 = (Long) jsonValue2.getJsonValue();
                }
                l = lValueOf2;
            }
            return new ContactConfig(lValueOf, l);
        }
    }
}
