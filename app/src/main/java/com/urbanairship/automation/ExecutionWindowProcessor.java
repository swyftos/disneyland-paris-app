package com.urbanairship.automation;

import android.content.Context;
import android.content.IntentFilter;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.UALog;
import com.urbanairship.util.Clock;
import com.urbanairship.util.TaskSleeper;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0016\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0082@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, m1836d2 = {"Lcom/urbanairship/automation/ExecutionWindowProcessor;", "", "context", "Landroid/content/Context;", "taskSleeper", "Lcom/urbanairship/util/TaskSleeper;", "clock", "Lcom/urbanairship/util/Clock;", "onEvaluate", "Lkotlin/Function2;", "Lcom/urbanairship/automation/ExecutionWindow;", "Ljava/util/Date;", "Lcom/urbanairship/automation/ExecutionWindowResult;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/urbanairship/util/TaskSleeper;Lcom/urbanairship/util/Clock;Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/CoroutineDispatcher;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "tasksState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lkotlinx/coroutines/Job;", "isActive", "", "window", "listenToTimeZoneChange", "", "nextAvailability", "process", "(Lcom/urbanairship/automation/ExecutionWindow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sleep", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "sleep-VtjQ1oo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nExecutionWindowProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExecutionWindowProcessor.kt\ncom/urbanairship/automation/ExecutionWindowProcessor\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,107:1\n226#2,5:108\n226#2,5:113\n*S KotlinDebug\n*F\n+ 1 ExecutionWindowProcessor.kt\ncom/urbanairship/automation/ExecutionWindowProcessor\n*L\n63#1:108,5\n65#1:113,5\n*E\n"})
public final class ExecutionWindowProcessor {
    private final Clock clock;
    private final Function2 onEvaluate;
    private final CoroutineScope scope;
    private final TaskSleeper taskSleeper;
    private final MutableStateFlow tasksState;

    /* JADX INFO: renamed from: com.urbanairship.automation.ExecutionWindowProcessor$process$1 */
    static final class C49711 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C49711(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExecutionWindowProcessor.this.process(null, this);
        }
    }

    public ExecutionWindowProcessor(@NotNull Context context, @NotNull TaskSleeper taskSleeper, @NotNull Clock clock, @NotNull Function2<? super ExecutionWindow, ? super Date, ? extends ExecutionWindowResult> onEvaluate, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(taskSleeper, "taskSleeper");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(onEvaluate, "onEvaluate");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.taskSleeper = taskSleeper;
        this.clock = clock;
        this.onEvaluate = onEvaluate;
        this.scope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.tasksState = StateFlowKt.MutableStateFlow(SetsKt.emptySet());
        listenToTimeZoneChange(context);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ExecutionWindowProcessor(Context context, TaskSleeper taskSleeper, Clock DEFAULT_CLOCK, Function2 function2, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        TaskSleeper taskSleeper2 = (i & 2) != 0 ? TaskSleeper.INSTANCE.getDefault() : taskSleeper;
        if ((i & 4) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(context, taskSleeper2, DEFAULT_CLOCK, (i & 8) != 0 ? new Function2() { // from class: com.urbanairship.automation.ExecutionWindowProcessor.1
            @Override // kotlin.jvm.functions.Function2
            public final ExecutionWindowResult invoke(ExecutionWindow window, Date date) {
                Intrinsics.checkNotNullParameter(window, "window");
                Intrinsics.checkNotNullParameter(date, "date");
                return ExecutionWindow.nextAvailability$urbanairship_automation_release$default(window, date, null, 2, null);
            }
        } : function2, (i & 16) != 0 ? AirshipDispatchers.INSTANCE.getIO() : coroutineDispatcher);
    }

    private final void listenToTimeZoneChange(Context context) {
        TimeZoneReceiver shared = TimeZoneReceiver.INSTANCE.getShared();
        shared.setHandler(new Function0() { // from class: com.urbanairship.automation.ExecutionWindowProcessor.listenToTimeZoneChange.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m5025invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m5025invoke() {
                Object value;
                MutableStateFlow mutableStateFlow = ExecutionWindowProcessor.this.tasksState;
                do {
                    value = mutableStateFlow.getValue();
                    Iterator it = ((Set) value).iterator();
                    while (it.hasNext()) {
                        Job.DefaultImpls.cancel$default((Job) it.next(), (CancellationException) null, 1, (Object) null);
                    }
                } while (!mutableStateFlow.compareAndSet(value, SetsKt.emptySet()));
            }
        });
        try {
            context.unregisterReceiver(shared);
        } catch (Exception unused) {
        }
        context.registerReceiver(shared, new IntentFilter("android.intent.action.TIMEZONE_CHANGED"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: sleep-VtjQ1oo, reason: not valid java name */
    public final Object m5024sleepVtjQ1oo(long j, Continuation continuation) {
        ExecutionWindowProcessor$sleep$1 executionWindowProcessor$sleep$1;
        Object value;
        Job job;
        Object value2;
        if (continuation instanceof ExecutionWindowProcessor$sleep$1) {
            executionWindowProcessor$sleep$1 = (ExecutionWindowProcessor$sleep$1) continuation;
            int i = executionWindowProcessor$sleep$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                executionWindowProcessor$sleep$1.label = i - Integer.MIN_VALUE;
            } else {
                executionWindowProcessor$sleep$1 = new ExecutionWindowProcessor$sleep$1(this, continuation);
            }
        } else {
            executionWindowProcessor$sleep$1 = new ExecutionWindowProcessor$sleep$1(this, continuation);
        }
        Object obj = executionWindowProcessor$sleep$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = executionWindowProcessor$sleep$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new ExecutionWindowProcessor$sleep$job$1(this, j, null), 3, null);
            MutableStateFlow mutableStateFlow = this.tasksState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, SetsKt.plus((Set<? extends Job>) value, jobLaunch$default)));
            executionWindowProcessor$sleep$1.L$0 = this;
            executionWindowProcessor$sleep$1.L$1 = jobLaunch$default;
            executionWindowProcessor$sleep$1.label = 1;
            if (jobLaunch$default.join(executionWindowProcessor$sleep$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            job = jobLaunch$default;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Job job2 = (Job) executionWindowProcessor$sleep$1.L$1;
            ExecutionWindowProcessor executionWindowProcessor = (ExecutionWindowProcessor) executionWindowProcessor$sleep$1.L$0;
            ResultKt.throwOnFailure(obj);
            job = job2;
            this = executionWindowProcessor;
        }
        MutableStateFlow mutableStateFlow2 = this.tasksState;
        do {
            value2 = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value2, SetsKt.minus((Set<? extends Job>) value2, job)));
        return Unit.INSTANCE;
    }

    private final ExecutionWindowResult nextAvailability(ExecutionWindow window) {
        try {
            return (ExecutionWindowResult) this.onEvaluate.invoke(window, new Date(this.clock.currentTimeMillis()));
        } catch (Exception e) {
            UALog.m1747e(e, new Function0() { // from class: com.urbanairship.automation.ExecutionWindowProcessor.nextAvailability.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to process execution window";
                }
            });
            Duration.Companion companion = Duration.INSTANCE;
            return new ExecutionWindowResult.Retry(DurationKt.toDuration(1, DurationUnit.DAYS), null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object process(@NotNull ExecutionWindow executionWindow, @NotNull Continuation<? super Unit> continuation) {
        C49711 c49711;
        if (continuation instanceof C49711) {
            c49711 = (C49711) continuation;
            int i = c49711.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c49711.label = i - Integer.MIN_VALUE;
            } else {
                c49711 = new C49711(continuation);
            }
        } else {
            c49711 = new C49711(continuation);
        }
        Object obj = c49711.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c49711.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ExecutionWindow executionWindow2 = (ExecutionWindow) c49711.L$1;
            ExecutionWindowProcessor executionWindowProcessor = (ExecutionWindowProcessor) c49711.L$0;
            ResultKt.throwOnFailure(obj);
            executionWindow = executionWindow2;
            this = executionWindowProcessor;
        }
        while (true) {
            ExecutionWindowResult executionWindowResultNextAvailability = this.nextAvailability(executionWindow);
            if (!Intrinsics.areEqual(executionWindowResultNextAvailability, ExecutionWindowResult.Now.INSTANCE)) {
                if (executionWindowResultNextAvailability instanceof ExecutionWindowResult.Retry) {
                    long delay = ((ExecutionWindowResult.Retry) executionWindowResultNextAvailability).getDelay();
                    c49711.L$0 = this;
                    c49711.L$1 = executionWindow;
                    c49711.label = 1;
                    if (this.m5024sleepVtjQ1oo(delay, c49711) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                return Unit.INSTANCE;
            }
        }
    }

    public final boolean isActive(@NotNull ExecutionWindow window) {
        Intrinsics.checkNotNullParameter(window, "window");
        return Intrinsics.areEqual(nextAvailability(window), ExecutionWindowResult.Now.INSTANCE);
    }
}
