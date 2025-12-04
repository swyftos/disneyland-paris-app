package com.urbanairship.automation.remotedata;

import ch.qos.logback.core.joran.action.Action;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UAirship;
import com.urbanairship.automation.InAppAutomationRemoteDataStatus;
import com.urbanairship.automation.engine.AutomationEngineInterface;
import com.urbanairship.automation.limits.FrequencyLimitManager;
import com.urbanairship.remotedata.RemoteDataSource;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0002\u0010\"J\u0006\u0010$\u001a\u00020\u001fJ.\u0010%\u001a\u00020\u001f2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0082@¢\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020\u001fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/urbanairship/automation/remotedata/AutomationRemoteDataSubscriber;", "", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "remoteDataAccess", "Lcom/urbanairship/automation/remotedata/AutomationRemoteDataAccessInterface;", "engine", "Lcom/urbanairship/automation/engine/AutomationEngineInterface;", "frequencyLimitManager", "Lcom/urbanairship/automation/limits/FrequencyLimitManager;", "airshipSDKVersion", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/automation/remotedata/AutomationRemoteDataAccessInterface;Lcom/urbanairship/automation/engine/AutomationEngineInterface;Lcom/urbanairship/automation/limits/FrequencyLimitManager;Ljava/lang/String;Lkotlinx/coroutines/CoroutineDispatcher;)V", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "sourceInfoStore", "Lcom/urbanairship/automation/remotedata/AutomationSourceInfoStore;", "status", "Lcom/urbanairship/automation/InAppAutomationRemoteDataStatus;", "getStatus", "()Lcom/urbanairship/automation/InAppAutomationRemoteDataStatus;", "statusUpdates", "Lkotlinx/coroutines/flow/Flow;", "getStatusUpdates", "()Lkotlinx/coroutines/flow/Flow;", "subscriptionState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "processAutomations", "", "data", "Lcom/urbanairship/automation/remotedata/InAppRemoteData;", "(Lcom/urbanairship/automation/remotedata/InAppRemoteData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processConstraints", "subscribe", "syncAutomations", "payload", "Lcom/urbanairship/automation/remotedata/InAppRemoteData$Payload;", "source", "Lcom/urbanairship/remotedata/RemoteDataSource;", "current", "", "Lcom/urbanairship/automation/AutomationSchedule;", "(Lcom/urbanairship/automation/remotedata/InAppRemoteData$Payload;Lcom/urbanairship/remotedata/RemoteDataSource;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unsubscribe", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAutomationRemoteDataSubscriber.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationRemoteDataSubscriber.kt\ncom/urbanairship/automation/remotedata/AutomationRemoteDataSubscriber\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,149:1\n1855#2:150\n766#2:151\n857#2,2:152\n1856#2:154\n1603#2,9:155\n1855#2:164\n1856#2:166\n1612#2:167\n1789#2,3:168\n1549#2:171\n1620#2,3:172\n1549#2:175\n1620#2,3:176\n766#2:179\n857#2,2:180\n1549#2:182\n1620#2,3:183\n766#2:186\n857#2,2:187\n1#3:165\n*S KotlinDebug\n*F\n+ 1 AutomationRemoteDataSubscriber.kt\ncom/urbanairship/automation/remotedata/AutomationRemoteDataSubscriber\n*L\n74#1:150\n75#1:151\n75#1:152,2\n74#1:154\n82#1:155,9\n82#1:164\n82#1:166\n82#1:167\n83#1:168,3\n98#1:171\n98#1:172,3\n120#1:175\n120#1:176,3\n122#1:179\n122#1:180,2\n123#1:182\n123#1:183,3\n129#1:186\n129#1:187,2\n82#1:165\n*E\n"})
/* loaded from: classes5.dex */
public final class AutomationRemoteDataSubscriber {
    private final String airshipSDKVersion;
    private final AutomationEngineInterface engine;
    private final FrequencyLimitManager frequencyLimitManager;
    private final AutomationRemoteDataAccessInterface remoteDataAccess;
    private final CoroutineScope scope;
    private final AutomationSourceInfoStore sourceInfoStore;
    private final MutableStateFlow subscriptionState;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<RemoteDataSource> entries$0 = EnumEntriesKt.enumEntries(RemoteDataSource.values());
    }

    /* renamed from: com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$processAutomations$1, reason: invalid class name and case insensitive filesystem */
    static final class C10581 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C10581(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationRemoteDataSubscriber.this.processAutomations(null, this);
        }
    }

    /* renamed from: com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$processConstraints$1, reason: invalid class name and case insensitive filesystem */
    static final class C10591 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C10591(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationRemoteDataSubscriber.this.processConstraints(null, this);
        }
    }

    /* renamed from: com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$syncAutomations$1, reason: invalid class name and case insensitive filesystem */
    static final class C10601 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C10601(Continuation continuation) {
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
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AutomationRemoteDataSubscriber(PreferenceDataStore preferenceDataStore, AutomationRemoteDataAccessInterface automationRemoteDataAccessInterface, AutomationEngineInterface automationEngineInterface, FrequencyLimitManager frequencyLimitManager, String str, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 16) != 0) {
            str = UAirship.getVersion();
            Intrinsics.checkNotNullExpressionValue(str, "getVersion(...)");
        }
        this(preferenceDataStore, automationRemoteDataAccessInterface, automationEngineInterface, frequencyLimitManager, str, (i & 32) != 0 ? AirshipDispatchers.INSTANCE.getIO() : coroutineDispatcher);
    }

    /* renamed from: com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AutomationRemoteDataSubscriber.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

                    /* renamed from: com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$1$1$1, reason: invalid class name and collision with other inner class name */
                    static final class C01401 extends SuspendLambda implements Function2 {
                        int label;
                        final /* synthetic */ AutomationRemoteDataSubscriber this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C01401(AutomationRemoteDataSubscriber automationRemoteDataSubscriber, Continuation continuation) {
                            super(2, continuation);
                            this.this$0 = automationRemoteDataSubscriber;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            return new C01401(this.this$0, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                            return ((C01401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* renamed from: com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$1$1$1$1, reason: invalid class name and collision with other inner class name */
                        static final class C01411 implements FlowCollector {
                            final /* synthetic */ AutomationRemoteDataSubscriber this$0;

                            C01411(AutomationRemoteDataSubscriber automationRemoteDataSubscriber) {
                                this.this$0 = automationRemoteDataSubscriber;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct code enable 'Show inconsistent code' option in preferences
                            */
                            public final java.lang.Object emit(com.urbanairship.automation.remotedata.InAppRemoteData r6, kotlin.coroutines.Continuation r7) {
                                /*
                                    r5 = this;
                                    boolean r0 = r7 instanceof com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$1$1$1$1$emit$1
                                    if (r0 == 0) goto L13
                                    r0 = r7
                                    com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$1$1$1$1$emit$1 r0 = (com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$1$1$1$1$emit$1) r0
                                    int r1 = r0.label
                                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                    r3 = r1 & r2
                                    if (r3 == 0) goto L13
                                    int r1 = r1 - r2
                                    r0.label = r1
                                    goto L18
                                L13:
                                    com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$1$1$1$1$emit$1 r0 = new com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$1$1$1$1$emit$1
                                    r0.<init>(r5, r7)
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
                                    goto L6e
                                L2c:
                                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                    r5.<init>(r6)
                                    throw r5
                                L34:
                                    java.lang.Object r5 = r0.L$1
                                    r6 = r5
                                    com.urbanairship.automation.remotedata.InAppRemoteData r6 = (com.urbanairship.automation.remotedata.InAppRemoteData) r6
                                    java.lang.Object r5 = r0.L$0
                                    com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$1$1$1$1 r5 = (com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber.AnonymousClass1.C01391.C01401.C01411) r5
                                    kotlin.ResultKt.throwOnFailure(r7)
                                    goto L53
                                L41:
                                    kotlin.ResultKt.throwOnFailure(r7)
                                    com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber r7 = r5.this$0
                                    r0.L$0 = r5
                                    r0.L$1 = r6
                                    r0.label = r4
                                    java.lang.Object r7 = com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber.access$processConstraints(r7, r6, r0)
                                    if (r7 != r1) goto L53
                                    return r1
                                L53:
                                    java.lang.Boolean r7 = (java.lang.Boolean) r7
                                    boolean r7 = r7.booleanValue()
                                    if (r7 != 0) goto L5e
                                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                                    return r5
                                L5e:
                                    com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber r5 = r5.this$0
                                    r7 = 0
                                    r0.L$0 = r7
                                    r0.L$1 = r7
                                    r0.label = r3
                                    java.lang.Object r5 = com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber.access$processAutomations(r5, r6, r0)
                                    if (r5 != r1) goto L6e
                                    return r1
                                L6e:
                                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                                    return r5
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber.AnonymousClass1.C01391.C01401.C01411.emit(com.urbanairship.automation.remotedata.InAppRemoteData, kotlin.coroutines.Continuation):java.lang.Object");
                            }
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                Flow<InAppRemoteData> updatesFlow = this.this$0.remoteDataAccess.getUpdatesFlow();
                                C01411 c01411 = new C01411(this.this$0);
                                this.label = 1;
                                if (updatesFlow.collect(c01411, this) == coroutine_suspended) {
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
                            objectRef.element = BuildersKt__Builders_commonKt.launch$default(automationRemoteDataSubscriber.scope, null, null, new C01401(automationRemoteDataSubscriber, null), 3, null);
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
    /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processAutomations(com.urbanairship.automation.remotedata.InAppRemoteData r11, kotlin.coroutines.Continuation r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber.C10581
            if (r0 == 0) goto L13
            r0 = r12
            com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$processAutomations$1 r0 = (com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber.C10581) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$processAutomations$1 r0 = new com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$processAutomations$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L51
            if (r2 == r4) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r10 = r0.L$3
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r11 = r0.L$2
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r2 = r0.L$1
            com.urbanairship.automation.remotedata.InAppRemoteData r2 = (com.urbanairship.automation.remotedata.InAppRemoteData) r2
            java.lang.Object r4 = r0.L$0
            com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber r4 = (com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber) r4
            kotlin.ResultKt.throwOnFailure(r12)
            goto L6f
        L3c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L44:
            java.lang.Object r10 = r0.L$1
            r11 = r10
            com.urbanairship.automation.remotedata.InAppRemoteData r11 = (com.urbanairship.automation.remotedata.InAppRemoteData) r11
            java.lang.Object r10 = r0.L$0
            com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber r10 = (com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber) r10
            kotlin.ResultKt.throwOnFailure(r12)
            goto L63
        L51:
            kotlin.ResultKt.throwOnFailure(r12)
            com.urbanairship.automation.engine.AutomationEngineInterface r12 = r10.engine
            r0.L$0 = r10
            r0.L$1 = r11
            r0.label = r4
            java.lang.Object r12 = r12.getSchedules(r0)
            if (r12 != r1) goto L63
            return r1
        L63:
            java.util.List r12 = (java.util.List) r12
            kotlin.enums.EnumEntries<com.urbanairship.remotedata.RemoteDataSource> r2 = com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber.EntriesMappings.entries$0
            java.util.Iterator r2 = r2.iterator()
            r4 = r10
            r10 = r2
            r2 = r11
            r11 = r12
        L6f:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto Lb8
            java.lang.Object r12 = r10.next()
            com.urbanairship.remotedata.RemoteDataSource r12 = (com.urbanairship.remotedata.RemoteDataSource) r12
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r6 = r11.iterator()
        L84:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L9d
            java.lang.Object r7 = r6.next()
            r8 = r7
            com.urbanairship.automation.AutomationSchedule r8 = (com.urbanairship.automation.AutomationSchedule) r8
            com.urbanairship.automation.remotedata.AutomationRemoteDataAccessInterface r9 = r4.remoteDataAccess
            com.urbanairship.remotedata.RemoteDataSource r8 = r9.sourceFor(r8)
            if (r8 != r12) goto L84
            r5.add(r7)
            goto L84
        L9d:
            java.util.Map r6 = r2.getPayload()
            java.lang.Object r6 = r6.get(r12)
            com.urbanairship.automation.remotedata.InAppRemoteData$Payload r6 = (com.urbanairship.automation.remotedata.InAppRemoteData.Payload) r6
            r0.L$0 = r4
            r0.L$1 = r2
            r0.L$2 = r11
            r0.L$3 = r10
            r0.label = r3
            java.lang.Object r12 = r4.syncAutomations(r6, r12, r5, r0)
            if (r12 != r1) goto L6f
            return r1
        Lb8:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber.processAutomations(com.urbanairship.automation.remotedata.InAppRemoteData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processConstraints(com.urbanairship.automation.remotedata.InAppRemoteData r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber.C10591
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$processConstraints$1 r0 = (com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber.C10591) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$processConstraints$1 r0 = new com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$processConstraints$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r4 = r6.getValue()
            goto L89
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.Map r5 = r5.getPayload()
            java.util.Collection r5 = r5.values()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r5 = r5.iterator()
        L4b:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L65
            java.lang.Object r2 = r5.next()
            com.urbanairship.automation.remotedata.InAppRemoteData$Payload r2 = (com.urbanairship.automation.remotedata.InAppRemoteData.Payload) r2
            com.urbanairship.automation.remotedata.InAppRemoteData$Data r2 = r2.getData()
            java.util.List r2 = r2.getConstraints()
            if (r2 == 0) goto L4b
            r6.add(r2)
            goto L4b
        L65:
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
            java.util.Iterator r6 = r6.iterator()
        L6d:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L7e
            java.lang.Object r2 = r6.next()
            java.util.List r2 = (java.util.List) r2
            java.util.List r5 = kotlin.collections.CollectionsKt.plus(r5, r2)
            goto L6d
        L7e:
            com.urbanairship.automation.limits.FrequencyLimitManager r4 = r4.frequencyLimitManager
            r0.label = r3
            java.lang.Object r4 = r4.m2816setConstraintsgIAlus(r5, r0)
            if (r4 != r1) goto L89
            return r1
        L89:
            boolean r5 = kotlin.Result.m2973isFailureimpl(r4)
            if (r5 == 0) goto L98
            com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$processConstraints$2 r5 = new com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber$processConstraints$2
            r5.<init>()
            r6 = 0
            com.urbanairship.UALog.d$default(r6, r5, r3, r6)
        L98:
            boolean r4 = kotlin.Result.m2974isSuccessimpl(r4)
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber.processConstraints(com.urbanairship.automation.remotedata.InAppRemoteData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object syncAutomations(com.urbanairship.automation.remotedata.InAppRemoteData.Payload r17, com.urbanairship.remotedata.RemoteDataSource r18, java.util.List r19, kotlin.coroutines.Continuation r20) {
        /*
            Method dump skipped, instructions count: 492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber.syncAutomations(com.urbanairship.automation.remotedata.InAppRemoteData$Payload, com.urbanairship.remotedata.RemoteDataSource, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
