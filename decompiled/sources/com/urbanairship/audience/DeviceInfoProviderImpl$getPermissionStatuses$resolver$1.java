package com.urbanairship.audience;

import com.urbanairship.UAirship;
import com.urbanairship.permission.Permission;
import com.urbanairship.permission.PermissionStatus;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
final class DeviceInfoProviderImpl$getPermissionStatuses$resolver$1 extends SuspendLambda implements Function2 {
    /* synthetic */ Object L$0;
    int label;

    DeviceInfoProviderImpl$getPermissionStatuses$resolver$1(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DeviceInfoProviderImpl$getPermissionStatuses$resolver$1 deviceInfoProviderImpl$getPermissionStatuses$resolver$1 = new DeviceInfoProviderImpl$getPermissionStatuses$resolver$1(continuation);
        deviceInfoProviderImpl$getPermissionStatuses$resolver$1.L$0 = obj;
        return deviceInfoProviderImpl$getPermissionStatuses$resolver$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Permission permission, Continuation continuation) {
        return ((DeviceInfoProviderImpl$getPermissionStatuses$resolver$1) create(permission, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Permission permission = (Permission) this.L$0;
            this.L$0 = permission;
            this.label = 1;
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(this));
            PermissionStatus result = UAirship.shared().getPermissionsManager().checkPermissionStatus(permission).getResult();
            Result.Companion companion = Result.INSTANCE;
            if (result == null) {
                result = PermissionStatus.NOT_DETERMINED;
            }
            safeContinuation.resumeWith(Result.m2968constructorimpl(result));
            obj = safeContinuation.getOrThrow();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
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
