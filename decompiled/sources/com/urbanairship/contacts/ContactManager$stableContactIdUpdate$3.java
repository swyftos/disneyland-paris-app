package com.urbanairship.contacts;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
final class ContactManager$stableContactIdUpdate$3 extends SuspendLambda implements Function2 {
    final /* synthetic */ long $minResolveDate;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContactManager$stableContactIdUpdate$3(long j, Continuation continuation) {
        super(2, continuation);
        this.$minResolveDate = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ContactManager$stableContactIdUpdate$3 contactManager$stableContactIdUpdate$3 = new ContactManager$stableContactIdUpdate$3(this.$minResolveDate, continuation);
        contactManager$stableContactIdUpdate$3.L$0 = obj;
        return contactManager$stableContactIdUpdate$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ContactIdUpdate contactIdUpdate, Continuation continuation) {
        return ((ContactManager$stableContactIdUpdate$3) create(contactIdUpdate, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ContactIdUpdate contactIdUpdate = (ContactIdUpdate) this.L$0;
        return Boxing.boxBoolean(contactIdUpdate.isStable() && contactIdUpdate.getResolveDateMs() >= this.$minResolveDate);
    }
}
