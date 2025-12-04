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

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BC\b\u0007\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006!"}, d2 = {"Lcom/urbanairship/remoteconfig/RemoteAirshipConfig;", "Lcom/urbanairship/json/JsonSerializable;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "(Lcom/urbanairship/json/JsonValue;)V", "remoteDataUrl", "", "deviceApiUrl", "walletUrl", "analyticsUrl", "meteredUsageUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAnalyticsUrl", "()Ljava/lang/String;", "getDeviceApiUrl", "getMeteredUsageUrl", "getRemoteDataUrl", "getWalletUrl", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "toString", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nRemoteConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteConfig.kt\ncom/urbanairship/remoteconfig/RemoteAirshipConfig\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,283:1\n79#2,16:284\n79#2,16:300\n79#2,16:316\n79#2,16:332\n79#2,16:348\n*S KotlinDebug\n*F\n+ 1 RemoteConfig.kt\ncom/urbanairship/remoteconfig/RemoteAirshipConfig\n*L\n95#1:284,16\n96#1:300,16\n97#1:316,16\n98#1:332,16\n99#1:348,16\n*E\n"})
/* loaded from: classes5.dex */
public final /* data */ class RemoteAirshipConfig implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final String analyticsUrl;
    private final String deviceApiUrl;
    private final String meteredUsageUrl;
    private final String remoteDataUrl;
    private final String walletUrl;

    @JvmOverloads
    public RemoteAirshipConfig() {
        this(null, null, null, null, null, 31, null);
    }

    @JvmOverloads
    public RemoteAirshipConfig(@Nullable String str) {
        this(str, null, null, null, null, 30, null);
    }

    @JvmOverloads
    public RemoteAirshipConfig(@Nullable String str, @Nullable String str2) {
        this(str, str2, null, null, null, 28, null);
    }

    @JvmOverloads
    public RemoteAirshipConfig(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this(str, str2, str3, null, null, 24, null);
    }

    @JvmOverloads
    public RemoteAirshipConfig(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this(str, str2, str3, str4, null, 16, null);
    }

    public static /* synthetic */ RemoteAirshipConfig copy$default(RemoteAirshipConfig remoteAirshipConfig, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = remoteAirshipConfig.remoteDataUrl;
        }
        if ((i & 2) != 0) {
            str2 = remoteAirshipConfig.deviceApiUrl;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = remoteAirshipConfig.walletUrl;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = remoteAirshipConfig.analyticsUrl;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = remoteAirshipConfig.meteredUsageUrl;
        }
        return remoteAirshipConfig.copy(str, str6, str7, str8, str5);
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final RemoteAirshipConfig fromJson(@NotNull JsonValue jsonValue) {
        return INSTANCE.fromJson(jsonValue);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getRemoteDataUrl() {
        return this.remoteDataUrl;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getDeviceApiUrl() {
        return this.deviceApiUrl;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getWalletUrl() {
        return this.walletUrl;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getAnalyticsUrl() {
        return this.analyticsUrl;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getMeteredUsageUrl() {
        return this.meteredUsageUrl;
    }

    @NotNull
    public final RemoteAirshipConfig copy(@Nullable String remoteDataUrl, @Nullable String deviceApiUrl, @Nullable String walletUrl, @Nullable String analyticsUrl, @Nullable String meteredUsageUrl) {
        return new RemoteAirshipConfig(remoteDataUrl, deviceApiUrl, walletUrl, analyticsUrl, meteredUsageUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteAirshipConfig)) {
            return false;
        }
        RemoteAirshipConfig remoteAirshipConfig = (RemoteAirshipConfig) other;
        return Intrinsics.areEqual(this.remoteDataUrl, remoteAirshipConfig.remoteDataUrl) && Intrinsics.areEqual(this.deviceApiUrl, remoteAirshipConfig.deviceApiUrl) && Intrinsics.areEqual(this.walletUrl, remoteAirshipConfig.walletUrl) && Intrinsics.areEqual(this.analyticsUrl, remoteAirshipConfig.analyticsUrl) && Intrinsics.areEqual(this.meteredUsageUrl, remoteAirshipConfig.meteredUsageUrl);
    }

    public int hashCode() {
        String str = this.remoteDataUrl;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deviceApiUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.walletUrl;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.analyticsUrl;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.meteredUsageUrl;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "RemoteAirshipConfig(remoteDataUrl=" + this.remoteDataUrl + ", deviceApiUrl=" + this.deviceApiUrl + ", walletUrl=" + this.walletUrl + ", analyticsUrl=" + this.analyticsUrl + ", meteredUsageUrl=" + this.meteredUsageUrl + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @JvmOverloads
    public RemoteAirshipConfig(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.remoteDataUrl = str;
        this.deviceApiUrl = str2;
        this.walletUrl = str3;
        this.analyticsUrl = str4;
        this.meteredUsageUrl = str5;
    }

    public /* synthetic */ RemoteAirshipConfig(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    @Nullable
    public final String getRemoteDataUrl() {
        return this.remoteDataUrl;
    }

    @Nullable
    public final String getDeviceApiUrl() {
        return this.deviceApiUrl;
    }

    @Nullable
    public final String getWalletUrl() {
        return this.walletUrl;
    }

    @Nullable
    public final String getAnalyticsUrl() {
        return this.analyticsUrl;
    }

    @Nullable
    public final String getMeteredUsageUrl() {
        return this.meteredUsageUrl;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("remote_data_url", this.remoteDataUrl), TuplesKt.to("device_api_url", this.deviceApiUrl), TuplesKt.to("analytics_url", this.analyticsUrl), TuplesKt.to("wallet_url", this.walletUrl), TuplesKt.to("metered_usage_url", this.meteredUsageUrl)).toJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public RemoteAirshipConfig(@NotNull JsonValue jsonValue) throws JsonException {
        String strOptString;
        String str;
        String strOptString2;
        String str2;
        String strOptString3;
        String str3;
        String strOptString4;
        String str4;
        String strOptString5;
        Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
        JsonMap jsonMapOptMap = jsonValue.optMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
        JsonValue jsonValue2 = jsonMapOptMap.get("remote_data_url");
        String str5 = null;
        if (jsonValue2 == null) {
            str = null;
        } else {
            Intrinsics.checkNotNull(jsonValue2);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString = jsonValue2.optString();
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString = (String) Boolean.valueOf(jsonValue2.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString = (String) Long.valueOf(jsonValue2.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
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
                strOptString = (String) jsonValue2.optList();
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                strOptString = (String) jsonValue2.optMap();
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'remote_data_url" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                strOptString = (String) jsonValue2.toJsonValue();
            }
            str = strOptString;
        }
        JsonMap jsonMapOptMap2 = jsonValue.optMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapOptMap2, "optMap(...)");
        JsonValue jsonValue3 = jsonMapOptMap2.get("device_api_url");
        if (jsonValue3 == null) {
            str2 = null;
        } else {
            Intrinsics.checkNotNull(jsonValue3);
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString2 = jsonValue3.optString();
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString2 = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString2 = (String) Long.valueOf(jsonValue3.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString2 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString2 = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString2 = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                strOptString2 = (String) Integer.valueOf(jsonValue3.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString2 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                strOptString2 = (String) jsonValue3.optList();
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                strOptString2 = (String) jsonValue3.optMap();
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'device_api_url" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                strOptString2 = (String) jsonValue3.toJsonValue();
            }
            str2 = strOptString2;
        }
        JsonMap jsonMapOptMap3 = jsonValue.optMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapOptMap3, "optMap(...)");
        JsonValue jsonValue4 = jsonMapOptMap3.get("wallet_url");
        if (jsonValue4 == null) {
            str3 = null;
        } else {
            Intrinsics.checkNotNull(jsonValue4);
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString3 = jsonValue4.optString();
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString3 = (String) Boolean.valueOf(jsonValue4.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString3 = (String) Long.valueOf(jsonValue4.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString3 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString3 = (String) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString3 = (String) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                strOptString3 = (String) Integer.valueOf(jsonValue4.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString3 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                strOptString3 = (String) jsonValue4.optList();
            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                strOptString3 = (String) jsonValue4.optMap();
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'wallet_url" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                strOptString3 = (String) jsonValue4.toJsonValue();
            }
            str3 = strOptString3;
        }
        JsonMap jsonMapOptMap4 = jsonValue.optMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapOptMap4, "optMap(...)");
        JsonValue jsonValue5 = jsonMapOptMap4.get("analytics_url");
        if (jsonValue5 == null) {
            str4 = null;
        } else {
            Intrinsics.checkNotNull(jsonValue5);
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString4 = jsonValue5.optString();
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString4 = (String) Boolean.valueOf(jsonValue5.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString4 = (String) Long.valueOf(jsonValue5.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString4 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue5.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString4 = (String) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString4 = (String) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                strOptString4 = (String) Integer.valueOf(jsonValue5.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString4 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue5.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                strOptString4 = (String) jsonValue5.optList();
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                strOptString4 = (String) jsonValue5.optMap();
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'analytics_url" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                strOptString4 = (String) jsonValue5.toJsonValue();
            }
            str4 = strOptString4;
        }
        JsonMap jsonMapOptMap5 = jsonValue.optMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapOptMap5, "optMap(...)");
        JsonValue jsonValue6 = jsonMapOptMap5.get("metered_usage_url");
        if (jsonValue6 != null) {
            Intrinsics.checkNotNull(jsonValue6);
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString5 = jsonValue6.optString();
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString5 = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString5 = (String) Long.valueOf(jsonValue6.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString5 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue6.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString5 = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString5 = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                strOptString5 = (String) Integer.valueOf(jsonValue6.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString5 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue6.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                strOptString5 = (String) jsonValue6.optList();
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                strOptString5 = (String) jsonValue6.optMap();
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'metered_usage_url" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                strOptString5 = (String) jsonValue6.toJsonValue();
            }
            str5 = strOptString5;
        }
        this(str, str2, str3, str4, str5);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/urbanairship/remoteconfig/RemoteAirshipConfig$Companion;", "", "()V", "ANALYTICS_URL_KEY", "", "DEVICE_API_URL_KEY", "METERED_USAGE_URL_KEY", "REMOTE_DATA_URL_KEY", "WALLET_URL_KEY", "fromJson", "Lcom/urbanairship/remoteconfig/RemoteAirshipConfig;", "json", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public final RemoteAirshipConfig fromJson(@NotNull JsonValue json) {
            Intrinsics.checkNotNullParameter(json, "json");
            return new RemoteAirshipConfig(json);
        }
    }
}
