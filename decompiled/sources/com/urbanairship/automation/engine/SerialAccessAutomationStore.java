package com.urbanairship.automation.engine;

import com.urbanairship.automation.engine.triggerprocessor.TriggerData;
import com.urbanairship.json.JsonException;
import com.urbanairship.util.SerialQueue;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u001c\u0010\u0006\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0096@¢\u0006\u0002\u0010\rJ$\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\u001c\u0010\u000e\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0096@¢\u0006\u0002\u0010\rJ\u001c\u0010\u0014\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0096@¢\u0006\u0002\u0010\rJ\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\fH\u0096@¢\u0006\u0002\u0010\u0019J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\f2\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0096@¢\u0006\u0002\u0010\rJ \u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\u001dJ,\u0010\u001e\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\t2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160 H\u0096@¢\u0006\u0002\u0010!J>\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u001a\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00160#H\u0096@¢\u0006\u0002\u0010$J\u001c\u0010%\u001a\u00020\u00072\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001b0\fH\u0096@¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/urbanairship/automation/engine/SerialAccessAutomationStore;", "Lcom/urbanairship/automation/engine/AutomationStoreInterface;", "store", "(Lcom/urbanairship/automation/engine/AutomationStoreInterface;)V", "queue", "Lcom/urbanairship/util/SerialQueue;", "deleteSchedules", "", "group", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ids", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTriggers", "scheduleID", "triggerIDs", "", "(Ljava/lang/String;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleIDs", "deleteTriggersExcluding", "getSchedule", "Lcom/urbanairship/automation/engine/AutomationScheduleData;", "id", "getSchedules", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrigger", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerData;", "triggerID", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSchedule", "closure", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertSchedules", "Lkotlin/Function2;", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertTriggers", "triggers", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SerialAccessAutomationStore implements AutomationStoreInterface {
    private final SerialQueue queue;
    private final AutomationStoreInterface store;

    public SerialAccessAutomationStore(@NotNull AutomationStoreInterface store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
        this.queue = new SerialQueue();
    }

    /* renamed from: com.urbanairship.automation.engine.SerialAccessAutomationStore$getSchedules$2, reason: invalid class name and case insensitive filesystem */
    static final class C10452 extends SuspendLambda implements Function1 {
        int label;

        C10452(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SerialAccessAutomationStore.this.new C10452(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C10452) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AutomationStoreInterface automationStoreInterface = SerialAccessAutomationStore.this.store;
                this.label = 1;
                obj = automationStoreInterface.getSchedules(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Override // com.urbanairship.automation.engine.ScheduleStoreInterface
    @Nullable
    public Object getSchedules(@NotNull Continuation<? super List<AutomationScheduleData>> continuation) {
        return this.queue.run(new C10452(null), continuation);
    }

    /* renamed from: com.urbanairship.automation.engine.SerialAccessAutomationStore$getSchedules$4, reason: invalid class name and case insensitive filesystem */
    static final class C10464 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $group;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10464(String str, Continuation continuation) {
            super(1, continuation);
            this.$group = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SerialAccessAutomationStore.this.new C10464(this.$group, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C10464) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AutomationStoreInterface automationStoreInterface = SerialAccessAutomationStore.this.store;
                String str = this.$group;
                this.label = 1;
                obj = automationStoreInterface.getSchedules(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Override // com.urbanairship.automation.engine.ScheduleStoreInterface
    @Nullable
    public Object getSchedules(@NotNull String str, @NotNull Continuation<? super List<AutomationScheduleData>> continuation) {
        return this.queue.run(new C10464(str, null), continuation);
    }

    /* renamed from: com.urbanairship.automation.engine.SerialAccessAutomationStore$getSchedules$6, reason: invalid class name */
    static final class AnonymousClass6 extends SuspendLambda implements Function1 {
        final /* synthetic */ List $ids;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(List list, Continuation continuation) {
            super(1, continuation);
            this.$ids = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SerialAccessAutomationStore.this.new AnonymousClass6(this.$ids, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass6) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AutomationStoreInterface automationStoreInterface = SerialAccessAutomationStore.this.store;
                List<String> list = this.$ids;
                this.label = 1;
                obj = automationStoreInterface.getSchedules(list, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Override // com.urbanairship.automation.engine.ScheduleStoreInterface
    @Nullable
    public Object getSchedules(@NotNull List<String> list, @NotNull Continuation<? super List<AutomationScheduleData>> continuation) {
        return this.queue.run(new AnonymousClass6(list, null), continuation);
    }

    /* renamed from: com.urbanairship.automation.engine.SerialAccessAutomationStore$updateSchedule$2, reason: invalid class name and case insensitive filesystem */
    static final class C10482 extends SuspendLambda implements Function1 {
        final /* synthetic */ Function1 $closure;
        final /* synthetic */ String $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10482(String str, Function1 function1, Continuation continuation) {
            super(1, continuation);
            this.$id = str;
            this.$closure = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SerialAccessAutomationStore.this.new C10482(this.$id, this.$closure, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C10482) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AutomationStoreInterface automationStoreInterface = SerialAccessAutomationStore.this.store;
                String str = this.$id;
                Function1<? super AutomationScheduleData, AutomationScheduleData> function1 = this.$closure;
                this.label = 1;
                obj = automationStoreInterface.updateSchedule(str, function1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Override // com.urbanairship.automation.engine.ScheduleStoreInterface
    @Nullable
    public Object updateSchedule(@NotNull String str, @NotNull Function1<? super AutomationScheduleData, AutomationScheduleData> function1, @NotNull Continuation<? super AutomationScheduleData> continuation) {
        return this.queue.run(new C10482(str, function1, null), continuation);
    }

    /* renamed from: com.urbanairship.automation.engine.SerialAccessAutomationStore$upsertSchedules$2, reason: invalid class name and case insensitive filesystem */
    static final class C10492 extends SuspendLambda implements Function1 {
        final /* synthetic */ Function2 $closure;
        final /* synthetic */ List $ids;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10492(List list, Function2 function2, Continuation continuation) {
            super(1, continuation);
            this.$ids = list;
            this.$closure = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SerialAccessAutomationStore.this.new C10492(this.$ids, this.$closure, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C10492) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AutomationStoreInterface automationStoreInterface = SerialAccessAutomationStore.this.store;
                List<String> list = this.$ids;
                Function2<? super String, ? super AutomationScheduleData, AutomationScheduleData> function2 = this.$closure;
                this.label = 1;
                obj = automationStoreInterface.upsertSchedules(list, function2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Override // com.urbanairship.automation.engine.ScheduleStoreInterface
    @Nullable
    public Object upsertSchedules(@NotNull List<String> list, @NotNull Function2<? super String, ? super AutomationScheduleData, AutomationScheduleData> function2, @NotNull Continuation<? super List<AutomationScheduleData>> continuation) {
        return this.queue.run(new C10492(list, function2, null), continuation);
    }

    /* renamed from: com.urbanairship.automation.engine.SerialAccessAutomationStore$deleteSchedules$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function1 {
        final /* synthetic */ List $ids;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List list, Continuation continuation) {
            super(1, continuation);
            this.$ids = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SerialAccessAutomationStore.this.new AnonymousClass2(this.$ids, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AutomationStoreInterface automationStoreInterface = SerialAccessAutomationStore.this.store;
                List<String> list = this.$ids;
                this.label = 1;
                if (automationStoreInterface.deleteSchedules(list, this) == coroutine_suspended) {
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

    @Override // com.urbanairship.automation.engine.ScheduleStoreInterface
    @Nullable
    public Object deleteSchedules(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
        Object objRun = this.queue.run(new AnonymousClass2(list, null), continuation);
        return objRun == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRun : Unit.INSTANCE;
    }

    /* renamed from: com.urbanairship.automation.engine.SerialAccessAutomationStore$deleteSchedules$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $group;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(String str, Continuation continuation) {
            super(1, continuation);
            this.$group = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SerialAccessAutomationStore.this.new AnonymousClass4(this.$group, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AutomationStoreInterface automationStoreInterface = SerialAccessAutomationStore.this.store;
                String str = this.$group;
                this.label = 1;
                if (automationStoreInterface.deleteSchedules(str, this) == coroutine_suspended) {
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

    @Override // com.urbanairship.automation.engine.ScheduleStoreInterface
    @Nullable
    public Object deleteSchedules(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        Object objRun = this.queue.run(new AnonymousClass4(str, null), continuation);
        return objRun == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRun : Unit.INSTANCE;
    }

    /* renamed from: com.urbanairship.automation.engine.SerialAccessAutomationStore$getSchedule$2, reason: invalid class name and case insensitive filesystem */
    static final class C10442 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10442(String str, Continuation continuation) {
            super(1, continuation);
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SerialAccessAutomationStore.this.new C10442(this.$id, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C10442) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AutomationStoreInterface automationStoreInterface = SerialAccessAutomationStore.this.store;
                String str = this.$id;
                this.label = 1;
                obj = automationStoreInterface.getSchedule(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Override // com.urbanairship.automation.engine.ScheduleStoreInterface
    @Nullable
    public Object getSchedule(@NotNull String str, @NotNull Continuation<? super AutomationScheduleData> continuation) {
        return this.queue.run(new C10442(str, null), continuation);
    }

    /* renamed from: com.urbanairship.automation.engine.SerialAccessAutomationStore$getTrigger$2, reason: invalid class name and case insensitive filesystem */
    static final class C10472 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $scheduleID;
        final /* synthetic */ String $triggerID;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10472(String str, String str2, Continuation continuation) {
            super(1, continuation);
            this.$scheduleID = str;
            this.$triggerID = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SerialAccessAutomationStore.this.new C10472(this.$scheduleID, this.$triggerID, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C10472) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws JsonException {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AutomationStoreInterface automationStoreInterface = SerialAccessAutomationStore.this.store;
                String str = this.$scheduleID;
                String str2 = this.$triggerID;
                this.label = 1;
                obj = automationStoreInterface.getTrigger(str, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Override // com.urbanairship.automation.engine.TriggerStoreInterface
    @Nullable
    public Object getTrigger(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super TriggerData> continuation) {
        return this.queue.run(new C10472(str, str2, null), continuation);
    }

    /* renamed from: com.urbanairship.automation.engine.SerialAccessAutomationStore$upsertTriggers$2, reason: invalid class name and case insensitive filesystem */
    static final class C10502 extends SuspendLambda implements Function1 {
        final /* synthetic */ List $triggers;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10502(List list, Continuation continuation) {
            super(1, continuation);
            this.$triggers = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SerialAccessAutomationStore.this.new C10502(this.$triggers, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C10502) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AutomationStoreInterface automationStoreInterface = SerialAccessAutomationStore.this.store;
                List<TriggerData> list = this.$triggers;
                this.label = 1;
                if (automationStoreInterface.upsertTriggers(list, this) == coroutine_suspended) {
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

    @Override // com.urbanairship.automation.engine.TriggerStoreInterface
    @Nullable
    public Object upsertTriggers(@NotNull List<TriggerData> list, @NotNull Continuation<? super Unit> continuation) {
        Object objRun = this.queue.run(new C10502(list, null), continuation);
        return objRun == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRun : Unit.INSTANCE;
    }

    /* renamed from: com.urbanairship.automation.engine.SerialAccessAutomationStore$deleteTriggersExcluding$2, reason: invalid class name and case insensitive filesystem */
    static final class C10432 extends SuspendLambda implements Function1 {
        final /* synthetic */ List $scheduleIDs;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10432(List list, Continuation continuation) {
            super(1, continuation);
            this.$scheduleIDs = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SerialAccessAutomationStore.this.new C10432(this.$scheduleIDs, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C10432) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AutomationStoreInterface automationStoreInterface = SerialAccessAutomationStore.this.store;
                List<String> list = this.$scheduleIDs;
                this.label = 1;
                if (automationStoreInterface.deleteTriggersExcluding(list, this) == coroutine_suspended) {
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

    @Override // com.urbanairship.automation.engine.TriggerStoreInterface
    @Nullable
    public Object deleteTriggersExcluding(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
        Object objRun = this.queue.run(new C10432(list, null), continuation);
        return objRun == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRun : Unit.INSTANCE;
    }

    /* renamed from: com.urbanairship.automation.engine.SerialAccessAutomationStore$deleteTriggers$2, reason: invalid class name and case insensitive filesystem */
    static final class C10412 extends SuspendLambda implements Function1 {
        final /* synthetic */ List $scheduleIDs;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10412(List list, Continuation continuation) {
            super(1, continuation);
            this.$scheduleIDs = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SerialAccessAutomationStore.this.new C10412(this.$scheduleIDs, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C10412) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AutomationStoreInterface automationStoreInterface = SerialAccessAutomationStore.this.store;
                List<String> list = this.$scheduleIDs;
                this.label = 1;
                if (automationStoreInterface.deleteTriggers(list, this) == coroutine_suspended) {
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

    @Override // com.urbanairship.automation.engine.TriggerStoreInterface
    @Nullable
    public Object deleteTriggers(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
        Object objRun = this.queue.run(new C10412(list, null), continuation);
        return objRun == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRun : Unit.INSTANCE;
    }

    /* renamed from: com.urbanairship.automation.engine.SerialAccessAutomationStore$deleteTriggers$4, reason: invalid class name and case insensitive filesystem */
    static final class C10424 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $scheduleID;
        final /* synthetic */ Set $triggerIDs;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10424(String str, Set set, Continuation continuation) {
            super(1, continuation);
            this.$scheduleID = str;
            this.$triggerIDs = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SerialAccessAutomationStore.this.new C10424(this.$scheduleID, this.$triggerIDs, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C10424) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AutomationStoreInterface automationStoreInterface = SerialAccessAutomationStore.this.store;
                String str = this.$scheduleID;
                Set<String> set = this.$triggerIDs;
                this.label = 1;
                if (automationStoreInterface.deleteTriggers(str, set, this) == coroutine_suspended) {
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

    @Override // com.urbanairship.automation.engine.TriggerStoreInterface
    @Nullable
    public Object deleteTriggers(@NotNull String str, @NotNull Set<String> set, @NotNull Continuation<? super Unit> continuation) {
        Object objRun = this.queue.run(new C10424(str, set, null), continuation);
        return objRun == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRun : Unit.INSTANCE;
    }
}
