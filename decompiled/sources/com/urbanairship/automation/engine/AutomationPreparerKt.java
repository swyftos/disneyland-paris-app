package com.urbanairship.automation.engine;

import com.urbanairship.automation.AutomationAudience;
import com.urbanairship.automation.AutomationCompoundAudience;
import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.automation.AutomationScheduleKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0002¨\u0006\u0005"}, d2 = {"audienceMissBehaviorResult", "Lcom/urbanairship/automation/engine/SchedulePrepareResult;", "Lcom/urbanairship/automation/AutomationSchedule;", "evaluateExperiments", "", "urbanairship-automation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AutomationPreparerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final SchedulePrepareResult audienceMissBehaviorResult(AutomationSchedule automationSchedule) {
        AutomationAudience.MissBehavior missBehavior;
        AutomationCompoundAudience compoundAudience = automationSchedule.getCompoundAudience();
        if (compoundAudience == null || (missBehavior = compoundAudience.getMissBehavior()) == null) {
            AutomationAudience audience = automationSchedule.getAudience();
            missBehavior = audience != null ? audience.getMissBehavior() : null;
            if (missBehavior == null) {
                missBehavior = AutomationAudience.MissBehavior.PENALIZE;
            }
        }
        return missBehavior.toPrepareResult$urbanairship_automation_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean evaluateExperiments(AutomationSchedule automationSchedule) {
        return AutomationScheduleKt.isInAppMessageType(automationSchedule) && !Intrinsics.areEqual(automationSchedule.getBypassHoldoutGroups(), Boolean.TRUE);
    }
}
