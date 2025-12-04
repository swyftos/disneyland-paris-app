package com.urbanairship.modules.automation;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.urbanairship.AirshipVersionInfo;
import com.urbanairship.ApplicationMetrics;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.analytics.AirshipEventFeed;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.audience.AudienceEvaluator;
import com.urbanairship.cache.AirshipCache;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.deferred.DeferredResolver;
import com.urbanairship.experiment.ExperimentManager;
import com.urbanairship.meteredusage.AirshipMeteredUsage;
import com.urbanairship.modules.Module;
import com.urbanairship.push.PushManager;
import com.urbanairship.remotedata.RemoteData;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface AutomationModuleFactory extends AirshipVersionInfo {
    @NonNull
    Module build(@NonNull Context context, @NonNull PreferenceDataStore preferenceDataStore, @NonNull AirshipRuntimeConfig airshipRuntimeConfig, @NonNull PrivacyManager privacyManager, @NonNull AirshipChannel airshipChannel, @NonNull PushManager pushManager, @NonNull Analytics analytics, @NonNull RemoteData remoteData, @NonNull ExperimentManager experimentManager, @NonNull AirshipMeteredUsage airshipMeteredUsage, @NonNull DeferredResolver deferredResolver, @NonNull AirshipEventFeed airshipEventFeed, @NonNull ApplicationMetrics applicationMetrics, @NonNull AirshipCache airshipCache, @NonNull AudienceEvaluator audienceEvaluator);
}
