package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.s2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0802s2 extends Lambda implements Function0<L4> {
    public final /* synthetic */ PreferencesStore a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0802s2(PreferencesStore preferencesStore) {
        super(0);
        this.a = preferencesStore;
    }

    @Override // kotlin.jvm.functions.Function0
    public final L4 invoke() {
        if (!this.a.getBoolean(PreferencesKey.PAUSE_TRACKING, false)) {
            return L4.EVALUATE;
        }
        int i = this.a.getInt(PreferencesKey.SESSION_ID, 0);
        int i2 = this.a.getInt(PreferencesKey.SCREEN_NUMBER, 0);
        this.a.putInt(PreferencesKey.PAUSED_SESSION_ID, i);
        this.a.putInt(PreferencesKey.PAUSED_SCREEN_NUMBER, i2);
        return L4.PROPAGATE_STOP;
    }
}
