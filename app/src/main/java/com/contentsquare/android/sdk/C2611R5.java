package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.R5 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2611R5 extends Lambda implements Function1<Boolean, Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2651V5 f2069a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2611R5(C2651V5 c2651v5) {
        super(1);
        this.f2069a = c2651v5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean bool) {
        boolean zBooleanValue = bool.booleanValue();
        C2678Y5 c2678y5 = this.f2069a.f2193a;
        if (c2678y5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsViewModel");
            c2678y5 = null;
        }
        c2678y5.f2301a.putBoolean(PreferencesKey.LOCAL_SESSION_REPLAY_MODE, zBooleanValue);
        return Unit.INSTANCE;
    }
}
