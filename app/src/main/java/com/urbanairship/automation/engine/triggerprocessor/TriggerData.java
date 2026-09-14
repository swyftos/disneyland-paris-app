package com.urbanairship.automation.engine.triggerprocessor;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.automation.engine.TriggerableState;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 02\u00020\u0001:\u00010BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u001cJ\r\u0010\u001d\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016J\u0015\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0006H\u0000¢\u0006\u0002\b(J\r\u0010)\u001a\u00020&H\u0000¢\u0006\u0002\b*J\r\u0010+\u001a\u00020&H\u0000¢\u0006\u0002\b,J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u0003H\u0016R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u00061"}, m1836d2 = {"Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;", "Lcom/urbanairship/json/JsonSerializable;", "scheduleId", "", "triggerId", "triggerCount", "", "children", "", "lastTriggerableState", "Lcom/urbanairship/automation/engine/TriggerableState;", "(Ljava/lang/String;Ljava/lang/String;DLjava/util/Map;Lcom/urbanairship/automation/engine/TriggerableState;)V", "getChildren", "()Ljava/util/Map;", "count", "getCount", "()D", "getLastTriggerableState$urbanairship_automation_release", "()Lcom/urbanairship/automation/engine/TriggerableState;", "setLastTriggerableState$urbanairship_automation_release", "(Lcom/urbanairship/automation/engine/TriggerableState;)V", "mutableChildren", "", "getScheduleId$urbanairship_automation_release", "()Ljava/lang/String;", "getTriggerId$urbanairship_automation_release", "childDate", "triggerID", "childDate$urbanairship_automation_release", "copy", "copy$urbanairship_automation_release", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "incrementCount", "", "value", "incrementCount$urbanairship_automation_release", "resetChildrenData", "resetChildrenData$urbanairship_automation_release", "resetCounter", "resetCounter$urbanairship_automation_release", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nTriggerData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TriggerData.kt\ncom/urbanairship/automation/engine/triggerprocessor/TriggerData\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,110:1\n372#2,7:111\n453#2:118\n403#2:119\n1238#3,4:120\n*S KotlinDebug\n*F\n+ 1 TriggerData.kt\ncom/urbanairship/automation/engine/triggerprocessor/TriggerData\n*L\n38#1:111,7\n46#1:118\n46#1:119\n46#1:120,4\n*E\n"})
public final class TriggerData implements JsonSerializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
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
    /* JADX INFO: renamed from: getScheduleId$urbanairship_automation_release, reason: from getter */
    public final String getScheduleId() {
        return this.scheduleId;
    }

    @NotNull
    /* JADX INFO: renamed from: getTriggerId$urbanairship_automation_release, reason: from getter */
    public final String getTriggerId() {
        return this.triggerId;
    }

    public /* synthetic */ TriggerData(String str, String str2, double d, Map map, TriggerableState triggerableState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : d, (i & 8) != 0 ? MapsKt.emptyMap() : map, (i & 16) != 0 ? null : triggerableState);
    }

    @Nullable
    /* JADX INFO: renamed from: getLastTriggerableState$urbanairship_automation_release, reason: from getter */
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

    /* JADX INFO: renamed from: getCount, reason: from getter */
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

    @Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m1836d2 = {"Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData$Companion;", "", "()V", "CHILDREN", "", "COUNT", "LAST_TRIGGERABLE_STATE", "SCHEDULE_ID", "TRIGGER_ID", "fromJson", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nTriggerData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TriggerData.kt\ncom/urbanairship/automation/engine/triggerprocessor/TriggerData$Companion\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,110:1\n453#2:111\n403#2:112\n1238#3,4:113\n44#4,15:117\n44#4,15:132\n44#4,15:147\n1#5:162\n*S KotlinDebug\n*F\n+ 1 TriggerData.kt\ncom/urbanairship/automation/engine/triggerprocessor/TriggerData$Companion\n*L\n66#1:111\n66#1:112\n66#1:113,4\n69#1:117,15\n70#1:132,15\n71#1:147,15\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:100:0x0292  */
        /* JADX WARN: Code duplicated, block: B:101:0x02a2  */
        /* JADX WARN: Code duplicated, block: B:103:0x02ac  */
        /* JADX WARN: Code duplicated, block: B:105:0x02b2  */
        /* JADX WARN: Code duplicated, block: B:106:0x02b6  */
        /* JADX WARN: Code duplicated, block: B:108:0x02bc  */
        /* JADX WARN: Code duplicated, block: B:110:0x02c6  */
        /* JADX WARN: Code duplicated, block: B:112:0x02cc  */
        /* JADX WARN: Code duplicated, block: B:113:0x02d0  */
        /* JADX WARN: Code duplicated, block: B:115:0x02d6  */
        /* JADX WARN: Code duplicated, block: B:117:0x02e0  */
        /* JADX WARN: Code duplicated, block: B:119:0x02e6  */
        /* JADX WARN: Code duplicated, block: B:122:0x02f2  */
        /* JADX WARN: Code duplicated, block: B:124:0x0304  */
        /* JADX WARN: Code duplicated, block: B:126:0x030a  */
        /* JADX WARN: Code duplicated, block: B:128:0x0310  */
        /* JADX WARN: Code duplicated, block: B:130:0x0316  */
        /* JADX WARN: Code duplicated, block: B:132:0x0320  */
        /* JADX WARN: Code duplicated, block: B:134:0x0326  */
        /* JADX WARN: Code duplicated, block: B:135:0x0329  */
        /* JADX WARN: Code duplicated, block: B:137:0x032f  */
        /* JADX WARN: Code duplicated, block: B:139:0x033b  */
        /* JADX WARN: Code duplicated, block: B:140:0x0347  */
        /* JADX WARN: Code duplicated, block: B:142:0x0353  */
        /* JADX WARN: Code duplicated, block: B:143:0x0363  */
        /* JADX WARN: Code duplicated, block: B:145:0x036f  */
        /* JADX WARN: Code duplicated, block: B:146:0x0381  */
        /* JADX WARN: Code duplicated, block: B:148:0x038d  */
        /* JADX WARN: Code duplicated, block: B:149:0x0399  */
        /* JADX WARN: Code duplicated, block: B:151:0x03a5  */
        /* JADX WARN: Code duplicated, block: B:152:0x03b2  */
        /* JADX WARN: Code duplicated, block: B:154:0x03bc  */
        /* JADX WARN: Code duplicated, block: B:155:0x03c8  */
        /* JADX WARN: Code duplicated, block: B:157:0x03d3  */
        /* JADX WARN: Code duplicated, block: B:158:0x03e2  */
        /* JADX WARN: Code duplicated, block: B:160:0x03ec  */
        /* JADX WARN: Code duplicated, block: B:162:0x03f2  */
        /* JADX WARN: Code duplicated, block: B:163:0x03f5  */
        /* JADX WARN: Code duplicated, block: B:165:0x03fb  */
        /* JADX WARN: Code duplicated, block: B:167:0x0405  */
        /* JADX WARN: Code duplicated, block: B:169:0x040b  */
        /* JADX WARN: Code duplicated, block: B:170:0x040e  */
        /* JADX WARN: Code duplicated, block: B:172:0x0414  */
        /* JADX WARN: Code duplicated, block: B:174:0x041e  */
        /* JADX WARN: Code duplicated, block: B:176:0x0424  */
        /* JADX WARN: Code duplicated, block: B:179:0x0432  */
        /* JADX WARN: Code duplicated, block: B:181:0x043a  */
        /* JADX WARN: Code duplicated, block: B:184:0x0445  */
        /* JADX WARN: Code duplicated, block: B:186:0x044b  */
        /* JADX WARN: Code duplicated, block: B:188:0x0471  */
        /* JADX WARN: Code duplicated, block: B:190:0x048b  */
        /* JADX WARN: Code duplicated, block: B:192:0x0491  */
        /* JADX WARN: Code duplicated, block: B:194:0x04b7  */
        /* JADX WARN: Code duplicated, block: B:65:0x01b5  */
        /* JADX WARN: Code duplicated, block: B:67:0x01c3  */
        /* JADX WARN: Code duplicated, block: B:70:0x01cf  */
        /* JADX WARN: Code duplicated, block: B:72:0x01d5  */
        /* JADX WARN: Code duplicated, block: B:74:0x01df  */
        /* JADX WARN: Code duplicated, block: B:77:0x01e6  */
        /* JADX WARN: Code duplicated, block: B:79:0x01ec  */
        /* JADX WARN: Code duplicated, block: B:81:0x01f8  */
        /* JADX WARN: Code duplicated, block: B:82:0x0204  */
        /* JADX WARN: Code duplicated, block: B:84:0x0210  */
        /* JADX WARN: Code duplicated, block: B:86:0x0222  */
        /* JADX WARN: Code duplicated, block: B:88:0x022f  */
        /* JADX WARN: Code duplicated, block: B:89:0x0240  */
        /* JADX WARN: Code duplicated, block: B:91:0x024c  */
        /* JADX WARN: Code duplicated, block: B:92:0x0259  */
        /* JADX WARN: Code duplicated, block: B:94:0x0265  */
        /* JADX WARN: Code duplicated, block: B:95:0x0271  */
        /* JADX WARN: Code duplicated, block: B:97:0x027b  */
        /* JADX WARN: Code duplicated, block: B:98:0x0287  */
        /* JADX WARN: Instruction removed from duplicated block: B:186:0x044b, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:188:0x0471, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:192:0x0491, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:194:0x04b7, please report this as an issue */
        @NotNull
        public final TriggerData fromJson(@NotNull JsonValue value) throws JsonException {
            String str;
            String str2;
            String str3;
            String strOptString;
            JsonValue jsonValue;
            KClass orCreateKotlinClass;
            String str4;
            String str5;
            Object jsonValue2;
            String str6;
            Object objOptMap;
            Object objOptList;
            String str7;
            String strOptString2;
            JsonValue jsonValue3;
            KClass orCreateKotlinClass2;
            LinkedHashMap linkedHashMap;
            Object jsonValue4;
            Double dValueOf;
            Object objOptMap2;
            Object objOptList2;
            Object objOptString;
            JsonValue jsonValue5;
            TriggerableState triggerableStateFromJson;
            Object objOptString2;
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            Map<String, JsonValue> map = jsonMapRequireMap.require("children").requireMap().getMap();
            Intrinsics.checkNotNullExpressionValue(map, "getMap(...)");
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                Companion companion = TriggerData.INSTANCE;
                Object value2 = entry.getValue();
                Intrinsics.checkNotNullExpressionValue(value2, "<get-value>(...)");
                linkedHashMap2.put(key, companion.fromJson((JsonValue) value2));
            }
            JsonValue jsonValue6 = jsonMapRequireMap.get("scheduleID");
            if (jsonValue6 == null) {
                throw new JsonException("Missing required field: 'scheduleID" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue6.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            str = "null cannot be cast to non-null type kotlin.String";
                            str2 = (String) Long.valueOf(jsonValue6.getLong(0L));
                        } else {
                            str = "null cannot be cast to non-null type kotlin.String";
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                str2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue6.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                str2 = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                str2 = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                str2 = (String) Integer.valueOf(jsonValue6.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                str2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue6.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                Object objOptList3 = jsonValue6.optList();
                                if (objOptList3 == null) {
                                    throw new NullPointerException(str);
                                }
                                str2 = (String) objOptList3;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                Object objOptMap3 = jsonValue6.optMap();
                                if (objOptMap3 == null) {
                                    throw new NullPointerException(str);
                                }
                                str2 = (String) objOptMap3;
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'scheduleID" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                Object jsonValue7 = jsonValue6.getJsonValue();
                                if (jsonValue7 == null) {
                                    throw new NullPointerException(str);
                                }
                                str2 = (String) jsonValue7;
                            }
                        }
                        str3 = str2;
                    }
                    jsonValue = jsonMapRequireMap.get("triggerID");
                    if (jsonValue != null) {
                        throw new JsonException("Missing required field: 'triggerID" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString2 = jsonValue.optString();
                        if (strOptString2 == null) {
                            throw new NullPointerException(str);
                        }
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString2 = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                    str4 = "' for field '";
                                    str5 = "Invalid type '";
                                    str6 = (String) Long.valueOf(jsonValue.getLong(0L));
                                } else {
                                    str4 = "' for field '";
                                    str5 = "Invalid type '";
                                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                        str6 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                        str6 = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                        str6 = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                        str6 = (String) Integer.valueOf(jsonValue.getInt(0));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                        str6 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                        objOptList = jsonValue.optList();
                                        if (objOptList != null) {
                                            throw new NullPointerException(str);
                                        }
                                        str6 = (String) objOptList;
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                        objOptMap = jsonValue.optMap();
                                        if (objOptMap != null) {
                                            throw new NullPointerException(str);
                                        }
                                        str6 = (String) objOptMap;
                                    } else {
                                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                            throw new JsonException(str5 + String.class.getSimpleName() + str4 + "triggerID" + CoreConstants.SINGLE_QUOTE_CHAR);
                                        }
                                        jsonValue2 = jsonValue.getJsonValue();
                                        if (jsonValue2 != null) {
                                            throw new NullPointerException(str);
                                        }
                                        str6 = (String) jsonValue2;
                                    }
                                }
                                str7 = str6;
                            }
                            jsonValue3 = jsonMapRequireMap.get("count");
                            if (jsonValue3 != null) {
                                throw new JsonException("Missing required field: 'count" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Double.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                                objOptString2 = jsonValue3.optString();
                                if (objOptString2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                                }
                                dValueOf = (Double) objOptString2;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                        dValueOf = (Double) Boolean.valueOf(jsonValue3.getBoolean(false));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                        linkedHashMap = linkedHashMap2;
                                        dValueOf = (Double) Long.valueOf(jsonValue3.getLong(0L));
                                    } else {
                                        linkedHashMap = linkedHashMap2;
                                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                            dValueOf = (Double) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                            dValueOf = Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                            dValueOf = (Double) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                            dValueOf = (Double) Integer.valueOf(jsonValue3.getInt(0));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                            dValueOf = (Double) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                            objOptList2 = jsonValue3.optList();
                                            if (objOptList2 != null) {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                                            }
                                            dValueOf = (Double) objOptList2;
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                            objOptMap2 = jsonValue3.optMap();
                                            if (objOptMap2 != null) {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                                            }
                                            dValueOf = (Double) objOptMap2;
                                        } else {
                                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                                throw new JsonException(str5 + Double.class.getSimpleName() + str4 + "count" + CoreConstants.SINGLE_QUOTE_CHAR);
                                            }
                                            jsonValue4 = jsonValue3.getJsonValue();
                                            if (jsonValue4 != null) {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                                            }
                                            dValueOf = (Double) jsonValue4;
                                        }
                                    }
                                    double dDoubleValue = dValueOf.doubleValue();
                                    jsonValue5 = jsonMapRequireMap.get("lastTriggerableState");
                                    if (jsonValue5 != null) {
                                        triggerableStateFromJson = TriggerableState.INSTANCE.fromJson(jsonValue5);
                                    } else {
                                        triggerableStateFromJson = null;
                                    }
                                    return new TriggerData(str3, str7, dDoubleValue, linkedHashMap, triggerableStateFromJson);
                                }
                                objOptString = jsonValue3.optString();
                                if (objOptString != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                                }
                                dValueOf = (Double) objOptString;
                            }
                            linkedHashMap = linkedHashMap2;
                            double dDoubleValue2 = dValueOf.doubleValue();
                            jsonValue5 = jsonMapRequireMap.get("lastTriggerableState");
                            if (jsonValue5 != null) {
                                triggerableStateFromJson = TriggerableState.INSTANCE.fromJson(jsonValue5);
                            } else {
                                triggerableStateFromJson = null;
                            }
                            return new TriggerData(str3, str7, dDoubleValue2, linkedHashMap, triggerableStateFromJson);
                        }
                        strOptString2 = jsonValue.optString();
                        if (strOptString2 == null) {
                            throw new NullPointerException(str);
                        }
                    }
                    str7 = strOptString2;
                    str4 = "' for field '";
                    str5 = "Invalid type '";
                    jsonValue3 = jsonMapRequireMap.get("count");
                    if (jsonValue3 != null) {
                        throw new JsonException("Missing required field: 'count" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Double.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                        objOptString2 = jsonValue3.optString();
                        if (objOptString2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                        }
                        dValueOf = (Double) objOptString2;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                dValueOf = (Double) Boolean.valueOf(jsonValue3.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                linkedHashMap = linkedHashMap2;
                                dValueOf = (Double) Long.valueOf(jsonValue3.getLong(0L));
                            } else {
                                linkedHashMap = linkedHashMap2;
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    dValueOf = (Double) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    dValueOf = Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    dValueOf = (Double) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    dValueOf = (Double) Integer.valueOf(jsonValue3.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    dValueOf = (Double) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    objOptList2 = jsonValue3.optList();
                                    if (objOptList2 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                                    }
                                    dValueOf = (Double) objOptList2;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    objOptMap2 = jsonValue3.optMap();
                                    if (objOptMap2 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                                    }
                                    dValueOf = (Double) objOptMap2;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException(str5 + Double.class.getSimpleName() + str4 + "count" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue4 = jsonValue3.getJsonValue();
                                    if (jsonValue4 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                                    }
                                    dValueOf = (Double) jsonValue4;
                                }
                            }
                            double dDoubleValue3 = dValueOf.doubleValue();
                            jsonValue5 = jsonMapRequireMap.get("lastTriggerableState");
                            if (jsonValue5 != null) {
                                triggerableStateFromJson = TriggerableState.INSTANCE.fromJson(jsonValue5);
                            } else {
                                triggerableStateFromJson = null;
                            }
                            return new TriggerData(str3, str7, dDoubleValue3, linkedHashMap, triggerableStateFromJson);
                        }
                        objOptString = jsonValue3.optString();
                        if (objOptString != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                        }
                        dValueOf = (Double) objOptString;
                    }
                    linkedHashMap = linkedHashMap2;
                    double dDoubleValue4 = dValueOf.doubleValue();
                    jsonValue5 = jsonMapRequireMap.get("lastTriggerableState");
                    if (jsonValue5 != null) {
                        triggerableStateFromJson = TriggerableState.INSTANCE.fromJson(jsonValue5);
                    } else {
                        triggerableStateFromJson = null;
                    }
                    return new TriggerData(str3, str7, dDoubleValue4, linkedHashMap, triggerableStateFromJson);
                }
                strOptString = jsonValue6.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
            str3 = strOptString;
            str = "null cannot be cast to non-null type kotlin.String";
            jsonValue = jsonMapRequireMap.get("triggerID");
            if (jsonValue != null) {
                throw new JsonException("Missing required field: 'triggerID" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString2 = jsonValue.optString();
                if (strOptString2 == null) {
                    throw new NullPointerException(str);
                }
            } else {
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString2 = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            str4 = "' for field '";
                            str5 = "Invalid type '";
                            str6 = (String) Long.valueOf(jsonValue.getLong(0L));
                        } else {
                            str4 = "' for field '";
                            str5 = "Invalid type '";
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                str6 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                str6 = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                str6 = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                str6 = (String) Integer.valueOf(jsonValue.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                str6 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList = jsonValue.optList();
                                if (objOptList != null) {
                                    throw new NullPointerException(str);
                                }
                                str6 = (String) objOptList;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap = jsonValue.optMap();
                                if (objOptMap != null) {
                                    throw new NullPointerException(str);
                                }
                                str6 = (String) objOptMap;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException(str5 + String.class.getSimpleName() + str4 + "triggerID" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue2 = jsonValue.getJsonValue();
                                if (jsonValue2 != null) {
                                    throw new NullPointerException(str);
                                }
                                str6 = (String) jsonValue2;
                            }
                        }
                        str7 = str6;
                    }
                    jsonValue3 = jsonMapRequireMap.get("count");
                    if (jsonValue3 != null) {
                        throw new JsonException("Missing required field: 'count" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Double.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                        objOptString2 = jsonValue3.optString();
                        if (objOptString2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                        }
                        dValueOf = (Double) objOptString2;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                dValueOf = (Double) Boolean.valueOf(jsonValue3.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                linkedHashMap = linkedHashMap2;
                                dValueOf = (Double) Long.valueOf(jsonValue3.getLong(0L));
                            } else {
                                linkedHashMap = linkedHashMap2;
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    dValueOf = (Double) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    dValueOf = Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    dValueOf = (Double) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    dValueOf = (Double) Integer.valueOf(jsonValue3.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    dValueOf = (Double) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    objOptList2 = jsonValue3.optList();
                                    if (objOptList2 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                                    }
                                    dValueOf = (Double) objOptList2;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    objOptMap2 = jsonValue3.optMap();
                                    if (objOptMap2 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                                    }
                                    dValueOf = (Double) objOptMap2;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException(str5 + Double.class.getSimpleName() + str4 + "count" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue4 = jsonValue3.getJsonValue();
                                    if (jsonValue4 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                                    }
                                    dValueOf = (Double) jsonValue4;
                                }
                            }
                            double dDoubleValue5 = dValueOf.doubleValue();
                            jsonValue5 = jsonMapRequireMap.get("lastTriggerableState");
                            if (jsonValue5 != null) {
                                triggerableStateFromJson = TriggerableState.INSTANCE.fromJson(jsonValue5);
                            } else {
                                triggerableStateFromJson = null;
                            }
                            return new TriggerData(str3, str7, dDoubleValue5, linkedHashMap, triggerableStateFromJson);
                        }
                        objOptString = jsonValue3.optString();
                        if (objOptString != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                        }
                        dValueOf = (Double) objOptString;
                    }
                    linkedHashMap = linkedHashMap2;
                    double dDoubleValue6 = dValueOf.doubleValue();
                    jsonValue5 = jsonMapRequireMap.get("lastTriggerableState");
                    if (jsonValue5 != null) {
                        triggerableStateFromJson = TriggerableState.INSTANCE.fromJson(jsonValue5);
                    } else {
                        triggerableStateFromJson = null;
                    }
                    return new TriggerData(str3, str7, dDoubleValue6, linkedHashMap, triggerableStateFromJson);
                }
                strOptString2 = jsonValue.optString();
                if (strOptString2 == null) {
                    throw new NullPointerException(str);
                }
            }
            str7 = strOptString2;
            str4 = "' for field '";
            str5 = "Invalid type '";
            jsonValue3 = jsonMapRequireMap.get("count");
            if (jsonValue3 != null) {
                throw new JsonException("Missing required field: 'count" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Double.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                objOptString2 = jsonValue3.optString();
                if (objOptString2 != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                }
                dValueOf = (Double) objOptString2;
            } else {
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        dValueOf = (Double) Boolean.valueOf(jsonValue3.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        linkedHashMap = linkedHashMap2;
                        dValueOf = (Double) Long.valueOf(jsonValue3.getLong(0L));
                    } else {
                        linkedHashMap = linkedHashMap2;
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            dValueOf = (Double) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            dValueOf = Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            dValueOf = (Double) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            dValueOf = (Double) Integer.valueOf(jsonValue3.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            dValueOf = (Double) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            objOptList2 = jsonValue3.optList();
                            if (objOptList2 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                            }
                            dValueOf = (Double) objOptList2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            objOptMap2 = jsonValue3.optMap();
                            if (objOptMap2 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                            }
                            dValueOf = (Double) objOptMap2;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException(str5 + Double.class.getSimpleName() + str4 + "count" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonValue4 = jsonValue3.getJsonValue();
                            if (jsonValue4 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                            }
                            dValueOf = (Double) jsonValue4;
                        }
                    }
                    double dDoubleValue7 = dValueOf.doubleValue();
                    jsonValue5 = jsonMapRequireMap.get("lastTriggerableState");
                    if (jsonValue5 != null) {
                        triggerableStateFromJson = TriggerableState.INSTANCE.fromJson(jsonValue5);
                    } else {
                        triggerableStateFromJson = null;
                    }
                    return new TriggerData(str3, str7, dDoubleValue7, linkedHashMap, triggerableStateFromJson);
                }
                objOptString = jsonValue3.optString();
                if (objOptString != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                }
                dValueOf = (Double) objOptString;
            }
            linkedHashMap = linkedHashMap2;
            double dDoubleValue8 = dValueOf.doubleValue();
            jsonValue5 = jsonMapRequireMap.get("lastTriggerableState");
            if (jsonValue5 != null) {
                triggerableStateFromJson = TriggerableState.INSTANCE.fromJson(jsonValue5);
            } else {
                triggerableStateFromJson = null;
            }
            return new TriggerData(str3, str7, dDoubleValue8, linkedHashMap, triggerableStateFromJson);
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* JADX INFO: renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("scheduleID", this.scheduleId), TuplesKt.m1842to("triggerID", this.triggerId), TuplesKt.m1842to("count", Double.valueOf(getTriggerCount())), TuplesKt.m1842to("children", getChildren()), TuplesKt.m1842to("lastTriggerableState", this.lastTriggerableState)).getJsonValue();
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
