package com.urbanairship.featureflag;

import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.UALog;
import com.urbanairship.analytics.Analytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagAnalytics;", "", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/urbanairship/analytics/Analytics;", "(Lcom/urbanairship/analytics/Analytics;)V", "trackInteraction", "", "flag", "Lcom/urbanairship/featureflag/FeatureFlag;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeatureFlagAnalytics {
    private final Analytics analytics;

    public FeatureFlagAnalytics(@NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.analytics = analytics;
    }

    public final void trackInteraction(@NotNull final FeatureFlag flag) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        if (!flag.getExists()) {
            UALog.e$default(null, new Function0() { // from class: com.urbanairship.featureflag.FeatureFlagAnalytics.trackInteraction.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Flag does not exist, unable to track interaction: " + flag;
                }
            }, 1, null);
            return;
        }
        if (flag.getReportingInfo() == null) {
            UALog.e$default(null, new Function0() { // from class: com.urbanairship.featureflag.FeatureFlagAnalytics.trackInteraction.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Flag missing reporting info, unable to track interaction: " + flag;
                }
            }, 1, null);
            return;
        }
        try {
            this.analytics.addEvent(new FeatureFlagInteractionEvent(flag));
        } catch (Exception e) {
            UALog.e(e, (Function0<String>) new Function0() { // from class: com.urbanairship.featureflag.FeatureFlagAnalytics.trackInteraction.3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to track interaction: " + flag;
                }
            });
        }
    }
}
