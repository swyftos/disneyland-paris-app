package com.urbanairship.remoteconfig;

import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogConstants;
import com.contentsquare.android.api.Currencies;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.PrivacyManager;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.Pair;
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
import okhttp3.internal.ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 32\u00020\u0001:\u00013B[\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010'\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jb\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\b\u0010/\u001a\u000200H\u0016J\t\u00101\u001a\u000202HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001f¨\u00064"}, d2 = {"Lcom/urbanairship/remoteconfig/RemoteConfig;", "Lcom/urbanairship/json/JsonSerializable;", "airshipConfig", "Lcom/urbanairship/remoteconfig/RemoteAirshipConfig;", "meteredUsageConfig", "Lcom/urbanairship/remoteconfig/MeteredUsageConfig;", "fetchContactRemoteData", "", "contactConfig", "Lcom/urbanairship/remoteconfig/ContactConfig;", "disabledFeatures", "Lcom/urbanairship/PrivacyManager$Feature;", "remoteDataRefreshInterval", "", "iaaConfig", "Lcom/urbanairship/remoteconfig/IAAConfig;", "(Lcom/urbanairship/remoteconfig/RemoteAirshipConfig;Lcom/urbanairship/remoteconfig/MeteredUsageConfig;Ljava/lang/Boolean;Lcom/urbanairship/remoteconfig/ContactConfig;Lcom/urbanairship/PrivacyManager$Feature;Ljava/lang/Long;Lcom/urbanairship/remoteconfig/IAAConfig;)V", "getAirshipConfig", "()Lcom/urbanairship/remoteconfig/RemoteAirshipConfig;", "getContactConfig", "()Lcom/urbanairship/remoteconfig/ContactConfig;", "getDisabledFeatures", "()Lcom/urbanairship/PrivacyManager$Feature;", "getFetchContactRemoteData", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIaaConfig", "()Lcom/urbanairship/remoteconfig/IAAConfig;", "getMeteredUsageConfig", "()Lcom/urbanairship/remoteconfig/MeteredUsageConfig;", "getRemoteDataRefreshInterval", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/urbanairship/remoteconfig/RemoteAirshipConfig;Lcom/urbanairship/remoteconfig/MeteredUsageConfig;Ljava/lang/Boolean;Lcom/urbanairship/remoteconfig/ContactConfig;Lcom/urbanairship/PrivacyManager$Feature;Ljava/lang/Long;Lcom/urbanairship/remoteconfig/IAAConfig;)Lcom/urbanairship/remoteconfig/RemoteConfig;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class RemoteConfig implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final RemoteAirshipConfig airshipConfig;
    private final ContactConfig contactConfig;
    private final PrivacyManager.Feature disabledFeatures;
    private final Boolean fetchContactRemoteData;
    private final IAAConfig iaaConfig;
    private final MeteredUsageConfig meteredUsageConfig;
    private final Long remoteDataRefreshInterval;

    @JvmOverloads
    public RemoteConfig() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    @JvmOverloads
    public RemoteConfig(@Nullable RemoteAirshipConfig remoteAirshipConfig) {
        this(remoteAirshipConfig, null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
    }

    @JvmOverloads
    public RemoteConfig(@Nullable RemoteAirshipConfig remoteAirshipConfig, @Nullable MeteredUsageConfig meteredUsageConfig) {
        this(remoteAirshipConfig, meteredUsageConfig, null, null, null, null, null, Currencies.CAD, null);
    }

    @JvmOverloads
    public RemoteConfig(@Nullable RemoteAirshipConfig remoteAirshipConfig, @Nullable MeteredUsageConfig meteredUsageConfig, @Nullable Boolean bool) {
        this(remoteAirshipConfig, meteredUsageConfig, bool, null, null, null, null, SyslogConstants.LOG_CLOCK, null);
    }

    @JvmOverloads
    public RemoteConfig(@Nullable RemoteAirshipConfig remoteAirshipConfig, @Nullable MeteredUsageConfig meteredUsageConfig, @Nullable Boolean bool, @Nullable ContactConfig contactConfig) {
        this(remoteAirshipConfig, meteredUsageConfig, bool, contactConfig, null, null, null, SyslogConstants.LOG_ALERT, null);
    }

    @JvmOverloads
    public RemoteConfig(@Nullable RemoteAirshipConfig remoteAirshipConfig, @Nullable MeteredUsageConfig meteredUsageConfig, @Nullable Boolean bool, @Nullable ContactConfig contactConfig, @Nullable PrivacyManager.Feature feature) {
        this(remoteAirshipConfig, meteredUsageConfig, bool, contactConfig, feature, null, null, 96, null);
    }

    @JvmOverloads
    public RemoteConfig(@Nullable RemoteAirshipConfig remoteAirshipConfig, @Nullable MeteredUsageConfig meteredUsageConfig, @Nullable Boolean bool, @Nullable ContactConfig contactConfig, @Nullable PrivacyManager.Feature feature, @Nullable Long l) {
        this(remoteAirshipConfig, meteredUsageConfig, bool, contactConfig, feature, l, null, 64, null);
    }

    public static /* synthetic */ RemoteConfig copy$default(RemoteConfig remoteConfig, RemoteAirshipConfig remoteAirshipConfig, MeteredUsageConfig meteredUsageConfig, Boolean bool, ContactConfig contactConfig, PrivacyManager.Feature feature, Long l, IAAConfig iAAConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            remoteAirshipConfig = remoteConfig.airshipConfig;
        }
        if ((i & 2) != 0) {
            meteredUsageConfig = remoteConfig.meteredUsageConfig;
        }
        MeteredUsageConfig meteredUsageConfig2 = meteredUsageConfig;
        if ((i & 4) != 0) {
            bool = remoteConfig.fetchContactRemoteData;
        }
        Boolean bool2 = bool;
        if ((i & 8) != 0) {
            contactConfig = remoteConfig.contactConfig;
        }
        ContactConfig contactConfig2 = contactConfig;
        if ((i & 16) != 0) {
            feature = remoteConfig.disabledFeatures;
        }
        PrivacyManager.Feature feature2 = feature;
        if ((i & 32) != 0) {
            l = remoteConfig.remoteDataRefreshInterval;
        }
        Long l2 = l;
        if ((i & 64) != 0) {
            iAAConfig = remoteConfig.iaaConfig;
        }
        return remoteConfig.copy(remoteAirshipConfig, meteredUsageConfig2, bool2, contactConfig2, feature2, l2, iAAConfig);
    }

    @JvmStatic
    @NotNull
    public static final RemoteConfig fromJson(@NotNull JsonMap jsonMap) {
        return INSTANCE.fromJson(jsonMap);
    }

    @JvmStatic
    @NotNull
    public static final RemoteConfig fromJson(@NotNull JsonValue jsonValue) {
        return INSTANCE.fromJson(jsonValue);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final RemoteAirshipConfig getAirshipConfig() {
        return this.airshipConfig;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final MeteredUsageConfig getMeteredUsageConfig() {
        return this.meteredUsageConfig;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Boolean getFetchContactRemoteData() {
        return this.fetchContactRemoteData;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final ContactConfig getContactConfig() {
        return this.contactConfig;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final PrivacyManager.Feature getDisabledFeatures() {
        return this.disabledFeatures;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Long getRemoteDataRefreshInterval() {
        return this.remoteDataRefreshInterval;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final IAAConfig getIaaConfig() {
        return this.iaaConfig;
    }

    @NotNull
    public final RemoteConfig copy(@Nullable RemoteAirshipConfig airshipConfig, @Nullable MeteredUsageConfig meteredUsageConfig, @Nullable Boolean fetchContactRemoteData, @Nullable ContactConfig contactConfig, @Nullable PrivacyManager.Feature disabledFeatures, @Nullable Long remoteDataRefreshInterval, @Nullable IAAConfig iaaConfig) {
        return new RemoteConfig(airshipConfig, meteredUsageConfig, fetchContactRemoteData, contactConfig, disabledFeatures, remoteDataRefreshInterval, iaaConfig);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteConfig)) {
            return false;
        }
        RemoteConfig remoteConfig = (RemoteConfig) other;
        return Intrinsics.areEqual(this.airshipConfig, remoteConfig.airshipConfig) && Intrinsics.areEqual(this.meteredUsageConfig, remoteConfig.meteredUsageConfig) && Intrinsics.areEqual(this.fetchContactRemoteData, remoteConfig.fetchContactRemoteData) && Intrinsics.areEqual(this.contactConfig, remoteConfig.contactConfig) && Intrinsics.areEqual(this.disabledFeatures, remoteConfig.disabledFeatures) && Intrinsics.areEqual(this.remoteDataRefreshInterval, remoteConfig.remoteDataRefreshInterval) && Intrinsics.areEqual(this.iaaConfig, remoteConfig.iaaConfig);
    }

    public int hashCode() {
        RemoteAirshipConfig remoteAirshipConfig = this.airshipConfig;
        int iHashCode = (remoteAirshipConfig == null ? 0 : remoteAirshipConfig.hashCode()) * 31;
        MeteredUsageConfig meteredUsageConfig = this.meteredUsageConfig;
        int iHashCode2 = (iHashCode + (meteredUsageConfig == null ? 0 : meteredUsageConfig.hashCode())) * 31;
        Boolean bool = this.fetchContactRemoteData;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        ContactConfig contactConfig = this.contactConfig;
        int iHashCode4 = (iHashCode3 + (contactConfig == null ? 0 : contactConfig.hashCode())) * 31;
        PrivacyManager.Feature feature = this.disabledFeatures;
        int iHashCode5 = (iHashCode4 + (feature == null ? 0 : feature.hashCode())) * 31;
        Long l = this.remoteDataRefreshInterval;
        int iHashCode6 = (iHashCode5 + (l == null ? 0 : l.hashCode())) * 31;
        IAAConfig iAAConfig = this.iaaConfig;
        return iHashCode6 + (iAAConfig != null ? iAAConfig.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "RemoteConfig(airshipConfig=" + this.airshipConfig + ", meteredUsageConfig=" + this.meteredUsageConfig + ", fetchContactRemoteData=" + this.fetchContactRemoteData + ", contactConfig=" + this.contactConfig + ", disabledFeatures=" + this.disabledFeatures + ", remoteDataRefreshInterval=" + this.remoteDataRefreshInterval + ", iaaConfig=" + this.iaaConfig + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @JvmOverloads
    public RemoteConfig(@Nullable RemoteAirshipConfig remoteAirshipConfig, @Nullable MeteredUsageConfig meteredUsageConfig, @Nullable Boolean bool, @Nullable ContactConfig contactConfig, @Nullable PrivacyManager.Feature feature, @Nullable Long l, @Nullable IAAConfig iAAConfig) {
        this.airshipConfig = remoteAirshipConfig;
        this.meteredUsageConfig = meteredUsageConfig;
        this.fetchContactRemoteData = bool;
        this.contactConfig = contactConfig;
        this.disabledFeatures = feature;
        this.remoteDataRefreshInterval = l;
        this.iaaConfig = iAAConfig;
    }

    public /* synthetic */ RemoteConfig(RemoteAirshipConfig remoteAirshipConfig, MeteredUsageConfig meteredUsageConfig, Boolean bool, ContactConfig contactConfig, PrivacyManager.Feature feature, Long l, IAAConfig iAAConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : remoteAirshipConfig, (i & 2) != 0 ? null : meteredUsageConfig, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : contactConfig, (i & 16) != 0 ? null : feature, (i & 32) != 0 ? null : l, (i & 64) != 0 ? null : iAAConfig);
    }

    @Nullable
    public final RemoteAirshipConfig getAirshipConfig() {
        return this.airshipConfig;
    }

    @Nullable
    public final MeteredUsageConfig getMeteredUsageConfig() {
        return this.meteredUsageConfig;
    }

    @Nullable
    public final Boolean getFetchContactRemoteData() {
        return this.fetchContactRemoteData;
    }

    @Nullable
    public final ContactConfig getContactConfig() {
        return this.contactConfig;
    }

    @Nullable
    public final PrivacyManager.Feature getDisabledFeatures() {
        return this.disabledFeatures;
    }

    @Nullable
    public final Long getRemoteDataRefreshInterval() {
        return this.remoteDataRefreshInterval;
    }

    @Nullable
    public final IAAConfig getIaaConfig() {
        return this.iaaConfig;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        RemoteAirshipConfig remoteAirshipConfig = this.airshipConfig;
        Pair pair = TuplesKt.to("airship_config", remoteAirshipConfig != null ? remoteAirshipConfig.getJsonValue() : null);
        MeteredUsageConfig meteredUsageConfig = this.meteredUsageConfig;
        Pair pair2 = TuplesKt.to("metered_usage", meteredUsageConfig != null ? meteredUsageConfig.getJsonValue() : null);
        Pair pair3 = TuplesKt.to("fetch_contact_remote_data", this.fetchContactRemoteData);
        ContactConfig contactConfig = this.contactConfig;
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(pair, pair2, pair3, TuplesKt.to("contact_config", contactConfig != null ? contactConfig.getJsonValue() : null), TuplesKt.to("disabled_features", this.disabledFeatures), TuplesKt.to("remote_data_refresh_interval", this.remoteDataRefreshInterval), TuplesKt.to("in_app_config", this.iaaConfig)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/remoteconfig/RemoteConfig$Companion;", "", "()V", "AIRSHIP_CONFIG_KEY", "", "CONTACT_CONFIG_KEY", "DISABLED_FEATURES_KEY", "FETCH_CONTACT_REMOTE_DATA_KEY", "IAA_CONFIG", "METERED_USAGE_CONFIG_KEY", "REMOTE_DATA_REFRESH_INTERVAL_KEY", "fromJson", "Lcom/urbanairship/remoteconfig/RemoteConfig;", "json", "Lcom/urbanairship/json/JsonMap;", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @SourceDebugExtension({"SMAP\nRemoteConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteConfig.kt\ncom/urbanairship/remoteconfig/RemoteConfig$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,283:1\n79#2,16:284\n79#2,16:300\n79#2,16:316\n79#2,16:332\n79#2,16:349\n1#3:348\n*S KotlinDebug\n*F\n+ 1 RemoteConfig.kt\ncom/urbanairship/remoteconfig/RemoteConfig$Companion\n*L\n51#1:284,16\n54#1:300,16\n57#1:316,16\n58#1:332,16\n62#1:349,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final RemoteConfig fromJson(@NotNull JsonValue json) {
            Intrinsics.checkNotNullParameter(json, "json");
            JsonMap jsonMapOptMap = json.optMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
            return fromJson(jsonMapOptMap);
        }

        @JvmStatic
        @NotNull
        public final RemoteConfig fromJson(@NotNull JsonMap json) {
            JsonValue jsonValue;
            JsonValue jsonValue2;
            String str;
            Boolean boolValueOf;
            Boolean bool;
            JsonValue jsonValue3;
            Long lValueOf;
            Long l;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue4 = json.get("airship_config");
            if (jsonValue4 == null) {
                jsonValue = null;
            } else {
                Intrinsics.checkNotNull(jsonValue4);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonValue.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString = jsonValue4.optString();
                    if (objOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                    }
                    jsonValue = (JsonValue) objOptString;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString2 = jsonValue4.optString();
                    if (objOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                    }
                    jsonValue = (JsonValue) objOptString2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonValue = (JsonValue) Boolean.valueOf(jsonValue4.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jsonValue = (JsonValue) Long.valueOf(jsonValue4.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    jsonValue = (JsonValue) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jsonValue = (JsonValue) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    jsonValue = (JsonValue) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    jsonValue = (JsonValue) Integer.valueOf(jsonValue4.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    jsonValue = (JsonValue) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    JsonSerializable jsonSerializableOptList = jsonValue4.optList();
                    if (jsonSerializableOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                    }
                    jsonValue = (JsonValue) jsonSerializableOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    JsonSerializable jsonSerializableOptMap = jsonValue4.optMap();
                    if (jsonSerializableOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                    }
                    jsonValue = (JsonValue) jsonSerializableOptMap;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + "' for field 'airship_config" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue = jsonValue4.getJsonValue();
                    if (jsonValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                    }
                }
            }
            RemoteAirshipConfig remoteAirshipConfigFromJson = jsonValue != null ? RemoteAirshipConfig.INSTANCE.fromJson(jsonValue) : null;
            JsonValue jsonValue5 = json.get("metered_usage");
            if (jsonValue5 == null) {
                jsonValue2 = null;
            } else {
                Intrinsics.checkNotNull(jsonValue5);
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonValue.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString3 = jsonValue5.optString();
                    if (objOptString3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                    }
                    jsonValue2 = (JsonValue) objOptString3;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString4 = jsonValue5.optString();
                    if (objOptString4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                    }
                    jsonValue2 = (JsonValue) objOptString4;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonValue2 = (JsonValue) Boolean.valueOf(jsonValue5.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jsonValue2 = (JsonValue) Long.valueOf(jsonValue5.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    jsonValue2 = (JsonValue) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue5.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jsonValue2 = (JsonValue) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    jsonValue2 = (JsonValue) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    jsonValue2 = (JsonValue) Integer.valueOf(jsonValue5.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    jsonValue2 = (JsonValue) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue5.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    JsonSerializable jsonSerializableOptList2 = jsonValue5.optList();
                    if (jsonSerializableOptList2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                    }
                    jsonValue2 = (JsonValue) jsonSerializableOptList2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    JsonSerializable jsonSerializableOptMap2 = jsonValue5.optMap();
                    if (jsonSerializableOptMap2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                    }
                    jsonValue2 = (JsonValue) jsonSerializableOptMap2;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + "' for field 'metered_usage" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue2 = jsonValue5.getJsonValue();
                    if (jsonValue2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                    }
                }
            }
            MeteredUsageConfig meteredUsageConfigFromJson = jsonValue2 != null ? MeteredUsageConfig.INSTANCE.fromJson(jsonValue2) : null;
            JsonValue jsonValue6 = json.get("fetch_contact_remote_data");
            if (jsonValue6 == null) {
                str = "null cannot be cast to non-null type com.urbanairship.json.JsonValue";
                bool = null;
            } else {
                Intrinsics.checkNotNull(jsonValue6);
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Boolean.class);
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString5 = jsonValue6.optString();
                    if (objOptString5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolValueOf = (Boolean) objOptString5;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString6 = jsonValue6.optString();
                    if (objOptString6 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolValueOf = (Boolean) objOptString6;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    boolValueOf = Boolean.valueOf(jsonValue6.getBoolean(false));
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        str = "null cannot be cast to non-null type com.urbanairship.json.JsonValue";
                        boolValueOf = (Boolean) Long.valueOf(jsonValue6.getLong(0L));
                    } else {
                        str = "null cannot be cast to non-null type com.urbanairship.json.JsonValue";
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            boolValueOf = (Boolean) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue6.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            boolValueOf = (Boolean) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            boolValueOf = (Boolean) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            boolValueOf = (Boolean) Integer.valueOf(jsonValue6.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            boolValueOf = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue6.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            Object objOptList = jsonValue6.optList();
                            if (objOptList == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                            boolValueOf = (Boolean) objOptList;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            Object objOptMap = jsonValue6.optMap();
                            if (objOptMap == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                            boolValueOf = (Boolean) objOptMap;
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'fetch_contact_remote_data" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Object jsonValue7 = jsonValue6.getJsonValue();
                            if (jsonValue7 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                            boolValueOf = (Boolean) jsonValue7;
                        }
                    }
                    bool = boolValueOf;
                }
                str = "null cannot be cast to non-null type com.urbanairship.json.JsonValue";
                bool = boolValueOf;
            }
            JsonValue jsonValue8 = json.get("contact_config");
            if (jsonValue8 == null) {
                jsonValue3 = null;
            } else {
                Intrinsics.checkNotNull(jsonValue8);
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(JsonValue.class);
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString7 = jsonValue8.optString();
                    if (objOptString7 == null) {
                        throw new NullPointerException(str);
                    }
                    jsonValue3 = (JsonValue) objOptString7;
                } else {
                    String str2 = str;
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        Object objOptString8 = jsonValue8.optString();
                        if (objOptString8 == null) {
                            throw new NullPointerException(str2);
                        }
                        jsonValue3 = (JsonValue) objOptString8;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        jsonValue3 = (JsonValue) Boolean.valueOf(jsonValue8.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        jsonValue3 = (JsonValue) Long.valueOf(jsonValue8.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        jsonValue3 = (JsonValue) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue8.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        jsonValue3 = (JsonValue) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        jsonValue3 = (JsonValue) Float.valueOf(jsonValue8.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        jsonValue3 = (JsonValue) Integer.valueOf(jsonValue8.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        jsonValue3 = (JsonValue) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue8.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        JsonSerializable jsonSerializableOptList3 = jsonValue8.optList();
                        if (jsonSerializableOptList3 == null) {
                            throw new NullPointerException(str2);
                        }
                        jsonValue3 = (JsonValue) jsonSerializableOptList3;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        JsonSerializable jsonSerializableOptMap3 = jsonValue8.optMap();
                        if (jsonSerializableOptMap3 == null) {
                            throw new NullPointerException(str2);
                        }
                        jsonValue3 = (JsonValue) jsonSerializableOptMap3;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + "' for field 'contact_config" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue3 = jsonValue8.getJsonValue();
                        if (jsonValue3 == null) {
                            throw new NullPointerException(str2);
                        }
                    }
                }
            }
            ContactConfig contactConfigFromJson = jsonValue3 != null ? ContactConfig.INSTANCE.fromJson(jsonValue3) : null;
            JsonValue jsonValue9 = json.get("disabled_features");
            PrivacyManager.Feature featureFromJson = jsonValue9 != null ? PrivacyManager.Feature.INSTANCE.fromJson(jsonValue9) : null;
            JsonValue jsonValue10 = json.get("remote_data_refresh_interval");
            if (jsonValue10 == null) {
                l = null;
            } else {
                Intrinsics.checkNotNull(jsonValue10);
                KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Long.class);
                if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    lValueOf = (Long) jsonValue10.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    lValueOf = (Long) Boolean.valueOf(jsonValue10.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    lValueOf = Long.valueOf(jsonValue10.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    lValueOf = (Long) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue10.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    lValueOf = (Long) Double.valueOf(jsonValue10.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    lValueOf = (Long) Float.valueOf(jsonValue10.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    lValueOf = (Long) Integer.valueOf(jsonValue10.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    lValueOf = (Long) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue10.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    lValueOf = (Long) jsonValue10.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    lValueOf = (Long) jsonValue10.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Long.class.getSimpleName() + "' for field 'remote_data_refresh_interval" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    lValueOf = (Long) jsonValue10.getJsonValue();
                }
                l = lValueOf;
            }
            JsonValue jsonValue11 = json.get("in_app_config");
            return new RemoteConfig(remoteAirshipConfigFromJson, meteredUsageConfigFromJson, bool, contactConfigFromJson, featureFromJson, l, jsonValue11 != null ? IAAConfig.INSTANCE.fromJson(jsonValue11) : null);
        }
    }
}
