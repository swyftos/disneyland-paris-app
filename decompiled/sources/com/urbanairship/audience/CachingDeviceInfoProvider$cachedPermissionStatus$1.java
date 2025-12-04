package com.urbanairship.audience;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
final class CachingDeviceInfoProvider$cachedPermissionStatus$1 extends SuspendLambda implements Function1 {
    int label;
    final /* synthetic */ CachingDeviceInfoProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CachingDeviceInfoProvider$cachedPermissionStatus$1(CachingDeviceInfoProvider cachingDeviceInfoProvider, Continuation continuation) {
        super(1, continuation);
        this.this$0 = cachingDeviceInfoProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new CachingDeviceInfoProvider$cachedPermissionStatus$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((CachingDeviceInfoProvider$cachedPermissionStatus$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DeviceInfoProviderImpl deviceInfoProviderImpl = this.this$0.deviceInfoProviderImpl;
            this.label = 1;
            obj = deviceInfoProviderImpl.getPermissionStatuses(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
