package com.urbanairship.automation.engine;

import com.urbanairship.automation.EventAutomationTriggerType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes5.dex */
final class AutomationEventFeed$attach$1 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ AutomationEventFeed this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutomationEventFeed$attach$1(AutomationEventFeed automationEventFeed, Continuation continuation) {
        super(2, continuation);
        this.this$0 = automationEventFeed;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AutomationEventFeed$attach$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AutomationEventFeed$attach$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00c3 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            r0 = 1
            r1 = 2
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r11.label
            if (r3 == 0) goto L1f
            if (r3 == r0) goto L1b
            if (r3 != r1) goto L13
            kotlin.ResultKt.throwOnFailure(r12)
            goto Lc4
        L13:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L1b:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L4b
        L1f:
            kotlin.ResultKt.throwOnFailure(r12)
            com.urbanairship.automation.engine.AutomationEventFeed r12 = r11.this$0
            boolean r12 = com.urbanairship.automation.engine.AutomationEventFeed.access$getHasAttachedBefore$p(r12)
            if (r12 != 0) goto L7d
            com.urbanairship.automation.engine.AutomationEventFeed r12 = r11.this$0
            com.urbanairship.automation.engine.AutomationEventFeed.access$setHasAttachedBefore$p(r12, r0)
            com.urbanairship.automation.engine.AutomationEventFeed r12 = r11.this$0
            kotlinx.coroutines.flow.MutableSharedFlow r12 = com.urbanairship.automation.engine.AutomationEventFeed.access$getStream$p(r12)
            com.urbanairship.automation.engine.AutomationEvent$Event r10 = new com.urbanairship.automation.engine.AutomationEvent$Event
            com.urbanairship.automation.EventAutomationTriggerType r4 = com.urbanairship.automation.EventAutomationTriggerType.APP_INIT
            r8 = 6
            r9 = 0
            r5 = 0
            r6 = 0
            r3 = r10
            r3.<init>(r4, r5, r6, r8, r9)
            r11.label = r0
            java.lang.Object r12 = r12.emit(r10, r11)
            if (r12 != r2) goto L4b
            return r2
        L4b:
            com.urbanairship.automation.engine.AutomationEventFeed r12 = r11.this$0
            com.urbanairship.ApplicationMetrics r12 = com.urbanairship.automation.engine.AutomationEventFeed.access$getApplicationMetrics$p(r12)
            boolean r12 = r12.getAppVersionUpdated()
            if (r12 == 0) goto L7d
            com.urbanairship.automation.engine.AutomationEventFeed r12 = r11.this$0
            kotlinx.coroutines.flow.MutableStateFlow r12 = com.urbanairship.automation.engine.AutomationEventFeed.access$getAppSessionState$p(r12)
            com.urbanairship.automation.engine.AutomationEventFeed r3 = r11.this$0
        L5f:
            java.lang.Object r4 = r12.getValue()
            r5 = r4
            com.urbanairship.automation.engine.TriggerableState r5 = (com.urbanairship.automation.engine.TriggerableState) r5
            com.urbanairship.ApplicationMetrics r6 = com.urbanairship.automation.engine.AutomationEventFeed.access$getApplicationMetrics$p(r3)
            long r6 = r6.getCurrentAppVersion()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r7 = 0
            com.urbanairship.automation.engine.TriggerableState r5 = com.urbanairship.automation.engine.TriggerableState.copy$default(r5, r7, r6, r0, r7)
            boolean r4 = r12.compareAndSet(r4, r5)
            if (r4 == 0) goto L5f
        L7d:
            com.urbanairship.automation.engine.AutomationEventFeed r12 = r11.this$0
            kotlinx.coroutines.flow.MutableStateFlow r12 = com.urbanairship.automation.engine.AutomationEventFeed.access$getAppSessionState$p(r12)
            com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$1 r3 = new com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$1
            r3.<init>()
            com.urbanairship.automation.engine.AutomationEventFeed r12 = r11.this$0
            com.urbanairship.app.ActivityMonitor r12 = com.urbanairship.automation.engine.AutomationEventFeed.access$getActivityMonitor$p(r12)
            kotlinx.coroutines.flow.StateFlow r12 = r12.getForegroundState()
            com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$2 r4 = new com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$2
            r4.<init>()
            com.urbanairship.automation.engine.AutomationEventFeed r12 = r11.this$0
            com.urbanairship.analytics.AirshipEventFeed r12 = com.urbanairship.automation.engine.AutomationEventFeed.access$getEventFeed$p(r12)
            kotlinx.coroutines.flow.SharedFlow r12 = r12.getEvents()
            com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$3 r5 = new com.urbanairship.automation.engine.AutomationEventFeed$attach$1$invokeSuspend$$inlined$map$3
            r5.<init>()
            r12 = 3
            kotlinx.coroutines.flow.Flow[] r12 = new kotlinx.coroutines.flow.Flow[r12]
            r6 = 0
            r12[r6] = r3
            r12[r0] = r4
            r12[r1] = r5
            kotlinx.coroutines.flow.Flow r12 = kotlinx.coroutines.flow.FlowKt.merge(r12)
            com.urbanairship.automation.engine.AutomationEventFeed$attach$1$5 r0 = new com.urbanairship.automation.engine.AutomationEventFeed$attach$1$5
            com.urbanairship.automation.engine.AutomationEventFeed r3 = r11.this$0
            r0.<init>(r3)
            r11.label = r1
            java.lang.Object r11 = r12.collect(r0, r11)
            if (r11 != r2) goto Lc4
            return r2
        Lc4:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationEventFeed$attach$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$5, reason: invalid class name */
    static final class AnonymousClass5 implements FlowCollector {
        final /* synthetic */ AutomationEventFeed this$0;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* renamed from: com.urbanairship.automation.engine.AutomationEventFeed$attach$1$5$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[EventAutomationTriggerType.values().length];
                try {
                    iArr[EventAutomationTriggerType.FOREGROUND.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EventAutomationTriggerType.BACKGROUND.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        AnonymousClass5(AutomationEventFeed automationEventFeed) {
            this.this$0 = automationEventFeed;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0065 -> B:22:0x0068). Please report as a decompilation issue!!! */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(java.util.List r9, kotlin.coroutines.Continuation r10) {
            /*
                r8 = this;
                boolean r0 = r10 instanceof com.urbanairship.automation.engine.AutomationEventFeed$attach$1$5$emit$1
                if (r0 == 0) goto L13
                r0 = r10
                com.urbanairship.automation.engine.AutomationEventFeed$attach$1$5$emit$1 r0 = (com.urbanairship.automation.engine.AutomationEventFeed$attach$1$5$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.urbanairship.automation.engine.AutomationEventFeed$attach$1$5$emit$1 r0 = new com.urbanairship.automation.engine.AutomationEventFeed$attach$1$5$emit$1
                r0.<init>(r8, r10)
            L18:
                java.lang.Object r10 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L3d
                if (r2 != r3) goto L35
                java.lang.Object r8 = r0.L$2
                com.urbanairship.automation.engine.AutomationEvent r8 = (com.urbanairship.automation.engine.AutomationEvent) r8
                java.lang.Object r9 = r0.L$1
                java.util.Iterator r9 = (java.util.Iterator) r9
                java.lang.Object r2 = r0.L$0
                com.urbanairship.automation.engine.AutomationEventFeed r2 = (com.urbanairship.automation.engine.AutomationEventFeed) r2
                kotlin.ResultKt.throwOnFailure(r10)
                goto L68
            L35:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L3d:
                kotlin.ResultKt.throwOnFailure(r10)
                if (r9 == 0) goto Lb5
                com.urbanairship.automation.engine.AutomationEventFeed r8 = r8.this$0
                java.util.Iterator r9 = r9.iterator()
                r2 = r8
            L49:
                boolean r8 = r9.hasNext()
                if (r8 == 0) goto Lb5
                java.lang.Object r8 = r9.next()
                com.urbanairship.automation.engine.AutomationEvent r8 = (com.urbanairship.automation.engine.AutomationEvent) r8
                kotlinx.coroutines.flow.MutableSharedFlow r10 = com.urbanairship.automation.engine.AutomationEventFeed.access$getStream$p(r2)
                r0.L$0 = r2
                r0.L$1 = r9
                r0.L$2 = r8
                r0.label = r3
                java.lang.Object r10 = r10.emit(r8, r0)
                if (r10 != r1) goto L68
                return r1
            L68:
                boolean r10 = r8 instanceof com.urbanairship.automation.engine.AutomationEvent.Event
                if (r10 == 0) goto L49
                com.urbanairship.automation.engine.AutomationEvent$Event r8 = (com.urbanairship.automation.engine.AutomationEvent.Event) r8
                com.urbanairship.automation.EventAutomationTriggerType r8 = r8.getTriggerType()
                int[] r10 = com.urbanairship.automation.engine.AutomationEventFeed$attach$1.AnonymousClass5.WhenMappings.$EnumSwitchMapping$0
                int r8 = r8.ordinal()
                r8 = r10[r8]
                r10 = 2
                r4 = 0
                if (r8 == r3) goto L97
                if (r8 == r10) goto L81
                goto L49
            L81:
                kotlinx.coroutines.flow.MutableStateFlow r8 = com.urbanairship.automation.engine.AutomationEventFeed.access$getAppSessionState$p(r2)
            L85:
                java.lang.Object r5 = r8.getValue()
                r6 = r5
                com.urbanairship.automation.engine.TriggerableState r6 = (com.urbanairship.automation.engine.TriggerableState) r6
                com.urbanairship.automation.engine.TriggerableState r6 = com.urbanairship.automation.engine.TriggerableState.copy$default(r6, r4, r4, r10, r4)
                boolean r5 = r8.compareAndSet(r5, r6)
                if (r5 == 0) goto L85
                goto L49
            L97:
                kotlinx.coroutines.flow.MutableStateFlow r8 = com.urbanairship.automation.engine.AutomationEventFeed.access$getAppSessionState$p(r2)
            L9b:
                java.lang.Object r5 = r8.getValue()
                r6 = r5
                com.urbanairship.automation.engine.TriggerableState r6 = (com.urbanairship.automation.engine.TriggerableState) r6
                java.util.UUID r7 = java.util.UUID.randomUUID()
                java.lang.String r7 = r7.toString()
                com.urbanairship.automation.engine.TriggerableState r6 = com.urbanairship.automation.engine.TriggerableState.copy$default(r6, r7, r4, r10, r4)
                boolean r5 = r8.compareAndSet(r5, r6)
                if (r5 == 0) goto L9b
                goto L49
            Lb5:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationEventFeed$attach$1.AnonymousClass5.emit(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
