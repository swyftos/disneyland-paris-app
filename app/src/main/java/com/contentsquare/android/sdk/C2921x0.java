package com.contentsquare.android.sdk;

import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.x0 */
/* JADX INFO: loaded from: classes2.dex */
@JvmName(name = "ConfigurationExtensions")
public final class C2921x0 {
    /* JADX INFO: renamed from: a */
    public static final boolean m1230a(@Nullable CoreModule coreModule, @NotNull String featureFlagName) {
        Intrinsics.checkNotNullParameter(featureFlagName, "featureFlagName");
        if (coreModule == null) {
            return false;
        }
        if (!coreModule.getPreferencesStore().getBoolean(PreferencesKey.DEVELOPER_OVERRIDE_FEATURE_FLAGS_ENABLED, false)) {
            return coreModule.getConfiguration().isFeatureFlagEnabled(featureFlagName);
        }
        Set<String> stringSet = coreModule.getPreferencesStore().getStringSet(PreferencesKey.DEVELOPER_OVERRIDE_FEATURE_FLAGS_STATES, SetsKt.emptySet());
        if (stringSet == null) {
            stringSet = SetsKt.emptySet();
        }
        return stringSet.contains(featureFlagName);
    }
}
