package com.urbanairship.automation.engine;

import android.net.Uri;
import com.disney.p026id.android.tracker.OneIDTrackerEvent;
import com.urbanairship.UALog;
import com.urbanairship.audience.AirshipDeviceAudienceResult;
import com.urbanairship.audience.AudienceEvaluator;
import com.urbanairship.audience.AudienceSelector;
import com.urbanairship.audience.CompoundAudienceSelector;
import com.urbanairship.audience.DeviceInfoProvider;
import com.urbanairship.automation.AdditionalAudienceCheckOverrides;
import com.urbanairship.automation.AutomationAudience;
import com.urbanairship.automation.AutomationCompoundAudience;
import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.automation.AutomationScheduleKt;
import com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver;
import com.urbanairship.automation.deferred.DeferredAutomationData;
import com.urbanairship.automation.deferred.DeferredScheduleResult;
import com.urbanairship.automation.limits.FrequencyChecker;
import com.urbanairship.automation.limits.FrequencyLimitManager;
import com.urbanairship.automation.remotedata.AutomationRemoteDataAccess;
import com.urbanairship.automation.utils.RetryingQueue;
import com.urbanairship.base.Supplier;
import com.urbanairship.contacts.StableContactInfo;
import com.urbanairship.deferred.DeferredRequest;
import com.urbanairship.deferred.DeferredResolver;
import com.urbanairship.deferred.DeferredResult;
import com.urbanairship.deferred.DeferredTriggerContext;
import com.urbanairship.experiment.ExperimentManager;
import com.urbanairship.experiment.ExperimentResult;
import com.urbanairship.experiment.MessageInfo;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.iam.PreparedInAppMessageData;
import com.urbanairship.json.JsonValue;
import com.urbanairship.remoteconfig.RetryingQueueConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 O2\u00020\u0001:\u0001OB\u0095\u0001\b\u0000\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0012\b\u0002\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0086@¢\u0006\u0002\u0010\"J(\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010*J.\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0,2\u0006\u0010 \u001a\u00020!2\u0006\u0010)\u001a\u00020\u000fH\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/J(\u00100\u001a\u0002012\u0006\u0010 \u001a\u00020!2\b\u00102\u001a\u0004\u0018\u00010(2\u0006\u00103\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u00104J\u008e\u0001\u00105\u001a\b\u0012\u0004\u0012\u000201062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010 \u001a\u00020!2\"\u0010;\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020&\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0=\u0012\u0006\u0012\u0004\u0018\u00010\u00010<2\"\u0010>\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0,0=\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\u0018\u0010@\u001a\u0014\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020B0<H\u0082@¢\u0006\u0002\u0010CJ^\u0010D\u001a\b\u0012\u0004\u0012\u000201062\u0006\u00107\u001a\u0002082\u0006\u0010%\u001a\u00020&2\u0006\u0010#\u001a\u00020$2\u0006\u0010 \u001a\u00020!2(\u0010E\u001a$\b\u0001\u0012\u0004\u0012\u00020:\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000201060=\u0012\u0006\u0012\u0004\u0018\u00010\u00010<H\u0082@¢\u0006\u0002\u0010FJ>\u0010G\u001a\b\u0012\u0004\u0012\u00020?0,2\u0006\u0010 \u001a\u00020!2\b\u0010H\u001a\u0004\u0018\u00010-2\u0006\u0010)\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u000eH\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bI\u0010JJ\"\u0010K\u001a\u00020B2\u0006\u0010L\u001a\u00020?2\u0006\u00109\u001a\u00020A2\b\u0010M\u001a\u0004\u0018\u00010NH\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006P"}, m1836d2 = {"Lcom/urbanairship/automation/engine/AutomationPreparer;", "", "actionPreparer", "Lcom/urbanairship/automation/engine/AutomationPreparerDelegate;", "Lcom/urbanairship/json/JsonValue;", "messagePreparer", "Lcom/urbanairship/iam/InAppMessage;", "Lcom/urbanairship/iam/PreparedInAppMessageData;", "deferredResolver", "Lcom/urbanairship/deferred/DeferredResolver;", "frequencyLimitManager", "Lcom/urbanairship/automation/limits/FrequencyLimitManager;", "deviceInfoProviderFactory", "Lkotlin/Function1;", "", "Lcom/urbanairship/audience/DeviceInfoProvider;", ExperimentManager.PAYLOAD_TYPE, "Lcom/urbanairship/experiment/ExperimentManager;", "remoteDataAccess", "Lcom/urbanairship/automation/remotedata/AutomationRemoteDataAccess;", "additionalAudienceResolver", "Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckerResolver;", "audienceEvaluator", "Lcom/urbanairship/audience/AudienceEvaluator;", "queueConfigSupplier", "Lcom/urbanairship/base/Supplier;", "Lcom/urbanairship/remoteconfig/RetryingQueueConfig;", "queues", "Lcom/urbanairship/automation/engine/Queues;", "(Lcom/urbanairship/automation/engine/AutomationPreparerDelegate;Lcom/urbanairship/automation/engine/AutomationPreparerDelegate;Lcom/urbanairship/deferred/DeferredResolver;Lcom/urbanairship/automation/limits/FrequencyLimitManager;Lkotlin/jvm/functions/Function1;Lcom/urbanairship/experiment/ExperimentManager;Lcom/urbanairship/automation/remotedata/AutomationRemoteDataAccess;Lcom/urbanairship/automation/audiencecheck/AdditionalAudienceCheckerResolver;Lcom/urbanairship/audience/AudienceEvaluator;Lcom/urbanairship/base/Supplier;Lcom/urbanairship/automation/engine/Queues;)V", "cancelled", "", "schedule", "Lcom/urbanairship/automation/AutomationSchedule;", "(Lcom/urbanairship/automation/AutomationSchedule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deferredRequest", "Lcom/urbanairship/deferred/DeferredRequest;", "deferred", "Lcom/urbanairship/automation/deferred/DeferredAutomationData;", "triggerContext", "Lcom/urbanairship/deferred/DeferredTriggerContext;", "deviceInfoProvider", "(Lcom/urbanairship/automation/deferred/DeferredAutomationData;Lcom/urbanairship/deferred/DeferredTriggerContext;Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "evaluateExperiments", "Lkotlin/Result;", "Lcom/urbanairship/experiment/ExperimentResult;", "evaluateExperiments-0E7RQCE", "(Lcom/urbanairship/automation/AutomationSchedule;Lcom/urbanairship/audience/DeviceInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepare", "Lcom/urbanairship/automation/engine/SchedulePrepareResult;", "deferredContext", "triggerSessionId", "(Lcom/urbanairship/automation/AutomationSchedule;Lcom/urbanairship/deferred/DeferredTriggerContext;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareData", "Lcom/urbanairship/automation/utils/RetryingQueue$Result;", "prepareCache", "Lcom/urbanairship/automation/engine/PrepareCache;", "data", "Lcom/urbanairship/automation/AutomationSchedule$ScheduleData;", "onDeferredRequest", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "onPrepareInfo", "Lcom/urbanairship/automation/engine/PreparedScheduleInfo;", "onPrepareSchedule", "Lcom/urbanairship/automation/engine/PreparedScheduleData;", "Lcom/urbanairship/automation/engine/PreparedSchedule;", "(Lcom/urbanairship/automation/engine/PrepareCache;Lcom/urbanairship/automation/AutomationSchedule$ScheduleData;Lcom/urbanairship/automation/AutomationSchedule;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareDeferred", "onResult", "(Lcom/urbanairship/automation/engine/PrepareCache;Lcom/urbanairship/automation/deferred/DeferredAutomationData;Lcom/urbanairship/deferred/DeferredRequest;Lcom/urbanairship/automation/AutomationSchedule;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareInfo", "experimentResult", "prepareInfo-yxL6bBk", "(Lcom/urbanairship/automation/AutomationSchedule;Lcom/urbanairship/experiment/ExperimentResult;Lcom/urbanairship/audience/DeviceInfoProvider;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareSchedule", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "frequencyChecker", "Lcom/urbanairship/automation/limits/FrequencyChecker;", "Companion", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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

    @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
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

    /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationPreparer$deferredRequest$1 */
    static final class C50651 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C50651(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationPreparer.this.deferredRequest(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationPreparer$prepareData$1 */
    static final class C50681 extends ContinuationImpl {
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

        C50681(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutomationPreparer.this.prepareData(null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationPreparer$prepareDeferred$1 */
    static final class C50711 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C50711(Continuation continuation) {
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
        Function1 function2 = (i & 16) != 0 ? new Function1() { // from class: com.urbanairship.automation.engine.AutomationPreparer.1
            @Override // kotlin.jvm.functions.Function1
            public final DeviceInfoProvider invoke(String str) {
                return DeviceInfoProvider.INSTANCE.newCachingProvider(str);
            }
        } : function1;
        Supplier supplier2 = (i & 512) != 0 ? null : supplier;
        this(automationPreparerDelegate, automationPreparerDelegate2, deferredResolver, frequencyLimitManager, function2, experimentManager, automationRemoteDataAccess, additionalAudienceCheckerResolver, audienceEvaluator, supplier2, (i & 1024) != 0 ? new Queues(supplier2) : queues);
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
        return RetryingQueue.run$default(this.queues.queue(automationSchedule.getQueue()), "Schedule " + automationSchedule.getIdentifier(), 0, new C50673(automationSchedule, prepareCache, deferredTriggerContext, str, null), continuation, 2, null);
    }

    /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationPreparer$prepare$3 */
    static final class C50673 extends SuspendLambda implements Function1 {
        final /* synthetic */ DeferredTriggerContext $deferredContext;
        final /* synthetic */ PrepareCache $prepareCache;
        final /* synthetic */ AutomationSchedule $schedule;
        final /* synthetic */ String $triggerSessionId;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C50673(AutomationSchedule automationSchedule, PrepareCache prepareCache, DeferredTriggerContext deferredTriggerContext, String str, Continuation continuation) {
            super(1, continuation);
            this.$schedule = automationSchedule;
            this.$prepareCache = prepareCache;
            this.$deferredContext = deferredTriggerContext;
            this.$triggerSessionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AutomationPreparer.this.new C50673(this.$schedule, this.$prepareCache, this.$deferredContext, this.$triggerSessionId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C50673) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00d5  */
        /* JADX WARN: Code duplicated, block: B:30:0x00e7  */
        /* JADX WARN: Code duplicated, block: B:32:0x00fe A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:35:0x0109  */
        /* JADX WARN: Code duplicated, block: B:37:0x0116  */
        /* JADX WARN: Code duplicated, block: B:38:0x011b  */
        /* JADX WARN: Code duplicated, block: B:41:0x0124  */
        /* JADX WARN: Code duplicated, block: B:42:0x0129  */
        /* JADX WARN: Code duplicated, block: B:45:0x0130  */
        /* JADX WARN: Code duplicated, block: B:47:0x014c A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:48:0x014d  */
        /* JADX WARN: Code duplicated, block: B:51:0x0156  */
        /* JADX WARN: Code duplicated, block: B:54:0x016e  */
        /* JADX WARN: Code duplicated, block: B:57:0x0181 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:60:0x018c  */
        /* JADX WARN: Code duplicated, block: B:62:0x01d0 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:64:0x01d2  */
        /* JADX WARN: Code duplicated, block: B:66:0x01eb A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:69:0x01f2  */
        /* JADX WARN: Code duplicated, block: B:71:0x0209 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:74:? A[RETURN, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DeviceInfoProvider deviceInfoProvider;
            Object objBestEffortRefresh;
            Object objM5057getFrequencyCheckergIAlus;
            DeviceInfoProvider deviceInfoProvider2;
            AutomationPreparer automationPreparer;
            final AutomationSchedule automationSchedule;
            Throwable thM5280exceptionOrNullimpl;
            AutomationRemoteDataAccess automationRemoteDataAccess;
            FrequencyChecker frequencyChecker;
            AutomationCompoundAudience compoundAudience;
            CompoundAudienceSelector selector;
            AutomationAudience audience;
            AudienceSelector audienceSelector;
            CompoundAudienceSelector compoundAudienceSelectorCombine;
            DeviceInfoProvider deviceInfoProvider3;
            Object objEvaluate;
            final FrequencyChecker frequencyChecker2;
            Object objM5047evaluateExperiments0E7RQCE;
            DeviceInfoProvider deviceInfoProvider4;
            AutomationPreparer automationPreparer2;
            final AutomationSchedule automationSchedule2;
            Throwable thM5280exceptionOrNullimpl2;
            AutomationRemoteDataAccess automationRemoteDataAccess2;
            Object objPrepareData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    deviceInfoProvider = (DeviceInfoProvider) AutomationPreparer.this.deviceInfoProviderFactory.invoke(AutomationPreparer.this.remoteDataAccess.contactIdFor(this.$schedule));
                    if (!AutomationPreparer.this.remoteDataAccess.requiredUpdate(this.$schedule)) {
                        AutomationRemoteDataAccess automationRemoteDataAccess3 = AutomationPreparer.this.remoteDataAccess;
                        AutomationSchedule automationSchedule3 = this.$schedule;
                        this.L$0 = deviceInfoProvider;
                        this.label = 2;
                        objBestEffortRefresh = automationRemoteDataAccess3.bestEffortRefresh(automationSchedule3, this);
                        if (objBestEffortRefresh == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (!((Boolean) objBestEffortRefresh).booleanValue()) {
                            FrequencyLimitManager frequencyLimitManager = AutomationPreparer.this.frequencyLimitManager;
                            List<String> frequencyConstraintIds$urbanairship_automation_release = this.$schedule.getFrequencyConstraintIds$urbanairship_automation_release();
                            this.L$0 = deviceInfoProvider;
                            this.label = 3;
                            objM5057getFrequencyCheckergIAlus = frequencyLimitManager.m5057getFrequencyCheckergIAlus(frequencyConstraintIds$urbanairship_automation_release, this);
                            if (objM5057getFrequencyCheckergIAlus == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            deviceInfoProvider2 = deviceInfoProvider;
                            automationPreparer = AutomationPreparer.this;
                            automationSchedule = this.$schedule;
                            thM5280exceptionOrNullimpl = Result.m5280exceptionOrNullimpl(objM5057getFrequencyCheckergIAlus);
                            if (thM5280exceptionOrNullimpl != null) {
                                UALog.m1747e(thM5280exceptionOrNullimpl, (Function0<String>) new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer$prepare$3$frequencyChecker$1$1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        return "Failed to fetch frequency checker for schedule " + automationSchedule.getIdentifier();
                                    }
                                });
                                automationRemoteDataAccess = automationPreparer.remoteDataAccess;
                                this.L$0 = null;
                                this.label = 4;
                                if (automationRemoteDataAccess.notifyOutdated(automationSchedule, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return new RetryingQueue.Result.Success(SchedulePrepareResult.Invalidate.INSTANCE, false, 2, null);
                            }
                            frequencyChecker = (FrequencyChecker) objM5057getFrequencyCheckergIAlus;
                            CompoundAudienceSelector.Companion companion = CompoundAudienceSelector.INSTANCE;
                            compoundAudience = this.$schedule.getCompoundAudience();
                            if (compoundAudience != null) {
                                selector = compoundAudience.getSelector();
                            } else {
                                selector = null;
                            }
                            audience = this.$schedule.getAudience();
                            if (audience != null) {
                                audienceSelector = audience.getAudienceSelector();
                            } else {
                                audienceSelector = null;
                            }
                            compoundAudienceSelectorCombine = companion.combine(selector, audienceSelector);
                            if (compoundAudienceSelectorCombine != null) {
                                AudienceEvaluator audienceEvaluator = AutomationPreparer.this.audienceEvaluator;
                                long created = this.$schedule.getCreated();
                                this.L$0 = deviceInfoProvider2;
                                this.L$1 = frequencyChecker;
                                this.label = 5;
                                objEvaluate = audienceEvaluator.evaluate(compoundAudienceSelectorCombine, created, deviceInfoProvider2, this);
                                if (objEvaluate == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                deviceInfoProvider3 = deviceInfoProvider2;
                                if (!((AirshipDeviceAudienceResult) objEvaluate).isMatch()) {
                                    final AutomationSchedule automationSchedule4 = this.$schedule;
                                    UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepare.3.3
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final String invoke() {
                                            return "Local audience miss for schedule " + automationSchedule4.getIdentifier();
                                        }
                                    }, 1, null);
                                    return new RetryingQueue.Result.Success(AutomationPreparerKt.audienceMissBehaviorResult(this.$schedule), true);
                                }
                            } else {
                                deviceInfoProvider3 = deviceInfoProvider2;
                            }
                            frequencyChecker2 = frequencyChecker;
                            AutomationPreparer automationPreparer3 = AutomationPreparer.this;
                            AutomationSchedule automationSchedule5 = this.$schedule;
                            this.L$0 = deviceInfoProvider3;
                            this.L$1 = frequencyChecker2;
                            this.label = 6;
                            objM5047evaluateExperiments0E7RQCE = automationPreparer3.m5047evaluateExperiments0E7RQCE(automationSchedule5, deviceInfoProvider3, this);
                            if (objM5047evaluateExperiments0E7RQCE == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            deviceInfoProvider4 = deviceInfoProvider3;
                            automationPreparer2 = AutomationPreparer.this;
                            automationSchedule2 = this.$schedule;
                            thM5280exceptionOrNullimpl2 = Result.m5280exceptionOrNullimpl(objM5047evaluateExperiments0E7RQCE);
                            if (thM5280exceptionOrNullimpl2 != null) {
                                UALog.m1747e(thM5280exceptionOrNullimpl2, (Function0<String>) new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer$prepare$3$experimentResult$1$1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        return "Failed to evaluate hold out groups " + automationSchedule2.getIdentifier();
                                    }
                                });
                                automationRemoteDataAccess2 = automationPreparer2.remoteDataAccess;
                                this.L$0 = null;
                                this.L$1 = null;
                                this.label = 7;
                                if (automationRemoteDataAccess2.notifyOutdated(automationSchedule2, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return new RetryingQueue.Result.Retry(null, 1, null);
                            }
                            ExperimentResult experimentResult = (ExperimentResult) objM5047evaluateExperiments0E7RQCE;
                            AutomationPreparer automationPreparer4 = AutomationPreparer.this;
                            PrepareCache prepareCache = this.$prepareCache;
                            AutomationSchedule.ScheduleData data = this.$schedule.getData();
                            AutomationSchedule automationSchedule6 = this.$schedule;
                            AnonymousClass4 anonymousClass4 = new AnonymousClass4(AutomationPreparer.this, this.$deferredContext, deviceInfoProvider4, null);
                            AnonymousClass5 anonymousClass5 = new AnonymousClass5(AutomationPreparer.this, this.$schedule, experimentResult, deviceInfoProvider4, this.$triggerSessionId, null);
                            final AutomationPreparer automationPreparer5 = AutomationPreparer.this;
                            Function2 function2 = new Function2() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepare.3.6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final PreparedSchedule invoke(PreparedScheduleInfo info, PreparedScheduleData data2) {
                                    Intrinsics.checkNotNullParameter(info, "info");
                                    Intrinsics.checkNotNullParameter(data2, "data");
                                    return automationPreparer5.prepareSchedule(info, data2, frequencyChecker2);
                                }
                            };
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 8;
                            objPrepareData = automationPreparer4.prepareData(prepareCache, data, automationSchedule6, anonymousClass4, anonymousClass5, function2, this);
                            if (objPrepareData == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return objPrepareData;
                        }
                        final AutomationSchedule automationSchedule7 = this.$schedule;
                        UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepare.3.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Schedule out of date " + automationSchedule7.getIdentifier();
                            }
                        }, 1, null);
                        return new RetryingQueue.Result.Success(SchedulePrepareResult.Invalidate.INSTANCE, false, 2, null);
                    }
                    final AutomationSchedule automationSchedule8 = this.$schedule;
                    UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepare.3.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Schedule out of date " + automationSchedule8.getIdentifier();
                        }
                    }, 1, null);
                    AutomationRemoteDataAccess automationRemoteDataAccess4 = AutomationPreparer.this.remoteDataAccess;
                    AutomationSchedule automationSchedule9 = this.$schedule;
                    this.label = 1;
                    if (automationRemoteDataAccess4.waitForFullRefresh(automationSchedule9, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return new RetryingQueue.Result.Success(SchedulePrepareResult.Invalidate.INSTANCE, false, 2, null);
                case 1:
                    ResultKt.throwOnFailure(obj);
                    return new RetryingQueue.Result.Success(SchedulePrepareResult.Invalidate.INSTANCE, false, 2, null);
                case 2:
                    deviceInfoProvider = (DeviceInfoProvider) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objBestEffortRefresh = obj;
                    if (!((Boolean) objBestEffortRefresh).booleanValue()) {
                        FrequencyLimitManager frequencyLimitManager2 = AutomationPreparer.this.frequencyLimitManager;
                        List<String> frequencyConstraintIds$urbanairship_automation_release2 = this.$schedule.getFrequencyConstraintIds$urbanairship_automation_release();
                        this.L$0 = deviceInfoProvider;
                        this.label = 3;
                        objM5057getFrequencyCheckergIAlus = frequencyLimitManager2.m5057getFrequencyCheckergIAlus(frequencyConstraintIds$urbanairship_automation_release2, this);
                        if (objM5057getFrequencyCheckergIAlus == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        deviceInfoProvider2 = deviceInfoProvider;
                        automationPreparer = AutomationPreparer.this;
                        automationSchedule = this.$schedule;
                        thM5280exceptionOrNullimpl = Result.m5280exceptionOrNullimpl(objM5057getFrequencyCheckergIAlus);
                        if (thM5280exceptionOrNullimpl != null) {
                            UALog.m1747e(thM5280exceptionOrNullimpl, (Function0<String>) new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer$prepare$3$frequencyChecker$1$1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Failed to fetch frequency checker for schedule " + automationSchedule.getIdentifier();
                                }
                            });
                            automationRemoteDataAccess = automationPreparer.remoteDataAccess;
                            this.L$0 = null;
                            this.label = 4;
                            if (automationRemoteDataAccess.notifyOutdated(automationSchedule, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return new RetryingQueue.Result.Success(SchedulePrepareResult.Invalidate.INSTANCE, false, 2, null);
                        }
                        frequencyChecker = (FrequencyChecker) objM5057getFrequencyCheckergIAlus;
                        CompoundAudienceSelector.Companion companion2 = CompoundAudienceSelector.INSTANCE;
                        compoundAudience = this.$schedule.getCompoundAudience();
                        if (compoundAudience != null) {
                            selector = compoundAudience.getSelector();
                        } else {
                            selector = null;
                        }
                        audience = this.$schedule.getAudience();
                        if (audience != null) {
                            audienceSelector = audience.getAudienceSelector();
                        } else {
                            audienceSelector = null;
                        }
                        compoundAudienceSelectorCombine = companion2.combine(selector, audienceSelector);
                        if (compoundAudienceSelectorCombine != null) {
                            AudienceEvaluator audienceEvaluator2 = AutomationPreparer.this.audienceEvaluator;
                            long created2 = this.$schedule.getCreated();
                            this.L$0 = deviceInfoProvider2;
                            this.L$1 = frequencyChecker;
                            this.label = 5;
                            objEvaluate = audienceEvaluator2.evaluate(compoundAudienceSelectorCombine, created2, deviceInfoProvider2, this);
                            if (objEvaluate == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            deviceInfoProvider3 = deviceInfoProvider2;
                            if (!((AirshipDeviceAudienceResult) objEvaluate).isMatch()) {
                                final AutomationSchedule automationSchedule10 = this.$schedule;
                                UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepare.3.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        return "Local audience miss for schedule " + automationSchedule10.getIdentifier();
                                    }
                                }, 1, null);
                                return new RetryingQueue.Result.Success(AutomationPreparerKt.audienceMissBehaviorResult(this.$schedule), true);
                            }
                        } else {
                            deviceInfoProvider3 = deviceInfoProvider2;
                        }
                        frequencyChecker2 = frequencyChecker;
                        AutomationPreparer automationPreparer6 = AutomationPreparer.this;
                        AutomationSchedule automationSchedule11 = this.$schedule;
                        this.L$0 = deviceInfoProvider3;
                        this.L$1 = frequencyChecker2;
                        this.label = 6;
                        objM5047evaluateExperiments0E7RQCE = automationPreparer6.m5047evaluateExperiments0E7RQCE(automationSchedule11, deviceInfoProvider3, this);
                        if (objM5047evaluateExperiments0E7RQCE == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        deviceInfoProvider4 = deviceInfoProvider3;
                        automationPreparer2 = AutomationPreparer.this;
                        automationSchedule2 = this.$schedule;
                        thM5280exceptionOrNullimpl2 = Result.m5280exceptionOrNullimpl(objM5047evaluateExperiments0E7RQCE);
                        if (thM5280exceptionOrNullimpl2 != null) {
                            UALog.m1747e(thM5280exceptionOrNullimpl2, (Function0<String>) new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer$prepare$3$experimentResult$1$1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Failed to evaluate hold out groups " + automationSchedule2.getIdentifier();
                                }
                            });
                            automationRemoteDataAccess2 = automationPreparer2.remoteDataAccess;
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 7;
                            if (automationRemoteDataAccess2.notifyOutdated(automationSchedule2, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return new RetryingQueue.Result.Retry(null, 1, null);
                        }
                        ExperimentResult experimentResult2 = (ExperimentResult) objM5047evaluateExperiments0E7RQCE;
                        AutomationPreparer automationPreparer7 = AutomationPreparer.this;
                        PrepareCache prepareCache2 = this.$prepareCache;
                        AutomationSchedule.ScheduleData data2 = this.$schedule.getData();
                        AutomationSchedule automationSchedule12 = this.$schedule;
                        AnonymousClass4 anonymousClass6 = new AnonymousClass4(AutomationPreparer.this, this.$deferredContext, deviceInfoProvider4, null);
                        AnonymousClass5 anonymousClass7 = new AnonymousClass5(AutomationPreparer.this, this.$schedule, experimentResult2, deviceInfoProvider4, this.$triggerSessionId, null);
                        final AutomationPreparer automationPreparer8 = AutomationPreparer.this;
                        Function2 function3 = new Function2() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepare.3.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final PreparedSchedule invoke(PreparedScheduleInfo info, PreparedScheduleData data3) {
                                Intrinsics.checkNotNullParameter(info, "info");
                                Intrinsics.checkNotNullParameter(data3, "data");
                                return automationPreparer8.prepareSchedule(info, data3, frequencyChecker2);
                            }
                        };
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 8;
                        objPrepareData = automationPreparer7.prepareData(prepareCache2, data2, automationSchedule12, anonymousClass6, anonymousClass7, function3, this);
                        if (objPrepareData == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return objPrepareData;
                    }
                    final AutomationSchedule automationSchedule13 = this.$schedule;
                    UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepare.3.2
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Schedule out of date " + automationSchedule13.getIdentifier();
                        }
                    }, 1, null);
                    return new RetryingQueue.Result.Success(SchedulePrepareResult.Invalidate.INSTANCE, false, 2, null);
                case 3:
                    deviceInfoProvider = (DeviceInfoProvider) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objM5057getFrequencyCheckergIAlus = ((Result) obj).getValue();
                    deviceInfoProvider2 = deviceInfoProvider;
                    automationPreparer = AutomationPreparer.this;
                    automationSchedule = this.$schedule;
                    thM5280exceptionOrNullimpl = Result.m5280exceptionOrNullimpl(objM5057getFrequencyCheckergIAlus);
                    if (thM5280exceptionOrNullimpl != null) {
                        UALog.m1747e(thM5280exceptionOrNullimpl, (Function0<String>) new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer$prepare$3$frequencyChecker$1$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failed to fetch frequency checker for schedule " + automationSchedule.getIdentifier();
                            }
                        });
                        automationRemoteDataAccess = automationPreparer.remoteDataAccess;
                        this.L$0 = null;
                        this.label = 4;
                        if (automationRemoteDataAccess.notifyOutdated(automationSchedule, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return new RetryingQueue.Result.Success(SchedulePrepareResult.Invalidate.INSTANCE, false, 2, null);
                    }
                    frequencyChecker = (FrequencyChecker) objM5057getFrequencyCheckergIAlus;
                    CompoundAudienceSelector.Companion companion3 = CompoundAudienceSelector.INSTANCE;
                    compoundAudience = this.$schedule.getCompoundAudience();
                    if (compoundAudience != null) {
                        selector = compoundAudience.getSelector();
                    } else {
                        selector = null;
                    }
                    audience = this.$schedule.getAudience();
                    if (audience != null) {
                        audienceSelector = audience.getAudienceSelector();
                    } else {
                        audienceSelector = null;
                    }
                    compoundAudienceSelectorCombine = companion3.combine(selector, audienceSelector);
                    if (compoundAudienceSelectorCombine != null) {
                        AudienceEvaluator audienceEvaluator3 = AutomationPreparer.this.audienceEvaluator;
                        long created3 = this.$schedule.getCreated();
                        this.L$0 = deviceInfoProvider2;
                        this.L$1 = frequencyChecker;
                        this.label = 5;
                        objEvaluate = audienceEvaluator3.evaluate(compoundAudienceSelectorCombine, created3, deviceInfoProvider2, this);
                        if (objEvaluate == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        deviceInfoProvider3 = deviceInfoProvider2;
                        if (!((AirshipDeviceAudienceResult) objEvaluate).isMatch()) {
                            final AutomationSchedule automationSchedule14 = this.$schedule;
                            UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepare.3.3
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    return "Local audience miss for schedule " + automationSchedule14.getIdentifier();
                                }
                            }, 1, null);
                            return new RetryingQueue.Result.Success(AutomationPreparerKt.audienceMissBehaviorResult(this.$schedule), true);
                        }
                    } else {
                        deviceInfoProvider3 = deviceInfoProvider2;
                    }
                    frequencyChecker2 = frequencyChecker;
                    AutomationPreparer automationPreparer9 = AutomationPreparer.this;
                    AutomationSchedule automationSchedule15 = this.$schedule;
                    this.L$0 = deviceInfoProvider3;
                    this.L$1 = frequencyChecker2;
                    this.label = 6;
                    objM5047evaluateExperiments0E7RQCE = automationPreparer9.m5047evaluateExperiments0E7RQCE(automationSchedule15, deviceInfoProvider3, this);
                    if (objM5047evaluateExperiments0E7RQCE == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    deviceInfoProvider4 = deviceInfoProvider3;
                    automationPreparer2 = AutomationPreparer.this;
                    automationSchedule2 = this.$schedule;
                    thM5280exceptionOrNullimpl2 = Result.m5280exceptionOrNullimpl(objM5047evaluateExperiments0E7RQCE);
                    if (thM5280exceptionOrNullimpl2 != null) {
                        UALog.m1747e(thM5280exceptionOrNullimpl2, (Function0<String>) new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer$prepare$3$experimentResult$1$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failed to evaluate hold out groups " + automationSchedule2.getIdentifier();
                            }
                        });
                        automationRemoteDataAccess2 = automationPreparer2.remoteDataAccess;
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 7;
                        if (automationRemoteDataAccess2.notifyOutdated(automationSchedule2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return new RetryingQueue.Result.Retry(null, 1, null);
                    }
                    ExperimentResult experimentResult3 = (ExperimentResult) objM5047evaluateExperiments0E7RQCE;
                    AutomationPreparer automationPreparer10 = AutomationPreparer.this;
                    PrepareCache prepareCache3 = this.$prepareCache;
                    AutomationSchedule.ScheduleData data3 = this.$schedule.getData();
                    AutomationSchedule automationSchedule16 = this.$schedule;
                    AnonymousClass4 anonymousClass8 = new AnonymousClass4(AutomationPreparer.this, this.$deferredContext, deviceInfoProvider4, null);
                    AnonymousClass5 anonymousClass9 = new AnonymousClass5(AutomationPreparer.this, this.$schedule, experimentResult3, deviceInfoProvider4, this.$triggerSessionId, null);
                    final AutomationPreparer automationPreparer11 = AutomationPreparer.this;
                    Function2 function4 = new Function2() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepare.3.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final PreparedSchedule invoke(PreparedScheduleInfo info, PreparedScheduleData data4) {
                            Intrinsics.checkNotNullParameter(info, "info");
                            Intrinsics.checkNotNullParameter(data4, "data");
                            return automationPreparer11.prepareSchedule(info, data4, frequencyChecker2);
                        }
                    };
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 8;
                    objPrepareData = automationPreparer10.prepareData(prepareCache3, data3, automationSchedule16, anonymousClass8, anonymousClass9, function4, this);
                    if (objPrepareData == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objPrepareData;
                case 4:
                    ResultKt.throwOnFailure(obj);
                    return new RetryingQueue.Result.Success(SchedulePrepareResult.Invalidate.INSTANCE, false, 2, null);
                case 5:
                    FrequencyChecker frequencyChecker3 = (FrequencyChecker) this.L$1;
                    deviceInfoProvider3 = (DeviceInfoProvider) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    frequencyChecker = frequencyChecker3;
                    objEvaluate = obj;
                    if (!((AirshipDeviceAudienceResult) objEvaluate).isMatch()) {
                        final AutomationSchedule automationSchedule17 = this.$schedule;
                        UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepare.3.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Local audience miss for schedule " + automationSchedule17.getIdentifier();
                            }
                        }, 1, null);
                        return new RetryingQueue.Result.Success(AutomationPreparerKt.audienceMissBehaviorResult(this.$schedule), true);
                    }
                    frequencyChecker2 = frequencyChecker;
                    AutomationPreparer automationPreparer12 = AutomationPreparer.this;
                    AutomationSchedule automationSchedule18 = this.$schedule;
                    this.L$0 = deviceInfoProvider3;
                    this.L$1 = frequencyChecker2;
                    this.label = 6;
                    objM5047evaluateExperiments0E7RQCE = automationPreparer12.m5047evaluateExperiments0E7RQCE(automationSchedule18, deviceInfoProvider3, this);
                    if (objM5047evaluateExperiments0E7RQCE == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    deviceInfoProvider4 = deviceInfoProvider3;
                    automationPreparer2 = AutomationPreparer.this;
                    automationSchedule2 = this.$schedule;
                    thM5280exceptionOrNullimpl2 = Result.m5280exceptionOrNullimpl(objM5047evaluateExperiments0E7RQCE);
                    if (thM5280exceptionOrNullimpl2 != null) {
                        UALog.m1747e(thM5280exceptionOrNullimpl2, (Function0<String>) new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer$prepare$3$experimentResult$1$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failed to evaluate hold out groups " + automationSchedule2.getIdentifier();
                            }
                        });
                        automationRemoteDataAccess2 = automationPreparer2.remoteDataAccess;
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 7;
                        if (automationRemoteDataAccess2.notifyOutdated(automationSchedule2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return new RetryingQueue.Result.Retry(null, 1, null);
                    }
                    ExperimentResult experimentResult4 = (ExperimentResult) objM5047evaluateExperiments0E7RQCE;
                    AutomationPreparer automationPreparer13 = AutomationPreparer.this;
                    PrepareCache prepareCache4 = this.$prepareCache;
                    AutomationSchedule.ScheduleData data4 = this.$schedule.getData();
                    AutomationSchedule automationSchedule19 = this.$schedule;
                    AnonymousClass4 anonymousClass10 = new AnonymousClass4(AutomationPreparer.this, this.$deferredContext, deviceInfoProvider4, null);
                    AnonymousClass5 anonymousClass11 = new AnonymousClass5(AutomationPreparer.this, this.$schedule, experimentResult4, deviceInfoProvider4, this.$triggerSessionId, null);
                    final AutomationPreparer automationPreparer14 = AutomationPreparer.this;
                    Function2 function5 = new Function2() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepare.3.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final PreparedSchedule invoke(PreparedScheduleInfo info, PreparedScheduleData data5) {
                            Intrinsics.checkNotNullParameter(info, "info");
                            Intrinsics.checkNotNullParameter(data5, "data");
                            return automationPreparer14.prepareSchedule(info, data5, frequencyChecker2);
                        }
                    };
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 8;
                    objPrepareData = automationPreparer13.prepareData(prepareCache4, data4, automationSchedule19, anonymousClass10, anonymousClass11, function5, this);
                    if (objPrepareData == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objPrepareData;
                case 6:
                    frequencyChecker2 = (FrequencyChecker) this.L$1;
                    deviceInfoProvider3 = (DeviceInfoProvider) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objM5047evaluateExperiments0E7RQCE = ((Result) obj).getValue();
                    deviceInfoProvider4 = deviceInfoProvider3;
                    automationPreparer2 = AutomationPreparer.this;
                    automationSchedule2 = this.$schedule;
                    thM5280exceptionOrNullimpl2 = Result.m5280exceptionOrNullimpl(objM5047evaluateExperiments0E7RQCE);
                    if (thM5280exceptionOrNullimpl2 != null) {
                        UALog.m1747e(thM5280exceptionOrNullimpl2, (Function0<String>) new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer$prepare$3$experimentResult$1$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failed to evaluate hold out groups " + automationSchedule2.getIdentifier();
                            }
                        });
                        automationRemoteDataAccess2 = automationPreparer2.remoteDataAccess;
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 7;
                        if (automationRemoteDataAccess2.notifyOutdated(automationSchedule2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return new RetryingQueue.Result.Retry(null, 1, null);
                    }
                    ExperimentResult experimentResult5 = (ExperimentResult) objM5047evaluateExperiments0E7RQCE;
                    AutomationPreparer automationPreparer15 = AutomationPreparer.this;
                    PrepareCache prepareCache5 = this.$prepareCache;
                    AutomationSchedule.ScheduleData data5 = this.$schedule.getData();
                    AutomationSchedule automationSchedule110 = this.$schedule;
                    AnonymousClass4 anonymousClass12 = new AnonymousClass4(AutomationPreparer.this, this.$deferredContext, deviceInfoProvider4, null);
                    AnonymousClass5 anonymousClass13 = new AnonymousClass5(AutomationPreparer.this, this.$schedule, experimentResult5, deviceInfoProvider4, this.$triggerSessionId, null);
                    final AutomationPreparer automationPreparer16 = AutomationPreparer.this;
                    Function2 function6 = new Function2() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepare.3.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final PreparedSchedule invoke(PreparedScheduleInfo info, PreparedScheduleData data6) {
                            Intrinsics.checkNotNullParameter(info, "info");
                            Intrinsics.checkNotNullParameter(data6, "data");
                            return automationPreparer16.prepareSchedule(info, data6, frequencyChecker2);
                        }
                    };
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 8;
                    objPrepareData = automationPreparer15.prepareData(prepareCache5, data5, automationSchedule110, anonymousClass12, anonymousClass13, function6, this);
                    if (objPrepareData == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objPrepareData;
                case 7:
                    ResultKt.throwOnFailure(obj);
                    return new RetryingQueue.Result.Retry(null, 1, null);
                case 8:
                    ResultKt.throwOnFailure(obj);
                    return obj;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationPreparer$prepare$3$4, reason: invalid class name */
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

        /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationPreparer$prepare$3$5, reason: invalid class name */
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
                Object objM5048prepareInfoyxL6bBk;
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
                    objM5048prepareInfoyxL6bBk = automationPreparer.m5048prepareInfoyxL6bBk(automationSchedule, experimentResult, deviceInfoProvider, str, this);
                    if (objM5048prepareInfoyxL6bBk == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    objM5048prepareInfoyxL6bBk = ((Result) obj).getValue();
                }
                return Result.m5276boximpl(objM5048prepareInfoyxL6bBk);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:28:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:30:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX INFO: renamed from: prepareInfo-yxL6bBk, reason: not valid java name */
    public final Object m5048prepareInfoyxL6bBk(AutomationSchedule automationSchedule, ExperimentResult experimentResult, DeviceInfoProvider deviceInfoProvider, String str, Continuation continuation) {
        AutomationPreparer$prepareInfo$1 automationPreparer$prepareInfo$1;
        final AutomationSchedule automationSchedule2;
        ExperimentResult experimentResult2;
        Object objM5040resolve0E7RQCE;
        String str2;
        String str3;
        boolean z;
        AutomationSchedule automationSchedule3;
        String str4;
        ExperimentResult experimentResult3;
        String str5;
        JsonValue jsonValue;
        Integer priority;
        int iIntValue;
        DeviceInfoProvider deviceInfoProvider2 = deviceInfoProvider;
        if (continuation instanceof AutomationPreparer$prepareInfo$1) {
            automationPreparer$prepareInfo$1 = (AutomationPreparer$prepareInfo$1) continuation;
            int i = automationPreparer$prepareInfo$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                automationPreparer$prepareInfo$1.label = i - Integer.MIN_VALUE;
            } else {
                automationPreparer$prepareInfo$1 = new AutomationPreparer$prepareInfo$1(this, continuation);
            }
        } else {
            automationPreparer$prepareInfo$1 = new AutomationPreparer$prepareInfo$1(this, continuation);
        }
        Object obj = automationPreparer$prepareInfo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = automationPreparer$prepareInfo$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            AdditionalAudienceCheckerResolver additionalAudienceCheckerResolver = this.additionalAudienceResolver;
            AdditionalAudienceCheckOverrides additionalAudienceCheckOverrides = automationSchedule.getAdditionalAudienceCheckOverrides();
            automationSchedule2 = automationSchedule;
            automationPreparer$prepareInfo$1.L$0 = automationSchedule2;
            experimentResult2 = experimentResult;
            automationPreparer$prepareInfo$1.L$1 = experimentResult2;
            automationPreparer$prepareInfo$1.L$2 = deviceInfoProvider2;
            automationPreparer$prepareInfo$1.L$3 = str;
            automationPreparer$prepareInfo$1.label = 1;
            objM5040resolve0E7RQCE = additionalAudienceCheckerResolver.m5040resolve0E7RQCE(deviceInfoProvider2, additionalAudienceCheckOverrides, automationPreparer$prepareInfo$1);
            if (objM5040resolve0E7RQCE == coroutine_suspended) {
                return coroutine_suspended;
            }
            str2 = str;
        } else {
            if (i2 == 1) {
                str2 = (String) automationPreparer$prepareInfo$1.L$3;
                deviceInfoProvider2 = (DeviceInfoProvider) automationPreparer$prepareInfo$1.L$2;
                ExperimentResult experimentResult4 = (ExperimentResult) automationPreparer$prepareInfo$1.L$1;
                AutomationSchedule automationSchedule4 = (AutomationSchedule) automationPreparer$prepareInfo$1.L$0;
                ResultKt.throwOnFailure(obj);
                objM5040resolve0E7RQCE = ((Result) obj).getValue();
                experimentResult2 = experimentResult4;
                automationSchedule2 = automationSchedule4;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z2 = automationPreparer$prepareInfo$1.Z$0;
                JsonValue jsonValue2 = (JsonValue) automationPreparer$prepareInfo$1.L$5;
                String str6 = (String) automationPreparer$prepareInfo$1.L$4;
                String str7 = (String) automationPreparer$prepareInfo$1.L$3;
                String str8 = (String) automationPreparer$prepareInfo$1.L$2;
                ExperimentResult experimentResult5 = (ExperimentResult) automationPreparer$prepareInfo$1.L$1;
                automationSchedule3 = (AutomationSchedule) automationPreparer$prepareInfo$1.L$0;
                ResultKt.throwOnFailure(obj);
                z = z2;
                jsonValue = jsonValue2;
                str5 = str6;
                str4 = str7;
                str3 = str8;
                experimentResult3 = experimentResult5;
            }
            String contactId = ((StableContactInfo) obj).getContactId();
            JsonValue reportingContext = automationSchedule3.getReportingContext();
            priority = automationSchedule3.getPriority();
            if (priority != null) {
                iIntValue = priority.intValue();
            } else {
                iIntValue = 0;
            }
            return Result.m5277constructorimpl(new PreparedScheduleInfo(str4, str5, jsonValue, contactId, experimentResult3, reportingContext, str3, z, iIntValue));
        }
        Throwable thM5280exceptionOrNullimpl = Result.m5280exceptionOrNullimpl(objM5040resolve0E7RQCE);
        if (thM5280exceptionOrNullimpl != null) {
            UALog.m1753v(thM5280exceptionOrNullimpl, (Function0<String>) new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer$prepareInfo$additionalAudienceCheckResult$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Additional audience check failed " + automationSchedule2.getIdentifier();
                }
            });
            return Result.m5277constructorimpl(ResultKt.createFailure(thM5280exceptionOrNullimpl));
        }
        boolean zBooleanValue = ((Boolean) objM5040resolve0E7RQCE).booleanValue();
        String identifier = automationSchedule2.getIdentifier();
        String productId = automationSchedule2.getProductId();
        JsonValue campaigns = automationSchedule2.getCampaigns();
        automationPreparer$prepareInfo$1.L$0 = automationSchedule2;
        automationPreparer$prepareInfo$1.L$1 = experimentResult2;
        automationPreparer$prepareInfo$1.L$2 = str2;
        automationPreparer$prepareInfo$1.L$3 = identifier;
        automationPreparer$prepareInfo$1.L$4 = productId;
        automationPreparer$prepareInfo$1.L$5 = campaigns;
        automationPreparer$prepareInfo$1.Z$0 = zBooleanValue;
        automationPreparer$prepareInfo$1.label = 2;
        Object stableContactInfo = deviceInfoProvider2.getStableContactInfo(automationPreparer$prepareInfo$1);
        if (stableContactInfo == coroutine_suspended) {
            return coroutine_suspended;
        }
        str3 = str2;
        z = zBooleanValue;
        automationSchedule3 = automationSchedule2;
        str4 = identifier;
        experimentResult3 = experimentResult2;
        str5 = productId;
        jsonValue = campaigns;
        obj = stableContactInfo;
        String contactId2 = ((StableContactInfo) obj).getContactId();
        JsonValue reportingContext2 = automationSchedule3.getReportingContext();
        priority = automationSchedule3.getPriority();
        if (priority != null) {
            iIntValue = priority.intValue();
        } else {
            iIntValue = 0;
        }
        return Result.m5277constructorimpl(new PreparedScheduleInfo(str4, str5, jsonValue, contactId2, experimentResult3, reportingContext2, str3, z, iIntValue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PreparedSchedule prepareSchedule(PreparedScheduleInfo info, PreparedScheduleData data, FrequencyChecker frequencyChecker) {
        return new PreparedSchedule(info, data, frequencyChecker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object deferredRequest(DeferredAutomationData deferredAutomationData, DeferredTriggerContext deferredTriggerContext, DeviceInfoProvider deviceInfoProvider, Continuation continuation) {
        C50651 c50651;
        DeferredTriggerContext deferredTriggerContext2;
        Uri uri;
        String str;
        DeferredTriggerContext deferredTriggerContext3;
        Uri uri2;
        DeviceInfoProvider deviceInfoProvider2;
        DeviceInfoProvider deviceInfoProvider3 = deviceInfoProvider;
        if (continuation instanceof C50651) {
            c50651 = (C50651) continuation;
            int i = c50651.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c50651.label = i - Integer.MIN_VALUE;
            } else {
                c50651 = new C50651(continuation);
            }
        } else {
            c50651 = new C50651(continuation);
        }
        Object obj = c50651.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c50651.label;
        if (i2 != 0) {
            if (i2 == 1) {
                Uri uri3 = (Uri) c50651.L$2;
                DeviceInfoProvider deviceInfoProvider4 = (DeviceInfoProvider) c50651.L$1;
                DeferredTriggerContext deferredTriggerContext4 = (DeferredTriggerContext) c50651.L$0;
                ResultKt.throwOnFailure(obj);
                uri = uri3;
                deviceInfoProvider3 = deviceInfoProvider4;
                deferredTriggerContext2 = deferredTriggerContext4;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String str2 = (String) c50651.L$3;
                Uri uri4 = (Uri) c50651.L$2;
                deviceInfoProvider2 = (DeviceInfoProvider) c50651.L$1;
                DeferredTriggerContext deferredTriggerContext5 = (DeferredTriggerContext) c50651.L$0;
                ResultKt.throwOnFailure(obj);
                str = str2;
                deferredTriggerContext3 = deferredTriggerContext5;
                uri2 = uri4;
            }
            return new DeferredRequest(uri2, str, ((StableContactInfo) obj).getContactId(), deferredTriggerContext3, deviceInfoProvider2.getLocale(), deviceInfoProvider2.isNotificationsOptedIn(), deviceInfoProvider2.getAppVersionName(), null, 128, null);
        }
        ResultKt.throwOnFailure(obj);
        Uri url = deferredAutomationData.getUrl();
        deferredTriggerContext2 = deferredTriggerContext;
        c50651.L$0 = deferredTriggerContext2;
        c50651.L$1 = deviceInfoProvider3;
        c50651.L$2 = url;
        c50651.label = 1;
        Object channelId = deviceInfoProvider3.getChannelId(c50651);
        if (channelId == coroutine_suspended) {
            return coroutine_suspended;
        }
        uri = url;
        obj = channelId;
        String str3 = (String) obj;
        c50651.L$0 = deferredTriggerContext2;
        c50651.L$1 = deviceInfoProvider3;
        c50651.L$2 = uri;
        c50651.L$3 = str3;
        c50651.label = 2;
        Object stableContactInfo = deviceInfoProvider3.getStableContactInfo(c50651);
        if (stableContactInfo == coroutine_suspended) {
            return coroutine_suspended;
        }
        str = str3;
        obj = stableContactInfo;
        deferredTriggerContext3 = deferredTriggerContext2;
        uri2 = uri;
        deviceInfoProvider2 = deviceInfoProvider3;
        return new DeferredRequest(uri2, str, ((StableContactInfo) obj).getContactId(), deferredTriggerContext3, deviceInfoProvider2.getLocale(), deviceInfoProvider2.isNotificationsOptedIn(), deviceInfoProvider2.getAppVersionName(), null, 128, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:26:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:28:0x0100 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x0101  */
    /* JADX WARN: Code duplicated, block: B:32:0x010b  */
    /* JADX WARN: Code duplicated, block: B:33:0x0123  */
    /* JADX WARN: Code duplicated, block: B:35:0x012e  */
    /* JADX WARN: Code duplicated, block: B:49:0x017b  */
    /* JADX WARN: Code duplicated, block: B:51:0x0194 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x0195  */
    /* JADX WARN: Code duplicated, block: B:55:0x019f  */
    /* JADX WARN: Code duplicated, block: B:56:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:58:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:68:0x023a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:69:0x023b A[PHI: r7
  0x023b: PHI (r7v17 java.lang.Object) = (r7v15 java.lang.Object), (r7v1 java.lang.Object) binds: [B:67:0x0238, B:12:0x003f] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    public final Object prepareData(PrepareCache prepareCache, final AutomationSchedule.ScheduleData scheduleData, AutomationSchedule automationSchedule, Function2 function2, Function1 function1, Function2 function3, Continuation continuation) {
        C50681 c50681;
        DeferredAutomationData deferred$urbanairship_automation_release;
        Object objInvoke;
        AutomationPreparer automationPreparer;
        PrepareCache prepareCache2;
        AutomationSchedule.ScheduleData scheduleData2;
        AutomationSchedule.ScheduleData scheduleData3;
        Object value;
        Throwable thM5280exceptionOrNullimpl;
        PreparedScheduleInfo preparedScheduleInfo;
        Object objMo5033prepare0E7RQCE;
        Function2 function4;
        Object value2;
        PreparedScheduleInfo preparedScheduleInfo2;
        Throwable thM5280exceptionOrNullimpl2;
        Object value3;
        Throwable thM5280exceptionOrNullimpl3;
        PreparedScheduleInfo preparedScheduleInfo3;
        Object objMo5033prepare0E7RQCE2;
        Function2 function5;
        Object value4;
        PreparedScheduleInfo preparedScheduleInfo4;
        Throwable thM5280exceptionOrNullimpl4;
        AutomationPreparer automationPreparer2 = this;
        PrepareCache prepareCache3 = prepareCache;
        final AutomationSchedule automationSchedule2 = automationSchedule;
        Function2 function6 = function2;
        Function1 function7 = function1;
        Function2 function8 = function3;
        if (continuation instanceof C50681) {
            c50681 = (C50681) continuation;
            int i = c50681.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c50681.label = i - Integer.MIN_VALUE;
            } else {
                c50681 = automationPreparer2.new C50681(continuation);
            }
        } else {
            c50681 = automationPreparer2.new C50681(continuation);
        }
        Object objInvoke2 = c50681.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c50681.label) {
            case 0:
                ResultKt.throwOnFailure(objInvoke2);
                if (scheduleData instanceof AutomationSchedule.ScheduleData.Actions) {
                    c50681.L$0 = automationPreparer2;
                    c50681.L$1 = scheduleData;
                    c50681.L$2 = function8;
                    c50681.label = 1;
                    objInvoke2 = function7.invoke(c50681);
                    if (objInvoke2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    scheduleData3 = scheduleData;
                    value = ((Result) objInvoke2).getValue();
                    thM5280exceptionOrNullimpl = Result.m5280exceptionOrNullimpl(value);
                    if (thM5280exceptionOrNullimpl == null) {
                        UALog.m1747e(thM5280exceptionOrNullimpl, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer$prepareData$info$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failed to prepare schedule data";
                            }
                        });
                        return new RetryingQueue.Result.Retry(null, 1, null);
                    }
                    preparedScheduleInfo = (PreparedScheduleInfo) value;
                    AutomationPreparerDelegate automationPreparerDelegate = automationPreparer2.actionPreparer;
                    JsonValue actions = ((AutomationSchedule.ScheduleData.Actions) scheduleData3).getActions();
                    c50681.L$0 = function8;
                    c50681.L$1 = preparedScheduleInfo;
                    c50681.L$2 = null;
                    c50681.label = 2;
                    objMo5033prepare0E7RQCE = automationPreparerDelegate.mo5033prepare0E7RQCE(actions, preparedScheduleInfo, c50681);
                    if (objMo5033prepare0E7RQCE == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function4 = function8;
                    value2 = objMo5033prepare0E7RQCE;
                    preparedScheduleInfo2 = preparedScheduleInfo;
                    thM5280exceptionOrNullimpl2 = Result.m5280exceptionOrNullimpl(value2);
                    if (thM5280exceptionOrNullimpl2 != null) {
                        UALog.m1747e(thM5280exceptionOrNullimpl2, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer$prepareData$3$1
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failed to prepare actions";
                            }
                        });
                        return new RetryingQueue.Result.Retry(null, 1, null);
                    }
                    return new RetryingQueue.Result.Success(new SchedulePrepareResult.Prepared((PreparedSchedule) function4.invoke(preparedScheduleInfo2, new PreparedScheduleData.Action((JsonValue) value2))), false, 2, null);
                }
                if (scheduleData instanceof AutomationSchedule.ScheduleData.InAppMessageData) {
                    if (!((AutomationSchedule.ScheduleData.InAppMessageData) scheduleData).getMessage().getDisplayContent().validate()) {
                        UALog.d$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepareData.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "⚠️ Message did not pass validation: " + ((AutomationSchedule.ScheduleData.InAppMessageData) scheduleData).getMessage().getName() + " - skipping(" + automationSchedule2.getIdentifier() + ").";
                            }
                        }, 1, null);
                        return new RetryingQueue.Result.Success(SchedulePrepareResult.Skip.INSTANCE, false, 2, null);
                    }
                    c50681.L$0 = automationPreparer2;
                    c50681.L$1 = scheduleData;
                    c50681.L$2 = function8;
                    c50681.label = 3;
                    objInvoke2 = function7.invoke(c50681);
                    if (objInvoke2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    scheduleData2 = scheduleData;
                    value3 = ((Result) objInvoke2).getValue();
                    thM5280exceptionOrNullimpl3 = Result.m5280exceptionOrNullimpl(value3);
                    if (thM5280exceptionOrNullimpl3 == null) {
                        UALog.m1747e(thM5280exceptionOrNullimpl3, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer$prepareData$info$2$1
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failed to prepare schedule data";
                            }
                        });
                        return new RetryingQueue.Result.Retry(null, 1, null);
                    }
                    preparedScheduleInfo3 = (PreparedScheduleInfo) value3;
                    AutomationPreparerDelegate automationPreparerDelegate2 = automationPreparer2.messagePreparer;
                    InAppMessage message = ((AutomationSchedule.ScheduleData.InAppMessageData) scheduleData2).getMessage();
                    c50681.L$0 = function8;
                    c50681.L$1 = preparedScheduleInfo3;
                    c50681.L$2 = null;
                    c50681.label = 4;
                    objMo5033prepare0E7RQCE2 = automationPreparerDelegate2.mo5033prepare0E7RQCE(message, preparedScheduleInfo3, c50681);
                    if (objMo5033prepare0E7RQCE2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function5 = function8;
                    value4 = objMo5033prepare0E7RQCE2;
                    preparedScheduleInfo4 = preparedScheduleInfo3;
                    thM5280exceptionOrNullimpl4 = Result.m5280exceptionOrNullimpl(value4);
                    if (thM5280exceptionOrNullimpl4 != null) {
                        UALog.m1747e(thM5280exceptionOrNullimpl4, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer$prepareData$6$1
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failed to prepare message";
                            }
                        });
                        return new RetryingQueue.Result.Retry(null, 1, null);
                    }
                    return new RetryingQueue.Result.Success(new SchedulePrepareResult.Prepared((PreparedSchedule) function5.invoke(preparedScheduleInfo4, new PreparedScheduleData.InAppMessage((PreparedInAppMessageData) value4))), false, 2, null);
                }
                if (!(scheduleData instanceof AutomationSchedule.ScheduleData.Deferred)) {
                    throw new NoWhenBranchMatchedException();
                }
                AutomationSchedule.ScheduleData.Deferred deferred = (AutomationSchedule.ScheduleData.Deferred) scheduleData;
                deferred$urbanairship_automation_release = deferred.getDeferred$urbanairship_automation_release();
                DeferredAutomationData deferred$urbanairship_automation_release2 = deferred.getDeferred$urbanairship_automation_release();
                c50681.L$0 = automationPreparer2;
                c50681.L$1 = prepareCache3;
                c50681.L$2 = automationSchedule2;
                c50681.L$3 = function6;
                c50681.L$4 = function7;
                c50681.L$5 = function8;
                c50681.L$6 = automationPreparer2;
                c50681.L$7 = prepareCache3;
                c50681.L$8 = deferred$urbanairship_automation_release;
                c50681.label = 5;
                objInvoke = function6.invoke(deferred$urbanairship_automation_release2, c50681);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                automationPreparer = automationPreparer2;
                prepareCache2 = prepareCache3;
                C50707 c50707 = automationPreparer.new C50707(prepareCache2, automationSchedule2, function6, function7, function8, null);
                c50681.L$0 = null;
                c50681.L$1 = null;
                c50681.L$2 = null;
                c50681.L$3 = null;
                c50681.L$4 = null;
                c50681.L$5 = null;
                c50681.L$6 = null;
                c50681.L$7 = null;
                c50681.L$8 = null;
                c50681.label = 6;
                objInvoke2 = automationPreparer2.prepareDeferred(prepareCache3, deferred$urbanairship_automation_release, (DeferredRequest) objInvoke, automationSchedule2, c50707, c50681);
                if (objInvoke2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objInvoke2;
            case 1:
                Function2 function9 = (Function2) c50681.L$2;
                scheduleData3 = (AutomationSchedule.ScheduleData) c50681.L$1;
                AutomationPreparer automationPreparer3 = (AutomationPreparer) c50681.L$0;
                ResultKt.throwOnFailure(objInvoke2);
                function8 = function9;
                automationPreparer2 = automationPreparer3;
                value = ((Result) objInvoke2).getValue();
                thM5280exceptionOrNullimpl = Result.m5280exceptionOrNullimpl(value);
                if (thM5280exceptionOrNullimpl == null) {
                    UALog.m1747e(thM5280exceptionOrNullimpl, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer$prepareData$info$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to prepare schedule data";
                        }
                    });
                    return new RetryingQueue.Result.Retry(null, 1, null);
                }
                preparedScheduleInfo = (PreparedScheduleInfo) value;
                AutomationPreparerDelegate automationPreparerDelegate3 = automationPreparer2.actionPreparer;
                JsonValue actions2 = ((AutomationSchedule.ScheduleData.Actions) scheduleData3).getActions();
                c50681.L$0 = function8;
                c50681.L$1 = preparedScheduleInfo;
                c50681.L$2 = null;
                c50681.label = 2;
                objMo5033prepare0E7RQCE = automationPreparerDelegate3.mo5033prepare0E7RQCE(actions2, preparedScheduleInfo, c50681);
                if (objMo5033prepare0E7RQCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function4 = function8;
                value2 = objMo5033prepare0E7RQCE;
                preparedScheduleInfo2 = preparedScheduleInfo;
                thM5280exceptionOrNullimpl2 = Result.m5280exceptionOrNullimpl(value2);
                if (thM5280exceptionOrNullimpl2 != null) {
                    UALog.m1747e(thM5280exceptionOrNullimpl2, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer$prepareData$3$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to prepare actions";
                        }
                    });
                    return new RetryingQueue.Result.Retry(null, 1, null);
                }
                return new RetryingQueue.Result.Success(new SchedulePrepareResult.Prepared((PreparedSchedule) function4.invoke(preparedScheduleInfo2, new PreparedScheduleData.Action((JsonValue) value2))), false, 2, null);
            case 2:
                preparedScheduleInfo2 = (PreparedScheduleInfo) c50681.L$1;
                function4 = (Function2) c50681.L$0;
                ResultKt.throwOnFailure(objInvoke2);
                value2 = ((Result) objInvoke2).getValue();
                thM5280exceptionOrNullimpl2 = Result.m5280exceptionOrNullimpl(value2);
                if (thM5280exceptionOrNullimpl2 != null) {
                    UALog.m1747e(thM5280exceptionOrNullimpl2, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer$prepareData$3$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to prepare actions";
                        }
                    });
                    return new RetryingQueue.Result.Retry(null, 1, null);
                }
                return new RetryingQueue.Result.Success(new SchedulePrepareResult.Prepared((PreparedSchedule) function4.invoke(preparedScheduleInfo2, new PreparedScheduleData.Action((JsonValue) value2))), false, 2, null);
            case 3:
                Function2 function10 = (Function2) c50681.L$2;
                scheduleData2 = (AutomationSchedule.ScheduleData) c50681.L$1;
                AutomationPreparer automationPreparer4 = (AutomationPreparer) c50681.L$0;
                ResultKt.throwOnFailure(objInvoke2);
                function8 = function10;
                automationPreparer2 = automationPreparer4;
                value3 = ((Result) objInvoke2).getValue();
                thM5280exceptionOrNullimpl3 = Result.m5280exceptionOrNullimpl(value3);
                if (thM5280exceptionOrNullimpl3 == null) {
                    UALog.m1747e(thM5280exceptionOrNullimpl3, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer$prepareData$info$2$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to prepare schedule data";
                        }
                    });
                    return new RetryingQueue.Result.Retry(null, 1, null);
                }
                preparedScheduleInfo3 = (PreparedScheduleInfo) value3;
                AutomationPreparerDelegate automationPreparerDelegate4 = automationPreparer2.messagePreparer;
                InAppMessage message2 = ((AutomationSchedule.ScheduleData.InAppMessageData) scheduleData2).getMessage();
                c50681.L$0 = function8;
                c50681.L$1 = preparedScheduleInfo3;
                c50681.L$2 = null;
                c50681.label = 4;
                objMo5033prepare0E7RQCE2 = automationPreparerDelegate4.mo5033prepare0E7RQCE(message2, preparedScheduleInfo3, c50681);
                if (objMo5033prepare0E7RQCE2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function5 = function8;
                value4 = objMo5033prepare0E7RQCE2;
                preparedScheduleInfo4 = preparedScheduleInfo3;
                thM5280exceptionOrNullimpl4 = Result.m5280exceptionOrNullimpl(value4);
                if (thM5280exceptionOrNullimpl4 != null) {
                    UALog.m1747e(thM5280exceptionOrNullimpl4, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer$prepareData$6$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to prepare message";
                        }
                    });
                    return new RetryingQueue.Result.Retry(null, 1, null);
                }
                return new RetryingQueue.Result.Success(new SchedulePrepareResult.Prepared((PreparedSchedule) function5.invoke(preparedScheduleInfo4, new PreparedScheduleData.InAppMessage((PreparedInAppMessageData) value4))), false, 2, null);
            case 4:
                preparedScheduleInfo4 = (PreparedScheduleInfo) c50681.L$1;
                function5 = (Function2) c50681.L$0;
                ResultKt.throwOnFailure(objInvoke2);
                value4 = ((Result) objInvoke2).getValue();
                thM5280exceptionOrNullimpl4 = Result.m5280exceptionOrNullimpl(value4);
                if (thM5280exceptionOrNullimpl4 != null) {
                    UALog.m1747e(thM5280exceptionOrNullimpl4, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer$prepareData$6$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to prepare message";
                        }
                    });
                    return new RetryingQueue.Result.Retry(null, 1, null);
                }
                return new RetryingQueue.Result.Success(new SchedulePrepareResult.Prepared((PreparedSchedule) function5.invoke(preparedScheduleInfo4, new PreparedScheduleData.InAppMessage((PreparedInAppMessageData) value4))), false, 2, null);
            case 5:
                DeferredAutomationData deferredAutomationData = (DeferredAutomationData) c50681.L$8;
                prepareCache3 = (PrepareCache) c50681.L$7;
                AutomationPreparer automationPreparer5 = (AutomationPreparer) c50681.L$6;
                Function2 function11 = (Function2) c50681.L$5;
                Function1 function12 = (Function1) c50681.L$4;
                Function2 function13 = (Function2) c50681.L$3;
                AutomationSchedule automationSchedule3 = (AutomationSchedule) c50681.L$2;
                prepareCache2 = (PrepareCache) c50681.L$1;
                automationPreparer = (AutomationPreparer) c50681.L$0;
                ResultKt.throwOnFailure(objInvoke2);
                deferred$urbanairship_automation_release = deferredAutomationData;
                automationPreparer2 = automationPreparer5;
                objInvoke = objInvoke2;
                function8 = function11;
                automationSchedule2 = automationSchedule3;
                function7 = function12;
                function6 = function13;
                C50707 c50708 = automationPreparer.new C50707(prepareCache2, automationSchedule2, function6, function7, function8, null);
                c50681.L$0 = null;
                c50681.L$1 = null;
                c50681.L$2 = null;
                c50681.L$3 = null;
                c50681.L$4 = null;
                c50681.L$5 = null;
                c50681.L$6 = null;
                c50681.L$7 = null;
                c50681.L$8 = null;
                c50681.label = 6;
                objInvoke2 = automationPreparer2.prepareDeferred(prepareCache3, deferred$urbanairship_automation_release, (DeferredRequest) objInvoke, automationSchedule2, c50708, c50681);
                if (objInvoke2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objInvoke2;
            case 6:
                ResultKt.throwOnFailure(objInvoke2);
                return objInvoke2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.automation.engine.AutomationPreparer$prepareData$7 */
    static final class C50707 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function2 $onDeferredRequest;
        final /* synthetic */ Function1 $onPrepareInfo;
        final /* synthetic */ Function2 $onPrepareSchedule;
        final /* synthetic */ PrepareCache $prepareCache;
        final /* synthetic */ AutomationSchedule $schedule;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C50707(PrepareCache prepareCache, AutomationSchedule automationSchedule, Function2 function2, Function1 function1, Function2 function3, Continuation continuation) {
            super(2, continuation);
            this.$prepareCache = prepareCache;
            this.$schedule = automationSchedule;
            this.$onDeferredRequest = function2;
            this.$onPrepareInfo = function1;
            this.$onPrepareSchedule = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C50707 c50707 = AutomationPreparer.this.new C50707(this.$prepareCache, this.$schedule, this.$onDeferredRequest, this.$onPrepareInfo, this.$onPrepareSchedule, continuation);
            c50707.L$0 = obj;
            return c50707;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AutomationSchedule.ScheduleData scheduleData, Continuation continuation) {
            return ((C50707) create(scheduleData, continuation)).invokeSuspend(Unit.INSTANCE);
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
                Function2 function3 = this.$onPrepareSchedule;
                this.label = 1;
                obj = automationPreparer.prepareData(prepareCache, scheduleData, automationSchedule, function2, function1, function3, this);
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
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: evaluateExperiments-0E7RQCE, reason: not valid java name */
    public final Object m5047evaluateExperiments0E7RQCE(AutomationSchedule automationSchedule, DeviceInfoProvider deviceInfoProvider, Continuation continuation) {
        AutomationPreparer$evaluateExperiments$1 automationPreparer$evaluateExperiments$1;
        if (continuation instanceof AutomationPreparer$evaluateExperiments$1) {
            automationPreparer$evaluateExperiments$1 = (AutomationPreparer$evaluateExperiments$1) continuation;
            int i = automationPreparer$evaluateExperiments$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                automationPreparer$evaluateExperiments$1.label = i - Integer.MIN_VALUE;
            } else {
                automationPreparer$evaluateExperiments$1 = new AutomationPreparer$evaluateExperiments$1(this, continuation);
            }
        } else {
            automationPreparer$evaluateExperiments$1 = new AutomationPreparer$evaluateExperiments$1(this, continuation);
        }
        Object obj = automationPreparer$evaluateExperiments$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = automationPreparer$evaluateExperiments$1.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        if (AutomationPreparerKt.evaluateExperiments(automationSchedule)) {
            ExperimentManager experimentManager = this.experiments;
            String messageType = automationSchedule.getMessageType();
            if (messageType == null) {
                messageType = AutomationSchedule.DEFAULT_MESSAGE_TYPE;
            }
            MessageInfo messageInfo = new MessageInfo(messageType, automationSchedule.getCampaigns());
            automationPreparer$evaluateExperiments$1.label = 1;
            Object objM5086evaluateExperiments0E7RQCE = experimentManager.m5086evaluateExperiments0E7RQCE(messageInfo, deviceInfoProvider, automationPreparer$evaluateExperiments$1);
            return objM5086evaluateExperiments0E7RQCE == coroutine_suspended ? coroutine_suspended : objM5086evaluateExperiments0E7RQCE;
        }
        return Result.m5277constructorimpl(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:32:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x00da  */
    /* JADX WARN: Code duplicated, block: B:38:0x00de  */
    /* JADX WARN: Code duplicated, block: B:40:0x00f2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:44:0x0100  */
    /* JADX WARN: Code duplicated, block: B:46:0x010a  */
    /* JADX WARN: Code duplicated, block: B:47:0x011b  */
    /* JADX WARN: Code duplicated, block: B:49:0x0121  */
    /* JADX WARN: Code duplicated, block: B:51:0x0125  */
    /* JADX WARN: Code duplicated, block: B:53:0x0133  */
    /* JADX WARN: Code duplicated, block: B:54:0x013a  */
    /* JADX WARN: Code duplicated, block: B:55:0x0143  */
    /* JADX WARN: Code duplicated, block: B:57:0x0147  */
    /* JADX WARN: Code duplicated, block: B:59:0x0158  */
    /* JADX WARN: Code duplicated, block: B:61:0x0166 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x0168  */
    /* JADX WARN: Code duplicated, block: B:64:0x0174  */
    /* JADX WARN: Code duplicated, block: B:65:0x0182  */
    /* JADX WARN: Code duplicated, block: B:67:0x0199 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:68:0x019a A[PHI: r2
  0x019a: PHI (r2v15 java.lang.Object) = (r2v9 java.lang.Object), (r2v1 java.lang.Object) binds: [B:66:0x0197, B:15:0x0039] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Code duplicated, block: B:69:0x019b  */
    /* JADX WARN: Code duplicated, block: B:71:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:73:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:74:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:76:0x01d3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:77:0x01d4 A[PHI: r2
  0x01d4: PHI (r2v14 java.lang.Object) = (r2v8 java.lang.Object), (r2v1 java.lang.Object) binds: [B:75:0x01d1, B:18:0x0046] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Code duplicated, block: B:78:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:80:0x01df  */
    public final Object prepareDeferred(PrepareCache prepareCache, DeferredAutomationData deferredAutomationData, DeferredRequest deferredRequest, AutomationSchedule automationSchedule, Function2 function2, Continuation continuation) {
        C50711 c50711;
        final DeferredResult deferredResult;
        PrepareCache prepareCache2;
        Function2 function3;
        DeferredAutomationData deferredAutomationData2;
        AutomationPreparer automationPreparer;
        DeferredResult.Success success;
        int i;
        JsonValue actions;
        InAppMessage message;
        Long retryAfter;
        Duration durationM5770boximpl;
        AutomationRemoteDataAccess automationRemoteDataAccess;
        AutomationRemoteDataAccess automationRemoteDataAccess2;
        final AutomationSchedule automationSchedule2 = automationSchedule;
        if (continuation instanceof C50711) {
            c50711 = (C50711) continuation;
            int i2 = c50711.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c50711.label = i2 - Integer.MIN_VALUE;
            } else {
                c50711 = new C50711(continuation);
            }
        } else {
            c50711 = new C50711(continuation);
        }
        Object objResolve = c50711.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c50711.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objResolve);
            UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepareDeferred.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Resolving deferred " + automationSchedule2.getIdentifier();
                }
            }, 1, null);
            deferredResult = prepareCache.getDeferredResult();
            if (deferredResult == null) {
                DeferredResolver deferredResolver = this.deferredResolver;
                AutomationPreparer$prepareDeferred$result$1 automationPreparer$prepareDeferred$result$1 = new AutomationPreparer$prepareDeferred$result$1(DeferredScheduleResult.INSTANCE);
                c50711.L$0 = this;
                prepareCache2 = prepareCache;
                c50711.L$1 = prepareCache2;
                c50711.L$2 = deferredAutomationData;
                c50711.L$3 = automationSchedule2;
                function3 = function2;
                c50711.L$4 = function3;
                c50711.label = 1;
                objResolve = deferredResolver.resolve(deferredRequest, automationPreparer$prepareDeferred$result$1, c50711);
                if (objResolve == coroutine_suspended) {
                    return coroutine_suspended;
                }
                deferredAutomationData2 = deferredAutomationData;
                automationPreparer = this;
            } else {
                prepareCache2 = prepareCache;
                function3 = function2;
                deferredAutomationData2 = deferredAutomationData;
                automationPreparer = this;
            }
            UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepareDeferred.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Deferred result " + automationSchedule2.getIdentifier() + ' ' + deferredResult;
                }
            }, 1, null);
            if (deferredResult instanceof DeferredResult.NotFound) {
                automationRemoteDataAccess2 = automationPreparer.remoteDataAccess;
                c50711.L$0 = null;
                c50711.L$1 = null;
                c50711.L$2 = null;
                c50711.L$3 = null;
                c50711.L$4 = null;
                c50711.label = 2;
                if (automationRemoteDataAccess2.notifyOutdated(automationSchedule2, c50711) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return new RetryingQueue.Result.Success(SchedulePrepareResult.Invalidate.INSTANCE, false, 2, null);
            }
            if (deferredResult instanceof DeferredResult.OutOfDate) {
                automationRemoteDataAccess = automationPreparer.remoteDataAccess;
                c50711.L$0 = null;
                c50711.L$1 = null;
                c50711.L$2 = null;
                c50711.L$3 = null;
                c50711.L$4 = null;
                c50711.label = 3;
                if (automationRemoteDataAccess.notifyOutdated(automationSchedule2, c50711) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return new RetryingQueue.Result.Success(SchedulePrepareResult.Invalidate.INSTANCE, false, 2, null);
            }
            if (deferredResult instanceof DeferredResult.RetriableError) {
                retryAfter = ((DeferredResult.RetriableError) deferredResult).getRetryAfter();
                if (retryAfter != null) {
                    Duration.Companion companion = Duration.INSTANCE;
                    durationM5770boximpl = Duration.m5770boximpl(DurationKt.toDuration(retryAfter.longValue(), DurationUnit.SECONDS));
                } else {
                    durationM5770boximpl = null;
                }
                return new RetryingQueue.Result.Retry(durationM5770boximpl, null);
            }
            if (deferredResult instanceof DeferredResult.TimedOut) {
                if (!Intrinsics.areEqual(deferredAutomationData2.getRetryOnTimeOut(), Boxing.boxBoolean(false))) {
                    return new RetryingQueue.Result.Retry(null, 1, null);
                }
                return new RetryingQueue.Result.Success(SchedulePrepareResult.Penalize.INSTANCE, true);
            }
            if (deferredResult instanceof DeferredResult.Success) {
                throw new NoWhenBranchMatchedException();
            }
            prepareCache2.setDeferredResult(deferredResult);
            success = (DeferredResult.Success) deferredResult;
            if (((DeferredScheduleResult) success.getResult()).isAudienceMatch()) {
                i = WhenMappings.$EnumSwitchMapping$0[deferredAutomationData2.getType().ordinal()];
                if (i != 1) {
                    actions = ((DeferredScheduleResult) success.getResult()).getActions();
                    if (actions == null) {
                        UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepareDeferred.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failed to get result for deferred " + automationSchedule2.getIdentifier();
                            }
                        }, 1, null);
                        return new RetryingQueue.Result.Retry(null, 1, null);
                    }
                    AutomationSchedule.ScheduleData.Actions actions2 = new AutomationSchedule.ScheduleData.Actions(actions);
                    c50711.L$0 = null;
                    c50711.L$1 = null;
                    c50711.L$2 = null;
                    c50711.L$3 = null;
                    c50711.L$4 = null;
                    c50711.label = 4;
                    objResolve = function3.invoke(actions2, c50711);
                    if (objResolve == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objResolve;
                }
                if (i == 2) {
                    message = ((DeferredScheduleResult) success.getResult()).getMessage();
                    if (message == null) {
                        UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepareDeferred.5
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Failed to get result for deferred " + automationSchedule2.getIdentifier();
                            }
                        }, 1, null);
                        return new RetryingQueue.Result.Retry(null, 1, null);
                    }
                    AutomationSchedule.ScheduleData.InAppMessageData inAppMessageData = new AutomationSchedule.ScheduleData.InAppMessageData(message);
                    c50711.L$0 = null;
                    c50711.L$1 = null;
                    c50711.L$2 = null;
                    c50711.L$3 = null;
                    c50711.L$4 = null;
                    c50711.label = 5;
                    objResolve = function3.invoke(inAppMessageData, c50711);
                    if (objResolve == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objResolve;
                }
                throw new NoWhenBranchMatchedException();
            }
            return new RetryingQueue.Result.Success(AutomationPreparerKt.audienceMissBehaviorResult(automationSchedule2), true);
        }
        if (i3 != 1) {
            if (i3 == 2) {
                ResultKt.throwOnFailure(objResolve);
                return new RetryingQueue.Result.Success(SchedulePrepareResult.Invalidate.INSTANCE, false, 2, null);
            }
            if (i3 == 3) {
                ResultKt.throwOnFailure(objResolve);
                return new RetryingQueue.Result.Success(SchedulePrepareResult.Invalidate.INSTANCE, false, 2, null);
            }
            if (i3 == 4) {
                ResultKt.throwOnFailure(objResolve);
                return objResolve;
            }
            if (i3 != 5) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objResolve);
            return objResolve;
        }
        Function2 function4 = (Function2) c50711.L$4;
        automationSchedule2 = (AutomationSchedule) c50711.L$3;
        deferredAutomationData2 = (DeferredAutomationData) c50711.L$2;
        prepareCache2 = (PrepareCache) c50711.L$1;
        automationPreparer = (AutomationPreparer) c50711.L$0;
        ResultKt.throwOnFailure(objResolve);
        function3 = function4;
        deferredResult = (DeferredResult) objResolve;
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepareDeferred.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Deferred result " + automationSchedule2.getIdentifier() + ' ' + deferredResult;
            }
        }, 1, null);
        if (deferredResult instanceof DeferredResult.NotFound) {
            automationRemoteDataAccess2 = automationPreparer.remoteDataAccess;
            c50711.L$0 = null;
            c50711.L$1 = null;
            c50711.L$2 = null;
            c50711.L$3 = null;
            c50711.L$4 = null;
            c50711.label = 2;
            if (automationRemoteDataAccess2.notifyOutdated(automationSchedule2, c50711) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return new RetryingQueue.Result.Success(SchedulePrepareResult.Invalidate.INSTANCE, false, 2, null);
        }
        if (deferredResult instanceof DeferredResult.OutOfDate) {
            automationRemoteDataAccess = automationPreparer.remoteDataAccess;
            c50711.L$0 = null;
            c50711.L$1 = null;
            c50711.L$2 = null;
            c50711.L$3 = null;
            c50711.L$4 = null;
            c50711.label = 3;
            if (automationRemoteDataAccess.notifyOutdated(automationSchedule2, c50711) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return new RetryingQueue.Result.Success(SchedulePrepareResult.Invalidate.INSTANCE, false, 2, null);
        }
        if (deferredResult instanceof DeferredResult.RetriableError) {
            retryAfter = ((DeferredResult.RetriableError) deferredResult).getRetryAfter();
            if (retryAfter != null) {
                Duration.Companion companion2 = Duration.INSTANCE;
                durationM5770boximpl = Duration.m5770boximpl(DurationKt.toDuration(retryAfter.longValue(), DurationUnit.SECONDS));
            } else {
                durationM5770boximpl = null;
            }
            return new RetryingQueue.Result.Retry(durationM5770boximpl, null);
        }
        if (deferredResult instanceof DeferredResult.TimedOut) {
            if (!Intrinsics.areEqual(deferredAutomationData2.getRetryOnTimeOut(), Boxing.boxBoolean(false))) {
                return new RetryingQueue.Result.Retry(null, 1, null);
            }
            return new RetryingQueue.Result.Success(SchedulePrepareResult.Penalize.INSTANCE, true);
        }
        if (deferredResult instanceof DeferredResult.Success) {
            throw new NoWhenBranchMatchedException();
        }
        prepareCache2.setDeferredResult(deferredResult);
        success = (DeferredResult.Success) deferredResult;
        if (((DeferredScheduleResult) success.getResult()).isAudienceMatch()) {
            i = WhenMappings.$EnumSwitchMapping$0[deferredAutomationData2.getType().ordinal()];
            if (i != 1) {
                actions = ((DeferredScheduleResult) success.getResult()).getActions();
                if (actions == null) {
                    UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepareDeferred.4
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to get result for deferred " + automationSchedule2.getIdentifier();
                        }
                    }, 1, null);
                    return new RetryingQueue.Result.Retry(null, 1, null);
                }
                AutomationSchedule.ScheduleData.Actions actions3 = new AutomationSchedule.ScheduleData.Actions(actions);
                c50711.L$0 = null;
                c50711.L$1 = null;
                c50711.L$2 = null;
                c50711.L$3 = null;
                c50711.L$4 = null;
                c50711.label = 4;
                objResolve = function3.invoke(actions3, c50711);
                if (objResolve == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objResolve;
            }
            if (i == 2) {
                message = ((DeferredScheduleResult) success.getResult()).getMessage();
                if (message == null) {
                    UALog.v$default(null, new Function0() { // from class: com.urbanairship.automation.engine.AutomationPreparer.prepareDeferred.5
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to get result for deferred " + automationSchedule2.getIdentifier();
                        }
                    }, 1, null);
                    return new RetryingQueue.Result.Retry(null, 1, null);
                }
                AutomationSchedule.ScheduleData.InAppMessageData inAppMessageData2 = new AutomationSchedule.ScheduleData.InAppMessageData(message);
                c50711.L$0 = null;
                c50711.L$1 = null;
                c50711.L$2 = null;
                c50711.L$3 = null;
                c50711.L$4 = null;
                c50711.label = 5;
                objResolve = function3.invoke(inAppMessageData2, c50711);
                if (objResolve == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objResolve;
            }
            throw new NoWhenBranchMatchedException();
        }
        return new RetryingQueue.Result.Success(AutomationPreparerKt.audienceMissBehaviorResult(automationSchedule2), true);
    }
}
