package com.urbanairship.automation;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.automation.AutomationTrigger;
import com.urbanairship.automation.engine.AutomationEvent;
import com.urbanairship.automation.engine.triggerprocessor.MatchResult;
import com.urbanairship.automation.engine.triggerprocessor.TriggerData;
import com.urbanairship.automation.engine.triggerprocessor.TriggerExecutionType;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0002#$B-\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001d\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001eJ\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lcom/urbanairship/automation/CompoundAutomationTrigger;", "Lcom/urbanairship/json/JsonSerializable;", "id", "", "type", "Lcom/urbanairship/automation/CompoundAutomationTriggerType;", "goal", "", "children", "", "Lcom/urbanairship/automation/CompoundAutomationTrigger$Child;", "(Ljava/lang/String;Lcom/urbanairship/automation/CompoundAutomationTriggerType;DLjava/util/List;)V", "getChildren$urbanairship_automation_release", "()Ljava/util/List;", "getGoal", "()D", "getId", "()Ljava/lang/String;", "getType", "()Lcom/urbanairship/automation/CompoundAutomationTriggerType;", "matchChildren", "Lcom/urbanairship/automation/engine/triggerprocessor/MatchResult;", "event", "Lcom/urbanairship/automation/engine/AutomationEvent;", "data", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;", "matchEvent", "matchEvent$urbanairship_automation_release", "removeStaleChildData", "", "removeStaleChildData$urbanairship_automation_release", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "triggeredChildrenCount", "", "Child", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAutomationTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationTrigger.kt\ncom/urbanairship/automation/CompoundAutomationTrigger\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,574:1\n1726#2,3:575\n1855#2,2:578\n1747#2,3:580\n1855#2,2:583\n1549#2:585\n1620#2,3:586\n766#2:589\n857#2,2:590\n1855#2,2:592\n*S KotlinDebug\n*F\n+ 1 AutomationTrigger.kt\ncom/urbanairship/automation/CompoundAutomationTrigger\n*L\n461#1:575,3\n464#1:578,2\n474#1:580,3\n476#1:583,2\n496#1:585\n496#1:586,3\n520#1:589\n520#1:590,2\n568#1:592,2\n*E\n"})
/* loaded from: classes5.dex */
public final class CompoundAutomationTrigger implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final List children;
    private final double goal;
    private final String id;
    private final CompoundAutomationTriggerType type;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CompoundAutomationTriggerType.values().length];
            try {
                iArr[CompoundAutomationTriggerType.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CompoundAutomationTriggerType.CHAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CompoundAutomationTriggerType.OR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CompoundAutomationTrigger(@NotNull String id, @NotNull CompoundAutomationTriggerType type, double d, @NotNull List<Child> children) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(children, "children");
        this.id = id;
        this.type = type;
        this.goal = d;
        this.children = children;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final CompoundAutomationTriggerType getType() {
        return this.type;
    }

    public final double getGoal() {
        return this.goal;
    }

    @NotNull
    public final List<Child> getChildren$urbanairship_automation_release() {
        return this.children;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ0\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0004\u0010\bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/automation/CompoundAutomationTrigger$Child;", "Lcom/urbanairship/json/JsonSerializable;", DeferredApiClient.KEY_TRIGGER_CONTEXT, "Lcom/urbanairship/automation/AutomationTrigger;", "isSticky", "", "resetOnIncrement", "(Lcom/urbanairship/automation/AutomationTrigger;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getResetOnIncrement", "getTrigger", "()Lcom/urbanairship/automation/AutomationTrigger;", "component1", "component2", "component3", "copy", "(Lcom/urbanairship/automation/AutomationTrigger;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/urbanairship/automation/CompoundAutomationTrigger$Child;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Child implements JsonSerializable {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean isSticky;
        private final Boolean resetOnIncrement;
        private final AutomationTrigger trigger;

        public static /* synthetic */ Child copy$default(Child child, AutomationTrigger automationTrigger, Boolean bool, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                automationTrigger = child.trigger;
            }
            if ((i & 2) != 0) {
                bool = child.isSticky;
            }
            if ((i & 4) != 0) {
                bool2 = child.resetOnIncrement;
            }
            return child.copy(automationTrigger, bool, bool2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final AutomationTrigger getTrigger() {
            return this.trigger;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final Boolean getIsSticky() {
            return this.isSticky;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final Boolean getResetOnIncrement() {
            return this.resetOnIncrement;
        }

        @NotNull
        public final Child copy(@NotNull AutomationTrigger trigger, @Nullable Boolean isSticky, @Nullable Boolean resetOnIncrement) {
            Intrinsics.checkNotNullParameter(trigger, "trigger");
            return new Child(trigger, isSticky, resetOnIncrement);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Child)) {
                return false;
            }
            Child child = (Child) other;
            return Intrinsics.areEqual(this.trigger, child.trigger) && Intrinsics.areEqual(this.isSticky, child.isSticky) && Intrinsics.areEqual(this.resetOnIncrement, child.resetOnIncrement);
        }

        public int hashCode() {
            int iHashCode = this.trigger.hashCode() * 31;
            Boolean bool = this.isSticky;
            int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.resetOnIncrement;
            return iHashCode2 + (bool2 != null ? bool2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Child(trigger=" + this.trigger + ", isSticky=" + this.isSticky + ", resetOnIncrement=" + this.resetOnIncrement + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Child(@NotNull AutomationTrigger trigger, @Nullable Boolean bool, @Nullable Boolean bool2) {
            Intrinsics.checkNotNullParameter(trigger, "trigger");
            this.trigger = trigger;
            this.isSticky = bool;
            this.resetOnIncrement = bool2;
        }

        @NotNull
        public final AutomationTrigger getTrigger() {
            return this.trigger;
        }

        @Nullable
        public final Boolean isSticky() {
            return this.isSticky;
        }

        @Nullable
        public final Boolean getResetOnIncrement() {
            return this.resetOnIncrement;
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/urbanairship/automation/CompoundAutomationTrigger$Child$Companion;", "", "()V", "KEY_IS_STICKY", "", "KEY_RESET_ON_INCREMENT", "KEY_TRIGGER", "fromJson", "Lcom/urbanairship/automation/CompoundAutomationTrigger$Child;", "value", "Lcom/urbanairship/json/JsonValue;", "executionType", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nAutomationTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationTrigger.kt\ncom/urbanairship/automation/CompoundAutomationTrigger$Child$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,574:1\n79#2,16:575\n79#2,16:591\n*S KotlinDebug\n*F\n+ 1 AutomationTrigger.kt\ncom/urbanairship/automation/CompoundAutomationTrigger$Child$Companion\n*L\n430#1:575,16\n431#1:591,16\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Child fromJson(@NotNull JsonValue value, @NotNull TriggerExecutionType executionType) throws JsonException {
                Boolean boolValueOf;
                Boolean boolValueOf2;
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(executionType, "executionType");
                JsonMap jsonMapRequireMap = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                AutomationTrigger.Companion companion = AutomationTrigger.INSTANCE;
                JsonValue jsonValueRequire = jsonMapRequireMap.require(DeferredApiClient.KEY_TRIGGER_CONTEXT);
                Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
                AutomationTrigger automationTriggerFromJson = companion.fromJson(jsonValueRequire, executionType);
                JsonValue jsonValue = jsonMapRequireMap.get("is_sticky");
                Boolean bool = null;
                if (jsonValue == null) {
                    boolValueOf = null;
                } else {
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        boolValueOf = (Boolean) jsonValue.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        boolValueOf = Boolean.valueOf(jsonValue.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        boolValueOf = (Boolean) Long.valueOf(jsonValue.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        boolValueOf = (Boolean) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        boolValueOf = (Boolean) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        boolValueOf = (Boolean) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        boolValueOf = (Boolean) Integer.valueOf(jsonValue.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        boolValueOf = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        boolValueOf = (Boolean) jsonValue.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        boolValueOf = (Boolean) jsonValue.optMap();
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'is_sticky" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        boolValueOf = (Boolean) jsonValue.getJsonValue();
                    }
                }
                JsonValue jsonValue2 = jsonMapRequireMap.get("reset_on_increment");
                if (jsonValue2 != null) {
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Boolean.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        boolValueOf2 = (Boolean) jsonValue2.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        boolValueOf2 = Boolean.valueOf(jsonValue2.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        boolValueOf2 = (Boolean) Long.valueOf(jsonValue2.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        boolValueOf2 = (Boolean) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue2.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        boolValueOf2 = (Boolean) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        boolValueOf2 = (Boolean) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        boolValueOf2 = (Boolean) Integer.valueOf(jsonValue2.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        boolValueOf2 = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        boolValueOf2 = (Boolean) jsonValue2.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        boolValueOf2 = (Boolean) jsonValue2.optMap();
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'reset_on_increment" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        boolValueOf2 = (Boolean) jsonValue2.getJsonValue();
                    }
                    bool = boolValueOf2;
                }
                return new Child(automationTriggerFromJson, boolValueOf, bool);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to(DeferredApiClient.KEY_TRIGGER_CONTEXT, this.trigger), TuplesKt.to("is_sticky", this.isSticky), TuplesKt.to("reset_on_increment", this.resetOnIncrement)).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00e6  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.urbanairship.automation.engine.triggerprocessor.MatchResult matchEvent$urbanairship_automation_release(@org.jetbrains.annotations.NotNull com.urbanairship.automation.engine.AutomationEvent r10, @org.jetbrains.annotations.NotNull com.urbanairship.automation.engine.triggerprocessor.TriggerData r11) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.CompoundAutomationTrigger.matchEvent$urbanairship_automation_release(com.urbanairship.automation.engine.AutomationEvent, com.urbanairship.automation.engine.triggerprocessor.TriggerData):com.urbanairship.automation.engine.triggerprocessor.MatchResult");
    }

    private final List matchChildren(AutomationEvent event, TriggerData data) {
        List<Child> list = this.children;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        boolean z = true;
        for (Child child : list) {
            TriggerData triggerDataChildDate$urbanairship_automation_release = data.childDate$urbanairship_automation_release(child.getTrigger().getId());
            MatchResult matchResultMatchEvent$urbanairship_automation_release = z ? child.getTrigger().matchEvent$urbanairship_automation_release(event, triggerDataChildDate$urbanairship_automation_release, false) : null;
            if (matchResultMatchEvent$urbanairship_automation_release == null) {
                matchResultMatchEvent$urbanairship_automation_release = new MatchResult(child.getTrigger().getId(), child.getTrigger().isTriggered$urbanairship_automation_release(triggerDataChildDate$urbanairship_automation_release));
            }
            if (this.type == CompoundAutomationTriggerType.CHAIN && z && !matchResultMatchEvent$urbanairship_automation_release.isTriggered()) {
                z = false;
            }
            arrayList.add(matchResultMatchEvent$urbanairship_automation_release);
        }
        return arrayList;
    }

    private final int triggeredChildrenCount(TriggerData data) {
        List list = this.children;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            Child child = (Child) obj;
            TriggerData triggerData = data.getChildren().get(child.getTrigger().getId());
            if (triggerData == null ? false : child.getTrigger().isTriggered$urbanairship_automation_release(triggerData)) {
                arrayList.add(obj);
            }
        }
        return arrayList.size();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/automation/CompoundAutomationTrigger$Companion;", "", "()V", "KEY_CHILDREN", "", "KEY_GOAL", "KEY_ID", "KEY_TYPE", "fromJson", "Lcom/urbanairship/automation/CompoundAutomationTrigger;", "value", "Lcom/urbanairship/json/JsonValue;", "executionType", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAutomationTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationTrigger.kt\ncom/urbanairship/automation/CompoundAutomationTrigger$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,574:1\n44#2,15:575\n79#2,16:590\n1549#3:606\n1620#3,3:607\n*S KotlinDebug\n*F\n+ 1 AutomationTrigger.kt\ncom/urbanairship/automation/CompoundAutomationTrigger$Companion\n*L\n542#1:575,15\n546#1:590,16\n549#1:606\n549#1:607,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:104:0x02ae  */
        /* JADX WARN: Removed duplicated region for block: B:108:0x02e2 A[LOOP:0: B:106:0x02dc->B:108:0x02e2, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x018a  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x018d  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.urbanairship.automation.CompoundAutomationTrigger fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r22, @org.jetbrains.annotations.NotNull com.urbanairship.automation.engine.triggerprocessor.TriggerExecutionType r23) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 895
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.CompoundAutomationTrigger.Companion.fromJson(com.urbanairship.json.JsonValue, com.urbanairship.automation.engine.triggerprocessor.TriggerExecutionType):com.urbanairship.automation.CompoundAutomationTrigger");
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("id", this.id), TuplesKt.to("type", this.type), TuplesKt.to("goal", Double.valueOf(this.goal)), TuplesKt.to("children", this.children)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    public final void removeStaleChildData$urbanairship_automation_release(@NotNull TriggerData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.children.isEmpty()) {
            return;
        }
        data.resetChildrenData$urbanairship_automation_release();
        for (Child child : this.children) {
            child.getTrigger().removeStaleChildData$urbanairship_automation_release(data.childDate$urbanairship_automation_release(child.getTrigger().getId()));
        }
    }
}
