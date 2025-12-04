package com.urbanairship.messagecenter;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
final class Inbox$setupRefreshOnMessageExpiresJob$1 extends SuspendLambda implements Function2 {
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Inbox this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Inbox$setupRefreshOnMessageExpiresJob$1(Inbox inbox, Continuation continuation) {
        super(2, continuation);
        this.this$0 = inbox;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        Inbox$setupRefreshOnMessageExpiresJob$1 inbox$setupRefreshOnMessageExpiresJob$1 = new Inbox$setupRefreshOnMessageExpiresJob$1(this.this$0, continuation);
        inbox$setupRefreshOnMessageExpiresJob$1.L$0 = obj;
        return inbox$setupRefreshOnMessageExpiresJob$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((Inbox$setupRefreshOnMessageExpiresJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00cb  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.Inbox$setupRefreshOnMessageExpiresJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
