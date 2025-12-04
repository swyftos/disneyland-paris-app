package com.urbanairship.contacts;

import com.urbanairship.contacts.ContactOperation;
import com.urbanairship.http.RequestException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
final class ContactManager$fetchToken$2 extends SuspendLambda implements Function2 {
    final /* synthetic */ String $identifier;
    int label;
    final /* synthetic */ ContactManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContactManager$fetchToken$2(ContactManager contactManager, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = contactManager;
        this.$identifier = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ContactManager$fetchToken$2(this.this$0, this.$identifier, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ContactManager$fetchToken$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.this$0.tokenIfValid();
            String str2 = this.$identifier;
            ContactIdentity lastContactIdentity = this.this$0.getLastContactIdentity();
            if (Intrinsics.areEqual(str2, lastContactIdentity != null ? lastContactIdentity.getContactId() : null) && str != null) {
                return Result.m2967boximpl(Result.m2968constructorimpl(str));
            }
            ContactManager contactManager = this.this$0;
            ContactOperation.Resolve resolve = ContactOperation.Resolve.INSTANCE;
            this.label = 1;
            if (contactManager.performOperation(resolve, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.yieldContactUpdates();
        String str3 = this.$identifier;
        ContactIdentity lastContactIdentity2 = this.this$0.getLastContactIdentity();
        if (Intrinsics.areEqual(str3, lastContactIdentity2 != null ? lastContactIdentity2.getContactId() : null)) {
            String str4 = this.this$0.tokenIfValid();
            if (str4 != null) {
                return Result.m2967boximpl(Result.m2968constructorimpl(str4));
            }
            Result.Companion companion = Result.INSTANCE;
            return Result.m2967boximpl(Result.m2968constructorimpl(ResultKt.createFailure(new RequestException("Failed to refresh token"))));
        }
        Result.Companion companion2 = Result.INSTANCE;
        return Result.m2967boximpl(Result.m2968constructorimpl(ResultKt.createFailure(new RequestException("Stale contact Id"))));
    }
}
