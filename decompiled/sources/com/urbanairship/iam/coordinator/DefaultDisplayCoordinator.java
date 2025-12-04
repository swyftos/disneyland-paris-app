package com.urbanairship.iam.coordinator;

import ch.qos.logback.core.joran.action.Action;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.util.DerivedStateFlowKt;
import com.urbanairship.util.TaskSleeper;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\"B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u001dH\u0002R,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Lcom/urbanairship/iam/coordinator/DefaultDisplayCoordinator;", "Lcom/urbanairship/iam/coordinator/DisplayCoordinator;", "displayInterval", "Lkotlin/time/Duration;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "sleeper", "Lcom/urbanairship/util/TaskSleeper;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(JLcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/util/TaskSleeper;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "value", "getDisplayInterval-UwyO8pc", "()J", "setDisplayInterval-LRDsOJo", "(J)V", "J", "isReady", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", "lockState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/urbanairship/iam/coordinator/DefaultDisplayCoordinator$LockState;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "unlockJob", "Lkotlinx/coroutines/Job;", "messageFinishedDisplaying", "", "message", "Lcom/urbanairship/iam/InAppMessage;", "messageWillDisplay", "startUnlocking", "LockState", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDefaultDisplayCoordinator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultDisplayCoordinator.kt\ncom/urbanairship/iam/coordinator/DefaultDisplayCoordinator\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,79:1\n226#2,5:80\n*S KotlinDebug\n*F\n+ 1 DefaultDisplayCoordinator.kt\ncom/urbanairship/iam/coordinator/DefaultDisplayCoordinator\n*L\n61#1:80,5\n*E\n"})
/* loaded from: classes5.dex */
public final class DefaultDisplayCoordinator implements DisplayCoordinator {
    private long displayInterval;
    private final StateFlow isReady;
    private MutableStateFlow lockState;
    private final CoroutineScope scope;
    private final TaskSleeper sleeper;
    private Job unlockJob;

    public /* synthetic */ DefaultDisplayCoordinator(long j, ActivityMonitor activityMonitor, TaskSleeper taskSleeper, CoroutineDispatcher coroutineDispatcher, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, activityMonitor, taskSleeper, coroutineDispatcher);
    }

    private DefaultDisplayCoordinator(long j, ActivityMonitor activityMonitor, TaskSleeper sleeper, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        Intrinsics.checkNotNullParameter(sleeper, "sleeper");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.sleeper = sleeper;
        this.scope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(LockState.UNLOCKED);
        this.lockState = MutableStateFlow;
        this.isReady = DerivedStateFlowKt.combineStates(MutableStateFlow, activityMonitor.getForegroundState(), new Function2() { // from class: com.urbanairship.iam.coordinator.DefaultDisplayCoordinator.isReady.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((LockState) obj, ((Boolean) obj2).booleanValue());
            }

            public final Boolean invoke(LockState lockState, boolean z) {
                Intrinsics.checkNotNullParameter(lockState, "lockState");
                return Boolean.valueOf(lockState == LockState.UNLOCKED && z);
            }
        });
        this.displayInterval = j;
    }

    public /* synthetic */ DefaultDisplayCoordinator(long j, ActivityMonitor activityMonitor, TaskSleeper taskSleeper, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, activityMonitor, (i & 4) != 0 ? TaskSleeper.INSTANCE.getDefault() : taskSleeper, (i & 8) != 0 ? AirshipDispatchers.INSTANCE.getIO() : coroutineDispatcher, null);
    }

    @Override // com.urbanairship.iam.coordinator.DisplayCoordinator
    @NotNull
    public StateFlow<Boolean> isReady() {
        return this.isReady;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static final class LockState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LockState[] $VALUES;
        public static final LockState UNLOCKED = new LockState("UNLOCKED", 0);
        public static final LockState LOCKED = new LockState("LOCKED", 1);
        public static final LockState UNLOCKING = new LockState("UNLOCKING", 2);

        private static final /* synthetic */ LockState[] $values() {
            return new LockState[]{UNLOCKED, LOCKED, UNLOCKING};
        }

        public static LockState valueOf(String str) {
            return (LockState) Enum.valueOf(LockState.class, str);
        }

        public static LockState[] values() {
            return (LockState[]) $VALUES.clone();
        }

        private LockState(String str, int i) {
        }

        static {
            LockState[] lockStateArr$values = $values();
            $VALUES = lockStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(lockStateArr$values);
        }
    }

    /* renamed from: getDisplayInterval-UwyO8pc, reason: not valid java name and from getter */
    public final long getDisplayInterval() {
        return this.displayInterval;
    }

    /* renamed from: setDisplayInterval-LRDsOJo, reason: not valid java name */
    public final void m2893setDisplayIntervalLRDsOJo(long j) {
        this.displayInterval = j;
        startUnlocking();
    }

    @Override // com.urbanairship.iam.coordinator.DisplayCoordinator
    public void messageWillDisplay(@NotNull InAppMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.lockState.setValue(LockState.LOCKED);
    }

    @Override // com.urbanairship.iam.coordinator.DisplayCoordinator
    public void messageFinishedDisplaying(@NotNull InAppMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        startUnlocking();
    }

    private final void startUnlocking() {
        Object value;
        LockState lockState;
        Job job = this.unlockJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        MutableStateFlow mutableStateFlow = this.lockState;
        do {
            value = mutableStateFlow.getValue();
            lockState = (LockState) value;
            if (lockState != LockState.UNLOCKED) {
                lockState = LockState.UNLOCKING;
            }
        } while (!mutableStateFlow.compareAndSet(value, lockState));
        if (this.lockState.getValue() == LockState.UNLOCKING) {
            this.unlockJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass2(null), 3, null);
        }
    }

    /* renamed from: com.urbanairship.iam.coordinator.DefaultDisplayCoordinator$startUnlocking$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = DefaultDisplayCoordinator.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                TaskSleeper taskSleeper = DefaultDisplayCoordinator.this.sleeper;
                long displayInterval = DefaultDisplayCoordinator.this.getDisplayInterval();
                this.L$0 = coroutineScope2;
                this.label = 1;
                if (taskSleeper.m2958sleepVtjQ1oo(displayInterval, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope = coroutineScope2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                DefaultDisplayCoordinator.this.lockState.setValue(LockState.UNLOCKED);
            }
            return Unit.INSTANCE;
        }
    }
}
