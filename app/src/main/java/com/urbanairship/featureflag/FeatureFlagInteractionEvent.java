package com.urbanairship.featureflag;

import com.urbanairship.analytics.ConversionData;
import com.urbanairship.analytics.Event;
import com.urbanairship.analytics.EventType;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, m1836d2 = {"Lcom/urbanairship/featureflag/FeatureFlagInteractionEvent;", "Lcom/urbanairship/analytics/Event;", "flag", "Lcom/urbanairship/featureflag/FeatureFlag;", "(Lcom/urbanairship/featureflag/FeatureFlag;)V", "data", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "getData", "()Lcom/urbanairship/json/JsonMap;", "getEventData", "conversionData", "Lcom/urbanairship/analytics/ConversionData;", "getType", "Lcom/urbanairship/analytics/EventType;", "urbanairship-feature-flag_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public final class FeatureFlagInteractionEvent extends Event {
    private final JsonMap data;

    @NotNull
    public final JsonMap getData() {
        return this.data;
    }

    private FeatureFlagInteractionEvent(JsonMap jsonMap) {
        this.data = jsonMap;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FeatureFlagInteractionEvent(@NotNull FeatureFlag flag) throws JsonException {
        Intrinsics.checkNotNullParameter(flag, "flag");
        Pair pairM1842to = TuplesKt.m1842to("flag_name", flag.getName());
        Pair pairM1842to2 = TuplesKt.m1842to("eligible", Boolean.valueOf(flag.getIsEligible()));
        FeatureFlag.ReportingInfo reportingInfo = flag.getReportingInfo();
        JsonMap reportingMetadata = reportingInfo != null ? reportingInfo.getReportingMetadata() : null;
        if (reportingMetadata == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Pair pairM1842to3 = TuplesKt.m1842to("reporting_metadata", reportingMetadata);
        FeatureFlag.ReportingInfo reportingInfo2 = flag.getReportingInfo();
        Pair pairM1842to4 = TuplesKt.m1842to("superseded_reporting_metadata", reportingInfo2 != null ? reportingInfo2.getSupersededReportingMetadata() : null);
        FeatureFlag.ReportingInfo reportingInfo3 = flag.getReportingInfo();
        this(JsonExtensionsKt.jsonMapOf(pairM1842to, pairM1842to2, pairM1842to3, pairM1842to4, TuplesKt.m1842to("device", reportingInfo3 != null ? JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("channel_id", reportingInfo3.getChannelId()), TuplesKt.m1842to(DeferredApiClient.KEY_CONTACT_ID, reportingInfo3.getContactId())) : null)));
    }

    @Override // com.urbanairship.analytics.Event
    @NotNull
    public EventType getType() {
        return EventType.FEATURE_FLAG_INTERACTION;
    }

    @Override // com.urbanairship.analytics.Event
    @NotNull
    public JsonMap getEventData(@NotNull ConversionData conversionData) {
        Intrinsics.checkNotNullParameter(conversionData, "conversionData");
        return this.data;
    }
}
