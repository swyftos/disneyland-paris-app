package com.urbanairship.iam.analytics;

import ch.qos.logback.core.joran.action.Action;
import com.dlp.BluetoothManager;
import com.google.firebase.messaging.Constants;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.android.layout.reporting.LayoutData;
import com.urbanairship.automation.engine.PreparedScheduleInfo;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.iam.analytics.InAppDisplayImpressionRule;
import com.urbanairship.iam.analytics.InAppEventContext;
import com.urbanairship.iam.analytics.InAppEventMessageId;
import com.urbanairship.iam.analytics.MessageDisplayHistory;
import com.urbanairship.iam.analytics.events.InAppDisplayEvent;
import com.urbanairship.iam.analytics.events.InAppEvent;
import com.urbanairship.json.JsonValue;
import com.urbanairship.meteredusage.MeteredUsageEventEntity;
import com.urbanairship.meteredusage.MeteredUsageType;
import com.urbanairship.util.Clock;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u0000 12\u00020\u0001:\u00011BK\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012Bu\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u001c\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001c\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u001fJ\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020\u001aH\u0002R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppMessageAnalytics;", "Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;", "preparedScheduleInfo", "Lcom/urbanairship/automation/engine/PreparedScheduleInfo;", "message", "Lcom/urbanairship/iam/InAppMessage;", "eventRecorder", "Lcom/urbanairship/iam/analytics/InAppEventRecorderInterface;", "historyStore", "Lcom/urbanairship/iam/analytics/MessageDisplayHistoryStoreInterface;", "displayImpressionRule", "Lcom/urbanairship/iam/analytics/InAppDisplayImpressionRule;", "displayHistory", "Lcom/urbanairship/iam/analytics/MessageDisplayHistory;", "clock", "Lcom/urbanairship/util/Clock;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/urbanairship/automation/engine/PreparedScheduleInfo;Lcom/urbanairship/iam/InAppMessage;Lcom/urbanairship/iam/analytics/InAppEventRecorderInterface;Lcom/urbanairship/iam/analytics/MessageDisplayHistoryStoreInterface;Lcom/urbanairship/iam/analytics/InAppDisplayImpressionRule;Lcom/urbanairship/iam/analytics/MessageDisplayHistory;Lcom/urbanairship/util/Clock;Lkotlinx/coroutines/CoroutineDispatcher;)V", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "Lcom/urbanairship/iam/analytics/InAppEventMessageId;", "source", "Lcom/urbanairship/iam/analytics/InAppEventSource;", "renderedLocale", "Lcom/urbanairship/json/JsonValue;", "isReportingEnabled", "", "_displayHistory", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_displayContext", "Lcom/urbanairship/iam/analytics/InAppEventContext$Display;", "(Lcom/urbanairship/automation/engine/PreparedScheduleInfo;Lcom/urbanairship/iam/analytics/InAppEventMessageId;Lcom/urbanairship/iam/analytics/InAppEventSource;Lcom/urbanairship/json/JsonValue;Lcom/urbanairship/iam/analytics/InAppEventRecorderInterface;ZLcom/urbanairship/iam/analytics/MessageDisplayHistoryStoreInterface;Lcom/urbanairship/iam/analytics/InAppDisplayImpressionRule;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlinx/coroutines/flow/MutableStateFlow;Lcom/urbanairship/util/Clock;Lkotlinx/coroutines/CoroutineDispatcher;)V", "displayContext", "Lkotlinx/coroutines/flow/StateFlow;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "customEventContext", "Lcom/urbanairship/iam/analytics/InAppCustomEventContext;", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/android/layout/reporting/LayoutData;", "recordEvent", "", "event", "Lcom/urbanairship/iam/analytics/events/InAppEvent;", "layoutContext", "recordImpression", "date", "", "shouldRecordImpression", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInAppMessageAnalytics.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppMessageAnalytics.kt\ncom/urbanairship/iam/analytics/InAppMessageAnalytics\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,218:1\n226#2,5:219\n226#2,5:224\n226#2,5:229\n226#2,5:234\n*S KotlinDebug\n*F\n+ 1 InAppMessageAnalytics.kt\ncom/urbanairship/iam/analytics/InAppMessageAnalytics\n*L\n110#1:219,5\n116#1:224,5\n124#1:229,5\n135#1:234,5\n*E\n"})
/* loaded from: classes5.dex */
public final class InAppMessageAnalytics implements InAppMessageAnalyticsInterface {
    private static final Companion Companion = new Companion(null);
    private MutableStateFlow _displayContext;
    private MutableStateFlow _displayHistory;
    private final Clock clock;
    private final StateFlow displayContext;
    private final StateFlow displayHistory;
    private final InAppDisplayImpressionRule displayImpressionRule;
    private final InAppEventRecorderInterface eventRecorder;
    private final MessageDisplayHistoryStoreInterface historyStore;
    private final boolean isReportingEnabled;
    private final InAppEventMessageId messageId;
    private final PreparedScheduleInfo preparedScheduleInfo;
    private final JsonValue renderedLocale;
    private final CoroutineScope scope;
    private final InAppEventSource source;

    private InAppMessageAnalytics(PreparedScheduleInfo preparedScheduleInfo, InAppEventMessageId inAppEventMessageId, InAppEventSource inAppEventSource, JsonValue jsonValue, InAppEventRecorderInterface inAppEventRecorderInterface, boolean z, MessageDisplayHistoryStoreInterface messageDisplayHistoryStoreInterface, InAppDisplayImpressionRule inAppDisplayImpressionRule, MutableStateFlow mutableStateFlow, MutableStateFlow mutableStateFlow2, Clock clock, CoroutineDispatcher coroutineDispatcher) {
        this.preparedScheduleInfo = preparedScheduleInfo;
        this.messageId = inAppEventMessageId;
        this.source = inAppEventSource;
        this.renderedLocale = jsonValue;
        this.eventRecorder = inAppEventRecorderInterface;
        this.isReportingEnabled = z;
        this.historyStore = messageDisplayHistoryStoreInterface;
        this.displayImpressionRule = inAppDisplayImpressionRule;
        this._displayHistory = mutableStateFlow;
        this._displayContext = mutableStateFlow2;
        this.clock = clock;
        this.scope = CoroutineScopeKt.CoroutineScope(coroutineDispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.displayHistory = FlowKt.asStateFlow(this._displayHistory);
        this.displayContext = FlowKt.asStateFlow(this._displayContext);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ InAppMessageAnalytics(PreparedScheduleInfo preparedScheduleInfo, InAppMessage inAppMessage, InAppEventRecorderInterface inAppEventRecorderInterface, MessageDisplayHistoryStoreInterface messageDisplayHistoryStoreInterface, InAppDisplayImpressionRule inAppDisplayImpressionRule, MessageDisplayHistory messageDisplayHistory, Clock clock, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Clock clock2;
        if ((i & 64) != 0) {
            Clock DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
            clock2 = DEFAULT_CLOCK;
        } else {
            clock2 = clock;
        }
        this(preparedScheduleInfo, inAppMessage, inAppEventRecorderInterface, messageDisplayHistoryStoreInterface, inAppDisplayImpressionRule, messageDisplayHistory, clock2, (i & 128) != 0 ? AirshipDispatchers.INSTANCE.newSerialDispatcher() : coroutineDispatcher);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public InAppMessageAnalytics(@NotNull PreparedScheduleInfo preparedScheduleInfo, @NotNull InAppMessage message, @NotNull InAppEventRecorderInterface eventRecorder, @NotNull MessageDisplayHistoryStoreInterface historyStore, @NotNull InAppDisplayImpressionRule displayImpressionRule, @NotNull MessageDisplayHistory displayHistory, @NotNull Clock clock, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(preparedScheduleInfo, "preparedScheduleInfo");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(eventRecorder, "eventRecorder");
        Intrinsics.checkNotNullParameter(historyStore, "historyStore");
        Intrinsics.checkNotNullParameter(displayImpressionRule, "displayImpressionRule");
        Intrinsics.checkNotNullParameter(displayHistory, "displayHistory");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Companion companion = Companion;
        InAppEventMessageId inAppEventMessageIdMakeMessageId = companion.makeMessageId(message, preparedScheduleInfo.getScheduleId$urbanairship_automation_release(), preparedScheduleInfo.getCampaigns$urbanairship_automation_release());
        InAppEventSource inAppEventSourceMakeEventSource = companion.makeEventSource(message);
        JsonValue renderedLocale = message.getRenderedLocale();
        Boolean isReportingEnabled = message.getIsReportingEnabled();
        boolean zBooleanValue = isReportingEnabled != null ? isReportingEnabled.booleanValue() : true;
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(displayHistory);
        String triggerSessionId$urbanairship_automation_release = preparedScheduleInfo.getTriggerSessionId$urbanairship_automation_release();
        boolean z = displayHistory.getLastDisplay() == null;
        String triggerSessionId$urbanairship_automation_release2 = preparedScheduleInfo.getTriggerSessionId$urbanairship_automation_release();
        this(preparedScheduleInfo, inAppEventMessageIdMakeMessageId, inAppEventSourceMakeEventSource, renderedLocale, eventRecorder, zBooleanValue, historyStore, displayImpressionRule, MutableStateFlow, StateFlowKt.MutableStateFlow(new InAppEventContext.Display(triggerSessionId$urbanairship_automation_release, z, !Intrinsics.areEqual(triggerSessionId$urbanairship_automation_release2, displayHistory.getLastDisplay() != null ? r2.getTriggerSessionId() : null))), clock, dispatcher);
    }

    private static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[InAppMessage.Source.values().length];
                try {
                    iArr[InAppMessage.Source.REMOTE_DATA.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[InAppMessage.Source.APP_DEFINED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[InAppMessage.Source.LEGACY_PUSH.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final InAppEventMessageId makeMessageId(InAppMessage message, String scheduleID, JsonValue jsonValue) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(scheduleID, "scheduleID");
            InAppMessage.Source source = message.getSource();
            if (source == null) {
                source = InAppMessage.Source.REMOTE_DATA;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[source.ordinal()];
            if (i == 1) {
                return new InAppEventMessageId.AirshipId(scheduleID, jsonValue);
            }
            if (i == 2) {
                return new InAppEventMessageId.AppDefined(scheduleID);
            }
            if (i == 3) {
                return new InAppEventMessageId.Legacy(scheduleID);
            }
            throw new NoWhenBranchMatchedException();
        }

        public final InAppEventSource makeEventSource(InAppMessage message) {
            Intrinsics.checkNotNullParameter(message, "message");
            InAppMessage.Source source = message.getSource();
            if (source == null) {
                source = InAppMessage.Source.REMOTE_DATA;
            }
            if (WhenMappings.$EnumSwitchMapping$0[source.ordinal()] == 2) {
                return InAppEventSource.APP_DEFINED;
            }
            return InAppEventSource.AIRSHIP;
        }
    }

    @Override // com.urbanairship.iam.analytics.InAppMessageAnalyticsInterface
    public void recordEvent(@NotNull InAppEvent event, @Nullable LayoutData layoutContext) {
        Object value;
        Object value2;
        Object value3;
        InAppEventContext.Display display;
        Object value4;
        InAppEventContext.Display display2;
        Intrinsics.checkNotNullParameter(event, "event");
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        if (event instanceof InAppDisplayEvent) {
            MessageDisplayHistory.LastDisplay lastDisplay = ((MessageDisplayHistory) this.displayHistory.getValue()).getLastDisplay();
            if (lastDisplay != null) {
                if (Intrinsics.areEqual(this.preparedScheduleInfo.getTriggerSessionId$urbanairship_automation_release(), lastDisplay.getTriggerSessionId())) {
                    MutableStateFlow mutableStateFlow = this._displayContext;
                    do {
                        value4 = mutableStateFlow.getValue();
                        display2 = (InAppEventContext.Display) value4;
                        display2.setFirstDisplay(false);
                        display2.setFirstDisplayTriggerSessionId(false);
                    } while (!mutableStateFlow.compareAndSet(value4, display2));
                } else {
                    MutableStateFlow mutableStateFlow2 = this._displayContext;
                    do {
                        value3 = mutableStateFlow2.getValue();
                        display = (InAppEventContext.Display) value3;
                        display.setFirstDisplay(false);
                    } while (!mutableStateFlow2.compareAndSet(value3, display));
                }
            }
            if (recordImpression(jCurrentTimeMillis)) {
                MutableStateFlow mutableStateFlow3 = this._displayHistory;
                do {
                    value2 = mutableStateFlow3.getValue();
                } while (!mutableStateFlow3.compareAndSet(value2, new MessageDisplayHistory(new MessageDisplayHistory.LastImpression(jCurrentTimeMillis, this.preparedScheduleInfo.getTriggerSessionId$urbanairship_automation_release()), ((MessageDisplayHistory) value2).getLastDisplay())));
            }
            MutableStateFlow mutableStateFlow4 = this._displayHistory;
            do {
                value = mutableStateFlow4.getValue();
            } while (!mutableStateFlow4.compareAndSet(value, new MessageDisplayHistory(((MessageDisplayHistory) value).getLastImpression(), new MessageDisplayHistory.LastDisplay(this.preparedScheduleInfo.getTriggerSessionId$urbanairship_automation_release()))));
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass4(null), 3, null);
        }
        if (this.isReportingEnabled) {
            this.eventRecorder.recordEvent(new InAppEventData(event, InAppEventContextKt.makeContext(InAppEventContext.INSTANCE, this.preparedScheduleInfo.getReportingContext$urbanairship_automation_release(), this.preparedScheduleInfo.getExperimentResult$urbanairship_automation_release(), layoutContext, (InAppEventContext.Display) this.displayContext.getValue()), this.source, this.messageId, this.renderedLocale));
        }
    }

    /* renamed from: com.urbanairship.iam.analytics.InAppMessageAnalytics$recordEvent$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass4(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return InAppMessageAnalytics.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MessageDisplayHistoryStoreInterface messageDisplayHistoryStoreInterface = InAppMessageAnalytics.this.historyStore;
                MessageDisplayHistory messageDisplayHistory = (MessageDisplayHistory) InAppMessageAnalytics.this.displayHistory.getValue();
                String scheduleId$urbanairship_automation_release = InAppMessageAnalytics.this.preparedScheduleInfo.getScheduleId$urbanairship_automation_release();
                this.label = 1;
                if (messageDisplayHistoryStoreInterface.set(messageDisplayHistory, scheduleId$urbanairship_automation_release, this) == coroutine_suspended) {
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

    @Override // com.urbanairship.iam.analytics.InAppMessageAnalyticsInterface
    @NotNull
    public InAppCustomEventContext customEventContext(@Nullable LayoutData state) {
        return new InAppCustomEventContext(this.messageId, InAppEventContextKt.makeContext(InAppEventContext.INSTANCE, this.preparedScheduleInfo.getReportingContext$urbanairship_automation_release(), this.preparedScheduleInfo.getExperimentResult$urbanairship_automation_release(), state, (InAppEventContext.Display) this.displayContext.getValue()));
    }

    private final boolean shouldRecordImpression() {
        MessageDisplayHistory.LastImpression lastImpression = ((MessageDisplayHistory) this.displayHistory.getValue()).getLastImpression();
        if (lastImpression == null || !Intrinsics.areEqual(this.preparedScheduleInfo.getTriggerSessionId$urbanairship_automation_release(), lastImpression.getTriggerSessionId())) {
            return true;
        }
        InAppDisplayImpressionRule inAppDisplayImpressionRule = this.displayImpressionRule;
        if (inAppDisplayImpressionRule instanceof InAppDisplayImpressionRule.Interval) {
            if (this.clock.currentTimeMillis() - lastImpression.getDate() >= Duration.m3485getInWholeMillisecondsimpl(((InAppDisplayImpressionRule.Interval) this.displayImpressionRule).m2886getValueUwyO8pc())) {
                return true;
            }
        } else if (!(inAppDisplayImpressionRule instanceof InAppDisplayImpressionRule.Once)) {
            throw new NoWhenBranchMatchedException();
        }
        return false;
    }

    private final boolean recordImpression(long date) {
        String productId$urbanairship_automation_release;
        if (!shouldRecordImpression() || (productId$urbanairship_automation_release = this.preparedScheduleInfo.getProductId$urbanairship_automation_release()) == null) {
            return false;
        }
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.eventRecorder.recordImpressionEvent(new MeteredUsageEventEntity(string, this.messageId.getIdentifier(), MeteredUsageType.IN_APP_EXPERIENCE_IMPRESSION, productId$urbanairship_automation_release, this.preparedScheduleInfo.getReportingContext$urbanairship_automation_release(), Long.valueOf(date), this.preparedScheduleInfo.getContactId$urbanairship_automation_release()));
        return true;
    }
}
