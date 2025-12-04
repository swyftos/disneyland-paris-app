package com.urbanairship.automation.remotedata;

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
import com.urbanairship.remotedata.RemoteDataInfo;
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

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/automation/remotedata/AutomationSourceInfo;", "Lcom/urbanairship/json/JsonSerializable;", "remoteDataInfo", "Lcom/urbanairship/remotedata/RemoteDataInfo;", "payloadTimestamp", "", "airshipSDKVersion", "", "(Lcom/urbanairship/remotedata/RemoteDataInfo;JLjava/lang/String;)V", "getAirshipSDKVersion", "()Ljava/lang/String;", "getPayloadTimestamp", "()J", "getRemoteDataInfo", "()Lcom/urbanairship/remotedata/RemoteDataInfo;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AutomationSourceInfo implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final String airshipSDKVersion;
    private final long payloadTimestamp;
    private final RemoteDataInfo remoteDataInfo;

    public static /* synthetic */ AutomationSourceInfo copy$default(AutomationSourceInfo automationSourceInfo, RemoteDataInfo remoteDataInfo, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            remoteDataInfo = automationSourceInfo.remoteDataInfo;
        }
        if ((i & 2) != 0) {
            j = automationSourceInfo.payloadTimestamp;
        }
        if ((i & 4) != 0) {
            str = automationSourceInfo.airshipSDKVersion;
        }
        return automationSourceInfo.copy(remoteDataInfo, j, str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final RemoteDataInfo getRemoteDataInfo() {
        return this.remoteDataInfo;
    }

    /* renamed from: component2, reason: from getter */
    public final long getPayloadTimestamp() {
        return this.payloadTimestamp;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getAirshipSDKVersion() {
        return this.airshipSDKVersion;
    }

    @NotNull
    public final AutomationSourceInfo copy(@Nullable RemoteDataInfo remoteDataInfo, long payloadTimestamp, @Nullable String airshipSDKVersion) {
        return new AutomationSourceInfo(remoteDataInfo, payloadTimestamp, airshipSDKVersion);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutomationSourceInfo)) {
            return false;
        }
        AutomationSourceInfo automationSourceInfo = (AutomationSourceInfo) other;
        return Intrinsics.areEqual(this.remoteDataInfo, automationSourceInfo.remoteDataInfo) && this.payloadTimestamp == automationSourceInfo.payloadTimestamp && Intrinsics.areEqual(this.airshipSDKVersion, automationSourceInfo.airshipSDKVersion);
    }

    public int hashCode() {
        RemoteDataInfo remoteDataInfo = this.remoteDataInfo;
        int iHashCode = (((remoteDataInfo == null ? 0 : remoteDataInfo.hashCode()) * 31) + Long.hashCode(this.payloadTimestamp)) * 31;
        String str = this.airshipSDKVersion;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AutomationSourceInfo(remoteDataInfo=" + this.remoteDataInfo + ", payloadTimestamp=" + this.payloadTimestamp + ", airshipSDKVersion=" + this.airshipSDKVersion + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public AutomationSourceInfo(@Nullable RemoteDataInfo remoteDataInfo, long j, @Nullable String str) {
        this.remoteDataInfo = remoteDataInfo;
        this.payloadTimestamp = j;
        this.airshipSDKVersion = str;
    }

    @Nullable
    public final RemoteDataInfo getRemoteDataInfo() {
        return this.remoteDataInfo;
    }

    public final long getPayloadTimestamp() {
        return this.payloadTimestamp;
    }

    @Nullable
    public final String getAirshipSDKVersion() {
        return this.airshipSDKVersion;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/automation/remotedata/AutomationSourceInfo$Companion;", "", "()V", "AIRSHIP_SDK_VERSION", "", "PAYLOAD_TIMESTAMP", "REMOTE_DATA_INFO", "fromJson", "Lcom/urbanairship/automation/remotedata/AutomationSourceInfo;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAutomationSourceInfoStore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationSourceInfoStore.kt\ncom/urbanairship/automation/remotedata/AutomationSourceInfo$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,128:1\n1#2:129\n44#3,15:130\n*S KotlinDebug\n*F\n+ 1 AutomationSourceInfoStore.kt\ncom/urbanairship/automation/remotedata/AutomationSourceInfo$Companion\n*L\n29#1:130,15\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final AutomationSourceInfo fromJson(@NotNull JsonValue value) throws JsonException {
            Long lValueOf;
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                JsonMap jsonMapRequireMap = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                JsonValue jsonValue = jsonMapRequireMap.get("remoteDataInfo");
                RemoteDataInfo remoteDataInfo = jsonValue != null ? new RemoteDataInfo(jsonValue) : null;
                JsonValue jsonValue2 = jsonMapRequireMap.get("payloadTimestamp");
                if (jsonValue2 == null) {
                    throw new JsonException("Missing required field: 'payloadTimestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString = jsonValue2.optString();
                    if (objOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) objOptString;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString2 = jsonValue2.optString();
                    if (objOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) objOptString2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    lValueOf = (Long) Boolean.valueOf(jsonValue2.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    lValueOf = Long.valueOf(jsonValue2.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    lValueOf = (Long) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue2.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    lValueOf = (Long) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    lValueOf = (Long) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    lValueOf = (Long) Integer.valueOf(jsonValue2.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    lValueOf = (Long) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList = jsonValue2.optList();
                    if (objOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) objOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap = jsonValue2.optMap();
                    if (objOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) objOptMap;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Long.class.getSimpleName() + "' for field 'payloadTimestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue3 = jsonValue2.getJsonValue();
                    if (jsonValue3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) jsonValue3;
                }
                long jLongValue = lValueOf.longValue();
                JsonValue jsonValue4 = jsonMapRequireMap.get("airshipSDKVersion");
                return new AutomationSourceInfo(remoteDataInfo, jLongValue, jsonValue4 != null ? jsonValue4.requireString() : null);
            } catch (JsonException unused) {
                return null;
            }
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("remoteDataInfo", this.remoteDataInfo), TuplesKt.to("payloadTimestamp", Long.valueOf(this.payloadTimestamp)), TuplesKt.to("airshipSDKVersion", this.airshipSDKVersion)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
