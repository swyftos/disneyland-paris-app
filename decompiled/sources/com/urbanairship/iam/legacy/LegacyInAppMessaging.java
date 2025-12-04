package com.urbanairship.iam.legacy;

import android.content.Context;
import android.content.res.Resources;
import androidx.media3.extractor.ts.PsExtractor;
import ch.qos.logback.core.joran.action.Action;
import com.contentsquare.android.api.Currencies;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UALog;
import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.automation.AutomationTrigger;
import com.urbanairship.automation.engine.AutomationEngineInterface;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.iam.content.Banner;
import com.urbanairship.iam.content.InAppMessageDisplayContent;
import com.urbanairship.iam.info.InAppMessageButtonInfo;
import com.urbanairship.iam.info.InAppMessageButtonLayoutType;
import com.urbanairship.iam.info.InAppMessageColor;
import com.urbanairship.iam.info.InAppMessageTextInfo;
import com.urbanairship.iam.legacy.LegacyInAppMessageUpdate;
import com.urbanairship.json.JsonMap;
import com.urbanairship.push.PushManager;
import com.urbanairship.push.notifications.NotificationActionButton;
import com.urbanairship.push.notifications.NotificationActionButtonGroup;
import com.urbanairship.util.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000 82\u00020\u0001:\u00018BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0012\u0010.\u001a\u0004\u0018\u00010\u00172\u0006\u0010/\u001a\u00020\u0016H\u0002J\u0016\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0082@¢\u0006\u0002\u00104J\u0016\u00105\u001a\u0002012\u0006\u00106\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u00107R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u0015j\u0004\u0018\u0001`\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010#\u001a\u0016\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$\u0018\u00010\u0015j\u0004\u0018\u0001`%X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001cR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010(\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015j\u0004\u0018\u0001`)X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/urbanairship/iam/legacy/LegacyInAppMessaging;", "Lcom/urbanairship/iam/legacy/LegacyInAppMessagingInterface;", "context", "Landroid/content/Context;", "pushManager", "Lcom/urbanairship/push/PushManager;", "updates", "Lkotlinx/coroutines/flow/Flow;", "Lcom/urbanairship/iam/legacy/LegacyInAppMessageUpdate;", "preferenceDataStore", "Lcom/urbanairship/PreferenceDataStore;", "automationEngine", "Lcom/urbanairship/automation/engine/AutomationEngineInterface;", "legacyAnalytics", "Lcom/urbanairship/iam/legacy/LegacyAnalytics;", "clock", "Lcom/urbanairship/util/Clock;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/urbanairship/push/PushManager;Lkotlinx/coroutines/flow/Flow;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/automation/engine/AutomationEngineInterface;Lcom/urbanairship/iam/legacy/LegacyAnalytics;Lcom/urbanairship/util/Clock;Lkotlinx/coroutines/CoroutineDispatcher;)V", "customMessageConverter", "Lkotlin/Function1;", "Lcom/urbanairship/iam/legacy/LegacyInAppMessage;", "Lcom/urbanairship/automation/AutomationSchedule;", "Lcom/urbanairship/iam/legacy/MessageConvertor;", "getCustomMessageConverter", "()Lkotlin/jvm/functions/Function1;", "setCustomMessageConverter", "(Lkotlin/jvm/functions/Function1;)V", "displayAsapEnabled", "", "getDisplayAsapEnabled", "()Z", "setDisplayAsapEnabled", "(Z)V", "messageExtender", "Lcom/urbanairship/iam/InAppMessage;", "Lcom/urbanairship/iam/legacy/MessageExtender;", "getMessageExtender", "setMessageExtender", "scheduleExtender", "Lcom/urbanairship/iam/legacy/ScheduleExtender;", "getScheduleExtender", "setScheduleExtender", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "createSchedule", "legacyInAppMessage", "processDirectOpen", "", "sendId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processNewMessage", "message", "(Lcom/urbanairship/iam/legacy/LegacyInAppMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLegacyInAppMessaging.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LegacyInAppMessaging.kt\ncom/urbanairship/iam/legacy/LegacyInAppMessaging\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,212:1\n1549#2:213\n1620#2,3:214\n*S KotlinDebug\n*F\n+ 1 LegacyInAppMessaging.kt\ncom/urbanairship/iam/legacy/LegacyInAppMessaging\n*L\n138#1:213\n138#1:214,3\n*E\n"})
/* loaded from: classes5.dex */
public final class LegacyInAppMessaging implements LegacyInAppMessagingInterface {
    public static final float DEFAULT_BORDER_RADIUS_DP = 2.0f;
    public static final long DEFAULT_EXPIRY_MS = 2592000000L;
    public static final int DEFAULT_PRIMARY_COLOR = -1;
    public static final int DEFAULT_SECONDARY_COLOR = -16777216;
    public static final long MIN_DURATION_MS = 1000;
    private final AutomationEngineInterface automationEngine;
    private final Clock clock;
    private final Context context;
    private Function1 customMessageConverter;
    private boolean displayAsapEnabled;
    private final LegacyAnalytics legacyAnalytics;
    private Function1 messageExtender;
    private final PreferenceDataStore preferenceDataStore;
    private final PushManager pushManager;
    private Function1 scheduleExtender;
    private final CoroutineScope scope;
    private final Flow updates;

    /* renamed from: com.urbanairship.iam.legacy.LegacyInAppMessaging$processDirectOpen$1, reason: invalid class name and case insensitive filesystem */
    static final class C11471 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11471(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LegacyInAppMessaging.this.processDirectOpen(null, this);
        }
    }

    /* renamed from: com.urbanairship.iam.legacy.LegacyInAppMessaging$processNewMessage$1, reason: invalid class name and case insensitive filesystem */
    static final class C11481 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11481(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LegacyInAppMessaging.this.processNewMessage(null, this);
        }
    }

    public LegacyInAppMessaging(@NotNull Context context, @NotNull PushManager pushManager, @NotNull Flow<? extends LegacyInAppMessageUpdate> updates, @NotNull PreferenceDataStore preferenceDataStore, @NotNull AutomationEngineInterface automationEngine, @NotNull LegacyAnalytics legacyAnalytics, @NotNull Clock clock, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pushManager, "pushManager");
        Intrinsics.checkNotNullParameter(updates, "updates");
        Intrinsics.checkNotNullParameter(preferenceDataStore, "preferenceDataStore");
        Intrinsics.checkNotNullParameter(automationEngine, "automationEngine");
        Intrinsics.checkNotNullParameter(legacyAnalytics, "legacyAnalytics");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.context = context;
        this.pushManager = pushManager;
        this.updates = updates;
        this.preferenceDataStore = preferenceDataStore;
        this.automationEngine = automationEngine;
        this.legacyAnalytics = legacyAnalytics;
        this.clock = clock;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.scope = CoroutineScope;
        this.displayAsapEnabled = true;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LegacyInAppMessaging(Context context, PushManager pushManager, Flow flow, PreferenceDataStore preferenceDataStore, AutomationEngineInterface automationEngineInterface, LegacyAnalytics legacyAnalytics, Clock clock, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Clock clock2;
        Flow flowUpdates = (i & 4) != 0 ? LegacyInAppMessageUpdate.INSTANCE.updates(pushManager) : flow;
        if ((i & 64) != 0) {
            Clock DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
            clock2 = DEFAULT_CLOCK;
        } else {
            clock2 = clock;
        }
        this(context, pushManager, flowUpdates, preferenceDataStore, automationEngineInterface, legacyAnalytics, clock2, (i & 128) != 0 ? Dispatchers.getMain().getImmediate() : coroutineDispatcher);
    }

    @Override // com.urbanairship.iam.legacy.LegacyInAppMessagingInterface
    @Nullable
    public Function1<LegacyInAppMessage, AutomationSchedule> getCustomMessageConverter() {
        return this.customMessageConverter;
    }

    @Override // com.urbanairship.iam.legacy.LegacyInAppMessagingInterface
    public void setCustomMessageConverter(@Nullable Function1<? super LegacyInAppMessage, AutomationSchedule> function1) {
        this.customMessageConverter = function1;
    }

    @Override // com.urbanairship.iam.legacy.LegacyInAppMessagingInterface
    @Nullable
    public Function1<InAppMessage, InAppMessage> getMessageExtender() {
        return this.messageExtender;
    }

    @Override // com.urbanairship.iam.legacy.LegacyInAppMessagingInterface
    public void setMessageExtender(@Nullable Function1<? super InAppMessage, InAppMessage> function1) {
        this.messageExtender = function1;
    }

    @Override // com.urbanairship.iam.legacy.LegacyInAppMessagingInterface
    @Nullable
    public Function1<AutomationSchedule, AutomationSchedule> getScheduleExtender() {
        return this.scheduleExtender;
    }

    @Override // com.urbanairship.iam.legacy.LegacyInAppMessagingInterface
    public void setScheduleExtender(@Nullable Function1<? super AutomationSchedule, AutomationSchedule> function1) {
        this.scheduleExtender = function1;
    }

    @Override // com.urbanairship.iam.legacy.LegacyInAppMessagingInterface
    public boolean getDisplayAsapEnabled() {
        return this.displayAsapEnabled;
    }

    @Override // com.urbanairship.iam.legacy.LegacyInAppMessagingInterface
    public void setDisplayAsapEnabled(boolean z) {
        this.displayAsapEnabled = z;
    }

    /* renamed from: com.urbanairship.iam.legacy.LegacyInAppMessaging$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return LegacyInAppMessaging.this.new AnonymousClass1(continuation);
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
                Flow flow = LegacyInAppMessaging.this.updates;
                final LegacyInAppMessaging legacyInAppMessaging = LegacyInAppMessaging.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.iam.legacy.LegacyInAppMessaging.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(LegacyInAppMessageUpdate legacyInAppMessageUpdate, Continuation continuation) throws Resources.NotFoundException {
                        if (legacyInAppMessageUpdate instanceof LegacyInAppMessageUpdate.DirectOpen) {
                            Object objProcessDirectOpen = legacyInAppMessaging.processDirectOpen(((LegacyInAppMessageUpdate.DirectOpen) legacyInAppMessageUpdate).getSendId(), continuation);
                            return objProcessDirectOpen == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessDirectOpen : Unit.INSTANCE;
                        }
                        if (legacyInAppMessageUpdate instanceof LegacyInAppMessageUpdate.NewMessage) {
                            Object objProcessNewMessage = legacyInAppMessaging.processNewMessage(((LegacyInAppMessageUpdate.NewMessage) legacyInAppMessageUpdate).getMessage(), continuation);
                            return objProcessNewMessage == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objProcessNewMessage : Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flow.collect(flowCollector, this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processNewMessage(com.urbanairship.iam.legacy.LegacyInAppMessage r10, kotlin.coroutines.Continuation r11) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.legacy.LegacyInAppMessaging.processNewMessage(com.urbanairship.iam.legacy.LegacyInAppMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processDirectOpen(java.lang.String r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.urbanairship.iam.legacy.LegacyInAppMessaging.C11471
            if (r0 == 0) goto L13
            r0 = r8
            com.urbanairship.iam.legacy.LegacyInAppMessaging$processDirectOpen$1 r0 = (com.urbanairship.iam.legacy.LegacyInAppMessaging.C11471) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.iam.legacy.LegacyInAppMessaging$processDirectOpen$1 r0 = new com.urbanairship.iam.legacy.LegacyInAppMessaging$processDirectOpen$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L42
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L89
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.L$1
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r6 = r0.L$0
            com.urbanairship.iam.legacy.LegacyInAppMessaging r6 = (com.urbanairship.iam.legacy.LegacyInAppMessaging) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L67
        L42:
            kotlin.ResultKt.throwOnFailure(r8)
            com.urbanairship.PreferenceDataStore r8 = r6.preferenceDataStore
            java.lang.String r2 = "com.urbanairship.push.iam.PENDING_MESSAGE_ID"
            java.lang.String r8 = r8.getString(r2, r5)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r7)
            if (r8 == 0) goto L8c
            com.urbanairship.PreferenceDataStore r8 = r6.preferenceDataStore
            r8.remove(r2)
            com.urbanairship.automation.engine.AutomationEngineInterface r8 = r6.automationEngine
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r8.getSchedule(r7, r0)
            if (r8 != r1) goto L67
            return r1
        L67:
            if (r8 == 0) goto L76
            r8 = 0
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.String r2 = "Pending in-app message cancelled."
            com.urbanairship.UALog.d(r2, r8)
            com.urbanairship.iam.legacy.LegacyAnalytics r8 = r6.legacyAnalytics
            r8.recordDirectOpenEvent(r7)
        L76:
            com.urbanairship.automation.engine.AutomationEngineInterface r6 = r6.automationEngine
            java.util.List r7 = kotlin.collections.CollectionsKt.listOf(r7)
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.cancelSchedules(r7, r0)
            if (r6 != r1) goto L89
            return r1
        L89:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L8c:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.legacy.LegacyInAppMessaging.processDirectOpen(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final AutomationSchedule createSchedule(LegacyInAppMessage legacyInAppMessage) throws Resources.NotFoundException {
        InAppMessage inAppMessageInvoke;
        AutomationTrigger automationTriggerM2780foregroundWZ4Q5Ns;
        AutomationSchedule automationScheduleInvoke;
        List listEmptyList;
        String str;
        String resourceName;
        Function1<LegacyInAppMessage, AutomationSchedule> customMessageConverter = getCustomMessageConverter();
        if (customMessageConverter != null) {
            return customMessageConverter.invoke(legacyInAppMessage);
        }
        Integer primaryColor = legacyInAppMessage.getPrimaryColor();
        InAppMessageColor inAppMessageColor = new InAppMessageColor(primaryColor != null ? primaryColor.intValue() : -1);
        Integer secondaryColor = legacyInAppMessage.getSecondaryColor();
        InAppMessageColor inAppMessageColor2 = new InAppMessageColor(secondaryColor != null ? secondaryColor.intValue() : -16777216);
        String buttonGroupId = legacyInAppMessage.getButtonGroupId();
        List list = null;
        if (buttonGroupId != null) {
            NotificationActionButtonGroup notificationActionGroup = this.pushManager.getNotificationActionGroup(buttonGroupId);
            if (notificationActionGroup == null) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                List<NotificationActionButton> notificationActionButtons = notificationActionGroup.getNotificationActionButtons();
                Intrinsics.checkNotNullExpressionValue(notificationActionButtons, "getNotificationActionButtons(...)");
                List<NotificationActionButton> listTake = CollectionsKt.take(notificationActionButtons, 2);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listTake, 10));
                for (NotificationActionButton notificationActionButton : listTake) {
                    if (notificationActionButton != null) {
                        int icon = notificationActionButton.getIcon();
                        try {
                            resourceName = this.context.getResources().getResourceName(icon);
                        } catch (Resources.NotFoundException unused) {
                            UALog.d("Drawable " + icon + " no longer exists or has a new identifier.", new Object[0]);
                            resourceName = null;
                        }
                        str = resourceName;
                    } else {
                        str = null;
                    }
                    String id = notificationActionButton.getId();
                    Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
                    String label = notificationActionButton.getLabel(this.context);
                    String str2 = label == null ? "" : label;
                    Intrinsics.checkNotNull(str2);
                    InAppMessageTextInfo inAppMessageTextInfo = new InAppMessageTextInfo(str2, inAppMessageColor, null, null, InAppMessageTextInfo.Alignment.CENTER, null, str, 44, null);
                    Map<String, JsonMap> buttonActionValues = legacyInAppMessage.getButtonActionValues();
                    ArrayList arrayList2 = arrayList;
                    arrayList2.add(new InAppMessageButtonInfo(id, inAppMessageTextInfo, buttonActionValues != null ? buttonActionValues.get(notificationActionButton.getId()) : null, null, inAppMessageColor2, null, 2.0f, 40, null));
                    arrayList = arrayList2;
                }
                listEmptyList = arrayList;
            }
            list = listEmptyList;
        }
        String id2 = legacyInAppMessage.getId();
        JsonMap clickActionValues = legacyInAppMessage.getClickActionValues();
        Long displayDurationMs = legacyInAppMessage.getDisplayDurationMs();
        long jCoerceAtLeast = RangesKt.coerceAtLeast(displayDurationMs != null ? displayDurationMs.longValue() : 15000L, 1000L);
        Banner.Placement placement = legacyInAppMessage.getPlacement();
        Banner.Template template = Banner.Template.MEDIA_LEFT;
        String alert = legacyInAppMessage.getAlert();
        InAppMessage inAppMessage = new InAppMessage(id2, new InAppMessageDisplayContent.BannerContent(new Banner(null, new InAppMessageTextInfo(alert == null ? "" : alert, inAppMessageColor2, null, null, null, null, null, Currencies.CAD, null), null, list, InAppMessageButtonLayoutType.SEPARATE, template, inAppMessageColor, inAppMessageColor2, 2.0f, jCoerceAtLeast, placement, clickActionValues, 5, null)), InAppMessage.Source.LEGACY_PUSH, legacyInAppMessage.getExtras(), null, null, null, null, PsExtractor.VIDEO_STREAM_MASK, null);
        Function1<InAppMessage, InAppMessage> messageExtender = getMessageExtender();
        if (messageExtender == null || (inAppMessageInvoke = messageExtender.invoke(inAppMessage)) == null) {
            inAppMessageInvoke = inAppMessage;
        }
        if (getDisplayAsapEnabled()) {
            automationTriggerM2780foregroundWZ4Q5Ns = AutomationTrigger.INSTANCE.m2779activeSessionWZ4Q5Ns(1);
        } else {
            automationTriggerM2780foregroundWZ4Q5Ns = AutomationTrigger.INSTANCE.m2780foregroundWZ4Q5Ns(1);
        }
        String id3 = legacyInAppMessage.getId();
        AutomationSchedule.ScheduleData.InAppMessageData inAppMessageData = new AutomationSchedule.ScheduleData.InAppMessageData(inAppMessageInvoke);
        List listListOf = CollectionsKt.listOf(automationTriggerM2780foregroundWZ4Q5Ns);
        Long expiryMs = legacyInAppMessage.getExpiryMs();
        AutomationSchedule automationSchedule = new AutomationSchedule(id3, listListOf, null, null, null, null, ULong.m3027boximpl(ULong.m3028constructorimpl(expiryMs != null ? expiryMs.longValue() : this.clock.currentTimeMillis() + DEFAULT_EXPIRY_MS)), null, null, null, null, inAppMessageData, null, null, null, null, null, null, null, null, null, 0L, null, null, 16775100, null);
        Function1<AutomationSchedule, AutomationSchedule> scheduleExtender = getScheduleExtender();
        return (scheduleExtender == null || (automationScheduleInvoke = scheduleExtender.invoke(automationSchedule)) == null) ? automationSchedule : automationScheduleInvoke;
    }
}
