package com.urbanairship.audience;

import com.urbanairship.contacts.StableContactInfo;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
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

    /* JADX WARN: Code duplicated, block: B:23:0x0075 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0076  */
    /* JADX WARN: Code duplicated, block: B:27:0x008e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x008f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        Object objResolveResult;
        String str3;
        String str4;
        AirshipDeviceAudienceResult airshipDeviceAudienceResult;
        HashChecker hashChecker;
        AudienceHashSelector audienceHashSelector;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                str = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                str2 = (String) obj;
                HashChecker hashChecker2 = this.this$0;
                AudienceHashSelector audienceHashSelector2 = this.$hashSelector;
                this.L$0 = str;
                this.L$1 = str2;
                this.label = 3;
                objResolveResult = hashChecker2.resolveResult(audienceHashSelector2, str, str2, this);
                if (objResolveResult == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str3 = str2;
                str4 = str;
                obj = objResolveResult;
            } else {
                if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AirshipDeviceAudienceResult airshipDeviceAudienceResult2 = (AirshipDeviceAudienceResult) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return airshipDeviceAudienceResult2;
                }
                String str5 = (String) this.L$1;
                String str6 = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                str3 = str5;
                str4 = str6;
            }
            airshipDeviceAudienceResult = (AirshipDeviceAudienceResult) obj;
            hashChecker = this.this$0;
            audienceHashSelector = this.$hashSelector;
            this.L$0 = airshipDeviceAudienceResult;
            this.L$1 = null;
            this.label = 4;
            if (hashChecker.cacheResult(audienceHashSelector, airshipDeviceAudienceResult, str4, str3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return airshipDeviceAudienceResult;
        }
        ResultKt.throwOnFailure(obj);
        DeviceInfoProvider deviceInfoProvider = this.$deviceInfoProvider;
        this.label = 1;
        obj = deviceInfoProvider.getStableContactInfo(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        String contactId = ((StableContactInfo) obj).getContactId();
        DeviceInfoProvider deviceInfoProvider2 = this.$deviceInfoProvider;
        this.L$0 = contactId;
        this.label = 2;
        Object channelId = deviceInfoProvider2.getChannelId(this);
        if (channelId == coroutine_suspended) {
            return coroutine_suspended;
        }
        str = contactId;
        obj = channelId;
        str2 = (String) obj;
        HashChecker hashChecker3 = this.this$0;
        AudienceHashSelector audienceHashSelector3 = this.$hashSelector;
        this.L$0 = str;
        this.L$1 = str2;
        this.label = 3;
        objResolveResult = hashChecker3.resolveResult(audienceHashSelector3, str, str2, this);
        if (objResolveResult == coroutine_suspended) {
            return coroutine_suspended;
        }
        str3 = str2;
        str4 = str;
        obj = objResolveResult;
        airshipDeviceAudienceResult = (AirshipDeviceAudienceResult) obj;
        hashChecker = this.this$0;
        audienceHashSelector = this.$hashSelector;
        this.L$0 = airshipDeviceAudienceResult;
        this.L$1 = null;
        this.label = 4;
        if (hashChecker.cacheResult(audienceHashSelector, airshipDeviceAudienceResult, str4, str3, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return airshipDeviceAudienceResult;
    }
}
