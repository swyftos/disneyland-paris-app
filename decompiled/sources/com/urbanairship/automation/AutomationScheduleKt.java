package com.urbanairship.automation;

import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.automation.deferred.DeferredAutomationDataKt;
import com.urbanairship.automation.engine.AutomationScheduleData;
import com.urbanairship.automation.engine.AutomationScheduleState;
import com.urbanairship.util.VersionUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u001e\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0000\u001a\u001e\u0010\b\u001a\u00020\t*\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0000¨\u0006\f"}, d2 = {"isInAppMessageType", "", "Lcom/urbanairship/automation/AutomationSchedule;", "isNewSchedule", "sinceDate", "", "lastSDKVersion", "", "updateOrCreate", "Lcom/urbanairship/automation/engine/AutomationScheduleData;", "data", "timestamp", "urbanairship-automation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AutomationScheduleKt {
    @NotNull
    public static final AutomationScheduleData updateOrCreate(@NotNull AutomationSchedule automationSchedule, @Nullable AutomationScheduleData automationScheduleData, long j) {
        Intrinsics.checkNotNullParameter(automationSchedule, "<this>");
        if (automationScheduleData == null) {
            AutomationScheduleState automationScheduleState = AutomationScheduleState.IDLE;
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return new AutomationScheduleData(automationSchedule, automationScheduleState, j, 0, null, null, null, string, 64, null);
        }
        automationScheduleData.setSchedule$urbanairship_automation_release(automationSchedule);
        return automationScheduleData;
    }

    public static final boolean isInAppMessageType(@NotNull AutomationSchedule automationSchedule) {
        Intrinsics.checkNotNullParameter(automationSchedule, "<this>");
        AutomationSchedule.ScheduleData data = automationSchedule.getData();
        if (data instanceof AutomationSchedule.ScheduleData.Actions) {
            return false;
        }
        if (data instanceof AutomationSchedule.ScheduleData.Deferred) {
            return DeferredAutomationDataKt.isInAppMessage(((AutomationSchedule.ScheduleData.Deferred) automationSchedule.getData()).getDeferred$urbanairship_automation_release());
        }
        if (data instanceof AutomationSchedule.ScheduleData.InAppMessageData) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean isNewSchedule(@NotNull AutomationSchedule automationSchedule, long j, @Nullable String str) {
        Intrinsics.checkNotNullParameter(automationSchedule, "<this>");
        if (automationSchedule.getCreated() > j) {
            return true;
        }
        String minSDKVersion = automationSchedule.getMinSDKVersion();
        if (minSDKVersion == null) {
            return false;
        }
        if (str == null) {
            return VersionUtils.isVersionNewerOrEqualTo("16.2.0", minSDKVersion);
        }
        return VersionUtils.isVersionNewer(str, minSDKVersion);
    }
}
