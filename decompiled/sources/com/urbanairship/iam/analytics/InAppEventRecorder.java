package com.urbanairship.iam.analytics;

import ch.qos.logback.core.joran.action.Action;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.UALog;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.meteredusage.AirshipMeteredUsage;
import com.urbanairship.meteredusage.MeteredUsageEventEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppEventRecorder;", "Lcom/urbanairship/iam/analytics/InAppEventRecorderInterface;", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/urbanairship/analytics/Analytics;", "meteredUsage", "Lcom/urbanairship/meteredusage/AirshipMeteredUsage;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/urbanairship/analytics/Analytics;Lcom/urbanairship/meteredusage/AirshipMeteredUsage;Lkotlinx/coroutines/CoroutineDispatcher;)V", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "recordEvent", "", "event", "Lcom/urbanairship/iam/analytics/InAppEventData;", "recordImpressionEvent", "Lcom/urbanairship/meteredusage/MeteredUsageEventEntity;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppEventRecorder implements InAppEventRecorderInterface {
    private final Analytics analytics;
    private final AirshipMeteredUsage meteredUsage;
    private final CoroutineScope scope;

    public InAppEventRecorder(@NotNull Analytics analytics, @NotNull AirshipMeteredUsage meteredUsage, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(meteredUsage, "meteredUsage");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.analytics = analytics;
        this.meteredUsage = meteredUsage;
        this.scope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    public /* synthetic */ InAppEventRecorder(Analytics analytics, AirshipMeteredUsage airshipMeteredUsage, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(analytics, airshipMeteredUsage, (i & 4) != 0 ? AirshipDispatchers.INSTANCE.newSerialDispatcher() : coroutineDispatcher);
    }

    @Override // com.urbanairship.iam.analytics.InAppEventRecorderInterface
    public void recordEvent(@NotNull final InAppEventData event) {
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            this.analytics.addEvent(new AnalyticsEvent(event));
        } catch (Exception e) {
            UALog.e(e, (Function0<String>) new Function0() { // from class: com.urbanairship.iam.analytics.InAppEventRecorder.recordEvent.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to record event " + event;
                }
            });
        }
    }

    /* renamed from: com.urbanairship.iam.analytics.InAppEventRecorder$recordImpressionEvent$1, reason: invalid class name and case insensitive filesystem */
    static final class C11421 extends SuspendLambda implements Function2 {
        final /* synthetic */ MeteredUsageEventEntity $event;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11421(MeteredUsageEventEntity meteredUsageEventEntity, Continuation continuation) {
            super(2, continuation);
            this.$event = meteredUsageEventEntity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return InAppEventRecorder.this.new C11421(this.$event, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AirshipMeteredUsage airshipMeteredUsage = InAppEventRecorder.this.meteredUsage;
                MeteredUsageEventEntity meteredUsageEventEntity = this.$event;
                this.label = 1;
                if (airshipMeteredUsage.addEvent(meteredUsageEventEntity, this) == coroutine_suspended) {
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

    @Override // com.urbanairship.iam.analytics.InAppEventRecorderInterface
    public void recordImpressionEvent(@NotNull MeteredUsageEventEntity event) {
        Intrinsics.checkNotNullParameter(event, "event");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11421(event, null), 3, null);
    }
}
