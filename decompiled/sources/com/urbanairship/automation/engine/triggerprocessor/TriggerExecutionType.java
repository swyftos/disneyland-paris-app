package com.urbanairship.automation.engine.triggerprocessor;

import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue$urbanairship_automation_release", "()Ljava/lang/String;", "EXECUTION", "DELAY_CANCELLATION", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TriggerExecutionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TriggerExecutionType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final String value;
    public static final TriggerExecutionType EXECUTION = new TriggerExecutionType("EXECUTION", 0, "execution");
    public static final TriggerExecutionType DELAY_CANCELLATION = new TriggerExecutionType("DELAY_CANCELLATION", 1, "delay_cancellation");

    private static final /* synthetic */ TriggerExecutionType[] $values() {
        return new TriggerExecutionType[]{EXECUTION, DELAY_CANCELLATION};
    }

    @NotNull
    public static EnumEntries<TriggerExecutionType> getEntries() {
        return $ENTRIES;
    }

    public static TriggerExecutionType valueOf(String str) {
        return (TriggerExecutionType) Enum.valueOf(TriggerExecutionType.class, str);
    }

    public static TriggerExecutionType[] values() {
        return (TriggerExecutionType[]) $VALUES.clone();
    }

    private TriggerExecutionType(String str, int i, String str2) {
        this.value = str2;
    }

    @NotNull
    /* renamed from: getValue$urbanairship_automation_release, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    static {
        TriggerExecutionType[] triggerExecutionTypeArr$values = $values();
        $VALUES = triggerExecutionTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(triggerExecutionTypeArr$values);
        INSTANCE = new Companion(null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nTriggerExecutionType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TriggerExecutionType.kt\ncom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,21:1\n288#2,2:22\n*S KotlinDebug\n*F\n+ 1 TriggerExecutionType.kt\ncom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType$Companion\n*L\n16#1:22,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final TriggerExecutionType fromJson(@NotNull JsonValue value) throws JsonException {
            TriggerExecutionType next;
            Intrinsics.checkNotNullParameter(value, "value");
            String strRequireString = value.requireString();
            Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
            Iterator<TriggerExecutionType> it = TriggerExecutionType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(next.getValue(), strRequireString)) {
                    break;
                }
            }
            TriggerExecutionType triggerExecutionType = next;
            if (triggerExecutionType != null) {
                return triggerExecutionType;
            }
            throw new JsonException("Invalid trigger execution type " + strRequireString);
        }
    }
}
