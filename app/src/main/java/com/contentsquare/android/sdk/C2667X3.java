package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.system.DeviceInfo;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.X3 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2667X3 implements InterfaceC2639U3 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ DeviceInfo f2252a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ PreferencesStore f2253b;

    public C2667X3(PreferencesStore preferencesStore, DeviceInfo deviceInfo) {
        this.f2252a = deviceInfo;
        this.f2253b = preferencesStore;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2639U3
    /* JADX INFO: renamed from: a */
    public final boolean mo1043a() {
        return this.f2252a.getBuildInformation().getApplicationVersionCode() != this.f2253b.getLong(PreferencesKey.TELEMETRY_CUSTOMER_APP_CODE_VERSION, -1L);
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2639U3
    @NotNull
    public final int getType() {
        return 2;
    }
}
