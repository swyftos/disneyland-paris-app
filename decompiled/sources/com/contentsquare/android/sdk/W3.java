package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class W3 implements U3 {
    public final /* synthetic */ PreferencesStore a;

    public W3(PreferencesStore preferencesStore) {
        this.a = preferencesStore;
    }

    @Override // com.contentsquare.android.sdk.U3
    public final boolean a() {
        return !this.a.getBoolean(PreferencesKey.TELEMETRY_IS_REPORT_SENT, false);
    }

    @Override // com.contentsquare.android.sdk.U3
    @NotNull
    public final int getType() {
        return 1;
    }
}
