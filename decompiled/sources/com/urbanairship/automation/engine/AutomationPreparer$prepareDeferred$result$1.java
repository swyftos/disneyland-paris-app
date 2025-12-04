package com.urbanairship.automation.engine;

import com.urbanairship.automation.deferred.DeferredScheduleResult;
import com.urbanairship.json.JsonValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
/* synthetic */ class AutomationPreparer$prepareDeferred$result$1 extends FunctionReferenceImpl implements Function1 {
    AutomationPreparer$prepareDeferred$result$1(Object obj) {
        super(1, obj, DeferredScheduleResult.Companion.class, "fromJson", "fromJson(Lcom/urbanairship/json/JsonValue;)Lcom/urbanairship/automation/deferred/DeferredScheduleResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DeferredScheduleResult invoke(JsonValue p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DeferredScheduleResult.Companion) this.receiver).fromJson(p0);
    }
}
