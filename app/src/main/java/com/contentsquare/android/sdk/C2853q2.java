package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.q2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2853q2 extends Lambda implements Function0<EnumC2551L4> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ PreferencesStore f3023a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2853q2(PreferencesStore preferencesStore) {
        super(0);
        this.f3023a = preferencesStore;
    }

    @Override // kotlin.jvm.functions.Function0
    public final EnumC2551L4 invoke() {
        return this.f3023a.getBoolean(PreferencesKey.FORGET_ME, false) ? EnumC2551L4.PROPAGATE_STOP : EnumC2551L4.EVALUATE;
    }
}
