package com.urbanairship.automation;

import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/InAppAutomationRemoteDataStatus;", "", "(Ljava/lang/String;I)V", "UP_TO_DATE", "STALE", "OUT_OF_DATE", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppAutomationRemoteDataStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InAppAutomationRemoteDataStatus[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final InAppAutomationRemoteDataStatus UP_TO_DATE = new InAppAutomationRemoteDataStatus("UP_TO_DATE", 0);
    public static final InAppAutomationRemoteDataStatus STALE = new InAppAutomationRemoteDataStatus("STALE", 1);
    public static final InAppAutomationRemoteDataStatus OUT_OF_DATE = new InAppAutomationRemoteDataStatus("OUT_OF_DATE", 2);

    private static final /* synthetic */ InAppAutomationRemoteDataStatus[] $values() {
        return new InAppAutomationRemoteDataStatus[]{UP_TO_DATE, STALE, OUT_OF_DATE};
    }

    @NotNull
    public static EnumEntries<InAppAutomationRemoteDataStatus> getEntries() {
        return $ENTRIES;
    }

    public static InAppAutomationRemoteDataStatus valueOf(String str) {
        return (InAppAutomationRemoteDataStatus) Enum.valueOf(InAppAutomationRemoteDataStatus.class, str);
    }

    public static InAppAutomationRemoteDataStatus[] values() {
        return (InAppAutomationRemoteDataStatus[]) $VALUES.clone();
    }

    private InAppAutomationRemoteDataStatus(String str, int i) {
    }

    static {
        InAppAutomationRemoteDataStatus[] inAppAutomationRemoteDataStatusArr$values = $values();
        $VALUES = inAppAutomationRemoteDataStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(inAppAutomationRemoteDataStatusArr$values);
        INSTANCE = new Companion(null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/InAppAutomationRemoteDataStatus$Companion;", "", "()V", "reduce", "Lcom/urbanairship/automation/InAppAutomationRemoteDataStatus;", "statuses", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final InAppAutomationRemoteDataStatus reduce(@NotNull List<? extends InAppAutomationRemoteDataStatus> statuses) {
            Intrinsics.checkNotNullParameter(statuses, "statuses");
            InAppAutomationRemoteDataStatus inAppAutomationRemoteDataStatus = InAppAutomationRemoteDataStatus.OUT_OF_DATE;
            if (statuses.contains(inAppAutomationRemoteDataStatus)) {
                return inAppAutomationRemoteDataStatus;
            }
            InAppAutomationRemoteDataStatus inAppAutomationRemoteDataStatus2 = InAppAutomationRemoteDataStatus.STALE;
            return statuses.contains(inAppAutomationRemoteDataStatus2) ? inAppAutomationRemoteDataStatus2 : InAppAutomationRemoteDataStatus.UP_TO_DATE;
        }
    }
}
