package com.contentsquare.android.sdk;

import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JvmName(name = "ConfigurationExtensions")
/* renamed from: com.contentsquare.android.sdk.x0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0848x0 {
    public static final boolean a(@Nullable CoreModule coreModule, @NotNull String featureFlagName) {
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
