package com.urbanairship.automation.engine;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0080\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, m1836d2 = {"Lcom/urbanairship/automation/engine/AutomationScheduleState;", "", "json", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJson$urbanairship_automation_release", "()Ljava/lang/String;", "toString", "IDLE", "TRIGGERED", "PREPARED", "EXECUTING", "PAUSED", "FINISHED", "Companion", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public enum AutomationScheduleState {
    IDLE("idle"),
    TRIGGERED("triggered"),
    PREPARED("prepared"),
    EXECUTING("executing"),
    PAUSED("paused"),
    FINISHED("finished");

    private final String json;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static EnumEntries<AutomationScheduleState> getEntries() {
        return $ENTRIES;
    }

    AutomationScheduleState(String str) {
        this.json = str;
    }

    @NotNull
    /* JADX INFO: renamed from: getJson$urbanairship_automation_release, reason: from getter */
    public final String getJson() {
        return this.json;
    }

    @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/automation/engine/AutomationScheduleState$Companion;", "", "()V", "fromString", "Lcom/urbanairship/automation/engine/AutomationScheduleState;", "value", "", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nAutomationScheduleState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationScheduleState.kt\ncom/urbanairship/automation/engine/AutomationScheduleState$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,25:1\n288#2,2:26\n*S KotlinDebug\n*F\n+ 1 AutomationScheduleState.kt\ncom/urbanairship/automation/engine/AutomationScheduleState$Companion\n*L\n19#1:26,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final AutomationScheduleState fromString(@NotNull String value) throws IllegalArgumentException {
            AutomationScheduleState next;
            Intrinsics.checkNotNullParameter(value, "value");
            Iterator<AutomationScheduleState> it = AutomationScheduleState.getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(next.getJson(), value));
            AutomationScheduleState automationScheduleState = next;
            if (automationScheduleState != null) {
                return automationScheduleState;
            }
            throw new IllegalArgumentException();
        }
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.json;
    }
}
