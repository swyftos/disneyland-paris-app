package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.utils.ConstantsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.Z3 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2685Z3 implements InterfaceC2639U3 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ PreferencesStore f2327a;

    public C2685Z3(PreferencesStore preferencesStore) {
        this.f2327a = preferencesStore;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2639U3
    /* JADX INFO: renamed from: a */
    public final boolean mo1043a() {
        return System.currentTimeMillis() - this.f2327a.getLong(PreferencesKey.TELEMETRY_LAST_REPORT_SENT_TIME_STAMP, 0L) > ConstantsKt.FORTNIGHTLY_IN_MILLIS;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2639U3
    @NotNull
    public final int getType() {
        return 3;
    }
}
