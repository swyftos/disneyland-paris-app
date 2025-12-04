package com.urbanairship.featureflag;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0002 !B!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B3\b\u0002\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ'\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlag;", "Lcom/urbanairship/json/JsonSerializable;", "isEligible", "", "exists", "variables", "Lcom/urbanairship/json/JsonMap;", "(ZZLcom/urbanairship/json/JsonMap;)V", "name", "", "reportingInfo", "Lcom/urbanairship/featureflag/FeatureFlag$ReportingInfo;", "(Ljava/lang/String;ZZLcom/urbanairship/featureflag/FeatureFlag$ReportingInfo;Lcom/urbanairship/json/JsonMap;)V", "getExists", "()Z", "getName", "()Ljava/lang/String;", "getReportingInfo$urbanairship_feature_flag_release", "()Lcom/urbanairship/featureflag/FeatureFlag$ReportingInfo;", "getVariables", "()Lcom/urbanairship/json/JsonMap;", "copyWith", "copyWith$urbanairship_feature_flag_release", "(Ljava/lang/Boolean;Lcom/urbanairship/json/JsonMap;)Lcom/urbanairship/featureflag/FeatureFlag;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "ReportingInfo", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeatureFlag implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final boolean exists;
    private final boolean isEligible;
    private final String name;
    private final ReportingInfo reportingInfo;
    private final JsonMap variables;

    public /* synthetic */ FeatureFlag(String str, boolean z, boolean z2, ReportingInfo reportingInfo, JsonMap jsonMap, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, z2, reportingInfo, jsonMap);
    }

    @JvmStatic
    @NotNull
    public static final FeatureFlag fromJson(@NotNull JsonValue jsonValue) throws JsonException {
        return INSTANCE.fromJson(jsonValue);
    }

    private FeatureFlag(String str, boolean z, boolean z2, ReportingInfo reportingInfo, JsonMap jsonMap) {
        this.name = str;
        this.isEligible = z;
        this.exists = z2;
        this.reportingInfo = reportingInfo;
        this.variables = jsonMap;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    /* renamed from: isEligible, reason: from getter */
    public final boolean getIsEligible() {
        return this.isEligible;
    }

    public final boolean getExists() {
        return this.exists;
    }

    @Nullable
    /* renamed from: getReportingInfo$urbanairship_feature_flag_release, reason: from getter */
    public final ReportingInfo getReportingInfo() {
        return this.reportingInfo;
    }

    @Nullable
    public final JsonMap getVariables() {
        return this.variables;
    }

    @Deprecated(message = "Applications should not create a flag directly, instead request a flag via FeatureFlagManager.flag or FeatureFlagManager.flagAsPendingResult")
    public FeatureFlag(boolean z, boolean z2, @Nullable JsonMap jsonMap) {
        this("", z, z2, null, jsonMap);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(FeatureFlag.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.featureflag.FeatureFlag");
        FeatureFlag featureFlag = (FeatureFlag) other;
        return Intrinsics.areEqual(this.name, featureFlag.name) && this.isEligible == featureFlag.isEligible && this.exists == featureFlag.exists && Intrinsics.areEqual(this.variables, featureFlag.variables) && Intrinsics.areEqual(this.reportingInfo, featureFlag.reportingInfo);
    }

    public int hashCode() {
        int iHashCode = ((((this.name.hashCode() * 31) + Boolean.hashCode(this.isEligible)) * 31) + Boolean.hashCode(this.exists)) * 31;
        JsonMap jsonMap = this.variables;
        int iHashCode2 = (iHashCode + (jsonMap != null ? jsonMap.hashCode() : 0)) * 31;
        ReportingInfo reportingInfo = this.reportingInfo;
        return iHashCode2 + (reportingInfo != null ? reportingInfo.hashCode() : 0);
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() throws JsonException {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("name", this.name), TuplesKt.to("exists", Boolean.valueOf(this.exists)), TuplesKt.to("is_eligible", Boolean.valueOf(this.isEligible)), TuplesKt.to("variables", this.variables), TuplesKt.to("_reporting_info", this.reportingInfo)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    public static /* synthetic */ FeatureFlag copyWith$urbanairship_feature_flag_release$default(FeatureFlag featureFlag, Boolean bool, JsonMap jsonMap, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        if ((i & 2) != 0) {
            jsonMap = null;
        }
        return featureFlag.copyWith$urbanairship_feature_flag_release(bool, jsonMap);
    }

    @NotNull
    public final FeatureFlag copyWith$urbanairship_feature_flag_release(@Nullable Boolean isEligible, @Nullable JsonMap variables) {
        String str = this.name;
        boolean zBooleanValue = isEligible != null ? isEligible.booleanValue() : this.isEligible;
        boolean z = this.exists;
        ReportingInfo reportingInfo = this.reportingInfo;
        if (variables == null) {
            variables = this.variables;
        }
        return new FeatureFlag(str, zBooleanValue, z, reportingInfo, variables);
    }

    @NotNull
    public String toString() {
        return "FeatureFlag(name='" + this.name + "', isEligible=" + this.isEligible + ", exists=" + this.exists + ", reportingInfo=" + this.reportingInfo + ", variables=" + this.variables + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0014J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlag$Companion;", "", "()V", "KEY_EXISTS", "", "KEY_IS_ELIGIBLE", "KEY_NAME", "KEY_REPORTING_INFO", "KEY_VARIABLES", "createFlag", "Lcom/urbanairship/featureflag/FeatureFlag;", "name", "isEligible", "", "reportingInfo", "Lcom/urbanairship/featureflag/FeatureFlag$ReportingInfo;", "variables", "Lcom/urbanairship/json/JsonMap;", "createFlag$urbanairship_feature_flag_release", "createMissingFlag", "createMissingFlag$urbanairship_feature_flag_release", "fromJson", "json", "Lcom/urbanairship/json/JsonValue;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nFeatureFlag.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeatureFlag.kt\ncom/urbanairship/featureflag/FeatureFlag$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,200:1\n44#2,15:201\n44#2,15:216\n44#2,15:231\n79#2,16:246\n*S KotlinDebug\n*F\n+ 1 FeatureFlag.kt\ncom/urbanairship/featureflag/FeatureFlag$Companion\n*L\n148#1:201,15\n149#1:216,15\n150#1:231,15\n154#1:246,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ FeatureFlag createMissingFlag$urbanairship_feature_flag_release(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new FeatureFlag(name, false, false, null, null, null);
        }

        public static /* synthetic */ FeatureFlag createFlag$urbanairship_feature_flag_release$default(Companion companion, String str, boolean z, ReportingInfo reportingInfo, JsonMap jsonMap, int i, Object obj) {
            if ((i & 8) != 0) {
                jsonMap = null;
            }
            return companion.createFlag$urbanairship_feature_flag_release(str, z, reportingInfo, jsonMap);
        }

        public final /* synthetic */ FeatureFlag createFlag$urbanairship_feature_flag_release(String name, boolean isEligible, ReportingInfo reportingInfo, JsonMap variables) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(reportingInfo, "reportingInfo");
            return new FeatureFlag(name, isEligible, true, reportingInfo, variables, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:117:0x02b3  */
        /* JADX WARN: Removed duplicated region for block: B:226:0x0589  */
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.urbanairship.featureflag.FeatureFlag fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r30) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 1580
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.FeatureFlag.Companion.fromJson(com.urbanairship.json.JsonValue):com.urbanairship.featureflag.FeatureFlag");
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u0000 &2\u00020\u0001:\u0001&B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J=\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\b\u0010#\u001a\u00020$H\u0016J\t\u0010%\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlag$ReportingInfo;", "Lcom/urbanairship/json/JsonSerializable;", "reportingMetadata", "Lcom/urbanairship/json/JsonMap;", "supersededReportingMetadata", "", "channelId", "", "contactId", "(Lcom/urbanairship/json/JsonMap;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getContactId", "getReportingMetadata", "()Lcom/urbanairship/json/JsonMap;", "setReportingMetadata", "(Lcom/urbanairship/json/JsonMap;)V", "getSupersededReportingMetadata", "()Ljava/util/List;", "setSupersededReportingMetadata", "(Ljava/util/List;)V", "addSuperseded", "", "metadata", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ReportingInfo implements JsonSerializable {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final String channelId;
        private final String contactId;
        private JsonMap reportingMetadata;
        private List supersededReportingMetadata;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ReportingInfo copy$default(ReportingInfo reportingInfo, JsonMap jsonMap, List list, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                jsonMap = reportingInfo.reportingMetadata;
            }
            if ((i & 2) != 0) {
                list = reportingInfo.supersededReportingMetadata;
            }
            if ((i & 4) != 0) {
                str = reportingInfo.channelId;
            }
            if ((i & 8) != 0) {
                str2 = reportingInfo.contactId;
            }
            return reportingInfo.copy(jsonMap, list, str, str2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final JsonMap getReportingMetadata() {
            return this.reportingMetadata;
        }

        @Nullable
        public final List<JsonMap> component2() {
            return this.supersededReportingMetadata;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final String getContactId() {
            return this.contactId;
        }

        @NotNull
        public final ReportingInfo copy(@NotNull JsonMap reportingMetadata, @Nullable List<? extends JsonMap> supersededReportingMetadata, @Nullable String channelId, @Nullable String contactId) {
            Intrinsics.checkNotNullParameter(reportingMetadata, "reportingMetadata");
            return new ReportingInfo(reportingMetadata, supersededReportingMetadata, channelId, contactId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReportingInfo)) {
                return false;
            }
            ReportingInfo reportingInfo = (ReportingInfo) other;
            return Intrinsics.areEqual(this.reportingMetadata, reportingInfo.reportingMetadata) && Intrinsics.areEqual(this.supersededReportingMetadata, reportingInfo.supersededReportingMetadata) && Intrinsics.areEqual(this.channelId, reportingInfo.channelId) && Intrinsics.areEqual(this.contactId, reportingInfo.contactId);
        }

        public int hashCode() {
            int iHashCode = this.reportingMetadata.hashCode() * 31;
            List list = this.supersededReportingMetadata;
            int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
            String str = this.channelId;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.contactId;
            return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "ReportingInfo(reportingMetadata=" + this.reportingMetadata + ", supersededReportingMetadata=" + this.supersededReportingMetadata + ", channelId=" + this.channelId + ", contactId=" + this.contactId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public ReportingInfo(@NotNull JsonMap reportingMetadata, @Nullable List<? extends JsonMap> list, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(reportingMetadata, "reportingMetadata");
            this.reportingMetadata = reportingMetadata;
            this.supersededReportingMetadata = list;
            this.channelId = str;
            this.contactId = str2;
        }

        public /* synthetic */ ReportingInfo(JsonMap jsonMap, List list, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(jsonMap, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2);
        }

        @NotNull
        public final JsonMap getReportingMetadata() {
            return this.reportingMetadata;
        }

        public final void setReportingMetadata(@NotNull JsonMap jsonMap) {
            Intrinsics.checkNotNullParameter(jsonMap, "<set-?>");
            this.reportingMetadata = jsonMap;
        }

        @Nullable
        public final List<JsonMap> getSupersededReportingMetadata() {
            return this.supersededReportingMetadata;
        }

        public final void setSupersededReportingMetadata(@Nullable List<? extends JsonMap> list) {
            this.supersededReportingMetadata = list;
        }

        @Nullable
        public final String getChannelId() {
            return this.channelId;
        }

        @Nullable
        public final String getContactId() {
            return this.contactId;
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlag$ReportingInfo$Companion;", "", "()V", "KEY_CHANNEL_ID", "", "KEY_CONTACT_ID", "KEY_REPORTING_METADATA", "KEY_SUPERSEDED_REPORTING_METADATA", "fromJson", "Lcom/urbanairship/featureflag/FeatureFlag$ReportingInfo;", "json", "Lcom/urbanairship/json/JsonValue;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nFeatureFlag.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeatureFlag.kt\ncom/urbanairship/featureflag/FeatureFlag$ReportingInfo$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,200:1\n44#2,15:201\n79#2,16:216\n79#2,16:232\n*S KotlinDebug\n*F\n+ 1 FeatureFlag.kt\ncom/urbanairship/featureflag/FeatureFlag$ReportingInfo$Companion\n*L\n175#1:201,15\n176#1:216,16\n177#1:232,16\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final ReportingInfo fromJson(@NotNull JsonValue json) throws JsonException {
                JsonMap jsonMapOptMap;
                Class cls;
                String strOptString;
                String strOptString2;
                String str;
                Intrinsics.checkNotNullParameter(json, "json");
                JsonMap jsonMapRequireMap = json.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                JsonValue jsonValue = jsonMapRequireMap.get("reporting_metadata");
                if (jsonValue == null) {
                    throw new JsonException("Missing required field: 'reporting_metadata" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonMap.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString = jsonValue.optString();
                    if (objOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) objOptString;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString2 = jsonValue.optString();
                    if (objOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) objOptString2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    JsonSerializable jsonSerializableOptList = jsonValue.optList();
                    if (jsonSerializableOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) jsonSerializableOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    jsonMapOptMap = jsonValue.optMap();
                    if (jsonMapOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'reporting_metadata" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    JsonSerializable jsonValue2 = jsonValue.getJsonValue();
                    if (jsonValue2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) jsonValue2;
                }
                JsonMap jsonMapRequireMap2 = json.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap2, "requireMap(...)");
                JsonValue jsonValue3 = jsonMapRequireMap2.get("channel_id");
                if (jsonValue3 == null) {
                    cls = String.class;
                    strOptString = null;
                } else {
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString = jsonValue3.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        cls = String.class;
                        strOptString = (String) Long.valueOf(jsonValue3.getLong(0L));
                    } else {
                        cls = String.class;
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            strOptString = (String) Integer.valueOf(jsonValue3.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            strOptString = (String) jsonValue3.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            strOptString = (String) jsonValue3.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + cls.getSimpleName() + "' for field 'channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            strOptString = (String) jsonValue3.getJsonValue();
                        }
                    }
                    cls = String.class;
                }
                JsonMap jsonMapRequireMap3 = json.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap3, "requireMap(...)");
                JsonValue jsonValue4 = jsonMapRequireMap3.get(DeferredApiClient.KEY_CONTACT_ID);
                if (jsonValue4 == null) {
                    str = null;
                } else {
                    KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(cls);
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString2 = jsonValue4.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString2 = (String) Boolean.valueOf(jsonValue4.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString2 = (String) Long.valueOf(jsonValue4.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString2 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString2 = (String) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString2 = (String) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        strOptString2 = (String) Integer.valueOf(jsonValue4.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString2 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        strOptString2 = (String) jsonValue4.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        strOptString2 = (String) jsonValue4.optMap();
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + cls.getSimpleName() + "' for field '" + DeferredApiClient.KEY_CONTACT_ID + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        strOptString2 = (String) jsonValue4.getJsonValue();
                    }
                    str = strOptString2;
                }
                return new ReportingInfo(jsonMapOptMap, null, strOptString, str, 2, null);
            }
        }

        public final void addSuperseded(@Nullable JsonMap metadata) {
            if (metadata == null) {
                return;
            }
            List listEmptyList = this.supersededReportingMetadata;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            List mutableList = CollectionsKt.toMutableList((Collection) listEmptyList);
            mutableList.add(metadata);
            this.supersededReportingMetadata = mutableList;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() throws JsonException {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("reporting_metadata", this.reportingMetadata), TuplesKt.to("channel_id", this.channelId), TuplesKt.to(DeferredApiClient.KEY_CONTACT_ID, this.contactId), TuplesKt.to("superseded_reporting_metadata", this.supersededReportingMetadata)).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }
}
