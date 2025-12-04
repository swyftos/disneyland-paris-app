package com.urbanairship.iam;

import android.app.Activity;
import com.urbanairship.Predicate;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.SimpleActivityListener;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0000¨\u0006\u0007"}, d2 = {"resumedActivitiesUpdates", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/urbanairship/app/ActivityMonitor;", "predicate", "Lcom/urbanairship/Predicate;", "Landroid/app/Activity;", "urbanairship-automation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppActivityMonitorKt {

    /* renamed from: com.urbanairship.iam.InAppActivityMonitorKt$resumedActivitiesUpdates$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Predicate $predicate;
        final /* synthetic */ ActivityMonitor $this_resumedActivitiesUpdates;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ActivityMonitor activityMonitor, Predicate predicate, Continuation continuation) {
            super(2, continuation);
            this.$this_resumedActivitiesUpdates = activityMonitor;
            this.$predicate = predicate;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_resumedActivitiesUpdates, this.$predicate, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope producerScope, Continuation continuation) {
            return ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                final ActivityMonitor activityMonitor = this.$this_resumedActivitiesUpdates;
                final Predicate predicate = this.$predicate;
                final SimpleActivityListener simpleActivityListener = new SimpleActivityListener() { // from class: com.urbanairship.iam.InAppActivityMonitorKt$resumedActivitiesUpdates$1$listener$1
                    @Override // com.urbanairship.app.SimpleActivityListener, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(@NotNull Activity activity) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                    }

                    @Override // com.urbanairship.app.SimpleActivityListener, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(@NotNull Activity activity) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        producerScope.mo3620trySendJP2dKIU(Boolean.valueOf(!activityMonitor.getResumedActivities(predicate).isEmpty()));
                    }

                    @Override // com.urbanairship.app.SimpleActivityListener, android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(@NotNull Activity activity) {
                        Intrinsics.checkNotNullParameter(activity, "activity");
                        producerScope.mo3620trySendJP2dKIU(Boolean.valueOf(!activityMonitor.getResumedActivities(predicate).isEmpty()));
                    }
                };
                producerScope.mo3620trySendJP2dKIU(Boxing.boxBoolean(!this.$this_resumedActivitiesUpdates.getResumedActivities(this.$predicate).isEmpty()));
                this.$this_resumedActivitiesUpdates.addActivityListener(simpleActivityListener);
                final ActivityMonitor activityMonitor2 = this.$this_resumedActivitiesUpdates;
                Function0 function0 = new Function0() { // from class: com.urbanairship.iam.InAppActivityMonitorKt.resumedActivitiesUpdates.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2872invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2872invoke() {
                        activityMonitor2.removeActivityListener(simpleActivityListener);
                    }
                };
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
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

    public static /* synthetic */ Flow resumedActivitiesUpdates$default(ActivityMonitor activityMonitor, Predicate predicate, int i, Object obj) {
        if ((i & 1) != 0) {
            predicate = null;
        }
        return resumedActivitiesUpdates(activityMonitor, predicate);
    }

    @NotNull
    public static final Flow<Boolean> resumedActivitiesUpdates(@NotNull ActivityMonitor activityMonitor, @Nullable Predicate<Activity> predicate) {
        Intrinsics.checkNotNullParameter(activityMonitor, "<this>");
        return FlowKt.callbackFlow(new AnonymousClass1(activityMonitor, predicate, null));
    }
}
