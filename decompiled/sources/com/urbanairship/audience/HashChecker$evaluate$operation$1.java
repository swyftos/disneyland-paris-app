package com.urbanairship.audience;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
final class HashChecker$evaluate$operation$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ DeviceInfoProvider $deviceInfoProvider;
    final /* synthetic */ AudienceHashSelector $hashSelector;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ HashChecker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HashChecker$evaluate$operation$1(DeviceInfoProvider deviceInfoProvider, HashChecker hashChecker, AudienceHashSelector audienceHashSelector, Continuation continuation) {
        super(2, continuation);
        this.$deviceInfoProvider = deviceInfoProvider;
        this.this$0 = hashChecker;
        this.$hashSelector = audienceHashSelector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HashChecker$evaluate$operation$1(this.$deviceInfoProvider, this.this$0, this.$hashSelector, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((HashChecker$evaluate$operation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L3f
            if (r1 == r5) goto L3b
            if (r1 == r4) goto L33
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            java.lang.Object r10 = r10.L$0
            com.urbanairship.audience.AirshipDeviceAudienceResult r10 = (com.urbanairship.audience.AirshipDeviceAudienceResult) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L90
        L1d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L25:
            java.lang.Object r1 = r10.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r3 = r10.L$0
            java.lang.String r3 = (java.lang.String) r3
            kotlin.ResultKt.throwOnFailure(r11)
            r7 = r1
            r6 = r3
            goto L79
        L33:
            java.lang.Object r1 = r10.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L63
        L3b:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L4d
        L3f:
            kotlin.ResultKt.throwOnFailure(r11)
            com.urbanairship.audience.DeviceInfoProvider r11 = r10.$deviceInfoProvider
            r10.label = r5
            java.lang.Object r11 = r11.getStableContactInfo(r10)
            if (r11 != r0) goto L4d
            return r0
        L4d:
            com.urbanairship.contacts.StableContactInfo r11 = (com.urbanairship.contacts.StableContactInfo) r11
            java.lang.String r11 = r11.getContactId()
            com.urbanairship.audience.DeviceInfoProvider r1 = r10.$deviceInfoProvider
            r10.L$0 = r11
            r10.label = r4
            java.lang.Object r1 = r1.getChannelId(r10)
            if (r1 != r0) goto L60
            return r0
        L60:
            r9 = r1
            r1 = r11
            r11 = r9
        L63:
            java.lang.String r11 = (java.lang.String) r11
            com.urbanairship.audience.HashChecker r4 = r10.this$0
            com.urbanairship.audience.AudienceHashSelector r5 = r10.$hashSelector
            r10.L$0 = r1
            r10.L$1 = r11
            r10.label = r3
            java.lang.Object r3 = com.urbanairship.audience.HashChecker.access$resolveResult(r4, r5, r1, r11, r10)
            if (r3 != r0) goto L76
            return r0
        L76:
            r7 = r11
            r6 = r1
            r11 = r3
        L79:
            com.urbanairship.audience.AirshipDeviceAudienceResult r11 = (com.urbanairship.audience.AirshipDeviceAudienceResult) r11
            com.urbanairship.audience.HashChecker r3 = r10.this$0
            com.urbanairship.audience.AudienceHashSelector r4 = r10.$hashSelector
            r10.L$0 = r11
            r1 = 0
            r10.L$1 = r1
            r10.label = r2
            r5 = r11
            r8 = r10
            java.lang.Object r10 = com.urbanairship.audience.HashChecker.access$cacheResult(r3, r4, r5, r6, r7, r8)
            if (r10 != r0) goto L8f
            return r0
        L8f:
            r10 = r11
        L90:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.audience.HashChecker$evaluate$operation$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
