package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.o2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2833o2 extends Lambda implements Function0<EnumC2551L4> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ PreferencesStore f2936a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2833o2(PreferencesStore preferencesStore) {
        super(0);
        this.f2936a = preferencesStore;
    }

    @Override // kotlin.jvm.functions.Function0
    public final EnumC2551L4 invoke() {
        return this.f2936a.getBoolean(PreferencesKey.LOCAL_SESSION_REPLAY_MODE, false) ? EnumC2551L4.PROPAGATE_START : EnumC2551L4.EVALUATE;
    }
}
