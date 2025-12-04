package com.urbanairship.android.framework.proxy;

import com.tagcommander.lib.serverside.ETCPurchaseStatus;
import com.urbanairship.embedded.AirshipEmbeddedInfo;
import com.urbanairship.embedded.AirshipEmbeddedObserver;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/urbanairship/android/framework/proxy/PendingEmbedded;", "", "()V", "_pending", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/urbanairship/embedded/AirshipEmbeddedInfo;", "dispatcher", "Lkotlinx/coroutines/CoroutineScope;", ETCPurchaseStatus.PENDING, "Lkotlinx/coroutines/flow/StateFlow;", "getPending", "()Lkotlinx/coroutines/flow/StateFlow;", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PendingEmbedded {

    @NotNull
    public static final PendingEmbedded INSTANCE = new PendingEmbedded();
    private static final MutableStateFlow _pending;
    private static final CoroutineScope dispatcher;
    private static final StateFlow pending;

    private PendingEmbedded() {
    }

    static {
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        dispatcher = CoroutineScope;
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        _pending = MutableStateFlow;
        pending = FlowKt.asStateFlow(MutableStateFlow);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    @NotNull
    public final StateFlow<List<AirshipEmbeddedInfo>> getPending() {
        return pending;
    }

    /* renamed from: com.urbanairship.android.framework.proxy.PendingEmbedded$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<List<AirshipEmbeddedInfo>> embeddedViewInfoFlow = new AirshipEmbeddedObserver(new Function1() { // from class: com.urbanairship.android.framework.proxy.PendingEmbedded.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(AirshipEmbeddedInfo it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.TRUE;
                    }
                }).getEmbeddedViewInfoFlow();
                AnonymousClass2 anonymousClass2 = new FlowCollector() { // from class: com.urbanairship.android.framework.proxy.PendingEmbedded.1.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(List list, Continuation continuation) {
                        PendingEmbedded._pending.setValue(list);
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (embeddedViewInfoFlow.collect(anonymousClass2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
