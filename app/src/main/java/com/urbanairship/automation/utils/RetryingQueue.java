package com.urbanairship.automation.utils;

import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.UALog;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.remoteconfig.RetryingQueueConfig;
import com.urbanairship.util.TaskSleeper;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 02\u00020\u0001:\u0003012B\u001d\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B7\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ&\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\u001fJ*\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140#2\u0006\u0010$\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010%J$\u0010&\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0015H\u0002JP\u0010'\u001a\u0002H(\"\u0004\b\u0000\u0010(2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\b2\"\u0010)\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H(0,0+\u0012\u0006\u0012\u0004\u0018\u00010\u00010*H\u0082@¢\u0006\u0002\u0010-JJ\u0010.\u001a\u0002H(\"\u0004\b\u0000\u0010(2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\b2\"\u0010)\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H(0,0+\u0012\u0006\u0012\u0004\u0018\u00010\u00010*H\u0086@¢\u0006\u0002\u0010/R\u0016\u0010\n\u001a\u00020\u000bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\f\u001a\u00020\u000bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00063"}, m1836d2 = {"Lcom/urbanairship/automation/utils/RetryingQueue;", "", "config", "Lcom/urbanairship/remoteconfig/RetryingQueueConfig;", "sleeper", "Lcom/urbanairship/util/TaskSleeper;", "(Lcom/urbanairship/remoteconfig/RetryingQueueConfig;Lcom/urbanairship/util/TaskSleeper;)V", "maxConcurrentOperations", "", "maxPendingResults", "initialBackOff", "Lkotlin/time/Duration;", "maxBackOff", "taskSleeper", "(IIJJLcom/urbanairship/util/TaskSleeper;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "nextTaskNumber", "Ljava/util/concurrent/atomic/AtomicLong;", "pendingResultTasks", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/urbanairship/automation/utils/RetryingQueue$PriorityTaskId;", "pendingStartTasks", "performingTasks", "startedTasks", "awaitTaskId", "scope", "Lkotlinx/coroutines/CoroutineScope;", "name", "", Constants.FirelogAnalytics.PARAM_PRIORITY, "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitTasksTurn", "", "tasks", "Lkotlinx/coroutines/flow/StateFlow;", "priorityTaskId", "(Lkotlinx/coroutines/flow/StateFlow;Lcom/urbanairship/automation/utils/RetryingQueue$PriorityTaskId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkCancelled", "doTask", ExifInterface.GPS_DIRECTION_TRUE, "operation", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/urbanairship/automation/utils/RetryingQueue$Result;", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "run", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "PriorityTaskId", "Result", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nRetryingQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RetryingQueue.kt\ncom/urbanairship/automation/utils/RetryingQueue\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,206:1\n226#2,5:207\n226#2,5:212\n226#2,5:217\n226#2,5:222\n226#2,5:227\n226#2,5:232\n226#2,5:237\n226#2,5:242\n226#2,5:247\n226#2,5:252\n226#2,5:257\n226#2,5:262\n226#2,5:267\n*S KotlinDebug\n*F\n+ 1 RetryingQueue.kt\ncom/urbanairship/automation/utils/RetryingQueue\n*L\n88#1:207,5\n107#1:212,5\n108#1:217,5\n109#1:222,5\n118#1:227,5\n119#1:232,5\n120#1:237,5\n121#1:242,5\n149#1:247,5\n155#1:252,5\n177#1:257,5\n182#1:262,5\n185#1:267,5\n*E\n"})
public final class RetryingQueue {
    private static final Companion Companion = new Companion(null);
    private final long initialBackOff;
    private final long maxBackOff;
    private final int maxConcurrentOperations;
    private final int maxPendingResults;
    private AtomicLong nextTaskNumber;
    private final MutableStateFlow pendingResultTasks;
    private final MutableStateFlow pendingStartTasks;
    private final MutableStateFlow performingTasks;
    private final MutableStateFlow startedTasks;
    private final TaskSleeper taskSleeper;

    /* JADX INFO: renamed from: com.urbanairship.automation.utils.RetryingQueue$awaitTaskId$1 */
    static final class C51441 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C51441(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetryingQueue.this.awaitTaskId(null, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.automation.utils.RetryingQueue$doTask$1 */
    static final class C51491 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C51491(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RetryingQueue.this.doTask(null, null, 0, null, this);
        }
    }

    public /* synthetic */ RetryingQueue(int i, int i2, long j, long j2, TaskSleeper taskSleeper, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, j, j2, taskSleeper);
    }

    private RetryingQueue(int i, int i2, long j, long j2, TaskSleeper taskSleeper) {
        Intrinsics.checkNotNullParameter(taskSleeper, "taskSleeper");
        this.maxConcurrentOperations = i;
        this.maxPendingResults = i2;
        this.initialBackOff = j;
        this.maxBackOff = j2;
        this.taskSleeper = taskSleeper;
        if (i <= 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (!Duration.m5805isPositiveimpl(j)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (!Duration.m5805isPositiveimpl(j2)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.nextTaskNumber = new AtomicLong(0L);
        this.pendingStartTasks = StateFlowKt.MutableStateFlow(SetsKt.emptySet());
        this.startedTasks = StateFlowKt.MutableStateFlow(SetsKt.emptySet());
        this.performingTasks = StateFlowKt.MutableStateFlow(SetsKt.emptySet());
        this.pendingResultTasks = StateFlowKt.MutableStateFlow(SetsKt.emptySet());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ RetryingQueue(int i, int i2, long j, long j2, TaskSleeper taskSleeper, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        long duration;
        long duration2;
        int i4 = (i3 & 1) != 0 ? 3 : i;
        int i5 = (i3 & 2) == 0 ? i2 : 2;
        if ((i3 & 4) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            duration = DurationKt.toDuration(15, DurationUnit.SECONDS);
        } else {
            duration = j;
        }
        if ((i3 & 8) != 0) {
            Duration.Companion companion2 = Duration.INSTANCE;
            duration2 = DurationKt.toDuration(60, DurationUnit.SECONDS);
        } else {
            duration2 = j2;
        }
        this(i4, i5, duration, duration2, (i3 & 16) != 0 ? TaskSleeper.INSTANCE.getDefault() : taskSleeper, null);
    }

    public /* synthetic */ RetryingQueue(RetryingQueueConfig retryingQueueConfig, TaskSleeper taskSleeper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : retryingQueueConfig, (i & 2) != 0 ? TaskSleeper.INSTANCE.getDefault() : taskSleeper);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public RetryingQueue(@Nullable RetryingQueueConfig retryingQueueConfig, @NotNull TaskSleeper sleeper) {
        Number maxBackOff;
        Number initialBackoff;
        Integer maxPendingResults;
        Integer maxConcurrentOperations;
        Intrinsics.checkNotNullParameter(sleeper, "sleeper");
        int iIntValue = (retryingQueueConfig == null || (maxConcurrentOperations = retryingQueueConfig.getMaxConcurrentOperations()) == null) ? 3 : maxConcurrentOperations.intValue();
        int iIntValue2 = (retryingQueueConfig == null || (maxPendingResults = retryingQueueConfig.getMaxPendingResults()) == null) ? 2 : maxPendingResults.intValue();
        Duration.Companion companion = Duration.INSTANCE;
        int iIntValue3 = ((retryingQueueConfig == null || (initialBackoff = retryingQueueConfig.getInitialBackoff()) == null) ? 15 : initialBackoff).intValue();
        DurationUnit durationUnit = DurationUnit.SECONDS;
        this(iIntValue, iIntValue2, DurationKt.toDuration(iIntValue3, durationUnit), DurationKt.toDuration(((retryingQueueConfig == null || (maxBackOff = retryingQueueConfig.getMaxBackOff()) == null) ? 60 : maxBackOff).intValue(), durationUnit), sleeper, null);
    }

    @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, m1836d2 = {"Lcom/urbanairship/automation/utils/RetryingQueue$Result;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "Retry", "Success", "Lcom/urbanairship/automation/utils/RetryingQueue$Result$Retry;", "Lcom/urbanairship/automation/utils/RetryingQueue$Result$Success;", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static abstract class Result<T> {
        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\r\u001a\u00020\u0005HÆ\u0003J(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, m1836d2 = {"Lcom/urbanairship/automation/utils/RetryingQueue$Result$Success;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/automation/utils/RetryingQueue$Result;", "result", "ignoreReturnOrder", "", "(Ljava/lang/Object;Z)V", "getIgnoreReturnOrder", "()Z", "getResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(Ljava/lang/Object;Z)Lcom/urbanairship/automation/utils/RetryingQueue$Result$Success;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
        public static final /* data */ class Success<T> extends Result<T> {
            private final boolean ignoreReturnOrder;
            private final Object result;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Success copy$default(Success success, Object obj, boolean z, int i, Object obj2) {
                if ((i & 1) != 0) {
                    obj = success.result;
                }
                if ((i & 2) != 0) {
                    z = success.ignoreReturnOrder;
                }
                return success.copy(obj, z);
            }

            public final T component1() {
                return (T) this.result;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIgnoreReturnOrder() {
                return this.ignoreReturnOrder;
            }

            @NotNull
            public final Success<T> copy(T result, boolean ignoreReturnOrder) {
                return new Success<>(result, ignoreReturnOrder);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return Intrinsics.areEqual(this.result, success.result) && this.ignoreReturnOrder == success.ignoreReturnOrder;
            }

            public int hashCode() {
                Object obj = this.result;
                return ((obj == null ? 0 : obj.hashCode()) * 31) + Boolean.hashCode(this.ignoreReturnOrder);
            }

            @NotNull
            public String toString() {
                return "Success(result=" + this.result + ", ignoreReturnOrder=" + this.ignoreReturnOrder + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public /* synthetic */ Success(Object obj, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(obj, (i & 2) != 0 ? false : z);
            }

            public final T getResult() {
                return (T) this.result;
            }

            public final boolean getIgnoreReturnOrder() {
                return this.ignoreReturnOrder;
            }

            public Success(T t, boolean z) {
                super(null);
                this.result = t;
                this.ignoreReturnOrder = z;
            }
        }

        private Result() {
        }

        @Metadata(m1835d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\tJ#\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001ø\u0001\u0000¢\u0006\u0002\b\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, m1836d2 = {"Lcom/urbanairship/automation/utils/RetryingQueue$Result$Retry;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/automation/utils/RetryingQueue$Result;", "retryAfter", "Lkotlin/time/Duration;", "(Lkotlin/time/Duration;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getRetryAfter-FghU774", "()Lkotlin/time/Duration;", "component1", "component1-FghU774", "copy", "copy-BwNAW2A", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
        public static final /* data */ class Retry<T> extends Result<T> {
            private final Duration retryAfter;

            public /* synthetic */ Retry(Duration duration, DefaultConstructorMarker defaultConstructorMarker) {
                this(duration);
            }

            /* JADX INFO: renamed from: copy-BwNAW2A$default, reason: not valid java name */
            public static /* synthetic */ Retry m5063copyBwNAW2A$default(Retry retry, Duration duration, int i, Object obj) {
                if ((i & 1) != 0) {
                    duration = retry.retryAfter;
                }
                return retry.m5065copyBwNAW2A(duration);
            }

            @Nullable
            /* JADX INFO: renamed from: component1-FghU774, reason: not valid java name and from getter */
            public final Duration getRetryAfter() {
                return this.retryAfter;
            }

            @NotNull
            /* JADX INFO: renamed from: copy-BwNAW2A, reason: not valid java name */
            public final Retry<T> m5065copyBwNAW2A(@Nullable Duration retryAfter) {
                return new Retry<>(retryAfter, null);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Retry) && Intrinsics.areEqual(this.retryAfter, ((Retry) other).retryAfter);
            }

            public int hashCode() {
                Duration duration = this.retryAfter;
                if (duration == null) {
                    return 0;
                }
                return Duration.m5799hashCodeimpl(duration.getRawValue());
            }

            @NotNull
            public String toString() {
                return "Retry(retryAfter=" + this.retryAfter + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            private Retry(Duration duration) {
                super(null);
                this.retryAfter = duration;
            }

            public /* synthetic */ Retry(Duration duration, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : duration, null);
            }

            @Nullable
            /* JADX INFO: renamed from: getRetryAfter-FghU774, reason: not valid java name */
            public final Duration m5066getRetryAfterFghU774() {
                return this.retryAfter;
            }
        }
    }

    public static /* synthetic */ Object run$default(RetryingQueue retryingQueue, String str, int i, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return retryingQueue.run(str, i, function1, continuation);
    }

    /* JADX INFO: renamed from: com.urbanairship.automation.utils.RetryingQueue$run$2 */
    static final class C51542 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $name;
        final /* synthetic */ Function1 $operation;
        final /* synthetic */ int $priority;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C51542(String str, int i, Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.$name = str;
            this.$priority = i;
            this.$operation = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C51542 c51542 = RetryingQueue.this.new C51542(this.$name, this.$priority, this.$operation, continuation);
            c51542.L$0 = obj;
            return c51542;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C51542) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                RetryingQueue retryingQueue = RetryingQueue.this;
                String str = this.$name;
                int i2 = this.$priority;
                Function1 function1 = this.$operation;
                this.label = 1;
                obj = retryingQueue.doTask(coroutineScope, str, i2, function1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Nullable
    public final <T> Object run(@NotNull String str, int i, @NotNull Function1<? super Continuation<? super Result<T>>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        return CoroutineScopeKt.coroutineScope(new C51542(str, i, function1, null), continuation);
    }

    /* JADX INFO: renamed from: com.urbanairship.automation.utils.RetryingQueue$awaitTasksTurn$2 */
    static final class C51472 extends SuspendLambda implements Function2 {
        final /* synthetic */ PriorityTaskId $priorityTaskId;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C51472(PriorityTaskId priorityTaskId, Continuation continuation) {
            super(2, continuation);
            this.$priorityTaskId = priorityTaskId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C51472 c51472 = new C51472(this.$priorityTaskId, continuation);
            c51472.L$0 = obj;
            return c51472;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Set set, Continuation continuation) {
            return ((C51472) create(set, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(Intrinsics.areEqual(CollectionsKt.firstOrNull(CollectionsKt.sortedWith((Set) this.L$0, ComparisonsKt.compareBy(new Function1() { // from class: com.urbanairship.automation.utils.RetryingQueue.awaitTasksTurn.2.1
                @Override // kotlin.jvm.functions.Function1
                public final Comparable invoke(PriorityTaskId it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Integer.valueOf(it.getPriority());
                }
            }, new Function1() { // from class: com.urbanairship.automation.utils.RetryingQueue.awaitTasksTurn.2.2
                @Override // kotlin.jvm.functions.Function1
                public final Comparable invoke(PriorityTaskId it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Long.valueOf(it.getIdentifier());
                }
            }))), this.$priorityTaskId));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitTasksTurn(StateFlow stateFlow, PriorityTaskId priorityTaskId, Continuation continuation) {
        Object objFirst = FlowKt.first(stateFlow, new C51472(priorityTaskId, null), continuation);
        return objFirst == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFirst : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x00e5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object awaitTaskId(CoroutineScope coroutineScope, String str, int i, Continuation continuation) {
        C51441 c51441;
        PriorityTaskId priorityTaskId;
        Object value;
        RetryingQueue retryingQueue;
        PriorityTaskId priorityTaskId2;
        CoroutineScope coroutineScope2;
        String str2;
        MutableStateFlow mutableStateFlow;
        C51464 c51464;
        PriorityTaskId priorityTaskId3;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        MutableStateFlow mutableStateFlow3;
        Object value3;
        MutableStateFlow mutableStateFlow4;
        Object value4;
        if (continuation instanceof C51441) {
            c51441 = (C51441) continuation;
            int i2 = c51441.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c51441.label = i2 - Integer.MIN_VALUE;
            } else {
                c51441 = new C51441(continuation);
            }
        } else {
            c51441 = new C51441(continuation);
        }
        Object obj = c51441.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c51441.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            priorityTaskId = new PriorityTaskId(this.nextTaskNumber.getAndIncrement(), i);
            MutableStateFlow mutableStateFlow5 = this.pendingStartTasks;
            do {
                value = mutableStateFlow5.getValue();
            } while (!mutableStateFlow5.compareAndSet(value, SetsKt.plus((Set<? extends PriorityTaskId>) value, priorityTaskId)));
            MutableStateFlow mutableStateFlow6 = this.pendingStartTasks;
            c51441.L$0 = this;
            c51441.L$1 = coroutineScope;
            c51441.L$2 = str;
            c51441.L$3 = priorityTaskId;
            c51441.label = 1;
            if (awaitTasksTurn(mutableStateFlow6, priorityTaskId, c51441) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 == 1) {
                PriorityTaskId priorityTaskId4 = (PriorityTaskId) c51441.L$3;
                str = (String) c51441.L$2;
                coroutineScope = (CoroutineScope) c51441.L$1;
                RetryingQueue retryingQueue2 = (RetryingQueue) c51441.L$0;
                ResultKt.throwOnFailure(obj);
                priorityTaskId = priorityTaskId4;
                this = retryingQueue2;
            } else if (i3 == 2) {
                priorityTaskId2 = (PriorityTaskId) c51441.L$3;
                str2 = (String) c51441.L$2;
                coroutineScope2 = (CoroutineScope) c51441.L$1;
                retryingQueue = (RetryingQueue) c51441.L$0;
                ResultKt.throwOnFailure(obj);
                retryingQueue.checkCancelled(coroutineScope2, str2, priorityTaskId2);
                mutableStateFlow = retryingQueue.pendingResultTasks;
                c51464 = retryingQueue.new C51464(null);
                c51441.L$0 = retryingQueue;
                c51441.L$1 = coroutineScope2;
                c51441.L$2 = str2;
                c51441.L$3 = priorityTaskId2;
                c51441.label = 3;
                if (FlowKt.first(mutableStateFlow, c51464, c51441) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i3 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                priorityTaskId2 = (PriorityTaskId) c51441.L$3;
                str2 = (String) c51441.L$2;
                coroutineScope2 = (CoroutineScope) c51441.L$1;
                retryingQueue = (RetryingQueue) c51441.L$0;
                ResultKt.throwOnFailure(obj);
            }
            priorityTaskId3 = priorityTaskId2;
            RetryingQueue retryingQueue3 = retryingQueue;
            retryingQueue3.checkCancelled(coroutineScope2, str2, priorityTaskId3);
            mutableStateFlow2 = retryingQueue3.pendingStartTasks;
            do {
                value2 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value2, SetsKt.minus((Set<? extends PriorityTaskId>) value2, priorityTaskId3)));
            mutableStateFlow3 = retryingQueue3.startedTasks;
            do {
                value3 = mutableStateFlow3.getValue();
            } while (!mutableStateFlow3.compareAndSet(value3, SetsKt.plus((Set<? extends PriorityTaskId>) value3, priorityTaskId3)));
            mutableStateFlow4 = retryingQueue3.performingTasks;
            do {
                value4 = mutableStateFlow4.getValue();
            } while (!mutableStateFlow4.compareAndSet(value4, SetsKt.plus((Set<? extends PriorityTaskId>) value4, priorityTaskId3)));
            return priorityTaskId3;
        }
        this.checkCancelled(coroutineScope, str, priorityTaskId);
        MutableStateFlow mutableStateFlow7 = this.performingTasks;
        C51453 c51453 = this.new C51453(null);
        c51441.L$0 = this;
        c51441.L$1 = coroutineScope;
        c51441.L$2 = str;
        c51441.L$3 = priorityTaskId;
        c51441.label = 2;
        if (FlowKt.first(mutableStateFlow7, c51453, c51441) == coroutine_suspended) {
            return coroutine_suspended;
        }
        retryingQueue = this;
        priorityTaskId2 = priorityTaskId;
        String str3 = str;
        coroutineScope2 = coroutineScope;
        str2 = str3;
        retryingQueue.checkCancelled(coroutineScope2, str2, priorityTaskId2);
        mutableStateFlow = retryingQueue.pendingResultTasks;
        c51464 = retryingQueue.new C51464(null);
        c51441.L$0 = retryingQueue;
        c51441.L$1 = coroutineScope2;
        c51441.L$2 = str2;
        c51441.L$3 = priorityTaskId2;
        c51441.label = 3;
        if (FlowKt.first(mutableStateFlow, c51464, c51441) == coroutine_suspended) {
            return coroutine_suspended;
        }
        priorityTaskId3 = priorityTaskId2;
        RetryingQueue retryingQueue4 = retryingQueue;
        retryingQueue4.checkCancelled(coroutineScope2, str2, priorityTaskId3);
        mutableStateFlow2 = retryingQueue4.pendingStartTasks;
        do {
            value2 = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value2, SetsKt.minus((Set<? extends PriorityTaskId>) value2, priorityTaskId3)));
        mutableStateFlow3 = retryingQueue4.startedTasks;
        do {
            value3 = mutableStateFlow3.getValue();
        } while (!mutableStateFlow3.compareAndSet(value3, SetsKt.plus((Set<? extends PriorityTaskId>) value3, priorityTaskId3)));
        mutableStateFlow4 = retryingQueue4.performingTasks;
        do {
            value4 = mutableStateFlow4.getValue();
        } while (!mutableStateFlow4.compareAndSet(value4, SetsKt.plus((Set<? extends PriorityTaskId>) value4, priorityTaskId3)));
        return priorityTaskId3;
    }

    /* JADX INFO: renamed from: com.urbanairship.automation.utils.RetryingQueue$awaitTaskId$3 */
    static final class C51453 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        C51453(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C51453 c51453 = RetryingQueue.this.new C51453(continuation);
            c51453.L$0 = obj;
            return c51453;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Set set, Continuation continuation) {
            return ((C51453) create(set, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((Set) this.L$0).size() < RetryingQueue.this.maxConcurrentOperations);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.automation.utils.RetryingQueue$awaitTaskId$4 */
    static final class C51464 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        C51464(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C51464 c51464 = RetryingQueue.this.new C51464(continuation);
            c51464.L$0 = obj;
            return c51464;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Set set, Continuation continuation) {
            return ((C51464) create(set, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((Set) this.L$0).size() < RetryingQueue.this.maxPendingResults);
        }
    }

    static /* synthetic */ void checkCancelled$default(RetryingQueue retryingQueue, CoroutineScope coroutineScope, String str, PriorityTaskId priorityTaskId, int i, Object obj) {
        if ((i & 4) != 0) {
            priorityTaskId = null;
        }
        retryingQueue.checkCancelled(coroutineScope, str, priorityTaskId);
    }

    private final void checkCancelled(CoroutineScope scope, final String name, PriorityTaskId priorityTaskId) {
        Object value;
        Object value2;
        Object value3;
        Object value4;
        if (CoroutineScopeKt.isActive(scope)) {
            return;
        }
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.utils.RetryingQueue.checkCancelled.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Operation " + name + " cancelled";
            }
        }, 1, null);
        if (priorityTaskId != null) {
            MutableStateFlow mutableStateFlow = this.startedTasks;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, SetsKt.minus((Set<? extends PriorityTaskId>) value, priorityTaskId)));
            MutableStateFlow mutableStateFlow2 = this.performingTasks;
            do {
                value2 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value2, SetsKt.minus((Set<? extends PriorityTaskId>) value2, priorityTaskId)));
            MutableStateFlow mutableStateFlow3 = this.pendingResultTasks;
            do {
                value3 = mutableStateFlow3.getValue();
            } while (!mutableStateFlow3.compareAndSet(value3, SetsKt.minus((Set<? extends PriorityTaskId>) value3, priorityTaskId)));
            MutableStateFlow mutableStateFlow4 = this.pendingStartTasks;
            do {
                value4 = mutableStateFlow4.getValue();
            } while (!mutableStateFlow4.compareAndSet(value4, SetsKt.minus((Set<? extends PriorityTaskId>) value4, priorityTaskId)));
        }
        CoroutineScopeKt.ensureActive(scope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:27:0x00f5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:32:0x011b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x011c  */
    /* JADX WARN: Code duplicated, block: B:45:0x0156  */
    /* JADX WARN: Code duplicated, block: B:50:0x017c  */
    /* JADX WARN: Code duplicated, block: B:57:0x01b6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x01b7 -> B:59:0x01bd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0271 -> B:25:0x00cc). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object doTask(kotlinx.coroutines.CoroutineScope r21, java.lang.String r22, int r23, kotlin.jvm.functions.Function1 r24, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instruction units count: 634
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.utils.RetryingQueue.doTask(kotlinx.coroutines.CoroutineScope, java.lang.String, int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private static final class PriorityTaskId {
        private final long identifier;
        private final int priority;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PriorityTaskId)) {
                return false;
            }
            PriorityTaskId priorityTaskId = (PriorityTaskId) obj;
            return this.identifier == priorityTaskId.identifier && this.priority == priorityTaskId.priority;
        }

        public int hashCode() {
            return (Long.hashCode(this.identifier) * 31) + Integer.hashCode(this.priority);
        }

        public String toString() {
            return "PriorityTaskId(identifier=" + this.identifier + ", priority=" + this.priority + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public PriorityTaskId(long j, int i) {
            this.identifier = j;
            this.priority = i;
        }

        public final long getIdentifier() {
            return this.identifier;
        }

        public final int getPriority() {
            return this.priority;
        }
    }
}
