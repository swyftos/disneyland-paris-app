package com.urbanairship.preferencecenter;

import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.UAirship;
import com.urbanairship.preferencecenter.data.Condition;
import com.urbanairship.push.PushManager;
import com.urbanairship.push.PushManagerExtensions;
import com.urbanairship.push.PushNotificationStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/preferencecenter/ConditionStateMonitor;", "", "pushManager", "Lcom/urbanairship/push/PushManager;", "(Lcom/urbanairship/push/PushManager;)V", "currentState", "Lcom/urbanairship/preferencecenter/data/Condition$State;", "getCurrentState", "()Lcom/urbanairship/preferencecenter/data/Condition$State;", "isOptedIn", "", "()Z", "states", "Lkotlinx/coroutines/flow/Flow;", "getStates", "()Lkotlinx/coroutines/flow/Flow;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nConditionStateMonitor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConditionStateMonitor.kt\ncom/urbanairship/preferencecenter/ConditionStateMonitor\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,26:1\n49#2:27\n51#2:31\n46#3:28\n51#3:30\n105#4:29\n*S KotlinDebug\n*F\n+ 1 ConditionStateMonitor.kt\ncom/urbanairship/preferencecenter/ConditionStateMonitor\n*L\n15#1:27\n15#1:31\n15#1:28\n15#1:30\n15#1:29\n*E\n"})
/* loaded from: classes5.dex */
public final class ConditionStateMonitor {
    private final PushManager pushManager;
    private final Flow states;

    public ConditionStateMonitor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ConditionStateMonitor(@NotNull PushManager pushManager) {
        Intrinsics.checkNotNullParameter(pushManager, "pushManager");
        this.pushManager = pushManager;
        final StateFlow<PushNotificationStatus> pushNotificationStatusFlow = PushManagerExtensions.getPushNotificationStatusFlow(pushManager);
        this.states = FlowKt.distinctUntilChanged(new Flow<Condition.State>() { // from class: com.urbanairship.preferencecenter.ConditionStateMonitor$special$$inlined$map$1

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 ConditionStateMonitor.kt\ncom/urbanairship/preferencecenter/ConditionStateMonitor\n*L\n1#1,218:1\n50#2:219\n16#3:220\n*E\n"})
            /* renamed from: com.urbanairship.preferencecenter.ConditionStateMonitor$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.preferencecenter.ConditionStateMonitor$special$$inlined$map$1$2", f = "ConditionStateMonitor.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                /* renamed from: com.urbanairship.preferencecenter.ConditionStateMonitor$special$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.urbanairship.preferencecenter.ConditionStateMonitor$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.urbanairship.preferencecenter.ConditionStateMonitor$special$$inlined$map$1$2$1 r0 = (com.urbanairship.preferencecenter.ConditionStateMonitor$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.preferencecenter.ConditionStateMonitor$special$$inlined$map$1$2$1 r0 = new com.urbanairship.preferencecenter.ConditionStateMonitor$special$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4a
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                        com.urbanairship.push.PushNotificationStatus r5 = (com.urbanairship.push.PushNotificationStatus) r5
                        com.urbanairship.preferencecenter.data.Condition$State r6 = new com.urbanairship.preferencecenter.data.Condition$State
                        boolean r5 = r5.isUserOptedIn()
                        r6.<init>(r5)
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r6, r0)
                        if (r4 != r1) goto L4a
                        return r1
                    L4a:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.ConditionStateMonitor$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Condition.State> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = pushNotificationStatusFlow.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ConditionStateMonitor(PushManager pushManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            pushManager = UAirship.shared().getPushManager();
            Intrinsics.checkNotNullExpressionValue(pushManager, "getPushManager(...)");
        }
        this(pushManager);
    }

    @NotNull
    public final Flow<Condition.State> getStates() {
        return this.states;
    }

    @NotNull
    public final Condition.State getCurrentState() {
        return new Condition.State(isOptedIn());
    }

    private final boolean isOptedIn() {
        return this.pushManager.getPushNotificationStatus().isUserOptedIn();
    }
}
