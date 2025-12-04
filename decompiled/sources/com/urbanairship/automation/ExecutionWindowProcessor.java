package com.urbanairship.automation;

import android.content.Context;
import android.content.IntentFilter;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.joran.action.Action;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.UALog;
import com.urbanairship.automation.ExecutionWindowResult;
import com.urbanairship.util.Clock;
import com.urbanairship.util.TaskSleeper;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0016\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0082@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"Lcom/urbanairship/automation/ExecutionWindowProcessor;", "", "context", "Landroid/content/Context;", "taskSleeper", "Lcom/urbanairship/util/TaskSleeper;", "clock", "Lcom/urbanairship/util/Clock;", "onEvaluate", "Lkotlin/Function2;", "Lcom/urbanairship/automation/ExecutionWindow;", "Ljava/util/Date;", "Lcom/urbanairship/automation/ExecutionWindowResult;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/urbanairship/util/TaskSleeper;Lcom/urbanairship/util/Clock;Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/CoroutineDispatcher;)V", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "tasksState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lkotlinx/coroutines/Job;", "isActive", "", "window", "listenToTimeZoneChange", "", "nextAvailability", "process", "(Lcom/urbanairship/automation/ExecutionWindow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sleep", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "sleep-VtjQ1oo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExecutionWindowProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExecutionWindowProcessor.kt\ncom/urbanairship/automation/ExecutionWindowProcessor\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,107:1\n226#2,5:108\n226#2,5:113\n*S KotlinDebug\n*F\n+ 1 ExecutionWindowProcessor.kt\ncom/urbanairship/automation/ExecutionWindowProcessor\n*L\n63#1:108,5\n65#1:113,5\n*E\n"})
/* loaded from: classes5.dex */
public final class ExecutionWindowProcessor {
    private final Clock clock;
    private final Function2 onEvaluate;
    private final CoroutineScope scope;
    private final TaskSleeper taskSleeper;
    private final MutableStateFlow tasksState;

    /* renamed from: com.urbanairship.automation.ExecutionWindowProcessor$process$1, reason: invalid class name and case insensitive filesystem */
    static final class C09851 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C09851(Continuation continuation) {
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
                m2783invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2783invoke() {
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
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: sleep-VtjQ1oo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2782sleepVtjQ1oo(long r11, kotlin.coroutines.Continuation r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.urbanairship.automation.ExecutionWindowProcessor$sleep$1
            if (r0 == 0) goto L13
            r0 = r13
            com.urbanairship.automation.ExecutionWindowProcessor$sleep$1 r0 = (com.urbanairship.automation.ExecutionWindowProcessor$sleep$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.ExecutionWindowProcessor$sleep$1 r0 = new com.urbanairship.automation.ExecutionWindowProcessor$sleep$1
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r10 = r0.L$1
            kotlinx.coroutines.Job r10 = (kotlinx.coroutines.Job) r10
            java.lang.Object r11 = r0.L$0
            com.urbanairship.automation.ExecutionWindowProcessor r11 = (com.urbanairship.automation.ExecutionWindowProcessor) r11
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = r10
            r10 = r11
            goto L6f
        L33:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3b:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlinx.coroutines.CoroutineScope r4 = r10.scope
            com.urbanairship.automation.ExecutionWindowProcessor$sleep$job$1 r7 = new com.urbanairship.automation.ExecutionWindowProcessor$sleep$job$1
            r13 = 0
            r7.<init>(r10, r11, r13)
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            kotlinx.coroutines.Job r11 = kotlinx.coroutines.BuildersKt.launch$default(r4, r5, r6, r7, r8, r9)
            kotlinx.coroutines.flow.MutableStateFlow r12 = r10.tasksState
        L50:
            java.lang.Object r13 = r12.getValue()
            r2 = r13
            java.util.Set r2 = (java.util.Set) r2
            java.util.Set r2 = kotlin.collections.SetsKt.plus(r2, r11)
            boolean r13 = r12.compareAndSet(r13, r2)
            if (r13 == 0) goto L50
            r0.L$0 = r10
            r0.L$1 = r11
            r0.label = r3
            java.lang.Object r12 = r11.join(r0)
            if (r12 != r1) goto L6e
            return r1
        L6e:
            r13 = r11
        L6f:
            kotlinx.coroutines.flow.MutableStateFlow r2 = r10.tasksState
        L71:
            java.lang.Object r10 = r2.getValue()
            r11 = r10
            java.util.Set r11 = (java.util.Set) r11
            java.util.Set r11 = kotlin.collections.SetsKt.minus(r11, r13)
            boolean r10 = r2.compareAndSet(r10, r11)
            if (r10 == 0) goto L71
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.ExecutionWindowProcessor.m2782sleepVtjQ1oo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final ExecutionWindowResult nextAvailability(ExecutionWindow window) {
        try {
            return (ExecutionWindowResult) this.onEvaluate.invoke(window, new Date(this.clock.currentTimeMillis()));
        } catch (Exception e) {
            UALog.e(e, new Function0() { // from class: com.urbanairship.automation.ExecutionWindowProcessor.nextAvailability.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to process execution window";
                }
            });
            Duration.Companion companion = Duration.INSTANCE;
            return new ExecutionWindowResult.Retry(DurationKt.toDuration(1, DurationUnit.DAYS), null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object process(@org.jetbrains.annotations.NotNull com.urbanairship.automation.ExecutionWindow r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.urbanairship.automation.ExecutionWindowProcessor.C09851
            if (r0 == 0) goto L13
            r0 = r9
            com.urbanairship.automation.ExecutionWindowProcessor$process$1 r0 = (com.urbanairship.automation.ExecutionWindowProcessor.C09851) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.ExecutionWindowProcessor$process$1 r0 = new com.urbanairship.automation.ExecutionWindowProcessor$process$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.L$1
            com.urbanairship.automation.ExecutionWindow r7 = (com.urbanairship.automation.ExecutionWindow) r7
            java.lang.Object r8 = r0.L$0
            com.urbanairship.automation.ExecutionWindowProcessor r8 = (com.urbanairship.automation.ExecutionWindowProcessor) r8
            kotlin.ResultKt.throwOnFailure(r9)
            r6 = r8
            r8 = r7
            r7 = r6
            goto L3f
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            kotlin.ResultKt.throwOnFailure(r9)
        L3f:
            com.urbanairship.automation.ExecutionWindowResult r9 = r7.nextAvailability(r8)
            com.urbanairship.automation.ExecutionWindowResult$Now r2 = com.urbanairship.automation.ExecutionWindowResult.Now.INSTANCE
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r2)
            if (r2 != 0) goto L62
            boolean r2 = r9 instanceof com.urbanairship.automation.ExecutionWindowResult.Retry
            if (r2 == 0) goto L3f
            com.urbanairship.automation.ExecutionWindowResult$Retry r9 = (com.urbanairship.automation.ExecutionWindowResult.Retry) r9
            long r4 = r9.getDelay()
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = r7.m2782sleepVtjQ1oo(r4, r0)
            if (r9 != r1) goto L3f
            return r1
        L62:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.ExecutionWindowProcessor.process(com.urbanairship.automation.ExecutionWindow, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean isActive(@NotNull ExecutionWindow window) {
        Intrinsics.checkNotNullParameter(window, "window");
        return Intrinsics.areEqual(nextAvailability(window), ExecutionWindowResult.Now.INSTANCE);
    }
}
