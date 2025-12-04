package com.urbanairship.modules.featureflag;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.urbanairship.AirshipVersionInfo;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.cache.AirshipCache;
import com.urbanairship.deferred.DeferredResolver;
import com.urbanairship.modules.Module;
import com.urbanairship.remotedata.RemoteData;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface FeatureFlagsModuleFactory extends AirshipVersionInfo {
    @NonNull
    Module build(@NonNull Context context, @NonNull PreferenceDataStore preferenceDataStore, @NonNull RemoteData remoteData, @NonNull Analytics analytics, @NonNull AirshipCache airshipCache, @NonNull DeferredResolver deferredResolver, @NonNull PrivacyManager privacyManager);
}
