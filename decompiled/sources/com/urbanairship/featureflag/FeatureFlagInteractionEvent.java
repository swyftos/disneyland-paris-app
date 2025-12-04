package com.urbanairship.featureflag;

import com.urbanairship.analytics.ConversionData;
import com.urbanairship.analytics.Event;
import com.urbanairship.analytics.EventType;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.featureflag.FeatureFlag;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagInteractionEvent;", "Lcom/urbanairship/analytics/Event;", "flag", "Lcom/urbanairship/featureflag/FeatureFlag;", "(Lcom/urbanairship/featureflag/FeatureFlag;)V", "data", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "getData", "()Lcom/urbanairship/json/JsonMap;", "getEventData", "conversionData", "Lcom/urbanairship/analytics/ConversionData;", "getType", "Lcom/urbanairship/analytics/EventType;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
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
        Pair pair = TuplesKt.to("flag_name", flag.getName());
        Pair pair2 = TuplesKt.to("eligible", Boolean.valueOf(flag.getIsEligible()));
        FeatureFlag.ReportingInfo reportingInfo = flag.getReportingInfo();
        JsonMap reportingMetadata = reportingInfo != null ? reportingInfo.getReportingMetadata() : null;
        if (reportingMetadata == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Pair pair3 = TuplesKt.to("reporting_metadata", reportingMetadata);
        FeatureFlag.ReportingInfo reportingInfo2 = flag.getReportingInfo();
        Pair pair4 = TuplesKt.to("superseded_reporting_metadata", reportingInfo2 != null ? reportingInfo2.getSupersededReportingMetadata() : null);
        FeatureFlag.ReportingInfo reportingInfo3 = flag.getReportingInfo();
        this(JsonExtensionsKt.jsonMapOf(pair, pair2, pair3, pair4, TuplesKt.to("device", reportingInfo3 != null ? JsonExtensionsKt.jsonMapOf(TuplesKt.to("channel_id", reportingInfo3.getChannelId()), TuplesKt.to(DeferredApiClient.KEY_CONTACT_ID, reportingInfo3.getContactId())) : null)));
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
