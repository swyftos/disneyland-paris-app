package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.T5 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2631T5 extends Lambda implements Function1<Integer, Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2651V5 f2152a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2631T5(C2651V5 c2651v5) {
        super(1);
        this.f2152a = c2651v5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Integer num) {
        int iIntValue = num.intValue();
        C2678Y5 c2678y5 = this.f2152a.f2193a;
        if (c2678y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            c2678y5 = null;
        }
        c2678y5.f2301a.putInt(PreferencesKey.CLIENT_MODE_LONG_SNAPSHOT_SCROLL_DELAY_MILLISECONDS, iIntValue);
        return Unit.INSTANCE;
    }
}
