package com.urbanairship.automation.engine;

import androidx.annotation.RestrictTo;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.experiment.ExperimentResult;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.UUID;
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

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0087\b\u0018\u0000 82\u00020\u0001:\u00018Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000e\u0010\u001f\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\"J\u0010\u0010#\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0002\b$J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b&J\u0010\u0010'\u001a\u0004\u0018\u00010\tHÀ\u0003¢\u0006\u0002\b(J\u0010\u0010)\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0002\b*J\u000e\u0010+\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b,J\u000e\u0010-\u001a\u00020\rHÀ\u0003¢\u0006\u0002\b.J\u000e\u0010/\u001a\u00020\u000fHÀ\u0003¢\u0006\u0002\b0Jm\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u00102\u001a\u00020\r2\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u00020\u000fHÖ\u0001J\b\u00106\u001a\u00020\u0006H\u0016J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0014\u0010\u000b\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016¨\u00069"}, d2 = {"Lcom/urbanairship/automation/engine/PreparedScheduleInfo;", "Lcom/urbanairship/json/JsonSerializable;", "scheduleId", "", "productId", "campaigns", "Lcom/urbanairship/json/JsonValue;", "contactId", "experimentResult", "Lcom/urbanairship/experiment/ExperimentResult;", "reportingContext", "triggerSessionId", "additionalAudienceCheckResult", "", Constants.FirelogAnalytics.PARAM_PRIORITY, "", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Ljava/lang/String;Lcom/urbanairship/experiment/ExperimentResult;Lcom/urbanairship/json/JsonValue;Ljava/lang/String;ZI)V", "getAdditionalAudienceCheckResult$urbanairship_automation_release", "()Z", "getCampaigns$urbanairship_automation_release", "()Lcom/urbanairship/json/JsonValue;", "getContactId$urbanairship_automation_release", "()Ljava/lang/String;", "getExperimentResult$urbanairship_automation_release", "()Lcom/urbanairship/experiment/ExperimentResult;", "getPriority$urbanairship_automation_release", "()I", "getProductId$urbanairship_automation_release", "getReportingContext$urbanairship_automation_release", "getScheduleId$urbanairship_automation_release", "getTriggerSessionId$urbanairship_automation_release", "component1", "component1$urbanairship_automation_release", "component2", "component2$urbanairship_automation_release", "component3", "component3$urbanairship_automation_release", "component4", "component4$urbanairship_automation_release", "component5", "component5$urbanairship_automation_release", "component6", "component6$urbanairship_automation_release", "component7", "component7$urbanairship_automation_release", "component8", "component8$urbanairship_automation_release", "component9", "component9$urbanairship_automation_release", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "toJsonValue", "toString", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class PreparedScheduleInfo implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final boolean additionalAudienceCheckResult;
    private final JsonValue campaigns;
    private final String contactId;
    private final ExperimentResult experimentResult;
    private final int priority;
    private final String productId;
    private final JsonValue reportingContext;
    private final String scheduleId;
    private final String triggerSessionId;

    @NotNull
    /* renamed from: component1$urbanairship_automation_release, reason: from getter */
    public final String getScheduleId() {
        return this.scheduleId;
    }

    @Nullable
    /* renamed from: component2$urbanairship_automation_release, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    @Nullable
    /* renamed from: component3$urbanairship_automation_release, reason: from getter */
    public final JsonValue getCampaigns() {
        return this.campaigns;
    }

    @Nullable
    /* renamed from: component4$urbanairship_automation_release, reason: from getter */
    public final String getContactId() {
        return this.contactId;
    }

    @Nullable
    /* renamed from: component5$urbanairship_automation_release, reason: from getter */
    public final ExperimentResult getExperimentResult() {
        return this.experimentResult;
    }

    @Nullable
    /* renamed from: component6$urbanairship_automation_release, reason: from getter */
    public final JsonValue getReportingContext() {
        return this.reportingContext;
    }

    @NotNull
    /* renamed from: component7$urbanairship_automation_release, reason: from getter */
    public final String getTriggerSessionId() {
        return this.triggerSessionId;
    }

    /* renamed from: component8$urbanairship_automation_release, reason: from getter */
    public final boolean getAdditionalAudienceCheckResult() {
        return this.additionalAudienceCheckResult;
    }

    /* renamed from: component9$urbanairship_automation_release, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    @NotNull
    public final PreparedScheduleInfo copy(@NotNull String scheduleId, @Nullable String productId, @Nullable JsonValue campaigns, @Nullable String contactId, @Nullable ExperimentResult experimentResult, @Nullable JsonValue reportingContext, @NotNull String triggerSessionId, boolean additionalAudienceCheckResult, int priority) {
        Intrinsics.checkNotNullParameter(scheduleId, "scheduleId");
        Intrinsics.checkNotNullParameter(triggerSessionId, "triggerSessionId");
        return new PreparedScheduleInfo(scheduleId, productId, campaigns, contactId, experimentResult, reportingContext, triggerSessionId, additionalAudienceCheckResult, priority);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreparedScheduleInfo)) {
            return false;
        }
        PreparedScheduleInfo preparedScheduleInfo = (PreparedScheduleInfo) other;
        return Intrinsics.areEqual(this.scheduleId, preparedScheduleInfo.scheduleId) && Intrinsics.areEqual(this.productId, preparedScheduleInfo.productId) && Intrinsics.areEqual(this.campaigns, preparedScheduleInfo.campaigns) && Intrinsics.areEqual(this.contactId, preparedScheduleInfo.contactId) && Intrinsics.areEqual(this.experimentResult, preparedScheduleInfo.experimentResult) && Intrinsics.areEqual(this.reportingContext, preparedScheduleInfo.reportingContext) && Intrinsics.areEqual(this.triggerSessionId, preparedScheduleInfo.triggerSessionId) && this.additionalAudienceCheckResult == preparedScheduleInfo.additionalAudienceCheckResult && this.priority == preparedScheduleInfo.priority;
    }

    public int hashCode() {
        int iHashCode = this.scheduleId.hashCode() * 31;
        String str = this.productId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        JsonValue jsonValue = this.campaigns;
        int iHashCode3 = (iHashCode2 + (jsonValue == null ? 0 : jsonValue.hashCode())) * 31;
        String str2 = this.contactId;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        ExperimentResult experimentResult = this.experimentResult;
        int iHashCode5 = (iHashCode4 + (experimentResult == null ? 0 : experimentResult.hashCode())) * 31;
        JsonValue jsonValue2 = this.reportingContext;
        return ((((((iHashCode5 + (jsonValue2 != null ? jsonValue2.hashCode() : 0)) * 31) + this.triggerSessionId.hashCode()) * 31) + Boolean.hashCode(this.additionalAudienceCheckResult)) * 31) + Integer.hashCode(this.priority);
    }

    @NotNull
    public String toString() {
        return "PreparedScheduleInfo(scheduleId=" + this.scheduleId + ", productId=" + this.productId + ", campaigns=" + this.campaigns + ", contactId=" + this.contactId + ", experimentResult=" + this.experimentResult + ", reportingContext=" + this.reportingContext + ", triggerSessionId=" + this.triggerSessionId + ", additionalAudienceCheckResult=" + this.additionalAudienceCheckResult + ", priority=" + this.priority + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public PreparedScheduleInfo(@NotNull String scheduleId, @Nullable String str, @Nullable JsonValue jsonValue, @Nullable String str2, @Nullable ExperimentResult experimentResult, @Nullable JsonValue jsonValue2, @NotNull String triggerSessionId, boolean z, int i) {
        Intrinsics.checkNotNullParameter(scheduleId, "scheduleId");
        Intrinsics.checkNotNullParameter(triggerSessionId, "triggerSessionId");
        this.scheduleId = scheduleId;
        this.productId = str;
        this.campaigns = jsonValue;
        this.contactId = str2;
        this.experimentResult = experimentResult;
        this.reportingContext = jsonValue2;
        this.triggerSessionId = triggerSessionId;
        this.additionalAudienceCheckResult = z;
        this.priority = i;
    }

    public /* synthetic */ PreparedScheduleInfo(String str, String str2, JsonValue jsonValue, String str3, ExperimentResult experimentResult, JsonValue jsonValue2, String str4, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : jsonValue, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : experimentResult, (i2 & 32) != 0 ? null : jsonValue2, str4, (i2 & 128) != 0 ? true : z, (i2 & 256) != 0 ? 0 : i);
    }

    @NotNull
    public final String getScheduleId$urbanairship_automation_release() {
        return this.scheduleId;
    }

    @Nullable
    public final String getProductId$urbanairship_automation_release() {
        return this.productId;
    }

    @Nullable
    public final JsonValue getCampaigns$urbanairship_automation_release() {
        return this.campaigns;
    }

    @Nullable
    public final String getContactId$urbanairship_automation_release() {
        return this.contactId;
    }

    @Nullable
    public final ExperimentResult getExperimentResult$urbanairship_automation_release() {
        return this.experimentResult;
    }

    @Nullable
    public final JsonValue getReportingContext$urbanairship_automation_release() {
        return this.reportingContext;
    }

    @NotNull
    public final String getTriggerSessionId$urbanairship_automation_release() {
        return this.triggerSessionId;
    }

    public final boolean getAdditionalAudienceCheckResult$urbanairship_automation_release() {
        return this.additionalAudienceCheckResult;
    }

    public final int getPriority$urbanairship_automation_release() {
        return this.priority;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/automation/engine/PreparedScheduleInfo$Companion;", "", "()V", "ADDITIONAL_AUDIENCE_CHECK_RESULT", "", "CAMPAIGNS", "CONTACT_ID", "EXPERIMENT_RESULT", "PRIORITY", "PRODUCT_ID", "REPORTING_CONTEXT", "SCHEDULE_ID", "TRIGGER_SESSION_ID", "fromJson", "Lcom/urbanairship/automation/engine/PreparedScheduleInfo;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPreparedSchedule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreparedSchedule.kt\ncom/urbanairship/automation/engine/PreparedScheduleInfo$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,87:1\n44#2,15:88\n79#2,16:103\n79#2,16:119\n79#2,16:136\n79#2,16:152\n79#2,16:168\n1#3:135\n*S KotlinDebug\n*F\n+ 1 PreparedSchedule.kt\ncom/urbanairship/automation/engine/PreparedScheduleInfo$Companion\n*L\n61#1:88,15\n62#1:103,16\n64#1:119,16\n68#1:136,16\n69#1:152,16\n70#1:168,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final PreparedScheduleInfo fromJson(@NotNull JsonValue value) throws JsonException {
            String strOptString;
            String strOptString2;
            String str;
            String strOptString3;
            String str2;
            ExperimentResult experimentResultFromJson;
            String strOptString4;
            Boolean boolValueOf;
            Integer numValueOf;
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonValue jsonValue = jsonMapRequireMap.get("schedule_id");
            if (jsonValue == null) {
                throw new JsonException("Missing required field: 'schedule_id" + CoreConstants.SINGLE_QUOTE_CHAR);
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
                strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
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
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'schedule_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue2 = jsonValue.toJsonValue();
                if (jsonValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue2;
            }
            String str3 = strOptString;
            JsonValue jsonValue3 = jsonMapRequireMap.get("product_id");
            Integer num = null;
            if (jsonValue3 == null) {
                str = null;
            } else {
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
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'product_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    strOptString2 = (String) jsonValue3.toJsonValue();
                }
                str = strOptString2;
            }
            JsonValue jsonValue4 = jsonMapRequireMap.get("campaigns");
            JsonValue jsonValue5 = jsonMapRequireMap.get(DeferredApiClient.KEY_CONTACT_ID);
            if (jsonValue5 == null) {
                str2 = null;
            } else {
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString3 = jsonValue5.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString3 = (String) Boolean.valueOf(jsonValue5.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString3 = (String) Long.valueOf(jsonValue5.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString3 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue5.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString3 = (String) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString3 = (String) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    strOptString3 = (String) Integer.valueOf(jsonValue5.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString3 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue5.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    strOptString3 = (String) jsonValue5.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    strOptString3 = (String) jsonValue5.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field '" + DeferredApiClient.KEY_CONTACT_ID + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    strOptString3 = (String) jsonValue5.toJsonValue();
                }
                str2 = strOptString3;
            }
            JsonValue jsonValue6 = jsonMapRequireMap.get("experiment_result");
            if (jsonValue6 != null) {
                ExperimentResult.Companion companion = ExperimentResult.INSTANCE;
                JsonMap jsonMapRequireMap2 = jsonValue6.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap2, "requireMap(...)");
                experimentResultFromJson = companion.fromJson(jsonMapRequireMap2);
            } else {
                experimentResultFromJson = null;
            }
            JsonValue jsonValue7 = jsonMapRequireMap.get("reporting_context");
            JsonValue jsonValue8 = jsonMapRequireMap.get("trigger_session_id");
            if (jsonValue8 == null) {
                strOptString4 = null;
            } else {
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString4 = jsonValue8.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString4 = (String) Boolean.valueOf(jsonValue8.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString4 = (String) Long.valueOf(jsonValue8.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString4 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue8.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString4 = (String) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString4 = (String) Float.valueOf(jsonValue8.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    strOptString4 = (String) Integer.valueOf(jsonValue8.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString4 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue8.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    strOptString4 = (String) jsonValue8.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    strOptString4 = (String) jsonValue8.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'trigger_session_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    strOptString4 = (String) jsonValue8.toJsonValue();
                }
            }
            if (strOptString4 == null) {
                strOptString4 = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(strOptString4, "toString(...)");
            }
            String str4 = strOptString4;
            JsonValue jsonValue9 = jsonMapRequireMap.get("additional_audience_check_result");
            if (jsonValue9 == null) {
                boolValueOf = null;
            } else {
                KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Boolean.class);
                if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    boolValueOf = (Boolean) jsonValue9.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    boolValueOf = Boolean.valueOf(jsonValue9.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    boolValueOf = (Boolean) Long.valueOf(jsonValue9.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    boolValueOf = (Boolean) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue9.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    boolValueOf = (Boolean) Double.valueOf(jsonValue9.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    boolValueOf = (Boolean) Float.valueOf(jsonValue9.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    boolValueOf = (Boolean) Integer.valueOf(jsonValue9.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    boolValueOf = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue9.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    boolValueOf = (Boolean) jsonValue9.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    boolValueOf = (Boolean) jsonValue9.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'additional_audience_check_result" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    boolValueOf = (Boolean) jsonValue9.toJsonValue();
                }
            }
            boolean zBooleanValue = boolValueOf != null ? boolValueOf.booleanValue() : true;
            JsonValue jsonValue10 = jsonMapRequireMap.get("PRIORITY");
            if (jsonValue10 != null) {
                KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Integer.class);
                if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    numValueOf = (Integer) jsonValue10.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    numValueOf = (Integer) Boolean.valueOf(jsonValue10.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    numValueOf = (Integer) Long.valueOf(jsonValue10.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    numValueOf = (Integer) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue10.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    numValueOf = (Integer) Double.valueOf(jsonValue10.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    numValueOf = (Integer) Float.valueOf(jsonValue10.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    numValueOf = Integer.valueOf(jsonValue10.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    numValueOf = (Integer) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue10.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    numValueOf = (Integer) jsonValue10.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    numValueOf = (Integer) jsonValue10.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Integer.class.getSimpleName() + "' for field 'PRIORITY" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    numValueOf = (Integer) jsonValue10.toJsonValue();
                }
                num = numValueOf;
            }
            return new PreparedScheduleInfo(str3, str, jsonValue4, str2, experimentResultFromJson, jsonValue7, str4, zBooleanValue, num != null ? num.intValue() : 0);
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("schedule_id", this.scheduleId), TuplesKt.to("product_id", this.productId), TuplesKt.to("campaigns", this.campaigns), TuplesKt.to(DeferredApiClient.KEY_CONTACT_ID, this.contactId), TuplesKt.to("experiment_result", this.experimentResult), TuplesKt.to("reporting_context", this.reportingContext), TuplesKt.to("trigger_session_id", this.triggerSessionId), TuplesKt.to("additional_audience_check_result", Boolean.valueOf(this.additionalAudienceCheckResult)), TuplesKt.to("PRIORITY", Integer.valueOf(this.priority))).toJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
