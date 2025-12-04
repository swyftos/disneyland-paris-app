package com.urbanairship.automation;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.ApplicationMetrics;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.analytics.AirshipEventFeed;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.app.GlobalActivityMonitor;
import com.urbanairship.audience.AudienceEvaluator;
import com.urbanairship.automation.action.ActionAutomationExecutor;
import com.urbanairship.automation.action.ActionAutomationPreparer;
import com.urbanairship.automation.audiencecheck.AdditionalAudienceCheckerResolver;
import com.urbanairship.automation.engine.AutomationDelayProcessor;
import com.urbanairship.automation.engine.AutomationEngine;
import com.urbanairship.automation.engine.AutomationEventFeed;
import com.urbanairship.automation.engine.AutomationExecutor;
import com.urbanairship.automation.engine.AutomationPreparer;
import com.urbanairship.automation.engine.AutomationStore;
import com.urbanairship.automation.engine.SerialAccessAutomationStore;
import com.urbanairship.automation.engine.triggerprocessor.AutomationTriggerProcessor;
import com.urbanairship.automation.limits.FrequencyLimitManager;
import com.urbanairship.automation.remotedata.AutomationRemoteDataAccess;
import com.urbanairship.automation.remotedata.AutomationRemoteDataSubscriber;
import com.urbanairship.automation.storage.AutomationDatabase;
import com.urbanairship.automation.storage.AutomationStoreMigrator;
import com.urbanairship.automation.utils.NetworkMonitor;
import com.urbanairship.automation.utils.ScheduleConditionsChangedNotifier;
import com.urbanairship.base.Supplier;
import com.urbanairship.cache.AirshipCache;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.deferred.DeferredResolver;
import com.urbanairship.experiment.ExperimentManager;
import com.urbanairship.iam.InAppMessageAutomationExecutor;
import com.urbanairship.iam.InAppMessageAutomationPreparer;
import com.urbanairship.iam.InAppMessaging;
import com.urbanairship.iam.adapter.DisplayAdapterFactory;
import com.urbanairship.iam.analytics.DefaultInAppDisplayImpressionRuleProvider;
import com.urbanairship.iam.analytics.InAppEventRecorder;
import com.urbanairship.iam.analytics.InAppMessageAnalyticsFactory;
import com.urbanairship.iam.analytics.MessageDisplayHistoryStore;
import com.urbanairship.iam.assets.AssetCacheManager;
import com.urbanairship.iam.coordinator.DisplayCoordinatorManager;
import com.urbanairship.iam.legacy.LegacyAnalytics;
import com.urbanairship.iam.legacy.LegacyInAppMessaging;
import com.urbanairship.meteredusage.AirshipMeteredUsage;
import com.urbanairship.modules.Module;
import com.urbanairship.modules.automation.AutomationModuleFactory;
import com.urbanairship.push.PushManager;
import com.urbanairship.remoteconfig.IAAConfig;
import com.urbanairship.remoteconfig.RetryingQueueConfig;
import com.urbanairship.remotedata.RemoteData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0080\u0001\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006)"}, d2 = {"Lcom/urbanairship/automation/AutomationModuleFactoryImpl;", "Lcom/urbanairship/modules/automation/AutomationModuleFactory;", "()V", "airshipVersion", "", "getAirshipVersion", "()Ljava/lang/String;", "packageVersion", "getPackageVersion", "build", "Lcom/urbanairship/modules/Module;", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "airshipChannel", "Lcom/urbanairship/channel/AirshipChannel;", "pushManager", "Lcom/urbanairship/push/PushManager;", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/urbanairship/analytics/Analytics;", "remoteData", "Lcom/urbanairship/remotedata/RemoteData;", "experimentManager", "Lcom/urbanairship/experiment/ExperimentManager;", "meteredUsage", "Lcom/urbanairship/meteredusage/AirshipMeteredUsage;", "deferredResolver", "Lcom/urbanairship/deferred/DeferredResolver;", "eventFeed", "Lcom/urbanairship/analytics/AirshipEventFeed;", "metrics", "Lcom/urbanairship/ApplicationMetrics;", "cache", "Lcom/urbanairship/cache/AirshipCache;", "audienceEvaluator", "Lcom/urbanairship/audience/AudienceEvaluator;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class AutomationModuleFactoryImpl implements AutomationModuleFactory {
    @Override // com.urbanairship.modules.automation.AutomationModuleFactory
    @NotNull
    public Module build(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull final AirshipRuntimeConfig runtimeConfig, @NotNull PrivacyManager privacyManager, @NotNull AirshipChannel airshipChannel, @NotNull PushManager pushManager, @NotNull Analytics analytics, @NotNull RemoteData remoteData, @NotNull ExperimentManager experimentManager, @NotNull AirshipMeteredUsage meteredUsage, @NotNull DeferredResolver deferredResolver, @NotNull AirshipEventFeed eventFeed, @NotNull ApplicationMetrics metrics, @NotNull AirshipCache cache, @NotNull AudienceEvaluator audienceEvaluator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(airshipChannel, "airshipChannel");
        Intrinsics.checkNotNullParameter(pushManager, "pushManager");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(remoteData, "remoteData");
        Intrinsics.checkNotNullParameter(experimentManager, "experimentManager");
        Intrinsics.checkNotNullParameter(meteredUsage, "meteredUsage");
        Intrinsics.checkNotNullParameter(deferredResolver, "deferredResolver");
        Intrinsics.checkNotNullParameter(eventFeed, "eventFeed");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(audienceEvaluator, "audienceEvaluator");
        AssetCacheManager assetCacheManager = new AssetCacheManager(context, null, null, null, 14, null);
        InAppEventRecorder inAppEventRecorder = new InAppEventRecorder(analytics, meteredUsage, null, 4, null);
        ScheduleConditionsChangedNotifier scheduleConditionsChangedNotifier = new ScheduleConditionsChangedNotifier();
        AutomationRemoteDataAccess automationRemoteDataAccess = new AutomationRemoteDataAccess(context, remoteData, null, 4, null);
        GlobalActivityMonitor globalActivityMonitorShared = GlobalActivityMonitor.INSTANCE.shared(context);
        DisplayCoordinatorManager displayCoordinatorManager = new DisplayCoordinatorManager(dataStore, globalActivityMonitorShared, null, null, 12, null);
        FrequencyLimitManager frequencyLimitManager = new FrequencyLimitManager(context, runtimeConfig);
        SerialAccessAutomationStore serialAccessAutomationStore = new SerialAccessAutomationStore(AutomationStore.INSTANCE.createDatabase(context, runtimeConfig));
        InAppMessageAnalyticsFactory inAppMessageAnalyticsFactory = new InAppMessageAnalyticsFactory(inAppEventRecorder, new MessageDisplayHistoryStore(serialAccessAutomationStore), new DefaultInAppDisplayImpressionRuleProvider());
        ActionAutomationPreparer actionAutomationPreparer = new ActionAutomationPreparer();
        InAppMessageAutomationPreparer inAppMessageAutomationPreparer = new InAppMessageAutomationPreparer(assetCacheManager, displayCoordinatorManager, new DisplayAdapterFactory(context, NetworkMonitor.INSTANCE.shared(context), globalActivityMonitorShared), inAppMessageAnalyticsFactory, null, 16, null);
        ActionAutomationExecutor actionAutomationExecutor = new ActionAutomationExecutor(null, 1, null);
        InAppMessageAutomationExecutor inAppMessageAutomationExecutor = new InAppMessageAutomationExecutor(context, assetCacheManager, inAppMessageAnalyticsFactory, scheduleConditionsChangedNotifier, null, 16, null);
        AutomationExecutor automationExecutor = new AutomationExecutor(actionAutomationExecutor, inAppMessageAutomationExecutor, automationRemoteDataAccess);
        AutomationPreparer automationPreparer = new AutomationPreparer(actionAutomationPreparer, inAppMessageAutomationPreparer, deferredResolver, frequencyLimitManager, null, experimentManager, automationRemoteDataAccess, new AdditionalAudienceCheckerResolver(runtimeConfig, cache, null, 4, null), audienceEvaluator, new Supplier() { // from class: com.urbanairship.automation.AutomationModuleFactoryImpl$$ExternalSyntheticLambda0
            @Override // com.urbanairship.base.Supplier
            public final Object get() {
                return AutomationModuleFactoryImpl.build$lambda$0(runtimeConfig);
            }
        }, null, 1040, null);
        AutomationEventFeed automationEventFeed = new AutomationEventFeed(metrics, globalActivityMonitorShared, eventFeed, null, 8, null);
        AutomationTriggerProcessor automationTriggerProcessor = new AutomationTriggerProcessor(serialAccessAutomationStore, null, 2, null);
        AutomationDelayProcessor automationDelayProcessor = new AutomationDelayProcessor(analytics, globalActivityMonitorShared, new ExecutionWindowProcessor(context, null, null, null, null, 30, null), null, null, 24, null);
        AutomationDatabase automationDatabaseCreateDatabase = AutomationDatabase.createDatabase(context, runtimeConfig);
        Intrinsics.checkNotNullExpressionValue(automationDatabaseCreateDatabase, "createDatabase(...)");
        AutomationEngine automationEngine = new AutomationEngine(serialAccessAutomationStore, automationExecutor, automationPreparer, scheduleConditionsChangedNotifier, automationEventFeed, automationTriggerProcessor, automationDelayProcessor, null, null, null, new AutomationStoreMigrator(automationDatabaseCreateDatabase, serialAccessAutomationStore), 896, null);
        Module moduleSingleComponent = Module.singleComponent(new InAppAutomationComponent(context, dataStore, new InAppAutomation(automationEngine, new InAppMessaging(inAppMessageAutomationExecutor, inAppMessageAutomationPreparer), new LegacyInAppMessaging(context, pushManager, null, dataStore, automationEngine, new LegacyAnalytics(inAppEventRecorder), null, null, 196, null), new AutomationRemoteDataSubscriber(dataStore, automationRemoteDataAccess, automationEngine, frequencyLimitManager, null, null, 48, null), dataStore, privacyManager, runtimeConfig)), R.xml.ua_automation_actions);
        Intrinsics.checkNotNullExpressionValue(moduleSingleComponent, "singleComponent(...)");
        return moduleSingleComponent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RetryingQueueConfig build$lambda$0(AirshipRuntimeConfig runtimeConfig) {
        Intrinsics.checkNotNullParameter(runtimeConfig, "$runtimeConfig");
        IAAConfig iaaConfig = runtimeConfig.getRemoteConfig().getIaaConfig();
        if (iaaConfig != null) {
            return iaaConfig.getRetryingQueue();
        }
        return null;
    }

    @Override // com.urbanairship.AirshipVersionInfo
    @NotNull
    public String getAirshipVersion() {
        return "19.9.1";
    }

    @Override // com.urbanairship.AirshipVersionInfo
    @NotNull
    public String getPackageVersion() {
        return BuildConfig.SDK_VERSION;
    }
}
