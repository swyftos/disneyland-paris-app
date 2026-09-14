package com.urbanairship.automation.remotedata;

import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.automation.AutomationScheduleKt;
import com.urbanairship.automation.InAppAutomationRemoteDataStatus;
import com.urbanairship.automation.engine.AutomationEngineInterface;
import com.urbanairship.automation.limits.FrequencyConstraint;
import com.urbanairship.automation.limits.FrequencyLimitManager;
import com.urbanairship.remotedata.RemoteDataInfo;
import com.urbanairship.remotedata.RemoteDataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0002\u0010\"J\u0006\u0010$\u001a\u00020\u001fJ.\u0010%\u001a\u00020\u001f2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0082@¢\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020\u001fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, m1836d2 = {"Lcom/urbanairship/automation/remotedata/AutomationRemoteDataSubscriber;", "", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "remoteDataAccess", "Lcom/urbanairship/automation/remotedata/AutomationRemoteDataAccessInterface;", "engine", "Lcom/urbanairship/automation/engine/AutomationEngineInterface;", "frequencyLimitManager", "Lcom/urbanairship/automation/limits/FrequencyLimitManager;", "airshipSDKVersion", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/automation/remotedata/AutomationRemoteDataAccessInterface;Lcom/urbanairship/automation/engine/AutomationEngineInterface;Lcom/urbanairship/automation/limits/FrequencyLimitManager;Ljava/lang/String;Lkotlinx/coroutines/CoroutineDispatcher;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sourceInfoStore", "Lcom/urbanairship/automation/remotedata/AutomationSourceInfoStore;", "status", "Lcom/urbanairship/automation/InAppAutomationRemoteDataStatus;", "getStatus", "()Lcom/urbanairship/automation/InAppAutomationRemoteDataStatus;", "statusUpdates", "Lkotlinx/coroutines/flow/Flow;", "getStatusUpdates", "()Lkotlinx/coroutines/flow/Flow;", "subscriptionState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "processAutomations", "", "data", "Lcom/urbanairship/automation/remotedata/InAppRemoteData;", "(Lcom/urbanairship/automation/remotedata/InAppRemoteData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processConstraints", "subscribe", "syncAutomations", "payload", "Lcom/urbanairship/automation/remotedata/InAppRemoteData$Payload;", "source", "Lcom/urbanairship/remotedata/RemoteDataSource;", "current", "", "Lcom/urbanairship/automation/AutomationSchedule;", "(Lcom/urbanairship/automation/remotedata/InAppRemoteData$Payload;Lcom/urbanairship/remotedata/RemoteDataSource;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unsubscribe", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nAutomationRemoteDataSubscriber.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationRemoteDataSubscriber.kt\ncom/urbanairship/automation/remotedata/AutomationRemoteDataSubscriber\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,149:1\n1855#2:150\n766#2:151\n857#2,2:152\n1856#2:154\n1603#2,9:155\n1855#2:164\n1856#2:166\n1612#2:167\n1789#2,3:168\n1549#2:171\n1620#2,3:172\n1549#2:175\n1620#2,3:176\n766#2:179\n857#2,2:180\n1549#2:182\n1620#2,3:183\n766#2:186\n857#2,2:187\n1#3:165\n*S KotlinDebug\n*F\n+ 1 AutomationRemoteDataSubscriber.kt\ncom/urbanairship/automation/remotedata/AutomationRemoteDataSubscriber\n*L\n74#1:150\n75#1:151\n75#1:152,2\n74#1:154\n82#1:155,9\n82#1:164\n82#1:166\n82#1:167\n83#1:168,3\n98#1:171\n98#1:172,3\n120#1:175\n120#1:176,3\n122#1:179\n122#1:180,2\n123#1:182\n123#1:183,3\n129#1:186\n129#1:187,2\n82#1:165\n*E\n"})
public final class AutomationRemoteDataSubscriber {
    private final String airshipSDKVersion;
    private final AutomationEngineInterface engine;
    private final FrequencyLimitManager frequencyLimitManager;
    private final AutomationRemoteDataAccessInterface remoteDataAccess;
    private final CoroutineScope scope;
    private final AutomationSourceInfoStore sourceInfoStore;
    private final MutableStateFlow subscriptionState;

    @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<RemoteDataSource> entries$0 = EnumEntriesKt.enumEntries(RemoteDataSource.values());
    }

    /* JADX INFO: renamed from: com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$processAutomations$1 */
    static final class C51281 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C51281(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationRemoteDataSubscriber.this.processAutomations(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$processConstraints$1 */
    static final class C51291 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C51291(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationRemoteDataSubscriber.this.processConstraints(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$syncAutomations$1 */
    static final class C51311 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C51311(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationRemoteDataSubscriber.this.syncAutomations(null, null, null, this);
        }
    }

    public AutomationRemoteDataSubscriber(@NotNull PreferenceDataStore dataStore, @NotNull AutomationRemoteDataAccessInterface remoteDataAccess, @NotNull AutomationEngineInterface engine, @NotNull FrequencyLimitManager frequencyLimitManager, @NotNull String airshipSDKVersion, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(remoteDataAccess, "remoteDataAccess");
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(frequencyLimitManager, "frequencyLimitManager");
        Intrinsics.checkNotNullParameter(airshipSDKVersion, "airshipSDKVersion");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.remoteDataAccess = remoteDataAccess;
        this.engine = engine;
        this.frequencyLimitManager = frequencyLimitManager;
        this.airshipSDKVersion = airshipSDKVersion;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.scope = CoroutineScope;
        this.sourceInfoStore = new AutomationSourceInfoStore(dataStore);
        this.subscriptionState = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new C51271(null), 3, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AutomationRemoteDataSubscriber(PreferenceDataStore preferenceDataStore, AutomationRemoteDataAccessInterface automationRemoteDataAccessInterface, AutomationEngineInterface automationEngineInterface, FrequencyLimitManager frequencyLimitManager, String str, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 16) != 0) {
            str = UAirship.getVersion();
            Intrinsics.checkNotNullExpressionValue(str, "getVersion(...)");
        }
        this(preferenceDataStore, automationRemoteDataAccessInterface, automationEngineInterface, frequencyLimitManager, str, (i & 32) != 0 ? AirshipDispatchers.INSTANCE.getIO() : coroutineDispatcher);
    }

    /* JADX INFO: renamed from: com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$1 */
    static final class C51271 extends SuspendLambda implements Function2 {
        int label;

        C51271(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AutomationRemoteDataSubscriber.this.new C51271(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C51271) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                MutableStateFlow mutableStateFlow = AutomationRemoteDataSubscriber.this.subscriptionState;
                final AutomationRemoteDataSubscriber automationRemoteDataSubscriber = AutomationRemoteDataSubscriber.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), continuation);
                    }

                    /* JADX INFO: renamed from: com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$1$1$1, reason: invalid class name and collision with other inner class name */
                    static final class C81651 extends SuspendLambda implements Function2 {
                        int label;
                        final /* synthetic */ AutomationRemoteDataSubscriber this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C81651(AutomationRemoteDataSubscriber automationRemoteDataSubscriber, Continuation continuation) {
                            super(2, continuation);
                            this.this$0 = automationRemoteDataSubscriber;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            return new C81651(this.this$0, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                            return ((C81651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX INFO: renamed from: com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$1$1$1$1, reason: invalid class name and collision with other inner class name */
                        static final class C81661 implements FlowCollector {
                            final /* synthetic */ AutomationRemoteDataSubscriber this$0;

                            C81661(AutomationRemoteDataSubscriber automationRemoteDataSubscriber) {
                                this.this$0 = automationRemoteDataSubscriber;
                            }

                            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            public final Object emit(InAppRemoteData inAppRemoteData, Continuation continuation) {
                                AutomationRemoteDataSubscriber$1$1$1$1$emit$1 automationRemoteDataSubscriber$1$1$1$1$emit$1;
                                if (continuation instanceof AutomationRemoteDataSubscriber$1$1$1$1$emit$1) {
                                    automationRemoteDataSubscriber$1$1$1$1$emit$1 = (AutomationRemoteDataSubscriber$1$1$1$1$emit$1) continuation;
                                    int i = automationRemoteDataSubscriber$1$1$1$1$emit$1.label;
                                    if ((i & Integer.MIN_VALUE) != 0) {
                                        automationRemoteDataSubscriber$1$1$1$1$emit$1.label = i - Integer.MIN_VALUE;
                                    } else {
                                        automationRemoteDataSubscriber$1$1$1$1$emit$1 = new AutomationRemoteDataSubscriber$1$1$1$1$emit$1(this, continuation);
                                    }
                                } else {
                                    automationRemoteDataSubscriber$1$1$1$1$emit$1 = new AutomationRemoteDataSubscriber$1$1$1$1$emit$1(this, continuation);
                                }
                                Object objProcessConstraints = automationRemoteDataSubscriber$1$1$1$1$emit$1.result;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i2 = automationRemoteDataSubscriber$1$1$1$1$emit$1.label;
                                if (i2 == 0) {
                                    ResultKt.throwOnFailure(objProcessConstraints);
                                    AutomationRemoteDataSubscriber automationRemoteDataSubscriber = this.this$0;
                                    automationRemoteDataSubscriber$1$1$1$1$emit$1.L$0 = this;
                                    automationRemoteDataSubscriber$1$1$1$1$emit$1.L$1 = inAppRemoteData;
                                    automationRemoteDataSubscriber$1$1$1$1$emit$1.label = 1;
                                    objProcessConstraints = automationRemoteDataSubscriber.processConstraints(inAppRemoteData, automationRemoteDataSubscriber$1$1$1$1$emit$1);
                                    if (objProcessConstraints == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i2 == 1) {
                                        inAppRemoteData = (InAppRemoteData) automationRemoteDataSubscriber$1$1$1$1$emit$1.L$1;
                                        this = (C81661) automationRemoteDataSubscriber$1$1$1$1$emit$1.L$0;
                                        ResultKt.throwOnFailure(objProcessConstraints);
                                    } else {
                                        if (i2 != 2) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(objProcessConstraints);
                                    }
                                    return Unit.INSTANCE;
                                }
                                if (!((Boolean) objProcessConstraints).booleanValue()) {
                                    return Unit.INSTANCE;
                                }
                                AutomationRemoteDataSubscriber automationRemoteDataSubscriber2 = this.this$0;
                                automationRemoteDataSubscriber$1$1$1$1$emit$1.L$0 = null;
                                automationRemoteDataSubscriber$1$1$1$1$emit$1.L$1 = null;
                                automationRemoteDataSubscriber$1$1$1$1$emit$1.label = 2;
                                if (automationRemoteDataSubscriber2.processAutomations(inAppRemoteData, automationRemoteDataSubscriber$1$1$1$1$emit$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                Flow<InAppRemoteData> updatesFlow = this.this$0.remoteDataAccess.getUpdatesFlow();
                                C81661 c81661 = new C81661(this.this$0);
                                this.label = 1;
                                if (updatesFlow.collect(c81661, this) == coroutine_suspended) {
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

                    /* JADX WARN: Type inference failed for: r7v6, types: [T, kotlinx.coroutines.Job] */
                    public final Object emit(boolean z, Continuation continuation) {
                        if (z) {
                            objectRef.element = BuildersKt__Builders_commonKt.launch$default(automationRemoteDataSubscriber.scope, null, null, new C81651(automationRemoteDataSubscriber, null), 3, null);
                        } else {
                            Job job = (Job) objectRef.element;
                            if (job != null) {
                                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (mutableStateFlow.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    public final void subscribe() {
        this.subscriptionState.compareAndSet(Boolean.FALSE, Boolean.TRUE);
    }

    public final void unsubscribe() {
        this.subscriptionState.compareAndSet(Boolean.TRUE, Boolean.FALSE);
    }

    @NotNull
    public final InAppAutomationRemoteDataStatus getStatus() {
        return this.remoteDataAccess.getStatus();
    }

    @NotNull
    public final Flow<InAppAutomationRemoteDataStatus> getStatusUpdates() {
        return this.remoteDataAccess.getStatusUpdates();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0075  */
    /* JADX WARN: Code duplicated, block: B:25:0x008a  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:? A[LOOP:0: B:20:0x006f->B:36:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0099 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object processAutomations(InAppRemoteData inAppRemoteData, Continuation continuation) {
        C51281 c51281;
        AutomationRemoteDataSubscriber automationRemoteDataSubscriber;
        Iterator<RemoteDataSource> it;
        InAppRemoteData inAppRemoteData2;
        List list;
        RemoteDataSource next;
        ArrayList arrayList;
        InAppRemoteData.Payload payload;
        if (continuation instanceof C51281) {
            c51281 = (C51281) continuation;
            int i = c51281.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c51281.label = i - Integer.MIN_VALUE;
            } else {
                c51281 = new C51281(continuation);
            }
        } else {
            c51281 = new C51281(continuation);
        }
        Object schedules = c51281.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c51281.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(schedules);
            AutomationEngineInterface automationEngineInterface = this.engine;
            c51281.L$0 = this;
            c51281.L$1 = inAppRemoteData;
            c51281.label = 1;
            schedules = automationEngineInterface.getSchedules(c51281);
            if (schedules == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 == 1) {
                inAppRemoteData = (InAppRemoteData) c51281.L$1;
                this = (AutomationRemoteDataSubscriber) c51281.L$0;
                ResultKt.throwOnFailure(schedules);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) c51281.L$3;
                list = (List) c51281.L$2;
                inAppRemoteData2 = (InAppRemoteData) c51281.L$1;
                automationRemoteDataSubscriber = (AutomationRemoteDataSubscriber) c51281.L$0;
                ResultKt.throwOnFailure(schedules);
            }
            while (it.hasNext()) {
                next = it.next();
                arrayList = new ArrayList();
                for (Object obj : list) {
                    if (automationRemoteDataSubscriber.remoteDataAccess.sourceFor((AutomationSchedule) obj) == next) {
                        arrayList.add(obj);
                    }
                }
                payload = inAppRemoteData2.getPayload().get(next);
                c51281.L$0 = automationRemoteDataSubscriber;
                c51281.L$1 = inAppRemoteData2;
                c51281.L$2 = list;
                c51281.L$3 = it;
                c51281.label = 2;
                if (automationRemoteDataSubscriber.syncAutomations(payload, next, arrayList, c51281) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        automationRemoteDataSubscriber = this;
        it = EntriesMappings.entries$0.iterator();
        inAppRemoteData2 = inAppRemoteData;
        list = (List) schedules;
        while (it.hasNext()) {
            next = it.next();
            arrayList = new ArrayList();
            while (r6.hasNext()) {
                if (automationRemoteDataSubscriber.remoteDataAccess.sourceFor((AutomationSchedule) obj) == next) {
                    arrayList.add(obj);
                }
            }
            payload = inAppRemoteData2.getPayload().get(next);
            c51281.L$0 = automationRemoteDataSubscriber;
            c51281.L$1 = inAppRemoteData2;
            c51281.L$2 = list;
            c51281.L$3 = it;
            c51281.label = 2;
            if (automationRemoteDataSubscriber.syncAutomations(payload, next, arrayList, c51281) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object processConstraints(InAppRemoteData inAppRemoteData, Continuation continuation) {
        C51291 c51291;
        final Object objM5058setConstraintsgIAlus;
        if (continuation instanceof C51291) {
            c51291 = (C51291) continuation;
            int i = c51291.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c51291.label = i - Integer.MIN_VALUE;
            } else {
                c51291 = new C51291(continuation);
            }
        } else {
            c51291 = new C51291(continuation);
        }
        Object obj = c51291.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c51291.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Collection<InAppRemoteData.Payload> collectionValues = inAppRemoteData.getPayload().values();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                List<FrequencyConstraint> constraints = ((InAppRemoteData.Payload) it.next()).getData().getConstraints();
                if (constraints != null) {
                    arrayList.add(constraints);
                }
            }
            List<FrequencyConstraint> listEmptyList = CollectionsKt.emptyList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                listEmptyList = CollectionsKt.plus((Collection) listEmptyList, (Iterable) it2.next());
            }
            FrequencyLimitManager frequencyLimitManager = this.frequencyLimitManager;
            c51291.label = 1;
            objM5058setConstraintsgIAlus = frequencyLimitManager.m5058setConstraintsgIAlus(listEmptyList, c51291);
            if (objM5058setConstraintsgIAlus == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objM5058setConstraintsgIAlus = ((Result) obj).getValue();
        }
        if (Result.m5282isFailureimpl(objM5058setConstraintsgIAlus)) {
            UALog.d$default(null, new Function0() { // from class: com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber.processConstraints.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to process constraints " + Result.m5280exceptionOrNullimpl(objM5058setConstraintsgIAlus);
                }
            }, 1, null);
        }
        return Boxing.boxBoolean(Result.m5283isSuccessimpl(objM5058setConstraintsgIAlus));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public final Object syncAutomations(InAppRemoteData.Payload payload, RemoteDataSource remoteDataSource, List list, Continuation continuation) {
        C51311 c51311;
        List<String> arrayList;
        AutomationSourceInfo sourceInfo;
        InAppRemoteData.Payload payload2;
        String str;
        AutomationRemoteDataSubscriber automationRemoteDataSubscriber;
        AutomationSourceInfo automationSourceInfo;
        String str2;
        AutomationSourceInfo automationSourceInfo2;
        AutomationRemoteDataSubscriber automationRemoteDataSubscriber2;
        boolean zIsNewSchedule;
        RemoteDataSource remoteDataSource2 = remoteDataSource;
        if (continuation instanceof C51311) {
            c51311 = (C51311) continuation;
            int i = c51311.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c51311.label = i - Integer.MIN_VALUE;
            } else {
                c51311 = new C51311(continuation);
            }
        } else {
            c51311 = new C51311(continuation);
        }
        Object obj = c51311.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c51311.label;
        if (i2 != 0) {
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i2 == 2) {
                automationSourceInfo = (AutomationSourceInfo) c51311.L$6;
                automationSourceInfo2 = (AutomationSourceInfo) c51311.L$5;
                String str3 = (String) c51311.L$4;
                arrayList = (List) c51311.L$3;
                RemoteDataSource remoteDataSource3 = (RemoteDataSource) c51311.L$2;
                payload2 = (InAppRemoteData.Payload) c51311.L$1;
                automationRemoteDataSubscriber = (AutomationRemoteDataSubscriber) c51311.L$0;
                ResultKt.throwOnFailure(obj);
                str2 = str3;
                remoteDataSource2 = remoteDataSource3;
                sourceInfo = automationSourceInfo2;
                str = str2;
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                automationSourceInfo = (AutomationSourceInfo) c51311.L$3;
                str = (String) c51311.L$2;
                remoteDataSource2 = (RemoteDataSource) c51311.L$1;
                automationRemoteDataSubscriber2 = (AutomationRemoteDataSubscriber) c51311.L$0;
                ResultKt.throwOnFailure(obj);
            }
            automationRemoteDataSubscriber = automationRemoteDataSubscriber2;
            automationRemoteDataSubscriber.sourceInfoStore.setSourceInfo(automationSourceInfo, remoteDataSource2, str);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        arrayList = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((AutomationSchedule) it.next()).getIdentifier());
        }
        if (payload == null) {
            if (!arrayList.isEmpty()) {
                AutomationEngineInterface automationEngineInterface = this.engine;
                c51311.label = 1;
                if (automationEngineInterface.stopSchedules(arrayList, c51311) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        RemoteDataInfo remoteDataInfo = payload.getRemoteDataInfo();
        String contactId = remoteDataInfo != null ? remoteDataInfo.getContactId() : null;
        sourceInfo = this.sourceInfoStore.getSourceInfo(remoteDataSource2, contactId);
        AutomationSourceInfo automationSourceInfo3 = new AutomationSourceInfo(payload.getRemoteDataInfo(), payload.getTimestamp(), this.airshipSDKVersion);
        if (Intrinsics.areEqual(automationSourceInfo3, sourceInfo)) {
            return Unit.INSTANCE;
        }
        List<AutomationSchedule> schedules = payload.getData().getSchedules();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(schedules, 10));
        Iterator<T> it2 = schedules.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((AutomationSchedule) it2.next()).getIdentifier());
        }
        Set set = CollectionsKt.toSet(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            if (!set.contains(((AutomationSchedule) obj2).getIdentifier())) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            arrayList4.add(((AutomationSchedule) it3.next()).getIdentifier());
        }
        if (arrayList4.isEmpty()) {
            payload2 = payload;
            str = contactId;
            automationRemoteDataSubscriber = this;
            automationSourceInfo = automationSourceInfo3;
        } else {
            AutomationEngineInterface automationEngineInterface2 = this.engine;
            c51311.L$0 = this;
            c51311.L$1 = payload;
            c51311.L$2 = remoteDataSource2;
            c51311.L$3 = arrayList;
            c51311.L$4 = contactId;
            c51311.L$5 = sourceInfo;
            c51311.L$6 = automationSourceInfo3;
            c51311.label = 2;
            if (automationEngineInterface2.stopSchedules(arrayList4, c51311) == coroutine_suspended) {
                return coroutine_suspended;
            }
            payload2 = payload;
            str2 = contactId;
            automationSourceInfo2 = sourceInfo;
            automationRemoteDataSubscriber = this;
            automationSourceInfo = automationSourceInfo3;
            sourceInfo = automationSourceInfo2;
            str = str2;
        }
        List<AutomationSchedule> schedules2 = payload2.getData().getSchedules();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj3 : schedules2) {
            AutomationSchedule automationSchedule = (AutomationSchedule) obj3;
            if (arrayList.contains(automationSchedule.getIdentifier())) {
                zIsNewSchedule = true;
            } else {
                zIsNewSchedule = AutomationScheduleKt.isNewSchedule(automationSchedule, sourceInfo != null ? sourceInfo.getPayloadTimestamp() : 0L, sourceInfo != null ? sourceInfo.getAirshipSDKVersion() : null);
            }
            if (zIsNewSchedule) {
                arrayList5.add(obj3);
            }
        }
        if (!arrayList5.isEmpty()) {
            AutomationEngineInterface automationEngineInterface3 = automationRemoteDataSubscriber.engine;
            c51311.L$0 = automationRemoteDataSubscriber;
            c51311.L$1 = remoteDataSource2;
            c51311.L$2 = str;
            c51311.L$3 = automationSourceInfo;
            c51311.L$4 = null;
            c51311.L$5 = null;
            c51311.L$6 = null;
            c51311.label = 3;
            if (automationEngineInterface3.upsertSchedules(arrayList5, c51311) == coroutine_suspended) {
                return coroutine_suspended;
            }
            automationRemoteDataSubscriber2 = automationRemoteDataSubscriber;
            automationRemoteDataSubscriber = automationRemoteDataSubscriber2;
        }
        automationRemoteDataSubscriber.sourceInfoStore.setSourceInfo(automationSourceInfo, remoteDataSource2, str);
        return Unit.INSTANCE;
    }
}
