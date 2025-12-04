package com.urbanairship.featureflag;

import com.urbanairship.featureflag.DeferredFlagInfo;
import com.urbanairship.json.JsonValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
/* synthetic */ class FlagDeferredResolver$fetchFlag$result$1 extends FunctionReferenceImpl implements Function1 {
    FlagDeferredResolver$fetchFlag$result$1(Object obj) {
        super(1, obj, DeferredFlagInfo.Companion.class, "fromJson", "fromJson(Lcom/urbanairship/json/JsonValue;)Lcom/urbanairship/featureflag/DeferredFlagInfo;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DeferredFlagInfo invoke(JsonValue p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DeferredFlagInfo.Companion) this.receiver).fromJson(p0);
    }
}
