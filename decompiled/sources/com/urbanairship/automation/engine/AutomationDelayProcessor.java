package com.urbanairship.automation.engine;

import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.automation.AutomationAppState;
import com.urbanairship.automation.AutomationDelay;
import com.urbanairship.automation.ExecutionWindow;
import com.urbanairship.automation.ExecutionWindowProcessor;
import com.urbanairship.util.Clock;
import com.urbanairship.util.TaskSleeper;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0015\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u0019J \u0010\u001a\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u0019J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"Lcom/urbanairship/automation/engine/AutomationDelayProcessor;", "Lcom/urbanairship/automation/engine/AutomationDelayProcessorInterface;", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/urbanairship/analytics/Analytics;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "executionWindowProcessor", "Lcom/urbanairship/automation/ExecutionWindowProcessor;", "clock", "Lcom/urbanairship/util/Clock;", "sleeper", "Lcom/urbanairship/util/TaskSleeper;", "(Lcom/urbanairship/analytics/Analytics;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/automation/ExecutionWindowProcessor;Lcom/urbanairship/util/Clock;Lcom/urbanairship/util/TaskSleeper;)V", "areConditionsMet", "", "delay", "Lcom/urbanairship/automation/AutomationDelay;", "isAppStateMatch", "isDisplayWindowMatch", "isRegionMatch", "isScreenMatch", "preprocess", "", "triggerDate", "", "(Lcom/urbanairship/automation/AutomationDelay;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "process", "remainingDelay", "Lkotlin/time/Duration;", "remainingDelay-3nIYWDw", "(Lcom/urbanairship/automation/AutomationDelay;J)J", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AutomationDelayProcessor implements AutomationDelayProcessorInterface {
    private static final long PREPROCESS_DELAY_ALLOWANCE;
    private final ActivityMonitor activityMonitor;
    private final Analytics analytics;
    private final Clock clock;
    private final ExecutionWindowProcessor executionWindowProcessor;
    private final TaskSleeper sleeper;

    public AutomationDelayProcessor(@NotNull Analytics analytics, @NotNull ActivityMonitor activityMonitor, @NotNull ExecutionWindowProcessor executionWindowProcessor, @NotNull Clock clock, @NotNull TaskSleeper sleeper) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        Intrinsics.checkNotNullParameter(executionWindowProcessor, "executionWindowProcessor");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(sleeper, "sleeper");
        this.analytics = analytics;
        this.activityMonitor = activityMonitor;
        this.executionWindowProcessor = executionWindowProcessor;
        this.clock = clock;
        this.sleeper = sleeper;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AutomationDelayProcessor(Analytics analytics, ActivityMonitor activityMonitor, ExecutionWindowProcessor executionWindowProcessor, Clock DEFAULT_CLOCK, TaskSleeper taskSleeper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 8) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(analytics, activityMonitor, executionWindowProcessor, DEFAULT_CLOCK, (i & 16) != 0 ? TaskSleeper.INSTANCE.getDefault() : taskSleeper);
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        PREPROCESS_DELAY_ALLOWANCE = DurationKt.toDuration(30, DurationUnit.SECONDS);
    }

    @Override // com.urbanairship.automation.engine.AutomationDelayProcessorInterface
    @Nullable
    public Object preprocess(@Nullable AutomationDelay automationDelay, long j, @NotNull Continuation<? super Unit> continuation) {
        if (automationDelay == null) {
            return Unit.INSTANCE;
        }
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass2(automationDelay, j, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationDelayProcessor$preprocess$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ AutomationDelay $delay;
        final /* synthetic */ long $triggerDate;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(AutomationDelay automationDelay, long j, Continuation continuation) {
            super(2, continuation);
            this.$delay = automationDelay;
            this.$triggerDate = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = AutomationDelayProcessor.this.new AnonymousClass2(this.$delay, this.$triggerDate, continuation);
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
                coroutineScope = (CoroutineScope) this.L$0;
                CoroutineScopeKt.ensureActive(coroutineScope);
                long jM3501minusLRDsOJo = Duration.m3501minusLRDsOJo(AutomationDelayProcessor.this.m2801remainingDelay3nIYWDw(this.$delay, this.$triggerDate), AutomationDelayProcessor.PREPROCESS_DELAY_ALLOWANCE);
                if (Duration.m3500isPositiveimpl(jM3501minusLRDsOJo)) {
                    TaskSleeper taskSleeper = AutomationDelayProcessor.this.sleeper;
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    if (taskSleeper.m2958sleepVtjQ1oo(jM3501minusLRDsOJo, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            CoroutineScopeKt.ensureActive(coroutineScope);
            ExecutionWindow executionWindow = this.$delay.getExecutionWindow();
            if (executionWindow != null) {
                ExecutionWindowProcessor executionWindowProcessor = AutomationDelayProcessor.this.executionWindowProcessor;
                this.L$0 = null;
                this.label = 2;
                if (executionWindowProcessor.process(executionWindow, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationDelayProcessor$process$2, reason: invalid class name and case insensitive filesystem */
    static final class C09922 extends SuspendLambda implements Function2 {
        final /* synthetic */ AutomationDelay $delay;
        final /* synthetic */ long $triggerDate;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AutomationDelayProcessor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09922(AutomationDelay automationDelay, AutomationDelayProcessor automationDelayProcessor, long j, Continuation continuation) {
            super(2, continuation);
            this.$delay = automationDelay;
            this.this$0 = automationDelayProcessor;
            this.$triggerDate = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C09922 c09922 = new C09922(this.$delay, this.this$0, this.$triggerDate, continuation);
            c09922.L$0 = obj;
            return c09922;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09922) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00c1  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00eb  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0113  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00e9 -> B:42:0x0108). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0105 -> B:42:0x0108). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                Method dump skipped, instructions count: 320
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationDelayProcessor.C09922.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.urbanairship.automation.engine.AutomationDelayProcessorInterface
    @Nullable
    public Object process(@Nullable AutomationDelay automationDelay, long j, @NotNull Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new C09922(automationDelay, this, j, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // com.urbanairship.automation.engine.AutomationDelayProcessorInterface
    public boolean areConditionsMet(@Nullable AutomationDelay delay) {
        if (delay == null) {
            return true;
        }
        return isAppStateMatch(delay) && isScreenMatch(delay) && isRegionMatch(delay) && isDisplayWindowMatch(delay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAppStateMatch(AutomationDelay delay) {
        if (delay.getAppState() == null) {
            return true;
        }
        return (delay.getAppState() == AutomationAppState.FOREGROUND) == this.activityMonitor.getForegroundState().getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isScreenMatch(AutomationDelay delay) {
        List<String> screens$urbanairship_automation_release = delay.getScreens$urbanairship_automation_release();
        if (screens$urbanairship_automation_release == null || screens$urbanairship_automation_release.isEmpty()) {
            return true;
        }
        return CollectionsKt.contains(delay.getScreens$urbanairship_automation_release(), this.analytics.getScreenState().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isRegionMatch(AutomationDelay delay) {
        String regionId = delay.getRegionId();
        if (regionId == null || regionId.length() == 0) {
            return true;
        }
        return this.analytics.getRegionState().getValue().contains(delay.getRegionId());
    }

    private final boolean isDisplayWindowMatch(AutomationDelay delay) {
        ExecutionWindow executionWindow = delay.getExecutionWindow();
        if (executionWindow == null) {
            return true;
        }
        return this.executionWindowProcessor.isActive(executionWindow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: remainingDelay-3nIYWDw, reason: not valid java name */
    public final long m2801remainingDelay3nIYWDw(AutomationDelay delay, long triggerDate) {
        Long seconds = delay.getSeconds();
        if (seconds == null) {
            Duration.Companion companion = Duration.INSTANCE;
            return DurationKt.toDuration(0, DurationUnit.SECONDS);
        }
        long jLongValue = seconds.longValue() - TimeUnit.MILLISECONDS.toSeconds(this.clock.currentTimeMillis() - triggerDate);
        Duration.Companion companion2 = Duration.INSTANCE;
        return DurationKt.toDuration(Math.max(0L, jLongValue), DurationUnit.SECONDS);
    }
}
