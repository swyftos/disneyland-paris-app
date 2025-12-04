package com.urbanairship.util.timer;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.react.uimanager.ViewProps;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.ApplicationListener;
import com.urbanairship.util.Clock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0018\u001a\u00020\u000eH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0017J\b\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\r\u0010\u001c\u001a\u00020\fH\u0001¢\u0006\u0002\b\u001dR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u00020\u000eX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u000e8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Lcom/urbanairship/util/timer/ActiveTimer;", "Lcom/urbanairship/util/timer/Timer;", "appStateTracker", "Lcom/urbanairship/app/ActivityMonitor;", "clock", "Lcom/urbanairship/util/Clock;", "(Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/util/Clock;)V", "_isStarted", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "cancelListener", "Lkotlin/Function0;", "", "elapsedTime", "Lkotlin/time/Duration;", "J", "isActive", "isStarted", "()Z", "startDate", "", "time", "getTime-UwyO8pc", "()J", "currentSessionTime", "currentSessionTime-UwyO8pc", ViewProps.START, "stop", "stopListening", "stopListening$urbanairship_core_release", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nActiveTimer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActiveTimer.kt\ncom/urbanairship/util/timer/ActiveTimer\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,84:1\n230#2,5:85\n230#2,5:90\n230#2,5:95\n230#2,5:100\n*S KotlinDebug\n*F\n+ 1 ActiveTimer.kt\ncom/urbanairship/util/timer/ActiveTimer\n*L\n60#1:85,5\n63#1:90,5\n70#1:95,5\n71#1:100,5\n*E\n"})
/* loaded from: classes5.dex */
public final class ActiveTimer implements Timer {
    private final MutableStateFlow _isStarted;
    private final ActivityMonitor appStateTracker;
    private Function0 cancelListener;
    private final Clock clock;
    private long elapsedTime;
    private final MutableStateFlow isActive;
    private final MutableStateFlow startDate;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [com.urbanairship.app.ApplicationListener, com.urbanairship.util.timer.ActiveTimer$listener$1] */
    public ActiveTimer(@NotNull ActivityMonitor appStateTracker, @NotNull Clock clock) {
        Intrinsics.checkNotNullParameter(appStateTracker, "appStateTracker");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.appStateTracker = appStateTracker;
        this.clock = clock;
        this._isStarted = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.isActive = StateFlowKt.MutableStateFlow(Boolean.valueOf(appStateTracker.getIsAppForegrounded()));
        this.startDate = StateFlowKt.MutableStateFlow(null);
        Duration.Companion companion = Duration.INSTANCE;
        this.elapsedTime = DurationKt.toDuration(0, DurationUnit.SECONDS);
        final ?? r4 = new ApplicationListener() { // from class: com.urbanairship.util.timer.ActiveTimer$listener$1
            @Override // com.urbanairship.app.ApplicationListener
            public void onForeground(long milliseconds) {
                Object value;
                Object value2;
                MutableStateFlow mutableStateFlow = this.this$0.isActive;
                do {
                    value = mutableStateFlow.getValue();
                    ((Boolean) value).booleanValue();
                } while (!mutableStateFlow.compareAndSet(value, Boolean.TRUE));
                if (((Boolean) this.this$0._isStarted.getValue()).booleanValue() && this.this$0.startDate.getValue() == null) {
                    MutableStateFlow mutableStateFlow2 = this.this$0.startDate;
                    ActiveTimer activeTimer = this.this$0;
                    do {
                        value2 = mutableStateFlow2.getValue();
                    } while (!mutableStateFlow2.compareAndSet(value2, Long.valueOf(activeTimer.clock.currentTimeMillis())));
                }
            }

            @Override // com.urbanairship.app.ApplicationListener
            public void onBackground(long milliseconds) {
                Object value;
                MutableStateFlow mutableStateFlow = this.this$0.isActive;
                do {
                    value = mutableStateFlow.getValue();
                    ((Boolean) value).booleanValue();
                } while (!mutableStateFlow.compareAndSet(value, Boolean.FALSE));
                this.this$0.stop();
            }
        };
        appStateTracker.addApplicationListener(r4);
        this.cancelListener = new Function0() { // from class: com.urbanairship.util.timer.ActiveTimer.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m2961invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2961invoke() {
                ActiveTimer.this.appStateTracker.removeApplicationListener(r4);
            }
        };
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ActiveTimer(ActivityMonitor activityMonitor, Clock DEFAULT_CLOCK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(activityMonitor, DEFAULT_CLOCK);
    }

    @Override // com.urbanairship.util.timer.Timer
    /* renamed from: getTime-UwyO8pc, reason: not valid java name */
    public long mo2960getTimeUwyO8pc() {
        return Duration.m3502plusLRDsOJo(this.elapsedTime, m2959currentSessionTimeUwyO8pc());
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
        if (((Boolean) this.isActive.getValue()).booleanValue()) {
            MutableStateFlow mutableStateFlow = this.startDate;
            do {
                value2 = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value2, Long.valueOf(this.clock.currentTimeMillis())));
        }
        MutableStateFlow mutableStateFlow2 = this._isStarted;
        do {
            value = mutableStateFlow2.getValue();
            ((Boolean) value).booleanValue();
        } while (!mutableStateFlow2.compareAndSet(value, Boolean.TRUE));
    }

    @Override // com.urbanairship.util.timer.Timer
    public void stop() {
        Object value;
        Object value2;
        if (((Boolean) this._isStarted.getValue()).booleanValue()) {
            this.elapsedTime = Duration.m3502plusLRDsOJo(this.elapsedTime, m2959currentSessionTimeUwyO8pc());
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

    @VisibleForTesting
    public final void stopListening$urbanairship_core_release() {
        Function0 function0 = this.cancelListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* renamed from: currentSessionTime-UwyO8pc, reason: not valid java name */
    private final long m2959currentSessionTimeUwyO8pc() {
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
