package com.oneid;

import com.disney.id.android.NotInitialized;
import com.oneid.common.EventId;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
/* synthetic */ class OneidModule$launchProfileDelegate$1 extends FunctionReferenceImpl implements Function5 {
    OneidModule$launchProfileDelegate$1(Object obj) {
        super(5, obj, OneidModule.class, "internalGetSessionData", "internalGetSessionData(ZZLcom/oneid/common/EventId;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) throws NotInitialized {
        invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (EventId) obj3, (Function1) obj4, (Function1) obj5);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, boolean z2, EventId p2, Function1 function1, Function1 function12) throws NotInitialized {
        Intrinsics.checkNotNullParameter(p2, "p2");
        ((OneidModule) this.receiver).internalGetSessionData(z, z2, p2, function1, function12);
    }
}
