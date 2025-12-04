package com.urbanairship.automation.engine;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.action.Action;
import com.facebook.react.uimanager.ViewProps;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.UALog;
import com.urbanairship.automation.AutomationDelay;
import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor;
import com.urbanairship.automation.engine.triggerprocessor.TriggerExecutionType;
import com.urbanairship.automation.engine.triggerprocessor.TriggerResult;
import com.urbanairship.automation.storage.AutomationStoreMigrator;
import com.urbanairship.automation.utils.ScheduleConditionsChangedNotifier;
import com.urbanairship.util.Clock;
import com.urbanairship.util.TaskSleeper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 l2\u00020\u0001:\u0003lmnBc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u001e\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0083@¢\u0006\u0002\u0010.J\u000e\u0010/\u001a\u000200H\u0082@¢\u0006\u0002\u00101J\u0016\u00102\u001a\u0002002\u0006\u00103\u001a\u000204H\u0096@¢\u0006\u0002\u00105J\u001c\u00102\u001a\u0002002\f\u00106\u001a\b\u0012\u0004\u0012\u00020407H\u0096@¢\u0006\u0002\u00108J\u0016\u00109\u001a\u0002002\u0006\u0010:\u001a\u00020;H\u0096@¢\u0006\u0002\u0010<J\u0018\u0010=\u001a\u00020>2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u0016\u0010?\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010AJ\u0018\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u000204H\u0096@¢\u0006\u0002\u00105J\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020C07H\u0096@¢\u0006\u0002\u00101J\u001c\u0010E\u001a\b\u0012\u0004\u0012\u00020C072\u0006\u00103\u001a\u000204H\u0096@¢\u0006\u0002\u00105J\"\u0010F\u001a\u0002002\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u000204H\u0002ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ\r\u0010\u0019\u001a\u00020\u001bH\u0001¢\u0006\u0002\bLJ\r\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0002\bMJ\r\u0010N\u001a\u00020\u001bH\u0001¢\u0006\u0002\bOJ\u0018\u0010P\u001a\u0004\u0018\u00010\u001f2\u0006\u0010*\u001a\u00020+H\u0082@¢\u0006\u0002\u0010QJ\u0016\u0010R\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+H\u0082@¢\u0006\u0002\u0010QJ\u000e\u0010S\u001a\u000200H\u0082@¢\u0006\u0002\u00101J\u0016\u0010T\u001a\u0002002\u0006\u0010U\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010AJ\u0016\u0010V\u001a\u0002002\u0006\u0010W\u001a\u00020XH\u0082@¢\u0006\u0002\u0010YJ\u0016\u0010Z\u001a\u0002002\u0006\u0010[\u001a\u000204H\u0082@¢\u0006\u0002\u00105J\u000e\u0010\\\u001a\u000200H\u0082@¢\u0006\u0002\u00101J\u0010\u0010]\u001a\u0002002\u0006\u0010^\u001a\u00020\u001bH\u0016J\u0010\u0010_\u001a\u0002002\u0006\u0010^\u001a\u00020\u001bH\u0016J\b\u0010`\u001a\u000200H\u0016J\u0016\u0010a\u001a\u0002002\u0006\u0010[\u001a\u000204H\u0082@¢\u0006\u0002\u00105J\u0006\u0010b\u001a\u000200J\u001c\u0010c\u001a\u0002002\f\u00106\u001a\b\u0012\u0004\u0012\u00020407H\u0096@¢\u0006\u0002\u00108J,\u0010d\u001a\u0004\u0018\u00010+2\u0006\u0010D\u001a\u0002042\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0fH\u0082@¢\u0006\u0002\u0010gJ\u001c\u0010h\u001a\u0002002\f\u0010i\u001a\b\u0012\u0004\u0012\u00020C07H\u0096@¢\u0006\u0002\u00108J\u0016\u0010j\u001a\u0002002\u0006\u0010U\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010AJ\u000e\u0010k\u001a\u000200H\u0082@¢\u0006\u0002\u00101R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006o"}, d2 = {"Lcom/urbanairship/automation/engine/AutomationEngine;", "Lcom/urbanairship/automation/engine/AutomationEngineInterface;", "store", "Lcom/urbanairship/automation/engine/ScheduleStoreInterface;", "executor", "Lcom/urbanairship/automation/engine/AutomationExecutorInterface;", "preparer", "Lcom/urbanairship/automation/engine/AutomationPreparer;", "scheduleConditionsChangedNotifier", "Lcom/urbanairship/automation/utils/ScheduleConditionsChangedNotifier;", "eventsFeed", "Lcom/urbanairship/automation/engine/AutomationEventFeed;", "triggerProcessor", "Lcom/urbanairship/automation/engine/triggerprocessor/AutomationTriggerProcessor;", "delayProcessor", "Lcom/urbanairship/automation/engine/AutomationDelayProcessorInterface;", "clock", "Lcom/urbanairship/util/Clock;", "sleeper", "Lcom/urbanairship/util/TaskSleeper;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "automationStoreMigrator", "Lcom/urbanairship/automation/storage/AutomationStoreMigrator;", "(Lcom/urbanairship/automation/engine/ScheduleStoreInterface;Lcom/urbanairship/automation/engine/AutomationExecutorInterface;Lcom/urbanairship/automation/engine/AutomationPreparer;Lcom/urbanairship/automation/utils/ScheduleConditionsChangedNotifier;Lcom/urbanairship/automation/engine/AutomationEventFeed;Lcom/urbanairship/automation/engine/triggerprocessor/AutomationTriggerProcessor;Lcom/urbanairship/automation/engine/AutomationDelayProcessorInterface;Lcom/urbanairship/util/Clock;Lcom/urbanairship/util/TaskSleeper;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/urbanairship/automation/storage/AutomationStoreMigrator;)V", "isExecutionPaused", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isPaused", "pendingExecution", "", "Lcom/urbanairship/automation/engine/AutomationEngine$PreparedData;", "preprocessingDelayJobs", "", "Lkotlinx/coroutines/Job;", "restoreState", "Lcom/urbanairship/automation/engine/AutomationEngine$ScheduleRestoreState;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "supervisorJob", "Lkotlinx/coroutines/CompletableJob;", "attemptExecute", "data", "Lcom/urbanairship/automation/engine/AutomationScheduleData;", "preparedSchedule", "Lcom/urbanairship/automation/engine/PreparedSchedule;", "(Lcom/urbanairship/automation/engine/AutomationScheduleData;Lcom/urbanairship/automation/engine/PreparedSchedule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelPreprocessDelayJobs", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelSchedules", "group", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "identifiers", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelSchedulesWith", "type", "Lcom/urbanairship/automation/AutomationSchedule$ScheduleType;", "(Lcom/urbanairship/automation/AutomationSchedule$ScheduleType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkReady", "Lcom/urbanairship/automation/engine/ScheduleReadyResult;", "checkStillValid", "prepared", "(Lcom/urbanairship/automation/engine/AutomationEngine$PreparedData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSchedule", "Lcom/urbanairship/automation/AutomationSchedule;", "identifier", "getSchedules", "handleInterval", "interval", "Lkotlin/time/Duration;", "scheduleID", "handleInterval-VtjQ1oo", "(JLjava/lang/String;)V", "isExecutionPaused$urbanairship_automation_release", "isPaused$urbanairship_automation_release", "isStarted", "isStarted$urbanairship_automation_release", "prepareSchedule", "(Lcom/urbanairship/automation/engine/AutomationScheduleData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preprocessDelay", "processNextPendingExecution", "processPrepared", "preparedData", "processTriggerResult", "result", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerResult;", "(Lcom/urbanairship/automation/engine/triggerprocessor/TriggerResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processTriggeredSchedule", "scheduleId", "restoreSchedules", "setEnginePaused", "paused", "setExecutionPaused", ViewProps.START, "startTaskToProcessTriggeredSchedule", "stop", "stopSchedules", "updateState", "updateBlock", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertSchedules", "schedules", "waitForConditions", "waitForScheduleRestore", "Companion", "PreparedData", "ScheduleRestoreState", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nAutomationEngine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationEngine.kt\ncom/urbanairship/automation/engine/AutomationEngine\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,685:1\n226#2,5:686\n226#2,5:691\n226#2,5:714\n226#2,5:733\n1#3:696\n766#4:697\n857#4,2:698\n1855#4,2:700\n766#4:702\n857#4,2:703\n1855#4,2:705\n766#4:707\n857#4,2:708\n1549#4:710\n1620#4,3:711\n2333#4,14:719\n*S KotlinDebug\n*F\n+ 1 AutomationEngine.kt\ncom/urbanairship/automation/engine/AutomationEngine\n*L\n104#1:686,5\n109#1:691,5\n452#1:714,5\n463#1:733,5\n346#1:697\n346#1:698,2\n348#1:700,2\n370#1:702\n370#1:703,2\n371#1:705,2\n379#1:707\n379#1:708,2\n380#1:710\n380#1:711,3\n459#1:719,14\n*E\n"})
/* loaded from: classes5.dex */
public final class AutomationEngine implements AutomationEngineInterface {
    private static final Companion Companion = new Companion(null);
    private static final List INTERRUPTIBLE_STATES = CollectionsKt.listOf((Object[]) new AutomationScheduleState[]{AutomationScheduleState.EXECUTING, AutomationScheduleState.PREPARED, AutomationScheduleState.TRIGGERED});
    private final AutomationStoreMigrator automationStoreMigrator;
    private final Clock clock;
    private final AutomationDelayProcessorInterface delayProcessor;
    private final CoroutineDispatcher dispatcher;
    private final AutomationEventFeed eventsFeed;
    private final AutomationExecutorInterface executor;
    private MutableStateFlow isExecutionPaused;
    private MutableStateFlow isPaused;
    private MutableStateFlow pendingExecution;
    private final AutomationPreparer preparer;
    private List preprocessingDelayJobs;
    private MutableStateFlow restoreState;
    private final ScheduleConditionsChangedNotifier scheduleConditionsChangedNotifier;
    private final CoroutineScope scope;
    private final TaskSleeper sleeper;
    private final ScheduleStoreInterface store;
    private final CompletableJob supervisorJob;
    private final AutomationTriggerProcessor triggerProcessor;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[TriggerExecutionType.values().length];
            try {
                iArr[TriggerExecutionType.DELAY_CANCELLATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TriggerExecutionType.EXECUTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ScheduleReadyResult.values().length];
            try {
                iArr2[ScheduleReadyResult.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ScheduleReadyResult.INVALIDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ScheduleReadyResult.NOT_READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ScheduleReadyResult.SKIP.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ScheduleExecuteResult.values().length];
            try {
                iArr3[ScheduleExecuteResult.CANCEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[ScheduleExecuteResult.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[ScheduleExecuteResult.RETRY.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$attemptExecute$1, reason: invalid class name */
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
            return AutomationEngine.this.attemptExecute(null, null, this);
        }
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$checkStillValid$1, reason: invalid class name and case insensitive filesystem */
    static final class C10011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10011(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationEngine.this.checkStillValid(null, this);
        }
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$prepareSchedule$1, reason: invalid class name and case insensitive filesystem */
    static final class C10081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C10081(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationEngine.this.prepareSchedule(null, this);
        }
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$processPrepared$1, reason: invalid class name and case insensitive filesystem */
    static final class C10141 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10141(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationEngine.this.processPrepared(null, this);
        }
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$processTriggerResult$1, reason: invalid class name and case insensitive filesystem */
    static final class C10151 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10151(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationEngine.this.processTriggerResult(null, this);
        }
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$processTriggeredSchedule$1, reason: invalid class name and case insensitive filesystem */
    static final class C10181 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C10181(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationEngine.this.processTriggeredSchedule(null, this);
        }
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$restoreSchedules$1, reason: invalid class name and case insensitive filesystem */
    static final class C10231 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C10231(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationEngine.this.restoreSchedules(this);
        }
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$updateState$1, reason: invalid class name and case insensitive filesystem */
    static final class C10271 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10271(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationEngine.this.updateState(null, null, this);
        }
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$waitForConditions$1, reason: invalid class name and case insensitive filesystem */
    static final class C10291 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10291(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationEngine.this.waitForConditions(null, this);
        }
    }

    public AutomationEngine(@NotNull ScheduleStoreInterface store, @NotNull AutomationExecutorInterface executor, @NotNull AutomationPreparer preparer, @NotNull ScheduleConditionsChangedNotifier scheduleConditionsChangedNotifier, @NotNull AutomationEventFeed eventsFeed, @NotNull AutomationTriggerProcessor triggerProcessor, @NotNull AutomationDelayProcessorInterface delayProcessor, @NotNull Clock clock, @NotNull TaskSleeper sleeper, @NotNull CoroutineDispatcher dispatcher, @NotNull AutomationStoreMigrator automationStoreMigrator) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(preparer, "preparer");
        Intrinsics.checkNotNullParameter(scheduleConditionsChangedNotifier, "scheduleConditionsChangedNotifier");
        Intrinsics.checkNotNullParameter(eventsFeed, "eventsFeed");
        Intrinsics.checkNotNullParameter(triggerProcessor, "triggerProcessor");
        Intrinsics.checkNotNullParameter(delayProcessor, "delayProcessor");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(sleeper, "sleeper");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(automationStoreMigrator, "automationStoreMigrator");
        this.store = store;
        this.executor = executor;
        this.preparer = preparer;
        this.scheduleConditionsChangedNotifier = scheduleConditionsChangedNotifier;
        this.eventsFeed = eventsFeed;
        this.triggerProcessor = triggerProcessor;
        this.delayProcessor = delayProcessor;
        this.clock = clock;
        this.sleeper = sleeper;
        this.dispatcher = dispatcher;
        this.automationStoreMigrator = automationStoreMigrator;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.supervisorJob = completableJobSupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(completableJobSupervisorJob$default));
        Boolean bool = Boolean.FALSE;
        this.isPaused = StateFlowKt.MutableStateFlow(bool);
        this.isExecutionPaused = StateFlowKt.MutableStateFlow(bool);
        this.restoreState = StateFlowKt.MutableStateFlow(ScheduleRestoreState.IDLE);
        this.pendingExecution = StateFlowKt.MutableStateFlow(SetsKt.emptySet());
        this.preprocessingDelayJobs = new ArrayList();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AutomationEngine(ScheduleStoreInterface scheduleStoreInterface, AutomationExecutorInterface automationExecutorInterface, AutomationPreparer automationPreparer, ScheduleConditionsChangedNotifier scheduleConditionsChangedNotifier, AutomationEventFeed automationEventFeed, AutomationTriggerProcessor automationTriggerProcessor, AutomationDelayProcessorInterface automationDelayProcessorInterface, Clock clock, TaskSleeper taskSleeper, CoroutineDispatcher coroutineDispatcher, AutomationStoreMigrator automationStoreMigrator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Clock clock2;
        if ((i & 128) != 0) {
            Clock DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
            clock2 = DEFAULT_CLOCK;
        } else {
            clock2 = clock;
        }
        this(scheduleStoreInterface, automationExecutorInterface, automationPreparer, scheduleConditionsChangedNotifier, automationEventFeed, automationTriggerProcessor, automationDelayProcessorInterface, clock2, (i & 256) != 0 ? TaskSleeper.INSTANCE.getDefault() : taskSleeper, (i & 512) != 0 ? AirshipDispatchers.INSTANCE.newSerialDispatcher() : coroutineDispatcher, automationStoreMigrator);
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/automation/engine/AutomationEngine$ScheduleRestoreState;", "", "(Ljava/lang/String;I)V", "IDLE", "IN_PROGRESS", "RESTORED", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ScheduleRestoreState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ScheduleRestoreState[] $VALUES;
        public static final ScheduleRestoreState IDLE = new ScheduleRestoreState("IDLE", 0);
        public static final ScheduleRestoreState IN_PROGRESS = new ScheduleRestoreState("IN_PROGRESS", 1);
        public static final ScheduleRestoreState RESTORED = new ScheduleRestoreState("RESTORED", 2);

        private static final /* synthetic */ ScheduleRestoreState[] $values() {
            return new ScheduleRestoreState[]{IDLE, IN_PROGRESS, RESTORED};
        }

        @NotNull
        public static EnumEntries<ScheduleRestoreState> getEntries() {
            return $ENTRIES;
        }

        public static ScheduleRestoreState valueOf(String str) {
            return (ScheduleRestoreState) Enum.valueOf(ScheduleRestoreState.class, str);
        }

        public static ScheduleRestoreState[] values() {
            return (ScheduleRestoreState[]) $VALUES.clone();
        }

        private ScheduleRestoreState(String str, int i) {
        }

        static {
            ScheduleRestoreState[] scheduleRestoreStateArr$values = $values();
            $VALUES = scheduleRestoreStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(scheduleRestoreStateArr$values);
        }
    }

    @VisibleForTesting
    public final boolean isStarted$urbanairship_automation_release() {
        return this.restoreState.getValue() != ScheduleRestoreState.IDLE;
    }

    @VisibleForTesting
    public final boolean isPaused$urbanairship_automation_release() {
        return ((Boolean) this.isPaused.getValue()).booleanValue();
    }

    @VisibleForTesting
    public final boolean isExecutionPaused$urbanairship_automation_release() {
        return ((Boolean) this.isExecutionPaused.getValue()).booleanValue();
    }

    @Override // com.urbanairship.automation.engine.AutomationEngineInterface
    public void setEnginePaused(boolean paused) {
        Object value;
        MutableStateFlow mutableStateFlow = this.isPaused;
        do {
            value = mutableStateFlow.getValue();
            ((Boolean) value).booleanValue();
        } while (!mutableStateFlow.compareAndSet(value, Boolean.valueOf(paused)));
        this.triggerProcessor.setPaused(paused);
    }

    @Override // com.urbanairship.automation.engine.AutomationEngineInterface
    public void setExecutionPaused(boolean paused) {
        Object value;
        MutableStateFlow mutableStateFlow = this.isExecutionPaused;
        do {
            value = mutableStateFlow.getValue();
            ((Boolean) value).booleanValue();
        } while (!mutableStateFlow.compareAndSet(value, Boolean.valueOf(paused)));
    }

    @Override // com.urbanairship.automation.engine.AutomationEngineInterface
    public void start() {
        this.restoreState.setValue(ScheduleRestoreState.IN_PROGRESS);
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C10241(null), 3, null);
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$start$1, reason: invalid class name and case insensitive filesystem */
    static final class C10241 extends SuspendLambda implements Function2 {
        private /* synthetic */ Object L$0;
        int label;

        C10241(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C10241 c10241 = AutomationEngine.this.new C10241(continuation);
            c10241.L$0 = obj;
            return c10241;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C10241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L28
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r0 = r8.L$0
                kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                kotlin.ResultKt.throwOnFailure(r9)
                r9 = r0
                goto L4d
            L17:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L1f:
                java.lang.Object r1 = r8.L$0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.throwOnFailure(r9)
                r9 = r1
                goto L40
            L28:
                kotlin.ResultKt.throwOnFailure(r9)
                java.lang.Object r9 = r8.L$0
                kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
                com.urbanairship.automation.engine.AutomationEngine r1 = com.urbanairship.automation.engine.AutomationEngine.this
                com.urbanairship.automation.storage.AutomationStoreMigrator r1 = com.urbanairship.automation.engine.AutomationEngine.access$getAutomationStoreMigrator$p(r1)
                r8.L$0 = r9
                r8.label = r3
                java.lang.Object r1 = r1.migrateData$urbanairship_automation_release(r8)
                if (r1 != r0) goto L40
                return r0
            L40:
                com.urbanairship.automation.engine.AutomationEngine r1 = com.urbanairship.automation.engine.AutomationEngine.this
                r8.L$0 = r9
                r8.label = r2
                java.lang.Object r1 = com.urbanairship.automation.engine.AutomationEngine.access$restoreSchedules(r1, r8)
                if (r1 != r0) goto L4d
                return r0
            L4d:
                com.urbanairship.automation.engine.AutomationEngine r0 = com.urbanairship.automation.engine.AutomationEngine.this
                kotlinx.coroutines.flow.MutableStateFlow r0 = com.urbanairship.automation.engine.AutomationEngine.access$getRestoreState$p(r0)
                com.urbanairship.automation.engine.AutomationEngine$ScheduleRestoreState r1 = com.urbanairship.automation.engine.AutomationEngine.ScheduleRestoreState.RESTORED
                r0.setValue(r1)
                boolean r0 = kotlinx.coroutines.CoroutineScopeKt.isActive(r9)
                if (r0 != 0) goto L61
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            L61:
                com.urbanairship.automation.engine.AutomationEngine$start$1$1 r5 = new com.urbanairship.automation.engine.AutomationEngine$start$1$1
                com.urbanairship.automation.engine.AutomationEngine r0 = com.urbanairship.automation.engine.AutomationEngine.this
                r1 = 0
                r5.<init>(r0, r1)
                r6 = 3
                r7 = 0
                r3 = 0
                r4 = 0
                r2 = r9
                kotlinx.coroutines.BuildersKt.launch$default(r2, r3, r4, r5, r6, r7)
                com.urbanairship.automation.engine.AutomationEngine$start$1$2 r5 = new com.urbanairship.automation.engine.AutomationEngine$start$1$2
                com.urbanairship.automation.engine.AutomationEngine r0 = com.urbanairship.automation.engine.AutomationEngine.this
                r5.<init>(r0, r1)
                kotlinx.coroutines.BuildersKt.launch$default(r2, r3, r4, r5, r6, r7)
                com.urbanairship.automation.engine.AutomationEngine$start$1$3 r5 = new com.urbanairship.automation.engine.AutomationEngine$start$1$3
                com.urbanairship.automation.engine.AutomationEngine r0 = com.urbanairship.automation.engine.AutomationEngine.this
                r5.<init>(r0, r1)
                kotlinx.coroutines.BuildersKt.launch$default(r2, r3, r4, r5, r6, r7)
                com.urbanairship.automation.engine.AutomationEngine$start$1$4 r5 = new com.urbanairship.automation.engine.AutomationEngine$start$1$4
                com.urbanairship.automation.engine.AutomationEngine r8 = com.urbanairship.automation.engine.AutomationEngine.this
                r5.<init>(r8, r1)
                kotlinx.coroutines.BuildersKt.launch$default(r2, r3, r4, r5, r6, r7)
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationEngine.C10241.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: com.urbanairship.automation.engine.AutomationEngine$start$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01311 extends SuspendLambda implements Function2 {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AutomationEngine this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01311(AutomationEngine automationEngine, Continuation continuation) {
                super(2, continuation);
                this.this$0 = automationEngine;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                C01311 c01311 = new C01311(this.this$0, continuation);
                c01311.L$0 = obj;
                return c01311;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C01311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    Flow<TriggerResult> triggerResults = this.this$0.triggerProcessor.getTriggerResults();
                    final AutomationEngine automationEngine = this.this$0;
                    FlowCollector<? super TriggerResult> flowCollector = new FlowCollector() { // from class: com.urbanairship.automation.engine.AutomationEngine.start.1.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(TriggerResult triggerResult, Continuation continuation) {
                            if (CoroutineScopeKt.isActive(coroutineScope)) {
                                Object objProcessTriggerResult = automationEngine.processTriggerResult(triggerResult, continuation);
                                return objProcessTriggerResult == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessTriggerResult : Unit.INSTANCE;
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    this.label = 1;
                    if (triggerResults.collect(flowCollector, this) == coroutine_suspended) {
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

        /* renamed from: com.urbanairship.automation.engine.AutomationEngine$start$1$2, reason: invalid class name */
        static final class AnonymousClass2 extends SuspendLambda implements Function2 {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AutomationEngine this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(AutomationEngine automationEngine, Continuation continuation) {
                super(2, continuation);
                this.this$0 = automationEngine;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    Flow<AutomationEvent> feed$urbanairship_automation_release = this.this$0.eventsFeed.getFeed$urbanairship_automation_release();
                    final AutomationEngine automationEngine = this.this$0;
                    FlowCollector<? super AutomationEvent> flowCollector = new FlowCollector() { // from class: com.urbanairship.automation.engine.AutomationEngine.start.1.2.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(AutomationEvent automationEvent, Continuation continuation) {
                            if (CoroutineScopeKt.isActive(coroutineScope)) {
                                Object objProcessEvent = automationEngine.triggerProcessor.processEvent(automationEvent, continuation);
                                return objProcessEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessEvent : Unit.INSTANCE;
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    this.label = 1;
                    if (feed$urbanairship_automation_release.collect(flowCollector, this) == coroutine_suspended) {
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

        /* renamed from: com.urbanairship.automation.engine.AutomationEngine$start$1$3, reason: invalid class name */
        static final class AnonymousClass3 extends SuspendLambda implements Function2 {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AutomationEngine this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(AutomationEngine automationEngine, Continuation continuation) {
                super(2, continuation);
                this.this$0 = automationEngine;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* renamed from: com.urbanairship.automation.engine.AutomationEngine$start$1$3$1, reason: invalid class name and collision with other inner class name */
            static final class C01341 extends SuspendLambda implements Function3 {
                /* synthetic */ boolean Z$0;
                /* synthetic */ boolean Z$1;
                int label;

                C01341(Continuation continuation) {
                    super(3, continuation);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Continuation) obj3);
                }

                public final Object invoke(boolean z, boolean z2, Continuation continuation) {
                    C01341 c01341 = new C01341(continuation);
                    c01341.Z$0 = z;
                    c01341.Z$1 = z2;
                    return c01341.invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Boxing.boxBoolean(this.Z$0 || this.Z$1);
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(FlowKt.combine(this.this$0.isPaused, this.this$0.isExecutionPaused, new C01341(null)));
                    final AutomationEngine automationEngine = this.this$0;
                    FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.automation.engine.AutomationEngine.start.1.3.2
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit(((Boolean) obj2).booleanValue(), continuation);
                        }

                        public final Object emit(boolean z, Continuation continuation) {
                            if (CoroutineScopeKt.isActive(coroutineScope) && !z) {
                                automationEngine.scheduleConditionsChangedNotifier.notifyChanged$urbanairship_automation_release();
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    this.label = 1;
                    if (flowDistinctUntilChanged.collect(flowCollector, this) == coroutine_suspended) {
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

        /* renamed from: com.urbanairship.automation.engine.AutomationEngine$start$1$4, reason: invalid class name */
        static final class AnonymousClass4 extends SuspendLambda implements Function2 {
            int label;
            final /* synthetic */ AutomationEngine this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(AutomationEngine automationEngine, Continuation continuation) {
                super(2, continuation);
                this.this$0 = automationEngine;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass4(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    MutableStateFlow mutableStateFlow = this.this$0.pendingExecution;
                    final AutomationEngine automationEngine = this.this$0;
                    FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.automation.engine.AutomationEngine.start.1.4.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(final Set set, Continuation continuation) {
                            UALog.d$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationEngine.start.1.4.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("Processing pending execution queue update ");
                                    Set set2 = set;
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set2, 10));
                                    Iterator it = set2.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((PreparedData) it.next()).getScheduleId());
                                    }
                                    sb.append(arrayList);
                                    return sb.toString();
                                }
                            }, 1, null);
                            Object objProcessNextPendingExecution = automationEngine.processNextPendingExecution(continuation);
                            return objProcessNextPendingExecution == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessNextPendingExecution : Unit.INSTANCE;
                        }
                    };
                    this.label = 1;
                    if (mutableStateFlow.collect(flowCollector, this) == coroutine_suspended) {
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
    }

    public final void stop() {
        this.restoreState.setValue(ScheduleRestoreState.IDLE);
        JobKt__JobKt.cancelChildren$default((Job) this.supervisorJob, (CancellationException) null, 1, (Object) null);
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$cancelPreprocessDelayJobs$2, reason: invalid class name and case insensitive filesystem */
    static final class C09932 extends SuspendLambda implements Function2 {
        int label;

        C09932(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AutomationEngine.this.new C09932(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09932) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CollectionsKt.removeAll(AutomationEngine.this.preprocessingDelayJobs, (Function1) new Function1() { // from class: com.urbanairship.automation.engine.AutomationEngine.cancelPreprocessDelayJobs.2.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(Job it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        Job.DefaultImpls.cancel$default(it, (CancellationException) null, 1, (Object) null);
                        return Boolean.TRUE;
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object cancelPreprocessDelayJobs(Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new C09932(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$preprocessDelay$2, reason: invalid class name and case insensitive filesystem */
    static final class C10112 extends SuspendLambda implements Function2 {
        final /* synthetic */ AutomationScheduleData $data;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AutomationEngine this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10112(AutomationScheduleData automationScheduleData, AutomationEngine automationEngine, Continuation continuation) {
            super(2, continuation);
            this.$data = automationScheduleData;
            this.this$0 = automationEngine;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C10112 c10112 = new C10112(this.$data, this.this$0, continuation);
            c10112.L$0 = obj;
            return c10112;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C10112) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Deferred deferred;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                AutomationDelay delay = this.$data.getSchedule().getDelay();
                if (delay == null) {
                    return Boxing.boxBoolean(true);
                }
                String identifier = this.$data.getSchedule().getIdentifier();
                TriggeringInfo triggerInfo = this.$data.getTriggerInfo();
                Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new AutomationEngine$preprocessDelay$2$job$1(this.this$0, delay, triggerInfo != null ? triggerInfo.getDate() : this.$data.getScheduleStateChangeDate(), identifier, null), 3, null);
                this.this$0.preprocessingDelayJobs.add(deferredAsync$default);
                this.L$0 = deferredAsync$default;
                this.label = 1;
                if (deferredAsync$default.join(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                deferred = deferredAsync$default;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                deferred = (Deferred) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.preprocessingDelayJobs.remove(deferred);
            return Boxing.boxBoolean(deferred.isCompleted());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object preprocessDelay(AutomationScheduleData automationScheduleData, Continuation continuation) {
        return BuildersKt.withContext(this.dispatcher, new C10112(automationScheduleData, this, null), continuation);
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$waitForScheduleRestore$2, reason: invalid class name and case insensitive filesystem */
    static final class C10322 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        C10322(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C10322 c10322 = new C10322(continuation);
            c10322.L$0 = obj;
            return c10322;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScheduleRestoreState scheduleRestoreState, Continuation continuation) {
            return ((C10322) create(scheduleRestoreState, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((ScheduleRestoreState) this.L$0) == ScheduleRestoreState.RESTORED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object waitForScheduleRestore(Continuation continuation) {
        Object objFirst = FlowKt.first(this.restoreState, new C10322(null), continuation);
        return objFirst == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFirst : Unit.INSTANCE;
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$stopSchedules$2, reason: invalid class name and case insensitive filesystem */
    static final class C10262 extends SuspendLambda implements Function2 {
        final /* synthetic */ List $identifiers;
        long J$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10262(List list, Continuation continuation) {
            super(2, continuation);
            this.$identifiers = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AutomationEngine.this.new C10262(this.$identifiers, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C10262) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0081 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 3
                r3 = 2
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L2c
                if (r1 == r5) goto L28
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                kotlin.ResultKt.throwOnFailure(r10)
                goto L82
            L16:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L1e:
                long r5 = r9.J$0
                java.lang.Object r1 = r9.L$0
                java.util.Iterator r1 = (java.util.Iterator) r1
                kotlin.ResultKt.throwOnFailure(r10)
                goto L55
            L28:
                kotlin.ResultKt.throwOnFailure(r10)
                goto L3a
            L2c:
                kotlin.ResultKt.throwOnFailure(r10)
                com.urbanairship.automation.engine.AutomationEngine r10 = com.urbanairship.automation.engine.AutomationEngine.this
                r9.label = r5
                java.lang.Object r10 = com.urbanairship.automation.engine.AutomationEngine.access$waitForScheduleRestore(r10, r9)
                if (r10 != r0) goto L3a
                return r0
            L3a:
                com.urbanairship.automation.engine.AutomationEngine$stopSchedules$2$1 r10 = new com.urbanairship.automation.engine.AutomationEngine$stopSchedules$2$1
                java.util.List r1 = r9.$identifiers
                r10.<init>()
                com.urbanairship.UALog.d$default(r4, r10, r5, r4)
                com.urbanairship.automation.engine.AutomationEngine r10 = com.urbanairship.automation.engine.AutomationEngine.this
                com.urbanairship.util.Clock r10 = com.urbanairship.automation.engine.AutomationEngine.access$getClock$p(r10)
                long r5 = r10.currentTimeMillis()
                java.util.List r10 = r9.$identifiers
                java.util.Iterator r10 = r10.iterator()
                r1 = r10
            L55:
                boolean r10 = r1.hasNext()
                if (r10 == 0) goto L75
                java.lang.Object r10 = r1.next()
                java.lang.String r10 = (java.lang.String) r10
                com.urbanairship.automation.engine.AutomationEngine r7 = com.urbanairship.automation.engine.AutomationEngine.this
                com.urbanairship.automation.engine.AutomationEngine$stopSchedules$2$2 r8 = new com.urbanairship.automation.engine.AutomationEngine$stopSchedules$2$2
                r8.<init>()
                r9.L$0 = r1
                r9.J$0 = r5
                r9.label = r3
                java.lang.Object r10 = com.urbanairship.automation.engine.AutomationEngine.access$updateState(r7, r10, r8, r9)
                if (r10 != r0) goto L55
                return r0
            L75:
                com.urbanairship.automation.engine.AutomationEngine r10 = com.urbanairship.automation.engine.AutomationEngine.this
                r9.L$0 = r4
                r9.label = r2
                java.lang.Object r9 = com.urbanairship.automation.engine.AutomationEngine.access$cancelPreprocessDelayJobs(r10, r9)
                if (r9 != r0) goto L82
                return r0
            L82:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationEngine.C10262.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.urbanairship.automation.engine.AutomationEngineInterface
    @Nullable
    public Object stopSchedules(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new C10262(list, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$upsertSchedules$2, reason: invalid class name and case insensitive filesystem */
    static final class C10282 extends SuspendLambda implements Function2 {
        final /* synthetic */ List $schedules;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10282(List list, Continuation continuation) {
            super(2, continuation);
            this.$schedules = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AutomationEngine.this.new C10282(this.$schedules, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C10282) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00a7 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00b2 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2e
                if (r1 == r5) goto L2a
                if (r1 == r4) goto L26
                if (r1 == r3) goto L21
                if (r1 != r2) goto L19
                kotlin.ResultKt.throwOnFailure(r9)
                goto Lb3
            L19:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L21:
                kotlin.ResultKt.throwOnFailure(r9)
                goto La8
            L26:
                kotlin.ResultKt.throwOnFailure(r9)
                goto L97
            L2a:
                kotlin.ResultKt.throwOnFailure(r9)
                goto L3c
            L2e:
                kotlin.ResultKt.throwOnFailure(r9)
                com.urbanairship.automation.engine.AutomationEngine r9 = com.urbanairship.automation.engine.AutomationEngine.this
                r8.label = r5
                java.lang.Object r9 = com.urbanairship.automation.engine.AutomationEngine.access$waitForScheduleRestore(r9, r8)
                if (r9 != r0) goto L3c
                return r0
            L3c:
                java.util.List r9 = r8.$schedules
                r1 = 10
                int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r1)
                int r1 = kotlin.collections.MapsKt.mapCapacity(r1)
                r6 = 16
                int r1 = kotlin.ranges.RangesKt.coerceAtLeast(r1, r6)
                java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
                r6.<init>(r1)
                java.util.Iterator r9 = r9.iterator()
            L57:
                boolean r1 = r9.hasNext()
                if (r1 == 0) goto L6c
                java.lang.Object r1 = r9.next()
                r7 = r1
                com.urbanairship.automation.AutomationSchedule r7 = (com.urbanairship.automation.AutomationSchedule) r7
                java.lang.String r7 = r7.getIdentifier()
                r6.put(r7, r1)
                goto L57
            L6c:
                java.util.Set r9 = r6.keySet()
                com.urbanairship.automation.engine.AutomationEngine$upsertSchedules$2$1 r1 = new com.urbanairship.automation.engine.AutomationEngine$upsertSchedules$2$1
                r1.<init>()
                r9 = 0
                com.urbanairship.UALog.d$default(r9, r1, r5, r9)
                com.urbanairship.automation.engine.AutomationEngine r9 = com.urbanairship.automation.engine.AutomationEngine.this
                com.urbanairship.automation.engine.ScheduleStoreInterface r9 = com.urbanairship.automation.engine.AutomationEngine.access$getStore$p(r9)
                java.util.Set r1 = r6.keySet()
                java.util.List r1 = kotlin.collections.CollectionsKt.toList(r1)
                com.urbanairship.automation.engine.AutomationEngine$upsertSchedules$2$updatedSchedules$1 r5 = new com.urbanairship.automation.engine.AutomationEngine$upsertSchedules$2$updatedSchedules$1
                com.urbanairship.automation.engine.AutomationEngine r7 = com.urbanairship.automation.engine.AutomationEngine.this
                r5.<init>()
                r8.label = r4
                java.lang.Object r9 = r9.upsertSchedules(r1, r5, r8)
                if (r9 != r0) goto L97
                return r0
            L97:
                java.util.List r9 = (java.util.List) r9
                com.urbanairship.automation.engine.AutomationEngine r1 = com.urbanairship.automation.engine.AutomationEngine.this
                com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor r1 = com.urbanairship.automation.engine.AutomationEngine.access$getTriggerProcessor$p(r1)
                r8.label = r3
                java.lang.Object r9 = r1.updateSchedules(r9, r8)
                if (r9 != r0) goto La8
                return r0
            La8:
                com.urbanairship.automation.engine.AutomationEngine r9 = com.urbanairship.automation.engine.AutomationEngine.this
                r8.label = r2
                java.lang.Object r8 = com.urbanairship.automation.engine.AutomationEngine.access$cancelPreprocessDelayJobs(r9, r8)
                if (r8 != r0) goto Lb3
                return r0
            Lb3:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationEngine.C10282.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.urbanairship.automation.engine.AutomationEngineInterface
    @Nullable
    public Object upsertSchedules(@NotNull List<AutomationSchedule> list, @NotNull Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new C10282(list, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$cancelSchedules$2, reason: invalid class name and case insensitive filesystem */
    static final class C09942 extends SuspendLambda implements Function2 {
        final /* synthetic */ List $identifiers;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09942(List list, Continuation continuation) {
            super(2, continuation);
            this.$identifiers = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AutomationEngine.this.new C09942(this.$identifiers, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09942) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0066 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0071 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2c
                if (r1 == r5) goto L28
                if (r1 == r4) goto L24
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                kotlin.ResultKt.throwOnFailure(r7)
                goto L72
            L18:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L20:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L67
            L24:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L56
            L28:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L3a
            L2c:
                kotlin.ResultKt.throwOnFailure(r7)
                com.urbanairship.automation.engine.AutomationEngine r7 = com.urbanairship.automation.engine.AutomationEngine.this
                r6.label = r5
                java.lang.Object r7 = com.urbanairship.automation.engine.AutomationEngine.access$waitForScheduleRestore(r7, r6)
                if (r7 != r0) goto L3a
                return r0
            L3a:
                com.urbanairship.automation.engine.AutomationEngine$cancelSchedules$2$1 r7 = new com.urbanairship.automation.engine.AutomationEngine$cancelSchedules$2$1
                java.util.List r1 = r6.$identifiers
                r7.<init>()
                r1 = 0
                com.urbanairship.UALog.d$default(r1, r7, r5, r1)
                com.urbanairship.automation.engine.AutomationEngine r7 = com.urbanairship.automation.engine.AutomationEngine.this
                com.urbanairship.automation.engine.ScheduleStoreInterface r7 = com.urbanairship.automation.engine.AutomationEngine.access$getStore$p(r7)
                java.util.List r1 = r6.$identifiers
                r6.label = r4
                java.lang.Object r7 = r7.deleteSchedules(r1, r6)
                if (r7 != r0) goto L56
                return r0
            L56:
                com.urbanairship.automation.engine.AutomationEngine r7 = com.urbanairship.automation.engine.AutomationEngine.this
                com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor r7 = com.urbanairship.automation.engine.AutomationEngine.access$getTriggerProcessor$p(r7)
                java.util.List r1 = r6.$identifiers
                r6.label = r3
                java.lang.Object r7 = r7.cancel(r1, r6)
                if (r7 != r0) goto L67
                return r0
            L67:
                com.urbanairship.automation.engine.AutomationEngine r7 = com.urbanairship.automation.engine.AutomationEngine.this
                r6.label = r2
                java.lang.Object r6 = com.urbanairship.automation.engine.AutomationEngine.access$cancelPreprocessDelayJobs(r7, r6)
                if (r6 != r0) goto L72
                return r0
            L72:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationEngine.C09942.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.urbanairship.automation.engine.AutomationEngineInterface
    @Nullable
    public Object cancelSchedules(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new C09942(list, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$cancelSchedules$4, reason: invalid class name and case insensitive filesystem */
    static final class C09954 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $group;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09954(String str, Continuation continuation) {
            super(2, continuation);
            this.$group = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AutomationEngine.this.new C09954(this.$group, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09954) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0066 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0071 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2c
                if (r1 == r5) goto L28
                if (r1 == r4) goto L24
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                kotlin.ResultKt.throwOnFailure(r7)
                goto L72
            L18:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L20:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L67
            L24:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L56
            L28:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L3a
            L2c:
                kotlin.ResultKt.throwOnFailure(r7)
                com.urbanairship.automation.engine.AutomationEngine r7 = com.urbanairship.automation.engine.AutomationEngine.this
                r6.label = r5
                java.lang.Object r7 = com.urbanairship.automation.engine.AutomationEngine.access$waitForScheduleRestore(r7, r6)
                if (r7 != r0) goto L3a
                return r0
            L3a:
                com.urbanairship.automation.engine.AutomationEngine$cancelSchedules$4$1 r7 = new com.urbanairship.automation.engine.AutomationEngine$cancelSchedules$4$1
                java.lang.String r1 = r6.$group
                r7.<init>()
                r1 = 0
                com.urbanairship.UALog.d$default(r1, r7, r5, r1)
                com.urbanairship.automation.engine.AutomationEngine r7 = com.urbanairship.automation.engine.AutomationEngine.this
                com.urbanairship.automation.engine.ScheduleStoreInterface r7 = com.urbanairship.automation.engine.AutomationEngine.access$getStore$p(r7)
                java.lang.String r1 = r6.$group
                r6.label = r4
                java.lang.Object r7 = r7.deleteSchedules(r1, r6)
                if (r7 != r0) goto L56
                return r0
            L56:
                com.urbanairship.automation.engine.AutomationEngine r7 = com.urbanairship.automation.engine.AutomationEngine.this
                com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor r7 = com.urbanairship.automation.engine.AutomationEngine.access$getTriggerProcessor$p(r7)
                java.lang.String r1 = r6.$group
                r6.label = r3
                java.lang.Object r7 = r7.cancel(r1, r6)
                if (r7 != r0) goto L67
                return r0
            L67:
                com.urbanairship.automation.engine.AutomationEngine r7 = com.urbanairship.automation.engine.AutomationEngine.this
                r6.label = r2
                java.lang.Object r6 = com.urbanairship.automation.engine.AutomationEngine.access$cancelPreprocessDelayJobs(r7, r6)
                if (r6 != r0) goto L72
                return r0
            L72:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationEngine.C09954.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.urbanairship.automation.engine.AutomationEngineInterface
    @Nullable
    public Object cancelSchedules(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new C09954(str, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$cancelSchedulesWith$2, reason: invalid class name and case insensitive filesystem */
    static final class C09962 extends SuspendLambda implements Function2 {
        final /* synthetic */ AutomationSchedule.ScheduleType $type;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09962(AutomationSchedule.ScheduleType scheduleType, Continuation continuation) {
            super(2, continuation);
            this.$type = scheduleType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AutomationEngine.this.new C09962(this.$type, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09962) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00c1 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00d3 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00de A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instructions count: 226
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationEngine.C09962.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.urbanairship.automation.engine.AutomationEngineInterface
    @Nullable
    public Object cancelSchedulesWith(@NotNull AutomationSchedule.ScheduleType scheduleType, @NotNull Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new C09962(scheduleType, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$getSchedules$2, reason: invalid class name and case insensitive filesystem */
    static final class C10062 extends SuspendLambda implements Function2 {
        int label;

        C10062(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AutomationEngine.this.new C10062(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C10062) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ScheduleStoreInterface scheduleStoreInterface = AutomationEngine.this.store;
                this.label = 1;
                obj = scheduleStoreInterface.getSchedules(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            AutomationEngine automationEngine = AutomationEngine.this;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : (Iterable) obj) {
                if (!((AutomationScheduleData) obj2).shouldDelete$urbanairship_automation_release(automationEngine.clock.currentTimeMillis())) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((AutomationScheduleData) it.next()).getSchedule());
            }
            return arrayList2;
        }
    }

    @Override // com.urbanairship.automation.engine.AutomationEngineInterface
    @Nullable
    public Object getSchedules(@NotNull Continuation<? super List<AutomationSchedule>> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C10062(null), continuation);
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$getSchedule$2, reason: invalid class name and case insensitive filesystem */
    static final class C10052 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $identifier;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10052(String str, Continuation continuation) {
            super(2, continuation);
            this.$identifier = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AutomationEngine.this.new C10052(this.$identifier, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C10052) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ScheduleStoreInterface scheduleStoreInterface = AutomationEngine.this.store;
                String str = this.$identifier;
                this.label = 1;
                obj = scheduleStoreInterface.getSchedule(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            AutomationScheduleData automationScheduleData = (AutomationScheduleData) obj;
            if (automationScheduleData == null || automationScheduleData.isExpired$urbanairship_automation_release(AutomationEngine.this.clock.currentTimeMillis())) {
                return null;
            }
            return automationScheduleData.getSchedule();
        }
    }

    @Override // com.urbanairship.automation.engine.AutomationEngineInterface
    @Nullable
    public Object getSchedule(@NotNull String str, @NotNull Continuation<? super AutomationSchedule> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C10052(str, null), continuation);
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$getSchedules$4, reason: invalid class name and case insensitive filesystem */
    static final class C10074 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $group;
        long J$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10074(String str, Continuation continuation) {
            super(2, continuation);
            this.$group = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AutomationEngine.this.new C10074(this.$group, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C10074) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long jCurrentTimeMillis = AutomationEngine.this.clock.currentTimeMillis();
                ScheduleStoreInterface scheduleStoreInterface = AutomationEngine.this.store;
                String str = this.$group;
                this.J$0 = jCurrentTimeMillis;
                this.label = 1;
                obj = scheduleStoreInterface.getSchedules(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j = jCurrentTimeMillis;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.J$0;
                ResultKt.throwOnFailure(obj);
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : (Iterable) obj) {
                if (!((AutomationScheduleData) obj2).isExpired$urbanairship_automation_release(j)) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((AutomationScheduleData) it.next()).getSchedule());
            }
            return CollectionsKt.toList(arrayList2);
        }
    }

    @Override // com.urbanairship.automation.engine.AutomationEngineInterface
    @Nullable
    public Object getSchedules(@NotNull String str, @NotNull Continuation<? super List<AutomationSchedule>> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C10074(str, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateState(java.lang.String r6, kotlin.jvm.functions.Function1 r7, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.urbanairship.automation.engine.AutomationEngine.C10271
            if (r0 == 0) goto L13
            r0 = r8
            com.urbanairship.automation.engine.AutomationEngine$updateState$1 r0 = (com.urbanairship.automation.engine.AutomationEngine.C10271) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.engine.AutomationEngine$updateState$1 r0 = new com.urbanairship.automation.engine.AutomationEngine$updateState$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.L$0
            com.urbanairship.automation.engine.AutomationScheduleData r5 = (com.urbanairship.automation.engine.AutomationScheduleData) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L72
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r5 = r0.L$0
            com.urbanairship.automation.engine.AutomationEngine r5 = (com.urbanairship.automation.engine.AutomationEngine) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L57
        L45:
            kotlin.ResultKt.throwOnFailure(r8)
            com.urbanairship.automation.engine.ScheduleStoreInterface r8 = r5.store
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r8 = r8.updateSchedule(r6, r7, r0)
            if (r8 != r1) goto L57
            return r1
        L57:
            r7 = r8
            com.urbanairship.automation.engine.AutomationScheduleData r7 = (com.urbanairship.automation.engine.AutomationScheduleData) r7
            r8 = 0
            if (r7 != 0) goto L5e
            return r8
        L5e:
            com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor r5 = r5.triggerProcessor
            com.urbanairship.automation.engine.AutomationScheduleState r2 = r7.getScheduleState()
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r5 = r5.updateScheduleState(r6, r2, r0)
            if (r5 != r1) goto L71
            return r1
        L71:
            r5 = r7
        L72:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationEngine.updateState(java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bf A[Catch: Exception -> 0x0039, TRY_LEAVE, TryCatch #0 {Exception -> 0x0039, blocks: (B:15:0x0034, B:22:0x004d, B:36:0x0094, B:26:0x0060, B:42:0x00bb, B:44:0x00bf, B:29:0x006d, B:33:0x007e, B:39:0x00a5), top: B:50:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processTriggerResult(final com.urbanairship.automation.engine.triggerprocessor.TriggerResult r11, kotlin.coroutines.Continuation r12) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationEngine.processTriggerResult(com.urbanairship.automation.engine.triggerprocessor.TriggerResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02dc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0175 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x01dd -> B:71:0x01fb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x01f8 -> B:71:0x01fb). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object restoreSchedules(kotlin.coroutines.Continuation r20) {
        /*
            Method dump skipped, instructions count: 762
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationEngine.restoreSchedules(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$startTaskToProcessTriggeredSchedule$2, reason: invalid class name and case insensitive filesystem */
    static final class C10252 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $scheduleId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10252(String str, Continuation continuation) {
            super(2, continuation);
            this.$scheduleId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AutomationEngine.this.new C10252(this.$scheduleId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C10252) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final String str = this.$scheduleId;
                UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationEngine.startTaskToProcessTriggeredSchedule.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Processing triggered schedule " + str;
                    }
                }, 1, null);
                AutomationEngine automationEngine = AutomationEngine.this;
                String str2 = this.$scheduleId;
                this.label = 1;
                if (automationEngine.processTriggeredSchedule(str2, this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final Object startTaskToProcessTriggeredSchedule(String str, Continuation continuation) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C10252(str, null), 3, null);
        Object objYield = YieldKt.yield(continuation);
        return objYield == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objYield : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0132 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processTriggeredSchedule(java.lang.String r8, kotlin.coroutines.Continuation r9) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationEngine.processTriggeredSchedule(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$processTriggeredSchedule$2, reason: invalid class name and case insensitive filesystem */
    static final class C10192 extends SuspendLambda implements Function2 {
        /* synthetic */ boolean Z$0;
        int label;

        C10192(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C10192 c10192 = new C10192(continuation);
            c10192.Z$0 = ((Boolean) obj).booleanValue();
            return c10192;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
        }

        public final Object invoke(boolean z, Continuation continuation) {
            return ((C10192) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(!this.Z$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processPrepared(com.urbanairship.automation.engine.AutomationEngine.PreparedData r10, kotlin.coroutines.Continuation r11) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationEngine.processPrepared(com.urbanairship.automation.engine.AutomationEngine$PreparedData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processNextPendingExecution(Continuation continuation) {
        Object next;
        Object value;
        Set mutableSet;
        Iterator it = ((Iterable) this.pendingExecution.getValue()).iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int priority = ((PreparedData) next).getPriority();
                do {
                    Object next2 = it.next();
                    int priority2 = ((PreparedData) next2).getPriority();
                    if (priority > priority2) {
                        next = next2;
                        priority = priority2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        final PreparedData preparedData = (PreparedData) next;
        if (preparedData == null) {
            return Unit.INSTANCE;
        }
        UALog.d$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationEngine.processNextPendingExecution.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Processing next pending schedule for execution: " + preparedData.getSchedule();
            }
        }, 1, null);
        MutableStateFlow mutableStateFlow = this.pendingExecution;
        do {
            value = mutableStateFlow.getValue();
            mutableSet = CollectionsKt.toMutableSet((Set) value);
            mutableSet.remove(preparedData);
        } while (!mutableStateFlow.compareAndSet(value, mutableSet));
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(Boxing.boxBoolean(false));
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C10134(MutableStateFlow, this, preparedData, null), 3, null);
        Object objFirst = FlowKt.first(MutableStateFlow, new AnonymousClass5(null), continuation);
        return objFirst == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFirst : Unit.INSTANCE;
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$processNextPendingExecution$4, reason: invalid class name and case insensitive filesystem */
    static final class C10134 extends SuspendLambda implements Function2 {
        final /* synthetic */ MutableStateFlow $jobRan;
        final /* synthetic */ PreparedData $next;
        int label;
        final /* synthetic */ AutomationEngine this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10134(MutableStateFlow mutableStateFlow, AutomationEngine automationEngine, PreparedData preparedData, Continuation continuation) {
            super(2, continuation);
            this.$jobRan = mutableStateFlow;
            this.this$0 = automationEngine;
            this.$next = preparedData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C10134(this.$jobRan, this.this$0, this.$next, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C10134) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* renamed from: com.urbanairship.automation.engine.AutomationEngine$processNextPendingExecution$4$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2 {
            final /* synthetic */ MutableStateFlow $jobRan;
            final /* synthetic */ PreparedData $next;
            int label;
            final /* synthetic */ AutomationEngine this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MutableStateFlow mutableStateFlow, AutomationEngine automationEngine, PreparedData preparedData, Continuation continuation) {
                super(2, continuation);
                this.$jobRan = mutableStateFlow;
                this.this$0 = automationEngine;
                this.$next = preparedData;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass1(this.$jobRan, this.this$0, this.$next, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:27:0x00a3  */
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
                    r2 = 3
                    r3 = 2
                    r4 = 0
                    r5 = 1
                    if (r1 == 0) goto L28
                    if (r1 == r5) goto L24
                    if (r1 == r3) goto L1f
                    if (r1 != r2) goto L17
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L91
                L17:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L1f:
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto Ld7
                L24:
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L4e
                L28:
                    kotlin.ResultKt.throwOnFailure(r8)
                    kotlinx.coroutines.flow.MutableStateFlow r8 = r7.$jobRan
                L2d:
                    java.lang.Object r1 = r8.getValue()
                    r6 = r1
                    java.lang.Boolean r6 = (java.lang.Boolean) r6
                    r6.booleanValue()
                    java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                    boolean r1 = r8.compareAndSet(r1, r6)
                    if (r1 == 0) goto L2d
                    com.urbanairship.automation.engine.AutomationEngine r8 = r7.this$0
                    com.urbanairship.automation.engine.AutomationEngine$PreparedData r1 = r7.$next
                    r7.label = r5
                    java.lang.Object r8 = com.urbanairship.automation.engine.AutomationEngine.access$checkStillValid(r8, r1, r7)
                    if (r8 != r0) goto L4e
                    return r0
                L4e:
                    java.lang.Boolean r8 = (java.lang.Boolean) r8
                    boolean r8 = r8.booleanValue()
                    if (r8 == 0) goto Lc0
                    com.urbanairship.automation.engine.AutomationEngine r8 = r7.this$0
                    com.urbanairship.automation.engine.AutomationDelayProcessorInterface r8 = com.urbanairship.automation.engine.AutomationEngine.access$getDelayProcessor$p(r8)
                    com.urbanairship.automation.engine.AutomationEngine$PreparedData r1 = r7.$next
                    com.urbanairship.automation.engine.AutomationScheduleData r1 = r1.getSchedule()
                    com.urbanairship.automation.AutomationSchedule r1 = r1.getSchedule()
                    com.urbanairship.automation.AutomationDelay r1 = r1.getDelay()
                    boolean r8 = r8.areConditionsMet(r1)
                    if (r8 == 0) goto Lc0
                    com.urbanairship.automation.engine.AutomationEngine$processNextPendingExecution$4$1$3 r8 = new com.urbanairship.automation.engine.AutomationEngine$processNextPendingExecution$4$1$3
                    com.urbanairship.automation.engine.AutomationEngine$PreparedData r1 = r7.$next
                    r8.<init>()
                    com.urbanairship.UALog.v$default(r4, r8, r5, r4)
                    com.urbanairship.automation.engine.AutomationEngine r8 = r7.this$0
                    com.urbanairship.automation.engine.AutomationEngine$PreparedData r1 = r7.$next
                    com.urbanairship.automation.engine.AutomationScheduleData r1 = r1.getSchedule()
                    com.urbanairship.automation.engine.AutomationEngine$PreparedData r3 = r7.$next
                    com.urbanairship.automation.engine.PreparedSchedule r3 = r3.getPreparedSchedule()
                    r7.label = r2
                    java.lang.Object r8 = com.urbanairship.automation.engine.AutomationEngine.access$attemptExecute(r8, r1, r3, r7)
                    if (r8 != r0) goto L91
                    return r0
                L91:
                    java.lang.Boolean r8 = (java.lang.Boolean) r8
                    boolean r8 = r8.booleanValue()
                    com.urbanairship.automation.engine.AutomationEngine$processNextPendingExecution$4$1$4 r0 = new com.urbanairship.automation.engine.AutomationEngine$processNextPendingExecution$4$1$4
                    com.urbanairship.automation.engine.AutomationEngine$PreparedData r1 = r7.$next
                    r0.<init>()
                    com.urbanairship.UALog.v$default(r4, r0, r5, r4)
                    if (r8 != 0) goto Ld7
                    com.urbanairship.automation.engine.AutomationEngine r8 = r7.this$0
                    kotlinx.coroutines.flow.MutableStateFlow r8 = com.urbanairship.automation.engine.AutomationEngine.access$getPendingExecution$p(r8)
                    com.urbanairship.automation.engine.AutomationEngine$PreparedData r7 = r7.$next
                Lab:
                    java.lang.Object r0 = r8.getValue()
                    r1 = r0
                    java.util.Set r1 = (java.util.Set) r1
                    java.util.Set r1 = kotlin.collections.CollectionsKt.toMutableSet(r1)
                    r1.add(r7)
                    boolean r0 = r8.compareAndSet(r0, r1)
                    if (r0 == 0) goto Lab
                    goto Ld7
                Lc0:
                    com.urbanairship.automation.engine.AutomationEngine$processNextPendingExecution$4$1$2 r8 = new com.urbanairship.automation.engine.AutomationEngine$processNextPendingExecution$4$1$2
                    com.urbanairship.automation.engine.AutomationEngine$PreparedData r1 = r7.$next
                    r8.<init>()
                    com.urbanairship.UALog.v$default(r4, r8, r5, r4)
                    com.urbanairship.automation.engine.AutomationEngine r8 = r7.this$0
                    com.urbanairship.automation.engine.AutomationEngine$PreparedData r1 = r7.$next
                    r7.label = r3
                    java.lang.Object r7 = com.urbanairship.automation.engine.AutomationEngine.access$processPrepared(r8, r1, r7)
                    if (r7 != r0) goto Ld7
                    return r0
                Ld7:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationEngine.C10134.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MainCoroutineDispatcher main = Dispatchers.getMain();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$jobRan, this.this$0, this.$next, null);
                this.label = 1;
                if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
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

    /* renamed from: com.urbanairship.automation.engine.AutomationEngine$processNextPendingExecution$5, reason: invalid class name */
    static final class AnonymousClass5 extends SuspendLambda implements Function2 {
        /* synthetic */ boolean Z$0;
        int label;

        AnonymousClass5(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(continuation);
            anonymousClass5.Z$0 = ((Boolean) obj).booleanValue();
            return anonymousClass5;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
        }

        public final Object invoke(boolean z, Continuation continuation) {
            return ((AnonymousClass5) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(this.Z$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object checkStillValid(final com.urbanairship.automation.engine.AutomationEngine.PreparedData r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.urbanairship.automation.engine.AutomationEngine.C10011
            if (r0 == 0) goto L13
            r0 = r8
            com.urbanairship.automation.engine.AutomationEngine$checkStillValid$1 r0 = (com.urbanairship.automation.engine.AutomationEngine.C10011) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.engine.AutomationEngine$checkStillValid$1 r0 = new com.urbanairship.automation.engine.AutomationEngine$checkStillValid$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.L$1
            r7 = r6
            com.urbanairship.automation.engine.AutomationEngine$PreparedData r7 = (com.urbanairship.automation.engine.AutomationEngine.PreparedData) r7
            java.lang.Object r6 = r0.L$0
            com.urbanairship.automation.engine.AutomationEngine r6 = (com.urbanairship.automation.engine.AutomationEngine) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L50
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r8)
            com.urbanairship.automation.engine.ScheduleStoreInterface r8 = r6.store
            java.lang.String r2 = r7.getScheduleId()
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = r8.getSchedule(r2, r0)
            if (r8 != r1) goto L50
            return r1
        L50:
            com.urbanairship.automation.engine.AutomationScheduleData r8 = (com.urbanairship.automation.engine.AutomationScheduleData) r8
            r0 = 0
            r1 = 0
            if (r8 == 0) goto Lb0
            com.urbanairship.automation.engine.AutomationScheduleState r2 = r8.getScheduleState()
            com.urbanairship.automation.engine.AutomationScheduleState r4 = com.urbanairship.automation.engine.AutomationScheduleState.PREPARED
            if (r2 != r4) goto Lb0
            com.urbanairship.automation.AutomationSchedule r8 = r8.getSchedule()
            com.urbanairship.automation.engine.AutomationScheduleData r2 = r7.getSchedule()
            com.urbanairship.automation.AutomationSchedule r2 = r2.getSchedule()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r2)
            if (r8 != 0) goto L71
            goto Lb0
        L71:
            com.urbanairship.automation.engine.AutomationScheduleData r8 = r7.getSchedule()
            com.urbanairship.util.Clock r2 = r6.clock
            long r4 = r2.currentTimeMillis()
            boolean r8 = r8.isActive$urbanairship_automation_release(r4)
            if (r8 != 0) goto L8e
            com.urbanairship.automation.engine.AutomationEngine$checkStillValid$3 r6 = new com.urbanairship.automation.engine.AutomationEngine$checkStillValid$3
            r6.<init>()
            com.urbanairship.UALog.v$default(r1, r6, r3, r1)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r6
        L8e:
            com.urbanairship.automation.engine.AutomationExecutorInterface r6 = r6.executor
            com.urbanairship.automation.engine.AutomationScheduleData r8 = r7.getSchedule()
            com.urbanairship.automation.AutomationSchedule r8 = r8.getSchedule()
            boolean r6 = r6.isValid(r8)
            if (r6 != 0) goto Lab
            com.urbanairship.automation.engine.AutomationEngine$checkStillValid$4 r6 = new com.urbanairship.automation.engine.AutomationEngine$checkStillValid$4
            r6.<init>()
            com.urbanairship.UALog.v$default(r1, r6, r3, r1)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r6
        Lab:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        Lb0:
            com.urbanairship.automation.engine.AutomationEngine$checkStillValid$2 r6 = new com.urbanairship.automation.engine.AutomationEngine$checkStillValid$2
            r6.<init>()
            com.urbanairship.UALog.v$default(r1, r6, r3, r1)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationEngine.checkStillValid(com.urbanairship.automation.engine.AutomationEngine$PreparedData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object waitForConditions(final com.urbanairship.automation.engine.AutomationEngine.PreparedData r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.urbanairship.automation.engine.AutomationEngine.C10291
            if (r0 == 0) goto L13
            r0 = r9
            com.urbanairship.automation.engine.AutomationEngine$waitForConditions$1 r0 = (com.urbanairship.automation.engine.AutomationEngine.C10291) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.engine.AutomationEngine$waitForConditions$1 r0 = new com.urbanairship.automation.engine.AutomationEngine$waitForConditions$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.lang.Object r7 = r0.L$0
            r8 = r7
            com.urbanairship.automation.engine.AutomationEngine$PreparedData r8 = (com.urbanairship.automation.engine.AutomationEngine.PreparedData) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L72
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            kotlin.ResultKt.throwOnFailure(r9)
            com.urbanairship.automation.engine.AutomationScheduleData r9 = r8.getSchedule()
            com.urbanairship.automation.engine.TriggeringInfo r9 = r9.getTriggerInfo()
            if (r9 == 0) goto L49
            long r5 = r9.getDate()
            goto L51
        L49:
            com.urbanairship.automation.engine.AutomationScheduleData r9 = r8.getSchedule()
            long r5 = r9.getScheduleStateChangeDate()
        L51:
            com.urbanairship.automation.engine.AutomationEngine$waitForConditions$2 r9 = new com.urbanairship.automation.engine.AutomationEngine$waitForConditions$2
            r9.<init>()
            com.urbanairship.UALog.v$default(r3, r9, r4, r3)
            com.urbanairship.automation.engine.AutomationDelayProcessorInterface r7 = r7.delayProcessor
            com.urbanairship.automation.engine.AutomationScheduleData r9 = r8.getSchedule()
            com.urbanairship.automation.AutomationSchedule r9 = r9.getSchedule()
            com.urbanairship.automation.AutomationDelay r9 = r9.getDelay()
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r7 = r7.process(r9, r5, r0)
            if (r7 != r1) goto L72
            return r1
        L72:
            com.urbanairship.automation.engine.AutomationEngine$waitForConditions$3 r7 = new com.urbanairship.automation.engine.AutomationEngine$waitForConditions$3
            r7.<init>()
            com.urbanairship.UALog.v$default(r3, r7, r4, r3)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationEngine.waitForConditions(com.urbanairship.automation.engine.AutomationEngine$PreparedData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object prepareSchedule(final com.urbanairship.automation.engine.AutomationScheduleData r12, kotlin.coroutines.Continuation r13) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationEngine.prepareSchedule(com.urbanairship.automation.engine.AutomationScheduleData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x011f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01bd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01e9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0230  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object attemptExecute(com.urbanairship.automation.engine.AutomationScheduleData r20, com.urbanairship.automation.engine.PreparedSchedule r21, kotlin.coroutines.Continuation r22) {
        /*
            Method dump skipped, instructions count: 614
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationEngine.attemptExecute(com.urbanairship.automation.engine.AutomationScheduleData, com.urbanairship.automation.engine.PreparedSchedule, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final ScheduleReadyResult checkReady(final AutomationScheduleData data, PreparedSchedule preparedSchedule) {
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationEngine.checkReady.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Checking if schedule is ready " + data;
            }
        }, 1, null);
        if (((Boolean) this.isExecutionPaused.getValue()).booleanValue() || ((Boolean) this.isPaused.getValue()).booleanValue()) {
            UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationEngine.checkReady.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Executor paused, not ready " + data;
                }
            }, 1, null);
            return ScheduleReadyResult.NOT_READY;
        }
        if (!data.isActive$urbanairship_automation_release(this.clock.currentTimeMillis())) {
            UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationEngine.checkReady.3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Schedule no longer active, Invalidating " + data;
                }
            }, 1, null);
            return ScheduleReadyResult.INVALIDATE;
        }
        ScheduleReadyResult scheduleReadyResultIsReady = this.executor.isReady(preparedSchedule);
        if (scheduleReadyResultIsReady != ScheduleReadyResult.READY) {
            UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationEngine.checkReady.4
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Schedule not ready " + data;
                }
            }, 1, null);
        }
        return scheduleReadyResultIsReady;
    }

    /* renamed from: handleInterval-VtjQ1oo, reason: not valid java name */
    private final void m2802handleIntervalVtjQ1oo(final long interval, final String scheduleID) {
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationEngine$handleInterval$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "handleInterval(interval: " + ((Object) Duration.m3515toStringimpl(interval)) + ", scheduleID: " + scheduleID + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }
        }, 1, null);
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AutomationEngine$handleInterval$2(this, interval, scheduleID, null), 3, null);
    }

    private static final class PreparedData {
        private final PreparedSchedule preparedSchedule;
        private final int priority;
        private final AutomationScheduleData schedule;
        private final String scheduleId;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PreparedData)) {
                return false;
            }
            PreparedData preparedData = (PreparedData) obj;
            return Intrinsics.areEqual(this.schedule, preparedData.schedule) && Intrinsics.areEqual(this.preparedSchedule, preparedData.preparedSchedule);
        }

        public int hashCode() {
            return (this.schedule.hashCode() * 31) + this.preparedSchedule.hashCode();
        }

        public String toString() {
            return "PreparedData(schedule=" + this.schedule + ", preparedSchedule=" + this.preparedSchedule + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public PreparedData(AutomationScheduleData schedule, PreparedSchedule preparedSchedule) {
            Intrinsics.checkNotNullParameter(schedule, "schedule");
            Intrinsics.checkNotNullParameter(preparedSchedule, "preparedSchedule");
            this.schedule = schedule;
            this.preparedSchedule = preparedSchedule;
            this.scheduleId = schedule.getSchedule().getIdentifier();
            Integer priority = schedule.getSchedule().getPriority();
            this.priority = priority != null ? priority.intValue() : 0;
        }

        public final AutomationScheduleData getSchedule() {
            return this.schedule;
        }

        public final PreparedSchedule getPreparedSchedule() {
            return this.preparedSchedule;
        }

        public final String getScheduleId() {
            return this.scheduleId;
        }

        public final int getPriority() {
            return this.priority;
        }
    }
}
