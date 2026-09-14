package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.s2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2873s2 extends Lambda implements Function0<EnumC2551L4> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ PreferencesStore f3094a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2873s2(PreferencesStore preferencesStore) {
        super(0);
        this.f3094a = preferencesStore;
    }

    @Override // kotlin.jvm.functions.Function0
    public final EnumC2551L4 invoke() {
        if (!this.f3094a.getBoolean(PreferencesKey.PAUSE_TRACKING, false)) {
            return EnumC2551L4.EVALUATE;
        }
        int i = this.f3094a.getInt(PreferencesKey.SESSION_ID, 0);
        int i2 = this.f3094a.getInt(PreferencesKey.SCREEN_NUMBER, 0);
        this.f3094a.putInt(PreferencesKey.PAUSED_SESSION_ID, i);
        this.f3094a.putInt(PreferencesKey.PAUSED_SCREEN_NUMBER, i2);
        return EnumC2551L4.PROPAGATE_STOP;
    }
}
