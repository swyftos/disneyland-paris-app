package com.urbanairship.automation.storage;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.UALog;
import com.urbanairship.automation.AutomationAppState;
import com.urbanairship.automation.AutomationAudience;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001-B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u001dH\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020*H\u0080@¢\u0006\u0004\b+\u0010,R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, m1836d2 = {"Lcom/urbanairship/automation/storage/AutomationStoreMigrator;", "", "legacyDatabase", "Lcom/urbanairship/automation/storage/AutomationDatabase;", "store", "Lcom/urbanairship/automation/engine/AutomationStoreInterface;", "(Lcom/urbanairship/automation/storage/AutomationDatabase;Lcom/urbanairship/automation/engine/AutomationStoreInterface;)V", "convert", "", "Lcom/urbanairship/automation/storage/AutomationStoreMigrator$Converted;", "fullSchedules", "Lcom/urbanairship/automation/storage/FullSchedule;", "convertLegacyType", "Lcom/urbanairship/automation/EventAutomationTriggerType;", "legacyType", "", "convertScheduleState", "Lcom/urbanairship/automation/engine/AutomationScheduleState;", "scheduleState", "convertTriggers", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;", "triggers", "Lcom/urbanairship/automation/storage/TriggerEntity;", "getDelay", "Lcom/urbanairship/automation/AutomationDelay;", "fullSchedule", "getPreparedScheduleInfo", "Lcom/urbanairship/automation/engine/PreparedScheduleInfo;", "schedule", "Lcom/urbanairship/automation/storage/ScheduleEntity;", "audienceCheck", "", "getScheduleData", "Lcom/urbanairship/automation/AutomationSchedule$ScheduleData;", "entity", "getTriggeringInfo", "Lcom/urbanairship/automation/engine/TriggeringInfo;", "getTriggers", "Lcom/urbanairship/automation/AutomationTrigger$Event;", "executionType", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType;", "migrateData", "", "migrateData$urbanairship_automation_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Converted", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nAutomationStoreMigrator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationStoreMigrator.kt\ncom/urbanairship/automation/storage/AutomationStoreMigrator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,241:1\n1194#2,2:242\n1222#2,4:244\n1360#2:248\n1446#2,5:249\n1603#2,9:254\n1855#2:263\n1856#2:266\n1612#2:267\n766#2:268\n857#2,2:269\n1603#2,9:271\n1855#2:280\n1856#2:282\n1612#2:283\n1603#2,9:284\n1855#2:293\n1856#2:295\n1612#2:296\n1#3:264\n1#3:265\n1#3:281\n1#3:294\n*S KotlinDebug\n*F\n+ 1 AutomationStoreMigrator.kt\ncom/urbanairship/automation/storage/AutomationStoreMigrator\n*L\n36#1:242,2\n36#1:244,4\n40#1:248\n40#1:249,5\n46#1:254,9\n46#1:263\n46#1:266\n46#1:267\n142#1:268\n142#1:269,2\n147#1:271,9\n147#1:280\n147#1:282\n147#1:283\n217#1:284,9\n217#1:293\n217#1:295\n217#1:296\n46#1:265\n147#1:281\n217#1:294\n*E\n"})
public final class AutomationStoreMigrator {
    private final AutomationDatabase legacyDatabase;
    private final AutomationStoreInterface store;

    @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
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

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object migrateData$urbanairship_automation_release(@NotNull Continuation<? super Unit> continuation) {
        AutomationStoreMigrator$migrateData$1 automationStoreMigrator$migrateData$1;
        AutomationDao scheduleDao;
        List<FullSchedule> schedules;
        List listConvert;
        AutomationDao automationDao;
        List<FullSchedule> list;
        if (continuation instanceof AutomationStoreMigrator$migrateData$1) {
            automationStoreMigrator$migrateData$1 = (AutomationStoreMigrator$migrateData$1) continuation;
            int i = automationStoreMigrator$migrateData$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                automationStoreMigrator$migrateData$1.label = i - Integer.MIN_VALUE;
            } else {
                automationStoreMigrator$migrateData$1 = new AutomationStoreMigrator$migrateData$1(this, continuation);
            }
        } else {
            automationStoreMigrator$migrateData$1 = new AutomationStoreMigrator$migrateData$1(this, continuation);
        }
        Object obj = automationStoreMigrator$migrateData$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = automationStoreMigrator$migrateData$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            scheduleDao = this.legacyDatabase.getScheduleDao();
            schedules = scheduleDao.getSchedules();
            Intrinsics.checkNotNullExpressionValue(schedules, "getSchedules(...)");
            if (schedules.isEmpty()) {
                return Unit.INSTANCE;
            }
            listConvert = convert(schedules);
            if (!listConvert.isEmpty()) {
                final LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listConvert, 10)), 16));
                for (Object obj2 : listConvert) {
                    linkedHashMap.put(((Converted) obj2).getScheduleData().getSchedule().getIdentifier(), obj2);
                }
                AutomationStoreInterface automationStoreInterface = this.store;
                List<String> list2 = CollectionsKt.toList(linkedHashMap.keySet());
                Function2<? super String, ? super AutomationScheduleData, AutomationScheduleData> function2 = new Function2() { // from class: com.urbanairship.automation.storage.AutomationStoreMigrator$migrateData$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final AutomationScheduleData invoke(String id, AutomationScheduleData automationScheduleData) {
                        Intrinsics.checkNotNullParameter(id, "id");
                        AutomationStoreMigrator.Converted converted = (AutomationStoreMigrator.Converted) linkedHashMap.get(id);
                        AutomationScheduleData scheduleData = converted != null ? converted.getScheduleData() : null;
                        if (scheduleData != null) {
                            return scheduleData;
                        }
                        throw new IllegalArgumentException("Required value was null.");
                    }
                };
                automationStoreMigrator$migrateData$1.L$0 = this;
                automationStoreMigrator$migrateData$1.L$1 = scheduleDao;
                automationStoreMigrator$migrateData$1.L$2 = schedules;
                automationStoreMigrator$migrateData$1.L$3 = listConvert;
                automationStoreMigrator$migrateData$1.label = 1;
                if (automationStoreInterface.upsertSchedules(list2, function2, automationStoreMigrator$migrateData$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            scheduleDao.deleteSchedules(schedules);
            return Unit.INSTANCE;
        }
        if (i2 == 1) {
            List list3 = (List) automationStoreMigrator$migrateData$1.L$3;
            schedules = (List) automationStoreMigrator$migrateData$1.L$2;
            AutomationDao automationDao2 = (AutomationDao) automationStoreMigrator$migrateData$1.L$1;
            AutomationStoreMigrator automationStoreMigrator = (AutomationStoreMigrator) automationStoreMigrator$migrateData$1.L$0;
            ResultKt.throwOnFailure(obj);
            scheduleDao = automationDao2;
            listConvert = list3;
            this = automationStoreMigrator;
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list = (List) automationStoreMigrator$migrateData$1.L$1;
            automationDao = (AutomationDao) automationStoreMigrator$migrateData$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        schedules = list;
        scheduleDao = automationDao;
        scheduleDao.deleteSchedules(schedules);
        return Unit.INSTANCE;
        AutomationStoreInterface automationStoreInterface2 = this.store;
        ArrayList arrayList = new ArrayList();
        Iterator it = listConvert.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((Converted) it.next()).getTriggerData());
        }
        automationStoreMigrator$migrateData$1.L$0 = scheduleDao;
        automationStoreMigrator$migrateData$1.L$1 = schedules;
        automationStoreMigrator$migrateData$1.L$2 = null;
        automationStoreMigrator$migrateData$1.L$3 = null;
        automationStoreMigrator$migrateData$1.label = 2;
        if (automationStoreInterface2.upsertTriggers(arrayList, automationStoreMigrator$migrateData$1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        automationDao = scheduleDao;
        list = schedules;
        schedules = list;
        scheduleDao = automationDao;
        scheduleDao.deleteSchedules(schedules);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:68:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:88:0x01b1 A[SYNTHETIC] */
    private final List convert(List fullSchedules) {
        String str;
        ArrayList arrayList;
        Iterator it;
        Converted converted;
        AutomationStoreMigrator automationStoreMigrator;
        Converted converted2;
        ArrayList arrayList2;
        List<String> list;
        AutomationAudience automationAudienceFromJson;
        AutomationStoreMigrator automationStoreMigrator2 = this;
        String str2 = "schedule";
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = fullSchedules.iterator();
        while (it2.hasNext()) {
            FullSchedule fullSchedule = (FullSchedule) it2.next();
            try {
                ScheduleEntity scheduleEntity = fullSchedule.schedule;
                Intrinsics.checkNotNullExpressionValue(scheduleEntity, str2);
                AutomationSchedule.ScheduleData scheduleData = automationStoreMigrator2.getScheduleData(scheduleEntity);
                if (scheduleData == null) {
                    str = str2;
                    arrayList = arrayList3;
                    it = it2;
                    converted2 = null;
                    automationStoreMigrator = automationStoreMigrator2;
                } else {
                    String str3 = fullSchedule.schedule.scheduleId;
                    List triggers = automationStoreMigrator2.getTriggers(fullSchedule, TriggerExecutionType.EXECUTION);
                    long j = fullSchedule.schedule.scheduleStart;
                    ULong uLongM5336boximpl = j >= 0 ? ULong.m5336boximpl(ULong.m5337constructorimpl(j)) : null;
                    long j2 = fullSchedule.schedule.scheduleEnd;
                    ULong uLongM5336boximpl2 = j2 >= 0 ? ULong.m5336boximpl(ULong.m5337constructorimpl(j2)) : null;
                    long jM5337constructorimpl = ULong.m5337constructorimpl(fullSchedule.schedule.newUserEvaluationDate);
                    ScheduleEntity scheduleEntity2 = fullSchedule.schedule;
                    String str4 = scheduleEntity2.group;
                    int i = scheduleEntity2.priority;
                    int i2 = scheduleEntity2.limit;
                    UInt uIntM5311boximpl = i2 >= 0 ? UInt.m5311boximpl(UInt.m5312constructorimpl(i2)) : null;
                    long jM5337constructorimpl2 = ULong.m5337constructorimpl(fullSchedule.schedule.interval);
                    AutomationDelay delay = automationStoreMigrator2.getDelay(fullSchedule);
                    JsonMap jsonMap = fullSchedule.schedule.metadata;
                    JsonValue jsonValue = jsonMap != null ? jsonMap.getJsonValue() : null;
                    ScheduleEntity scheduleEntity3 = fullSchedule.schedule;
                    JsonValue jsonValue2 = scheduleEntity3.campaigns;
                    it = it2;
                    try {
                        String str5 = str2;
                        arrayList = arrayList3;
                        try {
                            long jM5337constructorimpl3 = ULong.m5337constructorimpl(TimeUnit.MILLISECONDS.toDays(scheduleEntity3.editGracePeriod));
                            ScheduleEntity scheduleEntity4 = fullSchedule.schedule;
                            String str6 = scheduleEntity4.productId;
                            List<String> list2 = scheduleEntity4.frequencyConstraintIds;
                            if (list2 != null) {
                                Intrinsics.checkNotNull(list2);
                                if (list2.isEmpty()) {
                                    list2 = null;
                                }
                                list = list2;
                            } else {
                                list = null;
                            }
                            ScheduleEntity scheduleEntity5 = fullSchedule.schedule;
                            try {
                                String str7 = scheduleEntity5.messageType;
                                String str8 = scheduleEntity5.audience;
                                if (str8 != null) {
                                    AutomationAudience.Companion companion = AutomationAudience.INSTANCE;
                                    JsonValue string = JsonValue.parseString(str8);
                                    Intrinsics.checkNotNullExpressionValue(string, "parseString(...)");
                                    automationAudienceFromJson = companion.fromJson(string);
                                } else {
                                    automationAudienceFromJson = null;
                                }
                                ScheduleEntity scheduleEntity6 = fullSchedule.schedule;
                                boolean z = scheduleEntity6.bypassHoldoutGroups;
                                JsonValue jsonValue3 = scheduleEntity6.reportingContext;
                                Intrinsics.checkNotNull(str3);
                                AutomationSchedule automationSchedule = new AutomationSchedule(str3, triggers, str4, Integer.valueOf(i), uIntM5311boximpl, uLongM5336boximpl, uLongM5336boximpl2, automationAudienceFromJson, null, delay, ULong.m5336boximpl(jM5337constructorimpl2), scheduleData, Boolean.valueOf(z), ULong.m5336boximpl(jM5337constructorimpl3), jsonValue, list, str7, jsonValue2, jsonValue3, str6, null, jM5337constructorimpl, null, null, 13631744, null);
                                automationStoreMigrator = this;
                                try {
                                    AutomationScheduleState automationScheduleStateConvertScheduleState = automationStoreMigrator.convertScheduleState(fullSchedule.schedule.executionState);
                                    ScheduleEntity scheduleEntity7 = fullSchedule.schedule;
                                    long j3 = scheduleEntity7.executionStateChangeDate;
                                    int i3 = scheduleEntity7.count;
                                    str = str5;
                                    try {
                                        Intrinsics.checkNotNullExpressionValue(scheduleEntity7, str);
                                        TriggeringInfo triggeringInfo = automationStoreMigrator.getTriggeringInfo(scheduleEntity7);
                                        ScheduleEntity scheduleEntity8 = fullSchedule.schedule;
                                        Intrinsics.checkNotNullExpressionValue(scheduleEntity8, str);
                                        converted = null;
                                        try {
                                            PreparedScheduleInfo preparedScheduleInfo$default = getPreparedScheduleInfo$default(automationStoreMigrator, scheduleEntity8, false, 2, null);
                                            String string2 = UUID.randomUUID().toString();
                                            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                                            AutomationScheduleData automationScheduleData = new AutomationScheduleData(automationSchedule, automationScheduleStateConvertScheduleState, j3, i3, triggeringInfo, preparedScheduleInfo$default, null, string2, 64, null);
                                            List<TriggerEntity> triggers2 = fullSchedule.triggers;
                                            Intrinsics.checkNotNullExpressionValue(triggers2, "triggers");
                                            converted2 = new Converted(automationScheduleData, automationStoreMigrator.convertTriggers(triggers2));
                                        } catch (Exception e) {
                                            e = e;
                                            UALog.m1747e(e, new Function0() { // from class: com.urbanairship.automation.storage.AutomationStoreMigrator$convert$1$1
                                                @Override // kotlin.jvm.functions.Function0
                                                public final String invoke() {
                                                    return "Failed to convert schedule.";
                                                }
                                            });
                                            converted2 = converted;
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        converted = null;
                                        UALog.m1747e(e, new Function0() { // from class: com.urbanairship.automation.storage.AutomationStoreMigrator$convert$1$1
                                            @Override // kotlin.jvm.functions.Function0
                                            public final String invoke() {
                                                return "Failed to convert schedule.";
                                            }
                                        });
                                        converted2 = converted;
                                        arrayList2 = arrayList;
                                        if (converted2 != null) {
                                            arrayList2.add(converted2);
                                        }
                                        arrayList3 = arrayList2;
                                        automationStoreMigrator2 = automationStoreMigrator;
                                        str2 = str;
                                        it2 = it;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    str = str5;
                                    converted = null;
                                    UALog.m1747e(e, new Function0() { // from class: com.urbanairship.automation.storage.AutomationStoreMigrator$convert$1$1
                                        @Override // kotlin.jvm.functions.Function0
                                        public final String invoke() {
                                            return "Failed to convert schedule.";
                                        }
                                    });
                                    converted2 = converted;
                                    arrayList2 = arrayList;
                                    if (converted2 != null) {
                                        arrayList2.add(converted2);
                                    }
                                    arrayList3 = arrayList2;
                                    automationStoreMigrator2 = automationStoreMigrator;
                                    str2 = str;
                                    it2 = it;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                converted = null;
                                automationStoreMigrator = this;
                                str = str5;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            automationStoreMigrator = automationStoreMigrator2;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        automationStoreMigrator = automationStoreMigrator2;
                        str = str2;
                        arrayList = arrayList3;
                    }
                }
            } catch (Exception e7) {
                e = e7;
                str = str2;
                arrayList = arrayList3;
                it = it2;
                converted = null;
                automationStoreMigrator = automationStoreMigrator2;
            }
            arrayList2 = arrayList;
            if (converted2 != null) {
                arrayList2.add(converted2);
            }
            arrayList3 = arrayList2;
            automationStoreMigrator2 = automationStoreMigrator;
            str2 = str;
            it2 = it;
        }
        return arrayList3;
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
        UALog.m1744e("Failed to parse scheduleEntity, map is null", new Object[0]);
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

    @Metadata(m1835d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m1836d2 = {"Lcom/urbanairship/automation/storage/AutomationStoreMigrator$Converted;", "", "scheduleData", "Lcom/urbanairship/automation/engine/AutomationScheduleData;", "triggerData", "", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;", "(Lcom/urbanairship/automation/engine/AutomationScheduleData;Ljava/util/List;)V", "getScheduleData", "()Lcom/urbanairship/automation/engine/AutomationScheduleData;", "getTriggerData", "()Ljava/util/List;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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
        /* JADX INFO: renamed from: component1, reason: from getter */
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
