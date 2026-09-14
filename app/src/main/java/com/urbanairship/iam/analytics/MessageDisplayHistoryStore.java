package com.urbanairship.iam.analytics;

import com.urbanairship.UALog;
import com.urbanairship.automation.engine.AutomationScheduleData;
import com.urbanairship.automation.engine.ScheduleStoreInterface;
import com.urbanairship.channel.AttributeMutation;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m1836d2 = {"Lcom/urbanairship/iam/analytics/MessageDisplayHistoryStore;", "Lcom/urbanairship/iam/analytics/MessageDisplayHistoryStoreInterface;", "store", "Lcom/urbanairship/automation/engine/ScheduleStoreInterface;", "(Lcom/urbanairship/automation/engine/ScheduleStoreInterface;)V", "getStore", "()Lcom/urbanairship/automation/engine/ScheduleStoreInterface;", "get", "Lcom/urbanairship/iam/analytics/MessageDisplayHistory;", "scheduleID", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", AttributeMutation.ATTRIBUTE_ACTION_SET, "", "history", "(Lcom/urbanairship/iam/analytics/MessageDisplayHistory;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public final class MessageDisplayHistoryStore implements MessageDisplayHistoryStoreInterface {
    private final ScheduleStoreInterface store;

    /* JADX INFO: renamed from: com.urbanairship.iam.analytics.MessageDisplayHistoryStore$get$1 */
    static final class C53511 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C53511(Continuation continuation) {
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

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.urbanairship.iam.analytics.MessageDisplayHistoryStoreInterface
    @Nullable
    public Object get(@NotNull String str, @NotNull Continuation<? super MessageDisplayHistory> continuation) {
        C53511 c53511;
        JsonValue associatedData;
        if (continuation instanceof C53511) {
            c53511 = (C53511) continuation;
            int i = c53511.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c53511.label = i - Integer.MIN_VALUE;
            } else {
                c53511 = new C53511(continuation);
            }
        } else {
            c53511 = new C53511(continuation);
        }
        Object schedule = c53511.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c53511.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(schedule);
            ScheduleStoreInterface scheduleStoreInterface = this.store;
            c53511.label = 1;
            schedule = scheduleStoreInterface.getSchedule(str, c53511);
            if (schedule == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(schedule);
        }
        AutomationScheduleData automationScheduleData = (AutomationScheduleData) schedule;
        if (automationScheduleData == null || (associatedData = automationScheduleData.getAssociatedData()) == null) {
            return new MessageDisplayHistory(null, null, 3, null);
        }
        try {
            return MessageDisplayHistory.INSTANCE.fromJson(associatedData);
        } catch (JsonException e) {
            UALog.m1747e(e, new Function0() { // from class: com.urbanairship.iam.analytics.MessageDisplayHistoryStore$get$2$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "failed to retrieve message history";
                }
            });
            return new MessageDisplayHistory(null, null, 3, null);
        }
    }
}
