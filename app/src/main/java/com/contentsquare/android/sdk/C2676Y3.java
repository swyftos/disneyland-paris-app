package com.contentsquare.android.sdk;

import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.Y3 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2676Y3 implements InterfaceC2639U3 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ PreferencesStore f2296a;

    public C2676Y3(PreferencesStore preferencesStore) {
        this.f2296a = preferencesStore;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2639U3
    /* JADX INFO: renamed from: a */
    public final boolean mo1043a() {
        return (!C2921x0.m1230a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.TELEMETRY) || this.f2296a.getBoolean(PreferencesKey.FORGET_ME, false) || this.f2296a.getBoolean(PreferencesKey.IS_OPT_OUT, false)) ? false : true;
    }

    @Override // com.contentsquare.android.sdk.InterfaceC2639U3
    @NotNull
    public final int getType() {
        return 5;
    }
}
