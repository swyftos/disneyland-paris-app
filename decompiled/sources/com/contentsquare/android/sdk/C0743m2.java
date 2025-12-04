package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.m2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0743m2 extends Lambda implements Function0<L4> {
    public final /* synthetic */ PreferencesStore a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0743m2(PreferencesStore preferencesStore) {
        super(0);
        this.a = preferencesStore;
    }

    @Override // kotlin.jvm.functions.Function0
    public final L4 invoke() {
        int i = this.a.getInt(PreferencesKey.SCREEN_NUMBER, 0);
        int i2 = this.a.getInt(PreferencesKey.SESSION_ID, 0);
        PreferencesStore preferencesStore = this.a;
        PreferencesKey preferencesKey = PreferencesKey.PAUSED_SESSION_ID;
        int i3 = preferencesStore.getInt(preferencesKey, -1);
        PreferencesStore preferencesStore2 = this.a;
        PreferencesKey preferencesKey2 = PreferencesKey.PAUSED_SCREEN_NUMBER;
        int i4 = preferencesStore2.getInt(preferencesKey2, -1);
        boolean z = (i3 == -1 || i4 == -1) ? false : true;
        boolean z2 = i2 != i3;
        boolean z3 = i != i4;
        if (z && !z2 && !z3) {
            return L4.PROPAGATE_STOP;
        }
        this.a.remove(preferencesKey);
        this.a.remove(preferencesKey2);
        return L4.EVALUATE;
    }
}
