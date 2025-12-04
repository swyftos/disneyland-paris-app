package com.urbanairship.automation.audiencecheck;

import com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckApiClient;
import com.urbanairship.json.JsonValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
/* synthetic */ class AdditionalAudienceCheckerResolver$doResolve$2 extends FunctionReferenceImpl implements Function1 {
    AdditionalAudienceCheckerResolver$doResolve$2(Object obj) {
        super(1, obj, AdditionalAudienceCheckApiClient.Result.Companion.class, "fromJson", "fromJson(Lcom/urbanairship/json/JsonValue;)Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckApiClient$Result;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final AdditionalAudienceCheckApiClient.Result invoke(JsonValue p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((AdditionalAudienceCheckApiClient.Result.Companion) this.receiver).fromJson(p0);
    }
}
