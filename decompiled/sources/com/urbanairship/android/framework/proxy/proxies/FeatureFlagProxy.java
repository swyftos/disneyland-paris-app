package com.urbanairship.android.framework.proxy.proxies;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.featureflag.FeatureFlag;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u0006HÀ\u0003¢\u0006\u0002\b\u000bJ\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/FeatureFlagProxy;", "Lcom/urbanairship/json/JsonSerializable;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "(Lcom/urbanairship/json/JsonValue;)V", "original", "Lcom/urbanairship/featureflag/FeatureFlag;", "(Lcom/urbanairship/featureflag/FeatureFlag;)V", "getOriginal$airship_framework_proxy_release", "()Lcom/urbanairship/featureflag/FeatureFlag;", "component1", "component1$airship_framework_proxy_release", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "toString", "", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFeatureFlagManagerProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeatureFlagManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/FeatureFlagProxy\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,58:1\n44#2,15:59\n*S KotlinDebug\n*F\n+ 1 FeatureFlagManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/FeatureFlagProxy\n*L\n48#1:59,15\n*E\n"})
/* loaded from: classes2.dex */
public final /* data */ class FeatureFlagProxy implements JsonSerializable {
    private final FeatureFlag original;

    public static /* synthetic */ FeatureFlagProxy copy$default(FeatureFlagProxy featureFlagProxy, FeatureFlag featureFlag, int i, Object obj) {
        if ((i & 1) != 0) {
            featureFlag = featureFlagProxy.original;
        }
        return featureFlagProxy.copy(featureFlag);
    }

    @NotNull
    /* renamed from: component1$airship_framework_proxy_release, reason: from getter */
    public final FeatureFlag getOriginal() {
        return this.original;
    }

    @NotNull
    public final FeatureFlagProxy copy(@NotNull FeatureFlag original) {
        Intrinsics.checkNotNullParameter(original, "original");
        return new FeatureFlagProxy(original);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FeatureFlagProxy) && Intrinsics.areEqual(this.original, ((FeatureFlagProxy) other).original);
    }

    public int hashCode() {
        return this.original.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeatureFlagProxy(original=" + this.original + ")";
    }

    public FeatureFlagProxy(@NotNull FeatureFlag original) {
        Intrinsics.checkNotNullParameter(original, "original");
        this.original = original;
    }

    @NotNull
    public final FeatureFlag getOriginal$airship_framework_proxy_release() {
        return this.original;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FeatureFlagProxy(@NotNull JsonValue jsonValue) throws JsonException {
        JsonValue jsonValue2;
        Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
        FeatureFlag.Companion companion = FeatureFlag.INSTANCE;
        JsonMap jsonMapRequireMap = jsonValue.requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
        JsonValue jsonValue3 = jsonMapRequireMap.get("_internal");
        if (jsonValue3 == null) {
            throw new JsonException("Missing required field: '_internal" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonValue.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            Object objOptString = jsonValue3.optString();
            if (objOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
            }
            jsonValue2 = (JsonValue) objOptString;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            Object objOptString2 = jsonValue3.optString();
            if (objOptString2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
            }
            jsonValue2 = (JsonValue) objOptString2;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            jsonValue2 = (JsonValue) Boolean.valueOf(jsonValue3.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            jsonValue2 = (JsonValue) Long.valueOf(jsonValue3.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            jsonValue2 = (JsonValue) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            jsonValue2 = (JsonValue) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            jsonValue2 = (JsonValue) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            jsonValue2 = (JsonValue) Integer.valueOf(jsonValue3.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            jsonValue2 = (JsonValue) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            JsonSerializable jsonSerializableOptList = jsonValue3.optList();
            if (jsonSerializableOptList == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
            }
            jsonValue2 = (JsonValue) jsonSerializableOptList;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            JsonSerializable jsonSerializableOptMap = jsonValue3.optMap();
            if (jsonSerializableOptMap == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
            }
            jsonValue2 = (JsonValue) jsonSerializableOptMap;
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + "' for field '_internal" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            jsonValue2 = jsonValue3.getJsonValue();
            if (jsonValue2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
            }
        }
        this(companion.fromJson(jsonValue2));
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("isEligible", Boolean.valueOf(this.original.getIsEligible())), TuplesKt.to("exists", Boolean.valueOf(this.original.getExists())), TuplesKt.to("variables", this.original.getVariables()), TuplesKt.to("_internal", this.original)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
