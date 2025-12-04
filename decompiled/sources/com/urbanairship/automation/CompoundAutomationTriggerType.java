package com.urbanairship.automation;

import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/automation/CompoundAutomationTriggerType;", "", "Lcom/urbanairship/json/JsonSerializable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue$urbanairship_automation_release", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "OR", "AND", "CHAIN", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CompoundAutomationTriggerType implements JsonSerializable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CompoundAutomationTriggerType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final String value;
    public static final CompoundAutomationTriggerType OR = new CompoundAutomationTriggerType("OR", 0, JsonPredicate.OR_PREDICATE_TYPE);
    public static final CompoundAutomationTriggerType AND = new CompoundAutomationTriggerType("AND", 1, JsonPredicate.AND_PREDICATE_TYPE);
    public static final CompoundAutomationTriggerType CHAIN = new CompoundAutomationTriggerType("CHAIN", 2, "chain");

    private static final /* synthetic */ CompoundAutomationTriggerType[] $values() {
        return new CompoundAutomationTriggerType[]{OR, AND, CHAIN};
    }

    @NotNull
    public static EnumEntries<CompoundAutomationTriggerType> getEntries() {
        return $ENTRIES;
    }

    public static CompoundAutomationTriggerType valueOf(String str) {
        return (CompoundAutomationTriggerType) Enum.valueOf(CompoundAutomationTriggerType.class, str);
    }

    public static CompoundAutomationTriggerType[] values() {
        return (CompoundAutomationTriggerType[]) $VALUES.clone();
    }

    private CompoundAutomationTriggerType(String str, int i, String str2) {
        this.value = str2;
    }

    @NotNull
    /* renamed from: getValue$urbanairship_automation_release, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    static {
        CompoundAutomationTriggerType[] compoundAutomationTriggerTypeArr$values = $values();
        $VALUES = compoundAutomationTriggerTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(compoundAutomationTriggerTypeArr$values);
        INSTANCE = new Companion(null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/CompoundAutomationTriggerType$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/automation/CompoundAutomationTriggerType;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAutomationTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationTrigger.kt\ncom/urbanairship/automation/CompoundAutomationTriggerType$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,574:1\n288#2,2:575\n*S KotlinDebug\n*F\n+ 1 AutomationTrigger.kt\ncom/urbanairship/automation/CompoundAutomationTriggerType$Companion\n*L\n167#1:575,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final CompoundAutomationTriggerType fromJson(@NotNull JsonValue value) throws JsonException {
            CompoundAutomationTriggerType next;
            Intrinsics.checkNotNullParameter(value, "value");
            String strOptString = value.optString();
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            Iterator<CompoundAutomationTriggerType> it = CompoundAutomationTriggerType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(next.getValue(), strOptString)) {
                    break;
                }
            }
            return next;
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() {
        JsonValue jsonValueWrap = JsonValue.wrap(this.value);
        Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
        return jsonValueWrap;
    }
}
