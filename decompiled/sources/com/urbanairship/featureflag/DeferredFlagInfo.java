package com.urbanairship.featureflag;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/featureflag/DeferredFlagInfo;", "Lcom/urbanairship/json/JsonSerializable;", "isEligible", "", "variables", "Lcom/urbanairship/featureflag/FeatureFlagVariables;", "reportingMetadata", "Lcom/urbanairship/json/JsonMap;", "(ZLcom/urbanairship/featureflag/FeatureFlagVariables;Lcom/urbanairship/json/JsonMap;)V", "()Z", "getReportingMetadata", "()Lcom/urbanairship/json/JsonMap;", "getVariables", "()Lcom/urbanairship/featureflag/FeatureFlagVariables;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DeferredFlagInfo implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final boolean isEligible;
    private final JsonMap reportingMetadata;
    private final FeatureFlagVariables variables;

    public static /* synthetic */ DeferredFlagInfo copy$default(DeferredFlagInfo deferredFlagInfo, boolean z, FeatureFlagVariables featureFlagVariables, JsonMap jsonMap, int i, Object obj) {
        if ((i & 1) != 0) {
            z = deferredFlagInfo.isEligible;
        }
        if ((i & 2) != 0) {
            featureFlagVariables = deferredFlagInfo.variables;
        }
        if ((i & 4) != 0) {
            jsonMap = deferredFlagInfo.reportingMetadata;
        }
        return deferredFlagInfo.copy(z, featureFlagVariables, jsonMap);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsEligible() {
        return this.isEligible;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final FeatureFlagVariables getVariables() {
        return this.variables;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final JsonMap getReportingMetadata() {
        return this.reportingMetadata;
    }

    @NotNull
    public final DeferredFlagInfo copy(boolean isEligible, @Nullable FeatureFlagVariables variables, @NotNull JsonMap reportingMetadata) {
        Intrinsics.checkNotNullParameter(reportingMetadata, "reportingMetadata");
        return new DeferredFlagInfo(isEligible, variables, reportingMetadata);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeferredFlagInfo)) {
            return false;
        }
        DeferredFlagInfo deferredFlagInfo = (DeferredFlagInfo) other;
        return this.isEligible == deferredFlagInfo.isEligible && Intrinsics.areEqual(this.variables, deferredFlagInfo.variables) && Intrinsics.areEqual(this.reportingMetadata, deferredFlagInfo.reportingMetadata);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.isEligible) * 31;
        FeatureFlagVariables featureFlagVariables = this.variables;
        return ((iHashCode + (featureFlagVariables == null ? 0 : featureFlagVariables.hashCode())) * 31) + this.reportingMetadata.hashCode();
    }

    @NotNull
    public String toString() {
        return "DeferredFlagInfo(isEligible=" + this.isEligible + ", variables=" + this.variables + ", reportingMetadata=" + this.reportingMetadata + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public DeferredFlagInfo(boolean z, @Nullable FeatureFlagVariables featureFlagVariables, @NotNull JsonMap reportingMetadata) {
        Intrinsics.checkNotNullParameter(reportingMetadata, "reportingMetadata");
        this.isEligible = z;
        this.variables = featureFlagVariables;
        this.reportingMetadata = reportingMetadata;
    }

    public final boolean isEligible() {
        return this.isEligible;
    }

    @Nullable
    public final FeatureFlagVariables getVariables() {
        return this.variables;
    }

    @NotNull
    public final JsonMap getReportingMetadata() {
        return this.reportingMetadata;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/featureflag/DeferredFlagInfo$Companion;", "", "()V", "KEY_IS_ELIGIBLE", "", "KEY_REPORTING_METADATA", "KEY_VARIABLES", "fromJson", "Lcom/urbanairship/featureflag/DeferredFlagInfo;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nFlagDeferredResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlagDeferredResolver.kt\ncom/urbanairship/featureflag/DeferredFlagInfo$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,218:1\n44#2,15:219\n79#2,16:234\n44#2,15:251\n1#3:250\n*S KotlinDebug\n*F\n+ 1 FlagDeferredResolver.kt\ncom/urbanairship/featureflag/DeferredFlagInfo$Companion\n*L\n202#1:219,15\n203#1:234,16\n204#1:251,15\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:102:0x0296  */
        /* JADX WARN: Removed duplicated region for block: B:105:0x02a4  */
        /* JADX WARN: Removed duplicated region for block: B:165:0x0404  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.urbanairship.featureflag.DeferredFlagInfo fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r25) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 1161
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.DeferredFlagInfo.Companion.fromJson(com.urbanairship.json.JsonValue):com.urbanairship.featureflag.DeferredFlagInfo");
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() throws JsonException {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("is_eligible", Boolean.valueOf(this.isEligible)), TuplesKt.to("variables", this.variables), TuplesKt.to("reporting_metadata", this.reportingMetadata)).toJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
