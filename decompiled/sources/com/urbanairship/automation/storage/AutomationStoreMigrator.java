package com.urbanairship.automation.storage;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.UALog;
import com.urbanairship.automation.AutomationAppState;
import com.urbanairship.automation.AutomationDelay;
import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.automation.AutomationTrigger;
import com.urbanairship.automation.EventAutomationTrigger;
import com.urbanairship.automation.EventAutomationTriggerType;
import com.urbanairship.automation.engine.AutomationScheduleData;
import com.urbanairship.automation.engine.AutomationScheduleState;
import com.urbanairship.automation.engine.AutomationStoreInterface;
import com.urbanairship.automation.engine.PreparedScheduleInfo;
import com.urbanairship.automation.engine.TriggeringInfo;
import com.urbanairship.automation.engine.triggerprocessor.TriggerData;
import com.urbanairship.automation.engine.triggerprocessor.TriggerExecutionType;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001-B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u001dH\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020*H\u0080@¢\u0006\u0004\b+\u0010,R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/urbanairship/automation/storage/AutomationStoreMigrator;", "", "legacyDatabase", "Lcom/urbanairship/automation/storage/AutomationDatabase;", "store", "Lcom/urbanairship/automation/engine/AutomationStoreInterface;", "(Lcom/urbanairship/automation/storage/AutomationDatabase;Lcom/urbanairship/automation/engine/AutomationStoreInterface;)V", "convert", "", "Lcom/urbanairship/automation/storage/AutomationStoreMigrator$Converted;", "fullSchedules", "Lcom/urbanairship/automation/storage/FullSchedule;", "convertLegacyType", "Lcom/urbanairship/automation/EventAutomationTriggerType;", "legacyType", "", "convertScheduleState", "Lcom/urbanairship/automation/engine/AutomationScheduleState;", "scheduleState", "convertTriggers", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;", "triggers", "Lcom/urbanairship/automation/storage/TriggerEntity;", "getDelay", "Lcom/urbanairship/automation/AutomationDelay;", "fullSchedule", "getPreparedScheduleInfo", "Lcom/urbanairship/automation/engine/PreparedScheduleInfo;", "schedule", "Lcom/urbanairship/automation/storage/ScheduleEntity;", "audienceCheck", "", "getScheduleData", "Lcom/urbanairship/automation/AutomationSchedule$ScheduleData;", "entity", "getTriggeringInfo", "Lcom/urbanairship/automation/engine/TriggeringInfo;", "getTriggers", "Lcom/urbanairship/automation/AutomationTrigger$Event;", "executionType", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType;", "migrateData", "", "migrateData$urbanairship_automation_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Converted", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAutomationStoreMigrator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationStoreMigrator.kt\ncom/urbanairship/automation/storage/AutomationStoreMigrator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,241:1\n1194#2,2:242\n1222#2,4:244\n1360#2:248\n1446#2,5:249\n1603#2,9:254\n1855#2:263\n1856#2:266\n1612#2:267\n766#2:268\n857#2,2:269\n1603#2,9:271\n1855#2:280\n1856#2:282\n1612#2:283\n1603#2,9:284\n1855#2:293\n1856#2:295\n1612#2:296\n1#3:264\n1#3:265\n1#3:281\n1#3:294\n*S KotlinDebug\n*F\n+ 1 AutomationStoreMigrator.kt\ncom/urbanairship/automation/storage/AutomationStoreMigrator\n*L\n36#1:242,2\n36#1:244,4\n40#1:248\n40#1:249,5\n46#1:254,9\n46#1:263\n46#1:266\n46#1:267\n142#1:268\n142#1:269,2\n147#1:271,9\n147#1:280\n147#1:282\n147#1:283\n217#1:284,9\n217#1:293\n217#1:295\n217#1:296\n46#1:265\n147#1:281\n217#1:294\n*E\n"})
/* loaded from: classes5.dex */
public final class AutomationStoreMigrator {
    private final AutomationDatabase legacyDatabase;
    private final AutomationStoreInterface store;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TriggerExecutionType.values().length];
            try {
                iArr[TriggerExecutionType.EXECUTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TriggerExecutionType.DELAY_CANCELLATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AutomationStoreMigrator(@NotNull AutomationDatabase legacyDatabase, @NotNull AutomationStoreInterface store) {
        Intrinsics.checkNotNullParameter(legacyDatabase, "legacyDatabase");
        Intrinsics.checkNotNullParameter(store, "store");
        this.legacyDatabase = legacyDatabase;
        this.store = store;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object migrateData$urbanairship_automation_release(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.storage.AutomationStoreMigrator.migrateData$urbanairship_automation_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List convert(java.util.List r51) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.storage.AutomationStoreMigrator.convert(java.util.List):java.util.List");
    }

    private final AutomationSchedule.ScheduleData getScheduleData(ScheduleEntity entity) throws Exception {
        JsonMap map = entity.data.getMap();
        if (map != null) {
            JsonMap.Builder builderPutAll = JsonMap.newBuilder().putAll(map);
            Intrinsics.checkNotNullExpressionValue(builderPutAll, "putAll(...)");
            builderPutAll.put("type", JsonValue.wrap(entity.scheduleType));
            if (Intrinsics.areEqual(entity.scheduleType, AutomationSchedule.ScheduleType.IN_APP_MESSAGE.getJson())) {
                builderPutAll.put("message", map);
            }
            if (Intrinsics.areEqual(entity.scheduleType, AutomationSchedule.ScheduleType.DEFERRED.getJson())) {
                builderPutAll.put("deferred", map);
            }
            if (Intrinsics.areEqual(entity.scheduleType, AutomationSchedule.ScheduleType.ACTIONS.getJson())) {
                builderPutAll.put("actions", map);
            }
            AutomationSchedule.ScheduleData.Companion companion = AutomationSchedule.ScheduleData.INSTANCE;
            JsonValue jsonValue = builderPutAll.build().getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return companion.fromJson$urbanairship_automation_release(jsonValue);
        }
        UALog.e("Failed to parse scheduleEntity, map is null", new Object[0]);
        throw new Exception();
    }

    private final AutomationDelay getDelay(FullSchedule fullSchedule) {
        AutomationAppState automationAppState;
        AutomationAppState automationAppState2;
        Long lValueOf = Long.valueOf(fullSchedule.schedule.seconds);
        List<String> list = fullSchedule.schedule.screens;
        List<String> list2 = list.isEmpty() ? null : list;
        ScheduleEntity scheduleEntity = fullSchedule.schedule;
        String str = scheduleEntity.regionId;
        final int i = scheduleEntity.appState;
        if (i == 1) {
            automationAppState = null;
        } else {
            if (i == 2) {
                automationAppState2 = AutomationAppState.FOREGROUND;
            } else if (i == 3) {
                automationAppState2 = AutomationAppState.BACKGROUND;
            } else {
                UALog.e$default(null, new Function0() { // from class: com.urbanairship.automation.storage.AutomationStoreMigrator$getDelay$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Unexpected app state " + i + ' ';
                    }
                }, 1, null);
                automationAppState = null;
            }
            automationAppState = automationAppState2;
        }
        List triggers = getTriggers(fullSchedule, TriggerExecutionType.DELAY_CANCELLATION);
        return new AutomationDelay(lValueOf, list2, null, str, automationAppState, triggers.isEmpty() ? null : triggers, 4, null);
    }

    private final List getTriggers(FullSchedule fullSchedule, TriggerExecutionType executionType) {
        List<TriggerEntity> triggers = fullSchedule.triggers;
        Intrinsics.checkNotNullExpressionValue(triggers, "triggers");
        ArrayList<TriggerEntity> arrayList = new ArrayList();
        for (Object obj : triggers) {
            TriggerEntity triggerEntity = (TriggerEntity) obj;
            int i = WhenMappings.$EnumSwitchMapping$0[executionType.ordinal()];
            boolean z = true;
            if (i == 1) {
                if (triggerEntity.isCancellation) {
                    z = false;
                }
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                z = triggerEntity.isCancellation;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (TriggerEntity triggerEntity2 : arrayList) {
            EventAutomationTriggerType eventAutomationTriggerTypeConvertLegacyType = convertLegacyType(triggerEntity2.triggerType);
            AutomationTrigger.Event event = eventAutomationTriggerTypeConvertLegacyType == null ? null : new AutomationTrigger.Event(new EventAutomationTrigger(AutomationTrigger.INSTANCE.generateStableId$urbanairship_automation_release(eventAutomationTriggerTypeConvertLegacyType.getValue(), triggerEntity2.goal, triggerEntity2.jsonPredicate, executionType), eventAutomationTriggerTypeConvertLegacyType, triggerEntity2.goal, triggerEntity2.jsonPredicate));
            if (event != null) {
                arrayList2.add(event);
            }
        }
        return arrayList2;
    }

    private final EventAutomationTriggerType convertLegacyType(int legacyType) {
        switch (legacyType) {
            case 1:
                return EventAutomationTriggerType.FOREGROUND;
            case 2:
                return EventAutomationTriggerType.BACKGROUND;
            case 3:
                return EventAutomationTriggerType.REGION_ENTER;
            case 4:
                return EventAutomationTriggerType.REGION_EXIT;
            case 5:
                return EventAutomationTriggerType.CUSTOM_EVENT_COUNT;
            case 6:
                return EventAutomationTriggerType.CUSTOM_EVENT_VALUE;
            case 7:
                return EventAutomationTriggerType.SCREEN;
            case 8:
                return EventAutomationTriggerType.APP_INIT;
            case 9:
                return EventAutomationTriggerType.ACTIVE_SESSION;
            case 10:
                return EventAutomationTriggerType.VERSION;
            case 11:
                return EventAutomationTriggerType.FEATURE_FLAG_INTERACTION;
            default:
                return null;
        }
    }

    private final TriggeringInfo getTriggeringInfo(ScheduleEntity schedule) {
        return new TriggeringInfo(null, schedule.triggeredTime);
    }

    static /* synthetic */ PreparedScheduleInfo getPreparedScheduleInfo$default(AutomationStoreMigrator automationStoreMigrator, ScheduleEntity scheduleEntity, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return automationStoreMigrator.getPreparedScheduleInfo(scheduleEntity, z);
    }

    private final PreparedScheduleInfo getPreparedScheduleInfo(ScheduleEntity schedule, boolean audienceCheck) {
        int i = schedule.executionState;
        if (i != 6 && i != 2) {
            return null;
        }
        String scheduleId = schedule.scheduleId;
        Intrinsics.checkNotNullExpressionValue(scheduleId, "scheduleId");
        String str = schedule.productId;
        JsonValue jsonValue = schedule.campaigns;
        JsonValue jsonValue2 = schedule.reportingContext;
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return new PreparedScheduleInfo(scheduleId, str, jsonValue, null, null, jsonValue2, string, audienceCheck, schedule.priority);
    }

    private final AutomationScheduleState convertScheduleState(int scheduleState) {
        switch (scheduleState) {
            case 0:
                return AutomationScheduleState.IDLE;
            case 1:
                return AutomationScheduleState.PREPARED;
            case 2:
                return AutomationScheduleState.EXECUTING;
            case 3:
                return AutomationScheduleState.PAUSED;
            case 4:
                return AutomationScheduleState.FINISHED;
            case 5:
                return AutomationScheduleState.PREPARED;
            case 6:
                return AutomationScheduleState.PREPARED;
            default:
                return AutomationScheduleState.FINISHED;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/automation/storage/AutomationStoreMigrator$Converted;", "", "scheduleData", "Lcom/urbanairship/automation/engine/AutomationScheduleData;", "triggerData", "", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;", "(Lcom/urbanairship/automation/engine/AutomationScheduleData;Ljava/util/List;)V", "getScheduleData", "()Lcom/urbanairship/automation/engine/AutomationScheduleData;", "getTriggerData", "()Ljava/util/List;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Converted {
        private final AutomationScheduleData scheduleData;
        private final List triggerData;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Converted copy$default(Converted converted, AutomationScheduleData automationScheduleData, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                automationScheduleData = converted.scheduleData;
            }
            if ((i & 2) != 0) {
                list = converted.triggerData;
            }
            return converted.copy(automationScheduleData, list);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final AutomationScheduleData getScheduleData() {
            return this.scheduleData;
        }

        @NotNull
        public final List<TriggerData> component2() {
            return this.triggerData;
        }

        @NotNull
        public final Converted copy(@NotNull AutomationScheduleData scheduleData, @NotNull List<TriggerData> triggerData) {
            Intrinsics.checkNotNullParameter(scheduleData, "scheduleData");
            Intrinsics.checkNotNullParameter(triggerData, "triggerData");
            return new Converted(scheduleData, triggerData);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Converted)) {
                return false;
            }
            Converted converted = (Converted) other;
            return Intrinsics.areEqual(this.scheduleData, converted.scheduleData) && Intrinsics.areEqual(this.triggerData, converted.triggerData);
        }

        public int hashCode() {
            return (this.scheduleData.hashCode() * 31) + this.triggerData.hashCode();
        }

        @NotNull
        public String toString() {
            return "Converted(scheduleData=" + this.scheduleData + ", triggerData=" + this.triggerData + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Converted(@NotNull AutomationScheduleData scheduleData, @NotNull List<TriggerData> triggerData) {
            Intrinsics.checkNotNullParameter(scheduleData, "scheduleData");
            Intrinsics.checkNotNullParameter(triggerData, "triggerData");
            this.scheduleData = scheduleData;
            this.triggerData = triggerData;
        }

        @NotNull
        public final AutomationScheduleData getScheduleData() {
            return this.scheduleData;
        }

        @NotNull
        public final List<TriggerData> getTriggerData() {
            return this.triggerData;
        }
    }

    private final List convertTriggers(List triggers) {
        TriggerExecutionType triggerExecutionType;
        TriggerData triggerData;
        ArrayList arrayList = new ArrayList();
        Iterator it = triggers.iterator();
        while (it.hasNext()) {
            TriggerEntity triggerEntity = (TriggerEntity) it.next();
            EventAutomationTriggerType eventAutomationTriggerTypeConvertLegacyType = convertLegacyType(triggerEntity.triggerType);
            if (eventAutomationTriggerTypeConvertLegacyType == null) {
                triggerData = null;
            } else {
                if (triggerEntity.isCancellation) {
                    triggerExecutionType = TriggerExecutionType.DELAY_CANCELLATION;
                } else {
                    triggerExecutionType = TriggerExecutionType.EXECUTION;
                }
                TriggerExecutionType triggerExecutionType2 = triggerExecutionType;
                String parentScheduleId = triggerEntity.parentScheduleId;
                Intrinsics.checkNotNullExpressionValue(parentScheduleId, "parentScheduleId");
                triggerData = new TriggerData(parentScheduleId, AutomationTrigger.INSTANCE.generateStableId$urbanairship_automation_release(eventAutomationTriggerTypeConvertLegacyType.getValue(), triggerEntity.goal, triggerEntity.jsonPredicate, triggerExecutionType2), triggerEntity.progress, MapsKt.emptyMap(), null);
            }
            if (triggerData != null) {
                arrayList.add(triggerData);
            }
        }
        return arrayList;
    }
}
