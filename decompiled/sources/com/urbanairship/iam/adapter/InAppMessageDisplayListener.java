package com.urbanairship.iam.adapter;

import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.UALog;
import com.urbanairship.iam.analytics.InAppMessageAnalyticsInterface;
import com.urbanairship.iam.analytics.events.InAppDisplayEvent;
import com.urbanairship.iam.analytics.events.InAppResolutionEvent;
import com.urbanairship.iam.info.InAppMessageButtonInfo;
import com.urbanairship.util.timer.Timer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\tJ\u0006\u0010\u0015\u001a\u00020\tJ\u0006\u0010\u0016\u001a\u00020\tJ\u0006\u0010\u0017\u001a\u00020\tJ\u0006\u0010\u0018\u001a\u00020\tJ\u001c\u0010\u0019\u001a\u00020\t2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\b0\u0007H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/iam/adapter/InAppMessageDisplayListener;", "", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;", "timer", "Lcom/urbanairship/util/timer/Timer;", "onDismiss", "Lkotlin/Function1;", "Lcom/urbanairship/iam/adapter/DisplayResult;", "", "(Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;Lcom/urbanairship/util/timer/Timer;Lkotlin/jvm/functions/Function1;)V", "getAnalytics", "()Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;", "isDisplaying", "", "()Z", "onAppear", "onButtonDismissed", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Lcom/urbanairship/iam/info/InAppMessageButtonInfo;", "onMessageTapDismissed", "onPause", "onResume", "onTimedOut", "onUserDismissed", "tryDismiss", "block", "Lkotlin/time/Duration;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppMessageDisplayListener {
    private final InAppMessageAnalyticsInterface analytics;
    private Function1 onDismiss;
    private final Timer timer;

    public InAppMessageDisplayListener(@NotNull InAppMessageAnalyticsInterface analytics, @NotNull Timer timer, @Nullable Function1<? super DisplayResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(timer, "timer");
        this.analytics = analytics;
        this.timer = timer;
        this.onDismiss = function1;
    }

    @NotNull
    public final InAppMessageAnalyticsInterface getAnalytics() {
        return this.analytics;
    }

    public final void onAppear() {
        this.timer.start();
        this.analytics.recordEvent(new InAppDisplayEvent(), null);
    }

    public final boolean isDisplaying() {
        return this.onDismiss != null;
    }

    public final void onPause() {
        this.timer.stop();
    }

    public final void onResume() {
        this.timer.start();
    }

    public final void onButtonDismissed(@NotNull final InAppMessageButtonInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        tryDismiss(new Function1() { // from class: com.urbanairship.iam.adapter.InAppMessageDisplayListener.onButtonDismissed.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m2877invokeLRDsOJo(((Duration) obj).getRawValue());
            }

            /* renamed from: invoke-LRDsOJo, reason: not valid java name */
            public final DisplayResult m2877invokeLRDsOJo(long j) {
                InAppMessageDisplayListener.this.getAnalytics().recordEvent(InAppResolutionEvent.INSTANCE.m2887buttonTapSxA4cEA(info.getIdentifier(), info.getLabel().getText(), j), null);
                return info.getBehavior() == InAppMessageButtonInfo.Behavior.CANCEL ? DisplayResult.CANCEL : DisplayResult.FINISHED;
            }
        });
    }

    public final void onTimedOut() {
        tryDismiss(new Function1() { // from class: com.urbanairship.iam.adapter.InAppMessageDisplayListener.onTimedOut.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m2879invokeLRDsOJo(((Duration) obj).getRawValue());
            }

            /* renamed from: invoke-LRDsOJo, reason: not valid java name */
            public final DisplayResult m2879invokeLRDsOJo(long j) {
                InAppMessageDisplayListener.this.getAnalytics().recordEvent(InAppResolutionEvent.INSTANCE.m2889timedOutLRDsOJo(j), null);
                return DisplayResult.FINISHED;
            }
        });
    }

    public final void onUserDismissed() {
        tryDismiss(new Function1() { // from class: com.urbanairship.iam.adapter.InAppMessageDisplayListener.onUserDismissed.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m2880invokeLRDsOJo(((Duration) obj).getRawValue());
            }

            /* renamed from: invoke-LRDsOJo, reason: not valid java name */
            public final DisplayResult m2880invokeLRDsOJo(long j) {
                InAppMessageDisplayListener.this.getAnalytics().recordEvent(InAppResolutionEvent.INSTANCE.m2890userDismissedLRDsOJo(j), null);
                return DisplayResult.FINISHED;
            }
        });
    }

    public final void onMessageTapDismissed() {
        tryDismiss(new Function1() { // from class: com.urbanairship.iam.adapter.InAppMessageDisplayListener.onMessageTapDismissed.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m2878invokeLRDsOJo(((Duration) obj).getRawValue());
            }

            /* renamed from: invoke-LRDsOJo, reason: not valid java name */
            public final DisplayResult m2878invokeLRDsOJo(long j) {
                InAppMessageDisplayListener.this.getAnalytics().recordEvent(InAppResolutionEvent.INSTANCE.m2888messageTapLRDsOJo(j), null);
                return DisplayResult.FINISHED;
            }
        });
    }

    private final void tryDismiss(Function1 block) {
        Function1 function1 = this.onDismiss;
        if (function1 == null) {
            UALog.e$default(null, new Function0() { // from class: com.urbanairship.iam.adapter.InAppMessageDisplayListener.tryDismiss.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Dismissed already called!";
                }
            }, 1, null);
            return;
        }
        this.timer.stop();
        function1.invoke((DisplayResult) block.invoke(Duration.m3465boximpl(this.timer.mo2960getTimeUwyO8pc())));
        this.onDismiss = null;
    }
}
