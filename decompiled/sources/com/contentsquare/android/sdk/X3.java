package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.system.DeviceInfo;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class X3 implements U3 {
    public final /* synthetic */ DeviceInfo a;
    public final /* synthetic */ PreferencesStore b;

    public X3(PreferencesStore preferencesStore, DeviceInfo deviceInfo) {
        this.a = deviceInfo;
        this.b = preferencesStore;
    }

    @Override // com.contentsquare.android.sdk.U3
    public final boolean a() {
        return this.a.getBuildInformation().getApplicationVersionCode() != this.b.getLong(PreferencesKey.TELEMETRY_CUSTOMER_APP_CODE_VERSION, -1L);
    }

    @Override // com.contentsquare.android.sdk.U3
    @NotNull
    public final int getType() {
        return 2;
    }
}
