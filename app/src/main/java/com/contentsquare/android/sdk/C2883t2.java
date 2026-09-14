package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.t2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2883t2 extends Lambda implements Function0<EnumC2551L4> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ PreferencesStore f3109a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2883t2(PreferencesStore preferencesStore) {
        super(0);
        this.f3109a = preferencesStore;
    }

    @Override // kotlin.jvm.functions.Function0
    public final EnumC2551L4 invoke() {
        return !this.f3109a.getBoolean(PreferencesKey.TRACKING_ENABLE, false) ? EnumC2551L4.PROPAGATE_STOP : EnumC2551L4.EVALUATE;
    }
}
