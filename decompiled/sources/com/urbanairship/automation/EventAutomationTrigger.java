package com.urbanairship.automation;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.dlp.BluetoothManager;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.automation.EventAutomationTriggerType;
import com.urbanairship.automation.engine.AutomationEvent;
import com.urbanairship.automation.engine.TriggerableState;
import com.urbanairship.automation.engine.triggerprocessor.MatchResult;
import com.urbanairship.automation.engine.triggerprocessor.TriggerData;
import com.urbanairship.automation.engine.triggerprocessor.TriggerExecutionType;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.VersionUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001'B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB)\b\u0000\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0001H\u0002J\u001f\u0010\u001e\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b!J\u001a\u0010\"\u001a\u0004\u0018\u00010\u00172\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020&H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006("}, d2 = {"Lcom/urbanairship/automation/EventAutomationTrigger;", "Lcom/urbanairship/json/JsonSerializable;", "type", "Lcom/urbanairship/automation/EventAutomationTriggerType;", "goal", "", "predicate", "Lcom/urbanairship/json/JsonPredicate;", "(Lcom/urbanairship/automation/EventAutomationTriggerType;DLcom/urbanairship/json/JsonPredicate;)V", "id", "", "(Ljava/lang/String;Lcom/urbanairship/automation/EventAutomationTriggerType;DLcom/urbanairship/json/JsonPredicate;)V", "getGoal", "()D", "setGoal", "(D)V", "getId", "()Ljava/lang/String;", "getPredicate", "()Lcom/urbanairship/json/JsonPredicate;", "getType", "()Lcom/urbanairship/automation/EventAutomationTriggerType;", "evaluateResults", "Lcom/urbanairship/automation/engine/triggerprocessor/MatchResult;", "data", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;", "increment", "isPredicatedMatching", "", "value", "matchEvent", "event", "Lcom/urbanairship/automation/engine/AutomationEvent;", "matchEvent$urbanairship_automation_release", "stateTriggerMatch", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/automation/engine/TriggerableState;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EventAutomationTrigger implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private double goal;
    private final String id;
    private final JsonPredicate predicate;
    private final EventAutomationTriggerType type;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventAutomationTriggerType.values().length];
            try {
                iArr[EventAutomationTriggerType.VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventAutomationTriggerType.ACTIVE_SESSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public EventAutomationTrigger(@NotNull String id, @NotNull EventAutomationTriggerType type, double d, @Nullable JsonPredicate jsonPredicate) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.type = type;
        this.goal = d;
        this.predicate = jsonPredicate;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final EventAutomationTriggerType getType() {
        return this.type;
    }

    public final double getGoal() {
        return this.goal;
    }

    public final void setGoal(double d) {
        this.goal = d;
    }

    @Nullable
    public final JsonPredicate getPredicate() {
        return this.predicate;
    }

    public /* synthetic */ EventAutomationTrigger(EventAutomationTriggerType eventAutomationTriggerType, double d, JsonPredicate jsonPredicate, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventAutomationTriggerType, d, (i & 4) != 0 ? null : jsonPredicate);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public EventAutomationTrigger(@NotNull EventAutomationTriggerType type, double d, @Nullable JsonPredicate jsonPredicate) {
        Intrinsics.checkNotNullParameter(type, "type");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this(string, type, d, jsonPredicate);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/automation/EventAutomationTrigger$Companion;", "", "()V", "KEY_GOAL", "", "KEY_ID", "KEY_PREDICATE", "KEY_TYPE", "fromJson", "Lcom/urbanairship/automation/EventAutomationTrigger;", "value", "Lcom/urbanairship/json/JsonValue;", "executionType", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAutomationTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationTrigger.kt\ncom/urbanairship/automation/EventAutomationTrigger$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,574:1\n44#2,15:575\n44#2,15:590\n79#2,16:606\n1#3:605\n*S KotlinDebug\n*F\n+ 1 AutomationTrigger.kt\ncom/urbanairship/automation/EventAutomationTrigger$Companion\n*L\n328#1:575,15\n331#1:590,15\n335#1:606,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final EventAutomationTrigger fromJson(@NotNull JsonValue value, @NotNull TriggerExecutionType executionType) throws JsonException {
            String strOptString;
            Double dValueOf;
            String strOptString2;
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(executionType, "executionType");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            EventAutomationTriggerType.Companion companion = EventAutomationTriggerType.INSTANCE;
            JsonValue jsonValue = jsonMapRequireMap.get("type");
            if (jsonValue == null) {
                throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
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
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue2 = jsonValue.getJsonValue();
                if (jsonValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue2;
            }
            EventAutomationTriggerType eventAutomationTriggerTypeFrom = companion.from(strOptString);
            if (eventAutomationTriggerTypeFrom == null) {
                throw new JsonException("invalid compound trigger type " + jsonMapRequireMap);
            }
            JsonValue jsonValue3 = jsonMapRequireMap.get("goal");
            if (jsonValue3 == null) {
                throw new JsonException("Missing required field: 'goal" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Double.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString = jsonValue3.optString();
                if (objOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                }
                dValueOf = (Double) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString2 = jsonValue3.optString();
                if (objOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                }
                dValueOf = (Double) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                dValueOf = (Double) Boolean.valueOf(jsonValue3.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                dValueOf = (Double) Long.valueOf(jsonValue3.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                dValueOf = (Double) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                dValueOf = Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                dValueOf = (Double) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                dValueOf = (Double) Integer.valueOf(jsonValue3.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                dValueOf = (Double) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList2 = jsonValue3.optList();
                if (objOptList2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                }
                dValueOf = (Double) objOptList2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap2 = jsonValue3.optMap();
                if (objOptMap2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                }
                dValueOf = (Double) objOptMap2;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + Double.class.getSimpleName() + "' for field 'goal" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue4 = jsonValue3.getJsonValue();
                if (jsonValue4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                }
                dValueOf = (Double) jsonValue4;
            }
            double dDoubleValue = dValueOf.doubleValue();
            JsonValue jsonValue5 = jsonMapRequireMap.get("predicate");
            String str = null;
            JsonPredicate jsonPredicate = jsonValue5 != null ? JsonPredicate.parse(jsonValue5) : null;
            JsonValue jsonValue6 = jsonMapRequireMap.get("id");
            if (jsonValue6 != null) {
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString2 = jsonValue6.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString2 = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString2 = (String) Long.valueOf(jsonValue6.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString2 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue6.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString2 = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString2 = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    strOptString2 = (String) Integer.valueOf(jsonValue6.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString2 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue6.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    strOptString2 = (String) jsonValue6.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    strOptString2 = (String) jsonValue6.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'id" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    strOptString2 = (String) jsonValue6.getJsonValue();
                }
                str = strOptString2;
            }
            return new EventAutomationTrigger(str == null ? AutomationTrigger.INSTANCE.generateStableId$urbanairship_automation_release(eventAutomationTriggerTypeFrom.getValue(), dDoubleValue, jsonPredicate, executionType) : str, eventAutomationTriggerTypeFrom, dDoubleValue, jsonPredicate);
        }
    }

    @Nullable
    public final MatchResult matchEvent$urbanairship_automation_release(@NotNull AutomationEvent event, @NotNull TriggerData data) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(data, "data");
        if (event instanceof AutomationEvent.StateChanged) {
            return stateTriggerMatch(((AutomationEvent.StateChanged) event).getState(), data);
        }
        if (!(event instanceof AutomationEvent.Event)) {
            throw new NoWhenBranchMatchedException();
        }
        AutomationEvent.Event event2 = (AutomationEvent.Event) event;
        if (event2.getTriggerType() != this.type) {
            return null;
        }
        JsonValue NULL = event2.getData();
        if (NULL == null) {
            NULL = JsonValue.NULL;
            Intrinsics.checkNotNullExpressionValue(NULL, "NULL");
        }
        if (isPredicatedMatching(NULL)) {
            return evaluateResults(data, event2.getValue());
        }
        return null;
    }

    private final MatchResult stateTriggerMatch(TriggerableState state, TriggerData data) {
        String appSessionID;
        int i = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (i != 1) {
            if (i != 2 || (appSessionID = state.getAppSessionID()) == null) {
                return null;
            }
            TriggerableState lastTriggerableState = data.getLastTriggerableState();
            if (Intrinsics.areEqual(appSessionID, lastTriggerableState != null ? lastTriggerableState.getAppSessionID() : null)) {
                return null;
            }
            data.setLastTriggerableState$urbanairship_automation_release(state);
            return evaluateResults(data, 1.0d);
        }
        String versionUpdated = state.getVersionUpdated();
        if (versionUpdated == null) {
            return null;
        }
        TriggerableState lastTriggerableState2 = data.getLastTriggerableState();
        if (Intrinsics.areEqual(versionUpdated, lastTriggerableState2 != null ? lastTriggerableState2.getVersionUpdated() : null)) {
            return null;
        }
        JsonSerializable jsonSerializableCreateVersionObject = VersionUtils.createVersionObject(Long.parseLong(versionUpdated));
        Intrinsics.checkNotNullExpressionValue(jsonSerializableCreateVersionObject, "createVersionObject(...)");
        if (!isPredicatedMatching(jsonSerializableCreateVersionObject)) {
            return null;
        }
        data.setLastTriggerableState$urbanairship_automation_release(state);
        return evaluateResults(data, 1.0d);
    }

    private final boolean isPredicatedMatching(JsonSerializable value) {
        JsonPredicate jsonPredicate = this.predicate;
        if (jsonPredicate != null) {
            return jsonPredicate.apply(value);
        }
        return true;
    }

    private final MatchResult evaluateResults(TriggerData data, double increment) {
        data.incrementCount$urbanairship_automation_release(increment);
        return new MatchResult(this.id, data.getTriggerCount() >= this.goal);
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("id", this.id), TuplesKt.to("type", this.type), TuplesKt.to("goal", Double.valueOf(this.goal)), TuplesKt.to("predicate", this.predicate)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
