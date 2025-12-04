package com.urbanairship.automation;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.automation.AutomationTrigger;
import com.urbanairship.automation.deferred.DeferredAutomationData;
import com.urbanairship.automation.engine.triggerprocessor.TriggerExecutionType;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.util.DateUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 [2\u00020\u0001:\u0004Z[\\]B¥\u0002\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010#\u001a\u00020\r\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&¢\u0006\u0002\u0010'J4\u0010P\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0000ø\u0001\u0000¢\u0006\u0002\bQJ\u0013\u0010R\u001a\u00020\u00192\b\u0010S\u001a\u0004\u0018\u00010TH\u0096\u0002J\b\u0010U\u001a\u00020\tH\u0016J\u0006\u0010V\u001a\u00020WJ\b\u0010X\u001a\u00020\u001cH\u0016J\b\u0010Y\u001a\u00020\u0003H\u0016R\u0016\u0010%\u001a\u0004\u0018\u00010&X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001cX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001c\u0010#\u001a\u00020\rX\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\rø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\rø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b<\u0010;R\u001c\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010@R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\rø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\bB\u0010;R\u0019\u0010\n\u001a\u0004\u0018\u00010\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010@R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u00100R\u0016\u0010\"\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010@R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010J\u001a\u0004\bH\u0010IR\u0016\u0010!\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010@R\u0016\u0010$\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010@R\u0016\u0010 \u001a\u0004\u0018\u00010\u001cX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u00100R\u0019\u0010\f\u001a\u0004\u0018\u00010\rø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\bN\u0010;R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\bO\u0010>\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006^"}, d2 = {"Lcom/urbanairship/automation/AutomationSchedule;", "Lcom/urbanairship/json/JsonSerializable;", "identifier", "", "triggers", "", "Lcom/urbanairship/automation/AutomationTrigger;", "group", Constants.FirelogAnalytics.PARAM_PRIORITY, "", "limit", "Lkotlin/UInt;", "startDate", "Lkotlin/ULong;", "endDate", "audience", "Lcom/urbanairship/automation/AutomationAudience;", "compoundAudience", "Lcom/urbanairship/automation/AutomationCompoundAudience;", "delay", "Lcom/urbanairship/automation/AutomationDelay;", "interval", "data", "Lcom/urbanairship/automation/AutomationSchedule$ScheduleData;", "bypassHoldoutGroups", "", "editGracePeriodDays", "metadata", "Lcom/urbanairship/json/JsonValue;", "frequencyConstraintIds", Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, "campaigns", "reportingContext", "productId", "minSDKVersion", "created", "queue", "additionalAudienceCheckOverrides", "Lcom/urbanairship/automation/AdditionalAudienceCheckOverrides;", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/UInt;Lkotlin/ULong;Lkotlin/ULong;Lcom/urbanairship/automation/AutomationAudience;Lcom/urbanairship/automation/AutomationCompoundAudience;Lcom/urbanairship/automation/AutomationDelay;Lkotlin/ULong;Lcom/urbanairship/automation/AutomationSchedule$ScheduleData;Ljava/lang/Boolean;Lkotlin/ULong;Lcom/urbanairship/json/JsonValue;Ljava/util/List;Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Lcom/urbanairship/json/JsonValue;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/urbanairship/automation/AdditionalAudienceCheckOverrides;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdditionalAudienceCheckOverrides$urbanairship_automation_release", "()Lcom/urbanairship/automation/AdditionalAudienceCheckOverrides;", "getAudience", "()Lcom/urbanairship/automation/AutomationAudience;", "getBypassHoldoutGroups", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCampaigns$urbanairship_automation_release", "()Lcom/urbanairship/json/JsonValue;", "getCompoundAudience", "()Lcom/urbanairship/automation/AutomationCompoundAudience;", "getCreated-s-VKNKU$urbanairship_automation_release", "()J", "J", "getData", "()Lcom/urbanairship/automation/AutomationSchedule$ScheduleData;", "getDelay", "()Lcom/urbanairship/automation/AutomationDelay;", "getEditGracePeriodDays-6VbMDqA", "()Lkotlin/ULong;", "getEndDate-6VbMDqA", "getFrequencyConstraintIds$urbanairship_automation_release", "()Ljava/util/List;", "getGroup", "()Ljava/lang/String;", "getIdentifier", "getInterval-6VbMDqA", "getLimit-0hXNFcg", "()Lkotlin/UInt;", "getMessageType$urbanairship_automation_release", "getMetadata$urbanairship_automation_release", "getMinSDKVersion$urbanairship_automation_release", "getPriority", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProductId$urbanairship_automation_release", "getQueue$urbanairship_automation_release", "getReportingContext$urbanairship_automation_release", "getStartDate-6VbMDqA", "getTriggers", "copyWith", "copyWith-trFcsSw$urbanairship_automation_release", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "newBuilder", "Lcom/urbanairship/automation/AutomationSchedule$Builder;", "toJsonValue", "toString", "Builder", "Companion", "ScheduleData", "ScheduleType", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAutomationSchedule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationSchedule.kt\ncom/urbanairship/automation/AutomationSchedule\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,572:1\n1549#2:573\n1620#2,3:574\n1#3:577\n*S KotlinDebug\n*F\n+ 1 AutomationSchedule.kt\ncom/urbanairship/automation/AutomationSchedule\n*L\n461#1:573\n461#1:574,3\n*E\n"})
/* loaded from: classes5.dex */
public final class AutomationSchedule implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String DEFAULT_MESSAGE_TYPE = "transactional";
    public static final int TRIGGER_LIMIT = 10;
    private final AdditionalAudienceCheckOverrides additionalAudienceCheckOverrides;
    private final AutomationAudience audience;
    private final Boolean bypassHoldoutGroups;
    private final JsonValue campaigns;
    private final AutomationCompoundAudience compoundAudience;
    private final long created;
    private final ScheduleData data;
    private final AutomationDelay delay;
    private final ULong editGracePeriodDays;
    private final ULong endDate;
    private final List frequencyConstraintIds;
    private final String group;
    private final String identifier;
    private final ULong interval;
    private final UInt limit;
    private final String messageType;
    private final JsonValue metadata;
    private final String minSDKVersion;
    private final Integer priority;
    private final String productId;
    private final String queue;
    private final JsonValue reportingContext;
    private final ULong startDate;
    private final List triggers;

    @VisibleForTesting
    public /* synthetic */ AutomationSchedule(String str, List list, String str2, Integer num, UInt uInt, ULong uLong, ULong uLong2, AutomationAudience automationAudience, AutomationCompoundAudience automationCompoundAudience, AutomationDelay automationDelay, ULong uLong3, ScheduleData scheduleData, Boolean bool, ULong uLong4, JsonValue jsonValue, List list2, String str3, JsonValue jsonValue2, JsonValue jsonValue3, String str4, String str5, long j, String str6, AdditionalAudienceCheckOverrides additionalAudienceCheckOverrides, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, str2, num, uInt, uLong, uLong2, automationAudience, automationCompoundAudience, automationDelay, uLong3, scheduleData, bool, uLong4, jsonValue, list2, str3, jsonValue2, jsonValue3, str4, str5, j, str6, additionalAudienceCheckOverrides);
    }

    private AutomationSchedule(String identifier, List triggers, String str, Integer num, UInt uInt, ULong uLong, ULong uLong2, AutomationAudience automationAudience, AutomationCompoundAudience automationCompoundAudience, AutomationDelay automationDelay, ULong uLong3, ScheduleData data, Boolean bool, ULong uLong4, JsonValue jsonValue, List list, String str2, JsonValue jsonValue2, JsonValue jsonValue3, String str3, String str4, long j, String str5, AdditionalAudienceCheckOverrides additionalAudienceCheckOverrides) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(triggers, "triggers");
        Intrinsics.checkNotNullParameter(data, "data");
        this.identifier = identifier;
        this.triggers = triggers;
        this.group = str;
        this.priority = num;
        this.limit = uInt;
        this.startDate = uLong;
        this.endDate = uLong2;
        this.audience = automationAudience;
        this.compoundAudience = automationCompoundAudience;
        this.delay = automationDelay;
        this.interval = uLong3;
        this.data = data;
        this.bypassHoldoutGroups = bool;
        this.editGracePeriodDays = uLong4;
        this.metadata = jsonValue;
        this.frequencyConstraintIds = list;
        this.messageType = str2;
        this.campaigns = jsonValue2;
        this.reportingContext = jsonValue3;
        this.productId = str3;
        this.minSDKVersion = str4;
        this.created = j;
        this.queue = str5;
        this.additionalAudienceCheckOverrides = additionalAudienceCheckOverrides;
    }

    @NotNull
    public final String getIdentifier() {
        return this.identifier;
    }

    @NotNull
    public final List<AutomationTrigger> getTriggers() {
        return this.triggers;
    }

    @Nullable
    public final String getGroup() {
        return this.group;
    }

    @Nullable
    public final Integer getPriority() {
        return this.priority;
    }

    @Nullable
    /* renamed from: getLimit-0hXNFcg, reason: not valid java name and from getter */
    public final UInt getLimit() {
        return this.limit;
    }

    @Nullable
    /* renamed from: getStartDate-6VbMDqA, reason: not valid java name and from getter */
    public final ULong getStartDate() {
        return this.startDate;
    }

    @Nullable
    /* renamed from: getEndDate-6VbMDqA, reason: not valid java name and from getter */
    public final ULong getEndDate() {
        return this.endDate;
    }

    @Nullable
    public final AutomationAudience getAudience() {
        return this.audience;
    }

    @Nullable
    public final AutomationCompoundAudience getCompoundAudience() {
        return this.compoundAudience;
    }

    @Nullable
    public final AutomationDelay getDelay() {
        return this.delay;
    }

    @Nullable
    /* renamed from: getInterval-6VbMDqA, reason: not valid java name and from getter */
    public final ULong getInterval() {
        return this.interval;
    }

    @NotNull
    public final ScheduleData getData() {
        return this.data;
    }

    @Nullable
    public final Boolean getBypassHoldoutGroups() {
        return this.bypassHoldoutGroups;
    }

    @Nullable
    /* renamed from: getEditGracePeriodDays-6VbMDqA, reason: not valid java name and from getter */
    public final ULong getEditGracePeriodDays() {
        return this.editGracePeriodDays;
    }

    @Nullable
    /* renamed from: getMetadata$urbanairship_automation_release, reason: from getter */
    public final JsonValue getMetadata() {
        return this.metadata;
    }

    @Nullable
    public final List<String> getFrequencyConstraintIds$urbanairship_automation_release() {
        return this.frequencyConstraintIds;
    }

    @Nullable
    /* renamed from: getMessageType$urbanairship_automation_release, reason: from getter */
    public final String getMessageType() {
        return this.messageType;
    }

    @Nullable
    /* renamed from: getCampaigns$urbanairship_automation_release, reason: from getter */
    public final JsonValue getCampaigns() {
        return this.campaigns;
    }

    @Nullable
    /* renamed from: getReportingContext$urbanairship_automation_release, reason: from getter */
    public final JsonValue getReportingContext() {
        return this.reportingContext;
    }

    @Nullable
    /* renamed from: getProductId$urbanairship_automation_release, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    @Nullable
    /* renamed from: getMinSDKVersion$urbanairship_automation_release, reason: from getter */
    public final String getMinSDKVersion() {
        return this.minSDKVersion;
    }

    public /* synthetic */ AutomationSchedule(String str, List list, String str2, Integer num, UInt uInt, ULong uLong, ULong uLong2, AutomationAudience automationAudience, AutomationCompoundAudience automationCompoundAudience, AutomationDelay automationDelay, ULong uLong3, ScheduleData scheduleData, Boolean bool, ULong uLong4, JsonValue jsonValue, List list2, String str3, JsonValue jsonValue2, JsonValue jsonValue3, String str4, String str5, long j, String str6, AdditionalAudienceCheckOverrides additionalAudienceCheckOverrides, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : uInt, (i & 32) != 0 ? null : uLong, (i & 64) != 0 ? null : uLong2, (i & 128) != 0 ? null : automationAudience, (i & 256) != 0 ? null : automationCompoundAudience, (i & 512) != 0 ? null : automationDelay, (i & 1024) != 0 ? null : uLong3, scheduleData, (i & 4096) != 0 ? null : bool, (i & 8192) != 0 ? null : uLong4, (i & 16384) != 0 ? null : jsonValue, (32768 & i) != 0 ? null : list2, (65536 & i) != 0 ? null : str3, (131072 & i) != 0 ? null : jsonValue2, (262144 & i) != 0 ? null : jsonValue3, (524288 & i) != 0 ? null : str4, (1048576 & i) != 0 ? null : str5, (2097152 & i) != 0 ? ULong.m3028constructorimpl(System.currentTimeMillis()) : j, (4194304 & i) != 0 ? null : str6, (i & 8388608) != 0 ? null : additionalAudienceCheckOverrides, null);
    }

    /* renamed from: getCreated-s-VKNKU$urbanairship_automation_release, reason: not valid java name and from getter */
    public final long getCreated() {
        return this.created;
    }

    @Nullable
    /* renamed from: getQueue$urbanairship_automation_release, reason: from getter */
    public final String getQueue() {
        return this.queue;
    }

    @Nullable
    /* renamed from: getAdditionalAudienceCheckOverrides$urbanairship_automation_release, reason: from getter */
    public final AdditionalAudienceCheckOverrides getAdditionalAudienceCheckOverrides() {
        return this.additionalAudienceCheckOverrides;
    }

    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010-\u001a\u00020\u0003J\u0010\u0010.\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010/\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u000fJ\u000e\u00100\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u00101\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0015\u00102\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u000103¢\u0006\u0002\u00104J\u0015\u00105\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u000103¢\u0006\u0002\u00104J\u0010\u00106\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0015\u00107\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u000103¢\u0006\u0002\u00104J\u0015\u00108\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010%¢\u0006\u0002\u00109J\u0015\u0010:\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010%¢\u0006\u0002\u00109J\u0015\u0010;\u001a\u00020\u00002\b\u0010*\u001a\u0004\u0018\u000103¢\u0006\u0002\u00104J\u0014\u0010<\u001a\u00020\u00002\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u001aR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u00020\u0011X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0011X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u0011X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\u0004\u0018\u00010\u0011X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006="}, d2 = {"Lcom/urbanairship/automation/AutomationSchedule$Builder;", "", "schedule", "Lcom/urbanairship/automation/AutomationSchedule;", "(Lcom/urbanairship/automation/AutomationSchedule;)V", "additionalAudienceCheckOverrides", "Lcom/urbanairship/automation/AdditionalAudienceCheckOverrides;", "audience", "Lcom/urbanairship/automation/AutomationAudience;", "bypassHoldoutGroups", "", "Ljava/lang/Boolean;", "campaigns", "Lcom/urbanairship/json/JsonValue;", "compoundAudience", "Lcom/urbanairship/automation/AutomationCompoundAudience;", "created", "Lkotlin/ULong;", "J", "data", "Lcom/urbanairship/automation/AutomationSchedule$ScheduleData;", "delay", "Lcom/urbanairship/automation/AutomationDelay;", "editGracePeriodDays", "endDate", "frequencyConstraintIds", "", "", "group", "identifier", "interval", "limit", "Lkotlin/UInt;", Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, "metadata", "minSDKVersion", Constants.FirelogAnalytics.PARAM_PRIORITY, "", "Ljava/lang/Integer;", "productId", "queue", "reportingContext", "startDate", "triggers", "Lcom/urbanairship/automation/AutomationTrigger;", "build", "setAudience", "setCompoundAudience", "setData", "setDelay", "setEditGracePeriodDays", "", "(Ljava/lang/Long;)Lcom/urbanairship/automation/AutomationSchedule$Builder;", "setEndDate", "setGroup", "setInterval", "setLimit", "(Ljava/lang/Integer;)Lcom/urbanairship/automation/AutomationSchedule$Builder;", "setPriority", "setStartDate", "setTriggers", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Builder {
        private final AdditionalAudienceCheckOverrides additionalAudienceCheckOverrides;
        private AutomationAudience audience;
        private final Boolean bypassHoldoutGroups;
        private final JsonValue campaigns;
        private AutomationCompoundAudience compoundAudience;
        private final long created;
        private ScheduleData data;
        private AutomationDelay delay;
        private ULong editGracePeriodDays;
        private ULong endDate;
        private final List frequencyConstraintIds;
        private String group;
        private final String identifier;
        private ULong interval;
        private UInt limit;
        private final String messageType;
        private final JsonValue metadata;
        private final String minSDKVersion;
        private Integer priority;
        private final String productId;
        private final String queue;
        private final JsonValue reportingContext;
        private ULong startDate;
        private List triggers;

        public Builder(@NotNull AutomationSchedule schedule) {
            Intrinsics.checkNotNullParameter(schedule, "schedule");
            this.triggers = schedule.getTriggers();
            this.group = schedule.getGroup();
            this.priority = schedule.getPriority();
            this.limit = schedule.getLimit();
            this.startDate = schedule.getStartDate();
            this.endDate = schedule.getEndDate();
            this.audience = schedule.getAudience();
            this.compoundAudience = schedule.getCompoundAudience();
            this.delay = schedule.getDelay();
            this.interval = schedule.getInterval();
            this.data = schedule.getData();
            this.editGracePeriodDays = schedule.getEditGracePeriodDays();
            this.identifier = schedule.getIdentifier();
            this.metadata = schedule.getMetadata();
            this.frequencyConstraintIds = schedule.getFrequencyConstraintIds$urbanairship_automation_release();
            this.messageType = schedule.getMessageType();
            this.campaigns = schedule.getCampaigns();
            this.reportingContext = schedule.getReportingContext();
            this.productId = schedule.getProductId();
            this.minSDKVersion = schedule.getMinSDKVersion();
            this.created = schedule.getCreated();
            this.queue = schedule.getQueue();
            this.additionalAudienceCheckOverrides = schedule.getAdditionalAudienceCheckOverrides();
            this.bypassHoldoutGroups = schedule.getBypassHoldoutGroups();
        }

        @NotNull
        public final Builder setTriggers(@NotNull List<? extends AutomationTrigger> triggers) {
            Intrinsics.checkNotNullParameter(triggers, "triggers");
            this.triggers = triggers;
            return this;
        }

        @NotNull
        public final Builder setGroup(@Nullable String group) {
            this.group = group;
            return this;
        }

        @NotNull
        public final Builder setPriority(@Nullable Integer priority) {
            this.priority = priority;
            return this;
        }

        @NotNull
        public final Builder setLimit(@Nullable Integer limit) {
            this.limit = limit != null ? UInt.m3002boximpl(UInt.m3003constructorimpl(limit.intValue())) : null;
            return this;
        }

        @NotNull
        public final Builder setStartDate(@Nullable Long startDate) {
            this.startDate = startDate != null ? ULong.m3027boximpl(ULong.m3028constructorimpl(startDate.longValue())) : null;
            return this;
        }

        @NotNull
        public final Builder setEndDate(@Nullable Long endDate) {
            this.endDate = endDate != null ? ULong.m3027boximpl(ULong.m3028constructorimpl(endDate.longValue())) : null;
            return this;
        }

        @NotNull
        public final Builder setAudience(@Nullable AutomationAudience audience) {
            this.audience = audience;
            return this;
        }

        @NotNull
        public final Builder setCompoundAudience(@Nullable AutomationCompoundAudience audience) {
            this.compoundAudience = audience;
            return this;
        }

        @NotNull
        public final Builder setDelay(@Nullable AutomationDelay delay) {
            this.delay = delay;
            return this;
        }

        @NotNull
        public final Builder setInterval(@Nullable Long interval) {
            this.interval = interval != null ? ULong.m3027boximpl(ULong.m3028constructorimpl(interval.longValue())) : null;
            return this;
        }

        @NotNull
        public final Builder setData(@NotNull ScheduleData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            return this;
        }

        @NotNull
        public final Builder setEditGracePeriodDays(@Nullable Long editGracePeriodDays) {
            this.editGracePeriodDays = editGracePeriodDays != null ? ULong.m3027boximpl(ULong.m3028constructorimpl(editGracePeriodDays.longValue())) : null;
            return this;
        }

        @NotNull
        public final AutomationSchedule build() {
            return new AutomationSchedule(this.identifier, this.triggers, this.group, this.priority, this.limit, this.startDate, this.endDate, this.audience, this.compoundAudience, this.delay, this.interval, this.data, this.bypassHoldoutGroups, this.editGracePeriodDays, this.metadata, this.frequencyConstraintIds, this.messageType, this.campaigns, this.reportingContext, this.productId, this.minSDKVersion, this.created, this.queue, this.additionalAudienceCheckOverrides, null);
        }
    }

    @NotNull
    public final Builder newBuilder() {
        return new Builder(this);
    }

    /* renamed from: copyWith-trFcsSw$urbanairship_automation_release$default, reason: not valid java name */
    public static /* synthetic */ AutomationSchedule m2771copyWithtrFcsSw$urbanairship_automation_release$default(AutomationSchedule automationSchedule, String str, ULong uLong, JsonValue jsonValue, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            uLong = null;
        }
        if ((i & 4) != 0) {
            jsonValue = null;
        }
        return automationSchedule.m2772copyWithtrFcsSw$urbanairship_automation_release(str, uLong, jsonValue);
    }

    @NotNull
    /* renamed from: copyWith-trFcsSw$urbanairship_automation_release, reason: not valid java name */
    public final AutomationSchedule m2772copyWithtrFcsSw$urbanairship_automation_release(@Nullable String group, @Nullable ULong endDate, @Nullable JsonValue metadata) {
        return new AutomationSchedule(this.identifier, this.triggers, group == null ? this.group : group, this.priority, this.limit, this.startDate, endDate == null ? this.endDate : endDate, this.audience, this.compoundAudience, this.delay, this.interval, this.data, this.bypassHoldoutGroups, this.editGracePeriodDays, metadata == null ? this.metadata : metadata, this.frequencyConstraintIds, this.messageType, this.campaigns, this.reportingContext, this.productId, this.minSDKVersion, this.created, this.queue, this.additionalAudienceCheckOverrides, null);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/urbanairship/automation/AutomationSchedule$ScheduleData;", "Lcom/urbanairship/json/JsonSerializable;", "()V", "Actions", "Companion", "Deferred", "InAppMessageData", "Lcom/urbanairship/automation/AutomationSchedule$ScheduleData$Actions;", "Lcom/urbanairship/automation/AutomationSchedule$ScheduleData$Deferred;", "Lcom/urbanairship/automation/AutomationSchedule$ScheduleData$InAppMessageData;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class ScheduleData implements JsonSerializable {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        public /* synthetic */ ScheduleData(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/urbanairship/automation/AutomationSchedule$ScheduleData$Companion;", "", "()V", "ACTIONS", "", "DEFERRED", "MESSAGE", "TYPE", "fromJson", "Lcom/urbanairship/automation/AutomationSchedule$ScheduleData;", "value", "Lcom/urbanairship/json/JsonValue;", "fromJson$urbanairship_automation_release", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {

            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ScheduleType.values().length];
                    try {
                        iArr[ScheduleType.ACTIONS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ScheduleType.IN_APP_MESSAGE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ScheduleType.DEFERRED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final ScheduleData fromJson$urbanairship_automation_release(@NotNull JsonValue value) throws JsonException {
                Intrinsics.checkNotNullParameter(value, "value");
                JsonMap jsonMapRequireMap = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                ScheduleType.Companion companion = ScheduleType.INSTANCE;
                JsonValue jsonValueRequire = jsonMapRequireMap.require("type");
                Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
                int i = WhenMappings.$EnumSwitchMapping$0[companion.fromJson(jsonValueRequire).ordinal()];
                if (i == 1) {
                    JsonValue jsonValueRequire2 = jsonMapRequireMap.require("actions");
                    Intrinsics.checkNotNullExpressionValue(jsonValueRequire2, "require(...)");
                    return new Actions(jsonValueRequire2);
                }
                if (i == 2) {
                    InAppMessage.Companion companion2 = InAppMessage.INSTANCE;
                    JsonValue jsonValueRequire3 = jsonMapRequireMap.require("message");
                    Intrinsics.checkNotNullExpressionValue(jsonValueRequire3, "require(...)");
                    return new InAppMessageData(companion2.parseJson(jsonValueRequire3));
                }
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                DeferredAutomationData.Companion companion3 = DeferredAutomationData.INSTANCE;
                JsonValue jsonValueRequire4 = jsonMapRequireMap.require("deferred");
                Intrinsics.checkNotNullExpressionValue(jsonValueRequire4, "require(...)");
                return new Deferred(companion3.fromJson(jsonValueRequire4));
            }
        }

        private ScheduleData() {
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/automation/AutomationSchedule$ScheduleData$Actions;", "Lcom/urbanairship/automation/AutomationSchedule$ScheduleData;", "actions", "Lcom/urbanairship/json/JsonValue;", "(Lcom/urbanairship/json/JsonValue;)V", "getActions", "()Lcom/urbanairship/json/JsonValue;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Actions extends ScheduleData {
            private final JsonValue actions;

            public static /* synthetic */ Actions copy$default(Actions actions, JsonValue jsonValue, int i, Object obj) {
                if ((i & 1) != 0) {
                    jsonValue = actions.actions;
                }
                return actions.copy(jsonValue);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final JsonValue getActions() {
                return this.actions;
            }

            @NotNull
            public final Actions copy(@NotNull JsonValue actions) {
                Intrinsics.checkNotNullParameter(actions, "actions");
                return new Actions(actions);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Actions) && Intrinsics.areEqual(this.actions, ((Actions) other).actions);
            }

            public int hashCode() {
                return this.actions.hashCode();
            }

            @NotNull
            public String toString() {
                return "Actions(actions=" + this.actions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Actions(@NotNull JsonValue actions) {
                super(null);
                Intrinsics.checkNotNullParameter(actions, "actions");
                this.actions = actions;
            }

            @NotNull
            public final JsonValue getActions() {
                return this.actions;
            }

            @Override // com.urbanairship.json.JsonSerializable
            @NotNull
            public JsonValue toJsonValue() {
                JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", ScheduleType.ACTIONS), TuplesKt.to("actions", this.actions)).toJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                return jsonValue;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/automation/AutomationSchedule$ScheduleData$InAppMessageData;", "Lcom/urbanairship/automation/AutomationSchedule$ScheduleData;", "message", "Lcom/urbanairship/iam/InAppMessage;", "(Lcom/urbanairship/iam/InAppMessage;)V", "getMessage", "()Lcom/urbanairship/iam/InAppMessage;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class InAppMessageData extends ScheduleData {
            private final InAppMessage message;

            public static /* synthetic */ InAppMessageData copy$default(InAppMessageData inAppMessageData, InAppMessage inAppMessage, int i, Object obj) {
                if ((i & 1) != 0) {
                    inAppMessage = inAppMessageData.message;
                }
                return inAppMessageData.copy(inAppMessage);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final InAppMessage getMessage() {
                return this.message;
            }

            @NotNull
            public final InAppMessageData copy(@NotNull InAppMessage message) {
                Intrinsics.checkNotNullParameter(message, "message");
                return new InAppMessageData(message);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof InAppMessageData) && Intrinsics.areEqual(this.message, ((InAppMessageData) other).message);
            }

            public int hashCode() {
                return this.message.hashCode();
            }

            @NotNull
            public String toString() {
                return "InAppMessageData(message=" + this.message + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public InAppMessageData(@NotNull InAppMessage message) {
                super(null);
                Intrinsics.checkNotNullParameter(message, "message");
                this.message = message;
            }

            @NotNull
            public final InAppMessage getMessage() {
                return this.message;
            }

            @Override // com.urbanairship.json.JsonSerializable
            @NotNull
            public JsonValue toJsonValue() {
                JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", ScheduleType.IN_APP_MESSAGE), TuplesKt.to("message", this.message)).toJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                return jsonValue;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\bJ\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/automation/AutomationSchedule$ScheduleData$Deferred;", "Lcom/urbanairship/automation/AutomationSchedule$ScheduleData;", "deferred", "Lcom/urbanairship/automation/deferred/DeferredAutomationData;", "(Lcom/urbanairship/automation/deferred/DeferredAutomationData;)V", "getDeferred$urbanairship_automation_release", "()Lcom/urbanairship/automation/deferred/DeferredAutomationData;", "component1", "component1$urbanairship_automation_release", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Deferred extends ScheduleData {
            private final DeferredAutomationData deferred;

            public static /* synthetic */ Deferred copy$default(Deferred deferred, DeferredAutomationData deferredAutomationData, int i, Object obj) {
                if ((i & 1) != 0) {
                    deferredAutomationData = deferred.deferred;
                }
                return deferred.copy(deferredAutomationData);
            }

            @NotNull
            /* renamed from: component1$urbanairship_automation_release, reason: from getter */
            public final DeferredAutomationData getDeferred() {
                return this.deferred;
            }

            @NotNull
            public final Deferred copy(@NotNull DeferredAutomationData deferred) {
                Intrinsics.checkNotNullParameter(deferred, "deferred");
                return new Deferred(deferred);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Deferred) && Intrinsics.areEqual(this.deferred, ((Deferred) other).deferred);
            }

            public int hashCode() {
                return this.deferred.hashCode();
            }

            @NotNull
            public String toString() {
                return "Deferred(deferred=" + this.deferred + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Deferred(@NotNull DeferredAutomationData deferred) {
                super(null);
                Intrinsics.checkNotNullParameter(deferred, "deferred");
                this.deferred = deferred;
            }

            @NotNull
            public final DeferredAutomationData getDeferred$urbanairship_automation_release() {
                return this.deferred;
            }

            @Override // com.urbanairship.json.JsonSerializable
            @NotNull
            public JsonValue toJsonValue() {
                JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", ScheduleType.DEFERRED), TuplesKt.to("deferred", this.deferred)).toJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                return jsonValue;
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/automation/AutomationSchedule$ScheduleType;", "", "Lcom/urbanairship/json/JsonSerializable;", "json", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJson$urbanairship_automation_release", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "ACTIONS", "IN_APP_MESSAGE", "DEFERRED", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ScheduleType implements JsonSerializable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ScheduleType[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        private final String json;
        public static final ScheduleType ACTIONS = new ScheduleType("ACTIONS", 0, "actions");
        public static final ScheduleType IN_APP_MESSAGE = new ScheduleType("IN_APP_MESSAGE", 1, "in_app_message");
        public static final ScheduleType DEFERRED = new ScheduleType("DEFERRED", 2, "deferred");

        private static final /* synthetic */ ScheduleType[] $values() {
            return new ScheduleType[]{ACTIONS, IN_APP_MESSAGE, DEFERRED};
        }

        @NotNull
        public static EnumEntries<ScheduleType> getEntries() {
            return $ENTRIES;
        }

        public static ScheduleType valueOf(String str) {
            return (ScheduleType) Enum.valueOf(ScheduleType.class, str);
        }

        public static ScheduleType[] values() {
            return (ScheduleType[]) $VALUES.clone();
        }

        private ScheduleType(String str, int i, String str2) {
            this.json = str2;
        }

        @NotNull
        /* renamed from: getJson$urbanairship_automation_release, reason: from getter */
        public final String getJson() {
            return this.json;
        }

        static {
            ScheduleType[] scheduleTypeArr$values = $values();
            $VALUES = scheduleTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(scheduleTypeArr$values);
            INSTANCE = new Companion(null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/AutomationSchedule$ScheduleType$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/automation/AutomationSchedule$ScheduleType;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nAutomationSchedule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationSchedule.kt\ncom/urbanairship/automation/AutomationSchedule$ScheduleType$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,572:1\n288#2,2:573\n*S KotlinDebug\n*F\n+ 1 AutomationSchedule.kt\ncom/urbanairship/automation/AutomationSchedule$ScheduleType$Companion\n*L\n373#1:573,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final ScheduleType fromJson(@NotNull JsonValue value) throws JsonException {
                ScheduleType next;
                Intrinsics.checkNotNullParameter(value, "value");
                String strRequireString = value.requireString();
                Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                Iterator<ScheduleType> it = ScheduleType.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(next.getJson(), strRequireString)) {
                        break;
                    }
                }
                ScheduleType scheduleType = next;
                if (scheduleType != null) {
                    return scheduleType;
                }
                throw new JsonException("Invalid schedule type " + strRequireString);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() {
            JsonValue jsonValueWrap = JsonValue.wrap(this.json);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            return jsonValueWrap;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0080T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/urbanairship/automation/AutomationSchedule$Companion;", "", "()V", "ADDITIONAL_AUDIENCE_CHECK_OVERRIDES", "", "AUDIENCE", "BYPASS_HOLDOUT_GROUPS", "CAMPAIGNS", "COMPOUND_AUDIENCE", DebugCoroutineInfoImplKt.CREATED, "DEFAULT_MESSAGE_TYPE", "DELAY", "EDIT_GRACE_PERIOD_DAYS", "END", "FREQUENCY_CONSTRAINT_IDS", "GROUP", "IDENTIFIER", "INTERVAL", "LIMIT", "MESSAGE_TYPE", "METADATA", "MIN_SDK_VERSION", "PRIORITY", "PRODUCT_ID", "QUEUE", "REPORTING_CONTEXT", "START", "TRIGGERS", "TRIGGER_LIMIT", "", "fromJson", "Lcom/urbanairship/automation/AutomationSchedule;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAutomationSchedule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationSchedule.kt\ncom/urbanairship/automation/AutomationSchedule$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,572:1\n44#2,15:573\n79#2,16:592\n79#2,16:608\n79#2,16:625\n79#2,16:641\n79#2,16:657\n79#2,16:677\n79#2,16:693\n79#2,16:709\n1549#3:588\n1620#3,3:589\n1549#3:673\n1620#3,3:674\n1#4:624\n*S KotlinDebug\n*F\n+ 1 AutomationSchedule.kt\ncom/urbanairship/automation/AutomationSchedule$Companion\n*L\n425#1:573,15\n429#1:592,16\n431#1:608,16\n438#1:625,16\n442#1:641,16\n443#1:657,16\n446#1:677,16\n447#1:693,16\n448#1:709,16\n426#1:588\n426#1:589,3\n445#1:673\n445#1:674,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final AutomationSchedule fromJson(@NotNull JsonValue value) throws IllegalArgumentException, NoSuchElementException, JsonException {
            String strOptString;
            String str;
            String str2;
            String strOptString2;
            JsonValue jsonValue;
            Integer numValueOf;
            Integer num;
            AutomationAudience automationAudience;
            UInt uInt;
            ULong uLong;
            ULong uLongM3027boximpl;
            ULong uLong2;
            ULong uLong3;
            Boolean boolValueOf;
            Boolean bool;
            Boolean bool2;
            ULong uLongM3027boximpl2;
            ULong uLong4;
            ArrayList arrayList;
            ULong uLong5;
            String strOptString3;
            String str3;
            String str4;
            String strOptString4;
            String str5;
            String str6;
            String strOptString5;
            String str7;
            JsonList jsonListRequireList;
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            ULong uLongFromJson$parseDate = fromJson$parseDate(jsonMapRequireMap.get("created"));
            if (uLongFromJson$parseDate == null) {
                throw new JsonException("Invalid created date string " + jsonMapRequireMap.get("created"));
            }
            long data = uLongFromJson$parseDate.getData();
            JsonValue jsonValue2 = jsonMapRequireMap.get("id");
            if (jsonValue2 == null) {
                throw new JsonException("Missing required field: 'id" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue2.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString = jsonValue2.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
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
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString = (String) Integer.valueOf(jsonValue2.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList = jsonValue2.optList();
                if (objOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap = jsonValue2.optMap();
                if (objOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'id" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue3 = jsonValue2.toJsonValue();
                if (jsonValue3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue3;
            }
            String str8 = strOptString;
            JsonList jsonListRequireList2 = jsonMapRequireMap.require("triggers").requireList();
            Intrinsics.checkNotNullExpressionValue(jsonListRequireList2, "requireList(...)");
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList2, 10));
            for (JsonValue jsonValue4 : jsonListRequireList2) {
                AutomationTrigger.Companion companion = AutomationTrigger.INSTANCE;
                Intrinsics.checkNotNull(jsonValue4);
                arrayList2.add(companion.fromJson(jsonValue4, TriggerExecutionType.EXECUTION));
            }
            JsonValue jsonValue5 = jsonMapRequireMap.get("group");
            if (jsonValue5 == null) {
                str = "' for field '";
                str2 = "Invalid type '";
                strOptString2 = null;
            } else {
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString2 = jsonValue5.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString2 = (String) Boolean.valueOf(jsonValue5.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    str = "' for field '";
                    str2 = "Invalid type '";
                    strOptString2 = (String) Long.valueOf(jsonValue5.getLong(0L));
                } else {
                    str = "' for field '";
                    str2 = "Invalid type '";
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString2 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue5.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString2 = (String) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString2 = (String) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        strOptString2 = (String) Integer.valueOf(jsonValue5.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString2 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue5.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        strOptString2 = (String) jsonValue5.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        strOptString2 = (String) jsonValue5.optMap();
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException(str2 + String.class.getSimpleName() + str + "group" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        strOptString2 = (String) jsonValue5.toJsonValue();
                    }
                }
                str = "' for field '";
                str2 = "Invalid type '";
            }
            JsonValue jsonValue6 = jsonMapRequireMap.get("metadata");
            JsonValue jsonValue7 = jsonMapRequireMap.get(Constants.FirelogAnalytics.PARAM_PRIORITY);
            if (jsonValue7 == null) {
                jsonValue = jsonValue6;
                num = null;
            } else {
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Integer.class);
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    numValueOf = (Integer) jsonValue7.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    numValueOf = (Integer) Boolean.valueOf(jsonValue7.getBoolean(false));
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        jsonValue = jsonValue6;
                        numValueOf = (Integer) Long.valueOf(jsonValue7.getLong(0L));
                    } else {
                        jsonValue = jsonValue6;
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            numValueOf = (Integer) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue7.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            numValueOf = (Integer) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            numValueOf = (Integer) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            numValueOf = Integer.valueOf(jsonValue7.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            numValueOf = (Integer) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue7.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            numValueOf = (Integer) jsonValue7.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            numValueOf = (Integer) jsonValue7.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException(str2 + Integer.class.getSimpleName() + str + Constants.FirelogAnalytics.PARAM_PRIORITY + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            numValueOf = (Integer) jsonValue7.toJsonValue();
                        }
                    }
                    num = numValueOf;
                }
                jsonValue = jsonValue6;
                num = numValueOf;
            }
            JsonValue jsonValue8 = jsonMapRequireMap.get("limit");
            UInt uIntM3002boximpl = jsonValue8 != null ? UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue8.getInt(0))) : null;
            ULong uLongFromJson$parseDate2 = fromJson$parseDate(jsonMapRequireMap.get(ViewProps.START));
            ULong uLongFromJson$parseDate3 = fromJson$parseDate(jsonMapRequireMap.get(ViewProps.END));
            JsonValue jsonValue9 = jsonMapRequireMap.get("audience");
            AutomationAudience automationAudienceFromJson = jsonValue9 != null ? AutomationAudience.INSTANCE.fromJson(jsonValue9) : null;
            JsonValue jsonValue10 = jsonMapRequireMap.get("compound_audience");
            String str9 = str;
            AutomationCompoundAudience automationCompoundAudienceFromJson = jsonValue10 != null ? AutomationCompoundAudience.INSTANCE.fromJson(jsonValue10) : null;
            JsonValue jsonValue11 = jsonMapRequireMap.get("delay");
            AutomationDelay automationDelayFromJson = jsonValue11 != null ? AutomationDelay.INSTANCE.fromJson(jsonValue11) : null;
            JsonValue jsonValue12 = jsonMapRequireMap.get("interval");
            if (jsonValue12 == null) {
                uLong = uLongFromJson$parseDate2;
                automationAudience = automationAudienceFromJson;
                uLong2 = null;
                uInt = uIntM3002boximpl;
            } else {
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(ULong.class);
                automationAudience = automationAudienceFromJson;
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    uLongM3027boximpl = (ULong) jsonValue12.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    uLongM3027boximpl = (ULong) Boolean.valueOf(jsonValue12.getBoolean(false));
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        uInt = uIntM3002boximpl;
                        uLong = uLongFromJson$parseDate2;
                        uLongM3027boximpl = (ULong) Long.valueOf(jsonValue12.getLong(0L));
                    } else {
                        uInt = uIntM3002boximpl;
                        uLong = uLongFromJson$parseDate2;
                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            uLongM3027boximpl = ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue12.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            uLongM3027boximpl = (ULong) Double.valueOf(jsonValue12.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            uLongM3027boximpl = (ULong) Float.valueOf(jsonValue12.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            uLongM3027boximpl = (ULong) Integer.valueOf(jsonValue12.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            uLongM3027boximpl = (ULong) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue12.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            uLongM3027boximpl = (ULong) jsonValue12.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            uLongM3027boximpl = (ULong) jsonValue12.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException(str2 + ULong.class.getSimpleName() + str9 + "interval" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            uLongM3027boximpl = (ULong) jsonValue12.toJsonValue();
                        }
                    }
                    uLong2 = uLongM3027boximpl;
                }
                uInt = uIntM3002boximpl;
                uLong = uLongFromJson$parseDate2;
                uLong2 = uLongM3027boximpl;
            }
            JsonValue jsonValue13 = jsonMapRequireMap.get("campaigns");
            JsonValue jsonValue14 = jsonMapRequireMap.get("reporting_context");
            JsonValue jsonValue15 = jsonMapRequireMap.get("product_id");
            String strRequireString = jsonValue15 != null ? jsonValue15.requireString() : null;
            JsonValue jsonValue16 = jsonMapRequireMap.get("bypass_holdout_groups");
            if (jsonValue16 == null) {
                uLong3 = uLongFromJson$parseDate3;
                bool = null;
            } else {
                KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Boolean.class);
                if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    boolValueOf = (Boolean) jsonValue16.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    boolValueOf = Boolean.valueOf(jsonValue16.getBoolean(false));
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        uLong3 = uLongFromJson$parseDate3;
                        boolValueOf = (Boolean) Long.valueOf(jsonValue16.getLong(0L));
                    } else {
                        uLong3 = uLongFromJson$parseDate3;
                        if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            boolValueOf = (Boolean) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue16.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            boolValueOf = (Boolean) Double.valueOf(jsonValue16.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            boolValueOf = (Boolean) Float.valueOf(jsonValue16.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            boolValueOf = (Boolean) Integer.valueOf(jsonValue16.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            boolValueOf = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue16.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            boolValueOf = (Boolean) jsonValue16.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            boolValueOf = (Boolean) jsonValue16.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException(str2 + Boolean.class.getSimpleName() + str9 + "bypass_holdout_groups" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            boolValueOf = (Boolean) jsonValue16.toJsonValue();
                        }
                    }
                    bool = boolValueOf;
                }
                uLong3 = uLongFromJson$parseDate3;
                bool = boolValueOf;
            }
            JsonValue jsonValue17 = jsonMapRequireMap.get("edit_grace_period");
            if (jsonValue17 == null) {
                bool2 = bool;
                uLong4 = null;
            } else {
                KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(ULong.class);
                if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    uLongM3027boximpl2 = (ULong) jsonValue17.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    uLongM3027boximpl2 = (ULong) Boolean.valueOf(jsonValue17.getBoolean(false));
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        bool2 = bool;
                        uLongM3027boximpl2 = (ULong) Long.valueOf(jsonValue17.getLong(0L));
                    } else {
                        bool2 = bool;
                        if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            uLongM3027boximpl2 = ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue17.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            uLongM3027boximpl2 = (ULong) Double.valueOf(jsonValue17.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            uLongM3027boximpl2 = (ULong) Float.valueOf(jsonValue17.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            uLongM3027boximpl2 = (ULong) Integer.valueOf(jsonValue17.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            uLongM3027boximpl2 = (ULong) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue17.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            uLongM3027boximpl2 = (ULong) jsonValue17.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            uLongM3027boximpl2 = (ULong) jsonValue17.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException(str2 + ULong.class.getSimpleName() + str9 + "edit_grace_period" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            uLongM3027boximpl2 = (ULong) jsonValue17.toJsonValue();
                        }
                    }
                    uLong4 = uLongM3027boximpl2;
                }
                bool2 = bool;
                uLong4 = uLongM3027boximpl2;
            }
            JsonValue jsonValue18 = jsonMapRequireMap.get("frequency_constraint_ids");
            if (jsonValue18 == null || (jsonListRequireList = jsonValue18.requireList()) == null) {
                arrayList = null;
            } else {
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
                Iterator<JsonValue> it = jsonListRequireList.iterator();
                while (it.hasNext()) {
                    String strRequireString2 = it.next().requireString();
                    Intrinsics.checkNotNullExpressionValue(strRequireString2, "requireString(...)");
                    arrayList3.add(strRequireString2);
                }
                arrayList = arrayList3;
            }
            JsonValue jsonValue19 = jsonMapRequireMap.get(Constants.MessagePayloadKeys.MESSAGE_TYPE);
            if (jsonValue19 == null) {
                uLong5 = uLong4;
                str3 = null;
            } else {
                KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString3 = jsonValue19.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString3 = (String) Boolean.valueOf(jsonValue19.getBoolean(false));
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        uLong5 = uLong4;
                        strOptString3 = (String) Long.valueOf(jsonValue19.getLong(0L));
                    } else {
                        uLong5 = uLong4;
                        if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString3 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue19.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString3 = (String) Double.valueOf(jsonValue19.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString3 = (String) Float.valueOf(jsonValue19.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            strOptString3 = (String) Integer.valueOf(jsonValue19.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString3 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue19.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            strOptString3 = (String) jsonValue19.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            strOptString3 = (String) jsonValue19.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException(str2 + String.class.getSimpleName() + str9 + Constants.MessagePayloadKeys.MESSAGE_TYPE + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            strOptString3 = (String) jsonValue19.toJsonValue();
                        }
                    }
                    str3 = strOptString3;
                }
                uLong5 = uLong4;
                str3 = strOptString3;
            }
            JsonValue jsonValue20 = jsonMapRequireMap.get("min_sdk_version");
            if (jsonValue20 == null) {
                str4 = str3;
                str5 = null;
            } else {
                KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString4 = jsonValue20.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString4 = (String) Boolean.valueOf(jsonValue20.getBoolean(false));
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        str4 = str3;
                        strOptString4 = (String) Long.valueOf(jsonValue20.getLong(0L));
                    } else {
                        str4 = str3;
                        if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString4 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue20.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString4 = (String) Double.valueOf(jsonValue20.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString4 = (String) Float.valueOf(jsonValue20.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            strOptString4 = (String) Integer.valueOf(jsonValue20.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString4 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue20.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            strOptString4 = (String) jsonValue20.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            strOptString4 = (String) jsonValue20.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException(str2 + String.class.getSimpleName() + str9 + "min_sdk_version" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            strOptString4 = (String) jsonValue20.toJsonValue();
                        }
                    }
                    str5 = strOptString4;
                }
                str4 = str3;
                str5 = strOptString4;
            }
            JsonValue jsonValue21 = jsonMapRequireMap.get("queue");
            if (jsonValue21 == null) {
                str6 = str5;
                str7 = null;
            } else {
                KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString5 = jsonValue21.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString5 = (String) Boolean.valueOf(jsonValue21.getBoolean(false));
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        str6 = str5;
                        strOptString5 = (String) Long.valueOf(jsonValue21.getLong(0L));
                    } else {
                        str6 = str5;
                        if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString5 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue21.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString5 = (String) Double.valueOf(jsonValue21.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString5 = (String) Float.valueOf(jsonValue21.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            strOptString5 = (String) Integer.valueOf(jsonValue21.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString5 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue21.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            strOptString5 = (String) jsonValue21.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            strOptString5 = (String) jsonValue21.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException(str2 + String.class.getSimpleName() + str9 + "queue" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            strOptString5 = (String) jsonValue21.toJsonValue();
                        }
                    }
                    str7 = strOptString5;
                }
                str6 = str5;
                str7 = strOptString5;
            }
            ScheduleData scheduleDataFromJson$urbanairship_automation_release = ScheduleData.INSTANCE.fromJson$urbanairship_automation_release(value);
            JsonValue jsonValue22 = jsonMapRequireMap.get("additional_audience_check_overrides");
            return new AutomationSchedule(str8, arrayList2, strOptString2, num, uInt, uLong, uLong3, automationAudience, automationCompoundAudienceFromJson, automationDelayFromJson, uLong2, scheduleDataFromJson$urbanairship_automation_release, bool2, uLong5, jsonValue, arrayList, str4, jsonValue13, jsonValue14, strRequireString, str6, data, str7, jsonValue22 != null ? AdditionalAudienceCheckOverrides.INSTANCE.fromJson(jsonValue22) : null, null);
        }

        private static final ULong fromJson$parseDate(JsonValue jsonValue) {
            String strOptString;
            if (jsonValue == null || (strOptString = jsonValue.optString()) == null) {
                return null;
            }
            return ULong.m3027boximpl(ULong.m3028constructorimpl(DateUtils.parseIso8601(strOptString)));
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() {
        JsonMap.Builder builderPut = JsonMap.newBuilder().putAll(this.data.toJsonValue().optMap()).put("id", this.identifier);
        List list = this.triggers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((AutomationTrigger) it.next()).toJsonValue());
        }
        JsonMap.Builder builderPutOpt = builderPut.put("triggers", JsonExtensionsKt.toJsonList(arrayList)).putOpt("group", this.group).putOpt("metadata", this.metadata).putOpt(Constants.FirelogAnalytics.PARAM_PRIORITY, this.priority);
        UInt uInt = this.limit;
        JsonMap.Builder builderPutOpt2 = builderPutOpt.putOpt("limit", uInt != null ? Integer.valueOf(uInt.getData()) : null);
        ULong uLong = this.startDate;
        JsonMap.Builder builderPutOpt3 = builderPutOpt2.putOpt(ViewProps.START, uLong != null ? DateUtils.createIso8601TimeStamp(uLong.getData()) : null);
        ULong uLong2 = this.endDate;
        JsonMap.Builder builderPutOpt4 = builderPutOpt3.putOpt(ViewProps.END, uLong2 != null ? DateUtils.createIso8601TimeStamp(uLong2.getData()) : null).putOpt("audience", this.audience).putOpt("compound_audience", this.compoundAudience).putOpt("delay", this.delay);
        ULong uLong3 = this.interval;
        JsonMap.Builder builderPutOpt5 = builderPutOpt4.putOpt("interval", uLong3 != null ? Long.valueOf(uLong3.getData()) : null).putOpt("campaigns", this.campaigns).putOpt("metadata", this.metadata).putOpt("product_id", this.productId).putOpt("bypass_holdout_groups", this.bypassHoldoutGroups);
        ULong uLong4 = this.editGracePeriodDays;
        JsonValue jsonValue = builderPutOpt5.putOpt("edit_grace_period", uLong4 != null ? Long.valueOf(uLong4.getData()) : null).putOpt("frequency_constraint_ids", this.frequencyConstraintIds).putOpt(Constants.MessagePayloadKeys.MESSAGE_TYPE, this.messageType).putOpt("reporting_context", this.reportingContext).putOpt("min_sdk_version", this.minSDKVersion).putOpt("queue", this.queue).put("created", DateUtils.createIso8601TimeStamp(this.created)).putOpt("additional_audience_check_overrides", this.additionalAudienceCheckOverrides).build().toJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @NotNull
    public String toString() {
        String string = toJsonValue().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AutomationSchedule.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.automation.AutomationSchedule");
        AutomationSchedule automationSchedule = (AutomationSchedule) other;
        if (Intrinsics.areEqual(this.identifier, automationSchedule.identifier) && Intrinsics.areEqual(this.triggers, automationSchedule.triggers) && Intrinsics.areEqual(this.group, automationSchedule.group) && Intrinsics.areEqual(this.priority, automationSchedule.priority) && Intrinsics.areEqual(this.limit, automationSchedule.limit) && Intrinsics.areEqual(this.startDate, automationSchedule.startDate) && Intrinsics.areEqual(this.audience, automationSchedule.audience) && Intrinsics.areEqual(this.compoundAudience, automationSchedule.compoundAudience) && Intrinsics.areEqual(this.delay, automationSchedule.delay) && Intrinsics.areEqual(this.interval, automationSchedule.interval) && Intrinsics.areEqual(this.data, automationSchedule.data) && Intrinsics.areEqual(this.bypassHoldoutGroups, automationSchedule.bypassHoldoutGroups) && Intrinsics.areEqual(this.editGracePeriodDays, automationSchedule.editGracePeriodDays) && Intrinsics.areEqual(this.frequencyConstraintIds, automationSchedule.frequencyConstraintIds) && Intrinsics.areEqual(this.messageType, automationSchedule.messageType) && Intrinsics.areEqual(this.campaigns, automationSchedule.campaigns) && Intrinsics.areEqual(this.reportingContext, automationSchedule.reportingContext) && Intrinsics.areEqual(this.productId, automationSchedule.productId) && Intrinsics.areEqual(this.minSDKVersion, automationSchedule.minSDKVersion) && this.created == automationSchedule.created && Intrinsics.areEqual(this.queue, automationSchedule.queue) && Intrinsics.areEqual(this.metadata, automationSchedule.metadata)) {
            return Intrinsics.areEqual(this.endDate, automationSchedule.endDate);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.identifier, this.triggers, this.group, this.priority, this.limit, this.startDate, this.audience, this.compoundAudience, this.delay, this.interval, this.data, this.bypassHoldoutGroups, this.editGracePeriodDays, this.frequencyConstraintIds, this.messageType, this.campaigns, this.reportingContext, this.productId, this.minSDKVersion, ULong.m3027boximpl(this.created), this.queue, this.metadata, this.endDate);
    }
}
