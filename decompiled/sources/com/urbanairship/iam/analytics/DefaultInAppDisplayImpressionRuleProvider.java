package com.urbanairship.iam.analytics;

import com.urbanairship.iam.InAppMessage;
import com.urbanairship.iam.analytics.InAppDisplayImpressionRule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/urbanairship/iam/analytics/DefaultInAppDisplayImpressionRuleProvider;", "Lcom/urbanairship/iam/analytics/InAppDisplayImpressionRuleInterface;", "()V", "impressionRules", "Lcom/urbanairship/iam/analytics/InAppDisplayImpressionRule;", "message", "Lcom/urbanairship/iam/InAppMessage;", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DefaultInAppDisplayImpressionRuleProvider implements InAppDisplayImpressionRuleInterface {
    private static final long DEFAULT_EMBEDDED_IMPRESSION_INTERVAL;

    @Override // com.urbanairship.iam.analytics.InAppDisplayImpressionRuleInterface
    @NotNull
    public InAppDisplayImpressionRule impressionRules(@NotNull InAppMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.isEmbedded$urbanairship_automation_release()) {
            return new InAppDisplayImpressionRule.Interval(DEFAULT_EMBEDDED_IMPRESSION_INTERVAL, null);
        }
        return InAppDisplayImpressionRule.Once.INSTANCE;
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        DEFAULT_EMBEDDED_IMPRESSION_INTERVAL = DurationKt.toDuration(30, DurationUnit.MINUTES);
    }
}
