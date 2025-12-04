package com.urbanairship.iam;

import android.content.Context;
import ch.qos.logback.core.joran.action.Action;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.UALog;
import com.urbanairship.automation.engine.AutomationExecutorDelegate;
import com.urbanairship.automation.engine.PreparedScheduleInfo;
import com.urbanairship.automation.engine.ScheduleExecuteResult;
import com.urbanairship.automation.engine.ScheduleReadyResult;
import com.urbanairship.automation.utils.ScheduleConditionsChangedNotifier;
import com.urbanairship.iam.adapter.DisplayResult;
import com.urbanairship.iam.analytics.InAppMessageAnalyticsFactory;
import com.urbanairship.iam.assets.AssetCacheManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010!J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010$\u001a\u00020%R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/urbanairship/iam/InAppMessageAutomationExecutor;", "Lcom/urbanairship/automation/engine/AutomationExecutorDelegate;", "Lcom/urbanairship/iam/PreparedInAppMessageData;", "context", "Landroid/content/Context;", "assetManager", "Lcom/urbanairship/iam/assets/AssetCacheManager;", "analyticsFactory", "Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsFactory;", "scheduleConditionsChangedNotifier", "Lcom/urbanairship/automation/utils/ScheduleConditionsChangedNotifier;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/urbanairship/iam/assets/AssetCacheManager;Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsFactory;Lcom/urbanairship/automation/utils/ScheduleConditionsChangedNotifier;Lkotlinx/coroutines/CoroutineDispatcher;)V", "value", "Lcom/urbanairship/iam/InAppMessageDisplayDelegate;", "displayDelegate", "getDisplayDelegate", "()Lcom/urbanairship/iam/InAppMessageDisplayDelegate;", "setDisplayDelegate", "(Lcom/urbanairship/iam/InAppMessageDisplayDelegate;)V", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "execute", "Lcom/urbanairship/automation/engine/ScheduleExecuteResult;", "data", "preparedScheduleInfo", "Lcom/urbanairship/automation/engine/PreparedScheduleInfo;", "(Lcom/urbanairship/iam/PreparedInAppMessageData;Lcom/urbanairship/automation/engine/PreparedScheduleInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "interrupted", "Lcom/urbanairship/automation/engine/InterruptedBehavior;", "schedule", "Lcom/urbanairship/automation/AutomationSchedule;", "(Lcom/urbanairship/automation/AutomationSchedule;Lcom/urbanairship/automation/engine/PreparedScheduleInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isReady", "Lcom/urbanairship/automation/engine/ScheduleReadyResult;", "notifyDisplayConditionsChanged", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInAppMessageAutomationExecutor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppMessageAutomationExecutor.kt\ncom/urbanairship/iam/InAppMessageAutomationExecutor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,162:1\n1#2:163\n*E\n"})
/* loaded from: classes5.dex */
public final class InAppMessageAutomationExecutor implements AutomationExecutorDelegate<PreparedInAppMessageData> {
    private final InAppMessageAnalyticsFactory analyticsFactory;
    private final AssetCacheManager assetManager;
    private final Context context;
    private InAppMessageDisplayDelegate displayDelegate;
    private final ScheduleConditionsChangedNotifier scheduleConditionsChangedNotifier;
    private final CoroutineScope scope;

    /* renamed from: com.urbanairship.iam.InAppMessageAutomationExecutor$interrupted$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppMessageAutomationExecutor.this.interrupted(null, null, this);
        }
    }

    public InAppMessageAutomationExecutor(@NotNull Context context, @NotNull AssetCacheManager assetManager, @NotNull InAppMessageAnalyticsFactory analyticsFactory, @NotNull ScheduleConditionsChangedNotifier scheduleConditionsChangedNotifier, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics.checkNotNullParameter(analyticsFactory, "analyticsFactory");
        Intrinsics.checkNotNullParameter(scheduleConditionsChangedNotifier, "scheduleConditionsChangedNotifier");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.context = context;
        this.assetManager = assetManager;
        this.analyticsFactory = analyticsFactory;
        this.scheduleConditionsChangedNotifier = scheduleConditionsChangedNotifier;
        this.scope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    @Override // com.urbanairship.automation.engine.AutomationExecutorDelegate
    public /* bridge */ /* synthetic */ Object execute(PreparedInAppMessageData preparedInAppMessageData, PreparedScheduleInfo preparedScheduleInfo, Continuation continuation) {
        return execute2(preparedInAppMessageData, preparedScheduleInfo, (Continuation<? super ScheduleExecuteResult>) continuation);
    }

    public /* synthetic */ InAppMessageAutomationExecutor(Context context, AssetCacheManager assetCacheManager, InAppMessageAnalyticsFactory inAppMessageAnalyticsFactory, ScheduleConditionsChangedNotifier scheduleConditionsChangedNotifier, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, assetCacheManager, inAppMessageAnalyticsFactory, scheduleConditionsChangedNotifier, (i & 16) != 0 ? AirshipDispatchers.INSTANCE.getIO() : coroutineDispatcher);
    }

    @Nullable
    public final InAppMessageDisplayDelegate getDisplayDelegate() {
        InAppMessageDisplayDelegate inAppMessageDisplayDelegate;
        synchronized (this) {
            inAppMessageDisplayDelegate = this.displayDelegate;
        }
        return inAppMessageDisplayDelegate;
    }

    public final void setDisplayDelegate(@Nullable InAppMessageDisplayDelegate inAppMessageDisplayDelegate) {
        synchronized (this) {
            this.displayDelegate = inAppMessageDisplayDelegate;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.urbanairship.automation.engine.AutomationExecutorDelegate
    @NotNull
    public ScheduleReadyResult isReady(@NotNull PreparedInAppMessageData data, @NotNull final PreparedScheduleInfo preparedScheduleInfo) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(preparedScheduleInfo, "preparedScheduleInfo");
        if (!data.getDisplayAdapter().isReady().getValue().booleanValue()) {
            UALog.i$default(null, new Function0() { // from class: com.urbanairship.iam.InAppMessageAutomationExecutor.isReady.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Schedule " + preparedScheduleInfo.getScheduleId$urbanairship_automation_release() + " display adapter not ready";
                }
            }, 1, null);
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C11312(data, this, null), 3, null);
            return ScheduleReadyResult.NOT_READY;
        }
        if (!data.getDisplayCoordinator().isReady().getValue().booleanValue()) {
            UALog.i$default(null, new Function0() { // from class: com.urbanairship.iam.InAppMessageAutomationExecutor.isReady.3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Schedule " + preparedScheduleInfo.getScheduleId$urbanairship_automation_release() + " display coordinator not ready";
                }
            }, 1, null);
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass4(data, this, null), 3, null);
            return ScheduleReadyResult.NOT_READY;
        }
        InAppMessageDisplayDelegate displayDelegate = getDisplayDelegate();
        if (!(displayDelegate != null ? displayDelegate.isMessageReadyToDisplay(data.getMessage(), preparedScheduleInfo.getScheduleId$urbanairship_automation_release()) : true)) {
            UALog.i$default(null, new Function0() { // from class: com.urbanairship.iam.InAppMessageAutomationExecutor.isReady.5
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Schedule " + preparedScheduleInfo.getScheduleId$urbanairship_automation_release() + " InAppMessageDisplayDelegate not ready";
                }
            }, 1, null);
            return ScheduleReadyResult.NOT_READY;
        }
        return ScheduleReadyResult.READY;
    }

    /* renamed from: com.urbanairship.iam.InAppMessageAutomationExecutor$isReady$2, reason: invalid class name and case insensitive filesystem */
    static final class C11312 extends SuspendLambda implements Function2 {
        final /* synthetic */ PreparedInAppMessageData $data;
        int label;
        final /* synthetic */ InAppMessageAutomationExecutor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11312(PreparedInAppMessageData preparedInAppMessageData, InAppMessageAutomationExecutor inAppMessageAutomationExecutor, Continuation continuation) {
            super(2, continuation);
            this.$data = preparedInAppMessageData;
            this.this$0 = inAppMessageAutomationExecutor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C11312(this.$data, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11312) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* renamed from: com.urbanairship.iam.InAppMessageAutomationExecutor$isReady$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2 {
            /* synthetic */ boolean Z$0;
            int label;

            AnonymousClass1(Continuation continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.Z$0 = ((Boolean) obj).booleanValue();
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
            }

            public final Object invoke(boolean z, Continuation continuation) {
                return ((AnonymousClass1) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(this.Z$0);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<Boolean> stateFlowIsReady = this.$data.getDisplayAdapter().isReady();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
                this.label = 1;
                if (FlowKt.first(stateFlowIsReady, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.scheduleConditionsChangedNotifier.notifyChanged$urbanairship_automation_release();
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.urbanairship.iam.InAppMessageAutomationExecutor$isReady$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function2 {
        final /* synthetic */ PreparedInAppMessageData $data;
        int label;
        final /* synthetic */ InAppMessageAutomationExecutor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(PreparedInAppMessageData preparedInAppMessageData, InAppMessageAutomationExecutor inAppMessageAutomationExecutor, Continuation continuation) {
            super(2, continuation);
            this.$data = preparedInAppMessageData;
            this.this$0 = inAppMessageAutomationExecutor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass4(this.$data, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* renamed from: com.urbanairship.iam.InAppMessageAutomationExecutor$isReady$4$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2 {
            /* synthetic */ boolean Z$0;
            int label;

            AnonymousClass1(Continuation continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.Z$0 = ((Boolean) obj).booleanValue();
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
            }

            public final Object invoke(boolean z, Continuation continuation) {
                return ((AnonymousClass1) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(this.Z$0);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<Boolean> stateFlowIsReady = this.$data.getDisplayCoordinator().isReady();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
                this.label = 1;
                if (FlowKt.first(stateFlowIsReady, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.scheduleConditionsChangedNotifier.notifyChanged$urbanairship_automation_release();
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.urbanairship.iam.InAppMessageAutomationExecutor$execute$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ PreparedInAppMessageData $data;
        final /* synthetic */ PreparedScheduleInfo $preparedScheduleInfo;
        Object L$0;
        int label;
        final /* synthetic */ InAppMessageAutomationExecutor this$0;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* renamed from: com.urbanairship.iam.InAppMessageAutomationExecutor$execute$2$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DisplayResult.values().length];
                try {
                    iArr[DisplayResult.CANCEL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DisplayResult.FINISHED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PreparedScheduleInfo preparedScheduleInfo, PreparedInAppMessageData preparedInAppMessageData, InAppMessageAutomationExecutor inAppMessageAutomationExecutor, Continuation continuation) {
            super(2, continuation);
            this.$preparedScheduleInfo = preparedScheduleInfo;
            this.$data = preparedInAppMessageData;
            this.this$0 = inAppMessageAutomationExecutor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.$preparedScheduleInfo, this.$data, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x013b  */
        /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                Method dump skipped, instructions count: 341
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.InAppMessageAutomationExecutor.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Nullable
    /* renamed from: execute, reason: avoid collision after fix types in other method */
    public Object execute2(@NotNull PreparedInAppMessageData preparedInAppMessageData, @NotNull PreparedScheduleInfo preparedScheduleInfo, @NotNull Continuation<? super ScheduleExecuteResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new AnonymousClass2(preparedScheduleInfo, preparedInAppMessageData, this, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.urbanairship.automation.engine.AutomationExecutorDelegate
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object interrupted(@org.jetbrains.annotations.NotNull com.urbanairship.automation.AutomationSchedule r6, @org.jetbrains.annotations.NotNull com.urbanairship.automation.engine.PreparedScheduleInfo r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.automation.engine.InterruptedBehavior> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.urbanairship.iam.InAppMessageAutomationExecutor.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.urbanairship.iam.InAppMessageAutomationExecutor$interrupted$1 r0 = (com.urbanairship.iam.InAppMessageAutomationExecutor.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.iam.InAppMessageAutomationExecutor$interrupted$1 r0 = new com.urbanairship.iam.InAppMessageAutomationExecutor$interrupted$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r8)
            goto L97
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.L$1
            r7 = r5
            com.urbanairship.automation.engine.PreparedScheduleInfo r7 = (com.urbanairship.automation.engine.PreparedScheduleInfo) r7
            java.lang.Object r5 = r0.L$0
            com.urbanairship.iam.InAppMessageAutomationExecutor r5 = (com.urbanairship.iam.InAppMessageAutomationExecutor) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L78
        L41:
            kotlin.ResultKt.throwOnFailure(r8)
            com.urbanairship.automation.AutomationSchedule$ScheduleData r8 = r6.getData()
            boolean r8 = r8 instanceof com.urbanairship.automation.AutomationSchedule.ScheduleData.InAppMessageData
            if (r8 == 0) goto L9a
            com.urbanairship.automation.AutomationSchedule$ScheduleData r8 = r6.getData()
            com.urbanairship.automation.AutomationSchedule$ScheduleData$InAppMessageData r8 = (com.urbanairship.automation.AutomationSchedule.ScheduleData.InAppMessageData) r8
            com.urbanairship.iam.InAppMessage r8 = r8.getMessage()
            boolean r8 = r8.isEmbedded$urbanairship_automation_release()
            if (r8 == 0) goto L5f
            com.urbanairship.automation.engine.InterruptedBehavior r5 = com.urbanairship.automation.engine.InterruptedBehavior.RETRY
            return r5
        L5f:
            com.urbanairship.iam.analytics.InAppMessageAnalyticsFactory r8 = r5.analyticsFactory
            com.urbanairship.automation.AutomationSchedule$ScheduleData r6 = r6.getData()
            com.urbanairship.automation.AutomationSchedule$ScheduleData$InAppMessageData r6 = (com.urbanairship.automation.AutomationSchedule.ScheduleData.InAppMessageData) r6
            com.urbanairship.iam.InAppMessage r6 = r6.getMessage()
            r0.L$0 = r5
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r8.makeAnalytics(r6, r7, r0)
            if (r8 != r1) goto L78
            return r1
        L78:
            com.urbanairship.iam.analytics.InAppMessageAnalyticsInterface r8 = (com.urbanairship.iam.analytics.InAppMessageAnalyticsInterface) r8
            com.urbanairship.iam.analytics.events.InAppResolutionEvent$Companion r6 = com.urbanairship.iam.analytics.events.InAppResolutionEvent.INSTANCE
            com.urbanairship.iam.analytics.events.InAppResolutionEvent r6 = r6.interrupted()
            r2 = 0
            r8.recordEvent(r6, r2)
            com.urbanairship.iam.assets.AssetCacheManager r5 = r5.assetManager
            java.lang.String r6 = r7.getScheduleId$urbanairship_automation_release()
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r5 = r5.clearCache(r6, r0)
            if (r5 != r1) goto L97
            return r1
        L97:
            com.urbanairship.automation.engine.InterruptedBehavior r5 = com.urbanairship.automation.engine.InterruptedBehavior.FINISH
            return r5
        L9a:
            com.urbanairship.automation.engine.InterruptedBehavior r5 = com.urbanairship.automation.engine.InterruptedBehavior.FINISH
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.InAppMessageAutomationExecutor.interrupted(com.urbanairship.automation.AutomationSchedule, com.urbanairship.automation.engine.PreparedScheduleInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void notifyDisplayConditionsChanged() {
        this.scheduleConditionsChangedNotifier.notifyChanged$urbanairship_automation_release();
    }
}
