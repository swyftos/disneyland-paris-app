package com.urbanairship.iam.analytics;

import com.urbanairship.automation.engine.AutomationScheduleData;
import com.urbanairship.automation.engine.ScheduleStoreInterface;
import com.urbanairship.channel.AttributeMutation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/iam/analytics/MessageDisplayHistoryStore;", "Lcom/urbanairship/iam/analytics/MessageDisplayHistoryStoreInterface;", "store", "Lcom/urbanairship/automation/engine/ScheduleStoreInterface;", "(Lcom/urbanairship/automation/engine/ScheduleStoreInterface;)V", "getStore", "()Lcom/urbanairship/automation/engine/ScheduleStoreInterface;", "get", "Lcom/urbanairship/iam/analytics/MessageDisplayHistory;", "scheduleID", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", AttributeMutation.ATTRIBUTE_ACTION_SET, "", "history", "(Lcom/urbanairship/iam/analytics/MessageDisplayHistory;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MessageDisplayHistoryStore implements MessageDisplayHistoryStoreInterface {
    private final ScheduleStoreInterface store;

    /* renamed from: com.urbanairship.iam.analytics.MessageDisplayHistoryStore$get$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MessageDisplayHistoryStore.this.get(null, this);
        }
    }

    public MessageDisplayHistoryStore(@NotNull ScheduleStoreInterface store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
    }

    @NotNull
    public final ScheduleStoreInterface getStore() {
        return this.store;
    }

    @Override // com.urbanairship.iam.analytics.MessageDisplayHistoryStoreInterface
    @Nullable
    public Object set(@NotNull final MessageDisplayHistory messageDisplayHistory, @NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        Object objUpdateSchedule = this.store.updateSchedule(str, new Function1() { // from class: com.urbanairship.iam.analytics.MessageDisplayHistoryStore.set.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AutomationScheduleData invoke(AutomationScheduleData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                data.setAssociatedData(messageDisplayHistory.getJsonValue());
                return data;
            }
        }, continuation);
        return objUpdateSchedule == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateSchedule : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.urbanairship.iam.analytics.MessageDisplayHistoryStoreInterface
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object get(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.iam.analytics.MessageDisplayHistory> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.urbanairship.iam.analytics.MessageDisplayHistoryStore.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.iam.analytics.MessageDisplayHistoryStore$get$1 r0 = (com.urbanairship.iam.analytics.MessageDisplayHistoryStore.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.iam.analytics.MessageDisplayHistoryStore$get$1 r0 = new com.urbanairship.iam.analytics.MessageDisplayHistoryStore$get$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r6)
            goto L3f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            com.urbanairship.automation.engine.ScheduleStoreInterface r4 = r4.store
            r0.label = r3
            java.lang.Object r6 = r4.getSchedule(r5, r0)
            if (r6 != r1) goto L3f
            return r1
        L3f:
            com.urbanairship.automation.engine.AutomationScheduleData r6 = (com.urbanairship.automation.engine.AutomationScheduleData) r6
            r4 = 3
            r5 = 0
            if (r6 == 0) goto L60
            com.urbanairship.json.JsonValue r6 = r6.getAssociatedData()
            if (r6 != 0) goto L4c
            goto L60
        L4c:
            com.urbanairship.iam.analytics.MessageDisplayHistory$Companion r0 = com.urbanairship.iam.analytics.MessageDisplayHistory.INSTANCE     // Catch: com.urbanairship.json.JsonException -> L53
            com.urbanairship.iam.analytics.MessageDisplayHistory r4 = r0.fromJson(r6)     // Catch: com.urbanairship.json.JsonException -> L53
            goto L5f
        L53:
            r6 = move-exception
            com.urbanairship.iam.analytics.MessageDisplayHistoryStore$get$2$1 r0 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.iam.analytics.MessageDisplayHistoryStore$get$2$1
                static {
                    /*
                        com.urbanairship.iam.analytics.MessageDisplayHistoryStore$get$2$1 r0 = new com.urbanairship.iam.analytics.MessageDisplayHistoryStore$get$2$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.iam.analytics.MessageDisplayHistoryStore$get$2$1) com.urbanairship.iam.analytics.MessageDisplayHistoryStore$get$2$1.INSTANCE com.urbanairship.iam.analytics.MessageDisplayHistoryStore$get$2$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.analytics.MessageDisplayHistoryStore$get$2$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.analytics.MessageDisplayHistoryStore$get$2$1.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.analytics.MessageDisplayHistoryStore$get$2$1.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "failed to retrieve message history"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.analytics.MessageDisplayHistoryStore$get$2$1.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.e(r6, r0)
            com.urbanairship.iam.analytics.MessageDisplayHistory r6 = new com.urbanairship.iam.analytics.MessageDisplayHistory
            r6.<init>(r5, r5, r4, r5)
            r4 = r6
        L5f:
            return r4
        L60:
            com.urbanairship.iam.analytics.MessageDisplayHistory r6 = new com.urbanairship.iam.analytics.MessageDisplayHistory
            r6.<init>(r5, r5, r4, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.analytics.MessageDisplayHistoryStore.get(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
