package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.m1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2812m1 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final String f2872a;

    /* JADX WARN: Code duplicated, block: B:12:0x0038  */
    public C2812m1(@NotNull Configuration configuration, @NotNull PreferencesStore preferencesStore) {
        JsonConfig.SessionReplay sessionReplay;
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        StringBuilder sb = new StringBuilder();
        String string = preferencesStore.getString(PreferencesKey.DEVELOPER_SESSION_REPLAY_URL, PreferencesStore.DefaultValue.SR_URL_PRESET_FROM_CONFIG);
        if (Intrinsics.areEqual(string, PreferencesStore.DefaultValue.SR_URL_PRESET_FROM_CONFIG)) {
            JsonConfig.ProjectConfiguration projectConfig = configuration.getProjectConfig();
            string = (projectConfig == null || (sessionReplay = projectConfig.getSessionReplay()) == null) ? null : sessionReplay.getEndpoint();
            if (string == null) {
                string = "";
            }
        } else if (string == null) {
            string = "";
        }
        sb.append(string);
        sb.append("/v2/recording-mobile");
        this.f2872a = sb.toString();
    }
}
