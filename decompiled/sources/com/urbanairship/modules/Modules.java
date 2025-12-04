package com.urbanairship.modules;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.urbanairship.AirshipVersionInfo;
import com.urbanairship.ApplicationMetrics;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.analytics.AirshipEventFeed;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.audience.AudienceEvaluator;
import com.urbanairship.cache.AirshipCache;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.deferred.DeferredResolver;
import com.urbanairship.experiment.ExperimentManager;
import com.urbanairship.inputvalidation.AirshipInputValidation;
import com.urbanairship.meteredusage.AirshipMeteredUsage;
import com.urbanairship.modules.aaid.AdIdModuleFactory;
import com.urbanairship.modules.automation.AutomationModuleFactory;
import com.urbanairship.modules.debug.DebugModuleFactory;
import com.urbanairship.modules.featureflag.FeatureFlagsModuleFactory;
import com.urbanairship.modules.liveupdate.LiveUpdateModuleFactory;
import com.urbanairship.modules.location.LocationModule;
import com.urbanairship.modules.location.LocationModuleFactory;
import com.urbanairship.modules.messagecenter.MessageCenterModuleFactory;
import com.urbanairship.modules.preferencecenter.PreferenceCenterModuleFactory;
import com.urbanairship.permission.PermissionsManager;
import com.urbanairship.push.PushManager;
import com.urbanairship.remotedata.RemoteData;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class Modules {
    @Nullable
    public static Module messageCenter(@NonNull Context context, @NonNull PreferenceDataStore preferenceDataStore, @NonNull AirshipRuntimeConfig airshipRuntimeConfig, @NonNull PrivacyManager privacyManager, @NonNull AirshipChannel airshipChannel, @NonNull PushManager pushManager) {
        try {
            MessageCenterModuleFactory messageCenterModuleFactory = (MessageCenterModuleFactory) createFactory("com.urbanairship.messagecenter.MessageCenterModuleFactoryImpl", MessageCenterModuleFactory.class);
            if (messageCenterModuleFactory != null) {
                return messageCenterModuleFactory.build(context, preferenceDataStore, airshipRuntimeConfig, privacyManager, airshipChannel, pushManager);
            }
            return null;
        } catch (Exception e) {
            UALog.e(e, "Failed to build Message Center module", new Object[0]);
            return null;
        }
    }

    @Nullable
    public static LocationModule location(@NonNull Context context, @NonNull PreferenceDataStore preferenceDataStore, @NonNull PrivacyManager privacyManager, @NonNull AirshipChannel airshipChannel, @NonNull PermissionsManager permissionsManager) {
        try {
            LocationModuleFactory locationModuleFactory = (LocationModuleFactory) createFactory("com.urbanairship.location.LocationModuleFactoryImpl", LocationModuleFactory.class);
            if (locationModuleFactory != null) {
                return locationModuleFactory.build(context, preferenceDataStore, privacyManager, airshipChannel, permissionsManager);
            }
            return null;
        } catch (Exception e) {
            UALog.e(e, "Failed to build Location module", new Object[0]);
            return null;
        }
    }

    @Nullable
    public static Module automation(@NonNull Context context, @NonNull PreferenceDataStore preferenceDataStore, @NonNull AirshipRuntimeConfig airshipRuntimeConfig, @NonNull PrivacyManager privacyManager, @NonNull AirshipChannel airshipChannel, @NonNull PushManager pushManager, @NonNull Analytics analytics, @NonNull RemoteData remoteData, @NonNull ExperimentManager experimentManager, @NonNull AirshipMeteredUsage airshipMeteredUsage, @NonNull DeferredResolver deferredResolver, @NonNull AirshipEventFeed airshipEventFeed, @NonNull ApplicationMetrics applicationMetrics, @NonNull AirshipCache airshipCache, @NonNull AudienceEvaluator audienceEvaluator) {
        try {
            AutomationModuleFactory automationModuleFactory = (AutomationModuleFactory) createFactory("com.urbanairship.automation.AutomationModuleFactoryImpl", AutomationModuleFactory.class);
            if (automationModuleFactory != null) {
                return automationModuleFactory.build(context, preferenceDataStore, airshipRuntimeConfig, privacyManager, airshipChannel, pushManager, analytics, remoteData, experimentManager, airshipMeteredUsage, deferredResolver, airshipEventFeed, applicationMetrics, airshipCache, audienceEvaluator);
            }
            return null;
        } catch (Exception e) {
            UALog.e(e, "Failed to build Automation module", new Object[0]);
            return null;
        }
    }

    @Nullable
    public static Module debug(@NonNull Context context, @NonNull PreferenceDataStore preferenceDataStore, @NonNull RemoteData remoteData) {
        try {
            DebugModuleFactory debugModuleFactory = (DebugModuleFactory) createFactory("com.urbanairship.debug.DebugModuleFactoryImpl", DebugModuleFactory.class);
            if (debugModuleFactory != null) {
                return debugModuleFactory.build(context, preferenceDataStore, remoteData);
            }
            return null;
        } catch (Exception e) {
            UALog.e(e, "Failed to build Debug module", new Object[0]);
            return null;
        }
    }

    @Nullable
    public static Module adId(@NonNull Context context, @NonNull PreferenceDataStore preferenceDataStore, @NonNull AirshipRuntimeConfig airshipRuntimeConfig, @NonNull PrivacyManager privacyManager, @NonNull Analytics analytics) {
        try {
            AdIdModuleFactory adIdModuleFactory = (AdIdModuleFactory) createFactory("com.urbanairship.aaid.AdIdModuleFactoryImpl", AdIdModuleFactory.class);
            if (adIdModuleFactory != null) {
                return adIdModuleFactory.build(context, preferenceDataStore, airshipRuntimeConfig, privacyManager, analytics);
            }
            return null;
        } catch (Exception e) {
            UALog.e(e, "Failed to build Ad Id module", new Object[0]);
            return null;
        }
    }

    @Nullable
    public static Module preferenceCenter(@NonNull Context context, @NonNull PreferenceDataStore preferenceDataStore, @NonNull PrivacyManager privacyManager, @NonNull RemoteData remoteData, @NonNull AirshipInputValidation.Validator validator) {
        try {
            PreferenceCenterModuleFactory preferenceCenterModuleFactory = (PreferenceCenterModuleFactory) createFactory("com.urbanairship.preferencecenter.PreferenceCenterModuleFactoryImpl", PreferenceCenterModuleFactory.class);
            if (preferenceCenterModuleFactory != null) {
                return preferenceCenterModuleFactory.build(context, preferenceDataStore, privacyManager, remoteData, validator);
            }
            return null;
        } catch (Exception e) {
            UALog.e(e, "Failed to build Preference Center module", new Object[0]);
            return null;
        }
    }

    @Nullable
    public static Module liveUpdateManager(@NonNull Context context, @NonNull PreferenceDataStore preferenceDataStore, @NonNull AirshipRuntimeConfig airshipRuntimeConfig, @NonNull PrivacyManager privacyManager, @NonNull AirshipChannel airshipChannel, @NonNull PushManager pushManager) {
        try {
            LiveUpdateModuleFactory liveUpdateModuleFactory = (LiveUpdateModuleFactory) createFactory("com.urbanairship.liveupdate.LiveUpdateModuleFactoryImpl", LiveUpdateModuleFactory.class);
            if (liveUpdateModuleFactory != null) {
                return liveUpdateModuleFactory.build(context, preferenceDataStore, airshipRuntimeConfig, privacyManager, airshipChannel, pushManager);
            }
            return null;
        } catch (Exception e) {
            UALog.e(e, "Failed to build Live Update module", new Object[0]);
            return null;
        }
    }

    @Nullable
    public static Module featureFlags(@NonNull Context context, @NonNull PreferenceDataStore preferenceDataStore, @NonNull RemoteData remoteData, @NonNull Analytics analytics, @NonNull AirshipCache airshipCache, @NonNull DeferredResolver deferredResolver, @NonNull PrivacyManager privacyManager) {
        try {
            FeatureFlagsModuleFactory featureFlagsModuleFactory = (FeatureFlagsModuleFactory) createFactory("com.urbanairship.featureflag.FeatureFlagsModuleFactoryImpl", FeatureFlagsModuleFactory.class);
            if (featureFlagsModuleFactory != null) {
                return featureFlagsModuleFactory.build(context, preferenceDataStore, remoteData, analytics, airshipCache, deferredResolver, privacyManager);
            }
            return null;
        } catch (Exception e) {
            UALog.e(e, "Failed to build Feature Flags module", new Object[0]);
            return null;
        }
    }

    private static AirshipVersionInfo createFactory(String str, Class cls) {
        try {
            AirshipVersionInfo airshipVersionInfo = (AirshipVersionInfo) Class.forName(str).asSubclass(cls).newInstance();
            if (UAirship.getVersion().equals(airshipVersionInfo.getAirshipVersion())) {
                return airshipVersionInfo;
            }
            UALog.e("Unable to load module with factory %s, versions do not match. Core Version: %s, Module Version: %s.", cls, UAirship.getVersion(), airshipVersionInfo.getAirshipVersion());
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Exception e) {
            UALog.e(e, "Unable to create module factory %s", cls);
            return null;
        }
    }
}
