package com.urbanairship.iam.adapter;

import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.iam.adapter.CustomDisplayAdapter;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/iam/adapter/CustomDisplayAdapterWrapper;", "Lcom/urbanairship/iam/adapter/DisplayAdapter;", "adapter", "Lcom/urbanairship/iam/adapter/CustomDisplayAdapter;", "(Lcom/urbanairship/iam/adapter/CustomDisplayAdapter;)V", "getAdapter", "()Lcom/urbanairship/iam/adapter/CustomDisplayAdapter;", "isReady", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", "display", "Lcom/urbanairship/iam/adapter/DisplayResult;", "context", "Landroid/content/Context;", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;", "(Landroid/content/Context;Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CustomDisplayAdapterWrapper implements DisplayAdapter {
    private final CustomDisplayAdapter adapter;

    /* renamed from: com.urbanairship.iam.adapter.CustomDisplayAdapterWrapper$display$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomDisplayAdapterWrapper.this.display(null, null, this);
        }
    }

    public CustomDisplayAdapterWrapper(@NotNull CustomDisplayAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
    }

    @NotNull
    public final CustomDisplayAdapter getAdapter() {
        return this.adapter;
    }

    @Override // com.urbanairship.iam.adapter.DisplayAdapter
    @NotNull
    public StateFlow<Boolean> isReady() {
        CustomDisplayAdapter customDisplayAdapter = this.adapter;
        if (customDisplayAdapter instanceof CustomDisplayAdapter.CallbackAdapter) {
            return FlowKt.asStateFlow(StateFlowKt.MutableStateFlow(Boolean.TRUE));
        }
        if (customDisplayAdapter instanceof CustomDisplayAdapter.SuspendingAdapter) {
            return ((CustomDisplayAdapter.SuspendingAdapter) customDisplayAdapter).isReady();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.urbanairship.iam.adapter.DisplayAdapter
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object display(@org.jetbrains.annotations.NotNull android.content.Context r9, @org.jetbrains.annotations.NotNull com.urbanairship.iam.analytics.InAppMessageAnalyticsInterface r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.iam.adapter.DisplayResult> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.adapter.CustomDisplayAdapterWrapper.display(android.content.Context, com.urbanairship.iam.analytics.InAppMessageAnalyticsInterface, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
