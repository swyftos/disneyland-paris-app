package com.contentsquare.android.api.bridge.xpf;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.config.model.JsonConfig$FeatureFlag$$serializer;
import com.contentsquare.android.core.features.config.model.JsonConfig$MaskingRules$$serializer;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u0000 12\u00020\u0001:\u000201BW\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0001\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010B7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\rHÆ\u0003JE\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\bHÖ\u0001J!\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/HÇ\u0001R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0006\u0010\u0017R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0004\u0010\u0017R\u001e\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u001e¨\u00062"}, d2 = {"Lcom/contentsquare/android/api/bridge/xpf/BridgeConfig;", "", "seen1", "", "isCrashReporterEnabled", "", "isApiErrorsEnabled", "tagId", "", "featureFlags", "", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$FeatureFlag;", "maskingRules", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$MaskingRules;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZZLjava/lang/String;Ljava/util/List;Lcom/contentsquare/android/core/features/config/model/JsonConfig$MaskingRules;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ZZLjava/lang/String;Ljava/util/List;Lcom/contentsquare/android/core/features/config/model/JsonConfig$MaskingRules;)V", "getFeatureFlags$annotations", "()V", "getFeatureFlags", "()Ljava/util/List;", "isApiErrorsEnabled$annotations", "()Z", "isCrashReporterEnabled$annotations", "getMaskingRules$annotations", "getMaskingRules", "()Lcom/contentsquare/android/core/features/config/model/JsonConfig$MaskingRules;", "getTagId$annotations", "getTagId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class BridgeConfig {

    @NotNull
    private final List<JsonConfig.FeatureFlag> featureFlags;
    private final boolean isApiErrorsEnabled;
    private final boolean isCrashReporterEnabled;

    @Nullable
    private final JsonConfig.MaskingRules maskingRules;

    @Nullable
    private final String tagId;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, new ArrayListSerializer(JsonConfig$FeatureFlag$$serializer.INSTANCE), null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/api/bridge/xpf/BridgeConfig$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/contentsquare/android/api/bridge/xpf/BridgeConfig;", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<BridgeConfig> serializer() {
            return BridgeConfig$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ BridgeConfig(int i, @SerialName("crash_reporter_enabled") boolean z, @SerialName("api_errors_enabled") boolean z2, @SerialName("tag_id") String str, @SerialName(AirshipConfigOptions.FEATURE_FEATURE_FLAGS) List list, @SerialName("masking_rules") JsonConfig.MaskingRules maskingRules, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, BridgeConfig$$serializer.INSTANCE.getDescriptor());
        }
        this.isCrashReporterEnabled = z;
        this.isApiErrorsEnabled = z2;
        this.tagId = str;
        this.featureFlags = list;
        this.maskingRules = maskingRules;
    }

    public static /* synthetic */ BridgeConfig copy$default(BridgeConfig bridgeConfig, boolean z, boolean z2, String str, List list, JsonConfig.MaskingRules maskingRules, int i, Object obj) {
        if ((i & 1) != 0) {
            z = bridgeConfig.isCrashReporterEnabled;
        }
        if ((i & 2) != 0) {
            z2 = bridgeConfig.isApiErrorsEnabled;
        }
        boolean z3 = z2;
        if ((i & 4) != 0) {
            str = bridgeConfig.tagId;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            list = bridgeConfig.featureFlags;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            maskingRules = bridgeConfig.maskingRules;
        }
        return bridgeConfig.copy(z, z3, str2, list2, maskingRules);
    }

    @SerialName(AirshipConfigOptions.FEATURE_FEATURE_FLAGS)
    public static /* synthetic */ void getFeatureFlags$annotations() {
    }

    @SerialName("masking_rules")
    public static /* synthetic */ void getMaskingRules$annotations() {
    }

    @SerialName("tag_id")
    public static /* synthetic */ void getTagId$annotations() {
    }

    @SerialName("api_errors_enabled")
    public static /* synthetic */ void isApiErrorsEnabled$annotations() {
    }

    @SerialName("crash_reporter_enabled")
    public static /* synthetic */ void isCrashReporterEnabled$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(BridgeConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeBooleanElement(serialDesc, 0, self.isCrashReporterEnabled);
        output.encodeBooleanElement(serialDesc, 1, self.isApiErrorsEnabled);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.tagId);
        output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.featureFlags);
        output.encodeNullableSerializableElement(serialDesc, 4, JsonConfig$MaskingRules$$serializer.INSTANCE, self.maskingRules);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsCrashReporterEnabled() {
        return this.isCrashReporterEnabled;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsApiErrorsEnabled() {
        return this.isApiErrorsEnabled;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getTagId() {
        return this.tagId;
    }

    @NotNull
    public final List<JsonConfig.FeatureFlag> component4() {
        return this.featureFlags;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final JsonConfig.MaskingRules getMaskingRules() {
        return this.maskingRules;
    }

    @NotNull
    public final BridgeConfig copy(boolean isCrashReporterEnabled, boolean isApiErrorsEnabled, @Nullable String tagId, @NotNull List<JsonConfig.FeatureFlag> featureFlags, @Nullable JsonConfig.MaskingRules maskingRules) {
        Intrinsics.checkNotNullParameter(featureFlags, "featureFlags");
        return new BridgeConfig(isCrashReporterEnabled, isApiErrorsEnabled, tagId, featureFlags, maskingRules);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BridgeConfig)) {
            return false;
        }
        BridgeConfig bridgeConfig = (BridgeConfig) other;
        return this.isCrashReporterEnabled == bridgeConfig.isCrashReporterEnabled && this.isApiErrorsEnabled == bridgeConfig.isApiErrorsEnabled && Intrinsics.areEqual(this.tagId, bridgeConfig.tagId) && Intrinsics.areEqual(this.featureFlags, bridgeConfig.featureFlags) && Intrinsics.areEqual(this.maskingRules, bridgeConfig.maskingRules);
    }

    @NotNull
    public final List<JsonConfig.FeatureFlag> getFeatureFlags() {
        return this.featureFlags;
    }

    @Nullable
    public final JsonConfig.MaskingRules getMaskingRules() {
        return this.maskingRules;
    }

    @Nullable
    public final String getTagId() {
        return this.tagId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public int hashCode() {
        boolean z = this.isCrashReporterEnabled;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z2 = this.isApiErrorsEnabled;
        int i2 = (i + (z2 ? 1 : z2 ? 1 : 0)) * 31;
        String str = this.tagId;
        int iHashCode = (this.featureFlags.hashCode() + ((i2 + (str == null ? 0 : str.hashCode())) * 31)) * 31;
        JsonConfig.MaskingRules maskingRules = this.maskingRules;
        return iHashCode + (maskingRules != null ? maskingRules.hashCode() : 0);
    }

    public final boolean isApiErrorsEnabled() {
        return this.isApiErrorsEnabled;
    }

    public final boolean isCrashReporterEnabled() {
        return this.isCrashReporterEnabled;
    }

    @NotNull
    public String toString() {
        return "BridgeConfig(isCrashReporterEnabled=" + this.isCrashReporterEnabled + ", isApiErrorsEnabled=" + this.isApiErrorsEnabled + ", tagId=" + this.tagId + ", featureFlags=" + this.featureFlags + ", maskingRules=" + this.maskingRules + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public BridgeConfig(boolean z, boolean z2, @Nullable String str, @NotNull List<JsonConfig.FeatureFlag> featureFlags, @Nullable JsonConfig.MaskingRules maskingRules) {
        Intrinsics.checkNotNullParameter(featureFlags, "featureFlags");
        this.isCrashReporterEnabled = z;
        this.isApiErrorsEnabled = z2;
        this.tagId = str;
        this.featureFlags = featureFlags;
        this.maskingRules = maskingRules;
    }
}
