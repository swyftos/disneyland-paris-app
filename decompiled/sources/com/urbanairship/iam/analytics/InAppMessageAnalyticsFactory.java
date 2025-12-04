package com.urbanairship.iam.analytics;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsFactory;", "", "eventRecorder", "Lcom/urbanairship/iam/analytics/InAppEventRecorderInterface;", "displayHistoryStore", "Lcom/urbanairship/iam/analytics/MessageDisplayHistoryStore;", "displayImpressionRuleProvider", "Lcom/urbanairship/iam/analytics/InAppDisplayImpressionRuleInterface;", "(Lcom/urbanairship/iam/analytics/InAppEventRecorderInterface;Lcom/urbanairship/iam/analytics/MessageDisplayHistoryStore;Lcom/urbanairship/iam/analytics/InAppDisplayImpressionRuleInterface;)V", "makeAnalytics", "Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;", "message", "Lcom/urbanairship/iam/InAppMessage;", "preparedScheduleInfo", "Lcom/urbanairship/automation/engine/PreparedScheduleInfo;", "(Lcom/urbanairship/iam/InAppMessage;Lcom/urbanairship/automation/engine/PreparedScheduleInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppMessageAnalyticsFactory {
    private final MessageDisplayHistoryStore displayHistoryStore;
    private final InAppDisplayImpressionRuleInterface displayImpressionRuleProvider;
    private final InAppEventRecorderInterface eventRecorder;

    /* renamed from: com.urbanairship.iam.analytics.InAppMessageAnalyticsFactory$makeAnalytics$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppMessageAnalyticsFactory.this.makeAnalytics(null, null, this);
        }
    }

    public InAppMessageAnalyticsFactory(@NotNull InAppEventRecorderInterface eventRecorder, @NotNull MessageDisplayHistoryStore displayHistoryStore, @NotNull InAppDisplayImpressionRuleInterface displayImpressionRuleProvider) {
        Intrinsics.checkNotNullParameter(eventRecorder, "eventRecorder");
        Intrinsics.checkNotNullParameter(displayHistoryStore, "displayHistoryStore");
        Intrinsics.checkNotNullParameter(displayImpressionRuleProvider, "displayImpressionRuleProvider");
        this.eventRecorder = eventRecorder;
        this.displayHistoryStore = displayHistoryStore;
        this.displayImpressionRuleProvider = displayImpressionRuleProvider;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object makeAnalytics(@org.jetbrains.annotations.NotNull com.urbanairship.iam.InAppMessage r18, @org.jetbrains.annotations.NotNull com.urbanairship.automation.engine.PreparedScheduleInfo r19, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.iam.analytics.InAppMessageAnalyticsInterface> r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r20
            boolean r3 = r2 instanceof com.urbanairship.iam.analytics.InAppMessageAnalyticsFactory.AnonymousClass1
            if (r3 == 0) goto L19
            r3 = r2
            com.urbanairship.iam.analytics.InAppMessageAnalyticsFactory$makeAnalytics$1 r3 = (com.urbanairship.iam.analytics.InAppMessageAnalyticsFactory.AnonymousClass1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.label = r4
            goto L1e
        L19:
            com.urbanairship.iam.analytics.InAppMessageAnalyticsFactory$makeAnalytics$1 r3 = new com.urbanairship.iam.analytics.InAppMessageAnalyticsFactory$makeAnalytics$1
            r3.<init>(r2)
        L1e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            if (r5 == 0) goto L50
            if (r5 != r6) goto L48
            java.lang.Object r0 = r3.L$4
            com.urbanairship.iam.analytics.MessageDisplayHistoryStore r0 = (com.urbanairship.iam.analytics.MessageDisplayHistoryStore) r0
            java.lang.Object r1 = r3.L$3
            com.urbanairship.iam.analytics.InAppEventRecorderInterface r1 = (com.urbanairship.iam.analytics.InAppEventRecorderInterface) r1
            java.lang.Object r4 = r3.L$2
            com.urbanairship.iam.analytics.InAppDisplayImpressionRule r4 = (com.urbanairship.iam.analytics.InAppDisplayImpressionRule) r4
            java.lang.Object r5 = r3.L$1
            com.urbanairship.automation.engine.PreparedScheduleInfo r5 = (com.urbanairship.automation.engine.PreparedScheduleInfo) r5
            java.lang.Object r3 = r3.L$0
            com.urbanairship.iam.InAppMessage r3 = (com.urbanairship.iam.InAppMessage) r3
            kotlin.ResultKt.throwOnFailure(r2)
            r10 = r0
            r9 = r1
            r8 = r3
            r11 = r4
            r7 = r5
            goto L7c
        L48:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L50:
            kotlin.ResultKt.throwOnFailure(r2)
            com.urbanairship.iam.analytics.InAppDisplayImpressionRuleInterface r2 = r0.displayImpressionRuleProvider
            com.urbanairship.iam.analytics.InAppDisplayImpressionRule r2 = r2.impressionRules(r1)
            com.urbanairship.iam.analytics.InAppEventRecorderInterface r5 = r0.eventRecorder
            com.urbanairship.iam.analytics.MessageDisplayHistoryStore r0 = r0.displayHistoryStore
            java.lang.String r7 = r19.getScheduleId$urbanairship_automation_release()
            r3.L$0 = r1
            r8 = r19
            r3.L$1 = r8
            r3.L$2 = r2
            r3.L$3 = r5
            r3.L$4 = r0
            r3.label = r6
            java.lang.Object r3 = r0.get(r7, r3)
            if (r3 != r4) goto L76
            return r4
        L76:
            r10 = r0
            r11 = r2
            r2 = r3
            r9 = r5
            r7 = r8
            r8 = r1
        L7c:
            r12 = r2
            com.urbanairship.iam.analytics.MessageDisplayHistory r12 = (com.urbanairship.iam.analytics.MessageDisplayHistory) r12
            com.urbanairship.iam.analytics.InAppMessageAnalytics r0 = new com.urbanairship.iam.analytics.InAppMessageAnalytics
            r15 = 192(0xc0, float:2.69E-43)
            r16 = 0
            r13 = 0
            r14 = 0
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.analytics.InAppMessageAnalyticsFactory.makeAnalytics(com.urbanairship.iam.InAppMessage, com.urbanairship.automation.engine.PreparedScheduleInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
