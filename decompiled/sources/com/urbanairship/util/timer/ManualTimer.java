package com.urbanairship.util.timer;

import androidx.annotation.RestrictTo;
import com.facebook.react.uimanager.ViewProps;
import com.urbanairship.util.Clock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0012\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\tX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\t8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/util/timer/ManualTimer;", "Lcom/urbanairship/util/timer/Timer;", "clock", "Lcom/urbanairship/util/Clock;", "(Lcom/urbanairship/util/Clock;)V", "_isStarted", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "elapsed", "Lkotlin/time/Duration;", "J", "isStarted", "()Z", "startDate", "", "time", "getTime-UwyO8pc", "()J", "currentSessionTime", "currentSessionTime-UwyO8pc", ViewProps.START, "", "stop", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nManualTimer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ManualTimer.kt\ncom/urbanairship/util/timer/ManualTimer\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,50:1\n230#2,5:51\n230#2,5:56\n230#2,5:61\n230#2,5:66\n*S KotlinDebug\n*F\n+ 1 ManualTimer.kt\ncom/urbanairship/util/timer/ManualTimer\n*L\n33#1:51,5\n34#1:56,5\n41#1:61,5\n42#1:66,5\n*E\n"})
/* loaded from: classes5.dex */
public final class ManualTimer implements Timer {
    private final MutableStateFlow _isStarted;
    private final Clock clock;
    private long elapsed;
    private final MutableStateFlow startDate;

    public ManualTimer() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ManualTimer(@NotNull Clock clock) {
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.clock = clock;
        this._isStarted = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.startDate = StateFlowKt.MutableStateFlow(null);
        Duration.Companion companion = Duration.INSTANCE;
        this.elapsed = DurationKt.toDuration(0, DurationUnit.SECONDS);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ManualTimer(Clock DEFAULT_CLOCK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(DEFAULT_CLOCK);
    }

    @Override // com.urbanairship.util.timer.Timer
    /* renamed from: getTime-UwyO8pc */
    public long mo2960getTimeUwyO8pc() {
        return Duration.m3502plusLRDsOJo(this.elapsed, m2962currentSessionTimeUwyO8pc());
    }

    public final boolean isStarted() {
        return ((Boolean) this._isStarted.getValue()).booleanValue();
    }

    @Override // com.urbanairship.util.timer.Timer
    public void start() {
        Object value;
        Object value2;
        if (((Boolean) this._isStarted.getValue()).booleanValue()) {
            return;
        }
        MutableStateFlow mutableStateFlow = this.startDate;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, Long.valueOf(this.clock.currentTimeMillis())));
        MutableStateFlow mutableStateFlow2 = this._isStarted;
        do {
            value2 = mutableStateFlow2.getValue();
            ((Boolean) value2).booleanValue();
        } while (!mutableStateFlow2.compareAndSet(value2, Boolean.TRUE));
    }

    @Override // com.urbanairship.util.timer.Timer
    public void stop() {
        Object value;
        Object value2;
        if (((Boolean) this._isStarted.getValue()).booleanValue()) {
            this.elapsed = Duration.m3502plusLRDsOJo(this.elapsed, m2962currentSessionTimeUwyO8pc());
            MutableStateFlow mutableStateFlow = this.startDate;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, null));
            MutableStateFlow mutableStateFlow2 = this._isStarted;
            do {
                value2 = mutableStateFlow2.getValue();
                ((Boolean) value2).booleanValue();
            } while (!mutableStateFlow2.compareAndSet(value2, Boolean.FALSE));
        }
    }

    /* renamed from: currentSessionTime-UwyO8pc, reason: not valid java name */
    private final long m2962currentSessionTimeUwyO8pc() {
        Long l = (Long) this.startDate.getValue();
        if (l == null) {
            Duration.Companion companion = Duration.INSTANCE;
            return DurationKt.toDuration(0, DurationUnit.SECONDS);
        }
        long jLongValue = l.longValue();
        Duration.Companion companion2 = Duration.INSTANCE;
        return DurationKt.toDuration(this.clock.currentTimeMillis() - jLongValue, DurationUnit.MILLISECONDS);
    }
}
