package com.oneid;

import com.facebook.react.bridge.WritableMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
/* synthetic */ class OneidModule$loginDelegate$1 extends FunctionReferenceImpl implements Function2 {
    OneidModule$loginDelegate$1(Object obj) {
        super(2, obj, OneidModule.class, "sendEvent", "sendEvent(Ljava/lang/String;Lcom/facebook/react/bridge/WritableMap;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (WritableMap) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(String p0, WritableMap p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((OneidModule) this.receiver).sendEvent(p0, p1);
    }
}
