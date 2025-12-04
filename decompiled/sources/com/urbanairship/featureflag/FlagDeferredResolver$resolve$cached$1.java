package com.urbanairship.featureflag;

import com.urbanairship.featureflag.DeferredFlag;
import com.urbanairship.json.JsonValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
/* synthetic */ class FlagDeferredResolver$resolve$cached$1 extends FunctionReferenceImpl implements Function1 {
    FlagDeferredResolver$resolve$cached$1(Object obj) {
        super(1, obj, DeferredFlag.Companion.class, "fromJson", "fromJson(Lcom/urbanairship/json/JsonValue;)Lcom/urbanairship/featureflag/DeferredFlag;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DeferredFlag invoke(JsonValue p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((DeferredFlag.Companion) this.receiver).fromJson(p0);
    }
}
