package com.urbanairship.automation;

import androidx.annotation.RestrictTo;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.UAirship;
import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.automation.engine.AutomationEngine;
import com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.iam.InAppMessagingInterface;
import com.urbanairship.iam.legacy.LegacyInAppMessagingInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u0001:\u0001AB?\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\r\u0010)\u001a\u00020(H\u0000¢\u0006\u0002\b*J\u0016\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020-H\u0086@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020-H\u0086@¢\u0006\u0002\u0010.J\u001c\u0010/\u001a\u00020(2\f\u00101\u001a\b\u0012\u0004\u0012\u00020-02H\u0086@¢\u0006\u0002\u00103J\u0018\u00104\u001a\u00020(2\u0006\u00105\u001a\u000206H\u0080@¢\u0006\u0004\b7\u00108J\u0018\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010,\u001a\u00020-H\u0086@¢\u0006\u0002\u0010.J\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020:022\u0006\u00100\u001a\u00020-H\u0086@¢\u0006\u0002\u0010.J\b\u0010<\u001a\u00020(H\u0002J\r\u0010=\u001a\u00020(H\u0000¢\u0006\u0002\b>J\u001c\u0010?\u001a\u00020(2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020:02H\u0086@¢\u0006\u0002\u00103R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R*\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0015\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/urbanairship/automation/InAppAutomation;", "", "engine", "Lcom/urbanairship/automation/engine/AutomationEngine;", "inAppMessaging", "Lcom/urbanairship/iam/InAppMessagingInterface;", "legacyInAppMessaging", "Lcom/urbanairship/iam/legacy/LegacyInAppMessagingInterface;", "remoteDataSubscriber", "Lcom/urbanairship/automation/remotedata/AutomationRemoteDataSubscriber;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "(Lcom/urbanairship/automation/engine/AutomationEngine;Lcom/urbanairship/iam/InAppMessagingInterface;Lcom/urbanairship/iam/legacy/LegacyInAppMessagingInterface;Lcom/urbanairship/automation/remotedata/AutomationRemoteDataSubscriber;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/config/AirshipRuntimeConfig;)V", "getInAppMessaging", "()Lcom/urbanairship/iam/InAppMessagingInterface;", "value", "", "isPaused", "isPaused$annotations", "()V", "()Z", "setPaused", "(Z)V", "getLegacyInAppMessaging", "()Lcom/urbanairship/iam/legacy/LegacyInAppMessagingInterface;", "status", "Lcom/urbanairship/automation/InAppAutomationRemoteDataStatus;", "getStatus", "()Lcom/urbanairship/automation/InAppAutomationRemoteDataStatus;", "statusUpdates", "Lkotlinx/coroutines/flow/Flow;", "getStatusUpdates", "()Lkotlinx/coroutines/flow/Flow;", "subscriptions", "", "Lkotlin/Function0;", "", "airshipReady", "airshipReady$urbanairship_automation_release", "cancelSchedule", "identifier", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelSchedules", "group", "identifiers", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelSchedulesWith", "type", "Lcom/urbanairship/automation/AutomationSchedule$ScheduleType;", "cancelSchedulesWith$urbanairship_automation_release", "(Lcom/urbanairship/automation/AutomationSchedule$ScheduleType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSchedules", "Lcom/urbanairship/automation/AutomationSchedule;", "getSchedulesForGroup", "privacyManagerUpdated", "tearDown", "tearDown$urbanairship_automation_release", "upsertSchedules", "schedules", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInAppAutomation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppAutomation.kt\ncom/urbanairship/automation/InAppAutomation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,176:1\n1855#2,2:177\n*S KotlinDebug\n*F\n+ 1 InAppAutomation.kt\ncom/urbanairship/automation/InAppAutomation\n*L\n130#1:177,2\n*E\n"})
/* loaded from: classes5.dex */
public final class InAppAutomation {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final AirshipRuntimeConfig config;
    private final PreferenceDataStore dataStore;
    private final AutomationEngine engine;
    private final InAppMessagingInterface inAppMessaging;
    private final LegacyInAppMessagingInterface legacyInAppMessaging;
    private final PrivacyManager privacyManager;
    private final AutomationRemoteDataSubscriber remoteDataSubscriber;
    private final InAppAutomationRemoteDataStatus status;
    private final Flow statusUpdates;
    private final List subscriptions;

    public static /* synthetic */ void isPaused$annotations() {
    }

    @JvmStatic
    @NotNull
    public static final InAppAutomation shared() {
        return INSTANCE.shared();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public InAppAutomation(@NotNull AutomationEngine engine, @NotNull InAppMessagingInterface inAppMessaging, @NotNull LegacyInAppMessagingInterface legacyInAppMessaging, @NotNull AutomationRemoteDataSubscriber remoteDataSubscriber, @NotNull PreferenceDataStore dataStore, @NotNull PrivacyManager privacyManager, @NotNull AirshipRuntimeConfig config) {
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(inAppMessaging, "inAppMessaging");
        Intrinsics.checkNotNullParameter(legacyInAppMessaging, "legacyInAppMessaging");
        Intrinsics.checkNotNullParameter(remoteDataSubscriber, "remoteDataSubscriber");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(config, "config");
        this.engine = engine;
        this.inAppMessaging = inAppMessaging;
        this.legacyInAppMessaging = legacyInAppMessaging;
        this.remoteDataSubscriber = remoteDataSubscriber;
        this.dataStore = dataStore;
        this.privacyManager = privacyManager;
        this.config = config;
        this.subscriptions = new ArrayList();
        this.status = remoteDataSubscriber.getStatus();
        this.statusUpdates = remoteDataSubscriber.getStatusUpdates();
    }

    @NotNull
    public final InAppMessagingInterface getInAppMessaging() {
        return this.inAppMessaging;
    }

    @NotNull
    public final LegacyInAppMessagingInterface getLegacyInAppMessaging() {
        return this.legacyInAppMessaging;
    }

    public final boolean isPaused() {
        boolean z;
        synchronized (this) {
            z = this.dataStore.getBoolean("com.urbanairship.iam.paused", this.config.getConfigOptions().autoPauseInAppAutomationOnLaunch);
        }
        return z;
    }

    public final void setPaused(boolean z) {
        synchronized (this) {
            this.dataStore.put("com.urbanairship.iam.paused", z);
            this.engine.setExecutionPaused(z);
            Unit unit = Unit.INSTANCE;
        }
    }

    @NotNull
    public final InAppAutomationRemoteDataStatus getStatus() {
        return this.status;
    }

    @NotNull
    public final Flow<InAppAutomationRemoteDataStatus> getStatusUpdates() {
        return this.statusUpdates;
    }

    @Nullable
    public final Object upsertSchedules(@NotNull List<AutomationSchedule> list, @NotNull Continuation<? super Unit> continuation) {
        Object objUpsertSchedules = this.engine.upsertSchedules(list, continuation);
        return objUpsertSchedules == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpsertSchedules : Unit.INSTANCE;
    }

    @Nullable
    public final Object cancelSchedule(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        Object objCancelSchedules = this.engine.cancelSchedules(CollectionsKt.listOf(str), continuation);
        return objCancelSchedules == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCancelSchedules : Unit.INSTANCE;
    }

    @Nullable
    public final Object cancelSchedules(@NotNull List<String> list, @NotNull Continuation<? super Unit> continuation) {
        Object objCancelSchedules = this.engine.cancelSchedules(list, continuation);
        return objCancelSchedules == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCancelSchedules : Unit.INSTANCE;
    }

    @Nullable
    public final Object cancelSchedules(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        Object objCancelSchedules = this.engine.cancelSchedules(str, continuation);
        return objCancelSchedules == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCancelSchedules : Unit.INSTANCE;
    }

    @Nullable
    public final Object cancelSchedulesWith$urbanairship_automation_release(@NotNull AutomationSchedule.ScheduleType scheduleType, @NotNull Continuation<? super Unit> continuation) {
        Object objCancelSchedulesWith = this.engine.cancelSchedulesWith(scheduleType, continuation);
        return objCancelSchedulesWith == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCancelSchedulesWith : Unit.INSTANCE;
    }

    @Nullable
    public final Object getSchedules(@NotNull String str, @NotNull Continuation<? super AutomationSchedule> continuation) {
        return this.engine.getSchedule(str, continuation);
    }

    @Nullable
    public final Object getSchedulesForGroup(@NotNull String str, @NotNull Continuation<? super List<AutomationSchedule>> continuation) {
        return this.engine.getSchedules(str, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.urbanairship.PrivacyManager$Listener, com.urbanairship.automation.InAppAutomation$airshipReady$listener$1] */
    public final void airshipReady$urbanairship_automation_release() {
        this.engine.setExecutionPaused(isPaused());
        this.engine.start();
        final ?? r0 = new PrivacyManager.Listener() { // from class: com.urbanairship.automation.InAppAutomation$airshipReady$listener$1
            @Override // com.urbanairship.PrivacyManager.Listener
            public void onEnabledFeaturesChanged() {
                this.this$0.privacyManagerUpdated();
            }
        };
        this.privacyManager.addListener(r0);
        this.subscriptions.add(new Function0() { // from class: com.urbanairship.automation.InAppAutomation$airshipReady$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m2785invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2785invoke() {
                this.this$0.privacyManager.removeListener(r0);
            }
        });
        privacyManagerUpdated();
    }

    public final void tearDown$urbanairship_automation_release() {
        Iterator it = this.subscriptions.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void privacyManagerUpdated() {
        if (this.privacyManager.isEnabled(PrivacyManager.Feature.IN_APP_AUTOMATION)) {
            this.engine.setEnginePaused(false);
            this.remoteDataSubscriber.subscribe();
        } else {
            this.engine.setEnginePaused(true);
            this.remoteDataSubscriber.unsubscribe();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/InAppAutomation$Companion;", "", "()V", "PAUSED_STORE_KEY", "", "shared", "Lcom/urbanairship/automation/InAppAutomation;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final InAppAutomation shared() {
            return ((InAppAutomationComponent) UAirship.shared().requireComponent(InAppAutomationComponent.class)).getAutomation();
        }
    }
}
