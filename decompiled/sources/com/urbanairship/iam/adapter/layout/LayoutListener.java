package com.urbanairship.iam.adapter.layout;

import androidx.annotation.VisibleForTesting;
import com.dlp.BluetoothManager;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.UALog;
import com.urbanairship.android.layout.ThomasListenerInterface;
import com.urbanairship.android.layout.event.ReportingEvent;
import com.urbanairship.iam.adapter.DisplayResult;
import com.urbanairship.iam.analytics.InAppMessageAnalyticsInterface;
import com.urbanairship.iam.analytics.events.InAppButtonTapEvent;
import com.urbanairship.iam.analytics.events.InAppDisplayEvent;
import com.urbanairship.iam.analytics.events.InAppFormDisplayEvent;
import com.urbanairship.iam.analytics.events.InAppFormResultEvent;
import com.urbanairship.iam.analytics.events.InAppGestureEvent;
import com.urbanairship.iam.analytics.events.InAppPageActionEvent;
import com.urbanairship.iam.analytics.events.InAppPageSwipeEvent;
import com.urbanairship.iam.analytics.events.InAppPageViewEvent;
import com.urbanairship.iam.analytics.events.InAppPagerCompletedEvent;
import com.urbanairship.iam.analytics.events.InAppPagerSummaryEvent;
import com.urbanairship.iam.analytics.events.InAppResolutionEvent;
import com.urbanairship.json.JsonSerializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/iam/adapter/layout/LayoutListener;", "Lcom/urbanairship/android/layout/ThomasListenerInterface;", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;", "onDismiss", "Lkotlin/Function1;", "Lcom/urbanairship/iam/adapter/DisplayResult;", "", "(Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;Lkotlin/jvm/functions/Function1;)V", "getAnalytics", "()Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;", "cancel", "", "onReportingEvent", "event", "Lcom/urbanairship/android/layout/event/ReportingEvent;", "onStateChanged", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/json/JsonSerializable;", "onVisibilityChanged", "isVisible", "isForegrounded", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@VisibleForTesting
/* loaded from: classes5.dex */
public final class LayoutListener implements ThomasListenerInterface {
    private final InAppMessageAnalyticsInterface analytics;
    private Function1 onDismiss;

    @Override // com.urbanairship.android.layout.ThomasListenerInterface
    public void onStateChanged(@NotNull JsonSerializable state) {
        Intrinsics.checkNotNullParameter(state, "state");
    }

    public LayoutListener(@NotNull InAppMessageAnalyticsInterface analytics, @Nullable Function1<? super DisplayResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.analytics = analytics;
        this.onDismiss = function1;
    }

    @NotNull
    public final InAppMessageAnalyticsInterface getAnalytics() {
        return this.analytics;
    }

    @Override // com.urbanairship.android.layout.ThomasListenerInterface
    public void onReportingEvent(@NotNull ReportingEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof ReportingEvent.ButtonTap) {
            ReportingEvent.ButtonTap buttonTap = (ReportingEvent.ButtonTap) event;
            this.analytics.recordEvent(new InAppButtonTapEvent(buttonTap.getData()), buttonTap.getContext());
            return;
        }
        if (event instanceof ReportingEvent.Dismiss) {
            ReportingEvent.Dismiss dismiss = (ReportingEvent.Dismiss) event;
            ReportingEvent.DismissData data = dismiss.getData();
            if (data instanceof ReportingEvent.DismissData.ButtonTapped) {
                ReportingEvent.DismissData.ButtonTapped buttonTapped = (ReportingEvent.DismissData.ButtonTapped) data;
                this.analytics.recordEvent(InAppResolutionEvent.INSTANCE.m2887buttonTapSxA4cEA(buttonTapped.getIdentifier(), buttonTapped.getDescription(), dismiss.m2725getDisplayTimeUwyO8pc()), dismiss.getContext());
                return;
            } else if (Intrinsics.areEqual(data, ReportingEvent.DismissData.TimedOut.INSTANCE)) {
                this.analytics.recordEvent(InAppResolutionEvent.INSTANCE.m2889timedOutLRDsOJo(dismiss.m2725getDisplayTimeUwyO8pc()), dismiss.getContext());
                return;
            } else {
                if (Intrinsics.areEqual(data, ReportingEvent.DismissData.UserDismissed.INSTANCE)) {
                    this.analytics.recordEvent(InAppResolutionEvent.INSTANCE.m2890userDismissedLRDsOJo(dismiss.m2725getDisplayTimeUwyO8pc()), dismiss.getContext());
                    return;
                }
                return;
            }
        }
        if (event instanceof ReportingEvent.FormDisplay) {
            ReportingEvent.FormDisplay formDisplay = (ReportingEvent.FormDisplay) event;
            this.analytics.recordEvent(new InAppFormDisplayEvent(formDisplay.getData()), formDisplay.getContext());
            return;
        }
        if (event instanceof ReportingEvent.FormResult) {
            ReportingEvent.FormResult formResult = (ReportingEvent.FormResult) event;
            this.analytics.recordEvent(new InAppFormResultEvent(formResult.getData()), formResult.getContext());
            return;
        }
        if (event instanceof ReportingEvent.Gesture) {
            ReportingEvent.Gesture gesture = (ReportingEvent.Gesture) event;
            this.analytics.recordEvent(new InAppGestureEvent(gesture.getData()), gesture.getContext());
            return;
        }
        if (event instanceof ReportingEvent.PageAction) {
            ReportingEvent.PageAction pageAction = (ReportingEvent.PageAction) event;
            this.analytics.recordEvent(new InAppPageActionEvent(pageAction.getData()), pageAction.getContext());
            return;
        }
        if (event instanceof ReportingEvent.PagerSummary) {
            ReportingEvent.PagerSummary pagerSummary = (ReportingEvent.PagerSummary) event;
            this.analytics.recordEvent(new InAppPagerSummaryEvent(pagerSummary.getData()), pagerSummary.getContext());
            return;
        }
        if (event instanceof ReportingEvent.PageSwipe) {
            ReportingEvent.PageSwipe pageSwipe = (ReportingEvent.PageSwipe) event;
            this.analytics.recordEvent(new InAppPageSwipeEvent(pageSwipe.getData()), pageSwipe.getContext());
        } else if (event instanceof ReportingEvent.PageView) {
            ReportingEvent.PageView pageView = (ReportingEvent.PageView) event;
            this.analytics.recordEvent(new InAppPageViewEvent(pageView.getData()), pageView.getContext());
        } else if (event instanceof ReportingEvent.PagerComplete) {
            ReportingEvent.PagerComplete pagerComplete = (ReportingEvent.PagerComplete) event;
            this.analytics.recordEvent(new InAppPagerCompletedEvent(pagerComplete.getData()), pagerComplete.getContext());
        }
    }

    @Override // com.urbanairship.android.layout.ThomasListenerInterface
    public void onDismiss(boolean cancel) {
        Function1 function1 = this.onDismiss;
        if (function1 == null) {
            UALog.e$default(null, new Function0() { // from class: com.urbanairship.iam.adapter.layout.LayoutListener.onDismiss.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Dismissed already called!";
                }
            }, 1, null);
        } else {
            function1.invoke(cancel ? DisplayResult.CANCEL : DisplayResult.FINISHED);
        }
    }

    @Override // com.urbanairship.android.layout.ThomasListenerInterface
    public void onVisibilityChanged(boolean isVisible, boolean isForegrounded) {
        if (isVisible && isForegrounded) {
            this.analytics.recordEvent(new InAppDisplayEvent(), null);
        }
    }
}
