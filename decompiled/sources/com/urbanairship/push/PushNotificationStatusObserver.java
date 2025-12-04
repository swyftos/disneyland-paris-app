package com.urbanairship.push;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/push/PushNotificationStatusObserver;", "", "initialValue", "Lcom/urbanairship/push/PushNotificationStatus;", "listenerDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/urbanairship/push/PushNotificationStatus;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_pushNotificationStatusFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "changeListeners", "", "Lcom/urbanairship/push/PushNotificationStatusListener;", "getChangeListeners", "()Ljava/util/List;", "initialStateSkipped", "", "listenerScope", "Lkotlinx/coroutines/CoroutineScope;", "pushNotificationStatusFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getPushNotificationStatusFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "update", "", "status", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushNotificationStatusObserver {
    private final MutableStateFlow _pushNotificationStatusFlow;
    private final List changeListeners;
    private boolean initialStateSkipped;
    private final CoroutineScope listenerScope;
    private final StateFlow pushNotificationStatusFlow;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PushNotificationStatusObserver(@NotNull PushNotificationStatus initialValue) {
        this(initialValue, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
    }

    @JvmOverloads
    public PushNotificationStatusObserver(@NotNull PushNotificationStatus initialValue, @NotNull CoroutineDispatcher listenerDispatcher) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(listenerDispatcher, "listenerDispatcher");
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(listenerDispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.listenerScope = CoroutineScope;
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(initialValue);
        this._pushNotificationStatusFlow = MutableStateFlow;
        this.pushNotificationStatusFlow = MutableStateFlow;
        this.changeListeners = new CopyOnWriteArrayList();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(initialValue, null), 3, null);
    }

    public /* synthetic */ PushNotificationStatusObserver(PushNotificationStatus pushNotificationStatus, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pushNotificationStatus, (i & 2) != 0 ? Dispatchers.getMain() : coroutineDispatcher);
    }

    @NotNull
    public final StateFlow<PushNotificationStatus> getPushNotificationStatusFlow() {
        return this.pushNotificationStatusFlow;
    }

    @NotNull
    public final List<PushNotificationStatusListener> getChangeListeners() {
        return this.changeListeners;
    }

    /* renamed from: com.urbanairship.push.PushNotificationStatusObserver$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ PushNotificationStatus $initialValue;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PushNotificationStatus pushNotificationStatus, Continuation continuation) {
            super(2, continuation);
            this.$initialValue = pushNotificationStatus;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PushNotificationStatusObserver.this.new AnonymousClass1(this.$initialValue, continuation);
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
                StateFlow<PushNotificationStatus> pushNotificationStatusFlow = PushNotificationStatusObserver.this.getPushNotificationStatusFlow();
                final PushNotificationStatusObserver pushNotificationStatusObserver = PushNotificationStatusObserver.this;
                final PushNotificationStatus pushNotificationStatus = this.$initialValue;
                FlowCollector<? super PushNotificationStatus> flowCollector = new FlowCollector() { // from class: com.urbanairship.push.PushNotificationStatusObserver.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(PushNotificationStatus pushNotificationStatus2, Continuation continuation) {
                        if (pushNotificationStatusObserver.initialStateSkipped || !Intrinsics.areEqual(pushNotificationStatus2, pushNotificationStatus)) {
                            Iterator<T> it = pushNotificationStatusObserver.getChangeListeners().iterator();
                            while (it.hasNext()) {
                                ((PushNotificationStatusListener) it.next()).onChange(pushNotificationStatus2);
                            }
                            pushNotificationStatusObserver.initialStateSkipped = true;
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (pushNotificationStatusFlow.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    public final void update(@NotNull PushNotificationStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        this._pushNotificationStatusFlow.tryEmit(status);
    }
}
