package com.contentsquare.android.sdk;

import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class Y3 implements U3 {
    public final /* synthetic */ PreferencesStore a;

    public Y3(PreferencesStore preferencesStore) {
        this.a = preferencesStore;
    }

    @Override // com.contentsquare.android.sdk.U3
    public final boolean a() {
        return (!C0848x0.a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.TELEMETRY) || this.a.getBoolean(PreferencesKey.FORGET_ME, false) || this.a.getBoolean(PreferencesKey.IS_OPT_OUT, false)) ? false : true;
    }

    @Override // com.contentsquare.android.sdk.U3
    @NotNull
    public final int getType() {
        return 5;
    }
}
