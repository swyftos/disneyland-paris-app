package com.urbanairship.permission;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
final class PermissionsManager$suspendingRequestPermission$result$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ boolean $enableAirshipUsageOnGrant;
    final /* synthetic */ Permission $permission;
    Object L$0;
    int label;
    final /* synthetic */ PermissionsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PermissionsManager$suspendingRequestPermission$result$1(PermissionsManager permissionsManager, Permission permission, boolean z, Continuation continuation) {
        super(2, continuation);
        this.this$0 = permissionsManager;
        this.$permission = permission;
        this.$enableAirshipUsageOnGrant = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PermissionsManager$suspendingRequestPermission$result$1(this.this$0, this.$permission, this.$enableAirshipUsageOnGrant, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PermissionsManager$suspendingRequestPermission$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d8 A[LOOP:0: B:32:0x00d2->B:34:0x00d8, LOOP_END] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L23
            if (r1 == r4) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r0 = r7.L$0
            kotlinx.coroutines.flow.Flow r0 = (kotlinx.coroutines.flow.Flow) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L81
        L17:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1f:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4e
        L23:
            kotlin.ResultKt.throwOnFailure(r8)
            com.urbanairship.permission.PermissionsManager r8 = r7.this$0
            com.urbanairship.permission.Permission r1 = r7.$permission
            com.urbanairship.permission.PermissionDelegate r8 = com.urbanairship.permission.PermissionsManager.access$getDelegate(r8, r1)
            if (r8 != 0) goto L35
            com.urbanairship.permission.PermissionRequestResult r7 = com.urbanairship.permission.PermissionRequestResult.notDetermined()
            return r7
        L35:
            com.urbanairship.permission.PermissionsManager r1 = r7.this$0
            java.util.Map r1 = com.urbanairship.permission.PermissionsManager.access$getPendingRequestResults$p(r1)
            com.urbanairship.permission.Permission r5 = r7.$permission
            java.lang.Object r1 = r1.get(r5)
            kotlinx.coroutines.flow.Flow r1 = (kotlinx.coroutines.flow.Flow) r1
            if (r1 == 0) goto L4f
            r7.label = r4
            java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.first(r1, r7)
            if (r8 != r0) goto L4e
            return r0
        L4e:
            return r8
        L4f:
            com.urbanairship.permission.PermissionsManager$suspendingRequestPermission$result$1$1 r1 = new com.urbanairship.permission.PermissionsManager$suspendingRequestPermission$result$1$1
            com.urbanairship.permission.Permission r5 = r7.$permission
            r1.<init>()
            com.urbanairship.UALog.d$default(r3, r1, r4, r3)
            com.urbanairship.permission.PermissionsManager r1 = r7.this$0
            android.content.Context r1 = com.urbanairship.permission.PermissionsManager.access$getContext$p(r1)
            com.urbanairship.permission.PermissionsManager r5 = r7.this$0
            kotlinx.coroutines.CoroutineScope r5 = com.urbanairship.permission.PermissionsManager.access$getPermissionsScope$p(r5)
            kotlinx.coroutines.flow.Flow r8 = com.urbanairship.permission.PermissionsManagerKt.access$requestPermissionFlow(r8, r1, r5)
            com.urbanairship.permission.PermissionsManager r1 = r7.this$0
            java.util.Map r1 = com.urbanairship.permission.PermissionsManager.access$getPendingRequestResults$p(r1)
            com.urbanairship.permission.Permission r5 = r7.$permission
            r1.put(r5, r8)
            r7.L$0 = r8
            r7.label = r2
            java.lang.Object r1 = kotlinx.coroutines.flow.FlowKt.first(r8, r7)
            if (r1 != r0) goto L7f
            return r0
        L7f:
            r0 = r8
            r8 = r1
        L81:
            com.urbanairship.permission.PermissionRequestResult r8 = (com.urbanairship.permission.PermissionRequestResult) r8
            com.urbanairship.permission.PermissionsManager r1 = r7.this$0
            com.urbanairship.permission.Permission r2 = r7.$permission
            com.urbanairship.permission.PermissionStatus r5 = r8.getPermissionStatus()
            java.lang.String r6 = "getPermissionStatus(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            com.urbanairship.permission.PermissionsManager.access$updatePermissionStatus(r1, r2, r5)
            com.urbanairship.permission.PermissionsManager r1 = r7.this$0
            java.util.Map r1 = com.urbanairship.permission.PermissionsManager.access$getPendingRequestResults$p(r1)
            com.urbanairship.permission.Permission r2 = r7.$permission
            java.lang.Object r1 = r1.get(r2)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r0)
            if (r0 == 0) goto Lb0
            com.urbanairship.permission.PermissionsManager r0 = r7.this$0
            java.util.Map r0 = com.urbanairship.permission.PermissionsManager.access$getPendingRequestResults$p(r0)
            com.urbanairship.permission.Permission r1 = r7.$permission
            r0.remove(r1)
        Lb0:
            com.urbanairship.permission.PermissionsManager$suspendingRequestPermission$result$1$2 r0 = new com.urbanairship.permission.PermissionsManager$suspendingRequestPermission$result$1$2
            com.urbanairship.permission.Permission r1 = r7.$permission
            r0.<init>()
            com.urbanairship.UALog.d$default(r3, r0, r4, r3)
            com.urbanairship.permission.PermissionStatus r0 = r8.getPermissionStatus()
            com.urbanairship.permission.PermissionStatus r1 = com.urbanairship.permission.PermissionStatus.GRANTED
            if (r0 != r1) goto Le2
            boolean r0 = r7.$enableAirshipUsageOnGrant
            if (r0 == 0) goto Le2
            com.urbanairship.permission.PermissionsManager r0 = r7.this$0
            java.util.List r0 = com.urbanairship.permission.PermissionsManager.access$getAirshipEnablers$p(r0)
            com.urbanairship.permission.Permission r7 = r7.$permission
            java.util.Iterator r0 = r0.iterator()
        Ld2:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Le2
            java.lang.Object r1 = r0.next()
            androidx.core.util.Consumer r1 = (androidx.core.util.Consumer) r1
            r1.accept(r7)
            goto Ld2
        Le2:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.permission.PermissionsManager$suspendingRequestPermission$result$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
