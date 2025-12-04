package com.urbanairship.automation.engine;

import com.urbanairship.deferred.DeferredResult;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
final class PrepareCache {
    private DeferredResult deferredResult;

    public PrepareCache(DeferredResult deferredResult) {
        this.deferredResult = deferredResult;
    }

    public /* synthetic */ PrepareCache(DeferredResult deferredResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : deferredResult);
    }

    public final DeferredResult getDeferredResult() {
        return this.deferredResult;
    }

    public final void setDeferredResult(DeferredResult deferredResult) {
        this.deferredResult = deferredResult;
    }
}
