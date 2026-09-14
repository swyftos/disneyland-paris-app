package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.W3 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2658W3 implements InterfaceC2639U3 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ PreferencesStore f2210a;

    public C2658W3(PreferencesStore preferencesStore) {
        this.f2210a = preferencesStore;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2639U3
    /* JADX INFO: renamed from: a */
    public final boolean mo1043a() {
        return !this.f2210a.getBoolean(PreferencesKey.TELEMETRY_IS_REPORT_SENT, false);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2639U3
    @NotNull
    public final int getType() {
        return 1;
    }
}
