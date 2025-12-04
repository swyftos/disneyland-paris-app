package com.urbanairship.iam.analytics;

import com.urbanairship.iam.InAppMessage;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppDisplayImpressionRuleInterface;", "", "impressionRules", "Lcom/urbanairship/iam/analytics/InAppDisplayImpressionRule;", "message", "Lcom/urbanairship/iam/InAppMessage;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface InAppDisplayImpressionRuleInterface {
    @NotNull
    InAppDisplayImpressionRule impressionRules(@NotNull InAppMessage message);
}
