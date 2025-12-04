package com.urbanairship.automation.engine;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.joran.action.Action;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.ApplicationMetrics;
import com.urbanairship.analytics.AirshipEventFeed;
import com.urbanairship.app.ActivityMonitor;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\r\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/urbanairship/automation/engine/AutomationEventFeed;", "", "applicationMetrics", "Lcom/urbanairship/ApplicationMetrics;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "eventFeed", "Lcom/urbanairship/analytics/AirshipEventFeed;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/urbanairship/ApplicationMetrics;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/analytics/AirshipEventFeed;Lkotlinx/coroutines/CoroutineDispatcher;)V", "appSessionState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/urbanairship/automation/engine/TriggerableState;", "feed", "Lkotlinx/coroutines/flow/Flow;", "Lcom/urbanairship/automation/engine/AutomationEvent;", "getFeed$urbanairship_automation_release", "()Lkotlinx/coroutines/flow/Flow;", "hasAttachedBefore", "", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "stream", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "subscription", "Lkotlinx/coroutines/Job;", "attach", "", "attach$urbanairship_automation_release", "detach", "detach$urbanairship_automation_release", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class AutomationEventFeed {
    private final ActivityMonitor activityMonitor;
    private final MutableStateFlow appSessionState;
    private final ApplicationMetrics applicationMetrics;
    private final AirshipEventFeed eventFeed;
    private final Flow feed;
    private boolean hasAttachedBefore;
    private final CoroutineScope scope;
    private final MutableSharedFlow stream;
    private Job subscription;

    public AutomationEventFeed(@NotNull ApplicationMetrics applicationMetrics, @NotNull ActivityMonitor activityMonitor, @NotNull AirshipEventFeed eventFeed, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(applicationMetrics, "applicationMetrics");
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        Intrinsics.checkNotNullParameter(eventFeed, "eventFeed");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.applicationMetrics = applicationMetrics;
        this.activityMonitor = activityMonitor;
        this.eventFeed = eventFeed;
        this.scope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        MutableSharedFlow mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.stream = mutableSharedFlowMutableSharedFlow$default;
        this.appSessionState = StateFlowKt.MutableStateFlow(new TriggerableState(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
        this.feed = FlowKt.onSubscription(mutableSharedFlowMutableSharedFlow$default, new AutomationEventFeed$feed$1(this, null));
    }

    public /* synthetic */ AutomationEventFeed(ApplicationMetrics applicationMetrics, ActivityMonitor activityMonitor, AirshipEventFeed airshipEventFeed, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(applicationMetrics, activityMonitor, airshipEventFeed, (i & 8) != 0 ? AirshipDispatchers.INSTANCE.getIO() : coroutineDispatcher);
    }

    @NotNull
    public final Flow<AutomationEvent> getFeed$urbanairship_automation_release() {
        return this.feed;
    }

    public final void attach$urbanairship_automation_release() {
        Job job = this.subscription;
        if (job == null || !job.isActive()) {
            this.subscription = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AutomationEventFeed$attach$1(this, null), 3, null);
        }
    }

    public final void detach$urbanairship_automation_release() {
        Job job = this.subscription;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }
}
