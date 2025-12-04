package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.utils.ConstantsKt;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class Z3 implements U3 {
    public final /* synthetic */ PreferencesStore a;

    public Z3(PreferencesStore preferencesStore) {
        this.a = preferencesStore;
    }

    @Override // com.contentsquare.android.sdk.U3
    public final boolean a() {
        return System.currentTimeMillis() - this.a.getLong(PreferencesKey.TELEMETRY_LAST_REPORT_SENT_TIME_STAMP, 0L) > ConstantsKt.FORTNIGHTLY_IN_MILLIS;
    }

    @Override // com.contentsquare.android.sdk.U3
    @NotNull
    public final int getType() {
        return 3;
    }
}
