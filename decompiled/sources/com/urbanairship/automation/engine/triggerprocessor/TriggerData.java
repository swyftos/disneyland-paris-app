package com.urbanairship.automation.engine.triggerprocessor;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.automation.engine.TriggerableState;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 02\u00020\u0001:\u00010BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u001cJ\r\u0010\u001d\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016J\u0015\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0006H\u0000¢\u0006\u0002\b(J\r\u0010)\u001a\u00020&H\u0000¢\u0006\u0002\b*J\r\u0010+\u001a\u00020&H\u0000¢\u0006\u0002\b,J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u0003H\u0016R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u00061"}, d2 = {"Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;", "Lcom/urbanairship/json/JsonSerializable;", "scheduleId", "", "triggerId", "triggerCount", "", "children", "", "lastTriggerableState", "Lcom/urbanairship/automation/engine/TriggerableState;", "(Ljava/lang/String;Ljava/lang/String;DLjava/util/Map;Lcom/urbanairship/automation/engine/TriggerableState;)V", "getChildren", "()Ljava/util/Map;", "count", "getCount", "()D", "getLastTriggerableState$urbanairship_automation_release", "()Lcom/urbanairship/automation/engine/TriggerableState;", "setLastTriggerableState$urbanairship_automation_release", "(Lcom/urbanairship/automation/engine/TriggerableState;)V", "mutableChildren", "", "getScheduleId$urbanairship_automation_release", "()Ljava/lang/String;", "getTriggerId$urbanairship_automation_release", "childDate", "triggerID", "childDate$urbanairship_automation_release", "copy", "copy$urbanairship_automation_release", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "incrementCount", "", "value", "incrementCount$urbanairship_automation_release", "resetChildrenData", "resetChildrenData$urbanairship_automation_release", "resetCounter", "resetCounter$urbanairship_automation_release", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTriggerData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TriggerData.kt\ncom/urbanairship/automation/engine/triggerprocessor/TriggerData\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,110:1\n372#2,7:111\n453#2:118\n403#2:119\n1238#3,4:120\n*S KotlinDebug\n*F\n+ 1 TriggerData.kt\ncom/urbanairship/automation/engine/triggerprocessor/TriggerData\n*L\n38#1:111,7\n46#1:118\n46#1:119\n46#1:120,4\n*E\n"})
/* loaded from: classes5.dex */
public final class TriggerData implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private TriggerableState lastTriggerableState;
    private final Map mutableChildren;
    private final String scheduleId;
    private double triggerCount;
    private final String triggerId;

    public TriggerData(@NotNull String scheduleId, @NotNull String triggerId, double d, @NotNull Map<String, TriggerData> children, @Nullable TriggerableState triggerableState) {
        Intrinsics.checkNotNullParameter(scheduleId, "scheduleId");
        Intrinsics.checkNotNullParameter(triggerId, "triggerId");
        Intrinsics.checkNotNullParameter(children, "children");
        this.scheduleId = scheduleId;
        this.triggerId = triggerId;
        this.triggerCount = d;
        this.lastTriggerableState = triggerableState;
        this.mutableChildren = MapsKt.toMutableMap(children);
    }

    @NotNull
    /* renamed from: getScheduleId$urbanairship_automation_release, reason: from getter */
    public final String getScheduleId() {
        return this.scheduleId;
    }

    @NotNull
    /* renamed from: getTriggerId$urbanairship_automation_release, reason: from getter */
    public final String getTriggerId() {
        return this.triggerId;
    }

    public /* synthetic */ TriggerData(String str, String str2, double d, Map map, TriggerableState triggerableState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : d, (i & 8) != 0 ? MapsKt.emptyMap() : map, (i & 16) != 0 ? null : triggerableState);
    }

    @Nullable
    /* renamed from: getLastTriggerableState$urbanairship_automation_release, reason: from getter */
    public final TriggerableState getLastTriggerableState() {
        return this.lastTriggerableState;
    }

    public final void setLastTriggerableState$urbanairship_automation_release(@Nullable TriggerableState triggerableState) {
        this.lastTriggerableState = triggerableState;
    }

    @NotNull
    public final Map<String, TriggerData> getChildren() {
        return MapsKt.toMap(this.mutableChildren);
    }

    /* renamed from: getCount, reason: from getter */
    public final double getTriggerCount() {
        return this.triggerCount;
    }

    public final void incrementCount$urbanairship_automation_release(double value) {
        this.triggerCount += value;
    }

    public final void resetCounter$urbanairship_automation_release() {
        this.triggerCount = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public final void resetChildrenData$urbanairship_automation_release() {
        this.mutableChildren.clear();
    }

    @NotNull
    public final TriggerData childDate$urbanairship_automation_release(@NotNull String triggerID) {
        Intrinsics.checkNotNullParameter(triggerID, "triggerID");
        Map map = this.mutableChildren;
        Object triggerData = map.get(triggerID);
        if (triggerData == null) {
            triggerData = new TriggerData(this.scheduleId, triggerID, AudioStats.AUDIO_AMPLITUDE_NONE, null, null, 24, null);
            map.put(triggerID, triggerData);
        }
        return (TriggerData) triggerData;
    }

    @NotNull
    public final TriggerData copy$urbanairship_automation_release() {
        String str = this.scheduleId;
        String str2 = this.triggerId;
        double d = this.triggerCount;
        Map map = this.mutableChildren;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((TriggerData) entry.getValue()).copy$urbanairship_automation_release());
        }
        return new TriggerData(str, str2, d, MapsKt.toMap(linkedHashMap), this.lastTriggerableState);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData$Companion;", "", "()V", "CHILDREN", "", "COUNT", "LAST_TRIGGERABLE_STATE", "SCHEDULE_ID", "TRIGGER_ID", "fromJson", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nTriggerData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TriggerData.kt\ncom/urbanairship/automation/engine/triggerprocessor/TriggerData$Companion\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,110:1\n453#2:111\n403#2:112\n1238#3,4:113\n44#4,15:117\n44#4,15:132\n44#4,15:147\n1#5:162\n*S KotlinDebug\n*F\n+ 1 TriggerData.kt\ncom/urbanairship/automation/engine/triggerprocessor/TriggerData$Companion\n*L\n66#1:111\n66#1:112\n66#1:113,4\n69#1:117,15\n70#1:132,15\n71#1:147,15\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:122:0x02f2  */
        /* JADX WARN: Removed duplicated region for block: B:179:0x0432  */
        /* JADX WARN: Removed duplicated region for block: B:181:0x043a  */
        /* JADX WARN: Removed duplicated region for block: B:188:0x0471  */
        /* JADX WARN: Removed duplicated region for block: B:194:0x04b7  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x01b5  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.urbanairship.automation.engine.triggerprocessor.TriggerData fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r20) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 1303
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.triggerprocessor.TriggerData.Companion.fromJson(com.urbanairship.json.JsonValue):com.urbanairship.automation.engine.triggerprocessor.TriggerData");
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("scheduleID", this.scheduleId), TuplesKt.to("triggerID", this.triggerId), TuplesKt.to("count", Double.valueOf(getTriggerCount())), TuplesKt.to("children", getChildren()), TuplesKt.to("lastTriggerableState", this.lastTriggerableState)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(TriggerData.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.automation.engine.triggerprocessor.TriggerData");
        TriggerData triggerData = (TriggerData) other;
        if (Intrinsics.areEqual(this.scheduleId, triggerData.scheduleId) && Intrinsics.areEqual(this.triggerId, triggerData.triggerId) && Intrinsics.areEqual(this.lastTriggerableState, triggerData.lastTriggerableState) && getTriggerCount() == triggerData.getTriggerCount() && Intrinsics.areEqual(this.mutableChildren, triggerData.mutableChildren)) {
            return Intrinsics.areEqual(getChildren(), triggerData.getChildren());
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.scheduleId, this.triggerId, this.lastTriggerableState, Double.valueOf(getTriggerCount()), getChildren());
    }

    @NotNull
    public String toString() {
        return "TriggerData(scheduleId='" + this.scheduleId + "', triggerId='" + this.triggerId + "', triggerCount=" + this.triggerCount + ", lastTriggerableState=" + this.lastTriggerableState + ", mutableChildren=" + this.mutableChildren + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
