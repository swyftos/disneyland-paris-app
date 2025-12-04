package com.urbanairship.iam.actions;

import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.iam.analytics.InAppMessageAnalyticsInterface;
import com.urbanairship.iam.content.InAppMessageDisplayContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/urbanairship/iam/actions/InAppActionRunnerFactory;", "", "()V", "makeRunner", "Lcom/urbanairship/iam/actions/InAppActionRunner;", "inAppMessage", "Lcom/urbanairship/iam/InAppMessage;", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;", "makeRunner$urbanairship_automation_release", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppActionRunnerFactory {
    @NotNull
    public final InAppActionRunner makeRunner$urbanairship_automation_release(@NotNull InAppMessage inAppMessage, @NotNull InAppMessageAnalyticsInterface analytics) {
        Intrinsics.checkNotNullParameter(inAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new InAppActionRunner(analytics, inAppMessage.getDisplayContent().getDisplayType() == InAppMessageDisplayContent.DisplayType.LAYOUT, null, 4, null);
    }
}
