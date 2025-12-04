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
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/remoteconfig/MeteredUsageConfig;", "Lcom/urbanairship/json/JsonSerializable;", "isEnabled", "", "initialDelayMs", "", "intervalMs", "(ZJJ)V", "getInitialDelayMs", "()J", "getIntervalMs", "()Z", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class MeteredUsageConfig implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final MeteredUsageConfig DEFAULT = new MeteredUsageConfig(false, 15, 30);
    private final long initialDelayMs;
    private final long intervalMs;
    private final boolean isEnabled;

    public static /* synthetic */ MeteredUsageConfig copy$default(MeteredUsageConfig meteredUsageConfig, boolean z, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = meteredUsageConfig.isEnabled;
        }
        if ((i & 2) != 0) {
            j = meteredUsageConfig.initialDelayMs;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = meteredUsageConfig.intervalMs;
        }
        return meteredUsageConfig.copy(z, j3, j2);
    }

    @JvmStatic
    @NotNull
    public static final MeteredUsageConfig fromJson(@NotNull JsonMap jsonMap) {
        return INSTANCE.fromJson(jsonMap);
    }

    @JvmStatic
    @NotNull
    public static final MeteredUsageConfig fromJson(@NotNull JsonValue jsonValue) {
        return INSTANCE.fromJson(jsonValue);
    }

    @NotNull
    public static final MeteredUsageConfig getDEFAULT() {
        return INSTANCE.getDEFAULT();
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    /* renamed from: component2, reason: from getter */
    public final long getInitialDelayMs() {
        return this.initialDelayMs;
    }

    /* renamed from: component3, reason: from getter */
    public final long getIntervalMs() {
        return this.intervalMs;
    }

    @NotNull
    public final MeteredUsageConfig copy(boolean isEnabled, long initialDelayMs, long intervalMs) {
        return new MeteredUsageConfig(isEnabled, initialDelayMs, intervalMs);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MeteredUsageConfig)) {
            return false;
        }
        MeteredUsageConfig meteredUsageConfig = (MeteredUsageConfig) other;
        return this.isEnabled == meteredUsageConfig.isEnabled && this.initialDelayMs == meteredUsageConfig.initialDelayMs && this.intervalMs == meteredUsageConfig.intervalMs;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.isEnabled) * 31) + Long.hashCode(this.initialDelayMs)) * 31) + Long.hashCode(this.intervalMs);
    }

    @NotNull
    public String toString() {
        return "MeteredUsageConfig(isEnabled=" + this.isEnabled + ", initialDelayMs=" + this.initialDelayMs + ", intervalMs=" + this.intervalMs + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public MeteredUsageConfig(boolean z, long j, long j2) {
        this.isEnabled = z;
        this.initialDelayMs = j;
        this.intervalMs = j2;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final long getInitialDelayMs() {
        return this.initialDelayMs;
    }

    public final long getIntervalMs() {
        return this.intervalMs;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("enabled", Boolean.valueOf(this.isEnabled)), TuplesKt.to("initial_delay_ms", Long.valueOf(this.initialDelayMs)), TuplesKt.to("interval_ms", Long.valueOf(this.intervalMs))).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0012H\u0007R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/remoteconfig/MeteredUsageConfig$Companion;", "", "()V", "DEFAULT", "Lcom/urbanairship/remoteconfig/MeteredUsageConfig;", "getDEFAULT$annotations", "getDEFAULT", "()Lcom/urbanairship/remoteconfig/MeteredUsageConfig;", "DEFAULT_INITIAL_DELAY", "", "DEFAULT_INTERVAL", "INITIAL_DELAY_MS_KEY", "", "INTERVAL_MS_KEY", "IS_ENABLED_KEY", "fromJson", "json", "Lcom/urbanairship/json/JsonMap;", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @SourceDebugExtension({"SMAP\nRemoteConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteConfig.kt\ncom/urbanairship/remoteconfig/MeteredUsageConfig$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,283:1\n79#2,16:284\n79#2,16:300\n79#2,16:316\n*S KotlinDebug\n*F\n+ 1 RemoteConfig.kt\ncom/urbanairship/remoteconfig/MeteredUsageConfig$Companion\n*L\n172#1:284,16\n173#1:300,16\n174#1:316,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getDEFAULT$annotations() {
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final MeteredUsageConfig fromJson(@NotNull JsonMap json) throws JsonException {
            Boolean boolValueOf;
            Long lValueOf;
            Long lValueOf2;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue = json.get("enabled");
            Long l = null;
            if (jsonValue == null) {
                boolValueOf = null;
            } else {
                Intrinsics.checkNotNull(jsonValue);
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
                        throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'enabled" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    boolValueOf = (Boolean) jsonValue.getJsonValue();
                }
            }
            boolean zBooleanValue = boolValueOf != null ? boolValueOf.booleanValue() : false;
            JsonValue jsonValue2 = json.get("initial_delay_ms");
            if (jsonValue2 == null) {
                lValueOf = null;
            } else {
                Intrinsics.checkNotNull(jsonValue2);
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Long.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    lValueOf = (Long) jsonValue2.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    lValueOf = (Long) Boolean.valueOf(jsonValue2.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    lValueOf = Long.valueOf(jsonValue2.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    lValueOf = (Long) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue2.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    lValueOf = (Long) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    lValueOf = (Long) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    lValueOf = (Long) Integer.valueOf(jsonValue2.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    lValueOf = (Long) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    lValueOf = (Long) jsonValue2.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    lValueOf = (Long) jsonValue2.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Long.class.getSimpleName() + "' for field 'initial_delay_ms" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    lValueOf = (Long) jsonValue2.getJsonValue();
                }
            }
            long jLongValue = lValueOf != null ? lValueOf.longValue() : 15L;
            JsonValue jsonValue3 = json.get("interval_ms");
            if (jsonValue3 != null) {
                Intrinsics.checkNotNull(jsonValue3);
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Long.class);
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    lValueOf2 = (Long) jsonValue3.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    lValueOf2 = (Long) Boolean.valueOf(jsonValue3.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    lValueOf2 = Long.valueOf(jsonValue3.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    lValueOf2 = (Long) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    lValueOf2 = (Long) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    lValueOf2 = (Long) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    lValueOf2 = (Long) Integer.valueOf(jsonValue3.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    lValueOf2 = (Long) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    lValueOf2 = (Long) jsonValue3.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    lValueOf2 = (Long) jsonValue3.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Long.class.getSimpleName() + "' for field 'interval_ms" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    lValueOf2 = (Long) jsonValue3.getJsonValue();
                }
                l = lValueOf2;
            }
            return new MeteredUsageConfig(zBooleanValue, jLongValue, l != null ? l.longValue() : 30L);
        }

        @JvmStatic
        @NotNull
        public final MeteredUsageConfig fromJson(@NotNull JsonValue json) {
            Intrinsics.checkNotNullParameter(json, "json");
            JsonMap jsonMapOptMap = json.optMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
            return fromJson(jsonMapOptMap);
        }

        @NotNull
        public final MeteredUsageConfig getDEFAULT() {
            return MeteredUsageConfig.DEFAULT;
        }
    }
}
