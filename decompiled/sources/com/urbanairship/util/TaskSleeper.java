package com.urbanairship.util;

import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.uimanager.ViewProps;
import com.urbanairship.annotation.OpenForTesting;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@OpenForTesting
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0017\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0094@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0012ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/util/TaskSleeper;", "", "clock", "Lcom/urbanairship/util/Clock;", "(Lcom/urbanairship/util/Clock;)V", "onSleep", "", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "onSleep-VtjQ1oo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remainingMillis", "", ViewProps.START, "remainingMillis-HG0u8IE", "(JJ)J", "sleep", "sleep-VtjQ1oo", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class TaskSleeper {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long MAX_DELAY_INTERVAL;

    /* renamed from: default, reason: not valid java name */
    private static final TaskSleeper f6default;
    private final Clock clock;

    @Nullable
    /* renamed from: onSleep-VtjQ1oo, reason: not valid java name */
    protected Object m2957onSleepVtjQ1oo(long j, @NotNull Continuation<? super Unit> continuation) {
        return m2954onSleepVtjQ1oo$suspendImpl(this, j, continuation);
    }

    @Nullable
    /* renamed from: sleep-VtjQ1oo, reason: not valid java name */
    public Object m2958sleepVtjQ1oo(long j, @NotNull Continuation<? super Unit> continuation) {
        return m2956sleepVtjQ1oo$suspendImpl(this, j, continuation);
    }

    public TaskSleeper(@NotNull Clock clock) {
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.clock = clock;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0076 -> B:24:0x0079). Please report as a decompilation issue!!! */
    /* renamed from: sleep-VtjQ1oo$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object m2956sleepVtjQ1oo$suspendImpl(com.urbanairship.util.TaskSleeper r12, long r13, kotlin.coroutines.Continuation r15) {
        /*
            boolean r0 = r15 instanceof com.urbanairship.util.TaskSleeper$sleep$1
            if (r0 == 0) goto L13
            r0 = r15
            com.urbanairship.util.TaskSleeper$sleep$1 r0 = (com.urbanairship.util.TaskSleeper$sleep$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.util.TaskSleeper$sleep$1 r0 = new com.urbanairship.util.TaskSleeper$sleep$1
            r0.<init>(r12, r15)
        L18:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            long r12 = r0.J$1
            long r4 = r0.J$0
            java.lang.Object r14 = r0.L$0
            com.urbanairship.util.TaskSleeper r14 = (com.urbanairship.util.TaskSleeper) r14
            kotlin.ResultKt.throwOnFailure(r15)
            r10 = r12
            r12 = r14
            r13 = r4
            r4 = r10
            goto L79
        L35:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3d:
            kotlin.ResultKt.throwOnFailure(r15)
            boolean r15 = kotlin.time.Duration.m3495isFiniteimpl(r13)
            if (r15 == 0) goto L7e
            boolean r15 = kotlin.time.Duration.m3500isPositiveimpl(r13)
            if (r15 == 0) goto L7e
            com.urbanairship.util.Clock r15 = r12.clock
            long r4 = r15.currentTimeMillis()
            long r6 = r12.m2955remainingMillisHG0u8IE(r4, r13)
        L56:
            r8 = 0
            int r15 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r15 <= 0) goto L7e
            long r8 = com.urbanairship.util.TaskSleeper.MAX_DELAY_INTERVAL
            long r6 = kotlin.ranges.RangesKt.coerceAtMost(r6, r8)
            kotlin.time.Duration$Companion r15 = kotlin.time.Duration.INSTANCE
            kotlin.time.DurationUnit r15 = kotlin.time.DurationUnit.MILLISECONDS
            long r6 = kotlin.time.DurationKt.toDuration(r6, r15)
            r0.L$0 = r12
            r0.J$0 = r13
            r0.J$1 = r4
            r0.label = r3
            java.lang.Object r15 = r12.m2957onSleepVtjQ1oo(r6, r0)
            if (r15 != r1) goto L79
            return r1
        L79:
            long r6 = r12.m2955remainingMillisHG0u8IE(r4, r13)
            goto L56
        L7e:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.util.TaskSleeper.m2956sleepVtjQ1oo$suspendImpl(com.urbanairship.util.TaskSleeper, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: onSleep-VtjQ1oo$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m2954onSleepVtjQ1oo$suspendImpl(TaskSleeper taskSleeper, long j, Continuation continuation) {
        Object objM3608delayVtjQ1oo = DelayKt.m3608delayVtjQ1oo(j, continuation);
        return objM3608delayVtjQ1oo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM3608delayVtjQ1oo : Unit.INSTANCE;
    }

    /* renamed from: remainingMillis-HG0u8IE, reason: not valid java name */
    private long m2955remainingMillisHG0u8IE(long start, long duration) {
        return Duration.m3485getInWholeMillisecondsimpl(duration) - (this.clock.currentTimeMillis() - start);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/urbanairship/util/TaskSleeper$Companion;", "", "()V", "MAX_DELAY_INTERVAL", "", "default", "Lcom/urbanairship/util/TaskSleeper;", "getDefault", "()Lcom/urbanairship/util/TaskSleeper;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final TaskSleeper getDefault() {
            return TaskSleeper.f6default;
        }
    }

    static {
        Clock DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        f6default = new TaskSleeper(DEFAULT_CLOCK);
        Duration.Companion companion = Duration.INSTANCE;
        MAX_DELAY_INTERVAL = Duration.m3485getInWholeMillisecondsimpl(DurationKt.toDuration(30, DurationUnit.SECONDS));
    }
}
