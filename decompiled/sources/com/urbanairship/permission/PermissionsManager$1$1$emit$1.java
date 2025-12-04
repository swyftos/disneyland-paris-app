package com.urbanairship.permission;

import android.app.Activity;
import com.urbanairship.permission.PermissionsManager;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* loaded from: classes5.dex */
final class PermissionsManager$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PermissionsManager.AnonymousClass1.C01551 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PermissionsManager$1$1$emit$1(PermissionsManager.AnonymousClass1.C01551 c01551, Continuation continuation) {
        super(continuation);
        this.this$0 = c01551;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Activity) null, (Continuation) this);
    }
}
