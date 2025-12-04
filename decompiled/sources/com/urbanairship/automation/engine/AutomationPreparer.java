package com.urbanairship.automation.engine;

import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.urbanairship.UALog;
import com.urbanairship.audience.AudienceEvaluator;
import com.urbanairship.audience.DeviceInfoProvider;
import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.automation.AutomationScheduleKt;
import com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver;
import com.urbanairship.automation.deferred.DeferredAutomationData;
import com.urbanairship.automation.limits.FrequencyChecker;
import com.urbanairship.automation.limits.FrequencyLimitManager;
import com.urbanairship.automation.remotedata.AutomationRemoteDataAccess;
import com.urbanairship.automation.utils.RetryingQueue;
import com.urbanairship.base.Supplier;
import com.urbanairship.deferred.DeferredResolver;
import com.urbanairship.deferred.DeferredTriggerContext;
import com.urbanairship.experiment.ExperimentManager;
import com.urbanairship.experiment.ExperimentResult;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.iam.PreparedInAppMessageData;
import com.urbanairship.json.JsonValue;
import com.urbanairship.remoteconfig.RetryingQueueConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 O2\u00020\u0001:\u0001OB\u0095\u0001\b\u0000\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0012\b\u0002\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0086@¢\u0006\u0002\u0010\"J(\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010*J.\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0,2\u0006\u0010 \u001a\u00020!2\u0006\u0010)\u001a\u00020\u000fH\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/J(\u00100\u001a\u0002012\u0006\u0010 \u001a\u00020!2\b\u00102\u001a\u0004\u0018\u00010(2\u0006\u00103\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u00104J\u008e\u0001\u00105\u001a\b\u0012\u0004\u0012\u000201062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010 \u001a\u00020!2\"\u0010;\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020&\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0=\u0012\u0006\u0012\u0004\u0018\u00010\u00010<2\"\u0010>\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0,0=\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\u0018\u0010@\u001a\u0014\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020B0<H\u0082@¢\u0006\u0002\u0010CJ^\u0010D\u001a\b\u0012\u0004\u0012\u000201062\u0006\u00107\u001a\u0002082\u0006\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020$2\u0006\u0010 \u001a\u00020!2(\u0010E\u001a$\b\u0001\u0012\u0004\u0012\u00020:\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000201060=\u0012\u0006\u0012\u0004\u0018\u00010\u00010<H\u0082@¢\u0006\u0002\u0010FJ>\u0010G\u001a\b\u0012\u0004\u0012\u00020?0,2\u0006\u0010 \u001a\u00020!2\b\u0010H\u001a\u0004\u0018\u00010-2\u0006\u0010)\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u000eH\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bI\u0010JJ\"\u0010K\u001a\u00020B2\u0006\u0010L\u001a\u00020?2\u0006\u00109\u001a\u00020A2\b\u0010M\u001a\u0004\u0018\u00010NH\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006P"}, d2 = {"Lcom/urbanairship/automation/engine/AutomationPreparer;", "", "actionPreparer", "Lcom/urbanairship/automation/engine/AutomationPreparerDelegate;", "Lcom/urbanairship/json/JsonValue;", "messagePreparer", "Lcom/urbanairship/iam/InAppMessage;", "Lcom/urbanairship/iam/PreparedInAppMessageData;", "deferredResolver", "Lcom/urbanairship/deferred/DeferredResolver;", "frequencyLimitManager", "Lcom/urbanairship/automation/limits/FrequencyLimitManager;", "deviceInfoProviderFactory", "Lkotlin/Function1;", "", "Lcom/urbanairship/audience/DeviceInfoProvider;", ExperimentManager.PAYLOAD_TYPE, "Lcom/urbanairship/experiment/ExperimentManager;", "remoteDataAccess", "Lcom/urbanairship/automation/remotedata/AutomationRemoteDataAccess;", "additionalAudienceResolver", "Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckerResolver;", "audienceEvaluator", "Lcom/urbanairship/audience/AudienceEvaluator;", "queueConfigSupplier", "Lcom/urbanairship/base/Supplier;", "Lcom/urbanairship/remoteconfig/RetryingQueueConfig;", "queues", "Lcom/urbanairship/automation/engine/Queues;", "(Lcom/urbanairship/automation/engine/AutomationPreparerDelegate;Lcom/urbanairship/automation/engine/AutomationPreparerDelegate;Lcom/urbanairship/deferred/DeferredResolver;Lcom/urbanairship/automation/limits/FrequencyLimitManager;Lkotlin/jvm/functions/Function1;Lcom/urbanairship/experiment/ExperimentManager;Lcom/urbanairship/automation/remotedata/AutomationRemoteDataAccess;Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckerResolver;Lcom/urbanairship/audience/AudienceEvaluator;Lcom/urbanairship/base/Supplier;Lcom/urbanairship/automation/engine/Queues;)V", "cancelled", "", "schedule", "Lcom/urbanairship/automation/AutomationSchedule;", "(Lcom/urbanairship/automation/AutomationSchedule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deferredRequest", "Lcom/urbanairship/deferred/DeferredRequest;", "deferred", "Lcom/urbanairship/automation/deferred/DeferredAutomationData;", "triggerContext", "Lcom/urbanairship/deferred/DeferredTriggerContext;", "deviceInfoProvider", "(Lcom/urbanairship/automation/deferred/DeferredAutomationData;Lcom/urbanairship/deferred/DeferredTriggerContext;Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "evaluateExperiments", "Lkotlin/Result;", "Lcom/urbanairship/experiment/ExperimentResult;", "evaluateExperiments-0E7RQCE", "(Lcom/urbanairship/automation/AutomationSchedule;Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepare", "Lcom/urbanairship/automation/engine/SchedulePrepareResult;", "deferredContext", "triggerSessionId", "(Lcom/urbanairship/automation/AutomationSchedule;Lcom/urbanairship/deferred/DeferredTriggerContext;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareData", "Lcom/urbanairship/automation/utils/RetryingQueue$Result;", "prepareCache", "Lcom/urbanairship/automation/engine/PrepareCache;", "data", "Lcom/urbanairship/automation/AutomationSchedule$ScheduleData;", "onDeferredRequest", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "onPrepareInfo", "Lcom/urbanairship/automation/engine/PreparedScheduleInfo;", "onPrepareSchedule", "Lcom/urbanairship/automation/engine/PreparedScheduleData;", "Lcom/urbanairship/automation/engine/PreparedSchedule;", "(Lcom/urbanairship/automation/engine/PrepareCache;Lcom/urbanairship/automation/AutomationSchedule$ScheduleData;Lcom/urbanairship/automation/AutomationSchedule;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareDeferred", "onResult", "(Lcom/urbanairship/automation/engine/PrepareCache;Lcom/urbanairship/automation/deferred/DeferredAutomationData;Lcom/urbanairship/deferred/DeferredRequest;Lcom/urbanairship/automation/AutomationSchedule;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareInfo", "experimentResult", "prepareInfo-yxL6bBk", "(Lcom/urbanairship/automation/AutomationSchedule;Lcom/urbanairship/experiment/ExperimentResult;Lcom/urbanairship/audience/DeviceInfoProvider;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareSchedule", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "frequencyChecker", "Lcom/urbanairship/automation/limits/FrequencyChecker;", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AutomationPreparer {
    private final AutomationPreparerDelegate actionPreparer;
    private final AdditionalAudienceCheckerResolver additionalAudienceResolver;
    private final AudienceEvaluator audienceEvaluator;
    private final DeferredResolver deferredResolver;
    private final Function1 deviceInfoProviderFactory;
    private final ExperimentManager experiments;
    private final FrequencyLimitManager frequencyLimitManager;
    private final AutomationPreparerDelegate messagePreparer;
    private final Queues queues;
    private final AutomationRemoteDataAccess remoteDataAccess;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeferredAutomationData.DeferredType.values().length];
            try {
                iArr[DeferredAutomationData.DeferredType.ACTIONS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeferredAutomationData.DeferredType.IN_APP_MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationPreparer$deferredRequest$1, reason: invalid class name and case insensitive filesystem */
    static final class C10331 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C10331(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationPreparer.this.deferredRequest(null, null, null, this);
        }
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationPreparer$prepareData$1, reason: invalid class name and case insensitive filesystem */
    static final class C10341 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C10341(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationPreparer.this.prepareData(null, null, null, null, null, null, this);
        }
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationPreparer$prepareDeferred$1, reason: invalid class name and case insensitive filesystem */
    static final class C10351 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C10351(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationPreparer.this.prepareDeferred(null, null, null, null, null, this);
        }
    }

    public AutomationPreparer(@NotNull AutomationPreparerDelegate<JsonValue, JsonValue> actionPreparer, @NotNull AutomationPreparerDelegate<InAppMessage, PreparedInAppMessageData> messagePreparer, @NotNull DeferredResolver deferredResolver, @NotNull FrequencyLimitManager frequencyLimitManager, @NotNull Function1<? super String, ? extends DeviceInfoProvider> deviceInfoProviderFactory, @NotNull ExperimentManager experiments, @NotNull AutomationRemoteDataAccess remoteDataAccess, @NotNull AdditionalAudienceCheckerResolver additionalAudienceResolver, @NotNull AudienceEvaluator audienceEvaluator, @Nullable Supplier<RetryingQueueConfig> supplier, @NotNull Queues queues) {
        Intrinsics.checkNotNullParameter(actionPreparer, "actionPreparer");
        Intrinsics.checkNotNullParameter(messagePreparer, "messagePreparer");
        Intrinsics.checkNotNullParameter(deferredResolver, "deferredResolver");
        Intrinsics.checkNotNullParameter(frequencyLimitManager, "frequencyLimitManager");
        Intrinsics.checkNotNullParameter(deviceInfoProviderFactory, "deviceInfoProviderFactory");
        Intrinsics.checkNotNullParameter(experiments, "experiments");
        Intrinsics.checkNotNullParameter(remoteDataAccess, "remoteDataAccess");
        Intrinsics.checkNotNullParameter(additionalAudienceResolver, "additionalAudienceResolver");
        Intrinsics.checkNotNullParameter(audienceEvaluator, "audienceEvaluator");
        Intrinsics.checkNotNullParameter(queues, "queues");
        this.actionPreparer = actionPreparer;
        this.messagePreparer = messagePreparer;
        this.deferredResolver = deferredResolver;
        this.frequencyLimitManager = frequencyLimitManager;
        this.deviceInfoProviderFactory = deviceInfoProviderFactory;
        this.experiments = experiments;
        this.remoteDataAccess = remoteDataAccess;
        this.additionalAudienceResolver = additionalAudienceResolver;
        this.audienceEvaluator = audienceEvaluator;
        this.queues = queues;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AutomationPreparer(AutomationPreparerDelegate automationPreparerDelegate, AutomationPreparerDelegate automationPreparerDelegate2, DeferredResolver deferredResolver, FrequencyLimitManager frequencyLimitManager, Function1 function1, ExperimentManager experimentManager, AutomationRemoteDataAccess automationRemoteDataAccess, AdditionalAudienceCheckerResolver additionalAudienceCheckerResolver, AudienceEvaluator audienceEvaluator, Supplier supplier, Queues queues, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Function1 function12 = (i & 16) != 0 ? new Function1() { // from class: com.urbanairship.automation.engine.AutomationPreparer.1
            @Override // kotlin.jvm.functions.Function1
            public final DeviceInfoProvider invoke(String str) {
                return DeviceInfoProvider.INSTANCE.newCachingProvider(str);
            }
        } : function1;
        Supplier supplier2 = (i & 512) != 0 ? null : supplier;
        this(automationPreparerDelegate, automationPreparerDelegate2, deferredResolver, frequencyLimitManager, function12, experimentManager, automationRemoteDataAccess, additionalAudienceCheckerResolver, audienceEvaluator, supplier2, (i & 1024) != 0 ? new Queues(supplier2) : queues);
    }

    @Nullable
    public final Object cancelled(@NotNull AutomationSchedule automationSchedule, @NotNull Continuation<? super Unit> continuation) {
        if (AutomationScheduleKt.isInAppMessageType(automationSchedule)) {
            Object objCancelled = this.messagePreparer.cancelled(automationSchedule.getIdentifier(), continuation);
            return objCancelled == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCancelled : Unit.INSTANCE;
        }
        Object objCancelled2 = this.actionPreparer.cancelled(automationSchedule.getIdentifier(), continuation);
        return objCancelled2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCancelled2 : Unit.INSTANCE;
    }

    @Nullable
    public final Object prepare(@NotNull final AutomationSchedule automationSchedule, @Nullable DeferredTriggerContext deferredTriggerContext, @NotNull String str, @NotNull Continuation<? super SchedulePrepareResult> continuation) {
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepare.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Preparing " + automationSchedule.getIdentifier();
            }
        }, 1, null);
        PrepareCache prepareCache = new PrepareCache(null, 1, null);
        return RetryingQueue.run$default(this.queues.queue(automationSchedule.getQueue()), "Schedule " + automationSchedule.getIdentifier(), 0, new AnonymousClass3(automationSchedule, prepareCache, deferredTriggerContext, str, null), continuation, 2, null);
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationPreparer$prepare$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function1 {
        final /* synthetic */ DeferredTriggerContext $deferredContext;
        final /* synthetic */ PrepareCache $prepareCache;
        final /* synthetic */ AutomationSchedule $schedule;
        final /* synthetic */ String $triggerSessionId;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(AutomationSchedule automationSchedule, PrepareCache prepareCache, DeferredTriggerContext deferredTriggerContext, String str, Continuation continuation) {
            super(1, continuation);
            this.$schedule = automationSchedule;
            this.$prepareCache = prepareCache;
            this.$deferredContext = deferredTriggerContext;
            this.$triggerSessionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AutomationPreparer.this.new AnonymousClass3(this.$schedule, this.$prepareCache, this.$deferredContext, this.$triggerSessionId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0109  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0156  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0181 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x018c  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x01d2  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01f2  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instructions count: 552
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationPreparer.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* renamed from: com.urbanairship.automation.engine.AutomationPreparer$prepare$3$4, reason: invalid class name */
        static final class AnonymousClass4 extends SuspendLambda implements Function2 {
            final /* synthetic */ DeferredTriggerContext $deferredContext;
            final /* synthetic */ DeviceInfoProvider $deviceInfoProvider;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AutomationPreparer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(AutomationPreparer automationPreparer, DeferredTriggerContext deferredTriggerContext, DeviceInfoProvider deviceInfoProvider, Continuation continuation) {
                super(2, continuation);
                this.this$0 = automationPreparer;
                this.$deferredContext = deferredTriggerContext;
                this.$deviceInfoProvider = deviceInfoProvider;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.this$0, this.$deferredContext, this.$deviceInfoProvider, continuation);
                anonymousClass4.L$0 = obj;
                return anonymousClass4;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(DeferredAutomationData deferredAutomationData, Continuation continuation) {
                return ((AnonymousClass4) create(deferredAutomationData, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    DeferredAutomationData deferredAutomationData = (DeferredAutomationData) this.L$0;
                    AutomationPreparer automationPreparer = this.this$0;
                    DeferredTriggerContext deferredTriggerContext = this.$deferredContext;
                    DeviceInfoProvider deviceInfoProvider = this.$deviceInfoProvider;
                    this.label = 1;
                    obj = automationPreparer.deferredRequest(deferredAutomationData, deferredTriggerContext, deviceInfoProvider, this);
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

        /* renamed from: com.urbanairship.automation.engine.AutomationPreparer$prepare$3$5, reason: invalid class name */
        static final class AnonymousClass5 extends SuspendLambda implements Function1 {
            final /* synthetic */ DeviceInfoProvider $deviceInfoProvider;
            final /* synthetic */ ExperimentResult $experimentResult;
            final /* synthetic */ AutomationSchedule $schedule;
            final /* synthetic */ String $triggerSessionId;
            int label;
            final /* synthetic */ AutomationPreparer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass5(AutomationPreparer automationPreparer, AutomationSchedule automationSchedule, ExperimentResult experimentResult, DeviceInfoProvider deviceInfoProvider, String str, Continuation continuation) {
                super(1, continuation);
                this.this$0 = automationPreparer;
                this.$schedule = automationSchedule;
                this.$experimentResult = experimentResult;
                this.$deviceInfoProvider = deviceInfoProvider;
                this.$triggerSessionId = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation) {
                return new AnonymousClass5(this.this$0, this.$schedule, this.$experimentResult, this.$deviceInfoProvider, this.$triggerSessionId, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation continuation) {
                return ((AnonymousClass5) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object objM2806prepareInfoyxL6bBk;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AutomationPreparer automationPreparer = this.this$0;
                    AutomationSchedule automationSchedule = this.$schedule;
                    ExperimentResult experimentResult = this.$experimentResult;
                    DeviceInfoProvider deviceInfoProvider = this.$deviceInfoProvider;
                    String str = this.$triggerSessionId;
                    this.label = 1;
                    objM2806prepareInfoyxL6bBk = automationPreparer.m2806prepareInfoyxL6bBk(automationSchedule, experimentResult, deviceInfoProvider, str, this);
                    if (objM2806prepareInfoyxL6bBk == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    objM2806prepareInfoyxL6bBk = ((Result) obj).getValue();
                }
                return Result.m2967boximpl(objM2806prepareInfoyxL6bBk);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* renamed from: prepareInfo-yxL6bBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2806prepareInfoyxL6bBk(com.urbanairship.automation.AutomationSchedule r22, com.urbanairship.experiment.ExperimentResult r23, com.urbanairship.audience.DeviceInfoProvider r24, java.lang.String r25, kotlin.coroutines.Continuation r26) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationPreparer.m2806prepareInfoyxL6bBk(com.urbanairship.automation.AutomationSchedule, com.urbanairship.experiment.ExperimentResult, com.urbanairship.audience.DeviceInfoProvider, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PreparedSchedule prepareSchedule(PreparedScheduleInfo info, PreparedScheduleData data, FrequencyChecker frequencyChecker) {
        return new PreparedSchedule(info, data, frequencyChecker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deferredRequest(com.urbanairship.automation.deferred.DeferredAutomationData r20, com.urbanairship.deferred.DeferredTriggerContext r21, com.urbanairship.audience.DeviceInfoProvider r22, kotlin.coroutines.Continuation r23) {
        /*
            r19 = this;
            r0 = r22
            r1 = r23
            boolean r2 = r1 instanceof com.urbanairship.automation.engine.AutomationPreparer.C10331
            if (r2 == 0) goto L17
            r2 = r1
            com.urbanairship.automation.engine.AutomationPreparer$deferredRequest$1 r2 = (com.urbanairship.automation.engine.AutomationPreparer.C10331) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1e
        L17:
            com.urbanairship.automation.engine.AutomationPreparer$deferredRequest$1 r2 = new com.urbanairship.automation.engine.AutomationPreparer$deferredRequest$1
            r3 = r19
            r2.<init>(r1)
        L1e:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L63
            if (r4 == r6) goto L4d
            if (r4 != r5) goto L45
            java.lang.Object r0 = r2.L$3
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r3 = r2.L$2
            android.net.Uri r3 = (android.net.Uri) r3
            java.lang.Object r4 = r2.L$1
            com.urbanairship.audience.DeviceInfoProvider r4 = (com.urbanairship.audience.DeviceInfoProvider) r4
            java.lang.Object r2 = r2.L$0
            com.urbanairship.deferred.DeferredTriggerContext r2 = (com.urbanairship.deferred.DeferredTriggerContext) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r9 = r0
            r11 = r2
            r8 = r3
            goto L98
        L45:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L4d:
            java.lang.Object r0 = r2.L$2
            android.net.Uri r0 = (android.net.Uri) r0
            java.lang.Object r4 = r2.L$1
            com.urbanairship.audience.DeviceInfoProvider r4 = (com.urbanairship.audience.DeviceInfoProvider) r4
            java.lang.Object r6 = r2.L$0
            com.urbanairship.deferred.DeferredTriggerContext r6 = (com.urbanairship.deferred.DeferredTriggerContext) r6
            kotlin.ResultKt.throwOnFailure(r1)
            r18 = r6
            r6 = r0
            r0 = r4
            r4 = r18
            goto L80
        L63:
            kotlin.ResultKt.throwOnFailure(r1)
            android.net.Uri r1 = r20.getUrl()
            r4 = r21
            r2.L$0 = r4
            r2.L$1 = r0
            r2.L$2 = r1
            r2.label = r6
            java.lang.Object r6 = r0.getChannelId(r2)
            if (r6 != r3) goto L7b
            return r3
        L7b:
            r18 = r6
            r6 = r1
            r1 = r18
        L80:
            java.lang.String r1 = (java.lang.String) r1
            r2.L$0 = r4
            r2.L$1 = r0
            r2.L$2 = r6
            r2.L$3 = r1
            r2.label = r5
            java.lang.Object r2 = r0.getStableContactInfo(r2)
            if (r2 != r3) goto L93
            return r3
        L93:
            r9 = r1
            r1 = r2
            r11 = r4
            r8 = r6
            r4 = r0
        L98:
            com.urbanairship.contacts.StableContactInfo r1 = (com.urbanairship.contacts.StableContactInfo) r1
            java.lang.String r10 = r1.getContactId()
            java.util.Locale r12 = r4.getLocale()
            boolean r13 = r4.isNotificationsOptedIn()
            java.lang.String r14 = r4.getAppVersionName()
            com.urbanairship.deferred.DeferredRequest r0 = new com.urbanairship.deferred.DeferredRequest
            r15 = 0
            r16 = 128(0x80, float:1.8E-43)
            r17 = 0
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationPreparer.deferredRequest(com.urbanairship.automation.deferred.DeferredAutomationData, com.urbanairship.deferred.DeferredTriggerContext, com.urbanairship.audience.DeviceInfoProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x023a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x023b A[PHI: r7
  0x023b: PHI (r7v17 java.lang.Object) = (r7v15 java.lang.Object), (r7v1 java.lang.Object) binds: [B:67:0x0238, B:12:0x003f] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object prepareData(com.urbanairship.automation.engine.PrepareCache r19, final com.urbanairship.automation.AutomationSchedule.ScheduleData r20, com.urbanairship.automation.AutomationSchedule r21, kotlin.jvm.functions.Function2 r22, kotlin.jvm.functions.Function1 r23, kotlin.jvm.functions.Function2 r24, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationPreparer.prepareData(com.urbanairship.automation.engine.PrepareCache, com.urbanairship.automation.AutomationSchedule$ScheduleData, com.urbanairship.automation.AutomationSchedule, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.automation.engine.AutomationPreparer$prepareData$7, reason: invalid class name */
    static final class AnonymousClass7 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function2 $onDeferredRequest;
        final /* synthetic */ Function1 $onPrepareInfo;
        final /* synthetic */ Function2 $onPrepareSchedule;
        final /* synthetic */ PrepareCache $prepareCache;
        final /* synthetic */ AutomationSchedule $schedule;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(PrepareCache prepareCache, AutomationSchedule automationSchedule, Function2 function2, Function1 function1, Function2 function22, Continuation continuation) {
            super(2, continuation);
            this.$prepareCache = prepareCache;
            this.$schedule = automationSchedule;
            this.$onDeferredRequest = function2;
            this.$onPrepareInfo = function1;
            this.$onPrepareSchedule = function22;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass7 anonymousClass7 = AutomationPreparer.this.new AnonymousClass7(this.$prepareCache, this.$schedule, this.$onDeferredRequest, this.$onPrepareInfo, this.$onPrepareSchedule, continuation);
            anonymousClass7.L$0 = obj;
            return anonymousClass7;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AutomationSchedule.ScheduleData scheduleData, Continuation continuation) {
            return ((AnonymousClass7) create(scheduleData, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AutomationSchedule.ScheduleData scheduleData = (AutomationSchedule.ScheduleData) this.L$0;
                AutomationPreparer automationPreparer = AutomationPreparer.this;
                PrepareCache prepareCache = this.$prepareCache;
                AutomationSchedule automationSchedule = this.$schedule;
                Function2 function2 = this.$onDeferredRequest;
                Function1 function1 = this.$onPrepareInfo;
                Function2 function22 = this.$onPrepareSchedule;
                this.label = 1;
                obj = automationPreparer.prepareData(prepareCache, scheduleData, automationSchedule, function2, function1, function22, this);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: evaluateExperiments-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2805evaluateExperiments0E7RQCE(com.urbanairship.automation.AutomationSchedule r5, com.urbanairship.audience.DeviceInfoProvider r6, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.urbanairship.automation.engine.AutomationPreparer$evaluateExperiments$1
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.automation.engine.AutomationPreparer$evaluateExperiments$1 r0 = (com.urbanairship.automation.engine.AutomationPreparer$evaluateExperiments$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.automation.engine.AutomationPreparer$evaluateExperiments$1 r0 = new com.urbanairship.automation.engine.AutomationPreparer$evaluateExperiments$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r4 = r7.getValue()
            goto L5c
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = com.urbanairship.automation.engine.AutomationPreparerKt.access$evaluateExperiments(r5)
            if (r7 == 0) goto L5d
            com.urbanairship.experiment.ExperimentManager r4 = r4.experiments
            com.urbanairship.experiment.MessageInfo r7 = new com.urbanairship.experiment.MessageInfo
            java.lang.String r2 = r5.getMessageType()
            if (r2 != 0) goto L4c
            java.lang.String r2 = "transactional"
        L4c:
            com.urbanairship.json.JsonValue r5 = r5.getCampaigns()
            r7.<init>(r2, r5)
            r0.label = r3
            java.lang.Object r4 = r4.m2844evaluateExperiments0E7RQCE(r7, r6, r0)
            if (r4 != r1) goto L5c
            return r1
        L5c:
            return r4
        L5d:
            r4 = 0
            java.lang.Object r4 = kotlin.Result.m2968constructorimpl(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationPreparer.m2805evaluateExperiments0E7RQCE(com.urbanairship.automation.AutomationSchedule, com.urbanairship.audience.DeviceInfoProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object prepareDeferred(com.urbanairship.automation.engine.PrepareCache r17, com.urbanairship.automation.deferred.DeferredAutomationData r18, com.urbanairship.deferred.DeferredRequest r19, com.urbanairship.automation.AutomationSchedule r20, kotlin.jvm.functions.Function2 r21, kotlin.coroutines.Continuation r22) {
        /*
            Method dump skipped, instructions count: 485
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.engine.AutomationPreparer.prepareDeferred(com.urbanairship.automation.engine.PrepareCache, com.urbanairship.automation.deferred.DeferredAutomationData, com.urbanairship.deferred.DeferredRequest, com.urbanairship.automation.AutomationSchedule, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
