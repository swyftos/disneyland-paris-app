package com.urbanairship.automation.engine.triggerprocessor;

import com.dlp.BluetoothManager;
import com.urbanairship.automation.engine.AutomationEvent;
import com.urbanairship.automation.engine.AutomationScheduleState;
import com.urbanairship.automation.engine.TriggerStoreInterface;
import com.urbanairship.automation.engine.TriggerableState;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0018J\u001c\u0010\u0015\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000fH\u0086@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u001dJ\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u001fJ&\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0082@¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0086@¢\u0006\u0002\u0010+J\u001c\u0010,\u001a\u00020\u00162\f\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u000fH\u0086@¢\u0006\u0002\u0010\u001aJ\u000e\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u000bJ\u0010\u00101\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0002J \u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010&H\u0082@¢\u0006\u0002\u00104J\u001e\u00105\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u000e2\u0006\u00106\u001a\u000207H\u0086@¢\u0006\u0002\u00108J\u001c\u00109\u001a\u00020\u00162\f\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u000fH\u0086@¢\u0006\u0002\u0010\u001aR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/urbanairship/automation/engine/triggerprocessor/AutomationTriggerProcessor;", "", "store", "Lcom/urbanairship/automation/engine/TriggerStoreInterface;", "clock", "Lcom/urbanairship/util/Clock;", "(Lcom/urbanairship/automation/engine/TriggerStoreInterface;Lcom/urbanairship/util/Clock;)V", "appSessionState", "Lcom/urbanairship/automation/engine/TriggerableState;", "isPausedFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "preparedTriggers", "", "", "", "Lcom/urbanairship/automation/engine/triggerprocessor/PreparedTrigger;", "scheduleGroups", "triggerResultsFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerResult;", "cancel", "", "group", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleIds", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emit", "result", "(Lcom/urbanairship/automation/engine/triggerprocessor/TriggerResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTriggerResults", "Lkotlinx/coroutines/flow/Flow;", "makePreparedTrigger", "schedule", "Lcom/urbanairship/automation/AutomationSchedule;", DeferredApiClient.KEY_TRIGGER_CONTEXT, "Lcom/urbanairship/automation/AutomationTrigger;", "type", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType;", "(Lcom/urbanairship/automation/AutomationSchedule;Lcom/urbanairship/automation/AutomationTrigger;Lcom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processEvent", "event", "Lcom/urbanairship/automation/engine/AutomationEvent;", "(Lcom/urbanairship/automation/engine/AutomationEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreSchedules", "datas", "Lcom/urbanairship/automation/engine/AutomationScheduleData;", "setPaused", "paused", "trackStateChange", "updateActiveTriggers", "scheduleId", "(Ljava/lang/String;Lcom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateScheduleState", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/automation/engine/AutomationScheduleState;", "(Ljava/lang/String;Lcom/urbanairship/automation/engine/AutomationScheduleState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSchedules", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAutomationTriggerProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationTriggerProcessor.kt\ncom/urbanairship/automation/engine/triggerprocessor/AutomationTriggerProcessor\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 6 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,247:1\n226#2,5:248\n1855#3:253\n1855#3:254\n1856#3:256\n1856#3:257\n1549#3:258\n1620#3,3:259\n1549#3:262\n1620#3,3:263\n288#3,2:266\n288#3,2:268\n1549#3:270\n1620#3,3:271\n1549#3:274\n1620#3,3:275\n1855#3,2:278\n1855#3,2:291\n1855#3,2:293\n1603#3,9:295\n1855#3:304\n1856#3:306\n1612#3:307\n1549#3:308\n1620#3,3:309\n1#4:255\n1#4:305\n526#5:280\n511#5,6:281\n125#6:287\n152#6,3:288\n*S KotlinDebug\n*F\n+ 1 AutomationTriggerProcessor.kt\ncom/urbanairship/automation/engine/triggerprocessor/AutomationTriggerProcessor\n*L\n32#1:248,5\n47#1:253\n48#1:254\n48#1:256\n47#1:257\n56#1:258\n56#1:259,3\n69#1:262\n69#1:263,3\n87#1:266,2\n108#1:268,2\n127#1:270\n127#1:271,3\n128#1:274\n128#1:275,3\n144#1:278,2\n181#1:291,2\n185#1:293,2\n195#1:295,9\n195#1:304\n195#1:306\n195#1:307\n204#1:308\n204#1:309,3\n195#1:305\n153#1:280\n153#1:281,6\n153#1:287\n153#1:288,3\n*E\n"})
/* loaded from: classes5.dex */
public final class AutomationTriggerProcessor {
    private TriggerableState appSessionState;
    private final Clock clock;
    private final MutableStateFlow isPausedFlow;
    private Map preparedTriggers;
    private Map scheduleGroups;
    private final TriggerStoreInterface store;
    private final MutableSharedFlow triggerResultsFlow;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AutomationScheduleState.values().length];
            try {
                iArr[AutomationScheduleState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AutomationScheduleState.TRIGGERED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AutomationScheduleState.PREPARED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AutomationScheduleState.EXECUTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AutomationScheduleState.PAUSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AutomationScheduleState.FINISHED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor$makePreparedTrigger$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationTriggerProcessor.this.makePreparedTrigger(null, null, null, this);
        }
    }

    /* renamed from: com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor$processEvent$1, reason: invalid class name and case insensitive filesystem */
    static final class C10511 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C10511(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationTriggerProcessor.this.processEvent(null, this);
        }
    }

    /* renamed from: com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor$restoreSchedules$1, reason: invalid class name and case insensitive filesystem */
    static final class C10521 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10521(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationTriggerProcessor.this.restoreSchedules(null, this);
        }
    }

    /* renamed from: com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor$updateActiveTriggers$1, reason: invalid class name and case insensitive filesystem */
    static final class C10531 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C10531(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationTriggerProcessor.this.updateActiveTriggers(null, null, this);
        }
    }

    /* renamed from: com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor$updateSchedules$1, reason: invalid class name and case insensitive filesystem */
    static final class C10541 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C10541(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationTriggerProcessor.this.updateSchedules(null, this);
        }
    }

    public AutomationTriggerProcessor(@NotNull TriggerStoreInterface store, @NotNull Clock clock) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.store = store;
        this.clock = clock;
        this.triggerResultsFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.isPausedFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.preparedTriggers = new LinkedHashMap();
        this.scheduleGroups = new LinkedHashMap();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AutomationTriggerProcessor(TriggerStoreInterface triggerStoreInterface, Clock DEFAULT_CLOCK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(triggerStoreInterface, DEFAULT_CLOCK);
    }

    public final void setPaused(boolean paused) {
        Object value;
        MutableStateFlow mutableStateFlow = this.isPausedFlow;
        do {
            value = mutableStateFlow.getValue();
            ((Boolean) value).booleanValue();
        } while (!mutableStateFlow.compareAndSet(value, Boolean.valueOf(paused)));
    }

    @NotNull
    public final Flow<TriggerResult> getTriggerResults() {
        return this.triggerResultsFlow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.util.List] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processEvent(@org.jetbrains.annotations.NotNull com.urbanairship.automation.engine.AutomationEvent r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor.processEvent(com.urbanairship.automation.engine.AutomationEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object restoreSchedules(@org.jetbrains.annotations.NotNull java.util.List<com.urbanairship.automation.engine.AutomationScheduleData> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor.C10521
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor$restoreSchedules$1 r0 = (com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor.C10521) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor$restoreSchedules$1 r0 = new com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor$restoreSchedules$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L88
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r5 = r0.L$0
            com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor r5 = (com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L51
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.updateSchedules(r6, r0)
            if (r7 != r1) goto L51
            return r1
        L51:
            java.util.ArrayList r7 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r2)
            r7.<init>(r2)
            java.util.Iterator r6 = r6.iterator()
        L60:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L78
            java.lang.Object r2 = r6.next()
            com.urbanairship.automation.engine.AutomationScheduleData r2 = (com.urbanairship.automation.engine.AutomationScheduleData) r2
            com.urbanairship.automation.AutomationSchedule r2 = r2.getSchedule()
            java.lang.String r2 = r2.getIdentifier()
            r7.add(r2)
            goto L60
        L78:
            com.urbanairship.automation.engine.TriggerStoreInterface r5 = r5.store
            r6 = 0
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r5 = r5.deleteTriggersExcluding(r7, r0)
            if (r5 != r1) goto L88
            return r1
        L88:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor.restoreSchedules(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:27|(1:29)|30|(1:32)|33|124|(5:36|(2:37|(2:39|(1:126)(1:42))(2:125|43))|44|(4:46|(1:48)(1:49)|50|51)(1:123)|34)|122|56|(1:60)|61|134|(6:64|(2:65|(2:67|(1:136)(1:137))(2:135|70))|71|(5:129|73|(1:75)(1:76)|77|133)(3:127|78|(2:130|80)(2:81|132))|131|62)|128|82|(2:85|83)|138|86|(2:89|87)|139|90|114|91|(5:93|94|118|95|(1:97)(5:98|99|100|107|(1:109)(4:110|111|25|(0)(0))))(3:105|107|(0)(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(5:93|94|118|95|(1:97)(5:98|99|100|107|(1:109)(4:110|111|25|(0)(0)))) */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0295, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0296, code lost:
    
        r2 = r12;
        r4 = r13;
        r11 = r14;
        r12 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x029b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x029c, code lost:
    
        r5 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0162, code lost:
    
        r5 = com.urbanairship.automation.engine.triggerprocessor.TriggerExecutionType.EXECUTION;
        r1.L$0 = r15;
        r1.L$1 = r14;
        r1.L$2 = r13;
        r1.L$3 = r12;
        r1.L$4 = r11;
        r1.L$5 = r4;
        r1.L$6 = r2;
        r1.label = 1;
        r0 = r15.makePreparedTrigger(r12, r0, r5, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0178, code lost:
    
        if (r0 != r3) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x017a, code lost:
    
        return r3;
     */
    /* JADX WARN: Path cross not found for [B:58:0x0187, B:60:0x018d], limit reached: 138 */
    /* JADX WARN: Removed duplicated region for block: B:105:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02e0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0223 A[LOOP:4: B:83:0x021d->B:85:0x0223, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x024c A[LOOP:5: B:87:0x0246->B:89:0x024c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x026c A[Catch: Exception -> 0x029b, TRY_LEAVE, TryCatch #0 {Exception -> 0x029b, blocks: (B:91:0x0262, B:93:0x026c), top: B:114:0x0262 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:110:0x02e1 -> B:111:0x02e3). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateSchedules(@org.jetbrains.annotations.NotNull java.util.List<com.urbanairship.automation.engine.AutomationScheduleData> r22, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            Method dump skipped, instructions count: 746
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor.updateSchedules(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final Object cancel(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        Map map = this.scheduleGroups;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (Intrinsics.areEqual(entry.getValue(), str)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map.Entry) it.next()).getKey());
        }
        Object objCancel = cancel(arrayList, continuation);
        return objCancel == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCancel : Unit.INSTANCE;
    }

    private final void trackStateChange(AutomationEvent event) {
        if (event instanceof AutomationEvent.StateChanged) {
            this.appSessionState = ((AutomationEvent.StateChanged) event).getState();
        }
    }

    @Nullable
    public final Object updateScheduleState(@NotNull String str, @NotNull AutomationScheduleState automationScheduleState, @NotNull Continuation<? super Unit> continuation) {
        switch (WhenMappings.$EnumSwitchMapping$0[automationScheduleState.ordinal()]) {
            case 1:
                Object objUpdateActiveTriggers = updateActiveTriggers(str, TriggerExecutionType.EXECUTION, continuation);
                return objUpdateActiveTriggers == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateActiveTriggers : Unit.INSTANCE;
            case 2:
            case 3:
                Object objUpdateActiveTriggers2 = updateActiveTriggers(str, TriggerExecutionType.DELAY_CANCELLATION, continuation);
                return objUpdateActiveTriggers2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateActiveTriggers2 : Unit.INSTANCE;
            case 4:
            case 5:
            case 6:
                Object objUpdateActiveTriggers3 = updateActiveTriggers(str, null, continuation);
                return objUpdateActiveTriggers3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateActiveTriggers3 : Unit.INSTANCE;
            default:
                return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateActiveTriggers(java.lang.String r8, com.urbanairship.automation.engine.triggerprocessor.TriggerExecutionType r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor.updateActiveTriggers(java.lang.String, com.urbanairship.automation.engine.triggerprocessor.TriggerExecutionType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object emit(TriggerResult triggerResult, Continuation continuation) {
        if (((Boolean) this.isPausedFlow.getValue()).booleanValue()) {
            return Unit.INSTANCE;
        }
        Object objEmit = this.triggerResultsFlow.emit(triggerResult, continuation);
        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object makePreparedTrigger(com.urbanairship.automation.AutomationSchedule r20, com.urbanairship.automation.AutomationTrigger r21, com.urbanairship.automation.engine.triggerprocessor.TriggerExecutionType r22, kotlin.coroutines.Continuation r23) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor.makePreparedTrigger(com.urbanairship.automation.AutomationSchedule, com.urbanairship.automation.AutomationTrigger, com.urbanairship.automation.engine.triggerprocessor.TriggerExecutionType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final Object cancel(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
        for (String str : list) {
            this.preparedTriggers.remove(str);
            this.scheduleGroups.remove(str);
        }
        Object objDeleteTriggers = this.store.deleteTriggers(list, continuation);
        return objDeleteTriggers == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteTriggers : Unit.INSTANCE;
    }
}
